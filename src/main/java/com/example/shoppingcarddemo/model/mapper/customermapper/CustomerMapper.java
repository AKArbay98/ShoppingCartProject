package com.example.shoppingcarddemo.model.mapper.customermapper;

import com.example.shoppingcarddemo.model.dto.CustomerDTO;
import com.example.shoppingcarddemo.model.entity.customer.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "cart", target = "cart")
    @Mapping(source = "orders", target = "orders")
    CustomerDTO customerToCustomerDTO(Customer customer);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "cart", target = "cart")
    @Mapping(source = "orders", target = "orders")
    Customer customerDtoToCustomer(CustomerDTO customerDto);
}

