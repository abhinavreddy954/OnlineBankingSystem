package com.mybanks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybanks.dto.Address;
import com.mybanks.service.AddressService;
import modeldata.AddAddressmodel;

@Controller
@RequestMapping("/employee")
public class AddressSaveController {
	@Autowired
	AddressService addressService;
	
	@PostMapping("/address")
	protected String addressSave(@ModelAttribute("AddAddressmodel") AddAddressmodel addAddressmodel, Model model){
		String streetName=addAddressmodel.getStreetName();
		String cityName=addAddressmodel.getCityName();
		String country=addAddressmodel.getCountry();
		String IFSC=addAddressmodel.getIFSC();
		
		Address address=new Address();
		address.setStreetName(streetName);
		address.setCityName(cityName);
		address.setCountry(country);
		address.setIfscCode(IFSC);
		
		if(address != null) {
			addressService.save(address);
			model.addAttribute("key","successfully new bank address added into database");
			return "SaveAddress";
		}	
		else {
			model.addAttribute("key","some thing went wrong new bank address is not added into database");
			return "SaveAddress";
		}
	}
	
	@PostMapping("/saveAddress")
	public String saveAddress() {
	    return "SaveAddress";  // NOT SaveAddress.jsp
	}
}
