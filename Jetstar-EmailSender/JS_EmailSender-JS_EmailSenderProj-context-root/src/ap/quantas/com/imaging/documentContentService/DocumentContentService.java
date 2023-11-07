package ap.quantas.com.imaging.documentContentService;

import ap.quantas.com.imaging.documentContentService.ImagingException;
import ap.quantas.com.imaging.documentContentService.ObjectFactory;
import ap.quantas.com.imaging.documentContentService.RenderOptions;
import ap.quantas.com.imaging.documentContentService.RenderResult;
import ap.quantas.com.imaging.documentContentService.Rendition;
import ap.quantas.com.imaging.documentContentService.RenditionOutput;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "DocumentContentService", targetNamespace = "http://imaging.oracle/")
@XmlSeeAlso({ObjectFactory.class})
public interface DocumentContentService {
  @WebMethod
  @WebResult(name = "documentData", targetNamespace = "")
  @RequestWrapper(localName = "retrieve", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.Retrieve")
  @ResponseWrapper(localName = "retrieveResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.RetrieveResponse")
  byte[] retrieve(@WebParam(name = "documentId", targetNamespace = "") String paramString) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "rendition", targetNamespace = "")
  @RequestWrapper(localName = "retrieveRendition", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.RetrieveRendition")
  @ResponseWrapper(localName = "retrieveRenditionResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.RetrieveRenditionResponse")
  Rendition retrieveRendition(@WebParam(name = "documentId", targetNamespace = "") String paramString, @WebParam(name = "withAnnotations", targetNamespace = "") boolean paramBoolean1, @WebParam(name = "preserveColor", targetNamespace = "") boolean paramBoolean2, @WebParam(name = "outputType", targetNamespace = "") RenditionOutput paramRenditionOutput, @WebParam(name = "pages", targetNamespace = "") List<Integer> paramList) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "renderResult", targetNamespace = "")
  @RequestWrapper(localName = "retrieveVersionPage", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.RetrieveVersionPage")
  @ResponseWrapper(localName = "retrieveVersionPageResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.RetrieveVersionPageResponse")
  RenderResult retrieveVersionPage(@WebParam(name = "documentId", targetNamespace = "") String paramString, @WebParam(name = "versionId", targetNamespace = "") long paramLong, @WebParam(name = "options", targetNamespace = "") RenderOptions paramRenderOptions) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "uploadToken", targetNamespace = "")
  @RequestWrapper(localName = "uploadDocument", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.UploadDocument")
  @ResponseWrapper(localName = "uploadDocumentResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.UploadDocumentResponse")
  String uploadDocument(@WebParam(name = "data", targetNamespace = "") byte[] paramArrayOfbyte, @WebParam(name = "fileName", targetNamespace = "") String paramString) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "documentData", targetNamespace = "")
  @RequestWrapper(localName = "retrieveVersion", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.RetrieveVersion")
  @ResponseWrapper(localName = "retrieveVersionResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.RetrieveVersionResponse")
  byte[] retrieveVersion(@WebParam(name = "documentId", targetNamespace = "") String paramString, @WebParam(name = "versionId", targetNamespace = "") long paramLong) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "rendition", targetNamespace = "")
  @RequestWrapper(localName = "retrieveVersionRendition", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.RetrieveVersionRendition")
  @ResponseWrapper(localName = "retrieveVersionRenditionResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.RetrieveVersionRenditionResponse")
  Rendition retrieveVersionRendition(@WebParam(name = "documentId", targetNamespace = "") String paramString, @WebParam(name = "versionId", targetNamespace = "") long paramLong, @WebParam(name = "withAnnotations", targetNamespace = "") boolean paramBoolean1, @WebParam(name = "preserveColor", targetNamespace = "") boolean paramBoolean2, @WebParam(name = "outputType", targetNamespace = "") RenditionOutput paramRenditionOutput, @WebParam(name = "pages", targetNamespace = "") List<Integer> paramList) throws ImagingException;
  
  @WebMethod
  @WebResult(name = "renderResult", targetNamespace = "")
  @RequestWrapper(localName = "retrievePage", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.RetrievePage")
  @ResponseWrapper(localName = "retrievePageResponse", targetNamespace = "http://imaging.oracle/", className = "ap.quantas.com.imaging.documentContentService.RetrievePageResponse")
  RenderResult retrievePage(@WebParam(name = "documentId", targetNamespace = "") String paramString, @WebParam(name = "options", targetNamespace = "") RenderOptions paramRenderOptions) throws ImagingException;
}


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\DocumentContentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */