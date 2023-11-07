/*    */ package ap.quantas.com.imaging.documentContentService;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlSchemaType;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "renderPage", propOrder = {"pageData", "resourceUrl"})
/*    */ public class RenderPage {
/*    */   protected byte[] pageData;
/*    */   
/*    */   @XmlSchemaType(name = "anyURI")
/*    */   protected String resourceUrl;
/*    */   
/*    */   public byte[] getPageData() {
/* 49 */     return this.pageData;
/*    */   }
/*    */   
/*    */   public void setPageData(byte[] value) {
/* 60 */     this.pageData = value;
/*    */   }
/*    */   
/*    */   public String getResourceUrl() {
/* 72 */     return this.resourceUrl;
/*    */   }
/*    */   
/*    */   public void setResourceUrl(String value) {
/* 84 */     this.resourceUrl = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\RenderPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */