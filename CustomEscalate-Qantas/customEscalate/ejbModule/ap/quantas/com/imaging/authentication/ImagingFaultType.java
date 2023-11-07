/*    */ package ap.quantas.com.imaging.authentication;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
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
/*    */ @XmlType(name = "imagingFaultType")
/*    */ @XmlEnum
/*    */ public enum ImagingFaultType
/*    */ {
/* 29 */   SYSTEM,
/* 30 */   USAGE,
/* 31 */   SECURITY,
/* 32 */   DATABASE;
/*    */   
/*    */   public String value() {
/* 35 */     return name();
/*    */   }
/*    */   
/*    */   public static ImagingFaultType fromValue(String v) {
/* 39 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\authentication\ImagingFaultType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */