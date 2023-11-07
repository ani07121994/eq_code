/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentUpdate.NameId;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "getTargetApplication", propOrder = {"appNameId"})
/*    */ public class GetTargetApplication {
/*    */   protected NameId appNameId;
/*    */   
/*    */   public NameId getAppNameId() {
/* 45 */     return this.appNameId;
/*    */   }
/*    */   
/*    */   public void setAppNameId(NameId value) {
/* 57 */     this.appNameId = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\GetTargetApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */