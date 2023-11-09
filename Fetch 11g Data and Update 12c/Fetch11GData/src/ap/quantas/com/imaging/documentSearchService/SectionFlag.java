
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sectionFlag.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="sectionFlag">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NAME"/>
 *     &lt;enumeration value="DESCRIPTION"/>
 *     &lt;enumeration value="PROPERTIES"/>
 *     &lt;enumeration value="PARAMETERS"/>
 *     &lt;enumeration value="RESULT_COLUMNS"/>
 *     &lt;enumeration value="EXPRESSIONS"/>
 *     &lt;enumeration value="PERMISSIONS"/>
 *     &lt;enumeration value="SECURITY"/>
 *     &lt;enumeration value="HISTORY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "sectionFlag")
@XmlEnum
public enum SectionFlag {

    NAME,
    DESCRIPTION,
    PROPERTIES,
    PARAMETERS,
    RESULT_COLUMNS,
    EXPRESSIONS,
    PERMISSIONS,
    SECURITY,
    HISTORY;

    public String value() {
        return name();
    }

    public static SectionFlag fromValue(String v) {
        return valueOf(v);
    }

}
