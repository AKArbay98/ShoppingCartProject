package com.example.shoppingcarddemo.service.abstractservice;

import com.example.shoppingcarddemo.model.dto.CartDTO;

import java.util.List;

public interface CardService {

    void deleteCardById(Long id);

    List<CartDTO> fetchAllCard();

    CartDTO getCartById(Long id);

    void createCard(CartDTO cartDTO);

    void updateCard(Long id, CartDTO cartDTO);

    void emptyCartById(Long cartId);

    void addProductToCart(Long cartId, Long productId, Integer quantity);

    void deleteProductFromCart(Long cartId, Long productId);

}
