/*    */ package src.com;
/*    */ 
/*    */ import javax.xml.ws.WebServiceRef;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommonNotificationPortClient
/*    */ {
/*    */   @WebServiceRef
/*    */   private static QantasCommonNotificationService qantasCommonNotificationService;
/*    */   
/*    */   public static void main(String[] args) {
/* 17 */     qantasCommonNotificationService = new QantasCommonNotificationService();
/* 18 */     CommonNotification commonNotification = qantasCommonNotificationService.getCommonNotificationPort();
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\IdeserviceFaultHandler.jar!\src\com\CommonNotificationPortClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */