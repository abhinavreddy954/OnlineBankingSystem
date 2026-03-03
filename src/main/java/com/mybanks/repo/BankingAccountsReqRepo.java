package com.mybanks.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mybanks.dto.BankAccountsRequest;

@Repository // ✅ Ensure this annotation is present
public interface BankingAccountsReqRepo extends JpaRepository<BankAccountsRequest, Integer> {

    @Query("SELECT b FROM BankAccountsRequest b WHERE b.mobileNo = :phone")
    BankAccountsRequest findBankAccReqByPhoneno(@Param("phone") long phone);
    
    @Query("SELECT b FROM BankAccountsRequest b WHERE b.userName = :username")
    BankAccountsRequest findBankAccReqByUserName(@Param("username") String username);
}
