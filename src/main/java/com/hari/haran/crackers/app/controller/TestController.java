package com.hari.haran.crackers.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.haran.crackers.app.cons.URLCons;
import com.hari.haran.crackers.app.support.AppHtmlUtils;

/**
 * TestController is a REST Controller for handling REST webService requests
 * 
 * @author HARIHARAN MANI
 * @since 17-11-2021
 */
@RestController
public class TestController {

	@GetMapping({ "/", URLCons.URL_HEALH_INDEX })
	public String showIndex() {
		return AppHtmlUtils.HEALTH_PAGE;
	}
}