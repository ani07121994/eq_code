
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
 *         &lt;element name="INV_DETAILS" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails}APPS.QFEQIF_APINV_INV_INFO" minOccurs="0"/>
 *         &lt;element name="INV_DIST_DTL" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails}APPS.QFEQIF_APINV_INV_DIST_TBL_TYP" minOccurs="0"/>
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
    "invdetails",
    "invdistdtl"
})
@XmlRootElement(name = "InputParameters")
public class InputParameters {

    @XmlElementRef(name = "INV_DETAILS", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class)
    protected JAXBElement<APPSQFEQIFAPINVINVINFO> invdetails;
    @XmlElementRef(name = "INV_DIST_DTL", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/approverDetails", type = JAXBElement.class)
    protected JAXBElement<APPSQFEQIFAPINVINVDISTTBLTYP> invdistdtl;

    /**
     * Gets the value of the invdetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link APPSQFEQIFAPINVINVINFO }{@code >}
     *     
     */
    public JAXBElement<APPSQFEQIFAPINVINVINFO> getINVDETAILS() {
        return invdetails;
    }

    /**
     * Sets the value of the invdetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link APPSQFEQIFAPINVINVINFO }{@code >}
     *     
     */
    public void setINVDETAILS(JAXBElement<APPSQFEQIFAPINVINVINFO> value) {
        this.invdetails = ((JAXBElement<APPSQFEQIFAPINVINVINFO> ) value);
    }

    /**
     * Gets the value of the invdistdtl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link APPSQFEQIFAPINVINVDISTTBLTYP }{@code >}
     *     
     */
    public JAXBElement<APPSQFEQIFAPINVINVDISTTBLTYP> getINVDISTDTL() {
        return invdistdtl;
    }

    /**
     * Sets the value of the invdistdtl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link APPSQFEQIFAPINVINVDISTTBLTYP }{@code >}
     *     
     */
    public void setINVDISTDTL(JAXBElement<APPSQFEQIFAPINVINVDISTTBLTYP> value) {
        this.invdistdtl = ((JAXBElement<APPSQFEQIFAPINVINVDISTTBLTYP> ) value);
    }

}
