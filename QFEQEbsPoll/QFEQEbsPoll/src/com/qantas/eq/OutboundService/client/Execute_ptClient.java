/*    */ package com.qantas.eq.OutboundService.client;
/*    */ 
/*    */ import com.qantas.eq.OutboundService.client.Execute_ptt;
/*    */ import com.qantas.eq.OutboundService.client.QFEQ_Outbound_WF015Service;
/*    */ import javax.xml.ws.WebServiceRef;
/*    */ 
/*    */ public class Execute_ptClient {
/*    */   @WebServiceRef
/*    */   private static QFEQ_Outbound_WF015Service qFEQ_Outbound_WF015Service;
/*    */   
/*    */   public static void main(String[] args) {
/* 17 */     qFEQ_Outbound_WF015Service = new QFEQ_Outbound_WF015Service();
/* 18 */     Execute_ptt execute_ptt = qFEQ_Outbound_WF015Service.getExecute_pt();
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\OutboundService\client\Execute_ptClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */