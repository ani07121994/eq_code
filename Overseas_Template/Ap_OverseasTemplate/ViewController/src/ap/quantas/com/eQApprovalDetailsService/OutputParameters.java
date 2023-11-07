
package ap.qantas.com.eQApprovalDetailsService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OUT_RESULT" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails}APPS.QFEQIF_APINV_APRVR_OUT_TBL_TP" minOccurs="0"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "outresult",
    "status",
    "message"
})
@XmlRootElement(name = "OutputParameters")
public class OutputParameters {

    @XmlElementRef(name = "OUT_RESULT", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class)
    protected JAXBElement<APPSQFEQIFAPINVAPRVROUTTBLTP> outresult;
    @XmlElementRef(name = "STATUS", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class)
    protected JAXBElement<String> status;
    @XmlElementRef(name = "MESSAGE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class)
    protected JAXBElement<String> message;

    /**
     * Gets the value of the outresult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link APPSQFEQIFAPINVAPRVROUTTBLTP }{@code >}
     *     
     */
    public JAXBElement<APPSQFEQIFAPINVAPRVROUTTBLTP> getOUTRESULT() {
        return outresult;
    }

    /**
     * Sets the value of the outresult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link APPSQFEQIFAPINVAPRVROUTTBLTP }{@code >}
     *     
     */
    public void setOUTRESULT(JAXBElement<APPSQFEQIFAPINVAPRVROUTTBLTP> value) {
        this.outresult = ((JAXBElement<APPSQFEQIFAPINVAPRVROUTTBLTP> ) value);
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSTATUS(JAXBElement<String> value) {
        this.status = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMESSAGE() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMESSAGE(JAXBElement<String> value) {
        this.message = ((JAXBElement<String> ) value);
    }

}
