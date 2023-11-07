/*     */ package ap.quantas.com.imaging.documentContentService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentContentService.RenderOptions;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "retrieveVersionPage", propOrder = {"documentId", "versionId", "options"})
/*     */ public class RetrieveVersionPage {
/*     */   protected String documentId;
/*     */   
/*     */   protected long versionId;
/*     */   
/*     */   protected RenderOptions options;
/*     */   
/*     */   public String getDocumentId() {
/*  51 */     return this.documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String value) {
/*  63 */     this.documentId = value;
/*     */   }
/*     */   
/*     */   public long getVersionId() {
/*  71 */     return this.versionId;
/*     */   }
/*     */   
/*     */   public void setVersionId(long value) {
/*  79 */     this.versionId = value;
/*     */   }
/*     */   
/*     */   public RenderOptions getOptions() {
/*  91 */     return this.options;
/*     */   }
/*     */   
/*     */   public void setOptions(RenderOptions value) {
/* 103 */     this.options = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\RetrieveVersionPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */