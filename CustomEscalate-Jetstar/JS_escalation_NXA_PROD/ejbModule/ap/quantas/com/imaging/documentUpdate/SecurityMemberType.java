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
/*    */ @XmlType(name = "SecurityMemberType")
/*    */ @XmlEnum
/*    */ public enum SecurityMemberType
/*    */ {
/* 28 */   USER,
/* 29 */   GROUP,
/* 30 */   ROLE;
/*    */   
/*    */   public String value() {
/* 33 */     return name();
/*    */   }
/*    */   
/*    */   public static SecurityMemberType fromValue(String v) {
/* 37 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\JS_escalation_NXA_PROD.jar!\ap\quantas\com\imaging\documentUpdate\SecurityMemberType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */