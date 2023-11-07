/*    */ package com.qantas.eq.scheduler;
/*    */ 
/*    */ import com.qantas.eq.scheduler.QFEQTask;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.util.Properties;
/*    */ import java.util.Timer;
/*    */ import java.util.TimerTask;
/*    */ import org.apache.log4j.PropertyConfigurator;
/*    */ 
/*    */ public class QFEQScheduler {
/* 12 */   private static final com.qantas.eq.scheduler.QFEQScheduler instance = new com.qantas.eq.scheduler.QFEQScheduler();
/*    */   
/* 13 */   private static Properties eQIhubProperty = new Properties();
/*    */   
/* 14 */   private static long defaultScheduleDelay = 0L;
/*    */   
/*    */   private Timer timer;
/*    */   
/* 17 */   static QFEQTask task = null;
/*    */   
/*    */   public static com.qantas.eq.scheduler.QFEQScheduler getInstance() {
/*    */     try {
/* 21 */       eQIhubProperty.load(new FileInputStream(System.getenv("QFEQIF_CONFIG")));
/* 22 */       defaultScheduleDelay = Long.parseLong(eQIhubProperty.getProperty("EBS_POLLING_INTERVAL"));
/* 23 */     } catch (Exception e) {
/* 24 */       System.out.println("Error setting Log file location: ");
/* 25 */       e.printStackTrace();
/*    */     } 
/* 27 */     return instance;
/*    */   }
/*    */   
/*    */   protected QFEQScheduler() {
/* 31 */     this.timer = new Timer(true);
/*    */   }
/*    */   
/*    */   public void startPolling() {
/*    */     try {
/* 36 */       String value = System.getenv("QFEQIF_LOG_FILE");
/* 37 */       InputStream is = com.qantas.eq.scheduler.QFEQScheduler.class.getClassLoader().getResourceAsStream("log4j.properties");
/* 38 */       Properties prop = new Properties();
/* 39 */       prop.load(is);
/* 40 */       prop.put("QFEQIF_LOG_FILE", value);
/* 41 */       PropertyConfigurator.configure(prop);
/* 43 */       task = new QFEQTask();
/* 45 */       this.timer.schedule((TimerTask)task, 5000L, defaultScheduleDelay);
/* 47 */     } catch (Exception e) {
/* 48 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void stopPolling() {
/* 54 */     if (task != null)
/* 55 */       task.cancel(); 
/* 57 */     System.out.println("Polling stopped by user");
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\scheduler\QFEQScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */