
package qantas.imaging.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IPM_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IF_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Src_File_Path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Src_File_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeleteFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rename_filename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wcc_path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Error_message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateService", propOrder = {
    "ipmid",
    "ifId",
    "srcFilePath",
    "srcFileName",
    "deleteFlag",
    "renameFilename",
    "wccPath",
    "errorMessage"
})
public class UpdateService {

    @XmlElement(name = "IPM_ID")
    protected String ipmid;
    @XmlElement(name = "IF_id")
    protected String ifId;
    @XmlElement(name = "Src_File_Path")
    protected String srcFilePath;
    @XmlElement(name = "Src_File_Name")
    protected String srcFileName;
    @XmlElement(name = "DeleteFlag")
    protected String deleteFlag;
    @XmlElement(name = "rename_filename")
    protected String renameFilename;
    @XmlElement(name = "wcc_path")
    protected String wccPath;
    @XmlElement(name = "Error_message")
    protected String errorMessage;

    /**
     * Gets the value of the ipmid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPMID() {
        return ipmid;
    }

    /**
     * Sets the value of the ipmid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPMID(String value) {
        this.ipmid = value;
    }

    /**
     * Gets the value of the ifId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIFId() {
        return ifId;
    }

    /**
     * Sets the value of the ifId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIFId(String value) {
        this.ifId = value;
    }

    /**
     * Gets the value of the srcFilePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcFilePath() {
        return srcFilePath;
    }

    /**
     * Sets the value of the srcFilePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcFilePath(String value) {
        this.srcFilePath = value;
    }

    /**
     * Gets the value of the srcFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcFileName() {
        return srcFileName;
    }

    /**
     * Sets the value of the srcFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcFileName(String value) {
        this.srcFileName = value;
    }

    /**
     * Gets the value of the deleteFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * Sets the value of the deleteFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeleteFlag(String value) {
        this.deleteFlag = value;
    }

    /**
     * Gets the value of the renameFilename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenameFilename() {
        return renameFilename;
    }

    /**
     * Sets the value of the renameFilename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenameFilename(String value) {
        this.renameFilename = value;
    }

    /**
     * Gets the value of the wccPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWccPath() {
        return wccPath;
    }

    /**
     * Sets the value of the wccPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWccPath(String value) {
        this.wccPath = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

}
