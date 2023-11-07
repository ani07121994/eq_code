
package ap.qantas.com.ebsCalculateWHTAmountService;

import java.math.BigDecimal;
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
 *         &lt;element name="AP_CALCULATE_WHT_AMOUNTS" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
    "apcalculatewhtamounts",
    "pawtsuccess"
})
@XmlRootElement(name = "OutputParameters")
public class OutputParameters {

    @XmlElementRef(name = "AP_CALCULATE_WHT_AMOUNTS", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> apcalculatewhtamounts;
    @XmlElementRef(name = "P_AWT_SUCCESS", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", type = JAXBElement.class)
    protected JAXBElement<String> pawtsuccess;

    /**
     * Gets the value of the apcalculatewhtamounts property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getAPCALCULATEWHTAMOUNTS() {
        return apcalculatewhtamounts;
    }

    /**
     * Sets the value of the apcalculatewhtamounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setAPCALCULATEWHTAMOUNTS(JAXBElement<BigDecimal> value) {
        this.apcalculatewhtamounts = ((JAXBElement<BigDecimal> ) value);
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
