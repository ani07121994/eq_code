package com.ap.jetstar;

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
			File file = new File("WFR_Notification_Jetstar.properties");
			FileInputStream fileInput = new FileInputStream(file);

			prop.load(fileInput);

			propMap.put("imap", prop.getProperty("IMAP"));
			propMap.put("Email_NP_AUS_Pwd", prop.getProperty("Email_NP_AUS_Pwd"));
			propMap.put("Email_NP_AUS", prop.getProperty("Email_NP_AUS"));

			propMap.put("Email_HP_AUS_Pwd", prop.getProperty("Email_HP_AUS_Pwd"));
			propMap.put("Email_HP_AUS", prop.getProperty("Email_HP_AUS"));

			propMap.put("Email_NP_Japan_Pwd", prop.getProperty("Email_NP_Japan_Pwd"));
			propMap.put("Email_NP_Japan", prop.getProperty("Email_NP_Japan"));

			propMap.put("Email_HP_Japan_Pwd", prop.getProperty("Email_HP_Japan_Pwd"));
			propMap.put("Email_HP_Japan", prop.getProperty("Email_HP_Japan"));

			propMap.put("Email_NP_SGP_Pwd", prop.getProperty("Email_NP_SGP_Pwd"));
			propMap.put("Email_NP_SGP", prop.getProperty("Email_NP_SGP"));

			propMap.put("Email_HP_SGP_Pwd", prop.getProperty("Email_HP_SGP_Pwd"));
			propMap.put("Email_HP_SGP", prop.getProperty("Email_HP_SGP"));

			propMap.put("smtpHost", prop.getProperty("SMTPHOST"));
			propMap.put("env", prop.getProperty("ENV"));

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
		List<Integer> cntNP_AUS = new ArrayList<Integer>();
		List<Integer> cntHP_AUS = new ArrayList<Integer>();
		List<Integer> cntNP_Japan = new ArrayList<Integer>();
		List<Integer> cntHP_Japan = new ArrayList<Integer>();
		List<Integer> cntNP_SGP = new ArrayList<Integer>();
		List<Integer> cntHP_SGP = new ArrayList<Integer>();
		// List<Integer> check = new ArrayList<Integer>();
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

			String userId_NP_AUS = propMap.get("Email_NP_AUS");
			String password_NP_AUS = propMap.get("Email_NP_AUS_Pwd");

			String userID_Email_HP_AUS = propMap.get("Email_HP_AUS");
			String password_HP_AUS = propMap.get("Email_HP_AUS_Pwd");

			String userID_Email_NP_Japan = propMap.get("Email_NP_Japan");
			String passwordEmail_NP_Japan = propMap.get("Email_NP_Japan_Pwd");

			String userID_Email_HP_Japan = propMap.get("Email_HP_Japan");
			String passwordEmail_HP_Japan = propMap.get("Email_HP_Japan_Pwd");

			String userID_Email_NP_SGP = propMap.get("Email_NP_SGP");
			String password_NP_SGP = propMap.get("Email_NP_SGP_Pwd");

			String userID_Email_HP_SGP = propMap.get("Email_HP_SGP");
			String password_HP_SGP = propMap.get("Email_HP_SGP_Pwd");

			cntNP_AUS = checkUnprocessedMailBox(userId_NP_AUS, password_NP_AUS, imap, props1);
			cntHP_AUS = checkUnprocessedMailBox(userID_Email_HP_AUS, password_HP_AUS, imap, props1);

			cntNP_Japan = checkUnprocessedMailBox(userID_Email_NP_Japan, passwordEmail_NP_Japan, imap, props1);
			cntHP_Japan = checkUnprocessedMailBox(userID_Email_HP_Japan, passwordEmail_HP_Japan, imap, props1);

			cntNP_SGP = checkUnprocessedMailBox(userID_Email_NP_SGP, password_NP_SGP, imap, props1);
			cntHP_SGP = checkUnprocessedMailBox(userID_Email_HP_SGP, password_HP_SGP, imap, props1);

			System.out.println("userId_NP_AUS " + userId_NP_AUS + " cntNP_AUS size" + cntNP_AUS.size());
			System.out.println("userID_Email_HP_AUS " + userID_Email_HP_AUS + "size " + cntHP_AUS.size());

			System.out.println("userID_Email_NP_Japan " + userID_Email_NP_Japan + " size " + cntNP_Japan.size());
			System.out.println("userID_Email_HP_Japan " + userID_Email_HP_Japan + " size " + cntHP_Japan.size());

			System.out.println("userID_Email_NP_SGP " + userID_Email_NP_SGP + " size " + cntNP_SGP.size());
			System.out.println("userID_Email_HP_SGP " + userID_Email_HP_SGP + " size " + cntHP_SGP.size());

			countMailBox.put(userId_NP_AUS, cntNP_AUS);
			countMailBox.put(userID_Email_HP_AUS, cntHP_AUS);
			countMailBox.put(userID_Email_NP_Japan, cntNP_Japan);
			countMailBox.put(userID_Email_HP_Japan, cntHP_Japan);
			countMailBox.put(userID_Email_NP_SGP, cntNP_SGP);
			countMailBox.put(userID_Email_HP_SGP, cntHP_SGP);

			// check = checkUnprocessedMailBox(userID,password,imap,props1);

		} catch (Exception mex) {
			mex.printStackTrace();
		}
		return countMailBox;

	}

	private List<Integer> checkUnprocessedMailBox(String userID, String password, String imap, Properties props1) {
		List<Integer> countMail = new ArrayList<Integer>();
		System.out.println("Start : checkUnprocessedMailBox  ::: userID ::" + userID);
		try {
			// =loadProperties1();
			int countReProcessFolder = 0;

			String tenantId = propMap.get("tenantID");
			String applictionId = propMap.get("applicationID");
			String secretValue = propMap.get("secretValue");

			Session session = Session.getInstance(props1, null);
//			Store store = session.getStore("");
//	            store.connect(imap, userID, password);

			// change for Oauth2
			Store store = session.getStore("imap");
			BuildConfidentialClientObject(applictionId, tenantId, secretValue);
			IAuthenticationResult result = getAccessTokenByclientCredentialGrant();
			String token = result.accessToken();
			store.connect(imap, userID, token);

			Folder unprocessed = store.getFolder("Unprocessed");
			unprocessed.open(Folder.READ_ONLY);
			int countUnprocessedFolder = unprocessed.getMessageCount();
			unprocessed.close(true);
			if ("OWC-JJP@jetstar.com".equalsIgnoreCase(userID) || "ap.invoices@jetstar.com".equalsIgnoreCase(userID)) {
				System.out.println("No Re-Process folder for " + userID);
			} else {
				Folder ReProcess = store.getFolder("Re-Process");
				ReProcess.open(Folder.READ_ONLY);
				countReProcessFolder = ReProcess.getMessageCount();
				ReProcess.close(true);
			}

			Folder captureError = store.getFolder("Capture Error");
			captureError.open(Folder.READ_ONLY);
			int countCaptureErrorFolder = captureError.getMessageCount();
			captureError.close(true);

			store.close();

			System.out.println("no of messages in" + userID + " unprocessed folder" + " " + countUnprocessedFolder);
			System.out.println("no of messages in " + userID + " Re-Process folder" + " " + countReProcessFolder);
			System.out.println("no of messages in " + userID + " Capture Error folder" + " " + countCaptureErrorFolder);

			countMail.add(0, countUnprocessedFolder);
			countMail.add(1, countReProcessFolder);
			countMail.add(2, countCaptureErrorFolder);

		} catch (Exception e) {
			e.printStackTrace();
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
