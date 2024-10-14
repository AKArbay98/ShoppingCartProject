package com.example.shoppingcarddemo.model.entity.address;


import com.example.shoppingcarddemo.model.entity.baseentityaudit.BaseEntityAudit;
import com.example.shoppingcarddemo.model.entity.customer.Customer;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="address")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Address extends BaseEntityAudit {

    @Column(name="city", length=50, nullable=false, unique=false)
    private String city;

    @Column(name="district", length=50, nullable=false, unique=false)
    private String district;

    @Column(name="phone", length=50, nullable=false, unique=true)
    private String phoneNumber;

    @OneToOne(mappedBy = "address")
    private Customer customer;

    public Address() {

    }

    public Address(String city, String district, String phoneNumber, Customer customer) {
        this.city = city;
        this.district = district;
        this.phoneNumber = phoneNumber;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
