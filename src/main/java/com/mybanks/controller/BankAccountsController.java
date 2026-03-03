package com.mybanks.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybanks.dao.BankAccountsDao;
import com.mybanks.dto.Address;
import com.mybanks.dto.BankAccounts;
import com.mybanks.service.AddressService;
import com.mybanks.service.BankingAccountsRequestService;
import com.mybanks.util.ResponseStructure;

import jakarta.servlet.http.HttpServletRequest;
import modeldata.BankAccData;
import modeldata.SendMoney;

@Controller
@RequestMapping({"/customer", "/employee"})
public class BankAccountsController {

    @Autowired
    private BankingAccountsRequestService accountsRequestService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private BankAccountsDao accountsDao;

    @PostMapping("/BankAccountsController")
    public String handleBankAcc(@ModelAttribute("BankAccData") BankAccData bankaccdata, Model model) {

        try {
            System.out.println("BankReqId received: " + bankaccdata.getBankReqId());

            BankAccounts bankAccounts = new BankAccounts();
            bankAccounts.setBankAccNo(bankaccdata.getAccNo());

            String rawBal = bankaccdata.getBal();
            if (rawBal != null) {
                rawBal = rawBal.replaceAll("[^0-9.]", "");
                double bal = Double.parseDouble(rawBal);
                double realbal= bal-(2*bal);
                bankAccounts.setBalance(realbal);
                System.out.println("Cleaned balance: " + realbal);
            }

            bankAccounts.setUsername(bankaccdata.getUsername());
            bankAccounts.setDateOfBirth(bankaccdata.getDob());
            bankAccounts.setEmailId(bankaccdata.getEmailId());
            bankAccounts.setFatherName(bankaccdata.getFatherName());
            bankAccounts.setGender(bankaccdata.getGender());
            bankAccounts.setMobileNo(bankaccdata.getMobileno());
            bankAccounts.setMotherName(bankaccdata.getMotherName());
            bankAccounts.setSalutation(bankaccdata.getSalutation());
            bankAccounts.setSchemeType(bankaccdata.getScheme());
            bankAccounts.setState(bankaccdata.getState());
            bankAccounts.setDistrict(bankaccdata.getDistrict());
            bankAccounts.setUserfullname(bankaccdata.getUserfullname());

           
            bankAccounts.setBankReqId(bankaccdata.getBankReqId());

            // Fetch address
            ResponseStructure<Address> addressStructure =
                    addressService.fetchAddressById(bankaccdata.getAddressId());
            bankAccounts.setAddress(addressStructure.getData());

            // Save
            accountsDao.saveBankAccounts(bankAccounts);

            // Delete request
            accountsRequestService.deleteBankAccountsRequest(bankaccdata.getBankReqId());

            model.addAttribute("key", "Account details saved successfully!");
            return "Output";

        } catch (Exception e) {
            model.addAttribute("key", "Error saving account: " + e.getMessage());
            e.printStackTrace();
            return "Output";
        }
    }
    
    @PostMapping("/sendmoney")
    public String sendMoney(@ModelAttribute SendMoney sendMoney,Model model) {

       
        int senderAccountId = sendMoney.getAccountIdSender();
        double amount = sendMoney.getAmount();
        long receiverAccountNo= sendMoney.getReceiverAccountNo();
//    	int senderAccountId= Integer.parseInt(request.getParameter("accountId"));
//    	long receiverPhone= 

      
        Optional<BankAccounts> senderAccount =
                accountsDao.findBankAccounts(senderAccountId);

        if (senderAccount.isEmpty()) {
            model.addAttribute("key", "Sender account not found");
            return "BankAccountDetails";
        }

        BankAccounts sender = senderAccount.get();  

      
        BankAccounts receiver = accountsDao.findBankAccByAccNo(receiverAccountNo);
        if (receiver == null) {
            model.addAttribute("key", "Receiver account not found");
            return "BankAccountDetails";
        }

        
        Address address = receiver.getAddress();
        if (address == null
                || receiverAccountNo != (long) receiver.getBankAccNo()  || receiverAccountNo == sender.getBankAccNo()	
               ) {
            model.addAttribute("key", "Receiver details do not match or sender and receiver account number is sane");
            return "BankAccountDetails";
        }

    
        if (sender.getBalance() < amount && sender.getBalance() <= 500) {
            model.addAttribute("key", "Insufficient balance");
            return "BankAccountDetails";
        }

       
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountsDao.updateBankAccounts(sender.getBankId(), sender);
        accountsDao.updateBankAccounts(receiver.getBankId(), receiver);

        
        model.addAttribute("account", sender);
        model.addAttribute("successRequest", "Amount transferred successfully");

        return "BankAccountDetails";
    }

}
