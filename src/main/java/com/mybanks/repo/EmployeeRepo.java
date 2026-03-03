package com.mybanks.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mybanks.dto.EmployeeCredentials;

public interface EmployeeRepo extends JpaRepository<EmployeeCredentials, Integer> {
	@Query("select e from EmployeeCredentials e where e.userName=:un and e.pwd=:pwd")
	EmployeeCredentials fetchByCredentials(@Param("un") String un,@Param("pwd") String pwd);
	
	@Query("select e from EmployeeCredentials e where e.userName=:un")
	EmployeeCredentials fetchByUserName(@Param("un") String un);
}