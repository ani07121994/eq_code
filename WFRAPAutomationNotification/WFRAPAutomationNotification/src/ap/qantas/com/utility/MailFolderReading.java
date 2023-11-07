package ap.qantas.com.utility;

import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.aad.msal4j.ClientCredentialFactory;
import com.microsoft.aad.msal4j.ClientCredentialParameters;
import com.microsoft.aad.msal4j.ConfidentialClientApplication;
import com.microsoft.aad.msal4j.IAuthenticationResult;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

public class MailFolderReading {

	public static HashMap<String, String> propMap = new HashMap<String, String>();
	public static SimpleDateFormat sdfformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static SimpleDateFormat sdfformat1 = new SimpleDateFormat("dd/MM/yyyy");
	public static Calendar cal = Calendar.getInstance();
	public static String sysTime = sdfformat.format(cal.getTime());
	public static String sysDate = sdfformat1.format(cal.getTime());

	private static ConfidentialClientApplication app;

	public static void loadProperties1() {

		System.out.println("Inside : loadProperties of ReadOutlookUnprocessedMail executed at :" + sysTime);
		// System.out.println("system date :"+sysDate);

		try {

			Properties prop = new Properties();
			File file = new File("WFR_Notification.properties");
			FileInputStream fileInput = new FileInputStream(file);

			prop.load(fileInput);

			propMap.put("imap", prop.getProperty("IMAP"));
			propMap.put("password", prop.getProperty("OUTLOOKPWD"));
			propMap.put("userID", prop.getProperty("OUTLOOKUSER"));
			propMap.put("smtpHost", prop.getProperty("SMTPHOST"));
			propMap.put("env", prop.getProperty("ENV"));

			// propMap.put("imap", prop.getProperty("IMAP"));
			propMap.put("passwordH", prop.getProperty("PWD_HIGH_PRIORITY"));
			propMap.put("userIDH", prop.getProperty("EMAIL_HIGH_PRIORITY"));
			// propMap.put("smtpHost", prop.getProperty("SMTPHOST"));
			// propMap.put("env", prop.getProperty("ENV"));

			// getting tenant Id, application Id and secret value
			propMap.put("tenantID", prop.getProperty("TENANTID"));
			propMap.put("applicationID", prop.getProperty("APPLICATIONID"));
			propMap.put("secretValue", prop.getProperty("SECRETVALUE"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("End ::: loadProperties1");
	}

	public HashMap<String, List<Integer>> checkMail() {
		HashMap<String, List<Integer>> countMailBox = new HashMap<String, List<Integer>>();
		List<Integer> cntNormalPriority = new ArrayList<Integer>();
		List<Integer> cntHighPriority = new ArrayList<Integer>();
		loadProperties1();

		try {

			Properties props1 = new Properties();
			props1.setProperty("mail.store.protocol", "imaps");
			props1.setProperty("mail.imap.port", "993");
			props1.setProperty("mail.imap.connectiontimeout", "7000");
			props1.setProperty("mail.imap.timeout", "7000");

			// Adding for Oauth-2
			props1.put("mail.imap.host", "outlook.office365.com");
			props1.put("mail.imap.ssl.enable", "true");
			props1.put("mail.imap.starttls.enable", "true");
			props1.put("mail.imap.auth", "true");
			props1.put("mail.imap.auth.mechanisms", "XOAUTH2");

			String imap = propMap.get("imap");

			String userID = propMap.get("userID");
			String password = propMap.get("password");

			String userIDH = propMap.get("userIDH");
			String passwordH = propMap.get("passwordH");

			cntNormalPriority = checkUnprocessedMailBox(userID, password, imap, props1);
			cntHighPriority = checkUnprocessedMailBox(userIDH, passwordH, imap, props1);

			countMailBox.put("cntNormalPriority", cntNormalPriority);
			countMailBox.put("cntHighPriority", cntHighPriority);

		} catch (Exception mex) {
			mex.printStackTrace();
		}
		return countMailBox;

	}

	private List<Integer> checkUnprocessedMailBox(String userID, String password, String imap, Properties props1) {
		List<Integer> countMail = new ArrayList<Integer>();
		System.out.println("Start : checkUnprocessedMailBox");
		try {
			int countUnprocessedFolder = -1;
			int countUnprocessedJunkFolder = -1;
			int countCaptureErrorFolder = -1;

			String tenantId = propMap.get("tenantID");
			String applictionId = propMap.get("applicationID");
			String secretValue = propMap.get("secretValue");

			// =loadProperties1();
			if ("priorityap@qantas.com.au".equalsIgnoreCase(userID)) {
				Session session = Session.getInstance(props1, null);
//				Store store = session.getStore();
//				store.connect(imap, userID, password);

				// change for Oauth2
				Store store = session.getStore("imap");
				BuildConfidentialClientObject(applictionId, tenantId, secretValue);
				IAuthenticationResult result = getAccessTokenByclientCredentialGrant();
				String token = result.accessToken();
				store.connect(imap, userID, token);

				Folder unprocessed = store.getFolder("Unprocessed");
				unprocessed.open(Folder.READ_ONLY);
				countUnprocessedFolder = unprocessed.getMessageCount();
				unprocessed.close(true);
				store.close();

				System.out
						.println("no of messages in " + userID + " unprocessed folder" + " " + countUnprocessedFolder);

				countMail.add(0, countUnprocessedFolder);
			} else {
				Session session = Session.getInstance(props1, null);
//				Store store = session.getStore();
//				store.connect(imap, userID, password);

				// change for Oauth2
				Store store = session.getStore("imap");
				BuildConfidentialClientObject(applictionId, tenantId, secretValue);
				IAuthenticationResult result = getAccessTokenByclientCredentialGrant();
				String token = result.accessToken();
				store.connect(imap, userID, token);

				try {
					Folder unprocessed = store.getFolder("Unprocessed");
					unprocessed.open(Folder.READ_ONLY);
					countUnprocessedFolder = unprocessed.getMessageCount();
					unprocessed.close(true);

				} catch (Exception ex) {
					String msg = ex.getMessage();
					System.out.println(" Messge to read Unprocessed folder " + ex.getMessage());
					if (msg.contains("A3 BAD Request is throttled")) {
						countUnprocessedFolder = -2;
					}
					msg = null;
				}

				try {
					Folder unprocessedJunk = store.getFolder("Unprocessed Junk");
					unprocessedJunk.open(Folder.READ_ONLY);
					countUnprocessedJunkFolder = unprocessedJunk.getMessageCount();
					unprocessedJunk.close(true);

				} catch (Exception ex) {
					String msg = ex.getMessage();
					System.out.println(" Messge to read Unprocessed  Junk folder " + ex.getMessage());
					if (msg.contains("A3 BAD Request is throttled")) {
						countUnprocessedJunkFolder = -2;
					}
					msg = null;
				}

				try {
					Folder captureError = store.getFolder("Capture Error");
					captureError.open(Folder.READ_ONLY);
					countCaptureErrorFolder = captureError.getMessageCount();
					captureError.close(true);

				} catch (Exception ex) {
					System.out.println(" Messge to read Capture Error folder " + ex.getMessage());
					String msg = ex.getMessage();
					if (msg.contains("A3 BAD Request is throttled")) {
						countCaptureErrorFolder = -2;
					}
					msg = null;
				}
				store.close();

				countMail.add(0, countUnprocessedFolder);
				countMail.add(1, countUnprocessedJunkFolder);
				countMail.add(2, countCaptureErrorFolder);

				System.out
						.println("no of messages in normal priority unprocessed folder" + " " + countUnprocessedFolder);
				System.out.println(
						"no of messages in normal priority Unprocessed Junk folder" + " " + countUnprocessedJunkFolder);
				System.out.println(
						"no of messages in normal priority Capture Error folder" + " " + countCaptureErrorFolder);

			}

		} catch (Exception e) {

			// e.printStackTrace();
			System.out.println(" Messge to read Unprocessed folder " + e.getMessage());

		}
		return countMail;

	}

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

}
