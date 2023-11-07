package com.qantas.ap.quartz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;














import org.quartz.utils.counter.Counter;

//import ap.quantas.com.PropertyLoader;
import ap.quantas.com.imaging.WSSecurityHeaderSOAPHandler;
import ap.quantas.com.imaging.documentUpdate.DocumentService;
import ap.quantas.com.imaging.documentUpdate.DocumentService_Service;
import ap.quantas.com.imaging.documentUpdate.FieldValue;
import ap.quantas.com.imaging.documentUpdate.TypedValue;
import ap.quantas.com.imaging.documentUpdate.FieldType;

public class Test
{
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		System.out.println("===== Imaging Update for All records : START ======");
		System.out.println("===== "+new Date()+" =====");
		
		
		
			Connection con = null;
			Statement st   = null;
			ResultSet rs   = null;
			
			try {
				
				System.out.println("Connecting UCM table and fetching data");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.239.133:16010:TESTOWC", "TEST_OCS", "WebT3st#123");
				System.out.println("UCM Connection successful");
				
				st = con.createStatement();
				String sql = ("select DDOCNAME from revisions");
				rs = st.executeQuery(sql);
				int count = 0;
				while(rs.next()) { 
				
				String docID = "35."+rs.getString("DDOCNAME");
				count=count+1;
				 //System.out.println("Result from DB - " + docID);
				 
				//Connection Part Imaging
					System.out.println("Connecting Imaging");
					
					DocumentService docUpdateService = new DocumentService_Service().getDocumentServicePort();
		            BindingProvider bindingProvider = (BindingProvider)docUpdateService;
		            @SuppressWarnings("rawtypes")
		            List<Handler> handlerChain = new ArrayList<Handler>();
		            // for PROD environment.
		            /*handlerChain.add(new WSSecurityHeaderSOAPHandler(
			 					"eqadmin",
			 					"eq@dmin123"*/
			 		// for TEST environment.
		            handlerChain.add(new WSSecurityHeaderSOAPHandler(
		           		 					"eqadmin",
		           		 					"eQs0a@dmin123"
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
		          
		            	try
		            	{         
		            		
			                List<FieldValue> fieldValues = new ArrayList<FieldValue>();	                 
			                
			                {
			                	FieldValue fieldValue1 = new FieldValue();
			                	fieldValue1.setName("Activity");             
				                TypedValue typedValue = new TypedValue();
				                typedValue.setType( FieldType.TEXT );
				                typedValue.setValue("eQ Paid");
				                fieldValue1.setValue(typedValue);
				                fieldValues.add(fieldValue1);
			                }
			                
			              
			                docUpdateService.updateDocument(new Holder<String>(docID==null?"":docID), null, fieldValues, false);
			                System.out.println("\t\tUpdating Webcenter IPM successful for docID : "+docID);
			                System.out.println("Total number of records updated till now = "+count);
			            }
		            	catch (Exception e)
		            	{
			                System.out.println("\t\tUpdating Webcenter IPM failed --- "+e.getMessage());
			                failedUpdateList.add(docID);
			                e.printStackTrace();
			                
			            	}
		            	if (failedUpdateList.size()>0){
						System.out.println("===== Number of failed updates : "+failedUpdateList.size());
						System.out.println("===== Failed update list : "+failedUpdateList);
		            	}
				}
			
			System.out.println("Total number of records updated = "+count);

			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if(null != st)
					st.close();
				if(null != rs)
					rs.close();
				if(null != con)
					con.close();
			}
		
	          
			System.out.println("===== Imaging Update for All records : END ======");
			System.out.println("===== "+new Date()+" =====");		
	
	
}
}
				
			
		
		
		

