package com.mybanks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybanks.dto.Address;
import com.mybanks.service.AddressService;
import com.mybanks.util.ResponseStructure;

import modeldata.UpdateAddress;

@Controller
@RequestMapping({"/customer", "/employee"})
public class UpdateAddressController {
	@Autowired
	AddressService addressService;
	
	@PostMapping("/updateaddress")
	public String updateAddress(@ModelAttribute("UpdateAddress") UpdateAddress updateAddress,Model model) {
		int id=updateAddress.getId();
		
		Address address=new Address();
		address.setCityName(updateAddress.getCityName());
		address.setCountry(updateAddress.getCountry());
		address.setStreetName(updateAddress.getStreetName());
		address.setIfscCode(updateAddress.getIfsccode());
		ResponseStructure<Address> address2=addressService.update(id, address);
		Address data=address2.getData();
		
		if(data !=null) {
			System.out.println("update is successfull");
			model.addAttribute("result", data);
			return "Output";
			}
		else {
			System.out.println("update is not successfull");
			model.addAttribute("result","no address are found in DB");
			return "Output";
		}
		
	}
	
	@GetMapping("/updateAddress")
	public String updateAddress() {
	    return "UpdateAddress";  
	}
}
