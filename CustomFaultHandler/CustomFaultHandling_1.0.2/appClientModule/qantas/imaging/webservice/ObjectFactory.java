
package qantas.imaging.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the qantas.imaging.webservice package. 
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

    private final static QName _UploadFile_QNAME = new QName("http://webService.imaging.qantas/", "uploadFile");
    private final static QName _UploadFileResponse_QNAME = new QName("http://webService.imaging.qantas/", "uploadFileResponse");
    private final static QName _SearchIPM_QNAME = new QName("http://webService.imaging.qantas/", "searchIPM");
    private final static QName _SearchIPMResponse_QNAME = new QName("http://webService.imaging.qantas/", "searchIPMResponse");
    private final static QName _UpdateService_QNAME = new QName("http://webService.imaging.qantas/", "updateService");
    private final static QName _UpdateServiceResponse_QNAME = new QName("http://webService.imaging.qantas/", "updateServiceResponse");
    private final static QName _Exception_QNAME = new QName("http://webService.imaging.qantas/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: qantas.imaging.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UploadFile }
     * 
     */
    public UploadFile createUploadFile() {
        return new UploadFile();
    }

    /**
     * Create an instance of {@link UploadFileResponse }
     * 
     */
    public UploadFileResponse createUploadFileResponse() {
        return new UploadFileResponse();
    }

    /**
     * Create an instance of {@link SearchIPM }
     * 
     */
    public SearchIPM createSearchIPM() {
        return new SearchIPM();
    }

    /**
     * Create an instance of {@link SearchIPMResponse }
     * 
     */
    public SearchIPMResponse createSearchIPMResponse() {
        return new SearchIPMResponse();
    }

    /**
     * Create an instance of {@link UpdateService }
     * 
     */
    public UpdateService createUpdateService() {
        return new UpdateService();
    }

    /**
     * Create an instance of {@link UpdateServiceResponse }
     * 
     */
    public UpdateServiceResponse createUpdateServiceResponse() {
        return new UpdateServiceResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.imaging.qantas/", name = "uploadFile")
    public JAXBElement<UploadFile> createUploadFile(UploadFile value) {
        return new JAXBElement<UploadFile>(_UploadFile_QNAME, UploadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.imaging.qantas/", name = "uploadFileResponse")
    public JAXBElement<UploadFileResponse> createUploadFileResponse(UploadFileResponse value) {
        return new JAXBElement<UploadFileResponse>(_UploadFileResponse_QNAME, UploadFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchIPM }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.imaging.qantas/", name = "searchIPM")
    public JAXBElement<SearchIPM> createSearchIPM(SearchIPM value) {
        return new JAXBElement<SearchIPM>(_SearchIPM_QNAME, SearchIPM.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchIPMResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.imaging.qantas/", name = "searchIPMResponse")
    public JAXBElement<SearchIPMResponse> createSearchIPMResponse(SearchIPMResponse value) {
        return new JAXBElement<SearchIPMResponse>(_SearchIPMResponse_QNAME, SearchIPMResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.imaging.qantas/", name = "updateService")
    public JAXBElement<UpdateService> createUpdateService(UpdateService value) {
        return new JAXBElement<UpdateService>(_UpdateService_QNAME, UpdateService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.imaging.qantas/", name = "updateServiceResponse")
    public JAXBElement<UpdateServiceResponse> createUpdateServiceResponse(UpdateServiceResponse value) {
        return new JAXBElement<UpdateServiceResponse>(_UpdateServiceResponse_QNAME, UpdateServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.imaging.qantas/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
