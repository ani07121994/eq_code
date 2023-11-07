
package ap.quantas.com.ebsCalculateWHTAmountService;

//import com.oracle.xmlns.pcbpel.adapter.db.sp.jseq_ap_inv_img_process_cal_amt.APPSJSEQAPWHTTBL;
import ap.quantas.com.ebsCalculateWHTAmountService.APPSJSEQAPWHTTBL;
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
 *         &lt;element name="P_JSEQAPWHTTBL" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT}APPS.JSEQAPWHTTBL" minOccurs="0"/>
 *         &lt;element name="P_AWT_SUCCESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pjseqapwhttbl",
    "pawtsuccess"
})
@XmlRootElement(name = "InputParameters")
public class InputParameters {

    @XmlElementRef(name = "P_JSEQAPWHTTBL", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", type = JAXBElement.class)
    protected JAXBElement<APPSJSEQAPWHTTBL> pjseqapwhttbl;
    @XmlElementRef(name = "P_AWT_SUCCESS", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", type = JAXBElement.class)
    protected JAXBElement<String> pawtsuccess;

    /**
     * Gets the value of the pjseqapwhttbl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link APPSJSEQAPWHTTBL }{@code >}
     *     
     */
    public JAXBElement<APPSJSEQAPWHTTBL> getPJSEQAPWHTTBL() {
        return pjseqapwhttbl;
    }

    /**
     * Sets the value of the pjseqapwhttbl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link APPSJSEQAPWHTTBL }{@code >}
     *     
     */
    public void setPJSEQAPWHTTBL(JAXBElement<APPSJSEQAPWHTTBL> value) {
        this.pjseqapwhttbl = ((JAXBElement<APPSJSEQAPWHTTBL> ) value);
    }

    /**
     * Gets the value of the pawtsuccess property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPAWTSUCCESS() {
        return pawtsuccess;
    }

    /**
     * Sets the value of the pawtsuccess property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPAWTSUCCESS(JAXBElement<String> value) {
        this.pawtsuccess = ((JAXBElement<String> ) value);
    }

}
