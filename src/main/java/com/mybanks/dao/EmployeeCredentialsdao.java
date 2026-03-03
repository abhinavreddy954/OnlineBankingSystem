package com.mybanks.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybanks.dto.EmployeeCredentials;
import com.mybanks.repo.EmployeeRepo;

@Repository
public class EmployeeCredentialsdao {
	@Autowired
	EmployeeRepo employeeRepo;

	
	public EmployeeCredentials fetchByCredentials(String un,String pwd) {
		EmployeeCredentials credentials=employeeRepo.fetchByCredentials(un, pwd);
		return credentials;
	}
	
	public List<EmployeeCredentials> fetchAll() {
		List<EmployeeCredentials> credentials=employeeRepo.findAll();
		return credentials;
	}
	
	public EmployeeCredentials fetchByUserName(String un) {
		return employeeRepo.fetchByUserName(un);
	}
	
	public EmployeeCredentials saveEmployeeCredentials(EmployeeCredentials emp) {
		return employeeRepo.save(emp);
	}
	
}
