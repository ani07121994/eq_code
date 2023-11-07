/*    */ package com.qantas.eq.servlet.listener;
/*    */ 
/*    */ import com.qantas.eq.scheduler.QFEQScheduler;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.ServletContextEvent;
/*    */ import javax.servlet.ServletContextListener;
/*    */ 
/*    */ public class QFEQPollListener implements ServletContextListener {
/* 10 */   private ServletContext context = null;
/*    */   
/*    */   public void contextInitialized(ServletContextEvent event) {
/* 13 */     this.context = event.getServletContext();
/*    */   }
/*    */   
/*    */   public void contextDestroyed(ServletContextEvent event) {
/* 17 */     this.context = event.getServletContext();
/* 18 */     QFEQScheduler scheduler = QFEQScheduler.getInstance();
/* 19 */     scheduler.stopPolling();
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\servlet\listener\QFEQPollListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */