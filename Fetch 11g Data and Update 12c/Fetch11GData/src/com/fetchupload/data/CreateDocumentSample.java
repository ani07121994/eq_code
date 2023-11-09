package com.fetchupload.data;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import ap.quantas.com.imaging.WSSecurityHeaderSOAPHandler;
import ap.quantas.com.imaging.documentContentService.DocumentContentService;
import ap.quantas.com.imaging.documentContentService.DocumentContentService_Service;
import ap.quantas.com.imaging.documentUpdate.DocumentAbility;
import ap.quantas.com.imaging.documentUpdate.DocumentService_Service;
import ap.quantas.com.imaging.documentUpdate.FieldType;
import ap.quantas.com.imaging.documentUpdate.FieldValue;
import ap.quantas.com.imaging.documentUpdate.NameId;
import ap.quantas.com.imaging.documentUpdate.TypedValue;

public class CreateDocumentSample {

	public static void createDocumentTest(MetaDataDAO detail) {
		try {
			ap.quantas.com.imaging.documentUpdate.DocumentService docService = new DocumentService_Service()
					.getDocumentServicePort();
			BindingProvider bindingProvider = (BindingProvider) docService;
			List<Handler> handlerChain = new ArrayList<Handler>();
			handlerChain.add(new WSSecurityHeaderSOAPHandler("weblogic", "wls123@PSP"));

			DocumentContentService docContentService = new DocumentContentService_Service()
					.getDocumentContentServicePort();
			BindingProvider bindingProviderContentService = (BindingProvider) docContentService;
			List<Handler> handlerChainContentService = new ArrayList<Handler>();
			handlerChainContentService.add(new WSSecurityHeaderSOAPHandler("weblogic", "wls123@PSP"));

			System.out.println("12c IMAGING CONNECTION SUCCESSFUL -------");
			bindingProvider.getBinding().setHandlerChain(handlerChain);
			bindingProviderContentService.getBinding().setHandlerChain(handlerChainContentService);

			NameId invoicesAppNameId = null;

			// List the viewable applications to confirm that "Invoices" exists
			List<NameId> appsList = docService.listTargetApplications(DocumentAbility.CREATEDOCUMENT);
			for (NameId nameId : appsList) {
				if (nameId.getName().equals("Invoices")) {
					invoicesAppNameId = nameId;
				}
			}
			if (invoicesAppNameId == null) {
				System.out.println("Invoices application not found.");
				return;
			}

			// Upload document content
			String filePath = "D:\\Share\\WFR_NewImaging_Jetstar_sorted\\2663817_2_20230112_Seisuke.Kozaki@jetstar.com_A_TR_Kansai International Airport_23011067.pdf.pdf";
			DataHandler fileData = new DataHandler(new FileDataSource(filePath));
			byte[] bytes = Files.readAllBytes(new File(filePath).toPath());
			String fileName = "2663817_2_20230112_Seisuke.Kozaki@jetstar.com_A_TR_Kansai International Airport_23011067.pdf.pdf";
			fileName = fileName.substring(fileName.indexOf("_", fileName.indexOf("_") + 20) + 1);
			String uploadToken = docContentService.uploadDocument(bytes,
					"2663817_2_20230112_Seisuke.Kozaki@jetstar.com_A_TR_Kansai International Airport_23011067.pdf.pdf");

			List<FieldValue> fieldValues = new ArrayList<FieldValue>();

			{
				FieldValue fieldValue1 = new FieldValue();
				fieldValue1.setName("Source");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getSource());
				System.out.println("\t\t12c detail.getSource() " + detail.getSource());
				fieldValue1.setValue(typedValue);
				fieldValues.add(fieldValue1);
			}

			{
				FieldValue fieldValue2 = new FieldValue();
				fieldValue2.setName("Capture Batch ID");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getCaptureBatchId());
				System.out.println("\t\t12c detail.getCaptureBatchId() " + detail.getCaptureBatchId());
				fieldValue2.setValue(typedValue);
				fieldValues.add(fieldValue2);
			}

			{
				FieldValue fieldValue3 = new FieldValue();
				fieldValue3.setName("Username");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getUserName());
				System.out.println("\t\t12c detail.getUserName() " + detail.getUserName());
				fieldValue3.setValue(typedValue);
				fieldValues.add(fieldValue3);
			}

			{
				FieldValue fieldValue4 = new FieldValue();
				fieldValue4.setName("WFR Username");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getWfrUserName());
				System.out.println("\t\t12c detail.getWfrUserName() " + detail.getWfrUserName());
				fieldValue4.setValue(typedValue);
				fieldValues.add(fieldValue4);
			}

			{
				FieldValue fieldValue5 = new FieldValue();
				fieldValue5.setName("AP Username");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getApUserName());
				System.out.println("\t\t12c detail.getApUserName() " + detail.getApUserName());
				fieldValue5.setValue(typedValue);
				fieldValues.add(fieldValue5);
			}

			{
				FieldValue fieldValue6 = new FieldValue();
				fieldValue6.setName("Activity");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInvoiceStatus());
				System.out.println("\t\t12c detail.getInvoiceStatus() " + detail.getInvoiceStatus());
				fieldValue6.setValue(typedValue);
				fieldValues.add(fieldValue6);
			}

			{
				FieldValue fieldValue7 = new FieldValue();
				fieldValue7.setName("Invalid Reason");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInvalidReason());
				System.out.println("\t\t12c detail.getInvalidReason() " + detail.getInvalidReason());
				fieldValue7.setValue(typedValue);
				fieldValues.add(fieldValue7);
			}

			{
				FieldValue fieldValue8 = new FieldValue();
				fieldValue8.setName("Reason Type");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getReasonType());
				System.out.println("\t\t12c detail.getReasonType() " + detail.getReasonType());
				fieldValue8.setValue(typedValue);
				fieldValues.add(fieldValue8);
			}

			{
				FieldValue fieldValue9 = new FieldValue();
				fieldValue9.setName("Internal Status");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInternalStatus());
				System.out.println("\t\t12c detail.getInternalStatus() " + detail.getInternalStatus());
				fieldValue9.setValue(typedValue);
				fieldValues.add(fieldValue9);
			}

			{
				FieldValue fieldValue10 = new FieldValue();
				fieldValue10.setName("Priority");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getPriority());
				System.out.println("\t\t12c detail.getPriority() " + detail.getPriority());
				fieldValue10.setValue(typedValue);
				fieldValues.add(fieldValue10);
			}

			{
				FieldValue fieldValue11 = new FieldValue();
				fieldValue11.setName("Document Type");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getDocumentType());
				System.out.println("\t\t12c detail.getDocumentType() " + detail.getDocumentType());
				fieldValue11.setValue(typedValue);
				fieldValues.add(fieldValue11);
			}

			{
				FieldValue fieldValue12 = new FieldValue();
				fieldValue12.setName("Invoice Type");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInvoiceType());
				System.out.println("\t\t12c detail.getInvoiceType() " + detail.getInvoiceType());
				fieldValue12.setValue(typedValue);
				fieldValues.add(fieldValue12);
			}

			{
				FieldValue fieldValue13 = new FieldValue();
				fieldValue13.setName("Supplier ID");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getSupplierId());
				System.out.println("\t\t12c detail.getSupplierId() " + detail.getSupplierId());
				fieldValue13.setValue(typedValue);
				fieldValues.add(fieldValue13);
			}

			{
				FieldValue fieldValue14 = new FieldValue();
				fieldValue14.setName("Supplier Number");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getSupplierNumber());
				System.out.println("\t\t12c detail.getSupplierNumber() " + detail.getSupplierNumber());
				fieldValue14.setValue(typedValue);
				fieldValues.add(fieldValue14);
			}

			{
				FieldValue fieldValue15 = new FieldValue();
				fieldValue15.setName("Supplier Name");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getSupplierName());
				System.out.println("\t\t12c detail.getSupplierName() " + detail.getSupplierName());
				fieldValue15.setValue(typedValue);
				fieldValues.add(fieldValue15);
			}

			{
				FieldValue fieldValue16 = new FieldValue();
				fieldValue16.setName("Site ID");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getSiteId());
				System.out.println("\t\t12c detail.getSiteId() " + detail.getSiteId());
				fieldValue16.setValue(typedValue);
				fieldValues.add(fieldValue16);
			}
			// 923018-
			{
				FieldValue fieldValue17 = new FieldValue();
				fieldValue17.setName("Invoice Number");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInvoiceNum());
				System.out.println("\t\t12c detail.getInvoiceNum() " + detail.getInvoiceNum());
				fieldValue17.setValue(typedValue);
				fieldValues.add(fieldValue17);
			}

			{
				FieldValue fieldValue18 = new FieldValue();
				fieldValue18.setName("PO Number");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getPoNumber());
				System.out.println("\t\t12c detail.getPoNumber() " + detail.getPoNumber());
				fieldValue18.setValue(typedValue);
				fieldValues.add(fieldValue18);
			}

			{
				FieldValue fieldValue19 = new FieldValue();
				fieldValue19.setName("Certifier Name");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getCertifierName());
				System.out.println("\t\t12c detail.getCertifierName() " + detail.getCertifierName());
				fieldValue19.setValue(typedValue);
				fieldValues.add(fieldValue19);
			}

			{
				FieldValue fieldValue20 = new FieldValue();
				fieldValue20.setName("Approver Name");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getPendingWithApprovedBy());
				System.out.println("\t\t12c detail.getPendingWithApprovedBy() " + detail.getPendingWithApprovedBy());
				fieldValue20.setValue(typedValue);
				fieldValues.add(fieldValue20);
			}

			{
				FieldValue fieldValue21 = new FieldValue();
				fieldValue21.setName("Operating Unit Name");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getName());
				System.out.println("\t\t12c detail.getName() " + detail.getName());
				fieldValue21.setValue(typedValue);
				fieldValues.add(fieldValue21);
			}

			{
				FieldValue fieldValue22 = new FieldValue();
				fieldValue22.setName("Currency");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInvoiceCurrencycode());
				System.out.println("\t\t12c detail.getInvoiceCurrencycode() " + detail.getInvoiceCurrencycode());
				fieldValue22.setValue(typedValue);
				fieldValues.add(fieldValue22);
			}

			{
				FieldValue fieldValue23 = new FieldValue();
				fieldValue23.setName("Invoice Total");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DECIMAL);
				typedValue.setValue(detail.getInvoiceAmount());
				System.out.println("\t\t12c detail.getInvoiceAmount() " + detail.getInvoiceAmount());
				fieldValue23.setValue(typedValue);
				fieldValues.add(fieldValue23);
			}

			{
				FieldValue fieldValue24 = new FieldValue();
				fieldValue24.setName("WHT Amount");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DECIMAL);
				typedValue.setValue(detail.getWithholdingTax());
				System.out.println("\t\t12c detail.getWithholdingTax() " + detail.getWithholdingTax());
				fieldValue24.setValue(typedValue);
				fieldValues.add(fieldValue24);
			}

			{
				FieldValue fieldValue25 = new FieldValue();
				fieldValue25.setName("Freight");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DECIMAL);
				typedValue.setValue(detail.getFreight());
				System.out.println("\t\t12c detail.getFreight() " + detail.getFreight());
				fieldValue25.setValue(typedValue);
				fieldValues.add(fieldValue25);
			}

			{
				FieldValue fieldValue26 = new FieldValue();
				fieldValue26.setName("AOG");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DECIMAL);
				typedValue.setValue(detail.getAog());
				System.out.println("\t\t12c detail.getAog() " + detail.getAog());
				fieldValue26.setValue(typedValue);
				fieldValues.add(fieldValue26);
			}

			{
				FieldValue fieldValue27 = new FieldValue();
				fieldValue27.setName("Currency Equivalent");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DECIMAL);
				typedValue.setValue(detail.getCurrencyEquivalent());
				System.out.println("\t\t12c detail.getCurrencyEquivalent() " + detail.getCurrencyEquivalent());
				fieldValue27.setValue(typedValue);
				fieldValues.add(fieldValue27);
			}

			{
				FieldValue fieldValue28 = new FieldValue();
				fieldValue28.setName("Payment Number");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getPaymentNumber());
				System.out.println("\t\t12c detail.getPaymentNumber() " + detail.getPaymentNumber());
				fieldValue28.setValue(typedValue);
				fieldValues.add(fieldValue28);
			}

//			{
//				FieldValue fieldValue29 = new FieldValue();
//				fieldValue29.setName("Invoice Date");
//				TypedValue typedValue = new TypedValue();
//				typedValue.setType(FieldType.DATE);
//				typedValue.setValue(detail.getInvoiceDate());
//				System.out.println("\t\t12c detail.getInvoiceDate() " + detail.getInvoiceDate());
//				fieldValue29.setValue(typedValue);
//				fieldValues.add(fieldValue29);
//			}
//
//			{
//				FieldValue fieldValue30 = new FieldValue();
//				fieldValue30.setName("Scan Date");
//				TypedValue typedValue = new TypedValue();
//				typedValue.setType(FieldType.DATE);
//				typedValue.setValue(detail.getScanDate());
//				System.out.println("\t\t12c detail.getScanDate() " + detail.getScanDate());
//				fieldValue30.setValue(typedValue);
//				fieldValues.add(fieldValue30);
//			}

			{
				FieldValue fieldValue31 = new FieldValue();
				fieldValue31.setName("Document Creation Date");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DATE);
				typedValue.setValue("");
				System.out.println("\t\t12c detail.getDocumentCreationDate " + null);
				fieldValue31.setValue(typedValue);
				fieldValues.add(fieldValue31);
			}

//			{
//				FieldValue fieldValue32 = new FieldValue();
//				fieldValue32.setName("Due date");
//				TypedValue typedValue = new TypedValue();
//				typedValue.setType(FieldType.DATE);
//				typedValue.setValue(detail.getDueDate());
//				System.out.println("\t\t12c detail.getDueDate() " + detail.getDueDate());
//				fieldValue32.setValue(typedValue);
//				fieldValues.add(fieldValue32);
//			}

			{
				FieldValue fieldValue33 = new FieldValue();
				fieldValue33.setName("Certification Pending Date");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DATE);
				typedValue.setValue(detail.getCertificationPendingDate());
				System.out.println(
						"\t\t12c detail.getCertificationPendingDate() " + detail.getCertificationPendingDate());
				fieldValue33.setValue(typedValue);
				fieldValues.add(fieldValue33);
			}

			{
				FieldValue fieldValue34 = new FieldValue();
				fieldValue34.setName("eQ Interface Date");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DATE);
				typedValue.setValue(detail.geteQInterfaceDate());
				System.out.println("\t\t12c detail.geteQInterfaceDate() " + detail.geteQInterfaceDate());
				fieldValue34.setValue(typedValue);
				fieldValues.add(fieldValue34);
			}

			{
				FieldValue fieldValue35 = new FieldValue();
				fieldValue35.setName("Payment Date");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DATE);
				typedValue.setValue(detail.getPaymentDate());
				System.out.println("\t\t12c detail.getPaymentDate() " + detail.getPaymentDate());
				fieldValue35.setValue(typedValue);
				fieldValues.add(fieldValue35);
			}

			{
				FieldValue fieldValue36 = new FieldValue();
				fieldValue36.setName("Last Updated Date");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DATE);
				typedValue.setValue(detail.getLastUpdateDate());
				System.out.println("\t\t12c detail.getLastUpdateDate() " + detail.getLastUpdateDate());
				fieldValue36.setValue(typedValue);
				fieldValues.add(fieldValue36);
			}

			{
				FieldValue fieldValue37 = new FieldValue();
				fieldValue37.setName("SupplierEmailID");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getSupplierEmailId());
				System.out.println("\t\t12c detail.getSupplierEmailId() " + detail.getSupplierEmailId());
				fieldValue37.setValue(typedValue);
				fieldValues.add(fieldValue37);
			}

			{
				FieldValue fieldValue38 = new FieldValue();
				fieldValue38.setName("InvoiceFilename");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(fileName);
				System.out.println("\t\t12c detail.getInvoiceFileName() " + fileName);
				fieldValue38.setValue(typedValue);
				fieldValues.add(fieldValue38);
			}

			{
				FieldValue fieldValue39 = new FieldValue();
				fieldValue39.setName("On-Hold");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInvoiceHoldName());
				System.out.println("\t\t12c detail.getInvoiceHoldName() " + detail.getInvoiceHoldName());
				fieldValue39.setValue(typedValue);
				fieldValues.add(fieldValue39);
			}

			{
				FieldValue fieldValue40 = new FieldValue();
				fieldValue40.setName("Small_Business");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getSmallBusiness());
				System.out.println("\t\t12c detail.getSmallBusiness() " + detail.getSmallBusiness());
				fieldValue40.setValue(typedValue);
				fieldValues.add(fieldValue40);
			}

