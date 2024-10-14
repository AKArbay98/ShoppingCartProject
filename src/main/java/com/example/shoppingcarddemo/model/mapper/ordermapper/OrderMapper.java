package com.example.shoppingcarddemo.model.mapper.ordermapper;

import com.example.shoppingcarddemo.model.dto.OrderDTO;
import com.example.shoppingcarddemo.model.entity.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "status", target = "status")
    @Mapping(source = "orderDate", target = "orderDate")
    @Mapping(source = "totalCost", target = "totalCost")
    @Mapping(source = "products", target = "productList")
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "orderAddresses", target = "orderAddresses")
    OrderDTO orderToOrderDTO(Order order);

    @Mapping(source = "status", target = "status")
    @Mapping(source = "orderDate", target = "orderDate")
    @Mapping(source = "totalCost", target = "totalCost")
    @Mapping(source = "productList", target = "products")
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "orderAddresses", target = "orderAddresses")
    Order orderDtoToOrder(OrderDTO orderDto);
}

