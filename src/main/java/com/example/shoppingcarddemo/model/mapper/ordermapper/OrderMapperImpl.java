package com.example.shoppingcarddemo.model.mapper.ordermapper;

import com.example.shoppingcarddemo.model.dto.OrderDTO;
import com.example.shoppingcarddemo.model.entity.order.Order;

public class OrderMapperImpl {

    private final OrderMapper orderMapper;

    public OrderMapperImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public OrderDTO convertOrderToOrderDto(Order order){
        return orderMapper.orderToOrderDTO(order);
    }

    public Order convertOrderDtoToOrder(OrderDTO orderDTO){
        return orderMapper.orderDtoToOrder(orderDTO);
    }
}
