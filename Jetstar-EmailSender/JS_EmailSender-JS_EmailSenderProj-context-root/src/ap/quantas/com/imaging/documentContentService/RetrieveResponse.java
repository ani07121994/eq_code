/*    */ package ap.quantas.com.imaging.documentContentService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "retrieveResponse", propOrder = {"documentData"})
/*    */ public class RetrieveResponse {
/*    */   protected byte[] documentData;
/*    */   
/*    */   public byte[] getDocumentData() {
/* 44 */     return this.documentData;
/*    */   }
/*    */   
/*    */   public void setDocumentData(byte[] value) {
/* 55 */     this.documentData = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\RetrieveResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */