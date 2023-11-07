/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "setSupportingContent", propOrder = {"documentId", "key", "fileName", "data"})
/*     */ public class SetSupportingContent {
/*     */   protected String documentId;
/*     */   
/*     */   @XmlElement(required = true)
/*     */   protected String key;
/*     */   
/*     */   @XmlElement(required = true)
/*     */   protected String fileName;
/*     */   
/*     */   @XmlElement(required = true)
/*     */   protected byte[] data;
/*     */   
/*     */   public String getDocumentId() {
/*  58 */     return this.documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String value) {
/*  70 */     this.documentId = value;
/*     */   }
/*     */   
/*     */   public String getKey() {
/*  82 */     return this.key;
/*     */   }
/*     */   
/*     */   public void setKey(String value) {
/*  94 */     this.key = value;
/*     */   }
/*     */   
/*     */   public String getFileName() {
/* 106 */     return this.fileName;
/*     */   }
/*     */   
/*     */   public void setFileName(String value) {
/* 118 */     this.fileName = value;
/*     */   }
/*     */   
/*     */   public byte[] getData() {
/* 129 */     return this.data;
/*     */   }
/*     */   
/*     */   public void setData(byte[] value) {
/* 140 */     this.data = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\SetSupportingContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */