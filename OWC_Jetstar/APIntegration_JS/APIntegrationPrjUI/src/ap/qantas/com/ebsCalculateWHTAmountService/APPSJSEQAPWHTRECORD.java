
package ap.qantas.com.ebsCalculateWHTAmountService;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



/**
 * <p>Java class for APPS.JSEQAPWHTRECORD complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPS.JSEQAPWHTRECORD">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AWT_GROUP_NAME" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT}string25" minOccurs="0"/>
 *         &lt;element name="AWT_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LINE_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="INV_CURRENCY_CODE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT}string25" minOccurs="0"/>
 *         &lt;element name="SUPPLIER_SITE_ID" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="GL_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPS.JSEQAPWHTRECORD", propOrder = {
    "awtgroupname",
    "awtdate",
    "lineamount",
    "orgid",
    "invcurrencycode",
    "suppliersiteid",
    "gldate"
})
public class APPSJSEQAPWHTRECORD {

    @XmlElementRef(name = "AWT_GROUP_NAME", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", type = JAXBElement.class)
    protected JAXBElement<String> awtgroupname;
    @XmlElementRef(name = "AWT_DATE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", type = JAXBElement.class)
    protected JAXBElement<String> awtdate;
    @XmlElementRef(name = "LINE_AMOUNT", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> lineamount;
    @XmlElementRef(name = "ORG_ID", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> orgid;
    @XmlElementRef(name = "INV_CURRENCY_CODE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", type = JAXBElement.class)
    protected JAXBElement<String> invcurrencycode;
    @XmlElementRef(name = "SUPPLIER_SITE_ID", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> suppliersiteid;
    @XmlElementRef(name = "GL_DATE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", type = JAXBElement.class)
    protected JAXBElement<String> gldate;

    /**
     * Gets the value of the awtgroupname property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAWTGROUPNAME() {
        return awtgroupname;
    }

    /**
     * Sets the value of the awtgroupname property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAWTGROUPNAME(JAXBElement<String> value) {
        this.awtgroupname = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the awtdate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAWTDATE() {
        return awtdate;
    }

    /**
     * Sets the value of the awtdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAWTDATE(JAXBElement<String> value) {
        this.awtdate = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lineamount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getLINEAMOUNT() {
        return lineamount;
    }

    /**
     * Sets the value of the lineamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setLINEAMOUNT(JAXBElement<BigDecimal> value) {
        this.lineamount = ((JAXBElement<BigDecimal> ) value);
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
        this.orgid = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the invcurrencycode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getINVCURRENCYCODE() {
        return invcurrencycode;
    }

    /**
     * Sets the value of the invcurrencycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setINVCURRENCYCODE(JAXBElement<String> value) {
        this.invcurrencycode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the suppliersiteid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getSUPPLIERSITEID() {
        return suppliersiteid;
    }

    /**
     * Sets the value of the suppliersiteid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setSUPPLIERSITEID(JAXBElement<BigDecimal> value) {
        this.suppliersiteid = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the gldate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
     public JAXBElement<String> getGLDATE() {
         return gldate;
     }

     /**
      * Sets the value of the gldate property.
      * 
      * @param value
      *     allowed object is
      *     {@link JAXBElement }{@code <}{@link String }{@code >}
      *     
      */
     public void setGLDATE(JAXBElement<String> value) {
         this.gldate = ((JAXBElement<String> ) value);
     }
}