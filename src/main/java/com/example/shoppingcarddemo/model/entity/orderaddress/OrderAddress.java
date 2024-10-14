package com.example.shoppingcarddemo.model.entity.orderaddress;

import com.example.shoppingcarddemo.model.entity.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="order_address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderAddress {

    @Column(name="city", length=50, nullable=false, unique=false)
    private String city;

    @Column(name="district", length=50, nullable=false, unique=false)
    private String district;

    @Column(name="neighbourhood", length=50, nullable=false, unique=false)
    private String neighbourhood;

    @Column(name="address_description", length=50, nullable=false, unique=false)
    private String addressDescription;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    public OrderAddress(String city, String district, String neighbourhood, String addressDescription, Order order) {
        this.city = city;
        this.district = district;
        this.neighbourhood = neighbourhood;
        this.addressDescription = addressDescription;
        this.order = order;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
