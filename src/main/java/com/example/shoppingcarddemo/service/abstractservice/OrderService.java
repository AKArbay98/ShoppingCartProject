package com.example.shoppingcarddemo.service.abstractservice;

import com.example.shoppingcarddemo.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    void deleteOrderById(Long id);
    List<OrderDTO> fetchAllOrder();
    OrderDTO getOrderById(Long id);
    void createOrder(OrderDTO orderDTO);
    void updateOrder(Long id, OrderDTO orderDTO);
    List<OrderDTO> getOrderListFromCart(Long cartId);
    List<OrderDTO> getAllOrdersByCustomerId(Long customerId);
    OrderDTO getOrderFromCart(Long orderId, Long cartId);

}
