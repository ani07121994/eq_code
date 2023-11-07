/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentUpdate.ApplicationProperties;
/*     */ import ap.quantas.com.imaging.documentUpdate.BpelConfig;
/*     */ import ap.quantas.com.imaging.documentUpdate.Definition;
/*     */ import ap.quantas.com.imaging.documentUpdate.DefinitionPermissions;
/*     */ import ap.quantas.com.imaging.documentUpdate.DocumentPermissions;
/*     */ import ap.quantas.com.imaging.documentUpdate.LifecyclePolicy;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElementRef;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "Application", propOrder = {"applicationProperties", "fieldDefinitions", "applicationPermissions", "documentPermissions", "security", "documentSecurity", "lifecyclePolicy", "bpelConfig", "history"})
/*     */ public class Application extends Definition {
/*     */   @XmlElementRef(name = "applicationProperties", type = JAXBElement.class)
/*     */   protected JAXBElement<ApplicationProperties> applicationProperties;
/*     */   
/*     */   protected FieldDefinitions fieldDefinitions;
/*     */   
/*     */   @XmlElementRef(name = "applicationPermissions", type = JAXBElement.class)
/*     */   protected JAXBElement<DefinitionPermissions> applicationPermissions;
/*     */   
/*     */   @XmlElementRef(name = "documentPermissions", type = JAXBElement.class)
/*     */   protected JAXBElement<DocumentPermissions> documentPermissions;
/*     */   
/*     */   @XmlElementRef(name = "security", type = JAXBElement.class)
/*     */   protected JAXBElement<Security> security;
/*     */   
/*     */   @XmlElementRef(name = "documentSecurity", type = JAXBElement.class)
/*     */   protected JAXBElement<DocumentSecurity> documentSecurity;
/*     */   
/*     */   @XmlElementRef(name = "lifecyclePolicy", type = JAXBElement.class)
/*     */   protected JAXBElement<LifecyclePolicy> lifecyclePolicy;
/*     */   
/*     */   @XmlElementRef(name = "bpelConfig", type = JAXBElement.class)
/*     */   protected JAXBElement<BpelConfig> bpelConfig;
/*     */   
/*     */   protected History history;
/*     */   
/*     */   public JAXBElement<ApplicationProperties> getApplicationProperties() {
/* 123 */     return this.applicationProperties;
/*     */   }
/*     */   
/*     */   public void setApplicationProperties(JAXBElement<ApplicationProperties> value) {
/* 135 */     this.applicationProperties = value;
/*     */   }
/*     */   
/*     */   public FieldDefinitions getFieldDefinitions() {
/* 147 */     return this.fieldDefinitions;
/*     */   }
/*     */   
/*     */   public void setFieldDefinitions(FieldDefinitions value) {
/* 159 */     this.fieldDefinitions = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<DefinitionPermissions> getApplicationPermissions() {
/* 171 */     return this.applicationPermissions;
/*     */   }
/*     */   
/*     */   public void setApplicationPermissions(JAXBElement<DefinitionPermissions> value) {
/* 183 */     this.applicationPermissions = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<DocumentPermissions> getDocumentPermissions() {
/* 195 */     return this.documentPermissions;
/*     */   }
/*     */   
/*     */   public void setDocumentPermissions(JAXBElement<DocumentPermissions> value) {
/* 207 */     this.documentPermissions = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<Security> getSecurity() {
/* 219 */     return this.security;
/*     */   }
/*     */   
/*     */   public void setSecurity(JAXBElement<Security> value) {
/* 231 */     this.security = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<DocumentSecurity> getDocumentSecurity() {
/* 243 */     return this.documentSecurity;
/*     */   }
/*     */   
/*     */   public void setDocumentSecurity(JAXBElement<DocumentSecurity> value) {
/* 255 */     this.documentSecurity = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<LifecyclePolicy> getLifecyclePolicy() {
/* 267 */     return this.lifecyclePolicy;
/*     */   }
/*     */   
/*     */   public void setLifecyclePolicy(JAXBElement<LifecyclePolicy> value) {
/* 279 */     this.lifecyclePolicy = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<BpelConfig> getBpelConfig() {
/* 291 */     return this.bpelConfig;
/*     */   }
/*     */   
/*     */   public void setBpelConfig(JAXBElement<BpelConfig> value) {
/* 303 */     this.bpelConfig = value;
/*     */   }
/*     */   
/*     */   public History getHistory() {
/* 315 */     return this.history;
/*     */   }
/*     */   
/*     */   public void setHistory(History value) {
/* 327 */     this.history = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\Application.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */