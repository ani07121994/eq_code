
package ap.quantas.com.imaging.documentSearchService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchFormatColumn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchFormatColumn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="columnTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="results" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="selectedFields" type="{http://imaging.oracle/}SearchFormatSelectedField" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchFormatColumn", propOrder = {
    "columnTitle",
    "results"
})
public class SearchFormatColumn {

    protected String columnTitle;
    protected SearchFormatColumn.Results results;

    /**
     * Gets the value of the columnTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnTitle() {
        return columnTitle;
    }

    /**
     * Sets the value of the columnTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnTitle(String value) {
        this.columnTitle = value;
    }

    /**
     * Gets the value of the results property.
     * 
     * @return
     *     possible object is
     *     {@link SearchFormatColumn.Results }
     *     
     */
    public SearchFormatColumn.Results getResults() {
        return results;
    }

    /**
     * Sets the value of the results property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchFormatColumn.Results }
     *     
     */
    public void setResults(SearchFormatColumn.Results value) {
        this.results = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="selectedFields" type="{http://imaging.oracle/}SearchFormatSelectedField" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "selectedFields"
    })
    public static class Results {

        @XmlElement(required = true)
        protected List<SearchFormatSelectedField> selectedFields;

        /**
         * Gets the value of the selectedFields property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the selectedFields property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSelectedFields().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SearchFormatSelectedField }
         * 
         * 
         */
        public List<SearchFormatSelectedField> getSelectedFields() {
            if (selectedFields == null) {
                selectedFields = new ArrayList<SearchFormatSelectedField>();
            }
            return this.selectedFields;
        }

    }

}
