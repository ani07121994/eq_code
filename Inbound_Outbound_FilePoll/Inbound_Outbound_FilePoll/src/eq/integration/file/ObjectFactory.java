
package eq.integration.file;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eq.integration.file package. 
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

    private final static QName _ReleaseLockResponse_QNAME = new QName("http://file.integration.eq/", "releaseLockResponse");
    private final static QName _GetLock_QNAME = new QName("http://file.integration.eq/", "getLock");
    private final static QName _GetLockResponse_QNAME = new QName("http://file.integration.eq/", "getLockResponse");
    private final static QName _ReleaseLock_QNAME = new QName("http://file.integration.eq/", "releaseLock");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eq.integration.file
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReleaseLockResponse }
     * 
     */
    public ReleaseLockResponse createReleaseLockResponse() {
        return new ReleaseLockResponse();
    }

    /**
     * Create an instance of {@link GetLockResponse }
     * 
     */
    public GetLockResponse createGetLockResponse() {
        return new GetLockResponse();
    }

    /**
     * Create an instance of {@link GetLock }
     * 
     */
    public GetLock createGetLock() {
        return new GetLock();
    }

    /**
     * Create an instance of {@link ReleaseLock }
     * 
     */
    public ReleaseLock createReleaseLock() {
        return new ReleaseLock();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReleaseLockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.integration.eq/", name = "releaseLockResponse")
    public JAXBElement<ReleaseLockResponse> createReleaseLockResponse(ReleaseLockResponse value) {
        return new JAXBElement<ReleaseLockResponse>(_ReleaseLockResponse_QNAME, ReleaseLockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.integration.eq/", name = "getLock")
    public JAXBElement<GetLock> createGetLock(GetLock value) {
        return new JAXBElement<GetLock>(_GetLock_QNAME, GetLock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.integration.eq/", name = "getLockResponse")
    public JAXBElement<GetLockResponse> createGetLockResponse(GetLockResponse value) {
        return new JAXBElement<GetLockResponse>(_GetLockResponse_QNAME, GetLockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReleaseLock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://file.integration.eq/", name = "releaseLock")
    public JAXBElement<ReleaseLock> createReleaseLock(ReleaseLock value) {
        return new JAXBElement<ReleaseLock>(_ReleaseLock_QNAME, ReleaseLock.class, null, value);
    }

}
