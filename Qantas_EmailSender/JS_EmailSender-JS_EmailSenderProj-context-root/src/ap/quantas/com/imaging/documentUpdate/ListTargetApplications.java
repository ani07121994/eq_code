/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentUpdate.DocumentAbility;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "listTargetApplications", propOrder = {"ability"})
/*    */ public class ListTargetApplications {
/*    */   protected DocumentAbility ability;
/*    */   
/*    */   public DocumentAbility getAbility() {
/* 45 */     return this.ability;
/*    */   }
/*    */   
/*    */   public void setAbility(DocumentAbility value) {
/* 57 */     this.ability = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\ListTargetApplications.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */