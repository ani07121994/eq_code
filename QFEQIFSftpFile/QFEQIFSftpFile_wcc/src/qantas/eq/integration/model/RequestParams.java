package qantas.eq.integration.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @purpose RequestParams is the web service mapper class, it will map the variables with 
 *          the request XML and populate values in the variables 
 *          
 * @author  Tata Consultancy Services
 * 
 * @version 1.0
 *
 */

/*"IFS_ADMIN_USER", 
"IFS_ADMIN_PWD", 
"IFS_SERVICE",
"IFS_SYS_PWD",*/

@XmlType(name="requestParams", 
		 propOrder={"FILE_NAME", 
		            "SOURCE_FOLDER", 
		            "SFTP_HOST",
		            "SFTP_PORT",
		            "SFTP_AUTH_TYPE",
		            "SFTP_USER",
		            "SFTP_PWD",
		            "SFTP_SSH_KEY_LOCATION",
		            "DESTINATION_FOLDER",
		            "IFID", // 923018- Error file movement from error to original folder 03_11_21
		            "SFTP_FILENAME"})
@XmlAccessorType(XmlAccessType.FIELD)

public class RequestParams {
	
	@XmlElement(required=true)
	private String FILE_NAME;
	
	@XmlElement(required=true)
	private String SOURCE_FOLDER;
	
/*	@XmlElement(required=true)
	private String IFS_ADMIN_USER;
	
	@XmlElement(required=true)
	private String IFS_ADMIN_PWD;
	
	@XmlElement(required=true)
	private String IFS_SERVICE;
	
	@XmlElement(required=true)
	private String IFS_SYS_PWD;*/
	
	@XmlElement(required=true)
	private String SFTP_HOST;
	
	@XmlElement(required=true)
	private int    SFTP_PORT;
	
	@XmlElement(required=true)
	private String SFTP_AUTH_TYPE;
	
	@XmlElement(required=true)
	private String SFTP_USER;
	
	@XmlElement(required=true)
	private String SFTP_PWD;
	
	@XmlElement(required=true)
	private String SFTP_SSH_KEY_LOCATION;
	
	@XmlElement(required=true)
	private String DESTINATION_FOLDER;
	
	// // 923018- Error file movement from error to original folder 03_11_21
	@XmlElement(required=true)
	private String IFID;
	// // 923018- Error file movement from error to original folder 03_11_21
	
	@XmlElement(required=true)
	private String SFTP_FILENAME;

	//923018- Error file movement from error to original folder 03_11_21
	public String getIFID() {
		return IFID;
	}

	public void setIFID(String iFID) {
		IFID = iFID;
	}
	//923018- Error file movement from error to original folder 03_11_21 End
	public String getFILE_NAME() {
		return FILE_NAME;
	}

	public void setFILE_NAME(String fILE_NAME) {
		FILE_NAME = fILE_NAME;
	}

	public String getSOURCE_FOLDER() {
		return SOURCE_FOLDER;
	}

	public void setSOURCE_FOLDER(String sOURCE_FOLDER) {
		SOURCE_FOLDER = sOURCE_FOLDER;
	}

/*	public String getIFS_ADMIN_USER() {
		return IFS_ADMIN_USER;
	}

	public void setIFS_ADMIN_USER(String iFS_ADMIN_USER) {
		IFS_ADMIN_USER = iFS_ADMIN_USER;
	}

	public String getIFS_ADMIN_PWD() {
		return IFS_ADMIN_PWD;
	}

	public void setIFS_ADMIN_PWD(String iFS_ADMIN_PWD) {
		IFS_ADMIN_PWD = iFS_ADMIN_PWD;
	}

	public String getIFS_SERVICE() {
		return IFS_SERVICE;
	}

	public void setIFS_SERVICE(String iFS_SERVICE) {
		IFS_SERVICE = iFS_SERVICE;
	}

	public String getIFS_SYS_PWD() {
		return IFS_SYS_PWD;
	}

	public void setIFS_SYS_PWD(String iFS_SYS_PWD) {
		IFS_SYS_PWD = iFS_SYS_PWD;
	}*/

	public String getSFTP_HOST() {
		return SFTP_HOST;
	}

	public void setSFTP_HOST(String sFTP_HOST) {
		SFTP_HOST = sFTP_HOST;
	}

	public int getSFTP_PORT() {
		return SFTP_PORT;
	}

	public void setSFTP_PORT(int sFTP_PORT) {
		SFTP_PORT = sFTP_PORT;
	}

	public String getSFTP_USER() {
		return SFTP_USER;
	}

	public void setSFTP_USER(String sFTP_USER) {
		SFTP_USER = sFTP_USER;
	}

	public String getSFTP_PWD() {
		return SFTP_PWD;
	}

	public void setSFTP_PWD(String sFTP_PWD) {
		SFTP_PWD = sFTP_PWD;
	}

	public String getDESTINATION_FOLDER() {
		return DESTINATION_FOLDER;
	}

	public void setDESTINATION_FOLDER(String dESTINATION_FOLDER) {
		DESTINATION_FOLDER = dESTINATION_FOLDER;
	}

	public String getSFTP_FILENAME() {
		return SFTP_FILENAME;
	}

	public void setSFTP_FILENAME(String sFTP_FILENAME) {
		SFTP_FILENAME = sFTP_FILENAME;
	}

	public String getSFTP_AUTH_TYPE() {
		return SFTP_AUTH_TYPE;
	}

	public void setSFTP_AUTH_TYPE(String sFTP_AUTH_TYPE) {
		SFTP_AUTH_TYPE = sFTP_AUTH_TYPE;
	}

	public String getSFTP_SSH_KEY_LOCATION() {
		return SFTP_SSH_KEY_LOCATION;
	}

	public void setSFTP_SSH_KEY_LOCATION(String sFTP_SSH_KEY_LOCATION) {
		SFTP_SSH_KEY_LOCATION = sFTP_SSH_KEY_LOCATION;
	}
	
	

}
