/*     */ package com.qantas.eq.data;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.sql.Connection;
/*     */ import java.util.Properties;
/*     */ import oracle.ifs.adk.filesystem.IfsFileSystem;
/*     */ import oracle.ifs.beans.LibraryService;
/*     */ import oracle.ifs.beans.LibrarySession;
/*     */ import oracle.ifs.beans.PublicObject;
/*     */ import oracle.ifs.common.CleartextCredential;
/*     */ import oracle.ifs.common.Credential;
/*     */ import oracle.ifs.common.IfsException;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class QFEQIFCMSDKUtilSOA {
/*  61 */   static final Logger _logger = Logger.getLogger(com.qantas.eq.data.QFEQIFCMSDKUtilSOA.class);
/*     */   
/*  62 */   private final String CLASS_NAME = getClass().getName();
/*     */   
/*  65 */   private LibraryService m_service = null;
/*     */   
/*  66 */   private LibrarySession m_session = null;
/*     */   
/*     */   private String m_ifsSysPwd;
/*     */   
/*     */   boolean m_errorFlag = false;
/*     */   
/*     */   public QFEQIFCMSDKUtilSOA(String p_ifsAdminUser, String p_ifsAdminPwd, String p_ifsService, String p_ifsSysPwd) {
/*  81 */     this.m_ifsSysPwd = p_ifsSysPwd;
/*  82 */     this.m_session = createLibrarySession(p_ifsAdminUser, p_ifsAdminPwd, p_ifsService, p_ifsSysPwd);
/*     */   }
/*     */   
/*     */   public QFEQIFCMSDKUtilSOA(LibrarySession p_libs) {
/*  87 */     this.m_session = p_libs;
/*     */   }
/*     */   
/*     */   public QFEQIFCMSDKUtilSOA() {}
/*     */   
/*     */   private LibrarySession createLibrarySession(String p_ifsAdminUser, String p_ifsAdminPwd, String p_ifsService, String p_ifsSysPwd) {
/* 105 */     String METHOD_NAME = this.CLASS_NAME + ".createLibrarySession";
/* 106 */    // _logger.info("Entering " + METHOD_NAME);
/* 109 */     LibrarySession lsession = null;
/*     */     try {
/* 120 */       if (LibraryService.isServiceStarted(p_ifsService)) {
/* 122 */         this.m_service = LibraryService.findService(p_ifsService);
/*     */       } else {
/* 127 */         String configPath = System.getenv("QFEQIF_CONFIG");
/* 128 */         Properties pro = new Properties();
/* 129 */         pro.load(new FileInputStream(configPath));
/* 131 */         String domain_name = pro.getProperty("IFS_DOMAIN_NAME");
/* 133 */         domain_name = (domain_name == null) ? "" : domain_name;
/* 136 */         this.m_service = LibraryService.startService(p_ifsService, p_ifsSysPwd, null, domain_name);
/*     */       } 
/* 138 */       CleartextCredential cred = new CleartextCredential(p_ifsAdminUser, p_ifsAdminPwd);
/* 140 */       lsession = this.m_service.connect((Credential)cred, null);
/* 142 */       lsession.setAdministrationMode(true);
/* 144 */     } catch (IfsException e) {
/* 146 */       IfsException.setVerboseMessage(true);
/* 149 */       _logger.error("Error connecting to cmsdk.. " + e.getMessage());
/* 150 */       this.m_errorFlag = true;
/* 152 */     } catch (Exception ex) {
/* 156 */       _logger.error("Error reading config file.. " + ex.getMessage());
/* 157 */       this.m_errorFlag = true;
/*     */     } 
/* 161 */     return lsession;
/*     */   }
/*     */   
/*     */   public boolean createDocStream(String p_filePath, String p_fileName, InputStream p_contentStream) throws IfsException, IOException {
/* 176 */     String METHOD_NAME = this.CLASS_NAME + ".createDocStream";
/* 177 */     //_logger.info("Entering " + METHOD_NAME);
/* 179 */     IfsFileSystem ifs = new IfsFileSystem(this.m_session);
/* 182 */     PublicObject po = null;
/*     */     try {
/* 184 */       po = ifs.findPublicObjectByPath(p_filePath + "/" + p_fileName);
/* 185 */     } catch (IfsException fex) {
/* 186 */       po = null;
/* 188 */       _logger.info("Can't find this file. " + p_fileName);
/*     */     } 
/* 191 */     if (po != null)
/*     */       try {
/* 194 */         ifs.delete(po);
/* 195 */         _logger.info("Previous file deleted. " + p_fileName);
/* 196 */       } catch (IfsException fex) {
/* 197 */         fex.printStackTrace();
/* 198 */         _logger.info("Can't delete this file! " + p_fileName);
/*     */       }  
/* 203 */     ifs.createDocument(p_fileName, p_contentStream, p_filePath, null, false, null);
/* 204 */     _logger.info("New file created. " + p_fileName);
/* 206 */    // _logger.info("Exiting " + METHOD_NAME);
/* 207 */     return true;
/*     */   }
/*     */   
/*     */   public boolean createDocRef(String p_filePath, String p_fileName, Connection p_conn, String localPath) throws Exception {
/* 222 */     String METHOD_NAME = this.CLASS_NAME + ".createDocRef";
/* 223 */    // _logger.info("Entering " + METHOD_NAME);
/* 224 */     String FileGet = "" + localPath + "" + p_fileName;
/* 225 */     boolean bStatus = false;
/*     */     try {
/* 227 */       File file = new File(FileGet);
/* 228 */       FileInputStream fis = null;
/* 230 */       fis = new FileInputStream(file);
/* 231 */       createDocStream(p_filePath, p_fileName, fis);
/* 232 */       file.delete();
/* 233 */       bStatus = true;
/* 234 */       //_logger.info("Exiting " + METHOD_NAME);
/* 235 */     } catch (IfsException ifex) {
/* 236 */       throw new Exception("Error creating document in CM SDK.");
/* 237 */     } catch (IOException ioex) {
/* 238 */       throw new Exception("Error reading file from local folder.");
/*     */     } 
/* 240 */     return bStatus;
/*     */   }
/*     */   
/*     */   public void disconnectSession() throws IfsException {
/* 249 */     if (this.m_session != null) {
/* 251 */      // _logger.info("About to disconnectSession");
/* 252 */       this.m_session.disconnect();
/* 253 */       this.m_session = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void disconnectService() throws IfsException {
/* 263 */     if (this.m_service != null) {
/* 265 */       this.m_service.dispose(this.m_ifsSysPwd);
/* 266 */       this.m_service = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean getErrorFlag() {
/* 276 */     return this.m_errorFlag;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\data\QFEQIFCMSDKUtilSOA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */