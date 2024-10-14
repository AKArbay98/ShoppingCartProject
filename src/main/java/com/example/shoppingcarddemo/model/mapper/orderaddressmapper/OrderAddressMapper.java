package com.example.shoppingcarddemo.model.mapper.orderaddressmapper;

import com.example.shoppingcarddemo.model.dto.OrderAddressDTO;
import com.example.shoppingcarddemo.model.entity.orderaddress.OrderAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderAddressMapper {

    OrderAddressMapper INSTANCE = Mappers.getMapper(OrderAddressMapper.class);

    @Mapping(source = "city", target = "city")
    @Mapping(source = "district", target = "district")
    @Mapping(source = "neighbourhood", target = "neighbourhood")
    @Mapping(source = "addressDescription", target = "addressDescription")
    @Mapping(source = "order", target = "order")
    OrderAddressDTO orderAddressToOrderAddressDTO(OrderAddress orderAddress);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "commentList", target = "commentList")
    OrderAddress orderAddressDTOToOrderAddress(OrderAddressDTO orderAddressDTO);
}
