/*     */ package com.qantas.eq.OutboundService.genJava;
/*     */ 
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElementRef;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "QFEQIF_EBS_SOA_OUT", propOrder = {"itemtype", "itemkey", "filename", "filepath", "cmreqid", "cmretcode", "cmretmsg", "cmreccnt", "eventname", "eventkey", "payload", "queuedate"})
/*     */ public class QFEQIFEBSSOAOUT {
/*     */   @XmlElementRef(name = "ITEMTYPE", type = JAXBElement.class)
/*     */   protected JAXBElement<String> itemtype;
/*     */   
/*     */   @XmlElementRef(name = "ITEMKEY", type = JAXBElement.class)
/*     */   protected JAXBElement<String> itemkey;
/*     */   
/*     */   @XmlElementRef(name = "FILE_NAME", type = JAXBElement.class)
/*     */   protected JAXBElement<String> filename;
/*     */   
/*     */   @XmlElementRef(name = "FILE_PATH", type = JAXBElement.class)
/*     */   protected JAXBElement<String> filepath;
/*     */   
/*     */   @XmlElementRef(name = "CMREQID", type = JAXBElement.class)
/*     */   protected JAXBElement<String> cmreqid;
/*     */   
/*     */   @XmlElementRef(name = "CMRETCODE", type = JAXBElement.class)
/*     */   protected JAXBElement<String> cmretcode;
/*     */   
/*     */   @XmlElementRef(name = "CMRETMSG", type = JAXBElement.class)
/*     */   protected JAXBElement<String> cmretmsg;
/*     */   
/*     */   @XmlElementRef(name = "CMRECCNT", type = JAXBElement.class)
/*     */   protected JAXBElement<String> cmreccnt;
/*     */   
/*     */   @XmlElementRef(name = "EVENT_NAME", type = JAXBElement.class)
/*     */   protected JAXBElement<String> eventname;
/*     */   
/*     */   @XmlElementRef(name = "EVENT_KEY", type = JAXBElement.class)
/*     */   protected JAXBElement<String> eventkey;
/*     */   
/*     */   @XmlElementRef(name = "PAYLOAD", type = JAXBElement.class)
/*     */   protected JAXBElement<String> payload;
/*     */   
/*     */   @XmlElementRef(name = "QUEUE_DATE", type = JAXBElement.class)
/*     */   protected JAXBElement<String> queuedate;
/*     */   
/*     */   public JAXBElement<String> getITEMTYPE() {
/* 152 */     return this.itemtype;
/*     */   }
/*     */   
/*     */   public void setITEMTYPE(JAXBElement<String> value) {
/* 164 */     this.itemtype = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<String> getITEMKEY() {
/* 176 */     return this.itemkey;
/*     */   }
/*     */   
/*     */   public void setITEMKEY(JAXBElement<String> value) {
/* 188 */     this.itemkey = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<String> getFILENAME() {
/* 200 */     return this.filename;
/*     */   }
/*     */   
/*     */   public void setFILENAME(JAXBElement<String> value) {
/* 212 */     this.filename = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<String> getFILEPATH() {
/* 224 */     return this.filepath;
/*     */   }
/*     */   
/*     */   public void setFILEPATH(JAXBElement<String> value) {
/* 236 */     this.filepath = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<String> getCMREQID() {
/* 248 */     return this.cmreqid;
/*     */   }
/*     */   
/*     */   public void setCMREQID(JAXBElement<String> value) {
/* 260 */     this.cmreqid = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<String> getCMRETCODE() {
/* 272 */     return this.cmretcode;
/*     */   }
/*     */   
/*     */   public void setCMRETCODE(JAXBElement<String> value) {
/* 284 */     this.cmretcode = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<String> getCMRETMSG() {
/* 296 */     return this.cmretmsg;
/*     */   }
/*     */   
/*     */   public void setCMRETMSG(JAXBElement<String> value) {
/* 308 */     this.cmretmsg = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<String> getCMRECCNT() {
/* 320 */     return this.cmreccnt;
/*     */   }
/*     */   
/*     */   public void setCMRECCNT(JAXBElement<String> value) {
/* 332 */     this.cmreccnt = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<String> getEVENTNAME() {
/* 344 */     return this.eventname;
/*     */   }
/*     */   
/*     */   public void setEVENTNAME(JAXBElement<String> value) {
/* 356 */     this.eventname = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<String> getEVENTKEY() {
/* 368 */     return this.eventkey;
/*     */   }
/*     */   
/*     */   public void setEVENTKEY(JAXBElement<String> value) {
/* 380 */     this.eventkey = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<String> getPAYLOAD() {
/* 392 */     return this.payload;
/*     */   }
/*     */   
/*     */   public void setPAYLOAD(JAXBElement<String> value) {
/* 404 */     this.payload = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<String> getQUEUEDATE() {
/* 416 */     return this.queuedate;
/*     */   }
/*     */   
/*     */   public void setQUEUEDATE(JAXBElement<String> value) {
/* 428 */     this.queuedate = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\OutboundService\genJava\QFEQIFEBSSOAOUT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */