/*    */ package ap.quantas.com.imaging.documentContentService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentContentService.RenderOptions;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "retrievePage", propOrder = {"documentId", "options"})
/*    */ public class RetrievePage {
/*    */   protected String documentId;
/*    */   
/*    */   protected RenderOptions options;
/*    */   
/*    */   public String getDocumentId() {
/* 48 */     return this.documentId;
/*    */   }
/*    */   
/*    */   public void setDocumentId(String value) {
/* 60 */     this.documentId = value;
/*    */   }
/*    */   
/*    */   public RenderOptions getOptions() {
/* 72 */     return this.options;
/*    */   }
/*    */   
/*    */   public void setOptions(RenderOptions value) {
/* 84 */     this.options = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\RetrievePage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */