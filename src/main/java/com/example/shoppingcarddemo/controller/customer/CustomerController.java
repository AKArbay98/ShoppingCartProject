package com.example.shoppingcarddemo.controller.customer;


import com.example.shoppingcarddemo.model.dto.CustomerDTO;
import com.example.shoppingcarddemo.service.abstractservice.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomer(){
        List<CustomerDTO> customers = customerService.fetchAllCustomer();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable  Long id){
        CustomerDTO customerById = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerById);
    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.createCustomer(customerDTO);
    }

    @PutMapping("/customer/{id}")
    public void updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(Long id){
        customerService.deleteCustomerById(id);
    }
}
