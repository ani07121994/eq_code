/*    */ package com.qantas.eq.servlet;
/*    */ 
/*    */ import com.qantas.eq.scheduler.QFEQScheduler;
/*    */ import javax.servlet.ServletConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ 
/*    */ public class QFEQIFPollServlet extends HttpServlet {
/*    */   private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
/*    */   
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void init(ServletConfig config) throws ServletException {
/* 17 */     super.init(config);
/* 19 */     QFEQScheduler scheduler = QFEQScheduler.getInstance();
/* 20 */     scheduler.startPolling();
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\servlet\QFEQIFPollServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */