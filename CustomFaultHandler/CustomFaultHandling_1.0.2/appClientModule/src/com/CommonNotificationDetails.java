
package src.com;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for commonNotificationDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="commonNotificationDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IFId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mailToAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mailBody" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mailSubject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mailCcAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mailBccAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mailFromAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "commonNotificationDetails", propOrder = {
    "ifId",
    "mailToAddress",
    "mailBody",
    "mailSubject",
    "mailCcAddress",
    "mailBccAddress",
    "mailFromAddress"
})
public class CommonNotificationDetails {

    @XmlElement(name = "IFId", required = true, nillable = true)
    protected String ifId;
    @XmlElement(required = true, nillable = true)
    protected String mailToAddress;
    @XmlElement(required = true, nillable = true)
    protected String mailBody;
    @XmlElement(required = true, nillable = true)
    protected String mailSubject;
    @XmlElement(required = true, nillable = true)
    protected String mailCcAddress;
    @XmlElement(required = true, nillable = true)
    protected String mailBccAddress;
    @XmlElement(required = true, nillable = true)
    protected String mailFromAddress;

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
     * Gets the value of the mailToAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailToAddress() {
        return mailToAddress;
    }

    /**
     * Sets the value of the mailToAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailToAddress(String value) {
        this.mailToAddress = value;
    }

    /**
     * Gets the value of the mailBody property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailBody() {
        return mailBody;
    }

    /**
     * Sets the value of the mailBody property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailBody(String value) {
        this.mailBody = value;
    }

    /**
     * Gets the value of the mailSubject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailSubject() {
        return mailSubject;
    }

    /**
     * Sets the value of the mailSubject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailSubject(String value) {
        this.mailSubject = value;
    }

    /**
     * Gets the value of the mailCcAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailCcAddress() {
        return mailCcAddress;
    }

    /**
     * Sets the value of the mailCcAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailCcAddress(String value) {
        this.mailCcAddress = value;
    }

    /**
     * Gets the value of the mailBccAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailBccAddress() {
        return mailBccAddress;
    }

    /**
     * Sets the value of the mailBccAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailBccAddress(String value) {
        this.mailBccAddress = value;
    }

    /**
     * Gets the value of the mailFromAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailFromAddress() {
        return mailFromAddress;
    }

    /**
     * Sets the value of the mailFromAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailFromAddress(String value) {
        this.mailFromAddress = value;
    }

}
