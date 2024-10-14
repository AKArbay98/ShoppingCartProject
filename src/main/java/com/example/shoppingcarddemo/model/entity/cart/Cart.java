package com.example.shoppingcarddemo.model.entity.cart;

import com.example.shoppingcarddemo.model.entity.baseentityaudit.BaseEntityAudit;
import com.example.shoppingcarddemo.model.entity.customer.Customer;
import com.example.shoppingcarddemo.model.entity.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="cart")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart extends BaseEntityAudit {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    private List<Product> products;

    @Column(name="quantity", length=50)
    private Long quantity;

    @Transient // This annotation will prevent the field from being persisted
    private BigDecimal totalCost;

    public Cart() {
    }

    public Cart(Customer customer, List<Product> products, Long quantity) {
        this.customer = customer;
        this.products = products;
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getQuantity(Long quantity) {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Long getQuantity() {
        return quantity;
    }
}
