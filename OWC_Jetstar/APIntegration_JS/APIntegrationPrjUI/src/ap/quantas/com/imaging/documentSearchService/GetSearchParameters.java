
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSearchParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSearchParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchNameId" type="{http://imaging.oracle/}NameId" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSearchParameters", propOrder = {
    "searchNameId"
})
public class GetSearchParameters {

    protected NameId searchNameId;

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

}
