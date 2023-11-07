/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.Ability;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "listSearches", propOrder = {"ability"})
/*    */ public class ListSearches {
/*    */   protected Ability ability;
/*    */   
/*    */   public Ability getAbility() {
/* 45 */     return this.ability;
/*    */   }
/*    */   
/*    */   public void setAbility(Ability value) {
/* 57 */     this.ability = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\ListSearches.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */