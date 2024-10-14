package com.example.shoppingcarddemo.model.mapper.orderaddressmapper;

import com.example.shoppingcarddemo.model.dto.OrderAddressDTO;
import com.example.shoppingcarddemo.model.entity.orderaddress.OrderAddress;

public class OrderAddressMapperImpl {

    private final OrderAddressMapper orderAddressMapper;

    public OrderAddressMapperImpl(OrderAddressMapper orderAddressMapper) {
        this.orderAddressMapper = orderAddressMapper;
    }

    public OrderAddressDTO convertOrderAddressToOrderAddressDto(OrderAddress orderAddress){
        return orderAddressMapper.orderAddressToOrderAddressDTO(orderAddress);
    }

    public OrderAddress convertOrderAddressDtoToOrderAddress(OrderAddressDTO orderAddressDTO){
        return orderAddressMapper.orderAddressDTOToOrderAddress(orderAddressDTO);
    }
}
