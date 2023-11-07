/*    */ package com.qantas.eq.scheduler;
/*    */ 
/*    */ import com.qantas.eq.data.QFEQIFReadAQ;
/*    */ import java.util.TimerTask;
/*    */ 
/*    */ public class QFEQTask extends TimerTask {
/*    */   public void run() {
/* 14 */     QFEQIFReadAQ.AQObjectPayloadRead();
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\scheduler\QFEQTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */