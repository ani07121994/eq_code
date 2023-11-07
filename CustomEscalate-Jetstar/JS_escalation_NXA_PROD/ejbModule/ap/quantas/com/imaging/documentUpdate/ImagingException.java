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
/*    */ @WebFault(name = "ImagingException", targetNamespace = "http://imaging.oracle/")
/*    */ public class ImagingException
/*    */   extends Exception
/*    */ {
/*    */   private ImagingFaultInfo faultInfo;
/*    */   
/*    */   public ImagingException(String message, ImagingFaultInfo faultInfo) {
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
/*    */   public ImagingException(String message, ImagingFaultInfo faultInfo, Throwable cause) {
/* 41 */     super(message, cause);
/* 42 */     this.faultInfo = faultInfo;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ImagingFaultInfo getFaultInfo() {
/* 51 */     return this.faultInfo;
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\JS_escalation_NXA_PROD.jar!\ap\quantas\com\imaging\documentUpdate\ImagingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */