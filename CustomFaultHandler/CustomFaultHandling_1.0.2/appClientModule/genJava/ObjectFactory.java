
package genJava;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the genJava package. 
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

    private final static QName _MoveFile_QNAME = new QName("http://ifs.integration.eq.qantas/", "MoveFile");
    private final static QName _Exception_QNAME = new QName("http://ifs.integration.eq.qantas/", "Exception");
    private final static QName _MoveFileResponse_QNAME = new QName("http://ifs.integration.eq.qantas/", "MoveFileResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: genJava
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link MoveFile }
     * 
     */
    public MoveFile createMoveFile() {
        return new MoveFile();
    }

    /**
     * Create an instance of {@link MoveFileResponse }
     * 
     */
    public MoveFileResponse createMoveFileResponse() {
        return new MoveFileResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MoveFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ifs.integration.eq.qantas/", name = "MoveFile")
    public JAXBElement<MoveFile> createMoveFile(MoveFile value) {
        return new JAXBElement<MoveFile>(_MoveFile_QNAME, MoveFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ifs.integration.eq.qantas/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MoveFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ifs.integration.eq.qantas/", name = "MoveFileResponse")
    public JAXBElement<MoveFileResponse> createMoveFileResponse(MoveFileResponse value) {
        return new JAXBElement<MoveFileResponse>(_MoveFileResponse_QNAME, MoveFileResponse.class, null, value);
    }

}
