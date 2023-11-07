/*     */ package ap.quantas.com.imaging.documentUpdate;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentUpdate.ChangeType;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "pageChange", propOrder = {"changeType", "currentPageNumber", "newPageNumber", "uploadToken"})
/*     */ public class PageChange {
/*     */   protected ChangeType changeType;
/*     */   
/*     */   protected int currentPageNumber;
/*     */   
/*     */   protected int newPageNumber;
/*     */   
/*     */   protected String uploadToken;
/*     */   
/*     */   public ChangeType getChangeType() {
/*  54 */     return this.changeType;
/*     */   }
/*     */   
/*     */   public void setChangeType(ChangeType value) {
/*  66 */     this.changeType = value;
/*     */   }
/*     */   
/*     */   public int getCurrentPageNumber() {
/*  74 */     return this.currentPageNumber;
/*     */   }
/*     */   
/*     */   public void setCurrentPageNumber(int value) {
/*  82 */     this.currentPageNumber = value;
/*     */   }
/*     */   
/*     */   public int getNewPageNumber() {
/*  90 */     return this.newPageNumber;
/*     */   }
/*     */   
/*     */   public void setNewPageNumber(int value) {
/*  98 */     this.newPageNumber = value;
/*     */   }
/*     */   
/*     */   public String getUploadToken() {
/* 110 */     return this.uploadToken;
/*     */   }
/*     */   
/*     */   public void setUploadToken(String value) {
/* 122 */     this.uploadToken = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\PageChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */