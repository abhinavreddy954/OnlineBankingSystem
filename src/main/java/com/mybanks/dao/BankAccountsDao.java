package com.mybanks.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybanks.dto.BankAccounts;
import com.mybanks.repo.BankAccountsRepo;
import java.util.Optional;


@Repository
public class BankAccountsDao {
	@Autowired
	BankAccountsRepo accountsRepo;
	
	 
	public BankAccounts saveBankAccounts(BankAccounts bankAccount) {
		return accountsRepo.save(bankAccount);
	}
	
	public BankAccounts updateBankAccounts(int bankId,BankAccounts bankAccount) {
		bankAccount.setBankId(bankId);
		BankAccounts accounts=accountsRepo.save(bankAccount);
		return accounts;
	}
	
	public Optional<BankAccounts> findBankAccounts(int bankId) {
		Optional<BankAccounts> bankAcc=accountsRepo.findById(bankId);
		System.out.println(bankAcc);
		return bankAcc;
	}
	
	public BankAccounts findBankAccByPhoneno(long phone) {
		BankAccounts bankAcc=accountsRepo.findBankAccByPhoneno(phone);
		return bankAcc;
	}
	
	public BankAccounts findBankAccByAccNo(long accNo) {
		BankAccounts bankAcc=accountsRepo.findBankAccbyAccNo(accNo);
		return bankAcc;
	}
	
//	public BankAccounts findBankAccByaccountsRequest(BankAccountsRequest accountsRequest) {
//		return accountsRepo.findBankAccByaccountsRequest(accountsRequest);
//	}
	
	public List<BankAccounts> findAllBankAccounts() {
		List<BankAccounts> bankAcc=accountsRepo.findAll();
		return bankAcc;
	}
	
	public BankAccounts deleteBankAccounts(int bankId) {
		BankAccounts bankAcc=findBankAccounts(bankId).get();
		accountsRepo.delete(bankAcc);
		return bankAcc;
	}
	
	public BankAccounts findBankAccByUsername(String Username) {
		BankAccounts bankAcc= accountsRepo.findBankAccByUsername(Username);
		return bankAcc;		
	}
}
