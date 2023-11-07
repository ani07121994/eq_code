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
/*    */ @XmlType(name = "SearchValueType")
/*    */ @XmlEnum
/*    */ public enum SearchValueType
/*    */ {
/* 33 */   TEXT,
/* 34 */   NUMBER,
/* 35 */   DECIMAL,
/* 36 */   DATE,
/* 37 */   RELATIVEDATE,
/* 38 */   RELATIVEDATETIME,
/* 39 */   CURRENTUSER,
/* 40 */   DATETIME;
/*    */   
/*    */   public String value() {
/* 43 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentSearchService.SearchValueType fromValue(String v) {
/* 47 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SearchValueType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */