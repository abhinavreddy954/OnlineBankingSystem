package com.mybanks.Exception;

public class BankingAccountsRequestIdNotFound extends RuntimeException{
	private String message="bank account request id is not found the DB";

	public String getMessage() {
		return message;
	}
}
