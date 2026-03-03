package com.mybanks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mybanks.dao.EmployeeCredentialsdao;
import com.mybanks.dto.EmployeeCredentials;
import modeldata.EmployeeCredentialsmodel;

@Controller
public class EmployeeCredentialsController {

    @Autowired
    private EmployeeCredentialsdao credentialsDao;
    
    @Autowired
    EmployeeCredentialsdao employeeCredentialsdao;

    //@GetMapping("/employee")
    public String login(@ModelAttribute("EmployeeCredentialsmodel") EmployeeCredentialsmodel loginmodeldata,Model model) {
    	
    	String userName=loginmodeldata.getUser();
    	String pwd=loginmodeldata.getPwd();
        EmployeeCredentials credentials = credentialsDao.fetchByCredentials(userName, pwd);

        if (credentials != null &&
            credentials.getUserName().equals(userName) &&
            credentials.getPwd().equals(pwd)) {
            return "BankUserInterface";
        } else {
        	List<EmployeeCredentials> allEmployeeCreentials=employeeCredentialsdao.fetchAll();
        	for(EmployeeCredentials a:allEmployeeCreentials) {
				String userCredentials=a.getUserName();
				String pwdCredentials=a.getPwd();
				if(userCredentials.equals(userName) && pwdCredentials.equals(pwd)) {
					System.out.println("credentials found");
				} else {
					model.addAttribute("authenticate", "User name and password are not valid");
					model.addAttribute("value",1);
				}
			}
        	for(EmployeeCredentials a:allEmployeeCreentials) {
				String userCredentials=a.getUserName();
				if(userCredentials.equals(userName)) {
					System.out.println("credentials found");
				} else {
					model.addAttribute("authenticate", "User name is not valid");
					model.addAttribute("value",2);
				}
			}
        	for(EmployeeCredentials a:allEmployeeCreentials) {
        		String pwdCredentials=a.getPwd();
				if(pwdCredentials.equals(pwd)) {
					System.out.println("credentials found");
				} else {
					model.addAttribute("authenticate", "Password is not valid");
					model.addAttribute("value",3);
				}
			}
        	return "WorkerLogin";
        }
    }
}