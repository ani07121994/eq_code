/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentUpdate.ImagingFaultType;
/*     */ import ap.quantas.com.imaging.documentUpdate.ValidationFaultInfo;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlSeeAlso;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "ImagingFaultInfo", propOrder = {"exceptionCode", "exceptionLabel", "faultType", "stackTraceId", "faultDetails", "localizedErrorMessage"})
/*     */ @XmlSeeAlso({ValidationFaultInfo.class})
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
/*  76 */     return this.exceptionCode;
/*     */   }
/*     */   
/*     */   public void setExceptionCode(String value) {
/*  88 */     this.exceptionCode = value;
/*     */   }
/*     */   
/*     */   public String getExceptionLabel() {
/* 100 */     return this.exceptionLabel;
/*     */   }
/*     */   
/*     */   public void setExceptionLabel(String value) {
/* 112 */     this.exceptionLabel = value;
/*     */   }
/*     */   
/*     */   public ImagingFaultType getFaultType() {
/* 124 */     return this.faultType;
/*     */   }
/*     */   
/*     */   public void setFaultType(ImagingFaultType value) {
/* 136 */     this.faultType = value;
/*     */   }
/*     */   
/*     */   public String getStackTraceId() {
/* 148 */     return this.stackTraceId;
/*     */   }
/*     */   
/*     */   public void setStackTraceId(String value) {
/* 160 */     this.stackTraceId = value;
/*     */   }
/*     */   
/*     */   public FaultDetails getFaultDetails() {
/* 172 */     return this.faultDetails;
/*     */   }
/*     */   
/*     */   public void setFaultDetails(FaultDetails value) {
/* 184 */     this.faultDetails = value;
/*     */   }
/*     */   
/*     */   public String getLocalizedErrorMessage() {
/* 196 */     return this.localizedErrorMessage;
/*     */   }
/*     */   
/*     */   public void setLocalizedErrorMessage(String value) {
/* 208 */     this.localizedErrorMessage = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\ImagingFaultInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */