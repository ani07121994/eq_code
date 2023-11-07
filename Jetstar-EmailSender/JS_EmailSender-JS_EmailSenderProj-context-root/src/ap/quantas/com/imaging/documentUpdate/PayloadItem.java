/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentUpdate.WorkflowFunction;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElementRef;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "PayloadItem", propOrder = {"key", "mappingFunction", "value", "xmlType"})
/*     */ public class PayloadItem {
/*     */   protected String key;
/*     */   
/*     */   protected WorkflowFunction mappingFunction;
/*     */   
/*     */   @XmlElementRef(name = "value", type = JAXBElement.class)
/*     */   protected JAXBElement<String> value;
/*     */   
/*     */   protected String xmlType;
/*     */   
/*     */   public String getKey() {
/*  57 */     return this.key;
/*     */   }
/*     */   
/*     */   public void setKey(String value) {
/*  69 */     this.key = value;
/*     */   }
/*     */   
/*     */   public WorkflowFunction getMappingFunction() {
/*  81 */     return this.mappingFunction;
/*     */   }
/*     */   
/*     */   public void setMappingFunction(WorkflowFunction value) {
/*  93 */     this.mappingFunction = value;
/*     */   }
/*     */   
/*     */   public JAXBElement<String> getValue() {
/* 105 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setValue(JAXBElement<String> value) {
/* 117 */     this.value = value;
/*     */   }
/*     */   
/*     */   public String getXmlType() {
/* 129 */     return this.xmlType;
/*     */   }
/*     */   
/*     */   public void setXmlType(String value) {
/* 141 */     this.xmlType = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\PayloadItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */