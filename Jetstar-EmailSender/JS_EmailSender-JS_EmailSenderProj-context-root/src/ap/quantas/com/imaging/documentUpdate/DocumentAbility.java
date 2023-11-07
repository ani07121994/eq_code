/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlType(name = "DocumentAbility")
/*    */ @XmlEnum
/*    */ public enum DocumentAbility {
/* 27 */   VIEWDOCUMENT, CREATEDOCUMENT;
/*    */   
/*    */   public String value() {
/* 31 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentUpdate.DocumentAbility fromValue(String v) {
/* 35 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\DocumentAbility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */