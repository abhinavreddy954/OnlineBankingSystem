package com.mybanks.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int addressId;
	private String streetName;
	private String cityName;
	private String country;
	private String ifscCode;
	
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetName=" + streetName + ", cityName=" + cityName
				+ ", country=" + country + ", ifscCode=" + ifscCode + "]";
	}
	
	
}
