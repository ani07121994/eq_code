package com.fetchupload.data;

public class DocIDDAO {

	String newDocId;
	String oldDocId;
	String invoiceId;
	String siteId;

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public DocIDDAO(String newDocId, String oldDocId, String invoiceId, String siteId) {
		super();
		this.newDocId = newDocId;
		this.oldDocId = oldDocId;
		this.invoiceId = invoiceId;
		this.siteId = siteId;
	}

	public String getNewDocId() {
		return newDocId;
	}

	public void setNewDocId(String newDocId) {
		this.newDocId = newDocId;
	}

	public String getOldDocId() {
		return oldDocId;
	}

	public void setOldDocId(String oldDocId) {
		this.oldDocId = oldDocId;
	}

}
