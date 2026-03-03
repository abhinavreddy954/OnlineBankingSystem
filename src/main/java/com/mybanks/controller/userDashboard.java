package com.mybanks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mybanks.dao.BankAccountsDao;
import com.mybanks.dao.BankAccountsRequestDao;
import com.mybanks.dao.InternetBankingRegistrationDao;
import com.mybanks.dto.BankAccounts;
import com.mybanks.dto.BankAccountsRequest;
import com.mybanks.dto.InternetBankingRegistration;

@Controller
public class userDashboard {
	@Autowired
	BankAccountsDao bankAccountsDao;
	
	@Autowired
	InternetBankingRegistrationDao bankingRegistrationDao;
	
	@Autowired
	BankAccountsRequestDao accountsRequestDao;
	
	@GetMapping("/customer")
	public String userDashboard(Model model) {
		

	    Authentication auth =
	            SecurityContextHolder.getContext().getAuthentication();

	    String username = auth.getName();

	    // Fetch bank account
	    BankAccounts bankAccount =
	    		bankAccountsDao.findBankAccByUsername(username);

	    // Fetch bank account request
	    InternetBankingRegistration user =
	            bankingRegistrationDao.fetchIBRByUsername(username);

	    BankAccountsRequest accountRequest = null;

	    if (user != null) {
	        accountRequest =
	                accountsRequestDao.findBankAccReqByPhoneno(user.getPhone());
	    }

	    model.addAttribute("bankAccount", bankAccount);
	    model.addAttribute("accountRequest", accountRequest);

	    return "UserInterface";
	}
	
	@GetMapping("/backtouserdashboard")
	public String backToDashboard() {
		return "UserInterface";
	}

}
