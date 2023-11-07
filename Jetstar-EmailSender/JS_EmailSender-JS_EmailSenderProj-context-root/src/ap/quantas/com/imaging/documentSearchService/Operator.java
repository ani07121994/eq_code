/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlType(name = "operator")
/*    */ @XmlEnum
/*    */ public enum Operator
/*    */ {
/* 39 */   AND,
/* 40 */   OR,
/* 41 */   NOT,
/* 42 */   BEGINS_WITH,
/* 43 */   ENDS_WITH,
/* 44 */   CONTAINS,
/* 45 */   EQUAL,
/* 46 */   GREATER_THAN,
/* 47 */   GREATER_THAN_OR_EQUAL,
/* 48 */   LESS_THAN,
/* 49 */   LESS_THAN_OR_EQUAL,
/* 50 */   NOT_EQUAL,
/* 51 */   EQUAL_TEXT,
/* 52 */   NOT_EQUAL_TEXT;
/*    */   
/*    */   public String value() {
/* 55 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentSearchService.Operator fromValue(String v) {
/* 59 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\Operator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */