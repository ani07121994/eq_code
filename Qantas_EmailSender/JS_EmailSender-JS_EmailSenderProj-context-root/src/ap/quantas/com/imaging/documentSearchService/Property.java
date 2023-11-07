/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlType(name = "property")
/*    */ @XmlEnum
/*    */ public enum Property {
/* 29 */   CREATE_DATE, CREATED_BY_NAME, BATCHID, DOCUMENT_CONTENT;
/*    */   
/*    */   public String value() {
/* 35 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentSearchService.Property fromValue(String v) {
/* 39 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */