package com.mybanks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mybanks.Exception.AddressIdNotFound;
import com.mybanks.dao.AddressDao;
import com.mybanks.dto.Address;
import com.mybanks.util.ResponseStructure;
import com.mybanks.util.ResponseStructureList;


@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	@Autowired
	ResponseStructure<Address> responseStructure;
	@Autowired
	ResponseStructureList<Address> responseStructureList;
	
	public ResponseStructure<Address> save(Address address) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully new bank address created and inserted into DB");
		responseStructure.setData(addressDao.save(address));
		return responseStructure;	
	}
	
	public ResponseStructure<Address> update(int addressId,Address address) {
		Address a=addressDao.fetchAddressById(addressId);
		if(a!=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
	      	 responseStructure.setMessage("successfully data is fetched address from DB");
	      	 responseStructure.setData(addressDao.update(addressId, address));
	      	 return responseStructure;
		}
		else {
			throw new AddressIdNotFound();
		}
	}
	
	public ResponseStructure<Address> fetchAddressById(int addressId) {
		Address a=addressDao.fetchAddressById(addressId);
		if(a!=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
	      	 responseStructure.setMessage("successfully data is fetched from DB by band id");
	      	 responseStructure.setData(addressDao.fetchAddressById(addressId));
	      	 return responseStructure;
		}
		else {
			throw new AddressIdNotFound();
		}
	}
	
	public ResponseStructureList<Address> fetchAllAddress() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully fetched all bank account request from DB");
		responseStructureList.setData(addressDao.fetchAllAddress());
		return responseStructureList;
	}
	
	public ResponseStructure<Address> deleteAddressById(int addressId) {
		Address a=addressDao.fetchAddressById(addressId);
		if(a!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
	      	 responseStructure.setMessage("successfully data is deleted from DB");
	      	 responseStructure.setData(addressDao.deleteAddressById(addressId));
	      	 return responseStructure;
		}
		else {
			throw new AddressIdNotFound();
		}
	}
}
