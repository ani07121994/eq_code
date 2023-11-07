
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSearch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSearch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchNameId" type="{http://imaging.oracle/}NameId" minOccurs="0"/>
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
@XmlType(name = "getSearch", propOrder = {
    "searchNameId",
    "sectionSet"
})
public class GetSearch {

    protected NameId searchNameId;
    @XmlElement(namespace = "http://imaging.oracle/")
    protected SectionSet sectionSet;

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
