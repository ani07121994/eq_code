package ap.quantas.com.imaging.documentUpdate;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "DocumentService", targetNamespace = "http://imaging.oracle/")
@XmlSeeAlso({ObjectFactory.class})
public interface DocumentService {
  @WebMethod
  @WebResult(name = "annotationData", targetNamespace = "")
  @RequestWrapper(localName = "getAnnotations", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.GetAnnotations")
  @ResponseWrapper(localName = "getAnnotationsResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.GetAnnotationsResponse")
  byte[] getAnnotations(@WebParam(name = "documentId", targetNamespace = "") String paramString) throws ImagingException;
  
  @WebMethod
  @RequestWrapper(localName = "setAnnotations", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.SetAnnotations")
  @ResponseWrapper(localName = "setAnnotationsResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.SetAnnotationsResponse")
  void setAnnotations(@WebParam(name = "documentId", targetNamespace = "") String paramString, @WebParam(name = "annotData", targetNamespace = "") byte[] paramArrayOfbyte) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "documentId", targetNamespace = "")
  @RequestWrapper(localName = "createDocument", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.CreateDocument")
  @ResponseWrapper(localName = "createDocumentResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.CreateDocumentResponse")
  String createDocument(@WebParam(name = "uploadToken", targetNamespace = "") String paramString, @WebParam(name = "applicationId", targetNamespace = "") NameId paramNameId, @WebParam(name = "fieldValues", targetNamespace = "") List<FieldValue> paramList, @WebParam(name = "submitToWorkflow", targetNamespace = "") boolean paramBoolean) throws ImagingException, ValidationException;
  
  @WebMethod
  @WebResult(name = "document", targetNamespace = "http://imaging.oracle/")
  @RequestWrapper(localName = "getDocument", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.GetDocument")
  @ResponseWrapper(localName = "getDocumentResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.GetDocumentResponse")
  Document getDocument(@WebParam(name = "documentId", targetNamespace = "") String paramString, @WebParam(name = "sectionSet", targetNamespace = "http://imaging.oracle/") DocumentSectionSet paramDocumentSectionSet) throws ImagingException;
  
  @WebMethod
  @RequestWrapper(localName = "deleteDocument", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.DeleteDocument")
  @ResponseWrapper(localName = "deleteDocumentResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.DeleteDocumentResponse")
  void deleteDocument(@WebParam(name = "documentId", targetNamespace = "") String paramString) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "document", targetNamespace = "http://imaging.oracle/")
  @RequestWrapper(localName = "getDocumentVersion", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.GetDocumentVersion")
  @ResponseWrapper(localName = "getDocumentVersionResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.GetDocumentVersionResponse")
  Document getDocumentVersion(@WebParam(name = "documentId", targetNamespace = "") String paramString, @WebParam(name = "version", targetNamespace = "") long paramLong, @WebParam(name = "sectionSet", targetNamespace = "http://imaging.oracle/") DocumentSectionSet paramDocumentSectionSet) throws ImagingException;
  
  @WebMethod
  @RequestWrapper(localName = "submitToWorkflow", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.SubmitToWorkflow")
  @ResponseWrapper(localName = "submitToWorkflowResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.SubmitToWorkflowResponse")
  void submitToWorkflow(@WebParam(name = "documentId", targetNamespace = "") String paramString) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "appNameIds", targetNamespace = "")
  @RequestWrapper(localName = "listTargetApplications", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.ListTargetApplications")
  @ResponseWrapper(localName = "listTargetApplicationsResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.ListTargetApplicationsResponse")
  List<NameId> listTargetApplications(@WebParam(name = "ability", targetNamespace = "") DocumentAbility paramDocumentAbility) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "document", targetNamespace = "http://imaging.oracle/")
  @RequestWrapper(localName = "lockDocument", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.LockDocument")
  @ResponseWrapper(localName = "lockDocumentResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.LockDocumentResponse")
  Document lockDocument(@WebParam(name = "documentId", targetNamespace = "") String paramString, @WebParam(name = "sectionSet", targetNamespace = "http://imaging.oracle/") DocumentSectionSet paramDocumentSectionSet) throws ImagingException;
  
  @WebMethod
  @RequestWrapper(localName = "updateDocument", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.UpdateDocument")
  @ResponseWrapper(localName = "updateDocumentResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.UpdateDocumentResponse")
  void updateDocument(@WebParam(name = "documentId", targetNamespace = "", mode = WebParam.Mode.INOUT) Holder<String> paramHolder, @WebParam(name = "uploadToken", targetNamespace = "") String paramString, @WebParam(name = "fieldValues", targetNamespace = "") List<FieldValue> paramList, @WebParam(name = "reserved", targetNamespace = "") boolean paramBoolean) throws ImagingException, ValidationException;
  
  @WebMethod
  @RequestWrapper(localName = "deleteDocuments", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.DeleteDocuments")
  @ResponseWrapper(localName = "deleteDocumentsResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.DeleteDocumentsResponse")
  void deleteDocuments(@WebParam(name = "documentIds", targetNamespace = "") List<String> paramList) throws ImagingException;
  
  @WebMethod
  @WebResult(targetNamespace = "")
  @RequestWrapper(localName = "moveDocument", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.MoveDocument")
  @ResponseWrapper(localName = "moveDocumentResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.MoveDocumentResponse")
  String moveDocument(@WebParam(name = "documentId", targetNamespace = "") String paramString, @WebParam(name = "applicationId", targetNamespace = "") NameId paramNameId, @WebParam(name = "fieldValues", targetNamespace = "") List<FieldValue> paramList) throws ImagingException, ValidationException;
  
  @WebMethod
  @RequestWrapper(localName = "copyDocument", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.CopyDocument")
  @ResponseWrapper(localName = "copyDocumentResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.CopyDocumentResponse")
  void copyDocument(@WebParam(name = "documentId", targetNamespace = "", mode = WebParam.Mode.INOUT) Holder<String> paramHolder, @WebParam(name = "applicationId", targetNamespace = "") NameId paramNameId, @WebParam(name = "fieldValues", targetNamespace = "") List<FieldValue> paramList, @WebParam(name = "copyAnnotations", targetNamespace = "") boolean paramBoolean) throws ImagingException, ValidationException;
  
  @WebMethod
  @WebResult(name = "documents", targetNamespace = "")
  @RequestWrapper(localName = "getDocuments", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.GetDocuments")
  @ResponseWrapper(localName = "getDocumentsResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.GetDocumentsResponse")
  List<Document> getDocuments(@WebParam(name = "arg0", targetNamespace = "") List<String> paramList, @WebParam(name = "sectionSet", targetNamespace = "http://imaging.oracle/") DocumentSectionSet paramDocumentSectionSet) throws ImagingException;
  
  @WebMethod
  @RequestWrapper(localName = "modifyPageOrder", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.ModifyPageOrder")
  @ResponseWrapper(localName = "modifyPageOrderResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.ModifyPageOrderResponse")
  void modifyPageOrder(@WebParam(name = "documentId", targetNamespace = "") String paramString, @WebParam(name = "pageChanges", targetNamespace = "") List<PageChange> paramList) throws ImagingException;
  
  @WebMethod
  @RequestWrapper(localName = "setSupportingContent", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.SetSupportingContent")
  @ResponseWrapper(localName = "setSupportingContentResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.SetSupportingContentResponse")
  void setSupportingContent(@WebParam(name = "documentId", targetNamespace = "") String paramString1, @WebParam(name = "key", targetNamespace = "") String paramString2, @WebParam(name = "fileName", targetNamespace = "") String paramString3, @WebParam(name = "data", targetNamespace = "") byte[] paramArrayOfbyte) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "statusChanged", targetNamespace = "")
  @RequestWrapper(localName = "hasStatusChanged", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.HasStatusChanged")
  @ResponseWrapper(localName = "hasStatusChangedResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.HasStatusChangedResponse")
  boolean hasStatusChanged(@WebParam(name = "documentId", targetNamespace = "") String paramString1, @WebParam(name = "status", targetNamespace = "") String paramString2) throws ImagingException;
  
  @WebMethod
  @RequestWrapper(localName = "unlockDocument", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.UnlockDocument")
  @ResponseWrapper(localName = "unlockDocumentResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.UnlockDocumentResponse")
  void unlockDocument(@WebParam(name = "documentId", targetNamespace = "") String paramString) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "supportingContentData", targetNamespace = "")
  @RequestWrapper(localName = "getSupportingContent", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.GetSupportingContent")
  @ResponseWrapper(localName = "getSupportingContentResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.GetSupportingContentResponse")
  byte[] getSupportingContent(@WebParam(name = "documentId", targetNamespace = "") String paramString1, @WebParam(name = "key", targetNamespace = "") String paramString2) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "application", targetNamespace = "http://imaging.oracle/")
  @RequestWrapper(localName = "getTargetApplication", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.GetTargetApplication")
  @ResponseWrapper(localName = "getTargetApplicationResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.documentUpdate.GetTargetApplicationResponse")
  Application getTargetApplication(@WebParam(name = "appNameId", targetNamespace = "") NameId paramNameId) throws ImagingException;
}


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\documentUpdate\DocumentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */