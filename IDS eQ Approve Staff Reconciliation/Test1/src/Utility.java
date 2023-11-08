
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;


import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;




public class Utility {
	public static Map<String, String> propMap1 =  getProperties();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	static String currentDate =sdf.format(new Date());
	static Date current = new Date();
	static Date d = new Date(new Date().getTime() + 86400000);
	static String nextDate =sdf.format(d);
	
	public static final String DATA_FETCH_QUERY = "select distinct EMPLOYEE_NUMBER,application_flag from APPS.qfeqids_basic_det_tbl WHERE\r\n" + 
			"application_flag in ('APPROVED', 'BG PEND', 'BG_NOT_REQD')\r\n" + 
			"and (effective_date between '"+currentDate+"' and '"+nextDate+"')";
	
	
	
	private static Service service = null;
	private static QName serviceName = new QName(propMap1.get("EQ"), "QSService");
	private static QName portName = new QName(propMap1.get("EQ"), "QSPort");

	public static void main(String[] args) {
    Date current = new Date();
		System.out.println("start main method==>"+current);			
		  getOSBURL();
		MissingRecordsIds();

	}


	private static String getOSBURL() {
		String QF_COMPILATION_ENVIRONMENT = propMap1.get("ENV");

		if (QF_COMPILATION_ENVIRONMENT.equals("DEV")) {
			
			return propMap1.get("OSBURL");// sit
		}
		else if (QF_COMPILATION_ENVIRONMENT.equals("PSP")) {
			
			return propMap1.get("OSBURL");
		}

		else if (QF_COMPILATION_ENVIRONMENT.equals("PROD")) {
			return propMap1.get("OSBURL");
		}
		return null;
	}


	public static Map<String, String> getProperties() {
		Map<String, String> propMap = new HashMap<String, String>();
		try {
			InputStream reader = null;
			
			 reader = Utility.class.getClassLoader().getResourceAsStream("config1.properties");

			Properties p = new Properties();
			p.load(reader);
			//p.load(i);
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

	@SuppressWarnings("resource")
	public static void MissingRecordsIds() {
		 System.out.println("================MissingRecordsIds=================================");
		DataBaseUtility dbUtil = new DataBaseUtility();
		Connection con = null;
		Connection con1 = null;
		Connection con2  = null;
		
		System. out. println("Current JVM version - " + System. getProperty("java.version"));
		Map<String, Object[]> empData = new TreeMap<String, Object[]>();
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet= workbook.createSheet("Employee Data ");
		XSSFRow row;

		PreparedStatement ps  = null;
		ResultSet rs = null;
		PreparedStatement ps1  = null;
		ResultSet rs1 = null;
		PreparedStatement ps2  = null;
		ResultSet rs2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs3 = null;

		try {
			System.out.println("connection establishing for EQ");
			String uri = getOSBURL() + "/syncStatusFieldForOFReport/Proxy_Services/syncStatusFieldForOFReport_PS";
			createService(uri);
			System.out.println(uri);
			String request = "<qfeq:QFEQIDS_APPROVE_USER_NOTIFICATIONSInput xmlns:qfeq=\"http://xmlns.oracle.com/pcbpel/adapter/db/QFEQIDS_APPROVE_USER_NOTIFICATIONS\">\n"
					+ " <qfeq:FromDate>"+currentDate+"</qfeq:FromDate>\r\n" + 
					"<qfeq:ToDate>"+nextDate+"</qfeq:ToDate>\r\n" + 
					"" + "</qfeq:QFEQIDS_APPROVE_USER_NOTIFICATIONSInput>";
			
			Document document = callService(request);
			System.out.println("CallService " + document);
			NodeList nodeList = document.getDocumentElement().getChildNodes();
			System.out.println(nodeList.getLength());
			
            if(document!=null && document.getDocumentElement()!=null && document.getDocumentElement().getFirstChild()!=null && document.getDocumentElement().getFirstChild().getNodeName()!=null)
			System.out.println("Length >> " + document.getDocumentElement().getFirstChild().getNodeName());
			Map<String, String> eqParamsOSB = new HashMap<String, String>();
			List<String> emp = new ArrayList<>();


			for (int i = 0; i < nodeList.getLength(); i++) {
				eqParamsOSB.put(document.getElementsByTagName("EMPLOYEE_NUMBER").item(i).getTextContent(),document.getElementsByTagName("application_flag").item(i).getTextContent());
				emp.add((document.getElementsByTagName("EMPLOYEE_NUMBER").item(i).getTextContent()));


			}
			System.out.println("fetched from osb service"+eqParamsOSB);
			System.out.println("osb count"+nodeList.getLength());

			Map<String, String> eqParams = new HashMap<String, String>();
            int eqOsbCount = nodeList.getLength();
			
		Map<String, String> idsDbParams = new HashMap<String, String>();
		String envs = propMap1.get("ENV");
		if (envs != null) {
			idsDbParams.put("HOST", propMap1.get("HOST" ));
			idsDbParams.put("USER", propMap1.get("USER"));
			idsDbParams.put("PASSWORD", propMap1.get("PASSWORD"));
		}
	 System.out.println(":IdS DB Params: "+idsDbParams);
		 con1 = dbUtil.getConnection(idsDbParams);
			if(emp!=null && emp.size()>0) {

				System.out.println("IDS CONNECTION"+con1);
				if(con1!=null) {
					System.out.println("ids db conn established");
					String output = "";
					for (int i = 0; i < emp.size(); i++)
					
					{
					    output += "'"+emp.get(i) +"'"+ ",";
					}
					System.out.println(output);
					output = output.substring(0, output.length()-1);
					System.out.println("EQ Emp List===>"+output);
					 ps1 = con1.prepareStatement("select EMPLOYEE_NUMBER,APPLICATION_STATUS from QFEQIDS_BASIC_DET_TBL where  (APPL_APPR_REJ_DT BETWEEN '"+currentDate+"' and '"+nextDate+"')  AND employee_number in ("+output+")  ");
					 rs1 = ps1.executeQuery();
					int idsCount = 0;
					List<String> ids = new ArrayList<>();
					Map<String, String> idsParams = new HashMap<String, String>();
					while(rs1.next()) {
						idsCount =	rs1.getRow();
						idsParams.put(rs1.getString("EMPLOYEE_NUMBER"), rs1.getString("APPLICATION_STATUS"));
						ids.add(rs1.getString("EMPLOYEE_NUMBER"));
						
					}
					System.out.println("IDS EMP AND STATUS==>"+idsParams);
					System.out.println("eqCount"+eqOsbCount);
         			System.out.println("idsCount"+idsCount);
				List<String> result;				
				List<String> eqList = emp;
				List<String> idsList =ids;	
				//Collection<String> idsMissingvalues =	CollectionUtils.disjunction(eqList, idsList);
				 
				 ArrayList<String> uniquevalues = new ArrayList<String>(eqList);
				 uniquevalues.removeAll(idsList);
				
				if(eqOsbCount==idsCount) {
					System.out.println("========if both eq and ids count MATCHED============");
					
					result = idsParams.entrySet().stream().filter(x -> {
	                    if (x.getValue()==null || (x.getValue()!=null && !x.getValue().contains("APPROVED")) ) {
	                        return true;
	                    }
	                    return false;
	                })
	                .map(map -> map.getKey())
	                .collect(Collectors.toList());
					
							 if(result!=null && result.size()>0) {
									
						               System.out.println("NOT APPROVED IN IDS LIST"+result);


								 System.out.println("IDS STATUS DIFFERS WITH EQ");
							    
								
									for(String l : result) {
										
										int j = 0;
											if(j==0) {
												empData.put("1",new Object[] { "Employee Number", "IDS STATUS", "EQ STATUS" });
												j = 1;

											}
											empData.put(l,new Object[] { l, idsParams.get(l), eqParamsOSB.get(l) });
											
										
										
									
									}
									
							    }
						 
				}if(uniquevalues.size()>0) {
					System.out.println("========if both eq and ids count MISMATCHED============");
					
					    
					    
					    if(uniquevalues!=null && uniquevalues.size()>0) {
					    	System.out.println("missing records in IDS===>"+uniquevalues);
					    	
							
							

					    	for(String l :uniquevalues) {
					    		String idsStatus = null ;
								String eqStatus = null;
								
								
								int j = 0;
									if(j==0 && empData.isEmpty() ) {
										empData.put("1",new Object[] { "Employee Number", "IDS STATUS", "EQ STATUS" });
										j = 1;

									}
									if(idsParams.containsKey(l)) {
										idsStatus = idsParams.get(l);
										
									} if(eqParamsOSB.containsKey(l)){
										eqStatus = eqParamsOSB.get(l);
									}
                                  
									if(idsStatus==null) {
										idsStatus = "No record found in IDS";
									}if(eqStatus==null) {
										eqStatus = "No record found in eQ";
									}
									empData.put(l,new Object[] { l, idsStatus, eqStatus });
									
								
								
							}
					    }

				}
					
				}
				

			}

			System.out.println("ids db conn"+con1);
			 ps2 = con1.prepareStatement("select EMPLOYEE_NUMBER,APPLICATION_STATUS from QFEQIDS_BASIC_DET_TBL where  (APPL_APPR_REJ_DT BETWEEN '"+currentDate+"' and '"+nextDate+"')  AND APPLICATION_STATUS='APPROVED'");
			 if(ps2!=null)
				 rs2 = ps2.executeQuery();
				int idsCount1 = 0;
				List<String> ids1 = new ArrayList<>();
				Map<String, String> idsParams1 = new HashMap<String, String>();
				while(rs2.next()) {
					idsCount1 =	rs2.getRow();
					idsParams1.put(rs2.getString("EMPLOYEE_NUMBER"), rs2.getString("APPLICATION_STATUS"));
					ids1.add(rs2.getString("EMPLOYEE_NUMBER"));
				
				}
				System.out.println("IDS EMP AND STATUS==>"+idsParams1);
				List<String> eqList = emp;
				List<String> idsList =ids1;
				ArrayList<String> uniquevalues = new ArrayList<String>(idsList);
				 uniquevalues.removeAll(eqList);
				 
				 if(uniquevalues.size()>0) {
						System.out.println("missing values in eQ"+uniquevalues);
						
				    	for(String l :uniquevalues) {
				    		String idsStatus = null ;
							String eqStatus = null;
							
							int j = 0;
								if(j==0 && empData.isEmpty()) {
									empData.put("1",new Object[] { "Employee Number", "IDS STATUS", "EQ STATUS" });
									j = 1;

								}
								if(idsParams1.containsKey(l)) {
									idsStatus = idsParams1.get(l);
									
								} if(eqParams.containsKey(l)){
									eqStatus = eqParams.get(l);
								}
	                          
								if(idsStatus==null) {
									idsStatus = "No record found in IDS";
								}if(eqStatus==null) {
									eqStatus = "No record found in eQ";
								}
								empData.put(l,new Object[] { l, idsStatus, eqStatus });
								
							
						
				 }
				 }
			
         System.out.println("Emp Data"+empData);
              if(!empData.isEmpty()) {
            	  Set<String> keyid = empData.keySet();
  				int rowid = 0;
  				for (String key : keyid) {
  					row = spreadsheet.createRow(rowid++);
  					Object[] objectArr = empData.get(key);
  					int cellid = 0;
  					for (Object obj : objectArr) {
  						Cell cell = row.createCell(cellid++);
  						cell.setCellValue((String)obj);
  					}
  				}
  				// .xlsx is the format for Excel Sheets...
  				// writing the workbook into the file...
  			/*	FileOutputStream out = new FileOutputStream(
  						new File("C:/IDS 25 JULY/EmployeeData_"+currentDate+".xlsx"));
  				workbook.write(out);*/
  			FileOutputStream out = new FileOutputStream(
  					new File("/u03/app/oracle/Custom_Code/EmployeeData_MissingRecords_IDS_eQ_"+currentDate+".xlsx"));
  			// C://ids reconci/EmployeeData_MissingRecords_IDS_eQ_"+currentDate+".xlsx
  			// /u03/PSP/app/oracle/Latest_Patch/EmployeeData_MissingRecords_IDS_eQ_"+currentDate+".xlsx
  			// /u03/app/oracle/Custom_Code
  				workbook.write(out);
  			//System.out.println("EXCEL CREATED AT C:/IDS 25 JULY/EmployeeData_"+currentDate+".xlsx");
  				//File fileDirec = new File("C:/IDS 25 JULY/EmployeeData_"+currentDate+".xlsx");
  			File fileDirec = new File("/u03/app/oracle/Custom_Code/EmployeeData_MissingRecords_IDS_eQ_"+currentDate+".xlsx");	  
            
  			if(fileDirec.exists()) {
				System.out.println("file available");
				MailNotification mail = new MailNotification();
				mail.sendMail(fileDirec.getPath());
				System.out.println("MAIL SENT SUCESSFULLY");
				fileDirec.delete();
			}
              }
			
		

			
		} catch (Exception e) {
			System.out.println("============================ERROR===================================="+e);
			e.printStackTrace();

		} finally {
			dbUtil.closeConnection(con);
			dbUtil.closeConnection(con1);
			dbUtil.closeConnection(con2);
			dbUtil.closePreparedStatement(ps);
			dbUtil.closePreparedStatement(ps1);
			dbUtil.closePreparedStatement(ps2);
			dbUtil.closePreparedStatement(ps3);
			dbUtil.closeResultSet(rs);
			dbUtil.closeResultSet(rs1);
			dbUtil.closeResultSet(rs2);
			dbUtil.closeResultSet(rs3);
		}
	}

	private static Document callService(String request) throws Exception {
		Dispatch<Source> dispatch = service.createDispatch(portName, Source.class, Service.Mode.PAYLOAD);

		System.out.println("\nInvoking xml request: " + request);

		Source result = dispatch.invoke(new StreamSource(new StringReader(request)));

		System.out.println("Result >> " + result);

		String xmlResult = sourceToXMLString(result);
		System.out.println("Received xml response: " + xmlResult);

		// Get the DOM Builder Factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// Change By Arijit for VID-8 (CWE ID 611) - JAN 2020
		String FEATURE = null;
		try {
			FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
			factory.setFeature(FEATURE, true);
			FEATURE = "http://xml.org/sax/features/external-general-entities";
			factory.setFeature(FEATURE, false);
			FEATURE = "http://xml.org/sax/features/external-parameter-entities";
			factory.setFeature(FEATURE, false);
			FEATURE = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
			factory.setFeature(FEATURE, false);
			factory.setXIncludeAware(false);
			factory.setExpandEntityReferences(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("After Call Service");
		// End of Change By Arijit for VID-8 (CWE ID 611) - JAN 2020
		// Get the DOM Builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Load and Parse the XML document
		// document contains the complete XML as a Tree.
		Document document = builder.parse(new ByteArrayInputStream(xmlResult.getBytes("UTF-8")));
		return document;
	}


	private static String sourceToXMLString(Source result) {
		String xmlResult = null;
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			// Change By Arijit for VID-8 (CWE ID 611) - JAN 2020
			factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
			factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
			System.out.println("Inside sourceToXmlString");
			// End of Change By Arijit for VID-8 (CWE ID 611) - JAN 2020
			Transformer transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			OutputStream out = new ByteArrayOutputStream();
			StreamResult streamResult = new StreamResult();
			streamResult.setOutputStream(out);
			transformer.transform(result, streamResult);

			xmlResult = streamResult.getOutputStream().toString();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return xmlResult;
	}

	private static void createService(String endpointUrl) {
		/** Create a service and add at least one port to it. **/
		service = Service.create(serviceName);
		service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, endpointUrl);
	}
	
	
}
