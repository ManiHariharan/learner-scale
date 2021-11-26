package com.hari.haran.crackers.app.exception;

import org.springframework.http.HttpStatus;

/**
 * MyRestException is an user-defined Exception Class for Rest error handling
 * 
 * @author HARIHARAN MANI
 * @since 17-11-2021
 */
public class MyRestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final HttpStatus httpStatusCode;
	private final String errorMessage;
	private final String errorCode;

	public MyRestException(HttpStatus httpStatus, String errorMessage) {
		super(errorMessage);
		this.httpStatusCode = httpStatus;
		this.errorMessage = errorMessage;
		this.errorCode = "h2-ERROR";
	}

	public MyRestException(HttpStatus httpStatus, String errorMessage, String errorCode) {
		super(errorMessage);
		this.httpStatusCode = httpStatus;
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public HttpStatus getMyHttpStatusCode() {
		return this.httpStatusCode;
	}

	public String getMyErrorCode() {
		return this.errorCode;
	}

	public String getMyErrorMsg() {
		return this.errorMessage;
	}
}