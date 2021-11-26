package com.hari.haran.crackers.app.entity.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductJson {

	@JsonProperty("product_id")
	private String productId;

	@JsonProperty("category_id")
	private String categoryId;

	@JsonProperty("sub_category_id")
	private String subCategoryId;

	@JsonProperty("product_name")
	private String productName;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("mrp_price")
	private int mrpPrice;

	@JsonProperty("discount_rate")
	private int discountRate;

	@JsonProperty("primary_image")
	private String primaryImage;

	@JsonProperty("secondary_image")
	private String secondaryImage;

	@JsonProperty("thumb_nail")
	private String thumbNail;

	@JsonProperty("is_display")
	private int display;

}
