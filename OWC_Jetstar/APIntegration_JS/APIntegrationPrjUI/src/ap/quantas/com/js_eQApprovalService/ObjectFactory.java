
package ap.quantas.com.js_eQApprovalService;



import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import ap.quantas.com.js_eQApprovalService.*;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oracle.xmlns.pcbpel.adapter.db.sp.jseq_ap_inv_img_process_approver_dtl package. 
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

    private final static QName _APPSQFEQIFAPINVINVINFOORGID_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "ORG_ID");
    private final static QName _APPSQFEQIFAPINVINVINFOALTERNETAPPROVERNUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "ALTERNET_APPROVER_NUMBER");
    private final static QName _APPSQFEQIFAPINVINVINFOINVOICEAMOUNT_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "INVOICE_AMOUNT");
    private final static QName _APPSQFEQIFAPINVINVINFOREQUESTERNUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "REQUESTER_NUMBER");
    private final static QName _OutputParametersSTATUS_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "STATUS");
    private final static QName _OutputParametersOUTRESULT_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "OUT_RESULT");
    private final static QName _OutputParametersMESSAGE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "MESSAGE");
    private final static QName _APPSQFEQIFAPINVAPPROVERRECAPPFNDLCATEGORY_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "APP_FNDL_CATEGORY");
    private final static QName _APPSQFEQIFAPINVAPPROVERRECAPPEMAIL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "APP_EMAIL");
    private final static QName _APPSQFEQIFAPINVAPPROVERRECAPPPOSITION_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "APP_POSITION");
    private final static QName _APPSQFEQIFAPINVAPPROVERRECAPPEMPNO_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "APP_EMP_NO");
    private final static QName _APPSQFEQIFAPINVAPPROVERRECAPPAPPROVELIMIT_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "APP_APPROVE_LIMIT");
    private final static QName _APPSQFEQIFAPINVAPPROVERRECAPPNAME_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "APP_NAME");
    private final static QName _APPSQFEQIFAPINVINVDISTINFOGLCODECOMB_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "GL_CODE_COMB");
    private final static QName _APPSQFEQIFAPINVINVDISTINFOLINENUMBER_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "LINE_NUMBER");
    private final static QName _APPSQFEQIFAPINVINVDISTINFOLINETYPE_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "LINE_TYPE");
    private final static QName _InputParametersINVDETAILS_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "INV_DETAILS");
    private final static QName _InputParametersINVDISTDTL_QNAME = new QName("http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", "INV_DIST_DTL");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.pcbpel.adapter.db.sp.jseq_ap_inv_img_process_approver_dtl
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
     * Create an instance of {@link APPSQFEQIFAPINVINVINFO }
     * 
     */
    public APPSQFEQIFAPINVINVINFO createAPPSQFEQIFAPINVINVINFO() {
        return new APPSQFEQIFAPINVINVINFO();
    }

    /**
     * Create an instance of {@link APPSQFEQIFAPINVINVDISTTBLTYP }
     * 
     */
    public APPSQFEQIFAPINVINVDISTTBLTYP createAPPSQFEQIFAPINVINVDISTTBLTYP() {
        return new APPSQFEQIFAPINVINVDISTTBLTYP();
    }

    /**
     * Create an instance of {@link OutputParameters }
     * 
     */
    public OutputParameters createOutputParameters() {
        return new OutputParameters();
    }

    /**
     * Create an instance of {@link APPSQFEQIFAPINVAPRVROUTTBLTP }
     * 
     */
    public APPSQFEQIFAPINVAPRVROUTTBLTP createAPPSQFEQIFAPINVAPRVROUTTBLTP() {
        return new APPSQFEQIFAPINVAPRVROUTTBLTP();
    }

    /**
     * Create an instance of {@link APPSQFEQIFAPINVINVDISTINFO }
     * 
     */
    public APPSQFEQIFAPINVINVDISTINFO createAPPSQFEQIFAPINVINVDISTINFO() {
        return new APPSQFEQIFAPINVINVDISTINFO();
    }

    /**
     * Create an instance of {@link APPSQFEQIFAPINVAPPROVERREC }
     * 
     */
    public APPSQFEQIFAPINVAPPROVERREC createAPPSQFEQIFAPINVAPPROVERREC() {
        return new APPSQFEQIFAPINVAPPROVERREC();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "ORG_ID", scope = APPSQFEQIFAPINVINVINFO.class)
    public JAXBElement<BigDecimal> createAPPSQFEQIFAPINVINVINFOORGID(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSQFEQIFAPINVINVINFOORGID_QNAME, BigDecimal.class, APPSQFEQIFAPINVINVINFO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "ALTERNET_APPROVER_NUMBER", scope = APPSQFEQIFAPINVINVINFO.class)
    public JAXBElement<String> createAPPSQFEQIFAPINVINVINFOALTERNETAPPROVERNUMBER(String value) {
        return new JAXBElement<String>(_APPSQFEQIFAPINVINVINFOALTERNETAPPROVERNUMBER_QNAME, String.class, APPSQFEQIFAPINVINVINFO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "INVOICE_AMOUNT", scope = APPSQFEQIFAPINVINVINFO.class)
    public JAXBElement<BigDecimal> createAPPSQFEQIFAPINVINVINFOINVOICEAMOUNT(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSQFEQIFAPINVINVINFOINVOICEAMOUNT_QNAME, BigDecimal.class, APPSQFEQIFAPINVINVINFO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "REQUESTER_NUMBER", scope = APPSQFEQIFAPINVINVINFO.class)
    public JAXBElement<String> createAPPSQFEQIFAPINVINVINFOREQUESTERNUMBER(String value) {
        return new JAXBElement<String>(_APPSQFEQIFAPINVINVINFOREQUESTERNUMBER_QNAME, String.class, APPSQFEQIFAPINVINVINFO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "STATUS", scope = OutputParameters.class)
    public JAXBElement<String> createOutputParametersSTATUS(String value) {
        return new JAXBElement<String>(_OutputParametersSTATUS_QNAME, String.class, OutputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSQFEQIFAPINVAPRVROUTTBLTP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "OUT_RESULT", scope = OutputParameters.class)
    public JAXBElement<APPSQFEQIFAPINVAPRVROUTTBLTP> createOutputParametersOUTRESULT(APPSQFEQIFAPINVAPRVROUTTBLTP value) {
        return new JAXBElement<APPSQFEQIFAPINVAPRVROUTTBLTP>(_OutputParametersOUTRESULT_QNAME, APPSQFEQIFAPINVAPRVROUTTBLTP.class, OutputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "MESSAGE", scope = OutputParameters.class)
    public JAXBElement<String> createOutputParametersMESSAGE(String value) {
        return new JAXBElement<String>(_OutputParametersMESSAGE_QNAME, String.class, OutputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "APP_FNDL_CATEGORY", scope = APPSQFEQIFAPINVAPPROVERREC.class)
    public JAXBElement<String> createAPPSQFEQIFAPINVAPPROVERRECAPPFNDLCATEGORY(String value) {
        return new JAXBElement<String>(_APPSQFEQIFAPINVAPPROVERRECAPPFNDLCATEGORY_QNAME, String.class, APPSQFEQIFAPINVAPPROVERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "APP_EMAIL", scope = APPSQFEQIFAPINVAPPROVERREC.class)
    public JAXBElement<String> createAPPSQFEQIFAPINVAPPROVERRECAPPEMAIL(String value) {
        return new JAXBElement<String>(_APPSQFEQIFAPINVAPPROVERRECAPPEMAIL_QNAME, String.class, APPSQFEQIFAPINVAPPROVERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "APP_POSITION", scope = APPSQFEQIFAPINVAPPROVERREC.class)
    public JAXBElement<String> createAPPSQFEQIFAPINVAPPROVERRECAPPPOSITION(String value) {
        return new JAXBElement<String>(_APPSQFEQIFAPINVAPPROVERRECAPPPOSITION_QNAME, String.class, APPSQFEQIFAPINVAPPROVERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "APP_EMP_NO", scope = APPSQFEQIFAPINVAPPROVERREC.class)
    public JAXBElement<BigDecimal> createAPPSQFEQIFAPINVAPPROVERRECAPPEMPNO(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSQFEQIFAPINVAPPROVERRECAPPEMPNO_QNAME, BigDecimal.class, APPSQFEQIFAPINVAPPROVERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "APP_APPROVE_LIMIT", scope = APPSQFEQIFAPINVAPPROVERREC.class)
    public JAXBElement<BigDecimal> createAPPSQFEQIFAPINVAPPROVERRECAPPAPPROVELIMIT(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSQFEQIFAPINVAPPROVERRECAPPAPPROVELIMIT_QNAME, BigDecimal.class, APPSQFEQIFAPINVAPPROVERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "APP_NAME", scope = APPSQFEQIFAPINVAPPROVERREC.class)
    public JAXBElement<String> createAPPSQFEQIFAPINVAPPROVERRECAPPNAME(String value) {
        return new JAXBElement<String>(_APPSQFEQIFAPINVAPPROVERRECAPPNAME_QNAME, String.class, APPSQFEQIFAPINVAPPROVERREC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "GL_CODE_COMB", scope = APPSQFEQIFAPINVINVDISTINFO.class)
    public JAXBElement<String> createAPPSQFEQIFAPINVINVDISTINFOGLCODECOMB(String value) {
        return new JAXBElement<String>(_APPSQFEQIFAPINVINVDISTINFOGLCODECOMB_QNAME, String.class, APPSQFEQIFAPINVINVDISTINFO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "LINE_NUMBER", scope = APPSQFEQIFAPINVINVDISTINFO.class)
    public JAXBElement<BigDecimal> createAPPSQFEQIFAPINVINVDISTINFOLINENUMBER(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APPSQFEQIFAPINVINVDISTINFOLINENUMBER_QNAME, BigDecimal.class, APPSQFEQIFAPINVINVDISTINFO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "LINE_TYPE", scope = APPSQFEQIFAPINVINVDISTINFO.class)
    public JAXBElement<String> createAPPSQFEQIFAPINVINVDISTINFOLINETYPE(String value) {
        return new JAXBElement<String>(_APPSQFEQIFAPINVINVDISTINFOLINETYPE_QNAME, String.class, APPSQFEQIFAPINVINVDISTINFO.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSQFEQIFAPINVINVINFO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "INV_DETAILS", scope = InputParameters.class)
    public JAXBElement<APPSQFEQIFAPINVINVINFO> createInputParametersINVDETAILS(APPSQFEQIFAPINVINVINFO value) {
        return new JAXBElement<APPSQFEQIFAPINVINVINFO>(_InputParametersINVDETAILS_QNAME, APPSQFEQIFAPINVINVINFO.class, InputParameters.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link APPSQFEQIFAPINVINVDISTTBLTYP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL", name = "INV_DIST_DTL", scope = InputParameters.class)
    public JAXBElement<APPSQFEQIFAPINVINVDISTTBLTYP> createInputParametersINVDISTDTL(APPSQFEQIFAPINVINVDISTTBLTYP value) {
        return new JAXBElement<APPSQFEQIFAPINVINVDISTTBLTYP>(_InputParametersINVDISTDTL_QNAME, APPSQFEQIFAPINVINVDISTTBLTYP.class, InputParameters.class, value);
    }

}
