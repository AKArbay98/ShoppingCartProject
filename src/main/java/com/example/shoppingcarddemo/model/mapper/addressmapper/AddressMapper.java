package com.example.shoppingcarddemo.model.mapper.addressmapper;

import com.example.shoppingcarddemo.model.dto.AddressDTO;
import com.example.shoppingcarddemo.model.entity.address.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapperImpl INSTANCE = Mappers.getMapper(AddressMapperImpl.class);

    @Mapping(source = "city", target = "city")
    @Mapping(source = "district", target = "district")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "customer", target = "customer")
    AddressDTO addressToAddressDTO(Address address);

    @Mapping(source = "city", target = "city")
    @Mapping(source = "district", target = "district")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "customer", target = "customer")
    Address addressDtoToAddress(AddressDTO addressDto);
}
