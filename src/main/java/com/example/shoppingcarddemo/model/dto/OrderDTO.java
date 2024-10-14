package com.example.shoppingcarddemo.model.dto;

import com.example.shoppingcarddemo.model.entity.customer.Customer;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Data
public class OrderDTO {

    private Boolean status;
    private LocalDateTime orderDate;
    private BigDecimal totalCost;
    private List<ProductDTO> productList;
    private CustomerDTO customer;
    private List<OrderAddressDTO> orderAddresses;

    public OrderDTO(Boolean status, LocalDateTime orderDate, BigDecimal totalCost, List<ProductDTO> productList, CustomerDTO customer, List<OrderAddressDTO> orderAddresses) {
        this.status = status;
        this.orderDate = orderDate;
        this.totalCost = totalCost;
        this.productList = productList;
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

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<OrderAddressDTO> getOrderAddresses() {
        return orderAddresses;
    }

    public void setOrderAddresses(List<OrderAddressDTO> orderAddresses) {
        this.orderAddresses = orderAddresses;
    }
}

