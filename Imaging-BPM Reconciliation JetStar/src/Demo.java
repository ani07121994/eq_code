
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.*;
//import java.util.stream.Collectors;
//import org.apache.commons.collections4.ListUtils;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.collections.map.MultiValueMap;

public class Demo {
	public static Map<String, String> propMap = null;
	// public static ArrayList<String> capture_List = new ArrayList<String>();
	public static  ArrayList<ArrayList<String>> capture_id_List_apException = null;
	public static ArrayList<String> missmatch_id_List = new ArrayList<String>();
	// public static ArrayList<String> result_List = new ArrayList<String>();
	// public static ArrayList<String> result_List_status = new ArrayList<String>();
	// ArrayList<ArrayList<String>> bpm_return_list = new
	// ArrayList<ArrayList<String>>();

	// public static ArrayList<String> result_list_all = new ArrayList<String>();
	public static ArrayList<ArrayList<String>> bpm_id_List_apException = null;
	// public static ArrayList<ArrayList<String>> imaging_List = new
	// ArrayList<ArrayList<String>>();

	// public static ArrayList<String> supplierNM_imaging = new ArrayList<String>();
	public static ArrayList<String> WFT_list_apException = null;

	public static ArrayList<ArrayList<String>> capture_id_List_certifier = null;
	public static ArrayList<ArrayList<String>> bpm_id_List_certifier = null;
	public static ArrayList<String> WFT_list_certifier = null;


/*	public static final String wft_query = "Select textattribute1||textattribute6 invSuppNameAP from SOAPROD12C_SOAINFRA.wftask where state like 'ASSIGNED%' and TITLE ='AP Invoice Error'\r\n"
			+ "and processname ='JetStarIntegrationProcess'";*/

	public static void main(String[] args) throws SQLException {

		//System.out.println("Current JVM version - " + System.getProperty("java.version"));
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("=========================== Program has started : ===========================" + dateFormat.format(date));
		propMap = getProperties();
		String apException = "apException";
		String certifier = "certifier";

		capture_id_List_apException = new  ArrayList<ArrayList<String>>();
		capture_id_List_apException = getImagingData(propMap.get("imaging_query1"), apException);
		

		System.out.println("capture_id_List size for apException in Invoice Updated by APGroup: " + capture_id_List_apException.get(0).size());
		System.out.println("capture_id_List for apException in 	Invoice Updated by APGroup: " + capture_id_List_apException.get(0));

		bpm_id_List_apException = new ArrayList<ArrayList<String>>();
		 bpm_id_List_apException = getBPMData(capture_id_List_apException.get(1), apException);
		 //int s = capture_id_List_apException.get(0).size() + bpm_id_List_apException.get(0).size();
		 //System.out.println("size" + s);
			
		 System.out.println("Number of Missmatch data between IMAGING and BPM for ApException: " + bpm_id_List_apException.get(0).size());
		 System.out.println("Missmatch data between IMAGING and BPM for Ap Exception: " + bpm_id_List_apException.get(0) + "and their status : " + bpm_id_List_apException.get(1));
		System.out.println("Capture Batch ID which are missing in js_ap_invoice_table but present in Imaging : "+ bpm_id_List_apException.get(2));

		ArrayList<String> InvSupData_apException= new ArrayList<String>();  
		InvSupData_apException = getInvSupData(propMap.get("imaging_query1"));
		
		WFT_list_apException = new ArrayList<String>();
		WFT_list_apException = getWFTData(InvSupData_apException,propMap.get("wft_query1"));
		System.out.println("Number of Missmatch data between Imaging and WF TASK for Ap Exception: " + WFT_list_apException.size());
		System.out.println("Missmatch data between Imaging and WF TASK for Ap Exception: " + WFT_list_apException);

		capture_id_List_certifier = new ArrayList<ArrayList<String>>();
		capture_id_List_certifier = getImagingData(propMap.get("imaging_query2"), certifier);
		//System.out.println("capture_id_List_certifier size : " + capture_id_List_certifier.get(0).size());


		bpm_id_List_certifier = new ArrayList<ArrayList<String>>();
		bpm_id_List_certifier = getBPMData(capture_id_List_certifier.get(0), certifier);
		System.out.println("Number of Missmatch data between IMAGING and BPM for certifier: "
				+ bpm_id_List_certifier.get(0).size());
		System.out.println("Missmatch data between IMAGING and BPM for certifier: " + bpm_id_List_certifier.get(0)
				+ "and their status : " + bpm_id_List_certifier.get(1));
		System.out.println(
				"Capture Batch ID which are missing in js_ap_invoice_table but present in Imaging for certifier: "
						+ bpm_id_List_certifier.get(2));
		
		
		ArrayList<String> InvSupData_certifier= new ArrayList<String>();  
		InvSupData_certifier= getInvSupData(propMap.get("imaging_query2"));
		//System.out.println("InvSupData for certifier:" + InvSupData_certifier.size());

		
		WFT_list_certifier = new ArrayList<String>();
		
		WFT_list_certifier = getWFTData(InvSupData_certifier,propMap.get("wft_query2"));
		System.out.println("Number of Missmatch data between Imaging and WF TASK for certifier: " + WFT_list_certifier.size());
		System.out.println("Missmatch data between Imaging and WF TASK for certifier: " + WFT_list_certifier);

		
		  if ((capture_id_List_apException != null && capture_id_List_apException.size() > 0) || (bpm_id_List_apException != null && bpm_id_List_apException.size()> 0) || (WFT_list_apException.size()>0) ||
		  (bpm_id_List_certifier != null && bpm_id_List_certifier.size()> 0) ||
		  (WFT_list_certifier.size()>0)) 
		  { 
			  if((capture_id_List_apException.get(0) != null && capture_id_List_apException.get(0).size()>0) || (bpm_id_List_apException.get(0) != null &&bpm_id_List_apException.get(0).size()>0) || (bpm_id_List_apException.get(1) != null &&
							  bpm_id_List_apException.get(1).size()>0) || (WFT_list_apException != null && WFT_list_apException.size()>0) ||
		  (bpm_id_List_certifier.get(0) != null &&
		  bpm_id_List_certifier.get(0).size()>0) || (bpm_id_List_certifier.get(1) !=
		  null && bpm_id_List_certifier.get(1).size()>0) || (WFT_list_certifier != null
		  && WFT_list_certifier.size()>0) ) {
		  
		  System.out.println("Mail will trigger");
		  sendMail(capture_id_List_apException,bpm_id_List_apException,WFT_list_apException,bpm_id_List_certifier,WFT_list_certifier);
		  
		  }
		  
		  }
		 

		System.out.println("Closed");

	}

	public static ArrayList<String> getInvSupData(String query) throws SQLException
	{
		String env = propMap.get("ENV");
		Map<String, String> dbParams_imaging = new HashMap<String, String>();
		DatabaseUtility dbUtil = new DatabaseUtility();
		Connection con = null;
		ArrayList<String> InvSupData = new ArrayList<String>();  

		
		if (env != null) {
			dbParams_imaging.put("HOST", propMap.get("HOST_" + env));
			dbParams_imaging.put("USER", propMap.get("USER_" + env));
			dbParams_imaging.put("PASSWORD", propMap.get("PASSWORD_" + env));
		}
		
		con = dbUtil.getConnection(dbParams_imaging);
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try
		{	String q = query;
		   
			ps = con.prepareStatement(q);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				InvSupData.add(rs.getString("invSuppName"));
				
				
			}
					}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return InvSupData;
	}
	
	private static ArrayList<String> getWFTData(ArrayList<String> invSuppName, String wft_query) throws SQLException {

		
		ArrayList<String> invSuppNameAP = new ArrayList<String>();

		String env = propMap.get("ENV");
		Map<String, String> dbParams_WFT = new HashMap<String, String>();
		

		DatabaseUtility dbUtil = new DatabaseUtility();
		if (env != null) {
			dbParams_WFT.put("HOST", propMap.get("HOSTBPM_" + env));
			dbParams_WFT.put("USER", propMap.get("USERBPM_" + env));
			dbParams_WFT.put("PASSWORD", propMap.get("PASSWORDBPM_" + env));
		}
		Connection con3 = dbUtil.getConnection(dbParams_WFT);
		ResultSet rs3 = null;
		PreparedStatement ps3 = null;
		
		try {
			ps3 = con3.prepareStatement(wft_query);
			rs3 = ps3.executeQuery();
			while (rs3.next()) {
				invSuppNameAP.add(rs3.getString("invSuppNameAP"));

			}
			// System.out.println("invSuppName :" + invSuppName);
			// System.out.println("invSuppName Size :" + invSuppName.size());

			// System.out.println("invSuppNameAP :" + invSuppNameAP);
			// System.out.println("invSuppNameAP Size :" + invSuppNameAP.size());

			invSuppName.removeAll(invSuppNameAP);
			// System.out.println("invSuppName after compare :" + invSuppName);

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			con3.close();
			rs3.close();
			ps3.close();
		}
		return invSuppName;

	}

	public static Map<String, String> getProperties() {
		Map<String, String> propMap = new HashMap<String, String>();
		try {

			InputStream reader = Utility.class.getClassLoader().getResourceAsStream("config.properties");
			Properties p = new Properties();
			p.load(reader);
			Set set = p.entrySet();

			Iterator itr = set.iterator();
			while (itr.hasNext()) {
				Map.Entry entry = (Map.Entry) itr.next();
				propMap.put(entry.getKey().toString(), entry.getValue().toString());
			}

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return propMap;
	}

	public static ArrayList<ArrayList<String>> getImagingData(String query, String flag) throws SQLException
	{
		
		MultiValueMap captureidMap_apException = new MultiValueMap();
		ArrayList<String> captureidList_certifier = new ArrayList<String>(); 
		ArrayList<ArrayList<String>> imaging_captureid_list = new ArrayList<ArrayList<String>>(); 
		String env = propMap.get("ENV");
		Map<String, String> dbParams_imaging = new HashMap<String, String>();
		DatabaseUtility dbUtil = new DatabaseUtility();
		Connection con = null;
		

		
		if (env != null) {
			dbParams_imaging.put("HOST", propMap.get("HOST_" + env));
			dbParams_imaging.put("USER", propMap.get("USER_" + env));
			dbParams_imaging.put("PASSWORD", propMap.get("PASSWORD_" + env));
		}
		
		con = dbUtil.getConnection(dbParams_imaging);
		ResultSet rs = null;
		PreparedStatement ps = null;
		try
		{	String q = query;
			ps = con.prepareStatement(q);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (flag.equals("apException")){
					
					captureidMap_apException.put(rs.getString("captureBachid"),rs.getString("status"));
					//captureidMap_apException.put(rs.getString("ddocname"),rs.getString("status"));
				
				}
			
				else if(flag.equals("certifier"))
				{
					captureidList_certifier.add(rs.getString("captureBachid"));
					imaging_captureid_list.add(captureidList_certifier);
					
				}
				
			}
			
			if (flag.equals("apException")) {
				imaging_captureid_list = getKeys(captureidMap_apException, "Invoice Updated by APGroup");
				return imaging_captureid_list;
			}
			else if(flag.equals("certifier"))
			{
				return imaging_captureid_list;
			}
			
			/*System.out.println("firstList :" + imaging_captureid_list.get(0));
			System.out.println("firstList size:" + imaging_captureid_list.get(0).size());

			System.out.println("secondList :" + imaging_captureid_list.get(1));
			System.out.println("secondList :" + imaging_captureid_list.get(1).size());
			*/
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			con.close();
			ps.close();
			rs.close();
			
		}
		return null;
		
	}
	
	public static ArrayList<ArrayList<String>> getKeys (MultiValueMap map, String value)
	{
		ArrayList<ArrayList<String>> listOflist = new ArrayList<ArrayList<String>>();
		ArrayList firstList=new ArrayList();
		ArrayList secondList=new ArrayList();
		List list = null;
		Set entrySet = map.entrySet();
		Iterator it = entrySet.iterator();
		while (it.hasNext()) {
		Map.Entry mapEntry = (Map.Entry) it.next();
		list = (List) map.get(mapEntry.getKey());
		for (int j = 0; j < list.size(); j++) {
		 if (list.get(j).equals("Invoice Updated by APGroup")) {
			 firstList.add(mapEntry.getKey().toString());
			 //return mapEntry.getKey().toString();
			 
		 }else {
			 secondList.add(mapEntry.getKey().toString());
			 
		 	}
		 }
		
}
		listOflist.add(firstList);
		listOflist.add(secondList);
		
		/*System.out.println("firstList :" + firstList);
		System.out.println("firstList :" + firstList.size());
		System.out.println("secondList :" + secondList);
		System.out.println("secondList :" + secondList.size());*/

 

return listOflist;
		
	}


	public static ArrayList<ArrayList<String>> getBPMData(ArrayList<String> capture_id_List, String flag) throws SQLException

	{
		//System.out.println("Insidie the getBPMData");
		ArrayList<String> result_List = new ArrayList<String>();
		ArrayList<String> result_List_status = new ArrayList<String>();
		ArrayList<String> result_list_all = new ArrayList<String>();
		ArrayList<ArrayList<String>> bpm_return_list = new ArrayList<ArrayList<String>>();

		result_List.clear();
		result_List_status.clear();
		result_list_all.clear();

		String env = propMap.get("ENV");
		Map<String, String> dbParams_BPM = new HashMap<String, String>();

		DatabaseUtility dbUtil = new DatabaseUtility();
		if (env != null) {
			dbParams_BPM.put("HOST", propMap.get("HOSTBPM_" + env));
			dbParams_BPM.put("USER", propMap.get("USERBPM_" + env));
			dbParams_BPM.put("PASSWORD", propMap.get("PASSWORDBPM_" + env));
		}
		
		try {

			

			if (capture_id_List.size() > 999) {

				ArrayList<ArrayList<String>> parts = new ArrayList<ArrayList<String>>();
				ArrayList<String> subPart = new ArrayList<String>();

				final int size = capture_id_List.size();
				for (int i = 0; i < size; i += 600) {
					parts.add(new ArrayList<String>(capture_id_List.subList(i, Math.min(size, i + 600))));
				}
				for (int i = 0; i < parts.size(); i++) {
					subPart = parts.get(i);
					

					String query = "select invoice_number,modified_on,modified_by,site_id,header_attr7,internal_status,supplier_name from js_ap_invoice_table where modified_on > '16-OCT-22' and header_attr7 in (";
					StringBuilder queryBuilder = new StringBuilder(query);
					for (int j = 0; j < subPart.size(); j++) {
						queryBuilder.append(" ?");
						if (j != subPart.size() - 1)
							queryBuilder.append(",");
					}
					queryBuilder.append(")");

					String execute_query = queryBuilder.toString();
					

					try (Connection connection = dbUtil.getConnection(dbParams_BPM);
							PreparedStatement ps = connection.prepareStatement(execute_query)) {

						ResultSet rs = null;

						int parameterIndex = 1;
						for (Iterator<String> iterator = subPart.iterator(); iterator.hasNext();) {
							String id = (String) iterator.next();
							ps.setString(parameterIndex++, id);

						}
						rs = ps.executeQuery();
						while (rs.next()) {
							if (flag.equals("apException")) {
								if ((!rs.getString("internal_status").contains("INVOICE IN AP EXCEPTIONS"))
										&& (!rs.getString("internal_status").toUpperCase()
												.contains("Invoice Rejected By Certifier".toUpperCase()))) {
									result_List.add(rs.getString("header_attr7"));
									result_List_status.add(rs.getString("internal_status"));
								}
							} else if (flag.equals("certifier")) {
								if (!rs.getString("internal_status").contains("INVOICE PENDING FOR CERTIFICATION")) {
									result_List.add(rs.getString("header_attr7"));
									result_List_status.add(rs.getString("internal_status"));
								}
							}

							result_list_all.add(rs.getString("header_attr7"));
							result_list_all.removeAll(capture_id_List);
						}

						rs.close();
						ps.close();
						connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			} else {
				// System.out.println("Inside else");
				// System.out.println("capture_id_List.size" + capture_id_List.size());
				String query = "select invoice_number,modified_on,modified_by,site_id,header_attr7,internal_status,supplier_name from js_ap_invoice_table where modified_on > '16-OCT-22' and header_attr7 in (";
				StringBuilder queryBuilder = new StringBuilder(query);
				for (int i = 0; i < capture_id_List.size(); i++) {
					queryBuilder.append(" ?");
					if (i != capture_id_List.size() - 1)
						queryBuilder.append(",");
				}
				queryBuilder.append(")");

				String execute_query = queryBuilder.toString();

				try (Connection connection = dbUtil.getConnection(dbParams_BPM);
						PreparedStatement ps = connection.prepareStatement(execute_query)) {

					ResultSet rs = null;

					int parameterIndex = 1;
					for (Iterator<String> iterator = capture_id_List.iterator(); iterator.hasNext();) {
						String id = (String) iterator.next();
						ps.setString(parameterIndex++, id);

					}

					rs = ps.executeQuery();
					while (rs.next()) {

						if (flag.equals("apException")) {
							if ((!rs.getString("internal_status").contains("INVOICE IN AP EXCEPTIONS"))
									&& (!rs.getString("internal_status").toUpperCase()
											.contains("Invoice Rejected By Certifier".toUpperCase()))) {
								result_List.add(rs.getString("header_attr7"));
								result_List_status.add(rs.getString("internal_status"));
							}
						} else if (flag.equals("certifier")) {
							if (!rs.getString("internal_status").contains("INVOICE PENDING FOR CERTIFICATION")) {
								result_List.add(rs.getString("header_attr7"));
								result_List_status.add(rs.getString("internal_status"));
							}
						}
						result_list_all.add(rs.getString("header_attr7"));
						result_list_all.removeAll(capture_id_List);
					}

					rs.close();
					ps.close();
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			bpm_return_list.add(result_List);
			bpm_return_list.add(result_List_status);
			bpm_return_list.add(result_list_all);

			// System.out.println("result_List :" + result_List);
			// System.out.println("result_List :" + result_List.size());

			// System.out.println("result_List_status :" + result_List_status);
			// System.out.println("result_List_status :" + result_List_status.size());

			// System.out.println("result_list_all :" + result_list_all.size());

			// System.out.println("Mismatch list :" + bpm_return_list);
			// System.out.println("Size:" + bpm_return_list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bpm_return_list;

	}

	public static void sendMail(ArrayList<ArrayList<String>> capture_id_List_apException,ArrayList<ArrayList<String>> bpm_id_List_apException, ArrayList<String> WFT_list_apException,
			ArrayList<ArrayList<String>> bpm_id_List_certifier, ArrayList<String> WFT_list_certifier) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		String date = dateFormat.format(cal.getTime());
		// System.out.println("Date :" + date);

		Properties mailProp = new Properties();
		mailProp.put("mail.smtp.auth", propMap.get("mail.smtp.auth"));
		mailProp.put("mail.smtp.port", propMap.get("mail.smtp.port"));
		mailProp.put("mail.smtp.starttls.enable", propMap.get("mail.smtp.starttls.enable"));
		mailProp.put("mail.smtp.host", propMap.get("mail.smtp.host"));
		mailProp.put("mail.transport.protocol", propMap.get("mail.transport.protocol"));
		// System.out.println("Pro: " + mailProp.toString());
		String env = propMap.get("ENV");

		String bodyText_missing_data = "";
		String wft_ap = "";
		String bodyText_missing_certi = "";
		String wft_certi = "";

		for (String missing_data : bpm_id_List_apException.get(2)) {
			bodyText_missing_data = bodyText_missing_data + "<p>" + missing_data + "</p>";
		}

		for (String wft_ap_data : WFT_list_apException) {
			wft_ap = wft_ap + "<p>" + wft_ap_data + "</p>";
		}

		for (String missing_data_certi : bpm_id_List_certifier.get(2)) {
			bodyText_missing_certi = bodyText_missing_certi + "<p>" + missing_data_certi + "</p>";
		}

		for (String wft_ap_data_certi : WFT_list_certifier) {
			wft_certi = wft_certi + "<p>" + wft_ap_data_certi + "</p>";
		}

		Session session = Session.getDefaultInstance(mailProp);
		Message msg = new MimeMessage(session);
		try {
			String msgEmp = "";
			String bodyText = "";
			bodyText = "<p>Hi All,</p></br><p>Please find the details of missmatch data in " + env + " for the date of "
					+ date + "</p><p><b><u>Missmatch data between IMAGING and BPM for AP Exception</u>: </b>"
					+ (bpm_id_List_apException.get(0).size() + capture_id_List_apException.get(0).size())
					+ " </p></br><table border='1'><tr><th>Capture Batch ID</th><th>Status</th>";

			ArrayList<String> id_List = new ArrayList<String>();
			ArrayList<String> status_List = new ArrayList<String>();
			id_List = bpm_id_List_apException.get(0);
			status_List = bpm_id_List_apException.get(1);
			
			ArrayList<String> capture_id_apException = new ArrayList<String>();
			capture_id_apException = capture_id_List_apException.get(0);

			for (int i = 0; i < id_List.size(); i++) {

				msgEmp = msgEmp + "<tr><td>" + id_List.get(i) + "</td>" + "<td>" + status_List.get(i) + "</td></tr>";
			}
			
			for (int i = 0; i < capture_id_apException.size(); i++) {

				msgEmp = msgEmp + "<tr><td>" + capture_id_apException.get(i) + "</td>" + "<td>" + "Invoice Updated by APGroup" + "</td></tr>";
			}
			

			bodyText = bodyText + msgEmp
					+ "</table><p><b><u>Capture Batch ID which are missing in js_ap_invoice_table but present in Imaging for AP Exception</u>: </b>"
					+ bpm_id_List_apException.get(2).size() + "</p></br><p>" + bodyText_missing_data
					+ "</p></br><p><b><u>Missmatch data between Imaging and WF TASK for AP Exception</u>: </b>"
					+ WFT_list_apException.size() + "</p></br><p>" + wft_ap
					+ "</p></br><p><b><u>Missmatch data between IMAGING and BPM for Certification</u>: </b>"
					+ bpm_id_List_certifier.get(0).size()
					+ " </p></br><table border='1'><tr><th>Capture Batch ID</th><th>Status</th>";

			ArrayList<String> id_List_certifier = new ArrayList<String>();
			ArrayList<String> status_List_certifier = new ArrayList<String>();
			id_List_certifier = bpm_id_List_certifier.get(0);
			status_List_certifier = bpm_id_List_certifier.get(1);

			String msgEmp_certi = "";
			for (int i = 0; i < id_List_certifier.size(); i++) {

				msgEmp_certi = msgEmp_certi + "<tr><td>" + id_List_certifier.get(i) + "</td>" + "<td>"
						+ status_List_certifier.get(i) + "</td></tr>";
			}

			bodyText = bodyText + msgEmp_certi
					+ "</table><p><b><u>Capture Batch ID which are missing in js_ap_invoice_table but present in Imaging for Certification</u>: </b>"
					+ bpm_id_List_certifier.get(2).size() + "</p></br><p>" + bodyText_missing_certi
					+ "</p></br><p><b><u>Missmatch data between Imaging and WF TASK for Certification</u>: </b>"
					+ WFT_list_certifier.size() + "</p></br><p>" + wft_certi
					+ "</p></br><p>Kindly check logs for error occurred.</p></br><p>Regards</p></br><p>eQ OWC Support Team</p>";

			msg.setFrom(new InternetAddress(propMap.get("mail.from.address")));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(propMap.get("mail.receiver.list")));
			msg.setSubject(propMap.get("mail.subject.line"));
			msg.setSentDate(new java.util.Date());
			// msg.setContent("<p>Hi All,</p></br><p>Please find the details of missmatch
			// data in "+env+" for the date of "+date+"</p><p><b><u>Capture Batch ID which
			// are not in INVOICE IN AP EXCEPTIONS status</u>:
			// </b>"+bpm_id_List.get(0).size()+"
			// </p></br><p>"+bpm_id_List.get(0)+"</p></br><p><b><u>Capture Batch ID which
			// are missing in js_ap_invoice_table</u>:
			// </b>"+bpm_id_List.get(1).size()+"</p></br><p>"+bpm_id_List.get(1)+"</p></br><p><b><u>Invoice
			// Supplier Name which are missing in wftask table</u>:
			// </b>"+WFT_list.size()+"</p></br><p>"+WFT_list+"</p></br><p>Kindly check logs
			// for error occurred.</p></br><p>Regards</p></br><p>eQ OWC Support Team</p>",
			// "text/html; charset=utf-8");

			msg.setContent(bodyText, "text/html; charset=utf-8");
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
