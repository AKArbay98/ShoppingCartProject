package com.example.shoppingcarddemo.service.concreteservice;

import com.example.shoppingcarddemo.exceptions.ProductOutOfStockException;
import com.example.shoppingcarddemo.model.dto.OrderDTO;
import com.example.shoppingcarddemo.model.dto.ProductDTO;
import com.example.shoppingcarddemo.model.entity.cart.Cart;
import com.example.shoppingcarddemo.model.entity.customer.Customer;
import com.example.shoppingcarddemo.model.entity.order.Order;
import com.example.shoppingcarddemo.model.entity.orderaddress.OrderAddress;
import com.example.shoppingcarddemo.model.entity.product.Product;
import com.example.shoppingcarddemo.model.mapper.customermapper.CustomerMapperImpl;
import com.example.shoppingcarddemo.model.mapper.orderaddressmapper.OrderAddressMapperImpl;
import com.example.shoppingcarddemo.model.mapper.ordermapper.OrderMapperImpl;
import com.example.shoppingcarddemo.model.mapper.productmapper.ProductMapperImpl;
import com.example.shoppingcarddemo.repository.cartrepo.CardRepository;
import com.example.shoppingcarddemo.repository.customerrepo.CustomerRepository;
import com.example.shoppingcarddemo.repository.orderrepo.OrderRepository;
import com.example.shoppingcarddemo.repository.productrepo.ProductRepository;
import com.example.shoppingcarddemo.service.abstractservice.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapperImpl orderMapperImpl;
    private final ProductMapperImpl productMapperImpl;
    private final CustomerMapperImpl customerMapperImpl;
    private final OrderAddressMapperImpl orderAddressMapperImpl;
    private final CardRepository cardRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final ProductOutOfStockException productOutOfStockException;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapperImpl orderMapperImpl, ProductMapperImpl productMapperImpl, CustomerMapperImpl customerMapperImpl, OrderAddressMapperImpl orderAddressMapperImpl, CardRepository cardRepository, CustomerRepository customerRepository, ProductRepository productRepository, ProductOutOfStockException productOutOfStockException) {
        this.orderRepository = orderRepository;
        this.orderMapperImpl = orderMapperImpl;
        this.productMapperImpl = productMapperImpl;
        this.customerMapperImpl = customerMapperImpl;
        this.orderAddressMapperImpl = orderAddressMapperImpl;
        this.cardRepository = cardRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.productOutOfStockException = productOutOfStockException;
    }

    @Override
    public List<OrderDTO> fetchAllOrder() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapperImpl::convertOrderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapperImpl::convertOrderToOrderDto)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + orderId));
    }

    @Override
    public void createOrder(OrderDTO orderDTO) {
        List<ProductDTO> productList = orderDTO.getProductList();

        for (ProductDTO productDTO : productList) {
            Product product = productRepository.findById(productDTO.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productDTO.getId()));

            if (!product.isInStock()) {
                throw new ProductOutOfStockException("Product " + product.getName() + " is out of stock.");
            }
        }

        Order order = orderMapperImpl.convertOrderDtoToOrder(orderDTO);
        orderRepository.save(order);

        for (ProductDTO productDTO : productList) {
            Product product = productRepository.findById(productDTO.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productDTO.getId()));
            product.setQuantity(product.getQuantity() - 1);
            productRepository.save(product);
        }
    }

    @Override
    public void updateOrder(Long id, OrderDTO orderDTO) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("order not found with id: " + id));

        existingOrder.setStatus(orderDTO.getStatus());
        existingOrder.setOrderDate(orderDTO.getOrderDate());
        existingOrder.setTotalCost(orderDTO.getTotalCost());

        if(orderDTO.getProductList() != null){
            List<Product> products = orderDTO.getProductList().stream()
                    .map(productMapperImpl::convertProductDtoToProduct)
                    .collect(Collectors.toList());
            existingOrder.setProducts(products);
        }

        if(orderDTO.getCustomer() != null){
            Customer customer = customerMapperImpl.convertCustomerDtoToCustomer(orderDTO.getCustomer());
            existingOrder.setCustomer(customer);
        }

        if(orderDTO.getOrderAddresses() != null){
            List<OrderAddress> orderAddress = orderDTO.getOrderAddresses().stream()
                    .map(orderAddressMapperImpl::convertOrderAddressDtoToOrderAddress)
                    .collect(Collectors.toList());
            existingOrder.setOrderAddresses(orderAddress);
        }

        orderRepository.save(existingOrder);
    }

    @Override
    public List<OrderDTO> getOrderListFromCart(Long cartId) {
        Cart cart = cardRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + cartId));

        List<OrderDTO> orderDTO = cart.getProducts().stream()
                .map(Product::getOrder)
                .distinct()
                .map(orderMapperImpl::convertOrderToOrderDto)
                .collect(Collectors.toList());

        if (orderDTO.isEmpty()) {
            throw new IllegalArgumentException("No orders associated with the products in the cart.");
        }

        return orderDTO;
    }

    @Override
    public OrderDTO getOrderFromCart(Long orderId, Long cartId) {
        Cart cart = cardRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + cartId));

        Order order = cart.getProducts().stream()
                .map(Product::getOrder)
                .filter(o -> o.getId().equals(orderId))
                .findAny()
                .orElseThrow(
                        () ->
                                new EntityNotFoundException
                                        ("Order with id: " + orderId + " not found for the specified cart"));

        return orderMapperImpl.convertOrderToOrderDto(order);
    }

    @Override
    public List<OrderDTO> getAllOrdersByCustomerId(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with id: " + customerId));

        List<Order> orders = customer.getOrders();

        if (orders == null) {
            throw new EntityNotFoundException("Order not found for customer with id: " + customerId);
        }

        return orders.stream()
                .map(orderMapperImpl::convertOrderToOrderDto)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteOrderById(Long orderId) {
        if(!orderRepository.existsById(orderId)){
            throw new IllegalArgumentException("Order with ID " + orderId + " does not exist.");
        }
        orderRepository.deleteById(orderId);
    }

}
