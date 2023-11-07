/*    */ package ap.quantas.com.imaging.documentContentService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "retrieveVersion", propOrder = {"documentId", "versionId"})
/*    */ public class RetrieveVersion {
/*    */   protected String documentId;
/*    */   
/*    */   protected long versionId;
/*    */   
/*    */   public String getDocumentId() {
/* 48 */     return this.documentId;
/*    */   }
/*    */   
/*    */   public void setDocumentId(String value) {
/* 60 */     this.documentId = value;
/*    */   }
/*    */   
/*    */   public long getVersionId() {
/* 68 */     return this.versionId;
/*    */   }
/*    */   
/*    */   public void setVersionId(long value) {
/* 76 */     this.versionId = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\RetrieveVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */