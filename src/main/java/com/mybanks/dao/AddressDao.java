package com.mybanks.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybanks.dto.Address;
import com.mybanks.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	AddressRepo addressRepo;
	
	
	public Address save(Address address) {
		return addressRepo.save(address);		
	}
	
	public Address update(int addressId,Address address) {
		address.setAddressId(addressId);
		return addressRepo.save(address);
	}
	
	public Address fetchAddressById(int addressId) {
		Address address=addressRepo.findById(addressId).get();
		System.out.println(address);
		return address;
	}
	
	public List<Address> fetchAllAddress() {
		List<Address> address=addressRepo.findAll();
		return address;
	}
	
	public Address deleteAddressById(int addressId) {
		Address address=fetchAddressById(addressId);
		addressRepo.delete(address);
		return address;
	}
	
}
