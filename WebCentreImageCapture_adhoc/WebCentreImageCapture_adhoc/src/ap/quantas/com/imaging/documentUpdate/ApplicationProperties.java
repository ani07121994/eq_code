
package ap.quantas.com.imaging.documentUpdate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApplicationProperties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApplicationProperties">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="repository" type="{http://imaging.oracle/}NameId" minOccurs="0"/>
 *         &lt;element name="nextFieldId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="fastCheckIn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fullTextSearch" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationProperties", propOrder = {
    "repository",
    "nextFieldId",
    "fastCheckIn",
    "fullTextSearch"
})
public class ApplicationProperties {

    protected NameId repository;
    protected long nextFieldId;
    protected boolean fastCheckIn;
    protected boolean fullTextSearch;

    /**
     * Gets the value of the repository property.
     * 
     * @return
     *     possible object is
     *     {@link NameId }
     *     
     */
    public NameId getRepository() {
        return repository;
    }

    /**
     * Sets the value of the repository property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameId }
     *     
     */
    public void setRepository(NameId value) {
        this.repository = value;
    }

    /**
     * Gets the value of the nextFieldId property.
     * 
     */
    public long getNextFieldId() {
        return nextFieldId;
    }

    /**
     * Sets the value of the nextFieldId property.
     * 
     */
    public void setNextFieldId(long value) {
        this.nextFieldId = value;
    }

    /**
     * Gets the value of the fastCheckIn property.
     * 
     */
    public boolean isFastCheckIn() {
        return fastCheckIn;
    }

    /**
     * Sets the value of the fastCheckIn property.
     * 
     */
    public void setFastCheckIn(boolean value) {
        this.fastCheckIn = value;
    }

    /**
     * Gets the value of the fullTextSearch property.
     * 
     */
    public boolean isFullTextSearch() {
        return fullTextSearch;
    }

    /**
     * Sets the value of the fullTextSearch property.
     * 
     */
    public void setFullTextSearch(boolean value) {
        this.fullTextSearch = value;
    }

}
