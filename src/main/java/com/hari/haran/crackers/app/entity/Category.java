package com.hari.haran.crackers.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Category {

	@JsonProperty("CategoryId")
	private String categoryId;

	@JsonProperty("CategoryName")
	private String categoryName;

	@JsonProperty("Description")
	private String description;
}