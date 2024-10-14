package com.example.shoppingcarddemo.model.mapper.cartmapper;

import com.example.shoppingcarddemo.model.dto.CartDTO;
import com.example.shoppingcarddemo.model.entity.cart.Cart;

public class CartMapperImpl {

    private final CartMapper cartMapper;

    public CartMapperImpl(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    public CartDTO convertCartToCartDto(Cart cart){
        return cartMapper.cartToCartDTO(cart);
    }

    public Cart convertCartDtoToCart(CartDTO cartDTO){
        return cartMapper.cartDtoToCart(cartDTO);
    }
}
