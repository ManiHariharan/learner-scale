package com.hari.haran.crackers.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * ProductPaginData is an entity class containing product list with count
 * 
 * @author HARIHARAN MANI
 * @since 14-12-2021
 */
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
