/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentUpdate.Application;
/*     */ import ap.quantas.com.imaging.documentUpdate.BaseId;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlSeeAlso;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "Definition", propOrder = {"id", "name", "description"})
/*     */ @XmlSeeAlso({Application.class})
/*     */ public abstract class Definition extends BaseId {
/*     */   protected long id;
/*     */   
/*     */   protected String name;
/*     */   
/*     */   protected String description;
/*     */   
/*     */   public long getId() {
/*  53 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(long value) {
/*  61 */     this.id = value;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  73 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String value) {
/*  85 */     this.name = value;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/*  97 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setDescription(String value) {
/* 109 */     this.description = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\Definition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */