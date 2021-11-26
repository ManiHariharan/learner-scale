package com.hari.haran.crackers.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductPaginData {

	@JsonProperty("Products")
	private Product[] products;

	@JsonProperty("ProductCount")
	private int productCount;

	public ProductPaginData(Product[] products) {
		this.setProducts(products);
		this.setProductCount(products.length);
	}

}
