/*     */ package qantas.eq.integration.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Method;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Connection;
import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
import java.sql.Timestamp;
/*     */ import java.util.logging.Logger;
/*     */ import javax.jws.WebMethod;
/*     */ import javax.jws.WebParam;
/*     */ import javax.jws.WebService;

import org.apache.commons.io.FileUtils;

/*     */ import oracle.sql.CLOB;
/*     */ import qantas.eq.integration.QFEQIFBase;
/*     */ import qantas.eq.integration.QFEQIFLogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @WebService(serviceName="QFEQIFCrypto")
/*     */ public class QFEQIFCryptoSOA
/*     */   implements QFEQIFBase
/*     */ {
/*  33 */   private Connection m_conn = null;
/*  34 */   private final String CLASS_NAME = getClass().getName();
/*  35 */   private static Logger _QFEQLogger = QFEQIFLogger.getLogger(QFEQIFCryptoSOA.class.getName());
/*     */   
/*     */   public QFEQIFCryptoSOA(Connection p_conn)
/*     */   {
/*  39 */     m_conn = p_conn;
/*     */   }
/*     */   
/*     */ 
/*     */   public QFEQIFCryptoSOA() {}
/*     */   
/*     */ 
/*     */   @WebMethod(exclude=true)
/*     */   public String decrypt(String p_encryptedText)
/*     */     throws SQLException
/*     */   {
/*  50 */     String METHOD_NAME = CLASS_NAME + ".decrypt";
/*  51 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/*  53 */     String decryptedText = null;
/*     */     
/*     */ 
/*  56 */     String sStmt = "{call QFEQIF_UTIL_PKG.DECRYPT(?, ?)}";
/*     */     
/*  58 */     CallableStatement procStmt = m_conn.prepareCall(sStmt);
/*     */     
/*     */ 
/*  61 */     procStmt.setString(1, p_encryptedText);
/*     */     
/*  63 */     procStmt.registerOutParameter(2, 12);
/*     */     
/*  65 */     procStmt.execute();
/*  66 */     decryptedText = procStmt.getString(2);
/*     */     
/*  68 */     procStmt.close();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  75 */     _QFEQLogger.info("Exiting " + METHOD_NAME);
/*  76 */     return decryptedText;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @WebMethod(operationName="GPGCrypto")
/*     */   public String GPGCrypto(@WebParam(name="fcn") String p_fcn, @WebParam(name="interfaceID") String p_interfaceID, @WebParam(name="attrib1") String p_attrib1, @WebParam(name="fileNm") String fileNm, @WebParam(name="filePath") String p_filePath)
/*     */     throws Exception
/*     */   {
/*  86 */     String SCRIPT_DONE_MSG = "wfgpg Done!";
/*  87 */     boolean bStatus = true;
/*     */     
/*  89 */     String wfgpg_home = "";
/*  90 */     String enckey_fname = "";
/*  91 */     String seckey_fname = "";
/*  92 */     String data_fname = "";
/*  93 */     String processed_fname = "";
/*  94 */     String pubkey_fname = "";
/*     */     
/*  96 */     Connection dbConn = QFEQIFDatabaseConn.getConnection();
/*  97 */     m_conn = dbConn;
/*  98 */     QFEQIFCryptoSOA crypto = new QFEQIFCryptoSOA(dbConn);
/*     */     
/* 100 */     CallableStatement ocsGetKeys = null;
/*     */     
/*     */ 
/* 103 */     InputStream privKeyStream = null;
/* 104 */     InputStream pubKeyStream = null;
/* 105 */     InputStream verifyKeyStream = null;
/*     */     
/* 107 */     CLOB tmpClob = null;
/*     */     
/*     */ 
/* 110 */     InputStream dataStreamIn = null;
/*     */     
/*     */ 
/* 113 */     String passPhrase = "";
/* 114 */     String enc_uid = "";
/* 115 */     String sec_uid = "";
/*     */     
/* 117 */     int optimal_size = 0;
/* 118 */     wfgpg_home = System.getenv("GPG_HOME");
/*     */     
/*     */     //System.out.println('\n'+"Get the GPG HOME Loaction"+wfgpg_home+'\n');

/* 121 */     if (bStatus) {
/*     */       try {
/* 123 */         wfgpg_home = wfgpg_home + "/";
/*     */         
/* 125 */         int next_number = NextFileNameNumber();
/*     */         
/*     */ 
/* 128 */         enckey_fname = wfgpg_home + "ptm" + "/" + next_number + ".enc.asc";
/*     */         
/*     */ 
/* 131 */         seckey_fname = wfgpg_home + "ptm" + "/" + next_number + ".sec.asc";
/*     */         
/*     */ 
/* 134 */         data_fname = wfgpg_home + "ptm" + "/" + next_number + ".dat";
/*     */         
/*     */ 
/* 137 */         pubkey_fname = wfgpg_home + "ptm" + "/" + next_number + ".pub.asc";
/*     */         
                 //System.out.println("Get the key name"+enckey_fname+'\n'+seckey_fname+'\n'+data_fname+'\n'+pubkey_fname);
                 
/* 139 */         _QFEQLogger.info("wfgpg_home: " + wfgpg_home + ", next file name number: " + next_number);
/*     */ 
/*     */       }
/*     */       catch (SQLException ex)
/*     */       {
/* 144 */         _QFEQLogger.info("Error getting initial values for Encryption/Decryption.");
/* 145 */         bStatus = false;
/* 146 */         QFEQIFDatabaseConn.closeConnection();
/* 147 */         throw new Exception("Error getting next file number. Please see logs for detailed error.");
/*     */       }
/*     */     }
/* 150 */     if (bStatus) {
/*     */       try {
/* 152 */         String sStmt = "{?=call QFEQIF_UTIL_PKG.GetRingKey(?, ?, ?, ?, ?, ?, ?, ?,?)}";
/*     */        // System.out.println("Get get Ring Key"+sStmt+'\n');

/* 154 */         ocsGetKeys = m_conn.prepareCall(sStmt);
                  //System.out.println("Get get Ring Key"+ocsGetKeys+'\n'); 
/*     */         
/*     */ 
/* 157 */         ocsGetKeys.registerOutParameter(1, 4);
/*     */         
/*     */ 
/* 160 */         ocsGetKeys.registerOutParameter(5, 2005);
/*     */         
/*     */ 
/* 163 */         ocsGetKeys.registerOutParameter(6, 12);
/*     */         
/*     */ 
/* 166 */         ocsGetKeys.registerOutParameter(7, 2005);
/*     */         
/*     */ 
/* 169 */         ocsGetKeys.registerOutParameter(8, 2005);
/*     */         
/*     */ 
/* 172 */         ocsGetKeys.registerOutParameter(9, 12);
/*     */         
/*     */ 
/* 175 */         ocsGetKeys.registerOutParameter(10, 12);
/*     */         
/*     */ 
/* 178 */         ocsGetKeys.setString(2, p_interfaceID);
/*     */         
/*     */ 
/* 181 */         ocsGetKeys.setString(4, "IN");
/*     */         
/* 183 */         ocsGetKeys.setString(3, "FINSIT1");
/*     */         
/* 185 */         ocsGetKeys.execute();
/*     */         
/* 187 */         System.out.println(ocsGetKeys.getInt(1) + "GetRingKey"+'\n');
/*     */         
/* 189 */         if (ocsGetKeys.getInt(1) == 0)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 194 */           enc_uid = ocsGetKeys.getString(9);
/*     */           
/*     */ 
/* 197 */           sec_uid = ocsGetKeys.getString(10);
/*     */           
/*     */ 
/*     */ 
/* 201 */           passPhrase = ocsGetKeys.getString(6);
/*     */           
/*     */ 			//System.out.println("Get ids"+enc_uid+'\n'+sec_uid+'\n'+passPhrase);
/*     */ 
/* 205 */           tmpClob = getCLOB(ocsGetKeys.getClob(8));
/* 206 */           if (tmpClob != null)
/*     */           {
/* 208 */             verifyKeyStream = tmpClob.getAsciiStream();
/* 209 */             outputFile(enckey_fname, verifyKeyStream, tmpClob.getBufferSize());
/* 210 */             verifyKeyStream.close();
/* 211 */             verifyKeyStream = null;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 216 */           tmpClob = getCLOB(ocsGetKeys.getClob(7));
/* 217 */           if (tmpClob != null)
/*     */           {
/* 219 */             pubKeyStream = tmpClob.getAsciiStream();
/* 220 */             outputFile(pubkey_fname, pubKeyStream, tmpClob.getBufferSize());
/* 221 */             pubKeyStream.close();
/* 222 */             pubKeyStream = null;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 227 */           tmpClob = getCLOB(ocsGetKeys.getClob(5));
/* 228 */           if (tmpClob != null)
/*     */           {
/* 230 */             privKeyStream = tmpClob.getAsciiStream();
/* 231 */             outputFile(seckey_fname, privKeyStream, tmpClob.getBufferSize());
/* 232 */             privKeyStream.close();
/* 233 */             privKeyStream = null;
/*     */           }
/*     */           
/* 236 */           tmpClob = null;
/*     */         }
/*     */       } catch (SQLException ex) {
	              System.out.println("SQLException"+ex+'\n');
/* 239 */         _QFEQLogger.info("Can't get secret data from the keyring!" + ex.getMessage());
/* 240 */         bStatus = false;
/* 241 */         QFEQIFDatabaseConn.closeConnection();
/* 242 */         throw new Exception("Can't get secret data from the keyring. Encryption/Decryption can not proceed.");
/*     */       } catch (IOException iex) {
	             System.out.println("IOException  Can't write data to OS!"+iex+'\n');
/* 244 */         _QFEQLogger.info("Can't write data to OS!");
/* 245 */         bStatus = false;
/* 246 */         QFEQIFDatabaseConn.closeConnection();
/* 247 */         throw new Exception("Unable to write data to OS.");
/*     */       }
/*     */     }
/*     */     try
/*     */     {
/* 252 */       if (bStatus)
/*     */       {
/* 254 */         if (!writeFileToGPGHome(p_filePath + "/" + fileNm, data_fname,p_fcn,p_filePath,fileNm,p_interfaceID)) {//923018 -12_11_21  Added copy file from error to destination and update wcc status table.
	               System.out.println("File Path "+p_filePath+"/"+fileNm+'\n');
/* 255 */           bStatus = false;
/*     */         }
/*     */       }
/*     */     } catch (FileNotFoundException fnEx) {
	             System.out.println("FileNotFoundException"+fnEx);
/* 259 */       throw new Exception(fnEx.getMessage());
/*     */     } catch (IOException iex) {
	             System.out.println("IOException 2"+iex);
/* 261 */       throw new Exception(iex.getMessage());
/*     */     }
/*     */     
/*     */ 
/* 265 */     if (bStatus) {
/* 266 */       String padr = " ";
/* 267 */       _QFEQLogger.info("p_attrib1 >> " + p_attrib1);
/* 268 */       String attrib1 = p_attrib1 == null ? "null" : p_attrib1;
/* 269 */       attrib1 = attrib1.trim().equals("") ? "null" : attrib1;
/* 270 */       _QFEQLogger.info("attrib1 >> " + attrib1);
/*     */       
/* 272 */       String cmd = wfgpg_home + "wfgpg.sh" + padr + p_fcn + padr + enc_uid + padr + enckey_fname + padr + sec_uid + padr + seckey_fname + padr + passPhrase + padr + data_fname + padr + pubkey_fname + padr + attrib1 + padr;
/*     */       
/*     */ 		System.out.println("execute command"+cmd+'\n');
/*
/* 283 */       _QFEQLogger.info("--->About to exec: " + cmd);
/* 284 */       Process prc = null;
/*     */       try { 
	
	              prc = Runtime.getRuntime().exec(cmd);
/* 288 */         int MAX_WAIT_MILLIS = 300000;
/* 289 */         int WAKE_MILLIS = 5000;
/* 290 */         int current_millis = 0;
/*     */         
/*     */ 
/* 293 */        // while (current_millis < MAX_WAIT_MILLIS)
                 if(current_millis < MAX_WAIT_MILLIS)
/*     */         {
	                System.out.println("current_millis"+current_millis+'\n'); 
/* 295 */           Thread.sleep(WAKE_MILLIS);
/* 296 */           current_millis += WAKE_MILLIS;
/*     */           try
/*     */           {
/* 299 */             File srcFile = new File(p_filePath + "/" + fileNm);
/* 300 */             int exit_code = prc.exitValue();

                     System.out.println("exit_code"+exit_code+'\n');
/* 301 */             if (exit_code == 0)
/*     */             {
	                   System.out.println("In exit code");
/* 303 */               _QFEQLogger.info("wfgpg.sh command executed successfully.");
/* 304 */              // srcFile.delete(); //923018- Commented as part of CMSDK change
						
/*     */             }
/*     */             else
/*     */             {
/* 309 */               _QFEQLogger.info("wfgpg.sh command returned non-zero exit code: " + exit_code);
/*     */               
/* 311 */               File f = new File(data_fname + ".clr");
/* 312 */               if ((f.exists()) && (!f.isDirectory())) {
/* 313 */                 _QFEQLogger.info("File generated >> " + f.getName());
/*     */               } else {
/* 315 */                 _QFEQLogger.info(".clr file not generated");
/* 316 */                 bStatus = false;
/*     */               }
/*     */               
/*     */             }
					
/*     */             
/*     */           }
/*     */           catch (IllegalThreadStateException ex)
/*     */           {
	                   System.out.println("IllegalThreadStateException"+ex+'\n');
						
/* 324 */             _QFEQLogger.info("wfgpg.sh command not yet finished/exited. Time taken sofar (secs): " + current_millis / 1000);
/*     */           }
/*     */         }
/* 327 */         if (current_millis >= MAX_WAIT_MILLIS)
/*     */         {
/* 329 */           _QFEQLogger.info("Timeout!!! wfgpg.sh command has taken (mins): " + current_millis / 60000 + ". Removing the process by force...");
/* 330 */           bStatus = false;
/*     */           
/*     */           try
/*     */           {
/* 334 */             if (prc != null) {
/* 335 */               prc.destroy();
/*     */             }
/*     */           }
/*     */           catch (Exception ex) {
	                  System.out.println("Exception1"+ex+'\n');
/* 339 */             _QFEQLogger.info("Can't destoy the process: " + ex.getMessage());
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (IOException iex)
/*     */       {
	             System.out.println("IOException1 Can't execute OS command:"+iex);
/* 345 */         _QFEQLogger.info("Can't execute OS command: " + cmd);
/* 346 */         bStatus = false;
/* 347 */         throw new Exception("Unable to Encrypt/Decrypt.");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 356 */       if (ocsGetKeys != null)
/* 357 */         ocsGetKeys.close();
/*     */     } catch (SQLException ex) {
/* 359 */       _QFEQLogger.info("Error closing keyring " + ex.getMessage());
/*     */     }
/*     */     
/* 362 */     QFEQIFDatabaseConn.closeConnection();
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
/* 379 */     String rm_cmd = "rm -f ";
/* 380 */     _QFEQLogger.info("-------------File Cleanup Started-------------------");
/*     */     
/*     */     try
/*     */     {
/* 384 */       Runtime rt = Runtime.getRuntime();
/* 385 */       rt.exec(rm_cmd + enckey_fname);
/* 386 */       rt.exec(rm_cmd + pubkey_fname);
/* 387 */       rt.exec(rm_cmd + seckey_fname);
/* 388 */       rt.exec(rm_cmd + data_fname);
/* 389 */       rt.exec(rm_cmd + processed_fname);
/*     */     }
/*     */     catch (IOException iex)
/*     */     {
	            System.out.println("IOException Cleanup files. Can't execute OS command:"+iex);
	
/* 393 */       _QFEQLogger.info("Cleanup files. Can't execute OS command: " + rm_cmd);
/*     */     }
/*     */     
/*     */ 
/* 397 */     _QFEQLogger.info("wfgpg Done!");
/* 398 */     _QFEQLogger.info("Exiting GPGCrypto");
/*     */     
/* 400 */     if (bStatus) {
/* 401 */       if (p_fcn.equals("D"))
/*     */       {
/* 403 */         Process prc = null;
/* 404 */         String cmd = "dos2unix " + data_fname + ".clr";
/* 405 */         System.out.println("Trim command " + cmd);
/* 406 */         prc = Runtime.getRuntime().exec(cmd);
/*     */       }
/* 408 */       return data_fname;
/*     */     }
/* 410 */     return "";
/*     */   }
/*     */   
/*     */   @WebMethod(exclude=true)
/*     */   protected int NextFileNameNumber()
/*     */     throws SQLException
/*     */   {
/* 417 */     int next = -1;
/* 418 */     String sStmt = "{?=call QFEQIF_UTIL_PKG.NextFileNameNumber}";
/*     */     
/* 420 */     CallableStatement cstmt = m_conn.prepareCall(sStmt);
/*     */     
/* 422 */     cstmt.registerOutParameter(1, 4);
/* 423 */     cstmt.execute();
/* 424 */     next = cstmt.getInt(1);
/* 425 */     cstmt.close();
/* 426 */     return next;
/*     */   }

//923018- Error file movement from error to original folder -Start -03_11_21
	@WebMethod(exclude=true)
	public void updateWCCStatus(String ifId, String fileName, Timestamp ts) throws SQLException {

		Connection con = QFEQIFDatabaseConn.getConnection();
		Timestamp lastModified = new Timestamp(System.currentTimeMillis());
		_QFEQLogger.info(fileName+"lastModified :: QFEQIFCryptoSOA :: FTPSendFile :: updateWCCStatus " + lastModified.toString());
		PreparedStatement stmt = con.prepareStatement("update QFEQIF_WCC set STATUS = ?,LAST_UP_DT = ? where IFID = ? AND FILE_NAME = ? AND FILE_CREATION_TIME = ?");
		stmt.setString(1, "INPROGRESS");
		stmt.setTimestamp(2, lastModified);
		stmt.setString(3, ifId);
		stmt.setString(4, fileName);
		stmt.setTimestamp(5, ts);
		_QFEQLogger.info("UPDATE QUERY::: IFID :: "+ifId+" File Name :: "+fileName+" QFEQIFCryptoSOA :: updateWCCStatus :: FTPSendFile " + stmt.toString());
		stmt.executeUpdate();

		QFEQIFDatabaseConn.closeConnection();

	}
	//923018- Error file movement from error to original folder -End -03_11_21
/*     */   
/*     */   @WebMethod(exclude=true)
/*     */   private void outputFile(String p_fname, InputStream p_insfile, int p_bufsize) throws IOException
/*     */   {
/* 432 */     FileOutputStream fos = new FileOutputStream(p_fname);
/* 433 */     int size = p_bufsize;
/* 434 */     byte[] buffer = new byte[size];
/* 435 */     int length = -1;
/*     */     
/* 437 */     while ((length = p_insfile.read(buffer)) != -1) {
/* 438 */       fos.write(buffer, 0, length);
/*     */     }
/* 440 */     fos.flush();
/* 441 */     fos.close();
/* 442 */     fos = null;
/*     */   }
/*     */   
/*     */   @WebMethod(exclude=true)
/*     */   private boolean writeFileToGPGHome(String source, String target, String f_pcn, String folderPath, String fName, String ifid) throws FileNotFoundException, IOException,SQLException,Exception {
/* 447 */     boolean returnVal = true;

				_QFEQLogger.info(fName+ " :: writeFileToGPGHome:: source::  " + source);
				_QFEQLogger.info(fName+ " :: writeFileToGPGHome:: target::  " + target);
				_QFEQLogger.info(fName+ " :: writeFileToGPGHome:: f_pcn " + f_pcn);
				_QFEQLogger.info(fName+ " :: writeFileToGPGHome:: folderPath " + folderPath);
				_QFEQLogger.info(fName+ " :: writeFileToGPGHome:: ifid " + ifid);
				
/*     */     try
/*     */     {
/* 450 */       File f = new File(source);
/* 451 */       InputStream fis = new FileInputStream(f);
/* 452 */       FileOutputStream fos = new FileOutputStream(target);
/* 453 */       int size = 1024;
/* 454 */       byte[] buffer = new byte[size];
/* 455 */       int length = -1;
/*     */       
/* 457 */       while ((length = fis.read(buffer)) != -1) {
/* 458 */         fos.write(buffer, 0, length);
/*     */       }
/* 460 */       fos.flush();
/* 461 */       fos.close();
/* 462 */       fos = null;
/* 463 */       fis.close();
/*     */     }
/*     */     catch (FileNotFoundException e)
		/*     */ {
			/* 467 */ _QFEQLogger.info("Source file doesn't exist:: " + e.getMessage());
			if ("E".equalsIgnoreCase(f_pcn)) {

				String sourceFolder = (folderPath.substring(0, folderPath.lastIndexOf("/") + 1) + "error");
				_QFEQLogger.info(fName+"sourceFolder:: " + sourceFolder);
				File srcFile = new File(sourceFolder + File.separator + fName);
				_QFEQLogger.info(fName+"folderPath:: " + folderPath);
				File targetFile = new File(folderPath + File.separator + fName);
				
				if (srcFile.exists()) {
					try {
					Timestamp ts = new Timestamp(srcFile.lastModified());
					_QFEQLogger
							.info(fName + " ::inside FileNotFoundException.exists :: ifid :: " + ifid + " ts :: " + ts);

					try {
						updateWCCStatus(ifid, fName, ts);
					} catch (SQLException e1) {
						returnVal = false;
						_QFEQLogger.info(fName + " ::inside SQLException :: ifid :: " + e1.getMessage());
						throw new SQLException("Error in copying file to GPG Home.");
					}

					// File srcFile =new File (sourceFolder+File.separator+fName);
					FileUtils.copyFile(srcFile, targetFile);
					_QFEQLogger
					.info(fName + " :: File Copied Successfully :: " );
					srcFile.delete();
				}catch(Exception ex) {
					_QFEQLogger.info(fName+" Exception Occcured during copyFile " + e.getMessage());
					throw new Exception(ex.getMessage());
				}
					  try
					  /*     */     {
					  /* 450 */      // File f = new File(source);
					  /* 451 */       InputStream fis = new FileInputStream(targetFile);
					  /* 452 */       FileOutputStream fos = new FileOutputStream(target);
					  /* 453 */       int size = 1024;
					  /* 454 */       byte[] buffer = new byte[size];
					  /* 455 */       int length = -1;
					  /*     */       
					  /* 457 */       while ((length = fis.read(buffer)) != -1) {
					  /* 458 */         fos.write(buffer, 0, length);
					  /*     */       }
					  /* 460 */       fos.flush();
					  /* 461 */       fos.close();
					  /* 462 */       fos = null;
					  /* 463 */       fis.close();
					  /*     */     }
					  /*     */     catch (FileNotFoundException ex)
					  /*     */     {
						  				 returnVal = false;
						  /* 473 */       throw new IOException("Error in copying file to GPG Home from Error block");
					  				}
				}
			}
			/* 468 */ 
			/* 469 */ //throw new FileNotFoundException("Source file doesn't exist");
			/*     */ } catch (IOException io) {
				System.out.println("Error in copying file to GPG Home"+io);
/* 471 */       _QFEQLogger.info("Error in copying file to GPG Home");
/* 472 */       returnVal = false;
/* 473 */       throw new IOException("Error in copying file to GPG Home.");
/*     */     }
/* 475 */     return returnVal;
/*     */   }
/*     */   
/*     */   @WebMethod(exclude=true)
/*     */   public CLOB getCLOB(Object o) throws SQLException {
/* 480 */     CLOB result = null;
/* 481 */     if ((o instanceof CLOB)) {
/* 482 */       result = (CLOB)o;
/*     */     } else {
/*     */       try {
/* 485 */         Method unwrap = o.getClass().getMethod("unwrap", new Class[] { Class.class });
/* 486 */         result = (CLOB)unwrap.invoke(o, new Object[] { CLOB.class });
/*     */       } catch (Exception e) {
/* 488 */         throw new SQLException("The provided object is neither oracle.sql.BLOB nor WL's wrapper");
/*     */       }
/*     */     }
/* 491 */     return result;
/*     */   }
/*     */ }

/* Location:           D:\Workspace\QantasIHubServices\ImportedClasses
 * Qualified Name:     qantas.eq.integration.util.QFEQIFCryptoSOA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */