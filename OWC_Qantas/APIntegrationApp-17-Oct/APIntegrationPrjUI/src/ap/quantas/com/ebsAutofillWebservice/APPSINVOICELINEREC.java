
package ap.quantas.com.ebsAutofillWebservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for APPS.INVOICE_LINE_REC complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPS.INVOICE_LINE_REC">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LINENO" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string50" minOccurs="0"/>
 *         &lt;element name="LINETYPE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string25" minOccurs="0"/>
 *         &lt;element name="LINEPONUMBER" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string20" minOccurs="0"/>
 *         &lt;element name="POLINENUMBER" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LINEDESCRIPTION" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string500" minOccurs="0"/>
 *         &lt;element name="QUANTITY" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="UOM" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string25" minOccurs="0"/>
 *         &lt;element name="UNITPRICE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LINETOTALAMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TAXRATE" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="TAXRATECODE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string10" minOccurs="0"/>
 *         &lt;element name="LINETAXAMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PROJECTNO" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string25" minOccurs="0"/>
 *         &lt;element name="TASKNO" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string25" minOccurs="0"/>
 *         &lt;element name="EXPENDITUREORG" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string200" minOccurs="0"/>
 *         &lt;element name="EXPENDITUREDATE" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="EXPENDITURETYPE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string200" minOccurs="0"/>
 *         &lt;element name="GLCODE" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string100" minOccurs="0"/>
 *         &lt;element name="LINEAATT1" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string1000" minOccurs="0"/>
 *         &lt;element name="LINEAATT2" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string1000" minOccurs="0"/>
 *         &lt;element name="LINEAATT3" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string1000" minOccurs="0"/>
 *         &lt;element name="LINEAATT4" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string1000" minOccurs="0"/>
 *         &lt;element name="LINEAATT5" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string1000" minOccurs="0"/>
 *         &lt;element name="LINEAATT6" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string1000" minOccurs="0"/>
 *         &lt;element name="LINEAATT7" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string1000" minOccurs="0"/>
 *         &lt;element name="LINEAATT8" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string1000" minOccurs="0"/>
 *         &lt;element name="LINEAATT9" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string1000" minOccurs="0"/>
 *         &lt;element name="LINEAATT10" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update}string1000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPS.INVOICE_LINE_REC", propOrder = {
    "lineno",
    "linetype",
    "lineponumber",
    "polinenumber",
    "linedescription",
    "quantity",
    "uom",
    "unitprice",
    "linetotalamount",
    "taxrate",
    "taxratecode",
    "linetaxamount",
    "projectno",
    "taskno",
    "expenditureorg",
    "expendituredate",
    "expendituretype",
    "glcode",
    "lineaatt1",
    "lineaatt2",
    "lineaatt3",
    "lineaatt4",
    "lineaatt5",
    "lineaatt6",
    "lineaatt7",
    "lineaatt8",
    "lineaatt9",
    "lineaatt10"
})
public class APPSINVOICELINEREC {

    @XmlElementRef(name = "LINENO", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> lineno;
    @XmlElementRef(name = "LINETYPE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> linetype;
    @XmlElementRef(name = "LINEPONUMBER", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> lineponumber;
    @XmlElementRef(name = "POLINENUMBER", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> polinenumber;
    @XmlElementRef(name = "LINEDESCRIPTION", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> linedescription;
    @XmlElementRef(name = "QUANTITY", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> quantity;
    @XmlElementRef(name = "UOM", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> uom;
    @XmlElementRef(name = "UNITPRICE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> unitprice;
    @XmlElementRef(name = "LINETOTALAMOUNT", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> linetotalamount;
    @XmlElementRef(name = "TAXRATE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> taxrate;
    @XmlElementRef(name = "TAXRATECODE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> taxratecode;
    @XmlElementRef(name = "LINETAXAMOUNT", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<BigDecimal> linetaxamount;
    @XmlElementRef(name = "PROJECTNO", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> projectno;
    @XmlElementRef(name = "TASKNO", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> taskno;
    @XmlElementRef(name = "EXPENDITUREORG", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> expenditureorg;
    @XmlElementRef(name = "EXPENDITUREDATE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> expendituredate;
    @XmlElementRef(name = "EXPENDITURETYPE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> expendituretype;
    @XmlElementRef(name = "GLCODE", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> glcode;
    @XmlElementRef(name = "LINEAATT1", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> lineaatt1;
    @XmlElementRef(name = "LINEAATT2", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> lineaatt2;
    @XmlElementRef(name = "LINEAATT3", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> lineaatt3;
    @XmlElementRef(name = "LINEAATT4", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> lineaatt4;
    @XmlElementRef(name = "LINEAATT5", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> lineaatt5;
    @XmlElementRef(name = "LINEAATT6", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> lineaatt6;
    @XmlElementRef(name = "LINEAATT7", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> lineaatt7;
    @XmlElementRef(name = "LINEAATT8", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> lineaatt8;
    @XmlElementRef(name = "LINEAATT9", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> lineaatt9;
    @XmlElementRef(name = "LINEAATT10", namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", type = JAXBElement.class)
    protected JAXBElement<String> lineaatt10;

    /**
     * Gets the value of the lineno property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINENO() {
        return lineno;
    }

    /**
     * Sets the value of the lineno property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINENO(JAXBElement<String> value) {
        this.lineno = ((JAXBElement<String> ) value);
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
     * Gets the value of the lineponumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINEPONUMBER() {
        return lineponumber;
    }

    /**
     * Sets the value of the lineponumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINEPONUMBER(JAXBElement<String> value) {
        this.lineponumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the polinenumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getPOLINENUMBER() {
        return polinenumber;
    }

    /**
     * Sets the value of the polinenumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setPOLINENUMBER(JAXBElement<BigDecimal> value) {
        this.polinenumber = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the linedescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINEDESCRIPTION() {
        return linedescription;
    }

    /**
     * Sets the value of the linedescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINEDESCRIPTION(JAXBElement<String> value) {
        this.linedescription = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getQUANTITY() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setQUANTITY(JAXBElement<BigDecimal> value) {
        this.quantity = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the uom property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUOM() {
        return uom;
    }

    /**
     * Sets the value of the uom property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUOM(JAXBElement<String> value) {
        this.uom = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the unitprice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getUNITPRICE() {
        return unitprice;
    }

    /**
     * Sets the value of the unitprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setUNITPRICE(JAXBElement<BigDecimal> value) {
        this.unitprice = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the linetotalamount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getLINETOTALAMOUNT() {
        return linetotalamount;
    }

    /**
     * Sets the value of the linetotalamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setLINETOTALAMOUNT(JAXBElement<BigDecimal> value) {
        this.linetotalamount = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the taxrate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getTAXRATE() {
        return taxrate;
    }

    /**
     * Sets the value of the taxrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setTAXRATE(JAXBElement<BigDecimal> value) {
        this.taxrate = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the taxratecode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTAXRATECODE() {
        return taxratecode;
    }

    /**
     * Sets the value of the taxratecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTAXRATECODE(JAXBElement<String> value) {
        this.taxratecode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the linetaxamount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getLINETAXAMOUNT() {
        return linetaxamount;
    }

    /**
     * Sets the value of the linetaxamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setLINETAXAMOUNT(JAXBElement<BigDecimal> value) {
        this.linetaxamount = ((JAXBElement<BigDecimal> ) value);
    }

    /**
     * Gets the value of the projectno property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPROJECTNO() {
        return projectno;
    }

    /**
     * Sets the value of the projectno property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPROJECTNO(JAXBElement<String> value) {
        this.projectno = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the taskno property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTASKNO() {
        return taskno;
    }

    /**
     * Sets the value of the taskno property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTASKNO(JAXBElement<String> value) {
        this.taskno = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the expenditureorg property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEXPENDITUREORG() {
        return expenditureorg;
    }

    /**
     * Sets the value of the expenditureorg property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEXPENDITUREORG(JAXBElement<String> value) {
        this.expenditureorg = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the expendituredate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getEXPENDITUREDATE() {
        return expendituredate;
    }

    /**
     * Sets the value of the expendituredate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setEXPENDITUREDATE(JAXBElement<XMLGregorianCalendar> value) {
        this.expendituredate = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the expendituretype property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEXPENDITURETYPE() {
        return expendituretype;
    }

    /**
     * Sets the value of the expendituretype property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEXPENDITURETYPE(JAXBElement<String> value) {
        this.expendituretype = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the glcode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGLCODE() {
        return glcode;
    }

    /**
     * Sets the value of the glcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGLCODE(JAXBElement<String> value) {
        this.glcode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lineaatt1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINEAATT1() {
        return lineaatt1;
    }

    /**
     * Sets the value of the lineaatt1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINEAATT1(JAXBElement<String> value) {
        this.lineaatt1 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lineaatt2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINEAATT2() {
        return lineaatt2;
    }

    /**
     * Sets the value of the lineaatt2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINEAATT2(JAXBElement<String> value) {
        this.lineaatt2 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lineaatt3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINEAATT3() {
        return lineaatt3;
    }

    /**
     * Sets the value of the lineaatt3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINEAATT3(JAXBElement<String> value) {
        this.lineaatt3 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lineaatt4 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINEAATT4() {
        return lineaatt4;
    }

    /**
     * Sets the value of the lineaatt4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINEAATT4(JAXBElement<String> value) {
        this.lineaatt4 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lineaatt5 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINEAATT5() {
        return lineaatt5;
    }

    /**
     * Sets the value of the lineaatt5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINEAATT5(JAXBElement<String> value) {
        this.lineaatt5 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lineaatt6 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINEAATT6() {
        return lineaatt6;
    }

    /**
     * Sets the value of the lineaatt6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINEAATT6(JAXBElement<String> value) {
        this.lineaatt6 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lineaatt7 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINEAATT7() {
        return lineaatt7;
    }

    /**
     * Sets the value of the lineaatt7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINEAATT7(JAXBElement<String> value) {
        this.lineaatt7 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lineaatt8 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINEAATT8() {
        return lineaatt8;
    }

    /**
     * Sets the value of the lineaatt8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINEAATT8(JAXBElement<String> value) {
        this.lineaatt8 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lineaatt9 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINEAATT9() {
        return lineaatt9;
    }

    /**
     * Sets the value of the lineaatt9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINEAATT9(JAXBElement<String> value) {
        this.lineaatt9 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the lineaatt10 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLINEAATT10() {
        return lineaatt10;
    }

    /**
     * Sets the value of the lineaatt10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLINEAATT10(JAXBElement<String> value) {
        this.lineaatt10 = ((JAXBElement<String> ) value);
    }

}
