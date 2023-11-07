
package ap.quantas.com.ebsCalculateWHTAmountService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Java class for APPS.JSEQAPWHTTBL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPS.JSEQAPWHTTBL">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="P_JSEQAPWHTTBL_ITEM" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_AP_INV_IMG_PROCESS_CAL_AMT}APPS.JSEQAPWHTRECORD" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPS.JSEQAPWHTTBL", propOrder = {
    "pjseqapwhttblitem"
})
public class APPSJSEQAPWHTTBL {

    @XmlElement(name = "P_JSEQAPWHTTBL_ITEM", nillable = true)
    public List<ap.quantas.com.ebsCalculateWHTAmountService.APPSJSEQAPWHTRECORD> pjseqapwhttblitem;

    /**
     * Gets the value of the pjseqapwhttblitem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pjseqapwhttblitem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPJSEQAPWHTTBLITEM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link APPSJSEQAPWHTRECORD }
     * 
     * 
     */
    public List<APPSJSEQAPWHTRECORD> getPJSEQAPWHTTBLITEM() {
        if (pjseqapwhttblitem == null) {
            pjseqapwhttblitem = new ArrayList<APPSJSEQAPWHTRECORD>();
        }
        return this.pjseqapwhttblitem;
    }

}
