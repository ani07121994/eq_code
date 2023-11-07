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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @WebService(serviceName="CreateFileInCMSDK")
/*     */ public class QFEQIFCreateFileCMSDK
/*     */   implements QFEQIFBase
/*     */ {
/*  23 */   private final String CLASS_NAME = getClass().getName();
/*  24 */   private static Logger _QFEQLogger = Logger.getLogger(QFEQIFCreateFileCMSDK.class.getName());
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
/*     */   @WebMethod
/*     */   public boolean createDocRef(@WebParam(name="filePath") String p_filePath, @WebParam(name="fileName") String p_fileName, @WebParam(name="localPath") String localPath, @WebParam(name="enc_flag") String e_flag, @WebParam(name="ifsAdminUser") String ifsAdminUser, @WebParam(name="ifsAdminPwd") String ifsAdminPwd, @WebParam(name="ifsService") String ifsService, @WebParam(name="ifsSysPwd") String ifsSysPwd)
/*     */     throws Exception
/*     */   {
/*  77 */     String METHOD_NAME = CLASS_NAME + ".createDocRef";
/*  78 */     _QFEQLogger.info("Entering " + METHOD_NAME);
/*     */     
/*  80 */     String FileGet = "";
/*  81 */     QFEQIFCMSDKUtilSOA _CMSDKUtil = null;
/*     */     
/*     */ 
/*     */ 
/*  85 */     if (localPath.endsWith("/")) {
/*  86 */       FileGet = localPath + p_fileName;
/*     */     } else {
/*  88 */       FileGet = localPath + "/" + p_fileName;
/*     */     }
/*     */     
/*  91 */     _QFEQLogger.info("File Path :: " + FileGet);
/*     */     
/*  93 */     boolean bStatus = false;
/*     */     try {
/*  95 */       File file = new File(FileGet);
/*  96 */       FileInputStream fis = null;
/*     */       
/*  98 */       fis = new FileInputStream(file);
/*  99 */       Connection dbConn = QFEQIFDatabaseConn.getConnection();
/* 100 */       QFEQIFCryptoSOA crypto = new QFEQIFCryptoSOA(dbConn);
/* 101 */       _CMSDKUtil = new QFEQIFCMSDKUtilSOA(ifsAdminUser, crypto.decrypt(ifsAdminPwd), ifsService, crypto.decrypt(ifsSysPwd));
/*     */       
/* 103 */       _CMSDKUtil.createDocStream(p_filePath, p_fileName, fis);
/*     */       
/* 105 */       if (!e_flag.equals("Y")) {
/* 106 */         file.delete();
/*     */       }
/* 108 */       bStatus = true;
/* 109 */       _CMSDKUtil.disconnectSession();
/* 110 */       _QFEQLogger.info("Exiting " + METHOD_NAME);
/*     */     } catch (IfsException ifex) {
/* 112 */       if (_CMSDKUtil != null)
/*     */       {
/*     */         try
/*     */         {
/* 116 */           _CMSDKUtil.disconnectSession();
/* 117 */           _QFEQLogger.info("Disposed ifsService");
/*     */         }
/*     */         catch (IfsException ex)
/*     */         {
/* 121 */           _QFEQLogger.info("IfsException caught: " + ex.getMessage());
/*     */         }
/*     */       }
/* 124 */       _QFEQLogger.severe(QFEQIFCMSDKUtilSOA.stackTraceToString(ifex));
/* 125 */       throw new Exception("Error creating document in CM SDK." + QFEQIFCMSDKUtilSOA.stackTraceToString(ifex));
/*     */     } catch (IOException ioex) {
/* 127 */       _QFEQLogger.severe(QFEQIFCMSDKUtilSOA.stackTraceToString(ioex));
/* 128 */       throw new Exception("Error reading file from local folder. :: " + QFEQIFCMSDKUtilSOA.stackTraceToString(ioex));
/*     */     } finally {
/* 130 */       QFEQIFDatabaseConn.closeConnection();
/*     */     }
/* 132 */     return bStatus;
/*     */   }
/*     */ }

/* Location:           D:\Workspace\QantasIHubServices\ImportedClasses
 * Qualified Name:     qantas.eq.integration.util.QFEQIFCreateFileCMSDK
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */