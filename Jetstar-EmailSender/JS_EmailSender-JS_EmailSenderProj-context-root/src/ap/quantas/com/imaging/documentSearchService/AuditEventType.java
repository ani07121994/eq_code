/*    */ package ap.quantas.com.imaging.documentSearchService;
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
/*    */ @XmlType(name = "AuditEventType")
/*    */ @XmlEnum
/*    */ public enum AuditEventType
/*    */ {
/* 42 */   DOCUMENT_COPY,
/* 43 */   DOCUMENT_CREATE,
/* 44 */   DOCUMENT_DELETE,
/* 45 */   DOCUMENT_MIGRATE,
/* 46 */   DOCUMENT_MODIFY_METADATA,
/* 47 */   DOCUMENT_MOVE,
/* 48 */   DOCUMENT_RETRIEVE,
/* 49 */   DOCUMENT_VERSION,
/* 50 */   SUPPORTING_CONTENT_CREATE,
/* 51 */   WORKFLOW_INJECT,
/* 52 */   DEFINITION_CREATE,
/* 53 */   DEFINITION_DELETE,
/* 54 */   DEFINITION_MODIFY,
/* 55 */   SEARCH_EXECUTE,
/* 56 */   SYSTEM_SECURITY_MODIFY,
/* 57 */   ANNOTATION_MODIFIED,
/* 58 */   MBEAN_MODIFIED;
/*    */   
/*    */   public String value() {
/* 61 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentSearchService.AuditEventType fromValue(String v) {
/* 65 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\AuditEventType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */