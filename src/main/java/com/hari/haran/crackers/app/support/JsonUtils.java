package com.hari.haran.crackers.app.support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hari.haran.crackers.app.controller.AngularController;
import com.hari.haran.crackers.app.entity.Category;
import com.hari.haran.crackers.app.entity.Paging;
import com.hari.haran.crackers.app.entity.Product;
import com.hari.haran.crackers.app.entity.json.ProductJson;

public class JsonUtils {

	private static final String JSON_FOLDER = "crackers";
	private static final String JSON_PATH_DEPARTMENT = JSON_FOLDER + "/CategoriesList.json";
	private static final String JSON_PATH_CATEGORIES = JSON_FOLDER + "/SubCategoriesList.json";
	private static final String JSON_PATH_PRODUCT = JSON_FOLDER + "/ProductList.json";

	private static String departmentString;
	private static String categoriesString;

	private static Product[] productArray;
	private static Map<String, Product> productMap;

	private static Map<String, Category> departmentMap;

	private JsonUtils() {
		throw new IllegalStateException();
	}

	private static String getJsonString(String jsonPath) {
		try (InputStream is = AngularController.class.getClassLoader().getResourceAsStream(jsonPath)) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			return reader.lines().collect(Collectors.joining(System.lineSeparator()));
		} catch (IOException e) {
			return "{}";
		}
	}

	private static Object getJsonList(String jsonPath) {
		JSONObject jsonObject = new JSONObject(getJsonString(jsonPath));
		return jsonObject.get("data");
	}

	public static String getDepartments() {
		if (departmentString == null) {
			loadCategoriesEntity();
		}
		return departmentString;
	}

	public static Map<String, Category> getCategoriesMap() {
		if (departmentMap == null) {
			loadCategoriesEntity();
		}
		return departmentMap;
	}

	public static String getCategories() {
		if (categoriesString == null) {
			categoriesString = getJsonList(JSON_PATH_CATEGORIES).toString();
		}
		return categoriesString;
	}

	private static Product[] getProductArray() {
		if (productArray == null) {
			loadProductEntity();
		}
		return productArray;
	}

	public static Product getProductById(String productId) {
		if (productMap == null) {
			loadProductEntity();
		}
		return productMap.get(productId);
	}

	public static Product[] getProductArray(Paging paging) {
		Product[] productArray = getProductArray();

		if (!paging.isAllWords()) {
			String departmentId = Objects.toString(paging.getCategoryId(), "");
			if (!departmentId.isEmpty()) {
				Stream<Product> productStream = Arrays.stream(productArray);
				productArray = productStream.filter(p -> p.getCategoryId().equals(departmentId)).toArray(Product[]::new);
			}

			String subCategoryId = Objects.toString(paging.getSubCategoryId(), "");
			if (!subCategoryId.isEmpty()) {
				Stream<Product> productStream = Arrays.stream(productArray);
				productArray = productStream.filter(p -> p.getSubCategoryId().equals(subCategoryId))
						.toArray(Product[]::new);
			}
		}

		String searchInp = Objects.toString(paging.getSearchString(), "");
		if (!searchInp.isEmpty()) {
			Stream<Product> productStream = Arrays.stream(productArray);
			productArray = productStream.filter(p -> StringUtils.containsIgnoreCase(p.getProductName(), searchInp))
					.toArray(Product[]::new);
		}

		return productArray;
	}

	public static void loadProductEntity() {

		String jsonString = getJsonString(JSON_PATH_PRODUCT);
		JSONObject jsonObject = new JSONObject(jsonString);
		JSONArray jsonArray = jsonObject.getJSONArray("data");

		int jsonLength = jsonArray.length();

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Product> productMapInput = new HashMap<>();

		Map<String, Category> categoryMap = getCategoriesMap();

		Product[] productsArray = new Product[jsonLength];
		for (int i = 0; i < jsonLength; i++) {
			try {
				ProductJson productJson = objectMapper.readValue(jsonArray.get(i).toString(), ProductJson.class);
				String depName = categoryMap.get(String.valueOf(productJson.getCategoryId())).getCategoryName();
				Product product = new Product(productJson, depName, i + 1);
				productsArray[i] = product;
				productMapInput.put(productJson.getProductId(), product);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		productMap = productMapInput;
		productArray = productsArray;
	}

	public static void loadCategoriesEntity() {
		String departmentJsonString = getJsonString(JSON_PATH_DEPARTMENT);
		JSONObject jsonObject = new JSONObject(departmentJsonString);
		JSONArray jsonArray = jsonObject.getJSONArray("data");

		int jsonLength = jsonArray.length();

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Category> categoryMapInput = new HashMap<>();

		for (int i = 0; i < jsonLength; i++) {
			try {
				Category departmentJson = objectMapper.readValue(jsonArray.get(i).toString(), Category.class);
				categoryMapInput.put(departmentJson.getCategoryId(), departmentJson);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		departmentMap = categoryMapInput;
		departmentString = jsonObject.get("data").toString();
	}

}
