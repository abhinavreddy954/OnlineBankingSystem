package com.mybanks.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mybanks.dto.InternetBankingRegistration;


public interface InternetBankingRegistrationRepo extends JpaRepository<InternetBankingRegistration,Long> {
	@Query("SELECT i FROM InternetBankingRegistration i WHERE i.userName = :userName")
	InternetBankingRegistration findIBRByUserName(@Param("userName") String userName);
	
	@Query("select i from InternetBankingRegistration i where i.userName =:userName OR i.phone =:phone OR i.email =:email")
	InternetBankingRegistration findIBRBYUseNameOREmailORPhone(@Param("userName") String userName, @Param("phone") long phone, @Param("email") String email);
}