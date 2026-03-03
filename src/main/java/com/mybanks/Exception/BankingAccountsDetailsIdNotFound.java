package com.mybanks.Exception;

public class BankingAccountsDetailsIdNotFound extends RuntimeException{
	private String message="bank account id is not found the DB";

	public String getMessage() {
		return message;
	}
}
