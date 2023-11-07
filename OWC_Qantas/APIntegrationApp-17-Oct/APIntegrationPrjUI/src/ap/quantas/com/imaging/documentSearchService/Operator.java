
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="operator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AND"/>
 *     &lt;enumeration value="OR"/>
 *     &lt;enumeration value="NOT"/>
 *     &lt;enumeration value="BEGINS_WITH"/>
 *     &lt;enumeration value="ENDS_WITH"/>
 *     &lt;enumeration value="CONTAINS"/>
 *     &lt;enumeration value="EQUAL"/>
 *     &lt;enumeration value="GREATER_THAN"/>
 *     &lt;enumeration value="GREATER_THAN_OR_EQUAL"/>
 *     &lt;enumeration value="LESS_THAN"/>
 *     &lt;enumeration value="LESS_THAN_OR_EQUAL"/>
 *     &lt;enumeration value="NOT_EQUAL"/>
 *     &lt;enumeration value="EQUAL_TEXT"/>
 *     &lt;enumeration value="NOT_EQUAL_TEXT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "operator")
@XmlEnum
public enum Operator {

    AND,
    OR,
    NOT,
    BEGINS_WITH,
    ENDS_WITH,
    CONTAINS,
    EQUAL,
    GREATER_THAN,
    GREATER_THAN_OR_EQUAL,
    LESS_THAN,
    LESS_THAN_OR_EQUAL,
    NOT_EQUAL,
    EQUAL_TEXT,
    NOT_EQUAL_TEXT;

    public String value() {
        return name();
    }

    public static Operator fromValue(String v) {
        return valueOf(v);
    }

}
