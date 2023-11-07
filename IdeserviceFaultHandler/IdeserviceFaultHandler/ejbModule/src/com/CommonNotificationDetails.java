/*     */ package src.com;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "commonNotificationDetails", propOrder = {"ifId", "mailToAddress", "mailBody", "mailSubject", "mailCcAddress", "mailBccAddress", "mailFromAddress"})
/*     */ public class CommonNotificationDetails
/*     */ {
/*     */   @XmlElement(name = "IFId", required = true, nillable = true)
/*     */   protected String ifId;
/*     */   @XmlElement(required = true, nillable = true)
/*     */   protected String mailToAddress;
/*     */   @XmlElement(required = true, nillable = true)
/*     */   protected String mailBody;
/*     */   @XmlElement(required = true, nillable = true)
/*     */   protected String mailSubject;
/*     */   @XmlElement(required = true, nillable = true)
/*     */   protected String mailCcAddress;
/*     */   @XmlElement(required = true, nillable = true)
/*     */   protected String mailBccAddress;
/*     */   @XmlElement(required = true, nillable = true)
/*     */   protected String mailFromAddress;
/*     */   
/*     */   public String getIFId() {
/*  71 */     return this.ifId;
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
/*     */   public void setIFId(String value) {
/*  83 */     this.ifId = value;
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
/*     */   public String getMailToAddress() {
/*  95 */     return this.mailToAddress;
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
/*     */   public void setMailToAddress(String value) {
/* 107 */     this.mailToAddress = value;
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
/*     */   public String getMailBody() {
/* 119 */     return this.mailBody;
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
/*     */   public void setMailBody(String value) {
/* 131 */     this.mailBody = value;
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
/*     */   public String getMailSubject() {
/* 143 */     return this.mailSubject;
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
/*     */   public void setMailSubject(String value) {
/* 155 */     this.mailSubject = value;
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
/*     */   public String getMailCcAddress() {
/* 167 */     return this.mailCcAddress;
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
/*     */   public void setMailCcAddress(String value) {
/* 179 */     this.mailCcAddress = value;
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
/*     */   public String getMailBccAddress() {
/* 191 */     return this.mailBccAddress;
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
/*     */   public void setMailBccAddress(String value) {
/* 203 */     this.mailBccAddress = value;
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
/*     */   public String getMailFromAddress() {
/* 215 */     return this.mailFromAddress;
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
/*     */   public void setMailFromAddress(String value) {
/* 227 */     this.mailFromAddress = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\IdeserviceFaultHandler.jar!\src\com\CommonNotificationDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */