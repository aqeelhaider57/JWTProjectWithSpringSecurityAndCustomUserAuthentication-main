package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
