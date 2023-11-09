package com.fetchupload.data;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import com.fetch.data.WriteFile;

public class Test {

	public static Timestamp getDateTimeFromString(String string, String value) {
		Map<String, String> formatMap = new HashMap();
		DateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss.SSS");
		java.sql.Timestamp timeStampDate = null;
		formatMap.put("Certification Pending Date", "YYYY-MM-DD HH:mm:ss.SSS");
		formatMap.put("eQ Interface Date", "YYYY-MM-DD HH:mm:ss");
		formatMap.put("Last Updated Date", "YYYY-MM-DD HH:mm:ss");
		try {
			format = new SimpleDateFormat(formatMap.get(value));
			Date date = (Date) format.parse(string);
			timeStampDate = new Timestamp(date.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeStampDate;
	}

	public static Timestamp convertStringToTimestamp(String str_date) {
		try {
			DateFormat formatter;
			formatter = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss.SSS");
			Date date = (Date) formatter.parse(str_date);
			java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

			return timeStampDate;
		} catch (ParseException e) {
			e.printStackTrace();
//	      System.out.println("Exception :" + e);
			return null;
		}
	}

	public static Date getDateFromString(String string, String value) {
		Date date = null;
		Map<String, String> formatMap = new HashMap();
		DateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		formatMap.put("Invoice Date", "yyyy-MM-dd");
		formatMap.put("Due Date", "YYYY-MM-DD HH:mm:ss");
		formatMap.put("Scan Date", "yyyy-MM-dd HH:mm:ss");
		formatMap.put("Payment Date", "YYYY-MM-DD");
		formatMap.put("Certification Pending Date", "YYYY-MM-DD HH:mm:ss.SSS");
		formatMap.put("eQ Interface Date", "YYYY-MM-DD HH:mm:ss");
		formatMap.put("Last Updated Date", "YYYY-MM-DD HH:mm:ss");
		formatMap.put("PO_Hold_Release_Date", "YYYY-MM-DD HH:mm:ss");
		formatMap.put("Findel_Hold_Release_Date", "yyyy-MM-dd HH:mm:ss");
		if (value.equalsIgnoreCase("Scan Date")) {
			try {
				Date d = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(string);
				System.out.println("1 : " + d);
				string = new SimpleDateFormat(formatMap.get("Scan Date")).format(d);
				System.out.println("2 : " + string);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			System.out.println(string);
			format = new SimpleDateFormat(formatMap.get(value));
			date = (Date) format.parse(string);
//			System.out.println(format.format(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static void main(String[] args) {
//		String str = "2663817_2_20230112_Seisuke.Kozaki111@jetstarqantas111qqqwqwqwq.com_A_TR_Kansai International Airport_23011067.pdf.pdf";
////		str="";
//		LocalDate.parse("");
//		System.out.println(str.substring(str.indexOf("_", str.indexOf("_") + 20) + 1, str.lastIndexOf("_")));
//		System.out.println(str.indexOf("_", str.indexOf("_") + 1) + 1);
//		System.out.println(str.lastIndexOf("_"));
//		System.out.println(str.indexOf("_")+3);
//		System.out.println(str.substring(str.indexOf("_", str.indexOf("_") + 20)+1));
//		System.out.println(getDateTimeFromString(LocalDateTime.now().toString(), "Last Updated Date"));

//		List<String> appsList = new ArrayList<>();
//		appsList.add("4.IPM_021435");
//		appsList.add("3.IPM_1995635");
//		appsList.add("3.IPM_1995640");
//		appsList.add("3.IPM_1995654");
//		appsList.add("3.IPM_1995743");
//		appsList.add("3.IPM_1995849");
//		appsList.add("3.IPM_1995864");
//		appsList.add("3.IPM_1995922");
//		appsList.add("3.IPM_1995945");
//		appsList.add("3.IPM_1995946");
//		appsList.add("3.IPM_1995224");
//		List<DocIDDAO> docList=new ArrayList<>();
//		for (String data : appsList) {
////			docList.add(new DocIDDAO("4.IPM.022037", data));
//		}
//		WriteXLSX.writeDataToExcel("./DocIdList.xlsx", docList);
//		System.out.println("Length : " + newArray.length);

//		WriteFile.writeDataToExcel("./DocIdList.xlsx", string);
		String str="AOG1";
		if (Stream.of("AOG", "FRIGHT").anyMatch(str::equalsIgnoreCase)) {
		    System.out.println("HI");
		}
	}
}
