
package ap.quantas.com.js.eQApprovalService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APPS.QFEQIF_APINV_APRVR_OUT_TBL_TP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPS.QFEQIF_APINV_APRVR_OUT_TBL_TP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OUT_RESULT_ITEM" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL}APPS.QFEQIF_APINV_APPROVER_REC" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPS.QFEQIF_APINV_APRVR_OUT_TBL_TP", propOrder = {
    "outresultitem"
})
public class APPSQFEQIFAPINVAPRVROUTTBLTP {

    @XmlElement(name = "OUT_RESULT_ITEM", nillable = true)
    protected List<APPSQFEQIFAPINVAPPROVERREC> outresultitem;

    /**
     * Gets the value of the outresultitem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outresultitem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOUTRESULTITEM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link APPSQFEQIFAPINVAPPROVERREC }
     * 
     * 
     */
    public List<APPSQFEQIFAPINVAPPROVERREC> getOUTRESULTITEM() {
        if (outresultitem == null) {
            outresultitem = new ArrayList<APPSQFEQIFAPINVAPPROVERREC>();
        }
        return this.outresultitem;
    }

}
