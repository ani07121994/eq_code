/*     */ package WEB-INF.classes.ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentUpdate.BasePermissions;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "DefinitionPermissions", propOrder = {"view", "modify", "delete", "grantaccess"})
/*     */ public class DefinitionPermissions extends BasePermissions {
/*     */   protected short view;
/*     */   
/*     */   protected short modify;
/*     */   
/*     */   protected short delete;
/*     */   
/*     */   protected short grantaccess;
/*     */   
/*     */   public short getView() {
/*  52 */     return this.view;
/*     */   }
/*     */   
/*     */   public void setView(short value) {
/*  60 */     this.view = value;
/*     */   }
/*     */   
/*     */   public short getModify() {
/*  68 */     return this.modify;
/*     */   }
/*     */   
/*     */   public void setModify(short value) {
/*  76 */     this.modify = value;
/*     */   }
/*     */   
/*     */   public short getDelete() {
/*  84 */     return this.delete;
/*     */   }
/*     */   
/*     */   public void setDelete(short value) {
/*  92 */     this.delete = value;
/*     */   }
/*     */   
/*     */   public short getGrantaccess() {
/* 100 */     return this.grantaccess;
/*     */   }
/*     */   
/*     */   public void setGrantaccess(short value) {
/* 108 */     this.grantaccess = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\DefinitionPermissions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */