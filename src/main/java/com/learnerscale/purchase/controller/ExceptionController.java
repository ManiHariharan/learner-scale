package com.learnerscale.purchase.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * ExceptionController is a controller advice class used as an Error Handler
 * 
 * @author
 * @since 05-10-2021
 */
@ControllerAdvice
public class ExceptionController {

	@SuppressWarnings("unchecked")
	@ExceptionHandler(value = Exception.class)
	public <T> T showErrorPage(HttpServletRequest request, HttpServletResponse response, Exception exception) {
		return (T) ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}

	/**
	 * This method is used to handle invalid JSON input exceptions.
	 * 
	 * @param request
	 * @param exception
	 * @return restException
	 */
	@SuppressWarnings("unchecked")
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public <T> T jsonParseException(HttpMessageNotReadableException exception) {
		return (T) ResponseEntity.status(HttpStatus.BAD_REQUEST).body("JSON input error");
	}

	@SuppressWarnings("unchecked")
	@ExceptionHandler(value = NoHandlerFoundException.class)
	public <T> T showInvalidUrl() {
		return (T) ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid URL");
	}

	// Handle all required exceptions
}
