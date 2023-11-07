/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.Search;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "getSearchesResponse", propOrder = {"searches"})
/*    */ public class GetSearchesResponse {
/*    */   protected List<Search> searches;
/*    */   
/*    */   public List<Search> getSearches() {
/* 61 */     if (this.searches == null)
/* 62 */       this.searches = new ArrayList<Search>(); 
/* 64 */     return this.searches;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\GetSearchesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */