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
/*     */ @XmlType(name = "retrieveRendition", propOrder = {"documentId", "withAnnotations", "preserveColor", "outputType", "pages"})
/*     */ public class RetrieveRendition {
/*     */   protected String documentId;
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
/*  61 */     return this.documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String value) {
/*  73 */     this.documentId = value;
/*     */   }
/*     */   
/*     */   public boolean isWithAnnotations() {
/*  81 */     return this.withAnnotations;
/*     */   }
/*     */   
/*     */   public void setWithAnnotations(boolean value) {
/*  89 */     this.withAnnotations = value;
/*     */   }
/*     */   
/*     */   public boolean isPreserveColor() {
/*  97 */     return this.preserveColor;
/*     */   }
/*     */   
/*     */   public void setPreserveColor(boolean value) {
/* 105 */     this.preserveColor = value;
/*     */   }
/*     */   
/*     */   public RenditionOutput getOutputType() {
/* 117 */     return this.outputType;
/*     */   }
/*     */   
/*     */   public void setOutputType(RenditionOutput value) {
/* 129 */     this.outputType = value;
/*     */   }
/*     */   
/*     */   public List<Integer> getPages() {
/* 155 */     if (this.pages == null)
/* 156 */       this.pages = new ArrayList<Integer>(); 
/* 158 */     return this.pages;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\RetrieveRendition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */