/*    */ package ap.quantas.com.imaging.documentContentService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "retrieve", propOrder = {"documentId"})
/*    */ public class Retrieve {
/*    */   protected String documentId;
/*    */   
/*    */   public String getDocumentId() {
/* 45 */     return this.documentId;
/*    */   }
/*    */   
/*    */   public void setDocumentId(String value) {
/* 57 */     this.documentId = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\Retrieve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */