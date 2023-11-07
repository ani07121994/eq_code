/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElementRef;
/*     */ import javax.xml.bind.annotation.XmlSchemaType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ import javax.xml.datatype.XMLGregorianCalendar;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "DocumentProperties", propOrder = {"version", "isLatestVersion", "lastModifiedBy", "lastModifiedDate", "creator", "createDate", "lockedBy", "docUrl", "mimeType", "size", "applicationId", "applicationName", "batchId", "status", "volumeDate", "volume"})
/*     */ public class DocumentProperties {
/*     */   protected long version;
/*     */   
/*     */   protected boolean isLatestVersion;
/*     */   
/*     */   protected String lastModifiedBy;
/*     */   
/*     */   @XmlSchemaType(name = "dateTime")
/*     */   protected XMLGregorianCalendar lastModifiedDate;
/*     */   
/*     */   protected String creator;
/*     */   
/*     */   @XmlSchemaType(name = "dateTime")
/*     */   protected XMLGregorianCalendar createDate;
/*     */   
/*     */   protected String lockedBy;
/*     */   
/*     */   protected String docUrl;
/*     */   
/*     */   protected String mimeType;
/*     */   
/*     */   protected long size;
/*     */   
/*     */   protected long applicationId;
/*     */   
/*     */   protected String applicationName;
/*     */   
/*     */   protected long batchId;
/*     */   
/*     */   protected String status;
/*     */   
/*     */   @XmlElementRef(name = "volumeDate", type = JAXBElement.class)
/*     */   protected JAXBElement<XMLGregorianCalendar> volumeDate;
/*     */   
/*     */   @XmlElementRef(name = "volume", type = JAXBElement.class)
/*     */   protected JAXBElement<String> volume;
/*     */   
/*     */   public long getVersion() {
/*  94 */     return this.version;
/*     */   }
/*     */   
/*     */   public void setVersion(long value) {
/* 102 */     this.version = value;
/*     */   }
/*     */   
/*     */   public boolean isIsLatestVersion() {
/* 110 */     return this.isLatestVersion;
/*     */   }
/*     */   
/*     */   public void setIsLatestVersion(boolean value) {
/* 118 */     this.isLatestVersion = value;
/*     */   }
/*     */   
/*     */   public String getLastModifiedBy() {
/* 130 */     return this.lastModifiedBy;
/*     */   }
/*     */   
/*     */   public void setLastModifiedBy(String value) {
/* 142 */     this.lastModifiedBy = value;
/*     */   }
/*     */   
/*     */   public XMLGregorianCalendar getLastModifiedDate() {
/* 154 */     return this.lastModifiedDate;
/*     */   }
/*     */   
/*     */   public void setLastModifiedDate(XMLGregorianCalendar value) {
/* 166 */     this.lastModifiedDate = value;
/*     */   }
/*     */   
/*     */   public String getCreator() {
/* 178 */     return this.creator;
/*     */   }
/*     */   
/*     */   public void setCreator(String value) {
/* 190 */     this.creator = value;
/*     */   }
/*     */   
/*     */   public XMLGregorianCalendar getCreateDate() {
/* 202 */     return this.createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(XMLGregorianCalendar value) {
/* 214 */     this.createDate = value;
/*     */   }
/*     */   
/*     */   public String getLockedBy() {
/* 226 */     return this.lockedBy;
/*     */   }
/*     */   
/*     */   public void setLockedBy(String value) {
/* 238 */     this.lockedBy = value;
/*     */   }
/*     */   
/*     */   public String getDocUrl() {
/* 250 */     return this.docUrl;
/*     */   }
/*     */   
/*     */   public void setDocUrl(String value) {
/* 262 */     this.docUrl = value;
/*     */   }
/*     */   
/*     */   public String getMimeType() {
/* 274 */     return this.mimeType;
/*     */   }
/*     */   
/*     */   public void setMimeType(String value) {
/* 286 */     this.mimeType = value;
/*     */   }
/*     */   
/*     */   public long getSize() {
/* 294 */     return this.size;
/*     */   }
/*     */   
/*     */   public void setSize(long value) {
/* 302 */     this.size = value;
/*     */   }
/*     */   
/*     */   public long getApplicationId() {
/* 310 */     return this.applicationId;
/*     */   }
/*     */   
/*     */   public void setApplicationId(long value) {
/* 318 */     this.applicationId = value;
/*     */   }
/*     */   
/*     */   public String getApplicationName() {
/* 330 */     return this.applicationName;
/*     */   }
/*     */   
/*     */   public void setApplicationName(String value) {
/* 342 */     this.applicationName = value;
/*     */   }
/*     */   
/*     */   public long getBatchId() {
/* 350 */     return this.batchId;
/*     */   }
/*     */   
/*     */   public void setBatchId(long value) {
/* 358 */     this.batchId = value;
/*     */   }
/*     */   
/*     */   public String getStatus() {
/* 370 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String value) {
/* 382 */     this.status = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<XMLGregorianCalendar> getVolumeDate() {
/* 394 */     return this.volumeDate;
/*     */   }
/*     */   
/*     */   public void setVolumeDate(JAXBElement<XMLGregorianCalendar> value) {
/* 406 */     this.volumeDate = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<String> getVolume() {
/* 418 */     return this.volume;
/*     */   }
/*     */   
/*     */   public void setVolume(JAXBElement<String> value) {
/* 430 */     this.volume = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\DocumentProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */