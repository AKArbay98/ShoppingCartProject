package com.example.shoppingcarddemo.model.entity.order;

import com.example.shoppingcarddemo.model.entity.baseentityaudit.BaseEntityAudit;
import com.example.shoppingcarddemo.model.entity.customer.Customer;
import com.example.shoppingcarddemo.model.entity.orderaddress.OrderAddress;
import com.example.shoppingcarddemo.model.entity.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order extends BaseEntityAudit {

    @Column(name="status", length=50, nullable=true, unique=false)
    private Boolean status;

    @Column(name="order_date", length=50, nullable=true, unique=false)
    private LocalDateTime orderDate;

    @Column(name="total_cost", length=50, nullable=true, unique=false)
    private BigDecimal totalCost;

    @OneToMany(mappedBy = "order")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderAddress> orderAddresses;

    public Order(Boolean status, LocalDateTime orderDate, BigDecimal totalCost, List<Product> products, Customer customer, List<OrderAddress> orderAddresses) {
        this.status = status;
        this.orderDate = orderDate;
        this.totalCost = totalCost;
        this.products = products;
        this.customer = customer;
        this.orderAddresses = orderAddresses;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderAddress> getOrderAddresses() {
        return orderAddresses;
    }

    public void setOrderAddresses(List<OrderAddress> orderAddresses) {
        this.orderAddresses = orderAddresses;
    }
}
