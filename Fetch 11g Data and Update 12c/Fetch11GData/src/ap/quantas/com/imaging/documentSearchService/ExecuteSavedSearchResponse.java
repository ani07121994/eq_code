
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for executeSavedSearchResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="executeSavedSearchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchResults" type="{http://imaging.oracle/}SearchResultSet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeSavedSearchResponse", propOrder = {
    "searchResults"
})
public class ExecuteSavedSearchResponse {

    protected SearchResultSet searchResults;

    /**
     * Gets the value of the searchResults property.
     * 
     * @return
     *     possible object is
     *     {@link SearchResultSet }
     *     
     */
    public SearchResultSet getSearchResults() {
        return searchResults;
    }

    /**
     * Sets the value of the searchResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchResultSet }
     *     
     */
    public void setSearchResults(SearchResultSet value) {
        this.searchResults = value;
    }

}
