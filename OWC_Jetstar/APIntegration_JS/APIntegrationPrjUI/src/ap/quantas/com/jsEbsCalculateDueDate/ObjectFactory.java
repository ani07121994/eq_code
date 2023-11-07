
package ap.quantas.com.jsEbsCalculateDueDate;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.pcbpel.adapter.db.sp.jseq_ap_inv_img_process_auto_populate package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _APPSJSEQINVOICEHEADERRECHEADERATT4_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "HEADERATT4");
    private final static QName _APPSJSEQINVOICEHEADERRECWITHHOLDINGTAX_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "WITHHOLDINGTAX");
    private final static QName _APPSJSEQINVOICEHEADERRECHEADERATT5_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "HEADERATT5");
    private final static QName _APPSJSEQINVOICEHEADERRECHEADERATT6_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "HEADERATT6");
    private final static QName _APPSJSEQINVOICEHEADERRECDOCUMENTTYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "DOCUMENTTYPE");
    private final static QName _APPSJSEQINVOICEHEADERRECHEADERATT7_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "HEADERATT7");
    private final static QName _APPSJSEQINVOICEHEADERRECCERTIFIERCOMMENTS_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "CERTIFIERCOMMENTS");
    private final static QName _APPSJSEQINVOICEHEADERRECHEADERATT8_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "HEADERATT8");
    private final static QName _APPSJSEQINVOICEHEADERRECHEADERATT9_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "HEADERATT9");
    private final static QName _APPSJSEQINVOICEHEADERRECSITEID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "SITEID");
    private final static QName _APPSJSEQINVOICEHEADERRECREJECTIONREASON_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "REJECTIONREASON");
    private final static QName _APPSJSEQINVOICEHEADERRECINVOICEDATE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "INVOICEDATE");
    private final static QName _APPSJSEQINVOICEHEADERRECSUPPLIERID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "SUPPLIERID");
    private final static QName _APPSJSEQINVOICEHEADERRECINVOICETYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "INVOICETYPE");
    private final static QName _APPSJSEQINVOICEHEADERRECALTERNATEAPPROVEREMPLOYEENO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "ALTERNATEAPPROVEREMPLOYEENO");
    private final static QName _APPSJSEQINVOICEHEADERRECINVALIDREASON_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "INVALIDREASON");
    private final static QName _APPSJSEQINVOICEHEADERRECORGID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "ORGID");
    private final static QName _APPSJSEQINVOICEHEADERRECSTATUS_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "STATUS");
    private final static QName _APPSJSEQINVOICEHEADERRECINVOICEIMAGEURL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "INVOICEIMAGEURL");
    private final static QName _APPSJSEQINVOICEHEADERRECIMAGEURL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "IMAGEURL");
    private final static QName _APPSJSEQINVOICEHEADERRECCERTIFIEREMAILADD_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "CERTIFIEREMAILADD");
    private final static QName _APPSJSEQINVOICEHEADERRECCURRENCYCODE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "CURRENCYCODE");
    private final static QName _APPSJSEQINVOICEHEADERRECPOTYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "POTYPE");
    private final static QName _APPSJSEQINVOICEHEADERRECCERTIFIERNAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "CERTIFIERNAME");
    private final static QName _APPSJSEQINVOICEHEADERRECSUPPLIERNUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "SUPPLIERNUMBER");
    private final static QName _APPSJSEQINVOICEHEADERRECSUPPLIERNAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "SUPPLIERNAME");
    private final static QName _APPSJSEQINVOICEHEADERRECSITENAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "SITENAME");
    private final static QName _APPSJSEQINVOICEHEADERRECINVOICETOTALAMOUNT_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "INVOICETOTALAMOUNT");
    private final static QName _APPSJSEQINVOICEHEADERRECHEADERATT10_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "HEADERATT10");
    private final static QName _APPSJSEQINVOICEHEADERRECCERTIFIEREMPLOYEENO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "CERTIFIEREMPLOYEENO");
    private final static QName _APPSJSEQINVOICEHEADERRECINVALIDCODE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "INVALIDCODE");
    private final static QName _APPSJSEQINVOICEHEADERRECHEADERTAXTOTAL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "HEADERTAXTOTAL");
    private final static QName _APPSJSEQINVOICEHEADERRECPRIORITY_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "PRIORITY");
    private final static QName _APPSJSEQINVOICEHEADERRECPONUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "PONUMBER");
    private final static QName _APPSJSEQINVOICEHEADERRECTAXREGISTRATIONNUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "TAXREGISTRATIONNUMBER");
    private final static QName _APPSJSEQINVOICEHEADERRECINVOICENUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "INVOICENUMBER");
    private final static QName _APPSJSEQINVOICEHEADERRECREASONTYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "REASONTYPE");
    private final static QName _OutputParametersPINVOICEIN_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", "P_INVOICE_IN");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.pcbpel.adapter.db.sp.jseq_ap_inv_img_process_auto_populate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InputParameters }
     * 
     */
    public InputParameters createInputParameters() {
        return new InputParameters();
    }

    /**
     * Create an instance of {@link APPSJSEQINVOICEHEADERREC }
     * 
     */
    public APPSJSEQINVOICEHEADERREC createAPPSJSEQINVOICEHEADERREC() {
        return new APPSJSEQINVOICEHEADERREC();
    }

    /**
     * Create an instance of {@link OutputParameters }
     * 
     */
    public OutputParameters createOutputParameters() {
        return new OutputParameters();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "HEADERATT4", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECHEADERATT4(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECHEADERATT4_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "WITHHOLDINGTAX", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECWITHHOLDINGTAX(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECWITHHOLDINGTAX_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "HEADERATT5", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECHEADERATT5(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECHEADERATT5_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "HEADERATT6", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECHEADERATT6(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECHEADERATT6_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "DOCUMENTTYPE", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECDOCUMENTTYPE(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECDOCUMENTTYPE_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "HEADERATT7", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECHEADERATT7(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECHEADERATT7_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "CERTIFIERCOMMENTS", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECCERTIFIERCOMMENTS(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECCERTIFIERCOMMENTS_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "HEADERATT8", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECHEADERATT8(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECHEADERATT8_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "HEADERATT9", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECHEADERATT9(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECHEADERATT9_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "SITEID", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSJSEQINVOICEHEADERRECSITEID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSJSEQINVOICEHEADERRECSITEID_QNAME, BigDecimal.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "REJECTIONREASON", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECREJECTIONREASON(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECREJECTIONREASON_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "INVOICEDATE", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<XMLGregorianCalendar> createAPPSJSEQINVOICEHEADERRECINVOICEDATE(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_APPSJSEQINVOICEHEADERRECINVOICEDATE_QNAME, XMLGregorianCalendar.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "SUPPLIERID", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSJSEQINVOICEHEADERRECSUPPLIERID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSJSEQINVOICEHEADERRECSUPPLIERID_QNAME, BigDecimal.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "INVOICETYPE", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECINVOICETYPE(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECINVOICETYPE_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "ALTERNATEAPPROVEREMPLOYEENO", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECALTERNATEAPPROVEREMPLOYEENO(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECALTERNATEAPPROVEREMPLOYEENO_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "INVALIDREASON", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECINVALIDREASON(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECINVALIDREASON_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "ORGID", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSJSEQINVOICEHEADERRECORGID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSJSEQINVOICEHEADERRECORGID_QNAME, BigDecimal.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "STATUS", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECSTATUS(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECSTATUS_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "INVOICEIMAGEURL", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECINVOICEIMAGEURL(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECINVOICEIMAGEURL_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "IMAGEURL", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECIMAGEURL(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECIMAGEURL_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "CERTIFIEREMAILADD", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECCERTIFIEREMAILADD(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECCERTIFIEREMAILADD_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "CURRENCYCODE", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECCURRENCYCODE(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECCURRENCYCODE_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "POTYPE", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECPOTYPE(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECPOTYPE_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "CERTIFIERNAME", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECCERTIFIERNAME(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECCERTIFIERNAME_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "SUPPLIERNUMBER", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECSUPPLIERNUMBER(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECSUPPLIERNUMBER_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "SUPPLIERNAME", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECSUPPLIERNAME(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECSUPPLIERNAME_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "SITENAME", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECSITENAME(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECSITENAME_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "INVOICETOTALAMOUNT", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSJSEQINVOICEHEADERRECINVOICETOTALAMOUNT(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSJSEQINVOICEHEADERRECINVOICETOTALAMOUNT_QNAME, BigDecimal.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "HEADERATT10", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECHEADERATT10(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECHEADERATT10_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "CERTIFIEREMPLOYEENO", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECCERTIFIEREMPLOYEENO(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECCERTIFIEREMPLOYEENO_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "INVALIDCODE", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECINVALIDCODE(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECINVALIDCODE_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "HEADERTAXTOTAL", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSJSEQINVOICEHEADERRECHEADERTAXTOTAL(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSJSEQINVOICEHEADERRECHEADERTAXTOTAL_QNAME, BigDecimal.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "PRIORITY", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECPRIORITY(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECPRIORITY_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "PONUMBER", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECPONUMBER(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECPONUMBER_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "TAXREGISTRATIONNUMBER", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECTAXREGISTRATIONNUMBER(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECTAXREGISTRATIONNUMBER_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "INVOICENUMBER", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECINVOICENUMBER(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECINVOICENUMBER_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "REASONTYPE", scope = APPSJSEQINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSJSEQINVOICEHEADERRECREASONTYPE(String value) {
        return new JAXBElement<String>(_APPSJSEQINVOICEHEADERRECREASONTYPE_QNAME, String.class, APPSJSEQINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSJSEQINVOICEHEADERREC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "P_INVOICE_IN", scope = OutputParameters.class)
    public JAXBElement<APPSJSEQINVOICEHEADERREC> createOutputParametersPINVOICEIN(APPSJSEQINVOICEHEADERREC value) {
        return new JAXBElement<APPSJSEQINVOICEHEADERREC>(_OutputParametersPINVOICEIN_QNAME, APPSJSEQINVOICEHEADERREC.class, OutputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSJSEQINVOICEHEADERREC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE", name = "P_INVOICE_IN", scope = InputParameters.class)
    public JAXBElement<APPSJSEQINVOICEHEADERREC> createInputParametersPINVOICEIN(APPSJSEQINVOICEHEADERREC value) {
        return new JAXBElement<APPSJSEQINVOICEHEADERREC>(_OutputParametersPINVOICEIN_QNAME, APPSJSEQINVOICEHEADERREC.class, InputParameters.class, value);
    }

}
