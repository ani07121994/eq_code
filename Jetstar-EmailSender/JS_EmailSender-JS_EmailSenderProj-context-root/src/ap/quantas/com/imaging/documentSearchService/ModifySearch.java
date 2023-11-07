/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.Search;
/*    */ import ap.quantas.com.imaging.documentSearchService.SectionSet;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "modifySearch", propOrder = {"search", "sectionSet"})
/*    */ public class ModifySearch
/*    */ {
/*    */   @XmlElement(namespace = "http://imaging.oracle/")
/*    */   protected Search search;
/*    */   @XmlElement(namespace = "http://imaging.oracle/")
/*    */   protected SectionSet sectionSet;
/*    */   
/*    */   public Search getSearch() {
/* 51 */     return this.search;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSearch(Search value) {
/* 63 */     this.search = value;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SectionSet getSectionSet() {
/* 75 */     return this.sectionSet;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSectionSet(SectionSet value) {
/* 87 */     this.sectionSet = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\ModifySearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */