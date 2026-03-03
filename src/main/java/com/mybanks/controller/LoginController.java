package com.mybanks.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.mybanks.dao.BankAccountsDao;
import com.mybanks.dao.BankAccountsRequestDao;
import com.mybanks.dao.InternetBankingRegistrationDao;
import com.mybanks.dto.BankAccounts;
import com.mybanks.dto.BankAccountsRequest;
import com.mybanks.dto.InternetBankingRegistration;
import com.mybanks.service.AddressService;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import modeldata.EmployeeCredentialsmodel;

@Controller
public class LoginController {
	@Autowired
	InternetBankingRegistrationDao bankingRegistrationDao;
	
	@Autowired
	BankAccountsDao bankAccountsDao;
	
	@Autowired
	BankAccountsRequestDao accountsRequestDao;
	
	@Autowired
	AddressService addressService;
	
//	@GetMapping("/customer")
	protected String userLogin(@ModelAttribute("EmployeeCredentialsmodel") EmployeeCredentialsmodel loginmodeldata, Model model, HttpSession session) {
		String userName=loginmodeldata.getUser();
		String pwd=loginmodeldata.getPwd();
		
		if(userName != "" && pwd != "") {
			try {
			InternetBankingRegistration bankingRegistration=bankingRegistrationDao.fetchIBRByUsername(userName);
			BankAccounts bankAccounts=bankAccountsDao.findBankAccByUsername(userName);
			
			if(bankingRegistration.getUserName().equals(userName) && bankingRegistration.getPswd().equals(pwd) && bankAccounts!=null) {
				model.addAttribute("username", userName);
				model.addAttribute("pwd", pwd);
				model.addAttribute("bankAccount",bankAccounts);
				session.setAttribute("username", userName);
				System.out.println("login successfull");
				return "UserInterface";
			}
			
			else if(bankingRegistration.getUserName().equals(userName) && bankingRegistration.getPswd().equals(pwd)) {
				long phone=bankingRegistration.getPhone();
				BankAccountsRequest accountsRequest=accountsRequestDao.findBankAccReqByPhoneno(phone);
				session.setAttribute("username", userName);
				model.addAttribute("key",accountsRequest);
				model.addAttribute("user",userName);
				model.addAttribute("pwd", pwd);
				model.addAttribute("phoneno",phone);
				return "UserInterface";
			}
			else {
				List<InternetBankingRegistration> allInternetBankingAcc=bankingRegistrationDao.fetchAllIBR();
				for(InternetBankingRegistration a:allInternetBankingAcc) {
					String userCredentials=a.getUserName();
					String pwdCredentials=a.getPswd();
					if(userCredentials.equals(userName) && pwdCredentials.equals(pwd)) {
						System.out.println("credentials found");
					} else {
						model.addAttribute("authenticate", "User name and password are not valid");
						model.addAttribute("value",1);
					}
				}
				for(InternetBankingRegistration a:allInternetBankingAcc) {
					String userCredentials=a.getUserName();
					if(userCredentials.equals(userName)) {
						System.out.println("User name found");
					}else {
						model.addAttribute("authenticate", "username is not valid");
						model.addAttribute("value",2);
					}
				}
				for(InternetBankingRegistration a:allInternetBankingAcc) {
					String pwdCredentials=a.getPswd();
					if(pwdCredentials.equals(pwd)) {
						System.out.println("passwor found");
					} else {
						model.addAttribute("authenticate", "password is not valid");
						model.addAttribute("value", 3);
					}
				}		    			
				return "UserLogin";
			} } 
			
			catch(Exception e) {
				System.out.println("exception occured due to user name is not valid ue to which null pointer exception occured");
				List<InternetBankingRegistration> allInternetBankingAcc=bankingRegistrationDao.fetchAllIBR();
				for(InternetBankingRegistration a:allInternetBankingAcc) {
					String userCredentials=a.getUserName();
					String pwdCredentials=a.getPswd();
					if(userCredentials.equals(userName) && pwdCredentials.equals(pwd)) {
						System.out.println("credentials found");
					} else {
						model.addAttribute("authenticate", "User name and password are not valid");
						model.addAttribute("value",1);
					}
				}
				for(InternetBankingRegistration a:allInternetBankingAcc) {
					String userCredentials=a.getUserName();
					if(userCredentials.equals(userName)) {
						System.out.println("User name found");
					}else {
						model.addAttribute("authenticate", "username is not valid");
						model.addAttribute("value",2);
					}
				}
				for(InternetBankingRegistration a:allInternetBankingAcc) {
					String pwdCredentials=a.getPswd();
					if(pwdCredentials.equals(pwd)) {
						System.out.println("passwor found");
					} else {
						model.addAttribute("authenticate", "password is not valid");
						model.addAttribute("value", 3);
					}
				}		    			
				return "UserLogin";
			}}
		
		else {
			model.addAttribute("authenticate","please enter your credentials");
			model.addAttribute("value",1);
			return "UserLogin";
		}
	
	}
	
//	@GetMapping("/user/loginfail")
//	public String loginPage(@RequestParam(value="error", required=false) String error,
//	                        Model model) {
//
//	    if (error != null) {
//	        model.addAttribute("authenticate", "Invalid username or password");
//	    }
//
//	    return "UserLogin";
//	}
}