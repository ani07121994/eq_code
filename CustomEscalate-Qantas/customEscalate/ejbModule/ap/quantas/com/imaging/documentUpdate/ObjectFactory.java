/*      */ package ap.quantas.com.imaging.documentUpdate;
/*      */ 
/*      */ import javax.xml.bind.JAXBElement;
/*      */ import javax.xml.bind.annotation.XmlElementDecl;
/*      */ import javax.xml.bind.annotation.XmlRegistry;
/*      */ import javax.xml.datatype.XMLGregorianCalendar;
/*      */ import javax.xml.namespace.QName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @XmlRegistry
/*      */ public class ObjectFactory
/*      */ {
/*   28 */   private static final QName _DeleteDocumentResponse_QNAME = new QName("http://imaging.oracle/", "deleteDocumentResponse");
/*   29 */   private static final QName _GetTargetApplication_QNAME = new QName("http://imaging.oracle/", "getTargetApplication");
/*   30 */   private static final QName _GetDocuments_QNAME = new QName("http://imaging.oracle/", "getDocuments");
/*   31 */   private static final QName _GetTargetApplicationResponse_QNAME = new QName("http://imaging.oracle/", "getTargetApplicationResponse");
/*   32 */   private static final QName _DeleteDocuments_QNAME = new QName("http://imaging.oracle/", "deleteDocuments");
/*   33 */   private static final QName _NameId_QNAME = new QName("http://imaging.oracle/", "nameId");
/*   34 */   private static final QName _ValidationError_QNAME = new QName("http://imaging.oracle/", "ValidationError");
/*   35 */   private static final QName _StoragePolicyItem_QNAME = new QName("http://imaging.oracle/", "StoragePolicyItem");
/*   36 */   private static final QName _ValidationException_QNAME = new QName("http://imaging.oracle/", "ValidationException");
/*   37 */   private static final QName _SetAnnotationsResponse_QNAME = new QName("http://imaging.oracle/", "setAnnotationsResponse");
/*   38 */   private static final QName _Application_QNAME = new QName("http://imaging.oracle/", "application");
/*   39 */   private static final QName _GetAnnotations_QNAME = new QName("http://imaging.oracle/", "getAnnotations");
/*   40 */   private static final QName _GetSupportingContentResponse_QNAME = new QName("http://imaging.oracle/", "getSupportingContentResponse");
/*   41 */   private static final QName _CopyDocument_QNAME = new QName("http://imaging.oracle/", "copyDocument");
/*   42 */   private static final QName _ListTargetApplicationsResponse_QNAME = new QName("http://imaging.oracle/", "listTargetApplicationsResponse");
/*   43 */   private static final QName _MoveDocument_QNAME = new QName("http://imaging.oracle/", "moveDocument");
/*   44 */   private static final QName _Document_QNAME = new QName("http://imaging.oracle/", "document");
/*   45 */   private static final QName _CreateDocument_QNAME = new QName("http://imaging.oracle/", "createDocument");
/*   46 */   private static final QName _UpdateDocumentResponse_QNAME = new QName("http://imaging.oracle/", "updateDocumentResponse");
/*   47 */   private static final QName _Security_QNAME = new QName("http://imaging.oracle/", "security");
/*   48 */   private static final QName _SetSupportingContentResponse_QNAME = new QName("http://imaging.oracle/", "setSupportingContentResponse");
/*   49 */   private static final QName _FieldDefinition_QNAME = new QName("http://imaging.oracle/", "FieldDefinition");
/*   50 */   private static final QName _SubmitToWorkflowResponse_QNAME = new QName("http://imaging.oracle/", "submitToWorkflowResponse");
/*   51 */   private static final QName _DeleteDocumentsResponse_QNAME = new QName("http://imaging.oracle/", "deleteDocumentsResponse");
/*   52 */   private static final QName _SetSupportingContent_QNAME = new QName("http://imaging.oracle/", "setSupportingContent");
/*   53 */   private static final QName _LockDocumentResponse_QNAME = new QName("http://imaging.oracle/", "lockDocumentResponse");
/*   54 */   private static final QName _BpelConfig_QNAME = new QName("http://imaging.oracle/", "BpelConfig");
/*   55 */   private static final QName _GetSupportingContent_QNAME = new QName("http://imaging.oracle/", "getSupportingContent");
/*   56 */   private static final QName _SectionSet_QNAME = new QName("http://imaging.oracle/", "sectionSet");
/*   57 */   private static final QName _LifecyclePolicy_QNAME = new QName("http://imaging.oracle/", "LifecyclePolicy");
/*   58 */   private static final QName _CopyDocumentResponse_QNAME = new QName("http://imaging.oracle/", "copyDocumentResponse");
/*   59 */   private static final QName _SubmitToWorkflow_QNAME = new QName("http://imaging.oracle/", "submitToWorkflow");
/*   60 */   private static final QName _GetDocumentsResponse_QNAME = new QName("http://imaging.oracle/", "getDocumentsResponse");
/*   61 */   private static final QName _GetDocumentVersionResponse_QNAME = new QName("http://imaging.oracle/", "getDocumentVersionResponse");
/*   62 */   private static final QName _HasStatusChanged_QNAME = new QName("http://imaging.oracle/", "hasStatusChanged");
/*   63 */   private static final QName _DocumentSecurity_QNAME = new QName("http://imaging.oracle/", "documentSecurity");
/*   64 */   private static final QName _SetAnnotations_QNAME = new QName("http://imaging.oracle/", "setAnnotations");
/*   65 */   private static final QName _MoveDocumentResponse_QNAME = new QName("http://imaging.oracle/", "moveDocumentResponse");
/*   66 */   private static final QName _UnlockDocumentResponse_QNAME = new QName("http://imaging.oracle/", "unlockDocumentResponse");
/*   67 */   private static final QName _HasStatusChangedResponse_QNAME = new QName("http://imaging.oracle/", "hasStatusChangedResponse");
/*   68 */   private static final QName _GetAnnotationsResponse_QNAME = new QName("http://imaging.oracle/", "getAnnotationsResponse");
/*   69 */   private static final QName _GetDocumentVersion_QNAME = new QName("http://imaging.oracle/", "getDocumentVersion");
/*   70 */   private static final QName _UpdateDocument_QNAME = new QName("http://imaging.oracle/", "updateDocument");
/*   71 */   private static final QName _ModifyPageOrderResponse_QNAME = new QName("http://imaging.oracle/", "modifyPageOrderResponse");
/*   72 */   private static final QName _LockDocument_QNAME = new QName("http://imaging.oracle/", "lockDocument");
/*   73 */   private static final QName _CreateDocumentResponse_QNAME = new QName("http://imaging.oracle/", "createDocumentResponse");
/*   74 */   private static final QName _GetDocument_QNAME = new QName("http://imaging.oracle/", "getDocument");
/*   75 */   private static final QName _ListTargetApplications_QNAME = new QName("http://imaging.oracle/", "listTargetApplications");
/*   76 */   private static final QName _DeleteDocument_QNAME = new QName("http://imaging.oracle/", "deleteDocument");
/*   77 */   private static final QName _ModifyPageOrder_QNAME = new QName("http://imaging.oracle/", "modifyPageOrder");
/*   78 */   private static final QName _UnlockDocument_QNAME = new QName("http://imaging.oracle/", "unlockDocument");
/*   79 */   private static final QName _GetDocumentResponse_QNAME = new QName("http://imaging.oracle/", "getDocumentResponse");
/*   80 */   private static final QName _ImagingException_QNAME = new QName("http://imaging.oracle/", "ImagingException");
/*   81 */   private static final QName _PayloadItemValue_QNAME = new QName("", "value");
/*   82 */   private static final QName _DocumentPropertiesVolume_QNAME = new QName("", "volume");
/*   83 */   private static final QName _DocumentPropertiesVolumeDate_QNAME = new QName("", "volumeDate");
/*   84 */   private static final QName _LifecyclePolicyStoragePolicy_QNAME = new QName("", "storagePolicy");
/*   85 */   private static final QName _ApplicationBpelConfig_QNAME = new QName("", "bpelConfig");
/*   86 */   private static final QName _ApplicationLifecyclePolicy_QNAME = new QName("", "lifecyclePolicy");
/*   87 */   private static final QName _ApplicationDocumentPermissions_QNAME = new QName("", "documentPermissions");
/*   88 */   private static final QName _ApplicationDocumentSecurity_QNAME = new QName("", "documentSecurity");
/*   89 */   private static final QName _ApplicationApplicationPermissions_QNAME = new QName("", "applicationPermissions");
/*   90 */   private static final QName _ApplicationSecurity_QNAME = new QName("", "security");
/*   91 */   private static final QName _ApplicationProperties_QNAME = new QName("", "properties");
/*   92 */   private static final QName _BpelConfigPayloadMapping_QNAME = new QName("", "payloadMapping");
/*   93 */   private static final QName _FieldDefinitionPickList_QNAME = new QName("", "pickList");
/*   94 */   private static final QName _DocumentFieldValues_QNAME = new QName("", "fieldValues");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CopyDocumentResponse createCopyDocumentResponse() {
/*  108 */     return new CopyDocumentResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public UnlockDocument createUnlockDocument() {
/*  116 */     return new UnlockDocument();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DocumentSectionSet createDocumentSectionSet() {
/*  124 */     return new DocumentSectionSet();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GetDocumentResponse createGetDocumentResponse() {
/*  132 */     return new GetDocumentResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AuditEvent.Properties createAuditEventProperties() {
/*  140 */     return new AuditEvent.Properties();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GetTargetApplicationResponse createGetTargetApplicationResponse() {
/*  148 */     return new GetTargetApplicationResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FieldValue createFieldValue() {
/*  156 */     return new FieldValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Application createApplication() {
/*  164 */     return new Application();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AuditEvent createAuditEvent() {
/*  172 */     return new AuditEvent();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SubmitToWorkflow createSubmitToWorkflow() {
/*  180 */     return new SubmitToWorkflow();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HasStatusChanged createHasStatusChanged() {
/*  188 */     return new HasStatusChanged();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ListTargetApplicationsResponse createListTargetApplicationsResponse() {
/*  196 */     return new ListTargetApplicationsResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TypedValue createTypedValue() {
/*  204 */     return new TypedValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GetDocuments createGetDocuments() {
/*  212 */     return new GetDocuments();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DefinitionSecurity createDefinitionSecurity() {
/*  220 */     return new DefinitionSecurity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GetDocumentVersionResponse createGetDocumentVersionResponse() {
/*  228 */     return new GetDocumentVersionResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DocumentSecurity createDocumentSecurity() {
/*  236 */     return new DocumentSecurity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ImagingFaultInfo.FaultDetails createImagingFaultInfoFaultDetails() {
/*  244 */     return new ImagingFaultInfo.FaultDetails();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GetDocument createGetDocument() {
/*  252 */     return new GetDocument();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CopyDocument createCopyDocument() {
/*  260 */     return new CopyDocument();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Application.History createApplicationHistory() {
/*  268 */     return new Application.History();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DeleteDocuments createDeleteDocuments() {
/*  276 */     return new DeleteDocuments();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CreateDocumentResponse createCreateDocumentResponse() {
/*  284 */     return new CreateDocumentResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GetDocumentsResponse createGetDocumentsResponse() {
/*  292 */     return new GetDocumentsResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ModifyPageOrderResponse createModifyPageOrderResponse() {
/*  300 */     return new ModifyPageOrderResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Document.FieldValues createDocumentFieldValues() {
/*  308 */     return new Document.FieldValues();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StorageStage createStorageStage() {
/*  316 */     return new StorageStage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LifecyclePolicy.StoragePolicy createLifecyclePolicyStoragePolicy() {
/*  324 */     return new LifecyclePolicy.StoragePolicy();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PageChange createPageChange() {
/*  332 */     return new PageChange();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PayloadItem createPayloadItem() {
/*  340 */     return new PayloadItem();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DocumentPermissions createDocumentPermissions() {
/*  348 */     return new DocumentPermissions();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SetSupportingContent createSetSupportingContent() {
/*  356 */     return new SetSupportingContent();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ValidationError createValidationError() {
/*  364 */     return new ValidationError();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GetSupportingContent createGetSupportingContent() {
/*  372 */     return new GetSupportingContent();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HasStatusChangedResponse createHasStatusChangedResponse() {
/*  380 */     return new HasStatusChangedResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GetSupportingContentResponse createGetSupportingContentResponse() {
/*  388 */     return new GetSupportingContentResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GetDocumentVersion createGetDocumentVersion() {
/*  396 */     return new GetDocumentVersion();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Document createDocument() {
/*  404 */     return new Document();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public UpdateDocument createUpdateDocument() {
/*  412 */     return new UpdateDocument();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DocumentProperties createDocumentProperties() {
/*  420 */     return new DocumentProperties();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ListTargetApplications createListTargetApplications() {
/*  428 */     return new ListTargetApplications();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Application.FieldDefinitions createApplicationFieldDefinitions() {
/*  436 */     return new Application.FieldDefinitions();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Application.Security createApplicationSecurity() {
/*  444 */     return new Application.Security();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Document.History createDocumentHistory() {
/*  452 */     return new Document.History();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SetAnnotations createSetAnnotations() {
/*  460 */     return new SetAnnotations();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ValidationFaultInfo createValidationFaultInfo() {
/*  468 */     return new ValidationFaultInfo();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ImagingFaultInfo createImagingFaultInfo() {
/*  476 */     return new ImagingFaultInfo();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Application.DocumentSecurity createApplicationDocumentSecurity() {
/*  484 */     return new Application.DocumentSecurity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CreateDocument createCreateDocument() {
/*  492 */     return new CreateDocument();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MoveDocumentResponse createMoveDocumentResponse() {
/*  500 */     return new MoveDocumentResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SubmitToWorkflowResponse createSubmitToWorkflowResponse() {
/*  508 */     return new SubmitToWorkflowResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public UpdateDocumentResponse createUpdateDocumentResponse() {
/*  516 */     return new UpdateDocumentResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SetAnnotationsResponse createSetAnnotationsResponse() {
/*  524 */     return new SetAnnotationsResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DeleteDocumentResponse createDeleteDocumentResponse() {
/*  532 */     return new DeleteDocumentResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ModifyPageOrder createModifyPageOrder() {
/*  540 */     return new ModifyPageOrder();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MoveDocument createMoveDocument() {
/*  548 */     return new MoveDocument();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NameId createNameId() {
/*  556 */     return new NameId();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SetSupportingContentResponse createSetSupportingContentResponse() {
/*  564 */     return new SetSupportingContentResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ApplicationProperties createApplicationProperties() {
/*  572 */     return new ApplicationProperties();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LockDocument createLockDocument() {
/*  580 */     return new LockDocument();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LifecyclePolicy createLifecyclePolicy() {
/*  588 */     return new LifecyclePolicy();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BpelConfig createBpelConfig() {
/*  596 */     return new BpelConfig();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FieldDefinition createFieldDefinition() {
/*  604 */     return new FieldDefinition();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LockDocumentResponse createLockDocumentResponse() {
/*  612 */     return new LockDocumentResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DefinitionPermissions createDefinitionPermissions() {
/*  620 */     return new DefinitionPermissions();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FieldDefinition.PickList createFieldDefinitionPickList() {
/*  628 */     return new FieldDefinition.PickList();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ImagingFaultDetail createImagingFaultDetail() {
/*  636 */     return new ImagingFaultDetail();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GetAnnotationsResponse createGetAnnotationsResponse() {
/*  644 */     return new GetAnnotationsResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DeleteDocument createDeleteDocument() {
/*  652 */     return new DeleteDocument();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public UnlockDocumentResponse createUnlockDocumentResponse() {
/*  660 */     return new UnlockDocumentResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DeleteDocumentsResponse createDeleteDocumentsResponse() {
/*  668 */     return new DeleteDocumentsResponse();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GetTargetApplication createGetTargetApplication() {
/*  676 */     return new GetTargetApplication();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BpelConfig.PayloadMapping createBpelConfigPayloadMapping() {
/*  684 */     return new BpelConfig.PayloadMapping();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GetAnnotations createGetAnnotations() {
/*  692 */     return new GetAnnotations();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "deleteDocumentResponse")
/*      */   public JAXBElement<DeleteDocumentResponse> createDeleteDocumentResponse(DeleteDocumentResponse value) {
/*  701 */     return new JAXBElement<DeleteDocumentResponse>(_DeleteDocumentResponse_QNAME, DeleteDocumentResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getTargetApplication")
/*      */   public JAXBElement<GetTargetApplication> createGetTargetApplication(GetTargetApplication value) {
/*  710 */     return new JAXBElement<GetTargetApplication>(_GetTargetApplication_QNAME, GetTargetApplication.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getDocuments")
/*      */   public JAXBElement<GetDocuments> createGetDocuments(GetDocuments value) {
/*  719 */     return new JAXBElement<GetDocuments>(_GetDocuments_QNAME, GetDocuments.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getTargetApplicationResponse")
/*      */   public JAXBElement<GetTargetApplicationResponse> createGetTargetApplicationResponse(GetTargetApplicationResponse value) {
/*  728 */     return new JAXBElement<GetTargetApplicationResponse>(_GetTargetApplicationResponse_QNAME, GetTargetApplicationResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "deleteDocuments")
/*      */   public JAXBElement<DeleteDocuments> createDeleteDocuments(DeleteDocuments value) {
/*  737 */     return new JAXBElement<DeleteDocuments>(_DeleteDocuments_QNAME, DeleteDocuments.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "nameId")
/*      */   public JAXBElement<NameId> createNameId(NameId value) {
/*  746 */     return new JAXBElement<NameId>(_NameId_QNAME, NameId.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ValidationError")
/*      */   public JAXBElement<ValidationError> createValidationError(ValidationError value) {
/*  755 */     return new JAXBElement<ValidationError>(_ValidationError_QNAME, ValidationError.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "StoragePolicyItem")
/*      */   public JAXBElement<StorageStage> createStoragePolicyItem(StorageStage value) {
/*  764 */     return new JAXBElement<StorageStage>(_StoragePolicyItem_QNAME, StorageStage.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ValidationException")
/*      */   public JAXBElement<ValidationFaultInfo> createValidationException(ValidationFaultInfo value) {
/*  773 */     return new JAXBElement<ValidationFaultInfo>(_ValidationException_QNAME, ValidationFaultInfo.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "setAnnotationsResponse")
/*      */   public JAXBElement<SetAnnotationsResponse> createSetAnnotationsResponse(SetAnnotationsResponse value) {
/*  782 */     return new JAXBElement<SetAnnotationsResponse>(_SetAnnotationsResponse_QNAME, SetAnnotationsResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "application")
/*      */   public JAXBElement<Application> createApplication(Application value) {
/*  791 */     return new JAXBElement<Application>(_Application_QNAME, Application.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getAnnotations")
/*      */   public JAXBElement<GetAnnotations> createGetAnnotations(GetAnnotations value) {
/*  800 */     return new JAXBElement<GetAnnotations>(_GetAnnotations_QNAME, GetAnnotations.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSupportingContentResponse")
/*      */   public JAXBElement<GetSupportingContentResponse> createGetSupportingContentResponse(GetSupportingContentResponse value) {
/*  809 */     return new JAXBElement<GetSupportingContentResponse>(_GetSupportingContentResponse_QNAME, GetSupportingContentResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "copyDocument")
/*      */   public JAXBElement<CopyDocument> createCopyDocument(CopyDocument value) {
/*  818 */     return new JAXBElement<CopyDocument>(_CopyDocument_QNAME, CopyDocument.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "listTargetApplicationsResponse")
/*      */   public JAXBElement<ListTargetApplicationsResponse> createListTargetApplicationsResponse(ListTargetApplicationsResponse value) {
/*  827 */     return new JAXBElement<ListTargetApplicationsResponse>(_ListTargetApplicationsResponse_QNAME, ListTargetApplicationsResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "moveDocument")
/*      */   public JAXBElement<MoveDocument> createMoveDocument(MoveDocument value) {
/*  836 */     return new JAXBElement<MoveDocument>(_MoveDocument_QNAME, MoveDocument.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "document")
/*      */   public JAXBElement<Document> createDocument(Document value) {
/*  845 */     return new JAXBElement<Document>(_Document_QNAME, Document.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "createDocument")
/*      */   public JAXBElement<CreateDocument> createCreateDocument(CreateDocument value) {
/*  854 */     return new JAXBElement<CreateDocument>(_CreateDocument_QNAME, CreateDocument.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "updateDocumentResponse")
/*      */   public JAXBElement<UpdateDocumentResponse> createUpdateDocumentResponse(UpdateDocumentResponse value) {
/*  863 */     return new JAXBElement<UpdateDocumentResponse>(_UpdateDocumentResponse_QNAME, UpdateDocumentResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "security")
/*      */   public JAXBElement<DefinitionSecurity> createSecurity(DefinitionSecurity value) {
/*  872 */     return new JAXBElement<DefinitionSecurity>(_Security_QNAME, DefinitionSecurity.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "setSupportingContentResponse")
/*      */   public JAXBElement<SetSupportingContentResponse> createSetSupportingContentResponse(SetSupportingContentResponse value) {
/*  881 */     return new JAXBElement<SetSupportingContentResponse>(_SetSupportingContentResponse_QNAME, SetSupportingContentResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "FieldDefinition")
/*      */   public JAXBElement<FieldDefinition> createFieldDefinition(FieldDefinition value) {
/*  890 */     return new JAXBElement<FieldDefinition>(_FieldDefinition_QNAME, FieldDefinition.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "submitToWorkflowResponse")
/*      */   public JAXBElement<SubmitToWorkflowResponse> createSubmitToWorkflowResponse(SubmitToWorkflowResponse value) {
/*  899 */     return new JAXBElement<SubmitToWorkflowResponse>(_SubmitToWorkflowResponse_QNAME, SubmitToWorkflowResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "deleteDocumentsResponse")
/*      */   public JAXBElement<DeleteDocumentsResponse> createDeleteDocumentsResponse(DeleteDocumentsResponse value) {
/*  908 */     return new JAXBElement<DeleteDocumentsResponse>(_DeleteDocumentsResponse_QNAME, DeleteDocumentsResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "setSupportingContent")
/*      */   public JAXBElement<SetSupportingContent> createSetSupportingContent(SetSupportingContent value) {
/*  917 */     return new JAXBElement<SetSupportingContent>(_SetSupportingContent_QNAME, SetSupportingContent.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "lockDocumentResponse")
/*      */   public JAXBElement<LockDocumentResponse> createLockDocumentResponse(LockDocumentResponse value) {
/*  926 */     return new JAXBElement<LockDocumentResponse>(_LockDocumentResponse_QNAME, LockDocumentResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "BpelConfig")
/*      */   public JAXBElement<BpelConfig> createBpelConfig(BpelConfig value) {
/*  935 */     return new JAXBElement<BpelConfig>(_BpelConfig_QNAME, BpelConfig.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSupportingContent")
/*      */   public JAXBElement<GetSupportingContent> createGetSupportingContent(GetSupportingContent value) {
/*  944 */     return new JAXBElement<GetSupportingContent>(_GetSupportingContent_QNAME, GetSupportingContent.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "sectionSet")
/*      */   public JAXBElement<DocumentSectionSet> createSectionSet(DocumentSectionSet value) {
/*  953 */     return new JAXBElement<DocumentSectionSet>(_SectionSet_QNAME, DocumentSectionSet.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "LifecyclePolicy")
/*      */   public JAXBElement<LifecyclePolicy> createLifecyclePolicy(LifecyclePolicy value) {
/*  962 */     return new JAXBElement<LifecyclePolicy>(_LifecyclePolicy_QNAME, LifecyclePolicy.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "copyDocumentResponse")
/*      */   public JAXBElement<CopyDocumentResponse> createCopyDocumentResponse(CopyDocumentResponse value) {
/*  971 */     return new JAXBElement<CopyDocumentResponse>(_CopyDocumentResponse_QNAME, CopyDocumentResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "submitToWorkflow")
/*      */   public JAXBElement<SubmitToWorkflow> createSubmitToWorkflow(SubmitToWorkflow value) {
/*  980 */     return new JAXBElement<SubmitToWorkflow>(_SubmitToWorkflow_QNAME, SubmitToWorkflow.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getDocumentsResponse")
/*      */   public JAXBElement<GetDocumentsResponse> createGetDocumentsResponse(GetDocumentsResponse value) {
/*  989 */     return new JAXBElement<GetDocumentsResponse>(_GetDocumentsResponse_QNAME, GetDocumentsResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getDocumentVersionResponse")
/*      */   public JAXBElement<GetDocumentVersionResponse> createGetDocumentVersionResponse(GetDocumentVersionResponse value) {
/*  998 */     return new JAXBElement<GetDocumentVersionResponse>(_GetDocumentVersionResponse_QNAME, GetDocumentVersionResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "hasStatusChanged")
/*      */   public JAXBElement<HasStatusChanged> createHasStatusChanged(HasStatusChanged value) {
/* 1007 */     return new JAXBElement<HasStatusChanged>(_HasStatusChanged_QNAME, HasStatusChanged.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "documentSecurity")
/*      */   public JAXBElement<DocumentSecurity> createDocumentSecurity(DocumentSecurity value) {
/* 1016 */     return new JAXBElement<DocumentSecurity>(_DocumentSecurity_QNAME, DocumentSecurity.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "setAnnotations")
/*      */   public JAXBElement<SetAnnotations> createSetAnnotations(SetAnnotations value) {
/* 1025 */     return new JAXBElement<SetAnnotations>(_SetAnnotations_QNAME, SetAnnotations.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "moveDocumentResponse")
/*      */   public JAXBElement<MoveDocumentResponse> createMoveDocumentResponse(MoveDocumentResponse value) {
/* 1034 */     return new JAXBElement<MoveDocumentResponse>(_MoveDocumentResponse_QNAME, MoveDocumentResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "unlockDocumentResponse")
/*      */   public JAXBElement<UnlockDocumentResponse> createUnlockDocumentResponse(UnlockDocumentResponse value) {
/* 1043 */     return new JAXBElement<UnlockDocumentResponse>(_UnlockDocumentResponse_QNAME, UnlockDocumentResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "hasStatusChangedResponse")
/*      */   public JAXBElement<HasStatusChangedResponse> createHasStatusChangedResponse(HasStatusChangedResponse value) {
/* 1052 */     return new JAXBElement<HasStatusChangedResponse>(_HasStatusChangedResponse_QNAME, HasStatusChangedResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getAnnotationsResponse")
/*      */   public JAXBElement<GetAnnotationsResponse> createGetAnnotationsResponse(GetAnnotationsResponse value) {
/* 1061 */     return new JAXBElement<GetAnnotationsResponse>(_GetAnnotationsResponse_QNAME, GetAnnotationsResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getDocumentVersion")
/*      */   public JAXBElement<GetDocumentVersion> createGetDocumentVersion(GetDocumentVersion value) {
/* 1070 */     return new JAXBElement<GetDocumentVersion>(_GetDocumentVersion_QNAME, GetDocumentVersion.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "updateDocument")
/*      */   public JAXBElement<UpdateDocument> createUpdateDocument(UpdateDocument value) {
/* 1079 */     return new JAXBElement<UpdateDocument>(_UpdateDocument_QNAME, UpdateDocument.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "modifyPageOrderResponse")
/*      */   public JAXBElement<ModifyPageOrderResponse> createModifyPageOrderResponse(ModifyPageOrderResponse value) {
/* 1088 */     return new JAXBElement<ModifyPageOrderResponse>(_ModifyPageOrderResponse_QNAME, ModifyPageOrderResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "lockDocument")
/*      */   public JAXBElement<LockDocument> createLockDocument(LockDocument value) {
/* 1097 */     return new JAXBElement<LockDocument>(_LockDocument_QNAME, LockDocument.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "createDocumentResponse")
/*      */   public JAXBElement<CreateDocumentResponse> createCreateDocumentResponse(CreateDocumentResponse value) {
/* 1106 */     return new JAXBElement<CreateDocumentResponse>(_CreateDocumentResponse_QNAME, CreateDocumentResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getDocument")
/*      */   public JAXBElement<GetDocument> createGetDocument(GetDocument value) {
/* 1115 */     return new JAXBElement<GetDocument>(_GetDocument_QNAME, GetDocument.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "listTargetApplications")
/*      */   public JAXBElement<ListTargetApplications> createListTargetApplications(ListTargetApplications value) {
/* 1124 */     return new JAXBElement<ListTargetApplications>(_ListTargetApplications_QNAME, ListTargetApplications.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "deleteDocument")
/*      */   public JAXBElement<DeleteDocument> createDeleteDocument(DeleteDocument value) {
/* 1133 */     return new JAXBElement<DeleteDocument>(_DeleteDocument_QNAME, DeleteDocument.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "modifyPageOrder")
/*      */   public JAXBElement<ModifyPageOrder> createModifyPageOrder(ModifyPageOrder value) {
/* 1142 */     return new JAXBElement<ModifyPageOrder>(_ModifyPageOrder_QNAME, ModifyPageOrder.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "unlockDocument")
/*      */   public JAXBElement<UnlockDocument> createUnlockDocument(UnlockDocument value) {
/* 1151 */     return new JAXBElement<UnlockDocument>(_UnlockDocument_QNAME, UnlockDocument.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getDocumentResponse")
/*      */   public JAXBElement<GetDocumentResponse> createGetDocumentResponse(GetDocumentResponse value) {
/* 1160 */     return new JAXBElement<GetDocumentResponse>(_GetDocumentResponse_QNAME, GetDocumentResponse.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ImagingException")
/*      */   public JAXBElement<ImagingFaultInfo> createImagingException(ImagingFaultInfo value) {
/* 1169 */     return new JAXBElement<ImagingFaultInfo>(_ImagingException_QNAME, ImagingFaultInfo.class, null, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "value", scope = PayloadItem.class)
/*      */   public JAXBElement<String> createPayloadItemValue(String value) {
/* 1178 */     return new JAXBElement<String>(_PayloadItemValue_QNAME, String.class, PayloadItem.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "volume", scope = DocumentProperties.class)
/*      */   public JAXBElement<String> createDocumentPropertiesVolume(String value) {
/* 1187 */     return new JAXBElement<String>(_DocumentPropertiesVolume_QNAME, String.class, DocumentProperties.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "volumeDate", scope = DocumentProperties.class)
/*      */   public JAXBElement<XMLGregorianCalendar> createDocumentPropertiesVolumeDate(XMLGregorianCalendar value) {
/* 1196 */     return new JAXBElement<XMLGregorianCalendar>(_DocumentPropertiesVolumeDate_QNAME, XMLGregorianCalendar.class, DocumentProperties.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "storagePolicy", scope = LifecyclePolicy.class)
/*      */   public JAXBElement<LifecyclePolicy.StoragePolicy> createLifecyclePolicyStoragePolicy(LifecyclePolicy.StoragePolicy value) {
/* 1205 */     return new JAXBElement<LifecyclePolicy.StoragePolicy>(_LifecyclePolicyStoragePolicy_QNAME, LifecyclePolicy.StoragePolicy.class, LifecyclePolicy.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "bpelConfig", scope = Application.class)
/*      */   public JAXBElement<BpelConfig> createApplicationBpelConfig(BpelConfig value) {
/* 1214 */     return new JAXBElement<BpelConfig>(_ApplicationBpelConfig_QNAME, BpelConfig.class, Application.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "lifecyclePolicy", scope = Application.class)
/*      */   public JAXBElement<LifecyclePolicy> createApplicationLifecyclePolicy(LifecyclePolicy value) {
/* 1223 */     return new JAXBElement<LifecyclePolicy>(_ApplicationLifecyclePolicy_QNAME, LifecyclePolicy.class, Application.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "documentPermissions", scope = Application.class)
/*      */   public JAXBElement<DocumentPermissions> createApplicationDocumentPermissions(DocumentPermissions value) {
/* 1232 */     return new JAXBElement<DocumentPermissions>(_ApplicationDocumentPermissions_QNAME, DocumentPermissions.class, Application.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "documentSecurity", scope = Application.class)
/*      */   public JAXBElement<Application.DocumentSecurity> createApplicationDocumentSecurity(Application.DocumentSecurity value) {
/* 1241 */     return new JAXBElement<Application.DocumentSecurity>(_ApplicationDocumentSecurity_QNAME, Application.DocumentSecurity.class, Application.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "applicationPermissions", scope = Application.class)
/*      */   public JAXBElement<DefinitionPermissions> createApplicationApplicationPermissions(DefinitionPermissions value) {
/* 1250 */     return new JAXBElement<DefinitionPermissions>(_ApplicationApplicationPermissions_QNAME, DefinitionPermissions.class, Application.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "security", scope = Application.class)
/*      */   public JAXBElement<Application.Security> createApplicationSecurity(Application.Security value) {
/* 1259 */     return new JAXBElement<Application.Security>(_ApplicationSecurity_QNAME, Application.Security.class, Application.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "properties", scope = Application.class)
/*      */   public JAXBElement<ApplicationProperties> createApplicationProperties(ApplicationProperties value) {
/* 1268 */     return new JAXBElement<ApplicationProperties>(_ApplicationProperties_QNAME, ApplicationProperties.class, Application.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "payloadMapping", scope = BpelConfig.class)
/*      */   public JAXBElement<BpelConfig.PayloadMapping> createBpelConfigPayloadMapping(BpelConfig.PayloadMapping value) {
/* 1277 */     return new JAXBElement<BpelConfig.PayloadMapping>(_BpelConfigPayloadMapping_QNAME, BpelConfig.PayloadMapping.class, BpelConfig.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "pickList", scope = FieldDefinition.class)
/*      */   public JAXBElement<FieldDefinition.PickList> createFieldDefinitionPickList(FieldDefinition.PickList value) {
/* 1286 */     return new JAXBElement<FieldDefinition.PickList>(_FieldDefinitionPickList_QNAME, FieldDefinition.PickList.class, FieldDefinition.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "documentPermissions", scope = Document.class)
/*      */   public JAXBElement<DocumentPermissions> createDocumentDocumentPermissions(DocumentPermissions value) {
/* 1295 */     return new JAXBElement<DocumentPermissions>(_ApplicationDocumentPermissions_QNAME, DocumentPermissions.class, Document.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "properties", scope = Document.class)
/*      */   public JAXBElement<DocumentProperties> createDocumentProperties(DocumentProperties value) {
/* 1304 */     return new JAXBElement<DocumentProperties>(_ApplicationProperties_QNAME, DocumentProperties.class, Document.class, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "fieldValues", scope = Document.class)
/*      */   public JAXBElement<Document.FieldValues> createDocumentFieldValues(Document.FieldValues value) {
/* 1313 */     return new JAXBElement<Document.FieldValues>(_DocumentFieldValues_QNAME, Document.FieldValues.class, Document.class, value);
/*      */   }
/*      */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\documentUpdate\ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */