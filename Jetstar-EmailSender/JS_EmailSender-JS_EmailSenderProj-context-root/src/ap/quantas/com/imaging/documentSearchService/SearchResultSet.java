/*     */ package ap.quantas.com.imaging.documentSearchService;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "SearchResultSet", propOrder = {"resultsTruncated", "results", "columns"})
/*     */ public class SearchResultSet
/*     */ {
/*     */   protected boolean resultsTruncated;
/*     */   protected Results results;
/*     */   protected List<String> columns;
/*     */   
/*     */   public boolean isResultsTruncated() {
/*  59 */     return this.resultsTruncated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResultsTruncated(boolean value) {
/*  67 */     this.resultsTruncated = value;
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
/*     */   public Results getResults() {
/*  79 */     return this.results;
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
/*     */   public void setResults(Results value) {
/*  91 */     this.results = value;
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
/*     */   public List<String> getColumns() {
/* 117 */     if (this.columns == null) {
/* 118 */       this.columns = new ArrayList<String>();
/*     */     }
/* 120 */     return this.columns;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SearchResultSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */