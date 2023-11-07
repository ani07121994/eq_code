/*     */ package ap.quantas.com.imaging.documentContentService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentContentService.Document;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "rendition", propOrder = {"mimeType", "originalFilename", "content", "document"})
/*     */ public class Rendition {
/*     */   protected String mimeType;
/*     */   
/*     */   protected String originalFilename;
/*     */   
/*     */   protected byte[] content;
/*     */   
/*     */   @XmlElement(namespace = "http://imaging.oracle/")
/*     */   protected Document document;
/*     */   
/*     */   public String getMimeType() {
/*  56 */     return this.mimeType;
/*     */   }
/*     */   
/*     */   public void setMimeType(String value) {
/*  68 */     this.mimeType = value;
/*     */   }
/*     */   
/*     */   public String getOriginalFilename() {
/*  80 */     return this.originalFilename;
/*     */   }
/*     */   
/*     */   public void setOriginalFilename(String value) {
/*  92 */     this.originalFilename = value;
/*     */   }
/*     */   
/*     */   public byte[] getContent() {
/* 103 */     return this.content;
/*     */   }
/*     */   
/*     */   public void setContent(byte[] value) {
/* 114 */     this.content = value;
/*     */   }
/*     */   
/*     */   public Document getDocument() {
/* 126 */     return this.document;
/*     */   }
/*     */   
/*     */   public void setDocument(Document value) {
/* 138 */     this.document = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\Rendition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */