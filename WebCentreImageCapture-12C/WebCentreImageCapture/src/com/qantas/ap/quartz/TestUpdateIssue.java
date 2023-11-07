package com.qantas.ap.quartz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

import ap.quantas.com.imaging.WSSecurityHeaderSOAPHandler;
import ap.quantas.com.imaging.documentUpdate.DocumentService;
import ap.quantas.com.imaging.documentUpdate.DocumentService_Service;
import ap.quantas.com.imaging.documentUpdate.FieldType;
import ap.quantas.com.imaging.documentUpdate.FieldValue;
import ap.quantas.com.imaging.documentUpdate.TypedValue;

public class TestUpdateIssue {
	public static final String DATA_FETCH_QUERY_APPS = "SELECT ai.invoice_num ,ai.invoice_id ,as1.segment1 supplier_number ,as1.vendor_id supplier_id ,ass.vendor_site_id site_id ,ai.org_id ,hou.NAME ,ai.invoice_currency_code ,ai.invoice_amount ,to_char(ai.invoice_date ,'YYYY-MM-DD') invoice_date ,ail.freight ,ail.aog ,ail.due_date ,ail.witholding_tax ,(SELECT ph.segment1 FROM apps.po_headers_all       ph ,apps.ap_invoice_lines_all ail WHERE ail.po_header_id = ph.po_header_id AND nvl(ail.discarded_flag ,'N') <> 'Y' AND rownum < 2 AND ail.invoice_id = ai.invoice_id) po_number ,ai.invoice_type_lookup_code ap_invoice_type ,ai.SOURCE ap_invoice_source ,decode((SELECT COUNT(1) FROM apps.fnd_lookup_values flv WHERE flv.lookup_type = 'QFEQ_JETSTAR_JBA_SETUP_CONTROL' AND flv.lookup_code = ai.org_id) ,1 ,nvl((SELECT APPS.jseq_ap_inv_img_process.amount_rounding(flv.tag,(conversion_rate * ai.invoice_amount)) FROM gl.gl_daily_rates ,apps.fnd_lookup_values flv WHERE conversion_date = ai.gl_date AND from_currency = ai.invoice_currency_code AND to_currency = flv.tag AND conversion_type = 1000 AND flv.lookup_type = 'QFEQ_JETSTAR_JBA_SETUP_CONTROL' AND flv.lookup_code = ai.org_id) ,ai.invoice_amount) ,nvl(ai.base_amount ,ai.invoice_amount)) currency_equivalent ,regexp_substr(ai.attribute15 ,'[^_]+' ,1 ,2) image_url ,regexp_substr(ai.global_attribute2 ,'[^_]+' ,1 ,2)  image_url2 ,regexp_substr(ai.global_attribute3 ,'[^_]+' ,1 ,2)  image_url3 ,'eQ ' || initcap(decode(ai.cancelled_date ,NULL ,decode(ai.payment_status_flag ,'Y' ,'Paid' ,decode(hist.response ,NULL ,'Created' ,hist.response)) ,'Cancelled')) invoice_status ,hist.approver_name pending_with_approved_by ,hist.last_update_date action_date ,paymnt.check_number payment_number ,to_char(paymnt.check_date ,'YYYY-MM-DD') payment_date ,ai.description FROM apps.ap_invoices_all ai ,apps.ap_suppliers as1 ,apps.ap_supplier_sites_all ass ,(SELECT * FROM (SELECT rank() over(PARTITION BY invoice_id ORDER BY aha.invoice_id, aha.last_update_date DESC, aha.approval_history_id DESC) sl_no ,aha.* FROM apps.ap_inv_aprvl_hist_all aha) WHERE sl_no = 1) hist ,(SELECT ac.check_number ,ac.check_date ,aip.invoice_id FROM apps.ap_invoice_payments_all aip ,apps.ap_checks_all           ac WHERE ac.check_id = aip.check_id AND ac.void_date IS NULL) paymnt ,(SELECT SUM(decode(ail.line_type_lookup_code ,'AWT' ,amount ,0)) witholding_tax ,SUM(decode(ail.line_type_lookup_code ,'FREIGHT' ,amount ,0)) freight ,SUM(decode(ail.line_type_lookup_code ,'MISCELLANEOUS' ,amount ,0)) aog ,aps.due_date ,aps.invoice_id FROM apps.ap_payment_schedules_all aps ,apps.ap_invoice_lines_all     ail WHERE aps.invoice_id = ail.invoice_id GROUP BY aps.invoice_id ,aps.due_date) ail ,apps.fnd_lookup_values flv ,apps.hr_operating_units hou WHERE ai.SOURCE = flv.lookup_code AND flv.lookup_type = 'SOURCE' AND flv.attribute15 = 'Y' AND ai.vendor_id = as1.vendor_id AND ass.vendor_id = as1.vendor_id AND ass.vendor_site_id = ai.vendor_site_id AND ai.invoice_id = hist.invoice_id(+) AND paymnt.invoice_id(+) = ai.invoice_id AND ail.invoice_id = ai.invoice_id AND ai.org_id = hou.organization_id AND ai.creation_date > '01-JAN-2016' AND upper(ai.attribute15)  like '%HTTP%' AND (ai.last_update_date >= to_date('2020-06-14 10:33:09', 'YYYY-MM-DD HH24:MI:ss') OR hist.last_update_date >= to_date('2020-06-14 10:33:09', 'YYYY-MM-DD HH24:MI:ss') ) AND (ai.last_update_date < to_date('2020-06-16 10:35:09', 'YYYY-MM-DD HH24:MI:ss') OR hist.last_update_date < to_date('2020-06-16 10:35:09', 'YYYY-MM-DD HH24:MI:ss') ) UNION ALL SELECT ai.invoice_num ,ai.invoice_id ,as1.segment1 supplier_number ,as1.vendor_id supplier_id ,ass.vendor_site_id site_id ,ai.org_id ,hou.NAME ,ai.invoice_currency_code ,ai.invoice_amount ,to_char(ai.invoice_date ,'YYYY-MM-DD') invoice_date ,NULL ,NULL ,NULL ,NULL ,NULL po_number ,ai.invoice_type_lookup_code ap_invoice_type ,ai.SOURCE ap_invoice_source ,NULL ,regexp_substr(ai.attribute15 ,'[^_]+' ,1 ,2) image_url ,regexp_substr(ai.global_attribute2 ,'[^_]+' ,1 ,2)  image_url2 ,regexp_substr(ai.global_attribute3 ,'[^_]+' ,1 ,2)  image_url3 ,'eQ ' || decode(status ,'REJECTED' ,'Interface Rejected' ,NULL ,'Awaiting Import' ,status) ,NULL last_actioned_by ,NULL last_action_date ,NULL payment_number ,NULL payment_date ,ai.description FROM apps.ap_invoices_interface ai ,apps.ap_suppliers          as1 ,apps.ap_supplier_sites_all ass ,apps.fnd_lookup_values     flv ,apps.hr_operating_units    hou WHERE ai.SOURCE = flv.lookup_code AND flv.lookup_type = 'SOURCE' AND flv.attribute15 = 'Y' AND ai.vendor_id = as1.vendor_id(+) AND ass.vendor_site_id(+) = ai.vendor_site_id AND ai.org_id = hou.organization_id AND nvl(status ,'NEW') <> 'PROCESSED' AND upper(ai.attribute15)  like '%HTTP%' UNION ALL SELECT ai.invoice_num ,ai.invoice_id ,as1.segment1 supplier_number ,as1.vendor_id supplier_id ,ass.vendor_site_id site_id ,ai.org_id ,hou.NAME ,ai.invoice_currency_code ,ai.invoice_amount ,to_char(ai.invoice_date ,'YYYY-MM-DD') invoice_date ,NULL ,NULL ,NULL ,NULL ,NULL po_number ,ai.invoice_type_lookup_code ap_invoice_type ,ai.SOURCE ap_invoice_source ,NULL ,regexp_substr(ai.attribute15 ,'[^_]+' ,1 ,2) image_url ,regexp_substr(ai.global_attribute2 ,'[^_]+' ,1 ,2)  image_url2 ,regexp_substr(ai.global_attribute3 ,'[^_]+' ,1 ,2)  image_url3 ,'eQ Interface Deleted' ,NULL last_actioned_by ,NULL last_action_date ,NULL payment_number ,NULL payment_date ,ai.description FROM bolinf.qfeq_ap_inv_intrfc_del_audit ai ,apps.ap_suppliers                   as1 ,apps.ap_supplier_sites_all          ass ,apps.fnd_lookup_values              flv ,apps.hr_operating_units             hou WHERE ai.SOURCE = flv.lookup_code AND flv.lookup_type = 'SOURCE' AND flv.attribute15 = 'Y' AND ai.vendor_id = as1.vendor_id(+) AND ass.vendor_site_id(+) = ai.vendor_site_id AND ai.org_id = hou.organization_id  ";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String dt="2020-11-21 21:31:46.0";
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
		Date date;
		try {
			//date = format1.parse("2013-02-21");
			date = format1.parse(dt);
			System.out.println(format2.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println(DATA_FETCH_QUERY_APPS);
		DatabaseUtility dbUtil = new DatabaseUtility();
		ArrayList<StatusDetails> statusList = new ArrayList<StatusDetails>();
		
		Connection con = null;
		ResultSet rs1 = null;
		PreparedStatement ps = null;
		Map<String, String> dbParams = new HashMap<String, String>();
		
		dbParams.put("HOST", "jdbc:oracle:thin:@eqprod-db1.qantas.com.au:16010:PEBSDB1");
		dbParams.put("USER", "appsview");
		dbParams.put("PASSWORD", "Password08");
		
		
		
		
        
		con = dbUtil.getConnection(dbParams);
	
			try {
				ps = con.prepareStatement(DATA_FETCH_QUERY_APPS);
			
			rs1 = ps.executeQuery();

			while (rs1.next()) {
				String inv_num=rs1.getString("invoice_num");
				//System.out.println("   inv_num   "+inv_num);
				if("00012812".equalsIgnoreCase(inv_num) || "00012811".equalsIgnoreCase(inv_num) || "00012810".equalsIgnoreCase(inv_num)||"2075401".equalsIgnoreCase(inv_num)
						||"380342".equalsIgnoreCase(inv_num)||"380452".equalsIgnoreCase(inv_num)||"2087835".equalsIgnoreCase(inv_num)) {
					StatusDetails details = new StatusDetails();
					
					details.setInvoice_num(rs1.getString("invoice_num"));
					details.setSupplier_number(rs1.getString("supplier_number"));
					details.setSite_id(rs1.getString("site_id"));
					details.setOrg_id(rs1.getString("org_id"));
					details.setInvoice_status(rs1.getString("invoice_status"));
					details.setImage_url(rs1.getString("image_url"));
					// System.out.println("Image Url from DB " + rs1.getString("image_url"));
					
					// Two columns newly added for Finessecost
					details.setImage_url2(rs1.getString("image_url2"));
				 //System.out.println("Image Url2 from DB " + rs1.getString("image_url2"));
					details.setImage_url3(rs1.getString("image_url3"));
					// System.out.println("Image Url3 from DB " + rs1.getString("image_url3"));
					// Finessecost End
					
					details.setApprover_name(rs1.getString("pending_with_approved_by"));
					details.setPayment_date(rs1.getString("payment_date"));
					details.setPayment_number(rs1.getString("payment_number"));
					
					// Newly added for ECM Update
					details.setSupplier_id(rs1.getString("supplier_id"));
					details.setOperating_unit_name(rs1.getString("NAME"));
					details.setCurrency(rs1.getString("invoice_currency_code"));
					details.setInvoice_total(rs1.getString("invoice_amount"));
					details.setAog(rs1.getString("aog"));
					details.setFreight(rs1.getString("freight"));
					details.setCurrency_equivalent(rs1.getString("currency_equivalent"));
					details.setDue_date(rs1.getString("due_date"));
					details.setInvoice_date(rs1.getString("invoice_date"));
					details.setPo_number(rs1.getString("po_number"));
					System.out.println("rs1.getString(\"description\") "+rs1.getString("description"));
					details.setDescription(rs1.getString("description"));
					
					statusList.add(details);
				}
			}
			
			System.out.println("Status list size :: "+statusList.size());
			
			System.out.println("Connecting Imaging");
			
			DocumentService docUpdateService = new DocumentService_Service().getDocumentServicePort();
	        BindingProvider bindingProvider = (BindingProvider)docUpdateService;
	        @SuppressWarnings("rawtypes")
	        List<Handler> handlerChain = new ArrayList<Handler>();
	        // for PROD environment.
	        handlerChain.add(new WSSecurityHeaderSOAPHandler(
	 					"eqadmin",
	 					"eQs0a@dmin123"
	 		// for TEST environment.
	        /*handlerChain.add(new WSSecurityHeaderSOAPHandler(
	       		 					"eqadmin",
	       		 					"weblogic1"*/
	 		// for TEST environment.
	 		/*handlerChain.add(new WSSecurityHeaderSOAPHandler(
	 		           		 		"eqadmin",
	 		           		 		"weblogic1"*/
	                             )
	                        );
	        
	        System.out.println("Imaging Connection Successful");

	// Connection Part Imaging End        
	     
	        bindingProvider.getBinding().setHandlerChain(handlerChain);
	        ArrayList<String> failedUpdateList = new ArrayList<String>();
	        
	        
	         String docID = null;
	            for(int i=0;i<statusList.size();i++)
	            {
	            	
	            	StatusDetails detail = statusList.get(i);
	            	
	            	 System.out.println("Inside Update For loop....");
	            	//String docID = "35.IPM_010721";
	            	 System.out.println("Invoice Number .........:::: "+detail.getInvoice_num());
	            	 System.out.println("Invoice dESCRIPTION .........:::: "+detail.getDescription());
	            	 System.out.println("\t\tdetail.getInvoice_status() "+detail.getInvoice_status());
	            	String imgUrl = detail.getImage_url();
	            	if (imgUrl != null){
	            		 System.out.println("Image URL : "+imgUrl);
		            	//docID = "2.IPM_"+imgUrl;
	            		docID = "2.IPM_" + imgUrl;
	            		 System.out.println("imgUrl fetched from " +Constant.compileFor.value()+ " env. having docID :" +docID);
	            		updateDocCustom(detail, docID, docUpdateService);
	            		 System.out.println("All records updated against imgUrl, docID  :"+docID);
	            	}
	            	
	            	String imgUrl2 = detail.getImage_url2();
	            	if (imgUrl2 != null){
	            		
	            		 System.out.println("Image URL2 : "+imgUrl2);
		            	docID ="2.IPM_" + imgUrl2;
		            	 System.out.println("imgUrl2 fetched from " +Constant.compileFor.value()+ " env. having docID :" +docID);
	            		updateDocCustom(detail, docID, docUpdateService);
	            		 System.out.println("All records updated against imgUrl2, docID  :"+docID);
	            	}
         		
	            	String imgUrl3 = detail.getImage_url3();
	            	if (imgUrl3 != null){
	            		 System.out.println("Image URL3 : "+imgUrl3);
		            	docID = "2.IPM_" + imgUrl3;
		            	 System.out.println("imgUrl3 fetched from " +Constant.compileFor.value()+ " env. having docID :" +docID);
	            		updateDocCustom(detail, docID, docUpdateService);
	            		 System.out.println("All records updated against imgUrl3, docID  :"+docID);
	            	}
	            	
	            	//split = imgUrl.split("=");
         		//String docURL = split[0];
	            	//String docID = split[1];
	            	// System.out.println(docURL..."+docURL);
	            //	i=2;
	            }
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
public static void updateDocCustom(StatusDetails detail,String docID,DocumentService docUpdateService){
		
	System.out.println( "Updating for DOCID :::"+docID);
		
		try
		
    	{             
            List<FieldValue> fieldValues = new ArrayList<FieldValue>();	                 
            
            {
            	FieldValue fieldValue1 = new FieldValue();
            	fieldValue1.setName("Activity");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.TEXT );
                typedValue.setValue(detail.getInvoice_status());
                System.out.println("\t\tdetail.getInvoice_status() "+detail.getInvoice_status());
                fieldValue1.setValue(typedValue);
                fieldValues.add(fieldValue1);
            }
            
            {
            	FieldValue fieldValue2 = new FieldValue();
            	fieldValue2.setName("Approver Name");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.TEXT );
                typedValue.setValue( detail.getApprover_name() );
                System.out.println("\t\tdetail.getApprover_name() "+detail.getApprover_name());
                fieldValue2.setValue(typedValue);
                fieldValues.add(fieldValue2);
            }
            
            {
            	FieldValue fieldValue3 = new FieldValue();
            	fieldValue3.setName("Payment Number");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.TEXT );
                typedValue.setValue( detail.getPayment_number());
                System.out.println("\t\tdetail.getPayment_number() "+detail.getPayment_number());
                fieldValue3.setValue(typedValue);
                fieldValues.add(fieldValue3);
            }
            
            {
            	FieldValue fieldValue4 = new FieldValue();
            	fieldValue4.setName("Invoice Number");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.TEXT );
                typedValue.setValue(detail.getInvoice_num());
                System.out.println("\t\tdetail.getInvoice_num() "+detail.getInvoice_num());
                fieldValue4.setValue(typedValue);
                fieldValues.add(fieldValue4);
            }
            
            {
            	FieldValue fieldValue5 = new FieldValue();
            	fieldValue5.setName("Payment Date");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.DATE );
                typedValue.setValue( detail.getPayment_date());
                System.out.println("\t\tdetail.getPayment_date() "+detail.getPayment_date());
                fieldValue5.setValue(typedValue);
                fieldValues.add(fieldValue5);
            }
            
