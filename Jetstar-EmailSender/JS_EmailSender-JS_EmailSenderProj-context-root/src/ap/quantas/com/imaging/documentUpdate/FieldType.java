/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlType(name = "FieldType")
/*    */ @XmlEnum
/*    */ public enum FieldType {
/* 30 */   TEXT, NUMBER, DECIMAL, DATE, DATETIME;
/*    */   
/*    */   public String value() {
/* 37 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentUpdate.FieldType fromValue(String v) {
/* 41 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\FieldType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */