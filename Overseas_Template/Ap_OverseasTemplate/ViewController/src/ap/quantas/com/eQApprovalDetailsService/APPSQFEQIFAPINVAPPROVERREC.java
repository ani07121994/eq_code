
package ap.qantas.com.eQApprovalDetailsService;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APPS.QFEQIF_APINV_APPROVER_REC complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPS.QFEQIF_APINV_APPROVER_REC">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="APP_NAME" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails}string1000" minOccurs="0"/>
 *         &lt;element name="APP_EMAIL" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails}string1000" minOccurs="0"/>
 *         &lt;element name="APP_EMP_NO" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="APP_POSITION" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails}string1000" minOccurs="0"/>
 *         &lt;element name="APP_APPROVE_LIMIT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="APP_FNDL_CATEGORY" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails}string500" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPS.QFEQIF_APINV_APPROVER_REC", propOrder = {
    "appname",
    "appemail",
    "appempno",
    "appposition",
    "appapprovelimit",
    "appfndlcategory"
})
public class APPSQFEQIFAPINVAPPROVERREC {

    @XmlElementRef(name = "APP_NAME", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class)
    protected JAXBElement<String> appname;
    @XmlElementRef(name = "APP_EMAIL", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class)
    protected JAXBElement<String> appemail;
    @XmlElementRef(name = "APP_EMP_NO", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> appempno;
    @XmlElementRef(name = "APP_POSITION", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class)
    protected JAXBElement<String> appposition;
    @XmlElementRef(name = "APP_APPROVE_LIMIT", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> appapprovelimit;
    @XmlElementRef(name = "APP_FNDL_CATEGORY", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class)
    protected JAXBElement<String> appfndlcategory;

    /**
     * Gets the value of the appname property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAPPNAME() {
        return appname;
    }

    /**
     * Sets the value of the appname property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAPPNAME(JAXBElement<String> value) {
        this.appname = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the appemail property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAPPEMAIL() {
        return appemail;
    }

    /**
     * Sets the value of the appemail property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAPPEMAIL(JAXBElement<String> value) {
        this.appemail = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the appempno property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAPPEMPNO() {
        return appempno;
    }

    /**
     * Sets the value of the appempno property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAPPEMPNO(JAXBElement<BigDecimal> value) {
        this.appempno = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the appposition property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAPPPOSITION() {
        return appposition;
    }

    /**
     * Sets the value of the appposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAPPPOSITION(JAXBElement<String> value) {
        this.appposition = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the appapprovelimit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAPPAPPROVELIMIT() {
        return appapprovelimit;
    }

    /**
     * Sets the value of the appapprovelimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAPPAPPROVELIMIT(JAXBElement<BigDecimal> value) {
        this.appapprovelimit = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the appfndlcategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAPPFNDLCATEGORY() {
        return appfndlcategory;
    }

    /**
     * Sets the value of the appfndlcategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAPPFNDLCATEGORY(JAXBElement<String> value) {
        this.appfndlcategory = ((JAXBElement<String> ) value);
    }

}
