/*      */ package ap.quantas.com.imaging.documentUpdate;
/*      */ 
/*      */ import ap.quantas.com.imaging.documentUpdate.Application;
/*      */ import ap.quantas.com.imaging.documentUpdate.ApplicationProperties;
/*      */ import ap.quantas.com.imaging.documentUpdate.AuditEvent;
/*      */ import ap.quantas.com.imaging.documentUpdate.BpelConfig;
/*      */ import ap.quantas.com.imaging.documentUpdate.CopyDocument;
/*      */ import ap.quantas.com.imaging.documentUpdate.CopyDocumentResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.CreateDocument;
/*      */ import ap.quantas.com.imaging.documentUpdate.CreateDocumentResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.DefinitionPermissions;
/*      */ import ap.quantas.com.imaging.documentUpdate.DefinitionSecurity;
/*      */ import ap.quantas.com.imaging.documentUpdate.DeleteDocument;
/*      */ import ap.quantas.com.imaging.documentUpdate.DeleteDocumentResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.DeleteDocuments;
/*      */ import ap.quantas.com.imaging.documentUpdate.DeleteDocumentsResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.Document;
/*      */ import ap.quantas.com.imaging.documentUpdate.DocumentPermissions;
/*      */ import ap.quantas.com.imaging.documentUpdate.DocumentProperties;
/*      */ import ap.quantas.com.imaging.documentUpdate.DocumentSectionSet;
/*      */ import ap.quantas.com.imaging.documentUpdate.DocumentSecurity;
/*      */ import ap.quantas.com.imaging.documentUpdate.FieldDefinition;
/*      */ import ap.quantas.com.imaging.documentUpdate.FieldValue;
/*      */ import ap.quantas.com.imaging.documentUpdate.GetAnnotations;
/*      */ import ap.quantas.com.imaging.documentUpdate.GetAnnotationsResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.GetDocument;
/*      */ import ap.quantas.com.imaging.documentUpdate.GetDocumentResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.GetDocumentVersion;
/*      */ import ap.quantas.com.imaging.documentUpdate.GetDocumentVersionResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.GetDocuments;
/*      */ import ap.quantas.com.imaging.documentUpdate.GetDocumentsResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.GetSupportingContent;
/*      */ import ap.quantas.com.imaging.documentUpdate.GetSupportingContentResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.GetTargetApplication;
/*      */ import ap.quantas.com.imaging.documentUpdate.GetTargetApplicationResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.HasStatusChanged;
/*      */ import ap.quantas.com.imaging.documentUpdate.HasStatusChangedResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.ImagingFaultDetail;
/*      */ import ap.quantas.com.imaging.documentUpdate.ImagingFaultInfo;
/*      */ import ap.quantas.com.imaging.documentUpdate.LifecyclePolicy;
/*      */ import ap.quantas.com.imaging.documentUpdate.ListTargetApplications;
/*      */ import ap.quantas.com.imaging.documentUpdate.ListTargetApplicationsResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.LockDocument;
/*      */ import ap.quantas.com.imaging.documentUpdate.LockDocumentResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.ModifyPageOrder;
/*      */ import ap.quantas.com.imaging.documentUpdate.ModifyPageOrderResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.MoveDocument;
/*      */ import ap.quantas.com.imaging.documentUpdate.MoveDocumentResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.NameId;
/*      */ import ap.quantas.com.imaging.documentUpdate.PageChange;
/*      */ import ap.quantas.com.imaging.documentUpdate.PayloadItem;
/*      */ import ap.quantas.com.imaging.documentUpdate.SetAnnotations;
/*      */ import ap.quantas.com.imaging.documentUpdate.SetAnnotationsResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.SetSupportingContent;
/*      */ import ap.quantas.com.imaging.documentUpdate.SetSupportingContentResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.StorageStage;
/*      */ import ap.quantas.com.imaging.documentUpdate.SubmitToWorkflow;
/*      */ import ap.quantas.com.imaging.documentUpdate.SubmitToWorkflowResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.TypedValue;
/*      */ import ap.quantas.com.imaging.documentUpdate.UnlockDocument;
/*      */ import ap.quantas.com.imaging.documentUpdate.UnlockDocumentResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.UpdateDocument;
/*      */ import ap.quantas.com.imaging.documentUpdate.UpdateDocumentResponse;
/*      */ import ap.quantas.com.imaging.documentUpdate.ValidationError;
/*      */ import ap.quantas.com.imaging.documentUpdate.ValidationFaultInfo;
/*      */ import javax.xml.bind.JAXBElement;
/*      */ import javax.xml.bind.annotation.XmlElementDecl;
/*      */ import javax.xml.bind.annotation.XmlRegistry;
/*      */ import javax.xml.datatype.XMLGregorianCalendar;
/*      */ import javax.xml.namespace.QName;
/*      */ 
/*      */ @XmlRegistry
/*      */ public class ObjectFactory {
/*   28 */   private static final QName _PayloadItemValue_QNAME = new QName("", "value");
/*      */   
/*   29 */   private static final QName _DeleteDocumentResponse_QNAME = new QName("http://imaging.oracle/", "deleteDocumentResponse");
/*      */   
/*   30 */   private static final QName _GetTargetApplication_QNAME = new QName("http://imaging.oracle/", "getTargetApplication");
/*      */   
/*   31 */   private static final QName _GetDocuments_QNAME = new QName("http://imaging.oracle/", "getDocuments");
/*      */   
/*   32 */   private static final QName _GetTargetApplicationResponse_QNAME = new QName("http://imaging.oracle/", "getTargetApplicationResponse");
/*      */   
/*   33 */   private static final QName _DeleteDocuments_QNAME = new QName("http://imaging.oracle/", "deleteDocuments");
/*      */   
/*   34 */   private static final QName _NameId_QNAME = new QName("http://imaging.oracle/", "nameId");
/*      */   
/*   35 */   private static final QName _ValidationError_QNAME = new QName("http://imaging.oracle/", "ValidationError");
/*      */   
/*   36 */   private static final QName _ApplicationProperties_QNAME = new QName("http://imaging.oracle/", "ApplicationProperties");
/*      */   
/*   37 */   private static final QName _StoragePolicyItem_QNAME = new QName("http://imaging.oracle/", "StoragePolicyItem");
/*      */   
/*   38 */   private static final QName _ValidationException_QNAME = new QName("http://imaging.oracle/", "ValidationException");
/*      */   
/*   39 */   private static final QName _SetAnnotationsResponse_QNAME = new QName("http://imaging.oracle/", "setAnnotationsResponse");
/*      */   
/*   40 */   private static final QName _Application_QNAME = new QName("http://imaging.oracle/", "application");
/*      */   
/*   41 */   private static final QName _GetAnnotations_QNAME = new QName("http://imaging.oracle/", "getAnnotations");
/*      */   
/*   42 */   private static final QName _GetSupportingContentResponse_QNAME = new QName("http://imaging.oracle/", "getSupportingContentResponse");
/*      */   
/*   43 */   private static final QName _CopyDocument_QNAME = new QName("http://imaging.oracle/", "copyDocument");
/*      */   
/*   44 */   private static final QName _ListTargetApplicationsResponse_QNAME = new QName("http://imaging.oracle/", "listTargetApplicationsResponse");
/*      */   
/*   45 */   private static final QName _MoveDocument_QNAME = new QName("http://imaging.oracle/", "moveDocument");
/*      */   
/*   46 */   private static final QName _Document_QNAME = new QName("http://imaging.oracle/", "document");
/*      */   
/*   47 */   private static final QName _CreateDocument_QNAME = new QName("http://imaging.oracle/", "createDocument");
/*      */   
/*   48 */   private static final QName _UpdateDocumentResponse_QNAME = new QName("http://imaging.oracle/", "updateDocumentResponse");
/*      */   
/*   49 */   private static final QName _Security_QNAME = new QName("http://imaging.oracle/", "security");
/*      */   
/*   50 */   private static final QName _SetSupportingContentResponse_QNAME = new QName("http://imaging.oracle/", "setSupportingContentResponse");
/*      */   
/*   51 */   private static final QName _FieldDefinition_QNAME = new QName("http://imaging.oracle/", "FieldDefinition");
/*      */   
/*   52 */   private static final QName _SubmitToWorkflowResponse_QNAME = new QName("http://imaging.oracle/", "submitToWorkflowResponse");
/*      */   
/*   53 */   private static final QName _DeleteDocumentsResponse_QNAME = new QName("http://imaging.oracle/", "deleteDocumentsResponse");
/*      */   
/*   54 */   private static final QName _SetSupportingContent_QNAME = new QName("http://imaging.oracle/", "setSupportingContent");
/*      */   
/*   55 */   private static final QName _LockDocumentResponse_QNAME = new QName("http://imaging.oracle/", "lockDocumentResponse");
/*      */   
/*   56 */   private static final QName _BpelConfig_QNAME = new QName("http://imaging.oracle/", "BpelConfig");
/*      */   
/*   57 */   private static final QName _GetSupportingContent_QNAME = new QName("http://imaging.oracle/", "getSupportingContent");
/*      */   
/*   58 */   private static final QName _SectionSet_QNAME = new QName("http://imaging.oracle/", "sectionSet");
/*      */   
/*   59 */   private static final QName _LifecyclePolicy_QNAME = new QName("http://imaging.oracle/", "LifecyclePolicy");
/*      */   
/*   60 */   private static final QName _CopyDocumentResponse_QNAME = new QName("http://imaging.oracle/", "copyDocumentResponse");
/*      */   
/*   61 */   private static final QName _SubmitToWorkflow_QNAME = new QName("http://imaging.oracle/", "submitToWorkflow");
/*      */   
/*   62 */   private static final QName _GetDocumentsResponse_QNAME = new QName("http://imaging.oracle/", "getDocumentsResponse");
/*      */   
/*   63 */   private static final QName _GetDocumentVersionResponse_QNAME = new QName("http://imaging.oracle/", "getDocumentVersionResponse");
/*      */   
/*   64 */   private static final QName _HasStatusChanged_QNAME = new QName("http://imaging.oracle/", "hasStatusChanged");
/*      */   
/*   65 */   private static final QName _DocumentSecurity_QNAME = new QName("http://imaging.oracle/", "documentSecurity");
/*      */   
/*   66 */   private static final QName _SetAnnotations_QNAME = new QName("http://imaging.oracle/", "setAnnotations");
/*      */   
/*   67 */   private static final QName _MoveDocumentResponse_QNAME = new QName("http://imaging.oracle/", "moveDocumentResponse");
/*      */   
/*   68 */   private static final QName _UnlockDocumentResponse_QNAME = new QName("http://imaging.oracle/", "unlockDocumentResponse");
/*      */   
/*   69 */   private static final QName _HasStatusChangedResponse_QNAME = new QName("http://imaging.oracle/", "hasStatusChangedResponse");
/*      */   
/*   70 */   private static final QName _GetAnnotationsResponse_QNAME = new QName("http://imaging.oracle/", "getAnnotationsResponse");
/*      */   
/*   71 */   private static final QName _GetDocumentVersion_QNAME = new QName("http://imaging.oracle/", "getDocumentVersion");
/*      */   
/*   72 */   private static final QName _UpdateDocument_QNAME = new QName("http://imaging.oracle/", "updateDocument");
/*      */   
/*   73 */   private static final QName _ModifyPageOrderResponse_QNAME = new QName("http://imaging.oracle/", "modifyPageOrderResponse");
/*      */   
/*   74 */   private static final QName _LockDocument_QNAME = new QName("http://imaging.oracle/", "lockDocument");
/*      */   
/*   75 */   private static final QName _CreateDocumentResponse_QNAME = new QName("http://imaging.oracle/", "createDocumentResponse");
/*      */   
/*   76 */   private static final QName _GetDocument_QNAME = new QName("http://imaging.oracle/", "getDocument");
/*      */   
/*   77 */   private static final QName _ListTargetApplications_QNAME = new QName("http://imaging.oracle/", "listTargetApplications");
/*      */   
/*   78 */   private static final QName _DeleteDocument_QNAME = new QName("http://imaging.oracle/", "deleteDocument");
/*      */   
/*   79 */   private static final QName _ModifyPageOrder_QNAME = new QName("http://imaging.oracle/", "modifyPageOrder");
/*      */   
/*   80 */   private static final QName _UnlockDocument_QNAME = new QName("http://imaging.oracle/", "unlockDocument");
/*      */   
/*   81 */   private static final QName _GetDocumentResponse_QNAME = new QName("http://imaging.oracle/", "getDocumentResponse");
/*      */   
/*   82 */   private static final QName _ImagingException_QNAME = new QName("http://imaging.oracle/", "ImagingException");
/*      */   
/*   83 */   private static final QName _DocumentDocumentPermissions_QNAME = new QName("", "documentPermissions");
/*      */   
/*   84 */   private static final QName _DocumentProperties_QNAME = new QName("", "properties");
/*      */   
/*   85 */   private static final QName _DocumentFieldValues_QNAME = new QName("", "fieldValues");
/*      */   
/*   86 */   private static final QName _LifecyclePolicyStoragePolicy_QNAME = new QName("", "storagePolicy");
/*      */   
/*   87 */   private static final QName _FieldDefinitionPickList_QNAME = new QName("", "pickList");
/*      */   
/*   88 */   private static final QName _BpelConfigPayloadMapping_QNAME = new QName("", "payloadMapping");
/*      */   
/*   89 */   private static final QName _ApplicationBpelConfig_QNAME = new QName("", "bpelConfig");
/*      */   
/*   90 */   private static final QName _ApplicationLifecyclePolicy_QNAME = new QName("", "lifecyclePolicy");
/*      */   
/*   91 */   private static final QName _ApplicationDocumentSecurity_QNAME = new QName("", "documentSecurity");
/*      */   
/*   92 */   private static final QName _ApplicationApplicationPermissions_QNAME = new QName("", "applicationPermissions");
/*      */   
/*   93 */   private static final QName _ApplicationSecurity_QNAME = new QName("", "security");
/*      */   
/*   94 */   private static final QName _ApplicationApplicationProperties_QNAME = new QName("", "applicationProperties");
/*      */   
/*   95 */   private static final QName _DocumentPropertiesVolume_QNAME = new QName("", "volume");
/*      */   
/*   96 */   private static final QName _DocumentPropertiesVolumeDate_QNAME = new QName("", "volumeDate");
/*      */   
/*      */   public LifecyclePolicy.StoragePolicy createLifecyclePolicyStoragePolicy() {
/*  110 */     return new LifecyclePolicy.StoragePolicy();
/*      */   }
/*      */   
/*      */   public AuditEvent.Properties createAuditEventProperties() {
/*  118 */     return new AuditEvent.Properties();
/*      */   }
/*      */   
/*      */   public TypedValue createTypedValue() {
/*  126 */     return new TypedValue();
/*      */   }
/*      */   
/*      */   public GetDocuments createGetDocuments() {
/*  134 */     return new GetDocuments();
/*      */   }
/*      */   
/*      */   public BpelConfig createBpelConfig() {
/*  142 */     return new BpelConfig();
/*      */   }
/*      */   
/*      */   public GetDocumentVersion createGetDocumentVersion() {
/*  150 */     return new GetDocumentVersion();
/*      */   }
/*      */   
/*      */   public FieldDefinition.PickList createFieldDefinitionPickList() {
/*  158 */     return new FieldDefinition.PickList();
/*      */   }
/*      */   
/*      */   public ModifyPageOrderResponse createModifyPageOrderResponse() {
/*  166 */     return new ModifyPageOrderResponse();
/*      */   }
/*      */   
/*      */   public SetAnnotations createSetAnnotations() {
/*  174 */     return new SetAnnotations();
/*      */   }
/*      */   
/*      */   public DocumentSecurity createDocumentSecurity() {
/*  182 */     return new DocumentSecurity();
/*      */   }
/*      */   
/*      */   public ImagingFaultInfo createImagingFaultInfo() {
/*  190 */     return new ImagingFaultInfo();
/*      */   }
/*      */   
/*      */   public DocumentPermissions createDocumentPermissions() {
/*  198 */     return new DocumentPermissions();
/*      */   }
/*      */   
/*      */   public DocumentSectionSet createDocumentSectionSet() {
/*  206 */     return new DocumentSectionSet();
/*      */   }
/*      */   
/*      */   public GetDocumentsResponse createGetDocumentsResponse() {
/*  214 */     return new GetDocumentsResponse();
/*      */   }
/*      */   
/*      */   public SetSupportingContentResponse createSetSupportingContentResponse() {
/*  222 */     return new SetSupportingContentResponse();
/*      */   }
/*      */   
/*      */   public Document createDocument() {
/*  230 */     return new Document();
/*      */   }
/*      */   
/*      */   public CreateDocument createCreateDocument() {
/*  238 */     return new CreateDocument();
/*      */   }
/*      */   
/*      */   public Application.Security createApplicationSecurity() {
/*  246 */     return new Application.Security();
/*      */   }
/*      */   
/*      */   public LockDocument createLockDocument() {
/*  254 */     return new LockDocument();
/*      */   }
/*      */   
/*      */   public AuditEvent createAuditEvent() {
/*  262 */     return new AuditEvent();
/*      */   }
/*      */   
/*      */   public SubmitToWorkflow createSubmitToWorkflow() {
/*  270 */     return new SubmitToWorkflow();
/*      */   }
/*      */   
/*      */   public NameId createNameId() {
/*  278 */     return new NameId();
/*      */   }
/*      */   
/*      */   public StorageStage createStorageStage() {
/*  286 */     return new StorageStage();
/*      */   }
/*      */   
/*      */   public PayloadItem createPayloadItem() {
/*  294 */     return new PayloadItem();
/*      */   }
/*      */   
/*      */   public MoveDocument createMoveDocument() {
/*  302 */     return new MoveDocument();
/*      */   }
/*      */   
/*      */   public ListTargetApplications createListTargetApplications() {
/*  310 */     return new ListTargetApplications();
/*      */   }
/*      */   
/*      */   public MoveDocumentResponse createMoveDocumentResponse() {
/*  318 */     return new MoveDocumentResponse();
/*      */   }
/*      */   
/*      */   public DeleteDocumentsResponse createDeleteDocumentsResponse() {
/*  326 */     return new DeleteDocumentsResponse();
/*      */   }
/*      */   
/*      */   public LifecyclePolicy createLifecyclePolicy() {
/*  334 */     return new LifecyclePolicy();
/*      */   }
/*      */   
/*      */   public Application.DocumentSecurity createApplicationDocumentSecurity() {
/*  342 */     return new Application.DocumentSecurity();
/*      */   }
/*      */   
/*      */   public PageChange createPageChange() {
/*  350 */     return new PageChange();
/*      */   }
/*      */   
/*      */   public DeleteDocuments createDeleteDocuments() {
/*  358 */     return new DeleteDocuments();
/*      */   }
/*      */   
/*      */   public DeleteDocument createDeleteDocument() {
/*  366 */     return new DeleteDocument();
/*      */   }
/*      */   
/*      */   public GetTargetApplicationResponse createGetTargetApplicationResponse() {
/*  374 */     return new GetTargetApplicationResponse();
/*      */   }
/*      */   
/*      */   public ValidationFaultInfo createValidationFaultInfo() {
/*  382 */     return new ValidationFaultInfo();
/*      */   }
/*      */   
/*      */   public GetSupportingContent createGetSupportingContent() {
/*  390 */     return new GetSupportingContent();
/*      */   }
/*      */   
/*      */   public GetTargetApplication createGetTargetApplication() {
/*  398 */     return new GetTargetApplication();
/*      */   }
/*      */   
/*      */   public ValidationError createValidationError() {
/*  406 */     return new ValidationError();
/*      */   }
/*      */   
/*      */   public UnlockDocument createUnlockDocument() {
/*  414 */     return new UnlockDocument();
/*      */   }
/*      */   
/*      */   public UpdateDocument createUpdateDocument() {
/*  422 */     return new UpdateDocument();
/*      */   }
/*      */   
/*      */   public DocumentProperties createDocumentProperties() {
/*  430 */     return new DocumentProperties();
/*      */   }
/*      */   
/*      */   public CopyDocument createCopyDocument() {
/*  438 */     return new CopyDocument();
/*      */   }
/*      */   
/*      */   public ListTargetApplicationsResponse createListTargetApplicationsResponse() {
/*  446 */     return new ListTargetApplicationsResponse();
/*      */   }
/*      */   
/*      */   public ImagingFaultInfo.FaultDetails createImagingFaultInfoFaultDetails() {
/*  454 */     return new ImagingFaultInfo.FaultDetails();
/*      */   }
/*      */   
/*      */   public DeleteDocumentResponse createDeleteDocumentResponse() {
/*  462 */     return new DeleteDocumentResponse();
/*      */   }
/*      */   
/*      */   public LockDocumentResponse createLockDocumentResponse() {
/*  470 */     return new LockDocumentResponse();
/*      */   }
/*      */   
/*      */   public Document.FieldValues createDocumentFieldValues() {
/*  478 */     return new Document.FieldValues();
/*      */   }
/*      */   
/*      */   public Application.FieldDefinitions createApplicationFieldDefinitions() {
/*  486 */     return new Application.FieldDefinitions();
/*      */   }
/*      */   
/*      */   public DefinitionSecurity createDefinitionSecurity() {
/*  494 */     return new DefinitionSecurity();
/*      */   }
/*      */   
/*      */   public DefinitionPermissions createDefinitionPermissions() {
/*  502 */     return new DefinitionPermissions();
/*      */   }
/*      */   
/*      */   public CreateDocumentResponse createCreateDocumentResponse() {
/*  510 */     return new CreateDocumentResponse();
/*      */   }
/*      */   
/*      */   public CopyDocumentResponse createCopyDocumentResponse() {
/*  518 */     return new CopyDocumentResponse();
/*      */   }
/*      */   
/*      */   public Document.History createDocumentHistory() {
/*  526 */     return new Document.History();
/*      */   }
/*      */   
/*      */   public Application.History createApplicationHistory() {
/*  534 */     return new Application.History();
/*      */   }
/*      */   
/*      */   public BpelConfig.PayloadMapping createBpelConfigPayloadMapping() {
/*  542 */     return new BpelConfig.PayloadMapping();
/*      */   }
/*      */   
/*      */   public FieldDefinition createFieldDefinition() {
/*  550 */     return new FieldDefinition();
/*      */   }
/*      */   
/*      */   public GetDocumentResponse createGetDocumentResponse() {
/*  558 */     return new GetDocumentResponse();
/*      */   }
/*      */   
/*      */   public HasStatusChanged createHasStatusChanged() {
/*  566 */     return new HasStatusChanged();
/*      */   }
/*      */   
/*      */   public ApplicationProperties createApplicationProperties() {
/*  574 */     return new ApplicationProperties();
/*      */   }
/*      */   
/*      */   public GetSupportingContentResponse createGetSupportingContentResponse() {
/*  582 */     return new GetSupportingContentResponse();
/*      */   }
/*      */   
/*      */   public SubmitToWorkflowResponse createSubmitToWorkflowResponse() {
/*  590 */     return new SubmitToWorkflowResponse();
/*      */   }
/*      */   
/*      */   public UnlockDocumentResponse createUnlockDocumentResponse() {
/*  598 */     return new UnlockDocumentResponse();
/*      */   }
/*      */   
/*      */   public HasStatusChangedResponse createHasStatusChangedResponse() {
/*  606 */     return new HasStatusChangedResponse();
/*      */   }
/*      */   
/*      */   public SetAnnotationsResponse createSetAnnotationsResponse() {
/*  614 */     return new SetAnnotationsResponse();
/*      */   }
/*      */   
/*      */   public ImagingFaultDetail createImagingFaultDetail() {
/*  622 */     return new ImagingFaultDetail();
/*      */   }
/*      */   
/*      */   public GetDocument createGetDocument() {
/*  630 */     return new GetDocument();
/*      */   }
/*      */   
/*      */   public UpdateDocumentResponse createUpdateDocumentResponse() {
/*  638 */     return new UpdateDocumentResponse();
/*      */   }
/*      */   
/*      */   public FieldValue createFieldValue() {
/*  646 */     return new FieldValue();
/*      */   }
/*      */   
/*      */   public SetSupportingContent createSetSupportingContent() {
/*  654 */     return new SetSupportingContent();
/*      */   }
/*      */   
/*      */   public GetDocumentVersionResponse createGetDocumentVersionResponse() {
/*  662 */     return new GetDocumentVersionResponse();
/*      */   }
/*      */   
/*      */   public GetAnnotationsResponse createGetAnnotationsResponse() {
/*  670 */     return new GetAnnotationsResponse();
/*      */   }
/*      */   
/*      */   public ModifyPageOrder createModifyPageOrder() {
/*  678 */     return new ModifyPageOrder();
/*      */   }
/*      */   
/*      */   public Application createApplication() {
/*  686 */     return new Application();
/*      */   }
/*      */   
/*      */   public GetAnnotations createGetAnnotations() {
/*  694 */     return new GetAnnotations();
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "value", scope = PayloadItem.class)
/*      */   public JAXBElement<String> createPayloadItemValue(String value) {
/*  703 */     return new JAXBElement<String>(_PayloadItemValue_QNAME, String.class, PayloadItem.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "deleteDocumentResponse")
/*      */   public JAXBElement<DeleteDocumentResponse> createDeleteDocumentResponse(DeleteDocumentResponse value) {
/*  712 */     return new JAXBElement<DeleteDocumentResponse>(_DeleteDocumentResponse_QNAME, DeleteDocumentResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getTargetApplication")
/*      */   public JAXBElement<GetTargetApplication> createGetTargetApplication(GetTargetApplication value) {
/*  721 */     return new JAXBElement<GetTargetApplication>(_GetTargetApplication_QNAME, GetTargetApplication.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getDocuments")
/*      */   public JAXBElement<GetDocuments> createGetDocuments(GetDocuments value) {
/*  730 */     return new JAXBElement<GetDocuments>(_GetDocuments_QNAME, GetDocuments.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getTargetApplicationResponse")
/*      */   public JAXBElement<GetTargetApplicationResponse> createGetTargetApplicationResponse(GetTargetApplicationResponse value) {
/*  739 */     return new JAXBElement<GetTargetApplicationResponse>(_GetTargetApplicationResponse_QNAME, GetTargetApplicationResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "deleteDocuments")
/*      */   public JAXBElement<DeleteDocuments> createDeleteDocuments(DeleteDocuments value) {
/*  748 */     return new JAXBElement<DeleteDocuments>(_DeleteDocuments_QNAME, DeleteDocuments.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "nameId")
/*      */   public JAXBElement<NameId> createNameId(NameId value) {
/*  757 */     return new JAXBElement<NameId>(_NameId_QNAME, NameId.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ValidationError")
/*      */   public JAXBElement<ValidationError> createValidationError(ValidationError value) {
/*  766 */     return new JAXBElement<ValidationError>(_ValidationError_QNAME, ValidationError.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ApplicationProperties")
/*      */   public JAXBElement<ApplicationProperties> createApplicationProperties(ApplicationProperties value) {
/*  775 */     return new JAXBElement<ApplicationProperties>(_ApplicationProperties_QNAME, ApplicationProperties.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "StoragePolicyItem")
/*      */   public JAXBElement<StorageStage> createStoragePolicyItem(StorageStage value) {
/*  784 */     return new JAXBElement<StorageStage>(_StoragePolicyItem_QNAME, StorageStage.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ValidationException")
/*      */   public JAXBElement<ValidationFaultInfo> createValidationException(ValidationFaultInfo value) {
/*  793 */     return new JAXBElement<ValidationFaultInfo>(_ValidationException_QNAME, ValidationFaultInfo.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "setAnnotationsResponse")
/*      */   public JAXBElement<SetAnnotationsResponse> createSetAnnotationsResponse(SetAnnotationsResponse value) {
/*  802 */     return new JAXBElement<SetAnnotationsResponse>(_SetAnnotationsResponse_QNAME, SetAnnotationsResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "application")
/*      */   public JAXBElement<Application> createApplication(Application value) {
/*  811 */     return new JAXBElement<Application>(_Application_QNAME, Application.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getAnnotations")
/*      */   public JAXBElement<GetAnnotations> createGetAnnotations(GetAnnotations value) {
/*  820 */     return new JAXBElement<GetAnnotations>(_GetAnnotations_QNAME, GetAnnotations.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSupportingContentResponse")
/*      */   public JAXBElement<GetSupportingContentResponse> createGetSupportingContentResponse(GetSupportingContentResponse value) {
/*  829 */     return new JAXBElement<GetSupportingContentResponse>(_GetSupportingContentResponse_QNAME, GetSupportingContentResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "copyDocument")
/*      */   public JAXBElement<CopyDocument> createCopyDocument(CopyDocument value) {
/*  838 */     return new JAXBElement<CopyDocument>(_CopyDocument_QNAME, CopyDocument.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "listTargetApplicationsResponse")
/*      */   public JAXBElement<ListTargetApplicationsResponse> createListTargetApplicationsResponse(ListTargetApplicationsResponse value) {
/*  847 */     return new JAXBElement<ListTargetApplicationsResponse>(_ListTargetApplicationsResponse_QNAME, ListTargetApplicationsResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "moveDocument")
/*      */   public JAXBElement<MoveDocument> createMoveDocument(MoveDocument value) {
/*  856 */     return new JAXBElement<MoveDocument>(_MoveDocument_QNAME, MoveDocument.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "document")
/*      */   public JAXBElement<Document> createDocument(Document value) {
/*  865 */     return new JAXBElement<Document>(_Document_QNAME, Document.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "createDocument")
/*      */   public JAXBElement<CreateDocument> createCreateDocument(CreateDocument value) {
/*  874 */     return new JAXBElement<CreateDocument>(_CreateDocument_QNAME, CreateDocument.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "updateDocumentResponse")
/*      */   public JAXBElement<UpdateDocumentResponse> createUpdateDocumentResponse(UpdateDocumentResponse value) {
/*  883 */     return new JAXBElement<UpdateDocumentResponse>(_UpdateDocumentResponse_QNAME, UpdateDocumentResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "security")
/*      */   public JAXBElement<DefinitionSecurity> createSecurity(DefinitionSecurity value) {
/*  892 */     return new JAXBElement<DefinitionSecurity>(_Security_QNAME, DefinitionSecurity.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "setSupportingContentResponse")
/*      */   public JAXBElement<SetSupportingContentResponse> createSetSupportingContentResponse(SetSupportingContentResponse value) {
/*  901 */     return new JAXBElement<SetSupportingContentResponse>(_SetSupportingContentResponse_QNAME, SetSupportingContentResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "FieldDefinition")
/*      */   public JAXBElement<FieldDefinition> createFieldDefinition(FieldDefinition value) {
/*  910 */     return new JAXBElement<FieldDefinition>(_FieldDefinition_QNAME, FieldDefinition.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "submitToWorkflowResponse")
/*      */   public JAXBElement<SubmitToWorkflowResponse> createSubmitToWorkflowResponse(SubmitToWorkflowResponse value) {
/*  919 */     return new JAXBElement<SubmitToWorkflowResponse>(_SubmitToWorkflowResponse_QNAME, SubmitToWorkflowResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "deleteDocumentsResponse")
/*      */   public JAXBElement<DeleteDocumentsResponse> createDeleteDocumentsResponse(DeleteDocumentsResponse value) {
/*  928 */     return new JAXBElement<DeleteDocumentsResponse>(_DeleteDocumentsResponse_QNAME, DeleteDocumentsResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "setSupportingContent")
/*      */   public JAXBElement<SetSupportingContent> createSetSupportingContent(SetSupportingContent value) {
/*  937 */     return new JAXBElement<SetSupportingContent>(_SetSupportingContent_QNAME, SetSupportingContent.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "lockDocumentResponse")
/*      */   public JAXBElement<LockDocumentResponse> createLockDocumentResponse(LockDocumentResponse value) {
/*  946 */     return new JAXBElement<LockDocumentResponse>(_LockDocumentResponse_QNAME, LockDocumentResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "BpelConfig")
/*      */   public JAXBElement<BpelConfig> createBpelConfig(BpelConfig value) {
/*  955 */     return new JAXBElement<BpelConfig>(_BpelConfig_QNAME, BpelConfig.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSupportingContent")
/*      */   public JAXBElement<GetSupportingContent> createGetSupportingContent(GetSupportingContent value) {
/*  964 */     return new JAXBElement<GetSupportingContent>(_GetSupportingContent_QNAME, GetSupportingContent.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "sectionSet")
/*      */   public JAXBElement<DocumentSectionSet> createSectionSet(DocumentSectionSet value) {
/*  973 */     return new JAXBElement<DocumentSectionSet>(_SectionSet_QNAME, DocumentSectionSet.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "LifecyclePolicy")
/*      */   public JAXBElement<LifecyclePolicy> createLifecyclePolicy(LifecyclePolicy value) {
/*  982 */     return new JAXBElement<LifecyclePolicy>(_LifecyclePolicy_QNAME, LifecyclePolicy.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "copyDocumentResponse")
/*      */   public JAXBElement<CopyDocumentResponse> createCopyDocumentResponse(CopyDocumentResponse value) {
/*  991 */     return new JAXBElement<CopyDocumentResponse>(_CopyDocumentResponse_QNAME, CopyDocumentResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "submitToWorkflow")
/*      */   public JAXBElement<SubmitToWorkflow> createSubmitToWorkflow(SubmitToWorkflow value) {
/* 1000 */     return new JAXBElement<SubmitToWorkflow>(_SubmitToWorkflow_QNAME, SubmitToWorkflow.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getDocumentsResponse")
/*      */   public JAXBElement<GetDocumentsResponse> createGetDocumentsResponse(GetDocumentsResponse value) {
/* 1009 */     return new JAXBElement<GetDocumentsResponse>(_GetDocumentsResponse_QNAME, GetDocumentsResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getDocumentVersionResponse")
/*      */   public JAXBElement<GetDocumentVersionResponse> createGetDocumentVersionResponse(GetDocumentVersionResponse value) {
/* 1018 */     return new JAXBElement<GetDocumentVersionResponse>(_GetDocumentVersionResponse_QNAME, GetDocumentVersionResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "hasStatusChanged")
/*      */   public JAXBElement<HasStatusChanged> createHasStatusChanged(HasStatusChanged value) {
/* 1027 */     return new JAXBElement<HasStatusChanged>(_HasStatusChanged_QNAME, HasStatusChanged.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "documentSecurity")
/*      */   public JAXBElement<DocumentSecurity> createDocumentSecurity(DocumentSecurity value) {
/* 1036 */     return new JAXBElement<DocumentSecurity>(_DocumentSecurity_QNAME, DocumentSecurity.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "setAnnotations")
/*      */   public JAXBElement<SetAnnotations> createSetAnnotations(SetAnnotations value) {
/* 1045 */     return new JAXBElement<SetAnnotations>(_SetAnnotations_QNAME, SetAnnotations.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "moveDocumentResponse")
/*      */   public JAXBElement<MoveDocumentResponse> createMoveDocumentResponse(MoveDocumentResponse value) {
/* 1054 */     return new JAXBElement<MoveDocumentResponse>(_MoveDocumentResponse_QNAME, MoveDocumentResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "unlockDocumentResponse")
/*      */   public JAXBElement<UnlockDocumentResponse> createUnlockDocumentResponse(UnlockDocumentResponse value) {
/* 1063 */     return new JAXBElement<UnlockDocumentResponse>(_UnlockDocumentResponse_QNAME, UnlockDocumentResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "hasStatusChangedResponse")
/*      */   public JAXBElement<HasStatusChangedResponse> createHasStatusChangedResponse(HasStatusChangedResponse value) {
/* 1072 */     return new JAXBElement<HasStatusChangedResponse>(_HasStatusChangedResponse_QNAME, HasStatusChangedResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getAnnotationsResponse")
/*      */   public JAXBElement<GetAnnotationsResponse> createGetAnnotationsResponse(GetAnnotationsResponse value) {
/* 1081 */     return new JAXBElement<GetAnnotationsResponse>(_GetAnnotationsResponse_QNAME, GetAnnotationsResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getDocumentVersion")
/*      */   public JAXBElement<GetDocumentVersion> createGetDocumentVersion(GetDocumentVersion value) {
/* 1090 */     return new JAXBElement<GetDocumentVersion>(_GetDocumentVersion_QNAME, GetDocumentVersion.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "updateDocument")
/*      */   public JAXBElement<UpdateDocument> createUpdateDocument(UpdateDocument value) {
/* 1099 */     return new JAXBElement<UpdateDocument>(_UpdateDocument_QNAME, UpdateDocument.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "modifyPageOrderResponse")
/*      */   public JAXBElement<ModifyPageOrderResponse> createModifyPageOrderResponse(ModifyPageOrderResponse value) {
/* 1108 */     return new JAXBElement<ModifyPageOrderResponse>(_ModifyPageOrderResponse_QNAME, ModifyPageOrderResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "lockDocument")
/*      */   public JAXBElement<LockDocument> createLockDocument(LockDocument value) {
/* 1117 */     return new JAXBElement<LockDocument>(_LockDocument_QNAME, LockDocument.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "createDocumentResponse")
/*      */   public JAXBElement<CreateDocumentResponse> createCreateDocumentResponse(CreateDocumentResponse value) {
/* 1126 */     return new JAXBElement<CreateDocumentResponse>(_CreateDocumentResponse_QNAME, CreateDocumentResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getDocument")
/*      */   public JAXBElement<GetDocument> createGetDocument(GetDocument value) {
/* 1135 */     return new JAXBElement<GetDocument>(_GetDocument_QNAME, GetDocument.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "listTargetApplications")
/*      */   public JAXBElement<ListTargetApplications> createListTargetApplications(ListTargetApplications value) {
/* 1144 */     return new JAXBElement<ListTargetApplications>(_ListTargetApplications_QNAME, ListTargetApplications.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "deleteDocument")
/*      */   public JAXBElement<DeleteDocument> createDeleteDocument(DeleteDocument value) {
/* 1153 */     return new JAXBElement<DeleteDocument>(_DeleteDocument_QNAME, DeleteDocument.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "modifyPageOrder")
/*      */   public JAXBElement<ModifyPageOrder> createModifyPageOrder(ModifyPageOrder value) {
/* 1162 */     return new JAXBElement<ModifyPageOrder>(_ModifyPageOrder_QNAME, ModifyPageOrder.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "unlockDocument")
/*      */   public JAXBElement<UnlockDocument> createUnlockDocument(UnlockDocument value) {
/* 1171 */     return new JAXBElement<UnlockDocument>(_UnlockDocument_QNAME, UnlockDocument.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getDocumentResponse")
/*      */   public JAXBElement<GetDocumentResponse> createGetDocumentResponse(GetDocumentResponse value) {
/* 1180 */     return new JAXBElement<GetDocumentResponse>(_GetDocumentResponse_QNAME, GetDocumentResponse.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ImagingException")
/*      */   public JAXBElement<ImagingFaultInfo> createImagingException(ImagingFaultInfo value) {
/* 1189 */     return new JAXBElement<ImagingFaultInfo>(_ImagingException_QNAME, ImagingFaultInfo.class, null, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "documentPermissions", scope = Document.class)
/*      */   public JAXBElement<DocumentPermissions> createDocumentDocumentPermissions(DocumentPermissions value) {
/* 1198 */     return new JAXBElement<DocumentPermissions>(_DocumentDocumentPermissions_QNAME, DocumentPermissions.class, Document.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "properties", scope = Document.class)
/*      */   public JAXBElement<DocumentProperties> createDocumentProperties(DocumentProperties value) {
/* 1207 */     return new JAXBElement<DocumentProperties>(_DocumentProperties_QNAME, DocumentProperties.class, Document.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "fieldValues", scope = Document.class)
/*      */   public JAXBElement<Document.FieldValues> createDocumentFieldValues(Document.FieldValues value) {
/* 1216 */     return new JAXBElement<Document.FieldValues>(_DocumentFieldValues_QNAME, Document.FieldValues.class, Document.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "storagePolicy", scope = LifecyclePolicy.class)
/*      */   public JAXBElement<LifecyclePolicy.StoragePolicy> createLifecyclePolicyStoragePolicy(LifecyclePolicy.StoragePolicy value) {
/* 1225 */     return new JAXBElement<LifecyclePolicy.StoragePolicy>(_LifecyclePolicyStoragePolicy_QNAME, LifecyclePolicy.StoragePolicy.class, LifecyclePolicy.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "pickList", scope = FieldDefinition.class)
/*      */   public JAXBElement<FieldDefinition.PickList> createFieldDefinitionPickList(FieldDefinition.PickList value) {
/* 1234 */     return new JAXBElement<FieldDefinition.PickList>(_FieldDefinitionPickList_QNAME, FieldDefinition.PickList.class, FieldDefinition.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "payloadMapping", scope = BpelConfig.class)
/*      */   public JAXBElement<BpelConfig.PayloadMapping> createBpelConfigPayloadMapping(BpelConfig.PayloadMapping value) {
/* 1243 */     return new JAXBElement<BpelConfig.PayloadMapping>(_BpelConfigPayloadMapping_QNAME, BpelConfig.PayloadMapping.class, BpelConfig.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "bpelConfig", scope = Application.class)
/*      */   public JAXBElement<BpelConfig> createApplicationBpelConfig(BpelConfig value) {
/* 1252 */     return new JAXBElement<BpelConfig>(_ApplicationBpelConfig_QNAME, BpelConfig.class, Application.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "lifecyclePolicy", scope = Application.class)
/*      */   public JAXBElement<LifecyclePolicy> createApplicationLifecyclePolicy(LifecyclePolicy value) {
/* 1261 */     return new JAXBElement<LifecyclePolicy>(_ApplicationLifecyclePolicy_QNAME, LifecyclePolicy.class, Application.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "documentPermissions", scope = Application.class)
/*      */   public JAXBElement<DocumentPermissions> createApplicationDocumentPermissions(DocumentPermissions value) {
/* 1270 */     return new JAXBElement<DocumentPermissions>(_DocumentDocumentPermissions_QNAME, DocumentPermissions.class, Application.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "documentSecurity", scope = Application.class)
/*      */   public JAXBElement<Application.DocumentSecurity> createApplicationDocumentSecurity(Application.DocumentSecurity value) {
/* 1279 */     return new JAXBElement<Application.DocumentSecurity>(_ApplicationDocumentSecurity_QNAME, Application.DocumentSecurity.class, Application.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "applicationPermissions", scope = Application.class)
/*      */   public JAXBElement<DefinitionPermissions> createApplicationApplicationPermissions(DefinitionPermissions value) {
/* 1288 */     return new JAXBElement<DefinitionPermissions>(_ApplicationApplicationPermissions_QNAME, DefinitionPermissions.class, Application.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "security", scope = Application.class)
/*      */   public JAXBElement<Application.Security> createApplicationSecurity(Application.Security value) {
/* 1297 */     return new JAXBElement<Application.Security>(_ApplicationSecurity_QNAME, Application.Security.class, Application.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "applicationProperties", scope = Application.class)
/*      */   public JAXBElement<ApplicationProperties> createApplicationApplicationProperties(ApplicationProperties value) {
/* 1306 */     return new JAXBElement<ApplicationProperties>(_ApplicationApplicationProperties_QNAME, ApplicationProperties.class, Application.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "volume", scope = DocumentProperties.class)
/*      */   public JAXBElement<String> createDocumentPropertiesVolume(String value) {
/* 1315 */     return new JAXBElement<String>(_DocumentPropertiesVolume_QNAME, String.class, DocumentProperties.class, value);
/*      */   }
/*      */   
/*      */   @XmlElementDecl(namespace = "", name = "volumeDate", scope = DocumentProperties.class)
/*      */   public JAXBElement<XMLGregorianCalendar> createDocumentPropertiesVolumeDate(XMLGregorianCalendar value) {
/* 1324 */     return new JAXBElement<XMLGregorianCalendar>(_DocumentPropertiesVolumeDate_QNAME, XMLGregorianCalendar.class, DocumentProperties.class, value);
/*      */   }
/*      */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentUpdate\ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */