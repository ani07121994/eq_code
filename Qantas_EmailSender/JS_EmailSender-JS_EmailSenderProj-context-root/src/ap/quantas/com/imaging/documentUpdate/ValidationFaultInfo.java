/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentUpdate.ImagingFaultInfo;
/*    */ import ap.quantas.com.imaging.documentUpdate.ValidationError;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "ValidationFaultInfo", propOrder = {"validationErrors"})
/*    */ public class ValidationFaultInfo extends ImagingFaultInfo {
/*    */   @XmlElement(nillable = true)
/*    */   protected List<ValidationError> validationErrors;
/*    */   
/*    */   public List<ValidationError> getValidationErrors() {
/* 65 */     if (this.validationErrors == null)
/* 66 */       this.validationErrors = new ArrayList<ValidationError>(); 
/* 68 */     return this.validationErrors;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\ValidationFaultInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */