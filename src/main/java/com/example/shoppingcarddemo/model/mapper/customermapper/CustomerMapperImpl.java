package com.example.shoppingcarddemo.model.mapper.customermapper;

import com.example.shoppingcarddemo.model.dto.CustomerDTO;
import com.example.shoppingcarddemo.model.entity.customer.Customer;

public class CustomerMapperImpl {

    private final CustomerMapper customerMapper;

    public CustomerMapperImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public CustomerDTO convertCustomerToCustomerDto(Customer customer){
        return customerMapper.customerToCustomerDTO(customer);
    }

    public Customer convertCustomerDtoToCustomer(CustomerDTO customerDto){
        return customerMapper.customerDtoToCustomer(customerDto);
    }
}
