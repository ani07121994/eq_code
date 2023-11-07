package qantas.com.au;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.MessagingException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadMailOutlook_3 {
	public static Map<String, String[]> mail_box_creds_qantas;

	public static Map<String, String[]> mail_box_creds_js;

	public static String temp = String.valueOf(System.getenv("TEMP")) + "\\";

	public static String date_yyyyMMdd;

	static {
		DateFormat dateFormat = new SimpleDateFormat("yyyyddMM");
		date_yyyyMMdd = dateFormat.format(new Date());
		mail_box_creds_qantas = (Map) new HashMap<String, String>();
		mail_box_creds_js = (Map) new HashMap<String, String>();
		mail_box_creds_qantas.put("apinvoice@qantas.com.au",
				new String[] { "9uN3OeSPt4CE", "QF NORMAL PRIORITY", "74ea519d-9792-4aa9-86d9-b7cab8204ddd",
						"2615167a-ab76-4337-9b88-665328061342", "vfj8Q~eh6ENvhyDAaYiR0EAjaDIIQTuDZYu4Sdyq" });
		mail_box_creds_qantas.put("priorityap@qantas.com.au",
				new String[] { "qan@4567", "QF HIGH PRIORITY", "74ea519d-9792-4aa9-86d9-b7cab8204ddd",
						"2615167a-ab76-4337-9b88-665328061342", "vfj8Q~eh6ENvhyDAaYiR0EAjaDIIQTuDZYu4Sdyq" });
		mail_box_creds_js.put("AP.PriorityInvoices@jetstar.com",
				new String[] { "R3qZGrWQNp@", "JQ HIGH PRIORITY", "f48c00f2-03b8-4780-864a-6d718d272fcd",
						"43340c8c-b11a-4639-a73d-3872d2a74881", "UrW8Q~E-G8npn4J971i4pUxe1e~X5CBi2WXCYa3~" });
		mail_box_creds_js.put("ap.invoices@jetstar.com",
				new String[] { "R3qZGrWQNp@", "JQ NORMAL PRIORITY", "f48c00f2-03b8-4780-864a-6d718d272fcd",
						"43340c8c-b11a-4639-a73d-3872d2a74881", "UrW8Q~E-G8npn4J971i4pUxe1e~X5CBi2WXCYa3~" });
		mail_box_creds_js.put("OWC-JJP@jetstar.com",
				new String[] { "JetOW@1234", "JJP NORMAL PRIORITY", "f48c00f2-03b8-4780-864a-6d718d272fcd",
						"43340c8c-b11a-4639-a73d-3872d2a74881", "UrW8Q~E-G8npn4J971i4pUxe1e~X5CBi2WXCYa3~" });
		mail_box_creds_js.put("JJPaccountspayableHP@jetstar.com",
				new String[] { "JetHP!1234", "JJP HIGH PRIORITY", "f48c00f2-03b8-4780-864a-6d718d272fcd",
						"43340c8c-b11a-4639-a73d-3872d2a74881", "UrW8Q~E-G8npn4J971i4pUxe1e~X5CBi2WXCYa3~" });
		mail_box_creds_js.put("Accounts.Payable@jetstarasia.com",
				new String[] { "Jetstar@321", "JSA NORMAL PRIORITY", "f48c00f2-03b8-4780-864a-6d718d272fcd",
						"43340c8c-b11a-4639-a73d-3872d2a74881", "UrW8Q~E-G8npn4J971i4pUxe1e~X5CBi2WXCYa3~" });
		mail_box_creds_js.put("JSA.APPriority@jetstarasia.com",
				new String[] { "Hfcgd$5346", "JSA HIGH PRIORITY", "f48c00f2-03b8-4780-864a-6d718d272fcd",
						"43340c8c-b11a-4639-a73d-3872d2a74881", "UrW8Q~E-G8npn4J971i4pUxe1e~X5CBi2WXCYa3~" });
	}

	public static void main(String[] args) {
		System.out.println("New Changes Date 24-03-23");
		readMailOutlook(mail_box_creds_qantas, new String[] { "anirban.saha@qantas.com.au" },
				"ap_exceptions@qantas.com.au", "kakali.chowdhury@qantas.com.au", true);
		readMailOutlook(mail_box_creds_js, new String[] { "kakali.chowdhury@qantas.com.au" },
				"eQNotification@jetstar.com", "anirban.saha@qantas.com.au", false);
	}

	public static void readMailOutlook(Map<String, String[]> mail_box_creds, String[] receipents, String sender,
			String cc, boolean qantas_flag) {
		try {
			Iterator<Entry<String, String[]>> it = mail_box_creds.entrySet().iterator();
			List<List<ReportRow>> reportlist_array = new ArrayList<List<ReportRow>>();
			while (it.hasNext()) {
				Map.Entry pair = it.next();
				String mail_box_id = pair.getKey().toString();
				String[] mail_box_value = (String[]) pair.getValue();
				String box_pwd = mail_box_value[0];
				String box_name = mail_box_value[1];
				String tenantId = mail_box_value[2];
				String applicationId = mail_box_value[3];
				String secretValue = mail_box_value[4];
				System.out.println("===============Mail creds key value pair ================" + pair.getKey()
						+ "box_pwd ,box_name  = " + box_pwd + "," + box_name);
				List<ReportRow> reportRow_list = SearchEmailByDate.searchbyMethod(mail_box_id, box_pwd, box_name,
						tenantId, applicationId, secretValue);
				for (ReportRow report : reportRow_list) {
					System.out.println("============================================report.getMailId() ======="
							+ report.getMailId());
					System.out.println("report.getMail_count_morethan_OneMB()" + report.getMail_count_morethan_OneMB());
					System.out
							.println("report.getMail_count_WithoutAttchmts()" + report.getMail_count_WithoutAttchmts());
					System.out.println("report.getMail_count_WithAttchmts()" + report.getMail_count_WithAttchmts());
					System.out.println("report.getTotal_mailCount()" + report.getTotal_mailCount());
					System.out.println("===========Distinct extension :: ========");
					for (String extn : report.getAttachment_typs())
						System.out.println(extn);
					System.out.println("==========----------===========");
				}
				reportlist_array.add(reportRow_list);
			}
			writeExcel_1(reportlist_array,
					qantas_flag ? (String.valueOf(temp) + "QF_OWC_Emailbox_Rejection_Report_" + date_yyyyMMdd + ".xls")
							: (String.valueOf(temp) + "JS_OWC_Emailbox_Rejection_Report_" + date_yyyyMMdd + ".xls"),
					qantas_flag);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeExcel_1(List<List<ReportRow>> reportlist_array, String excelFilePath, boolean qantas_flag)
			throws IOException {
		System.out.println("reportlist_array --------------------" + reportlist_array.size());
		System.out.println("excelFilePath --------------------" + excelFilePath);
		System.out.println("excelFilePath --------------------" + qantas_flag);
		HSSFWorkbook hSSFWorkbook = new HSSFWorkbook();
		for (List<ReportRow> row_list : reportlist_array) {
			Sheet sheet = hSSFWorkbook.createSheet();
			System.out.println("workbook --------------------" + hSSFWorkbook);
			System.out
					.println("workbook.getSheetIndex(sheet) --------------------" + hSSFWorkbook.getSheetIndex(sheet));
			hSSFWorkbook.setSheetName(hSSFWorkbook.getSheetIndex(sheet),
					(row_list != null && row_list.get(0) != null) ? ((ReportRow) row_list.get(0)).getReport_name()
							: "");
			int rowCount = 0;
			Font headerFont = hSSFWorkbook.createFont();
			headerFont.setBoldweight((short) 700);
			headerFont.setFontHeightInPoints((short) 10);
			headerFont.setColor(IndexedColors.BLACK.getIndex());
			headerFont.setFontName("Calibri");
			CellStyle headerCellStyle = hSSFWorkbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
			headerCellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			headerCellStyle.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
			headerCellStyle.setFillPattern((short) 1);
			headerCellStyle.setAlignment((short) 2);
			headerCellStyle.setBorderBottom((short) 2);
			headerCellStyle.setBorderTop((short) 2);
			headerCellStyle.setBorderRight((short) 2);
			headerCellStyle.setBorderLeft((short) 2);
			Row headerRow = sheet.createRow(0);
			String[] header_columns = { "Email Id", "Total Number of mails", "Mails without attachments",
					"Mails with attachments", "Attachment Types", "Mails more than 1MB" };
			for (int i = 0; i < header_columns.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(header_columns[i]);
				cell.setCellStyle(headerCellStyle);
			}
			Collections.sort(row_list, new Comparator<ReportRow>() {
				public int compare(ReportRow r1, ReportRow r2) {
					return r2.getTotal_mailCount().compareTo(r1.getTotal_mailCount());
				}
			});
			for (ReportRow report_row : row_list) {
				Row row = sheet.createRow(++rowCount);
				writeBook(report_row, row);
			}
		}
		String report_filepath = qantas_flag
				? (String.valueOf(temp) + "QF_OWC_Emailbox_Rejection_Report_" + date_yyyyMMdd + ".xls")
				: (String.valueOf(temp) + "JS_OWC_Emailbox_Rejection_Report_" + date_yyyyMMdd + ".xls");
		FileOutputStream outputStream = new FileOutputStream(new File(report_filepath));
		hSSFWorkbook.write(outputStream);
		outputStream.close();
		System.out.println("Writesheet.xlsx written successfully in location :: " + report_filepath);
		MailUtility.sendMail(report_filepath, "anirban.saha@qantas.com.au", qantas_flag);
		System.out.println("Mail send successfully");
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean res = fileDeletion_afterMail(report_filepath);
		if (res)
			System.out.println(String.valueOf(report_filepath) + "is deleted successfully");
	}

	private static boolean fileDeletion_afterMail(String file_path) {
		try {
			Files.deleteIfExists(Paths.get(file_path, new String[0]));
		} catch (NoSuchFileException e) {
			System.out.println("No such file/directory exists");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Directory is not empty.");
		} catch (IOException e) {
			System.out.println("Invalid permissions.");
		}
		System.out.println("Deletion successful.");
		return true;
	}

	private static void writeBook(ReportRow report_row, Row row) {
		Cell cell = row.createCell(0);
		if (report_row.getMailId() != null) {
			cell.setCellValue(report_row.getMailId());
		} else {
			cell.setCellValue("N/A");
		}
		cell = row.createCell(1);
		if (report_row.getTotal_mailCount() != null) {
			cell.setCellValue(report_row.getTotal_mailCount().intValue());
		} else {
			cell.setCellValue("0");
		}
		cell = row.createCell(2);
		if (report_row.getMail_count_WithoutAttchmts() != null) {
			cell.setCellValue(report_row.getMail_count_WithoutAttchmts().intValue());
		} else {
			cell.setCellValue("0");
		}
		cell = row.createCell(3);
		if (report_row.getMail_count_WithAttchmts() != null) {
			cell.setCellValue(report_row.getMail_count_WithAttchmts().intValue());
		} else {
			cell.setCellValue("0");
		}
		cell = row.createCell(4);
		if (report_row.getAttachment_typs() != null && report_row.getAttachment_typs().size() > 1) {
			StringBuilder rString = new StringBuilder();
			for (String each : report_row.getAttachment_typs())
				rString.append(",").append(each);
			cell.setCellValue(rString.toString());
		} else if (report_row.getAttachment_typs() != null
				&& (report_row.getAttachment_typs().size() == 1 || report_row.getAttachment_typs().size() == 0)) {
			cell.setCellValue(report_row.getAttachment_typs().get(0));
		} else {
			cell.setCellValue("0");
		}
		cell = row.createCell(5);
		if (report_row.getMail_count_morethan_OneMB() != null) {
			cell.setCellValue(report_row.getMail_count_morethan_OneMB().intValue());
		} else {
			cell.setCellValue("N/A");
		}
	}
}
