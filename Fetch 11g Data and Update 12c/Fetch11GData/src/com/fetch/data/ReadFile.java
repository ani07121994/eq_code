package com.fetch.data;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.InputStream;
import java.util.Scanner; // Import the Scanner class to read text files

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.util.StringUtil;

import com.google.common.base.Strings;

public class ReadFile {
	public static void main(String[] args) {
		System.out.println(isDigits("0"));
//	  FetchData fetchData=new FetchData();
//  	fetchData.call11gQuery("01-MAR-2018", "16-MAR-2018", "IPM_1945317");
		try {
//			FetchData fetchData = new FetchData();
//			Object[][] databaseData; 
//			File myObj = new File("C:\\Users\\2292543\\Downloads\\OldDocId\\01Mar - 15Mar 2018.txt");
//			Scanner myReader = new Scanner(myObj);
//			while (myReader.hasNextLine()) {
//				String data = myReader.nextLine();
//				System.out.println(data);
//				databaseData=fetchData.call11gQuery("01-MAR-2018", "16-MAR-2018", data);
//				WriteFile.writeDataToExcel("C:\\2292543\\11gData.xlsx", databaseData);
//			}

			File myObj = new File("C:\\2292543\\Test.txt");
			Scanner myReader = new Scanner(myObj);
			String aa = "";
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
				String[] a = data.split(":");
				System.out.println("1 : " + a[0]);
				System.out.println("2 : " + a[1].trim().equals(""));
				System.out.println("3 : " + (aa == null));
				System.out.println("4 : " + aa.isEmpty());
			}
			String orginal_fileName = "2292543_BCM-3.PdF";
			String extn = FilenameUtils.getExtension(orginal_fileName);
			System.out.println("Ext : " + extn);
			String a = "12345";
			System.out.println("Value : " + (a != null && !a.trim().isEmpty()));
			if (a != null && !a.trim().isEmpty())
				System.out.println("Sucess");
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
    public static boolean isDigits(String str) {
    // check for null & empty
        if(str == null || str.isEmpty() || str.length() == 0) {
            // return false
            return false;
        }
        // return if its all match
        return str.chars().allMatch(ch -> Character.isDigit(ch));
    }
}