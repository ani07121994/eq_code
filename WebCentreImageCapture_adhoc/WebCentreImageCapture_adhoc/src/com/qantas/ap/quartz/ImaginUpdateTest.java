package com.qantas.ap.quartz;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

import ap.quantas.com.imaging.WSSecurityHeaderSOAPHandler;
import ap.quantas.com.imaging.documentUpdate.DocumentService;
import ap.quantas.com.imaging.documentUpdate.DocumentService_Service;
import ap.quantas.com.imaging.documentUpdate.FieldType;
import ap.quantas.com.imaging.documentUpdate.FieldValue;
import ap.quantas.com.imaging.documentUpdate.TypedValue;

public class ImaginUpdateTest {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		

		
		
		try {
			DocumentService docUpdateService = new DocumentService_Service().getDocumentServicePort();
	        BindingProvider bindingProvider = (BindingProvider)docUpdateService;
	        @SuppressWarnings("rawtypes")
	        List<Handler> handlerChain = new ArrayList<Handler>();
	        handlerChain.add(new WSSecurityHeaderSOAPHandler(
	       		 					"eqadmin",
	       		 					"eQs0a@dmin123"
	                             )
	                        );
	        bindingProvider.getBinding().setHandlerChain(handlerChain);

	        
	        
	        List<FieldValue> fieldValues = new ArrayList<FieldValue>();			                 
	        
            FieldValue fieldValue1 = new FieldValue();
            fieldValue1.setName("Supplier Name");             
            TypedValue typedValue1 = new TypedValue();
            typedValue1.setType( FieldType.TEXT );
            typedValue1.setValue( "Supplier Name" );
            fieldValue1.setValue(typedValue1);
            
            FieldValue fieldValue2 = new FieldValue();
            fieldValue2.setName("Invoice Number");             
            TypedValue typedValue2 = new TypedValue();
            typedValue2.setType( FieldType.TEXT );
            typedValue2.setValue("Invoice Number");
            fieldValue2.setValue(typedValue2);
            
            FieldValue fieldValue3 = new FieldValue();
            fieldValue3.setName("Invoice Date");             
            TypedValue typedValue3 = new TypedValue();
            typedValue3.setType( FieldType.DATE );
            typedValue3.setValue(null);
            fieldValue3.setValue(typedValue3);
            
            FieldValue fieldValue4 = new FieldValue();
            fieldValue4.setName("Invoice Total");             
            TypedValue typedValue4 = new TypedValue();
            typedValue4.setType( FieldType.DECIMAL );
            typedValue4.setValue( "100.50" );
            fieldValue4.setValue(typedValue4);
            
            FieldValue fieldValue5 = new FieldValue();
            fieldValue5.setName("PO Number");             
            TypedValue typedValue5 = new TypedValue();
            typedValue5.setType( FieldType.TEXT );
            typedValue5.setValue( "PO1234" );
            fieldValue5.setValue(typedValue5);
            
            FieldValue fieldValue6 = new FieldValue();
            fieldValue6.setName("Site ID");             
            TypedValue typedValue6 = new TypedValue();
            typedValue6.setType( FieldType.TEXT );
            typedValue6.setValue( "12345" );
            fieldValue6.setValue(typedValue6);
            
            FieldValue fieldValue7 = new FieldValue();
            fieldValue7.setName("Supplier Number");             
            TypedValue typedValue7 = new TypedValue();
            typedValue7.setType( FieldType.TEXT );
            typedValue7.setValue( "56789" );
            fieldValue7.setValue(typedValue7);
            
            FieldValue fieldValue8 = new FieldValue();
            fieldValue8.setName("Certifier Name");             
            TypedValue typedValue8 = new TypedValue();
            typedValue8.setType( FieldType.TEXT );
            typedValue8.setValue( "Certifier Name" );
            fieldValue8.setValue(typedValue8);
            
            
            fieldValues.add(fieldValue1);
            fieldValues.add(fieldValue2);         
            fieldValues.add(fieldValue3);
            fieldValues.add(fieldValue4);
            fieldValues.add(fieldValue5);
            fieldValues.add(fieldValue6);
            fieldValues.add(fieldValue7);
            fieldValues.add(fieldValue8);	                
	        
	        String docId = "10.IPM_003659";
	        
	        docUpdateService.updateDocument(new Holder<String>(docId==null?"":docId.toString()), null, fieldValues, false);
	        System.out.println("\t\tUpdating Webcenter IPM successful ---");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
	}
	
	
	
	
	
	public static void main2(String[] args) {
		
		
		try {
			DocumentService docUpdateService = new DocumentService_Service().getDocumentServicePort();
	        BindingProvider bindingProvider = (BindingProvider)docUpdateService;
	        @SuppressWarnings("rawtypes")
	        List<Handler> handlerChain = new ArrayList<Handler>();
	        handlerChain.add(new WSSecurityHeaderSOAPHandler(
	       		 					"eqadmin",
	       		 					"eQs0a@dmin123"
	                             )
	                        );
	        bindingProvider.getBinding().setHandlerChain(handlerChain);

	        
	        
	        List<FieldValue> fieldValues = new ArrayList<FieldValue>();			                 
	        
	        {
	        	FieldValue fieldValue1 = new FieldValue();
	        	fieldValue1.setName("Activity");             
	            TypedValue typedValue = new TypedValue();
	            typedValue.setType( FieldType.TEXT );
	            typedValue.setValue( "eQ Reject" );
	            fieldValue1.setValue(typedValue);
	            fieldValues.add(fieldValue1);
	        }			                
	        {
	        	FieldValue fieldValue2 = new FieldValue();
	        	fieldValue2.setName("Approver Name");             
	            TypedValue typedValue = new TypedValue();
	            typedValue.setType( FieldType.TEXT );
	            typedValue.setValue( "Sterling, Michael" );
	            fieldValue2.setValue(typedValue);
	            fieldValues.add(fieldValue2);
	        }
	        {
	        	FieldValue fieldValue3 = new FieldValue();
	        	fieldValue3.setName("Payment Term");             
	            TypedValue typedValue = new TypedValue();
	            typedValue.setType( FieldType.TEXT );
	            typedValue.setValue( "3027231" );
	            fieldValue3.setValue(typedValue);
	            fieldValues.add(fieldValue3);
	        }
	        {
	        	FieldValue fieldValue4 = new FieldValue();
	        	fieldValue4.setName("Payment Date");             
	            TypedValue typedValue = new TypedValue();
	            typedValue.setType( FieldType.DATE );
	            typedValue.setValue( "2016-08-12" );
	            fieldValue4.setValue(typedValue);
	            fieldValues.add(fieldValue4);
	        }			                
	        
	        String docId = "9.IPM_004499";
	        
	        docUpdateService.updateDocument(new Holder<String>(docId==null?"":docId.toString()), null, fieldValues, false);
	        System.out.println("\t\tUpdating Webcenter IPM successful ---");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
