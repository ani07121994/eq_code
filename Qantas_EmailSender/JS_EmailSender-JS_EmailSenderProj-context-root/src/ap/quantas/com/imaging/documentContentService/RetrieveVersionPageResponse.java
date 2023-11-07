/*    */ package ap.quantas.com.imaging.documentContentService;
/*    */ 
/*    */ import ap.quantas.com.imaging.documentContentService.RenderResult;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "retrieveVersionPageResponse", propOrder = {"renderResult"})
/*    */ public class RetrieveVersionPageResponse {
/*    */   protected RenderResult renderResult;
/*    */   
/*    */   public RenderResult getRenderResult() {
/* 45 */     return this.renderResult;
/*    */   }
/*    */   
/*    */   public void setRenderResult(RenderResult value) {
/* 57 */     this.renderResult = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\RetrieveVersionPageResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */