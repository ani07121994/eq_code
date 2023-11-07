
package ap.quantas.com.ebsCalculateInvoiceDueDateWebService;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ap.quantas.com.ebsCalculateInvoiceDueDateWebService package. 
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

    private final static QName _OutputParametersPINVOICEIN_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "P_INVOICE_IN");
    private final static QName _APPSINVOICEHEADERRECINVOICEIMAGEURL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "INVOICEIMAGEURL");
    private final static QName _APPSINVOICEHEADERRECIMAGEURL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "IMAGEURL");
    private final static QName _APPSINVOICEHEADERRECINVALIDREASON_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "INVALIDREASON");
    private final static QName _APPSINVOICEHEADERRECORGID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "ORGID");
    private final static QName _APPSINVOICEHEADERRECSTATUS_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "STATUS");
    private final static QName _APPSINVOICEHEADERRECHEADERATT8_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "HEADERATT8");
    private final static QName _APPSINVOICEHEADERRECHEADERATT9_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "HEADERATT9");
    private final static QName _APPSINVOICEHEADERRECHEADERATT4_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "HEADERATT4");
    private final static QName _APPSINVOICEHEADERRECWITHHOLDINGTAX_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "WITHHOLDINGTAX");
    private final static QName _APPSINVOICEHEADERRECHEADERATT5_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "HEADERATT5");
    private final static QName _APPSINVOICEHEADERRECHEADERATT6_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "HEADERATT6");
    private final static QName _APPSINVOICEHEADERRECDOCUMENTTYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "DOCUMENTTYPE");
    private final static QName _APPSINVOICEHEADERRECHEADERATT7_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "HEADERATT7");
    private final static QName _APPSINVOICEHEADERRECCERTIFIERCOMMENTS_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "CERTIFIERCOMMENTS");
    private final static QName _APPSINVOICEHEADERRECINVOICEDATE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "INVOICEDATE");
    private final static QName _APPSINVOICEHEADERRECSUPPLIERID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "SUPPLIERID");
    private final static QName _APPSINVOICEHEADERRECINVOICETYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "INVOICETYPE");
    private final static QName _APPSINVOICEHEADERRECALTERNATEAPPROVEREMPLOYEENO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "ALTERNATEAPPROVEREMPLOYEENO");
    private final static QName _APPSINVOICEHEADERRECSITEID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "SITEID");
    private final static QName _APPSINVOICEHEADERRECREJECTIONREASON_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "REJECTIONREASON");
    private final static QName _APPSINVOICEHEADERRECINVALIDCODE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "INVALIDCODE");
    private final static QName _APPSINVOICEHEADERRECHEADERTAXTOTAL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "HEADERTAXTOTAL");
    private final static QName _APPSINVOICEHEADERRECHEADERATT10_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "HEADERATT10");
    private final static QName _APPSINVOICEHEADERRECCERTIFIEREMPLOYEENO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "CERTIFIEREMPLOYEENO");
    private final static QName _APPSINVOICEHEADERRECINVOICENUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "INVOICENUMBER");
    private final static QName _APPSINVOICEHEADERRECREASONTYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "REASONTYPE");
    private final static QName _APPSINVOICEHEADERRECPRIORITY_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "PRIORITY");
    private final static QName _APPSINVOICEHEADERRECPONUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "PONUMBER");
    private final static QName _APPSINVOICEHEADERRECTAXREGISTRATIONNUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "TAXREGISTRATIONNUMBER");
    private final static QName _APPSINVOICEHEADERRECCERTIFIERNAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "CERTIFIERNAME");
    private final static QName _APPSINVOICEHEADERRECCERTIFIEREMAILADD_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "CERTIFIEREMAILADD");
    private final static QName _APPSINVOICEHEADERRECCURRENCYCODE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "CURRENCYCODE");
    private final static QName _APPSINVOICEHEADERRECPOTYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "POTYPE");
    private final static QName _APPSINVOICEHEADERRECSITENAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "SITENAME");
    private final static QName _APPSINVOICEHEADERRECINVOICETOTALAMOUNT_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "INVOICETOTALAMOUNT");
    private final static QName _APPSINVOICEHEADERRECSUPPLIERNUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "SUPPLIERNUMBER");
    private final static QName _APPSINVOICEHEADERRECSUPPLIERNAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", "SUPPLIERNAME");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ap.quantas.com.ebsCalculateInvoiceDueDateWebService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OutputParameters }
     * 
     */
    public OutputParameters createOutputParameters() {
        return new OutputParameters();
    }

    /**
     * Create an instance of {@link InputParameters }
     * 
     */
    public InputParameters createInputParameters() {
        return new InputParameters();
    }

    /**
     * Create an instance of {@link APPSINVOICEHEADERREC }
     * 
     */
    public APPSINVOICEHEADERREC createAPPSINVOICEHEADERREC() {
        return new APPSINVOICEHEADERREC();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSINVOICEHEADERREC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "P_INVOICE_IN", scope = OutputParameters.class)
    public JAXBElement<APPSINVOICEHEADERREC> createOutputParametersPINVOICEIN(APPSINVOICEHEADERREC value) {
        return new JAXBElement<APPSINVOICEHEADERREC>(_OutputParametersPINVOICEIN_QNAME, APPSINVOICEHEADERREC.class, OutputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSINVOICEHEADERREC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "P_INVOICE_IN", scope = InputParameters.class)
    public JAXBElement<APPSINVOICEHEADERREC> createInputParametersPINVOICEIN(APPSINVOICEHEADERREC value) {
        return new JAXBElement<APPSINVOICEHEADERREC>(_OutputParametersPINVOICEIN_QNAME, APPSINVOICEHEADERREC.class, InputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "INVOICEIMAGEURL", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVOICEIMAGEURL(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVOICEIMAGEURL_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "IMAGEURL", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECIMAGEURL(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECIMAGEURL_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "INVALIDREASON", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVALIDREASON(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVALIDREASON_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "ORGID", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECORGID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECORGID_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "STATUS", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECSTATUS(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECSTATUS_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "HEADERATT8", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT8(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT8_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "HEADERATT9", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT9(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT9_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "HEADERATT4", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT4(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT4_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "WITHHOLDINGTAX", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECWITHHOLDINGTAX(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECWITHHOLDINGTAX_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "HEADERATT5", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT5(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT5_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "HEADERATT6", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT6(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT6_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "DOCUMENTTYPE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECDOCUMENTTYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECDOCUMENTTYPE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "HEADERATT7", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT7(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT7_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "CERTIFIERCOMMENTS", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCERTIFIERCOMMENTS(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCERTIFIERCOMMENTS_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "INVOICEDATE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<XMLGregorianCalendar> createAPPSINVOICEHEADERRECINVOICEDATE(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_APPSINVOICEHEADERRECINVOICEDATE_QNAME, XMLGregorianCalendar.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "SUPPLIERID", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECSUPPLIERID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECSUPPLIERID_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "INVOICETYPE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVOICETYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVOICETYPE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "ALTERNATEAPPROVEREMPLOYEENO", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECALTERNATEAPPROVEREMPLOYEENO(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECALTERNATEAPPROVEREMPLOYEENO_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "SITEID", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECSITEID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECSITEID_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "REJECTIONREASON", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECREJECTIONREASON(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECREJECTIONREASON_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "INVALIDCODE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVALIDCODE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVALIDCODE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "HEADERTAXTOTAL", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECHEADERTAXTOTAL(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECHEADERTAXTOTAL_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "HEADERATT10", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT10(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT10_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "CERTIFIEREMPLOYEENO", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCERTIFIEREMPLOYEENO(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCERTIFIEREMPLOYEENO_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "INVOICENUMBER", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVOICENUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVOICENUMBER_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "REASONTYPE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECREASONTYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECREASONTYPE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "PRIORITY", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECPRIORITY(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECPRIORITY_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "PONUMBER", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECPONUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECPONUMBER_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "TAXREGISTRATIONNUMBER", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECTAXREGISTRATIONNUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECTAXREGISTRATIONNUMBER_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "CERTIFIERNAME", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCERTIFIERNAME(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCERTIFIERNAME_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "CERTIFIEREMAILADD", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCERTIFIEREMAILADD(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCERTIFIEREMAILADD_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "CURRENCYCODE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCURRENCYCODE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCURRENCYCODE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "POTYPE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECPOTYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECPOTYPE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "SITENAME", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECSITENAME(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECSITENAME_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "INVOICETOTALAMOUNT", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECINVOICETOTALAMOUNT(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECINVOICETOTALAMOUNT_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "SUPPLIERNUMBER", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECSUPPLIERNUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECSUPPLIERNUMBER_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/DueDateService", name = "SUPPLIERNAME", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECSUPPLIERNAME(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECSUPPLIERNAME_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

}
