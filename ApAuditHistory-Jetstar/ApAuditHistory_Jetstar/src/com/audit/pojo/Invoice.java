package com.audit.pojo;

public class Invoice {
	
	private String invoiceNo;
	private String supplierName;
	private String siteId;
	private int invoiceId;
	private String invoiceDate;
	private String invoiceTotalAmount;
	private String internalStatus;
	
	public String getInternalStatus() {
		return internalStatus;
	}
	public void setInternalStatus(String internalStatus) {
		this.internalStatus = internalStatus;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getInvoiceTotalAmount() {
		return invoiceTotalAmount;
	}
	public void setInvoiceTotalAmount(String invoiceTotalAmount) {
		this.invoiceTotalAmount = invoiceTotalAmount;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	
	

}
