
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchProperties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchProperties">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxRows" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchProperties", propOrder = {
    "searchInstructions",
    "maxRows"
})
public class SearchProperties {

    protected String searchInstructions;
    protected int maxRows;

    /**
     * Gets the value of the searchInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchInstructions() {
        return searchInstructions;
    }

    /**
     * Sets the value of the searchInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchInstructions(String value) {
        this.searchInstructions = value;
    }

    /**
     * Gets the value of the maxRows property.
     * 
     */
    public int getMaxRows() {
        return maxRows;
    }

    /**
     * Sets the value of the maxRows property.
     * 
     */
    public void setMaxRows(int value) {
        this.maxRows = value;
    }

}
