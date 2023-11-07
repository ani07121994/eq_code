
package ap.quantas.com.ebs_inv_process;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APPS.OUT_RESULT_REC complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPS.OUT_RESULT_REC">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EXCEPTIONREASON" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS}string200" minOccurs="0"/>
 *         &lt;element name="EXCEPTIONTYPE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS}string200" minOccurs="0"/>
 *         &lt;element name="ERRORMESSAGE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS}string4000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPS.OUT_RESULT_REC", propOrder = {
    "exceptionreason",
    "exceptiontype",
    "errormessage"
})
public class APPSOUTRESULTREC {

    @XmlElementRef(name = "EXCEPTIONREASON", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", type = JAXBElement.class)
    protected JAXBElement<String> exceptionreason;
    @XmlElementRef(name = "EXCEPTIONTYPE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", type = JAXBElement.class)
    protected JAXBElement<String> exceptiontype;
    @XmlElementRef(name = "ERRORMESSAGE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", type = JAXBElement.class)
    protected JAXBElement<String> errormessage;

    /**
     * Gets the value of the exceptionreason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEXCEPTIONREASON() {
        return exceptionreason;
    }

    /**
     * Sets the value of the exceptionreason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEXCEPTIONREASON(JAXBElement<String> value) {
        this.exceptionreason = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the exceptiontype property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEXCEPTIONTYPE() {
        return exceptiontype;
    }

    /**
     * Sets the value of the exceptiontype property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEXCEPTIONTYPE(JAXBElement<String> value) {
        this.exceptiontype = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the errormessage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getERRORMESSAGE() {
        return errormessage;
    }

    /**
     * Sets the value of the errormessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setERRORMESSAGE(JAXBElement<String> value) {
        this.errormessage = ((JAXBElement<String> ) value);
    }

}
