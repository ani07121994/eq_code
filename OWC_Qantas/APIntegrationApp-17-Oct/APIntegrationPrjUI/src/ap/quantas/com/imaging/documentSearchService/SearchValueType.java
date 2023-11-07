
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchValueType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchValueType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TEXT"/>
 *     &lt;enumeration value="NUMBER"/>
 *     &lt;enumeration value="DECIMAL"/>
 *     &lt;enumeration value="DATE"/>
 *     &lt;enumeration value="RELATIVEDATE"/>
 *     &lt;enumeration value="RELATIVEDATETIME"/>
 *     &lt;enumeration value="CURRENTUSER"/>
 *     &lt;enumeration value="DATETIME"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchValueType")
@XmlEnum
public enum SearchValueType {

    TEXT,
    NUMBER,
    DECIMAL,
    DATE,
    RELATIVEDATE,
    RELATIVEDATETIME,
    CURRENTUSER,
    DATETIME;

    public String value() {
        return name();
    }

    public static SearchValueType fromValue(String v) {
        return valueOf(v);
    }

}
