package qantas.com.au;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.SearchTerm;

import com.microsoft.aad.msal4j.ClientCredentialFactory;
import com.microsoft.aad.msal4j.ClientCredentialParameters;
import com.microsoft.aad.msal4j.ConfidentialClientApplication;
import com.microsoft.aad.msal4j.IAuthenticationResult;

public class SearchEmailByDate {

	private static ConfidentialClientApplication app;

	// Method return access token
	private static void BuildConfidentialClientObject(String clientId, String tanantId, String clientSecret)
			throws Exception {
		app = ConfidentialClientApplication.builder(clientId, ClientCredentialFactory.createFromSecret(clientSecret))
				.authority("https://login.microsoftonline.com/" + tanantId + "/oauth2/v2.0/token").build();
	}

	private static IAuthenticationResult getAccessTokenByclientCredentialGrant() throws Exception {
		ClientCredentialParameters clientCredentialParameters = ClientCredentialParameters
				.builder(Collections.singleton("https://outlook.office365.com/.default")).build();
		CompletableFuture<IAuthenticationResult> future = app.acquireToken(clientCredentialParameters);
		return future.get();
	}

	public static Store connect_mailBox(String user_id, String pwd, String tenantId, String applicationId,
			String secretValue) throws MessagingException {
		Properties props1 = new Properties();

		props1.setProperty("mail.store.protocol", "imaps");
		props1.setProperty("mail.imap.port", "993");
		props1.setProperty("mail.imap.connectiontimeout", "5000");
		props1.setProperty("mail.imap.timeout", "5000");
		props1.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

		// Adding for Oauth-2 (24-03-23)
		props1.put("mail.imap.host", "outlook.office365.com");
		props1.put("mail.imap.ssl.enable", "true");
		props1.put("mail.imap.starttls.enable", "true");
		props1.put("mail.imap.auth", "true");
		props1.put("mail.imap.auth.mechanisms", "XOAUTH2");
		Store store = null;
		try {
			// Adding for Oauth-2 (24-03-23)
			BuildConfidentialClientObject(applicationId, tenantId, secretValue);
			IAuthenticationResult result = getAccessTokenByclientCredentialGrant();
			String token = result.accessToken();
			Session session = Session.getInstance(props1, null);
			store = session.getStore("imap");
			store.connect("outlook.office365.com", user_id, token);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return store;
	}

	public static List<ReportRow> searchbyMethod(String user_id, String pwd, String box_name, String tenantId,
			String applicationId, String secretValue) throws MessagingException, IOException {
		Integer total_messages_count = Integer.valueOf(0);
		Store store = connect_mailBox(user_id, pwd, tenantId, applicationId, secretValue);
		Folder inbox = store.getFolder("Inbox");
		inbox.open(1);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		SearchTerm searchCondition = new SearchTerm() {
			public boolean match(Message message) {
				try {
					System.out.println("Message get subject :: " + message.getSentDate());
					Calendar cal = Calendar.getInstance();
					cal.add(5, -8);
					Date search_dt = new Date(cal.getTimeInMillis());
					if (message.getSentDate() != null && message.getSentDate().after(search_dt))
						return true;
				} catch (MessagingException ex) {
					ex.printStackTrace();
				}
				return false;
			}
		};
		System.out.println("after searchCondition ");
		Message[] message_list = inbox.search(searchCondition);
		System.out.println("implementing searchCondition ");
		int countInboxFolder = inbox.getMessageCount();
		System.out.println("Inside message countInboxFolder " + countInboxFolder);
		total_messages_count = Integer
				.valueOf((message_list != null && message_list.length > 0) ? message_list.length : 0);
		int count = 1;
		Map<String, List<Message>> groupby_mailsender_map = new HashMap<String, List<Message>>();
		System.out.println("Before group by111============================");
		System.out.println("Before group by111============================" + message_list.length);
		int i = 0;
		if (message_list.length != 0) {
//			byte b;
			int b;
			int j;
			Message[] arrayOfMessage;
			for (j = (arrayOfMessage = message_list).length, b = 0; b < j;) {
//				System.out.println("Adding 1 : " + (arrayOfMessage = message_list).length);
//				System.out.println("Adding 2 : " + arrayOfMessage.length);
//				System.out.println("Adding 3 : "+message_list.length);
//				System.out.println("B : " + b);
				Message msg = arrayOfMessage[b];
				System.out.println("msg.getFrom()");
				System.out.println("msg.getFrom()-----" + msg.getFrom());
				if (msg.getFrom() != null && msg.getFrom()[0] != null) {
					System.out.println("msg.getFrom()----------->" + msg.getFrom() + "----msg.getFrom()[0]-----"
							+ msg.getFrom()[0]);
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
			Integer total_senders = Integer.valueOf(0);
			Integer total_count_perSender = Integer.valueOf(0);
			Integer tot_senders = Integer.valueOf(0);
			Integer tot_mailcount_perSender = Integer.valueOf(0);
			Integer tot_mailcountwithoutAttchment_perSender = Integer.valueOf(0);
			Integer tot_mailcountwithAttchment_perSender = Integer.valueOf(0);
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
					reportRow.setReport_name(box_name);
					if (msg.getSize() > 1048576) {
						mailSizeMorethanOneMB_count++;
						reportRow.setMail_count_morethan_OneMB(Integer.valueOf(mailSizeMorethanOneMB_count));
					}
					System.out.println("===============Mail Sender key value pair _inside ================"
							+ pair.getKey() + " = " + pair.getValue());
					if (!pair.getKey().toString().equalsIgnoreCase("au.creditcontrol@ap.equinix.com")
							&& !pair.getKey().toString().equalsIgnoreCase("apac.creditcontrol@ap.equinix.com"))
						if (!pair.getKey().toString().equalsIgnoreCase("MAILER-DAEMON@qantas.com.au")
								&& !pair.getKey().toString().equalsIgnoreCase("no-reply@equinix.com")) {
							if (msg.getContent() != null && msg.getContent() instanceof Multipart) {
								System.out.println("Multipart is present for message No =" + count);
								withAttchment_count++;
								Multipart multipart = (Multipart) msg.getContent();
								for (int k = 0; k < multipart.getCount(); k++) {
									System.out.println("Attachment No ::" + k);
									BodyPart bodyPart = multipart.getBodyPart(k);
									System.out.println("Attachment file content type ::" + bodyPart.getContentType());
									String extn = (bodyPart.getFileName() != null
											&& bodyPart.getFileName().lastIndexOf(".") != -1)
													? bodyPart.getFileName()
															.substring(bodyPart.getFileName().lastIndexOf(".") + 1)
															.toLowerCase()
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
									System.out.println("Attachment file name       ===========>"
											+ bodyPart.getFileName() + "Attachment size in bytes   ============> ::"
											+ bodyPart.getSize());
									if (bodyPart.getSize() > 0)
										System.out.println("Attachment size in KB" + (bodyPart.getSize() / 1024));
								}
								continue;
							}
							System.out.println("No multipart is present for mail No  ===" + count);
							withoutAttchment_count++;
							continue;
						}
					System.out.println("au.creditcontrol@ap.equinix.com continue");
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
			return reportRow_list;
		}
		if (message_list.length == 0) {
			List<ReportRow> reportRow_list = new ArrayList<ReportRow>();
			ReportRow ReportRow = new ReportRow();
			ReportRow.setReport_name(box_name);
			ArrayList<String> attachment_types = new ArrayList<String>();
			attachment_types.add("NONE");
			ReportRow.setAttachment_typs(attachment_types);
			reportRow_list.add(ReportRow);
			return reportRow_list;
		}
		return null;
	}
}
