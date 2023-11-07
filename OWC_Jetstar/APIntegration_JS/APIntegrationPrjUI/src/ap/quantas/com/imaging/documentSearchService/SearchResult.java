
package ap.quantas.com.imaging.documentSearchService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="columnValues" type="{http://imaging.oracle/}TypedValue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="serialVersionUID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element ref="{http://imaging.oracle/}document" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchResult", propOrder = {
    "columnValues",
    "serialVersionUID",
    "document"
})
public class SearchResult {

    protected List<TypedValue> columnValues;
    protected long serialVersionUID;
    @XmlElement(namespace = "http://imaging.oracle/")
    protected Document document;

    /**
     * Gets the value of the columnValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the columnValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumnValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypedValue }
     * 
     * 
     */
    public List<TypedValue> getColumnValues() {
        if (columnValues == null) {
            columnValues = new ArrayList<TypedValue>();
        }
        return this.columnValues;
    }

    /**
     * Gets the value of the serialVersionUID property.
     * 
     */
    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Sets the value of the serialVersionUID property.
     * 
     */
    public void setSerialVersionUID(long value) {
        this.serialVersionUID = value;
    }

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link Document }
     *     
     */
    public Document getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link Document }
     *     
     */
    public void setDocument(Document value) {
        this.document = value;
    }

}
