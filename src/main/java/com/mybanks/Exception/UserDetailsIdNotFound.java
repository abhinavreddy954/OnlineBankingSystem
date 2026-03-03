package com.mybanks.Exception;

public class UserDetailsIdNotFound extends RuntimeException {
	private String message="User id is not found the DB";

	public String getMessage() {
		return message;
	}
}
