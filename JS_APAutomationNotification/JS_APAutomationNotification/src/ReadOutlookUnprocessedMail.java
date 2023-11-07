
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

public class ReadOutlookUnprocessedMail {
	public static HashMap<String, String> filePathList1 = new HashMap<>();
	public static SimpleDateFormat sdfformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static SimpleDateFormat sdfformat1 = new SimpleDateFormat("dd/MM/yyyy");
	public static Calendar cal = Calendar.getInstance();
	public static String sysTime = sdfformat.format(cal.getTime());
	public static String sysDate = sdfformat1.format(cal.getTime());

	private static ConfidentialClientApplication app;

	public static void loadProperties1() {
		System.out.println("Inside : loadProperties of ReadOutlookUnprocessedMail executed at :" + sysTime);

		try {
			Properties prop = new Properties();
			File file = new File("WFR_Notification_Jetstar.properties");
			FileInputStream fileInput = new FileInputStream(file);

			prop.load(fileInput);

			filePathList1.put("imap", prop.getProperty("IMAP"));
			filePathList1.put("password", prop.getProperty("OUTLOOKPWD"));
			filePathList1.put("userID", prop.getProperty("OUTLOOKUSER"));
			filePathList1.put("smtpHost", prop.getProperty("SMTPHOST"));
			filePathList1.put("env", prop.getProperty("ENV"));

			// getting tenant Id, application Id and secret Id
			filePathList1.put("tenantID", prop.getProperty("TENANTID"));
			filePathList1.put("applicationID", prop.getProperty("APPLICATIONID"));
			filePathList1.put("secretValue", prop.getProperty("SECRETVALUE"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("End ::: loadProperties1");
	}

	public List<Integer> checkMail() {
		List<Integer> check = new ArrayList<>();
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

			String imap = filePathList1.get("imap");

			String userID = filePathList1.get("userID");
			String password = filePathList1.get("password");

			String tenantId = filePathList1.get("tenantID");
			String applicationId = filePathList1.get("applicationID");
			String secretValue = filePathList1.get("secretValue");

			check = checkUnprocessedMailBox(userID, password, imap, props1, tenantId, applicationId, secretValue);

		} catch (Exception mex) {
			mex.printStackTrace();
		}
		return check;
	}

	private List<Integer> checkUnprocessedMailBox(String userID, String password, String imap, Properties props1,
			String tenantId, String applicationId, String secretValue) {
		List<Integer> countMail = new ArrayList<>();
		System.out.println("Start : checkUnprocessedMailBox");

		try {
			Session session = Session.getInstance(props1, null);
//			Store store = session.getStore();
//			store.connect(imap, userID, password);

			// change for Oauth2
			Store store = session.getStore("imap");
			BuildConfidentialClientObject(applicationId, tenantId, secretValue);
			IAuthenticationResult result = getAccessTokenByclientCredentialGrant();
			String token = result.accessToken();
			store.connect(imap, userID, token);
			Folder unprocessed = store.getFolder("Unprocessed");
			unprocessed.open(1);
			int countUnprocessedFolder = unprocessed.getMessageCount();
			unprocessed.close(true);

			Folder ReProcess = store.getFolder("Re-Process");
			ReProcess.open(1);
			int countReProcessFolder = ReProcess.getMessageCount();
			ReProcess.close(true);

			Folder captureError = store.getFolder("Capture Error");
			captureError.open(1);
			int countCaptureErrorFolder = captureError.getMessageCount();
			captureError.close(true);

			store.close();

			System.out.println("no of messages in unprocessed folder " + countUnprocessedFolder);
			System.out.println("no of messages in Re-Process folder " + countReProcessFolder);
			System.out.println("no of messages in Capture Error folder " + countCaptureErrorFolder);

			countMail.add(0, Integer.valueOf(countUnprocessedFolder));
			countMail.add(1, Integer.valueOf(countReProcessFolder));
			countMail.add(2, Integer.valueOf(countCaptureErrorFolder));

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

/*
 * Location: C:\Users\2146691\Downloads\client notification\client
 * notification\js\APAutomationNotification.jar!\ReadOutlookUnprocessedMail.
 * class Java compiler version: 8 (52.0) JD-Core Version: 1.1.3
 */