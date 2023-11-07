/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "ApplicationProperties", propOrder = {"repository", "nextFieldId", "fastCheckIn", "fullTextSearch"})
/*     */ public class ApplicationProperties
/*     */ {
/*     */   protected NameId repository;
/*     */   protected long nextFieldId;
/*     */   protected boolean fastCheckIn;
/*     */   protected boolean fullTextSearch;
/*     */   
/*     */   public NameId getRepository() {
/*  54 */     return this.repository;
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
/*     */   public void setRepository(NameId value) {
/*  66 */     this.repository = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getNextFieldId() {
/*  74 */     return this.nextFieldId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNextFieldId(long value) {
/*  82 */     this.nextFieldId = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFastCheckIn() {
/*  90 */     return this.fastCheckIn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFastCheckIn(boolean value) {
/*  98 */     this.fastCheckIn = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullTextSearch() {
/* 106 */     return this.fullTextSearch;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFullTextSearch(boolean value) {
/* 114 */     this.fullTextSearch = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2146691\Downloads\JS_escalation_NXA_PROD.jar!\ap\quantas\com\imaging\documentUpdate\ApplicationProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */