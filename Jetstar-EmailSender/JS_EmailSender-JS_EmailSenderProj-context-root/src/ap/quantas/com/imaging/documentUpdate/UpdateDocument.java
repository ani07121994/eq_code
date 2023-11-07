/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentUpdate.FieldValue;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "updateDocument", propOrder = {"documentId", "uploadToken", "fieldValues", "reserved"})
/*     */ public class UpdateDocument {
/*     */   protected String documentId;
/*     */   
/*     */   protected String uploadToken;
/*     */   
/*     */   protected List<FieldValue> fieldValues;
/*     */   
/*     */   protected boolean reserved;
/*     */   
/*     */   public String getDocumentId() {
/*  56 */     return this.documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String value) {
/*  68 */     this.documentId = value;
/*     */   }
/*     */   
/*     */   public String getUploadToken() {
/*  80 */     return this.uploadToken;
/*     */   }
/*     */   
/*     */   public void setUploadToken(String value) {
/*  92 */     this.uploadToken = value;
/*     */   }
/*     */   
/*     */   public List<FieldValue> getFieldValues() {
/* 118 */     if (this.fieldValues == null)
/* 119 */       this.fieldValues = new ArrayList<FieldValue>(); 
/* 121 */     return this.fieldValues;
/*     */   }
/*     */   
/*     */   public boolean isReserved() {
/* 129 */     return this.reserved;
/*     */   }
/*     */   
/*     */   public void setReserved(boolean value) {
/* 137 */     this.reserved = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\UpdateDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */