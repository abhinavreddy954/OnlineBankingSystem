package com.mybanks.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BankAccountsRequest {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int bankReqId;
	private String schemeType;
	private String salutation;
	private String userfullname;
	private String userName;
	private String fatherName;
	private String motherName;
	private String gender;
	private String dateOfBirth;
	private long mobileNo;
	private String emailId;
	private String state;
	private String district;
	private int branchID;
	private double amountdeposited;
	
	public double getAmountdeposited() {
		return amountdeposited;
	}
	public void setAmountdeposited(double amountdeposited) {
		this.amountdeposited = amountdeposited;
	}
	public String getSchemeType() {
		return schemeType;
	}
	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getBranchID() {
		return branchID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	public int getBankReqId() {
		return bankReqId;
	}
	public void setBankReqId(int bankReqId) {
		this.bankReqId = bankReqId;
	}
	public String getUserfullname() {
		return userfullname;
	}
	public void setUserfullname(String userfullname) {
		this.userfullname = userfullname;
	}
	@Override
	public String toString() {
		return "BankAccountsRequest [bankReqId=" + bankReqId + ", schemeType=" + schemeType + ", salutation="
				+ salutation + ", userfullname=" + userfullname + ", userName=" + userName + ", fatherName="
				+ fatherName + ", motherName=" + motherName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", state=" + state + ", district=" + district
				+ ", branchID=" + branchID + ", amountdeposited=" + amountdeposited + "]";
	}
	
	
	
	
	
}