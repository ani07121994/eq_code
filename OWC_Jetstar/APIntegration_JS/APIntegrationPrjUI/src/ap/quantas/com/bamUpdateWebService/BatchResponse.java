
package ap.quantas.com.bamUpdateWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BatchResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BatchResult" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchResponse", propOrder = {
    "batchResult"
})
public class BatchResponse {

    @XmlElement(name = "BatchResult")
    protected boolean batchResult;

    /**
     * Gets the value of the batchResult property.
     * 
     */
    public boolean isBatchResult() {
        return batchResult;
    }

    /**
     * Sets the value of the batchResult property.
     * 
     */
    public void setBatchResult(boolean value) {
        this.batchResult = value;
    }

}
