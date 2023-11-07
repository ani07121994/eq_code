
package ap.quantas.com.imaging.documentSearchService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Search complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Search">
 *   &lt;complexContent>
 *     &lt;extension base="{http://imaging.oracle/}Definition">
 *       &lt;sequence>
 *         &lt;element name="properties" type="{http://imaging.oracle/}SearchProperties" minOccurs="0"/>
 *         &lt;element name="parameterDefinitions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="parameterDefinition" type="{http://imaging.oracle/}SearchParameterDefinition" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="searchExpressions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="searchExpression" type="{http://imaging.oracle/}ApplicationExpression" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="resultColumns" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="resultColumn" type="{http://imaging.oracle/}SearchFormatColumn" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="permissions" type="{http://imaging.oracle/}DefinitionPermissions" minOccurs="0"/>
 *         &lt;element name="security" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="securityItem" type="{http://imaging.oracle/}DefinitionSecurity" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="history" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="historyItem" type="{http://imaging.oracle/}AuditEvent" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Search", propOrder = {
    "properties",
    "parameterDefinitions",
    "searchExpressions",
    "resultColumns",
    "permissions",
    "security",
    "history"
})
public class Search
    extends Definition
{

    @XmlElementRef(name = "properties", type = JAXBElement.class)
    protected JAXBElement<SearchProperties> properties;
    @XmlElementRef(name = "parameterDefinitions", type = JAXBElement.class)
    protected JAXBElement<Search.ParameterDefinitions> parameterDefinitions;
    @XmlElementRef(name = "searchExpressions", type = JAXBElement.class)
    protected JAXBElement<Search.SearchExpressions> searchExpressions;
    @XmlElementRef(name = "resultColumns", type = JAXBElement.class)
    protected JAXBElement<Search.ResultColumns> resultColumns;
    @XmlElementRef(name = "permissions", type = JAXBElement.class)
    protected JAXBElement<DefinitionPermissions> permissions;
    @XmlElementRef(name = "security", type = JAXBElement.class)
    protected JAXBElement<Search.Security> security;
    protected Search.History history;

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SearchProperties }{@code >}
     *     
     */
    public JAXBElement<SearchProperties> getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SearchProperties }{@code >}
     *     
     */
    public void setProperties(JAXBElement<SearchProperties> value) {
        this.properties = ((JAXBElement<SearchProperties> ) value);
    }

    /**
     * Gets the value of the parameterDefinitions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Search.ParameterDefinitions }{@code >}
     *     
     */
    public JAXBElement<Search.ParameterDefinitions> getParameterDefinitions() {
        return parameterDefinitions;
    }

    /**
     * Sets the value of the parameterDefinitions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Search.ParameterDefinitions }{@code >}
     *     
     */
    public void setParameterDefinitions(JAXBElement<Search.ParameterDefinitions> value) {
        this.parameterDefinitions = ((JAXBElement<Search.ParameterDefinitions> ) value);
    }

    /**
     * Gets the value of the searchExpressions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Search.SearchExpressions }{@code >}
     *     
     */
    public JAXBElement<Search.SearchExpressions> getSearchExpressions() {
        return searchExpressions;
    }

    /**
     * Sets the value of the searchExpressions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Search.SearchExpressions }{@code >}
     *     
     */
    public void setSearchExpressions(JAXBElement<Search.SearchExpressions> value) {
        this.searchExpressions = ((JAXBElement<Search.SearchExpressions> ) value);
    }

    /**
     * Gets the value of the resultColumns property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Search.ResultColumns }{@code >}
     *     
     */
    public JAXBElement<Search.ResultColumns> getResultColumns() {
        return resultColumns;
    }

    /**
     * Sets the value of the resultColumns property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Search.ResultColumns }{@code >}
     *     
     */
    public void setResultColumns(JAXBElement<Search.ResultColumns> value) {
        this.resultColumns = ((JAXBElement<Search.ResultColumns> ) value);
    }

    /**
     * Gets the value of the permissions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DefinitionPermissions }{@code >}
     *     
     */
    public JAXBElement<DefinitionPermissions> getPermissions() {
        return permissions;
    }

    /**
     * Sets the value of the permissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DefinitionPermissions }{@code >}
     *     
     */
    public void setPermissions(JAXBElement<DefinitionPermissions> value) {
        this.permissions = ((JAXBElement<DefinitionPermissions> ) value);
    }

    /**
     * Gets the value of the security property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Search.Security }{@code >}
     *     
     */
    public JAXBElement<Search.Security> getSecurity() {
        return security;
    }

    /**
     * Sets the value of the security property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Search.Security }{@code >}
     *     
     */
    public void setSecurity(JAXBElement<Search.Security> value) {
        this.security = ((JAXBElement<Search.Security> ) value);
    }

    /**
     * Gets the value of the history property.
     * 
     * @return
     *     possible object is
     *     {@link Search.History }
     *     
     */
    public Search.History getHistory() {
        return history;
    }

    /**
     * Sets the value of the history property.
     * 
     * @param value
     *     allowed object is
     *     {@link Search.History }
     *     
     */
    public void setHistory(Search.History value) {
        this.history = value;
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
     *         &lt;element name="historyItem" type="{http://imaging.oracle/}AuditEvent" maxOccurs="unbounded" minOccurs="0"/>
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
        "historyItem"
    })
    public static class History {

        protected List<AuditEvent> historyItem;

        /**
         * Gets the value of the historyItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the historyItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHistoryItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AuditEvent }
         * 
         * 
         */
        public List<AuditEvent> getHistoryItem() {
            if (historyItem == null) {
                historyItem = new ArrayList<AuditEvent>();
            }
            return this.historyItem;
        }

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
     *         &lt;element name="parameterDefinition" type="{http://imaging.oracle/}SearchParameterDefinition" maxOccurs="unbounded" minOccurs="0"/>
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
        "parameterDefinition"
    })
    public static class ParameterDefinitions {

        @XmlElement(nillable = true)
        protected List<SearchParameterDefinition> parameterDefinition;

        /**
         * Gets the value of the parameterDefinition property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the parameterDefinition property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getParameterDefinition().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SearchParameterDefinition }
         * 
         * 
         */
        public List<SearchParameterDefinition> getParameterDefinition() {
            if (parameterDefinition == null) {
                parameterDefinition = new ArrayList<SearchParameterDefinition>();
            }
            return this.parameterDefinition;
        }

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
     *         &lt;element name="resultColumn" type="{http://imaging.oracle/}SearchFormatColumn" maxOccurs="unbounded"/>
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
        "resultColumn"
    })
    public static class ResultColumns {

        @XmlElement(required = true)
        protected List<SearchFormatColumn> resultColumn;

        /**
         * Gets the value of the resultColumn property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the resultColumn property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResultColumn().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SearchFormatColumn }
         * 
         * 
         */
        public List<SearchFormatColumn> getResultColumn() {
            if (resultColumn == null) {
                resultColumn = new ArrayList<SearchFormatColumn>();
            }
            return this.resultColumn;
        }

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
     *         &lt;element name="searchExpression" type="{http://imaging.oracle/}ApplicationExpression" maxOccurs="unbounded"/>
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
        "searchExpression"
    })
    public static class SearchExpressions {

        @XmlElement(required = true)
        protected List<ApplicationExpression> searchExpression;

        /**
         * Gets the value of the searchExpression property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the searchExpression property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSearchExpression().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ApplicationExpression }
         * 
         * 
         */
        public List<ApplicationExpression> getSearchExpression() {
            if (searchExpression == null) {
                searchExpression = new ArrayList<ApplicationExpression>();
            }
            return this.searchExpression;
        }

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
     *         &lt;element name="securityItem" type="{http://imaging.oracle/}DefinitionSecurity" maxOccurs="unbounded" minOccurs="0"/>
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
        "securityItem"
    })
    public static class Security {

        @XmlElement(nillable = true)
        protected List<DefinitionSecurity> securityItem;

        /**
         * Gets the value of the securityItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the securityItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSecurityItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DefinitionSecurity }
         * 
         * 
         */
        public List<DefinitionSecurity> getSecurityItem() {
            if (securityItem == null) {
                securityItem = new ArrayList<DefinitionSecurity>();
            }
            return this.securityItem;
        }

    }

}
