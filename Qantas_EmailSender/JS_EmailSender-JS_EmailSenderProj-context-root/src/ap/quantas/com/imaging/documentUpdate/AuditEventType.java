/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlType(name = "AuditEventType")
/*    */ @XmlEnum
/*    */ public enum AuditEventType {
/* 42 */   DOCUMENT_COPY, DOCUMENT_CREATE, DOCUMENT_DELETE, DOCUMENT_MIGRATE, DOCUMENT_MODIFY_METADATA, DOCUMENT_MOVE, DOCUMENT_RETRIEVE, DOCUMENT_VERSION, SUPPORTING_CONTENT_CREATE, WORKFLOW_INJECT, DEFINITION_CREATE, DEFINITION_DELETE, DEFINITION_MODIFY, SEARCH_EXECUTE, SYSTEM_SECURITY_MODIFY, ANNOTATION_MODIFIED, MBEAN_MODIFIED;
/*    */   
/*    */   public String value() {
/* 61 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentUpdate.AuditEventType fromValue(String v) {
/* 65 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\AuditEventType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */