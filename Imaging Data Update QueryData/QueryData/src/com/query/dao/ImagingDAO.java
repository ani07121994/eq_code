package com.query.dao;

public class ImagingDAO {

	String invoiceNumber;
	String siteID;
	String activity;
	String scanDate;

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getSiteID() {
		return siteID;
	}

	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getScanDate() {
		return scanDate;
	}

	public void setScanDate(String scanDate) {
		this.scanDate = scanDate;
	}

	@Override
	public String toString() {
		return "ImagingDAO [invoiceNumber=" + invoiceNumber + ", siteID=" + siteID + ", activity=" + activity
				+ ", scanDate=" + scanDate + "]";
	}

}
