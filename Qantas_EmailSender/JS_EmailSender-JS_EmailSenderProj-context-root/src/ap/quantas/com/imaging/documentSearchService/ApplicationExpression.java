/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.NameId;
/*    */ import ap.quantas.com.imaging.documentSearchService.SearchNode;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "ApplicationExpression", propOrder = {})
/*    */ public class ApplicationExpression {
/*    */   protected NameId applicationId;
/*    */   
/*    */   protected SearchNode searchTree;
/*    */   
/*    */   public NameId getApplicationId() {
/* 47 */     return this.applicationId;
/*    */   }
/*    */   
/*    */   public void setApplicationId(NameId value) {
/* 59 */     this.applicationId = value;
/*    */   }
/*    */   
/*    */   public SearchNode getSearchTree() {
/* 71 */     return this.searchTree;
/*    */   }
/*    */   
/*    */   public void setSearchTree(SearchNode value) {
/* 83 */     this.searchTree = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\ApplicationExpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */