package com.mybanks.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mybanks.dto.EmployeeCredentials;
import com.mybanks.dto.InternetBankingRegistration;

@Repository
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private InternetBankingRegistrationDao bankingRegistrationDao;

    @Autowired
    private EmployeeCredentialsdao employeeCredentialsdao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //  Check Employee first
        EmployeeCredentials employee =
                employeeCredentialsdao.fetchByUserName(username);

        if (employee != null) {
            return User.builder()
                    .username(employee.getUserName())
                    .password(employee.getPwd()) // must be BCrypt encoded
                    .roles("EMPLOYEE")
                    .build();
        }

        //  Else check normal user
        InternetBankingRegistration user =
                bankingRegistrationDao.fetchIBRByUsername(username);


        if (user != null) {
            return User.builder()
                    .username(user.getUserName())
                    .password(user.getPswd()) // must be BCrypt encoded
                    .roles("USER")
                    .build();
        }

        throw new UsernameNotFoundException("User not found");
    }
}


