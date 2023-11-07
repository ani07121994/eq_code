package qantas.imaging.webService;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import qantas.imaging.util.ImagingUtil;
import qantas.imaging.util.QFEQIFLogger;

@WebService(serviceName = "ImagingDoc")
public class ImagingServiceImpl {

	private static final Logger logger = QFEQIFLogger.getLogger(ImagingServiceImpl.class.getName());
	ImagingUtil imagingUtil = new ImagingUtil();

	public ImagingServiceImpl() {
	}

	@WebMethod
	public String uploadFile(@WebParam(name = "IF_id") String Interface_ID,
			@WebParam(name = "File_Path") String src_location, @WebParam(name = "File_Name") String src_fileName,
			@WebParam(name = "wcc_Path") String wcc_filePath,
			@WebParam(name = "rename_filename") String rename_filename,
			@WebParam(name = "Error_message") String errorMessage, @WebParam(name = "Delete_Flag") String deleteFile){
		String rvalue = "false";
		try {
			
			logger.info("********************************Start uploadFile  Service************** for "+src_fileName+" *********************************" );
			logger.info(" uploadFile  Service - Input Param Interface_ID : " + Interface_ID);
			logger.info(" uploadFile  Service - Input Param src_location : " + src_location + " for src_filename " + src_fileName);
			logger.info(" uploadFile  Service - Input Param src_fileName : " + src_fileName);
			logger.info(" uploadFile  Service - Input Param wcc_filePath : " + wcc_filePath + " for src_filename " + src_fileName);
			logger.info(" uploadFile  Service - Input Param rename_filename : " + rename_filename + " for src_filename " + src_fileName);
			logger.info(" uploadFile  Service - Input Param errorMessage : " + errorMessage + " for src_filename " + src_fileName);
			logger.info(" uploadFile  Service - Input Param deleteFile : " + deleteFile + " for src_filename " + src_fileName);
			
			String filePath = src_location + File.separator + src_fileName;
			logger.info("Source Filename : " + src_fileName);
			logger.info("Rename Filename : " + rename_filename);
			logger.info("filePath : " + filePath);
			File file = new File(filePath);
			Timestamp ts = new Timestamp(file.lastModified());
			logger.info("uploadFile : Timestamp : " + ts + "for src_filename" + src_fileName);
			Timestamp lastModified = new Timestamp(System.currentTimeMillis());
			String wcc_filename = src_fileName;
			if (rename_filename != null && !(rename_filename.trim()).isEmpty()) {
				wcc_filename = rename_filename;
			}
			logger.info("WCC Filename : " + wcc_filename);
			rvalue = imagingUtil.uploadDocument(Interface_ID, filePath, ts, wcc_filename, wcc_filePath, errorMessage,
					deleteFile, lastModified);

			logger.info("deleteFile Value : " + deleteFile);
			if ("Y".equalsIgnoreCase(deleteFile) && rvalue.equalsIgnoreCase("true")) {
				file.delete();
				rvalue = "true";
			}
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception Occured ");
			logger.log(Level.SEVERE, e.getMessage(), e);
			rvalue = e.getMessage();
		}

		return rvalue;
	}

	@WebMethod
	public List<String> searchIPM(@WebParam(name = "IF_id") String Interface_ID,
			@WebParam(name = "Src_File_Path") String src_location,
			@WebParam(name = "Src_File_Name") String src_fileName,
			@WebParam(name = "rename_filename") String rename_filename) {
		
		logger.info("*************************** Inside SearchIPM ***********************");
		logger.info("SearchIPM - IF_ID" + Interface_ID);
		logger.info("SearchIPM - src_location" + src_location + "for src_filename" + src_fileName);
		logger.info("SearchIPM - Src_File_Name" + src_fileName);
		logger.info("SearchIPM - rename_filename" + rename_filename + "for src_filename" + src_fileName);

		String search_filename = null;
		List<String> result = new ArrayList<String>();
		try { 

			if (rename_filename != null && !(rename_filename.trim()).isEmpty()) {
				search_filename = rename_filename;
			} else {
				search_filename = src_fileName;
			}
			src_location = src_location + File.separator + src_fileName;
			logger.info("absolute path of file" + src_location + "for src_filename" + src_fileName);
			File file = new File(src_location);
			Timestamp ts = new Timestamp(file.lastModified());
			logger.info("SearchIpmId - Timestamp : " + ts + "for src_filename" + src_fileName);
			result.add(imagingUtil.searchService(Interface_ID, search_filename, ts));
			result.add(ts.toString());

		} catch (Exception e) {
			logger.log(Level.WARNING, " SearchIPM - Exception Occured for src_filename" + src_fileName);
			String messge=null;
			logger.log(Level.WARNING, "e.getMessage()::" +e.getMessage());
			if(e.getMessage() !=null && e.getMessage() .contains("Index: 0, Size: 0")) {
				messge = "Index: 0, Size: 0";
			}else {
				messge = "Exception Occured :"+e.getMessage();
			}
			//"Exception Occured :"+e.getMessage();
			logger.log(Level.WARNING, messge);
			result.add(messge);
			logger.log(Level.SEVERE, e.getMessage(), e);
			
		}

		return result;

	}
	
	
	
	@WebMethod
	public String updateService(@WebParam(name = "IPM_ID") String IPM_ID,
			@WebParam(name = "IF_id") String Interface_ID,
			@WebParam(name = "Src_File_Path") String src_location,
			@WebParam(name = "Src_File_Name") String src_fileName,
			@WebParam(name = "DeleteFlag") String deleteFlag,
			@WebParam(name = "rename_filename") String rename_filename,
			@WebParam(name = "wcc_path") String wcc_path,
			@WebParam(name = "Error_message") String errorMessage) throws Exception {
		
		
		logger.info("*************************** Inside updateService ***********************");
		logger.info("IPM_ID updateService" + IPM_ID);
		logger.info("Interface_ID updateService" + Interface_ID);
		logger.info("src_location  updateService" + src_location + "for src_filename" + src_fileName);
		logger.info("src_fileName updateService" + src_fileName);
		logger.info("for src_filename" + src_fileName + "deleteFlag updateService" + deleteFlag);
		logger.info("for src_filename" + src_fileName + "rename_filename updateService" + rename_filename);
		logger.info("wcc_path updateService" + wcc_path + "for src_filename" + src_fileName);
		logger.info("for src_filename" + src_fileName + "errorMessage updateService " + errorMessage);
		
		String rvalue = "false";
		try {
			
			String wcc_filename = src_fileName;
			String filePath = null;
			Timestamp ts = null;
			File file = null;
			if(src_fileName != null && !(src_fileName.trim()).isEmpty()) {
			filePath = src_location + File.separator + src_fileName;
			logger.info("Source Filename : " + src_fileName);
			logger.info("Rename Filename : " + rename_filename);
			file = new File(filePath);
			ts = new Timestamp(file.lastModified());
			logger.info("updateService : Timestamp : " + ts + "for src_filename" + src_fileName);
			}
			Timestamp lastModified = new Timestamp(System.currentTimeMillis());
			if (rename_filename != null && !(rename_filename.trim()).isEmpty()) {
				wcc_filename = rename_filename;
			}
			
			rvalue = imagingUtil.updateService(IPM_ID,Interface_ID,filePath,wcc_filename,wcc_path,errorMessage,ts,lastModified);
			logger.info("return value" + rvalue);
			logger.info("deleteFile Value : " + deleteFlag);
			if ("Y".equalsIgnoreCase(deleteFlag) && rvalue.equalsIgnoreCase("true") && file!=null) {
				file.delete();
				logger.info("File has been deleted");
				rvalue = "true";
			}
		} catch (Exception e) {
			logger.log(Level.WARNING, "UpdateIPM - Exception Occured for src_filename" + src_fileName);
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw new Exception(e.getMessage(),e.getCause());
		}

		return rvalue;

	}
}
