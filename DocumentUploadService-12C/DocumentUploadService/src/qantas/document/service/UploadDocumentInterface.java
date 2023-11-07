package qantas.document.service;

import javax.jws.WebMethod;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import qantas.document.exception.ServiceException;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface UploadDocumentInterface{
	
	@WebMethod String getDocumentURL(
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
			String filePath) throws ServiceException;

	@WebMethod String getDocument(
			@WebParam(targetNamespace="http://service.document.qantas/", name="DocumentType")
			String DocumentType,
			@WebParam(targetNamespace="http://service.document.qantas/", name="SiteID")
			String SiteID,
			@WebParam(targetNamespace="http://service.document.qantas/", name="InvoiceNumber")
			String InvoiceNumber,
			@WebParam(targetNamespace="http://service.document.qantas/", name="FileDownloadPath")
			String FileDownloadPath) throws ServiceException;	
}