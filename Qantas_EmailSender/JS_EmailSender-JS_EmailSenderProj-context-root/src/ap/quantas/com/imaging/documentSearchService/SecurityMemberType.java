/*    */ package ap.quantas.com.imaging.documentSearchService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlType(name = "SecurityMemberType")
/*    */ @XmlEnum
/*    */ public enum SecurityMemberType {
/* 28 */   USER, GROUP, ROLE;
/*    */   
/*    */   public String value() {
/* 33 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentSearchService.SecurityMemberType fromValue(String v) {
/* 37 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SecurityMemberType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */