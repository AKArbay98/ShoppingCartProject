package com.example.shoppingcarddemo.repository.cartrepo;

import com.example.shoppingcarddemo.model.entity.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Cart,Long> {
}
