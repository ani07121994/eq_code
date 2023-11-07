package ap.qantas.com.utility;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;






import java.io.File;
import java.io.FileInputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class WFRAutomationNotificationUtility {
	public static HashMap<String, String> propMap = new HashMap<String, String>();
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("WFRAutomationNotificationUtility :main : Started");
		if (!loadproperties()) {

			System.out.println("loadproperties not executed");
			System.out.println("--------Ending program-------");

			System.exit(0);
		}

		ArrayList<String> list_of_links = new ArrayList<String>();
		ArrayList<String> link_status = new ArrayList<String>();
		ArrayList<String> success_list = new ArrayList<String>();

		for (Object key : propMap.keySet()) {
			// System.out.println("Key : " + key.toString() + " Value : " +
			// propMap.get(key));
			String keyValue = key.toString();
			if (keyValue.contains("captureLink")
					|| keyValue.contains("verifierLink")
					|| keyValue.contains("imagingLink")
					|| keyValue.contains("bpmLink")
					|| keyValue.contains("bamLink")) {

				list_of_links.add(propMap.get(key));

			}
		}

		System.out
				.println("WFRAutomationNotificationUtility : main : no of links to be checked :"
						+ list_of_links.size());
		// System.out.println("name of links checked : captureLink, imagingLink, verifierLink, bpmLink, bamLink");

		for (String url : list_of_links) {
			try {
				// System.out.println("check links url :"+checkLinks(url));
				if (!checkLinks(url)){
					System.out.println("WFRAutomationNotificationUtility :: checkLinks(url)::::"+url);
					link_status.add(url);
				}
				else
					success_list.add(url);
			} catch (Exception e) {
				continue;
			}
		}

		if (link_status.size() == 0 || link_status == null) {
			System.out.println("WFRAutomationNotificationUtility :: All links working fine");
		} else {
			System.out.println("WFRAutomationNotificationUtility :: no of error links :" + link_status.size());
		}

		int no_of_wfr_import_files = countWFRImport();
		//int no_of_stuck_invoices = countStuckInvoices();
		int no_of_failed_instances = countFailedInterfaceInstance();
		
		int no_of_Error_recovery = countErrorForRecovery();
		//int no_of_eQ_interface_rejections = countEqInterfaceRejections();
		int no_of_Bad_images = countBadImages();
		int no_partial_success_files = countPartialSuccess();
		//int no_of_pending_certification = countPendingCertification();
		//int no_of_file_stuck_in_input_folder = countInputFolder();
		HashMap<String,Integer > stuckFileInfolder =  new HashMap<String,Integer >();		
		stuckFileInfolder = countInputFolder();
		 
		HashMap<String,Integer > stuckInvoices = countStuckInvoices();
		 
		//int no_of_ecm_invisible_records = countECMInvisibleRecords();// commented as part of 12c migration
		int no_of_ecm_invisible_records = 0;


	System.out.println("***************************");
	
	System.out.println("stuckFileInfolder "+propMap.get("HighPriorityLoc"));
		System.out.println("stuckFileInfolder "+propMap.get("HighPriorityLoc")+"   :: "+stuckFileInfolder.get(propMap.get("HighPriorityLoc")));
		System.out.println("stuckFileInfolder "+propMap.get("HighPriorityBadImg")+"   :: "+stuckFileInfolder.get(propMap.get("HighPriorityBadImg")));
		System.out.println("stuckFileInfolder "+propMap.get("NormalPriorityLoc")+"   :: "+stuckFileInfolder.get(propMap.get("NormalPriorityLoc")));
		System.out.println("stuckFileInfolder "+propMap.get("NormalPriorityBadImg")+"   :: "+stuckFileInfolder.get(propMap.get("NormalPriorityBadImg")));
		System.out.println("stuckFileInfolder "+propMap.get("NormalPriorityJunk")+"   :: "+stuckFileInfolder.get(propMap.get("NormalPriorityJunk")));
		System.out.println("stuckFileInfolder "+propMap.get("NormalPriorityJunkBadImg")+"   :: "+stuckFileInfolder.get(propMap.get("NormalPriorityJunkBadImg")));
		
		System.out.println("***************************");
		//int no_of_email_stuck_in_priorityap = 
		System.out.println("no of success links :" + success_list.size());
		System.out.println("WFR_IMPORT count :" + no_of_wfr_import_files);
		System.out.println("stuck invoice in 50/150/250/750/100 :");
				for (Map.Entry<String,Integer> entry : stuckInvoices.entrySet())  
		            System.out.println(entry.getKey() + 
		                             " : " + entry.getValue()); 
				
		System.out.println("no of failed instances :" + no_of_failed_instances);
		System.out.println("Error for recovery count :" + no_of_Error_recovery);
		/*System.out.println("eQ interface rejected count :"
				+ no_of_eQ_interface_rejections);*/
		System.out.println("no of bad images :" + no_of_Bad_images);
		System.out.println("no of partial success files :"
				+ no_partial_success_files);
		/*System.out.println("pending for certification count :"
				+ no_of_pending_certification);
		/*System.out.println("no of files stuck in input folder :"
				+ no_of_file_stuck_in_input_folder);*/
		System.out.println("no of invisible records in ECM :"
				+ no_of_ecm_invisible_records);
		
		
		
		//Mail Send Part
		
	//	MailFolderReading mailread= new 	MailFolderReading();	
		//HashMap<String, List<Integer> > countMail = mailread.checkMail();
		/*System.out.println("*************************");
		System.out.println("  link_status.size() :: "+link_status.size()+" :: no_of_wfr_import_files > 0 ::"+(no_of_wfr_import_files > 0));
		System.out.println("  !stuckInvoices.isEmpty() :: "+(!stuckInvoices.isEmpty())+" :: no_of_failed_instances > 0 ::"+(no_of_failed_instances > 0));
		System.out.println("  no_of_Error_recovery >0  :: "+(no_of_Error_recovery >0) +" :: no_of_Bad_images>0 ::"+(no_of_Bad_images>0));
		System.out.println("  no_partial_success_files>0  :: "+(no_partial_success_files>0) +" :: stuckFileInfolder.size()>0 ::"+(stuckFileInfolder.size()>0));*/
		
		//if(link_status.size() > 0 || no_of_wfr_import_files > 0 ||!stuckInvoices.isEmpty() || no_of_failed_instances > 0 ||no_of_Error_recovery >0 ||no_of_Bad_images>0 ||no_partial_success_files>0||stuckFileInfolder.size()>0){
		//	System.out.println("Calling sendmail ");
			sendMail(success_list,link_status,no_of_wfr_import_files,stuckInvoices,no_of_failed_instances,no_of_Error_recovery,no_of_Bad_images,stuckFileInfolder,no_partial_success_files,no_of_ecm_invisible_records);
		//}
	}

	private static void sendMail(ArrayList<String> success_list,ArrayList<String> link_status,int no_of_wfr_import_files, HashMap<String, Integer> stuckInvoices,int no_of_failed_instances, int no_of_Error_recovery,int no_of_Bad_images, HashMap<String,Integer >stuckFileInfolder,int no_partial_success_files,int no_of_ecm_invisible_records) {

		
		MailFolderReading mailread= new 	MailFolderReading();	
		HashMap<String, List<Integer> > countMail = mailread.checkMail();
		 List<Integer> cntNormalPriority = new ArrayList<Integer>();
		 List<Integer> cntHighPriority = new ArrayList<Integer>();
		 cntNormalPriority= countMail.get("cntNormalPriority");
		 cntHighPriority=countMail.get("cntHighPriority");
		
			System.out.println("Inside sendMail");
			Session session = null;
			String message = "<p>Hi All,</p>";
			if(link_status.size() > 0 || success_list.size() > 0){
				message += "<p>Please find the application and the server health status of OWC Application.Additionally,please find AP Automation system status below:</p>";
				}else{
				message += "<p>Please find AP Automation system status below:</p>";
			}
			message += "<table style = 'border: 1px solid black;border-collapse: collapse; collapse;width : 100%'>";
			message += "<tr><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Activity</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Module</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Date/Time</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Running Status</b></th></tr>";
			
			if(success_list.size() > 0 && !success_list.isEmpty() || link_status.size() > 0 && !link_status.isEmpty() || no_of_wfr_import_files >= 0 || !stuckInvoices.isEmpty()  || no_of_failed_instances >= 0 || no_of_Error_recovery >= 0  ||  !stuckFileInfolder.isEmpty()){
			
			try {
				
				/*CAPTURELINK=http://eqprod-capture1:16035/cs/
IMAGINGLINK=http://eqprod-capture1:16033/imaging/faces/Authentication/Login.jspx
VERIFIERLINK=http://eqprod-verifier1/WebVerifier/Login.aspx
BPMLINK=http://eqprod-soa-ap1:16035/bpm/workspace*/
				
					if(link_status.size() > 0){
						System.out.println("no of error links :"+link_status.size());
						for(String url : link_status){
							if(url.contains("http://eqprod-capture1:16035/cs/")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>CAPTURE</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Error"+"</td></tr>";
							}
							if(url.contains("http://eqprod-verifier1/WebVerifier/Login.aspx")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Verifier</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Error"+"</td></tr>";
							}
							if(url.contains("http://eqprod-capture1:16033/imaging/faces/Authentication/Login.jspx")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>IMAGING/ECM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Error"+"</td></tr>";								
							}
							
							if(url.contains("http://eqprod-soa-ap1:16035/bpm/workspace/faces/loginPage.jspx")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM Workspace</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Error"+"</td></tr>";
							}
							if(url.contains("http://eqprod-soa-ap1:16031/OracleBAM")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Oracle BAM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>BAM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Error"+"</td></tr>";
							}
						}
					}
					else if(success_list.size() > 0){
						
						for(String url : success_list){
							if(url.contains("http://eqprod-capture1:16035/cs/")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>CAPTURE</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Running Normal"+"</td></tr>";
							}
							if(url.contains("http://eqprod-verifier1/WebVerifier/Login.aspx")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Verifier</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Running Normal"+"</td></tr>";
							}
							if(url.contains("http://eqprod-capture1:16033/imaging/faces/Authentication/Login.jspx")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>IMAGING/ECM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Running Normal"+"</td></tr>";								
							}
							if(url.contains("http://eqprod-soa-ap1:16035/bpm/workspace/faces/loginPage.jspx")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM Workspace</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Running Normal"+"</td></tr>";
							}
							if(url.contains("http://eqprod-soa-ap1:16031/OracleBAM")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Oracle BAM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>BAM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Running Normal"+"</td></tr>";
							}
						}
						
					}/*
							//message += "<p>All links of the application are working fine and all servers are up and running.</p>";
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>CAPTURE</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Running Normal"+"</td></tr>";
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>IMAGING/ECM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Running Normal"+"</td></tr>";
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Verifier</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Running Normal"+"</td></tr>";
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM Workspace</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Running Normal"+"</td></tr>";
								
					}*/
						
						/*message += "<table style = 'border: 1px solid black;border-collapse: collapse; collapse;width : 100%'>";
						message += "<tr><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Activity</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Module</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Time/Date</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Running Status</b></th></tr>";
						*/		/*<tr>
					    <th>Firstname</th>
					    <th>Lastname</th> 
					    <th>Age</th>
					  </tr>*/
					if(null !=stuckFileInfolder && !stuckFileInfolder.isEmpty())
						System.out.println("stuckFileInfolder size "+stuckFileInfolder.size());
						int stcflHighLoc=stuckFileInfolder.get(propMap.get("HighPriorityLoc"));
						int stcFlHighPriorityBadImg=stuckFileInfolder.get(propMap.get("HighPriorityBadImg"));
						int stcflNormalPriorityLoc=stuckFileInfolder.get(propMap.get("NormalPriorityLoc"));
						int stcflNormalPriorityBadImg=stuckFileInfolder.get(propMap.get("NormalPriorityBadImg"));
						int stcflNormalPriorityJunkLoc=stuckFileInfolder.get(propMap.get("NormalPriorityJunk"));
						int stcflNormalPriorityJunkBadImgLoc=stuckFileInfolder.get(propMap.get("NormalPriorityJunkBadImg"));
						
						try {
							System.out.println("Normal Priority size : "+cntNormalPriority.size());
							System.out.println("cntNormalPriority.get(0): "+cntNormalPriority.get(0));
							if(cntNormalPriority.get(0)==-2) {
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in Normal Priority folders </td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"'A3 BAD Request is throttled' Error Occurred"+"</td></tr>";
							}
						if(cntNormalPriority.get(0) >0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in Normal Priority Unprocessed folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cntNormalPriority.get(0)+"</td></tr>";
						if(cntNormalPriority.get(1) >0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in Normal Priority Unprocessed Junk folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cntNormalPriority.get(1)+"</td></tr>";
						if(cntNormalPriority.get(2) >0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in  Normal Priority Capture Error folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cntNormalPriority.get(2)+"</td></tr>";
						
						}catch(Exception ex) {
							System.out.println(" Normal Priority Mail box issue Occured " +ex.getMessage());
						}
						if(cntHighPriority.get(0) >0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in  High Priority Unprocessed folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cntHighPriority.get(0)+"</td></tr>";
						
						if(stcflHighLoc >0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>File stuck in "+propMap.get("HighPriorityLoc")+" </td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+stcflHighLoc+"</td></tr>";
						if(stcFlHighPriorityBadImg >0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>File stuck in "+propMap.get("HighPriorityBadImg")+" </td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+stcFlHighPriorityBadImg+"</td></tr>";
						
						if(stcflNormalPriorityLoc >0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>File stuck in "+propMap.get("NormalPriorityLoc")+" </td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+stcflNormalPriorityLoc+"</td></tr>";
						
						if(stcflNormalPriorityBadImg >0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>File stuck in "+propMap.get("NormalPriorityBadImg")+" </td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+stcflNormalPriorityBadImg+"</td></tr>";
						if(stcflNormalPriorityJunkLoc >0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>File stuck in "+propMap.get("NormalPriorityJunk")+" </td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+stcflNormalPriorityJunkLoc+"</td></tr>";
						
						if(stcflNormalPriorityJunkBadImgLoc >0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>File stuck in "+propMap.get("NormalPriorityJunkBadImg")+" </td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+stcflNormalPriorityJunkBadImgLoc+"</td></tr>";
					
						if(no_of_Bad_images > 0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Invoices rejected by WFR due to poor quality</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_Bad_images+"</td></tr>";
						if(!stuckInvoices.isEmpty()){
							for (Map.Entry<String,Integer> entry : stuckInvoices.entrySet())  {
					            System.out.println("Mail  "+entry.getKey() + 
					                             " : " + entry.getValue()); 
					            message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Stuck Invoices ("+entry.getKey()+")</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+entry.getValue()+"</td></tr>";
							}
						}
						if(no_partial_success_files > 0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR export failure</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_partial_success_files+"</td></tr>";
						if(no_of_wfr_import_files > 0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Import</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_wfr_import_files+"</td></tr>";
						if(no_of_ecm_invisible_records > 0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>ECM Invisible Records</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_ecm_invisible_records+"</td></tr>";
						if(no_of_Error_recovery > 0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Internal error occured</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_Error_recovery+"</td></tr>";
						/*if(no_of_pending_certification > 0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Assigned invoices to Admin User</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_pending_certification+"</td></tr>";*/
						if(no_of_failed_instances > 0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Invoices failed to insert record in AP interface</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_failed_instances+"</td></tr>";
						/*if(no_of_eQ_interface_rejections > 0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>AP interface rejection</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>eQ</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_eQ_interface_rejections+"</td></tr>";*/
						
					message += "</table><br>";
				    message += "Regards,<br>eQ OWC Support Team";
				    
				    System.out.println("*************************");
					System.out.println("  link_status.size() :: "+link_status.size()+" :: no_of_wfr_import_files > 0 ::"+(no_of_wfr_import_files > 0));
					System.out.println("  !stuckInvoices.isEmpty() :: "+(!stuckInvoices.isEmpty())+" :: no_of_failed_instances > 0 ::"+(no_of_failed_instances > 0));
					System.out.println("  no_of_Error_recovery >0  :: "+(no_of_Error_recovery >0) +" :: no_of_Bad_images>0 ::"+(no_of_Bad_images>0));
					System.out.println("  no_partial_success_files>0  :: "+(no_partial_success_files>0) +" :: stcflHighLoc >0 ::"+(stcflHighLoc >0));
					System.out.println("  stcFlHighPriorityBadImg >0  :: "+(stcFlHighPriorityBadImg >0) +" :: stcflNormalPriorityLoc >0 ::"+(stcflNormalPriorityLoc >0));
					System.out.println("  stcflNormalPriorityBadImg >0  :: "+(stcflNormalPriorityBadImg >0) +" :: stcflNormalPriorityJunkLoc >0::"+(stcflNormalPriorityJunkLoc >0));
					System.out.println("  stcflNormalPriorityJunkBadImgLoc >0  :: "+(stcflNormalPriorityJunkBadImgLoc >0) +" :: cntNormalPriority.get(0) >0 ::"+(cntNormalPriority.get(0) >0));
					
					System.out.println("  cntNormalPriority.get(1) >0  :: "+(cntNormalPriority.get(1) >0) +" :: cntNormalPriority.get(2) >0 ::"+(cntNormalPriority.get(2) >0)+":: cntHighPriority.get(0) >0 :: "+(cntHighPriority.get(0) >0));
					
				    if(link_status.size() > 0 || no_of_wfr_import_files > 0 ||!stuckInvoices.isEmpty() || no_of_failed_instances > 0 ||no_of_Error_recovery >0 ||no_of_Bad_images>0 ||no_partial_success_files>0||stcflHighLoc >0
				    		||stcFlHighPriorityBadImg >0 || stcflNormalPriorityLoc >0||stcflNormalPriorityBadImg >0||stcflNormalPriorityJunkLoc >0||stcflNormalPriorityJunkBadImgLoc >0||cntNormalPriority.get(0) >0||cntNormalPriority.get(1) >0||cntNormalPriority.get(2) >0||(cntNormalPriority.get(0)==-2)||cntHighPriority.get(0) >0){
				    	System.out.println(" Mail prop Initialise");
						Properties properties = System.getProperties();
						properties.setProperty("mail.smtp.host",propMap.get("smtpHost"));
						session = Session.getDefaultInstance(properties);
						Message msg = new MimeMessage(session);
						msg.setFrom(InternetAddress.parse(propMap.get("emailFrom"),false)[0]);
					
			            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(propMap.get("emailTo")));
			           
			            
			            msg.setSubject(propMap.get("emailSubject"));
			            msg.setSentDate(new java.util.Date());
			            msg.setContent(message, "text/html; charset=utf-8");
			            Transport.send(msg);
						
						
						System.out.println("WFR AP Automation Status Mail Sent Successfully");
				    }
			
		}catch(Exception e){
					e.printStackTrace();
				}
		
			}else{
				System.out.println("everything is woking fine");
			}
			
	
	}
	private static int countWFRImport() { // wfr_import
		System.out.println("WFRAutomationNotificationUtility :: countWFRImport Started ");
		try {
			int count = 0;

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					propMap.get("wfrJDBCUrl"), propMap.get("wfrUser"),
					propMap.get("wfrPwd"));

			PreparedStatement ps = con
					.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 = 'WFR_IMPORT' and xipm_app_1_31='P2P INVOICE'");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}
			rs.close();
			ps.close();
			con.close();
			System.out.println("WFRAutomationNotificationUtility :: countWFRImport :: count "+count);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	private static  HashMap<String,Integer >  countStuckInvoices() {
		System.out.println("WFRAutomationNotificationUtility :: countStuckInvoices :: Started ");
		 HashMap<String,Integer > stuckCount = new HashMap<String, Integer>();
		try {
			int count = 0;
			String state=null;
			

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					propMap.get("wfrJDBCUrl"), propMap.get("wfrUser"),
					propMap.get("wfrPwd"));

			PreparedStatement ps = con
					.prepareStatement("select STATE,count(*) from EQWFR.BATCH where STATE IN ('50','150','250','750','900','100') GROUP BY STATE");
					//.prepareStatement("select count(*) from EQWFR.BATCH where STATE IN ('50','150','250','750','900')");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(" WFRAutomationNotificationUtility :: countStuckInvoices ::Result Set");
				state=rs.getString(1);
				count = Integer.parseInt(rs.getString(2));
				System.out.println(" WFRAutomationNotificationUtility :: countStuckInvoices :: State :::::::::::::::::: "+state+" Count ::::: "+count);
				stuckCount.put(state, count);
				//count = Integer.parseInt(rs.getString(1));
				
				
			}

			con.close();
			
			
			//return count;
		} catch (Exception e) {
			e.printStackTrace();
			//return -1;
		}
		System.out.println("WFRAutomationNotificationUtility :: countStuckInvoices :: End ::  "+stuckCount.size());
		return stuckCount;

	}

	private static int countFailedInterfaceInstance() {
		System.out.println("WFRAutomationNotificationUtility :: countFailedInterfaceInstance :: Started ");
		try {
			int count = 0;

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					propMap.get("wfrJDBCUrl"), propMap.get("wfrUser"),
					propMap.get("wfrPwd"));

			/*PreparedStatement ps = con
					.prepareStatement("select count(*) from PROD_OCS.DOCMETA where XIPM_APP_1_1 like '%Invoice Failed%' and xipm_app_1_32='P2P INVOICE'");*/
			
			PreparedStatement ps = con.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 like '%Invoice Failed%' and (xipm_app_1_31='P2P INVOICE' or xipm_app_1_31='FINESSECOST')");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}

			rs.close();
			ps.close();
			con.close();			
			System.out.println("WFRAutomationNotificationUtility :: countFailedInterfaceInstance :: Count "+count);
			
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	private static int countErrorForRecovery() {

		try {
			int count = 0;

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					propMap.get("wfrJDBCUrl"), propMap.get("wfrUser"),
					propMap.get("wfrPwd"));

			PreparedStatement ps = con
					.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 like 'Internal%' and xipm_app_1_31='P2P INVOICE'");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}

			con.close();

			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	private static int countEqInterfaceRejections() {

		try {
			int count = 0;

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(
					propMap.get("eqJDBCUrl"), propMap.get("eqUser"),
					propMap.get("eqPwd"));

			PreparedStatement ps = con
					.prepareStatement("select count(*) from apps.ap_invoices_interface where attribute12 like '%IMGPROCESS%' and status = 'REJECTED' and source IN ('P2P PO BASED','P2P NON PO INVOICE')");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}

			con.close();

			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	private static int countBadImages() {

		int count = 0;
		try {
			String badImagesLocation = propMap.get("badImagesLocation");

			File[] file = new File(badImagesLocation).listFiles();

			for (File f : file) {
				if (f.getName().endsWith(".tif")) {
					count++;
				} else
					continue;
			}

			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	private static int countPartialSuccess() {

		int count = 0;
		try {
			String partialSuccessLocation = propMap
					.get("partialSuccessLocation");

			File[] file = new File(partialSuccessLocation).listFiles();
			if(null != file){
				for (File f : file) {
					if (f.getName().endsWith(".txt")) {
						count++;
					} else
						continue;
				}
			}
			System.out.println(" Number of files present in "+partialSuccessLocation+ " is "+count);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	private static int countPendingCertification() {

		try {
			int count = 0;

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					propMap.get("wfrJDBCUrl"), propMap.get("wfrUser"),
					propMap.get("wfrPwd"));
			PreparedStatement ps = con
					.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 like '%Invoice Pending Certification%' and xipm_app_1_0 = 'eqadmin' and xipm_app_1_31='P2P INVOICE'");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}

			con.close();

			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	
	private static  HashMap<String,Integer> countInputFolder() {
		System.out.println("WFRAutomationNotificationUtility :: countInputFolder :: Started");
		int count=0 ;
		 HashMap<String,Integer > folderCount =  new HashMap<String,Integer >();
		try {
			ArrayList<String> searchLocation = new ArrayList<String>();
					searchLocation.add(propMap.get("HighPriorityLoc")) ;
					searchLocation.add(propMap.get("HighPriorityBadImg")) ;
					searchLocation.add(propMap.get("NormalPriorityLoc")) ;
					searchLocation.add(propMap.get("NormalPriorityBadImg")) ;
					searchLocation.add(propMap.get("NormalPriorityJunk")) ;
					searchLocation.add(propMap.get("NormalPriorityJunkBadImg")) ;
					
			for(String str : searchLocation){
				if(null != str){
					//System.out.println("WFRAutomationNotificationUtility :: Search Location :: "+str);
					count=0;
					File[] file = new File(str).listFiles();
					if (null !=file){
						for (File f : file) {
							if (f.getName().endsWith(".tif")|| f.getName().endsWith(".pdf")) {
								count++;
							} else
								continue;
						}
					}
					folderCount.put(str, count);
					System.out.println("WFRAutomationNotificationUtility :: Number of files in "+str+"is "+count);
				}
			}
			

			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return folderCount;

	}
	/*private static int countInputFolder() {

		int count = 0;
		try {
			String inputFolderLocation = propMap.get("inputFolderLocation");

			File[] file = new File(inputFolderLocation).listFiles();

			for (File f : file) {
				if (f.getName().endsWith(".tif")) {
					count++;
				} else
					continue;
			}

			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}*/

	private static int countECMInvisibleRecords() { // invisible records ECM

		try {
			int count = 0;

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					propMap.get("wfrJDBCUrl"), propMap.get("wfrUser"),
					propMap.get("wfrPwd"));

			PreparedStatement ps = con
					//.prepareStatement("select count(*) from PROD_OCS.revisions where ddocname not in (select distinct(ddocname) from PROD_OCS.idctext2)");
					.prepareStatement("select count(*) FROM PROD_OCS.revisions WHERE ddocname NOT IN (SELECT DISTINCT(ddocname) from PROD_OCS.idctext1)");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}

			con.close();

			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public static boolean loadproperties() {

		try {
			System.out
					.println("WFRAutomationNotificationUtility :loadproperties : Started");
			Properties prop = new Properties();
			File file = new File("WFR_Notification.properties");
			FileInputStream fileInput = new FileInputStream(file);

			prop.load(fileInput);

			propMap.put("badImagesLocation",
					prop.getProperty("BADIMAGESLOCATION"));
			propMap.put("partialSuccessLocation",
					prop.getProperty("PARTIALSUCCESSLOCATION"));
			propMap.put("inputFolderLocation",
					prop.getProperty("INPUTFOLDERLOCATION"));

			propMap.put("smtpHost", prop.getProperty("SMTPHOST"));
			propMap.put("emailSubject", prop.getProperty("EMAILSUBJECT"));
			propMap.put("emailTo", prop.getProperty("EMAILTO"));
			propMap.put("emailFrom", prop.getProperty("EMAILFROM"));

			propMap.put("captureLink", prop.getProperty("CAPTURELINK"));
			propMap.put("imagingLink", prop.getProperty("IMAGINGLINK"));
			propMap.put("verifierLink", prop.getProperty("VERIFIERLINK"));
			propMap.put("bpmLink", prop.getProperty("BPMLINK"));
			propMap.put("bamLink", prop.getProperty("BAMLINK"));

			propMap.put("wfrJDBCUrl", prop.getProperty("WFRJDBCURL"));
			propMap.put("wfrPwd", prop.getProperty("WFRPWD"));
			propMap.put("wfrUser", prop.getProperty("WFRUSER"));

			propMap.put("eqJDBCUrl", prop.getProperty("EQJDBCURL"));
			propMap.put("eqPwd", prop.getProperty("EQPWD"));
			propMap.put("eqUser", prop.getProperty("EQUSER"));
			
			//
			propMap.put("HighPriorityLoc", prop.getProperty("HighPriorityLoc"));
			propMap.put("HighPriorityBadImg", prop.getProperty("HighPriorityBadImg"));
			propMap.put("NormalPriorityLoc", prop.getProperty("NormalPriorityLoc"));
			propMap.put("NormalPriorityBadImg", prop.getProperty("NormalPriorityBadImg"));
			propMap.put("NormalPriorityJunk", prop.getProperty("NormalPriorityJunk"));
			propMap.put("NormalPriorityJunkBadImg", prop.getProperty("NormalPriorityJunkBadImg"));

			System.out
			.println("WFRAutomationNotificationUtility :loadproperties : End");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private static boolean checkLinks(String url) {

		CookieHandler.setDefault(new CookieManager(null,
				CookiePolicy.ACCEPT_ALL));

		try {

			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			huc.setConnectTimeout(20000); // timeout of connection
			huc.setRequestMethod("GET"); // OR huc.setRequestMethod ("HEAD");
			huc.connect();
			int code = huc.getResponseCode();

			if (code == 200) {
				return true;
			}

		} catch (Exception e) {

			return false;
		}
		return false;

	}

}
