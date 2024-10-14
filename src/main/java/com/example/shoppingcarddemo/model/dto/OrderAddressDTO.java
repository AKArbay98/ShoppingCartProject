package com.example.shoppingcarddemo.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class OrderAddressDTO {

    private String city;
    private String district;
    private String neighbourhood;
    private String addressDescription;
    private OrderDTO order;

    public OrderAddressDTO(String city, String district, String neighbourhood, String addressDescription, OrderDTO order) {
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

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }
}
