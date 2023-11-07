/*    */ package ap.quantas.com.imaging.documentContentService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlEnum;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlType(name = "renditionOutput")
/*    */ @XmlEnum
/*    */ public enum RenditionOutput {
/* 27 */   TIFF, ORIGINALORTIFF;
/*    */   
/*    */   public String value() {
/* 31 */     return name();
/*    */   }
/*    */   
/*    */   public static ap.quantas.com.imaging.documentContentService.RenditionOutput fromValue(String v) {
/* 35 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\RenditionOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */