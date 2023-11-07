/*     */ package ap.quantas.com.imaging.documentSearchService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentSearchService.ApplicationExpression;
/*     */ import ap.quantas.com.imaging.documentSearchService.AuditEvent;
/*     */ import ap.quantas.com.imaging.documentSearchService.CreateSearch;
/*     */ import ap.quantas.com.imaging.documentSearchService.CreateSearchResponse;
/*     */ import ap.quantas.com.imaging.documentSearchService.DefinitionPermissions;
/*     */ import ap.quantas.com.imaging.documentSearchService.DefinitionSecurity;
/*     */ import ap.quantas.com.imaging.documentSearchService.DeleteSearch;
/*     */ import ap.quantas.com.imaging.documentSearchService.DeleteSearchResponse;
/*     */ import ap.quantas.com.imaging.documentSearchService.Document;
/*     */ import ap.quantas.com.imaging.documentSearchService.DocumentPermissions;
/*     */ import ap.quantas.com.imaging.documentSearchService.DocumentProperties;
/*     */ import ap.quantas.com.imaging.documentSearchService.ExecuteSavedSearch;
/*     */ import ap.quantas.com.imaging.documentSearchService.ExecuteSavedSearchResponse;
/*     */ import ap.quantas.com.imaging.documentSearchService.ExecuteSearch;
/*     */ import ap.quantas.com.imaging.documentSearchService.ExecuteSearchResponse;
/*     */ import ap.quantas.com.imaging.documentSearchService.FieldValue;
/*     */ import ap.quantas.com.imaging.documentSearchService.GetSearch;
/*     */ import ap.quantas.com.imaging.documentSearchService.GetSearchParameters;
/*     */ import ap.quantas.com.imaging.documentSearchService.GetSearchParametersResponse;
/*     */ import ap.quantas.com.imaging.documentSearchService.GetSearchResponse;
/*     */ import ap.quantas.com.imaging.documentSearchService.GetSearches;
/*     */ import ap.quantas.com.imaging.documentSearchService.GetSearchesResponse;
/*     */ import ap.quantas.com.imaging.documentSearchService.ImagingFaultDetail;
/*     */ import ap.quantas.com.imaging.documentSearchService.ImagingFaultInfo;
/*     */ import ap.quantas.com.imaging.documentSearchService.ListSearches;
/*     */ import ap.quantas.com.imaging.documentSearchService.ListSearchesResponse;
/*     */ import ap.quantas.com.imaging.documentSearchService.ModifySearch;
/*     */ import ap.quantas.com.imaging.documentSearchService.ModifySearchResponse;
/*     */ import ap.quantas.com.imaging.documentSearchService.NameId;
/*     */ import ap.quantas.com.imaging.documentSearchService.Search;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchCondition;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchConjunction;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchFormatColumn;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchFormatSelectedField;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchParameter;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchParameter2;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchParameterDefinition;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchParameters;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchProperties;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchResult;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchResultSet;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchValue;
/*     */ import ap.quantas.com.imaging.documentSearchService.SectionSet;
/*     */ import ap.quantas.com.imaging.documentSearchService.TypedValue;
/*     */ import ap.quantas.com.imaging.documentSearchService.ValidationError;
/*     */ import ap.quantas.com.imaging.documentSearchService.ValidationFaultInfo;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlElementDecl;
/*     */ import javax.xml.bind.annotation.XmlRegistry;
/*     */ import javax.xml.datatype.XMLGregorianCalendar;
/*     */ import javax.xml.namespace.QName;
/*     */ 
/*     */ @XmlRegistry
/*     */ public class ObjectFactory {
/*  28 */   private static final QName _SearchFormatColumn_QNAME = new QName("http://imaging.oracle/", "SearchFormatColumn");
/*     */   
/*  29 */   private static final QName _ListSearchesResponse_QNAME = new QName("http://imaging.oracle/", "listSearchesResponse");
/*     */   
/*  30 */   private static final QName _GetSearchParametersResponse_QNAME = new QName("http://imaging.oracle/", "getSearchParametersResponse");
/*     */   
/*  31 */   private static final QName _ExecuteSearchResponse_QNAME = new QName("http://imaging.oracle/", "executeSearchResponse");
/*     */   
/*  32 */   private static final QName _SectionSet_QNAME = new QName("http://imaging.oracle/", "sectionSet");
/*     */   
/*  33 */   private static final QName _GetSearch_QNAME = new QName("http://imaging.oracle/", "getSearch");
/*     */   
/*  34 */   private static final QName _ModifySearch_QNAME = new QName("http://imaging.oracle/", "modifySearch");
/*     */   
/*  35 */   private static final QName _SearchParameterDefinition_QNAME = new QName("http://imaging.oracle/", "SearchParameterDefinition");
/*     */   
/*  36 */   private static final QName _DeleteSearchResponse_QNAME = new QName("http://imaging.oracle/", "deleteSearchResponse");
/*     */   
/*  37 */   private static final QName _ModifySearchResponse_QNAME = new QName("http://imaging.oracle/", "modifySearchResponse");
/*     */   
/*  38 */   private static final QName _NameId_QNAME = new QName("http://imaging.oracle/", "nameId");
/*     */   
/*  39 */   private static final QName _ValidationError_QNAME = new QName("http://imaging.oracle/", "ValidationError");
/*     */   
/*  40 */   private static final QName _ExecuteSearch_QNAME = new QName("http://imaging.oracle/", "executeSearch");
/*     */   
/*  41 */   private static final QName _CreateSearchResponse_QNAME = new QName("http://imaging.oracle/", "createSearchResponse");
/*     */   
/*  42 */   private static final QName _CreateSearch_QNAME = new QName("http://imaging.oracle/", "createSearch");
/*     */   
/*  43 */   private static final QName _GetSearchParameters_QNAME = new QName("http://imaging.oracle/", "getSearchParameters");
/*     */   
/*  44 */   private static final QName _ValidationException_QNAME = new QName("http://imaging.oracle/", "ValidationException");
/*     */   
/*  45 */   private static final QName _ApplicationExpression_QNAME = new QName("http://imaging.oracle/", "ApplicationExpression");
/*     */   
/*  46 */   private static final QName _GetSearches_QNAME = new QName("http://imaging.oracle/", "getSearches");
/*     */   
/*  47 */   private static final QName _SearchFormatSelectedField_QNAME = new QName("http://imaging.oracle/", "SearchFormatSelectedField");
/*     */   
/*  48 */   private static final QName _ExecuteSavedSearch_QNAME = new QName("http://imaging.oracle/", "executeSavedSearch");
/*     */   
/*  49 */   private static final QName _GetSearchResponse_QNAME = new QName("http://imaging.oracle/", "getSearchResponse");
/*     */   
/*  50 */   private static final QName _SearchCondition_QNAME = new QName("http://imaging.oracle/", "searchCondition");
/*     */   
/*  51 */   private static final QName _DeleteSearch_QNAME = new QName("http://imaging.oracle/", "deleteSearch");
/*     */   
/*  52 */   private static final QName _ExecuteSavedSearchResponse_QNAME = new QName("http://imaging.oracle/", "executeSavedSearchResponse");
/*     */   
/*  53 */   private static final QName _SearchResultSet_QNAME = new QName("http://imaging.oracle/", "SearchResultSet");
/*     */   
/*  54 */   private static final QName _Search_QNAME = new QName("http://imaging.oracle/", "search");
/*     */   
/*  55 */   private static final QName _Document_QNAME = new QName("http://imaging.oracle/", "document");
/*     */   
/*  56 */   private static final QName _SearchParameters_QNAME = new QName("http://imaging.oracle/", "searchParameters");
/*     */   
/*  57 */   private static final QName _SearchProperties2_QNAME = new QName("http://imaging.oracle/", "SearchProperties2");
/*     */   
/*  58 */   private static final QName _GetSearchesResponse_QNAME = new QName("http://imaging.oracle/", "getSearchesResponse");
/*     */   
/*  59 */   private static final QName _Security_QNAME = new QName("http://imaging.oracle/", "security");
/*     */   
/*  60 */   private static final QName _ListSearches_QNAME = new QName("http://imaging.oracle/", "listSearches");
/*     */   
/*  61 */   private static final QName _SearchParameter_QNAME = new QName("http://imaging.oracle/", "searchParameter");
/*     */   
/*  62 */   private static final QName _ImagingException_QNAME = new QName("http://imaging.oracle/", "ImagingException");
/*     */   
/*  63 */   private static final QName _SearchConjunction_QNAME = new QName("http://imaging.oracle/", "searchConjunction");
/*     */   
/*  64 */   private static final QName _DocumentPropertiesVolume_QNAME = new QName("", "volume");
/*     */   
/*  65 */   private static final QName _DocumentPropertiesVolumeDate_QNAME = new QName("", "volumeDate");
/*     */   
/*  66 */   private static final QName _DocumentDocumentPermissions_QNAME = new QName("", "documentPermissions");
/*     */   
/*  67 */   private static final QName _DocumentProperties_QNAME = new QName("", "properties");
/*     */   
/*  68 */   private static final QName _DocumentFieldValues_QNAME = new QName("", "fieldValues");
/*     */   
/*  69 */   private static final QName _SearchResultColumns_QNAME = new QName("", "resultColumns");
/*     */   
/*  70 */   private static final QName _SearchSearchExpressions_QNAME = new QName("", "searchExpressions");
/*     */   
/*  71 */   private static final QName _SearchPermissions_QNAME = new QName("", "permissions");
/*     */   
/*  72 */   private static final QName _SearchParameterDefinitions_QNAME = new QName("", "parameterDefinitions");
/*     */   
/*  73 */   private static final QName _SearchSecurity_QNAME = new QName("", "security");
/*     */   
/*     */   public ExecuteSearchResponse createExecuteSearchResponse() {
/*  87 */     return new ExecuteSearchResponse();
/*     */   }
/*     */   
/*     */   public AuditEvent createAuditEvent() {
/*  95 */     return new AuditEvent();
/*     */   }
/*     */   
/*     */   public CreateSearchResponse createCreateSearchResponse() {
/* 103 */     return new CreateSearchResponse();
/*     */   }
/*     */   
/*     */   public ModifySearchResponse createModifySearchResponse() {
/* 111 */     return new ModifySearchResponse();
/*     */   }
/*     */   
/*     */   public DefinitionPermissions createDefinitionPermissions() {
/* 119 */     return new DefinitionPermissions();
/*     */   }
/*     */   
/*     */   public AuditEvent.Properties createAuditEventProperties() {
/* 127 */     return new AuditEvent.Properties();
/*     */   }
/*     */   
/*     */   public GetSearch createGetSearch() {
/* 135 */     return new GetSearch();
/*     */   }
/*     */   
/*     */   public ValidationFaultInfo createValidationFaultInfo() {
/* 143 */     return new ValidationFaultInfo();
/*     */   }
/*     */   
/*     */   public Search createSearch() {
/* 151 */     return new Search();
/*     */   }
/*     */   
/*     */   public TypedValue createTypedValue() {
/* 159 */     return new TypedValue();
/*     */   }
/*     */   
/*     */   public ImagingFaultInfo.FaultDetails createImagingFaultInfoFaultDetails() {
/* 167 */     return new ImagingFaultInfo.FaultDetails();
/*     */   }
/*     */   
/*     */   public SearchFormatSelectedField createSearchFormatSelectedField() {
/* 175 */     return new SearchFormatSelectedField();
/*     */   }
/*     */   
/*     */   public SearchParameters createSearchParameters() {
/* 183 */     return new SearchParameters();
/*     */   }
/*     */   
/*     */   public ImagingFaultInfo createImagingFaultInfo() {
/* 191 */     return new ImagingFaultInfo();
/*     */   }
/*     */   
/*     */   public Search.SearchExpressions createSearchSearchExpressions() {
/* 199 */     return new Search.SearchExpressions();
/*     */   }
/*     */   
/*     */   public SearchParameterDefinition createSearchParameterDefinition() {
/* 207 */     return new SearchParameterDefinition();
/*     */   }
/*     */   
/*     */   public NameId createNameId() {
/* 215 */     return new NameId();
/*     */   }
/*     */   
/*     */   public SearchParameter2 createSearchParameter2() {
/* 223 */     return new SearchParameter2();
/*     */   }
/*     */   
/*     */   public DefinitionSecurity createDefinitionSecurity() {
/* 231 */     return new DefinitionSecurity();
/*     */   }
/*     */   
/*     */   public Search.ResultColumns createSearchResultColumns() {
/* 239 */     return new Search.ResultColumns();
/*     */   }
/*     */   
/*     */   public ExecuteSavedSearchResponse createExecuteSavedSearchResponse() {
/* 247 */     return new ExecuteSavedSearchResponse();
/*     */   }
/*     */   
/*     */   public SearchProperties createSearchProperties() {
/* 255 */     return new SearchProperties();
/*     */   }
/*     */   
/*     */   public SearchFormatColumn createSearchFormatColumn() {
/* 263 */     return new SearchFormatColumn();
/*     */   }
/*     */   
/*     */   public Search.History createSearchHistory() {
/* 271 */     return new Search.History();
/*     */   }
/*     */   
/*     */   public SearchResultSet createSearchResultSet() {
/* 279 */     return new SearchResultSet();
/*     */   }
/*     */   
/*     */   public SearchResult createSearchResult() {
/* 287 */     return new SearchResult();
/*     */   }
/*     */   
/*     */   public SectionSet createSectionSet() {
/* 295 */     return new SectionSet();
/*     */   }
/*     */   
/*     */   public ImagingFaultDetail createImagingFaultDetail() {
/* 303 */     return new ImagingFaultDetail();
/*     */   }
/*     */   
/*     */   public Document.FieldValues createDocumentFieldValues() {
/* 311 */     return new Document.FieldValues();
/*     */   }
/*     */   
/*     */   public ListSearches createListSearches() {
/* 319 */     return new ListSearches();
/*     */   }
/*     */   
/*     */   public Search.Security createSearchSecurity() {
/* 327 */     return new Search.Security();
/*     */   }
/*     */   
/*     */   public ExecuteSearch createExecuteSearch() {
/* 335 */     return new ExecuteSearch();
/*     */   }
/*     */   
/*     */   public ValidationError createValidationError() {
/* 343 */     return new ValidationError();
/*     */   }
/*     */   
/*     */   public SearchCondition createSearchCondition() {
/* 351 */     return new SearchCondition();
/*     */   }
/*     */   
/*     */   public DeleteSearch createDeleteSearch() {
/* 359 */     return new DeleteSearch();
/*     */   }
/*     */   
/*     */   public Search.ParameterDefinitions createSearchParameterDefinitions() {
/* 367 */     return new Search.ParameterDefinitions();
/*     */   }
/*     */   
/*     */   public CreateSearch createCreateSearch() {
/* 375 */     return new CreateSearch();
/*     */   }
/*     */   
/*     */   public ModifySearch createModifySearch() {
/* 383 */     return new ModifySearch();
/*     */   }
/*     */   
/*     */   public GetSearchesResponse createGetSearchesResponse() {
/* 391 */     return new GetSearchesResponse();
/*     */   }
/*     */   
/*     */   public ListSearchesResponse createListSearchesResponse() {
/* 399 */     return new ListSearchesResponse();
/*     */   }
/*     */   
/*     */   public SearchParameter createSearchParameter() {
/* 407 */     return new SearchParameter();
/*     */   }
/*     */   
/*     */   public SearchConjunction createSearchConjunction() {
/* 415 */     return new SearchConjunction();
/*     */   }
/*     */   
/*     */   public SearchFormatColumn.Results createSearchFormatColumnResults() {
/* 423 */     return new SearchFormatColumn.Results();
/*     */   }
/*     */   
/*     */   public DeleteSearchResponse createDeleteSearchResponse() {
/* 431 */     return new DeleteSearchResponse();
/*     */   }
/*     */   
/*     */   public GetSearchParameters createGetSearchParameters() {
/* 439 */     return new GetSearchParameters();
/*     */   }
/*     */   
/*     */   public GetSearchParametersResponse createGetSearchParametersResponse() {
/* 447 */     return new GetSearchParametersResponse();
/*     */   }
/*     */   
/*     */   public DocumentProperties createDocumentProperties() {
/* 455 */     return new DocumentProperties();
/*     */   }
/*     */   
/*     */   public GetSearchResponse createGetSearchResponse() {
/* 463 */     return new GetSearchResponse();
/*     */   }
/*     */   
/*     */   public SearchResultSet.Results createSearchResultSetResults() {
/* 471 */     return new SearchResultSet.Results();
/*     */   }
/*     */   
/*     */   public DocumentPermissions createDocumentPermissions() {
/* 479 */     return new DocumentPermissions();
/*     */   }
/*     */   
/*     */   public SearchParameter2.PossibleOperators createSearchParameter2PossibleOperators() {
/* 487 */     return new SearchParameter2.PossibleOperators();
/*     */   }
/*     */   
/*     */   public ApplicationExpression createApplicationExpression() {
/* 495 */     return new ApplicationExpression();
/*     */   }
/*     */   
/*     */   public SearchValue createSearchValue() {
/* 503 */     return new SearchValue();
/*     */   }
/*     */   
/*     */   public ExecuteSavedSearch createExecuteSavedSearch() {
/* 511 */     return new ExecuteSavedSearch();
/*     */   }
/*     */   
/*     */   public GetSearches createGetSearches() {
/* 519 */     return new GetSearches();
/*     */   }
/*     */   
/*     */   public FieldValue createFieldValue() {
/* 527 */     return new FieldValue();
/*     */   }
/*     */   
/*     */   public Document.History createDocumentHistory() {
/* 535 */     return new Document.History();
/*     */   }
/*     */   
/*     */   public SearchParameterDefinition.PossibleOperators createSearchParameterDefinitionPossibleOperators() {
/* 543 */     return new SearchParameterDefinition.PossibleOperators();
/*     */   }
/*     */   
/*     */   public Document createDocument() {
/* 551 */     return new Document();
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "SearchFormatColumn")
/*     */   public JAXBElement<SearchFormatColumn> createSearchFormatColumn(SearchFormatColumn value) {
/* 560 */     return new JAXBElement<SearchFormatColumn>(_SearchFormatColumn_QNAME, SearchFormatColumn.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "listSearchesResponse")
/*     */   public JAXBElement<ListSearchesResponse> createListSearchesResponse(ListSearchesResponse value) {
/* 569 */     return new JAXBElement<ListSearchesResponse>(_ListSearchesResponse_QNAME, ListSearchesResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSearchParametersResponse")
/*     */   public JAXBElement<GetSearchParametersResponse> createGetSearchParametersResponse(GetSearchParametersResponse value) {
/* 578 */     return new JAXBElement<GetSearchParametersResponse>(_GetSearchParametersResponse_QNAME, GetSearchParametersResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "executeSearchResponse")
/*     */   public JAXBElement<ExecuteSearchResponse> createExecuteSearchResponse(ExecuteSearchResponse value) {
/* 587 */     return new JAXBElement<ExecuteSearchResponse>(_ExecuteSearchResponse_QNAME, ExecuteSearchResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "sectionSet")
/*     */   public JAXBElement<SectionSet> createSectionSet(SectionSet value) {
/* 596 */     return new JAXBElement<SectionSet>(_SectionSet_QNAME, SectionSet.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSearch")
/*     */   public JAXBElement<GetSearch> createGetSearch(GetSearch value) {
/* 605 */     return new JAXBElement<GetSearch>(_GetSearch_QNAME, GetSearch.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "modifySearch")
/*     */   public JAXBElement<ModifySearch> createModifySearch(ModifySearch value) {
/* 614 */     return new JAXBElement<ModifySearch>(_ModifySearch_QNAME, ModifySearch.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "SearchParameterDefinition")
/*     */   public JAXBElement<SearchParameterDefinition> createSearchParameterDefinition(SearchParameterDefinition value) {
/* 623 */     return new JAXBElement<SearchParameterDefinition>(_SearchParameterDefinition_QNAME, SearchParameterDefinition.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "deleteSearchResponse")
/*     */   public JAXBElement<DeleteSearchResponse> createDeleteSearchResponse(DeleteSearchResponse value) {
/* 632 */     return new JAXBElement<DeleteSearchResponse>(_DeleteSearchResponse_QNAME, DeleteSearchResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "modifySearchResponse")
/*     */   public JAXBElement<ModifySearchResponse> createModifySearchResponse(ModifySearchResponse value) {
/* 641 */     return new JAXBElement<ModifySearchResponse>(_ModifySearchResponse_QNAME, ModifySearchResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "nameId")
/*     */   public JAXBElement<NameId> createNameId(NameId value) {
/* 650 */     return new JAXBElement<NameId>(_NameId_QNAME, NameId.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ValidationError")
/*     */   public JAXBElement<ValidationError> createValidationError(ValidationError value) {
/* 659 */     return new JAXBElement<ValidationError>(_ValidationError_QNAME, ValidationError.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "executeSearch")
/*     */   public JAXBElement<ExecuteSearch> createExecuteSearch(ExecuteSearch value) {
/* 668 */     return new JAXBElement<ExecuteSearch>(_ExecuteSearch_QNAME, ExecuteSearch.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "createSearchResponse")
/*     */   public JAXBElement<CreateSearchResponse> createCreateSearchResponse(CreateSearchResponse value) {
/* 677 */     return new JAXBElement<CreateSearchResponse>(_CreateSearchResponse_QNAME, CreateSearchResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "createSearch")
/*     */   public JAXBElement<CreateSearch> createCreateSearch(CreateSearch value) {
/* 686 */     return new JAXBElement<CreateSearch>(_CreateSearch_QNAME, CreateSearch.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSearchParameters")
/*     */   public JAXBElement<GetSearchParameters> createGetSearchParameters(GetSearchParameters value) {
/* 695 */     return new JAXBElement<GetSearchParameters>(_GetSearchParameters_QNAME, GetSearchParameters.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ValidationException")
/*     */   public JAXBElement<ValidationFaultInfo> createValidationException(ValidationFaultInfo value) {
/* 704 */     return new JAXBElement<ValidationFaultInfo>(_ValidationException_QNAME, ValidationFaultInfo.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ApplicationExpression")
/*     */   public JAXBElement<ApplicationExpression> createApplicationExpression(ApplicationExpression value) {
/* 713 */     return new JAXBElement<ApplicationExpression>(_ApplicationExpression_QNAME, ApplicationExpression.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSearches")
/*     */   public JAXBElement<GetSearches> createGetSearches(GetSearches value) {
/* 722 */     return new JAXBElement<GetSearches>(_GetSearches_QNAME, GetSearches.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "SearchFormatSelectedField")
/*     */   public JAXBElement<SearchFormatSelectedField> createSearchFormatSelectedField(SearchFormatSelectedField value) {
/* 731 */     return new JAXBElement<SearchFormatSelectedField>(_SearchFormatSelectedField_QNAME, SearchFormatSelectedField.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "executeSavedSearch")
/*     */   public JAXBElement<ExecuteSavedSearch> createExecuteSavedSearch(ExecuteSavedSearch value) {
/* 740 */     return new JAXBElement<ExecuteSavedSearch>(_ExecuteSavedSearch_QNAME, ExecuteSavedSearch.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSearchResponse")
/*     */   public JAXBElement<GetSearchResponse> createGetSearchResponse(GetSearchResponse value) {
/* 749 */     return new JAXBElement<GetSearchResponse>(_GetSearchResponse_QNAME, GetSearchResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "searchCondition")
/*     */   public JAXBElement<SearchCondition> createSearchCondition(SearchCondition value) {
/* 758 */     return new JAXBElement<SearchCondition>(_SearchCondition_QNAME, SearchCondition.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "deleteSearch")
/*     */   public JAXBElement<DeleteSearch> createDeleteSearch(DeleteSearch value) {
/* 767 */     return new JAXBElement<DeleteSearch>(_DeleteSearch_QNAME, DeleteSearch.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "executeSavedSearchResponse")
/*     */   public JAXBElement<ExecuteSavedSearchResponse> createExecuteSavedSearchResponse(ExecuteSavedSearchResponse value) {
/* 776 */     return new JAXBElement<ExecuteSavedSearchResponse>(_ExecuteSavedSearchResponse_QNAME, ExecuteSavedSearchResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "SearchResultSet")
/*     */   public JAXBElement<SearchResultSet> createSearchResultSet(SearchResultSet value) {
/* 785 */     return new JAXBElement<SearchResultSet>(_SearchResultSet_QNAME, SearchResultSet.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "search")
/*     */   public JAXBElement<Search> createSearch(Search value) {
/* 794 */     return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "document")
/*     */   public JAXBElement<Document> createDocument(Document value) {
/* 803 */     return new JAXBElement<Document>(_Document_QNAME, Document.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "searchParameters")
/*     */   public JAXBElement<SearchParameters> createSearchParameters(SearchParameters value) {
/* 812 */     return new JAXBElement<SearchParameters>(_SearchParameters_QNAME, SearchParameters.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "SearchProperties2")
/*     */   public JAXBElement<SearchProperties> createSearchProperties2(SearchProperties value) {
/* 821 */     return new JAXBElement<SearchProperties>(_SearchProperties2_QNAME, SearchProperties.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSearchesResponse")
/*     */   public JAXBElement<GetSearchesResponse> createGetSearchesResponse(GetSearchesResponse value) {
/* 830 */     return new JAXBElement<GetSearchesResponse>(_GetSearchesResponse_QNAME, GetSearchesResponse.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "security")
/*     */   public JAXBElement<DefinitionSecurity> createSecurity(DefinitionSecurity value) {
/* 839 */     return new JAXBElement<DefinitionSecurity>(_Security_QNAME, DefinitionSecurity.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "listSearches")
/*     */   public JAXBElement<ListSearches> createListSearches(ListSearches value) {
/* 848 */     return new JAXBElement<ListSearches>(_ListSearches_QNAME, ListSearches.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "searchParameter")
/*     */   public JAXBElement<SearchParameter2> createSearchParameter(SearchParameter2 value) {
/* 857 */     return new JAXBElement<SearchParameter2>(_SearchParameter_QNAME, SearchParameter2.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ImagingException")
/*     */   public JAXBElement<ImagingFaultInfo> createImagingException(ImagingFaultInfo value) {
/* 866 */     return new JAXBElement<ImagingFaultInfo>(_ImagingException_QNAME, ImagingFaultInfo.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "searchConjunction")
/*     */   public JAXBElement<SearchConjunction> createSearchConjunction(SearchConjunction value) {
/* 875 */     return new JAXBElement<SearchConjunction>(_SearchConjunction_QNAME, SearchConjunction.class, null, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "volume", scope = DocumentProperties.class)
/*     */   public JAXBElement<String> createDocumentPropertiesVolume(String value) {
/* 884 */     return new JAXBElement<String>(_DocumentPropertiesVolume_QNAME, String.class, DocumentProperties.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "volumeDate", scope = DocumentProperties.class)
/*     */   public JAXBElement<XMLGregorianCalendar> createDocumentPropertiesVolumeDate(XMLGregorianCalendar value) {
/* 893 */     return new JAXBElement<XMLGregorianCalendar>(_DocumentPropertiesVolumeDate_QNAME, XMLGregorianCalendar.class, DocumentProperties.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "documentPermissions", scope = Document.class)
/*     */   public JAXBElement<DocumentPermissions> createDocumentDocumentPermissions(DocumentPermissions value) {
/* 902 */     return new JAXBElement<DocumentPermissions>(_DocumentDocumentPermissions_QNAME, DocumentPermissions.class, Document.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "properties", scope = Document.class)
/*     */   public JAXBElement<DocumentProperties> createDocumentProperties(DocumentProperties value) {
/* 911 */     return new JAXBElement<DocumentProperties>(_DocumentProperties_QNAME, DocumentProperties.class, Document.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "fieldValues", scope = Document.class)
/*     */   public JAXBElement<Document.FieldValues> createDocumentFieldValues(Document.FieldValues value) {
/* 920 */     return new JAXBElement<Document.FieldValues>(_DocumentFieldValues_QNAME, Document.FieldValues.class, Document.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "resultColumns", scope = Search.class)
/*     */   public JAXBElement<Search.ResultColumns> createSearchResultColumns(Search.ResultColumns value) {
/* 929 */     return new JAXBElement<Search.ResultColumns>(_SearchResultColumns_QNAME, Search.ResultColumns.class, Search.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "searchExpressions", scope = Search.class)
/*     */   public JAXBElement<Search.SearchExpressions> createSearchSearchExpressions(Search.SearchExpressions value) {
/* 938 */     return new JAXBElement<Search.SearchExpressions>(_SearchSearchExpressions_QNAME, Search.SearchExpressions.class, Search.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "permissions", scope = Search.class)
/*     */   public JAXBElement<DefinitionPermissions> createSearchPermissions(DefinitionPermissions value) {
/* 947 */     return new JAXBElement<DefinitionPermissions>(_SearchPermissions_QNAME, DefinitionPermissions.class, Search.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "parameterDefinitions", scope = Search.class)
/*     */   public JAXBElement<Search.ParameterDefinitions> createSearchParameterDefinitions(Search.ParameterDefinitions value) {
/* 956 */     return new JAXBElement<Search.ParameterDefinitions>(_SearchParameterDefinitions_QNAME, Search.ParameterDefinitions.class, Search.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "security", scope = Search.class)
/*     */   public JAXBElement<Search.Security> createSearchSecurity(Search.Security value) {
/* 965 */     return new JAXBElement<Search.Security>(_SearchSecurity_QNAME, Search.Security.class, Search.class, value);
/*     */   }
/*     */   
/*     */   @XmlElementDecl(namespace = "", name = "properties", scope = Search.class)
/*     */   public JAXBElement<SearchProperties> createSearchProperties(SearchProperties value) {
/* 974 */     return new JAXBElement<SearchProperties>(_DocumentProperties_QNAME, SearchProperties.class, Search.class, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */