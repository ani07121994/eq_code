/*     */ package ap.quantas.com.imaging.documentSearchService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentSearchService.NameId;
/*     */ import ap.quantas.com.imaging.documentSearchService.Property;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchNode;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchValue;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "SearchCondition", propOrder = {"fieldDefinition", "parameterName", "property", "searchValue"})
/*     */ public class SearchCondition
/*     */   extends SearchNode
/*     */ {
/*     */   protected NameId fieldDefinition;
/*     */   protected String parameterName;
/*     */   protected Property property;
/*     */   protected SearchValue searchValue;
/*     */   
/*     */   public NameId getFieldDefinition() {
/*  56 */     return this.fieldDefinition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFieldDefinition(NameId value) {
/*  68 */     this.fieldDefinition = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParameterName() {
/*  80 */     return this.parameterName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameterName(String value) {
/*  92 */     this.parameterName = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Property getProperty() {
/* 104 */     return this.property;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperty(Property value) {
/* 116 */     this.property = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SearchValue getSearchValue() {
/* 128 */     return this.searchValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSearchValue(SearchValue value) {
/* 140 */     this.searchValue = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SearchCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */