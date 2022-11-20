package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Address;
import com.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public List<Address> getAllAddresses() {

		List<Address> addresses = new ArrayList<>();
		addressRepository.findAll().forEach(x -> addresses.add(x));
		return addresses;
	}

	public boolean addAddress(Address address) {
		if (address.equals(null)) {
			return false;
		} else {
			addressRepository.save(address);
			return true;
		}

	}

	public boolean deleteAddress(Address address) {
		if (address.equals(null)) {
			return false;
		} else {
			addressRepository.delete(address);
			return true;
		}
	}

	public Address getSingleAddress(long id) {
		Address address = addressRepository.getOne(id);
		return address;
	}

}
