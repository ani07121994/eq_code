/*    */ package ap.quantas.com.imaging.documentContentService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "uploadDocumentResponse", propOrder = {"uploadToken"})
/*    */ public class UploadDocumentResponse {
/*    */   protected String uploadToken;
/*    */   
/*    */   public String getUploadToken() {
/* 45 */     return this.uploadToken;
/*    */   }
/*    */   
/*    */   public void setUploadToken(String value) {
/* 57 */     this.uploadToken = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\UploadDocumentResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */