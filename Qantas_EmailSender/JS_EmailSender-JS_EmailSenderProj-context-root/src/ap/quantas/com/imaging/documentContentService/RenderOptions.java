/*     */ package ap.quantas.com.imaging.documentContentService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentContentService.FitMode;
/*     */ import ap.quantas.com.imaging.documentContentService.RenderBoundRect;
/*     */ import ap.quantas.com.imaging.documentContentService.RenderResult;
/*     */ import ap.quantas.com.imaging.documentContentService.RotationStop;
import oracle.imaging.RenderOptions.OutputFormat;

/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlSeeAlso;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "renderOptions", propOrder = {"fitMode", "format", "rotation", "scaleFactor", "pageNumber", "withAnnotations", "boundRect", "requestURL"})
/*     */ @XmlSeeAlso({RenderResult.class})
/*     */ public class RenderOptions {
/*     */   protected FitMode fitMode;
/*     */   
/*     */   protected OutputFormat format;
/*     */   
/*     */   protected RotationStop rotation;
/*     */   
/*     */   protected int scaleFactor;
/*     */   
/*     */   protected int pageNumber;
/*     */   
/*     */   protected boolean withAnnotations;
/*     */   
/*     */   protected RenderBoundRect boundRect;
/*     */   
/*     */   protected String requestURL;
/*     */   
/*     */   public FitMode getFitMode() {
/*  70 */     return this.fitMode;
/*     */   }
/*     */   
/*     */   public void setFitMode(FitMode value) {
/*  82 */     this.fitMode = value;
/*     */   }
/*     */   
/*     */   public OutputFormat getFormat() {
/*  94 */     return this.format;
/*     */   }
/*     */   
/*     */   public void setFormat(OutputFormat value) {
/* 106 */     this.format = value;
/*     */   }
/*     */   
/*     */   public RotationStop getRotation() {
/* 118 */     return this.rotation;
/*     */   }
/*     */   
/*     */   public void setRotation(RotationStop value) {
/* 130 */     this.rotation = value;
/*     */   }
/*     */   
/*     */   public int getScaleFactor() {
/* 138 */     return this.scaleFactor;
/*     */   }
/*     */   
/*     */   public void setScaleFactor(int value) {
/* 146 */     this.scaleFactor = value;
/*     */   }
/*     */   
/*     */   public int getPageNumber() {
/* 154 */     return this.pageNumber;
/*     */   }
/*     */   
/*     */   public void setPageNumber(int value) {
/* 162 */     this.pageNumber = value;
/*     */   }
/*     */   
/*     */   public boolean isWithAnnotations() {
/* 170 */     return this.withAnnotations;
/*     */   }
/*     */   
/*     */   public void setWithAnnotations(boolean value) {
/* 178 */     this.withAnnotations = value;
/*     */   }
/*     */   
/*     */   public RenderBoundRect getBoundRect() {
/* 190 */     return this.boundRect;
/*     */   }
/*     */   
/*     */   public void setBoundRect(RenderBoundRect value) {
/* 202 */     this.boundRect = value;
/*     */   }
/*     */   
/*     */   public String getRequestURL() {
/* 214 */     return this.requestURL;
/*     */   }
/*     */   
/*     */   public void setRequestURL(String value) {
/* 226 */     this.requestURL = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\RenderOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */