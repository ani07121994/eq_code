/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "SearchFormatColumn", propOrder = {"columnTitle", "results"})
/*    */ public class SearchFormatColumn {
/*    */   protected String columnTitle;
/*    */   
/*    */   protected Results results;
/*    */   
/*    */   public String getColumnTitle() {
/* 61 */     return this.columnTitle;
/*    */   }
/*    */   
/*    */   public void setColumnTitle(String value) {
/* 73 */     this.columnTitle = value;
/*    */   }
/*    */   
/*    */   public Results getResults() {
/* 85 */     return this.results;
/*    */   }
/*    */   
/*    */   public void setResults(Results value) {
/* 97 */     this.results = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SearchFormatColumn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */