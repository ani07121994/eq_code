/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentUpdate.Document;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "getDocumentsResponse", propOrder = {"documents"})
/*    */ public class GetDocumentsResponse {
/*    */   protected List<Document> documents;
/*    */   
/*    */   public List<Document> getDocuments() {
/* 61 */     if (this.documents == null)
/* 62 */       this.documents = new ArrayList<Document>(); 
/* 64 */     return this.documents;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\GetDocumentsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */