package com.example.shoppingcarddemo.model.mapper.addressmapper;

import com.example.shoppingcarddemo.model.dto.AddressDTO;
import com.example.shoppingcarddemo.model.entity.address.Address;

public class AddressMapperImpl {

    private final AddressMapper addressMapper;

    public AddressMapperImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public AddressDTO convertAddressToAddressDto(Address address){
        return addressMapper.addressToAddressDTO(address);
    }

    public Address convertAddressDtoToAddress(AddressDTO addressDTO){
        return addressMapper.addressDtoToAddress(addressDTO);
    }

}
