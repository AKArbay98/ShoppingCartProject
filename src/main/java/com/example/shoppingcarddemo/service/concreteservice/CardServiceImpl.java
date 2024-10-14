package com.example.shoppingcarddemo.service.concreteservice;

import com.example.shoppingcarddemo.model.dto.CartDTO;
import com.example.shoppingcarddemo.model.entity.cart.Cart;
import com.example.shoppingcarddemo.model.entity.customer.Customer;
import com.example.shoppingcarddemo.model.entity.product.Product;
import com.example.shoppingcarddemo.model.mapper.cartmapper.CartMapperImpl;
import com.example.shoppingcarddemo.model.mapper.customermapper.CustomerMapperImpl;
import com.example.shoppingcarddemo.model.mapper.productmapper.ProductMapperImpl;
import com.example.shoppingcarddemo.repository.cartrepo.CardRepository;
import com.example.shoppingcarddemo.repository.productrepo.ProductRepository;
import com.example.shoppingcarddemo.service.abstractservice.CardService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CartMapperImpl cartMapperImpl;
    private final ProductMapperImpl productMapperImpl;
    private final CustomerMapperImpl customerMapperImpl;
    private final ProductRepository productRepository;


    public CardServiceImpl(CardRepository cardRepository, CartMapperImpl cartMapperImpl, ProductMapperImpl productMapperImpl, CustomerMapperImpl customerMapperImpl, ProductRepository productRepository) {
        this.cardRepository = cardRepository;
        this.cartMapperImpl = cartMapperImpl;
        this.productMapperImpl = productMapperImpl;
        this.customerMapperImpl = customerMapperImpl;
        this.productRepository = productRepository;
    }

    @Override
    public List<CartDTO> fetchAllCard() {
        List<Cart> carts = cardRepository.findAll();
        return carts.stream()
                .map(cartMapperImpl::convertCartToCartDto)
                .collect(Collectors.toList());
    }

    @Override
    public CartDTO getCartById(Long cartId) {
        return cardRepository.findById(cartId)
                .map(cartMapperImpl::convertCartToCartDto)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + cartId));
    }

    @Override
    public void createCard(CartDTO cartDTO) {
        Cart cart = cartMapperImpl.convertCartDtoToCart(cartDTO);
        cardRepository.save(cart);
    }

    @Override
    public void updateCard(Long id, CartDTO cartDTO) {
        Cart existingCart = cardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + id));

        if(cartDTO.getCustomer() != null){
            Customer customer = customerMapperImpl.convertCustomerDtoToCustomer(cartDTO.getCustomer());
            existingCart.setCustomer(customer);
        }

        if (cartDTO.getProducts() != null) {
            List<Product> products = cartDTO.getProducts().stream()
                    .map(productMapperImpl::convertProductDtoToProduct)
                    .collect(Collectors.toList());
            existingCart.setProducts(products);
        }

        existingCart.setQuantity(cartDTO.getQuantity());
        cardRepository.save(existingCart);
    }

    @Override
    public void emptyCartById(Long cartId) {
        Cart cart = cardRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + cartId));
        cart.getProducts().clear();
        cardRepository.save(cart);
    }

    @Override
    public void addProductToCart(Long cartId, Long productId, Integer quantity) {
        Cart cart = cardRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + cartId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));

        product.setQuantity(quantity);

        product.setCart(cart);

        cart.getProducts().add(product);

        updateCartTotalCost(cart);

        cardRepository.save(cart);
    }

    private void updateCartTotalCost(Cart cart) {
        BigDecimal totalCost = cart.getProducts().stream()
                .map(product -> product.getPrice().multiply(new BigDecimal(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        cart.setTotalCost(totalCost);
    }

    public CartDTO updateProductQuantity(Long cartId, Long productId, int quantity) {
        Cart cart = cardRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + cartId));

        Product product = cart.getProducts().stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Product not found in the cart with id: " + productId));

        product.setQuantity(quantity);

        updateCartTotalCost(cart);

        cardRepository.save(cart);

        return cartMapperImpl.convertCartToCartDto(cart);
    }

    @Override
    public void deleteProductFromCart(Long cartId, Long productId) {
        Cart cart = cardRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + cartId));

        Product product = cart.getProducts().stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Product not found in the cart with id: " + productId));

        cart.getProducts().remove(product);
        product.setCart(null);

        updateCartTotalCost(cart);

        cardRepository.save(cart);
    }

    @Override
    public void deleteCardById(Long cardId) {
        if (!cardRepository.existsById(cardId)){
            throw new IllegalArgumentException("Product with ID " + cardId + " does not exist.");
        }
        cardRepository.deleteById(cardId);
    }

}
