package com.audit.utility;


import java.util.List;
import java.util.Locale;

import oracle.imaging.BasicUserToken;
import oracle.imaging.Document;
import oracle.imaging.DocumentService;
import oracle.imaging.ImagingException;
import oracle.imaging.ServicesFactory;

import oracle.imaging.UserToken;
import oracle.imaging.Document.FieldValue;
import oracle.imaging.Document.SectionSet;

public class QueryWFR {
	
	public String validateInvoiceNumber(String documentID) {
		String invoiceNo = null;
		System.out.println("inside query WFR doc id :"+documentID);
		
		try { // try-catch
			//UserToken credentials = new BasicUserToken("eqadmin", "weblogic1"); //	TEST
			UserToken credentials = new BasicUserToken("weblogic", "wls123@PRD"); //	PROD
			ServicesFactory servicesFactory = 
			//ServicesFactory.login(credentials, Locale.US,"http://eqtest-capture1:16033/imaging/ws");
					ServicesFactory.login(credentials, Locale.US,"http://eqprod-capture1:16033/imaging/ws");
			try { // try-finally to ensure logout
			DocumentService docService = servicesFactory.getDocumentService();

			
			SectionSet sectionSet = Document.SectionSet.of(Document.SectionFlag.FIELDVALUES);
			
			Document dd = docService.getDocument(documentID, sectionSet);
			
			List<FieldValue> listFields =  dd.getFieldValues();
			
			
			for(FieldValue ob : listFields){
				System.out.println(ob.getName() + "--> "+ob.getStringValue());
				if(ob.getName().equals("Invoice Number"))
				{
					invoiceNo = ob.getStringValue();
					//System.out.println("Invoice Number : "+ob.getStringValue());
					break;
				}

			}
			
			return invoiceNo;
			
			}
finally {
			if (servicesFactory != null) {
			servicesFactory.logout();
			}
		}
	}
	catch (ImagingException e) {
		e.printStackTrace();
	}
		
		return null;

}
}
