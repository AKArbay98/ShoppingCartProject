package com.example.shoppingcarddemo.service.concreteservice;

import com.example.shoppingcarddemo.model.dto.AddressDTO;
import com.example.shoppingcarddemo.model.entity.customer.Customer;
import com.example.shoppingcarddemo.model.mapper.addressmapper.AddressMapperImpl;
import com.example.shoppingcarddemo.model.entity.address.Address;
import com.example.shoppingcarddemo.model.mapper.customermapper.CustomerMapperImpl;
import com.example.shoppingcarddemo.repository.addressrepo.AddressRepository;
import com.example.shoppingcarddemo.service.abstractservice.AddressService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapperImpl addressMapperImpl;
    private final CustomerMapperImpl customerMapperImpl;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapperImpl addressMapperImpl, CustomerMapperImpl customerMapperImpl) {
        this.addressRepository = addressRepository;
        this.addressMapperImpl = addressMapperImpl;
        this.customerMapperImpl = customerMapperImpl;
    }


    @Override
    public List<AddressDTO> fetchAllAddress() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(addressMapperImpl::convertAddressToAddressDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO getAddressById(Long id) {
        return addressRepository.findById(id)
                .map(addressMapperImpl::convertAddressToAddressDto)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id: " + id));
    }

    @Override
    public void createAddress(AddressDTO addressDTO) {
        Address address = addressMapperImpl.convertAddressDtoToAddress(addressDTO);
        addressRepository.save(address);
    }

    @Override
    public void updateAddress(Long id, AddressDTO addressDTO) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id: " + id));

        existingAddress.setCity(addressDTO.getCity());
        existingAddress.setDistrict(addressDTO.getDistrict());
        existingAddress.setPhoneNumber(addressDTO.getPhoneNumber());

        if(addressDTO.getCustomer() != null){
            Customer customer = customerMapperImpl.convertCustomerDtoToCustomer(addressDTO.getCustomer());
            existingAddress.setCustomer(customer);
        }

        addressRepository.save(existingAddress);

    }

    @Override
    public void deleteAddressById(Long id) {
        if (!addressRepository.existsById(id)){
            throw new IllegalArgumentException("Address with ID " + id + " does not exist.");
        }
        addressRepository.deleteById(id);
    }

}
