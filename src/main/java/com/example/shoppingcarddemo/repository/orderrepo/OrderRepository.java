package com.example.shoppingcarddemo.repository.orderrepo;

import com.example.shoppingcarddemo.model.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
