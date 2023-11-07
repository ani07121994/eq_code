/*     */ package ap.quantas.com.imaging.documentContentService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentContentService.BaseId;
/*     */ import ap.quantas.com.imaging.documentContentService.TypedValue;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "FieldValue", propOrder = {"value"})
/*     */ public class FieldValue extends BaseId {
/*     */   protected TypedValue value;
/*     */   
/*     */   @XmlAttribute
/*     */   protected String name;
/*     */   
/*     */   @XmlAttribute(required = true)
/*     */   protected long id;
/*     */   
/*     */   public TypedValue getValue() {
/*  54 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setValue(TypedValue value) {
/*  66 */     this.value = value;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  78 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String value) {
/*  90 */     this.name = value;
/*     */   }
/*     */   
/*     */   public long getId() {
/*  98 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(long value) {
/* 106 */     this.id = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\FieldValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */