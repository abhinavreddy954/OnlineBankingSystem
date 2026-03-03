 package com.mybanks.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybanks.dto.InternetBankingRegistration;
import com.mybanks.repo.InternetBankingRegistrationRepo;

@Repository
public class InternetBankingRegistrationDao {
	
	@Autowired
	InternetBankingRegistrationRepo bankingRegistrationRepo;
	
	InternetBankingRegistration reg = new InternetBankingRegistration();
	long phone = reg.getPhone();
	
	public boolean saveIBR(InternetBankingRegistration internetBankingRegistration) {
		boolean exists = bankingRegistrationRepo.existsById(phone);
		if(exists == false) {
			bankingRegistrationRepo.save(internetBankingRegistration);
			return true;
		}
		else {
			return false;
		}
	}

	
	public InternetBankingRegistration updateIBR(long phone,InternetBankingRegistration internetBankingRegistration) {
		internetBankingRegistration.setPhone(phone);
		InternetBankingRegistration updateBankingRegistration=bankingRegistrationRepo.save(internetBankingRegistration);
		return updateBankingRegistration;
	}
	
	public InternetBankingRegistration updateIBR(String username,InternetBankingRegistration internetBankingRegistration) {
		internetBankingRegistration.setUserName(username);
		InternetBankingRegistration updateBankingRegistration=bankingRegistrationRepo.save(internetBankingRegistration);
		return updateBankingRegistration;
	}
	
	public void deleteIBR(long phone) {
		InternetBankingRegistration bankingRegistration=fetchIBRById(phone);
		bankingRegistrationRepo.delete(bankingRegistration);
	}
	
	public InternetBankingRegistration fetchIBRById(long phone) {
		return bankingRegistrationRepo.findById(phone).get();
	}
	
	public InternetBankingRegistration fetchIBRByUsername(String username) {
		return bankingRegistrationRepo.findIBRByUserName(username);
	}
	
	public List<InternetBankingRegistration> fetchAllIBR() {
		return bankingRegistrationRepo.findAll();
	}
	
	public InternetBankingRegistration findIBRBYUseNameOREmailORPhone(String username,long phone, String email) {
		return bankingRegistrationRepo.findIBRBYUseNameOREmailORPhone(username, phone, email);
	}
	
	
}