//			{
//				FieldValue fieldValue41 = new FieldValue();
//				fieldValue41.setName("PO_Hold_Release_Date");
//				TypedValue typedValue = new TypedValue();
//				typedValue.setType(FieldType.DATE);
//				typedValue.setValue(detail.getPoHoldReleaseDate());
//				System.out.println("\t\t12c detail.getPoHoldReleaseDate() " + detail.getPoHoldReleaseDate());
//				fieldValue41.setValue(typedValue);
//				fieldValues.add(fieldValue41);
//			}
//
//			{
//				FieldValue fieldValue42 = new FieldValue();
//				fieldValue42.setName("Findel_Hold_Release_Date");
//				TypedValue typedValue = new TypedValue();
//				typedValue.setType(FieldType.DATE);
//				typedValue.setValue(detail.getFindelHoldReleaseDate());
//				System.out.println("\t\t12c detail.getFindel_Hold_Release_Date() " + detail.getFindelHoldReleaseDate());
//				fieldValue42.setValue(typedValue);
//				fieldValues.add(fieldValue42);
//			}

			docService.createDocument(uploadToken, invoicesAppNameId, fieldValues, true);
			
			System.out.println("\t\t12c Updating Webcenter IPM successful for DocID ---");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static void main(String[] args) {

	}
}