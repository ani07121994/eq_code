/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentUpdate.Application;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "getTargetApplicationResponse", propOrder = {"application"})
/*    */ public class GetTargetApplicationResponse {
/*    */   @XmlElement(namespace = "http://imaging.oracle/")
/*    */   protected Application application;
/*    */   
/*    */   public Application getApplication() {
/* 47 */     return this.application;
/*    */   }
/*    */   
/*    */   public void setApplication(Application value) {
/* 59 */     this.application = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\GetTargetApplicationResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */