/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "deleteDocuments", propOrder = {"documentIds"})
/*    */ public class DeleteDocuments {
/*    */   protected List<String> documentIds;
/*    */   
/*    */   public List<String> getDocumentIds() {
/* 61 */     if (this.documentIds == null)
/* 62 */       this.documentIds = new ArrayList<String>(); 
/* 64 */     return this.documentIds;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\DeleteDocuments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */