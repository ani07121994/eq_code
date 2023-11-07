/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.NameId;
/*    */ import ap.quantas.com.imaging.documentSearchService.SectionSet;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "getSearch", propOrder = {"searchNameId", "sectionSet"})
/*    */ public class GetSearch {
/*    */   protected NameId searchNameId;
/*    */   
/*    */   @XmlElement(namespace = "http://imaging.oracle/")
/*    */   protected SectionSet sectionSet;
/*    */   
/*    */   public NameId getSearchNameId() {
/* 50 */     return this.searchNameId;
/*    */   }
/*    */   
/*    */   public void setSearchNameId(NameId value) {
/* 62 */     this.searchNameId = value;
/*    */   }
/*    */   
/*    */   public SectionSet getSectionSet() {
/* 74 */     return this.sectionSet;
/*    */   }
/*    */   
/*    */   public void setSectionSet(SectionSet value) {
/* 86 */     this.sectionSet = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\GetSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */