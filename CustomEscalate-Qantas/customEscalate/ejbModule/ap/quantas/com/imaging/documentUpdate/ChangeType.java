/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlEnumValue;
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
/*    */ @XmlType(name = "changeType")
/*    */ @XmlEnum
/*    */ public enum ChangeType
/*    */ {
/* 30 */   APPEND_PAGE("AppendPage"),
/*    */   
/* 32 */   INSERT_PAGE("InsertPage"),
/*    */   
/* 34 */   DELETE_PAGE("DeletePage"),
/*    */   
/* 36 */   MOVE_PAGE("MovePage");
/*    */   
/*    */   private final String value;
/*    */   
/*    */   ChangeType(String v) {
/* 41 */     this.value = v;
/*    */   }
/*    */   
/*    */   public String value() {
/* 45 */     return this.value;
/*    */   }
/*    */   
/*    */   public static ChangeType fromValue(String v) {
/* 49 */     for (ChangeType c : values()) {
/* 50 */       if (c.value.equals(v)) {
/* 51 */         return c;
/*    */       }
/*    */     } 
/* 54 */     throw new IllegalArgumentException(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\documentUpdate\ChangeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */