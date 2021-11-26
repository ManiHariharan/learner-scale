package com.hari.haran.crackers.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hari.haran.crackers.app.cons.SettingCons;
import com.hari.haran.crackers.app.cons.URLCons;
import com.hari.haran.crackers.app.entity.Customer;
import com.hari.haran.crackers.app.entity.Paging;
import com.hari.haran.crackers.app.entity.Product;
import com.hari.haran.crackers.app.entity.ProductPaginData;
import com.hari.haran.crackers.app.exception.MyRestException;
import com.hari.haran.crackers.app.support.JsonUtils;

/**
 * AngularController is a REST Controller for handling Angular requests
 * 
 * @author HARIHARAN MANI
 * @since 17-11-2021
 */
@RestController
@RequestMapping(value = URLCons.PREFIX_API_ANGULAR, produces = URLCons.JSON_UTF8_ENCODING)
@CrossOrigin(origins = { SettingCons.PRODUCTION_SERVER, SettingCons.STAGING_SERVER, SettingCons.LOCAL_SERVER })
public class AngularController {

	@PostMapping(path = URLCons.URL_LOGIN_CHECK, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer authenticateLogin(@RequestParam(name = "user_name") String userName,
			@RequestParam(name = "pass_key") String passKey) {
		if (userName.equals("hari") && passKey.equals("hari")) {
			Customer customerInfo = new Customer();
			customerInfo.setCustomerId(12);
			customerInfo.setFirstName("HARIHARAN");
			customerInfo.setLastName("MANI");
			customerInfo.setFullName("HARIHARAN MANI");

			customerInfo.setAddressOne("");
			customerInfo.setAddressTwo("");
			customerInfo.setTown("");
			customerInfo.setCountry("INDIA");
			customerInfo.setRegionId(100);
			customerInfo.setRegion("TAMIL NADU");
			customerInfo.setZipCode("624620");
			customerInfo.setMobile(12345);
			customerInfo.setCreditCard(98765);

			customerInfo.setEMail("hariharan.12bit2019@mkce.ac.in");
			customerInfo.setPassword("Pass@123");
			return customerInfo;
		}

		throw new MyRestException(HttpStatus.UNAUTHORIZED, "Invalid Credentials");
	}

	@GetMapping(path = URLCons.URL_GET_CATEGORIES)
	public String getCategories() {
		return JsonUtils.getCategories();
	}

	@GetMapping(path = URLCons.URL_GET_DEPARTMENTS)
	public String getDepartments() {
		return JsonUtils.getDepartments();
	}

	@GetMapping(path = URLCons.URL_GET_PRODUCT_DETAILS)
	public Product getProductDetails(@RequestParam(name = "product_id") String productId) {
		return JsonUtils.getProductById(productId);
	}

	@PostMapping(path = URLCons.URL_GET_FILTERED_PRODUCTS)
	public ProductPaginData getFilteredProducts(@RequestBody Paging paging) {
		return new ProductPaginData(JsonUtils.getProductArray(paging));
	}
}