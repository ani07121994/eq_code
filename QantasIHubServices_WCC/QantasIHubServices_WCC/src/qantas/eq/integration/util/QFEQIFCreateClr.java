/*     */ package qantas.eq.integration.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.sql.Connection;
/*     */ import java.util.logging.Logger;
/*     */ import javax.jws.WebMethod;
/*     */ import javax.jws.WebParam;
/*     */ import javax.jws.WebService;
/*     */ import oracle.ifs.common.IfsException;
/*     */ import qantas.eq.integration.QFEQIFBase;
/*     */ import qantas.eq.integration.QFEQIFLogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @WebService
/*     */ public class QFEQIFCreateClr
/*     */   implements QFEQIFBase
/*     */ {
/*  24 */   private final String CLASS_NAME = getClass().getName();
/*  25 */   private static Logger _QFEQLogger = QFEQIFLogger.getLogger(QFEQIFCreateClr.class.getName());
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
/*     */   @WebMethod
/*     */   public boolean createClr(@WebParam(name="filePath") String p_filePath, @WebParam(name="fileName") String p_fileName, @WebParam(name="localPath") String localPath, @WebParam(name="del_flag") String e_flag, @WebParam(name="ifsAdminUser") String ifsAdminUser, @WebParam(name="ifsAdminPwd") String ifsAdminPwd, @WebParam(name="ifsService") String ifsService, @WebParam(name="ifsSysPwd") String ifsSysPwd, @WebParam(name="n_FileName") String n_fileName)
/*     */     throws Exception
/*     */   {
/*  50 */     String METHOD_NAME = CLASS_NAME + ".createDocRef";
/*  51 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/*  53 */     String FileGet = "";
/*  54 */     QFEQIFCMSDKUtilSOA _CMSDKUtil = null;
/*     */     
/*     */ 
/*     */ 
/*  58 */     if (localPath.endsWith("/")) {
/*  59 */       FileGet = localPath + p_fileName;
/*     */     } else {
/*  61 */       FileGet = localPath + "/" + p_fileName;
/*     */     }
/*     */     
/*  64 */     _QFEQLogger.info("File Path :: " + FileGet);
/*     */     
/*  66 */     boolean bStatus = false;
/*     */     try {
/*  68 */       File file = new File(FileGet);
/*  69 */       FileInputStream fis = null;
/*     */       
/*  71 */       fis = new FileInputStream(file);
/*  72 */       Connection dbConn = QFEQIFDatabaseConn.getConnection();
/*  73 */       QFEQIFCryptoSOA crypto = new QFEQIFCryptoSOA(dbConn);
/*  74 */       _CMSDKUtil = new QFEQIFCMSDKUtilSOA(ifsAdminUser, crypto.decrypt(ifsAdminPwd), ifsService, crypto.decrypt(ifsSysPwd));
/*     */       
/*  76 */       if (n_fileName != null) {
/*  77 */         if (!n_fileName.trim().equals("")) {
/*  78 */           bStatus = _CMSDKUtil.createDocStream(p_filePath, n_fileName, fis);
/*     */         } else {
/*  80 */           bStatus = _CMSDKUtil.createDocStream(p_filePath, p_fileName, fis);
/*     */         }
/*     */       } else {
/*  83 */         bStatus = _CMSDKUtil.createDocStream(p_filePath, p_fileName, fis);
/*     */       }
/*     */       
/*  86 */       if (e_flag.equals("Y")) {
/*  87 */         file.delete();
/*     */       }
/*  89 */       bStatus = true;
/*  90 */       _CMSDKUtil.disconnectSession();
/*  91 */       _QFEQLogger.info("Exiting " + METHOD_NAME);
/*     */     } catch (IfsException ifex) {
/*  93 */       if (_CMSDKUtil != null)
/*     */       {
/*     */         try
/*     */         {
/*  97 */           _CMSDKUtil.disconnectSession();
/*  98 */           _QFEQLogger.info("Disposed ifsService");
/*     */         }
/*     */         catch (IfsException ex)
/*     */         {
/* 102 */           _QFEQLogger.info("IfsException caught: " + ex.getMessage());
/*     */         }
/*     */       }
/* 105 */       _QFEQLogger.severe(QFEQIFCMSDKUtilSOA.stackTraceToString(ifex));
/* 106 */       throw new Exception("Error creating document in CM SDK." + QFEQIFCMSDKUtilSOA.stackTraceToString(ifex));
/*     */     }
/*     */     catch (IOException ioex) {
/* 109 */       _QFEQLogger.severe(QFEQIFCMSDKUtilSOA.stackTraceToString(ioex));
/* 110 */       throw new Exception("Error reading file from local folder. :: " + QFEQIFCMSDKUtilSOA.stackTraceToString(ioex));
/*     */     } finally {
/* 112 */       QFEQIFDatabaseConn.closeConnection();
/*     */     }
/* 114 */     return bStatus;
/*     */   }
/*     */ }

/* Location:           D:\Workspace\QantasIHubServices\ImportedClasses
 * Qualified Name:     qantas.eq.integration.util.QFEQIFCreateClr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */