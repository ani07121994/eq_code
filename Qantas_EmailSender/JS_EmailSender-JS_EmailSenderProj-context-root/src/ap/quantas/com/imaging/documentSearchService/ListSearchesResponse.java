/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.NameId;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "listSearchesResponse", propOrder = {"searchNameIds"})
/*    */ public class ListSearchesResponse {
/*    */   protected List<NameId> searchNameIds;
/*    */   
/*    */   public List<NameId> getSearchNameIds() {
/* 61 */     if (this.searchNameIds == null)
/* 62 */       this.searchNameIds = new ArrayList<NameId>(); 
/* 64 */     return this.searchNameIds;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\ListSearchesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */