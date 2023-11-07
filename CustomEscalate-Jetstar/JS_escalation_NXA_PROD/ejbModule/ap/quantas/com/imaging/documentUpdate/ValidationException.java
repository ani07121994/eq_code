/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import javax.xml.ws.WebFault;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @WebFault(name = "ValidationException", targetNamespace = "http://imaging.oracle/")
/*    */ public class ValidationException
/*    */   extends Exception
/*    */ {
/*    */   private ValidationFaultInfo faultInfo;
/*    */   
/*    */   public ValidationException(String message, ValidationFaultInfo faultInfo) {
/* 30 */     super(message);
/* 31 */     this.faultInfo = faultInfo;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValidationException(String message, ValidationFaultInfo faultInfo, Throwable cause) {
/* 41 */     super(message, cause);
/* 42 */     this.faultInfo = faultInfo;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValidationFaultInfo getFaultInfo() {
/* 51 */     return this.faultInfo;
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\JS_escalation_NXA_PROD.jar!\ap\quantas\com\imaging\documentUpdate\ValidationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */