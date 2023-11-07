
package genJava;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MoveFile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MoveFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceFolder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetFolder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="overwriteFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ifsAdminUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ifsAdminPwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ifsService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ifsSysPwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MoveFile", propOrder = {
    "fileName",
    "sourceFolder",
    "targetFolder",
    "overwriteFlag",
    "ifsAdminUser",
    "ifsAdminPwd",
    "ifsService",
    "ifsSysPwd"
})
public class MoveFile {

    protected String fileName;
    protected String sourceFolder;
    protected String targetFolder;
    protected String overwriteFlag;
    protected String ifsAdminUser;
    protected String ifsAdminPwd;
    protected String ifsService;
    protected String ifsSysPwd;

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
     * Gets the value of the sourceFolder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceFolder() {
        return sourceFolder;
    }

    /**
     * Sets the value of the sourceFolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceFolder(String value) {
        this.sourceFolder = value;
    }

    /**
     * Gets the value of the targetFolder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetFolder() {
        return targetFolder;
    }

    /**
     * Sets the value of the targetFolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetFolder(String value) {
        this.targetFolder = value;
    }

    /**
     * Gets the value of the overwriteFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverwriteFlag() {
        return overwriteFlag;
    }

    /**
     * Sets the value of the overwriteFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverwriteFlag(String value) {
        this.overwriteFlag = value;
    }

    /**
     * Gets the value of the ifsAdminUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfsAdminUser() {
        return ifsAdminUser;
    }

    /**
     * Sets the value of the ifsAdminUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfsAdminUser(String value) {
        this.ifsAdminUser = value;
    }

    /**
     * Gets the value of the ifsAdminPwd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfsAdminPwd() {
        return ifsAdminPwd;
    }

    /**
     * Sets the value of the ifsAdminPwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfsAdminPwd(String value) {
        this.ifsAdminPwd = value;
    }

    /**
     * Gets the value of the ifsService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfsService() {
        return ifsService;
    }

    /**
     * Sets the value of the ifsService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfsService(String value) {
        this.ifsService = value;
    }

    /**
     * Gets the value of the ifsSysPwd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfsSysPwd() {
        return ifsSysPwd;
    }

    /**
     * Sets the value of the ifsSysPwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfsSysPwd(String value) {
        this.ifsSysPwd = value;
    }

}
