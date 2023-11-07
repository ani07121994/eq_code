/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlEnum;
/*     */ import javax.xml.bind.annotation.XmlEnumValue;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlType(name = "workflowFunction")
/*     */ @XmlEnum
/*     */ public enum WorkflowFunction {
/*  49 */   DOC_ID("DocId"),
/*  51 */   DOC_NAME("DocName"),
/*  53 */   VERSION("Version"),
/*  55 */   CREATE_BY("CreateBy"),
/*  57 */   CREATE_DATE("CreateDate"),
/*  59 */   MODIFY_BY("ModifyBy"),
/*  61 */   MODIFY_DATE("ModifyDate"),
/*  63 */   MIME_TYPE("MimeType"),
/*  65 */   DOC_URL("DocUrl"),
/*  67 */   DOC_URL_PATH("DocUrlPath"),
/*  69 */   DOC_URL_ROOT("DocUrlRoot"),
/*  71 */   DOC_SIZE("DocSize"),
/*  73 */   VOLUME_DATE("VolumeDate"),
/*  75 */   VOLUME("Volume"),
/*  77 */   APP_ID("AppId"),
/*  79 */   APP_NAME("AppName"),
/*  81 */   BATCH_ID("BatchId"),
/*  83 */   FIELD_VALUE("FieldValue"),
/*  85 */   SUPPORTING_CONTENT("SupportingContent"),
/*  87 */   TRUE("True"),
/*  89 */   FALSE("False"),
/*  91 */   FORMAT_VALUE("FormatValue"),
/*  93 */   POLICY_OVERRIDE("PolicyOverride");
/*     */   
/*     */   private final String value;
/*     */   
/*     */   WorkflowFunction(String v) {
/*  98 */     this.value = v;
/*     */   }
/*     */   
/*     */   public String value() {
/* 102 */     return this.value;
/*     */   }
/*     */   
/*     */   public static ap.quantas.com.imaging.documentUpdate.WorkflowFunction fromValue(String v) {
/* 106 */     for (ap.quantas.com.imaging.documentUpdate.WorkflowFunction c : values()) {
/* 107 */       if (c.value.equals(v))
/* 108 */         return c; 
/*     */     } 
/* 111 */     throw new IllegalArgumentException(v);
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\WorkflowFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */