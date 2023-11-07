/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.NameId;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "getSearchParameters", propOrder = {"searchNameId"})
/*    */ public class GetSearchParameters {
/*    */   protected NameId searchNameId;
/*    */   
/*    */   public NameId getSearchNameId() {
/* 45 */     return this.searchNameId;
/*    */   }
/*    */   
/*    */   public void setSearchNameId(NameId value) {
/* 57 */     this.searchNameId = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\GetSearchParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */