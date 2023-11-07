/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentUpdate.NameId;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElementRef;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "BpelConfig", propOrder = {"enabled", "connection", "composite", "service", "operation", "payloadMapping"})
/*     */ public class BpelConfig {
/*     */   protected boolean enabled;
/*     */   
/*     */   protected NameId connection;
/*     */   
/*     */   protected String composite;
/*     */   
/*     */   protected String service;
/*     */   
/*     */   protected String operation;
/*     */   
/*     */   @XmlElementRef(name = "payloadMapping", type = JAXBElement.class)
/*     */   protected JAXBElement<PayloadMapping> payloadMapping;
/*     */   
/*     */   public boolean isEnabled() {
/*  71 */     return this.enabled;
/*     */   }
/*     */   
/*     */   public void setEnabled(boolean value) {
/*  79 */     this.enabled = value;
/*     */   }
/*     */   
/*     */   public NameId getConnection() {
/*  91 */     return this.connection;
/*     */   }
/*     */   
/*     */   public void setConnection(NameId value) {
/* 103 */     this.connection = value;
/*     */   }
/*     */   
/*     */   public String getComposite() {
/* 115 */     return this.composite;
/*     */   }
/*     */   
/*     */   public void setComposite(String value) {
/* 127 */     this.composite = value;
/*     */   }
/*     */   
/*     */   public String getService() {
/* 139 */     return this.service;
/*     */   }
/*     */   
/*     */   public void setService(String value) {
/* 151 */     this.service = value;
/*     */   }
/*     */   
/*     */   public String getOperation() {
/* 163 */     return this.operation;
/*     */   }
/*     */   
/*     */   public void setOperation(String value) {
/* 175 */     this.operation = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<PayloadMapping> getPayloadMapping() {
/* 187 */     return this.payloadMapping;
/*     */   }
/*     */   
/*     */   public void setPayloadMapping(JAXBElement<PayloadMapping> value) {
/* 199 */     this.payloadMapping = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\BpelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */