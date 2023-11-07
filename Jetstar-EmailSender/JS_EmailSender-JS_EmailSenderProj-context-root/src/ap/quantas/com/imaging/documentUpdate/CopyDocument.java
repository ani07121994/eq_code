/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentUpdate.FieldValue;
/*     */ import ap.quantas.com.imaging.documentUpdate.NameId;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "copyDocument", propOrder = {"documentId", "applicationId", "fieldValues", "copyAnnotations"})
/*     */ public class CopyDocument {
/*     */   protected String documentId;
/*     */   
/*     */   protected NameId applicationId;
/*     */   
/*     */   protected List<FieldValue> fieldValues;
/*     */   
/*     */   protected boolean copyAnnotations;
/*     */   
/*     */   public String getDocumentId() {
/*  56 */     return this.documentId;
/*     */   }
/*     */   
/*     */   public void setDocumentId(String value) {
/*  68 */     this.documentId = value;
/*     */   }
/*     */   
/*     */   public NameId getApplicationId() {
/*  80 */     return this.applicationId;
/*     */   }
/*     */   
/*     */   public void setApplicationId(NameId value) {
/*  92 */     this.applicationId = value;
/*     */   }
/*     */   
/*     */   public List<FieldValue> getFieldValues() {
/* 118 */     if (this.fieldValues == null)
/* 119 */       this.fieldValues = new ArrayList<FieldValue>(); 
/* 121 */     return this.fieldValues;
/*     */   }
/*     */   
/*     */   public boolean isCopyAnnotations() {
/* 129 */     return this.copyAnnotations;
/*     */   }
/*     */   
/*     */   public void setCopyAnnotations(boolean value) {
/* 137 */     this.copyAnnotations = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\CopyDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */