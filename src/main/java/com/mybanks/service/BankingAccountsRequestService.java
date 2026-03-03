package com.mybanks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mybanks.Exception.BankingAccountsRequestIdNotFound;
import com.mybanks.dao.BankAccountsRequestDao;
import com.mybanks.dto.BankAccountsRequest;
import com.mybanks.util.ResponseStructure;
import com.mybanks.util.ResponseStructureList;


@Service
public class BankingAccountsRequestService {
	@Autowired
	BankAccountsRequestDao accountsRequestDao;
	@Autowired
	ResponseStructure<BankAccountsRequest> responseStructure;
	@Autowired
	ResponseStructureList<BankAccountsRequest> responseStructureList;
	
	
	public ResponseStructure<BankAccountsRequest> saveBankAccountsRequest(BankAccountsRequest bankAccount) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully new bank account created and inserted into DB");
		responseStructure.setData(accountsRequestDao.saveBankAccountsRequest(bankAccount));
		return responseStructure;
	}
	
	public ResponseStructure<BankAccountsRequest> updateBankAccountsRequest(int bankId,BankAccountsRequest bankAccount) {
		BankAccountsRequest b=accountsRequestDao.findBankAccountsRequest(bankId);
		if(b!=null) {
			 responseStructure.setStatusCode(HttpStatus.FOUND.value());
	      	 responseStructure.setMessage("successfully data is fetched from DB");
	      	 responseStructure.setData(accountsRequestDao.updateBankAccountsRequest(bankId, bankAccount));
	      	 return responseStructure;
		}
		else {
			throw new BankingAccountsRequestIdNotFound();
		}
	}
	
	public ResponseStructure<BankAccountsRequest> findBankAccountsRequest(int bankId) {
		BankAccountsRequest b=accountsRequestDao.findBankAccountsRequest(bankId);
		if(b!=null) {
      	 responseStructure.setStatusCode(HttpStatus.FOUND.value());
      	 responseStructure.setMessage("successfully data is fetched from DB");
      	 responseStructure.setData(accountsRequestDao.findBankAccountsRequest(bankId));
      	 return responseStructure;
		}
		else {
			throw new BankingAccountsRequestIdNotFound();
		}
	}
	
	public ResponseStructureList<BankAccountsRequest> findAllBankAccountsRequest() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully fetched all bank account request from DB");
		responseStructureList.setData(accountsRequestDao.findAllBankAccountsRequest());
		return responseStructureList;
	}
	
	public ResponseStructure<BankAccountsRequest> findBankAccReqByPhoneno(long phone) {
		BankAccountsRequest b=accountsRequestDao.findBankAccReqByPhoneno(phone);
		if(b!=null) {
      	 responseStructure.setStatusCode(HttpStatus.FOUND.value());
      	 responseStructure.setMessage("successfully data is fetched from DB");
      	 responseStructure.setData(accountsRequestDao.findBankAccReqByPhoneno(phone));
      	 return responseStructure;
		}
		else {
			throw new BankingAccountsRequestIdNotFound();
		}
	}
	
	public ResponseStructure<BankAccountsRequest> deleteBankAccountsRequest(int bankId) {
		BankAccountsRequest b=accountsRequestDao.findBankAccountsRequest(bankId);
		if(b!=null) {
      	 responseStructure.setStatusCode(HttpStatus.OK.value());
      	 responseStructure.setMessage("successfully data is deleted from DB");
      	 responseStructure.setData(accountsRequestDao.deleteBankAccountsRequest(bankId));
      	 return responseStructure;
		}
		else {
			throw new BankingAccountsRequestIdNotFound();
		}
	}
}
