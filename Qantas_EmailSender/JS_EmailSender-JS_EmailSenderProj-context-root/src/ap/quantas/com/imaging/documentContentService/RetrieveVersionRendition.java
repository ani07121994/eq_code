/*     */ package ap.quantas.com.imaging.documentContentService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentContentService.RenditionOutput;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "retrieveVersionRendition", propOrder = {"documentId", "versionId", "withAnnotations", "preserveColor", "outputType", "pages"})
/*     */ public class RetrieveVersionRendition {
/*     */   protected String documentId;
/*     */   
/*     */   protected long versionId;
/*     */   
/*     */   protected boolean withAnnotations;
/*     */   
/*     */   protected boolean preserveColor;
/*     */   
/*     */   protected RenditionOutput outputType;
/*     */   
/*     */   @XmlElement(type = Integer.class)
/*     */   protected List<Integer> pages;
/*     */   
/*     */   public String getDocumentId() {
/*  64 */     return this.documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String value) {
/*  76 */     this.documentId = value;
/*     */   }
/*     */   
/*     */   public long getVersionId() {
/*  84 */     return this.versionId;
/*     */   }
/*     */   
/*     */   public void setVersionId(long value) {
/*  92 */     this.versionId = value;
/*     */   }
/*     */   
/*     */   public boolean isWithAnnotations() {
/* 100 */     return this.withAnnotations;
/*     */   }
/*     */   
/*     */   public void setWithAnnotations(boolean value) {
/* 108 */     this.withAnnotations = value;
/*     */   }
/*     */   
/*     */   public boolean isPreserveColor() {
/* 116 */     return this.preserveColor;
/*     */   }
/*     */   
/*     */   public void setPreserveColor(boolean value) {
/* 124 */     this.preserveColor = value;
/*     */   }
/*     */   
/*     */   public RenditionOutput getOutputType() {
/* 136 */     return this.outputType;
/*     */   }
/*     */   
/*     */   public void setOutputType(RenditionOutput value) {
/* 148 */     this.outputType = value;
/*     */   }
/*     */   
/*     */   public List<Integer> getPages() {
/* 174 */     if (this.pages == null)
/* 175 */       this.pages = new ArrayList<Integer>(); 
/* 177 */     return this.pages;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\RetrieveVersionRendition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */