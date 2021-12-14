package com.hari.haran.crackers.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Category is an entity class used for reading Category input
 * 
 * @author HARIHARAN MANI
 * @since 14-12-2021
 */
@Data
public class Category {

	@JsonProperty("CategoryId")
	private String categoryId;

	@JsonProperty("CategoryName")
	private String categoryName;

	@JsonProperty("Description")
	private String description;
}