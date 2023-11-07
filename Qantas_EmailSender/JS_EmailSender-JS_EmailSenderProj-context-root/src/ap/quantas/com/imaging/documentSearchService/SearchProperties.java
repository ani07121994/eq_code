/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "SearchProperties", propOrder = {"searchInstructions", "maxRows"})
/*    */ public class SearchProperties {
/*    */   protected String searchInstructions;
/*    */   
/*    */   protected int maxRows;
/*    */   
/*    */   public String getSearchInstructions() {
/* 48 */     return this.searchInstructions;
/*    */   }
/*    */   
/*    */   public void setSearchInstructions(String value) {
/* 60 */     this.searchInstructions = value;
/*    */   }
/*    */   
/*    */   public int getMaxRows() {
/* 68 */     return this.maxRows;
/*    */   }
/*    */   
/*    */   public void setMaxRows(int value) {
/* 76 */     this.maxRows = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SearchProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */