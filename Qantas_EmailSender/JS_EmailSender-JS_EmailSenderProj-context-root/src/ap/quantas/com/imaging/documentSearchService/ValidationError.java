/*     */ package ap.quantas.com.imaging.documentSearchService;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "validationError", propOrder = {"validationCode", "validationLabel", "validationMessage", "localizedValidationMessage", "subCode"})
/*     */ public class ValidationError {
/*     */   protected String validationCode;
/*     */   
/*     */   protected String validationLabel;
/*     */   
/*     */   protected String validationMessage;
/*     */   
/*     */   protected String localizedValidationMessage;
/*     */   
/*     */   protected String subCode;
/*     */   
/*     */   public String getValidationCode() {
/*  57 */     return this.validationCode;
/*     */   }
/*     */   
/*     */   public void setValidationCode(String value) {
/*  69 */     this.validationCode = value;
/*     */   }
/*     */   
/*     */   public String getValidationLabel() {
/*  81 */     return this.validationLabel;
/*     */   }
/*     */   
/*     */   public void setValidationLabel(String value) {
/*  93 */     this.validationLabel = value;
/*     */   }
/*     */   
/*     */   public String getValidationMessage() {
/* 105 */     return this.validationMessage;
/*     */   }
/*     */   
/*     */   public void setValidationMessage(String value) {
/* 117 */     this.validationMessage = value;
/*     */   }
/*     */   
/*     */   public String getLocalizedValidationMessage() {
/* 129 */     return this.localizedValidationMessage;
/*     */   }
/*     */   
/*     */   public void setLocalizedValidationMessage(String value) {
/* 141 */     this.localizedValidationMessage = value;
/*     */   }
/*     */   
/*     */   public String getSubCode() {
/* 153 */     return this.subCode;
/*     */   }
/*     */   
/*     */   public void setSubCode(String value) {
/* 165 */     this.subCode = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\ValidationError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */