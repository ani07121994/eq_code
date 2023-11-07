/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "moveDocumentResponse", propOrder = {"_return"})
/*    */ public class MoveDocumentResponse {
/*    */   @XmlElement(name = "return")
/*    */   protected String _return;
/*    */   
/*    */   public String getReturn() {
/* 47 */     return this._return;
/*    */   }
/*    */   
/*    */   public void setReturn(String value) {
/* 59 */     this._return = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\MoveDocumentResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */