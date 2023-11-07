/*    */ package qantas.eq.integration.ifs;

import java.io.File;
/*    */
/*    */ import java.io.IOException;
import java.nio.file.Files;
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
/*    */ import java.util.logging.Logger;
/*    */ import javax.jws.WebMethod;
/*    */ import javax.jws.WebParam;
/*    */ import javax.jws.WebService;

import org.apache.commons.io.FileUtils;

/*    */ import oracle.ifs.common.IfsException;
/*    */ import qantas.eq.integration.QFEQIFBase;
/*    */ import qantas.eq.integration.QFEQIFLogger;
/*    */ import qantas.eq.integration.util.QFEQIFCMSDKUtilSOA;
/*    */ import qantas.eq.integration.util.QFEQIFCryptoSOA;
/*    */ import qantas.eq.integration.util.QFEQIFDatabaseConn;
import qantas.eq.integration.util.QFEQIFImagingUtility;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ @WebService
/*    */ public class QFEQIFUpdateLobster/*    */ implements QFEQIFBase
/*    */ {
	/* 28 */ private final String CLASS_NAME = getClass().getName();
	/* 29 */ private static Logger _QFEQLogger = QFEQIFLogger.getLogger(QFEQIFUpdateLobster.class.getName());
	/* 30 */ protected String m_dataOut = "";

	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */ @WebMethod(action = "Copy")
	/*    */ public boolean sendFileToLocal(@WebParam(name = "m_fileName") String m_fileName,
			@WebParam(name = "m_sourceFolder") String m_sourceFolder,
			@WebParam(name = "p_destfolder") String p_destfolder, @WebParam(name = "d_flag") String dec_flag,@WebParam(name = "decript_flag") String decript_flag,
			@WebParam(name = "uploadRequired") String uploadRequired,
			// @WebParam(name = "ifsAdminUser") String ifsAdminUser, @WebParam(name =
			// "ifsAdminPwd") String ifsAdminPwd,
			// @WebParam(name = "ifsService") String ifsService, @WebParam(name =
			// "ifsSysPwd") String ifsSysPwd)
			@WebParam(name = "copyFileFlag") String copyFileFlag,
			@WebParam(name = "renmFlName") String renmFlName, @WebParam(name = "wcc_Path") String wcc_Path,
			@WebParam(name = "ifId") String ifId)/*    */ throws Exception
	/*    */ {
		_QFEQLogger.info("Entering UpdateLobsterService for file name "+m_fileName);
		String METHOD_NAME = CLASS_NAME + ".execute";
		_QFEQLogger.info("Entering " + METHOD_NAME);
		String srcFile = m_sourceFolder + "/" + m_fileName;
		_QFEQLogger.info("Src File Name is ::  " + srcFile);
		File sourceFile = new File(srcFile);
		_QFEQLogger.info("Rename Filename" + renmFlName + " for ifId " + ifId + " and filename " + m_fileName);
		_QFEQLogger.info("m_sourceFolder  " + m_sourceFolder + " for ifId " + ifId + " and filename " + m_fileName);
		_QFEQLogger.info("p_destfolder  " + p_destfolder + " for ifId " + ifId + " and filename " + m_fileName);
		_QFEQLogger.info("d_flag  " + dec_flag + " for ifId " + ifId + " and filename " + m_fileName);
		_QFEQLogger.info("uploadRequired flag " + uploadRequired + " for ifId " + ifId + " and filename " + m_fileName);
		_QFEQLogger.info("copyFileFlag flag " + copyFileFlag + " for ifId " + ifId + " and filename " + m_fileName);
		_QFEQLogger.info("decript_flag flag " + decript_flag + " for ifId " + ifId + " and filename " + m_fileName);
		
		String newFileName = null;
		File targetFile =null;
		if (null != sourceFile) {
		if(sourceFile.length() == 0) {
				_QFEQLogger.info("0KB files occured for ifId " + ifId + " and filename " + m_fileName);
			  throw new Exception(" Error occured .0 KB files. Please check .");
		}
		else {
				
			
			
			try {
				if (renmFlName != null && !(renmFlName.trim()).isEmpty()) {
					newFileName = renmFlName;
				} else {
					newFileName = m_fileName;
				}
				
				
				//923018- Functionality Implemented on 04/10/21- Start
				if(!("N".equalsIgnoreCase(copyFileFlag))) {
					 targetFile = new File(p_destfolder + "/" + newFileName);
					_QFEQLogger.info("Destination File Name is ::  " + targetFile.getAbsolutePath() + " and filename " + m_fileName);
					Timestamp ts = new Timestamp(sourceFile.lastModified());
					_QFEQLogger.info("Source File Name timestamp is ::  " + ts + " and filename " + m_fileName);
					
					// copy file from one location to other
					FileUtils.copyFile(sourceFile, targetFile);
					Timestamp ts1 = new Timestamp(targetFile.lastModified());
					_QFEQLogger.info("Destination File  timestamp is ::  " + ts1 + " and filename " + m_fileName);
					
					/*if (decript_flag.equals("N")) {
						 210        Process prc = null;
						 211        String cmd = "dos2unix " + p_destfolder + "/" + m_fileName;
						 212      _QFEQLogger.info("IFID :: "+ifId+" File Name :: "+m_fileName+" cmd:: "+cmd);
						 213        prc = Runtime.getRuntime().exec(cmd);
						          }*/
					Timestamp ts3 = new Timestamp(targetFile.lastModified());
					_QFEQLogger.info("Destination File  timestamp after dos2unix is ::  " + ts3 + " and filename " + m_fileName);
				}
				//923018- Functionality Implemented on 04/10/21- End
				if(!("N".equalsIgnoreCase(uploadRequired))) {
					
				
				// New Functionality 
				File srcfile = new File(m_sourceFolder + File.separator + m_fileName);
				//Timestamp will be srcfile timestamp irrespective of renamefilename
				Timestamp ts = new Timestamp(srcfile.lastModified());
				QFEQIFImagingUtility iu = new QFEQIFImagingUtility();
				try {
					_QFEQLogger.info("Searching database for IPMID for ifId " + ifId + " and filename " + m_fileName);
					String result = iu.getIPMId(ifId, newFileName, ts);
					_QFEQLogger.info("RESULT for ipmid search in database : " + result + " and filename " + m_fileName);
					if ("norecord".equalsIgnoreCase(result)) {
						_QFEQLogger.info("IFID insert" + ifId);
						String value = iu.uploadService(ifId, m_sourceFolder, m_fileName, wcc_Path, renmFlName, null , "N");
						if (!"true".equalsIgnoreCase(value))
							throw new Exception();
						Thread.sleep(10000);
						List<String> response = iu.searchimpid(ifId, m_sourceFolder, m_fileName, renmFlName);
						_QFEQLogger.info("deleteFile Value : " + dec_flag + "for ifId " + ifId + " and filename " + m_fileName);
						if ("Y".equalsIgnoreCase(dec_flag) && "true".equalsIgnoreCase(value)) {
							srcfile.delete();
							_QFEQLogger.info("File Deleted  in norecord case for ifId " + ifId + " and filename " + m_fileName);
						}
						
						String IPM_ID = response.get(0);
						if (!IPM_ID.contains("IPM")) {
							IPM_ID = null;
						}
						_QFEQLogger.info("IFID " + ifId + " IPM_ID : " + IPM_ID + " and filename " + m_fileName);
						iu.insertIPMId(ifId, newFileName, ts, IPM_ID);

					} else if ("noipmid".equalsIgnoreCase(result)) {
						_QFEQLogger.info("for noipmid for ifId " + ifId + " and filename " + m_fileName);
						String value = iu.uploadService(ifId, m_sourceFolder, m_fileName, wcc_Path, renmFlName, null , "N");
						if (!"true".equalsIgnoreCase(value))
							throw new Exception();
						List<String> response = iu.searchimpid(ifId, m_sourceFolder, m_fileName, renmFlName);
						_QFEQLogger.info("deleteFile Value : " + dec_flag + "for ifId " + ifId + " and filename " + m_fileName);
						if ("Y".equalsIgnoreCase(dec_flag) && "true".equalsIgnoreCase(value)) {
							srcfile.delete();
							_QFEQLogger.info("File Deleted  noipmid case for ifId " + ifId + " and filename " + m_fileName);
						}
						_QFEQLogger.info("IFID " + ifId + " IPM_ID" + response.get(0));
						String IPM_ID = response.get(0);
						if (!IPM_ID.contains("IPM")) {
							IPM_ID = null;
						}
						_QFEQLogger.info("IFID " + ifId + " IPM_ID : " + IPM_ID+ " and filename " + m_fileName);
						iu.updateIPMId(ifId, newFileName, ts, IPM_ID);

					} else if (result != null && result.contains("IPM")) {
						_QFEQLogger.info("Update Service with IPM Id block called for ifId " + ifId + " and filename " + m_fileName);
						String value = iu.updateService(result, ifId, m_sourceFolder, m_fileName, wcc_Path, renmFlName, null, dec_flag);
						if (!"true".equalsIgnoreCase(value))
							throw new Exception();
						
						iu.updateIPMId(ifId, newFileName, ts, result);
					}else if ("error".equalsIgnoreCase(result)) {
						if ("Y".equalsIgnoreCase(dec_flag) && srcfile.exists()) {
							srcfile.delete();
							_QFEQLogger.info(" File Deleted for ifId in error case " + ifId + " and filename " + m_fileName);
						}
						throw new Exception("Exception occured during search operation in the database");
					}

				} 
				catch (SQLException e) {
					_QFEQLogger.info(" ifId " + ifId + " and filename " + m_fileName + "SQLException caught: " + e.getMessage());
					//923018 - Added on 22_09_21 to delete file from source location in case of database operation fails.
					if ("Y".equalsIgnoreCase(dec_flag) && srcfile.exists()) {
						srcfile.delete();
						_QFEQLogger.info(" File Deleted for ifId in SQLException case " + ifId + " and filename " + m_fileName);
					}
					throw new Exception("SQLException occured during database operation.");

				}
				catch (Exception e) {
					_QFEQLogger.info("for ifId " + ifId + " and filename " + m_fileName + "Exception caught: " + e.getMessage());
					iu.insertIPMId(ifId, newFileName, ts, null); //923018 -Added on 04_10_21 Incase of imaging exception it will insert a row so that so can update the table entry to address duplicate issue.
					//923018 - Added on 22_09_21 to delete file from source location in case of imaging fails.
					if ("Y".equalsIgnoreCase(dec_flag) && srcfile.exists()) {
						srcfile.delete();
						_QFEQLogger.info(" File Deleted for ifId in Exception case " + ifId + " and filename " + m_fileName);
					}

				} finally {
					QFEQIFDatabaseConn.closeConnection();
				}
			}
				_QFEQLogger.info("Files copied successfully. for ifId " + ifId + " and filename " + m_fileName);
			} catch (IOException e) {
				// resultOut = "ERROR";
				_QFEQLogger.info("for ifId " + ifId + " and filename " + m_fileName + "Exception caught: " + e.getMessage());
				//923018- 26/10 -- Implement copy file incase of error from error folder to destination folder.
				  m_sourceFolder = (m_sourceFolder.substring(0, m_sourceFolder.lastIndexOf("/") + 1) + "error");
				  srcFile = m_sourceFolder + "/" + m_fileName;
				 _QFEQLogger.info("Src File Name is from Catch Block::  " + srcFile);
				 sourceFile = new File(srcFile);
				  try {
					  Timestamp ts = new Timestamp(sourceFile.lastModified());
						_QFEQLogger.info("filename " + m_fileName+" Source file File  timestamp is ::  " + ts );
					  FileUtils.copyFile(sourceFile, targetFile);
					  
					 
					  _QFEQLogger.info("File copied successfully from "+srcFile+" to target  "+targetFile);
					  
					  Timestamp ts1 = new Timestamp(targetFile.lastModified());
					  _QFEQLogger.info("filename " + m_fileName+" Target file File  timestamp is ::  " + ts1);
					  
					  /*if (decript_flag.equals("N")) {
							 210        Process prc = null;
							 211        String cmd = "dos2unix " + p_destfolder + "/" + m_fileName;
							_QFEQLogger.info("IFID :: "+ifId+" File Name :: "+m_fileName+" cmd:: "+cmd);
							 212       // System.out.println("Trim command " + cmd);
							 213        prc = Runtime.getRuntime().exec(cmd);
							          }*/
					  
					  
					  Timestamp ts3 = new Timestamp(targetFile.lastModified());
					  _QFEQLogger.info("filename " + m_fileName+" Target file File  timestamp after dos2unix is ::  " + ts3);
					  //28-10-21-- Delete files if flag is "Y" after copying file
					  if ("Y".equalsIgnoreCase(dec_flag) && sourceFile.exists()) {
						  sourceFile.delete();
							_QFEQLogger.info(" File Deleted for ifId in IOException case " + ifId + " and filename " + m_fileName);
						}
					  //28-10-21-- Delete files if flag is "Y" after copying file
				  }catch(IOException ex) {
						e.printStackTrace();
					  throw new Exception(" Error occured .Failed to write file in error folder. Please check .");
				  }
				//e.printStackTrace();
					//throw new Exception("Failed to write file locally. Please check the given path.");
				//923018- 26/10 -- Implement copy file incase of error from error folder to destination folder.
				
			
		}
		}
	}
		
		
		_QFEQLogger.info("for ifId " + ifId + " and filename " + m_fileName + "Exiting " + METHOD_NAME);
		return true;
	}

	/*    */
	/*    */ /*
				 * @WebMethod(action="Copy") public boolean
				 * sendFileToLocal(@WebParam(name="m_fileName") String
				 * m_fileName, @WebParam(name="m_sourceFolder") String
				 * m_sourceFolder, @WebParam(name="p_destfolder") String
				 * p_destfolder, @WebParam(name="d_flag") String
				 * dec_flag, @WebParam(name="ifsAdminUser") String
				 * ifsAdminUser, @WebParam(name="ifsAdminPwd") String
				 * ifsAdminPwd, @WebParam(name="ifsService") String
				 * ifsService, @WebParam(name="ifsSysPwd") String ifsSysPwd) throws Exception {
				 * 42 String METHOD_NAME = CLASS_NAME + ".execute"; 43
				 * _QFEQLogger.info("Entering " + METHOD_NAME);
				 * 
				 * 45 String resultOut = ""; 46 resultOut = "SUCCESS"; 47 QFEQIFCMSDKUtilSOA
				 * ifsUtil = null;
				 * 
				 * 49 Connection dbConn = QFEQIFDatabaseConn.getConnection(); 50 QFEQIFCryptoSOA
				 * crypto = new QFEQIFCryptoSOA(dbConn); try { 53 ifsUtil = new
				 * QFEQIFCMSDKUtilSOA(ifsAdminUser, crypto.decrypt(ifsAdminPwd), ifsService,
				 * crypto.decrypt(ifsSysPwd));
				 * 
				 * 55 if (!ifsUtil.getErrorFlag()) { 57 ifsUtil.updateLobster(m_sourceFolder,
				 * m_fileName, dbConn, p_destfolder, dec_flag); 58 dbConn.commit(); }
				 * 
				 * 61 if (ifsUtil.getErrorFlag()) { 63 resultOut = "ERROR"; }
				 * 
				 * 
				 * 67 ifsUtil.disconnectSession();
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * try { 81 dbConn.rollback(); 82 QFEQIFDatabaseConn.closeConnection(); } catch
				 * (SQLException sqlex) { 84 _QFEQLogger.info("SQLException caught: " +
				 * sqlex.getMessage()); }
				 * 
				 * 
				 * 88 if (ifsUtil != null) { try { 90 ifsUtil.disconnectSession(); 91
				 * _QFEQLogger.info("Disposed ifsService"); } catch (IfsException ex) { 93
				 * _QFEQLogger.info("Exception caught: " + ex.getMessage()); } }
				 * 
				 * 97 _QFEQLogger.info("resultOut: " + resultOut); } catch (IfsException ie) {
				 * 69 resultOut = "ERROR"; 70 _QFEQLogger.info("IfsException caught: " +
				 * ie.getMessage()); 71 ie.printStackTrace(); 72 throw new
				 * Exception("Error retrieving file from CM SDK." +
				 * QFEQIFCMSDKUtilSOA.stackTraceToString(ie)); } catch (IOException e) { 74
				 * resultOut = "ERROR"; 75 _QFEQLogger.info("Exception caught: " +
				 * e.getMessage()); 76 e.printStackTrace(); 77 throw new
				 * Exception("Failed to write file locally. Please check the given path." +
				 * QFEQIFCMSDKUtilSOA.stackTraceToString(e)); } finally { try { 81
				 * dbConn.rollback(); 82 QFEQIFDatabaseConn.closeConnection(); } catch
				 * (SQLException sqlex) { 84 _QFEQLogger.info("SQLException caught: " +
				 * sqlex.getMessage()); }
				 * 
				 * 
				 * 88 if (ifsUtil != null) { try { 90 ifsUtil.disconnectSession(); 91
				 * _QFEQLogger.info("Disposed ifsService"); } catch (IfsException ex) { 93
				 * _QFEQLogger.info("Exception caught: " + ex.getMessage()); } } }
				 * 
				 * 98 _QFEQLogger.info("Exiting " + METHOD_NAME); 99 return true; }
				 */
	/*    */ }

/*
 * Location: D:\Workspace\QantasIHubServices\ImportedClasses Qualified Name:
 * qantas.eq.integration.ifs.QFEQIFUpdateLobster Java Class Version: 6 (50.0)
 * JD-Core Version: 0.7.1
 */