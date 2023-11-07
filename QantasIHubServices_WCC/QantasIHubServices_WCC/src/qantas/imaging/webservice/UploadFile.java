
package qantas.imaging.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for uploadFile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="uploadFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IF_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="File_Path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="File_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wcc_Path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rename_filename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Error_message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Delete_Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uploadFile", propOrder = {
    "ifId",
    "filePath",
    "fileName",
    "wccPath",
    "renameFilename",
    "errorMessage",
    "deleteFlag"
})
public class UploadFile {

    @XmlElement(name = "IF_id")
    protected String ifId;
    @XmlElement(name = "File_Path")
    protected String filePath;
    @XmlElement(name = "File_Name")
    protected String fileName;
    @XmlElement(name = "wcc_Path")
    protected String wccPath;
    @XmlElement(name = "rename_filename")
    protected String renameFilename;
    @XmlElement(name = "Error_message")
    protected String errorMessage;
    @XmlElement(name = "Delete_Flag")
    protected String deleteFlag;

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
     * Gets the value of the filePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the value of the filePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilePath(String value) {
        this.filePath = value;
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
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

}
