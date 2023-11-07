
package oracle.imaging;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for retrieveVersionPageResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="retrieveVersionPageResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="renderResult" type="{http://imaging.oracle/}renderResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retrieveVersionPageResponse", propOrder = {
    "renderResult"
})
public class RetrieveVersionPageResponse {

    protected RenderResult renderResult;

    /**
     * Gets the value of the renderResult property.
     * 
     * @return
     *     possible object is
     *     {@link RenderResult }
     *     
     */
    public RenderResult getRenderResult() {
        return renderResult;
    }

    /**
     * Sets the value of the renderResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RenderResult }
     *     
     */
    public void setRenderResult(RenderResult value) {
        this.renderResult = value;
    }

}
