
package ap.quantas.com.ebsCalculateInvoiceDueDateWebService;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for APPS.INVOICE_HEADER_REC complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPS.INVOICE_HEADER_REC">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DOCUMENTTYPE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string200" minOccurs="0"/>
 *         &lt;element name="INVOICETYPE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string200" minOccurs="0"/>
 *         &lt;element name="ORGID" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="INVOICENUMBER" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string50" minOccurs="0"/>
 *         &lt;element name="INVOICEDATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="SUPPLIERID" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SUPPLIERNAME" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string240" minOccurs="0"/>
 *         &lt;element name="SUPPLIERNUMBER" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string30" minOccurs="0"/>
 *         &lt;element name="SITEID" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="SITENAME" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string15" minOccurs="0"/>
 *         &lt;element name="PONUMBER" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string20" minOccurs="0"/>
 *         &lt;element name="TAXREGISTRATIONNUMBER" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string20" minOccurs="0"/>
 *         &lt;element name="HEADERTAXTOTAL" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="WITHHOLDINGTAX" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string100" minOccurs="0"/>
 *         &lt;element name="INVOICETOTALAMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CURRENCYCODE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string15" minOccurs="0"/>
 *         &lt;element name="CERTIFIERNAME" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string240" minOccurs="0"/>
 *         &lt;element name="CERTIFIEREMPLOYEENO" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string30" minOccurs="0"/>
 *         &lt;element name="CERTIFIEREMAILADD" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string240" minOccurs="0"/>
 *         &lt;element name="INVALIDREASON" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string500" minOccurs="0"/>
 *         &lt;element name="INVALIDCODE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string200" minOccurs="0"/>
 *         &lt;element name="POTYPE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string25" minOccurs="0"/>
 *         &lt;element name="ALTERNATEAPPROVEREMPLOYEENO" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string240" minOccurs="0"/>
 *         &lt;element name="CERTIFIERCOMMENTS" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string500" minOccurs="0"/>
 *         &lt;element name="INVOICEIMAGEURL" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string300" minOccurs="0"/>
 *         &lt;element name="HEADERATT4" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string1000" minOccurs="0"/>
 *         &lt;element name="HEADERATT5" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string1000" minOccurs="0"/>
 *         &lt;element name="HEADERATT6" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string1000" minOccurs="0"/>
 *         &lt;element name="HEADERATT7" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string1000" minOccurs="0"/>
 *         &lt;element name="HEADERATT8" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string1000" minOccurs="0"/>
 *         &lt;element name="HEADERATT9" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string1000" minOccurs="0"/>
 *         &lt;element name="HEADERATT10" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string1000" minOccurs="0"/>
 *         &lt;element name="IMAGEURL" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string300" minOccurs="0"/>
 *         &lt;element name="PRIORITY" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string50" minOccurs="0"/>
 *         &lt;element name="REASONTYPE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string300" minOccurs="0"/>
 *         &lt;element name="STATUS" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string300" minOccurs="0"/>
 *         &lt;element name="REJECTIONREASON" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService}string300" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPS.INVOICE_HEADER_REC", propOrder = {
    "documenttype",
    "invoicetype",
    "orgid",
    "invoicenumber",
    "invoicedate",
    "supplierid",
    "suppliername",
    "suppliernumber",
    "siteid",
    "sitename",
    "ponumber",
    "taxregistrationnumber",
    "headertaxtotal",
    "withholdingtax",
    "invoicetotalamount",
    "currencycode",
    "certifiername",
    "certifieremployeeno",
    "certifieremailadd",
    "invalidreason",
    "invalidcode",
    "potype",
    "alternateapproveremployeeno",
    "certifiercomments",
    "invoiceimageurl",
    "headeratt4",
    "headeratt5",
    "headeratt6",
    "headeratt7",
    "headeratt8",
    "headeratt9",
    "headeratt10",
    "imageurl",
    "priority",
    "reasontype",
    "status",
    "rejectionreason"
})
public class APPSINVOICEHEADERREC {

    @XmlElementRef(name = "DOCUMENTTYPE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> documenttype;
    @XmlElementRef(name = "INVOICETYPE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> invoicetype;
    @XmlElementRef(name = "ORGID", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> orgid;
    @XmlElementRef(name = "INVOICENUMBER", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> invoicenumber;
    @XmlElementRef(name = "INVOICEDATE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> invoicedate;
    @XmlElementRef(name = "SUPPLIERID", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> supplierid;
    @XmlElementRef(name = "SUPPLIERNAME", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> suppliername;
    @XmlElementRef(name = "SUPPLIERNUMBER", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> suppliernumber;
    @XmlElementRef(name = "SITEID", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> siteid;
    @XmlElementRef(name = "SITENAME", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> sitename;
    @XmlElementRef(name = "PONUMBER", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> ponumber;
    @XmlElementRef(name = "TAXREGISTRATIONNUMBER", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> taxregistrationnumber;
    @XmlElementRef(name = "HEADERTAXTOTAL", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> headertaxtotal;
    @XmlElementRef(name = "WITHHOLDINGTAX", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> withholdingtax;
    @XmlElementRef(name = "INVOICETOTALAMOUNT", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> invoicetotalamount;
    @XmlElementRef(name = "CURRENCYCODE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> currencycode;
    @XmlElementRef(name = "CERTIFIERNAME", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> certifiername;
    @XmlElementRef(name = "CERTIFIEREMPLOYEENO", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> certifieremployeeno;
    @XmlElementRef(name = "CERTIFIEREMAILADD", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> certifieremailadd;
    @XmlElementRef(name = "INVALIDREASON", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> invalidreason;
    @XmlElementRef(name = "INVALIDCODE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> invalidcode;
    @XmlElementRef(name = "POTYPE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> potype;
    @XmlElementRef(name = "ALTERNATEAPPROVEREMPLOYEENO", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> alternateapproveremployeeno;
    @XmlElementRef(name = "CERTIFIERCOMMENTS", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> certifiercomments;
    @XmlElementRef(name = "INVOICEIMAGEURL", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> invoiceimageurl;
    @XmlElementRef(name = "HEADERATT4", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> headeratt4;
    @XmlElementRef(name = "HEADERATT5", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> headeratt5;
    @XmlElementRef(name = "HEADERATT6", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> headeratt6;
    @XmlElementRef(name = "HEADERATT7", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> headeratt7;
    @XmlElementRef(name = "HEADERATT8", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> headeratt8;
    @XmlElementRef(name = "HEADERATT9", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> headeratt9;
    @XmlElementRef(name = "HEADERATT10", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> headeratt10;
    @XmlElementRef(name = "IMAGEURL", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> imageurl;
    @XmlElementRef(name = "PRIORITY", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> priority;
    @XmlElementRef(name = "REASONTYPE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> reasontype;
    @XmlElementRef(name = "STATUS", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> status;
    @XmlElementRef(name = "REJECTIONREASON", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", type = JAXBElement.class)
    protected JAXBElement<String> rejectionreason;

    /**
     * Gets the value of the documenttype property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDOCUMENTTYPE() {
        return documenttype;
    }

    /**
     * Sets the value of the documenttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDOCUMENTTYPE(JAXBElement<String> value) {
        this.documenttype = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the invoicetype property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getINVOICETYPE() {
        return invoicetype;
    }

    /**
     * Sets the value of the invoicetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setINVOICETYPE(JAXBElement<String> value) {
        this.invoicetype = ((JAXBElement<String> ) value);
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
     * Gets the value of the invoicenumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getINVOICENUMBER() {
        return invoicenumber;
    }

    /**
     * Sets the value of the invoicenumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setINVOICENUMBER(JAXBElement<String> value) {
        this.invoicenumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the invoicedate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getINVOICEDATE() {
        return invoicedate;
    }

    /**
     * Sets the value of the invoicedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setINVOICEDATE(JAXBElement<XMLGregorianCalendar> value) {
        this.invoicedate = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the supplierid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getSUPPLIERID() {
        return supplierid;
    }

    /**
     * Sets the value of the supplierid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setSUPPLIERID(JAXBElement<BigDecimal> value) {
        this.supplierid = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the suppliername property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSUPPLIERNAME() {
        return suppliername;
    }

    /**
     * Sets the value of the suppliername property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSUPPLIERNAME(JAXBElement<String> value) {
        this.suppliername = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the suppliernumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSUPPLIERNUMBER() {
        return suppliernumber;
    }

    /**
     * Sets the value of the suppliernumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSUPPLIERNUMBER(JAXBElement<String> value) {
        this.suppliernumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the siteid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setSITEID(JAXBElement<BigDecimal> value) {
        this.siteid = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the sitename property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSITENAME() {
        return sitename;
    }

    /**
     * Sets the value of the sitename property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSITENAME(JAXBElement<String> value) {
        this.sitename = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ponumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPONUMBER() {
        return ponumber;
    }

    /**
     * Sets the value of the ponumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPONUMBER(JAXBElement<String> value) {
        this.ponumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the taxregistrationnumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTAXREGISTRATIONNUMBER() {
        return taxregistrationnumber;
    }

    /**
     * Sets the value of the taxregistrationnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTAXREGISTRATIONNUMBER(JAXBElement<String> value) {
        this.taxregistrationnumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the headertaxtotal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getHEADERTAXTOTAL() {
        return headertaxtotal;
    }

    /**
     * Sets the value of the headertaxtotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setHEADERTAXTOTAL(JAXBElement<BigDecimal> value) {
        this.headertaxtotal = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the withholdingtax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWITHHOLDINGTAX() {
        return withholdingtax;
    }

    /**
     * Sets the value of the withholdingtax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWITHHOLDINGTAX(JAXBElement<String> value) {
        this.withholdingtax = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the invoicetotalamount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getINVOICETOTALAMOUNT() {
        return invoicetotalamount;
    }

    /**
     * Sets the value of the invoicetotalamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setINVOICETOTALAMOUNT(JAXBElement<BigDecimal> value) {
        this.invoicetotalamount = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the currencycode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCURRENCYCODE() {
        return currencycode;
    }

    /**
     * Sets the value of the currencycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCURRENCYCODE(JAXBElement<String> value) {
        this.currencycode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the certifiername property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCERTIFIERNAME() {
        return certifiername;
    }

    /**
     * Sets the value of the certifiername property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCERTIFIERNAME(JAXBElement<String> value) {
        this.certifiername = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the certifieremployeeno property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCERTIFIEREMPLOYEENO() {
        return certifieremployeeno;
    }

    /**
     * Sets the value of the certifieremployeeno property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCERTIFIEREMPLOYEENO(JAXBElement<String> value) {
        this.certifieremployeeno = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the certifieremailadd property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCERTIFIEREMAILADD() {
        return certifieremailadd;
    }

    /**
     * Sets the value of the certifieremailadd property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCERTIFIEREMAILADD(JAXBElement<String> value) {
        this.certifieremailadd = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the invalidreason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getINVALIDREASON() {
        return invalidreason;
    }

    /**
     * Sets the value of the invalidreason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setINVALIDREASON(JAXBElement<String> value) {
        this.invalidreason = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the invalidcode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getINVALIDCODE() {
        return invalidcode;
    }

    /**
     * Sets the value of the invalidcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setINVALIDCODE(JAXBElement<String> value) {
        this.invalidcode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the potype property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPOTYPE() {
        return potype;
    }

    /**
     * Sets the value of the potype property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPOTYPE(JAXBElement<String> value) {
        this.potype = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the alternateapproveremployeeno property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getALTERNATEAPPROVEREMPLOYEENO() {
        return alternateapproveremployeeno;
    }

    /**
     * Sets the value of the alternateapproveremployeeno property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setALTERNATEAPPROVEREMPLOYEENO(JAXBElement<String> value) {
        this.alternateapproveremployeeno = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the certifiercomments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCERTIFIERCOMMENTS() {
        return certifiercomments;
    }

    /**
     * Sets the value of the certifiercomments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCERTIFIERCOMMENTS(JAXBElement<String> value) {
        this.certifiercomments = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the invoiceimageurl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getINVOICEIMAGEURL() {
        return invoiceimageurl;
    }

    /**
     * Sets the value of the invoiceimageurl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setINVOICEIMAGEURL(JAXBElement<String> value) {
        this.invoiceimageurl = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the headeratt4 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHEADERATT4() {
        return headeratt4;
    }

    /**
     * Sets the value of the headeratt4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHEADERATT4(JAXBElement<String> value) {
        this.headeratt4 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the headeratt5 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHEADERATT5() {
        return headeratt5;
    }

    /**
     * Sets the value of the headeratt5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHEADERATT5(JAXBElement<String> value) {
        this.headeratt5 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the headeratt6 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHEADERATT6() {
        return headeratt6;
    }

    /**
     * Sets the value of the headeratt6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHEADERATT6(JAXBElement<String> value) {
        this.headeratt6 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the headeratt7 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHEADERATT7() {
        return headeratt7;
    }

    /**
     * Sets the value of the headeratt7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHEADERATT7(JAXBElement<String> value) {
        this.headeratt7 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the headeratt8 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHEADERATT8() {
        return headeratt8;
    }

    /**
     * Sets the value of the headeratt8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHEADERATT8(JAXBElement<String> value) {
        this.headeratt8 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the headeratt9 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHEADERATT9() {
        return headeratt9;
    }

    /**
     * Sets the value of the headeratt9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHEADERATT9(JAXBElement<String> value) {
        this.headeratt9 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the headeratt10 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHEADERATT10() {
        return headeratt10;
    }

    /**
     * Sets the value of the headeratt10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHEADERATT10(JAXBElement<String> value) {
        this.headeratt10 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the imageurl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIMAGEURL() {
        return imageurl;
    }

    /**
     * Sets the value of the imageurl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIMAGEURL(JAXBElement<String> value) {
        this.imageurl = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPRIORITY() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPRIORITY(JAXBElement<String> value) {
        this.priority = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the reasontype property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getREASONTYPE() {
        return reasontype;
    }

    /**
     * Sets the value of the reasontype property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setREASONTYPE(JAXBElement<String> value) {
        this.reasontype = ((JAXBElement<String> ) value);
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
     * Gets the value of the rejectionreason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getREJECTIONREASON() {
        return rejectionreason;
    }

    /**
     * Sets the value of the rejectionreason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setREJECTIONREASON(JAXBElement<String> value) {
        this.rejectionreason = ((JAXBElement<String> ) value);
    }

}
