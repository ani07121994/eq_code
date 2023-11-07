package qantas.com.au.changeRequest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSender {
	public static void main(String[] args) {
		System.out.println("Hello");
		Connection conn = null;
		try {
			String jdbcURL = "jdbc:oracle:thin:@eqsit-soa:16013:SOASIT";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbcURL, "eqfiles", "eqfiles");
			PreparedStatement eq_change_template = conn.prepareStatement("select * from EQ_CHANGETEMPLATE_EMAIL_TABLE");
			ResultSet eq_change_template_rs = eq_change_template.executeQuery();
			String mail_body = null;
			String mail_subject = null;
			while (eq_change_template_rs.next()) {
				mail_body = eq_change_template_rs.getString("BODY");
				mail_subject = eq_change_template_rs.getString("SUBJECT");
			}
			System.out.println("mail_body====>" + mail_body);
			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.port", "25");
			props.put("mail.smtp.host", "eqdr-soa-ap1.qantas.com.au");
			props.put("mail.smtp.auth", "false");
			Session mailSession = Session.getInstance(props);
			if (mailSession != null)
				System.out
						.println("Session properties :: " + mailSession.getProperties().getProperty("mail.smtp.host"));
			MimeMessage msg = new MimeMessage(mailSession);
			msg.setFrom((Address) InternetAddress.parse("pinky.roy@qantas.com.au", false)[0]);
			StringBuilder sb = new StringBuilder();
			FileReader reader = null;
			BufferedReader br = null;
			try {
				reader = new FileReader("D:\\Anwesha\\EqchangeRequest_mail\\mailId_list.txt");
				br = new BufferedReader(reader);
				int index = 1;
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println("Sending mail to " + line);
					msg.setRecipients(Message.RecipientType.TO, (Address[]) InternetAddress.parse(line, false));
					MimeBodyPart mbp1 = new MimeBodyPart();
					mbp1.setContent(mail_body, "text/html; charset=utf-8");
					MimeMultipart mimeMultipart = new MimeMultipart();
					mimeMultipart.addBodyPart((BodyPart) mbp1);
					msg.setContent((Multipart) mimeMultipart);
					msg.setSentDate(new Date());
					msg.setSubject(mail_subject);
					Transport.send((Message) msg);
					System.out.println("Message sent successfully");
				}
			} catch (IOException e) {
				String line="";
				System.out.println("exception" + line);
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
