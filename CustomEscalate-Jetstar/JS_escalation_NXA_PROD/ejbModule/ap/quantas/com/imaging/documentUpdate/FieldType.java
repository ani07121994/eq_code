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
/*    */ 
/*    */ @XmlType(name = "FieldType")
/*    */ @XmlEnum
/*    */ public enum FieldType
/*    */ {
/* 30 */   TEXT,
/* 31 */   NUMBER,
/* 32 */   DECIMAL,
/* 33 */   DATE,
/* 34 */   DATETIME;
/*    */   
/*    */   public String value() {
/* 37 */     return name();
/*    */   }
/*    */   
/*    */   public static FieldType fromValue(String v) {
/* 41 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\JS_escalation_NXA_PROD.jar!\ap\quantas\com\imaging\documentUpdate\FieldType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */