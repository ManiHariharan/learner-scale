package com.hari.haran.crackers.app.exception;

/**
 * MyCustomException is an user-defined Exception Class for Custom Errors
 * 
 * @author HARIHARAN MANI
 * @since 20-11-2021
 */
public class MyCustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String errorMessage;
	private final String exceptionMsg;

	public MyCustomException(String errorMessage, Exception excp) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.exceptionMsg = excp.getMessage();
	}

	public String getMyErrorMsg() {
		return this.errorMessage;
	}

	public String getExceptionMsg() {
		return this.exceptionMsg;
	}
}