
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for property.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="property">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREATE_DATE"/>
 *     &lt;enumeration value="CREATED_BY_NAME"/>
 *     &lt;enumeration value="BATCHID"/>
 *     &lt;enumeration value="DOCUMENT_CONTENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "property")
@XmlEnum
public enum Property {

    CREATE_DATE,
    CREATED_BY_NAME,
    BATCHID,
    DOCUMENT_CONTENT;

    public String value() {
        return name();
    }

    public static Property fromValue(String v) {
        return valueOf(v);
    }

}
