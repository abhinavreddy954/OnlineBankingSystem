package com.mybanks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.mybanks.dao.EmployeeCredentialsdao;
import com.mybanks.dto.EmployeeCredentials;

import modeldata.EmployeeCredentialsmodel;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class EmployeeAccCreateController {
	
	
	@Autowired
	EmployeeCredentialsdao employeeCredentialsdao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/empaccdetails")
	public String employeeAccountCreate(EmployeeCredentialsmodel employeeCredentialsmodel, Model model) {
		List<EmployeeCredentials> data=employeeCredentialsdao.fetchAll();
		String un= employeeCredentialsmodel.getUser();
		String pwd= employeeCredentialsmodel.getPwd();
		String encodedPassword = passwordEncoder.encode(pwd);
		if (data.isEmpty()) {
			if(un != null && encodedPassword !=null) {
			EmployeeCredentials emp = new EmployeeCredentials(); 
			emp.setUserName(un);
			emp.setPwd(encodedPassword);
			employeeCredentialsdao.saveEmployeeCredentials(emp);
			System.out.println(emp);
			model.addAttribute("msg","successfully created");
			return "WorkerLogin";
			}
			else {
				model.addAttribute("errmsg","! error data you enter not reach to database, once again enter data correctly");
				return "EmployeeAcccreation";
			}
		}
		else {
			model.addAttribute("errmsg","! error you need to login with one of the employee credentials");
			return "EmployeeAcccreation";
		}
	}
	
	
	@PostMapping("/employee/empaccdetails")
	public String employeeAccountCreateWithEmployeeLogin(EmployeeCredentialsmodel employeeCredentialsmodel, Model model) {
		boolean state=false;
		List<EmployeeCredentials> data=employeeCredentialsdao.fetchAll();
		String un= employeeCredentialsmodel.getUser();
		String pwd= employeeCredentialsmodel.getPwd();
		String encodedPassword = passwordEncoder.encode(pwd);
		for(EmployeeCredentials checkdata : data) {
			String userNameInDB= checkdata.getUserName();
			if(userNameInDB != null && userNameInDB == un) {
				state=true;
			}
		}
		if(un != null && encodedPassword != null) {
			if(state != true) {
			EmployeeCredentials emp = new EmployeeCredentials(); 
			emp.setUserName(un);
			emp.setPwd(encodedPassword);
			employeeCredentialsdao.saveEmployeeCredentials(emp);
			System.out.println(emp);
			model.addAttribute("msg","successfully created new account for employee");
			return "BankUserInterface";
			}
			else {
				model.addAttribute("errmsg","! error user name you have entered is already present in DB, try with other user name");
				return "EmployeeAcccreation";
			}
		}
		else {
			model.addAttribute("errmsg","! error something went wrong while creating account");
			return "EmployeeAcccreation";
		}
	}

}
