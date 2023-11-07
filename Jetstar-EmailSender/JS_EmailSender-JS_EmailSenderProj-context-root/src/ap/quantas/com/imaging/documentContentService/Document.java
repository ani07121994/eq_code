/*     */ package ap.quantas.com.imaging.documentContentService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentContentService.DocumentPermissions;
/*     */ import ap.quantas.com.imaging.documentContentService.DocumentProperties;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElementRef;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "Document", propOrder = {"name", "id", "properties", "fieldValues", "documentPermissions", "history"})
/*     */ public class Document {
/*     */   protected String name;
/*     */   
/*     */   protected String id;
/*     */   
/*     */   @XmlElementRef(name = "properties", type = JAXBElement.class)
/*     */   protected JAXBElement<DocumentProperties> properties;
/*     */   
/*     */   @XmlElementRef(name = "fieldValues", type = JAXBElement.class)
/*     */   protected JAXBElement<FieldValues> fieldValues;
/*     */   
/*     */   @XmlElementRef(name = "documentPermissions", type = JAXBElement.class)
/*     */   protected JAXBElement<DocumentPermissions> documentPermissions;
/*     */   
/*     */   protected History history;
/*     */   
/*     */   public String getName() {
/*  87 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String value) {
/*  99 */     this.name = value;
/*     */   }
/*     */   
/*     */   public String getId() {
/* 111 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(String value) {
/* 123 */     this.id = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<DocumentProperties> getProperties() {
/* 135 */     return this.properties;
/*     */   }
/*     */   
/*     */   public void setProperties(JAXBElement<DocumentProperties> value) {
/* 147 */     this.properties = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<FieldValues> getFieldValues() {
/* 159 */     return this.fieldValues;
/*     */   }
/*     */   
/*     */   public void setFieldValues(JAXBElement<FieldValues> value) {
/* 171 */     this.fieldValues = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<DocumentPermissions> getDocumentPermissions() {
/* 183 */     return this.documentPermissions;
/*     */   }
/*     */   
/*     */   public void setDocumentPermissions(JAXBElement<DocumentPermissions> value) {
/* 195 */     this.documentPermissions = value;
/*     */   }
/*     */   
/*     */   public History getHistory() {
/* 207 */     return this.history;
/*     */   }
/*     */   
/*     */   public void setHistory(History value) {
/* 219 */     this.history = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\Document.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */