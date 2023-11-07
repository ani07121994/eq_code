/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlType(name = "ability")
/*    */ @XmlEnum
/*    */ public enum Ability
/*    */ {
/* 27 */   VIEW,
/* 28 */   MANAGE;
/*    */   
/*    */   public String value() {
/* 31 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentSearchService.Ability fromValue(String v) {
/* 35 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\Ability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */