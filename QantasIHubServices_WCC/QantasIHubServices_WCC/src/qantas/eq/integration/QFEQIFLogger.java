/*    */ package qantas.eq.integration;
/*    */ 
/*    */ import java.util.Hashtable;
/*    */ import java.util.logging.FileHandler;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ 
/*    */ public class QFEQIFLogger
/*    */ {
/* 10 */   private static String LOG_FILE_NAME = "QFEQServices_wcc.log";
/* 11 */   private static Hashtable<String, Logger> loggers = new Hashtable();
/* 12 */   private static FileHandler handler = null;
/*    */   
/*    */   public static Logger getLogger(String loggerName) {
/*    */     try {
/* 16 */       if (loggers.get(loggerName) != null) {
/* 17 */         return (Logger)loggers.get(loggerName);
/*    */       }
/* 19 */       if (handler == null) {
/* 20 */         boolean append = true;
/* 21 */         handler = new FileHandler(System.getenv("QFEQIF_LOG_FILE") + "/" + LOG_FILE_NAME, append);
/* 22 */         handler.setFormatter(new java.util.logging.SimpleFormatter());
/*    */       }
/*    */     }
/*    */     catch (Exception e) {
/* 26 */       e.printStackTrace();
/*    */     }
/* 28 */     Logger logger = Logger.getLogger(loggerName);
/* 29 */     logger.setLevel(Level.ALL);
/* 30 */     logger.addHandler(handler);
/* 31 */     logger.setUseParentHandlers(false);
/* 32 */     loggers.put(loggerName, logger);
/* 33 */     return logger;
/*    */   }
/*    */ }

/* Location:           D:\Workspace\QantasIHubServices\ImportedClasses
 * Qualified Name:     qantas.eq.integration.QFEQIFLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */