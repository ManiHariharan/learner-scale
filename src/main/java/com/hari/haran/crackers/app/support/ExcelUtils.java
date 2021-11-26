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
import com.hari.haran.crackers.app.exception.MyCustomException;

public class ExcelUtils {

	private static final String EXCEL_PATH = "C:\\Users\\harihama\\Desktop\\Desktop\\Crackers.xls";
	private static final String SHEET_CATEGORY = "Category";
	private static final String SHEET_SUB_CATEGORY = "SubCategory";

	/**
	 * This is a private constructor to hide the implicit public one.
	 */
	private ExcelUtils() {
		throw new IllegalStateException();
	}

	public static List<SubCategory> getSubCategoryList() {
		try (Workbook workbook = getWorkBook()) {
			Sheet categorySheet = workbook.getSheet(SHEET_SUB_CATEGORY);

			List<SubCategory> categoryList = new ArrayList<>();

			int rowCount = categorySheet.getLastRowNum();
			for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
				Row currentRow = categorySheet.getRow(rowNo);

				String subCategoryId = Objects.toString(currentRow.getCell(0), "");
				String departmentId = Objects.toString(currentRow.getCell(1), "");
				String categoryName = Objects.toString(currentRow.getCell(2), "");
				String description = Objects.toString(currentRow.getCell(3), "");

				if (subCategoryId.isEmpty() || departmentId.isEmpty()) {
					System.out.println(String.format("Error in the row [%s]", rowNo + 1));
				} else {
					categoryList.add(new SubCategory(subCategoryId, departmentId, categoryName, description));
				}
			}
			System.out.println(categoryList.size());
			return categoryList;
		} catch (Exception e) {
			throw new MyCustomException("SubCategory List Read Error", e);
		}
	}

	public static List<Category> getCategoryList() {
		try (Workbook workbook = getWorkBook()) {
			Sheet categorySheet = workbook.getSheet(SHEET_CATEGORY);

			List<Category> departmentList = new ArrayList<>();

			int rowCount = categorySheet.getLastRowNum();
			for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
				Row currentRow = categorySheet.getRow(rowNo);

				String categoryId = Objects.toString(currentRow.getCell(0), "");
				String categoryName = Objects.toString(currentRow.getCell(1), "");
				String description = Objects.toString(currentRow.getCell(2), "");

				if (categoryId.isEmpty() || categoryName.isEmpty()) {
					System.out.println(String.format("Error in the row [%s]", rowNo + 1));
				} else {
					Category categoryEntity = new Category();
					categoryEntity.setCategoryId(categoryId);
					categoryEntity.setCategoryName(categoryName);
					categoryEntity.setDescription(description);
					departmentList.add(categoryEntity);
				}
			}
			System.out.println(departmentList.size());
			return departmentList;
		} catch (Exception e) {
			throw new MyCustomException("Category List Read Error", e);
		}
	}

	public static Workbook getWorkBook() {
		try (FileInputStream inputStream = new FileInputStream(EXCEL_PATH);
				Workbook workBook = new HSSFWorkbook(inputStream);) {
			return workBook;
		} catch (Exception e) {
			throw new MyCustomException("Workbook Read Error", e);
		}
	}
}