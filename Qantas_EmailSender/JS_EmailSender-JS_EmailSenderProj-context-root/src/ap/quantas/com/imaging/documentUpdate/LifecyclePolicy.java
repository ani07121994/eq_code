/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElementRef;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "LifecyclePolicy", propOrder = {"retentionPolicy", "storagePolicy", "supportingContentVolume"})
/*     */ public class LifecyclePolicy {
/*     */   protected String retentionPolicy;
/*     */   
/*     */   @XmlElementRef(name = "storagePolicy", type = JAXBElement.class)
/*     */   protected JAXBElement<StoragePolicy> storagePolicy;
/*     */   
/*     */   protected String supportingContentVolume;
/*     */   
/*     */   public String getRetentionPolicy() {
/*  66 */     return this.retentionPolicy;
/*     */   }
/*     */   
/*     */   public void setRetentionPolicy(String value) {
/*  78 */     this.retentionPolicy = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<StoragePolicy> getStoragePolicy() {
/*  90 */     return this.storagePolicy;
/*     */   }
/*     */   
/*     */   public void setStoragePolicy(JAXBElement<StoragePolicy> value) {
/* 102 */     this.storagePolicy = value;
/*     */   }
/*     */   
/*     */   public String getSupportingContentVolume() {
/* 114 */     return this.supportingContentVolume;
/*     */   }
/*     */   
/*     */   public void setSupportingContentVolume(String value) {
/* 126 */     this.supportingContentVolume = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\LifecyclePolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */