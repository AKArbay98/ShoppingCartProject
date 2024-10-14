package com.example.shoppingcarddemo.model.mapper.cartmapper;

import com.example.shoppingcarddemo.model.dto.CartDTO;
import com.example.shoppingcarddemo.model.entity.cart.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "products", target = "products")
    @Mapping(source = "quantity", target = "quantity")
    CartDTO cartToCartDTO(Cart cart);

    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "products", target = "products")
    @Mapping(source = "quantity", target = "quantity")
    Cart cartDtoToCart(CartDTO cartDto);
}
