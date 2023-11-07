/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.NameId;
/*    */ import ap.quantas.com.imaging.documentSearchService.SectionSet;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "getSearches", propOrder = {"searchNameIds", "sectionSet"})
/*    */ public class GetSearches {
/*    */   protected List<NameId> searchNameIds;
/*    */   
/*    */   @XmlElement(namespace = "http://imaging.oracle/")
/*    */   protected SectionSet sectionSet;
/*    */   
/*    */   public List<NameId> getSearchNameIds() {
/* 66 */     if (this.searchNameIds == null)
/* 67 */       this.searchNameIds = new ArrayList<NameId>(); 
/* 69 */     return this.searchNameIds;
/*    */   }
/*    */   
/*    */   public SectionSet getSectionSet() {
/* 81 */     return this.sectionSet;
/*    */   }
/*    */   
/*    */   public void setSectionSet(SectionSet value) {
/* 93 */     this.sectionSet = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\GetSearches.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */