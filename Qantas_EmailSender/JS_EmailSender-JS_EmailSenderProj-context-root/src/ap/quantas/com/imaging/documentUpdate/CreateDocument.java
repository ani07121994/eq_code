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
/*     */ @XmlType(name = "createDocument", propOrder = {"uploadToken", "applicationId", "fieldValues", "submitToWorkflow"})
/*     */ public class CreateDocument {
/*     */   protected String uploadToken;
/*     */   
/*     */   protected NameId applicationId;
/*     */   
/*     */   protected List<FieldValue> fieldValues;
/*     */   
/*     */   protected boolean submitToWorkflow;
/*     */   
/*     */   public String getUploadToken() {
/*  56 */     return this.uploadToken;
/*     */   }
/*     */   
/*     */   public void setUploadToken(String value) {
/*  68 */     this.uploadToken = value;
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
/*     */   public boolean isSubmitToWorkflow() {
/* 129 */     return this.submitToWorkflow;
/*     */   }
/*     */   
/*     */   public void setSubmitToWorkflow(boolean value) {
/* 137 */     this.submitToWorkflow = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\CreateDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */