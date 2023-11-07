/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.SearchParameters;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "getSearchParametersResponse", propOrder = {"searchParameters"})
/*    */ public class GetSearchParametersResponse {
/*    */   @XmlElement(namespace = "http://imaging.oracle/")
/*    */   protected SearchParameters searchParameters;
/*    */   
/*    */   public SearchParameters getSearchParameters() {
/* 47 */     return this.searchParameters;
/*    */   }
/*    */   
/*    */   public void setSearchParameters(SearchParameters value) {
/* 59 */     this.searchParameters = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\GetSearchParametersResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */