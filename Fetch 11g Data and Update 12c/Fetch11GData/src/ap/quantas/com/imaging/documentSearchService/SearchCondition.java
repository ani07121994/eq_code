
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchCondition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchCondition">
 *   &lt;complexContent>
 *     &lt;extension base="{http://imaging.oracle/}SearchNode">
 *       &lt;sequence>
 *         &lt;element name="fieldDefinition" type="{http://imaging.oracle/}NameId" minOccurs="0"/>
 *         &lt;element name="parameterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="property" type="{http://imaging.oracle/}property" minOccurs="0"/>
 *         &lt;element name="searchValue" type="{http://imaging.oracle/}SearchValue" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchCondition", propOrder = {
    "fieldDefinition",
    "parameterName",
    "property",
    "searchValue"
})
public class SearchCondition
    extends SearchNode
{

    protected NameId fieldDefinition;
    protected String parameterName;
    protected Property property;
    protected SearchValue searchValue;

    /**
     * Gets the value of the fieldDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link NameId }
     *     
     */
    public NameId getFieldDefinition() {
        return fieldDefinition;
    }

    /**
     * Sets the value of the fieldDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameId }
     *     
     */
    public void setFieldDefinition(NameId value) {
        this.fieldDefinition = value;
    }

    /**
     * Gets the value of the parameterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameterName() {
        return parameterName;
    }

    /**
     * Sets the value of the parameterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameterName(String value) {
        this.parameterName = value;
    }

    /**
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link Property }
     *     
     */
    public Property getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link Property }
     *     
     */
    public void setProperty(Property value) {
        this.property = value;
    }

    /**
     * Gets the value of the searchValue property.
     * 
     * @return
     *     possible object is
     *     {@link SearchValue }
     *     
     */
    public SearchValue getSearchValue() {
        return searchValue;
    }

    /**
     * Sets the value of the searchValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchValue }
     *     
     */
    public void setSearchValue(SearchValue value) {
        this.searchValue = value;
    }

}
