package com.example.shoppingcarddemo.model.entity.customer;

import com.example.shoppingcarddemo.model.entity.address.Address;
import com.example.shoppingcarddemo.model.entity.baseentityaudit.BaseEntityAudit;
import com.example.shoppingcarddemo.model.entity.cart.Cart;
import com.example.shoppingcarddemo.model.entity.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer extends BaseEntityAudit {

    @Column(name="name", length=50, nullable=false, unique=false)
    private String name;

    @Column(name="surname", length=50, nullable=false, unique=false)
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name="password", length=50, nullable=false, unique=true)
    private String password;

    @Column(name="age", length=50, nullable=true, unique=false)
    private Integer age;

    @Column(name = "email", length=50, nullable=false, unique=true)
    private String email;

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer(String name, String surname, Address address, String password, Integer age, String email, Cart cart, List<Order> orders) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
