package qantas.com.au;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadOutlookMails {
	public static void main(String[] args) {
		List<Integer> check = new ArrayList<Integer>();
		Integer total_messages_count = Integer.valueOf(0);
		Integer tot_senders = Integer.valueOf(0);
		Integer tot_mailcount_perSender = Integer.valueOf(0);
		Integer tot_mailcountwithoutAttchment_perSender = Integer.valueOf(0);
		Integer tot_mailcountwithAttchment_perSender = Integer.valueOf(0);
		try {
			Properties props1 = new Properties();
			props1.setProperty("mail.store.protocol", "imaps");
			props1.setProperty("mail.imap.port", "993");
			props1.setProperty("mail.imap.connectiontimeout", "5000");
			props1.setProperty("mail.imap.timeout", "5000");
			Session session = Session.getInstance(props1, null);
			Store store = session.getStore();
			store.connect("outlook.office365.com", "apinvoice@qantas.com.au", "9uN3OeSPt4CE");
			Folder inbox = store.getFolder("Inbox");
			inbox.open(1);
			int countInboxFolder = inbox.getMessageCount();
			System.out.println("Inside message countInboxFolder " + countInboxFolder);
			Message[] message_list = inbox.getMessages();
			total_messages_count = Integer
					.valueOf((message_list != null && message_list.length > 0) ? message_list.length : 0);
			int count = 1;
			Map<String, List<Message>> groupby_mailsender_map = new HashMap<String, List<Message>>();
			System.out.println("Before group by============================");
			int i = 0;
			byte b;
			int j;
			Message[] arrayOfMessage1;
			for (j = (arrayOfMessage1 = message_list).length, b = 0; b < j;) {
				Message msg = arrayOfMessage1[b];
				if (msg.getFrom() != null && msg.getFrom()[0] != null) {
					Address[] froms = msg.getFrom();
					String email_sender = (froms == null) ? null : ((InternetAddress) froms[0]).getAddress();
					System.out.println("Inside  group by get email_sender============================recordno=====" + i
							+ "==========" + email_sender);
					if (!groupby_mailsender_map.containsKey(email_sender))
						groupby_mailsender_map.put(email_sender, new ArrayList<Message>());
					((List<Message>) groupby_mailsender_map.get(email_sender)).add(msg);
					i++;
				}
				b++;
			}
			tot_senders = Integer.valueOf(groupby_mailsender_map.size());
			Iterator<Entry<String, List<Message>>> it = groupby_mailsender_map.entrySet().iterator();
			List<ReportRow> reportRow_list = new ArrayList<ReportRow>();
			while (it.hasNext()) {
				ReportRow reportRow = new ReportRow();
				Map.Entry pair = it.next();
				System.out.println("===============Mail Sender key value pair ================" + pair.getKey() + " = "
						+ pair.getValue());
				ArrayList<Message> messages_perSender = (ArrayList<Message>) pair.getValue();
				int withAttchment_count = 0;
				int withoutAttchment_count = 0;
				int mailSizeMorethanOneMB_count = 0;
				System.out.println("messages_perSender total count  ======>" + messages_perSender.size());
				ArrayList<String> attachment_typs = new ArrayList<String>();
				for (Message msg : messages_perSender) {
					reportRow.setTotal_mailCount(Integer.valueOf(messages_perSender.size()));
					reportRow.setMailId(pair.getKey().toString());
					if (msg.getSize() > 1048576) {
						mailSizeMorethanOneMB_count++;
						reportRow.setMail_count_morethan_OneMB(Integer.valueOf(mailSizeMorethanOneMB_count));
					}
					if (msg.getContent() != null && msg.getContent() instanceof Multipart) {
						System.out.println("Multipart is present for message No =" + count);
						withAttchment_count++;
						Multipart multipart = (Multipart) msg.getContent();
						for (int k = 0; k < multipart.getCount(); k++) {
							System.out.println("Attachment No ::" + k);
							BodyPart bodyPart = multipart.getBodyPart(k);
							System.out.println("Attachment file content type ::" + bodyPart.getContentType());
							String extn = (bodyPart.getFileName() != null
									&& bodyPart.getFileName().lastIndexOf(".") != -1) ? bodyPart.getFileName()
											.substring(bodyPart.getFileName().lastIndexOf(".") + 1).toLowerCase()
											: null;
							if (extn != null && !attachment_typs.contains(extn))
								attachment_typs.add(extn);
							if (bodyPart.getFileName() == null) {
								System.out.println(
										"Full name is null from this particular multipart attachment hence setting the file name the the same as the content type");
								if (bodyPart.getContentType() != null && !attachment_typs.contains("txt"))
									attachment_typs.add("txt");
							}
							System.out.println("Attachment extension ::" + extn);
							System.out.println("Attachment file name       ===========>" + bodyPart.getFileName()
									+ "Attachment size in bytes   ============> ::" + bodyPart.getSize());
							if (bodyPart.getSize() > 0)
								System.out.println("Attachment size in KB" + (bodyPart.getSize() / 1024));
						}
						continue;
					}
					System.out.println("No multipart is present for mail No  ===" + count);
					withoutAttchment_count++;
				}
				reportRow.setTotal_mailCount(Integer.valueOf(withAttchment_count + withoutAttchment_count));
				reportRow.setMail_count_WithAttchmts(Integer.valueOf(withAttchment_count));
				reportRow.setMail_count_WithoutAttchmts(Integer.valueOf(withoutAttchment_count));
				if (attachment_typs.size() == 0)
					attachment_typs.add("N/A");
				if ((reportRow.getMail_count_morethan_OneMB() != null
						&& reportRow.getMail_count_morethan_OneMB().intValue() == 0)
						|| reportRow.getMail_count_morethan_OneMB() == null)
					reportRow.setMail_count_morethan_OneMB(Integer.valueOf(0));
				reportRow.setAttachment_typs(attachment_typs);
				reportRow_list.add(reportRow);
				it.remove();
			}
			inbox.close(true);
			store.close();
			for (ReportRow report : reportRow_list) {
				System.out.println(
						"============================================report.getMailId() =======" + report.getMailId());
				System.out.println("report.getMail_count_morethan_OneMB()" + report.getMail_count_morethan_OneMB());
				System.out.println("report.getMail_count_WithoutAttchmts()" + report.getMail_count_WithoutAttchmts());
				System.out.println("report.getMail_count_WithAttchmts()" + report.getMail_count_WithAttchmts());
				System.out.println("report.getTotal_mailCount()" + report.getTotal_mailCount());
				System.out.println("===========Distinct extension :: ========");
				for (String extn : report.getAttachment_typs())
					System.out.println(extn);
				System.out.println("==========----------===========");
			}
			writeExcel(reportRow_list, "gigi");
		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}

	private static List<Message> checkInboxMails(String userID, String password, String imap, Properties props1) {
		List<Message> email_list = new ArrayList<Message>();
		System.out.println("Start : checkUnprocessedMailBox");
		try {
			Session session = Session.getInstance(props1, null);
			Store store = session.getStore();
			store.connect("outlook.office365.com", userID, password);
			Folder inbox = store.getFolder("Inbox");
			inbox.open(1);
			int countInboxFolder = inbox.getMessageCount();
			System.out.println("Inside message countInboxFolder " + countInboxFolder);
			Message[] message_list = inbox.getMessages();
			int count = 1;
			byte b;
			int i;
			Message[] arrayOfMessage1;
			for (i = (arrayOfMessage1 = message_list).length, b = 0; b < i;) {
				Message msg = arrayOfMessage1[b];
				System.out.println("======================Inside mail No :: ========" + count);
				System.out.println(
						"Mail  Subject     =======>  " + msg.getSubject() + " Mail Description            =======> "
								+ msg.getDescription() + " Mail Recipients             =======>"
								+ msg.getAllRecipients() + " Mail Sent Date              =======>" + msg.getSentDate()
								+ " Mail Sender                 =======>" + msg.getFrom()[0]
								+ " Mail Size                    =======>" + msg.getSize());
				email_list.add(msg);
				count++;
				b++;
			}
			inbox.close(true);
			store.close();
			return email_list;
		} catch (Exception e) {
			e.printStackTrace();
			return email_list;
		}
	}

	public static void writeExcel(List<ReportRow> row_list, String excelFilePath) throws IOException {
		HSSFWorkbook hSSFWorkbook = new HSSFWorkbook();
		Sheet sheet = hSSFWorkbook.createSheet();
		int rowCount = 0;
		Font headerFont = hSSFWorkbook.createFont();
		headerFont.setBoldweight((short) 700);
		headerFont.setFontHeightInPoints((short) 10);
		headerFont.setColor(IndexedColors.BLACK.getIndex());
		CellStyle headerCellStyle = hSSFWorkbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		Row headerRow = sheet.createRow(0);
		String[] header_columns = { "EmailId", "Total Number of mails", "Mails with attachments",
				"Mails without attachments", "Mails more than  1GB", "Attachment Types" };
		for (int i = 0; i < header_columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(header_columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		for (ReportRow report_row : row_list) {
			Row row = sheet.createRow(++rowCount);
			writeBook(report_row, row);
		}
		String report_filepath = "D:\\Report.xlsx";
		FileOutputStream outputStream = new FileOutputStream(new File(report_filepath));
		hSSFWorkbook.write(outputStream);
		outputStream.close();
		System.out.println("Writesheet.xlsx written successfully in location :: " + report_filepath);
		MailUtility.sendMail(report_filepath, "nirmalya.pramanik@qantas.com.au", true);
		System.out.println("Mail send successfully");
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
		if (report_row.getMail_count_WithAttchmts() != null) {
			cell.setCellValue(report_row.getMail_count_WithAttchmts().intValue());
		} else {
			cell.setCellValue("0");
		}
		cell = row.createCell(3);
		if (report_row.getMail_count_WithoutAttchmts() != null) {
			cell.setCellValue(report_row.getMail_count_WithoutAttchmts().intValue());
		} else {
			cell.setCellValue("0");
		}
		cell = row.createCell(4);
		if (report_row.getMail_count_morethan_OneMB() != null) {
			cell.setCellValue(report_row.getMail_count_morethan_OneMB().intValue());
		} else {
			cell.setCellValue("0");
		}
		cell = row.createCell(5);
		if (report_row.getAttachment_typs() != null) {
			cell.setCellValue(String.join(",", (Iterable) report_row.getAttachment_typs()));
		} else {
			cell.setCellValue("N/A");
		}
	}
}
