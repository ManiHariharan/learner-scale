package com.hari.haran.crackers.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * SubCategory is an entity class used for reading SubCategory information
 * 
 * @author HARIHARAN MANI
 * @since 14-12-2021
 */
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