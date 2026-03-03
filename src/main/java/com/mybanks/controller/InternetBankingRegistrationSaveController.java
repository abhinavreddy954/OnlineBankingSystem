package com.mybanks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mybanks.dao.BankAccountsDao;
import com.mybanks.dao.BankAccountsRequestDao;
import com.mybanks.dao.InternetBankingRegistrationDao;
import com.mybanks.dto.BankAccounts;
import com.mybanks.dto.BankAccountsRequest;
import com.mybanks.dto.InternetBankingRegistration;
import modeldata.InternetBankingregestrationmodel;

@Controller
public class InternetBankingRegistrationSaveController{
	
	@Autowired
	private InternetBankingRegistrationDao bankingRegistrationDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	  
	@PostMapping("/IBR")
	protected String IBRSave(@ModelAttribute("InternetBankingregestrationmodel") InternetBankingregestrationmodel internetBankingregestrationmodel,Model model) {
		long phone=internetBankingregestrationmodel.getPhone();
		String userName=internetBankingregestrationmodel.getUser();
		String pswd=internetBankingregestrationmodel.getPwd();
		String retypepswd=internetBankingregestrationmodel.getRetypepwd();
		String email=internetBankingregestrationmodel.getEmail();
		boolean saved=false;
		
		InternetBankingRegistration fetchbankregistrationdetails=bankingRegistrationDao.findIBRBYUseNameOREmailORPhone(userName, phone, email);
	    if(fetchbankregistrationdetails == null) {
	    	if(pswd.equals(retypepswd)) {
	    		InternetBankingRegistration bankingRegistration=new InternetBankingRegistration();
	    		String encodedPassword = passwordEncoder.encode(pswd);
	    		
				bankingRegistration.setPhone(phone);
				bankingRegistration.setUserName(userName);
				
				bankingRegistration.setPswd(encodedPassword);
				bankingRegistration.setRetyprpswd(encodedPassword);
				
//				bankingRegistration.setPswd(pswd);
//				bankingRegistration.setRetyprpswd(retypepswd);
				bankingRegistration.setEmail(email);
		        saved = bankingRegistrationDao.saveIBR(bankingRegistration);

	    	}
	    	else {
	    		model.addAttribute("key","password and retype password is not same..");
				return "/NewUserIBR";  //NewUserIBR
	    	}
			
		}else {
			model.addAttribute("key","new Internet banking digital account not created as already account available with usernme or email or phone number you have entered ,please use any other details..");
			return "/NewUserIBR";  //NewUserIBR
		}
		
		if(saved==true) {
			model.addAttribute("key","successfully created a new Internet banking sdigital account");
			return "redirect:/customer"; //userlogin.jsp
		}
		else {
			model.addAttribute("key","new Internet banking digital account not created try once again");
			return "/NewUserIBR"; //NewUserIBR
		}
    }
	
	
	
	@Autowired
	BankAccountsRequestDao accountsRequestDao;
	@Autowired
	BankAccountsDao bankaccountsDao;
	
	@PostMapping("/ibrupdate")
	public String updateIBR(
			@RequestParam("phone") long phone,
	        @RequestParam("user") String user,
	        @RequestParam("email") String email,
	        @RequestParam("pwd") String password,
	        Model model) {

	    InternetBankingRegistration existingIBR =
	            bankingRegistrationDao.fetchIBRByUsername(user);

	    if (existingIBR == null) {
	        model.addAttribute("failuremsg", "User not found");
	        return "BankAccountDetails";
	    }

	    // Update IBR
	    String encodedPassword = passwordEncoder.encode(password);
	    existingIBR.setPhone(phone);
	    if (password != null && !password.trim().isEmpty()) {
	        // User entered new password encode and update
	    	existingIBR.setPswd(passwordEncoder.encode(password));
	    }
	    existingIBR.setEmail(email);
	    bankingRegistrationDao.updateIBR(user, existingIBR);
	    
	    
	    
	    // Update IBR details in Bank Account Request if exists
	    BankAccountsRequest request =
	            accountsRequestDao.findBankAccountsRequestByUserName(user);

	    if (request != null) {
	        request.setUserName(user);
	        request.setEmailId(email);
	        request.setMobileNo(phone);
	        accountsRequestDao.updateBankAccountsRequest(
	                request.getBankReqId(), request);
	    }

	    // UpdateIBR details in Bank Account if exists
	    BankAccounts account =
	            bankaccountsDao.findBankAccByUsername(user);

	    if (account != null) {
	        account.setUsername(user);
	        account.setEmailId(email);
	        account.setMobileNo(phone);
	        bankaccountsDao.updateBankAccounts(
	                account.getBankId(), account);
	    }

	    model.addAttribute("successRequest",
	            "Internet banking digital account updated successfully");

	    return "BankAccountDetails";
	}

}