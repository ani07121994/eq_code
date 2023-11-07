
package ap.qantas.com.eQApprovalDetailsService;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APPS.QFEQIF_APINV_INV_INFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPS.QFEQIF_APINV_INV_INFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="REQUESTER_NUMBER" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails}string200" minOccurs="0"/>
 *         &lt;element name="ALTERNET_APPROVER_NUMBER" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails}string500" minOccurs="0"/>
 *         &lt;element name="INVOICE_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPS.QFEQIF_APINV_INV_INFO", propOrder = {
    "requesternumber",
    "alternetapprovernumber",
    "invoiceamount",
    "orgid"
})
public class APPSQFEQIFAPINVINVINFO {

    @XmlElementRef(name = "REQUESTER_NUMBER", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class, required = false)
    protected JAXBElement<String> requesternumber;
    @XmlElementRef(name = "ALTERNET_APPROVER_NUMBER", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class, required = false)
    protected JAXBElement<String> alternetapprovernumber;
    @XmlElementRef(name = "INVOICE_AMOUNT", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> invoiceamount;
    @XmlElementRef(name = "ORG_ID", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> orgid;

    /**
     * Gets the value of the requesternumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getREQUESTERNUMBER() {
        return requesternumber;
    }

    /**
     * Sets the value of the requesternumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setREQUESTERNUMBER(JAXBElement<String> value) {
        this.requesternumber = value;
    }

    /**
     * Gets the value of the alternetapprovernumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getALTERNETAPPROVERNUMBER() {
        return alternetapprovernumber;
    }

    /**
     * Sets the value of the alternetapprovernumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setALTERNETAPPROVERNUMBER(JAXBElement<String> value) {
        this.alternetapprovernumber = value;
    }

    /**
     * Gets the value of the invoiceamount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getINVOICEAMOUNT() {
        return invoiceamount;
    }

    /**
     * Sets the value of the invoiceamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setINVOICEAMOUNT(JAXBElement<BigDecimal> value) {
        this.invoiceamount = value;
    }

    /**
     * Gets the value of the orgid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setORGID(JAXBElement<BigDecimal> value) {
        this.orgid = value;
    }

}
