/*     */ package qantas.com.au.utility;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
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
/*     */ @XmlRootElement(name = "invoice")
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ public class InvoiceDO
/*     */ {
/*     */   private String documentType;
/*     */   private String supplierName;
/*     */   private String siteId;
/*     */   private String invNumber;
/*     */   private String taxRegistrationNumber;
/*     */   private String poNumber;
/*     */   private String currency;
/*     */   private String certifierName;
/*     */   private String certEmailAddress;
/*     */   private String certifierFlag;
/*     */   private String alternateApprover;
/*     */   private String invType;
/*     */   private String supplierNo;
/*     */   private String siteName;
/*     */   private String invoiceDate;
/*     */   private String operatingUnit;
/*     */   private String lineTotal;
/*     */   private String taxTotal;
/*     */   private String headerTotal;
/*     */   private String employeeNo;
/*     */   private String noteToApprover;
/*     */   private String paymentDec;
/*     */   private String paymentMan;
/*     */   private String paymentCheque;
/*     */   private String paymentWithInv;
/*     */   private String paymentWired;
/*     */   private String paymentChequeNo;
/*     */   private String requestFlag;
/*     */   
/*     */   public void setRequestFlag(String requestFlag) {
/*  51 */     this.requestFlag = requestFlag;
/*     */   }
/*     */   
/*     */   public String getRequestFlag() {
/*  55 */     return this.requestFlag;
/*     */   }
/*     */   
/*     */   public void setDocumentType(String documentType) {
/*  59 */     this.documentType = documentType;
/*     */   }
/*     */   
/*     */   public String getDocumentType() {
/*  63 */     return this.documentType;
/*     */   }
/*     */   
/*     */   public void setSupplierName(String supplierName) {
/*  67 */     this.supplierName = supplierName;
/*     */   }
/*     */   
/*     */   public String getSupplierName() {
/*  71 */     return this.supplierName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPoNumber(String poNumber) {
/*  81 */     this.poNumber = poNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPoNumber() {
/*  89 */     return this.poNumber;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCurrency(String currency) {
/*  94 */     this.currency = currency;
/*     */   }
/*     */   
/*     */   public String getCurrency() {
/*  98 */     return this.currency;
/*     */   }
/*     */   
/*     */   public void setCertifierName(String certifierName) {
/* 102 */     this.certifierName = certifierName;
/*     */   }
/*     */   
/*     */   public String getCertifierName() {
/* 106 */     return this.certifierName;
/*     */   }
/*     */   
/*     */   public void setCertEmailAddress(String certEmailAddress) {
/* 110 */     this.certEmailAddress = certEmailAddress;
/*     */   }
/*     */   
/*     */   public String getCertEmailAddress() {
/* 114 */     return this.certEmailAddress;
/*     */   }
/*     */   
/*     */   public void setCertifierFlag(String certifierFlag) {
/* 118 */     this.certifierFlag = certifierFlag;
/*     */   }
/*     */   
/*     */   public String getCertifierFlag() {
/* 122 */     return this.certifierFlag;
/*     */   }
/*     */   
/*     */   public void setAlternateApprover(String alternateApprover) {
/* 126 */     this.alternateApprover = alternateApprover;
/*     */   }
/*     */   
/*     */   public String getAlternateApprover() {
/* 130 */     return this.alternateApprover;
/*     */   }
/*     */   
/*     */   public void setInvType(String invType) {
/* 134 */     this.invType = invType;
/*     */   }
/*     */   
/*     */   public String getInvType() {
/* 138 */     return this.invType;
/*     */   }
/*     */   
/*     */   public void setSupplierNo(String supplierNo) {
/* 142 */     this.supplierNo = supplierNo;
/*     */   }
/*     */   
/*     */   public String getSupplierNo() {
/* 146 */     return this.supplierNo;
/*     */   }
/*     */   
/*     */   public void setSiteName(String siteName) {
/* 150 */     this.siteName = siteName;
/*     */   }
/*     */   
/*     */   public String getSiteName() {
/* 154 */     return this.siteName;
/*     */   }
/*     */   
/*     */   public void setInvoiceDate(String invoiceDate) {
/* 158 */     this.invoiceDate = invoiceDate;
/*     */   }
/*     */   
/*     */   public String getInvoiceDate() {
/* 162 */     return this.invoiceDate;
/*     */   }
/*     */   
/*     */   public void setOperatingUnit(String operatingUnit) {
/* 166 */     this.operatingUnit = operatingUnit;
/*     */   }
/*     */   
/*     */   public String getOperatingUnit() {
/* 170 */     return this.operatingUnit;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmployeeNo(String employeeNo) {
/* 176 */     this.employeeNo = employeeNo;
/*     */   }
/*     */   
/*     */   public String getEmployeeNo() {
/* 180 */     return this.employeeNo;
/*     */   }
/*     */   
/*     */   public void setNoteToApprover(String noteToApprover) {
/* 184 */     this.noteToApprover = noteToApprover;
/*     */   }
/*     */   
/*     */   public String getNoteToApprover() {
/* 188 */     return this.noteToApprover;
/*     */   }
/*     */   
/*     */   public void setPaymentDec(String paymentDec) {
/* 192 */     this.paymentDec = paymentDec;
/*     */   }
/*     */   
/*     */   public String getPaymentDec() {
/* 196 */     return this.paymentDec;
/*     */   }
/*     */   
/*     */   public void setPaymentMan(String paymentMan) {
/* 200 */     this.paymentMan = paymentMan;
/*     */   }
/*     */   
/*     */   public String getPaymentMan() {
/* 204 */     return this.paymentMan;
/*     */   }
/*     */   
/*     */   public void setPaymentCheque(String paymentCheque) {
/* 208 */     this.paymentCheque = paymentCheque;
/*     */   }
/*     */   
/*     */   public String getPaymentCheque() {
/* 212 */     return this.paymentCheque;
/*     */   }
/*     */   
/*     */   public void setPaymentWithInv(String paymentWithInv) {
/* 216 */     this.paymentWithInv = paymentWithInv;
/*     */   }
/*     */   
/*     */   public String getPaymentWithInv() {
/* 220 */     return this.paymentWithInv;
/*     */   }
/*     */   
/*     */   public void setPaymentWired(String paymentWired) {
/* 224 */     this.paymentWired = paymentWired;
/*     */   }
/*     */   
/*     */   public String getPaymentWired() {
/* 228 */     return this.paymentWired;
/*     */   }
/*     */   
/*     */   public void setPaymentChequeNo(String paymentChequeNo) {
/* 232 */     this.paymentChequeNo = paymentChequeNo;
/*     */   }
/*     */   
/*     */   public String getPaymentChequeNo() {
/* 236 */     return this.paymentChequeNo;
/*     */   }
/*     */   
/*     */   public void setInvNumber(String invNumber) {
/* 240 */     this.invNumber = invNumber;
/*     */   }
/*     */   
/*     */   public String getInvNumber() {
/* 244 */     return this.invNumber;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSiteId(String siteId) {
/* 249 */     this.siteId = siteId;
/*     */   }
/*     */   
/*     */   public String getSiteId() {
/* 253 */     return this.siteId;
/*     */   }
/*     */   
/*     */   public void setTaxRegistrationNumber(String taxRegistrationNumber) {
/* 257 */     this.taxRegistrationNumber = taxRegistrationNumber;
/*     */   }
/*     */   
/*     */   public String getTaxRegistrationNumber() {
/* 261 */     return this.taxRegistrationNumber;
/*     */   }
/*     */   
/*     */   public void setLineTotal(String lineTotal) {
/* 265 */     this.lineTotal = lineTotal;
/*     */   }
/*     */   
/*     */   public String getLineTotal() {
/* 269 */     return this.lineTotal;
/*     */   }
/*     */   
/*     */   public void setTaxTotal(String taxTotal) {
/* 273 */     this.taxTotal = taxTotal;
/*     */   }
/*     */   
/*     */   public String getTaxTotal() {
/* 277 */     return this.taxTotal;
/*     */   }
/*     */   
/*     */   public void setHeaderTotal(String headerTotal) {
/* 281 */     this.headerTotal = headerTotal;
/*     */   }
/*     */   
/*     */   public String getHeaderTotal() {
/* 285 */     return this.headerTotal;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\overseas_ear.ear!\Overseas_PDFMergerWebservice-Project1Overseas_PDFMergerWebservice-context-root.war!\WEB-INF\classes\qantas\com\a\\utility\InvoiceDO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */