/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentUpdate.DefinitionSecurity;
/*     */ import ap.quantas.com.imaging.documentUpdate.DocumentSecurity;
/*     */ import ap.quantas.com.imaging.documentUpdate.SecurityMemberType;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlSeeAlso;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "BaseSecurity", propOrder = {"guid", "name", "type"})
/*     */ @XmlSeeAlso({DocumentSecurity.class, DefinitionSecurity.class})
/*     */ public abstract class BaseSecurity {
/*     */   protected String guid;
/*     */   
/*     */   protected String name;
/*     */   
/*     */   protected SecurityMemberType type;
/*     */   
/*     */   public String getGuid() {
/*  56 */     return this.guid;
/*     */   }
/*     */   
/*     */   public void setGuid(String value) {
/*  68 */     this.guid = value;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  80 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String value) {
/*  92 */     this.name = value;
/*     */   }
/*     */   
/*     */   public SecurityMemberType getType() {
/* 104 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(SecurityMemberType value) {
/* 116 */     this.type = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\BaseSecurity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */