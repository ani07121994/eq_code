/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "LifecyclePolicy", propOrder = {"retentionPolicy", "storagePolicy", "supportingContentVolume"})
/*     */ public class LifecyclePolicy
/*     */ {
/*     */   protected String retentionPolicy;
/*     */   @XmlElementRef(name = "storagePolicy", type = JAXBElement.class)
/*     */   protected JAXBElement<StoragePolicy> storagePolicy;
/*     */   protected String supportingContentVolume;
/*     */   
/*     */   public String getRetentionPolicy() {
/*  66 */     return this.retentionPolicy;
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
/*     */   public void setRetentionPolicy(String value) {
/*  78 */     this.retentionPolicy = value;
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
/*     */   public JAXBElement<StoragePolicy> getStoragePolicy() {
/*  90 */     return this.storagePolicy;
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
/*     */   public void setStoragePolicy(JAXBElement<StoragePolicy> value) {
/* 102 */     this.storagePolicy = value;
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
/*     */   public String getSupportingContentVolume() {
/* 114 */     return this.supportingContentVolume;
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
/*     */   public void setSupportingContentVolume(String value) {
/* 126 */     this.supportingContentVolume = value;
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
/*     */   @XmlType(name = "", propOrder = {"storagePolicyItem"})
/*     */   public static class StoragePolicy
/*     */   {
/*     */     protected List<StorageStage> storagePolicyItem;
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
/*     */     public List<StorageStage> getStoragePolicyItem() {
/* 180 */       if (this.storagePolicyItem == null) {
/* 181 */         this.storagePolicyItem = new ArrayList<StorageStage>();
/*     */       }
/* 183 */       return this.storagePolicyItem;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\documentUpdate\LifecyclePolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */