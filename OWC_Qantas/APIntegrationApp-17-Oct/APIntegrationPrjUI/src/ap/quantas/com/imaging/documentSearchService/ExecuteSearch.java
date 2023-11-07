
package ap.quantas.com.imaging.documentSearchService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for executeSearch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="executeSearch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://imaging.oracle/}search" minOccurs="0"/>
 *         &lt;element name="searchArguments" type="{http://imaging.oracle/}SearchParameter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeSearch", propOrder = {
    "search",
    "searchArguments"
})
public class ExecuteSearch {

    @XmlElement(namespace = "http://imaging.oracle/")
    protected Search search;
    protected List<SearchParameter> searchArguments;

    /**
     * Gets the value of the search property.
     * 
     * @return
     *     possible object is
     *     {@link Search }
     *     
     */
    public Search getSearch() {
        return search;
    }

    /**
     * Sets the value of the search property.
     * 
     * @param value
     *     allowed object is
     *     {@link Search }
     *     
     */
    public void setSearch(Search value) {
        this.search = value;
    }

    /**
     * Gets the value of the searchArguments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchArguments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchArguments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchParameter }
     * 
     * 
     */
    public List<SearchParameter> getSearchArguments() {
        if (searchArguments == null) {
            searchArguments = new ArrayList<SearchParameter>();
        }
        return this.searchArguments;
    }

}
