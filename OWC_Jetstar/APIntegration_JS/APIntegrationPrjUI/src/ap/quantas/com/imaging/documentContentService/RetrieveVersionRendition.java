
package ap.quantas.com.imaging.documentContentService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for retrieveVersionRendition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="retrieveVersionRendition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="versionId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="withAnnotations" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="preserveColor" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="outputType" type="{http://imaging.oracle/}renditionOutput" minOccurs="0"/>
 *         &lt;element name="pages" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retrieveVersionRendition", propOrder = {
    "documentId",
    "versionId",
    "withAnnotations",
    "preserveColor",
    "outputType",
    "pages"
})
public class RetrieveVersionRendition {

    protected String documentId;
    protected long versionId;
    protected boolean withAnnotations;
    protected boolean preserveColor;
    protected RenditionOutput outputType;
    @XmlElement(type = Integer.class)
    protected List<Integer> pages;

    /**
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentId(String value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the versionId property.
     * 
     */
    public long getVersionId() {
        return versionId;
    }

    /**
     * Sets the value of the versionId property.
     * 
     */
    public void setVersionId(long value) {
        this.versionId = value;
    }

    /**
     * Gets the value of the withAnnotations property.
     * 
     */
    public boolean isWithAnnotations() {
        return withAnnotations;
    }

    /**
     * Sets the value of the withAnnotations property.
     * 
     */
    public void setWithAnnotations(boolean value) {
        this.withAnnotations = value;
    }

    /**
     * Gets the value of the preserveColor property.
     * 
     */
    public boolean isPreserveColor() {
        return preserveColor;
    }

    /**
     * Sets the value of the preserveColor property.
     * 
     */
    public void setPreserveColor(boolean value) {
        this.preserveColor = value;
    }

    /**
     * Gets the value of the outputType property.
     * 
     * @return
     *     possible object is
     *     {@link RenditionOutput }
     *     
     */
    public RenditionOutput getOutputType() {
        return outputType;
    }

    /**
     * Sets the value of the outputType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RenditionOutput }
     *     
     */
    public void setOutputType(RenditionOutput value) {
        this.outputType = value;
    }

    /**
     * Gets the value of the pages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getPages() {
        if (pages == null) {
            pages = new ArrayList<Integer>();
        }
        return this.pages;
    }

}
