
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchNode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="leftOperand" type="{http://imaging.oracle/}SearchNode" minOccurs="0"/>
 *         &lt;element name="rightOperand" type="{http://imaging.oracle/}SearchNode" minOccurs="0"/>
 *         &lt;element name="searchOperator" type="{http://imaging.oracle/}operator" minOccurs="0"/>
 *         &lt;element name="alwaysDisplayParentheses" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchNode", propOrder = {
    "leftOperand",
    "rightOperand",
    "searchOperator",
    "alwaysDisplayParentheses"
})
@XmlSeeAlso({
    SearchConjunction.class,
    SearchCondition.class
})
public abstract class SearchNode {

    protected SearchNode leftOperand;
    protected SearchNode rightOperand;
    protected Operator searchOperator;
    protected boolean alwaysDisplayParentheses;

    /**
     * Gets the value of the leftOperand property.
     * 
     * @return
     *     possible object is
     *     {@link SearchNode }
     *     
     */
    public SearchNode getLeftOperand() {
        return leftOperand;
    }

    /**
     * Sets the value of the leftOperand property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchNode }
     *     
     */
    public void setLeftOperand(SearchNode value) {
        this.leftOperand = value;
    }

    /**
     * Gets the value of the rightOperand property.
     * 
     * @return
     *     possible object is
     *     {@link SearchNode }
     *     
     */
    public SearchNode getRightOperand() {
        return rightOperand;
    }

    /**
     * Sets the value of the rightOperand property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchNode }
     *     
     */
    public void setRightOperand(SearchNode value) {
        this.rightOperand = value;
    }

    /**
     * Gets the value of the searchOperator property.
     * 
     * @return
     *     possible object is
     *     {@link Operator }
     *     
     */
    public Operator getSearchOperator() {
        return searchOperator;
    }

    /**
     * Sets the value of the searchOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Operator }
     *     
     */
    public void setSearchOperator(Operator value) {
        this.searchOperator = value;
    }

    /**
     * Gets the value of the alwaysDisplayParentheses property.
     * 
     */
    public boolean isAlwaysDisplayParentheses() {
        return alwaysDisplayParentheses;
    }

    /**
     * Sets the value of the alwaysDisplayParentheses property.
     * 
     */
    public void setAlwaysDisplayParentheses(boolean value) {
        this.alwaysDisplayParentheses = value;
    }

}
