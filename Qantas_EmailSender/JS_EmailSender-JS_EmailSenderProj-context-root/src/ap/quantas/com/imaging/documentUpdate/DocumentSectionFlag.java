/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlType(name = "DocumentSectionFlag")
/*    */ @XmlEnum
/*    */ public enum DocumentSectionFlag {
/* 29 */   PROPERTIES, FIELDVALUES, PERMISSIONS, HISTORY;
/*    */   
/*    */   public String value() {
/* 35 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentUpdate.DocumentSectionFlag fromValue(String v) {
/* 39 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\DocumentSectionFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */