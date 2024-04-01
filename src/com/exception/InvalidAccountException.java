package com.exception;

public class InvalidAccountException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	
	public InvalidAccountException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

