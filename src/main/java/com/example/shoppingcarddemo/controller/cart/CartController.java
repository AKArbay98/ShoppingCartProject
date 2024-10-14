package com.example.shoppingcarddemo.controller.cart;

import com.example.shoppingcarddemo.model.dto.CartDTO;
import com.example.shoppingcarddemo.service.abstractservice.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CartController {

    private final CardService cardService;

    public CartController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/carts")
    public ResponseEntity<List<CartDTO>> getAllCard(){
        List<CartDTO> carts = cardService.fetchAllCard();
        return ResponseEntity.ok(carts);
    }

    @GetMapping("/carts/{id}")
    public ResponseEntity<CartDTO> getCart(@PathVariable Long id){
        CartDTO cartById = cardService.getCartById(id);
        return ResponseEntity.ok(cartById);
    }

    @PostMapping("/card")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCard(@RequestBody CartDTO cartDTO){
        cardService.createCard(cartDTO);
    }

    @PostMapping("/cart/{cartId}/product/{productId}/quantity/{quantity}")
    public void addProductToCart(@PathVariable Long cartId, @PathVariable Long productId, @PathVariable Integer quantity){
        cardService.addProductToCart(cartId,productId,quantity);
    }

    @PutMapping("/cart/{id}")
    public void updateCard(@PathVariable("id") Long id, @RequestBody CartDTO cartDTO){
        cardService.updateCard(id, cartDTO);
    }

    @PutMapping("/cart/empty/{id}")
    public ResponseEntity<Void> emptyCart(@PathVariable Long id){
        cardService.emptyCartById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCard(@PathVariable Long id){
        cardService.deleteCardById(id);
    }

    @DeleteMapping("/cart/{cartId}/product/{productId}")
    public void removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId){
        cardService.deleteProductFromCart(cartId,productId);
    }

}
