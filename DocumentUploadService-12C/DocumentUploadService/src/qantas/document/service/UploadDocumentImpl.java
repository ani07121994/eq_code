package qantas.document.service;

import java.util.Map;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import qantas.document.exception.ServiceException;
import qantas.document.exception.ServiceExceptionBean;
import qantas.document.util.Utility;


//Service Implementation
@WebService(endpointInterface = "qantas.document.service.UploadDocumentImpl")
@HandlerChain(file = "./handler/handler-chain.xml")
public class UploadDocumentImpl implements UploadDocumentInterface/*,SOAPHandler<SOAPMessageContext>*/{

	@SuppressWarnings("rawtypes")
	@WebMethod(operationName = "getDocument")		
	public String getDocument(
			@WebParam(targetNamespace="http://service.document.qantas/", name="DocumentType")
			String DocumentType,
			@WebParam(targetNamespace="http://service.document.qantas/", name="SiteID")
			String SiteID,
			@WebParam(targetNamespace="http://service.document.qantas/", name="InvoiceNumber")
			String InvoiceNumber,
			@WebParam(targetNamespace="http://service.document.qantas/", name="FileDownloadPath")
			String FileDownloadPath) throws ServiceException{
		
		ServiceExceptionBean obj = new ServiceExceptionBean();
		Utility utilObj = new Utility();

		String download_document_name = "";

		//checkMandatory(filePath,obj);

		@SuppressWarnings("unchecked")
		Map<String,String> map = utilObj.fetchValueFromDB();		
		
		DownloadDocument downloadDocObj = new DownloadDocument();
		if(map != null && map.size() > 0){
			map.put("Document_Type",utilObj.handleControlChar(DocumentType));
			map.put("Site_ID",utilObj.handleControlChar(SiteID));
			map.put("Invoice_Number",utilObj.handleControlChar(InvoiceNumber));
			map.put("Download_Path", utilObj.handleControlChar(FileDownloadPath));
			
			download_document_name = downloadDocObj.getDocument(map);
			
		}else
			throw new ServiceException("Mandatory Configuration parameter is missing", obj);
		
		System.out.println("download_document_name=="+download_document_name);
		
		return download_document_name;
	}
	
	@SuppressWarnings("rawtypes")
	@WebMethod(operationName = "getDocumentURL")	
	public String getDocumentURL(
			@WebParam(targetNamespace="http://service.document.qantas/", name="source")
			String source,
			@WebParam(targetNamespace="http://service.document.qantas/", name="DocumentType")
			String DocumentType,
			@WebParam(targetNamespace="http://service.document.qantas/", name="InvoiceType")
			String InvoiceType,
			@WebParam(targetNamespace="http://service.document.qantas/", name="SupplierID")
			String SupplierID,
			@WebParam(targetNamespace="http://service.document.qantas/", name="SupplierNumber")
			String SupplierNumber,
			@WebParam(targetNamespace="http://service.document.qantas/", name="SupplierName")
			String SupplierName,	
			@WebParam(targetNamespace="http://service.document.qantas/", name="SiteID")
			String SiteID,
			@WebParam(targetNamespace="http://service.document.qantas/", name="InvoiceNumber")
			String InvoiceNumber,
			@WebParam(targetNamespace="http://service.document.qantas/", name="CertifierName")
			String CertifierName,
			@WebParam(targetNamespace="http://service.document.qantas/", name="ApproverName")
			String ApproverName,
			@WebParam(targetNamespace="http://service.document.qantas/", name="OrgID")
			String OrgID,
			@WebParam(targetNamespace="http://service.document.qantas/", name="Currency")
			String Currency,			
			@WebParam(targetNamespace="http://service.document.qantas/", name="InvoiceDate")
			String InvoiceDate,
			@WebParam(targetNamespace="http://service.document.qantas/", name="InvoiceTotal")
			String InvoiceTotal,				
			@WebParam(targetNamespace="http://service.document.qantas/", name="filePath")
			String filePath) throws ServiceException{
		
		//trackAuditInfo();
		
		ServiceExceptionBean obj = new ServiceExceptionBean();
		Utility utilObj = new Utility();
		
		String docId        = "";
		String document_url = "";

		checkMandatory(filePath,obj);

		Map<String,String> map = utilObj.fetchValueFromDB();		
		
		UploadDocument uploadDocObj = new UploadDocument();
		if(map != null && map.size() > 0){
						
			map.put("source",utilObj.handleControlChar(source));
			map.put("Document_Type",utilObj.handleControlChar(DocumentType));
			map.put("Invoice_Type",utilObj.handleControlChar(InvoiceType));
			map.put("Supplier_ID",utilObj.handleControlChar(SupplierID));
			map.put("Supplier_Number",utilObj.handleControlChar(SupplierNumber));
			map.put("Supplier_Name",utilObj.handleControlChar(SupplierName));
			map.put("Site_ID",utilObj.handleControlChar(SiteID));
			map.put("Invoice_Number",utilObj.handleControlChar(InvoiceNumber));
			map.put("Certifier_Name",utilObj.handleControlChar(CertifierName));
			map.put("Approver_Name",utilObj.handleControlChar(ApproverName));
			map.put("OrgID",utilObj.handleControlChar(OrgID));
			map.put("Currency",utilObj.handleControlChar(Currency));
			map.put("Invoice_Date",utilObj.handleControlChar(InvoiceDate));
			map.put("Invoice_Total",utilObj.handleControlChar(InvoiceTotal));			
			map.put("upload_path", utilObj.handleControlChar(filePath));
			
			docId = uploadDocObj.getDocId(map);
			
			document_url = (String)map.get("DOC_URL")+docId;
		}else
			throw new ServiceException("Mandatory Configuration parameter is missing", obj);
		
		System.out.println("docId=="+docId);
		return document_url;
	}
	
	private void checkMandatory(String val, ServiceExceptionBean obj ) throws ServiceException
	{
		if(val != null && !"".equals(val) && !val.equals("null")){
			
		}else{
			throw new ServiceException("Mandatory Parameter is missing : FILE PATH",obj);
		}		
	}
	
}