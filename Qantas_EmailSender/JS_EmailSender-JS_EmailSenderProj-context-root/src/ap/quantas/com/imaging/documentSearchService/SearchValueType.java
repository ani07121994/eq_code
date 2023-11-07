/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlType(name = "SearchValueType")
/*    */ @XmlEnum
/*    */ public enum SearchValueType {
/* 33 */   TEXT, NUMBER, DECIMAL, DATE, RELATIVEDATE, RELATIVEDATETIME, CURRENTUSER, DATETIME;
/*    */   
/*    */   public String value() {
/* 43 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentSearchService.SearchValueType fromValue(String v) {
/* 47 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SearchValueType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */