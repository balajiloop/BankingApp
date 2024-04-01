package com.exception;

public class DatabasrConnectionException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	
	public DatabasrConnectionException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}