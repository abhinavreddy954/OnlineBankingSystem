package com.mybanks.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;

@Entity
public class InternetBankingRegistration {
	@Id
	private long phone;
	@Column(unique = true)
	private String userName;
	private String pswd;
	private String retypepswd;
	private String email;
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getRetyprpswd() {
		return retypepswd;
	}
	public void setRetyprpswd(String retyprpswd) {
		this.retypepswd = retyprpswd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "InternetBankingRegistration [phone=" + phone + ", userName=" + userName + ", pswd=" + pswd
				+ ", retyprpswd=" + retypepswd + ", email=" + email + "]";
	}
	
	
}
