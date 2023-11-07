/*    */ package com.qantas.eq.data;
/*    */ 
/*    */ import java.util.Hashtable;
/*    */ import java.util.logging.FileHandler;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import java.util.logging.SimpleFormatter;
/*    */ 
/*    */ public class LoggerWrapper {
/* 10 */   private static String LOG_FILE_NAME = "QFEQEbsPoll.log";
/*    */   
/* 11 */   private static Hashtable<String, Logger> loggers = new Hashtable<String, Logger>();
/*    */   
/* 12 */   private static FileHandler handler = null;
/*    */   
/*    */   public static Logger getLogger(String loggerName) {
/*    */     try {
/* 16 */       if (loggers.get(loggerName) != null)
/* 17 */         return loggers.get(loggerName); 
/* 19 */       if (handler == null) {
/* 20 */         boolean append = true;
/* 21 */         handler = new FileHandler(System.getenv("QFEQIF_LOG_FILE") + "/" + LOG_FILE_NAME, append);
/* 22 */         handler.setFormatter(new SimpleFormatter());
/*    */       } 
/* 25 */     } catch (Exception e) {
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


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\data\LoggerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */