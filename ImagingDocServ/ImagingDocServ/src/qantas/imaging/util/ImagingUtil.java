package qantas.imaging.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import oracle.imaging.BasicUserToken;
import oracle.imaging.Document;
import oracle.imaging.DocumentContentService;
import oracle.imaging.Document.FieldValue;
import oracle.imaging.DocumentService;
import oracle.imaging.ImagingException;
import oracle.imaging.NameId;
import oracle.imaging.Search;
import oracle.imaging.SearchArgument;
import oracle.imaging.SearchService;
import oracle.imaging.SearchValue;
import oracle.imaging.ServicesFactory;
import oracle.imaging.UserToken;

public class ImagingUtil {

	private static final Logger logger = QFEQIFLogger.getLogger(ImagingUtil.class.getName());

	public ServicesFactory getServicesFactory() {
		logger.info("Inside getServicesFactory");
		//UserToken credentials = new BasicUserToken("weblogic", "0wC@dmin#123");
		UserToken credentials = null;
		ServicesFactory servicesFactory = null;
		Properties pro = new Properties();
		String configFilePath = "";
		FileInputStream fis = null;
		
		
		try {
			configFilePath = System.getenv("QFEQIF_CONFIG");
			fis = new FileInputStream(configFilePath);
			pro.load(fis);
			
			String imagingWsUrl = pro.getProperty("imaging.ws.url");
			String userid = pro.getProperty("imaging.ws.userid");
			String password = pro.getProperty("imaging.ws.password");
			
			credentials = new BasicUserToken(userid, password);
			logger.info("interfaces to be polled for inbound are : " + imagingWsUrl);
			
			servicesFactory = ServicesFactory.login(credentials, Locale.US, imagingWsUrl);
		} catch (ImagingException e) {
			logger.log(Level.WARNING, "ImagingException Occured ");
			logger.log(Level.SEVERE, e.getMessage(), e);
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "FileNotFoundException Occured ");
			logger.log(Level.SEVERE, e.getMessage(), e);
		} catch (IOException e) {
			logger.log(Level.WARNING, "IOException Occured ");
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return servicesFactory;
	}

	public NameId getNameId(DocumentService docService) {
		logger.info("Inside getNameId");

		NameId invoicesAppNameId = null;
		// List the viewable applications to confirm that "Invoices" exists
		List<NameId> appsList = null;
		try {
			appsList = docService.listTargetApplications(Document.Ability.CREATEDOCUMENT);
		} catch (ImagingException e) {
			e.printStackTrace();
		}
		for (NameId nameId : appsList) {
			if (nameId.getName().equals("Test_ihub_app")) {
			//if (nameId.getName().equals("ihub_new_search")) {
				invoicesAppNameId = nameId;
				logger.info(" Name Id "+invoicesAppNameId.getName());
			}
		}
		//if()
	//	System.out.println(" Name Id "+invoicesAppNameId.getName());
		return invoicesAppNameId;
	}

	public String uploadDocument(String interface_ID, String filePath, Timestamp ts, String wcc_filename,
			String wcc_filePath, String errorMessage, String deleteFile, Timestamp lastModified) {
		logger.info("!!!!!!!!!!!!!!!!!!!!!!Inside uploadDocument !!!!!!!!!!!!!!!!!!!!!!!!!");
		logger.info("ifId : " + interface_ID);
		logger.info("timestamp : " + ts + "for wcc_filename" + wcc_filename);
		logger.info("wcc_fileName : " + wcc_filename);
		logger.info("wcc_filePath : " + wcc_filePath);
		logger.info("errorMessage : " + errorMessage);
		logger.info("deleteFile : " + deleteFile);
		logger.info("lastModified : " + lastModified);
		String rvalue = "false";

		try {
			ServicesFactory servicesFactory = getServicesFactory();

			try {

				DocumentService docService = servicesFactory.getDocumentService();
				DocumentContentService docContentService = servicesFactory.getDocumentContentService();
				NameId invoicesAppNameId = getNameId(docService);
				if (invoicesAppNameId == null) {
					logger.info("Invoices application not found.");
					return rvalue;
				}

				DataHandler fileData = new DataHandler(new FileDataSource(filePath));
				String uploadToken = null;

				uploadToken = docContentService.uploadDocument(fileData, wcc_filename);

				List<Document.FieldValue> fieldValues = new ArrayList<Document.FieldValue>();
				fieldValues.add(new Document.FieldValue("Interface_ID", interface_ID));
				fieldValues.add(new Document.FieldValue("File_Name", wcc_filename));
				fieldValues.add(new Document.FieldValue("File_Path", wcc_filePath));
				fieldValues.add(new Document.FieldValue("File_Date", ts));
				if (errorMessage != null && !(errorMessage.trim()).isEmpty()) {
					fieldValues.add(new Document.FieldValue("Error_Message", errorMessage));
					fieldValues.add(new Document.FieldValue("Status", "Error"));
				} else {
					fieldValues.add(new Document.FieldValue("Status", "Success"));
				}
				fieldValues.add(new Document.FieldValue("Last_Updated_Date", lastModified));
				docService.createDocument(uploadToken, invoicesAppNameId, fieldValues, true);
				logger.info("Document Creation...");
				rvalue = "true";
			} catch(Exception e) {
				
					logger.log(Level.WARNING, "ImagingException Occured ");
					logger.log(Level.SEVERE, e.getMessage(), e);
					rvalue = e.getMessage();
			}
			finally {
				if (servicesFactory != null) {
					servicesFactory.logout();
				}
			}
		} catch (ImagingException e) {
			logger.log(Level.WARNING, "ImagingException Occured ");
			logger.log(Level.SEVERE, e.getMessage(), e);
			rvalue = e.getMessage();
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception Occured ");
			logger.log(Level.SEVERE, e.getMessage(), e);
			rvalue = e.getMessage();
		}

		return rvalue;
	}

	public String searchService(String interface_ID, String search_filename, Timestamp ts) {
		String result = null;
		try { // try-catch
			
			logger.info("************************* Inside searchService method ********************");
			logger.info("interface_ID : " + interface_ID);
			logger.info("search_filename : " + search_filename);
			logger.info("ts : " + ts + "for search_filename : " + search_filename);
			
			ServicesFactory servicesFactory = getServicesFactory();

			try {

				SearchService searchService = servicesFactory.getSearchService();

				List<SearchArgument> searchArguments = new ArrayList<SearchArgument>();
				SearchValue searchValue = new SearchValue(SearchValue.Type.TEXT, interface_ID);
				SearchArgument searchArgument = new SearchArgument("Interface_ID", searchValue);
				searchArgument.setOperatorValue(Search.Operator.CONTAINS);
				searchArguments.add(searchArgument);
				searchValue = new SearchValue(SearchValue.Type.TEXT, search_filename);
				searchArgument = new SearchArgument("File_Name", searchValue);
				searchArgument.setOperatorValue(Search.Operator.CONTAINS);
				searchArguments.add(searchArgument);

				searchValue = new SearchValue(SearchValue.Type.DATETIME, ts);
				searchArgument = new SearchArgument("File_Date", searchValue);
				searchArgument.setOperatorValue(Search.Operator.EQUAL);
				searchArguments.add(searchArgument);
				/*Search.ResultSet resultSet = searchService.executeSavedSearch(new NameId("Test_ihub_search"),
						searchArguments);*/
				Search.ResultSet resultSet = searchService.executeSavedSearch(new NameId("ihub_new_search"),
						searchArguments);
				if (resultSet.getTotalResults() == 0) {
					System.out.println("Document not found");
				}
				result = resultSet.getResults().get(0).getDocumentId();
				logger.info("IPM ID" + result);
				if(!result.contains("IPM")) {
					result = "NoRecord";
				}

			} finally {
				if (servicesFactory != null) {
					servicesFactory.logout();
				}
			}
		} catch (ImagingException e) {
			logger.log(Level.WARNING, "ImagingException Occured ");
			logger.log(Level.WARNING, "e.getMessage() in ImagingException ::" +e.getMessage());
			
			if(e.getMessage() !=null && e.getMessage() .contains("Index: 0, Size: 0")) {
				result = "Index: 0, Size: 0";
			}else {
				result = "Exception Occured :"+e.getMessage();
			}
			logger.log(Level.WARNING, "result ImagingException ::::::: "+result);
			logger.log(Level.SEVERE, e.getMessage(), e);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception Occured ");
			logger.log(Level.WARNING, "e.getMessage() in Exceptionn ::" +e.getMessage());
			
			if(e.getMessage() !=null && e.getMessage() .contains("Index: 0, Size: 0")) {
				result = "Index: 0, Size: 0";
			}else {
				result = "Exception Occured :"+e.getMessage();
			}
			logger.log(Level.WARNING, "result Exception ::::::: "+result);
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return result;
	}

	public String updateService(String ipm_id, String interface_ID, String filePath, String wcc_filename,
			String wcc_path, String errorMessage, Timestamp ts, Timestamp lastModified) throws Exception {

		String result = "false";
		try { 
			ServicesFactory servicesFactory = getServicesFactory();
			try {
				DocumentService docService = servicesFactory.getDocumentService();
				DocumentContentService docContentService = servicesFactory.getDocumentContentService();
				
				List<Document.FieldValue> fieldValues = new ArrayList<Document.FieldValue>();
				if (interface_ID != null && !(interface_ID.trim()).isEmpty())
					fieldValues.add(new Document.FieldValue("Interface_ID", interface_ID));

				if (wcc_filename != null && !(wcc_filename.trim()).isEmpty())
					fieldValues.add(new Document.FieldValue("File_Name", wcc_filename));

				if (wcc_path != null && !(wcc_path.trim()).isEmpty())
					fieldValues.add(new Document.FieldValue("File_Path", wcc_path));

				if (errorMessage != null && !(errorMessage.trim()).isEmpty()) {
					fieldValues.add(new Document.FieldValue("Error_Message", errorMessage));
					fieldValues.add(new Document.FieldValue("Status", "Error"));
				} else {
					fieldValues.add(new Document.FieldValue("Status", "Success"));
					fieldValues.add(new Document.FieldValue("Error_Message", ""));
				}
				if (ts != null)
					fieldValues.add(new Document.FieldValue("File_Date", ts));

				fieldValues.add(new Document.FieldValue("Last_Updated_Date", lastModified));

				
				if (filePath != null && !(filePath.trim()).isEmpty()) {
					DataHandler fileData = new DataHandler(new FileDataSource(filePath));
					String uploadToken = docContentService.uploadDocument(fileData, wcc_filename);
					docService.updateDocument(ipm_id, uploadToken, fieldValues, false);
					result = "true";
				} else {
					docService.updateDocument(ipm_id, null, fieldValues, false);
					result = "true";
				}
			} finally {
				if (servicesFactory != null) {
					servicesFactory.logout();
				}
			}
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception Occured ");
			logger.log(Level.SEVERE, e.getMessage(), e);
			result = e.getMessage();
			throw new Exception(e.getMessage(),e.getCause());
		}

		return result;
	}

}
