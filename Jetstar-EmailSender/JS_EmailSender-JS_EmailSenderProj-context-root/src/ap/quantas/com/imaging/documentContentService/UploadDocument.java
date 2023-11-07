/*    */ package ap.quantas.com.imaging.documentContentService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "uploadDocument", propOrder = {"data", "fileName"})
/*    */ public class UploadDocument {
/*    */   protected byte[] data;
/*    */   
/*    */   protected String fileName;
/*    */   
/*    */   public byte[] getData() {
/* 47 */     return this.data;
/*    */   }
/*    */   
/*    */   public void setData(byte[] value) {
/* 58 */     this.data = value;
/*    */   }
/*    */   
/*    */   public String getFileName() {
/* 70 */     return this.fileName;
/*    */   }
/*    */   
/*    */   public void setFileName(String value) {
/* 82 */     this.fileName = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\UploadDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */