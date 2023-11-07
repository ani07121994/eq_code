
package ap.quantas.com.ebs_inv_process_new.js;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APPS.JSEQ_OUT_RESULT_TBL_TYPE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPS.JSEQ_OUT_RESULT_TBL_TYPE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OUT_RESULT_ITEM" type="{http://xmlns.oracle.com/pcbpel/adapter/db/sp/JSEQ_INV_IMG_PROCESS}APPS.JSEQ_OUT_RESULT_REC" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPS.JSEQ_OUT_RESULT_TBL_TYPE", propOrder = {
    "outresultitem"
})
public class APPSJSEQOUTRESULTTBLTYPE {

    @XmlElement(name = "OUT_RESULT_ITEM", nillable = true)
    protected List<APPSJSEQOUTRESULTREC> outresultitem;

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
     * {@link APPSJSEQOUTRESULTREC }
     * 
     * 
     */
    public List<APPSJSEQOUTRESULTREC> getOUTRESULTITEM() {
        if (outresultitem == null) {
            outresultitem = new ArrayList<APPSJSEQOUTRESULTREC>();
        }
        return this.outresultitem;
    }

}
