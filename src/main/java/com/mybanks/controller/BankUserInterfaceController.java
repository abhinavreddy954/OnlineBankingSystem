package com.mybanks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybanks.dao.BankAccountsDao;
import com.mybanks.dao.BankAccountsRequestDao;
import com.mybanks.dao.InternetBankingRegistrationDao;
import com.mybanks.dto.BankAccounts;
import com.mybanks.dto.BankAccountsRequest;
import com.mybanks.dto.InternetBankingRegistration;

import jakarta.servlet.http.HttpServletRequest;
import modeldata.Editbankaccountdetails;
import modeldata.FetchBankAccDetails;

@Controller
@RequestMapping({"/customer", "/employee"})
public class BankUserInterfaceController{

	@Autowired
	BankAccountsRequestDao accountsRequestDao;
	
	@PostMapping("/accrequest")
	protected String fetchAccountRequests(Model model) {
		List<BankAccountsRequest> accountsRequest=accountsRequestDao.findAllBankAccountsRequest();
		if(accountsRequest == null) {
			model.addAttribute("key","currently no new account requests available");
			System.out.println("currently no new account requests available");
			return "accountsrequest";
		}
		else {			
			model.addAttribute("key",accountsRequest);
			System.out.println("account requests available");
			return "accountsrequest";
		}
	}
	
	
	@Autowired
	BankAccountsDao accountsDao;
	
	@PostMapping("/bankaccountdetails")
		protected String fetchBankAccDetails(Authentication authentication,Model model,HttpServletRequest request) {
//			String userName=fetchLoginedUserBankAccDetails.getUn();
//			String pwd=fetchLoginedUserBankAccDetails.getPwd();
//			int id=fetchLoginedUserBankAccDetails.getAccountId();
		int id=Integer.parseInt(request.getParameter("accountId"));
		String userName = authentication.getName();		
		
			if(id != 0 && userName != null ) {
				Optional<BankAccounts> accountdetailsOptional=accountsDao.findBankAccounts(id);
				BankAccounts accountdetails=accountdetailsOptional.get();
				model.addAttribute("account", accountdetails);
				System.out.println("account details fetched successfully "+accountdetails);
				return "BankAccountDetails";
			} 
			
			else {
				model.addAttribute("key", "something went wrong!..");
				System.out.println("something went wrong!..");
				return "UserInterface";
			}
		}
	
	@Autowired
	InternetBankingRegistrationDao bankingRegistrationDao;
	
//	@PostMapping("/editbankinternetaccountdetails")
//	protected String editbankaccountdetails(@ModelAttribute("Editbankaccountdetails") Editbankaccountdetails editbankaccountdetails,Model model) {
//		String username = editbankaccountdetails.getUsername();
//		InternetBankingRegistration editinternetBankingRegistration=bankingRegistrationDao.fetchIBRByUsername(username);
//		
////		System.out.println(userName);
////		System.out.println(pwd);
////		System.out.println(editinternetBankingRegistration);
//		if(editinternetBankingRegistration != null && username != null) {
//			model.addAttribute("internetbankingaccount", editinternetBankingRegistration);
//			model.addAttribute("un",username);
//			//model.addAttribute("pwd", pwd);
//		
//			System.out.println("internet banking account details fetched successfully "+editinternetBankingRegistration);
//			return "BankAccountDetails";
//		}
//		else {
//			model.addAttribute("errormsg", "something went wrong!..");
//			System.out.println("something went wrong!..");
//			return "UserInterface";
//		}
//	}

	
	@PostMapping("/editbankinternetaccountdetails")
	protected String editbankaccountdetails(
	        Authentication authentication,
	        Model model) {

	    String username = authentication.getName();

	    InternetBankingRegistration editinternetBankingRegistration =
	            bankingRegistrationDao.fetchIBRByUsername(username);

	    if (editinternetBankingRegistration != null) {

	        model.addAttribute("internetbankingaccount",
	                editinternetBankingRegistration);
	        model.addAttribute("un",username);
	        System.out.println("internet banking account details fetched successfully "+editinternetBankingRegistration);
	        return "BankAccountDetails";
	    }
	    else {
	        model.addAttribute("errormsg", "something went wrong!..");
	        System.out.println("something went wrong!..");
	        return "UserInterface";
	    }
	}
	
	
	@PostMapping("/emp")
	public String empAccountCreation() {
		return "EmployeeAcccreation";
	}
	
	
}