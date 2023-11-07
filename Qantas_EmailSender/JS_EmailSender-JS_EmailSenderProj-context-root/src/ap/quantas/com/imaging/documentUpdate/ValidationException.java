/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentUpdate.ValidationFaultInfo;
/*    */ import javax.xml.ws.WebFault;
/*    */ 
/*    */ @WebFault(name = "ValidationException", targetNamespace = "http://imaging.oracle/")
/*    */ public class ValidationException extends Exception {
/*    */   private ValidationFaultInfo faultInfo;
/*    */   
/*    */   public ValidationException(String message, ValidationFaultInfo faultInfo) {
/* 30 */     super(message);
/* 31 */     this.faultInfo = faultInfo;
/*    */   }
/*    */   
/*    */   public ValidationException(String message, ValidationFaultInfo faultInfo, Throwable cause) {
/* 41 */     super(message, cause);
/* 42 */     this.faultInfo = faultInfo;
/*    */   }
/*    */   
/*    */   public ValidationFaultInfo getFaultInfo() {
/* 51 */     return this.faultInfo;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\ValidationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */