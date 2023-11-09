package com.query;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class WriteCSV {

	public static void main(String[] args) {
		List<String[]> list = new ArrayList<>();
		list.add(new String[] { "A", "B", "C", "D", "E", "F" });
		list.add(new String[] { "A1", "B1", "C1", "D1", "E1", "F1" });
		list.add(new String[] { "A2", "B2", "C2", "D2", "E2", "F2" });
		list.add(new String[] { "A3", "B3", "C3", "D3", "E3", "F3" });
		list.add(new String[] { "A4", "B4", "C4", "D4", "E4", "F4" });
		writeDataAtOnce("C:\\Code\\Pdf\\Demo.csv", list);
	}

	public static void writeDataAtOnce(String filePath, List<String[]> list) {

		// first create file object for file placed at location
		// specified by file path
		File file = new File(filePath);

		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			// create a List which contains String array
			List<String[]> data = new ArrayList<>();
			data.add(new String[] { "Invoice_Number", "Site_Id", "Invoice_Status", "Activity", "Payment_Number",
					"Payment_Date" });
			writer.writeAll(data);
			writer.writeAll(list);
			// closing writer connection
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
