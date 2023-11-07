
package ap.quantas.com.imaging.documentSearchService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchParameter2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchParameter2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parameterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prompt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatorText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defaultOperator" type="{http://imaging.oracle/}operator" minOccurs="0"/>
 *         &lt;element name="possibleOperators" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="possibleOperator" type="{http://imaging.oracle/}operator" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="defaultValue" type="{http://imaging.oracle/}SearchValue" minOccurs="0"/>
 *         &lt;element name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="required" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="picklist" type="{http://imaging.oracle/}TypedValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchParameter2", propOrder = {
    "parameterName",
    "prompt",
    "operatorText",
    "defaultOperator",
    "possibleOperators",
    "defaultValue",
    "readOnly",
    "required",
    "picklist"
})
public class SearchParameter2 {

    protected String parameterName;
    protected String prompt;
    protected String operatorText;
    protected Operator defaultOperator;
    protected SearchParameter2 .PossibleOperators possibleOperators;
    protected SearchValue defaultValue;
    protected boolean readOnly;
    protected boolean required;
    protected List<TypedValue> picklist;

    /**
     * Gets the value of the parameterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameterName() {
        return parameterName;
    }

    /**
     * Sets the value of the parameterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameterName(String value) {
        this.parameterName = value;
    }

    /**
     * Gets the value of the prompt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Sets the value of the prompt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrompt(String value) {
        this.prompt = value;
    }

    /**
     * Gets the value of the operatorText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorText() {
        return operatorText;
    }

    /**
     * Sets the value of the operatorText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorText(String value) {
        this.operatorText = value;
    }

    /**
     * Gets the value of the defaultOperator property.
     * 
     * @return
     *     possible object is
     *     {@link Operator }
     *     
     */
    public Operator getDefaultOperator() {
        return defaultOperator;
    }

    /**
     * Sets the value of the defaultOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Operator }
     *     
     */
    public void setDefaultOperator(Operator value) {
        this.defaultOperator = value;
    }

    /**
     * Gets the value of the possibleOperators property.
     * 
     * @return
     *     possible object is
     *     {@link SearchParameter2 .PossibleOperators }
     *     
     */
    public SearchParameter2 .PossibleOperators getPossibleOperators() {
        return possibleOperators;
    }

    /**
     * Sets the value of the possibleOperators property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchParameter2 .PossibleOperators }
     *     
     */
    public void setPossibleOperators(SearchParameter2 .PossibleOperators value) {
        this.possibleOperators = value;
    }

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link SearchValue }
     *     
     */
    public SearchValue getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchValue }
     *     
     */
    public void setDefaultValue(SearchValue value) {
        this.defaultValue = value;
    }

    /**
     * Gets the value of the readOnly property.
     * 
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Sets the value of the readOnly property.
     * 
     */
    public void setReadOnly(boolean value) {
        this.readOnly = value;
    }

    /**
     * Gets the value of the required property.
     * 
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * Sets the value of the required property.
     * 
     */
    public void setRequired(boolean value) {
        this.required = value;
    }

    /**
     * Gets the value of the picklist property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the picklist property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPicklist().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypedValue }
     * 
     * 
     */
    public List<TypedValue> getPicklist() {
        if (picklist == null) {
            picklist = new ArrayList<TypedValue>();
        }
        return this.picklist;
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
     *         &lt;element name="possibleOperator" type="{http://imaging.oracle/}operator" maxOccurs="unbounded" minOccurs="0"/>
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
        "possibleOperator"
    })
    public static class PossibleOperators {

        protected List<Operator> possibleOperator;

        /**
         * Gets the value of the possibleOperator property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the possibleOperator property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPossibleOperator().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Operator }
         * 
         * 
         */
        public List<Operator> getPossibleOperator() {
            if (possibleOperator == null) {
                possibleOperator = new ArrayList<Operator>();
            }
            return this.possibleOperator;
        }

    }

}
