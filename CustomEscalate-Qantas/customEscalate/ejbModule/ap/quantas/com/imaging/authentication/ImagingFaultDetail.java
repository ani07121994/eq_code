/*    */ package ap.quantas.com.imaging.authentication;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "ImagingFaultDetail", propOrder = {"errorCode", "errorMessage"})
/*    */ public class ImagingFaultDetail
/*    */ {
/*    */   protected String errorCode;
/*    */   protected String errorMessage;
/*    */   
/*    */   public String getErrorCode() {
/* 48 */     return this.errorCode;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setErrorCode(String value) {
/* 60 */     this.errorCode = value;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getErrorMessage() {
/* 72 */     return this.errorMessage;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setErrorMessage(String value) {
/* 84 */     this.errorMessage = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\authentication\ImagingFaultDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */