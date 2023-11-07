/*     */ package ap.quantas.com.imaging.documentContentService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentContentService.Document;
/*     */ import ap.quantas.com.imaging.documentContentService.RenderOptions;
/*     */ import ap.quantas.com.imaging.documentContentService.RenderPage;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "renderResult", propOrder = {"docPageCount", "pages", "mimeType", "fileName", "originalFilename", "totalPageCount", "document"})
/*     */ public class RenderResult extends RenderOptions {
/*     */   protected int docPageCount;
/*     */   
/*     */   @XmlElement(nillable = true)
/*     */   protected List<RenderPage> pages;
/*     */   
/*     */   protected String mimeType;
/*     */   
/*     */   protected String fileName;
/*     */   
/*     */   protected String originalFilename;
/*     */   
/*     */   protected int totalPageCount;
/*     */   
/*     */   @XmlElement(namespace = "http://imaging.oracle/")
/*     */   protected Document document;
/*     */   
/*     */   public int getDocPageCount() {
/*  66 */     return this.docPageCount;
/*     */   }
/*     */   
/*     */   public void setDocPageCount(int value) {
/*  74 */     this.docPageCount = value;
/*     */   }
/*     */   
/*     */   public List<RenderPage> getPages() {
/* 100 */     if (this.pages == null)
/* 101 */       this.pages = new ArrayList<RenderPage>(); 
/* 103 */     return this.pages;
/*     */   }
/*     */   
/*     */   public String getMimeType() {
/* 115 */     return this.mimeType;
/*     */   }
/*     */   
/*     */   public void setMimeType(String value) {
/* 127 */     this.mimeType = value;
/*     */   }
/*     */   
/*     */   public String getFileName() {
/* 139 */     return this.fileName;
/*     */   }
/*     */   
/*     */   public void setFileName(String value) {
/* 151 */     this.fileName = value;
/*     */   }
/*     */   
/*     */   public String getOriginalFilename() {
/* 163 */     return this.originalFilename;
/*     */   }
/*     */   
/*     */   public void setOriginalFilename(String value) {
/* 175 */     this.originalFilename = value;
/*     */   }
/*     */   
/*     */   public int getTotalPageCount() {
/* 183 */     return this.totalPageCount;
/*     */   }
/*     */   
/*     */   public void setTotalPageCount(int value) {
/* 191 */     this.totalPageCount = value;
/*     */   }
/*     */   
/*     */   public Document getDocument() {
/* 203 */     return this.document;
/*     */   }
/*     */   
/*     */   public void setDocument(Document value) {
/* 215 */     this.document = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\RenderResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */