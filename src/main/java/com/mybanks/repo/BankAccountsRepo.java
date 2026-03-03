package com.mybanks.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mybanks.dto.BankAccounts;

public interface BankAccountsRepo extends JpaRepository<BankAccounts, Integer>{
	@Query("select b from BankAccounts b where b.username=:username")
	BankAccounts findBankAccByUsername(@Param("username") String Username );
	
	@Query("select b from BankAccounts b where b.mobileNo=:phone")
	BankAccounts findBankAccByPhoneno(@Param("phone") long phone);
	
	@Query("select b from BankAccounts b where b.bankAccNo=:accNo")
	BankAccounts findBankAccbyAccNo(@Param("accNo") long accNo);
}