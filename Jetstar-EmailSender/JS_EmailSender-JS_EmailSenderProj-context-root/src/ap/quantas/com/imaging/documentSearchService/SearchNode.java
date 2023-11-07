/*     */ package ap.quantas.com.imaging.documentSearchService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentSearchService.Operator;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchCondition;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchConjunction;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlSeeAlso;
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
/*     */ @XmlType(name = "SearchNode", propOrder = {"leftOperand", "rightOperand", "searchOperator", "alwaysDisplayParentheses"})
/*     */ @XmlSeeAlso({SearchConjunction.class, SearchCondition.class})
/*     */ public abstract class SearchNode
/*     */ {
/*     */   protected ap.quantas.com.imaging.documentSearchService.SearchNode leftOperand;
/*     */   protected ap.quantas.com.imaging.documentSearchService.SearchNode rightOperand;
/*     */   protected Operator searchOperator;
/*     */   protected boolean alwaysDisplayParentheses;
/*     */   
/*     */   public ap.quantas.com.imaging.documentSearchService.SearchNode getLeftOperand() {
/*  59 */     return this.leftOperand;
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
/*     */   public void setLeftOperand(ap.quantas.com.imaging.documentSearchService.SearchNode value) {
/*  71 */     this.leftOperand = value;
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
/*     */   public ap.quantas.com.imaging.documentSearchService.SearchNode getRightOperand() {
/*  83 */     return this.rightOperand;
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
/*     */   public void setRightOperand(ap.quantas.com.imaging.documentSearchService.SearchNode value) {
/*  95 */     this.rightOperand = value;
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
/*     */   public Operator getSearchOperator() {
/* 107 */     return this.searchOperator;
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
/*     */   public void setSearchOperator(Operator value) {
/* 119 */     this.searchOperator = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAlwaysDisplayParentheses() {
/* 127 */     return this.alwaysDisplayParentheses;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlwaysDisplayParentheses(boolean value) {
/* 135 */     this.alwaysDisplayParentheses = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SearchNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */