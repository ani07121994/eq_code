
package ap.quantas.com.bamUpdateWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpsertResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpsertResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UpsertResult" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpsertResponse", propOrder = {
    "upsertResult"
})
public class UpsertResponse {

    @XmlElement(name = "UpsertResult")
    protected boolean upsertResult;

    /**
     * Gets the value of the upsertResult property.
     * 
     */
    public boolean isUpsertResult() {
        return upsertResult;
    }

    /**
     * Sets the value of the upsertResult property.
     * 
     */
    public void setUpsertResult(boolean value) {
        this.upsertResult = value;
    }

}
