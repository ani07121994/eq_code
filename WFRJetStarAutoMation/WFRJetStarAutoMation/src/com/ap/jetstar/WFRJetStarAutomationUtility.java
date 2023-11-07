package com.ap.jetstar;


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

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class WFRJetStarAutomationUtility {
	
	public static HashMap<String,String> propMap =  new HashMap<String, String>();
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		if(!loadproperties()){
			
			System.out.println("loadproperties not executed");
			System.out.println("--------Ending program-------");
			
			System.exit(0);
		}
		
		ArrayList<String> list_of_links = new ArrayList<String>();
		ArrayList<String> link_status = new ArrayList<String>();
		ArrayList<String> success_list = new ArrayList<String>();
		
		for (Object key : propMap.keySet()) {
			//System.out.println("Key : " + key.toString() + " Value : " + propMap.get(key));
			String keyValue = key.toString();
			if(keyValue.contains("captureLink") || keyValue.contains("verifierLink") || keyValue.contains("imagingLink") || keyValue.contains("bpmLink")){
				
				list_of_links.add(propMap.get(key));
				
			}
		}
		
		System.out.println("no of links to be checked :"+list_of_links.size());
		System.out.println("name of links checked : captureLink, imagingLink, verifierLink, bpmLink");
		//link_status = checkLinks(list_of_links);
		
		for(String url : list_of_links){
			try{
				//System.out.println("check links url :"+checkLinks(url));
				if(!checkLinks(url))
					link_status.add(url);
				else
					success_list.add(url);
			}catch(Exception e){
				continue;
			}
		}
		
		if(link_status.size() == 0 || link_status == null){
				System.out.println("All links working fine");
		}else{
				System.out.println("no of error links :"+link_status.size());
			 }
		 
		int no_of_wfr_import_files = countWFRImport();
	//	int no_of_stuck_invoices = countStuckInvoices();
		HashMap<String,Integer > stuckInvoices = countStuckInvoices();
		int no_of_failed_instances = countFailedInterfaceInstance();
		int no_of_Error_recovery = countErrorForRecovery();
		//int no_of_eQ_interface_rejections = countEqInterfaceRejections();
		//int no_of_Bad_imagesAUS = countBadImagesAUS();
		//int no_of_Bad_imagesJAP = countBadImagesJAP();
	//	int no_of_Bad_imagesSGP = countBadImagesSGP();
		int no_partial_success_files = countPartialSuccess();
		//int no_of_pending_certification = countPendingCertification();
		//int no_of_file_stuck_in_input_folderAUS = countInputFolderAUS();
		//int no_of_file_stuck_in_input_folderJAP = countInputFolderJAP();
		//int no_of_file_stuck_in_input_folderSGP = countInputFolderSGP();
		//int no_of_file_stuck_in_input_folder = no_of_file_stuck_in_input_folderAUS+no_of_file_stuck_in_input_folderJAP+no_of_file_stuck_in_input_folderSGP;
		HashMap<String,Integer > stuckFileInfolder =  new HashMap<String,Integer >();		
		stuckFileInfolder = countInputFolder();
		//int no_of_ecm_invisible_records = countECMInvisibleRecords(); Commented as part of 12c migration
		int no_of_ecm_invisible_records=0;
		//int no_of_Bad_images = no_of_Bad_imagesAUS+no_of_Bad_imagesJAP+no_of_Bad_imagesSGP;
		
		System.out.println("no of success links :"+success_list.size());
		System.out.println("WFR_IMPORT count :"+no_of_wfr_import_files);
	//	System.out.println("stuck invoice in 50/150/250/750 :"+no_of_stuck_invoices);
		System.out.println("no of failed instances :"+no_of_failed_instances);
		System.out.println("Error for recovery count :"+no_of_Error_recovery);
		//System.out.println("eQ interface rejected count :"+no_of_eQ_interface_rejections);
		//System.out.println("no of bad images :"+no_of_Bad_imagesAUS);
		//System.out.println("no of bad images :"+no_of_Bad_imagesJAP);
		//System.out.println("no of bad images :"+no_of_Bad_imagesSGP);
		System.out.println("no of partial success files :"+no_partial_success_files);
		//System.out.println("pending for certification count :"+no_of_pending_certification);
		/*System.out.println("no of files stuck in input folder :"+no_of_file_stuck_in_input_folderAUS);
		System.out.println("no of files stuck in input folder :"+no_of_file_stuck_in_input_folderJAP);
		System.out.println("no of files stuck in input folder :"+no_of_file_stuck_in_input_folderSGP);
		System.out.println("no of files stuck in input folder :"+no_of_file_stuck_in_input_folder);*/
		System.out.println("no of invisible records in ECM :"+no_of_ecm_invisible_records);
	//	System.out.println("no of files stuck in badimages folder :"+no_of_Bad_images);
	
		
		
		if(link_status.size() > 0 || no_of_wfr_import_files > 0 ||!stuckInvoices.isEmpty() || no_of_failed_instances > 0 ||no_of_Error_recovery >0 ||no_partial_success_files>0||stuckFileInfolder.size()>0){
			System.out.println("Calling sendmail ");
			sendMail(success_list,link_status,no_of_wfr_import_files,stuckInvoices,no_of_failed_instances,no_of_Error_recovery,stuckFileInfolder,no_partial_success_files,no_of_ecm_invisible_records);
		}
		//sendMail(success_list,link_status,no_of_wfr_import_files,no_of_stuck_invoices,no_of_failed_instances,no_of_Error_recovery,no_of_eQ_interface_rejections,no_of_Bad_imagesAUS,no_of_file_stuck_in_input_folder,no_partial_success_files,no_of_pending_certification,no_of_ecm_invisible_records);
		
		
		
	}catch(Exception e){
		e.printStackTrace();
		}

	}
private static void sendMail(ArrayList<String> success_list,ArrayList<String> link_status,int no_of_wfr_import_files, HashMap<String, Integer> stuckInvoices,int no_of_failed_instances, int no_of_Error_recovery, HashMap<String,Integer >stuckFileInfolder,int no_partial_success_files,int no_of_ecm_invisible_records) {
//private static void sendMail(ArrayList<String> success_list,ArrayList<String> link_status,int no_of_wfr_import_files, int no_of_stuck_invoices,int no_of_failed_instances, int no_of_Error_recovery,int no_of_eQ_interface_rejections,int no_of_Bad_images,int no_of_file_stuck_in_input_folder,int no_partial_success_files,int no_of_pending_certification,int no_of_ecm_invisible_records) {
		boolean isMailSendRequird=false;
	MailFolderReading mailread= new 	MailFolderReading();	
	//	List<Integer> countMail = mailread.checkMail();
		
		HashMap<String, List<Integer> > countMail = mailread.checkMail();
		 List<Integer> cnt_NP_AUS = new ArrayList<Integer>();
		 List<Integer> cnt_HP_AUS = new ArrayList<Integer>();
		 
		 List<Integer> cnt_NP_JAP = new ArrayList<Integer>();
		 List<Integer> cnt_HP_JAP = new ArrayList<Integer>();
		 
		 List<Integer> cnt_NP_SGP = new ArrayList<Integer>();
		 List<Integer> cnt_HP_SGP = new ArrayList<Integer>();
		 
		 
		 cnt_NP_AUS= countMail.get(propMap.get("Email_NP_AUS"));
		 cnt_HP_AUS=countMail.get(propMap.get("Email_HP_AUS"));
		 
		 cnt_NP_JAP= countMail.get(propMap.get("Email_NP_Japan"));
		 cnt_HP_JAP=countMail.get(propMap.get("Email_HP_Japan"));
		 
		 cnt_NP_SGP= countMail.get(propMap.get("Email_NP_SGP"));
		 cnt_HP_SGP=countMail.get(propMap.get("Email_HP_SGP"));
		
			System.out.println("Inside sendMail");
			Session session = null;
			String message = "<p>Hi All,</p>";
			if(link_status.size() > 0 || success_list.size() > 0){
				message += "<p>Please find the application and the server health status of OWC Application for Jetstar. Additionally,please find AP Automation system status below:</p>";
				}else{
				message += "<p>Please find AP Automation system status below:</p>";
			}
			message += "<table style = 'border: 1px solid black;border-collapse: collapse; collapse;width : 100%'>";
			message += "<tr><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Activity</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Module</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Date/Time</b></th><th style = 'border: 1px solid black;border-collapse: collapse;'><b>Running Status</b></th></tr>";
			
			if(success_list.size() > 0 && !success_list.isEmpty() || link_status.size() > 0 && !link_status.isEmpty() || no_of_wfr_import_files >= 0 || !stuckInvoices.isEmpty()  || no_of_failed_instances >= 0 || no_of_Error_recovery >= 0  ||  !stuckFileInfolder.isEmpty()){
			//if(success_list.size() > 0 && !success_list.isEmpty() || link_status.size() > 0 && !link_status.isEmpty() || no_of_wfr_import_files >= 0 || no_of_stuck_invoices >= 0 || no_of_failed_instances >= 0 || no_of_Error_recovery >= 0 || no_of_eQ_interface_rejections >= 0 || no_of_pending_certification >= 0 || no_of_Bad_images >=0 || no_of_file_stuck_in_input_folder >=0){
			
			try {
				
				/*CAPTURELINK=http://eqprod-capture1:16035/cs/
IMAGINGLINK=http://eqprod-capture1:16033/imaging/faces/Authentication/Login.jspx
VERIFIERLINK=http://eqprod-verifier1/WebVerifier/Login.aspx
BPMLINK=http://eqprod-soa-ap1:16035/bpm/workspace*/
				
					if(link_status.size() > 0){
						//System.out.println("no of error links :"+link_status.size());
						isMailSendRequird=true;
						for(String url : link_status){
							if(url.contains("http://eqprod-capture1:16035/cs/")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>CAPTURE</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Error"+"</td></tr>";
							}
							if(url.contains("http://eqprod-verifier2/WebVerifier/Login.aspx")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Verifier</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Error"+"</td></tr>";
							}
							if(url.contains("http://eqprod-capture1:16033/imaging/faces/Authentication/Login.jspx")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>IMAGING/ECM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Error"+"</td></tr>";								
							}
							
							if(url.contains("http://eqprod-soa-ap1:16035/bpm/workspace/faces/loginPage.jspx")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM Workspace</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Error"+"</td></tr>";
							}
						}
					}
					else if(success_list.size() > 0){
						
						for(String url : success_list){
							if(url.contains("http://eqprod-capture1:16035/cs/")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>CAPTURE</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Running Normal"+"</td></tr>";
							}
							if(url.contains("http://eqprod-verifier2/WebVerifier/Login.aspx")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Verifier</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Running Normal"+"</td></tr>";
							}
							if(url.contains("http://eqprod-capture1:16033/imaging/faces/Authentication/Login.jspx")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>IMAGING/ECM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Running Normal"+"</td></tr>";								
							}
							if(url.contains("http://eqprod-soa-ap1:16035/bpm/workspace/faces/loginPage.jspx")){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>BPM Workspace</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+"Running Normal"+"</td></tr>";
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
					
						
					
					
						if(cnt_NP_AUS.get(0) >0){
							isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_NP_AUS")+"</u> <b>Unprocessed</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_NP_AUS.get(0)+"</td></tr>";
						}
						if(cnt_NP_AUS.get(1) >0){
							isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_NP_AUS")+"</u> <b>Re-Process</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_NP_AUS.get(1)+"</td></tr>";
						}
						if(cnt_NP_AUS.get(2) >0){
							isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_NP_AUS")+"</u> <b>Capture Error</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_NP_AUS.get(2)+"</td></tr>";
						}
						if(cnt_HP_AUS.get(0) >0){
							isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_HP_AUS")+"</u> <b>Unprocessed</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_HP_AUS.get(0)+"</td></tr>";
						}
						if(cnt_HP_AUS.get(1) >0){
							isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_HP_AUS")+"</u> <b>Re-Process</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_HP_AUS.get(1)+"</td></tr>";
						}
						if(cnt_HP_AUS.get(2) >0){
							isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_HP_AUS")+"</u> <b>Capture Error</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_HP_AUS.get(2)+"</td></tr>";
						}
						if(cnt_NP_JAP.get(0) >0){
							isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_NP_Japan")+"</u> <b>Unprocessed</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_NP_JAP.get(0)+"</td></tr>";
						}
						if(cnt_NP_JAP.get(1) >0){
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_NP_Japan")+"</u> <b>Re-Process</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_NP_JAP.get(1)+"</td></tr>";
							isMailSendRequird=true;
						}
						if(cnt_NP_JAP.get(2) >0){
							isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_NP_Japan")+"</u> <b>Capture Error</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_NP_JAP.get(2)+"</td></tr>";
						}
						if(cnt_HP_JAP.get(0) >0){
							isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_HP_Japan")+"</u> <b>Unprocessed</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_HP_JAP.get(0)+"</td></tr>";
						}
						if(cnt_HP_JAP.get(1) >0){
							isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_HP_Japan")+"</u> <b>Re-Process</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_HP_JAP.get(1)+"</td></tr>";
						}
							if(cnt_HP_JAP.get(2) >0){
								isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_HP_Japan")+"</u> <b>Capture Error</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_HP_JAP.get(2)+"</td></tr>";
							}
						if(cnt_NP_SGP.get(0) >0){
							isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_NP_SGP")+"</u> <b>Unprocessed</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_NP_SGP.get(0)+"</td></tr>";
						}
							if(cnt_NP_SGP.get(1) >0){
								message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_NP_SGP")+"</u> <b>Re-Process</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_NP_SGP.get(1)+"</td></tr>";
								isMailSendRequird=true;
							}
							if(cnt_NP_SGP.get(2) >0){
								isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_NP_SGP")+"</u> <b>Capture Error</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_NP_SGP.get(2)+"</td></tr>";
							}
						if(cnt_HP_SGP.get(0) >0){
							isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_HP_SGP")+"</u> <b>Unprocessed</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_HP_SGP.get(0)+"</td></tr>";
						}
							if(cnt_HP_SGP.get(1) >0){
								isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_HP_SGP")+"</u> <b>Re-Process</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_HP_SGP.get(1)+"</td></tr>";
							}
						if(cnt_HP_SGP.get(2) >0){
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Emails stuck in <u>"+propMap.get("Email_HP_SGP")+"</u> <b>Capture Error</b> folder</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC Email</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+cnt_HP_SGP.get(2)+"</td></tr>";
							isMailSendRequird=true;
						}
				if (null != stuckFileInfolder && !stuckFileInfolder.isEmpty()) {
					System.out.println("stuckFileInfolder size "
							+ stuckFileInfolder.size());
					for (Map.Entry<String, Integer> entry : stuckFileInfolder
							.entrySet()) {
						System.out.println(entry.getKey() + " : "
								+ entry.getValue());
						if (entry.getValue() > 0){
							isMailSendRequird=true;
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>File stuck in "
									+ entry.getKey()
									+ " </td>"
									+ "<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"
									+ "<td style = 'border: 1px solid black;border-collapse: collapse;'>"
									+ sdf.format(new Date())
									+ "</td>"
									+ "<td style = 'border: 1px solid black;border-collapse: collapse;'>"
									+ entry.getValue() + "</td></tr>";
						}
					}
				}
				
				if(!stuckInvoices.isEmpty()){
					for (Map.Entry<String,Integer> entry : stuckInvoices.entrySet())  {
			            System.out.println("Mail  "+entry.getKey() + 
			                             " : " + entry.getValue()); 
			            isMailSendRequird=true;
			            message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Stuck Invoices ("+entry.getKey()+")</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+entry.getValue()+"</td></tr>";
					}
				}
							
					/*	if(no_of_file_stuck_in_input_folder >=0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>File stuck between Capture and WFR</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_file_stuck_in_input_folder+"</td></tr>";
						if(no_of_Bad_images >=0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Invoices rejected by WFR due to poor quality</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_Bad_images+"</td></tr>";
						if(no_of_stuck_invoices >= 0)
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Stuck Invoices (0/50/150/250/750/900)</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_stuck_invoices+"</td></tr>";*/
						if(no_partial_success_files > 0){
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR export failure</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_partial_success_files+"</td></tr>";
							isMailSendRequird=true;
						}
						if(no_of_wfr_import_files > 0){
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>WFR Import</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_wfr_import_files+"</td></tr>";
							isMailSendRequird=true;
						}
						if(no_of_ecm_invisible_records > 0){
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>ECM Invisible Records</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>OWC</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_ecm_invisible_records+"</td></tr>";
							isMailSendRequird=true;
						}
						if(no_of_Error_recovery > 0){
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Internal error occured</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_Error_recovery+"</td></tr>";
							isMailSendRequird=true;
						}
						
						if(no_of_failed_instances > 0){
							message += "<tr><td style = 'border: 1px solid black;border-collapse: collapse;'>Invoices failed to insert record in AP interface</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>BPM</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+sdf.format(new Date())+"</td>"+"<td style = 'border: 1px solid black;border-collapse: collapse;'>"+no_of_failed_instances+"</td></tr>";
							isMailSendRequird=true;
						}
						
					message += "</table><br>";
				    message += "Regards,<br>eQ OWC Support Team";
				if (isMailSendRequird) {
					System.out.println(" Mail prop Initialise");
					Properties properties = System.getProperties();
					properties.setProperty("mail.smtp.host",
							propMap.get("smtpHost"));
					session = Session.getDefaultInstance(properties);
					Message msg = new MimeMessage(session);
					msg.setFrom(InternetAddress.parse(propMap.get("emailFrom"),
							false)[0]);

					msg.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(propMap.get("emailTo")));

					msg.setSubject(propMap.get("emailSubject"));
					msg.setSentDate(new java.util.Date());
					msg.setContent(message, "text/html; charset=utf-8");
					Transport.send(msg);

					System.out
							.println("WFR AP Automation Status Mail Sent Successfully");
				}
			
		}catch(Exception e){
					e.printStackTrace();
				}
		
			}else{
				System.out.println("everything is woking fine");
			}
			
	}
	
public static boolean loadproperties(){
		
		try{
			
			Properties prop = new Properties();
	        File file = new File("WFR_Notification_Jetstar.properties");
	        FileInputStream fileInput = new FileInputStream(file);
	        
	        prop.load(fileInput);
	        
	        
	        propMap.put("badImagesLocationAUS",prop.getProperty("BADIMAGESLOCATION1"));
	        propMap.put("badImagesLocationJAP",prop.getProperty("BADIMAGESLOCATION2"));
	        propMap.put("badImagesLocationSGP",prop.getProperty("BADIMAGESLOCATION3"));
	        propMap.put("partialSuccessLocation",prop.getProperty("PARTIALSUCCESSLOCATION"));
	       // propMap.put("inputFolderLocationAUS",prop.getProperty("INPUTFOLDERLOCATION1"));
	        propMap.put("inputFolderLocationJAP",prop.getProperty("INPUTFOLDERLOCATION2"));
	        propMap.put("inputFolderLocationSGP",prop.getProperty("INPUTFOLDERLOCATION3"));
	        
	        
	        
	        propMap.put("FOLDER_AUS_NORMAL",prop.getProperty("FOLDER_AUS_NORMAL"));
	        propMap.put("FOLDER_AUS_NORMAL_BAD_IMG",prop.getProperty("FOLDER_AUS_NORMAL_BAD_IMG"));
	        propMap.put("FOLDER_AUS_HIGH",prop.getProperty("FOLDER_AUS_HIGH"));
	        propMap.put("FOLDER_AUS_HIGH_BAD_IMG",prop.getProperty("FOLDER_AUS_HIGH_BAD_IMG"));
	        
	        
	        propMap.put("FOLDER_AUS_HIGH_UNPROCESSED",prop.getProperty("FOLDER_AUS_HIGH_UNPROCESSED"));
	        propMap.put("FOLDER_AUS_HIGH_UNPROCESSED_BAD_IMG",prop.getProperty("FOLDER_AUS_HIGH_UNPROCESSED_BAD_IMG"));
	        propMap.put("FOLDER_AUS_NORMAL_UNPROCESSED",prop.getProperty("FOLDER_AUS_NORMAL_UNPROCESSED"));
	        propMap.put("FOLDER_AUS_NORMAL_UNPROCESSED_BAD_IMG",prop.getProperty("FOLDER_AUS_NORMAL_UNPROCESSED_BAD_IMG"));
	        
	        propMap.put("FOLDER_JAP_HIGH_UNPROCESSED",prop.getProperty("FOLDER_JAP_HIGH_UNPROCESSED"));
	        propMap.put("FOLDER_JAP_NORMAL_UNPROCESSED",prop.getProperty("FOLDER_JAP_NORMAL_UNPROCESSED"));
	        propMap.put("FOLDER_JAP_NORMAL_UNPROCESSED_BAD_IMG",prop.getProperty("FOLDER_JAP_NORMAL_UNPROCESSED_BAD_IMG"));
	        
	        propMap.put("FOLDER_SGP_HIGH_UNPROCESSED",prop.getProperty("FOLDER_SGP_HIGH_UNPROCESSED"));
	        propMap.put("FOLDER_SGP_HIGH_UNPROCESSED_BAD_IMG",prop.getProperty("FOLDER_SGP_HIGH_UNPROCESSED_BAD_IMG"));
	        propMap.put("FOLDER_SGP_NORMAL_UNPROCESSED",prop.getProperty("FOLDER_SGP_NORMAL_UNPROCESSED"));
	        propMap.put("FOLDER_SGP_NORMAL_UNPROCESSED_BAD_IMG",prop.getProperty("FOLDER_SGP_NORMAL_UNPROCESSED_BAD_IMG"));
	        
	        propMap.put("FOLDER_ZAP_NORMAL",prop.getProperty("FOLDER_ZAP_NORMAL"));
	        propMap.put("FOLDER_ZAP_NORMAL_BAD_IMG",prop.getProperty("FOLDER_ZAP_NORMAL_BAD_IMG"));
	        propMap.put("FOLDER_ZAP_HIGH",prop.getProperty("FOLDER_ZAP_HIGH"));
	        propMap.put("FOLDER_ZAP_HIGH_BAD_IMG",prop.getProperty("FOLDER_ZAP_HIGH_BAD_IMG"));
	        
	        propMap.put("FOLDER_SGP_NORMAL",prop.getProperty("FOLDER_SGP_NORMAL"));
	        propMap.put("FOLDER_SGP_NORMAL_BAD_IMG",prop.getProperty("FOLDER_SGP_NORMAL_BAD_IMG"));
	        propMap.put("FOLDER_SGP_HIGH",prop.getProperty("FOLDER_SGP_HIGH"));
	        propMap.put("FOLDER_SGP_HIGH_BAD_IMG",prop.getProperty("FOLDER_SGP_HIGH_BAD_IMG"));
	        
	        propMap.put("Email_NP_AUS",prop.getProperty("Email_NP_AUS"));
	        propMap.put("Email_HP_AUS",prop.getProperty("Email_HP_AUS"));
	        propMap.put("Email_NP_Japan",prop.getProperty("Email_NP_Japan"));
	        propMap.put("Email_HP_Japan",prop.getProperty("Email_HP_Japan"));
	        propMap.put("Email_NP_SGP",prop.getProperty("Email_NP_SGP"));
	        propMap.put("Email_HP_SGP",prop.getProperty("Email_HP_SGP"));
	      
	        
	        
	        propMap.put("smtpHost",prop.getProperty("SMTPHOST"));
	        propMap.put("emailSubject",prop.getProperty("EMAILSUBJECT"));
	        propMap.put("emailTo",prop.getProperty("EMAILTO"));
	        propMap.put("emailFrom",prop.getProperty("EMAILFROM"));
	        
	        propMap.put("captureLink", prop.getProperty("CAPTURELINK"));
	        propMap.put("imagingLink", prop.getProperty("IMAGINGLINK"));
	        propMap.put("verifierLink",prop.getProperty("VERIFIERLINK"));
	        propMap.put("bpmLink",prop.getProperty("BPMLINK"));
	        
	        propMap.put("wfrJDBCUrl",prop.getProperty("WFRJDBCURL"));
	        propMap.put("wfrPwd",prop.getProperty("WFRPWD"));
	        propMap.put("wfrUser",prop.getProperty("WFRUSER"));
	        
	        propMap.put("eqJDBCUrl",prop.getProperty("EQJDBCURL"));
	        propMap.put("eqPwd",prop.getProperty("EQPWD"));
	        propMap.put("eqUser",prop.getProperty("EQUSER"));
	        
	        return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
private static int countWFRImport() { //wfr_import
	
	try{
			int count = 0;
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(propMap.get("wfrJDBCUrl"),propMap.get("wfrUser"),propMap.get("wfrPwd"));
			
			PreparedStatement ps = con.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 = 'WFR_IMPORT'and XIPM_APP_1_31='JETSTAR INVOICE'");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				count = Integer.parseInt(rs.getString(1));
			}
			
			con.close();
			
			return count;
	   }catch(Exception e){
		   e.printStackTrace();
		   return -1;
	   }
	
	
}
private static boolean checkLinks(String url) {
	
	
	
	CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
	
	try{
		
		
		
			URL u = new URL (url);
			HttpURLConnection huc =  ( HttpURLConnection )  u.openConnection (); 
			huc.setConnectTimeout(20000); // timeout of connection
			huc.setRequestMethod ("GET");  //OR  huc.setRequestMethod ("HEAD"); 
			huc.connect () ; 
			int code = huc.getResponseCode() ;
			
			if(code == 200){
				return true;
			}
		
	}catch(Exception e){
		
		return false;
	}
return false;	
	
}


private static HashMap<String,Integer > countStuckInvoices() {
	System.out.println("WFRJetStarAutomationUtility :: countStuckInvoices :: Started ");
	 HashMap<String,Integer > stuckCount = new HashMap<String, Integer>();
	try{
		int count = 0;
		String state=null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(propMap.get("wfrJDBCUrl"),propMap.get("wfrUser"),propMap.get("wfrPwd"));
		
		//PreparedStatement ps = con.prepareStatement("select count(*) from JSWFR.BATCH where STATE IN ('0','50','150','250','750','900')");
		PreparedStatement ps = con.prepareStatement("select STATE,count(*) from JSWFR.BATCH where STATE IN ('0','50','150','250','750','900','100') GROUP BY STATE");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(" WFRJetStarAutomationUtility :: countStuckInvoices ::Result Set");
			state=rs.getString(1);
			count = Integer.parseInt(rs.getString(2));
			System.out.println(" WFRJetStarAutomationUtility :: countStuckInvoices :: State :::::::::::::::::: "+state+" Count ::::: "+count);
			stuckCount.put(state, count);
		}
		
		con.close();
		
		//return count;
		}catch(Exception e){
			e.printStackTrace();
			//return -1;
		}
	System.out.println("WFRJetStarAutomationUtility :: countStuckInvoices :: End ::  "+stuckCount.size());
	return stuckCount;
	
}
private static int countFailedInterfaceInstance() {
	
	try{
		int count = 0;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(propMap.get("wfrJDBCUrl"),propMap.get("wfrUser"),propMap.get("wfrPwd"));
		
		PreparedStatement ps = con.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 like '%Invoice Failed%'and XIPM_APP_1_31='JETSTAR INVOICE'");
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			count = Integer.parseInt(rs.getString(1));
		}
		
		con.close();
		
		return count;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	
}
private static int countErrorForRecovery() {
	
	try{
		int count = 0;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(propMap.get("wfrJDBCUrl"),propMap.get("wfrUser"),propMap.get("wfrPwd"));
		
		PreparedStatement ps = con.prepareStatement("select count(*) from OWCPRD12C_OCS.DOCMETA where XIPM_APP_1_1 like 'Internal%'and XIPM_APP_1_31='JETSTAR INVOICE'");
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			count = Integer.parseInt(rs.getString(1));
		}
		
		con.close();
		
		return count;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	
}

private static int countBadImagesAUS() {
	
	int count = 0;
	try{
	String badImagesLocation = propMap.get("badImagesLocationAUS");
	
	
	File[] file = new File(badImagesLocation).listFiles();
	
	for(File f:file){
		if(f.getName().endsWith(".tif")){
			count++;
		}
		else
			continue;
	}
	
		return count;
	}catch(Exception e){
		e.printStackTrace();
		return -1;
	}
	
}

private static int countBadImagesJAP() {
	
	int count = 0;
	try{
	String badImagesLocation = propMap.get("badImagesLocationJAP");
	
	
	File[] file = new File(badImagesLocation).listFiles();
	
	for(File f:file){
		if(f.getName().endsWith(".tif")){
			count++;
		}
		else
			continue;
	}
	
		return count;
	}catch(Exception e){
		e.printStackTrace();
		return -1;
	}
	
}

private static int countBadImagesSGP() {

int count = 0;
try{
String badImagesLocation = propMap.get("badImagesLocationSGP");


File[] file = new File(badImagesLocation).listFiles();

for(File f:file){
	if(f.getName().endsWith(".tif")){
		count++;
	}
	else
		continue;
}

	return count;
}catch(Exception e){
	e.printStackTrace();
	return -1;
}

}


private static int countPartialSuccess() {
	
	int count = 0;
	try{
	String partialSuccessLocation = propMap.get("partialSuccessLocation");
	
	
	File[] file = new File(partialSuccessLocation).listFiles();
	
	for(File f:file){
		if(f.getName().endsWith(".txt")){
			count++;
		}
		else
			continue;
	}
	
		return count;
	}catch(Exception e){
		e.printStackTrace();
		return -1;
	}
}
private static int countInputFolderAUS() {
	
	int count = 0;
	try{
	String inputFolderLocation = propMap.get("inputFolderLocationAUS");
	
	
	File[] file = new File(inputFolderLocation).listFiles();
	
	for(File f:file){
		if(f.getName().endsWith(".tif")){
			count++;
		}
		else
			continue;
	}
	
		return count;
	}catch(Exception e){
		e.printStackTrace();
		return -1;
	}
	
}

private static int countInputFolderJAP() {

int count = 0;
try{
String inputFolderLocation = propMap.get("inputFolderLocationJAP");


File[] file = new File(inputFolderLocation).listFiles();

for(File f:file){
	if(f.getName().endsWith(".tif")){
		count++;
	}
	else
		continue;
}

	return count;
}catch(Exception e){
	e.printStackTrace();
	return -1;
}

}

private static int countInputFolderSGP() {

int count = 0;
try{
String inputFolderLocation = propMap.get("inputFolderLocationSGP");


File[] file = new File(inputFolderLocation).listFiles();

for(File f:file){
	if(f.getName().endsWith(".tif")){
		count++;
	}
	else
		continue;
}

	return count;
}catch(Exception e){
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
		
				searchLocation.add(propMap.get("FOLDER_AUS_NORMAL")) ;
				searchLocation.add(propMap.get("FOLDER_AUS_NORMAL_BAD_IMG")) ;
				searchLocation.add(propMap.get("FOLDER_AUS_HIGH")) ;
				searchLocation.add(propMap.get("FOLDER_AUS_HIGH_BAD_IMG")) ;
				
				searchLocation.add(propMap.get("FOLDER_AUS_HIGH_UNPROCESSED")) ;
				searchLocation.add(propMap.get("FOLDER_AUS_HIGH_UNPROCESSED_BAD_IMG")) ;
				searchLocation.add(propMap.get("FOLDER_AUS_NORMAL_UNPROCESSED")) ;
				searchLocation.add(propMap.get("FOLDER_AUS_NORMAL_UNPROCESSED_BAD_IMG")) ;
				
				searchLocation.add(propMap.get("FOLDER_JAP_HIGH_UNPROCESSED")) ;
				searchLocation.add(propMap.get("FOLDER_JAP_NORMAL_UNPROCESSED")) ;
				searchLocation.add(propMap.get("FOLDER_JAP_NORMAL_UNPROCESSED_BAD_IMG")) ;
				
				searchLocation.add(propMap.get("FOLDER_SGP_HIGH_UNPROCESSED")) ;
				searchLocation.add(propMap.get("FOLDER_SGP_HIGH_UNPROCESSED_BAD_IMG")) ;
				searchLocation.add(propMap.get("FOLDER_SGP_NORMAL_UNPROCESSED")) ;
				searchLocation.add(propMap.get("FOLDER_SGP_NORMAL_UNPROCESSED_BAD_IMG")) ;
				
				searchLocation.add(propMap.get("FOLDER_ZAP_NORMAL")) ;
				searchLocation.add(propMap.get("FOLDER_ZAP_NORMAL_BAD_IMG")) ;
				searchLocation.add(propMap.get("FOLDER_ZAP_HIGH")) ;
				searchLocation.add(propMap.get("FOLDER_ZAP_HIGH_BAD_IMG")) ;
				
				searchLocation.add(propMap.get("FOLDER_SGP_NORMAL")) ;
				searchLocation.add(propMap.get("FOLDER_SGP_NORMAL_BAD_IMG")) ;
				searchLocation.add(propMap.get("FOLDER_SGP_HIGH")) ;
				searchLocation.add(propMap.get("FOLDER_SGP_HIGH_BAD_IMG")) ;
				
				
				
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
private static int countECMInvisibleRecords() { //invisible records ECM
	
	try{
			int count = 0;
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(propMap.get("wfrJDBCUrl"),propMap.get("wfrUser"),propMap.get("wfrPwd"));
			
			PreparedStatement ps = con.prepareStatement("select count(*) from PROD_OCS.revisions where ddocname not in (select distinct(ddocname) from PROD_OCS.idctext1)");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				count = Integer.parseInt(rs.getString(1));
			}
			
			con.close();
			
			return count;
	   }catch(Exception e){
		   e.printStackTrace();
		   return -1;
	   }
	
	
}
}
