package com.audit.pojo;

public class InvoiceAudit {

	private String invoiceNo;
	private String invoiceDate;
	private String invoiceType;
	private String documentType;
	private String supplierId;
	private String supplierName;
	private String supplierNumber;
	private String siteId;
	private String siteName;
	private String PONumber;
	private String currencyCode;
	private String taxRegNumber;
	private String taxAmount;
	private String invoiceTotalAmount;
	private String docId;
	
	private String lastUpdatedDate;
	private String apOperationComments;
	private String certifierRejectionComments;
	private String certifierReassignComments;
	
	/*For All Comments*/
	
	private String comments;
	
	/* For Invoice Summary */
	
	private String internalStatus;
	private String reasonType;
	//private String reasonCode;
	private String certifierName;
	private String employeeNumber;
	private String statusCamelCase;
	private String employeeReassignedNo;
	private String firstName;
	
	private String panelBorderColor; // to color last panel in workflow

	public String getPanelBorderColor() {
		return panelBorderColor;
	}
	public void setPanelBorderColor(String panelBorderColor) {
		this.panelBorderColor = panelBorderColor;
	}
	public String getEmployeeReassignedNo() {
		return employeeReassignedNo;
	}
	public void setEmployeeReassignedNo(String employeeReassignedNo) {
		this.employeeReassignedNo = employeeReassignedNo;
	}
	public String getStatusCamelCase() {
		return statusCamelCase;
	}
	public void setStatusCamelCase(String statusCamelCase) {
		this.statusCamelCase = statusCamelCase;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierNumber() {
		return supplierNumber;
	}
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getPONumber() {
		return PONumber;
	}
	public void setPONumber(String pONumber) {
		PONumber = pONumber;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getTaxRegNumber() {
		return taxRegNumber;
	}
	public void setTaxRegNumber(String taxRegNumber) {
		this.taxRegNumber = taxRegNumber;
	}
	public String getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}
	public String getInvoiceTotalAmount() {
		return invoiceTotalAmount;
	}
	public void setInvoiceTotalAmount(String invoiceTotalAmount) {
		this.invoiceTotalAmount = invoiceTotalAmount;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getInternalStatus() {
		return internalStatus;
	}
	public void setInternalStatus(String internalStatus) {
		this.internalStatus = internalStatus;
	}
	public String getReasonType() {
		return reasonType;
	}
	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}
	public String getCertifierName() {
		return certifierName;
	}
	public void setCertifierName(String certifierName) {
		this.certifierName = certifierName;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getApOperationComments() {
		return apOperationComments;
	}
	public void setApOperationComments(String apOperationComments) {
		this.apOperationComments = apOperationComments;
	}
	public String getCertifierRejectionComments() {
		return certifierRejectionComments;
	}
	public void setCertifierRejectionComments(String certifierRejectionComments) {
		this.certifierRejectionComments = certifierRejectionComments;
	}
	public String getCertifierReassignComments() {
		return certifierReassignComments;
	}
	public void setCertifierReassignComments(String certifierReassignComments) {
		this.certifierReassignComments = certifierReassignComments;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}
