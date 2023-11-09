package com.fetchupload.data;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MetaDataDAO {

	String invoiceNum;
	String invoiceId;
	String supplierNumber;
	String supplierId;
	String siteId;
	String orgId;
	String name;
	String invoiceCurrencycode;
	String invoiceAmount;
	String invoiceDate;
	String freight;
	String aog;
	String dueDate;
	String withholdingTax;
	String poNumber;
	String apInvoiceType;
	String apInvoiceSource;
	String currencyEquivalent;
	String imageUrl;
	String imageUrl2;
	String imageUrl3;
	String invoiceStatus;
	String pendingWithApprovedBy;
	String actionDate;
	String paymentNumber;
	String paymentDate;
	String description;
	String smallBusiness;
	String invoiceHoldName;
	String poHoldReleaseDate;
	String findelHoldReleaseDate;
	String source;
	String locked;
	String mimeType;
	String userName;
	String wfrUserName;
	String apUserName;
	String invalidReason;
	String reasonType;
	String internalStatus;
	String priority;
	String documentType;
	String invoiceType;
	String supplierName;
	String certifierName;
	String scanDate;
	String certificationPendingDate;
	String eQInterfaceDate;
	String lastUpdateDate;
	String supplierEmailId;
	String invoiceFileName;
	String captureBatchId;

	public static Date getDateFromString(String string, String value) {
		Date date = null;
		Map<String, String> formatMap = new HashMap();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		formatMap.put("Invoice Date", "yyyy-MM-dd");
		formatMap.put("Due Date", "yyyy-MM-dd HH:mm:ss");
		formatMap.put("Scan Date", "yyyy-MM-dd HH:mm:ss");
		formatMap.put("Payment Date", "yyyy-MM-dd");
		formatMap.put("PO_Hold_Release_Date", "yyyy-MM-dd HH:mm:ss");
		formatMap.put("Findel_Hold_Release_Date", "yyyy-MM-dd HH:mm:ss");
		if (value.equalsIgnoreCase("Scan Date")) {
			try {
				Date d=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(string);
				System.out.println("1 : "+d);
				string=new SimpleDateFormat(formatMap.get("Scan Date")).format(d);
				System.out.println("2 : "+string);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
//			format = new SimpleDateFormat(formatMap.get(value));
			date = format.parse(string);
			System.out.println(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String getCurrentDateCustom() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return format.format(date);
	}

	public static Timestamp getDateTimeFromString(String string, String value) {
		Map<String, String> formatMap = new HashMap();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		java.sql.Timestamp timeStampDate = null;
		formatMap.put("Certification Pending Date", "yyyy-MM-dd HH:mm:ss.SSS");
		formatMap.put("eQ Interface Date", "yyyy-MM-dd HH:mm:ss");
		formatMap.put("Last Updated Date", "yyyy-MM-dd HH:mm:ss");
		try {
			format = new SimpleDateFormat(formatMap.get(value));
			Date date = (Date) format.parse(string);
			timeStampDate = new Timestamp(date.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeStampDate;
	}

	public String getCaptureBatchId() {
		return captureBatchId;
	}

	public void setCaptureBatchId(String captureBatchId) {
		this.captureBatchId = captureBatchId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWfrUserName() {
		return wfrUserName;
	}

	public void setWfrUserName(String wfrUserName) {
		this.wfrUserName = wfrUserName;
	}

	public String getApUserName() {
		return apUserName;
	}

	public void setApUserName(String apUserName) {
		this.apUserName = apUserName;
	}

	public String getInvalidReason() {
		return invalidReason;
	}

	public void setInvalidReason(String invalidReason) {
		this.invalidReason = invalidReason;
	}

	public String getReasonType() {
		return reasonType;
	}

	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

	public String getInternalStatus() {
		return internalStatus;
	}

	public void setInternalStatus(String internalStatus) {
		this.internalStatus = internalStatus;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getCertifierName() {
		return certifierName;
	}

	public void setCertifierName(String certifierName) {
		this.certifierName = certifierName;
	}

	public String getScanDate() {
		return scanDate;
	}

	public void setScanDate(String scanDate) {
		this.scanDate = scanDate;
	}

	public String getCertificationPendingDate() {
		return certificationPendingDate;
	}

	public void setCertificationPendingDate(String certificationPendingDate) {
		this.certificationPendingDate = certificationPendingDate;
	}

	public String geteQInterfaceDate() {
		return eQInterfaceDate;
	}

	public void seteQInterfaceDate(String eQInterfaceDate) {
		this.eQInterfaceDate = eQInterfaceDate;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getSupplierEmailId() {
		return supplierEmailId;
	}

	public void setSupplierEmailId(String supplierEmailId) {
		this.supplierEmailId = supplierEmailId;
	}

	public String getInvoiceFileName() {
		return invoiceFileName;
	}

	public void setInvoiceFileName(String invoiceFileName) {
		this.invoiceFileName = invoiceFileName;
	}

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInvoiceCurrencycode() {
		return invoiceCurrencycode;
	}

	public void setInvoiceCurrencycode(String invoiceCurrencycode) {
		this.invoiceCurrencycode = invoiceCurrencycode;
	}

	public String getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getAog() {
		return aog;
	}

	public void setAog(String aog) {
		this.aog = aog;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getWithholdingTax() {
		return withholdingTax;
	}

	public void setWithholdingTax(String withholdingTax) {
		this.withholdingTax = withholdingTax;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getApInvoiceType() {
		return apInvoiceType;
	}

	public void setApInvoiceType(String apInvoiceType) {
		this.apInvoiceType = apInvoiceType;
	}

	public String getApInvoiceSource() {
		return apInvoiceSource;
	}

	public void setApInvoiceSource(String apInvoiceSource) {
		this.apInvoiceSource = apInvoiceSource;
	}

	public String getCurrencyEquivalent() {
		return currencyEquivalent;
	}

	public void setCurrencyEquivalent(String currencyEquivalent) {
		this.currencyEquivalent = currencyEquivalent;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageUrl2() {
		return imageUrl2;
	}

	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}

	public String getImageUrl3() {
		return imageUrl3;
	}

	public void setImageUrl3(String imageUrl3) {
		this.imageUrl3 = imageUrl3;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getPendingWithApprovedBy() {
		return pendingWithApprovedBy;
	}

	public void setPendingWithApprovedBy(String pendingWithApprovedBy) {
		this.pendingWithApprovedBy = pendingWithApprovedBy;
	}

	public String getActionDate() {
		return actionDate;
	}

	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}

	public String getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSmallBusiness() {
		return smallBusiness;
	}

	public void setSmallBusiness(String smallBusiness) {
		this.smallBusiness = smallBusiness;
	}

	public String getInvoiceHoldName() {
		return invoiceHoldName;
	}

	public void setInvoiceHoldName(String invoiceHoldName) {
		this.invoiceHoldName = invoiceHoldName;
	}

	public String getPoHoldReleaseDate() {
		return poHoldReleaseDate;
	}

	public void setPoHoldReleaseDate(String poHoldReleaseDate) {
		this.poHoldReleaseDate = poHoldReleaseDate;
	}

	public String getFindelHoldReleaseDate() {
		return findelHoldReleaseDate;
	}

	public void setFindelHoldReleaseDate(String findelHoldReleaseDate) {
		this.findelHoldReleaseDate = findelHoldReleaseDate;
	}

	@Override
	public String toString() {
		return "MetaDataDAO [invoiceNum=" + invoiceNum + ", invoiceId=" + invoiceId + ", supplierNumber="
				+ supplierNumber + ", supplierId=" + supplierId + ", siteId=" + siteId + ", orgId=" + orgId + ", name="
				+ name + ", invoiceCurrencycode=" + invoiceCurrencycode + ", invoiceAmount=" + invoiceAmount
				+ ", invoiceDate=" + invoiceDate + ", freight=" + freight + ", aog=" + aog + ", dueDate=" + dueDate
				+ ", withholdingTax=" + withholdingTax + ", poNumber=" + poNumber + ", apInvoiceType=" + apInvoiceType
				+ ", apInvoiceSource=" + apInvoiceSource + ", currencyEquivalent=" + currencyEquivalent + ", imageUrl="
				+ imageUrl + ", imageUrl2=" + imageUrl2 + ", imageUrl3=" + imageUrl3 + ", invoiceStatus="
				+ invoiceStatus + ", pendingWithApprovedBy=" + pendingWithApprovedBy + ", actionDate=" + actionDate
				+ ", paymentNumber=" + paymentNumber + ", paymentDate=" + paymentDate + ", description=" + description
				+ ", smallBusiness=" + smallBusiness + ", invoiceHoldName=" + invoiceHoldName + ", poHoldReleaseDate="
				+ poHoldReleaseDate + ", findelHoldReleaseDate=" + findelHoldReleaseDate + ", source=" + source
				+ ", locked=" + locked + ", mimeType=" + mimeType + ", userName=" + userName + ", wfrUserName="
				+ wfrUserName + ", apUserName=" + apUserName + ", invalidReason=" + invalidReason + ", reasonType="
				+ reasonType + ", internalStatus=" + internalStatus + ", priority=" + priority + ", documentType="
				+ documentType + ", invoiceType=" + invoiceType + ", supplierName=" + supplierName + ", certifierName="
				+ certifierName + ", scanDate=" + scanDate + ", certificationPendingDate=" + certificationPendingDate
				+ ", eQInterfaceDate=" + eQInterfaceDate + ", lastUpdateDate=" + lastUpdateDate + ", supplierEmailId="
				+ supplierEmailId + ", invoiceFileName=" + invoiceFileName + ", captureBatchId=" + captureBatchId
				+ ", getCaptureBatchId()=" + getCaptureBatchId() + ", getSource()=" + getSource() + ", getLocked()="
				+ getLocked() + ", getMimeType()=" + getMimeType() + ", getUserName()=" + getUserName()
				+ ", getWfrUserName()=" + getWfrUserName() + ", getApUserName()=" + getApUserName()
				+ ", getInvalidReason()=" + getInvalidReason() + ", getReasonType()=" + getReasonType()
				+ ", getInternalStatus()=" + getInternalStatus() + ", getPriority()=" + getPriority()
				+ ", getDocumentType()=" + getDocumentType() + ", getInvoiceType()=" + getInvoiceType()
				+ ", getSupplierName()=" + getSupplierName() + ", getCertifierName()=" + getCertifierName()
				+ ", getScanDate()=" + getScanDate() + ", getCertificationPendingDate()="
				+ getCertificationPendingDate() + ", geteQInterfaceDate()=" + geteQInterfaceDate()
				+ ", getLastUpdateDate()=" + getLastUpdateDate() + ", getSupplierEmailId()=" + getSupplierEmailId()
				+ ", getInvoiceFileName()=" + getInvoiceFileName() + ", getInvoiceNum()=" + getInvoiceNum()
				+ ", getInvoiceId()=" + getInvoiceId() + ", getSupplierNumber()=" + getSupplierNumber()
				+ ", getSupplierId()=" + getSupplierId() + ", getSiteId()=" + getSiteId() + ", getOrgId()=" + getOrgId()
				+ ", getName()=" + getName() + ", getInvoiceCurrencycode()=" + getInvoiceCurrencycode()
				+ ", getInvoiceAmount()=" + getInvoiceAmount() + ", getInvoiceDate()=" + getInvoiceDate()
				+ ", getFreight()=" + getFreight() + ", getAog()=" + getAog() + ", getDueDate()=" + getDueDate()
				+ ", getWithholdingTax()=" + getWithholdingTax() + ", getPoNumber()=" + getPoNumber()
				+ ", getApInvoiceType()=" + getApInvoiceType() + ", getApInvoiceSource()=" + getApInvoiceSource()
				+ ", getCurrencyEquivalent()=" + getCurrencyEquivalent() + ", getImageUrl()=" + getImageUrl()
				+ ", getImageUrl2()=" + getImageUrl2() + ", getImageUrl3()=" + getImageUrl3() + ", getInvoiceStatus()="
				+ getInvoiceStatus() + ", getPendingWithApprovedBy()=" + getPendingWithApprovedBy()
				+ ", getActionDate()=" + getActionDate() + ", getPaymentNumber()=" + getPaymentNumber()
				+ ", getPaymentDate()=" + getPaymentDate() + ", getDescription()=" + getDescription()
				+ ", getSmallBusiness()=" + getSmallBusiness() + ", getInvoiceHoldName()=" + getInvoiceHoldName()
				+ ", getPoHoldReleaseDate()=" + getPoHoldReleaseDate() + ", getFindelHoldReleaseDate()="
				+ getFindelHoldReleaseDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
