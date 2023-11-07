/*    */ package ap.quantas.com.imaging.documentUpdate;
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
/*    */ @XmlType(name = "DocumentSectionFlag")
/*    */ @XmlEnum
/*    */ public enum DocumentSectionFlag
/*    */ {
/* 29 */   PROPERTIES,
/* 30 */   FIELDVALUES,
/* 31 */   PERMISSIONS,
/* 32 */   HISTORY;
/*    */   
/*    */   public String value() {
/* 35 */     return name();
/*    */   }
/*    */   
/*    */   public static DocumentSectionFlag fromValue(String v) {
/* 39 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\JS_escalation_NXA_PROD.jar!\ap\quantas\com\imaging\documentUpdate\DocumentSectionFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */