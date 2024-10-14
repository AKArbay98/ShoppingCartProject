package com.example.shoppingcarddemo.repository.productrepo;

import com.example.shoppingcarddemo.model.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
