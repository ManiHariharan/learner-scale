package com.hari.haran.crackers.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SubCategory {

	@JsonProperty("SubCategoryId")
	private String subCategoryId;

	@JsonProperty("CategoryId")
	private String categoryId;

	@JsonProperty("SubCategoryName")
	private String subCategoryName;

	@JsonProperty("Description")
	private String description;

	public SubCategory(String subCategoryId, String categoryId, String name, String description) {
		this.setSubCategoryId(subCategoryId);
		this.setCategoryId(categoryId);
		this.setSubCategoryName(name);
		this.setDescription(description);
	}
}