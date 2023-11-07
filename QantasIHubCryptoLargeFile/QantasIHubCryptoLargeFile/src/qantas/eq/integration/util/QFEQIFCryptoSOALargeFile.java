/*     */ package qantas.eq.integration.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Method;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.logging.Logger;
/*     */ import javax.jws.WebMethod;
/*     */ import javax.jws.WebParam;
/*     */ import javax.jws.WebService;
/*     */ import oracle.sql.CLOB;
/*     */ import qantas.eq.integration.QFEQIFBase;
/*     */ import qantas.eq.integration.QFEQIFLogger;
/*     */ import qantas.eq.integration.util.QFEQIFDatabaseConn;
/*     */ 
/*     */ @WebService(serviceName = "QFEQIFCrypto")
/*     */ public class QFEQIFCryptoSOALargeFile implements QFEQIFBase {
/*  33 */   private Connection m_conn = null;
/*     */   
/*  34 */   private final String CLASS_NAME = getClass().getName();
/*     */   
/*  35 */   private static Logger _QFEQLogger = QFEQIFLogger.getLogger(qantas.eq.integration.util.QFEQIFCryptoSOALargeFile.class.getName());
/*     */   
/*     */   public QFEQIFCryptoSOALargeFile(Connection p_conn) {
/*  39 */     this.m_conn = p_conn;
/*     */   }
/*     */   
/*     */   public QFEQIFCryptoSOALargeFile() {}
/*     */   
/*     */   @WebMethod(exclude = true)
/*     */   public String decrypt(String p_encryptedText) throws SQLException {
/*  48 */     String METHOD_NAME = this.CLASS_NAME + ".decrypt";
/*  49 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*  51 */     String decryptedText = null;
/*  54 */     String sStmt = "{call QFEQIF_UTIL_PKG.DECRYPT(?, ?)}";
/*  56 */     CallableStatement procStmt = this.m_conn.prepareCall(sStmt);
/*  59 */     procStmt.setString(1, p_encryptedText);
/*  61 */     procStmt.registerOutParameter(2, 12);
/*  63 */     procStmt.execute();
/*  64 */     decryptedText = procStmt.getString(2);
/*  66 */     procStmt.close();
/*  73 */     _QFEQLogger.info("Exiting " + METHOD_NAME);
/*  74 */     return decryptedText;
/*     */   }
/*     */   
/*     */   @WebMethod(operationName = "GPGCrypto")
/*     */   public String GPGCrypto(@WebParam(name = "fcn") String p_fcn, @WebParam(name = "interfaceID") String p_interfaceID, @WebParam(name = "attrib1") String p_attrib1, @WebParam(name = "fileNm") String fileNm, @WebParam(name = "filePath") String p_filePath) throws Exception {
/*  84 */     String SCRIPT_DONE_MSG = "wfgpg Done!";
/*  85 */     boolean bStatus = true;
/*  87 */     String wfgpg_home = "";
/*  88 */     String enckey_fname = "";
/*  89 */     String seckey_fname = "";
/*  90 */     String data_fname = "";
/*  91 */     String processed_fname = "";
/*  92 */     String pubkey_fname = "";
/*  94 */     Connection dbConn = QFEQIFDatabaseConn.getConnection();
/*  95 */     this.m_conn = dbConn;
/*  96 */     qantas.eq.integration.util.QFEQIFCryptoSOALargeFile crypto = new qantas.eq.integration.util.QFEQIFCryptoSOALargeFile(dbConn);
/*  98 */     CallableStatement ocsGetKeys = null;
/* 101 */     InputStream privKeyStream = null;
/* 102 */     InputStream pubKeyStream = null;
/* 103 */     InputStream verifyKeyStream = null;
/* 105 */     CLOB tmpClob = null;
/* 108 */     InputStream dataStreamIn = null;
/* 111 */     String passPhrase = "";
/* 112 */     String enc_uid = "";
/* 113 */     String sec_uid = "";
/* 115 */     int optimal_size = 0;
/* 116 */     wfgpg_home = System.getenv("GPG_HOME");
/* 119 */     if (bStatus)
/*     */       try {
/* 121 */         wfgpg_home = (wfgpg_home == null) ? "" : (wfgpg_home + "/");
/* 124 */         int next_number = NextFileNameNumber();
/* 127 */         enckey_fname = wfgpg_home + "ptm" + "/" + next_number + ".enc.asc";
/* 132 */         seckey_fname = wfgpg_home + "ptm" + "/" + next_number + ".sec.asc";
/* 137 */         data_fname = wfgpg_home + "ptm" + "/" + next_number + ".dat";
/* 142 */         pubkey_fname = wfgpg_home + "ptm" + "/" + next_number + ".pub.asc";
/* 194 */         System.out.println(wfgpg_home + "wfgpg_home"+"..."+enckey_fname+"..."+seckey_fname+"..."+data_fname+"..."+pubkey_fname);

/* 146 */         _QFEQLogger.info("wfgpg_home: " + wfgpg_home + ", next file name number: " + next_number);
					
/* 149 */       } catch (SQLException ex) {
/* 150 */         _QFEQLogger.info("Error getting initial values for Encryption/Decryption.");
/* 151 */         bStatus = false;
/* 152 */         QFEQIFDatabaseConn.closeConnection();
/* 153 */         throw new Exception("Error getting next file number. Please see logs for detailed error.");
/*     */       }  
/* 156 */     if (bStatus)
/*     */       try {
/* 158 */         String sStmt = "{?=call QFEQIF_UTIL_PKG.GetRingKey(?, ?, ?, ?, ?, ?, ?, ?,?)}";
/* 161 */         ocsGetKeys = this.m_conn.prepareCall(sStmt);
/* 164 */         ocsGetKeys.registerOutParameter(1, 4);
/* 167 */         ocsGetKeys.registerOutParameter(5, 2005);
/* 170 */         ocsGetKeys.registerOutParameter(6, 12);
/* 173 */         ocsGetKeys.registerOutParameter(7, 2005);
/* 176 */         ocsGetKeys.registerOutParameter(8, 2005);
/* 179 */         ocsGetKeys.registerOutParameter(9, 12);
/* 182 */         ocsGetKeys.registerOutParameter(10, 12);
/* 185 */         ocsGetKeys.setString(2, p_interfaceID);
/* 188 */         ocsGetKeys.setString(4, "IN");
/* 190 */         ocsGetKeys.setString(3, "FINSIT1");
/* 192 */         ocsGetKeys.execute();
/* 194 */         System.out.println(ocsGetKeys.getInt(1) + "GetRingKey");
/* 196 */         if (ocsGetKeys.getInt(1) == 0) {
					System.out.println("inside if1");
/* 200 */           enc_uid = ocsGetKeys.getString(9);
/* 203 */           sec_uid = ocsGetKeys.getString(10);
/* 207 */           passPhrase = ocsGetKeys.getString(6);
/* 211 */           tmpClob = getCLOB(ocsGetKeys.getClob(8));
/* 212 */           if (tmpClob != null) {
						System.out.println("inside tmpClob if1");
/* 213 */             verifyKeyStream = tmpClob.getAsciiStream();
/* 214 */             outputFile(enckey_fname, verifyKeyStream, tmpClob.getBufferSize());
/* 216 */             verifyKeyStream.close();
/* 217 */             verifyKeyStream = null;
/*     */           } 
/* 222 */           tmpClob = getCLOB(ocsGetKeys.getClob(7));
/* 223 */           if (tmpClob != null) {
						System.out.println("inside tmpClob if2");

/* 224 */             pubKeyStream = tmpClob.getAsciiStream();
/* 225 */             outputFile(pubkey_fname, pubKeyStream, tmpClob.getBufferSize());
/* 227 */             pubKeyStream.close();
/* 228 */             pubKeyStream = null;
/*     */           } 
/* 233 */           tmpClob = getCLOB(ocsGetKeys.getClob(5));
/* 234 */           if (tmpClob != null) {
/* 235 */             privKeyStream = tmpClob.getAsciiStream();
/* 236 */             outputFile(seckey_fname, privKeyStream, tmpClob.getBufferSize());
/* 238 */             privKeyStream.close();
/* 239 */             privKeyStream = null;
/*     */           } 
/* 242 */           tmpClob = null;
/*     */         } 
/* 244 */       } catch (SQLException ex) {
/* 245 */         _QFEQLogger.info("Can't get secret data from the keyring!" + ex.getMessage());
/* 247 */         bStatus = false;
/* 248 */         QFEQIFDatabaseConn.closeConnection();
/* 249 */         throw new Exception("Can't get secret data from the keyring. Encryption/Decryption can not proceed.");
/* 250 */       } catch (IOException iex) {
/* 251 */         _QFEQLogger.info("Can't write data to OS!");
/* 252 */         bStatus = false;
/* 253 */         QFEQIFDatabaseConn.closeConnection();
/* 254 */         throw new Exception("Unable to write data to OS.");
/*     */       }
				catch (Exception iex) {
/* 251 */        System.out.println("ex in gpg home is"+iex);
/* 252 */         bStatus = false;
/* 253 */         QFEQIFDatabaseConn.closeConnection();
/* 254 */         throw new Exception("Unable to write data to OS.");
/*     */       }  
/*     */     try {
				System.out.println("p_filePath"+p_filePath+"...fileNm..."+fileNm+"..data_fname.."+data_fname);

/* 259 */       if (bStatus)
/* 261 */         if (!writeFileToGPGHome(p_filePath + "/" + fileNm, data_fname))
/* 264 */           bStatus = false;  
/* 267 */     } catch (FileNotFoundException fnEx) {
/* 268 */       throw new Exception(fnEx.getMessage());
/* 269 */     } catch (IOException iex) {
/* 270 */       throw new Exception(iex.getMessage());
/*     */     } 
/* 274 */     if (bStatus) {
/* 275 */       String padr = " ";
/* 276 */       _QFEQLogger.info("p_attrib1 >> " + p_attrib1);
				System.out.println("p_attrib1 >> " + p_attrib1);
/* 277 */       String attrib1 = (p_attrib1 == null) ? "null" : p_attrib1;
/* 278 */       attrib1 = attrib1.trim().equals("") ? "null" : attrib1;
/* 280 */       _QFEQLogger.info("attrib1 >> " + attrib1);
/* 282 */       String cmd = "wfgpgv2.sh" + padr + p_fcn + padr + enc_uid + padr + enckey_fname + padr + sec_uid + padr + seckey_fname + padr + passPhrase + padr + data_fname + padr + pubkey_fname + padr + attrib1 + padr;
/* 288 */       _QFEQLogger.info("--->About to exec: " + cmd);
/* 288 */      System.out.println("--->About to exec: " + cmd);

/* 289 */       Process prc = null;
/*     */       try {
					System.out.println("--->before exec: " + cmd);
/* 291 */         prc = Runtime.getRuntime().exec(cmd);
					System.out.println("--->after exec: " + cmd);
/* 293 */         int MAX_WAIT_MILLIS = 600000;
/* 295 */         int WAKE_MILLIS = 5000;
/* 296 */         int current_millis = 0;
/* 299 */         if (current_millis < MAX_WAIT_MILLIS) {
/* 300 */           Thread.sleep(WAKE_MILLIS);
/* 302 */           current_millis += WAKE_MILLIS;
/*     */           try {
						System.out.println("p_filePath"+p_filePath+"...fileNm..."+fileNm);
/* 304 */             File srcFile = new File(p_filePath + "/" + fileNm);
/* 309 */             int exit_code = prc.waitFor();
/* 311 */             if (exit_code == 0) {
						System.out.println("wfgpgv2.sh command executed successfully.");
/* 312 */               _QFEQLogger.info("wfgpgv2.sh command executed successfully.");
/* 314 */               srcFile.delete();
/*     */             } else {
						System.out.println("wfgpgv2.sh command returned non-zero exit code: " + exit_code);

/* 320 */               _QFEQLogger.info("wfgpgv2.sh command returned non-zero exit code: " + exit_code);
/* 324 */               File f = new File(data_fname + ".clr");
/* 325 */               if (f.exists() && !f.isDirectory()) {
							System.out.println("File generated >> " + f.getName());
/* 326 */                 _QFEQLogger.info("File generated >> " + f.getName());
/*     */               } else {
							System.out.println(".clr file not generated");
/* 329 */                 _QFEQLogger.info(".clr file not generated");
/* 330 */                 bStatus = false;
/*     */               } 
/*     */             } 
/* 334 */           } catch (IllegalThreadStateException ex) {
/* 336 */             _QFEQLogger.info("wfgpgv2.sh command not yet finished/exited. Time taken sofar (secs): " + (current_millis / 1000));
/* 339 */             throw new Exception("Encryption/Decryption not yet completed.");
/*     */           } 
/*     */         } 
/* 342 */         if (current_millis >= MAX_WAIT_MILLIS) {
/* 343 */           _QFEQLogger.info("Timeout!!! wfgpgv2.sh command has taken (mins): " + (current_millis / 60000) + ". Removing the process by force...");
/* 348 */           bStatus = false;
/*     */           try {
/* 351 */             if (prc != null)
/* 352 */               prc.destroy(); 
/* 353 */           } catch (Exception ex) {
/* 354 */             _QFEQLogger.info("Can't destoy the process: " + ex.getMessage());
/*     */           } 
/*     */         } 
/* 358 */       } catch (IOException iex) {
/* 359 */         _QFEQLogger.info("Can't execute OS command: " + cmd);
/* 360 */         bStatus = false;
/* 361 */         throw new Exception("Unable to Encrypt/Decrypt.");
/*     */       } 
/*     */     } 
/*     */     try {
/* 369 */       if (ocsGetKeys != null)
/* 370 */         ocsGetKeys.close(); 
/* 371 */     } catch (SQLException ex) {
/* 372 */       _QFEQLogger.info("Error closing keyring " + ex.getMessage());
/*     */     } 
/* 375 */     QFEQIFDatabaseConn.closeConnection();
/* 392 */     String rm_cmd = "rm -f ";
/* 393 */     _QFEQLogger.info("-------------File Cleanup Started-------------------");
/*     */     try {
/* 396 */       Runtime rt = Runtime.getRuntime();
/* 397 */       rt.exec(rm_cmd + enckey_fname);
/* 398 */       rt.exec(rm_cmd + pubkey_fname);
/* 399 */       rt.exec(rm_cmd + seckey_fname);
/* 400 */       rt.exec(rm_cmd + data_fname);
/* 401 */       rt.exec(rm_cmd + processed_fname);
/* 402 */     } catch (IOException iex) {
/* 403 */       _QFEQLogger.info("Cleanup files. Can't execute OS command: " + rm_cmd);
/*     */     } 
/* 408 */     _QFEQLogger.info("wfgpg Done!");
/* 409 */     _QFEQLogger.info("Exiting GPGCrypto");
/* 411 */     if (bStatus) {
/* 412 */       if (p_fcn.equals("D")) {
/* 414 */         Process prc = null;
/* 415 */         String cmd = "dos2unix " + data_fname + ".clr";
/* 417 */         System.out.println("Trim command " + cmd);
/* 418 */         prc = Runtime.getRuntime().exec(cmd);
/*     */       } 
/* 420 */       return data_fname;
/*     */     } 
/* 422 */     return "";
/*     */   }
/*     */   
/*     */   @WebMethod(exclude = true)
/*     */   protected int NextFileNameNumber() throws SQLException {
/* 428 */     int next = -1;
/* 429 */     String sStmt = "{?=call QFEQIF_UTIL_PKG.NextFileNameNumber}";
/* 431 */     CallableStatement cstmt = this.m_conn.prepareCall(sStmt);
/* 433 */     cstmt.registerOutParameter(1, 4);
/* 434 */     cstmt.execute();
/* 435 */     next = cstmt.getInt(1);
/* 436 */     cstmt.close();
/* 437 */     return next;
/*     */   }
/*     */   
/*     */   @WebMethod(exclude = true)
/*     */   private void outputFile(String p_fname, InputStream p_insfile, int p_bufsize) throws IOException {
/* 443 */     FileOutputStream fos = new FileOutputStream(p_fname);
/* 444 */     int size = p_bufsize;
/* 445 */     byte[] buffer = new byte[size];
/* 446 */     int length = -1;
/* 448 */     while ((length = p_insfile.read(buffer)) != -1)
/* 449 */       fos.write(buffer, 0, length); 
/* 451 */     fos.flush();
/* 452 */     fos.close();
/* 453 */     fos = null;
/*     */   }
/*     */   
/*     */   @WebMethod(exclude = true)
/*     */   private boolean writeFileToGPGHome(String source, String target) throws FileNotFoundException, IOException {
/* 460 */     boolean returnVal = true;
/*     */     try {
/* 463 */       File f = new File(source);
/* 464 */       InputStream fis = new FileInputStream(f);
/* 465 */       FileOutputStream fos = new FileOutputStream(target);
/* 466 */       int size = 1024;
/* 467 */       byte[] buffer = new byte[size];
/* 468 */       int length = -1;
/* 470 */       while ((length = fis.read(buffer)) != -1)
/* 471 */         fos.write(buffer, 0, length); 
/* 473 */       fos.flush();
/* 474 */       fos.close();
/* 475 */       fos = null;
/* 476 */       fis.close();
/* 478 */     } catch (FileNotFoundException e) {
/* 480 */       _QFEQLogger.info("Source file doesn't exist:: " + e.getMessage());
/* 481 */       returnVal = false;
/* 482 */       throw new FileNotFoundException("Source file doesn't exist");
/* 483 */     } catch (IOException io) {
/* 484 */       _QFEQLogger.info("Error in copying file to GPG Home");
/* 485 */       returnVal = false;
/* 486 */       throw new IOException("Error in copying file to GPG Home.");
/*     */     } 
/* 488 */     return returnVal;
/*     */   }
/*     */   
/*     */   @WebMethod(exclude = true)
/*     */   public CLOB getCLOB(Object o) throws SQLException {
/* 493 */     CLOB result = null;
/* 494 */     if (o instanceof CLOB) {
/* 495 */       result = (CLOB)o;
/*     */     } else {
/*     */       try {
/* 498 */         Method unwrap = o.getClass().getMethod("unwrap", new Class[] { Class.class });
/* 500 */         result = (CLOB)unwrap.invoke(o, new Object[] { CLOB.class });
/* 501 */       } catch (Exception e) {
/* 502 */         throw new SQLException("The provided object is neither oracle.sql.BLOB nor WL's wrapper");
/*     */       } 
/*     */     } 
/* 505 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\non_prodwars\QantasIHubCryptoLargeFile.war!\WEB-INF\classes\qantas\eq\integratio\\util\QFEQIFCryptoSOALargeFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */