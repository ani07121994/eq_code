/*     */ package qantas.eq.integration.util;
/*     */ 
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class QFEQIFLogMgr {
/*     */   private static qantas.eq.integration.util.QFEQIFLogMgr s_logMgrInstance;
/*     */   
/*     */   public static final String ENTRY_DATE_FORMAT = "[dd/MM/yyyy HH:mm:ss]";
/*     */   
/*     */   private PrintWriter m_logFile;
/*     */   
/*     */   private boolean m_traceOn = true;
/*     */   
/*     */   public static qantas.eq.integration.util.QFEQIFLogMgr instance() {
/*  67 */     System.out.println("In QFEQIFLogMgr.instance()");
/*  68 */     if (s_logMgrInstance == null)
/*  74 */       synchronized (qantas.eq.integration.util.QFEQIFLogMgr.class) {
/*  76 */         if (s_logMgrInstance == null) {
/*  78 */           s_logMgrInstance = new qantas.eq.integration.util.QFEQIFLogMgr();
/*  81 */           String logFileName = "/u03/SOA/QFEQIF_LOG_FILE/qfeqif_log_file.log";
/*  84 */           if (logFileName == null) {
/*  86 */             s_logMgrInstance.open();
/*  88 */           } else if (logFileName.trim().equals("")) {
/*  90 */             s_logMgrInstance.open();
/*     */           } else {
/*  94 */             DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/*  96 */             Date date = new Date();
/*  97 */             s_logMgrInstance.open(logFileName + "/QFEQServices." + dateFormat.format(date) + ".log");
/*     */           } 
/*  99 */           s_logMgrInstance.trace("Got an instance of QFEQIFLogMgr");
/*     */         } 
/*     */       }  
/* 116 */     return s_logMgrInstance;
/*     */   }
/*     */   
/*     */   public static void kill() {
/* 125 */     if (s_logMgrInstance != null) {
/* 127 */       s_logMgrInstance.close();
/* 128 */       s_logMgrInstance = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getLogEntryHeader() {
/* 139 */     return "[" + Thread.currentThread().getThreadGroup().getName() + "]" + "[" + Thread.currentThread().getName() + "]";
/*     */   }
/*     */   
/*     */   public void trace(String p_text) {
/* 151 */     System.out.println("m_traceOn >> " + this.m_traceOn);
/* 152 */     System.out.println(this.m_logFile.toString());
/* 153 */     if (this.m_logFile != null && this.m_traceOn) {
/* 155 */       System.out.println("In trace...");
/* 156 */       SimpleDateFormat dfSimple = new SimpleDateFormat();
/* 157 */       dfSimple.applyPattern("[dd/MM/yyyy HH:mm:ss]");
/* 159 */       Date dCurrentDate = new Date();
/* 161 */       dCurrentDate.setTime(System.currentTimeMillis());
/* 163 */       String sDateString = dfSimple.format(dCurrentDate).toString();
/* 164 */       System.out.println("Printing...");
/* 165 */       this.m_logFile.println(sDateString + getLogEntryHeader() + p_text);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void open(String p_fileName) {
/* 179 */     System.out.println("In open log file");
/*     */     try {
/* 181 */       this.m_logFile = new PrintWriter(new FileOutputStream(p_fileName, true), true);
/* 182 */       System.out.println("m_logFile opened...");
/* 183 */       trace("Log mgr file opened");
/* 185 */     } catch (IOException ex) {
/* 187 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void open() {
/*     */     try {
/* 199 */       System.out.println("Log file not specified. Will use Standard output.");
/* 200 */       this.m_logFile = new PrintWriter(System.out, true);
/* 201 */       trace("Log mgr file opened");
/* 203 */     } catch (Exception ex) {
/* 205 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void close() {
/* 217 */     this.m_logFile = null;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\non_prodwars\QantasIHubCryptoLargeFile.war!\WEB-INF\classes\qantas\eq\integratio\\util\QFEQIFLogMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */