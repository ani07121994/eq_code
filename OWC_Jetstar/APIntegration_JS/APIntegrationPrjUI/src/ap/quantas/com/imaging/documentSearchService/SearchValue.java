
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="typedValue" type="{http://imaging.oracle/}TypedValue" minOccurs="0"/>
 *         &lt;element name="searchValueType" type="{http://imaging.oracle/}SearchValueType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchValue", propOrder = {
    "typedValue",
    "searchValueType"
})
public class SearchValue {

    protected TypedValue typedValue;
    protected SearchValueType searchValueType;

    /**
     * Gets the value of the typedValue property.
     * 
     * @return
     *     possible object is
     *     {@link TypedValue }
     *     
     */
    public TypedValue getTypedValue() {
        return typedValue;
    }

    /**
     * Sets the value of the typedValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypedValue }
     *     
     */
    public void setTypedValue(TypedValue value) {
        this.typedValue = value;
    }

    /**
     * Gets the value of the searchValueType property.
     * 
     * @return
     *     possible object is
     *     {@link SearchValueType }
     *     
     */
    public SearchValueType getSearchValueType() {
        return searchValueType;
    }

    /**
     * Sets the value of the searchValueType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchValueType }
     *     
     */
    public void setSearchValueType(SearchValueType value) {
        this.searchValueType = value;
    }

}
