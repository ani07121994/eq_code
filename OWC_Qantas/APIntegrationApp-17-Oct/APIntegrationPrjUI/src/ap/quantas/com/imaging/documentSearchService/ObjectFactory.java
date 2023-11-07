
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ap.quantas.com.imaging.documentSearchService package. 
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

    private final static QName _SearchFormatColumn_QNAME = new QName("http://imaging.oracle/", "SearchFormatColumn");
    private final static QName _ListSearchesResponse_QNAME = new QName("http://imaging.oracle/", "listSearchesResponse");
    private final static QName _GetSearchParametersResponse_QNAME = new QName("http://imaging.oracle/", "getSearchParametersResponse");
    private final static QName _ExecuteSearchResponse_QNAME = new QName("http://imaging.oracle/", "executeSearchResponse");
    private final static QName _SectionSet_QNAME = new QName("http://imaging.oracle/", "sectionSet");
    private final static QName _GetSearch_QNAME = new QName("http://imaging.oracle/", "getSearch");
    private final static QName _ModifySearch_QNAME = new QName("http://imaging.oracle/", "modifySearch");
    private final static QName _SearchParameterDefinition_QNAME = new QName("http://imaging.oracle/", "SearchParameterDefinition");
    private final static QName _DeleteSearchResponse_QNAME = new QName("http://imaging.oracle/", "deleteSearchResponse");
    private final static QName _ModifySearchResponse_QNAME = new QName("http://imaging.oracle/", "modifySearchResponse");
    private final static QName _NameId_QNAME = new QName("http://imaging.oracle/", "nameId");
    private final static QName _ValidationError_QNAME = new QName("http://imaging.oracle/", "ValidationError");
    private final static QName _ExecuteSearch_QNAME = new QName("http://imaging.oracle/", "executeSearch");
    private final static QName _CreateSearchResponse_QNAME = new QName("http://imaging.oracle/", "createSearchResponse");
    private final static QName _CreateSearch_QNAME = new QName("http://imaging.oracle/", "createSearch");
    private final static QName _GetSearchParameters_QNAME = new QName("http://imaging.oracle/", "getSearchParameters");
    private final static QName _ValidationException_QNAME = new QName("http://imaging.oracle/", "ValidationException");
    private final static QName _ApplicationExpression_QNAME = new QName("http://imaging.oracle/", "ApplicationExpression");
    private final static QName _GetSearches_QNAME = new QName("http://imaging.oracle/", "getSearches");
    private final static QName _SearchFormatSelectedField_QNAME = new QName("http://imaging.oracle/", "SearchFormatSelectedField");
    private final static QName _ExecuteSavedSearch_QNAME = new QName("http://imaging.oracle/", "executeSavedSearch");
    private final static QName _GetSearchResponse_QNAME = new QName("http://imaging.oracle/", "getSearchResponse");
    private final static QName _SearchCondition_QNAME = new QName("http://imaging.oracle/", "searchCondition");
    private final static QName _DeleteSearch_QNAME = new QName("http://imaging.oracle/", "deleteSearch");
    private final static QName _ExecuteSavedSearchResponse_QNAME = new QName("http://imaging.oracle/", "executeSavedSearchResponse");
    private final static QName _SearchResultSet_QNAME = new QName("http://imaging.oracle/", "SearchResultSet");
    private final static QName _Search_QNAME = new QName("http://imaging.oracle/", "search");
    private final static QName _Document_QNAME = new QName("http://imaging.oracle/", "document");
    private final static QName _SearchParameters_QNAME = new QName("http://imaging.oracle/", "searchParameters");
    private final static QName _SearchProperties2_QNAME = new QName("http://imaging.oracle/", "SearchProperties2");
    private final static QName _GetSearchesResponse_QNAME = new QName("http://imaging.oracle/", "getSearchesResponse");
    private final static QName _Security_QNAME = new QName("http://imaging.oracle/", "security");
    private final static QName _ListSearches_QNAME = new QName("http://imaging.oracle/", "listSearches");
    private final static QName _SearchParameter_QNAME = new QName("http://imaging.oracle/", "searchParameter");
    private final static QName _ImagingException_QNAME = new QName("http://imaging.oracle/", "ImagingException");
    private final static QName _SearchConjunction_QNAME = new QName("http://imaging.oracle/", "searchConjunction");
    private final static QName _DocumentPropertiesVolume_QNAME = new QName("", "volume");
    private final static QName _DocumentPropertiesVolumeDate_QNAME = new QName("", "volumeDate");
    private final static QName _DocumentDocumentPermissions_QNAME = new QName("", "documentPermissions");
    private final static QName _DocumentProperties_QNAME = new QName("", "properties");
    private final static QName _DocumentFieldValues_QNAME = new QName("", "fieldValues");
    private final static QName _SearchResultColumns_QNAME = new QName("", "resultColumns");
    private final static QName _SearchSearchExpressions_QNAME = new QName("", "searchExpressions");
    private final static QName _SearchPermissions_QNAME = new QName("", "permissions");
    private final static QName _SearchParameterDefinitions_QNAME = new QName("", "parameterDefinitions");
    private final static QName _SearchSecurity_QNAME = new QName("", "security");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ap.quantas.com.imaging.documentSearchService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExecuteSearchResponse }
     * 
     */
    public ExecuteSearchResponse createExecuteSearchResponse() {
        return new ExecuteSearchResponse();
    }

    /**
     * Create an instance of {@link AuditEvent }
     * 
     */
    public AuditEvent createAuditEvent() {
        return new AuditEvent();
    }

    /**
     * Create an instance of {@link CreateSearchResponse }
     * 
     */
    public CreateSearchResponse createCreateSearchResponse() {
        return new CreateSearchResponse();
    }

    /**
     * Create an instance of {@link ModifySearchResponse }
     * 
     */
    public ModifySearchResponse createModifySearchResponse() {
        return new ModifySearchResponse();
    }

    /**
     * Create an instance of {@link DefinitionPermissions }
     * 
     */
    public DefinitionPermissions createDefinitionPermissions() {
        return new DefinitionPermissions();
    }

    /**
     * Create an instance of {@link AuditEvent.Properties }
     * 
     */
    public AuditEvent.Properties createAuditEventProperties() {
        return new AuditEvent.Properties();
    }

    /**
     * Create an instance of {@link GetSearch }
     * 
     */
    public GetSearch createGetSearch() {
        return new GetSearch();
    }

    /**
     * Create an instance of {@link ValidationFaultInfo }
     * 
     */
    public ValidationFaultInfo createValidationFaultInfo() {
        return new ValidationFaultInfo();
    }

    /**
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link TypedValue }
     * 
     */
    public TypedValue createTypedValue() {
        return new TypedValue();
    }

    /**
     * Create an instance of {@link ImagingFaultInfo.FaultDetails }
     * 
     */
    public ImagingFaultInfo.FaultDetails createImagingFaultInfoFaultDetails() {
        return new ImagingFaultInfo.FaultDetails();
    }

    /**
     * Create an instance of {@link SearchFormatSelectedField }
     * 
     */
    public SearchFormatSelectedField createSearchFormatSelectedField() {
        return new SearchFormatSelectedField();
    }

    /**
     * Create an instance of {@link SearchParameters }
     * 
     */
    public SearchParameters createSearchParameters() {
        return new SearchParameters();
    }

    /**
     * Create an instance of {@link ImagingFaultInfo }
     * 
     */
    public ImagingFaultInfo createImagingFaultInfo() {
        return new ImagingFaultInfo();
    }

    /**
     * Create an instance of {@link Search.SearchExpressions }
     * 
     */
    public Search.SearchExpressions createSearchSearchExpressions() {
        return new Search.SearchExpressions();
    }

    /**
     * Create an instance of {@link SearchParameterDefinition }
     * 
     */
    public SearchParameterDefinition createSearchParameterDefinition() {
        return new SearchParameterDefinition();
    }

    /**
     * Create an instance of {@link NameId }
     * 
     */
    public NameId createNameId() {
        return new NameId();
    }

    /**
     * Create an instance of {@link SearchParameter2 }
     * 
     */
    public SearchParameter2 createSearchParameter2() {
        return new SearchParameter2();
    }

    /**
     * Create an instance of {@link DefinitionSecurity }
     * 
     */
    public DefinitionSecurity createDefinitionSecurity() {
        return new DefinitionSecurity();
    }

    /**
     * Create an instance of {@link Search.ResultColumns }
     * 
     */
    public Search.ResultColumns createSearchResultColumns() {
        return new Search.ResultColumns();
    }

    /**
     * Create an instance of {@link ExecuteSavedSearchResponse }
     * 
     */
    public ExecuteSavedSearchResponse createExecuteSavedSearchResponse() {
        return new ExecuteSavedSearchResponse();
    }

    /**
     * Create an instance of {@link SearchProperties }
     * 
     */
    public SearchProperties createSearchProperties() {
        return new SearchProperties();
    }

    /**
     * Create an instance of {@link SearchFormatColumn }
     * 
     */
    public SearchFormatColumn createSearchFormatColumn() {
        return new SearchFormatColumn();
    }

    /**
     * Create an instance of {@link Search.History }
     * 
     */
    public Search.History createSearchHistory() {
        return new Search.History();
    }

    /**
     * Create an instance of {@link SearchResultSet }
     * 
     */
    public SearchResultSet createSearchResultSet() {
        return new SearchResultSet();
    }

    /**
     * Create an instance of {@link SearchResult }
     * 
     */
    public SearchResult createSearchResult() {
        return new SearchResult();
    }

    /**
     * Create an instance of {@link SectionSet }
     * 
     */
    public SectionSet createSectionSet() {
        return new SectionSet();
    }

    /**
     * Create an instance of {@link ImagingFaultDetail }
     * 
     */
    public ImagingFaultDetail createImagingFaultDetail() {
        return new ImagingFaultDetail();
    }

    /**
     * Create an instance of {@link Document.FieldValues }
     * 
     */
    public Document.FieldValues createDocumentFieldValues() {
        return new Document.FieldValues();
    }

    /**
     * Create an instance of {@link ListSearches }
     * 
     */
    public ListSearches createListSearches() {
        return new ListSearches();
    }

    /**
     * Create an instance of {@link Search.Security }
     * 
     */
    public Search.Security createSearchSecurity() {
        return new Search.Security();
    }

    /**
     * Create an instance of {@link ExecuteSearch }
     * 
     */
    public ExecuteSearch createExecuteSearch() {
        return new ExecuteSearch();
    }

    /**
     * Create an instance of {@link ValidationError }
     * 
     */
    public ValidationError createValidationError() {
        return new ValidationError();
    }

    /**
     * Create an instance of {@link SearchCondition }
     * 
     */
    public SearchCondition createSearchCondition() {
        return new SearchCondition();
    }

    /**
     * Create an instance of {@link DeleteSearch }
     * 
     */
    public DeleteSearch createDeleteSearch() {
        return new DeleteSearch();
    }

    /**
     * Create an instance of {@link Search.ParameterDefinitions }
     * 
     */
    public Search.ParameterDefinitions createSearchParameterDefinitions() {
        return new Search.ParameterDefinitions();
    }

    /**
     * Create an instance of {@link CreateSearch }
     * 
     */
    public CreateSearch createCreateSearch() {
        return new CreateSearch();
    }

    /**
     * Create an instance of {@link ModifySearch }
     * 
     */
    public ModifySearch createModifySearch() {
        return new ModifySearch();
    }

    /**
     * Create an instance of {@link GetSearchesResponse }
     * 
     */
    public GetSearchesResponse createGetSearchesResponse() {
        return new GetSearchesResponse();
    }

    /**
     * Create an instance of {@link ListSearchesResponse }
     * 
     */
    public ListSearchesResponse createListSearchesResponse() {
        return new ListSearchesResponse();
    }

    /**
     * Create an instance of {@link SearchParameter }
     * 
     */
    public SearchParameter createSearchParameter() {
        return new SearchParameter();
    }

    /**
     * Create an instance of {@link SearchConjunction }
     * 
     */
    public SearchConjunction createSearchConjunction() {
        return new SearchConjunction();
    }

    /**
     * Create an instance of {@link SearchFormatColumn.Results }
     * 
     */
    public SearchFormatColumn.Results createSearchFormatColumnResults() {
        return new SearchFormatColumn.Results();
    }

    /**
     * Create an instance of {@link DeleteSearchResponse }
     * 
     */
    public DeleteSearchResponse createDeleteSearchResponse() {
        return new DeleteSearchResponse();
    }

    /**
     * Create an instance of {@link GetSearchParameters }
     * 
     */
    public GetSearchParameters createGetSearchParameters() {
        return new GetSearchParameters();
    }

    /**
     * Create an instance of {@link GetSearchParametersResponse }
     * 
     */
    public GetSearchParametersResponse createGetSearchParametersResponse() {
        return new GetSearchParametersResponse();
    }

    /**
     * Create an instance of {@link DocumentProperties }
     * 
     */
    public DocumentProperties createDocumentProperties() {
        return new DocumentProperties();
    }

    /**
     * Create an instance of {@link GetSearchResponse }
     * 
     */
    public GetSearchResponse createGetSearchResponse() {
        return new GetSearchResponse();
    }

    /**
     * Create an instance of {@link SearchResultSet.Results }
     * 
     */
    public SearchResultSet.Results createSearchResultSetResults() {
        return new SearchResultSet.Results();
    }

    /**
     * Create an instance of {@link DocumentPermissions }
     * 
     */
    public DocumentPermissions createDocumentPermissions() {
        return new DocumentPermissions();
    }

    /**
     * Create an instance of {@link SearchParameter2 .PossibleOperators }
     * 
     */
    public SearchParameter2 .PossibleOperators createSearchParameter2PossibleOperators() {
        return new SearchParameter2 .PossibleOperators();
    }

    /**
     * Create an instance of {@link ApplicationExpression }
     * 
     */
    public ApplicationExpression createApplicationExpression() {
        return new ApplicationExpression();
    }

    /**
     * Create an instance of {@link SearchValue }
     * 
     */
    public SearchValue createSearchValue() {
        return new SearchValue();
    }

    /**
     * Create an instance of {@link ExecuteSavedSearch }
     * 
     */
    public ExecuteSavedSearch createExecuteSavedSearch() {
        return new ExecuteSavedSearch();
    }

    /**
     * Create an instance of {@link GetSearches }
     * 
     */
    public GetSearches createGetSearches() {
        return new GetSearches();
    }

    /**
     * Create an instance of {@link FieldValue }
     * 
     */
    public FieldValue createFieldValue() {
        return new FieldValue();
    }

    /**
     * Create an instance of {@link Document.History }
     * 
     */
    public Document.History createDocumentHistory() {
        return new Document.History();
    }

    /**
     * Create an instance of {@link SearchParameterDefinition.PossibleOperators }
     * 
     */
    public SearchParameterDefinition.PossibleOperators createSearchParameterDefinitionPossibleOperators() {
        return new SearchParameterDefinition.PossibleOperators();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchFormatColumn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "SearchFormatColumn")
    public JAXBElement<SearchFormatColumn> createSearchFormatColumn(SearchFormatColumn value) {
        return new JAXBElement<SearchFormatColumn>(_SearchFormatColumn_QNAME, SearchFormatColumn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListSearchesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "listSearchesResponse")
    public JAXBElement<ListSearchesResponse> createListSearchesResponse(ListSearchesResponse value) {
        return new JAXBElement<ListSearchesResponse>(_ListSearchesResponse_QNAME, ListSearchesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSearchParametersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSearchParametersResponse")
    public JAXBElement<GetSearchParametersResponse> createGetSearchParametersResponse(GetSearchParametersResponse value) {
        return new JAXBElement<GetSearchParametersResponse>(_GetSearchParametersResponse_QNAME, GetSearchParametersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteSearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "executeSearchResponse")
    public JAXBElement<ExecuteSearchResponse> createExecuteSearchResponse(ExecuteSearchResponse value) {
        return new JAXBElement<ExecuteSearchResponse>(_ExecuteSearchResponse_QNAME, ExecuteSearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SectionSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "sectionSet")
    public JAXBElement<SectionSet> createSectionSet(SectionSet value) {
        return new JAXBElement<SectionSet>(_SectionSet_QNAME, SectionSet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSearch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSearch")
    public JAXBElement<GetSearch> createGetSearch(GetSearch value) {
        return new JAXBElement<GetSearch>(_GetSearch_QNAME, GetSearch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifySearch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "modifySearch")
    public JAXBElement<ModifySearch> createModifySearch(ModifySearch value) {
        return new JAXBElement<ModifySearch>(_ModifySearch_QNAME, ModifySearch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchParameterDefinition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "SearchParameterDefinition")
    public JAXBElement<SearchParameterDefinition> createSearchParameterDefinition(SearchParameterDefinition value) {
        return new JAXBElement<SearchParameterDefinition>(_SearchParameterDefinition_QNAME, SearchParameterDefinition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "deleteSearchResponse")
    public JAXBElement<DeleteSearchResponse> createDeleteSearchResponse(DeleteSearchResponse value) {
        return new JAXBElement<DeleteSearchResponse>(_DeleteSearchResponse_QNAME, DeleteSearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifySearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "modifySearchResponse")
    public JAXBElement<ModifySearchResponse> createModifySearchResponse(ModifySearchResponse value) {
        return new JAXBElement<ModifySearchResponse>(_ModifySearchResponse_QNAME, ModifySearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NameId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "nameId")
    public JAXBElement<NameId> createNameId(NameId value) {
        return new JAXBElement<NameId>(_NameId_QNAME, NameId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidationError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ValidationError")
    public JAXBElement<ValidationError> createValidationError(ValidationError value) {
        return new JAXBElement<ValidationError>(_ValidationError_QNAME, ValidationError.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteSearch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "executeSearch")
    public JAXBElement<ExecuteSearch> createExecuteSearch(ExecuteSearch value) {
        return new JAXBElement<ExecuteSearch>(_ExecuteSearch_QNAME, ExecuteSearch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "createSearchResponse")
    public JAXBElement<CreateSearchResponse> createCreateSearchResponse(CreateSearchResponse value) {
        return new JAXBElement<CreateSearchResponse>(_CreateSearchResponse_QNAME, CreateSearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSearch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "createSearch")
    public JAXBElement<CreateSearch> createCreateSearch(CreateSearch value) {
        return new JAXBElement<CreateSearch>(_CreateSearch_QNAME, CreateSearch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSearchParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSearchParameters")
    public JAXBElement<GetSearchParameters> createGetSearchParameters(GetSearchParameters value) {
        return new JAXBElement<GetSearchParameters>(_GetSearchParameters_QNAME, GetSearchParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidationFaultInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ValidationException")
    public JAXBElement<ValidationFaultInfo> createValidationException(ValidationFaultInfo value) {
        return new JAXBElement<ValidationFaultInfo>(_ValidationException_QNAME, ValidationFaultInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplicationExpression }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ApplicationExpression")
    public JAXBElement<ApplicationExpression> createApplicationExpression(ApplicationExpression value) {
        return new JAXBElement<ApplicationExpression>(_ApplicationExpression_QNAME, ApplicationExpression.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSearches }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSearches")
    public JAXBElement<GetSearches> createGetSearches(GetSearches value) {
        return new JAXBElement<GetSearches>(_GetSearches_QNAME, GetSearches.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchFormatSelectedField }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "SearchFormatSelectedField")
    public JAXBElement<SearchFormatSelectedField> createSearchFormatSelectedField(SearchFormatSelectedField value) {
        return new JAXBElement<SearchFormatSelectedField>(_SearchFormatSelectedField_QNAME, SearchFormatSelectedField.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteSavedSearch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "executeSavedSearch")
    public JAXBElement<ExecuteSavedSearch> createExecuteSavedSearch(ExecuteSavedSearch value) {
        return new JAXBElement<ExecuteSavedSearch>(_ExecuteSavedSearch_QNAME, ExecuteSavedSearch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSearchResponse")
    public JAXBElement<GetSearchResponse> createGetSearchResponse(GetSearchResponse value) {
        return new JAXBElement<GetSearchResponse>(_GetSearchResponse_QNAME, GetSearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCondition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "searchCondition")
    public JAXBElement<SearchCondition> createSearchCondition(SearchCondition value) {
        return new JAXBElement<SearchCondition>(_SearchCondition_QNAME, SearchCondition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSearch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "deleteSearch")
    public JAXBElement<DeleteSearch> createDeleteSearch(DeleteSearch value) {
        return new JAXBElement<DeleteSearch>(_DeleteSearch_QNAME, DeleteSearch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteSavedSearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "executeSavedSearchResponse")
    public JAXBElement<ExecuteSavedSearchResponse> createExecuteSavedSearchResponse(ExecuteSavedSearchResponse value) {
        return new JAXBElement<ExecuteSavedSearchResponse>(_ExecuteSavedSearchResponse_QNAME, ExecuteSavedSearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResultSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "SearchResultSet")
    public JAXBElement<SearchResultSet> createSearchResultSet(SearchResultSet value) {
        return new JAXBElement<SearchResultSet>(_SearchResultSet_QNAME, SearchResultSet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "search")
    public JAXBElement<Search> createSearch(Search value) {
        return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Document }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "document")
    public JAXBElement<Document> createDocument(Document value) {
        return new JAXBElement<Document>(_Document_QNAME, Document.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchParameters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "searchParameters")
    public JAXBElement<SearchParameters> createSearchParameters(SearchParameters value) {
        return new JAXBElement<SearchParameters>(_SearchParameters_QNAME, SearchParameters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchProperties }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "SearchProperties2")
    public JAXBElement<SearchProperties> createSearchProperties2(SearchProperties value) {
        return new JAXBElement<SearchProperties>(_SearchProperties2_QNAME, SearchProperties.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSearchesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getSearchesResponse")
    public JAXBElement<GetSearchesResponse> createGetSearchesResponse(GetSearchesResponse value) {
        return new JAXBElement<GetSearchesResponse>(_GetSearchesResponse_QNAME, GetSearchesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefinitionSecurity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "security")
    public JAXBElement<DefinitionSecurity> createSecurity(DefinitionSecurity value) {
        return new JAXBElement<DefinitionSecurity>(_Security_QNAME, DefinitionSecurity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListSearches }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "listSearches")
    public JAXBElement<ListSearches> createListSearches(ListSearches value) {
        return new JAXBElement<ListSearches>(_ListSearches_QNAME, ListSearches.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchParameter2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "searchParameter")
    public JAXBElement<SearchParameter2> createSearchParameter(SearchParameter2 value) {
        return new JAXBElement<SearchParameter2>(_SearchParameter_QNAME, SearchParameter2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImagingFaultInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ImagingException")
    public JAXBElement<ImagingFaultInfo> createImagingException(ImagingFaultInfo value) {
        return new JAXBElement<ImagingFaultInfo>(_ImagingException_QNAME, ImagingFaultInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchConjunction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://imaging.oracle/", name = "searchConjunction")
    public JAXBElement<SearchConjunction> createSearchConjunction(SearchConjunction value) {
        return new JAXBElement<SearchConjunction>(_SearchConjunction_QNAME, SearchConjunction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "volume", scope = DocumentProperties.class)
    public JAXBElement<String> createDocumentPropertiesVolume(String value) {
        return new JAXBElement<String>(_DocumentPropertiesVolume_QNAME, String.class, DocumentProperties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "volumeDate", scope = DocumentProperties.class)
    public JAXBElement<XMLGregorianCalendar> createDocumentPropertiesVolumeDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DocumentPropertiesVolumeDate_QNAME, XMLGregorianCalendar.class, DocumentProperties.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentPermissions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "documentPermissions", scope = Document.class)
    public JAXBElement<DocumentPermissions> createDocumentDocumentPermissions(DocumentPermissions value) {
        return new JAXBElement<DocumentPermissions>(_DocumentDocumentPermissions_QNAME, DocumentPermissions.class, Document.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentProperties }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "properties", scope = Document.class)
    public JAXBElement<DocumentProperties> createDocumentProperties(DocumentProperties value) {
        return new JAXBElement<DocumentProperties>(_DocumentProperties_QNAME, DocumentProperties.class, Document.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Document.FieldValues }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "fieldValues", scope = Document.class)
    public JAXBElement<Document.FieldValues> createDocumentFieldValues(Document.FieldValues value) {
        return new JAXBElement<Document.FieldValues>(_DocumentFieldValues_QNAME, Document.FieldValues.class, Document.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search.ResultColumns }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "resultColumns", scope = Search.class)
    public JAXBElement<Search.ResultColumns> createSearchResultColumns(Search.ResultColumns value) {
        return new JAXBElement<Search.ResultColumns>(_SearchResultColumns_QNAME, Search.ResultColumns.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search.SearchExpressions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "searchExpressions", scope = Search.class)
    public JAXBElement<Search.SearchExpressions> createSearchSearchExpressions(Search.SearchExpressions value) {
        return new JAXBElement<Search.SearchExpressions>(_SearchSearchExpressions_QNAME, Search.SearchExpressions.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefinitionPermissions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "permissions", scope = Search.class)
    public JAXBElement<DefinitionPermissions> createSearchPermissions(DefinitionPermissions value) {
        return new JAXBElement<DefinitionPermissions>(_SearchPermissions_QNAME, DefinitionPermissions.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search.ParameterDefinitions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "parameterDefinitions", scope = Search.class)
    public JAXBElement<Search.ParameterDefinitions> createSearchParameterDefinitions(Search.ParameterDefinitions value) {
        return new JAXBElement<Search.ParameterDefinitions>(_SearchParameterDefinitions_QNAME, Search.ParameterDefinitions.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search.Security }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "security", scope = Search.class)
    public JAXBElement<Search.Security> createSearchSecurity(Search.Security value) {
        return new JAXBElement<Search.Security>(_SearchSecurity_QNAME, Search.Security.class, Search.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchProperties }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "properties", scope = Search.class)
    public JAXBElement<SearchProperties> createSearchProperties(SearchProperties value) {
        return new JAXBElement<SearchProperties>(_DocumentProperties_QNAME, SearchProperties.class, Search.class, value);
    }

}
