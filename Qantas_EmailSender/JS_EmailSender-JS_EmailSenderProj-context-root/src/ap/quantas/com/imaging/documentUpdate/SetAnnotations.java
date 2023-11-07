/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "setAnnotations", propOrder = {"documentId", "annotData"})
/*    */ public class SetAnnotations {
/*    */   protected String documentId;
/*    */   
/*    */   @XmlElement(required = true)
/*    */   protected byte[] annotData;
/*    */   
/*    */   public String getDocumentId() {
/* 50 */     return this.documentId;
/*    */   }
/*    */   
/*    */   public void setDocumentId(String value) {
/* 62 */     this.documentId = value;
/*    */   }
/*    */   
/*    */   public byte[] getAnnotData() {
/* 73 */     return this.annotData;
/*    */   }
/*    */   
/*    */   public void setAnnotData(byte[] value) {
/* 84 */     this.annotData = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\SetAnnotations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */