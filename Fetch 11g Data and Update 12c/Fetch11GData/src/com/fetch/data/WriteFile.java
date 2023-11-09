package com.fetch.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author javacodepoint.com
 *
 */

public class WriteFile {

	public static void writeDataToExcel(String fileName, Object[][] data) {

		// Creating file object of existing excel file
		File xlsxFile = new File(fileName);

		// New students records to update in excel file
//		Object[][] newStudents = { { "Rakesh sharma", "New Delhi", "rakesh.sharma@gmail.com", 22 },
//				{ "Thomas Hardy", "London", "thomas.hardy@gmail.com", 25 } };

		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);

			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);
//			Workbook workbook = new XSSFWorkbook(inputStream);

			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(0);

			// Getting the count of existing records
			int rowCount = sheet.getLastRowNum();

			// Iterating new values to update
			for (Object[] values : data) {

				// Creating new row from the next row count
				Row row = sheet.createRow(++rowCount);

				int columnCount = 0;

				// Iterating value informations
				for (Object info : values) {

					// Creating new cell and setting the value
					Cell cell = row.createCell(columnCount++);
					if (info instanceof String) {
						cell.setCellValue((String) info);
					} else if (info instanceof Integer) {
						cell.setCellValue((Integer) info);
					}
				}
			}
			// Close input stream
			inputStream.close();

			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);

			// Close the workbook and output stream
			workbook.close();
			os.close();

			System.out.println("Excel file has been updated successfully.");

		} catch (Exception e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Object[][] newStudents = { { "Rakesh sharma", "New Delhi", "rakesh.sharma@gmail.com", 22 },
				{ "Thomas Hardy", "London", "thomas.hardy@gmail.com", 25 } };
		writeDataToExcel("C:\\2292543\\export.xlsx", newStudents);
	}
}
