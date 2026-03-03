package com.mybanks.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping; 

//public class LogoutController { 
//	@GetMapping("/worker/logout")
//	public String workerlogout(HttpServletRequest request) {
//	    HttpSession session = request.getSession(false);
//	    if (session != null) {
//	        session.invalidate();
//	    }    
//			return "redirect:/worker/login"; 		
//	}
//	
//	@GetMapping("/user/logout")
//	public String userlogout(HttpServletRequest request) {
//	    HttpSession session = request.getSession(false);
//	    if (session != null) {
//	        session.invalidate();       
//	    }    
//	    
//	    Cookie cookie = new Cookie("JSESSIONID", null);
//        cookie.setPath("/");
//        cookie.setHttpOnly(true);
//        cookie.setMaxAge(0);
//        response.addCookie(cookie);
//			return "redirect:/user/login"; 		
//	}
//}

@Controller
public class LogoutController {

	@GetMapping("/u/logout")
    public String userLogout(HttpServletRequest request,
                                         HttpServletResponse response) {

        // Invalidate session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Remove JSESSIONID cookie
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        request.setAttribute("logout",0);
        return "redirect:/user/login";
    }
	
	
	@GetMapping("/w/logout")
    public String workerLogout(HttpServletRequest request,
                                         HttpServletResponse response) {

        // Invalidate session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Remove JSESSIONID cookie
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        request.setAttribute("logout",0);

        return "redirect:/worker/login";
    }
}



	
	
	

//@GetMapping("/worker/logout")
//public String workerlogout(HttpServletRequest request) {
//	int value= Integer.parseInt(request.getParameter("bankuserlogout"));
//    HttpSession session = request.getSession(false);
//    if (session != null) {
//        session.invalidate();
//    }
//    if(value==1) { 
//		return "redirect:/WorkerLogin.jsp"; 
//	} else { 
//		return "redirect:/UserLogin.jsp"; 
//	} 
//}
//	