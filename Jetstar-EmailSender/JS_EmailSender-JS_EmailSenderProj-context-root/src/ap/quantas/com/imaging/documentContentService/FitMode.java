/*    */ package ap.quantas.com.imaging.documentContentService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlType(name = "fitMode")
/*    */ @XmlEnum
/*    */ public enum FitMode {
/* 29 */   FITBEST, FITHEIGHT, FITWIDTH, FITSCALE;
/*    */   
/*    */   public String value() {
/* 35 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentContentService.FitMode fromValue(String v) {
/* 39 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\FitMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */