
package src.com;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the src.com package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CommonNotificationDetails_QNAME = new QName("http://com.src/", "commonNotificationDetails");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: src.com
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CommonNotificationDetails }
     * 
     */
    public CommonNotificationDetails createCommonNotificationDetails() {
        return new CommonNotificationDetails();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommonNotificationDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.src/", name = "commonNotificationDetails")
    public JAXBElement<CommonNotificationDetails> createCommonNotificationDetails(CommonNotificationDetails value) {
        return new JAXBElement<CommonNotificationDetails>(_CommonNotificationDetails_QNAME, CommonNotificationDetails.class, null, value);
    }

}
