package com.example.shoppingcarddemo.service.abstractservice;

import com.example.shoppingcarddemo.model.dto.CustomerDTO;
import com.example.shoppingcarddemo.model.entity.customer.Customer;

import java.util.List;

public interface CustomerService {

    void deleteCustomerById(Long id);
    List<CustomerDTO> fetchAllCustomer();
    CustomerDTO getCustomerById(Long id);
    void createCustomer(CustomerDTO customerDTO);
    void updateCustomer(Long id, CustomerDTO customerDTO);

}
