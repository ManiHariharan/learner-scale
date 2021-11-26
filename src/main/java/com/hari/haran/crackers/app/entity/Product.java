package com.hari.haran.crackers.app.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hari.haran.crackers.app.cons.SettingCons;
import com.hari.haran.crackers.app.entity.json.ProductJson;

import lombok.Data;

@Data
public class Product {

	@JsonProperty("ProductId")
	private String productId;

	@JsonProperty("CategoryId")
	private String categoryId;

	@JsonProperty("CategoryName")
	private String categoryName;

	@JsonProperty("SubCategoryId")
	private String subCategoryId;

	@JsonProperty("SubCategoryName")
	private String subCategoryName;

	@JsonProperty("ProductName")
	private String productName;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("PrimaryImage")
	private String primaryImage;

	@JsonProperty("SecondaryImage")
	private String secondaryImage;

	@JsonProperty("Thumbnail")
	private String thumbnail;

	@JsonProperty("Display")
	private int display;

	@JsonProperty("MrpPrice")
	private int mrpPrice;

	@JsonProperty("DiscountPrice")
	private int discountPrice;

	@JsonProperty("DiscountPercent")
	private int discountPercent;

	@JsonProperty("ProductCount")
	private int productCount;

	public Product(ProductJson productJson, String categoryName, int productCount) {
		String productIdInput = productJson.getProductId();
		this.setProductId(productIdInput);
		this.setProductName(productJson.getProductName());
		this.setDescription(productJson.getDescription());

		this.setPrimaryImage(productJson.getPrimaryImage());
		this.setSecondaryImage(productJson.getSecondaryImage());
		this.setThumbnail(productJson.getThumbNail());
		this.setDisplay(productJson.getDisplay());

		int mrpAmount = productJson.getMrpPrice();
		int discountRate = productJson.getDiscountRate();
		discountRate = (discountRate == 0) ? SettingCons.DEF_DISCOUNT_RATE : discountRate;
		int discountAmount = (mrpAmount * discountRate) / 100;
		int netAmount = mrpAmount - discountAmount;

		this.setMrpPrice(mrpAmount);
		this.setDiscountPercent(discountRate);
		this.setDiscountPrice(netAmount);

		this.setProductCount(productCount);

		this.setCategoryId(productJson.getCategoryId());
		this.setCategoryName(categoryName);

		String categoryIdRef = Objects.toString(productJson.getSubCategoryId(), "");
		this.setSubCategoryId(categoryIdRef);
		this.setSubCategoryName(categoryIdRef.isEmpty() ? "" : "SOUND CRACKERS");
	}
}
