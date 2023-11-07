
package ap.quantas.com.ebsCalculateWHTAmountService;

//import com.oracle.xmlns.pcbpel.adapter.db.sp.jseq_ap_inv_img_process_cal_amt.APPSJSEQAPWHTRECORD;
import ap.quantas.com.ebsCalculateWHTAmountService.APPSJSEQAPWHTRECORD;

//import com.oracle.xmlns.pcbpel.adapter.db.sp.jseq_ap_inv_img_process_cal_amt.APPSJSEQAPWHTTBL;
import ap.quantas.com.ebsCalculateWHTAmountService.APPSJSEQAPWHTTBL;

//import com.oracle.xmlns.pcbpel.adapter.db.sp.jseq_ap_inv_img_process_cal_amt.OutputParameters;
//import ap.quantas.com.ebsCalculateWHTAmountService.OutputParameters;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.pcbpel.adapter.db.sp.jseq_ap_inv_img_process_cal_amt package. 
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

    private final static QName _OutputParametersAPCALCULATEWHTAMOUNTS_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", "AP_CALCULATE_WHT_AMOUNTS");
    private final static QName _OutputParametersPAWTSUCCESS_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", "P_AWT_SUCCESS");
    private final static QName _APPSJSEQAPWHTRECORDLINEAMOUNT_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", "LINE_AMOUNT");
    private final static QName _APPSJSEQAPWHTRECORDAWTDATE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", "AWT_DATE");
    private final static QName _APPSJSEQAPWHTRECORDGLDATE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", "GL_DATE");
    private final static QName _APPSJSEQAPWHTRECORDINVCURRENCYCODE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", "INV_CURRENCY_CODE");
    private final static QName _APPSJSEQAPWHTRECORDORGID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", "ORG_ID");
    private final static QName _APPSJSEQAPWHTRECORDAWTGROUPNAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", "AWT_GROUP_NAME");
    private final static QName _APPSJSEQAPWHTRECORDSUPPLIERSITEID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", "SUPPLIER_SITE_ID");
    private final static QName _InputParametersPJSEQAPWHTTBL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", "P_JSEQAPWHTTBL");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.pcbpel.adapter.db.sp.jseq_ap_inv_img_process_cal_amt
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
     * Create an instance of {@link APPSJSEQAPWHTTBL }
     *
     */
    public APPSJSEQAPWHTTBL createAPPSJSEQAPWHTTBL() {
        return new APPSJSEQAPWHTTBL();
    }

    /**
     * Create an instance of {@link OutputParameters }
     *
     */
    public OutputParameters createOutputParameters() {
        return new OutputParameters();
    }

    /**
     * Create an instance of {@link APPSJSEQAPWHTRECORD }
     *
     */
    public APPSJSEQAPWHTRECORD createAPPSJSEQAPWHTRECORD() {
        return new APPSJSEQAPWHTRECORD();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", name = "AP_CALCULATE_WHT_AMOUNTS", scope = OutputParameters.class)
    public JAXBElement<BigDecimal> createOutputParametersAPCALCULATEWHTAMOUNTS(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_OutputParametersAPCALCULATEWHTAMOUNTS_QNAME, BigDecimal.class,
                                           OutputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", name = "P_AWT_SUCCESS", scope = OutputParameters.class)
    public JAXBElement<String> createOutputParametersPAWTSUCCESS(String value) {
        return new JAXBElement<String>(_OutputParametersPAWTSUCCESS_QNAME, String.class, OutputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", name = "LINE_AMOUNT", scope = APPSJSEQAPWHTRECORD.class)
    public JAXBElement<BigDecimal> createAPPSJSEQAPWHTRECORDLINEAMOUNT(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSJSEQAPWHTRECORDLINEAMOUNT_QNAME, BigDecimal.class,
                                           APPSJSEQAPWHTRECORD.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", name = "AWT_DATE", scope = APPSJSEQAPWHTRECORD.class)
    public JAXBElement<String> createAPPSJSEQAPWHTRECORDAWTDATE(String value) {
        return new JAXBElement<String>(_APPSJSEQAPWHTRECORDAWTDATE_QNAME, String.class,
                                                     APPSJSEQAPWHTRECORD.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", name = "GL_DATE", scope = APPSJSEQAPWHTRECORD.class)
    public JAXBElement<String> createAPPSJSEQAPWHTRECORDGLDATE(String value) {
        return new JAXBElement<String>(_APPSJSEQAPWHTRECORDGLDATE_QNAME, String.class,
                                                     APPSJSEQAPWHTRECORD.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", name = "INV_CURRENCY_CODE", scope = APPSJSEQAPWHTRECORD.class)
    public JAXBElement<String> createAPPSJSEQAPWHTRECORDINVCURRENCYCODE(String value) {
        return new JAXBElement<String>(_APPSJSEQAPWHTRECORDINVCURRENCYCODE_QNAME, String.class, APPSJSEQAPWHTRECORD.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", name = "ORG_ID", scope = APPSJSEQAPWHTRECORD.class)
    public JAXBElement<BigDecimal> createAPPSJSEQAPWHTRECORDORGID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSJSEQAPWHTRECORDORGID_QNAME, BigDecimal.class,
                                           APPSJSEQAPWHTRECORD.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", name = "AWT_GROUP_NAME", scope = APPSJSEQAPWHTRECORD.class)
    public JAXBElement<String> createAPPSJSEQAPWHTRECORDAWTGROUPNAME(String value) {
        return new JAXBElement<String>(_APPSJSEQAPWHTRECORDAWTGROUPNAME_QNAME, String.class, APPSJSEQAPWHTRECORD.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", name = "SUPPLIER_SITE_ID", scope = APPSJSEQAPWHTRECORD.class)
    public JAXBElement<BigDecimal> createAPPSJSEQAPWHTRECORDSUPPLIERSITEID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSJSEQAPWHTRECORDSUPPLIERSITEID_QNAME, BigDecimal.class,
                                           APPSJSEQAPWHTRECORD.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSJSEQAPWHTTBL }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", name = "P_JSEQAPWHTTBL", scope = InputParameters.class)
    public JAXBElement<APPSJSEQAPWHTTBL> createInputParametersPJSEQAPWHTTBL(APPSJSEQAPWHTTBL value) {
        return new JAXBElement<APPSJSEQAPWHTTBL>(_InputParametersPJSEQAPWHTTBL_QNAME,
                                                 APPSJSEQAPWHTTBL.class,
                                                 InputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT", name = "P_AWT_SUCCESS", scope = InputParameters.class)
    public JAXBElement<String> createInputParametersPAWTSUCCESS(String value) {
        return new JAXBElement<String>(_OutputParametersPAWTSUCCESS_QNAME, String.class, InputParameters.class, value);
    }

}
