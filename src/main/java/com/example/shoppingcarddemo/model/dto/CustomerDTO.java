package com.example.shoppingcarddemo.model.dto;


import lombok.*;

import java.util.List;


@Getter
@Setter
@Data
public class CustomerDTO {

    private String name;
    private String surname;
    private AddressDTO address;
    private String password;
    private Integer age;
    private String email;
    private CartDTO cart;
    private List<OrderDTO> orders;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String surname, AddressDTO address, String password, Integer age, String email, CartDTO cart, List<OrderDTO> orders) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.password = password;
        this.age = age;
        this.email = email;
        this.cart = cart;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CartDTO getCart() {
        return cart;
    }

    public void setCart(CartDTO cart) {
        this.cart = cart;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}
