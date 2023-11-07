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
/*    */ @XmlType(name = "DocumentAbility")
/*    */ @XmlEnum
/*    */ public enum DocumentAbility
/*    */ {
/* 27 */   VIEWDOCUMENT,
/* 28 */   CREATEDOCUMENT;
/*    */   
/*    */   public String value() {
/* 31 */     return name();
/*    */   }
/*    */   
/*    */   public static DocumentAbility fromValue(String v) {
/* 35 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\documentUpdate\DocumentAbility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */