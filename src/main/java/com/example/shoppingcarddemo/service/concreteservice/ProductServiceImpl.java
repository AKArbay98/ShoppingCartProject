package com.example.shoppingcarddemo.service.concreteservice;

import com.example.shoppingcarddemo.model.dto.ProductDTO;
import com.example.shoppingcarddemo.model.entity.cart.Cart;
import com.example.shoppingcarddemo.model.entity.comment.Comment;
import com.example.shoppingcarddemo.model.entity.order.Order;
import com.example.shoppingcarddemo.model.entity.product.Product;
import com.example.shoppingcarddemo.model.mapper.cartmapper.CartMapperImpl;
import com.example.shoppingcarddemo.model.mapper.commentmapper.CommentMapperImpl;
import com.example.shoppingcarddemo.model.mapper.ordermapper.OrderMapperImpl;
import com.example.shoppingcarddemo.model.mapper.productmapper.ProductMapperImpl;
import com.example.shoppingcarddemo.repository.productrepo.ProductRepository;
import com.example.shoppingcarddemo.service.abstractservice.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapperImpl productMapperImpl;
    private final CommentMapperImpl commentMapperImpl;
    private final CartMapperImpl cartMapperImpl;
    private final OrderMapperImpl orderMapperImpl;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapperImpl productMapperImpl, CommentMapperImpl commentMapperImpl, CartMapperImpl cartMapperImpl, OrderMapperImpl orderMapperImpl) {
        this.productRepository = productRepository;
        this.productMapperImpl = productMapperImpl;
        this.commentMapperImpl = commentMapperImpl;
        this.cartMapperImpl = cartMapperImpl;
        this.orderMapperImpl = orderMapperImpl;
    }

    @Override
    public List<ProductDTO> fetchAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapperImpl::convertProductToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        return productRepository.findById(productId)
                .map(productMapperImpl::convertProductToProductDto)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        Product product = productMapperImpl.convertProductDtoToProduct(productDTO);
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setQuantity(productDTO.getQuantity());

        if(productDTO.getCommentList() != null){
            Comment comment = commentMapperImpl.convertCommentDtoToComment(productDTO.getCommentList());
            existingProduct.setCommentList((List<Comment>) comment);
        }

        if(productDTO.getCart() != null){
            Cart cart = cartMapperImpl.convertCartDtoToCart(productDTO.getCart());
            existingProduct.setCart(cart);
        }

        if(productDTO.getOrder() != null){
            Order order = orderMapperImpl.convertOrderDtoToOrder(productDTO.getOrder());
            existingProduct.setOrder(order);
        }

        existingProduct.setRating(productDTO.getRating());
    }


    @Override
    public void deleteProductById(Long productId) {
        if(!productRepository.existsById(productId)){
            throw new IllegalArgumentException("Product with ID " + productId + " does not exist.");
        }
        productRepository.deleteById(productId);
    }

}
