package com.mybanks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybanks.dao.BankAccountsRequestDao;
import com.mybanks.dto.BankAccountsRequest;
import modeldata.BankAccSaveRequestDatamodel;
import modeldata.FetchBankAccRequestDataModel;

@Controller
@RequestMapping({"/customer", "/employee"})
public class BankAccountsSaveRequestController {

    @Autowired
    private BankAccountsRequestDao accountsRequestDao;

    @PostMapping("/newacc")  // use POST instead of GET for form submission
    protected String saveBankAccRequest(@ModelAttribute("BankAccSaveRequestDatamodel") BankAccSaveRequestDatamodel accRequestDatamodel,Model model) {

        System.out.println("BankAccountsSaveRequestController: Received a request for /newacc");
        
        String schemeType = accRequestDatamodel.getAcc_selection();
        String salutation = accRequestDatamodel.getSalutation();
        String userFullName= accRequestDatamodel.getUserfullname();
        String userName = accRequestDatamodel.getUsername();
        String fatherName = accRequestDatamodel.getFathername();
        String motherName = accRequestDatamodel.getMothername();
        String gender = accRequestDatamodel.getGender();
        String dateOfBirth = accRequestDatamodel.getDob();
        long mobileNo = accRequestDatamodel.getMobile();
        String emailId = accRequestDatamodel.getEmail();
        String state = accRequestDatamodel.getState();
        String district = accRequestDatamodel.getDistrict();
        int branchID = accRequestDatamodel.getBranchId();
        double amountdeposited= accRequestDatamodel.getAmount();

        System.out.println(branchID + " " + gender);

        BankAccountsRequest accountsRequest = new BankAccountsRequest();
        accountsRequest.setBranchID(branchID);
        accountsRequest.setDateOfBirth(dateOfBirth);
        accountsRequest.setDistrict(district);
        accountsRequest.setEmailId(emailId);
        accountsRequest.setFatherName(fatherName);
        accountsRequest.setGender(gender);
        accountsRequest.setMobileNo(mobileNo);
        accountsRequest.setMotherName(motherName);
        accountsRequest.setSalutation(salutation);
        accountsRequest.setSchemeType(schemeType);
        accountsRequest.setState(state);
        accountsRequest.setUserName(userName);
        accountsRequest.setAmountdeposited(amountdeposited);
        accountsRequest.setUserfullname(userFullName);

        BankAccountsRequest accountsRequest2 = accountsRequestDao.saveBankAccountsRequest(accountsRequest);

        if (accountsRequest2 != null) {
            model.addAttribute("successRequest","Bank account request is successful. Once accepted, you will be notified.");
            return "UserInterface";
        } else {
            model.addAttribute("key","New bank account request failed. Please try again filling all mandatory details.");
            return "NewAcc";
        }
    }
    
    @PostMapping("/fetchbankaccountrequest")
    protected String saveBankAccRequest(@ModelAttribute("FetchBankAccRequestDataModel") FetchBankAccRequestDataModel fetchBankAccRequestDataModel,Model model) {
    	String userName= fetchBankAccRequestDataModel.getUn();
    	String pwd= fetchBankAccRequestDataModel.getPwd();
    	int bankReqId= fetchBankAccRequestDataModel.getAccountRequestId();
    	
    	BankAccountsRequest accountsRequest=accountsRequestDao.findBankAccountsRequest(bankReqId);
    	if(accountsRequest != null) {
    		String userFullName = accountsRequest.getUserfullname();
    	    String email = accountsRequest.getEmailId();
    	    double amount = accountsRequest.getAmountdeposited();
    	    
    	    model.addAttribute("name", userFullName);
    	    model.addAttribute("email", email);
    	    model.addAttribute("amount",amount);
    	    model.addAttribute("bankReqId", bankReqId);
    	    model.addAttribute("accountsRequest", accountsRequest);
    	    System.out.println("accounts request fetched successfully");
    	    return "BankAccountDetails";
    	}
    	else {
    		model.addAttribute("key", "Bank accounts request unable to fetch, something went wrong..!");
    	    return "BankAccountDetails";
    	}
    }
    
    @PostMapping("/accountsrequest")
	public String updateAddress() {
	    return "accountsrequest";  
	}
    
}