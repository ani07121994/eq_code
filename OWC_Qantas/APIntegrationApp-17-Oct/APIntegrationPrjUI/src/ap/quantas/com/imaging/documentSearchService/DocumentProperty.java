
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for documentProperty.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="documentProperty">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREATE_DATE"/>
 *     &lt;enumeration value="SIZE"/>
 *     &lt;enumeration value="CREATED_BY_NAME"/>
 *     &lt;enumeration value="BATCHID"/>
 *     &lt;enumeration value="DOCUMENT_ID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "documentProperty")
@XmlEnum
public enum DocumentProperty {

    CREATE_DATE,
    SIZE,
    CREATED_BY_NAME,
    BATCHID,
    DOCUMENT_ID;

    public String value() {
        return name();
    }

    public static DocumentProperty fromValue(String v) {
        return valueOf(v);
    }

}
