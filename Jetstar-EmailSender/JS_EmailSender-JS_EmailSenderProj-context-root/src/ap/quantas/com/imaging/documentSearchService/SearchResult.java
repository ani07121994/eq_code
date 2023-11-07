/*     */ package ap.quantas.com.imaging.documentSearchService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentSearchService.Document;
/*     */ import ap.quantas.com.imaging.documentSearchService.TypedValue;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "SearchResult", propOrder = {"columnValues", "serialVersionUID", "document"})
/*     */ public class SearchResult
/*     */ {
/*     */   protected List<TypedValue> columnValues;
/*     */   protected long serialVersionUID;
/*     */   @XmlElement(namespace = "http://imaging.oracle/")
/*     */   protected Document document;
/*     */   
/*     */   public List<TypedValue> getColumnValues() {
/*  69 */     if (this.columnValues == null) {
/*  70 */       this.columnValues = new ArrayList<TypedValue>();
/*     */     }
/*  72 */     return this.columnValues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSerialVersionUID() {
/*  80 */     return this.serialVersionUID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSerialVersionUID(long value) {
/*  88 */     this.serialVersionUID = value;
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
/*     */   public Document getDocument() {
/* 100 */     return this.document;
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
/*     */   public void setDocument(Document value) {
/* 112 */     this.document = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SearchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */