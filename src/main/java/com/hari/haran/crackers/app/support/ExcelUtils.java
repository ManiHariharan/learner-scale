package com.hari.haran.crackers.app.support;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.hari.haran.crackers.app.entity.Category;
import com.hari.haran.crackers.app.entity.SubCategory;
import com.hari.haran.crackers.app.entity.json.ProductJson;
import com.hari.haran.crackers.app.exception.MyCustomException;

/**
 * ExcelUtils is an utility class used to read inputs from Excel
 * 
 * @author HARIHARAN MANI
 * @since 14-12-2021
 */
public class ExcelUtils {

	private static final String EXCEL_PATH = "C:\\Users\\harihama\\Desktop\\Desktop\\Crackers.xls";
	private static final String SHEET_CATEGORY = "Category";
	private static final String SHEET_SUB_CATEGORY = "SubCategory";
	private static final String SHEET_PRODUCT = "Product";

	/**
	 * This is a private constructor to hide the implicit public one.
	 */
	private ExcelUtils() {
		throw new IllegalStateException();
	}

	private static List<ProductJson> getProductList() {
		try (Workbook workbook = getWorkBook()) {
			Sheet productSheet = workbook.getSheet(SHEET_PRODUCT);

			List<ProductJson> productList = new ArrayList<>();

			int rowCount = productSheet.getLastRowNum();
			for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
				Row currentRow = productSheet.getRow(rowNo);

				ProductJson productJson = new ProductJson();
				productJson.setCategoryId(Objects.toString(currentRow.getCell(0), "").toUpperCase());
				productJson.setSubCategoryId(Objects.toString(currentRow.getCell(2), "").toUpperCase());
				productJson.setProductId(Objects.toString(currentRow.getCell(4), "").toUpperCase());
				productJson.setProductName(Objects.toString(currentRow.getCell(5), "").toUpperCase());
				productJson.setDescription(Objects.toString(currentRow.getCell(6), ""));

				productJson.setMrpPrice((int) currentRow.getCell(7).getNumericCellValue());
				productJson.setDiscountRate((int) currentRow.getCell(8).getNumericCellValue());
				productJson.setDisplay((int) currentRow.getCell(9).getNumericCellValue());

				if (productJson.getProductId().isEmpty() || productJson.getProductName().isEmpty()
						|| productJson.getCategoryId().isEmpty() || productJson.getMrpPrice() == 0) {
					System.out.println(String.format("Error in the product [%s]", rowNo + 1));
				} else {
					productList.add(productJson);
				}
			}
			System.out.println(String.format("Product List Count = %s", productList.size()));
			return productList;
		} catch (Exception e) {
			throw new MyCustomException("Product List Read Error", e);
		}
	}

	private static List<SubCategory> getSubCategoryList() {
		try (Workbook workbook = getWorkBook()) {
			Sheet categorySheet = workbook.getSheet(SHEET_SUB_CATEGORY);

			List<SubCategory> subCategoryList = new ArrayList<>();

			int rowCount = categorySheet.getLastRowNum();
			for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
				Row currentRow = categorySheet.getRow(rowNo);

				String categorytId = Objects.toString(currentRow.getCell(0), "").toUpperCase();
				String subCategoryId = Objects.toString(currentRow.getCell(1), "").toUpperCase();
				String subCategoryName = Objects.toString(currentRow.getCell(2), "").toUpperCase();
				String description = Objects.toString(currentRow.getCell(3), "");

				if (subCategoryId.isEmpty() || categorytId.isEmpty()) {
					System.out.println(String.format("Error in the row [%s]", rowNo + 1));
				} else {
					subCategoryList.add(new SubCategory(subCategoryId, categorytId, subCategoryName, description));
				}
			}
			System.out.println(String.format("Sub-Category List Count = %s", subCategoryList.size()));
			return subCategoryList;
		} catch (Exception e) {
			throw new MyCustomException("SubCategory List Read Error", e);
		}
	}

	private static List<Category> getCategoryList() {
		try (Workbook workbook = getWorkBook()) {
			Sheet categorySheet = workbook.getSheet(SHEET_CATEGORY);

			List<Category> categoryList = new ArrayList<>();

			int rowCount = categorySheet.getLastRowNum();
			for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
				Row currentRow = categorySheet.getRow(rowNo);

				String categoryId = Objects.toString(currentRow.getCell(0), "").toUpperCase();
				String categoryName = Objects.toString(currentRow.getCell(1), "").toUpperCase();
				String description = Objects.toString(currentRow.getCell(2), "");

				if (categoryId.isEmpty() || categoryName.isEmpty()) {
					System.out.println(String.format("Error in the row [%s]", rowNo + 1));
				} else {
					Category categoryEntity = new Category();
					categoryEntity.setCategoryId(categoryId);
					categoryEntity.setCategoryName(categoryName);
					categoryEntity.setDescription(description);
					categoryList.add(categoryEntity);
				}
			}

			System.out.println(String.format("Category List Count = %s", categoryList.size()));
			return categoryList;
		} catch (Exception e) {
			throw new MyCustomException("Category List Read Error", e);
		}
	}

	private static Workbook getWorkBook() {
		try (FileInputStream inputStream = new FileInputStream(EXCEL_PATH);
				Workbook workBook = new HSSFWorkbook(inputStream);) {
			return workBook;
		} catch (Exception e) {
			throw new MyCustomException("Workbook Read Error", e);
		}
	}

	public static String printCategoryJson() {
		List<Category> categoryExcelList = ExcelUtils.getCategoryList();
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"data\": [");

		categoryExcelList.stream().forEach(categoryVal -> {
			sb.append("{");
			sb.append("\"CategoryId\": \"").append(categoryVal.getCategoryId()).append("\",");
			sb.append("\"CategoryName\": \"").append(categoryVal.getCategoryName()).append("\",");
			sb.append("\"Description\": \"").append(categoryVal.getDescription()).append("\"");
			sb.append("},");
		});

		sb.append("] }");
		return sb.toString();
	}

	public static String printSubCategoryJson() {
		List<SubCategory> subCategoryExcelList = ExcelUtils.getSubCategoryList();
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"data\": [");

		subCategoryExcelList.stream().forEach(categoryVal -> {
			sb.append("{");
			sb.append("\"SubCategoryId\": \"").append(categoryVal.getSubCategoryId()).append("\",");
			sb.append("\"CategoryId\": \"").append(categoryVal.getCategoryId()).append("\",");
			sb.append("\"SubCategoryName\": \"").append(categoryVal.getSubCategoryName()).append("\",");
			sb.append("\"Description\": \"").append(categoryVal.getSubCategoryName().toLowerCase()).append("\"");
			sb.append("},");
		});

		sb.append("] }");
		return sb.toString();
	}

	public static String printProductJson() {
		List<ProductJson> subCategoryExcelList = ExcelUtils.getProductList();
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"data\": [");

		subCategoryExcelList.stream().forEach(categoryVal -> {
			sb.append("{");
			sb.append("\"product_id\": \"").append(categoryVal.getProductId()).append("\",");
			sb.append("\"category_id\": \"").append(categoryVal.getCategoryId()).append("\",");
			sb.append("\"product_name\": \"").append(categoryVal.getProductName()).append("\",");
			sb.append("\"Description\": \"").append(categoryVal.getDescription()).append("\",");

			sb.append("\"mrp_price\": ").append(categoryVal.getMrpPrice()).append(",");

			String subCategoryId = Objects.toString(categoryVal.getSubCategoryId(), "");
			if (!subCategoryId.isEmpty()) {
				sb.append("\"sub_category_id\": \"").append(subCategoryId).append("\",");
			}

			int discountRate = categoryVal.getDiscountRate();
			if (discountRate > 0) {
				sb.append("\"discount_rate\": ").append(discountRate).append(",");
			}

			int isDisplay = categoryVal.getDisplay();
			if (isDisplay > 0) {
				sb.append("\"is_display\": ").append(isDisplay).append(",");
			}

			sb.append("\"primary_image\": \"").append(categoryVal.getCategoryId()).append("_p.png\",");
			sb.append("\"secondary_image\": \"").append(categoryVal.getCategoryId()).append("_s.png\",");
			sb.append("\"thumb_nail\": \"").append(categoryVal.getCategoryId()).append("_t.png\",");

			sb.append("},");
		});

		sb.append("] }");
		return sb.toString();
	}
}