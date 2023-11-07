/*    */ package com.idservice.fault.mail;
/*    */ 
/*    */ import src.com.CommonNotification;
/*    */ import src.com.QantasCommonNotificationService;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MailSender
/*    */ {
/*    */   public static boolean sendMail(String toMailId, String mailBody, String mailSubject, String fromMailId) {
/* 13 */     boolean mailStatus = false;
/*    */     
/*    */     try {
/* 16 */       QantasCommonNotificationService notServ = new QantasCommonNotificationService();
/* 17 */       CommonNotification cmn = notServ.getCommonNotificationPort();
/* 18 */       cmn.commonNotificationDetails("", toMailId, mailBody.toString(), mailSubject, "", "", fromMailId);
/* 19 */       System.out.println("Mail Send Successfulyy");
/* 20 */       mailStatus = true;
/* 21 */     } catch (Exception e) {
/* 22 */       mailStatus = false;
/* 23 */       e.printStackTrace();
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 28 */     return mailStatus;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\IdeserviceFaultHandler.jar!\com\idservice\fault\mail\MailSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */