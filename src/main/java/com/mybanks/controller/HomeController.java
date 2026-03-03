package com.mybanks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String welcome() {
        return "welcome"; 
    }
    
    @GetMapping("/home")
    public String home() {
        return "home"; 
    }
    
    
	@GetMapping("/worker/login")
	public String workerLogin() {
	    return "WorkerLogin"; 
	}
	
	@GetMapping("/user/login")
	public String userLogin(HttpSession session) {
	    return "UserLogin"; 
	}

	@GetMapping("/ibr")
	public String NewIBR() {
	    return "NewUserIBR"; 
	}
	
	
//	@GetMapping("/customer")
//	public String customerPage() {
//	    return "UserInterface";
//	}

}