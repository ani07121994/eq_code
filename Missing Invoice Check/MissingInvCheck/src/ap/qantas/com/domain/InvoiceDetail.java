package ap.qantas.com.domain;

public class InvoiceDetail {
	
	private String invoiceId;
	private String invoiceNo;
	private String modifiedOn;
	private int count;
	private String frmDt;
	private String toDt;
	
	public String getToDt() {
		return toDt;
	}
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	public String getFrmDt() {
		return frmDt;
	}
	public void setFrmDt(String frmDt) {
		this.frmDt = frmDt;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
