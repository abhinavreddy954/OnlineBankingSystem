package com.mybanks.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybanks.dto.BankAccountsRequest;
import com.mybanks.repo.BankingAccountsReqRepo;


@Repository
public class BankAccountsRequestDao {
    @Autowired
    BankingAccountsReqRepo accountsRepo;

    public BankAccountsRequest saveBankAccountsRequest(BankAccountsRequest bankAccount) {
        return accountsRepo.save(bankAccount);
    }

    public BankAccountsRequest updateBankAccountsRequest(int bankId, BankAccountsRequest bankAccount) {
        bankAccount.setBankReqId(bankId);
        return accountsRepo.save(bankAccount);
    }
    

    public BankAccountsRequest findBankAccountsRequest(int bankId) {
        return accountsRepo.findById(bankId).orElse(null);
    }
    
    public BankAccountsRequest findBankAccountsRequestByUserName(String username) {
        return accountsRepo.findBankAccReqByUserName(username);
    }
    
    public List<BankAccountsRequest> findAllBankAccountsRequest() {
        return accountsRepo.findAll();
    }

    public BankAccountsRequest findBankAccReqByPhoneno(long phone) {
        return accountsRepo.findBankAccReqByPhoneno(phone);
    }

    public BankAccountsRequest deleteBankAccountsRequest(int bankId) {
        BankAccountsRequest bankAcc = findBankAccountsRequest(bankId);
        if (bankAcc != null) {
            accountsRepo.delete(bankAcc);
        }
        return bankAcc;
    }
}
