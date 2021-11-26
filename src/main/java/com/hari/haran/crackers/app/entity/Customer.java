package com.hari.haran.crackers.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Customer is an Entity having Customer information.
 * 
 * @author HARIHARAN MANI
 * @since 17-11-2021
 */
@Data
public class Customer {

	@JsonProperty("CustomerId")
	private int customerId;

	@JsonProperty("FirstName")
	private String firstName;

	@JsonProperty("LastName")
	private String lastName;

	@JsonProperty("FullName")
	private String fullName;

	@JsonProperty("AddressOne")
	private String addressOne;

	@JsonProperty("AddressTwo")
	private String addressTwo;

	@JsonProperty("Town")
	private String town;

	@JsonProperty("Country")
	private String country;

	@JsonProperty("RegionId")
	private int regionId;

	@JsonProperty("Region")
	private String region;

	@JsonProperty("ZipCode")
	private String zipCode;

	@JsonProperty("Mobile")
	private int mobile;

	@JsonProperty("CreditCard")
	private int creditCard;

	@JsonProperty("Email")
	private String eMail;

	@JsonProperty("Password")
	private String password;

}
