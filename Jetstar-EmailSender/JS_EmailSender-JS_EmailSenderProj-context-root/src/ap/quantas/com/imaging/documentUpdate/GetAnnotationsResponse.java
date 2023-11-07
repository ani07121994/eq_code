/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "getAnnotationsResponse", propOrder = {"annotationData"})
/*    */ public class GetAnnotationsResponse {
/*    */   protected byte[] annotationData;
/*    */   
/*    */   public byte[] getAnnotationData() {
/* 44 */     return this.annotationData;
/*    */   }
/*    */   
/*    */   public void setAnnotationData(byte[] value) {
/* 55 */     this.annotationData = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\GetAnnotationsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */