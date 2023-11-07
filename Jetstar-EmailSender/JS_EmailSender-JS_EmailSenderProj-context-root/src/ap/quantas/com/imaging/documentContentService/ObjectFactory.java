/*     */ package ap.quantas.com.imaging.documentContentService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentContentService.AuditEvent;
/*     */ import ap.quantas.com.imaging.documentContentService.Document;
/*     */ import ap.quantas.com.imaging.documentContentService.DocumentPermissions;
/*     */ import ap.quantas.com.imaging.documentContentService.DocumentProperties;
/*     */ import ap.quantas.com.imaging.documentContentService.FieldValue;
/*     */ import ap.quantas.com.imaging.documentContentService.ImagingFaultDetail;
/*     */ import ap.quantas.com.imaging.documentContentService.ImagingFaultInfo;
/*     */ import ap.quantas.com.imaging.documentContentService.RenderBoundRect;
/*     */ import ap.quantas.com.imaging.documentContentService.RenderOptions;
/*     */ import ap.quantas.com.imaging.documentContentService.RenderPage;
/*     */ import ap.quantas.com.imaging.documentContentService.RenderResult;
/*     */ import ap.quantas.com.imaging.documentContentService.Rendition;
/*     */ import ap.quantas.com.imaging.documentContentService.Retrieve;
/*     */ import ap.quantas.com.imaging.documentContentService.RetrievePage;
/*     */ import ap.quantas.com.imaging.documentContentService.RetrievePageResponse;
/*     */ import ap.quantas.com.imaging.documentContentService.RetrieveRendition;
/*     */ import ap.quantas.com.imaging.documentContentService.RetrieveRenditionResponse;
/*     */ import ap.quantas.com.imaging.documentContentService.RetrieveResponse;
/*     */ import ap.quantas.com.imaging.documentContentService.RetrieveVersion;
/*     */ import ap.quantas.com.imaging.documentContentService.RetrieveVersionPage;
/*     */ import ap.quantas.com.imaging.documentContentService.RetrieveVersionPageResponse;
/*     */ import ap.quantas.com.imaging.documentContentService.RetrieveVersionRendition;
/*     */ import ap.quantas.com.imaging.documentContentService.RetrieveVersionRenditionResponse;
/*     */ import ap.quantas.com.imaging.documentContentService.RetrieveVersionResponse;
/*     */ import ap.quantas.com.imaging.documentContentService.TypedValue;
/*     */ import ap.quantas.com.imaging.documentContentService.UploadDocument;
/*     */ import ap.quantas.com.imaging.documentContentService.UploadDocumentResponse;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlElementDecl;
/*     */ import javax.xml.bind.annotation.XmlRegistry;
/*     */ import javax.xml.datatype.XMLGregorianCalendar;
/*     */ import javax.xml.namespace.QName;
/*     */ 
/*     */ @XmlRegistry
/*     */ public class ObjectFactory {
/*  28 */   private static final QName _DocumentDocumentPermissions_QNAME = new QName("", "documentPermissions");
/*     */   
/*  29 */   private static final QName _DocumentProperties_QNAME = new QName("", "properties");
/*     */   
/*  30 */   private static final QName _DocumentFieldValues_QNAME = new QName("", "fieldValues");
/*     */   
/*  31 */   private static final QName _RetrieveVersion_QNAME = new QName("http://imaging.oracle/", "retrieveVersion");
/*     */   
/*  32 */   private static final QName _Retrieve_QNAME = new QName("http://imaging.oracle/", "retrieve");
/*     */   
/*  33 */   private static final QName _RetrieveRendition_QNAME = new QName("http://imaging.oracle/", "retrieveRendition");
/*     */   
/*  34 */   private static final QName _RenderPage_QNAME = new QName("http://imaging.oracle/", "RenderPage");
/*     */   
/*  35 */   private static final QName _RenderOptions_QNAME = new QName("http://imaging.oracle/", "RenderOptions");
/*     */   
/*  36 */   private static final QName _Document_QNAME = new QName("http://imaging.oracle/", "document");
/*     */   
/*  37 */   private static final QName _RetrieveRenditionResponse_QNAME = new QName("http://imaging.oracle/", "retrieveRenditionResponse");
/*     */   
/*  38 */   private static final QName _RetrieveVersionRendition_QNAME = new QName("http://imaging.oracle/", "retrieveVersionRendition");
/*     */   
/*  39 */   private static final QName _UploadDocumentResponse_QNAME = new QName("http://imaging.oracle/", "uploadDocumentResponse");
/*     */   
/*  40 */   private static final QName _RetrieveVersionResponse_QNAME = new QName("http://imaging.oracle/", "retrieveVersionResponse");
/*     */   
/*  41 */   private static final QName _UploadDocument_QNAME = new QName("http://imaging.oracle/", "uploadDocument");
/*     */   
/*  42 */   private static final QName _Rendition_QNAME = new QName("http://imaging.oracle/", "Rendition");
/*     */   
/*  43 */   private static final QName _RetrieveResponse_QNAME = new QName("http://imaging.oracle/", "retrieveResponse");
/*     */   
/*  44 */   private static final QName _RetrieveVersionPageResponse_QNAME = new QName("http://imaging.oracle/", "retrieveVersionPageResponse");
/*     */   
/*  45 */   private static final QName _RetrievePageResponse_QNAME = new QName("http://imaging.oracle/", "retrievePageResponse");
/*     */   
/*  46 */   private static final QName _RenderResult_QNAME = new QName("http://imaging.oracle/", "RenderResult");
/*     */   
/*  47 */   private static final QName _RetrievePage_QNAME = new QName("http://imaging.oracle/", "retrievePage");
/*     */   
/*  48 */   private static final QName _RetrieveVersionPage_QNAME = new QName("http://imaging.oracle/", "retrieveVersionPage");
/*     */   
/*  49 */   private static final QName _RetrieveVersionRenditionResponse_QNAME = new QName("http://imaging.oracle/", "retrieveVersionRenditionResponse");
/*     */   
/*  50 */   private static final QName _ImagingException_QNAME = new QName("http://imaging.oracle/", "ImagingException");
/*     */   
/*  51 */   private static final QName _DocumentPropertiesVolume_QNAME = new QName("", "volume");
/*     */   
/*  52 */   private static final QName _DocumentPropertiesVolumeDate_QNAME = new QName("", "volumeDate");
/*     */   
/*     */   public RetrieveVersionRendition createRetrieveVersionRendition() {
/*  66 */     return new RetrieveVersionRendition();
/*     */   }
/*     */   
/*     */   public RetrieveRendition createRetrieveRendition() {
/*  74 */     return new RetrieveRendition();
/*     */   }
/*     */   
/*     */   public RenderPage createRenderPage() {
/*  82 */     return new RenderPage();
/*     */   }
/*     */   
/*     */   public RetrieveVersionPageResponse createRetrieveVersionPageResponse() {
/*  90 */     return new RetrieveVersionPageResponse();
/*     */   }
/*     */   
/*     */   public FieldValue createFieldValue() {
/*  98 */     return new FieldValue();
/*     */   }
/*     */   
/*     */   public ImagingFaultInfo createImagingFaultInfo() {
/* 106 */     return new ImagingFaultInfo();
/*     */   }
/*     */   
/*     */   public RetrievePage createRetrievePage() {
/* 114 */     return new RetrievePage();
/*     */   }
/*     */   
/*     */   public Document createDocument() {
/* 122 */     return new Document();
/*     */   }
/*     */   
/*     */   public ImagingFaultInfo.FaultDetails createImagingFaultInfoFaultDetails() {
/* 130 */     return new ImagingFaultInfo.FaultDetails();
/*     */   }
/*     */   
/*     */   public RetrieveRenditionResponse createRetrieveRenditionResponse() {
/* 138 */     return new RetrieveRenditionResponse();
/*     */   }
/*     */   
/*     */   public RetrieveVersion createRetrieveVersion() {
/* 146 */     return new RetrieveVersion();
/*     */   }
/*     */   
/*     */   public RetrieveVersionResponse createRetrieveVersionResponse() {
/* 154 */     return new RetrieveVersionResponse();
/*     */   }
/*     */   
/*     */   public DocumentPermissions createDocumentPermissions() {
/* 162 */     return new DocumentPermissions();
/*     */   }
/*     */   
/*     */   public Rendition createRendition() {
/* 170 */     return new Rendition();
/*     */   }
/*     */   
/*     */   public DocumentProperties createDocumentProperties() {
/* 178 */     return new DocumentProperties();
/*     */   }
/*     */   
/*     */   public AuditEvent createAuditEvent() {
/* 186 */     return new AuditEvent();
/*     */   }
/*     */   
/*     */   public Document.History createDocumentHistory() {
/* 194 */     return new Document.History();
/*     */   }
/*     */   
/*     */   public RetrieveVersionRenditionResponse createRetrieveVersionRenditionResponse() {
/* 202 */     return new RetrieveVersionRenditionResponse();
/*     */   }
/*     */   
/*     */   public RenderBoundRect createRenderBoundRect() {
/* 210 */     return new RenderBoundRect();
/*     */   }
/*     */   
/*     */   public UploadDocument createUploadDocument() {
/* 218 */     return new UploadDocument();
/*     */   }
/*     */   
/*     */   public TypedValue createTypedValue() {
/* 226 */     return new TypedValue();
/*     */   }
/*     */   
/*     */   public Retrieve createRetrieve() {
/* 234 */     return new Retrieve();
/*     */   }
/*     */   
/*     */   public Document.FieldValues createDocumentFieldValues() {
/* 242 */     return new Document.FieldValues();
/*     */   }
/*     */   
/*     */   public AuditEvent.Properties createAuditEventProperties() {
/* 250 */     return new AuditEvent.Properties();
/*     */   }
/*     */   
/*     */   public UploadDocumentResponse createUploadDocumentResponse() {
/* 258 */     return new UploadDocumentResponse();
/*     */   }
/*     */   
/*     */   public RetrieveVersionPage createRetrieveVersionPage() {
/* 266 */     return new RetrieveVersionPage();
/*     */   }
/*     */   
/*     */   public RenderOptions createRenderOptions() {
/* 274 */     return new RenderOptions();
/*     */   }
/*     */   
/*     */   public RetrieveResponse createRetrieveResponse() {
/* 282 */     return new RetrieveResponse();
/*     */   }
/*     */   
/*     */   public RetrievePageResponse createRetrievePageResponse() {
/* 290 */     return new RetrievePageResponse();
/*     */   }
/*     */   
/*     */   public ImagingFaultDetail createImagingFaultDetail() {
/* 298 */     return new ImagingFaultDetail();
/*     */   }
/*     */   
/*     */   public RenderResult createRenderResult() {
/* 306 */     return new RenderResult();
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "documentPermissions", scope = Document.class)
/*     */   public JAXBElement<DocumentPermissions> createDocumentDocumentPermissions(DocumentPermissions value) {
/* 315 */     return new JAXBElement<DocumentPermissions>(_DocumentDocumentPermissions_QNAME, DocumentPermissions.class, Document.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "properties", scope = Document.class)
/*     */   public JAXBElement<DocumentProperties> createDocumentProperties(DocumentProperties value) {
/* 324 */     return new JAXBElement<DocumentProperties>(_DocumentProperties_QNAME, DocumentProperties.class, Document.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "fieldValues", scope = Document.class)
/*     */   public JAXBElement<Document.FieldValues> createDocumentFieldValues(Document.FieldValues value) {
/* 333 */     return new JAXBElement<Document.FieldValues>(_DocumentFieldValues_QNAME, Document.FieldValues.class, Document.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "retrieveVersion")
/*     */   public JAXBElement<RetrieveVersion> createRetrieveVersion(RetrieveVersion value) {
/* 342 */     return new JAXBElement<RetrieveVersion>(_RetrieveVersion_QNAME, RetrieveVersion.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "retrieve")
/*     */   public JAXBElement<Retrieve> createRetrieve(Retrieve value) {
/* 351 */     return new JAXBElement<Retrieve>(_Retrieve_QNAME, Retrieve.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "retrieveRendition")
/*     */   public JAXBElement<RetrieveRendition> createRetrieveRendition(RetrieveRendition value) {
/* 360 */     return new JAXBElement<RetrieveRendition>(_RetrieveRendition_QNAME, RetrieveRendition.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "RenderPage")
/*     */   public JAXBElement<RenderPage> createRenderPage(RenderPage value) {
/* 369 */     return new JAXBElement<RenderPage>(_RenderPage_QNAME, RenderPage.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "RenderOptions")
/*     */   public JAXBElement<RenderOptions> createRenderOptions(RenderOptions value) {
/* 378 */     return new JAXBElement<RenderOptions>(_RenderOptions_QNAME, RenderOptions.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "document")
/*     */   public JAXBElement<Document> createDocument(Document value) {
/* 387 */     return new JAXBElement<Document>(_Document_QNAME, Document.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "retrieveRenditionResponse")
/*     */   public JAXBElement<RetrieveRenditionResponse> createRetrieveRenditionResponse(RetrieveRenditionResponse value) {
/* 396 */     return new JAXBElement<RetrieveRenditionResponse>(_RetrieveRenditionResponse_QNAME, RetrieveRenditionResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "retrieveVersionRendition")
/*     */   public JAXBElement<RetrieveVersionRendition> createRetrieveVersionRendition(RetrieveVersionRendition value) {
/* 405 */     return new JAXBElement<RetrieveVersionRendition>(_RetrieveVersionRendition_QNAME, RetrieveVersionRendition.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "uploadDocumentResponse")
/*     */   public JAXBElement<UploadDocumentResponse> createUploadDocumentResponse(UploadDocumentResponse value) {
/* 414 */     return new JAXBElement<UploadDocumentResponse>(_UploadDocumentResponse_QNAME, UploadDocumentResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "retrieveVersionResponse")
/*     */   public JAXBElement<RetrieveVersionResponse> createRetrieveVersionResponse(RetrieveVersionResponse value) {
/* 423 */     return new JAXBElement<RetrieveVersionResponse>(_RetrieveVersionResponse_QNAME, RetrieveVersionResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "uploadDocument")
/*     */   public JAXBElement<UploadDocument> createUploadDocument(UploadDocument value) {
/* 432 */     return new JAXBElement<UploadDocument>(_UploadDocument_QNAME, UploadDocument.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "Rendition")
/*     */   public JAXBElement<Rendition> createRendition(Rendition value) {
/* 441 */     return new JAXBElement<Rendition>(_Rendition_QNAME, Rendition.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "retrieveResponse")
/*     */   public JAXBElement<RetrieveResponse> createRetrieveResponse(RetrieveResponse value) {
/* 450 */     return new JAXBElement<RetrieveResponse>(_RetrieveResponse_QNAME, RetrieveResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "retrieveVersionPageResponse")
/*     */   public JAXBElement<RetrieveVersionPageResponse> createRetrieveVersionPageResponse(RetrieveVersionPageResponse value) {
/* 459 */     return new JAXBElement<RetrieveVersionPageResponse>(_RetrieveVersionPageResponse_QNAME, RetrieveVersionPageResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "retrievePageResponse")
/*     */   public JAXBElement<RetrievePageResponse> createRetrievePageResponse(RetrievePageResponse value) {
/* 468 */     return new JAXBElement<RetrievePageResponse>(_RetrievePageResponse_QNAME, RetrievePageResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "RenderResult")
/*     */   public JAXBElement<RenderResult> createRenderResult(RenderResult value) {
/* 477 */     return new JAXBElement<RenderResult>(_RenderResult_QNAME, RenderResult.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "retrievePage")
/*     */   public JAXBElement<RetrievePage> createRetrievePage(RetrievePage value) {
/* 486 */     return new JAXBElement<RetrievePage>(_RetrievePage_QNAME, RetrievePage.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "retrieveVersionPage")
/*     */   public JAXBElement<RetrieveVersionPage> createRetrieveVersionPage(RetrieveVersionPage value) {
/* 495 */     return new JAXBElement<RetrieveVersionPage>(_RetrieveVersionPage_QNAME, RetrieveVersionPage.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "retrieveVersionRenditionResponse")
/*     */   public JAXBElement<RetrieveVersionRenditionResponse> createRetrieveVersionRenditionResponse(RetrieveVersionRenditionResponse value) {
/* 504 */     return new JAXBElement<RetrieveVersionRenditionResponse>(_RetrieveVersionRenditionResponse_QNAME, RetrieveVersionRenditionResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ImagingException")
/*     */   public JAXBElement<ImagingFaultInfo> createImagingException(ImagingFaultInfo value) {
/* 513 */     return new JAXBElement<ImagingFaultInfo>(_ImagingException_QNAME, ImagingFaultInfo.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "volume", scope = DocumentProperties.class)
/*     */   public JAXBElement<String> createDocumentPropertiesVolume(String value) {
/* 522 */     return new JAXBElement<String>(_DocumentPropertiesVolume_QNAME, String.class, DocumentProperties.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "volumeDate", scope = DocumentProperties.class)
/*     */   public JAXBElement<XMLGregorianCalendar> createDocumentPropertiesVolumeDate(XMLGregorianCalendar value) {
/* 531 */     return new JAXBElement<XMLGregorianCalendar>(_DocumentPropertiesVolumeDate_QNAME, XMLGregorianCalendar.class, DocumentProperties.class, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */