/*     */ package ap.quantas.com.imaging.authentication;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "ImagingFaultInfo", propOrder = {"exceptionCode", "exceptionLabel", "faultType", "stackTraceId", "faultDetails", "localizedErrorMessage"})
/*     */ public class ImagingFaultInfo
/*     */ {
/*     */   protected String exceptionCode;
/*     */   protected String exceptionLabel;
/*     */   protected ImagingFaultType faultType;
/*     */   protected String stackTraceId;
/*     */   protected FaultDetails faultDetails;
/*     */   protected String localizedErrorMessage;
/*     */   
/*     */   public String getExceptionCode() {
/*  72 */     return this.exceptionCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExceptionCode(String value) {
/*  84 */     this.exceptionCode = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExceptionLabel() {
/*  96 */     return this.exceptionLabel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExceptionLabel(String value) {
/* 108 */     this.exceptionLabel = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ImagingFaultType getFaultType() {
/* 120 */     return this.faultType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFaultType(ImagingFaultType value) {
/* 132 */     this.faultType = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStackTraceId() {
/* 144 */     return this.stackTraceId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStackTraceId(String value) {
/* 156 */     this.stackTraceId = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FaultDetails getFaultDetails() {
/* 168 */     return this.faultDetails;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFaultDetails(FaultDetails value) {
/* 180 */     this.faultDetails = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocalizedErrorMessage() {
/* 192 */     return this.localizedErrorMessage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocalizedErrorMessage(String value) {
/* 204 */     this.localizedErrorMessage = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name = "", propOrder = {"faultDetail"})
/*     */   public static class FaultDetails
/*     */   {
/*     */     protected List<ImagingFaultDetail> faultDetail;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<ImagingFaultDetail> getFaultDetail() {
/* 258 */       if (this.faultDetail == null) {
/* 259 */         this.faultDetail = new ArrayList<ImagingFaultDetail>();
/*     */       }
/* 261 */       return this.faultDetail;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\authentication\ImagingFaultInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */