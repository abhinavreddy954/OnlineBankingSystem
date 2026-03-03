package com.mybanks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class empDashboard {
	@GetMapping("/employee")
	public String employeePage() {
	    return "BankUserInterface";
	}
	
	@GetMapping("/emp")
	public String empAccountCreation() {
		return "EmployeeAcccreation";
	}
	
	@GetMapping("employee/bankuserinterface")
	public String BankUserInterfaceJSP() {
		return "BankUserInterface";
	}
	
	@PostMapping("employee/NewBAcc")
	public String NewBankAccRequestJSP() {
		return "NewBAcc";
	}
	
	@PostMapping("/backtoemployeedashboard")
	public String backToDashboard() {
		return "BankUserInterface";
	}
}
