package com.fetchupload.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import oracle.imaging.Application;
import oracle.imaging.ApplicationService;
import oracle.imaging.BasicUserToken;
import oracle.imaging.Document;
import oracle.imaging.DocumentContentService;
import oracle.imaging.DocumentService;
import oracle.imaging.FieldType;
import oracle.imaging.ImagingException;
import oracle.imaging.NameId;
import oracle.imaging.ServicesFactory;
import oracle.imaging.UserToken;
import oracle.imaging.WsmUserToken;

public class CreateDocumentImaging {

	public static String createDocument(MetaDataDAO detail, String filePath, String fileName) {

		try { // try-catch
			WsmUserToken credentials = new WsmUserToken("weblogic", "wls123@PSP");
			credentials.setClientPolicy(WsmUserToken.USERNAME_TOKEN_POLICY);

			ServicesFactory servicesFactory = ServicesFactory.login(credentials, Locale.US,
					"http://eqtest-capture1.qantas.com.au:16033/imaging/ws");
			try { // try-finally to ensure logout
				DocumentService docService = servicesFactory.getDocumentService();

				DocumentContentService docContentService = servicesFactory.getDocumentContentService();
				NameId invoicesAppNameId = null;

				// List the viewable applications to confirm that "Invoices" exists
				List<NameId> appsList = docService.listTargetApplications(Document.Ability.CREATEDOCUMENT);
				for (NameId nameId : appsList) {
					if (nameId.getName().equals("Invoices")) {
						invoicesAppNameId = nameId;
					}
				}
				if (invoicesAppNameId == null) {
					System.out.println("Invoices application not found.");
					return "";
				}

				// Upload document content
//				String filePath = "D:\\923018\\Query\\2663817_2_20230112_Seisuke.Kozaki@jetstar.com_A_TR_Kansai International Airport_23011067.pdf.pdf";
				DataHandler fileData = new DataHandler(new FileDataSource(filePath));
				fileName = fileName.substring(fileName.indexOf("_", fileName.indexOf("_") + 20) + 1);
				String uploadToken = docContentService.uploadDocument(fileData, fileName);

				// Index the document
				List<Document.FieldValue> fieldValues = new ArrayList<Document.FieldValue>();
				fieldValues.add(new Document.FieldValue("Source", FieldType.TEXT, detail.getApInvoiceSource()));
				fieldValues
						.add(new Document.FieldValue("Capture Batch ID", FieldType.TEXT, detail.getCaptureBatchId()));
				fieldValues.add(new Document.FieldValue("Username", FieldType.TEXT, detail.getUserName()));
				fieldValues.add(new Document.FieldValue("WFR Username", FieldType.TEXT, detail.getWfrUserName()));
				fieldValues.add(new Document.FieldValue("AP Username", FieldType.TEXT, detail.getApUserName()));
				fieldValues.add(new Document.FieldValue("Activity", FieldType.TEXT, detail.getInvoiceStatus()));
				fieldValues.add(new Document.FieldValue("Invalid Reason", FieldType.TEXT, detail.getInvalidReason()));
				fieldValues.add(new Document.FieldValue("Reason Type", FieldType.TEXT, detail.getReasonType()));
				fieldValues.add(new Document.FieldValue("Internal Status", FieldType.TEXT, detail.getInternalStatus()));
				fieldValues.add(new Document.FieldValue("Priority", FieldType.TEXT, detail.getPriority()));
				fieldValues.add(new Document.FieldValue("Document Type", FieldType.TEXT, detail.getDocumentType()));
				fieldValues.add(new Document.FieldValue("Invoice Type", FieldType.TEXT, detail.getInvoiceType()));
				fieldValues.add(new Document.FieldValue("Supplier ID", FieldType.TEXT, detail.getSupplierId()));
				fieldValues.add(new Document.FieldValue("Supplier Number", FieldType.TEXT, detail.getSupplierNumber()));
				fieldValues.add(new Document.FieldValue("Supplier Name", FieldType.TEXT, detail.getSupplierName()));
				fieldValues.add(new Document.FieldValue("Site ID", FieldType.TEXT, detail.getSiteId()));
				fieldValues.add(new Document.FieldValue("Invoice Number", FieldType.TEXT, detail.getInvoiceNum()));
				fieldValues.add(new Document.FieldValue("PO Number", FieldType.TEXT,
						(detail.getPoNumber() == null ? "" : detail.getPoNumber())));
				fieldValues.add(new Document.FieldValue("Certifier Name", FieldType.TEXT, detail.getCertifierName()));
				fieldValues.add(
						new Document.FieldValue("Approver Name", FieldType.TEXT, detail.getPendingWithApprovedBy()));
				fieldValues.add(new Document.FieldValue("OrgID", FieldType.TEXT, detail.getOrgId()));
				fieldValues.add(new Document.FieldValue("Operating Unit Name", FieldType.TEXT, detail.getName()));
				fieldValues.add(new Document.FieldValue("InvoiceDescription", FieldType.TEXT, detail.getDescription()));
				fieldValues.add(new Document.FieldValue("Currency", FieldType.TEXT, detail.getInvoiceCurrencycode()));
				fieldValues.add(new Document.FieldValue("Invoice Total", FieldType.DECIMAL,
						new BigDecimal(detail.getInvoiceAmount())));
				fieldValues.add(new Document.FieldValue("WHT Amount", FieldType.DECIMAL,
						new BigDecimal(detail.getWithholdingTax())));
				fieldValues.add(
						new Document.FieldValue("Freight", FieldType.DECIMAL, new BigDecimal(detail.getFreight())));
				fieldValues.add(new Document.FieldValue("AOG", FieldType.DECIMAL, new BigDecimal(detail.getAog())));
				fieldValues.add(new Document.FieldValue("Currency Equivalent", FieldType.DECIMAL,
						new BigDecimal(detail.getCurrencyEquivalent())));
				fieldValues.add(new Document.FieldValue("Payment Number", FieldType.TEXT, detail.getPaymentNumber()));
				fieldValues.add(new Document.FieldValue("Invoice Date", FieldType.DATE,
						MetaDataDAO.getDateFromString(detail.getInvoiceDate(), "Invoice Date")));
				fieldValues.add(new Document.FieldValue("Scan Date", FieldType.DATE,
						MetaDataDAO.getDateFromString(detail.getScanDate(), "Scan Date")));
//				fieldValues.add(new Document.FieldValue("Document Creation Date", new Date()));
				fieldValues.add(new Document.FieldValue("Due date", FieldType.DATE,
						MetaDataDAO.getDateFromString(detail.getDueDate(), "Due Date")));

				fieldValues.add(new Document.FieldValue("eQ Interface Date", FieldType.DATETIME,
						MetaDataDAO.getDateTimeFromString(detail.geteQInterfaceDate(), "eQ Interface Date")));
				fieldValues.add(new Document.FieldValue("Payment Date", FieldType.DATE,
						MetaDataDAO.getDateFromString(detail.getPaymentDate(), "Payment Date")));
				fieldValues.add(new Document.FieldValue("Last Updated Date", FieldType.DATETIME,
						MetaDataDAO.getDateTimeFromString(
								detail.getLastUpdateDate() == null ? MetaDataDAO.getCurrentDateCustom()
										: detail.getLastUpdateDate(),
								"Last Updated Date")));
				fieldValues
						.add(new Document.FieldValue("SupplierEmailID", FieldType.TEXT, detail.getSupplierEmailId()));
				fieldValues.add(new Document.FieldValue("InvoiceFilename", FieldType.TEXT, fileName));
				fieldValues.add(new Document.FieldValue("On-Hold", FieldType.TEXT, detail.getInvoiceHoldName()));
				fieldValues.add(new Document.FieldValue("Small_Business", FieldType.TEXT, detail.getSmallBusiness()));
//				if (detail.getInvoiceType().equalsIgnoreCase("PO")) {
//					fieldValues.add(new Document.FieldValue("PO_Hold_Release_Date", FieldType.DATE,
//							MetaDataDAO.getDateFromString(detail.getPoHoldReleaseDate(), "PO_Hold_Release_Date")));

//				} else {
					fieldValues.add(new Document.FieldValue("Findel_Hold_Release_Date", FieldType.DATE, MetaDataDAO
							.getDateFromString(detail.getFindelHoldReleaseDate(), "Findel_Hold_Release_Date")));
					fieldValues.add(new Document.FieldValue("Certification Pending Date", FieldType.DATETIME,
							MetaDataDAO.getDateTimeFromString(detail.getCertificationPendingDate(),
									"Certification Pending Date")));
//				}
				String doc = docService.createDocument(uploadToken, invoicesAppNameId, fieldValues, true);
				System.out.println("Doc : " + doc);
				return doc;
			} finally {
				if (servicesFactory != null) {
					servicesFactory.logout();
				}
			}
		} catch (ImagingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {

	}
}
