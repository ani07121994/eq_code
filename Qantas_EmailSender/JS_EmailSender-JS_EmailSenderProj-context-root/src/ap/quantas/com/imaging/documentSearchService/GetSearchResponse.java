/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.Search;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "getSearchResponse", propOrder = {"search"})
/*    */ public class GetSearchResponse {
/*    */   @XmlElement(namespace = "http://imaging.oracle/")
/*    */   protected Search search;
/*    */   
/*    */   public Search getSearch() {
/* 47 */     return this.search;
/*    */   }
/*    */   
/*    */   public void setSearch(Search value) {
/* 59 */     this.search = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\GetSearchResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */