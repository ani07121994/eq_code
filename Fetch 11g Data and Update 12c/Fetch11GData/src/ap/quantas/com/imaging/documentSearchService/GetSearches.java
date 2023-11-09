
package ap.quantas.com.imaging.documentSearchService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSearches complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSearches">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchNameIds" type="{http://imaging.oracle/}NameId" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://imaging.oracle/}sectionSet" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSearches", propOrder = {
    "searchNameIds",
    "sectionSet"
})
public class GetSearches {

    protected List<NameId> searchNameIds;
    @XmlElement(namespace = "http://imaging.oracle/")
    protected SectionSet sectionSet;

    /**
     * Gets the value of the searchNameIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchNameIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchNameIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameId }
     * 
     * 
     */
    public List<NameId> getSearchNameIds() {
        if (searchNameIds == null) {
            searchNameIds = new ArrayList<NameId>();
        }
        return this.searchNameIds;
    }

    /**
     * Gets the value of the sectionSet property.
     * 
     * @return
     *     possible object is
     *     {@link SectionSet }
     *     
     */
    public SectionSet getSectionSet() {
        return sectionSet;
    }

    /**
     * Sets the value of the sectionSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link SectionSet }
     *     
     */
    public void setSectionSet(SectionSet value) {
        this.sectionSet = value;
    }

}
