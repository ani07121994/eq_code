
public class ImagingDAO {

	String captureBatchId;
	String status;
	String invSuppName;
	public String getInvSuppName() {
		return invSuppName;
	}
	public void setInvSuppName(String invSuppName) {
		this.invSuppName = invSuppName;
	}
	public String getCaptureBatchId() {
		return captureBatchId;
	}
	public void setCaptureBatchId(String captureBatchId) {
		this.captureBatchId = captureBatchId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ImagingDAO [captureBatchId=" + captureBatchId + ", status=" + status + "]";
	}
	
}
