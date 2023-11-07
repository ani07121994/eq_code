/*     */ package qantas.eq.integration.ftp;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
import java.sql.Timestamp;
/*     */ import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

/*     */ import oracle.ifs.common.IfsException;
/*     */ import qantas.eq.integration.QFEQIFLogger;
/*     */ import qantas.eq.integration.util.QFEQIFCMSDKUtilSOA;
/*     */ import qantas.eq.integration.util.QFEQIFCryptoSOA;
/*     */ import qantas.eq.integration.util.QFEQIFDatabaseConn;
/*     */ import qantas.eq.integration.util.QFEQIFUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QFEQIFFtpIHub
/*     */   extends QFEQIFWorkflowBase
/*     */ {
/*  47 */   private final String CLASS_NAME = getClass().getName();
/*  48 */   private static Logger _QFEQLogger = QFEQIFLogger.getLogger(QFEQIFFtpIHub.class.getName());
/*     */   private static String resultOut;
/*     */   public static QFEQIFFtpIHub instance;
/*     */   
/*     */   public static QFEQIFFtpIHub getInstance() {
/*  53 */     if (instance == null) {
/*  54 */       synchronized (QFEQIFFtpFile.class) {
/*  55 */         if (instance == null) {
/*  56 */           return new QFEQIFFtpIHub();
/*     */         }
/*     */       }
/*     */     }
/*  60 */     _QFEQLogger.info("Got instance!!");
/*  61 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean execute(String FILE_NAME, String SOURCE_FOLDER, String wfFtpHost, String wfFtpPort, String wfFtpUser, String wfFtpPwd, String wfFtpPath, String wfFtpFileName, String attrib1, String attrib2, String xferMode,String ifid)////923018- Error file movement from error to original folder
/*     */     throws Exception
/*     */   {
/*  88 */     String METHOD_NAME = CLASS_NAME + ".execute";
/*  89 */     _QFEQLogger.info("Entering "+FILE_NAME+" :: " + METHOD_NAME);
/*     */     
			_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub:: execute:: FILE_NAME " + FILE_NAME);
			_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub:: execute:: SOURCE_FOLDER " + SOURCE_FOLDER);
			_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub:: execute:: wfFtpHost " + wfFtpHost);
			_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub:: execute:: wfFtpPort ::" + wfFtpPort);
			_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub:: execute:: :: wfFtpUser " + wfFtpUser);
			_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub:: execute:: wfFtpPath ::" + wfFtpPath);
			_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub:: execute:: ifid ::" + ifid);
/*  91 */     resultOut = "SUCCESS";
/*     */     
/*     */   boolean ftpFlag=false;
/*  94 */     //QFEQIFCMSDKUtilSOA ifsUtil = null;
/*     */     
/*     */ //String origSourcFol=SOURCE_FOLDER;  //923018- Error file movement from error to original folder
String targetFilefullNm=null;  //923018- Error file movement from error to original folder -08-11-21
File srcFile=null;//923018- Error file movement from error to original folder -08-11-21
BufferedInputStream bis=null;
FileInputStream fis=null;
/*     */ 
/*     */ 
/*  99 */     //String d_ifsAdminPwd = "";
/* 100 */     //String d_ifsSysPwd = "";
/* 101 */     String d_wfFtpPwd = "";
/*     */     
/* 103 */     boolean l_isConnected = true;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 108 */     m_fileName = FILE_NAME;
/*     */     
/* 110 */     m_sourceFolder = SOURCE_FOLDER;
/*     */     
/*     */ 
/* 113 */     /*attrib1 = getAttribValue(attrib1);
 114      attrib2 = getAttribValue(attrib2);
 115      xferMode = getAttribValue(xferMode);
          
      
 118      Connection conn = QFEQIFDatabaseConn.getConnection();
 119      QFEQIFCryptoSOA crypto = new QFEQIFCryptoSOA(conn);
          try
          {
 122        d_ifsAdminPwd = crypto.decrypt(ifsAdminPwd);
 123        d_ifsSysPwd = crypto.decrypt(ifsSysPwd);
 124        d_wfFtpPwd = crypto.decrypt(wfFtpPwd);
          } catch (SQLException sqlx) {
 126        _QFEQLogger.info("Exception :: " + stackTraceToString(sqlx));
 127        if (sqlx.getMessage().equalsIgnoreCase("Connection closed")) {
 128          conn = QFEQIFDatabaseConn.getConnection();
 129          crypto = new QFEQIFCryptoSOA(conn);
 130          d_ifsAdminPwd = crypto.decrypt(ifsAdminPwd);
 131          d_ifsSysPwd = crypto.decrypt(ifsSysPwd);
 132          d_wfFtpPwd = crypto.decrypt(wfFtpPwd);
            }
          }
          
      
 137      ifsUtil = new QFEQIFCMSDKUtilSOA(ifsAdminUser, d_ifsAdminPwd, ifsService, d_ifsSysPwd);
          
 139      if (ifsUtil.getErrorFlag())
          {
 141        resultOut = "IFSLOGIN";
 142        throw new Exception("Error connecting CMSDK server.");
          }
/*     */     
			attrib1 = getAttribValue(attrib1);
			attrib2 = getAttribValue(attrib2);
			xferMode = getAttribValue(xferMode);
/*     */  Connection conn = QFEQIFDatabaseConn.getConnection();
			QFEQIFCryptoSOA crypto = new QFEQIFCryptoSOA(conn);
			try {
				d_wfFtpPwd = crypto.decrypt(wfFtpPwd);
			}catch (SQLException sqlx) {
				_QFEQLogger.info("Exception :: " + stackTraceToString(sqlx));
				_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub:: execute:: Exception :: Occured  ::" + stackTraceToString(sqlx));
				if (sqlx.getMessage().equalsIgnoreCase("Connection closed")) {
					conn = QFEQIFDatabaseConn.getConnection();
					crypto = new QFEQIFCryptoSOA(conn);
					d_wfFtpPwd = crypto.decrypt(wfFtpPwd);
				}
				
			}
			
/* 146 */     QFEQIFFtpClient ftpClient = new QFEQIFFtpClient(isBinaryXfer(xferMode), isPassive(attrib1));
/*     */     
/* 148 */     //conn = QFEQIFDatabaseConn.getConnection();
/* 149 */     //crypto = new QFEQIFCryptoSOA(conn);
/*     */     try
/*     */     {
/* 152 */       l_isConnected = ftpClient.connect(wfFtpHost, Integer.parseInt(wfFtpPort), wfFtpUser, d_wfFtpPwd);
				_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub:: execute:: l_isConnected::" + l_isConnected);
/*     */     } catch (IOException io_err) {
				_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub:: execute:: IOException catch block::" +io_err.getMessage());
/* 154 */       throw new Exception(FILE_NAME +"IOException caught: " + stackTraceToString(io_err));
/*     */     }
/*     */     catch (Exception e) {
/* 157 */       //ifsUtil.disconnectSession();
				_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub:: execute:: Exception block before thorwing :: Incorrect username/password " + e.getMessage());
/* 158 */       QFEQIFDatabaseConn.closeConnection();
/* 159 */       throw new Exception("Incorrect username/password");
/*     */     }

			  File file = null;
			
			  try {
				  if(m_sourceFolder.endsWith("/"))
				  {
					  targetFilefullNm=m_sourceFolder + m_fileName;
					  file = new File(m_sourceFolder + m_fileName);
					 
				  }
				  else {
					  targetFilefullNm= m_sourceFolder + File.separator + m_fileName;
					  file = new File(m_sourceFolder + File.separator + m_fileName);
				  }
				 //923018- Error file movement from error to original folder-08-11-21
			  
			  //_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub:: execute:: Exception::" + e.getMessage());
			   fis = new FileInputStream(file);
			   bis = new BufferedInputStream(fis);
			   _QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute::Successfull fetched the file from  :: location  "+targetFilefullNm);	
			  
			  }catch(Exception ex) {
				  _QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute:: Entered in Exception block :: targetFilefullNm "+targetFilefullNm);	
				  m_sourceFolder = (m_sourceFolder.substring(0, m_sourceFolder.lastIndexOf("/") + 1) + "error");
				  _QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute:: Copying file from :: m_sourceFolder "+m_sourceFolder);	
				  srcFile=new File(m_sourceFolder+ File.separator + m_fileName);
				  fis = new FileInputStream(srcFile);
				   bis = new BufferedInputStream(fis);
			  }
/*     */     
/*     */ 	 _QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute:: after file BufferedInputStream ");
/* 163 */     if (l_isConnected)
/*     */     {
/* 165 */       if (!wfFtpPath.equals(""))
/*     */       {
/* 167 */         if (!ftpClient.changeDir(wfFtpPath))
/*     */         {
/* 169 */           resultOut = "ERROR";
/* 170 */           //ifsUtil.disconnectSession();
/* 171 */           QFEQIFDatabaseConn.closeConnection();
					_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute:: changeDir:: before throwing Exception");
/* 172 */           throw new Exception("Directory does not exist/permission denied! " + wfFtpPath);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 177 */       if (wfFtpFileName.equals(""))
/*     */       {
/* 179 */         wfFtpFileName = m_fileName;
/*     */       }
/*     */       _QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub:: execute:: wfFtpFileName:: "+wfFtpFileName);
/*     */ 
/* 183 */       if (!QFEQIFUtil.toBlank(attrib2).equals("")) {
/* 184 */         ftpClient.site(attrib2);
/*     */       }
/* 186 */       if (resultOut == "SUCCESS") {
/*     */         try
/*     */         {
/* 189 */           //if(!ftpClient.put(wfFtpFileName, ifsUtil.getDocumentContent(m_sourceFolder, m_fileName)))
					if (!ftpClient.put(wfFtpFileName, bis))
/*     */           {
/* 191 */             resultOut = "ERROR";
/* 192 */             //ifsUtil.disconnectSession();
/* 193 */             QFEQIFDatabaseConn.closeConnection();
					  _QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute:: changeDir:: before throwing  Unable to put Exception :: m_fileName "+m_fileName);
/* 194 */             throw new Exception("Unable to put " + m_fileName + " in Remote FTP Server.");
/*     */           }else {
						_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute :: :: setting ftpFlag true");
						ftpFlag=true;
					}
/*     */         }
/*     */         catch (Exception ifsEx) {// 923018-02_11 Changing the IFSException to Exception
					
/*     */           try {
	  					_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute:: first place :: Exception ifsEx :: m_sourceFolder "+m_sourceFolder);	
/* 199 */           	  m_sourceFolder = (m_sourceFolder.substring(0, m_sourceFolder.lastIndexOf("/") + 1) + "error");
					  _QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute:: Exception ifsEx :: m_sourceFolder "+m_sourceFolder);	
					  srcFile=new File(m_sourceFolder+ File.separator + m_fileName);
/* 200 */             //if (!ftpClient.put(wfFtpFileName, ifsUtil.getDocumentContent(m_sourceFolder, m_fileName)))
					  if (!ftpClient.put(wfFtpFileName, bis))
/*     */             {
/* 202 */               resultOut = "ERROR";
/* 203 */               //ifsUtil.disconnectSession();
/* 204 */               QFEQIFDatabaseConn.closeConnection();
						_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute:: Exception ifsEx :: before throwing Unable to put in Remote FTP server :: m_fileName"+m_fileName);	
/* 205 */               throw new Exception("Unable to put " + m_fileName + " in Remote FTP Server.");
/*     */             }
					  else{//923018- Error file movement from error to original folder- Start -08-11-21
						  _QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute:: Inside else block :: setting ftpFlag true");	
						  ftpFlag=true;						 
						 
					  }
					//923018- Error file movement from error to original folder
/*     */           }
/*     */           catch (Exception e) { //923018-02_11 IFSException
/* 209 */             //ifsUtil.disconnectSession();
						_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute:: Exception e :: before throwing Error getting file from CMSDK location :: m_fileName:: "+m_fileName+" m_sourceFolder :: "+m_sourceFolder);	
/* 210 */             QFEQIFDatabaseConn.closeConnection();
/* 211 */             throw new Exception("Error getting " + m_fileName + " file from CMSDK location : " + m_sourceFolder);
/*     */           }
/*     */         }
				//923018- Error file movement from error to original folder-08-11-21 -Start
					_QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute:: ftpFlag :: "+ftpFlag);	
					if(ftpFlag) {
						 _QFEQLogger.info(FILE_NAME+" QFEQIFFtpIHub::execute:: if of ftpFlag :: m_sourceFolder "+m_sourceFolder);	
						 if(m_sourceFolder !=null && m_sourceFolder .contains("error")) {
							  _QFEQLogger.info(" ::inside m_sourceFolder error check :: ");
								try {
									if (srcFile.exists()) {
										File targetFile=new File(targetFilefullNm);
										Timestamp ts = new Timestamp(srcFile.lastModified());
										_QFEQLogger.info(FILE_NAME+" ::inside srcfile.exists :: ifid :: "+ifid+" ts :: "+ts);
										crypto.updateWCCStatus(ifid, m_fileName, ts);
										
										_QFEQLogger.info(FILE_NAME+" Database Update successfull  srcFile ::" + srcFile.getName() + " targetFile ::: "
												+ targetFile.getName());
										// File sourceFile =new file(sourceFolder+"/"+)
										
										FileUtils.copyFile(srcFile, targetFile);

										srcFile.delete();
									} else {
										_QFEQLogger.info(m_fileName+" No File exist in Src location  " + m_sourceFolder);
									}
								} catch (Exception e) {
									_QFEQLogger.info(m_fileName+" Exception Occcured during copyFile " + e.getMessage());
								}
							}
					}
					 //923018- Error file movement from error to original folder-08-11-21 End
/*     */       }
/*     */        _QFEQLogger.info(FILE_NAME+" ftpClient logout");	
/* 216 */       ftpClient.logout();
				if(bis!= null)
					bis.close();
				if(fis!=null)
					fis.close();
/*     */     }
/*     */     else
/*     */     {
/* 220 */       resultOut = "FTPLOGIN";
				_QFEQLogger.info(FILE_NAME+" ftpClient login");	
				if(bis!= null)
					bis.close();
				if(fis!=null)
					fis.close();
/* 221 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 225 */     //ifsUtil.disconnectSession();
/* 226 */     QFEQIFDatabaseConn.closeConnection();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 275 */     _QFEQLogger.info("resultOut: " + resultOut);
/* 276 */     _QFEQLogger.info("Exiting " + METHOD_NAME);
/* 277 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getAttribValue(String p_attrib)
/*     */   {
/* 288 */     String attribVal = "";
/*     */     try
/*     */     {
/* 291 */       attribVal = QFEQIFUtil.toBlank(p_attrib);
/*     */     }
/*     */     catch (Exception e) {}
/*     */     
/*     */ 
/*     */ 
/* 297 */     return attribVal;
/*     */   }
/*     */   
/*     */   private static String stackTraceToString(Throwable e) {
/* 301 */     StringBuilder sb = new StringBuilder();
/* 302 */     for (StackTraceElement element : e.getStackTrace()) {
/* 303 */       sb.append(element.toString());
/* 304 */       sb.append("\n");
/*     */     }
/* 306 */     return sb.toString();
/*     */   }
/*     */ }

/* Location:           D:\Workspace\QantasIHubServices\ImportedClasses
 * Qualified Name:     qantas.eq.integration.ftp.QFEQIFFtpIHub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */