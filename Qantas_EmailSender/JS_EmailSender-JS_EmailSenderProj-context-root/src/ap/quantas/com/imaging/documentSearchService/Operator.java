/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlType(name = "operator")
/*    */ @XmlEnum
/*    */ public enum Operator {
/* 39 */   AND, OR, NOT, BEGINS_WITH, ENDS_WITH, CONTAINS, EQUAL, GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL, NOT_EQUAL, EQUAL_TEXT, NOT_EQUAL_TEXT;
/*    */   
/*    */   public String value() {
/* 55 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentSearchService.Operator fromValue(String v) {
/* 59 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\Operator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */