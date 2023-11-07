/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentUpdate.Document;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "getDocumentResponse", propOrder = {"document"})
/*    */ public class GetDocumentResponse {
/*    */   @XmlElement(namespace = "http://imaging.oracle/")
/*    */   protected Document document;
/*    */   
/*    */   public Document getDocument() {
/* 47 */     return this.document;
/*    */   }
/*    */   
/*    */   public void setDocument(Document value) {
/* 59 */     this.document = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\GetDocumentResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */