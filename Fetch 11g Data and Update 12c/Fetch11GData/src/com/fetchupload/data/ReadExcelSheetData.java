package com.fetchupload.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheetData {

	public static void main(String[] args) throws IOException {
		ReadExcelSheetData r = new ReadExcelSheetData();

		String val = r.getMapData("2669898");

		System.out.println("Value of the keyword (2663101) is- " + val);

	}

	public static boolean isRowEmpty(Row row) {
		boolean isEmpty = true;
		DataFormatter dataFormatter = new DataFormatter();
		if (row != null) {
			for (Cell cell : row) {
				if (dataFormatter.formatCellValue(cell).trim().length() > 0) {
					isEmpty = false;
					break;
				}
			}
		}
		return isEmpty;
	}

	public static Map<String, Map<String, String>> setMapData() throws IOException {

		String path = "C:\\Users\\2292543\\Downloads\\Qantas_batchid_filelist.xlsx";

		FileInputStream fis = new FileInputStream(path);

		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter formatter = new DataFormatter();
		int lastRow = sheet.getLastRowNum();

		Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String, String>>();

		Map<String, String> dataMap = new HashMap<String, String>();

		// Looping over entire row
		for (int i = 0; i <= lastRow; i++) {

			Row row = sheet.getRow(i);
			if (!isRowEmpty(row)) {
				// 1st Cell as Value
				Cell valueCell = row.getCell(1);
				
				// 0th Cell as Key
				Cell keyCell = row.getCell(0);

				String value = formatter.formatCellValue(valueCell);
				String key = formatter.formatCellValue(keyCell);

				// Putting key & value in dataMap
				dataMap.put(key, value);

				// Putting dataMap to excelFileMap
				excelFileMap.put("DataSheet", dataMap);
			}
		}

		// Returning excelFileMap
		return excelFileMap;

	}

	// Method to retrieve value
	public static String getMapData(String key) throws IOException {

		Map<String, String> m = setMapData().get("DataSheet");
		String value = m.get(key);

		return value;

	}

}