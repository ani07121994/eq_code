/*    */ package ap.quantas.com.imaging.documentContentService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentContentService.Rendition;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "retrieveRenditionResponse", propOrder = {"rendition"})
/*    */ public class RetrieveRenditionResponse {
/*    */   protected Rendition rendition;
/*    */   
/*    */   public Rendition getRendition() {
/* 45 */     return this.rendition;
/*    */   }
/*    */   
/*    */   public void setRendition(Rendition value) {
/* 57 */     this.rendition = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\RetrieveRenditionResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */