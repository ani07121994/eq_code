package com.audit.dao;

import com.audit.utility.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import oracle.imaging.BasicUserToken;
import oracle.imaging.Document;
import oracle.imaging.DocumentService;
import oracle.imaging.ServicesFactory;
import oracle.imaging.UserToken;
import oracle.imaging.Document.FieldValue;
import oracle.imaging.Document.SectionSet;

import com.audit.pojo.*;
import com.audit.utility.DBUtil;





public class FetchFromDB {

	public ArrayList<InvoiceAudit> auditInvoiceDtlList = new ArrayList<InvoiceAudit>();
	public Properties props = new Properties();
	
	public ArrayList<Invoice> getDatafromDB(int invoiceID,String invoiceNumber){
		
		Connection eqfilesDb = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy");
		
		try{
			
			props.load(this.getClass().getResourceAsStream("queries.sql"));
			
			System.out.println("Searching in database for invoice no :"+invoiceNumber);
			System.out.println("Searching in database for invoice id :"+invoiceID);
			
			ArrayList<Invoice> invoiceDetailList = new ArrayList<Invoice>();
			
			
			String query = props.getProperty("EQFILES_INVOICE_SEARCH_QUERY");
			System.out.println("Invoice search query :" + query);
			
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@eqsit-db.qantas.com.au:16085:SOAPATCH","eqfiles","eqfiles");
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@eqdr-db1:16010:SOAPSP1","eqfiles","soapSp009");
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@eqprod-db1:16010:PSOADB1","eqfiles","soaprod008");
			
			eqfilesDb = DBUtil.getEqfilesConnection();
			
				ps = eqfilesDb.prepareStatement(query);
			    //ps = con.prepareStatement(query);
				ps.setString(1,invoiceNumber);
				
				rs = ps.executeQuery();
			
			
			
			while(rs.next()){
				
				Invoice inv = new Invoice();
				
				inv.setInvoiceNo(rs.getString(1));
				inv.setSupplierName(rs.getString(2));
				inv.setSiteId(rs.getString(3));
				inv.setInvoiceId(rs.getInt(4));
				inv.setInvoiceDate(rs.getDate(5)!=null? sdfDestination.format(rs.getDate(5)) : "");
				inv.setInvoiceTotalAmount(Double.toString(rs.getDouble(6)));
				inv.setInternalStatus(rs.getString(7) != null ? rs.getString(7) : "");
				
				System.out.println("invoiceNumber : "+inv.getInvoiceNo()+"\t"+"supplerName : "+inv.getSupplierName()+"\t"+"site id :"+inv.getSiteId() +"\t"+"invoice id :"+inv.getInvoiceId());
				
				invoiceDetailList.add(inv);
				
				
			}
			
			System.out.println("no of results returned by query :"+invoiceDetailList.size());
			
			/*
			 * 
			 * if invoiceList size is 1 ,then directly take invoiceid and serach in 
			 * the directly search in audit and return that as result 
			 * */
			return invoiceDetailList;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(ps!=null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(eqfilesDb!=null) {
				try {
					eqfilesDb.close();
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		}
		return null;
	}
	
	
	
	public ArrayList<InvoiceAudit> getAuditDatafromDB(int invoiceId) {
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection eqfilesDb = null;
		Connection con = null;
		
		boolean eQDataReqd = false; // determine whether eQ Database query is reqd
		SimpleDateFormat sdfDestination = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		SimpleDateFormat sdfDestination2 = new SimpleDateFormat("dd-MM-yy");
		System.out.println("invoice id in dao class :"+invoiceId);
		
		try{
			
			props.load(this.getClass().getResourceAsStream("queries.sql"));
			
			eqfilesDb = DBUtil.getEqfilesConnection();
			
			String query = props.getProperty("EQFILES_AUDIT_QUERY_UPDATED");
			System.out.println("Invoice Audit query :" + query);
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@eqsit-db.qantas.com.au:16085:SOAPATCH","eqfiles","eqfiles");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@eqdr-db1:16010:SOAPSP1","eqfiles","soapSp009");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@eqprod-db1:16010:PSOADB1","eqfiles","soaprod008");
			//ps = con.prepareStatement("select invoice_number,supplier_name,site_id,internal_status,certifier_name,last_updated_date from ap_audit_invoice_table where invoice_id = ? order by last_updated_date asc ");
			
			InvoiceAudit eQDataObj = null;
			String docIDForEQ = null;
			ps = eqfilesDb.prepareStatement(query);
			//ps = con.prepareStatement(query);
			
			
			ps.setInt(1,invoiceId);
			ps.setInt(2,invoiceId);
			ps.setInt(3,invoiceId);
			ps.setInt(4,invoiceId);
			ps.setInt(5,invoiceId);
			ps.setInt(6,invoiceId);
			ps.setInt(7,invoiceId);
			ps.setInt(8,invoiceId);
			ps.setInt(9,invoiceId);
			ps.setInt(10,invoiceId);
			ps.setInt(11,invoiceId);
			
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				String allComments = "";
				InvoiceAudit inv = new InvoiceAudit();
				
				inv.setInvoiceNo(rs.getString("INVOICE_NUMBER"));
				inv.setInvoiceDate(rs.getDate("INVOICE_DATE") != null ? sdfDestination2.format(rs.getDate("INVOICE_DATE")) : "");
				inv.setInvoiceType(rs.getString("INVOICE_TYPE"));
				inv.setDocumentType(rs.getString("DOCUMENT_TYPE"));
				inv.setSupplierId(String.valueOf(rs.getInt("SUPPLIER_ID")));
				inv.setSupplierName(rs.getString("SUPPLIER_NAME"));
				inv.setSupplierNumber(String.valueOf(rs.getInt("SUPPLIER_NUMBER")));
				inv.setSiteId(String.valueOf(rs.getInt("SITE_ID")));
				inv.setSiteName(rs.getString("SITE_NAME"));
				inv.setPONumber(rs.getString("PO_NUMBER"));
				inv.setCurrencyCode(rs.getString("CURRENCY_CODE"));
				inv.setTaxRegNumber(String.valueOf(rs.getLong("TAX_REG_NUMBER")));
				inv.setTaxAmount(String.valueOf(rs.getDouble("TAX_AMOUNT")));
				inv.setInvoiceTotalAmount(String.valueOf(rs.getDouble("INVOICE_TOT_AMOUNT")));
				inv.setPanelBorderColor("green");
				inv.setInternalStatus(rs.getString("INTERNAL_STATUS"));
				inv.setDocId(rs.getString("DOC_ID"));
				inv.setEmployeeNumber(rs.getString("EMPLOYEE_NUMBER"));
			
				if(inv.getInternalStatus().contains("INVOICE REASSIGNED"))
					inv.setCertifierName(rs.getString("CERTIFIER_REASSIGN_TO")!= null ? rs.getString("CERTIFIER_REASSIGN_TO") : rs.getString("CERTIFIER_NAME"));
				else if(inv.getInternalStatus().equalsIgnoreCase("INVOICE FROM WFR TO BPM"))
					inv.setCertifierName(null);
				else if(inv.getInternalStatus().equalsIgnoreCase("INVOICE IN AP EXCEPTIONS"))
					inv.setCertifierName(rs.getString("MODIFIED_BY")); 
				else if(inv.getInternalStatus().equalsIgnoreCase("INVOICE PENDING FOR CERTIFICATION")){
					
					System.out.println("getting name from eQ :"+getEmployeeName(inv.getEmployeeNumber()));
					inv.setCertifierName(inv.getEmployeeNumber() != null ? getEmployeeName(inv.getEmployeeNumber())[0] : "");
				}
				else if(inv.getInternalStatus().equalsIgnoreCase("INVOICE IN AP INTERFACE"))
				{
					inv.setCertifierName("");
				}
				else
				inv.setCertifierName(inv.getEmployeeNumber() != null ? getEmployeeName(inv.getEmployeeNumber())[0] : ""); 
			    inv.setFirstName(inv.getEmployeeNumber() != null ? getEmployeeName(inv.getEmployeeNumber())[1] : ""); 
					
				
				inv.setLastUpdatedDate(sdfDestination.format(rs.getTimestamp("LAST_UPDATED_DATE")));
				inv.setReasonType(rs.getString("INVALID_REASON_TYPE"));
				
				
				System.out.println("Status :"+inv.getInternalStatus());
				
				/*if(rs.getString("AP_OPERATION_COMMENTS") != null  && inv.getInternalStatus().equalsIgnoreCase("INVOICE IN AP EXCEPTIONS"))
					allComments += rs.getString("AP_OPERATION_COMMENTS") +"\n";*/
				
				if(rs.getString("AP_OPERATION_COMMENTS") != null  && (inv.getInternalStatus().equalsIgnoreCase("INVOICE IN AP EXCEPTIONS") || inv.getInternalStatus().equalsIgnoreCase("INVOICE REJECTED BY AP GROUP")))
					{
						allComments += rs.getString("AP_OPERATION_COMMENTS") +"\n";
						System.out.println("AP Rejection/AP Operation Comments : "+allComments);
					}
				if(rs.getString("CERTIFIER_REASSIGN_COMMENTS") != null && inv.getInternalStatus().contains("INVOICE REASSIGNED BY")){
					String certifierComments = rs.getString("CERTIFIER_REASSIGN_COMMENTS");
					if(certifierComments.contains("Reassigned by User")){
						certifierComments = certifierComments.split("Comments :")[1].trim();
					}
					System.out.println("Modified Comments : " + certifierComments);
					if(!certifierComments.equals(""))
					allComments += certifierComments + "\n";
				}
				
				
				if(rs.getString("CERTIFIER_REJ_COMMENTS") != null && inv.getInternalStatus().contains("REJECTED"))
					allComments += rs.getString("CERTIFIER_REJ_COMMENTS") + "\n";
				
				
				/****Query Ap Comments Table for getting hold release comments : change to be done : NO EXTRA QUERY NEEDED IN COMMENTS TABLE***/
				
				if(inv.getInternalStatus().contains("INVOICE PENDING FOR CERTIFICATION : HOLD")){
					
					System.out.println("in hold block : "+rs.getString("CERTIFIER_REASSIGN_COMMENTS"));
					allComments += rs.getString("CERTIFIER_REASSIGN_COMMENTS") != null ? rs.getString("CERTIFIER_REASSIGN_COMMENTS").split(":")[1].trim() : "";
					System.out.println("Hold Comments :"+allComments);
					
				}
				
				if(inv.getInternalStatus().contains("INVOICE PENDING FOR CERTIFICATION : RELEASE")){
					
					System.out.println("in release block : "+rs.getString("CERTIFIER_REASSIGN_COMMENTS"));
					allComments += rs.getString("CERTIFIER_REASSIGN_COMMENTS") != null ? rs.getString("CERTIFIER_REASSIGN_COMMENTS").split(":")[1].trim() : "";
					System.out.println("Release Comments :"+allComments);
					
				}

				inv.setComments(allComments);
				inv.setEmployeeReassignedNo(rs.getString("REASSIGNED_BY")!= null ? rs.getString("REASSIGNED_BY") : null);
				
				/*To get eQ status*/
				
				if(inv.getInternalStatus().contains("INVOICE IN AP INTERFACE")){
					
					System.out.println("eQ data Reqd");
					eQDataReqd = true;
					eQDataObj = inv; 
					String[] docIDArray = inv.getDocId() != null ? inv.getDocId().split("_") : null;
					
					if(docIDArray != null){
						docIDForEQ = docIDArray[1];
						System.out.println("Document ID sent to eQ:" + docIDForEQ );	
						
					}
					else
						docIDForEQ = "";
					
				}
				
				
				inv.setStatusCamelCase(returnCamelCase(inv.getInternalStatus()));
				if(inv.getStatusCamelCase().contains("Invoice Reassigned By")){
					
					String employeeNO = inv.getEmployeeReassignedNo() != null ? inv.getEmployeeReassignedNo() : null;
					if(employeeNO != null){
						//getEmployeeName Query
						
						String employeeName = getEmployeeName(employeeNO)[0];
						inv.setStatusCamelCase("Invoice Reassigned By : " + employeeName);		
					}
					
					else
						
						inv.setStatusCamelCase("Invoice Reassigned");
					
				}
				
				if(inv.getStatusCamelCase().contains("Invoice Rejected By")){
					if(inv.getEmployeeNumber() != null)
						inv.setStatusCamelCase("Invoice Rejected By : " + getEmployeeName(inv.getEmployeeNumber())[0]);
					else
						inv.setStatusCamelCase("Invoice Rejected");
				}
				
				auditInvoiceDtlList.add(inv);
			}
			
			//eQDataReqd = false; // comment later
			
			/*** Query WFR to get updated Invoice No to query EBS Database***/
			if(eQDataReqd)
			{
				System.out.println("getting Imaging data");
				System.out.println("DOc id for imaging :"+eQDataObj.getDocId());
				/*QueryWFR ob = new QueryWFR();
				String invoiceNumber = ob.validateInvoiceNumber(eQDataObj.getDocId());*/
				
				String invoiceNumber = null;
				
				try { 
					
					
					String ecmWsdl = PropertyLoader.getInstance().getProperty("IMAGING_DOCUMENT_SERVICE_WSDL").toString().split("/DocumentService")[0];
				
					System.out.println("ECM WDSL :"+ ecmWsdl);
					
					String userName = PropertyLoader.getInstance().getProperty("IMAGING_DOCUMENT_SERVICE_USERNAME").toString();
					String passWord = PropertyLoader.getInstance().getProperty("IMAGING_DOCUMENT_SERVICE_PASSWORD").toString();
					
					System.out.println("Username :"+userName);
					System.out.println("Password :"+passWord);
					
					UserToken credentials = new BasicUserToken(userName, passWord); 
					
					//UserToken credentials = new BasicUserToken("eqadmin", "eq@dmin123"); //	PROD
					//ServicesFactory servicesFactory = ServicesFactory.login(credentials, Locale.US,"http://eqtest-capture1:16033/imaging/ws");
					
					ServicesFactory servicesFactory = ServicesFactory.login(credentials, Locale.US,ecmWsdl);
							
					try {
					DocumentService docService = servicesFactory.getDocumentService();

					
					SectionSet sectionSet = Document.SectionSet.of(Document.SectionFlag.FIELDVALUES);
					
					Document dd = docService.getDocument(eQDataObj.getDocId(), sectionSet);
					
					List<FieldValue> listFields =  dd.getFieldValues();
					
					
					for(FieldValue ob1 : listFields){
						System.out.println(ob1.getName() + "--> "+ob1.getStringValue());
						if(ob1.getName().equals("Invoice Number"))
						{
							invoiceNumber = ob1.getStringValue();
							//System.out.println("Invoice Number : "+ob.getStringValue());
							break;
						}

					}
					
					}
		finally {
					if (servicesFactory != null) {
					servicesFactory.logout();
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
				
				
				System.out.println("updated invoice no from Imaging :"+eQDataObj.getInvoiceNo());
				
				getDataFromEQ(eQDataObj.getInvoiceNo(),docIDForEQ,eQDataObj);
			}
			
			/* Adding last internal status programmatically if the last status returned by query contains any of the following internal status */
			
			if(auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().contains("INVOICE REJECTED BY")){
				
				InvoiceAudit lastob = auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1);
				
				InvoiceAudit ob = new InvoiceAudit();
				ob.setInternalStatus("INVOICE IN AP EXCEPTIONS");
				ob.setStatusCamelCase(returnCamelCase(ob.getInternalStatus()));
				
				
				ob.setInvoiceNo(lastob.getInvoiceNo());
				ob.setInvoiceDate(lastob.getInvoiceDate());
				ob.setInvoiceType(lastob.getInvoiceType());
				ob.setDocumentType(lastob.getDocumentType());
				ob.setSupplierId(lastob.getSupplierId());
				ob.setSupplierName(lastob.getSupplierName());
				ob.setSupplierNumber(lastob.getSupplierNumber());
				ob.setSiteId(lastob.getSiteId());
				ob.setSiteName(lastob.getSiteName());
				ob.setPONumber(lastob.getPONumber());
				ob.setCurrencyCode(lastob.getCurrencyCode());
				ob.setTaxRegNumber(lastob.getTaxRegNumber());
				ob.setTaxAmount(lastob.getTaxAmount());
				ob.setInvoiceTotalAmount(lastob.getInvoiceTotalAmount());
				ob.setPanelBorderColor("green");
				ob.setLastUpdatedDate(lastob.getLastUpdatedDate());
				
				auditInvoiceDtlList.add(ob);
				
			}
			
			else if(auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().contains("INVOICE REASSIGNED")){
				
				InvoiceAudit lastob = auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1);
				
				InvoiceAudit ob = new InvoiceAudit();
				ob.setInternalStatus("INVOICE PENDING FOR CERTIFICATION");
				ob.setStatusCamelCase(returnCamelCase(ob.getInternalStatus()));
				
				
				ob.setInvoiceNo(lastob.getInvoiceNo());
				ob.setInvoiceDate(lastob.getInvoiceDate());
				ob.setInvoiceType(lastob.getInvoiceType());
				ob.setDocumentType(lastob.getDocumentType());
				ob.setSupplierId(lastob.getSupplierId());
				ob.setSupplierName(lastob.getSupplierName());
				ob.setSupplierNumber(lastob.getSupplierNumber());
				ob.setSiteId(lastob.getSiteId());
				ob.setSiteName(lastob.getSiteName());
				ob.setPONumber(lastob.getPONumber());
				ob.setCurrencyCode(lastob.getCurrencyCode());
				ob.setTaxRegNumber(lastob.getTaxRegNumber());
				ob.setTaxAmount(lastob.getTaxAmount());
				ob.setInvoiceTotalAmount(lastob.getInvoiceTotalAmount());
				ob.setPanelBorderColor("green");
				ob.setLastUpdatedDate(lastob.getLastUpdatedDate());
				ob.setCertifierName(lastob.getCertifierName());
				ob.setEmployeeNumber(lastob.getEmployeeNumber());
				
				auditInvoiceDtlList.add(ob);
				
			}
			
			else if(auditInvoiceDtlList.size() == 1 && auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().contains("INVOICE FROM WFR TO BPM")){
				
				InvoiceAudit lastob = auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1);
				
				InvoiceAudit ob = new InvoiceAudit();
				ob.setInternalStatus("INVOICE IN AP EXCEPTIONS");
				ob.setStatusCamelCase(returnCamelCase(ob.getInternalStatus()));
				
				
				ob.setInvoiceNo(lastob.getInvoiceNo());
				ob.setInvoiceDate(lastob.getInvoiceDate());
				ob.setInvoiceType(lastob.getInvoiceType());
				ob.setDocumentType(lastob.getDocumentType());
				ob.setSupplierId(lastob.getSupplierId());
				ob.setSupplierName(lastob.getSupplierName());
				ob.setSupplierNumber(lastob.getSupplierNumber());
				ob.setSiteId(lastob.getSiteId());
				ob.setSiteName(lastob.getSiteName());
				ob.setPONumber(lastob.getPONumber());
				ob.setCurrencyCode(lastob.getCurrencyCode());
				ob.setTaxRegNumber(lastob.getTaxRegNumber());
				ob.setTaxAmount(lastob.getTaxAmount());
				ob.setInvoiceTotalAmount(lastob.getInvoiceTotalAmount());
				ob.setPanelBorderColor("green");
				ob.setLastUpdatedDate(lastob.getLastUpdatedDate());
				ob.setCertifierName("");
				ob.setEmployeeNumber(lastob.getEmployeeNumber());
				
				auditInvoiceDtlList.add(ob);
				
			}
			
			
			else if(auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().contains("INVOICE PENDING FOR CERTIFICATION : RELEASE")){
				
				InvoiceAudit lastob = auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1);
				
				InvoiceAudit ob = new InvoiceAudit();
				ob.setInternalStatus("INVOICE PENDING FOR CERTIFICATION");
				ob.setStatusCamelCase(returnCamelCase(ob.getInternalStatus()));
				
				
				ob.setInvoiceNo(lastob.getInvoiceNo());
				ob.setInvoiceDate(lastob.getInvoiceDate());
				ob.setInvoiceType(lastob.getInvoiceType());
				ob.setDocumentType(lastob.getDocumentType());
				ob.setSupplierId(lastob.getSupplierId());
				ob.setSupplierName(lastob.getSupplierName());
				ob.setSupplierNumber(lastob.getSupplierNumber());
				ob.setSiteId(lastob.getSiteId());
				ob.setSiteName(lastob.getSiteName());
				ob.setPONumber(lastob.getPONumber());
				ob.setCurrencyCode(lastob.getCurrencyCode());
				ob.setTaxRegNumber(lastob.getTaxRegNumber());
				ob.setTaxAmount(lastob.getTaxAmount());
				ob.setInvoiceTotalAmount(lastob.getInvoiceTotalAmount());
				ob.setPanelBorderColor("green");
				ob.setLastUpdatedDate(lastob.getLastUpdatedDate());
				ob.setCertifierName(lastob.getCertifierName());
				ob.setEmployeeNumber(lastob.getEmployeeNumber());
				
				auditInvoiceDtlList.add(ob);
				
			}
			
			if(auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().equalsIgnoreCase("INVOICE IN AP EXCEPTIONS")){
				
				auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).setCertifierName(""); //setting certifier name as blank when invoice reaches AP Exceptions in last stage
			}
			
			if(auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().equalsIgnoreCase("INVOICE IN AP EXCEPTIONS")
				|| auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().equalsIgnoreCase("INVOICE PENDING FOR CERTIFICATION")
				|| auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().equalsIgnoreCase("INVOICE PENDING FOR CERTIFICATION : HOLD") // for hold invoice
				|| auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().equalsIgnoreCase("INVOICE PENDING FOR CERTIFICATION : RELEASE") // for release by certifier
				|| auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().equalsIgnoreCase("eQ Awaiting Import")
				|| auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().equalsIgnoreCase("eQ PENDING")
				|| auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().equalsIgnoreCase("eQ ESCALATED")
				|| auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().equalsIgnoreCase("eQ TRANSFERRED")
				|| auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().equalsIgnoreCase("eQ Cancelled")
				|| auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().equalsIgnoreCase("eQ Created")
				|| auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().equalsIgnoreCase("eQ Hold"))
				
				
				/*|| auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).getInternalStatus().equalsIgnoreCase("eQ REJECT"))*/
			
				auditInvoiceDtlList.get(auditInvoiceDtlList.size() - 1).setPanelBorderColor("red"); // Setting panel border color; Red for the above Internal Status
			
			
			
			/** Sanitize special characters **/
			
			for(InvoiceAudit ob : auditInvoiceDtlList){
				
				if(ob.getCertifierName() != null){
					if(ob.getCertifierName().contains("’")){
						ob.setCertifierName(ob.getCertifierName().replaceAll("’",""));
						}
				}
				
				if(ob.getStatusCamelCase() != null){
						if(ob.getStatusCamelCase().contains("’")){
							ob.setStatusCamelCase(ob.getStatusCamelCase().replaceAll("’",""));
						}
				}
			}
			
			System.out.println("Sanitized");
			
			return auditInvoiceDtlList;
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(ps!=null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(eqfilesDb!=null) {
				try {
					eqfilesDb.close();
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		}
		return null;
	}


	/*Get Employee Name for particular Employee NOS so that all names are consistent in the format -> firstName + lastName*/
	private String[] getEmployeeName(String employeeNO) {
			
		
		Connection ebsDb = null;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String[] employeeName = new String[2];
		
		try{
		
		ebsDb = DBUtil.getEbsConnection();
		
		props.load(this.getClass().getResourceAsStream("queries.sql"));
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@eqprod-db1:16010:PEBSDB1","Eul5_us","eul5_us123");*/
		
		
		
		String query = props.getProperty("EBS_EMPLOYEE_NAME_QUERY");
		System.out.println("Invoice Audit query :" + query);
		ps = ebsDb.prepareStatement(query);
		//ps = con.prepareStatement(query);
		
		
		ps.setString(1, employeeNO);
		rs = ps.executeQuery();
		
		
		
		while(rs.next()){
			
			employeeName[0] = rs.getString(1) + " " + rs.getString(2) ; //certifier Name
			employeeName[1] = rs.getString(1) ; //first Name
			
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			if(ps!=null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(ebsDb!=null) {
				try {
					ebsDb.close();
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		}
		return employeeName;
	}


	/* Return Camelcase Format of Internal Status Fields in the table Column : Internal Status*/
	public String returnCamelCase(String input){
		String result = "";
		
		char firstChar = input.charAt(0);
        result = result + Character.toUpperCase(firstChar);
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char previousChar = input.charAt(i - 1);
            if (previousChar == ' ') {
                result = result + Character.toUpperCase(currentChar);
            } else {
                result = result + Character.toLowerCase(currentChar);
            }
        }
		
		return result;
	}
	
	
	    /* Get Relevant Invoice Status from EBS end after Invoice In AP Interface*/
	
		public void getDataFromEQ(String invoiceNumber,String docID,InvoiceAudit ob){
			
			ResultSet rs = null;
			PreparedStatement ps = null;
			Connection ebsDb = null;
			
			try{
				
				SimpleDateFormat sdfDestination = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
				System.out.println("Searching in database for invoice no :"+invoiceNumber);
				
				ebsDb = DBUtil.getEbsConnection();
				String query = props.getProperty("EBS_AUDIT_QUERY_LATEST");
				System.out.println("Invoice Audit query :" + query);	
				
				
				/*Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@eqprod-db1:16010:PEBSDB1","Eul5_us","eul5_us123");
				*/
				ps = ebsDb.prepareStatement(query);
				//ps = con.prepareStatement(query);
				
				ps.setString(1,docID);
				ps.setString(2,invoiceNumber);
				rs = ps.executeQuery();
				
				while(rs.next()){
					
					InvoiceAudit inv = new InvoiceAudit();
					
					inv.setInvoiceNo(invoiceNumber);
					inv.setInvoiceDate(ob.getInvoiceDate());
					inv.setInvoiceType(ob.getInvoiceType());
					inv.setDocumentType(ob.getDocumentType());
					inv.setSupplierId(ob.getSupplierId());
					inv.setSupplierName(ob.getSupplierName());
					inv.setSupplierNumber(ob.getSupplierNumber());
					inv.setSiteId(rs.getString(4));
					inv.setSiteName(ob.getSiteName());
					inv.setPONumber(ob.getPONumber());
					inv.setCurrencyCode(ob.getCurrencyCode());
					inv.setTaxRegNumber(ob.getTaxRegNumber());
					inv.setTaxAmount(ob.getTaxAmount());
					inv.setInvoiceTotalAmount(ob.getInvoiceTotalAmount());
					inv.setDocId(ob.getDocId());
					inv.setInternalStatus(rs.getString(9).toUpperCase());
					inv.setCertifierName(rs.getString("APPROVER_NAME") != null ? getModifiedName(rs.getString("APPROVER_NAME")) : "");
					inv.setLastUpdatedDate(sdfDestination.format(rs.getTimestamp(10)));
					inv.setReasonType(ob.getReasonType());
					inv.setEmployeeNumber(ob.getEmployeeNumber());
					inv.setStatusCamelCase(returnCamelCase(inv.getInternalStatus()));
					inv.setComments(rs.getString("APPROVER_COMMENTS") != null ? rs.getString("APPROVER_COMMENTS") : "");
					inv.setPanelBorderColor("green");
					auditInvoiceDtlList.add(inv);
					
					
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(ps!=null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(ebsDb!=null) {
				try {
					ebsDb.close();
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		}
		}


		/*** Eq stores name as lastName,firstName ; hence modifying Name to keep same firstName + lastName format throughout ***/
		private String getModifiedName(String approverName) {
			
			if(approverName.contains(",")){
				
				String[] modifiedName = approverName.split(",");
				return (modifiedName[1].trim() + " " + modifiedName[0].trim());
			}
			
			else
				
				return approverName;

		}
}
	

