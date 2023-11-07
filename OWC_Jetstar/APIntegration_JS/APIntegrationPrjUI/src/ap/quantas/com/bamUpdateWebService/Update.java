
package ap.quantas.com.bamUpdateWebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Update complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Update">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataObject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="keysCSV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="xmlPayload" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Update", propOrder = {
    "dataObject",
    "keysCSV",
    "xmlPayload"
})
public class Update {

    protected String dataObject;
    protected String keysCSV;
    protected String xmlPayload;

    /**
     * Gets the value of the dataObject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataObject() {
        return dataObject;
    }

    /**
     * Sets the value of the dataObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataObject(String value) {
        this.dataObject = value;
    }

    /**
     * Gets the value of the keysCSV property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeysCSV() {
        return keysCSV;
    }

    /**
     * Sets the value of the keysCSV property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeysCSV(String value) {
        this.keysCSV = value;
    }

    /**
     * Gets the value of the xmlPayload property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlPayload() {
        return xmlPayload;
    }

    /**
     * Sets the value of the xmlPayload property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlPayload(String value) {
        this.xmlPayload = value;
    }

}
