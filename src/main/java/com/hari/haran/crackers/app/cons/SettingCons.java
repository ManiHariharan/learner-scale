package com.hari.haran.crackers.app.cons;

/**
 * SettingCons is a constant class used for all h2JsonApp inputs.
 * 
 * @author HARIHARAN MANI
 * @since 17-11-2021
 */
public class SettingCons {

	/**
	 * SettingCons() is a private constructor to hide the implicit public one.
	 */
	private SettingCons() {
		throw new IllegalStateException();
	}

	public static final String APP_NAME = "h2-eCommerce";
	public static final String APP_VERSION = "1.0";
	public static final String APP_BUILD_NO = "b01";

	public static final String PRODUCTION_SERVER = "https://h2-ecommerce-backend.herokuapp.com";
	public static final String STAGING_SERVER = "https://h2-krishiv-staging.herokuapp.com";
	public static final String LOCAL_SERVER = "http://localhost:6200";

	public static final int DEF_DISCOUNT_RATE = 55;

}