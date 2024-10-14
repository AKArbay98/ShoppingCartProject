package com.example.shoppingcarddemo.controller.address;

import com.example.shoppingcarddemo.model.dto.AddressDTO;
import com.example.shoppingcarddemo.service.abstractservice.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public ResponseEntity<List<AddressDTO>> getAllAddress(){
        List<AddressDTO> addresses = addressService.fetchAllAddress();
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable Long id){
        AddressDTO addressById = addressService.getAddressById(id);
        return ResponseEntity.ok(addressById);
    }

    @PostMapping("/address")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAddress(@RequestBody AddressDTO addressDto){
        addressService.createAddress(addressDto);
    }

    @PutMapping("/address/{id}")
    public void updateAddress(@PathVariable("id") Long id, @RequestBody AddressDTO addressDto){
        addressService.updateAddress(id, addressDto);
    }

    @DeleteMapping("/address/{id}")
    public void deleteAddress(@PathVariable Long id){
        addressService.deleteAddressById(id);
    }

}
