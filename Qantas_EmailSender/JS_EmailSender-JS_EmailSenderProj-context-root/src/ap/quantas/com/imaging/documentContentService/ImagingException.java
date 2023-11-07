/*    */ package ap.quantas.com.imaging.documentContentService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentContentService.ImagingFaultInfo;
/*    */ import javax.xml.ws.WebFault;
/*    */ 
/*    */ @WebFault(name = "ImagingException", targetNamespace = "http://imaging.oracle/")
/*    */ public class ImagingException extends Exception {
/*    */   private ImagingFaultInfo faultInfo;
/*    */   
/*    */   public ImagingException(String message, ImagingFaultInfo faultInfo) {
/* 30 */     super(message);
/* 31 */     this.faultInfo = faultInfo;
/*    */   }
/*    */   
/*    */   public ImagingException(String message, ImagingFaultInfo faultInfo, Throwable cause) {
/* 41 */     super(message, cause);
/* 42 */     this.faultInfo = faultInfo;
/*    */   }
/*    */   
/*    */   public ImagingFaultInfo getFaultInfo() {
/* 51 */     return this.faultInfo;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\ImagingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */