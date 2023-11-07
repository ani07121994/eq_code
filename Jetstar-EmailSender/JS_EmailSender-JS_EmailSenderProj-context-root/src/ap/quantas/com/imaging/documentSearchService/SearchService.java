package ap.quantas.com.imaging.documentSearchService;

import ap.quantas.com.imaging.documentSearchService.Ability;
import ap.quantas.com.imaging.documentSearchService.ImagingException;
import ap.quantas.com.imaging.documentSearchService.NameId;
import ap.quantas.com.imaging.documentSearchService.ObjectFactory;
import ap.quantas.com.imaging.documentSearchService.Search;
import ap.quantas.com.imaging.documentSearchService.SearchParameter;
import ap.quantas.com.imaging.documentSearchService.SearchParameters;
import ap.quantas.com.imaging.documentSearchService.SearchResultSet;
import ap.quantas.com.imaging.documentSearchService.SectionSet;
import ap.quantas.com.imaging.documentSearchService.ValidationException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "SearchService", targetNamespace = "http://imaging.oracle/")
@XmlSeeAlso({ObjectFactory.class})
public interface SearchService {
  @WebMethod
  @WebResult(name = "search", targetNamespace = "http://imaging.oracle/")
  @RequestWrapper(localName = "getSearch", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.GetSearch")
  @ResponseWrapper(localName = "getSearchResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.GetSearchResponse")
  Search getSearch(@WebParam(name = "searchNameId", targetNamespace = "") NameId paramNameId, @WebParam(name = "sectionSet", targetNamespace = "http://imaging.oracle/") SectionSet paramSectionSet) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "searchResults", targetNamespace = "")
  @RequestWrapper(localName = "executeSavedSearch", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.ExecuteSavedSearch")
  @ResponseWrapper(localName = "executeSavedSearchResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.ExecuteSavedSearchResponse")
  SearchResultSet executeSavedSearch(@WebParam(name = "searchNameId", targetNamespace = "") NameId paramNameId, @WebParam(name = "searchArguments", targetNamespace = "") List<SearchParameter> paramList) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "searchParameters", targetNamespace = "http://imaging.oracle/")
  @RequestWrapper(localName = "getSearchParameters", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.GetSearchParameters")
  @ResponseWrapper(localName = "getSearchParametersResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.GetSearchParametersResponse")
  SearchParameters getSearchParameters(@WebParam(name = "searchNameId", targetNamespace = "") NameId paramNameId) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "searchResults", targetNamespace = "")
  @RequestWrapper(localName = "executeSearch", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.ExecuteSearch")
  @ResponseWrapper(localName = "executeSearchResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.ExecuteSearchResponse")
  SearchResultSet executeSearch(@WebParam(name = "search", targetNamespace = "http://imaging.oracle/") Search paramSearch, @WebParam(name = "searchArguments", targetNamespace = "") List<SearchParameter> paramList) throws ImagingException;
  
  @WebMethod
  @RequestWrapper(localName = "modifySearch", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.ModifySearch")
  @ResponseWrapper(localName = "modifySearchResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.ModifySearchResponse")
  void modifySearch(@WebParam(name = "search", targetNamespace = "http://imaging.oracle/") Search paramSearch, @WebParam(name = "sectionSet", targetNamespace = "http://imaging.oracle/") SectionSet paramSectionSet) throws ImagingException, ValidationException;
  
  @WebMethod
  @WebResult(name = "search", targetNamespace = "")
  @RequestWrapper(localName = "createSearch", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.CreateSearch")
  @ResponseWrapper(localName = "createSearchResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.CreateSearchResponse")
  NameId createSearch(@WebParam(name = "search", targetNamespace = "http://imaging.oracle/") Search paramSearch) throws ImagingException, ValidationException;
  
  @WebMethod
  @WebResult(name = "searchNameIds", targetNamespace = "")
  @RequestWrapper(localName = "listSearches", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.ListSearches")
  @ResponseWrapper(localName = "listSearchesResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.ListSearchesResponse")
  List<NameId> listSearches(@WebParam(name = "ability", targetNamespace = "") Ability paramAbility) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "searches", targetNamespace = "")
  @RequestWrapper(localName = "getSearches", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.GetSearches")
  @ResponseWrapper(localName = "getSearchesResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.GetSearchesResponse")
  List<Search> getSearches(@WebParam(name = "searchNameIds", targetNamespace = "") List<NameId> paramList, @WebParam(name = "sectionSet", targetNamespace = "http://imaging.oracle/") SectionSet paramSectionSet) throws ImagingException;
  
  @WebMethod
  @RequestWrapper(localName = "deleteSearch", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.DeleteSearch")
  @ResponseWrapper(localName = "deleteSearchResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentSearchService.DeleteSearchResponse")
  void deleteSearch(@WebParam(name = "searchNameId", targetNamespace = "") NameId paramNameId) throws ImagingException;
}


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SearchService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */