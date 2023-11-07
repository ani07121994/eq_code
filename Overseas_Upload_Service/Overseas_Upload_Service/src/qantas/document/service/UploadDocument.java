package qantas.document.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.imaging.Application;
import oracle.imaging.ApplicationService;
import oracle.imaging.BasicUserToken;
import oracle.imaging.Document;
import oracle.imaging.DocumentContentService;
import oracle.imaging.DocumentService;
import oracle.imaging.ImagingException;
import oracle.imaging.NameId;
import oracle.imaging.ServicesFactory;
import oracle.imaging.UserToken;
//import qantas.document.exception.ServiceException;
//import qantas.document.exception.ServiceExceptionBean;

public class UploadDocument {
	@SuppressWarnings("deprecation")
	public String getDocId(Map map) throws Exception{
	 String docId = "";
      try { // try-catch
		 System.out.println("Map Values==="+map);

         UserToken credentials = new BasicUserToken((String)map.get("USER_NAME"), (String)map.get("PWD"));
         ServicesFactory servicesFactory =          
            ServicesFactory.login(credentials, Locale.US,(String)map.get("IMAGING_URL"));
         
         try { // try-finally to ensure logout
            DocumentService docService = servicesFactory.getDocumentService();
            DocumentContentService docContentService =                
               servicesFactory.getDocumentContentService();

            NameId invoicesAppNameId = null;

            // List the viewable applications to confirm that "Invoices" exists
            List<NameId> appsList =
             docService.listTargetApplications(Document.Ability.CREATEDOCUMENT);
           String strNameId = (String)map.get("APP_NAME");
           
            for (NameId nameId: appsList) {

                System.out.println("nameId.getName()=="+nameId.getName());
                if (nameId.getName().equals(strNameId)) {
                	invoicesAppNameId = nameId;
                }            	
            }
            if (invoicesAppNameId == null) {
               System.out.println("Invoices application not found.");
               //return;
            }
            System.out.println("invoicesAppNameId=="+invoicesAppNameId);

            // Upload document content
            String fileName = (String)map.get("upload_path");
            System.out.println("fileName=="+fileName);
            
            DataHandler fileData = new DataHandler(new FileDataSource(fileName));
            String strPath = "";
            if(fileName != null && !"".equals(fileName) && !fileName.equals("null")){
            	if(fileName.indexOf("\\") > 0)
            		strPath = "\\";
            	else
            		strPath = "/";
            }
            //fileName = fileName.substring(fileName.lastIndexOf((String)map.get("WINDOWS_PATH"))+1);//UNIX_PATH
            fileName = fileName.substring(fileName.lastIndexOf(strPath)+1);
            
            System.out.println("fileName=="+fileName);            
            String uploadToken = docContentService.uploadDocument(fileData, fileName);

            // Index the document
		    java.util.List<Document.FieldValue> fieldValues = new ArrayList<Document.FieldValue>();
		    
		    fieldValues.add(new Document.FieldValue("Username", ((String)map.get("Username") == null?"":(String)map.get("Username"))));
		    fieldValues.add(new Document.FieldValue("Activity", ((String)map.get("Activity") == null?"":(String)map.get("Activity"))));
		    //Start :Discussed with Nirmalya on 10th May to change the field name from Invoice Source to Source 
		    //fieldValues.add(new Document.FieldValue("Invoice Source", ((String)map.get("source") == null?"":(String)map.get("source"))));
		    //End :
		    fieldValues.add(new Document.FieldValue("Source", ((String)map.get("source") == null?"":(String)map.get("source"))));
		    fieldValues.add(new Document.FieldValue("Document Type", ((String)map.get("Document_Type") == null?"":(String)map.get("Document_Type"))));
		    fieldValues.add(new Document.FieldValue("Invoice Type", ((String)map.get("Invoice_Type") == null?"":(String)map.get("Invoice_Type"))));
		    fieldValues.add(new Document.FieldValue("Supplier ID", ((String)map.get("Supplier_ID") == null?"":(String)map.get("Supplier_ID"))));
		    fieldValues.add(new Document.FieldValue("Supplier Number", ((String)map.get("Supplier_Number") == null?"":(String)map.get("Supplier_Number"))));
		    fieldValues.add(new Document.FieldValue("Supplier Name", ((String)map.get("Supplier_Name") == null?"":(String)map.get("Supplier_Name"))));
		    fieldValues.add(new Document.FieldValue("Site ID", ((String)map.get("Site_ID") == null?"":(String)map.get("Site_ID"))));
		    fieldValues.add(new Document.FieldValue("Invoice Number", ((String)map.get("Invoice_Number") == null?"":(String)map.get("Invoice_Number"))));
		    fieldValues.add(new Document.FieldValue("Certifier Name", ((String)map.get("Certifier_Name") == null?"":(String)map.get("Certifier_Name"))));
		    fieldValues.add(new Document.FieldValue("Approver Name", ((String)map.get("Approver_Name") == null?"":(String)map.get("Approver_Name"))));
		    fieldValues.add(new Document.FieldValue("OrgID", ((String)map.get("OrgID") == null?"":(String)map.get("OrgID"))));
		    fieldValues.add(new Document.FieldValue("Currency", ((String)map.get("Currency") == null?"":(String)map.get("Currency"))));
		    
		    fieldValues.add(new Document.FieldValue("Capture Batch ID", ((String)map.get("Capture_Batch_ID") == null?"":(String)map.get("Capture_Batch_ID"))));
		    
		    
		    /*
		    "30/11/2018"
		    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		    Date invDate =  sdf.parse((String)map.get("Invoice_Date"));*/
		    
		    
		    
		    fieldValues.add(new Document.FieldValue("Invoice Date", ((String)map.get("Invoice_Date") == null?new java.util.Date("01/01/9999"):new java.util.Date((String)map.get("Invoice_Date")))));
		    //fieldValues.add(new Document.FieldValue("Invoice Date", ((String)map.get("Invoice_Date") == null?new java.util.Date("01/01/9999"):sdf.parse((String)map.get("Invoice_Date")))));
		    
		    //fieldValues.add(new Document.FieldValue("Invoice Date", ((String)map.get("Invoice_Date") == null?new java.util.Date("01/01/9999"):new java.util.Date((String)map.get("Invoice_Date")))));
		    fieldValues.add(new Document.FieldValue("Invoice Total", ((String)map.get("Invoice_Total") == null?new BigDecimal("0"):new BigDecimal((String)map.get("Invoice_Total")))));

		    System.out.println("fieldValues--- : "+fieldValues);
		    
		    /*fieldValues.add(new Document.FieldValue("Username", (String)map.get("Username")));
		    fieldValues.add(new Document.FieldValue("Activity", (String)map.get("Activity")));		    
		    fieldValues.add(new Document.FieldValue("Invoice Source", (String)map.get("source")));
		    fieldValues.add(new Document.FieldValue("Document Type",(String)map.get("Document_Type")));
		    fieldValues.add(new Document.FieldValue("Invoice Type",(String)map.get("Invoice_Type")));
		    fieldValues.add(new Document.FieldValue("Supplier ID",(String)map.get("Supplier_ID")));
		    fieldValues.add(new Document.FieldValue("Supplier Number",(String)map.get("Supplier_Number")));
		    fieldValues.add(new Document.FieldValue("Supplier Name",(String)map.get("Supplier_Name")));
		    fieldValues.add(new Document.FieldValue("Site ID",(String)map.get("Site_ID")));
		    fieldValues.add(new Document.FieldValue("Invoice Number",(String)map.get("Invoice_Number")));
		    fieldValues.add(new Document.FieldValue("Certifier Name",(String)map.get("Certifier_Name")));
		    fieldValues.add(new Document.FieldValue("Approver Name",(String)map.get("Approver_Name")));
		    fieldValues.add(new Document.FieldValue("OrgID",(String)map.get("OrgID")));
		    fieldValues.add(new Document.FieldValue("Currency",(String)map.get("Currency")));
		    fieldValues.add(new Document.FieldValue("Invoice Date",new java.util.Date((String)map.get("Invoice_Date"))));
		    fieldValues.add(new Document.FieldValue("Invoice Total",new BigDecimal((String)map.get("Invoice_Total"))));*/	
		    
		    docId = docService.createDocument(uploadToken, invoicesAppNameId, fieldValues, true);
		    System.out.println(fieldValues+"\n--- : "+docId);
            
         }
         
       
         finally {
            if (servicesFactory != null) {
               servicesFactory.logout();
            }
         }
      }
      catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
         throw new Exception("Exception inside document upload :"+e.getMessage());
      }
      return docId;
   }


}
