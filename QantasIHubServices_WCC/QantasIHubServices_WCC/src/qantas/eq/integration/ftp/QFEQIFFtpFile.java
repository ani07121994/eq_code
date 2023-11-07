/*     */ package qantas.eq.integration.ftp;
/*     */ 
/*     */ import java.util.logging.Logger;
/*     */ import javax.jws.WebMethod;
/*     */ import javax.jws.WebParam;
/*     */ import javax.jws.WebService;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @WebService(serviceName="SendFileToFTP")
/*     */ public class QFEQIFFtpFile
/*     */   extends QFEQIFWorkflowBase
/*     */   implements QFEQIFBase
/*     */ {
/*     */   public static QFEQIFFtpFile instance;
/*  30 */   private static Logger _QFEQLogger = QFEQIFLogger.getLogger(QFEQIFFtpFile.class.getName());
/*  31 */   private final String CLASS_NAME = getClass().getName();
/*     */   
/*     */   private static String resultOut;
/*     */   
/*     */   @WebMethod(exclude=true)
/*     */   public static QFEQIFFtpFile getInstance()
/*     */   {
/*  38 */     if (instance == null) {
/*  39 */       synchronized (QFEQIFFtpFile.class) {
/*  40 */         if (instance == null) {
/*  41 */           return new QFEQIFFtpFile();
/*     */         }
/*     */       }
/*     */     }
/*  45 */     _QFEQLogger.info("Got instance!!");
/*  46 */     return instance;
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
/*     */ 
/*     */ 
/*     */   @WebMethod(operationName="Execute")
/*     */   public boolean FTPSendFile(@WebParam(name="FILE_NAME") String FILE_NAME, @WebParam(name="SOURCE_FOLDER") String SOURCE_FOLDER, @WebParam(name="FTP_HOST") String FTP_HOST, @WebParam(name="FTP_PORT") int FTP_PORT, @WebParam(name="FTP_USER") String FTP_USER, @WebParam(name="FTP_PWD") String FTP_PWD, @WebParam(name="FTP_PATH") String FTP_PATH, @WebParam(name="FTP_FILENAME") String FTP_FILENAME, @WebParam(name="FTP_MODE") String FTP_MODE, @WebParam(name="FTP_ATTRIB1") String FTP_ATTRIB1, @WebParam(name="FTP_ATTRIB2") String FTP_ATTRIB2,@WebParam(name="IFID") String IFID)//923018- Error file movement from error to original folder- Start -08-11-21
/*     */     throws Exception
/*     */   {
/*  76 */     String METHOD_NAME = CLASS_NAME + ".FTPSendFile";
/*     */     
/*  78 */     _QFEQLogger.info(FILE_NAME+" Entering FTPSendFile " + METHOD_NAME);

/*     */     
/*  80 */     QFEQIFFtpIHub FtpFile = QFEQIFFtpIHub.getInstance();
/*  81 */     //boolean rval = FtpFile.execute(FILE_NAME, SOURCE_FOLDER, IFS_ADMIN_USER, IFS_ADMIN_PWD, IFS_SERVICE, IFS_SYS_PWD, FTP_HOST.trim(), String.valueOf(FTP_PORT).trim(), FTP_USER.trim(), FTP_PWD.trim(), FTP_PATH.trim(), FTP_FILENAME.trim(), FTP_ATTRIB1.trim(), FTP_ATTRIB2, FTP_MODE);
/*     */     boolean rval = FtpFile.execute(FILE_NAME, SOURCE_FOLDER, FTP_HOST.trim(), String.valueOf(FTP_PORT).trim(), FTP_USER.trim(), FTP_PWD.trim(), FTP_PATH.trim(), FTP_FILENAME.trim(), FTP_ATTRIB1.trim(), FTP_ATTRIB2, FTP_MODE,IFID);//923018- Error file movement from error to original folder- Start -08-11-21
/*     */ 	  _QFEQLogger.info(FILE_NAME+" FTPSendFile :: rval" + rval);
/*  84 */     return rval;
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
/*     */   private static String stackTraceToString(Throwable e)
/*     */   {
/* 254 */     StringBuilder sb = new StringBuilder();
/* 255 */     for (StackTraceElement element : e.getStackTrace()) {
/* 256 */       sb.append(element.toString());
/* 257 */       sb.append("\n");
/*     */     }
/* 259 */     return sb.toString();
/*     */   }
/*     */ }

/* Location:           D:\Workspace\QantasIHubServices\ImportedClasses
 * Qualified Name:     qantas.eq.integration.ftp.QFEQIFFtpFile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */