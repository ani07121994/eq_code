/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "hasStatusChanged", propOrder = {"documentId", "status"})
/*    */ public class HasStatusChanged {
/*    */   protected String documentId;
/*    */   
/*    */   protected String status;
/*    */   
/*    */   public String getDocumentId() {
/* 48 */     return this.documentId;
/*    */   }
/*    */   
/*    */   public void setDocumentId(String value) {
/* 60 */     this.documentId = value;
/*    */   }
/*    */   
/*    */   public String getStatus() {
/* 72 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(String value) {
/* 84 */     this.status = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\HasStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */