
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchFormatSelectedField complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchFormatSelectedField">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applicationId" type="{http://imaging.oracle/}NameId" minOccurs="0"/>
 *         &lt;element name="fieldId" type="{http://imaging.oracle/}NameId" minOccurs="0"/>
 *         &lt;element name="property" type="{http://imaging.oracle/}documentProperty" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchFormatSelectedField", propOrder = {
    "applicationId",
    "fieldId",
    "property"
})
public class SearchFormatSelectedField {

    protected NameId applicationId;
    protected NameId fieldId;
    protected DocumentProperty property;

    /**
     * Gets the value of the applicationId property.
     * 
     * @return
     *     possible object is
     *     {@link NameId }
     *     
     */
    public NameId getApplicationId() {
        return applicationId;
    }

    /**
     * Sets the value of the applicationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameId }
     *     
     */
    public void setApplicationId(NameId value) {
        this.applicationId = value;
    }

    /**
     * Gets the value of the fieldId property.
     * 
     * @return
     *     possible object is
     *     {@link NameId }
     *     
     */
    public NameId getFieldId() {
        return fieldId;
    }

    /**
     * Sets the value of the fieldId property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameId }
     *     
     */
    public void setFieldId(NameId value) {
        this.fieldId = value;
    }

    /**
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentProperty }
     *     
     */
    public DocumentProperty getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentProperty }
     *     
     */
    public void setProperty(DocumentProperty value) {
        this.property = value;
    }

}
