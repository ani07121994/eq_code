
package ap.quantas.com.ebs_inv_process;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import ap.quantas.com.ebs_inv_process.APPSINVOICEHEADERREC;
import ap.quantas.com.ebs_inv_process.ObjectFactory;



/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.pcbpel.adapter.db.sp.qfeq_ap_inv_img_process package. 
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

    private final static QName _APPSINVOICELINERECLINENO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINENO");
    private final static QName _APPSINVOICELINERECTAXRATECODE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "TAXRATECODE");
    private final static QName _APPSINVOICELINERECLINEPONUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINEPONUMBER");
    private final static QName _APPSINVOICELINERECSUSPENSEACCOUNTFLAG_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "SUSPENSE_ACCOUNT_FLAG");
    private final static QName _APPSINVOICELINERECPOLINENUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "POLINENUMBER");
    private final static QName _APPSINVOICELINERECLINEAATT9_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINEAATT9");
    private final static QName _APPSINVOICELINERECLINEAATT8_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINEAATT8");
    private final static QName _APPSINVOICELINERECQUANTITY_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "QUANTITY");
    private final static QName _APPSINVOICELINERECPROJECTNO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "PROJECTNO");
    private final static QName _APPSINVOICELINERECLINEAATT7_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINEAATT7");
    private final static QName _APPSINVOICELINERECLINEAATT6_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINEAATT6");
    private final static QName _APPSINVOICELINERECLINEAATT5_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINEAATT5");
    private final static QName _APPSINVOICELINERECLINETAXAMOUNT_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINETAXAMOUNT");
    private final static QName _APPSINVOICELINERECLINEAATT4_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINEAATT4");
    private final static QName _APPSINVOICELINERECLINEAATT1_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINEAATT1");
    private final static QName _APPSINVOICELINERECTAXRATE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "TAXRATE");
    private final static QName _APPSINVOICELINERECLINEAATT2_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINEAATT2");
    private final static QName _APPSINVOICELINERECLINEAATT3_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINEAATT3");
    private final static QName _APPSINVOICELINERECTASKNO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "TASKNO");
    private final static QName _APPSINVOICELINERECLINEDESCRIPTION_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINEDESCRIPTION");
    private final static QName _APPSINVOICELINERECGLCODE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "GLCODE");
    private final static QName _APPSINVOICELINERECLINETYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINETYPE");
    private final static QName _APPSINVOICELINERECEXPENDITURETYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "EXPENDITURETYPE");
    private final static QName _APPSINVOICELINERECEXPENDITUREDATE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "EXPENDITUREDATE");
    private final static QName _APPSINVOICELINERECEXPENDITUREORG_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "EXPENDITUREORG");
    private final static QName _APPSINVOICELINERECLINEAATT10_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINEAATT10");
    private final static QName _APPSINVOICELINERECLINETOTALAMOUNT_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "LINETOTALAMOUNT");
    private final static QName _APPSINVOICELINERECUNITPRICE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "UNITPRICE");
    private final static QName _APPSINVOICELINERECUOM_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "UOM");
    private final static QName _OutputParametersPINVLINE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "P_INV_LINE");
    private final static QName _OutputParametersOUTRESULT_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "OUT_RESULT");
    private final static QName _OutputParametersPINVOICEIN_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "P_INVOICE_IN");
    private final static QName _InputParametersPCALLEDFROM_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "P_CALLED_FROM");
    private final static QName _APPSOUTRESULTRECEXCEPTIONTYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "EXCEPTIONTYPE");
    private final static QName _APPSOUTRESULTRECERRORMESSAGE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "ERRORMESSAGE");
    private final static QName _APPSOUTRESULTRECEXCEPTIONREASON_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "EXCEPTIONREASON");
    private final static QName _APPSINVOICEHEADERRECORGID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "ORGID");
    private final static QName _APPSINVOICEHEADERRECSTATUS_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "STATUS");
    private final static QName _APPSINVOICEHEADERRECINVALIDREASON_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "INVALIDREASON");
    private final static QName _APPSINVOICEHEADERRECIMAGEURL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "IMAGEURL");
    private final static QName _APPSINVOICEHEADERRECINVOICEIMAGEURL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "INVOICEIMAGEURL");
    private final static QName _APPSINVOICEHEADERRECCHECKNUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "CHECK_NUMBER");
    private final static QName _APPSINVOICEHEADERRECREJECTIONREASON_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "REJECTIONREASON");
    private final static QName _APPSINVOICEHEADERRECPAYGROUP_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "PAYGROUP");
    private final static QName _APPSINVOICEHEADERRECSITEID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "SITEID");
    private final static QName _APPSINVOICEHEADERRECSUPPLIERID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "SUPPLIERID");
    private final static QName _APPSINVOICEHEADERRECINVOICETYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "INVOICETYPE");
    private final static QName _APPSINVOICEHEADERRECALTERNATEAPPROVEREMPLOYEENO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "ALTERNATEAPPROVEREMPLOYEENO");
    private final static QName _APPSINVOICEHEADERRECINVOICEDATE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "INVOICEDATE");
    private final static QName _APPSINVOICEHEADERRECHEADERATT6_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "HEADERATT6");
    private final static QName _APPSINVOICEHEADERRECDOCUMENTTYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "DOCUMENTTYPE");
    private final static QName _APPSINVOICEHEADERRECHEADERATT7_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "HEADERATT7");
    private final static QName _APPSINVOICEHEADERRECCERTIFIERCOMMENTS_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "CERTIFIERCOMMENTS");
    private final static QName _APPSINVOICEHEADERRECHEADERATT4_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "HEADERATT4");
    private final static QName _APPSINVOICEHEADERRECWITHHOLDINGTAX_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "WITHHOLDINGTAX");
    private final static QName _APPSINVOICEHEADERRECHEADERATT5_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "HEADERATT5");
    private final static QName _APPSINVOICEHEADERRECHEADERATT8_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "HEADERATT8");
    private final static QName _APPSINVOICEHEADERRECHEADERATT9_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "HEADERATT9");
    private final static QName _APPSINVOICEHEADERRECPONUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "PONUMBER");
    private final static QName _APPSINVOICEHEADERRECTAXREGISTRATIONNUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "TAXREGISTRATIONNUMBER");
    private final static QName _APPSINVOICEHEADERRECPRIORITY_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "PRIORITY");
    private final static QName _APPSINVOICEHEADERRECPAYMENTMETHOD_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "PAYMENT_METHOD");
    private final static QName _APPSINVOICEHEADERRECREASONTYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "REASONTYPE");
    private final static QName _APPSINVOICEHEADERRECINVOICENUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "INVOICENUMBER");
    private final static QName _APPSINVOICEHEADERRECHEADERATT10_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "HEADERATT10");
    private final static QName _APPSINVOICEHEADERRECCERTIFIEREMPLOYEENO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "CERTIFIEREMPLOYEENO");
    private final static QName _APPSINVOICEHEADERRECHEADERTAXTOTAL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "HEADERTAXTOTAL");
    private final static QName _APPSINVOICEHEADERRECINVALIDCODE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "INVALIDCODE");
    private final static QName _APPSINVOICEHEADERRECSUPPLIERNUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "SUPPLIERNUMBER");
    private final static QName _APPSINVOICEHEADERRECSUPPLIERNAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "SUPPLIERNAME");
    private final static QName _APPSINVOICEHEADERRECSITENAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "SITENAME");
    private final static QName _APPSINVOICEHEADERRECINVOICETOTALAMOUNT_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "INVOICETOTALAMOUNT");
    private final static QName _APPSINVOICEHEADERRECCERTIFIEREMAILADD_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "CERTIFIEREMAILADD");
    private final static QName _APPSINVOICEHEADERRECCURRENCYCODE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "CURRENCYCODE");
    private final static QName _APPSINVOICEHEADERRECPOTYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "POTYPE");
    private final static QName _APPSINVOICEHEADERRECCERTIFIERNAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", "CERTIFIERNAME");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.pcbpel.adapter.db.sp.qfeq_ap_inv_img_process
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
     * Create an instance of {@link APPSINVOICEHEADERREC }
     * 
     */
    public APPSINVOICEHEADERREC createAPPSINVOICEHEADERREC() {
        return new APPSINVOICEHEADERREC();
    }

    /**
     * Create an instance of {@link APPSINVOICEINTBLTYPE }
     * 
     */
    public APPSINVOICEINTBLTYPE createAPPSINVOICEINTBLTYPE() {
        return new APPSINVOICEINTBLTYPE();
    }

    /**
     * Create an instance of {@link OutputParameters }
     * 
     */
    public OutputParameters createOutputParameters() {
        return new OutputParameters();
    }

    /**
     * Create an instance of {@link APPSOUTRESULTTBLTYPE }
     * 
     */
    public APPSOUTRESULTTBLTYPE createAPPSOUTRESULTTBLTYPE() {
        return new APPSOUTRESULTTBLTYPE();
    }

    /**
     * Create an instance of {@link APPSOUTRESULTREC }
     * 
     */
    public APPSOUTRESULTREC createAPPSOUTRESULTREC() {
        return new APPSOUTRESULTREC();
    }

    /**
     * Create an instance of {@link APPSINVOICELINEREC }
     * 
     */
    public APPSINVOICELINEREC createAPPSINVOICELINEREC() {
        return new APPSINVOICELINEREC();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINENO", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINENO(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINENO_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "TAXRATECODE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECTAXRATECODE(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECTAXRATECODE_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINEPONUMBER", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEPONUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEPONUMBER_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "SUSPENSE_ACCOUNT_FLAG", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECSUSPENSEACCOUNTFLAG(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECSUSPENSEACCOUNTFLAG_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "POLINENUMBER", scope = APPSINVOICELINEREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICELINERECPOLINENUMBER(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICELINERECPOLINENUMBER_QNAME, BigDecimal.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINEAATT9", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT9(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT9_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINEAATT8", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT8(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT8_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "QUANTITY", scope = APPSINVOICELINEREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICELINERECQUANTITY(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICELINERECQUANTITY_QNAME, BigDecimal.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "PROJECTNO", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECPROJECTNO(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECPROJECTNO_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINEAATT7", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT7(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT7_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINEAATT6", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT6(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT6_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINEAATT5", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT5(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT5_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINETAXAMOUNT", scope = APPSINVOICELINEREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICELINERECLINETAXAMOUNT(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICELINERECLINETAXAMOUNT_QNAME, BigDecimal.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINEAATT4", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT4(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT4_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINEAATT1", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT1(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT1_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "TAXRATE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICELINERECTAXRATE(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICELINERECTAXRATE_QNAME, BigDecimal.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINEAATT2", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT2(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT2_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINEAATT3", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT3(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT3_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "TASKNO", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECTASKNO(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECTASKNO_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINEDESCRIPTION", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEDESCRIPTION(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEDESCRIPTION_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "GLCODE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECGLCODE(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECGLCODE_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINETYPE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINETYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINETYPE_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "EXPENDITURETYPE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECEXPENDITURETYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECEXPENDITURETYPE_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "EXPENDITUREDATE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<XMLGregorianCalendar> createAPPSINVOICELINERECEXPENDITUREDATE(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_APPSINVOICELINERECEXPENDITUREDATE_QNAME, XMLGregorianCalendar.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "EXPENDITUREORG", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECEXPENDITUREORG(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECEXPENDITUREORG_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINEAATT10", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECLINEAATT10(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECLINEAATT10_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "LINETOTALAMOUNT", scope = APPSINVOICELINEREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICELINERECLINETOTALAMOUNT(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICELINERECLINETOTALAMOUNT_QNAME, BigDecimal.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "UNITPRICE", scope = APPSINVOICELINEREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICELINERECUNITPRICE(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICELINERECUNITPRICE_QNAME, BigDecimal.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "UOM", scope = APPSINVOICELINEREC.class)
    public JAXBElement<String> createAPPSINVOICELINERECUOM(String value) {
        return new JAXBElement<String>(_APPSINVOICELINERECUOM_QNAME, String.class, APPSINVOICELINEREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSINVOICEINTBLTYPE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "P_INV_LINE", scope = OutputParameters.class)
    public JAXBElement<APPSINVOICEINTBLTYPE> createOutputParametersPINVLINE(APPSINVOICEINTBLTYPE value) {
        return new JAXBElement<APPSINVOICEINTBLTYPE>(_OutputParametersPINVLINE_QNAME, APPSINVOICEINTBLTYPE.class, OutputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSOUTRESULTTBLTYPE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "OUT_RESULT", scope = OutputParameters.class)
    public JAXBElement<APPSOUTRESULTTBLTYPE> createOutputParametersOUTRESULT(APPSOUTRESULTTBLTYPE value) {
        return new JAXBElement<APPSOUTRESULTTBLTYPE>(_OutputParametersOUTRESULT_QNAME, APPSOUTRESULTTBLTYPE.class, OutputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSINVOICEHEADERREC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "P_INVOICE_IN", scope = OutputParameters.class)
    public JAXBElement<APPSINVOICEHEADERREC> createOutputParametersPINVOICEIN(APPSINVOICEHEADERREC value) {
        return new JAXBElement<APPSINVOICEHEADERREC>(_OutputParametersPINVOICEIN_QNAME, APPSINVOICEHEADERREC.class, OutputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSINVOICEINTBLTYPE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "P_INV_LINE", scope = InputParameters.class)
    public JAXBElement<APPSINVOICEINTBLTYPE> createInputParametersPINVLINE(APPSINVOICEINTBLTYPE value) {
        return new JAXBElement<APPSINVOICEINTBLTYPE>(_OutputParametersPINVLINE_QNAME, APPSINVOICEINTBLTYPE.class, InputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSINVOICEHEADERREC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "P_INVOICE_IN", scope = InputParameters.class)
    public JAXBElement<APPSINVOICEHEADERREC> createInputParametersPINVOICEIN(APPSINVOICEHEADERREC value) {
        return new JAXBElement<APPSINVOICEHEADERREC>(_OutputParametersPINVOICEIN_QNAME, APPSINVOICEHEADERREC.class, InputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "P_CALLED_FROM", scope = InputParameters.class)
    public JAXBElement<String> createInputParametersPCALLEDFROM(String value) {
        return new JAXBElement<String>(_InputParametersPCALLEDFROM_QNAME, String.class, InputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "EXCEPTIONTYPE", scope = APPSOUTRESULTREC.class)
    public JAXBElement<String> createAPPSOUTRESULTRECEXCEPTIONTYPE(String value) {
        return new JAXBElement<String>(_APPSOUTRESULTRECEXCEPTIONTYPE_QNAME, String.class, APPSOUTRESULTREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "ERRORMESSAGE", scope = APPSOUTRESULTREC.class)
    public JAXBElement<String> createAPPSOUTRESULTRECERRORMESSAGE(String value) {
        return new JAXBElement<String>(_APPSOUTRESULTRECERRORMESSAGE_QNAME, String.class, APPSOUTRESULTREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "EXCEPTIONREASON", scope = APPSOUTRESULTREC.class)
    public JAXBElement<String> createAPPSOUTRESULTRECEXCEPTIONREASON(String value) {
        return new JAXBElement<String>(_APPSOUTRESULTRECEXCEPTIONREASON_QNAME, String.class, APPSOUTRESULTREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "ORGID", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECORGID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECORGID_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "STATUS", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECSTATUS(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECSTATUS_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "INVALIDREASON", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVALIDREASON(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVALIDREASON_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "IMAGEURL", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECIMAGEURL(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECIMAGEURL_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "INVOICEIMAGEURL", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVOICEIMAGEURL(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVOICEIMAGEURL_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "CHECK_NUMBER", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCHECKNUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCHECKNUMBER_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "REJECTIONREASON", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECREJECTIONREASON(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECREJECTIONREASON_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "PAYGROUP", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECPAYGROUP(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECPAYGROUP_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "SITEID", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECSITEID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECSITEID_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "SUPPLIERID", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECSUPPLIERID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECSUPPLIERID_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "INVOICETYPE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVOICETYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVOICETYPE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "ALTERNATEAPPROVEREMPLOYEENO", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECALTERNATEAPPROVEREMPLOYEENO(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECALTERNATEAPPROVEREMPLOYEENO_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "INVOICEDATE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<XMLGregorianCalendar> createAPPSINVOICEHEADERRECINVOICEDATE(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_APPSINVOICEHEADERRECINVOICEDATE_QNAME, XMLGregorianCalendar.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "HEADERATT6", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT6(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT6_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "DOCUMENTTYPE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECDOCUMENTTYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECDOCUMENTTYPE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "HEADERATT7", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT7(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT7_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "CERTIFIERCOMMENTS", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCERTIFIERCOMMENTS(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCERTIFIERCOMMENTS_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "HEADERATT4", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT4(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT4_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "WITHHOLDINGTAX", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECWITHHOLDINGTAX(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECWITHHOLDINGTAX_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "HEADERATT5", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT5(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT5_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "HEADERATT8", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT8(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT8_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "HEADERATT9", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT9(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT9_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "PONUMBER", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECPONUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECPONUMBER_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "TAXREGISTRATIONNUMBER", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECTAXREGISTRATIONNUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECTAXREGISTRATIONNUMBER_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "PRIORITY", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECPRIORITY(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECPRIORITY_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "PAYMENT_METHOD", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECPAYMENTMETHOD(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECPAYMENTMETHOD_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "REASONTYPE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECREASONTYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECREASONTYPE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "INVOICENUMBER", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVOICENUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVOICENUMBER_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "HEADERATT10", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECHEADERATT10(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECHEADERATT10_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "CERTIFIEREMPLOYEENO", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCERTIFIEREMPLOYEENO(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCERTIFIEREMPLOYEENO_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "HEADERTAXTOTAL", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECHEADERTAXTOTAL(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECHEADERTAXTOTAL_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "INVALIDCODE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECINVALIDCODE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECINVALIDCODE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "SUPPLIERNUMBER", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECSUPPLIERNUMBER(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECSUPPLIERNUMBER_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "SUPPLIERNAME", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECSUPPLIERNAME(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECSUPPLIERNAME_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "SITENAME", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECSITENAME(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECSITENAME_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "INVOICETOTALAMOUNT", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<BigDecimal> createAPPSINVOICEHEADERRECINVOICETOTALAMOUNT(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSINVOICEHEADERRECINVOICETOTALAMOUNT_QNAME, BigDecimal.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "CERTIFIEREMAILADD", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCERTIFIEREMAILADD(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCERTIFIEREMAILADD_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "CURRENCYCODE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCURRENCYCODE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCURRENCYCODE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "POTYPE", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECPOTYPE(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECPOTYPE_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/QFEQ_AP_INV_IMG_PROCESS", name = "CERTIFIERNAME", scope = APPSINVOICEHEADERREC.class)
    public JAXBElement<String> createAPPSINVOICEHEADERRECCERTIFIERNAME(String value) {
        return new JAXBElement<String>(_APPSINVOICEHEADERRECCERTIFIERNAME_QNAME, String.class, APPSINVOICEHEADERREC.class, value);
    }

}
