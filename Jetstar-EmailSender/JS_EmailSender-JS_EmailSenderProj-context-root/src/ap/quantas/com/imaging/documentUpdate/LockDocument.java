/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentUpdate.DocumentSectionSet;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "lockDocument", propOrder = {"documentId", "sectionSet"})
/*    */ public class LockDocument {
/*    */   protected String documentId;
/*    */   
/*    */   @XmlElement(namespace = "http://imaging.oracle/")
/*    */   protected DocumentSectionSet sectionSet;
/*    */   
/*    */   public String getDocumentId() {
/* 50 */     return this.documentId;
/*    */   }
/*    */   
/*    */   public void setDocumentId(String value) {
/* 62 */     this.documentId = value;
/*    */   }
/*    */   
/*    */   public DocumentSectionSet getSectionSet() {
/* 74 */     return this.sectionSet;
/*    */   }
/*    */   
/*    */   public void setSectionSet(DocumentSectionSet value) {
/* 86 */     this.sectionSet = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\LockDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */