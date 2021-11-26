package com.hari.haran.crackers.app.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.haran.crackers.app.support.AppHtmlUtils;

/**
 * MyErrorController is a user defined controller for handling h2JsonApp Errors
 * 
 * @author HARIHARAN MANI
 * @since 17-11-2021
 */
@RestController
public class MyErrorController implements ErrorController {

	@RequestMapping(value = "/error")
	public String myError() {
		return AppHtmlUtils.ERROR_PAGE;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}