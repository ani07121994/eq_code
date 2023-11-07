/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "hasStatusChangedResponse", propOrder = {"statusChanged"})
/*    */ public class HasStatusChangedResponse {
/*    */   protected boolean statusChanged;
/*    */   
/*    */   public boolean isStatusChanged() {
/* 41 */     return this.statusChanged;
/*    */   }
/*    */   
/*    */   public void setStatusChanged(boolean value) {
/* 49 */     this.statusChanged = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\HasStatusChangedResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */