
package ap.quantas.com.bamUpdateWebService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ap.quantas.com.bamUpdateWebService package. 
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

    private final static QName _Update_QNAME = new QName("http://xmlns.oracle.com/bam", "Update");
    private final static QName _Destroy_QNAME = new QName("http://xmlns.oracle.com/bam", "destroy");
    private final static QName _Batch_QNAME = new QName("http://xmlns.oracle.com/bam", "Batch");
    private final static QName _Insert_QNAME = new QName("http://xmlns.oracle.com/bam", "Insert");
    private final static QName _Upsert_QNAME = new QName("http://xmlns.oracle.com/bam", "Upsert");
    private final static QName _UpdateResponse_QNAME = new QName("http://xmlns.oracle.com/bam", "UpdateResponse");
    private final static QName _DestroyResponse_QNAME = new QName("http://xmlns.oracle.com/bam", "destroyResponse");
    private final static QName _DeleteResponse_QNAME = new QName("http://xmlns.oracle.com/bam", "DeleteResponse");
    private final static QName _BatchResponse_QNAME = new QName("http://xmlns.oracle.com/bam", "BatchResponse");
    private final static QName _InsertResponse_QNAME = new QName("http://xmlns.oracle.com/bam", "InsertResponse");
    private final static QName _Delete_QNAME = new QName("http://xmlns.oracle.com/bam", "Delete");
    private final static QName _UpsertResponse_QNAME = new QName("http://xmlns.oracle.com/bam", "UpsertResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ap.quantas.com.bamUpdateWebService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BatchResponse }
     * 
     */
    public BatchResponse createBatchResponse() {
        return new BatchResponse();
    }

    /**
     * Create an instance of {@link DestroyResponse }
     * 
     */
    public DestroyResponse createDestroyResponse() {
        return new DestroyResponse();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link InsertResponse }
     * 
     */
    public InsertResponse createInsertResponse() {
        return new InsertResponse();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link UpdateResponse }
     * 
     */
    public UpdateResponse createUpdateResponse() {
        return new UpdateResponse();
    }

    /**
     * Create an instance of {@link UpsertResponse }
     * 
     */
    public UpsertResponse createUpsertResponse() {
        return new UpsertResponse();
    }

    /**
     * Create an instance of {@link Insert }
     * 
     */
    public Insert createInsert() {
        return new Insert();
    }

    /**
     * Create an instance of {@link Batch }
     * 
     */
    public Batch createBatch() {
        return new Batch();
    }

    /**
     * Create an instance of {@link Destroy }
     * 
     */
    public Destroy createDestroy() {
        return new Destroy();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link Upsert }
     * 
     */
    public Upsert createUpsert() {
        return new Upsert();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bam", name = "Update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Destroy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bam", name = "destroy")
    public JAXBElement<Destroy> createDestroy(Destroy value) {
        return new JAXBElement<Destroy>(_Destroy_QNAME, Destroy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Batch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bam", name = "Batch")
    public JAXBElement<Batch> createBatch(Batch value) {
        return new JAXBElement<Batch>(_Batch_QNAME, Batch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Insert }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bam", name = "Insert")
    public JAXBElement<Insert> createInsert(Insert value) {
        return new JAXBElement<Insert>(_Insert_QNAME, Insert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Upsert }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bam", name = "Upsert")
    public JAXBElement<Upsert> createUpsert(Upsert value) {
        return new JAXBElement<Upsert>(_Upsert_QNAME, Upsert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bam", name = "UpdateResponse")
    public JAXBElement<UpdateResponse> createUpdateResponse(UpdateResponse value) {
        return new JAXBElement<UpdateResponse>(_UpdateResponse_QNAME, UpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DestroyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bam", name = "destroyResponse")
    public JAXBElement<DestroyResponse> createDestroyResponse(DestroyResponse value) {
        return new JAXBElement<DestroyResponse>(_DestroyResponse_QNAME, DestroyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bam", name = "DeleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bam", name = "BatchResponse")
    public JAXBElement<BatchResponse> createBatchResponse(BatchResponse value) {
        return new JAXBElement<BatchResponse>(_BatchResponse_QNAME, BatchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bam", name = "InsertResponse")
    public JAXBElement<InsertResponse> createInsertResponse(InsertResponse value) {
        return new JAXBElement<InsertResponse>(_InsertResponse_QNAME, InsertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bam", name = "Delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpsertResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/bam", name = "UpsertResponse")
    public JAXBElement<UpsertResponse> createUpsertResponse(UpsertResponse value) {
        return new JAXBElement<UpsertResponse>(_UpsertResponse_QNAME, UpsertResponse.class, null, value);
    }

}
