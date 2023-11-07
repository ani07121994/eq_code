
package ap.quantas.com.imaging.documentSearchService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for executeSavedSearch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="executeSavedSearch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchNameId" type="{http://imaging.oracle/}NameId" minOccurs="0"/>
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
@XmlType(name = "executeSavedSearch", propOrder = {
    "searchNameId",
    "searchArguments"
})
public class ExecuteSavedSearch {

    protected NameId searchNameId;
    protected List<SearchParameter> searchArguments;

    /**
     * Gets the value of the searchNameId property.
     * 
     * @return
     *     possible object is
     *     {@link NameId }
     *     
     */
    public NameId getSearchNameId() {
        return searchNameId;
    }

    /**
     * Sets the value of the searchNameId property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameId }
     *     
     */
    public void setSearchNameId(NameId value) {
        this.searchNameId = value;
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
