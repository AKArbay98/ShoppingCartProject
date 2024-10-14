package com.example.shoppingcarddemo.controller.order;

import com.example.shoppingcarddemo.model.dto.OrderDTO;
import com.example.shoppingcarddemo.service.abstractservice.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getAllOrder(){
        List<OrderDTO> orders = orderService.fetchAllOrder();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id){
        OrderDTO orderById = orderService.getOrderById(id);
        return ResponseEntity.ok(orderById);
    }

    @GetMapping("/order/{orderId}/cart/{cartId}")
    public ResponseEntity<OrderDTO> getOrderFromCart(@PathVariable Long orderId, @PathVariable Long cartId){
        OrderDTO orderFromCart = orderService.getOrderFromCart(orderId, cartId);
        return ResponseEntity.ok(orderFromCart);
    }

    @GetMapping("/order/cart/{cartId}")
    public ResponseEntity<List<OrderDTO>> getOrderListFromCart(@PathVariable Long cartId){
        List<OrderDTO> orderListFromCart = orderService.getOrderListFromCart(cartId);
        return ResponseEntity.ok(orderListFromCart);
    }

    @GetMapping("/order/customer/{customerId}")
    public ResponseEntity<List<OrderDTO>> getAllOrdersFromCustomer(@PathVariable Long customerId){
        List<OrderDTO> allOrdersByCustomerId = orderService.getAllOrdersByCustomerId(customerId);
        return ResponseEntity.ok(allOrdersByCustomerId);
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderDTO orderDTO){
        orderService.createOrder(orderDTO);
    }

    @PutMapping("/order/{id}")
    public void updateOrder(@PathVariable("id") Long id, @RequestBody OrderDTO orderDTO){
        orderService.updateOrder(id, orderDTO);
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrderById(id);
    }

}
