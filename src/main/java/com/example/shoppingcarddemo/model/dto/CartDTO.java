package com.example.shoppingcarddemo.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
public class CartDTO {

    private CustomerDTO customer;
    private List<ProductDTO> products;
    private Long quantity;

    public CartDTO(CustomerDTO customer, List<ProductDTO> products, Long quantity) {
        this.customer = customer;
        this.products = products;
        this.quantity = quantity;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
