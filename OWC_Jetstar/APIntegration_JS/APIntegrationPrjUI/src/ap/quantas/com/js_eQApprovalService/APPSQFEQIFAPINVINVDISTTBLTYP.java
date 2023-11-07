
package ap.quantas.com.js_eQApprovalService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APPS.QFEQIF_APINV_INV_DIST_TBL_TYP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPS.QFEQIF_APINV_INV_DIST_TBL_TYP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="INV_DIST_DTL_ITEM" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL}APPS.QFEQIF_APINV_INV_DIST_INFO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPS.QFEQIF_APINV_INV_DIST_TBL_TYP", propOrder = {
    "invdistdtlitem"
})
public class APPSQFEQIFAPINVINVDISTTBLTYP {

    @XmlElement(name = "INV_DIST_DTL_ITEM", nillable = true)
    protected List<APPSQFEQIFAPINVINVDISTINFO> invdistdtlitem;

    /**
     * Gets the value of the invdistdtlitem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invdistdtlitem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getINVDISTDTLITEM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link APPSQFEQIFAPINVINVDISTINFO }
     * 
     * 
     */
    public List<APPSQFEQIFAPINVINVDISTINFO> getINVDISTDTLITEM() {
        if (invdistdtlitem == null) {
            invdistdtlitem = new ArrayList<APPSQFEQIFAPINVINVDISTINFO>();
        }
        return this.invdistdtlitem;
    }

}
