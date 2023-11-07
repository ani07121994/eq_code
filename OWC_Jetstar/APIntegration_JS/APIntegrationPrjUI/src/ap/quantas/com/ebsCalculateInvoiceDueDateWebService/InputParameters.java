
package ap.quantas.com.ebsCalculateInvoiceDueDateWebService;

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
 *         &lt;element name="P_INVOICE_IN" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}APPS.INVOICE_HEADER_REC" minOccurs="0"/>
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
    "pinvoicein"
})
@XmlRootElement(name = "InputParameters")
public class InputParameters {

    @XmlElementRef(name = "P_INVOICE_IN", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<APPSINVOICEHEADERREC> pinvoicein;

    /**
     * Gets the value of the pinvoicein property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link APPSINVOICEHEADERREC }{@code >}
     *     
     */
    public JAXBElement<APPSINVOICEHEADERREC> getPINVOICEIN() {
        return pinvoicein;
    }

    /**
     * Sets the value of the pinvoicein property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link APPSINVOICEHEADERREC }{@code >}
     *     
     */
    public void setPINVOICEIN(JAXBElement<APPSINVOICEHEADERREC> value) {
        this.pinvoicein = ((JAXBElement<APPSINVOICEHEADERREC> ) value);
    }

}
