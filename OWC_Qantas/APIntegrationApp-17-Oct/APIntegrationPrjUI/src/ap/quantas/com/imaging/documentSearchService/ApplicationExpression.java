
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApplicationExpression complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApplicationExpression">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="applicationId" type="{http://imaging.oracle/}NameId" minOccurs="0"/>
 *         &lt;element name="searchTree" type="{http://imaging.oracle/}SearchNode" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationExpression", propOrder = {

})
public class ApplicationExpression {

    protected NameId applicationId;
    protected SearchNode searchTree;

    /**
     * Gets the value of the applicationId property.
     * 
     * @return
     *     possible object is
     *     {@link NameId }
     *     
     */
    public NameId getApplicationId() {
        return applicationId;
    }

    /**
     * Sets the value of the applicationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameId }
     *     
     */
    public void setApplicationId(NameId value) {
        this.applicationId = value;
    }

    /**
     * Gets the value of the searchTree property.
     * 
     * @return
     *     possible object is
     *     {@link SearchNode }
     *     
     */
    public SearchNode getSearchTree() {
        return searchTree;
    }

    /**
     * Sets the value of the searchTree property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchNode }
     *     
     */
    public void setSearchTree(SearchNode value) {
        this.searchTree = value;
    }

}
