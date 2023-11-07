/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentSearchService.SearchValueType;
/*    */ import ap.quantas.com.imaging.documentSearchService.TypedValue;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "SearchValue", propOrder = {"typedValue", "searchValueType"})
/*    */ public class SearchValue {
/*    */   protected TypedValue typedValue;
/*    */   
/*    */   protected SearchValueType searchValueType;
/*    */   
/*    */   public TypedValue getTypedValue() {
/* 48 */     return this.typedValue;
/*    */   }
/*    */   
/*    */   public void setTypedValue(TypedValue value) {
/* 60 */     this.typedValue = value;
/*    */   }
/*    */   
/*    */   public SearchValueType getSearchValueType() {
/* 72 */     return this.searchValueType;
/*    */   }
/*    */   
/*    */   public void setSearchValueType(SearchValueType value) {
/* 84 */     this.searchValueType = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SearchValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */