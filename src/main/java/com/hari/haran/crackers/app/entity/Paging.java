package com.hari.haran.crackers.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Paging {

	@JsonProperty("SubCategoryId")
	private String subCategoryId;

	@JsonProperty("SubCategoryName")
	private String subCategoryName;

	@JsonProperty("CategoryId")
	private String categoryId;

	@JsonProperty("CategoryName")
	private String categoryName;

	@JsonProperty("PageSize")
	private int pageSize;

	@JsonProperty("PageNumber")
	private int pageNumber;

	@JsonProperty("CurrentPage")
	private int currentPage;

	@JsonProperty("SearchString")
	private String searchString;

	@JsonProperty("IsAllWords")
	private boolean isAllWords;

}
