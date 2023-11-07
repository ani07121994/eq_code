/*     */ package ap.quantas.com.imaging.documentContentService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentContentService.BasePermissions;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "DocumentPermissions", propOrder = {"view", "write", "delete", "grantaccess", "lockAdministrator", "standard", "restricted", "hidden"})
/*     */ public class DocumentPermissions extends BasePermissions {
/*     */   protected short view;
/*     */   
/*     */   protected short write;
/*     */   
/*     */   protected short delete;
/*     */   
/*     */   protected short grantaccess;
/*     */   
/*     */   protected short lockAdministrator;
/*     */   
/*     */   protected short standard;
/*     */   
/*     */   protected short restricted;
/*     */   
/*     */   protected short hidden;
/*     */   
/*     */   public short getView() {
/*  64 */     return this.view;
/*     */   }
/*     */   
/*     */   public void setView(short value) {
/*  72 */     this.view = value;
/*     */   }
/*     */   
/*     */   public short getWrite() {
/*  80 */     return this.write;
/*     */   }
/*     */   
/*     */   public void setWrite(short value) {
/*  88 */     this.write = value;
/*     */   }
/*     */   
/*     */   public short getDelete() {
/*  96 */     return this.delete;
/*     */   }
/*     */   
/*     */   public void setDelete(short value) {
/* 104 */     this.delete = value;
/*     */   }
/*     */   
/*     */   public short getGrantaccess() {
/* 112 */     return this.grantaccess;
/*     */   }
/*     */   
/*     */   public void setGrantaccess(short value) {
/* 120 */     this.grantaccess = value;
/*     */   }
/*     */   
/*     */   public short getLockAdministrator() {
/* 128 */     return this.lockAdministrator;
/*     */   }
/*     */   
/*     */   public void setLockAdministrator(short value) {
/* 136 */     this.lockAdministrator = value;
/*     */   }
/*     */   
/*     */   public short getStandard() {
/* 144 */     return this.standard;
/*     */   }
/*     */   
/*     */   public void setStandard(short value) {
/* 152 */     this.standard = value;
/*     */   }
/*     */   
/*     */   public short getRestricted() {
/* 160 */     return this.restricted;
/*     */   }
/*     */   
/*     */   public void setRestricted(short value) {
/* 168 */     this.restricted = value;
/*     */   }
/*     */   
/*     */   public short getHidden() {
/* 176 */     return this.hidden;
/*     */   }
/*     */   
/*     */   public void setHidden(short value) {
/* 184 */     this.hidden = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\DocumentPermissions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */