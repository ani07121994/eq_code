/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlElementRef;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "Application", propOrder = {"properties", "fieldDefinitions", "applicationPermissions", "documentPermissions", "security", "documentSecurity", "lifecyclePolicy", "bpelConfig", "history"})
/*     */ public class Application
/*     */   extends Definition
/*     */ {
/*     */   @XmlElementRef(name = "properties", type = JAXBElement.class)
/*     */   protected JAXBElement<ApplicationProperties> properties;
/*     */   protected FieldDefinitions fieldDefinitions;
/*     */   @XmlElementRef(name = "applicationPermissions", type = JAXBElement.class)
/*     */   protected JAXBElement<DefinitionPermissions> applicationPermissions;
/*     */   @XmlElementRef(name = "documentPermissions", type = JAXBElement.class)
/*     */   protected JAXBElement<DocumentPermissions> documentPermissions;
/*     */   @XmlElementRef(name = "security", type = JAXBElement.class)
/*     */   protected JAXBElement<Security> security;
/*     */   @XmlElementRef(name = "documentSecurity", type = JAXBElement.class)
/*     */   protected JAXBElement<DocumentSecurity> documentSecurity;
/*     */   @XmlElementRef(name = "lifecyclePolicy", type = JAXBElement.class)
/*     */   protected JAXBElement<LifecyclePolicy> lifecyclePolicy;
/*     */   @XmlElementRef(name = "bpelConfig", type = JAXBElement.class)
/*     */   protected JAXBElement<BpelConfig> bpelConfig;
/*     */   protected History history;
/*     */   
/*     */   public JAXBElement<ApplicationProperties> getProperties() {
/* 123 */     return this.properties;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperties(JAXBElement<ApplicationProperties> value) {
/* 135 */     this.properties = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FieldDefinitions getFieldDefinitions() {
/* 147 */     return this.fieldDefinitions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFieldDefinitions(FieldDefinitions value) {
/* 159 */     this.fieldDefinitions = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAXBElement<DefinitionPermissions> getApplicationPermissions() {
/* 171 */     return this.applicationPermissions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setApplicationPermissions(JAXBElement<DefinitionPermissions> value) {
/* 183 */     this.applicationPermissions = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAXBElement<DocumentPermissions> getDocumentPermissions() {
/* 195 */     return this.documentPermissions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentPermissions(JAXBElement<DocumentPermissions> value) {
/* 207 */     this.documentPermissions = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAXBElement<Security> getSecurity() {
/* 219 */     return this.security;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSecurity(JAXBElement<Security> value) {
/* 231 */     this.security = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAXBElement<DocumentSecurity> getDocumentSecurity() {
/* 243 */     return this.documentSecurity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentSecurity(JAXBElement<DocumentSecurity> value) {
/* 255 */     this.documentSecurity = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAXBElement<LifecyclePolicy> getLifecyclePolicy() {
/* 267 */     return this.lifecyclePolicy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLifecyclePolicy(JAXBElement<LifecyclePolicy> value) {
/* 279 */     this.lifecyclePolicy = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAXBElement<BpelConfig> getBpelConfig() {
/* 291 */     return this.bpelConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBpelConfig(JAXBElement<BpelConfig> value) {
/* 303 */     this.bpelConfig = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public History getHistory() {
/* 315 */     return this.history;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHistory(History value) {
/* 327 */     this.history = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name = "", propOrder = {"documentSecurityItem"})
/*     */   public static class DocumentSecurity
/*     */   {
/*     */     protected List<DocumentSecurity> documentSecurityItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<DocumentSecurity> getDocumentSecurityItem() {
/* 381 */       if (this.documentSecurityItem == null) {
/* 382 */         this.documentSecurityItem = new ArrayList<DocumentSecurity>();
/*     */       }
/* 384 */       return this.documentSecurityItem;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name = "", propOrder = {"fieldDefinition"})
/*     */   public static class FieldDefinitions
/*     */   {
/*     */     @XmlElement(nillable = true)
/*     */     protected List<FieldDefinition> fieldDefinition;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<FieldDefinition> getFieldDefinition() {
/* 441 */       if (this.fieldDefinition == null) {
/* 442 */         this.fieldDefinition = new ArrayList<FieldDefinition>();
/*     */       }
/* 444 */       return this.fieldDefinition;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name = "", propOrder = {"historyItem"})
/*     */   public static class History
/*     */   {
/*     */     protected List<AuditEvent> historyItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<AuditEvent> getHistoryItem() {
/* 500 */       if (this.historyItem == null) {
/* 501 */         this.historyItem = new ArrayList<AuditEvent>();
/*     */       }
/* 503 */       return this.historyItem;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name = "", propOrder = {"securityItem"})
/*     */   public static class Security
/*     */   {
/*     */     protected List<DefinitionSecurity> securityItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<DefinitionSecurity> getSecurityItem() {
/* 559 */       if (this.securityItem == null) {
/* 560 */         this.securityItem = new ArrayList<DefinitionSecurity>();
/*     */       }
/* 562 */       return this.securityItem;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\documentUpdate\Application.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */