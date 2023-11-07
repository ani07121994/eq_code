/*     */ package qantas.eq.integration.util;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Dictionary;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Properties;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.Vector;
/*     */ import java.util.logging.Logger;
/*     */ import oracle.ifs.adk.filesystem.IfsFileSystem;
/*     */ import oracle.ifs.beans.Document;
/*     */ import oracle.ifs.beans.Folder;
/*     */ import oracle.ifs.beans.LibraryService;
/*     */ import oracle.ifs.beans.LibrarySession;
/*     */ import oracle.ifs.beans.PublicObject;
/*     */ import oracle.ifs.common.CleartextCredential;
/*     */ import oracle.ifs.common.IfsException;
/*     */ import oracle.ifs.protocols.email.beans.BodyPart;
/*     */ import oracle.ifs.protocols.email.beans.Rfc822Message;
/*     */ import oracle.jdbc.driver.OracleDriver;
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
/*     */ public class QFEQIFCMSDKUtilSOA
/*     */   implements QFEQIFBase
/*     */ {
/*  47 */   static final Logger _QFEQLogger = QFEQIFLogger.getLogger(QFEQIFCMSDKUtilSOA.class.getName());
/*  48 */   private final String CLASS_NAME = getClass().getName();
/*     */   
/*     */ 
/*  51 */   private LibraryService m_service = null;
/*  52 */   private LibrarySession m_session = null;
/*  53 */   private String m_message = "";
/*     */   private String m_ifsSysPwd;
/*  55 */   boolean m_errorFlag = false;
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
/*     */   public QFEQIFCMSDKUtilSOA(String p_ifsAdminUser, String p_ifsAdminPwd, String p_ifsService, String p_ifsSysPwd)
/*     */     throws Exception
/*     */   {
/*  69 */     m_ifsSysPwd = p_ifsSysPwd;
/*  70 */     m_session = createLibrarySession(p_ifsAdminUser, p_ifsAdminPwd, p_ifsService, p_ifsSysPwd);
/*     */   }
/*     */   
/*     */   public QFEQIFCMSDKUtilSOA(LibrarySession p_libs)
/*     */   {
/*  75 */     m_session = p_libs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public QFEQIFCMSDKUtilSOA() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private LibrarySession createLibrarySession(String p_ifsAdminUser, String p_ifsAdminPwd, String p_ifsService, String p_ifsSysPwd)
/*     */     throws Exception
/*     */   {
/*  95 */     String METHOD_NAME = CLASS_NAME + ".createLibrarySession";
/*  96 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 103 */     LibrarySession lsession = null;
/*     */     try
/*     */     {
/* 106 */       if (LibraryService.isServiceStarted(p_ifsService))
/*     */       {
/* 108 */         m_service = LibraryService.findService(p_ifsService);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 113 */         String configPath = System.getenv("QFEQIF_CONFIG");
/* 114 */         Properties pro = new Properties();
/* 115 */         pro.load(new FileInputStream(configPath));
/*     */         
/* 117 */         String domain_name = pro.getProperty("IFS_DOMAIN_NAME");
/*     */         
/* 119 */         domain_name = domain_name == null ? "" : domain_name;
/*     */         
/*     */ 
/*     */ 
/* 123 */         m_service = LibraryService.startService(p_ifsService, p_ifsSysPwd, null, domain_name);
/*     */       }
/* 125 */       CleartextCredential cred = new CleartextCredential(p_ifsAdminUser, p_ifsAdminPwd);
/* 126 */       _QFEQLogger.info("***************Connecting...**************");
/* 127 */       lsession = m_service.connect(cred, null);
/* 128 */       _QFEQLogger.info("**********Connected!!***********");
/* 129 */       lsession.setAdministrationMode(true);
/*     */     } catch (IfsException e) {
/* 131 */       IfsException.setVerboseMessage(true);
/* 132 */       m_message = e.getMessage();
/* 133 */       _QFEQLogger.info("Error connecting CMSDK server. Ifs Error Detail :: " + stackTraceToString(e));
/* 134 */       m_errorFlag = true;
/* 135 */       throw new Exception("Error connecting CMSDK server. Ifs Error Detail :: " + stackTraceToString(e));
/*     */     } catch (IOException ex) {
/* 137 */       m_message = ex.getMessage();
/* 138 */       _QFEQLogger.info("Error connecting CMSDK server. IO Error Detail :: " + stackTraceToString(ex));
/* 139 */       m_errorFlag = true;
/* 140 */       throw new Exception("Error connecting CMSDK server. IO Error Detail :: " + stackTraceToString(ex));
/*     */     }
/* 142 */     _QFEQLogger.info("Exiting " + METHOD_NAME);
/* 143 */     return lsession;
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
/*     */   public boolean updateLobster(String p_filePath, String p_fileName, Connection p_conn, String p_destFilePath, String d_flag)
/*     */     throws IfsException, IOException, Exception
/*     */   {
/* 164 */     String METHOD_NAME = CLASS_NAME + ".UpdateLobster";
/* 165 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/*     */ 
/*     */ 
/* 169 */     IfsFileSystem ifs = new IfsFileSystem(m_session);
/* 170 */     BufferedInputStream content = null;
/*     */     
/*     */ 
/*     */ 
/* 174 */     PublicObject po = null;
/*     */     try {
/* 176 */       po = ifs.findPublicObjectByPath(p_filePath + "/" + p_fileName);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 181 */       content = getDocumentContent(p_filePath, p_fileName);
/*     */     } catch (IfsException fex) {
/* 183 */       po = null;
/*     */       
/* 185 */       _QFEQLogger.info("Can't find this file. " + p_fileName + " in " + p_filePath);
/* 186 */       p_filePath = p_filePath.substring(0, p_filePath.lastIndexOf("/") + 1) + "error";
/* 187 */       _QFEQLogger.info("Looking file in " + p_filePath);
/* 188 */       po = ifs.findPublicObjectByPath(p_filePath + "/" + p_fileName);
/* 189 */       _QFEQLogger.info("File found!!");
/* 190 */       content = getDocumentContent(p_filePath, p_fileName);
/*     */     }
/* 192 */     if (content != null)
/*     */     {
/* 194 */       _QFEQLogger.info("*********** get contain*******************");
/* 195 */       FileOutputStream fos = new FileOutputStream(p_destFilePath + "/" + p_fileName);
/*     */       
/* 197 */       int size = 1024;
/* 198 */       byte[] buffer = new byte[size];
/* 199 */       int length = -1;
/*     */       
/* 201 */       while ((length = content.read(buffer)) != -1) {
/* 202 */         fos.write(buffer, 0, length);
/*     */       }
/* 204 */       fos.flush();
/* 205 */       fos.close();
/* 206 */       fos = null;
/*     */     }
/*     */     
/* 209 */     if (d_flag.equals("N")) {
/* 210 */       Process prc = null;
/* 211 */       String cmd = "dos2unix " + p_destFilePath + "/" + p_fileName;
/* 212 */       System.out.println("Trim command " + cmd);
/* 213 */       prc = Runtime.getRuntime().exec(cmd);
/*     */     }
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
/* 225 */     boolean bStatus = true;
/*     */     
/* 227 */     _QFEQLogger.info("Exiting " + METHOD_NAME);
/* 228 */     return bStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void moveObject(String p_fileName, String p_oldFolder, String p_newFolder, String p_overWrite)
/*     */     throws IfsException
/*     */   {
/* 241 */     String METHOD_NAME = CLASS_NAME + ".moveObject";
/* 242 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/* 244 */     _QFEQLogger.info("file to move: " + p_oldFolder + "/" + p_fileName);
/* 245 */     _QFEQLogger.info("new folder: " + p_newFolder);
/* 246 */     _QFEQLogger.info("old folder: " + p_oldFolder);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 252 */     boolean overwrite_flag = true;
/*     */     
/* 254 */     IfsFileSystem fs = new IfsFileSystem(m_session);
/*     */     PublicObject po;
/*     */     try
/*     */     {
/* 258 */       po = fs.findPublicObjectByPath(p_oldFolder + "/" + p_fileName);
/*     */     } catch (IfsException fex) {
/* 260 */       po = null;
/*     */       
/* 262 */       _QFEQLogger.info("Can't find this file. " + p_fileName + " in " + p_oldFolder);
/* 263 */       p_oldFolder = p_oldFolder.substring(0, p_oldFolder.lastIndexOf("/") + 1) + "error";
/* 264 */       _QFEQLogger.info("Looking file in " + p_oldFolder);
/* 265 */       po = fs.findPublicObjectByPath(p_oldFolder + "/" + p_fileName);
/* 266 */       _QFEQLogger.info("File found!!");
/*     */     }
/* 268 */     PublicObject nf = fs.findPublicObjectByPath(p_newFolder);
/* 269 */     PublicObject of = fs.findPublicObjectByPath(p_oldFolder);
/*     */     
/* 271 */     if (p_overWrite.equals("N"))
/*     */     {
/* 273 */       overwrite_flag = false;
/*     */     }
/*     */     
/* 276 */     if ((nf instanceof Folder & of instanceof Folder))
/*     */     {
/* 278 */       PublicObject copy = fs.move((Folder)of, (Folder)nf, po, null, null, overwrite_flag);
/* 279 */       m_message = (p_fileName + " moved to folder " + p_newFolder);
/*     */       
/* 281 */       m_errorFlag = false;
/*     */     }
/*     */     else {
/* 284 */       m_message = (p_newFolder + " or" + p_oldFolder + " is not a folder");
/* 285 */       m_errorFlag = true;
/*     */     }
/* 287 */     _QFEQLogger.info("Exiting " + METHOD_NAME);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void deleteObject(String p_file)
/*     */     throws IfsException
/*     */   {
/* 297 */     String METHOD_NAME = CLASS_NAME + ".deleteObject";
/* 298 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/* 300 */     _QFEQLogger.info("file to delete: " + p_file);
/*     */     
/*     */ 
/*     */ 
/* 304 */     IfsFileSystem fs = new IfsFileSystem(m_session);
/*     */     
/* 306 */     PublicObject po = fs.findPublicObjectByPath(p_file);
/*     */     
/*     */ 
/* 309 */     fs.delete(po);
/* 310 */     m_message = (p_file + " deleted.");
/* 311 */     m_errorFlag = false;
/*     */     
/* 313 */     _QFEQLogger.info("Exiting " + METHOD_NAME);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean getErrorFlag()
/*     */   {
/* 322 */     return m_errorFlag;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getMessage()
/*     */   {
/* 331 */     return m_message;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void disconnectSession()
/*     */     throws IfsException
/*     */   {
/* 340 */     if (m_session != null)
/*     */     {
/* 342 */       _QFEQLogger.info("About to disconnectSession");
/* 343 */       m_session.disconnect();
/* 344 */       m_session = null;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void disconnectService()
/*     */     throws IfsException
/*     */   {
/* 354 */     if (m_service != null)
/*     */     {
/* 356 */       m_service.dispose(m_ifsSysPwd);
/* 357 */       m_service = null;
/*     */     }
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
/*     */   public BufferedInputStream getDocumentContent(String p_filePath, String p_fileName)
/*     */     throws IfsException, IOException
/*     */   {
/* 372 */     String METHOD_NAME = CLASS_NAME + ".getDocumentContent";
/* 373 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/* 375 */     _QFEQLogger.info(p_filePath + "/" + p_fileName);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 380 */     IfsFileSystem ifs = new IfsFileSystem(m_session);
/*     */     
/* 382 */     Document doc = (Document)ifs.findPublicObjectByPath(p_filePath + "/" + p_fileName);
/* 383 */     BufferedInputStream bis = new BufferedInputStream(ifs.getDocumentContent(doc));
/*     */     
/* 385 */     _QFEQLogger.info("Exiting " + METHOD_NAME);
/* 386 */     return bis;
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
/*     */   public boolean createDocStream(String p_filePath, String p_fileName, InputStream p_contentStream)
/*     */     throws IfsException, IOException, Exception
/*     */   {
/* 401 */     String METHOD_NAME = CLASS_NAME + ".createDocStream";
/* 402 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/* 404 */     IfsFileSystem ifs = new IfsFileSystem(m_session);
/*     */     
/*     */ 
/* 407 */     PublicObject po = null;
/*     */     try {
/* 409 */       po = ifs.findPublicObjectByPath(p_filePath + "/" + p_fileName);
/*     */     } catch (IfsException fex) {
/* 411 */       po = null;
/*     */       
/* 413 */       _QFEQLogger.info("Can't find this file. " + p_fileName);
/*     */     }
/*     */     
/* 416 */     if (po != null) {
/*     */       try
/*     */       {
/* 419 */         ifs.delete(po);
/* 420 */         _QFEQLogger.info("Previous file deleted. " + p_fileName);
/*     */       } catch (IfsException fex) {
/* 422 */         _QFEQLogger.info("Can't delete this file! " + p_fileName);
/*     */       }
/*     */     }
/*     */     
/* 426 */     ifs.createDocument(p_fileName, p_contentStream, p_filePath, null, false, null);
/*     */     try
/*     */     {
/* 429 */       po = ifs.findPublicObjectByPath(p_filePath + "/" + p_fileName);
/* 430 */       _QFEQLogger.info("New file created. " + p_fileName);
/*     */     } catch (IfsException fex) {
/* 432 */       po = null;
/*     */       
/* 434 */       _QFEQLogger.severe("File not created. " + p_fileName);
/*     */     }
/*     */     
/* 437 */     Document doc = null;
/* 438 */     doc = (Document)po;
/*     */     
/* 440 */     if (doc.getContentSize() == 0L) {
/* 441 */       throw new Exception("Outbound file contains no data. File Name - " + p_fileName);
/*     */     }
/*     */     
/* 444 */     _QFEQLogger.info("Exiting " + METHOD_NAME);
/* 445 */     return true;
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
/*     */   public boolean delLobRef(Connection p_conn, String p_lobRef)
/*     */     throws IOException, SQLException
/*     */   {
/* 459 */     String METHOD_NAME = CLASS_NAME + ".delLobRef";
/* 460 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/* 462 */     boolean bStatus = false;
/*     */     
/*     */ 
/* 465 */     String sStmt = "{?=call QFEQIF_UTIL_PKG.DelLobster(?)}";
/*     */     
/*     */ 
/* 468 */     CallableStatement ocs = p_conn.prepareCall(sStmt);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 474 */     ocs.setString(2, p_lobRef);
/*     */     
/* 476 */     bStatus = ocs.execute();
/* 477 */     if (ocs.getInt(1) == 0)
/*     */     {
/* 479 */       _QFEQLogger.info(p_lobRef + " - lob removed.");
/*     */     }
/*     */     else
/*     */     {
/* 483 */       _QFEQLogger.info(p_lobRef + " - lob NOT removed.");
/*     */     }
/* 485 */     ocs.close();
/*     */     
/* 487 */     _QFEQLogger.info("Exiting " + METHOD_NAME);
/* 488 */     return bStatus;
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
/*     */   public boolean createDocRef(String p_filePath, String p_fileName, Connection p_conn, String localPath)
/*     */     throws Exception
/*     */   {
/* 503 */     String METHOD_NAME = CLASS_NAME + ".createDocRef";
/* 504 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/* 505 */     String FileGet = "" + localPath + "" + p_fileName;
/* 506 */     boolean bStatus = false;
/*     */     try {
/* 508 */       File file = new File(FileGet);
/* 509 */       FileInputStream fis = null;
/*     */       
/* 511 */       fis = new FileInputStream(file);
/* 512 */       createDocStream(p_filePath, p_fileName, fis);
/* 513 */       file.delete();
/* 514 */       bStatus = true;
/* 515 */       _QFEQLogger.info("Exiting " + METHOD_NAME);
/*     */     } catch (IfsException ifex) {
/* 517 */       throw new Exception("Error creating document in CM SDK.");
/*     */     } catch (IOException ioex) {
/* 519 */       throw new Exception("Error reading file from local folder.");
/*     */     }
/* 521 */     return bStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isValid()
/*     */   {
/* 532 */     return m_session != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean detach(Rfc822Message p_msg, String p_targetFolder)
/*     */   {
/* 543 */     String METHOD_NAME = CLASS_NAME + ".detach";
/* 544 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/* 546 */     boolean hasParts = false;
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 551 */       BodyPart multipart = p_msg.getBodyPart();
/*     */       
/* 553 */       Vector parts = multipart.getSubParts();
/*     */       
/*     */ 
/* 556 */       if (parts != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 561 */         boolean hasAttachment = false;
/*     */         
/*     */ 
/* 564 */         int i = 0; BodyPart part; Dictionary hdict; Enumeration enumkey; for (int n = parts.size(); i < n; i++)
/*     */         {
/* 566 */           part = (BodyPart)parts.elementAt(i);
/* 567 */           _QFEQLogger.info("Part name: " + part.getName());
/* 568 */           hasParts = true;
/*     */           
/* 570 */           hdict = part.getHeaderDictionary();
/*     */           
/*     */ 
/* 573 */           for (enumkey = hdict.keys(); enumkey.hasMoreElements();)
/*     */           {
/*     */ 
/* 576 */             String key = (String)enumkey.nextElement();
/*     */             
/* 578 */             String param = (String)hdict.get(key);
/* 579 */             _QFEQLogger.info(key + ":" + param);
/*     */             
/* 581 */             key = key.trim();
/* 582 */             if (key.equalsIgnoreCase("CONTENT-DISPOSITION"))
/*     */             {
/* 584 */               String fname = null;
/* 585 */               hasAttachment = false;
/* 586 */               StringTokenizer tokens = new StringTokenizer(param, ";");
/* 587 */               while (tokens.hasMoreTokens())
/*     */               {
/* 589 */                 String disposition = tokens.nextToken().trim().toUpperCase();
/* 590 */                 _QFEQLogger.info("Param: " + disposition);
/*     */                 
/* 592 */                 if ((disposition.equals("ATTACHMENT")) || (disposition.equals("INLINE")))
/*     */                 {
/* 594 */                   hasAttachment = true;
/*     */                 }
/* 596 */                 int pos = disposition.indexOf("FILENAME");
/* 597 */                 if (pos > -1)
/*     */                 {
/* 599 */                   StringTokenizer nameTokens = new StringTokenizer(disposition, "=");
/* 600 */                   while (nameTokens.hasMoreTokens())
/*     */                   {
/* 602 */                     String str = nameTokens.nextToken().trim().toUpperCase();
/* 603 */                     _QFEQLogger.info("Disposition param: " + str);
/* 604 */                     if ((str.equals("FILENAME")) && 
/*     */                     
/*     */ 
/* 607 */                       (nameTokens.hasMoreTokens()))
/*     */                     {
/* 609 */                       fname = nameTokens.nextToken();
/*     */                       
/*     */ 
/* 612 */                       pos = fname.indexOf("\"");
/* 613 */                       if (pos > -1)
/*     */                       {
/* 615 */                         fname = fname.substring(1, fname.length() - 1);
/*     */                       }
/* 617 */                       _QFEQLogger.info("fname: " + fname);
/*     */                     }
/*     */                   }
/*     */                 }
/*     */                 
/*     */ 
/*     */ 
/* 624 */                 if (fname != null) {
/*     */                   break;
/*     */                 }
/*     */               }
/*     */               
/* 629 */               if ((hasAttachment) && (fname != null))
/*     */               {
/* 631 */                 createDocStream(p_targetFolder, fname, part.getCleartextBodyStream());
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
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
/* 648 */       if ((!hasParts) && (multipart != null))
/*     */       {
/* 650 */         createDocStream(p_targetFolder, multipart.getName(), multipart.getCleartextBodyStream());
/* 651 */         _QFEQLogger.info("No bodyparts in email. Created file: " + multipart.getName());
/*     */       }
/*     */     } catch (Exception ex) {
/* 654 */       _QFEQLogger.info(ex.toString());
/* 655 */       return false;
/*     */     }
/* 657 */     _QFEQLogger.info("Exiting " + METHOD_NAME);
/* 658 */     return true;
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
/*     */   public byte[] getLobContent(Connection p_conn, String p_lobRef)
/*     */     throws IfsException, IOException, SQLException
/*     */   {
/* 672 */     String METHOD_NAME = CLASS_NAME + ".getLobContent";
/* 673 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/* 675 */     byte[] lobContent = null;
/* 676 */     boolean bStatus = false;
/*     */     
/*     */ 
/*     */ 
/* 680 */     String sStmt = "{?=call GetLobster(?, ?)}";
/*     */     
/* 682 */     CallableStatement ocs = p_conn.prepareCall(sStmt);
/* 683 */     ocs.registerOutParameter(1, 4);
/* 684 */     ocs.registerOutParameter(3, 2005);
/*     */     
/*     */ 
/* 687 */     ocs.setString(2, p_lobRef);
/*     */     
/* 689 */     ocs.execute();
/* 690 */     if (ocs.getInt(1) == 0)
/*     */     {
/* 692 */       CLOB clob = (CLOB)ocs.getClob(3);
/*     */       
/*     */       try
/*     */       {
/* 696 */         Long lob_len = new Long(clob.length());
/* 697 */         lobContent = new byte[lob_len.intValue()];
/*     */         
/*     */ 
/*     */ 
/* 701 */         InputStream lobInstream = clob.getAsciiStream();
/*     */         
/*     */ 
/* 704 */         int size = clob.getBufferSize();
/*     */         
/* 706 */         byte[] buffer = new byte[size];
/* 707 */         int length = -1;
/* 708 */         int i = 0;
/* 709 */         int lob_size = 0;
/*     */         
/* 711 */         while ((length = lobInstream.read(buffer)) != -1)
/*     */         {
/* 713 */           for (i = 0; i < length; lob_size++) {
/* 714 */             lobContent[lob_size] = buffer[i];i++;
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 721 */         lobInstream.close();
/*     */       }
/*     */       catch (Exception ex) {
/* 724 */         _QFEQLogger.info("Exception-Getting clob content.");
/* 725 */         ex.printStackTrace();
/*     */       }
/* 727 */       bStatus = true;
/*     */     }
/* 729 */     ocs.close();
/*     */     
/* 731 */     _QFEQLogger.info("Exiting " + METHOD_NAME);
/* 732 */     return lobContent;
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
/*     */   public boolean processStuckEmails(String p_basePath, String p_targetFolder)
/*     */     throws IfsException
/*     */   {
/* 747 */     String METHOD_NAME = CLASS_NAME + ".processStuckEmails";
/* 748 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 754 */     boolean overwrite_flag = true;
/* 755 */     PublicObject currentEmail = null;
/*     */     
/*     */     try
/*     */     {
/* 759 */       String srcPathFile = p_basePath + "/mail/inbox";
/* 760 */       String targetPath = p_basePath + "/" + p_targetFolder;
/* 761 */       String archivePath = p_basePath + "/archive";
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 767 */       IfsFileSystem fs = new IfsFileSystem(m_session);
/* 768 */       PublicObject srcFolder = fs.findPublicObjectByPath(srcPathFile);
/* 769 */       PublicObject[] emails = fs.listFolder((Folder)srcFolder, null);
/*     */       
/* 771 */       if (emails != null)
/*     */       {
/* 773 */         for (int i = 0; i < emails.length; i++)
/*     */         {
/* 775 */           currentEmail = emails[i];
/*     */           
/*     */ 
/* 778 */           if ((currentEmail instanceof Rfc822Message))
/*     */           {
/* 780 */             if (detach((Rfc822Message)currentEmail, targetPath))
/*     */             {
/* 782 */               _QFEQLogger.info("Email processed: " + currentEmail.getName());
/*     */               
/*     */ 
/* 785 */               PublicObject of = fs.findPublicObjectByPath(srcPathFile);
/* 786 */               PublicObject nf = fs.findPublicObjectByPath(archivePath);
/*     */               PublicObject copy;
/* 788 */               if ((nf instanceof Folder & of instanceof Folder))
/*     */               {
/*     */ 
/* 791 */                 copy = fs.move((Folder)of, (Folder)nf, currentEmail, ((Rfc822Message)currentEmail).generateFilename() + "_ORIG", null, true);
/*     */ 
/*     */               }
/*     */               else
/*     */               {
/* 796 */                 _QFEQLogger.info(srcPathFile + " and/or " + targetPath + " is not a folder! ");
/*     */               }
/*     */               
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 806 */       return false;
/*     */     }
/* 808 */     _QFEQLogger.info("Exiting " + METHOD_NAME);
/* 809 */     return true;
/*     */   }
/*     */   
/*     */   public static String stackTraceToString(Throwable e)
/*     */   {
/* 814 */     Writer writer = new StringWriter();
/* 815 */     PrintWriter printWriter = new PrintWriter(writer);
/* 816 */     e.printStackTrace(printWriter);
/* 817 */     String s = writer.toString();
/* 818 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/* 831 */       DriverManager.registerDriver(new OracleDriver());
/*     */       
/* 833 */       Connection conn = DriverManager.getConnection("jdbc:oracle:oci8:@IASDB1.QANTAS.COM.AU", "eqfiles", "xxx");
/* 834 */       QFEQIFCMSDKUtilSOA util = new QFEQIFCMSDKUtilSOA();
/* 835 */       byte[] content = util.getLobContent(conn, "3137");
/*     */       
/* 837 */       _QFEQLogger.info("content: " + new String(content));
/*     */       
/* 839 */       conn.close();
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 843 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean moveDocument(String p_filePath, String p_fileName) throws IfsException {
/* 848 */     String METHOD_NAME = CLASS_NAME + ".moveDocument";
/* 849 */     boolean resultOut = true;
/*     */     
/* 851 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/* 853 */     IfsFileSystem ifs = new IfsFileSystem(m_session);
/*     */     
/*     */ 
/* 856 */     PublicObject po = null;
/*     */     try {
/* 858 */       po = ifs.findPublicObjectByPath(p_filePath + "/" + p_fileName);
/*     */     } catch (IfsException fex) {
/* 860 */       po = null;
/*     */       
/* 862 */       _QFEQLogger.info("Can't find this file. " + p_fileName);
/*     */     }
/*     */     
/* 865 */     if (po != null) {
/*     */       try
/*     */       {
/* 868 */         ifs.delete(po);
/* 869 */         _QFEQLogger.info("Previous file deleted. " + p_fileName);
/*     */       } catch (IfsException fex) {
/* 871 */         _QFEQLogger.info("Can't delete this file! " + p_fileName);
/*     */       }
/*     */     }
/* 874 */     return resultOut;
/*     */   }
/*     */ }

/* Location:           D:\Workspace\QantasIHubServices\ImportedClasses
 * Qualified Name:     qantas.eq.integration.util.QFEQIFCMSDKUtilSOA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */