
package ap.quantas.com.js_eQApprovalService;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APPS.QFEQIF_APINV_INV_DIST_INFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPS.QFEQIF_APINV_INV_DIST_INFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LINE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LINE_TYPE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL}string200" minOccurs="0"/>
 *         &lt;element name="GL_CODE_COMB" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL}string500" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPS.QFEQIF_APINV_INV_DIST_INFO", propOrder = {
    "linenumber",
    "linetype",
    "glcodecomb"
})
public class APPSQFEQIFAPINVINVDISTINFO {

    @XmlElementRef(name = "LINE_NUMBER", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> linenumber;
    @XmlElementRef(name = "LINE_TYPE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", type = JAXBElement.class)
    protected JAXBElement<String> linetype;
    @XmlElementRef(name = "GL_CODE_COMB", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", type = JAXBElement.class)
    protected JAXBElement<String> glcodecomb;

    /**
     * Gets the value of the linenumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getLINENUMBER() {
        return linenumber;
    }

    /**
     * Sets the value of the linenumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setLINENUMBER(JAXBElement<BigDecimal> value) {
        this.linenumber = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the linetype property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINETYPE() {
        return linetype;
    }

    /**
     * Sets the value of the linetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINETYPE(JAXBElement<String> value) {
        this.linetype = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the glcodecomb property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGLCODECOMB() {
        return glcodecomb;
    }

    /**
     * Sets the value of the glcodecomb property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGLCODECOMB(JAXBElement<String> value) {
        this.glcodecomb = ((JAXBElement<String> ) value);
    }

}
