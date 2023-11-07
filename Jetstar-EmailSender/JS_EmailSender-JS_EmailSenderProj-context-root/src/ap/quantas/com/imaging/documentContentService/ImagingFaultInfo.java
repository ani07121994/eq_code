/*     */ package ap.quantas.com.imaging.documentContentService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentContentService.ImagingFaultType;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "ImagingFaultInfo", propOrder = {"exceptionCode", "exceptionLabel", "faultType", "stackTraceId", "faultDetails", "localizedErrorMessage"})
/*     */ public class ImagingFaultInfo {
/*     */   protected String exceptionCode;
/*     */   
/*     */   protected String exceptionLabel;
/*     */   
/*     */   protected ImagingFaultType faultType;
/*     */   
/*     */   protected String stackTraceId;
/*     */   
/*     */   protected FaultDetails faultDetails;
/*     */   
/*     */   protected String localizedErrorMessage;
/*     */   
/*     */   public String getExceptionCode() {
/*  72 */     return this.exceptionCode;
/*     */   }
/*     */   
/*     */   public void setExceptionCode(String value) {
/*  84 */     this.exceptionCode = value;
/*     */   }
/*     */   
/*     */   public String getExceptionLabel() {
/*  96 */     return this.exceptionLabel;
/*     */   }
/*     */   
/*     */   public void setExceptionLabel(String value) {
/* 108 */     this.exceptionLabel = value;
/*     */   }
/*     */   
/*     */   public ImagingFaultType getFaultType() {
/* 120 */     return this.faultType;
/*     */   }
/*     */   
/*     */   public void setFaultType(ImagingFaultType value) {
/* 132 */     this.faultType = value;
/*     */   }
/*     */   
/*     */   public String getStackTraceId() {
/* 144 */     return this.stackTraceId;
/*     */   }
/*     */   
/*     */   public void setStackTraceId(String value) {
/* 156 */     this.stackTraceId = value;
/*     */   }
/*     */   
/*     */   public FaultDetails getFaultDetails() {
/* 168 */     return this.faultDetails;
/*     */   }
/*     */   
/*     */   public void setFaultDetails(FaultDetails value) {
/* 180 */     this.faultDetails = value;
/*     */   }
/*     */   
/*     */   public String getLocalizedErrorMessage() {
/* 192 */     return this.localizedErrorMessage;
/*     */   }
/*     */   
/*     */   public void setLocalizedErrorMessage(String value) {
/* 204 */     this.localizedErrorMessage = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\ImagingFaultInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */