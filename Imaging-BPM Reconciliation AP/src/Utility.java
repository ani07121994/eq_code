// prod code for qantas
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
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
//import java.util.stream.Collectors;
//import org.apache.commons.collections4.ListUtils;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Utility {
	public static Map<String, String> propMap = null;
	public static ArrayList<ArrayList<String>> capture_id_List = null;
	public static ArrayList<String> missmatch_id_List = new ArrayList<String>();  
	public static ArrayList<ArrayList<String>> bpm_id_List = null;
	public static ArrayList<String> WFT_list = null; 
	public static ArrayList<ArrayList<String>> capture_id_List_certifier = null;
	public static ArrayList<ArrayList<String>> bpm_id_List_certifier = null;
	public static ArrayList<String> WFT_list_certifier = null;

	
	public static final String wft_query = "Select textattribute1||textattribute6 invSuppNameAP from SOAPROD12C_SOAINFRA.wftask where state like 'ASSIGNED%' and TITLE ='AP Invoice Error'\r\n" + 
			"and processname ='JetStarIntegrationProcess'";

	public static void main(String[] args) throws SQLException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		 System.out.println("=========================== Program has started : ===========================" + dateFormat.format(date));
		 System.out.println("This is for the Qantas");
		 propMap = getProperties();
		 //System.out.println("propMap :" + propMap);
		 
		 capture_id_List = new ArrayList<ArrayList<String>>();
         capture_id_List = getImagingData(propMap.get("imaging_query1"));
		 //System.out.println("capture_id_List : " + capture_id_List.get(0).size());
		// System.out.println("capture_id_List statuses: " + capture_id_List.get(0));

		 
		 bpm_id_List = new ArrayList<ArrayList<String>>();
		 //bpm_id_List = getBPMData(capture_id_List.get(0),propMap.get("STATUS_AP1"),propMap.get("STATUS_AP2"));
		 String apException = "apException";
		 bpm_id_List = getBPMData(capture_id_List.get(0), apException);
		 //System.out.println("bpm_id_List : " + bpm_id_List);
		 System.out.println("Number of Missmatch data between IMAGING and BPM for Ap Exception: " + bpm_id_List.get(0).size());
		 System.out.println("Missmatch data between IMAGING and BPM for Ap Exception: " + bpm_id_List.get(0) + "and their status : " + bpm_id_List.get(1));
		 System.out.println("Capture Batch ID which are missing in js_ap_invoice_table but present in Imaging : "+ bpm_id_List.get(2));

		 
		 WFT_list = new ArrayList<String>();
		 WFT_list = getWFTData(capture_id_List.get(1),propMap.get("wft_query1"));
		 System.out.println("Number of Missmatch data between Imaging and WF TASK for Ap Exception: " + WFT_list.size());
		 System.out.println("Missmatch data between Imaging and WF TASK for Ap Exception: " + WFT_list);
	
		 
		 capture_id_List_certifier = new ArrayList<ArrayList<String>>();
	     capture_id_List_certifier = getImagingData(propMap.get("imaging_query2"));
	     
		 bpm_id_List_certifier = new ArrayList<ArrayList<String>>();
		 String certifier = "certifier";
		 //bpm_id_List_certifier = getBPMData(capture_id_List_certifier.get(0),propMap.get("STATUS_CERTIFICATE1"),propMap.get("STATUS_CERTIFICATE2"));
		 bpm_id_List_certifier = getBPMData(capture_id_List_certifier.get(0), certifier);

		 //System.out.println("bpm_id_List_certifier : " + bpm_id_List_certifier);
		 //System.out.println("bpm_id_List_certifier : " + bpm_id_List_certifier.get(0).size());
		 System.out.println("Number of Missmatch data between IMAGING and BPM for certifier: " + bpm_id_List_certifier.get(0).size());
		 System.out.println("Missmatch data between IMAGING and BPM for certifier: " + bpm_id_List_certifier.get(0) + "and their status : " + bpm_id_List_certifier.get(1));
		 System.out.println("Capture Batch ID which are missing in js_ap_invoice_table but present in Imaging for certifier: "+ bpm_id_List_certifier.get(2));

		 WFT_list_certifier = new ArrayList<String>();
		 WFT_list_certifier = getWFTData(capture_id_List_certifier.get(1),propMap.get("wft_query2"));
		 System.out.println("No of Missmatch data between Imaging and WF TASK for certifier: " + WFT_list_certifier.size());
		 System.out.println("Missmatch data between Imaging and WF TASK for certifier: " + WFT_list_certifier);
		 

		 
		 
		 
		 
		 if ((bpm_id_List != null && bpm_id_List.size()> 0) || (WFT_list.size()>0) || (bpm_id_List_certifier != null && bpm_id_List_certifier.size()> 0) || (WFT_list_certifier.size()>0)) {
			 if((bpm_id_List.get(0) != null && bpm_id_List.get(0).size()>0) || 
						(bpm_id_List.get(1) != null && bpm_id_List.get(1).size()>0) || (WFT_list != null && WFT_list.size()>0) ||
						(bpm_id_List_certifier.get(0) != null && bpm_id_List_certifier.get(0).size()>0) || (bpm_id_List_certifier.get(1) != null && bpm_id_List_certifier.get(1).size()>0)
						|| (WFT_list_certifier != null && WFT_list_certifier.size()>0) )  {
				 
				 System.out.println("Mail will trigger");
				 sendMail(bpm_id_List,WFT_list,bpm_id_List_certifier,WFT_list_certifier);
				 
			 }
			 
		 }

		System.out.println("Closed");


	}
	
	
	
	
	private static ArrayList<String> getWFTData(ArrayList<String> invSuppName, String wft_query) throws SQLException {
		
		//System.out.println("Insidie the getWFTData");
		//invSuppName.clear();
		ArrayList<String> invSuppNameAP = new ArrayList<String>(); 

		String env = propMap.get("ENV");
		Map<String, String> dbParams_WFT = new HashMap<String, String>();
		//ArrayList<String> invSuppNameAP = new ArrayList<String>(); 
		//invSuppNameAP.clear();



		DatabaseUtility dbUtil = new DatabaseUtility();
		if (env != null) {
			dbParams_WFT.put("HOST", propMap.get("HOSTBPM_" + env));
			dbParams_WFT.put("USER", propMap.get("USERBPM_" + env));
			dbParams_WFT.put("PASSWORD", propMap.get("PASSWORDBPM_" + env));
		}
		Connection con3 = dbUtil.getConnection(dbParams_WFT);
		ResultSet rs3 = null;
		PreparedStatement ps3 = null;
		//System.out.println("con for 12C: " + con3);
		try
		{
			ps3 = con3.prepareStatement(wft_query);
			rs3 = ps3.executeQuery();
			while (rs3.next()) {
				invSuppNameAP.add(rs3.getString("invSuppNameAP"));
					
			}
			
			
			invSuppName.removeAll(invSuppNameAP);
			//System.out.println("invSuppName after compare :" + invSuppName);

		}
		
		catch(Exception e)
		{
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
				propMap.put(entry.getKey().toString(), entry.getValue()
						.toString());
			}

		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return propMap;
	}
	
	public static ArrayList<ArrayList<String>> getImagingData(String query) throws SQLException
	{
		ArrayList<ArrayList<String>> imaging_List = null;
		imaging_List = new ArrayList<ArrayList<String>>();
		ArrayList<String> capture_List = new ArrayList<String>(); 
		ArrayList<String> capture_statuses = new ArrayList<String>(); 
		ArrayList<String> supplierNM_imaging = new ArrayList<String>();
		ArrayList<String> capture_id_list = new ArrayList<String>();
		


/*		imaging_List.clear();
		capture_List.clear();
		supplierNM_imaging.clear();*/
		//System.out.println("Insidie the getImagingData");
		String env = propMap.get("ENV");
		Map<String, String> dbParams_imaging = new HashMap<String, String>();
		DatabaseUtility dbUtil = new DatabaseUtility();
		Connection con = null;
		//ArrayList<String> capture_List = new ArrayList<String>();  

		
		if (env != null) {
			dbParams_imaging.put("HOST", propMap.get("HOST_" + env));
			dbParams_imaging.put("USER", propMap.get("USER_" + env));
			dbParams_imaging.put("PASSWORD", propMap.get("PASSWORD_" + env));
		}
		
		con = dbUtil.getConnection(dbParams_imaging);
		ResultSet rs = null;
		PreparedStatement ps = null;
		//System.out.println("con for 12C: " + con);
		try
		{	String q = query;
		    //System.out.println("Q : " + q);
			ps = con.prepareStatement(q);
			rs = ps.executeQuery();
			while (rs.next()) {
				String status = rs.getString("status");
				
				//Code Added by Raya for getting the list of imaging IDs whose ststus is other than "Invoice AP Exception"
				/*if(status.contains("Invoice Rejected By Certifier")) {
					capture_id_list.add(rs.getString("captureBachid"));
				}*/
				capture_List.add(rs.getString("captureBachid"));
				supplierNM_imaging.add(rs.getString("invSuppName"));	
				
			}
			//capture_List.removeAll(capture_id_list);// Removing All imaging Ids other than "Invoice In AP Exceptions"
			imaging_List.add(capture_List);
			imaging_List.add(supplierNM_imaging);
			imaging_List.add(capture_statuses);
			//imaging_List.add(capture_id_list);
			
			/*System.out.println("capture_List :" + capture_List);
			System.out.println("supplierNM_imaging :" + supplierNM_imaging);*/
			//System.out.println("imaging_List :" + imaging_List);
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
			capture_List = null;
			supplierNM_imaging  = null;
			capture_statuses = null;
		}
		return imaging_List;
		
	}

	
	//public static ArrayList<ArrayList<String>> getBPMData( ArrayList<String> capture_id_List, String status1, String status2) throws SQLException
	public static ArrayList<ArrayList<String>> getBPMData( ArrayList<String> capture_id_List, String flag) throws SQLException

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
		//con1 = dbUtil.getConnection(dbParams_BPM);
		//System.out.println("con1 : " + con1);
		try {
			
			if(capture_id_List.size()>999)
			{
				//System.out.println("Insise in ");
				//System.out.println("capture_id_List.size" + capture_id_List.size());
			        
				ArrayList<ArrayList<String>> parts = new ArrayList<ArrayList<String>>();
			        ArrayList<String> part11 = new ArrayList<String>();

			        final int N = capture_id_List.size();
			       for (int i = 0; i < N; i += 600) {
			            parts.add(new ArrayList<String>(
			            		capture_id_List.subList(i, Math.min(N, i + 600))));
			           // System.out.println("parts abc :" + parts.get(i));
				       // System.out.println("parts abc size:" + parts.get(i).size());
			        }
			       //System.out.println("parts abc :" + parts);
			       for(int i = 0; i<parts.size(); i++)
			       {
			    	   part11 = parts.get(i);
			    	   //System.out.println("part11 :" + part11);
			    	   
						String query = "select invoice_number,modified_on,modified_by,site_id,attr7,internal_status,supplier_name from ap_invoice_table where modified_on > '16-OCT-22' and attr7 in (";
				        StringBuilder queryBuilder = new StringBuilder(query);
				        for (int j = 0; j < part11.size(); j++) {
				            queryBuilder.append(" ?");
				            if (j != part11.size() - 1)
				                queryBuilder.append(",");
				        }
				        queryBuilder.append(")");
				       
				        
				        String query1 =  queryBuilder.toString();
				        //System.out.println("Query=" + query1);
				        
				        try (Connection connection =  dbUtil.getConnection(dbParams_BPM);
								 PreparedStatement ps = connection.prepareStatement(query1)){
				        	
				            ResultSet rs = null;

				            int parameterIndex = 1;
				            for (Iterator < String > iterator = part11.iterator(); iterator.hasNext();) {
				                String id = (String) iterator.next();
				                ps.setString(parameterIndex++, id);
				                
				            }
				            //System.out.println("ps :" + ps);
				            rs = ps.executeQuery();
				            while (rs.next()) {
				            	
				            	//INVOICE IN AP EXCEPTIONS - ap exception
				            	//INVOICE PENDING FOR CERTIFICATION - certi
				            	//Invoice Rejected By Certifier : Pending with AP Exceptions  - Raya - need to discuss with kakali di
				            	//&& !statusValue.contains("Invoice Rejected By Certifier")
				            	//String statusValue = rs.getString("internal_status");
				            	if(flag.equals("apException"))
				            	{
				            	if((!rs.getString("internal_status").contains("INVOICE IN AP EXCEPTIONS")) && (!rs.getString("internal_status").toUpperCase().contains("Invoice Rejected By Certifier".toUpperCase()))
				            			&& (!rs.getString("internal_status").contains("INVOICE IN AP INTERFACE"))) {
									result_List.add(rs.getString("attr7"));
									result_List_status.add(rs.getString("internal_status"));
									}
				            }
				            	else if(flag.equals("certifier"))
				            	{
				            	if((!rs.getString("internal_status").contains("INVOICE PENDING FOR CERTIFICATION")
				            			) && (!rs.getString("internal_status").contains("INVOICE IN AP INTERFACE")) && (!rs.getString("internal_status").contains("AUTO REJECTED BY SYSTEM")
						            			) && (!rs.getString("internal_status").contains("INVOICE REJECTED BY AP GROUP")) && (!rs.getString("internal_status").contains("Invoice on Hold"))) {
									result_List.add(rs.getString("attr7"));
									result_List_status.add(rs.getString("internal_status"));
									}
				            }
				            
									result_list_all.add(rs.getString("attr7"));
									result_list_all.removeAll(capture_id_List);
				            }
				        	
				            rs.close();
				            ps.close();
				            connection.close();
				        }
				        catch(Exception e)
				        {
				        	e.printStackTrace();
				        }
			    	   
			    	   
			       }
			        
  
			}
			else
			{
				//System.out.println("Inside else");
				//System.out.println("capture_id_List.size" + capture_id_List.size());
				String query = "select invoice_number,modified_on,modified_by,site_id,attr7,internal_status,supplier_name from ap_invoice_table where modified_on > '16-OCT-22' and attr7 in (";
		        StringBuilder queryBuilder = new StringBuilder(query);
		        for (int i = 0; i < capture_id_List.size(); i++) {
		            queryBuilder.append(" ?");
		            if (i != capture_id_List.size() - 1)
		                queryBuilder.append(",");
		        }
		        queryBuilder.append(")");
		       
		        
		        String query1 =  queryBuilder.toString();
		        //System.out.println("Query=" + query1);
		        
		        try (Connection connection =  dbUtil.getConnection(dbParams_BPM);
						 PreparedStatement ps = connection.prepareStatement(query1)){
		        	
		            ResultSet rs = null;

		            int parameterIndex = 1;
		            for (Iterator < String > iterator = capture_id_List.iterator(); iterator.hasNext();) {
		                String id = (String) iterator.next();
		                ps.setString(parameterIndex++, id);
		                
		            }
		            //System.out.println("ps :" + ps);
		            rs = ps.executeQuery();
		            while (rs.next()) {
		                
		            	if(flag.equals("apException"))
		            	{
		            		if((!rs.getString("internal_status").contains("INVOICE IN AP EXCEPTIONS")) && (!rs.getString("internal_status").toUpperCase().contains("Invoice Rejected By Certifier".toUpperCase()))
			            			&& (!rs.getString("internal_status").contains("INVOICE IN AP INTERFACE")) && (!rs.getString("internal_status").contains("Invoice on Hold"))){
							result_List.add(rs.getString("attr7"));
							result_List_status.add(rs.getString("internal_status"));
							}
		            }
		            	else if(flag.equals("certifier"))
		            	{
		            		if((!rs.getString("internal_status").contains("INVOICE PENDING FOR CERTIFICATION")
			            			) && (!rs.getString("internal_status").contains("INVOICE IN AP INTERFACE")) && (!rs.getString("internal_status").contains("AUTO REJECTED BY SYSTEM")
					            			) && (!rs.getString("internal_status").contains("INVOICE REJECTED BY AP GROUP"))) {
							result_List.add(rs.getString("attr7"));
							result_List_status.add(rs.getString("internal_status"));
							}
		            }
							result_list_all.add(rs.getString("attr7"));
							result_list_all.removeAll(capture_id_List);
		            }
		        	
		            rs.close();
		            ps.close();
		            connection.close();
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }
			
			}
			
			bpm_return_list.add(result_List);
			bpm_return_list.add(result_List_status);
			bpm_return_list.add(result_list_all); 
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return bpm_return_list;
		
	}
	
	public static void sendMail( ArrayList<ArrayList<String>> bpm_id_List, ArrayList<String> WFT_list, ArrayList<ArrayList<String>> bpm_id_List_certifier, ArrayList<String> WFT_list_certifier) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		String date = dateFormat.format(cal.getTime());
		//System.out.println("Date :" + date);

		Properties mailProp = new Properties();
		mailProp.put("mail.smtp.auth", propMap.get("mail.smtp.auth"));
		mailProp.put("mail.smtp.port", propMap.get("mail.smtp.port"));
		mailProp.put("mail.smtp.starttls.enable", propMap.get("mail.smtp.starttls.enable"));
		mailProp.put("mail.smtp.host", propMap.get("mail.smtp.host"));
		mailProp.put("mail.transport.protocol", propMap.get("mail.transport.protocol"));
		//System.out.println("Pro: " + mailProp.toString());
		String env = propMap.get("ENV");
		
		String bodyText_missing_data = "";
		String wft_ap = "";
		String bodyText_missing_certi = "";
		String wft_certi = "";


		
		for(String missing_data : bpm_id_List.get(2)) {
			bodyText_missing_data=bodyText_missing_data+"<p>"+missing_data+"</p>";
		}
		
		for(String wft_ap_data : WFT_list) {
			wft_ap=wft_ap+"<p>"+wft_ap_data+"</p>";
		}
		
		for(String missing_data_certi : bpm_id_List_certifier.get(2)) {
			bodyText_missing_certi=bodyText_missing_certi+"<p>"+missing_data_certi+"</p>";
		}
		
		for(String wft_ap_data_certi : WFT_list_certifier) {
			wft_certi=wft_certi+"<p>"+wft_ap_data_certi+"</p>";
		}
		
		Session session = Session.getDefaultInstance(mailProp);
		Message msg = new MimeMessage(session);
		try {
			String msgEmp = "";
			String bodyText = "";
			 bodyText = "<p>Hi All,</p></br><p>Please find the details of missmatch data in "+env+" for the date of "+date+"</p><p><b><u>Missmatch data between IMAGING and BPM for AP Exception</u>: </b>"+bpm_id_List.get(0).size()+" </p></br>";
			 
			ArrayList<String> id_List = new ArrayList<String>(); 
			ArrayList<String> status_List = new ArrayList<String>();
			String msgEmp_certi = "";
			id_List = bpm_id_List.get(0);
			status_List = bpm_id_List.get(1);
			
			if(id_List.size()> 0 && status_List.size()>0) {
			bodyText = bodyText + "<table border='1'><tr><th>Capture Batch ID</th><th>Status</th>";
        	
	        for (int i = 0; i<id_List.size(); i++) {
	        	
	        	msgEmp = msgEmp + "<tr><td>" + id_List.get(i) + "</td>" + "<td>"
	                    + status_List.get(i) + "</td></tr>";
	        }
			}
			
	    bodyText = bodyText + msgEmp + "</table><p><b><u>Capture Batch ID which are missing in js_ap_invoice_table but present in Imaging for AP Exception</u>: </b>"+bpm_id_List.get(2).size()+"</p></br><p>"+bodyText_missing_data+"</p></br><p><b><u>Missmatch data between Imaging and WF TASK for AP Exception</u>: </b>"+WFT_list.size()+"</p></br><p>"+wft_ap+"</p></br><p><b><u>Missmatch data between IMAGING and BPM for Certification</u>: </b>"+bpm_id_List_certifier.get(0).size()+" </p></br>";
			
	    ArrayList<String> id_List_certifier = new ArrayList<String>(); 
		ArrayList<String> status_List_certifier = new ArrayList<String>(); 
		id_List_certifier = bpm_id_List_certifier.get(0);
		status_List_certifier = bpm_id_List_certifier.get(1);
		
		if(id_List_certifier.size()>0 && status_List_certifier.size() > 0) {
		bodyText = bodyText + "<table border='1'><tr><th>Capture Batch ID</th><th>Status</th>";
    	
		
        for (int i = 0; i<id_List_certifier.size(); i++) {
        	
        	msgEmp_certi = msgEmp_certi + "<tr><td>" + id_List_certifier.get(i) + "</td>" + "<td>"
                    + status_List_certifier.get(i) + "</td></tr>";
        }
			}
			
	    bodyText = bodyText + msgEmp_certi + "</table><p><b><u>Capture Batch ID which are missing in js_ap_invoice_table but present in Imaging for Certification</u>: </b>"+bpm_id_List_certifier.get(2).size()+"</p></br><p>"+bodyText_missing_certi+"</p></br><p><b><u>Missmatch data between Imaging and WF TASK for Certification</u>: </b>"+WFT_list_certifier.size()+"</p></br><p>"+wft_certi+"</p></br><p>Kindly check logs for error occurred.</p></br><p>Regards</p></br><p>eQ OWC Support Team</p>";

			msg.setFrom(new InternetAddress(propMap.get("mail.from.address")));
			msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(propMap.get("mail.receiver.list")));
		    msg.setSubject(propMap.get("mail.subject.line"));
		    msg.setSentDate(new java.util.Date());
		    //msg.setContent("<p>Hi All,</p></br><p>Please find the details of missmatch data in "+env+" for the date of "+date+"</p><p><b><u>Capture Batch ID which are not in INVOICE IN AP EXCEPTIONS status</u>: </b>"+bpm_id_List.get(0).size()+" </p></br><p>"+bpm_id_List.get(0)+"</p></br><p><b><u>Capture Batch ID which are missing in js_ap_invoice_table</u>: </b>"+bpm_id_List.get(1).size()+"</p></br><p>"+bpm_id_List.get(1)+"</p></br><p><b><u>Invoice Supplier Name which are missing in wftask table</u>: </b>"+WFT_list.size()+"</p></br><p>"+WFT_list+"</p></br><p>Kindly check logs for error occurred.</p></br><p>Regards</p></br><p>eQ OWC Support Team</p>", "text/html; charset=utf-8");
		    
		    msg.setContent(bodyText,"text/html; charset=utf-8");
		    Transport.send(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	

}
