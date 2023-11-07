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
/*    */ @XmlType(name = "sectionFlag")
/*    */ @XmlEnum
/*    */ public enum SectionFlag
/*    */ {
/* 34 */   NAME,
/* 35 */   DESCRIPTION,
/* 36 */   PROPERTIES,
/* 37 */   PARAMETERS,
/* 38 */   RESULT_COLUMNS,
/* 39 */   EXPRESSIONS,
/* 40 */   PERMISSIONS,
/* 41 */   SECURITY,
/* 42 */   HISTORY;
/*    */   
/*    */   public String value() {
/* 45 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentSearchService.SectionFlag fromValue(String v) {
/* 49 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SectionFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */