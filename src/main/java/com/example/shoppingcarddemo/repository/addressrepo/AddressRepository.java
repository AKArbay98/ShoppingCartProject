package com.example.shoppingcarddemo.repository.addressrepo;

import com.example.shoppingcarddemo.model.entity.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
