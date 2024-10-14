package com.example.shoppingcarddemo.service.concreteservice;

import com.example.shoppingcarddemo.model.dto.CustomerDTO;
import com.example.shoppingcarddemo.model.entity.address.Address;
import com.example.shoppingcarddemo.model.entity.cart.Cart;
import com.example.shoppingcarddemo.model.entity.customer.Customer;
import com.example.shoppingcarddemo.model.entity.order.Order;
import com.example.shoppingcarddemo.model.mapper.addressmapper.AddressMapperImpl;
import com.example.shoppingcarddemo.model.mapper.cartmapper.CartMapperImpl;
import com.example.shoppingcarddemo.model.mapper.customermapper.CustomerMapperImpl;
import com.example.shoppingcarddemo.model.mapper.ordermapper.OrderMapperImpl;
import com.example.shoppingcarddemo.repository.customerrepo.CustomerRepository;
import com.example.shoppingcarddemo.service.abstractservice.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapperImpl customerMapperImpl;
    private final AddressMapperImpl addressMapperImpl;
    private final CartMapperImpl cartMapperImpl;
    private final OrderMapperImpl orderMapperImpl;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapperImpl customerMapperImpl, AddressMapperImpl addressMapperImpl, CartMapperImpl cartMapperImpl, OrderMapperImpl orderMapperImpl) {
        this.customerRepository = customerRepository;
        this.customerMapperImpl = customerMapperImpl;
        this.addressMapperImpl = addressMapperImpl;
        this.cartMapperImpl = cartMapperImpl;
        this.orderMapperImpl = orderMapperImpl;
    }


    @Override
    public List<CustomerDTO> fetchAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapperImpl::convertCustomerToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapperImpl::convertCustomerToCustomerDto)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));
    }

    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapperImpl.convertCustomerDtoToCustomer(customerDTO);
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));

        existingCustomer.setName(customerDTO.getName());
        existingCustomer.setSurname(customerDTO.getSurname());

        if(customerDTO.getAddress() != null){
            Address address = addressMapperImpl.convertAddressDtoToAddress(customerDTO.getAddress());
            existingCustomer.setAddress(address);
        }

        existingCustomer.setPassword(customerDTO.getPassword());
        existingCustomer.setAge(customerDTO.getAge());
        existingCustomer.setEmail(customerDTO.getEmail());

        if(customerDTO.getCart() != null){
            Cart cart = cartMapperImpl.convertCartDtoToCart(customerDTO.getCart());
            existingCustomer.setCart(cart);
        }

        if(customerDTO.getOrders() != null){
            List<Order> orders = customerDTO.getOrders().stream()
                    .map(orderMapperImpl::convertOrderDtoToOrder)
                    .collect(Collectors.toList());
            existingCustomer.setOrders(orders);
        }

        customerRepository.save(existingCustomer);
    }


    @Override
    public void deleteCustomerById(Long customerId) {
        if(!customerRepository.existsById(customerId)){
            throw new IllegalArgumentException("Customer with ID " + customerId + " does not exist.");
        }
        customerRepository.deleteById(customerId);
    }

}
