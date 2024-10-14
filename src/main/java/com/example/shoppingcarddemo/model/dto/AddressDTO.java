package com.example.shoppingcarddemo.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class AddressDTO {

    private String city;
    private String district;
    private String phoneNumber;
    private CustomerDTO customer;

    public AddressDTO(String city, String district, String phoneNumber, CustomerDTO customer) {
        this.city = city;
        this.district = district;
        this.phoneNumber = phoneNumber;
        this.customer = customer;
    }

    public AddressDTO() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
