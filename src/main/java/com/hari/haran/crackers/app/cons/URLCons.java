package com.hari.haran.crackers.app.cons;

/**
 * URLCons is a constant class used for maintaining all JSP file names and URLs.
 * 
 * @author HARIHARAN MANI
 * @since 15-11-2019
 */
public class URLCons {

	/**
	 * This is a private constructor to hide the implicit public one.
	 */
	private URLCons() {
		throw new IllegalStateException();
	}

	public static final String URL_HEALH_INDEX = "health";

	public static final String JSON_UTF8_ENCODING = "application/json; charset=UTF-8"; // for JSON AJAX response

	public static final String PREFIX_API_ANGULAR = "/api/h2p/v1/";
	public static final String URL_LOGIN_CHECK = "authenticateLogin";
	public static final String URL_USER_LOGOUT = "userLogOut";

	public static final String URL_GET_CATEGORIES = "getCategories";
	public static final String URL_GET_DEPARTMENTS = "getDepartments";
	public static final String URL_GET_FILTERED_PRODUCTS = "getFilteredProducts";
	public static final String URL_GET_PRODUCT_DETAILS = "getProductDetails";

}