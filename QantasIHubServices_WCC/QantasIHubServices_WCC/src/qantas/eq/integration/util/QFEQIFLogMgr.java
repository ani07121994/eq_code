/*     */ package qantas.eq.integration.util;
/*     */ 
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QFEQIFLogMgr
/*     */ {
/*     */   private static QFEQIFLogMgr s_logMgrInstance;
/*     */   public static final String ENTRY_DATE_FORMAT = "[dd/MM/yyyy HH:mm:ss]";
/*     */   private PrintWriter m_logFile;
/*  48 */   private boolean m_traceOn = true;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static QFEQIFLogMgr instance()
/*     */   {
/*  67 */     System.out.println("In QFEQIFLogMgr.instance()");
/*  68 */     if (s_logMgrInstance == null)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  74 */       synchronized (QFEQIFLogMgr.class)
/*     */       {
/*  76 */         if (s_logMgrInstance == null)
/*     */         {
/*  78 */           s_logMgrInstance = new QFEQIFLogMgr();
/*     */           
/*     */ 
/*  81 */           String logFileName = "/home/applsoa/QFEQIF_LOG_FILE/qfeqif_log_file.log";
/*     */           
/*     */ 
/*  84 */           if (logFileName == null)
/*     */           {
/*  86 */             s_logMgrInstance.open();
/*     */           }
/*  88 */           else if (logFileName.trim().equals(""))
/*     */           {
/*  90 */             s_logMgrInstance.open();
/*     */           }
/*     */           else
/*     */           {
/*  94 */             DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/*     */             
/*  96 */             Date date = new Date();
/*  97 */             s_logMgrInstance.open(logFileName + "/QFEQServices." + dateFormat.format(date) + ".log");
/*     */           }
/*  99 */           s_logMgrInstance.trace("Got an instance of QFEQIFLogMgr");
/*     */         }
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/* 116 */     return s_logMgrInstance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void kill()
/*     */   {
/* 125 */     if (s_logMgrInstance != null)
/*     */     {
/* 127 */       s_logMgrInstance.close();
/* 128 */       s_logMgrInstance = null;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLogEntryHeader()
/*     */   {
/* 139 */     return "[" + Thread.currentThread().getThreadGroup().getName() + "]" + "[" + Thread.currentThread().getName() + "]";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void trace(String p_text)
/*     */   {
/* 151 */     System.out.println("m_traceOn >> " + m_traceOn);
/* 152 */     System.out.println(m_logFile.toString());
/* 153 */     if ((m_logFile != null) && (m_traceOn))
/*     */     {
/* 155 */       System.out.println("In trace...");
/* 156 */       SimpleDateFormat dfSimple = new SimpleDateFormat();
/* 157 */       dfSimple.applyPattern("[dd/MM/yyyy HH:mm:ss]");
/*     */       
/* 159 */       Date dCurrentDate = new Date();
/*     */       
/* 161 */       dCurrentDate.setTime(System.currentTimeMillis());
/*     */       
/* 163 */       String sDateString = dfSimple.format(dCurrentDate).toString();
/* 164 */       System.out.println("Printing...");
/* 165 */       m_logFile.println(sDateString + getLogEntryHeader() + p_text);
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
/*     */   private void open(String p_fileName)
/*     */   {
/* 179 */     System.out.println("In open log file");
/*     */     try {
/* 181 */       m_logFile = new PrintWriter(new FileOutputStream(p_fileName, true), true);
/* 182 */       System.out.println("m_logFile opened...");
/* 183 */       trace("Log mgr file opened");
/*     */     }
/*     */     catch (IOException ex)
/*     */     {
/* 187 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void open()
/*     */   {
/*     */     try
/*     */     {
/* 199 */       System.out.println("Log file not specified. Will use Standard output.");
/* 200 */       m_logFile = new PrintWriter(System.out, true);
/* 201 */       trace("Log mgr file opened");
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 205 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void close()
/*     */   {
/* 217 */     m_logFile = null;
/*     */   }
/*     */ }

/* Location:           D:\Workspace\QantasIHubServices\ImportedClasses
 * Qualified Name:     qantas.eq.integration.util.QFEQIFLogMgr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */