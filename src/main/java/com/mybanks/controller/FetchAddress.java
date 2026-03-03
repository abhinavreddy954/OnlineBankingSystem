package com.mybanks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybanks.dao.AddressDao;
import com.mybanks.dao.InternetBankingRegistrationDao;
import com.mybanks.dto.Address;
import com.mybanks.dto.InternetBankingRegistration;

import modeldata.CheckAddress;

@Controller
@RequestMapping({"/customer", "/employee"})
public class FetchAddress {
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	InternetBankingRegistrationDao bankingRegistrationDao;
	
	@GetMapping("/fetchAllAddress")
	public String fetchAllAddress(Model model) {
		List<Address> address=addressDao.fetchAllAddress();
//		for(Address a:address) {
//			System.out.println(a);
//		}
		
		if(address != null) {
			model.addAttribute("keyfetchall", address);
			return "fetchAllAddress";
		}
		else {
			model.addAttribute("keyfetchall","no address are found in DB");
			return "fetchAllAddress";
		}
	}
	
	//used to fetch address in NEwAcc.jsp
	@PostMapping("/fetchAllAddressforNewACC")
	public String fetchAllAddressforNewACC(Model model) {
		Authentication auth =
	            SecurityContextHolder.getContext().getAuthentication();

	    String user = auth.getName();
	    InternetBankingRegistration details = bankingRegistrationDao.fetchIBRByUsername(user);
	    Long phone= details.getPhone();
	    String email=details.getEmail();
	    List<Address> addressList = addressDao.fetchAllAddress();

	    model.addAttribute("user", user);
	    model.addAttribute("phoneno", phone);
	    model.addAttribute("email", email);
	    System.out.println(phone);
	    if (addressList != null && !addressList.isEmpty()) {
	        model.addAttribute("keyfetchall", addressList);
	    } else {
	        model.addAttribute("keyfetchall", null);
	    }

	    return "NewAcc";  
	}

	
	@GetMapping("/fetchAddress")
	public String fetchAddress(@ModelAttribute("CheckAddress") CheckAddress checkAddress, Model model) {
		System.out.println("address Id: "+checkAddress.getId());
		Address address=addressDao.fetchAddressById(checkAddress.getId());
		System.out.println(address);
		
		if(address != null) {
			model.addAttribute("keyfetched", address);
			return "fetchAddress";
		}
		else {
			model.addAttribute("keyfetched","no address is found associated with id "+checkAddress.getId()+" in DB");
			return "fetchAddress";
		}
	}
}
