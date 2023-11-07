/*     */ package com.qantas.eq.OutboundService.genJava;
/*     */ 
/*     */ import com.qantas.eq.OutboundService.genJava.QFEQIFEBSSOAOUT;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlElementDecl;
/*     */ import javax.xml.bind.annotation.XmlRegistry;
/*     */ import javax.xml.namespace.QName;
/*     */ 
/*     */ @XmlRegistry
/*     */ public class ObjectFactory {
/*  27 */   private static final QName _QFEQIFEBSSOAOUT_QNAME = new QName("http://xmlns.oracle.com/xdb/BOLINF", "QFEQIF_EBS_SOA_OUT");
/*     */   
/*  28 */   private static final QName _QFEQIFEBSSOAOUTEVENTNAME_QNAME = new QName("", "EVENT_NAME");
/*     */   
/*  29 */   private static final QName _QFEQIFEBSSOAOUTEVENTKEY_QNAME = new QName("", "EVENT_KEY");
/*     */   
/*  30 */   private static final QName _QFEQIFEBSSOAOUTFILENAME_QNAME = new QName("", "FILE_NAME");
/*     */   
/*  31 */   private static final QName _QFEQIFEBSSOAOUTQUEUEDATE_QNAME = new QName("", "QUEUE_DATE");
/*     */   
/*  32 */   private static final QName _QFEQIFEBSSOAOUTPAYLOAD_QNAME = new QName("", "PAYLOAD");
/*     */   
/*  33 */   private static final QName _QFEQIFEBSSOAOUTCMRETMSG_QNAME = new QName("", "CMRETMSG");
/*     */   
/*  34 */   private static final QName _QFEQIFEBSSOAOUTCMREQID_QNAME = new QName("", "CMREQID");
/*     */   
/*  35 */   private static final QName _QFEQIFEBSSOAOUTITEMKEY_QNAME = new QName("", "ITEMKEY");
/*     */   
/*  36 */   private static final QName _QFEQIFEBSSOAOUTCMRETCODE_QNAME = new QName("", "CMRETCODE");
/*     */   
/*  37 */   private static final QName _QFEQIFEBSSOAOUTFILEPATH_QNAME = new QName("", "FILE_PATH");
/*     */   
/*  38 */   private static final QName _QFEQIFEBSSOAOUTCMRECCNT_QNAME = new QName("", "CMRECCNT");
/*     */   
/*  39 */   private static final QName _QFEQIFEBSSOAOUTITEMTYPE_QNAME = new QName("", "ITEMTYPE");
/*     */   
/*     */   public QFEQIFEBSSOAOUT createQFEQIFEBSSOAOUT() {
/*  53 */     return new QFEQIFEBSSOAOUT();
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://xmlns.oracle.com/xdb/BOLINF", name = "QFEQIF_EBS_SOA_OUT")
/*     */   public JAXBElement<QFEQIFEBSSOAOUT> createQFEQIFEBSSOAOUT(QFEQIFEBSSOAOUT value) {
/*  62 */     return new JAXBElement<QFEQIFEBSSOAOUT>(_QFEQIFEBSSOAOUT_QNAME, QFEQIFEBSSOAOUT.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "EVENT_NAME", scope = QFEQIFEBSSOAOUT.class)
/*     */   public JAXBElement<String> createQFEQIFEBSSOAOUTEVENTNAME(String value) {
/*  71 */     return new JAXBElement<String>(_QFEQIFEBSSOAOUTEVENTNAME_QNAME, String.class, QFEQIFEBSSOAOUT.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "EVENT_KEY", scope = QFEQIFEBSSOAOUT.class)
/*     */   public JAXBElement<String> createQFEQIFEBSSOAOUTEVENTKEY(String value) {
/*  80 */     return new JAXBElement<String>(_QFEQIFEBSSOAOUTEVENTKEY_QNAME, String.class, QFEQIFEBSSOAOUT.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "FILE_NAME", scope = QFEQIFEBSSOAOUT.class)
/*     */   public JAXBElement<String> createQFEQIFEBSSOAOUTFILENAME(String value) {
/*  89 */     return new JAXBElement<String>(_QFEQIFEBSSOAOUTFILENAME_QNAME, String.class, QFEQIFEBSSOAOUT.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "QUEUE_DATE", scope = QFEQIFEBSSOAOUT.class)
/*     */   public JAXBElement<String> createQFEQIFEBSSOAOUTQUEUEDATE(String value) {
/*  98 */     return new JAXBElement<String>(_QFEQIFEBSSOAOUTQUEUEDATE_QNAME, String.class, QFEQIFEBSSOAOUT.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "PAYLOAD", scope = QFEQIFEBSSOAOUT.class)
/*     */   public JAXBElement<String> createQFEQIFEBSSOAOUTPAYLOAD(String value) {
/* 107 */     return new JAXBElement<String>(_QFEQIFEBSSOAOUTPAYLOAD_QNAME, String.class, QFEQIFEBSSOAOUT.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "CMRETMSG", scope = QFEQIFEBSSOAOUT.class)
/*     */   public JAXBElement<String> createQFEQIFEBSSOAOUTCMRETMSG(String value) {
/* 116 */     return new JAXBElement<String>(_QFEQIFEBSSOAOUTCMRETMSG_QNAME, String.class, QFEQIFEBSSOAOUT.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "CMREQID", scope = QFEQIFEBSSOAOUT.class)
/*     */   public JAXBElement<String> createQFEQIFEBSSOAOUTCMREQID(String value) {
/* 125 */     return new JAXBElement<String>(_QFEQIFEBSSOAOUTCMREQID_QNAME, String.class, QFEQIFEBSSOAOUT.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "ITEMKEY", scope = QFEQIFEBSSOAOUT.class)
/*     */   public JAXBElement<String> createQFEQIFEBSSOAOUTITEMKEY(String value) {
/* 134 */     return new JAXBElement<String>(_QFEQIFEBSSOAOUTITEMKEY_QNAME, String.class, QFEQIFEBSSOAOUT.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "CMRETCODE", scope = QFEQIFEBSSOAOUT.class)
/*     */   public JAXBElement<String> createQFEQIFEBSSOAOUTCMRETCODE(String value) {
/* 143 */     return new JAXBElement<String>(_QFEQIFEBSSOAOUTCMRETCODE_QNAME, String.class, QFEQIFEBSSOAOUT.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "FILE_PATH", scope = QFEQIFEBSSOAOUT.class)
/*     */   public JAXBElement<String> createQFEQIFEBSSOAOUTFILEPATH(String value) {
/* 152 */     return new JAXBElement<String>(_QFEQIFEBSSOAOUTFILEPATH_QNAME, String.class, QFEQIFEBSSOAOUT.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "CMRECCNT", scope = QFEQIFEBSSOAOUT.class)
/*     */   public JAXBElement<String> createQFEQIFEBSSOAOUTCMRECCNT(String value) {
/* 161 */     return new JAXBElement<String>(_QFEQIFEBSSOAOUTCMRECCNT_QNAME, String.class, QFEQIFEBSSOAOUT.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "ITEMTYPE", scope = QFEQIFEBSSOAOUT.class)
/*     */   public JAXBElement<String> createQFEQIFEBSSOAOUTITEMTYPE(String value) {
/* 170 */     return new JAXBElement<String>(_QFEQIFEBSSOAOUTITEMTYPE_QNAME, String.class, QFEQIFEBSSOAOUT.class, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\OutboundService\genJava\ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */