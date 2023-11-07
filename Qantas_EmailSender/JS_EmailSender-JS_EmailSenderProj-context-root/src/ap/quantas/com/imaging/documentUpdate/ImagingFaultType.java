/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlType(name = "imagingFaultType")
/*    */ @XmlEnum
/*    */ public enum ImagingFaultType {
/* 29 */   SYSTEM, USAGE, SECURITY, DATABASE;
/*    */   
/*    */   public String value() {
/* 35 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentUpdate.ImagingFaultType fromValue(String v) {
/* 39 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\ImagingFaultType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */