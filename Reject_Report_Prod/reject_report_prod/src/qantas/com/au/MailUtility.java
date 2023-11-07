package qantas.com.au;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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
import javax.naming.InitialContext;

public class MailUtility {
	public static String date_yyyyMMdd;

	public static void sendMail_office365() {
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.host", "m.outlook.com");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(props);
	}

	static {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		date_yyyyMMdd = dateFormat.format(new Date());
	}

	public static void sendMail(String attachmentloc, String recepientId, boolean qantas_flag) {
		System.out.println("New Changes Date 24-03-23 for sendMail method");
		String mailFrom = qantas_flag ? "ap_exceptions@qantas.com.au" : "eQNotification@jetstar.com";
		String emailTo = recepientId;
		// To mail address Qantas
		String[] mailAddressToQantas = { "anirban.saha@qantas.com.au", "upamanyu.ghosh@qantas.com.au",
				"kakali.chowdhury@qantas.com.au" };
		// CC mail address Qantas
		String[] emailCcQantas = { "pinkyroy@qantas.com.au" };
		// To mail address Jetstar
		String[] mailAddressToJetstar = { "David.prior@jetstar.com", "Ap.queries@jetstar.com",
				"AnnaMarie.Bugayong@jetstar.com", "RubyMae.Balinong@jetstar.com", "soumya.basu@jetstar.com" };
		// CC mail address Jetstar
		String[] emailCcJetstar = { "anirban.saha@qantas.com.au", "pinkyroy@qantas.com.au",
				"kakali.chowdhury@qantas.com.au" };

		String[] mailAddressTo = qantas_flag ? mailAddressToQantas : mailAddressToJetstar;
		String[] emailCc = qantas_flag ? emailCcQantas : emailCcJetstar;

		String emailBcc = null;
		String emailSubj = qantas_flag ? ("Qantas OWC Emailbox Rejection Report PROD " + date_yyyyMMdd)
				: ("Jetstar OWC Emailbox Rejection Report PROD" + date_yyyyMMdd);
		String emailBody = null;
		InitialContext ic = null;

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", Boolean.valueOf(true));
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.port", Integer.valueOf(25));
		props.put("mail.smtp.host", "eqprod-soa-ap1.qantas.com.au");
		props.put("mail.smtp.auth", Boolean.valueOf(false));
		Session session = Session.getInstance(props);
		if (session != null)
			System.out.println("Session properties :: " + session.getProperties().getProperty("mail.smtp.host"));
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom((Address) InternetAddress.parse(mailFrom, false)[0]);
			if (emailTo != null)
				try {
					InternetAddress[] mailAddress_TO = new InternetAddress[mailAddressTo.length];
					for (int i = 0; i < mailAddressTo.length; i++)
						mailAddress_TO[i] = new InternetAddress(mailAddressTo[i]);
					msg.addRecipients(Message.RecipientType.TO, (Address[]) mailAddress_TO);
					InternetAddress[] emailCc_cc = new InternetAddress[emailCc.length];
					for (int j = 0; j < emailCc_cc.length; j++)
						emailCc_cc[j] = new InternetAddress(emailCc[j]);
					msg.addRecipients(Message.RecipientType.CC, (Address[]) emailCc_cc);
				} catch (Exception exception) {
				}
			if (emailBcc != null)
				try {
					msg.setRecipients(Message.RecipientType.BCC, (Address[]) InternetAddress.parse(emailBcc, false));
				} catch (Exception exception) {
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String subject = emailSubj;
			String body = emailBody;
			MimeBodyPart mbp2 = new MimeBodyPart();
			DataSource source = new FileDataSource(attachmentloc);
			mbp2.setDataHandler(new DataHandler(source));
			System.out.println("FileName is-"
					+ attachmentloc.substring(attachmentloc.lastIndexOf("/") + 1, attachmentloc.length()));
			mbp2.setFileName(qantas_flag ? ("QF_OWC_Emailbox_Rejection_Report_" + date_yyyyMMdd + ".xls")
					: ("JS_OWC_Emailbox_Rejection_Report_" + date_yyyyMMdd + ".xls"));
			System.out.println("mb2 file name ::" + mbp2.getFileName());
			MimeMultipart mimeMultipart = new MimeMultipart();
			mimeMultipart.addBodyPart((BodyPart) mbp2);
			msg.setSubject(subject);
			msg.setContent((Multipart) mimeMultipart);
			Transport.send((Message) msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
