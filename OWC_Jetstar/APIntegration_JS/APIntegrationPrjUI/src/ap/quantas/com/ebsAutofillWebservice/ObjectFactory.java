
package ap.quantas.com.ebsAutofillWebservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ap.quantas.com.ebs_webservice package. 
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

    private final static QName _InputParametersPINVLINE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "P_INV_LINE");
    private final static QName _InputParametersPINVOICEIN_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "P_INVOICE_IN");
    private final static QName _APPSINVOICEHEADERRECINVALIDREASON_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "INVALIDREASON");
    private final static QName _APPSINVOICEHEADERRECORGID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "ORGID");
    private final static QName _APPSINVOICEHEADERRECSTATUS_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "STATUS");
    private final static QName _APPSINVOICEHEADERRECINVOICEIMAGEURL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "INVOICEIMAGEURL");
    private final static QName _APPSINVOICEHEADERRECIMAGEURL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "IMAGEURL");
    private final static QName _APPSINVOICEHEADERRECSITEID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "SITEID");
    private final static QName _APPSINVOICEHEADERRECREJECTIONREASON_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "REJECTIONREASON");
    private final static QName _APPSINVOICEHEADERRECINVOICEDATE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "INVOICEDATE");
    private final static QName _APPSINVOICEHEADERRECSUPPLIERID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "SUPPLIERID");
    private final static QName _APPSINVOICEHEADERRECINVOICETYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "INVOICETYPE");
    private final static QName _APPSINVOICEHEADERRECALTERNATEAPPROVEREMPLOYEENO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "ALTERNATEAPPROVEREMPLOYEENO");
    private final static QName _APPSINVOICEHEADERRECHEADERATT4_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "HEADERATT4");
    private final static QName _APPSINVOICEHEADERRECWITHHOLDINGTAX_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "WITHHOLDINGTAX");
    private final static QName _APPSINVOICEHEADERRECHEADERATT5_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "HEADERATT5");
    private final static QName _APPSINVOICEHEADERRECHEADERATT6_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "HEADERATT6");
    private final static QName _APPSINVOICEHEADERRECDOCUMENTTYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "DOCUMENTTYPE");
    private final static QName _APPSINVOICEHEADERRECHEADERATT7_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "HEADERATT7");
    private final static QName _APPSINVOICEHEADERRECCERTIFIERCOMMENTS_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "CERTIFIERCOMMENTS");
    private final static QName _APPSINVOICEHEADERRECHEADERATT8_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "HEADERATT8");
    private final static QName _APPSINVOICEHEADERRECHEADERATT9_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "HEADERATT9");
    private final static QName _APPSINVOICEHEADERRECPRIORITY_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "PRIORITY");
    private final static QName _APPSINVOICEHEADERRECPONUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "PONUMBER");
    private final static QName _APPSINVOICEHEADERRECTAXREGISTRATIONNUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "TAXREGISTRATIONNUMBER");
    private final static QName _APPSINVOICEHEADERRECINVOICENUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "INVOICENUMBER");
    private final static QName _APPSINVOICEHEADERRECREASONTYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "REASONTYPE");
    private final static QName _APPSINVOICEHEADERRECHEADERATT10_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "HEADERATT10");
    private final static QName _APPSINVOICEHEADERRECCERTIFIEREMPLOYEENO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "CERTIFIEREMPLOYEENO");
    private final static QName _APPSINVOICEHEADERRECINVALIDCODE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "INVALIDCODE");
    private final static QName _APPSINVOICEHEADERRECHEADERTAXTOTAL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "HEADERTAXTOTAL");
    private final static QName _APPSINVOICEHEADERRECSUPPLIERNUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "SUPPLIERNUMBER");
    private final static QName _APPSINVOICEHEADERRECSUPPLIERNAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "SUPPLIERNAME");
    private final static QName _APPSINVOICEHEADERRECSITENAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "SITENAME");
    private final static QName _APPSINVOICEHEADERRECINVOICETOTALAMOUNT_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "INVOICETOTALAMOUNT");
    private final static QName _APPSINVOICEHEADERRECCERTIFIEREMAILADD_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "CERTIFIEREMAILADD");
    private final static QName _APPSINVOICEHEADERRECCURRENCYCODE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "CURRENCYCODE");
    private final static QName _APPSINVOICEHEADERRECPOTYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "POTYPE");
    private final static QName _APPSINVOICEHEADERRECCERTIFIERNAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "CERTIFIERNAME");
    
    
    
    private final static QName _APPSINVOICELINERECLINENO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINENO");
    private final static QName _APPSINVOICELINERECTAXRATECODE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "TAXRATECODE");
    private final static QName _APPSINVOICELINERECLINEPONUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINEPONUMBER");
    private final static QName _APPSINVOICELINERECPOLINENUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "POLINENUMBER");
    private final static QName _APPSINVOICELINERECLINEAATT9_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINEAATT9");
    private final static QName _APPSINVOICELINERECLINEAATT8_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINEAATT8");
    private final static QName _APPSINVOICELINERECQUANTITY_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "QUANTITY");
    private final static QName _APPSINVOICELINERECLINEAATT5_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINEAATT5");
    private final static QName _APPSINVOICELINERECLINETAXAMOUNT_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINETAXAMOUNT");
    private final static QName _APPSINVOICELINERECLINEAATT4_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINEAATT4");
    private final static QName _APPSINVOICELINERECPROJECTNO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "PROJECTNO");
    private final static QName _APPSINVOICELINERECLINEAATT7_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINEAATT7");
    private final static QName _APPSINVOICELINERECLINEAATT6_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINEAATT6");
    private final static QName _APPSINVOICELINERECTAXRATE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "TAXRATE");
    private final static QName _APPSINVOICELINERECLINEAATT2_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINEAATT2");
    private final static QName _APPSINVOICELINERECLINEAATT3_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINEAATT3");
    private final static QName _APPSINVOICELINERECLINEAATT1_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINEAATT1");
    private final static QName _APPSINVOICELINERECTASKNO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "TASKNO");
    private final static QName _APPSINVOICELINERECLINEDESCRIPTION_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINEDESCRIPTION");
    private final static QName _APPSINVOICELINERECLINETYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINETYPE");
    private final static QName _APPSINVOICELINERECEXPENDITURETYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "EXPENDITURETYPE");
    private final static QName _APPSINVOICELINERECGLCODE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "GLCODE");
    private final static QName _APPSINVOICELINERECEXPENDITUREORG_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "EXPENDITUREORG");
    private final static QName _APPSINVOICELINERECEXPENDITUREDATE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "EXPENDITUREDATE");
    private final static QName _APPSINVOICELINERECLINEAATT10_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINEAATT10");
    private final static QName _APPSINVOICELINERECLINETOTALAMOUNT_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "LINETOTALAMOUNT");
    private final static QName _APPSINVOICELINERECUNITPRICE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "UNITPRICE");
    private final static QName _APPSINVOICELINERECUOM_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", "UOM");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ap.quantas.com.ebs_webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link APPSINVOICEINTBLTYPE }
     * 
     */
    public APPSINVOICEINTBLTYPE createAPPSINVOICEINTBLTYPE() {
        return new APPSINVOICEINTBLTYPE();
    }

    /**
     * Create an instance of {@link InputParameters }
     * 
     */
    public InputParameters createInputParameters() {
        return new InputParameters();
    }

    /**
     * Create an instance of {@link OutputParameters }
     * 
     */
    public OutputParameters createOutputParameters() {
        return new OutputParameters();
    }

    /**
     * Create an instance of {@link APPSINVOICEHEADERREC }
     * 
     */
    public APPSINVOICEHEADERREC createAPPSINVOICEHEADERREC() {
        return new APPSINVOICEHEADERREC();
    }

    /**
     * Create an instance of {@link APPSINVOICELINEREC }
     * 
     */
    public APPSINVOICELINEREC createAPPSINVOICELINEREC() {
        return new APPSINVOICELINEREC();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSINVOICEINTBLTYPE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "P_INV_LINE", scope = InputParameters.class)
    public JAXBElement<APPSINVOICEINTBLTYPE> createInputParametersPINVLINE(APPSINVOICEINTBLTYPE value) {
        return new JAXBElement<APPSINVOICEINTBLTYPE>(_InputParametersPINVLINE_QNAME, APPSINVOICEINTBLTYPE.class, InputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSINVOICEHEADERREC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "P_INVOICE_IN", scope = InputParameters.class)
    public JAXBElement<APPSINVOICEHEADERREC> createInputParametersPINVOICEIN(APPSINVOICEHEADERREC value) {
        return new JAXBElement<APPSINVOICEHEADERREC>(_InputParametersPINVOICEIN_QNAME, APPSINVOICEHEADERREC.class, InputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSINVOICEINTBLTYPE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "P_INV_LINE", scope = OutputParameters.class)
    public JAXBElement<APPSINVOICEINTBLTYPE> createOutputParametersPINVLINE(APPSINVOICEINTBLTYPE value) {
        return new JAXBElement<APPSINVOICEINTBLTYPE>(_InputParametersPINVLINE_QNAME, APPSINVOICEINTBLTYPE.class, OutputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSINVOICEHEADERREC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "P_INVOICE_IN", scope = OutputParameters.class)
    public JAXBElement<APPSINVOICEHEADERREC> createOutputParametersPINVOICEIN(APPSINVOICEHEADERREC value) {
        return new JAXBElement<APPSINVOICEHEADERREC>(_InputParametersPINVOICEIN_QNAME, APPSINVOICEHEADERREC.class, OutputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "INVALIDREASON", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVALIDREASON(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVALIDREASON_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "ORGID", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECORGID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECORGID_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "STATUS", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECSTATUS(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECSTATUS_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "INVOICEIMAGEURL", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVOICEIMAGEURL(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVOICEIMAGEURL_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "IMAGEURL", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECIMAGEURL(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECIMAGEURL_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "SITEID", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECSITEID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECSITEID_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "REJECTIONREASON", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECREJECTIONREASON(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECREJECTIONREASON_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "INVOICEDATE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<XMLGregorianCalendar> createAPPSINVOICEHEADERRECINVOICEDATE(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_APPSINVOICEHEADERRECINVOICEDATE_QNAME, XMLGregorianCalendar.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "SUPPLIERID", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECSUPPLIERID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECSUPPLIERID_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "INVOICETYPE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVOICETYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVOICETYPE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "ALTERNATEAPPROVEREMPLOYEENO", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECALTERNATEAPPROVEREMPLOYEENO(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECALTERNATEAPPROVEREMPLOYEENO_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "HEADERATT4", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT4(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT4_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "WITHHOLDINGTAX", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECWITHHOLDINGTAX(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECWITHHOLDINGTAX_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "HEADERATT5", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT5(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT5_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "HEADERATT6", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT6(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT6_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "DOCUMENTTYPE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECDOCUMENTTYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECDOCUMENTTYPE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "HEADERATT7", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT7(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT7_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "CERTIFIERCOMMENTS", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCERTIFIERCOMMENTS(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCERTIFIERCOMMENTS_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "HEADERATT8", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT8(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT8_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "HEADERATT9", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT9(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT9_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "PRIORITY", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECPRIORITY(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECPRIORITY_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "PONUMBER", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECPONUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECPONUMBER_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "TAXREGISTRATIONNUMBER", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECTAXREGISTRATIONNUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECTAXREGISTRATIONNUMBER_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "INVOICENUMBER", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVOICENUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVOICENUMBER_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "REASONTYPE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECREASONTYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECREASONTYPE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "HEADERATT10", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT10(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT10_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "CERTIFIEREMPLOYEENO", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCERTIFIEREMPLOYEENO(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCERTIFIEREMPLOYEENO_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "INVALIDCODE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVALIDCODE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVALIDCODE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "HEADERTAXTOTAL", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECHEADERTAXTOTAL(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECHEADERTAXTOTAL_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "SUPPLIERNUMBER", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECSUPPLIERNUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECSUPPLIERNUMBER_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "SUPPLIERNAME", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECSUPPLIERNAME(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECSUPPLIERNAME_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "SITENAME", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECSITENAME(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECSITENAME_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "INVOICETOTALAMOUNT", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECINVOICETOTALAMOUNT(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECINVOICETOTALAMOUNT_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "CERTIFIEREMAILADD", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCERTIFIEREMAILADD(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCERTIFIEREMAILADD_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "CURRENCYCODE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCURRENCYCODE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCURRENCYCODE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "POTYPE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECPOTYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECPOTYPE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "CERTIFIERNAME", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCERTIFIERNAME(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCERTIFIERNAME_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINENO", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINENO(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINENO_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "TAXRATECODE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECTAXRATECODE(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECTAXRATECODE_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINEPONUMBER", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEPONUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEPONUMBER_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "POLINENUMBER", scope = APPSINVOICELINEREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICELINERECPOLINENUMBER(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICELINERECPOLINENUMBER_QNAME, BigDecimal.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINEAATT9", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT9(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT9_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINEAATT8", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT8(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT8_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "QUANTITY", scope = APPSINVOICELINEREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICELINERECQUANTITY(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICELINERECQUANTITY_QNAME, BigDecimal.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINEAATT5", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT5(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT5_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINETAXAMOUNT", scope = APPSINVOICELINEREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICELINERECLINETAXAMOUNT(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICELINERECLINETAXAMOUNT_QNAME, BigDecimal.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINEAATT4", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT4(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT4_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "PROJECTNO", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECPROJECTNO(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECPROJECTNO_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINEAATT7", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT7(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT7_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINEAATT6", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT6(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT6_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "TAXRATE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICELINERECTAXRATE(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICELINERECTAXRATE_QNAME, BigDecimal.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINEAATT2", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT2(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT2_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINEAATT3", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT3(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT3_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINEAATT1", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT1(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT1_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "TASKNO", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECTASKNO(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECTASKNO_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINEDESCRIPTION", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEDESCRIPTION(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEDESCRIPTION_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINETYPE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINETYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINETYPE_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "EXPENDITURETYPE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECEXPENDITURETYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECEXPENDITURETYPE_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "GLCODE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECGLCODE(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECGLCODE_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "EXPENDITUREORG", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECEXPENDITUREORG(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECEXPENDITUREORG_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "EXPENDITUREDATE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<XMLGregorianCalendar> createAPPSINVOICELINERECEXPENDITUREDATE(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_APPSINVOICELINERECEXPENDITUREDATE_QNAME, XMLGregorianCalendar.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINEAATT10", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT10(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT10_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "LINETOTALAMOUNT", scope = APPSINVOICELINEREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICELINERECLINETOTALAMOUNT(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICELINERECLINETOTALAMOUNT_QNAME, BigDecimal.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "UNITPRICE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICELINERECUNITPRICE(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICELINERECUNITPRICE_QNAME, BigDecimal.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/Update", name = "UOM", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECUOM(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECUOM_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

}