            //newly added
            {
            	FieldValue fieldValue6 = new FieldValue();
            	fieldValue6.setName("Supplier ID");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.TEXT );
                typedValue.setValue(detail.getSupplier_id());
                System.out.println("\t\tdetail.getSupplier_id() "+detail.getSupplier_id());
                fieldValue6.setValue(typedValue);
                fieldValues.add(fieldValue6);
            }
			
			{
            	FieldValue fieldValue7 = new FieldValue();
            	fieldValue7.setName("Operating Unit Name");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.TEXT );
                typedValue.setValue(detail.getOperating_unit_name());
                System.out.println("\t\tdetail.getOperating_unit_name() "+detail.getOperating_unit_name());
                fieldValue7.setValue(typedValue);
                fieldValues.add(fieldValue7);
            }
			
			{
            	FieldValue fieldValue8 = new FieldValue();
            	fieldValue8.setName("Currency");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.TEXT );
                typedValue.setValue(detail.getCurrency());
                System.out.println("\t\tdetail.getCurrency() "+detail.getCurrency());
                fieldValue8.setValue(typedValue);
                fieldValues.add(fieldValue8);
            }
			
			{
            	FieldValue fieldValue9 = new FieldValue();
            	fieldValue9.setName("Invoice Total");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.DECIMAL );
                typedValue.setValue(detail.getInvoice_total());
                System.out.println("\t\tdetail.getInvoice_total() "+detail.getInvoice_total());
                fieldValue9.setValue(typedValue);
                fieldValues.add(fieldValue9);
            }
			
			{
            	FieldValue fieldValue10 = new FieldValue();
            	fieldValue10.setName("AOG");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.DECIMAL );
                typedValue.setValue(detail.getAog());
                System.out.println("\t\tdetail.getAog() "+detail.getAog());
                fieldValue10.setValue(typedValue);
                fieldValues.add(fieldValue10);
            }
			
			{
            	FieldValue fieldValue11 = new FieldValue();
            	fieldValue11.setName("Freight");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.DECIMAL );
                typedValue.setValue(detail.getFreight());
                System.out.println("\t\tdetail.getFreight() "+detail.getFreight());
                fieldValue11.setValue(typedValue);
                fieldValues.add(fieldValue11);
            }
			
			{
            	FieldValue fieldValue12 = new FieldValue();
            	fieldValue12.setName("Currency Equivalent");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.DECIMAL );
                typedValue.setValue(detail.getCurrency_equivalent());
                System.out.println("\t\tdetail.getCurrency_equivalent() "+detail.getCurrency_equivalent());
                fieldValue12.setValue(typedValue);
                fieldValues.add(fieldValue12);
            }
			
			{
            	FieldValue fieldValue13 = new FieldValue();
            	fieldValue13.setName("Due date");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.DATE );
                typedValue.setValue( detail.getDue_date());
                System.out.println("\t\tdetail.getDue_date() "+detail.getDue_date());
                fieldValue13.setValue(typedValue);
                fieldValues.add(fieldValue13);
            }
			
			{
            	FieldValue fieldValue14 = new FieldValue();
            	fieldValue14.setName("Invoice Date");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.DATE );
	            typedValue.setValue( detail.getInvoice_date());
	            System.out.println("\t\tdetail.getInvoice_date() "+detail.getInvoice_date());
	            fieldValue14.setValue(typedValue);
	            fieldValues.add(fieldValue14);
            }
			
			{
            	FieldValue fieldValue15 = new FieldValue();
            	fieldValue15.setName("PO Number");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.TEXT );
                typedValue.setValue(detail.getPo_number());
                System.out.println("\t\tdetail.getPo_number() "+detail.getPo_number());
                fieldValue15.setValue(typedValue);
                fieldValues.add(fieldValue15);
            }
			
			{
            	FieldValue fieldValue16 = new FieldValue();
            	fieldValue16.setName("InvoiceDescription");             
                TypedValue typedValue = new TypedValue();
                typedValue.setType( FieldType.TEXT );
                typedValue.setValue(detail.getDescription());
                System.out.println("\t\tdetail.getDescription() "+detail.getDescription());
//                System.out.println("detail.getDescription() "+detail.getDescription());
                fieldValue16.setValue(typedValue);
                fieldValues.add(fieldValue16);
            }
          
            docUpdateService.updateDocument(new Holder<String>(docID==null?"":docID), null, fieldValues, false);
            System.out.println("\t\tUpdating Webcenter IPM successful for DocID ---" +docID);
            //noOfMatchedRecords++;
            
        }
    	catch (Exception e)
    	{
    	
            System.out.println("\t\tUpdating Webcenter IPM failed for DocID --- " +docID+ " with error " +e.getMessage());
        	//logger.log(Level.INFO, "Error "+e );
        	e.printStackTrace();
            //failedUpdateList.add(docID);
            //e.printStackTrace();
        }
	}

}
