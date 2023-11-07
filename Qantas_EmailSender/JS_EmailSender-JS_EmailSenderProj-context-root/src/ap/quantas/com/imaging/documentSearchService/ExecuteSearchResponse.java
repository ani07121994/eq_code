/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.SearchResultSet;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "executeSearchResponse", propOrder = {"searchResults"})
/*    */ public class ExecuteSearchResponse {
/*    */   protected SearchResultSet searchResults;
/*    */   
/*    */   public SearchResultSet getSearchResults() {
/* 45 */     return this.searchResults;
/*    */   }
/*    */   
/*    */   public void setSearchResults(SearchResultSet value) {
/* 57 */     this.searchResults = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\ExecuteSearchResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */