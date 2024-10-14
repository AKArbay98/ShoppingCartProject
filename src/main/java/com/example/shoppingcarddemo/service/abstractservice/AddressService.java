package com.example.shoppingcarddemo.service.abstractservice;

import com.example.shoppingcarddemo.model.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    void deleteAddressById(Long id);
    List<AddressDTO> fetchAllAddress();
    AddressDTO getAddressById(Long id);
    void createAddress(AddressDTO address);
    void updateAddress(Long id, AddressDTO address);

}
