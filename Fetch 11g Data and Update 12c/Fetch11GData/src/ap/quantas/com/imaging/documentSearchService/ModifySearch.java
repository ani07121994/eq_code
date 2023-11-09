
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for modifySearch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="modifySearch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://imaging.oracle/}search" minOccurs="0"/>
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
@XmlType(name = "modifySearch", propOrder = {
    "search",
    "sectionSet"
})
public class ModifySearch {

    @XmlElement(namespace = "http://imaging.oracle/")
    protected Search search;
    @XmlElement(namespace = "http://imaging.oracle/")
    protected SectionSet sectionSet;

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
