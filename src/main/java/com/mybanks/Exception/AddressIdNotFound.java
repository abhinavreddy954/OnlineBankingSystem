package com.mybanks.Exception;

public class AddressIdNotFound extends RuntimeException{
	private String msg="address id not found";

	public String getMsg() {
		return msg;
	}

}
