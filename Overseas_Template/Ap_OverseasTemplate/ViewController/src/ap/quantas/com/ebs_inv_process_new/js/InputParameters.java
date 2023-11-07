
package ap.quantas.com.ebs_inv_process_new.js;

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
 *         &lt;element name="P_INVOICE_IN" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_INV_IMG_PROCESS}APPS.JSEQ_INVOICE_HEADER_REC" minOccurs="0"/>
 *         &lt;element name="P_INV_LINE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_INV_IMG_PROCESS}APPS.JSEQ_INVOICE_IN_TBL_TYPE" minOccurs="0"/>
 *         &lt;element name="P_CALLED_FROM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pinvoicein",
    "pinvline",
    "pcalledfrom"
})
@XmlRootElement(name = "InputParameters")
public class InputParameters {

    @XmlElementRef(name = "P_INVOICE_IN", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_INV_IMG_PROCESS", type = JAXBElement.class, required = false)
    protected JAXBElement<APPSJSEQINVOICEHEADERREC> pinvoicein;
    @XmlElementRef(name = "P_INV_LINE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_INV_IMG_PROCESS", type = JAXBElement.class, required = false)
    protected JAXBElement<APPSJSEQINVOICEINTBLTYPE> pinvline;
    @XmlElementRef(name = "P_CALLED_FROM", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_INV_IMG_PROCESS", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pcalledfrom;

    /**
     * Gets the value of the pinvoicein property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link APPSJSEQINVOICEHEADERREC }{@code >}
     *     
     */
    public JAXBElement<APPSJSEQINVOICEHEADERREC> getPINVOICEIN() {
        return pinvoicein;
    }

    /**
     * Sets the value of the pinvoicein property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link APPSJSEQINVOICEHEADERREC }{@code >}
     *     
     */
    public void setPINVOICEIN(JAXBElement<APPSJSEQINVOICEHEADERREC> value) {
        this.pinvoicein = value;
    }

    /**
     * Gets the value of the pinvline property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link APPSJSEQINVOICEINTBLTYPE }{@code >}
     *     
     */
    public JAXBElement<APPSJSEQINVOICEINTBLTYPE> getPINVLINE() {
        return pinvline;
    }

    /**
     * Sets the value of the pinvline property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link APPSJSEQINVOICEINTBLTYPE }{@code >}
     *     
     */
    public void setPINVLINE(JAXBElement<APPSJSEQINVOICEINTBLTYPE> value) {
        this.pinvline = value;
    }

    /**
     * Gets the value of the pcalledfrom property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPCALLEDFROM() {
        return pcalledfrom;
    }

    /**
     * Sets the value of the pcalledfrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPCALLEDFROM(JAXBElement<String> value) {
        this.pcalledfrom = value;
    }

}
