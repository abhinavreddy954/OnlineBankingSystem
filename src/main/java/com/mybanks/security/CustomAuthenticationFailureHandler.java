package com.mybanks.security;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request,
//                                        HttpServletResponse response,
//                                        AuthenticationException exception)
//            throws IOException, ServletException {
//
//        if (exception instanceof UsernameNotFoundException) {
//            response.sendRedirect("/user/login?error=username");
//        } else if (exception instanceof BadCredentialsException) {
//            response.sendRedirect("/user/login?error=password");
//        } else {
//            response.sendRedirect("/user/login?error=true");
//        }
//    }
//}

	@Override
	public void onAuthenticationFailure(
	        HttpServletRequest request,
	        HttpServletResponse response,
	        AuthenticationException exception)
	        throws IOException {

	    String errorMessage;
	    String errorField;
	    String loginPage;

	    if (exception instanceof UsernameNotFoundException) {
	        errorMessage = "Username not found!";
	        errorField = "username";
	    } 
	    else if (exception instanceof BadCredentialsException) {
	        errorMessage = "Incorrect password!";
	        errorField = "password";
	    } 
	    else {
	        errorMessage = "Authentication failed!";
	        errorField = "general";
	    }

	    // Detect which login URL was used
	    String uri = request.getRequestURI();

	    if (uri.contains("perform_workerlogin")) {
	        loginPage = "/worker/login";
	    } else {
	        loginPage = "/user/login";
	    }

	    request.getSession().setAttribute("errorMessage", errorMessage);
	    request.getSession().setAttribute("errorField", errorField);

	    response.sendRedirect(loginPage);
	}
}