package com.fetchupload.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

import ap.quantas.com.imaging.WSSecurityHeaderSOAPHandler;
import ap.quantas.com.imaging.documentUpdate.DocumentService;
import ap.quantas.com.imaging.documentUpdate.DocumentService_Service;
import ap.quantas.com.imaging.documentUpdate.FieldType;
import ap.quantas.com.imaging.documentUpdate.FieldValue;
import ap.quantas.com.imaging.documentUpdate.TypedValue;

public class UploadDocumentImaging {

	public void updateDocCustom(MetaDataDAO detail, String docID) {

		
		System.out.println("12c Updating for DOCID :::" + docID);

		try

		{
			DocumentService docUpdateService = new DocumentService_Service().getDocumentServicePort();
			BindingProvider bindingProvider = (BindingProvider) docUpdateService;
			@SuppressWarnings("rawtypes")
			List<Handler> handlerChain = new ArrayList<Handler>();
			handlerChain.add(new WSSecurityHeaderSOAPHandler("weblogic","wls123@PSP"));

			System.out.println("12c IMAGING CONNECTION SUCCESSFUL -------");
			bindingProvider.getBinding().setHandlerChain(handlerChain);
			List<FieldValue> fieldValues = new ArrayList<FieldValue>();

			{
				FieldValue fieldValue1 = new FieldValue();
				fieldValue1.setName("Activity");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInvoiceStatus());
				System.out.println("\t\t12c detail.getInvoice_status() " + detail.getInvoiceStatus());
				fieldValue1.setValue(typedValue);
				fieldValues.add(fieldValue1);
			}

			{
				FieldValue fieldValue2 = new FieldValue();
				fieldValue2.setName("Approver Name");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getPendingWithApprovedBy());
				System.out.println("\t\t12c detail.getApprover_name() " + detail.getPendingWithApprovedBy());
				fieldValue2.setValue(typedValue);
				fieldValues.add(fieldValue2);
			}

			{
				FieldValue fieldValue3 = new FieldValue();
				fieldValue3.setName("Payment Number");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getPaymentNumber());
				System.out.println("\t\t12c detail.getPayment_number() " + detail.getPaymentNumber());
				fieldValue3.setValue(typedValue);
				fieldValues.add(fieldValue3);
			}

			{
				FieldValue fieldValue4 = new FieldValue();
				fieldValue4.setName("Invoice Number");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInvoiceNum());
				System.out.println("\t\t12c detail.getInvoice_num() " + detail.getInvoiceNum());
				fieldValue4.setValue(typedValue);
				fieldValues.add(fieldValue4);
			}

			{
				FieldValue fieldValue5 = new FieldValue();
				fieldValue5.setName("Payment Date");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DATE);
				typedValue.setValue(detail.getPaymentDate());
				System.out.println("\t\t12c detail.getPayment_date() " + detail.getPaymentDate());
				fieldValue5.setValue(typedValue);
				fieldValues.add(fieldValue5);
			}

			// newly added
			{
				FieldValue fieldValue6 = new FieldValue();
				fieldValue6.setName("Supplier ID");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getSupplierId());
				System.out.println("\t\t12c detail.getSupplier_id() " + detail.getSupplierId());
				fieldValue6.setValue(typedValue);
				fieldValues.add(fieldValue6);
			}

			{
				FieldValue fieldValue7 = new FieldValue();
				fieldValue7.setName("Operating Unit Name");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getOrgId());
				System.out.println("\t\t12c detail.getOperating_unit_name() " + detail.getOrgId());
				fieldValue7.setValue(typedValue);
				fieldValues.add(fieldValue7);
			}

			{
				FieldValue fieldValue8 = new FieldValue();
				fieldValue8.setName("Currency");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInvoiceCurrencycode());
				System.out.println("\t\t12c detail.getCurrency() " + detail.getInvoiceCurrencycode());
				fieldValue8.setValue(typedValue);
				fieldValues.add(fieldValue8);
			}

			{
				FieldValue fieldValue9 = new FieldValue();
				fieldValue9.setName("Invoice Total");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DECIMAL);
				typedValue.setValue(detail.getInvoiceAmount());
				System.out.println("\t\t12c detail.getInvoice_total() " + detail.getInvoiceAmount());
				fieldValue9.setValue(typedValue);
				fieldValues.add(fieldValue9);
			}

			{
				FieldValue fieldValue10 = new FieldValue();
				fieldValue10.setName("AOG");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DECIMAL);
				typedValue.setValue(detail.getAog());
				System.out.println("\t\t12c detail.getAog() " + detail.getAog());
				fieldValue10.setValue(typedValue);
				fieldValues.add(fieldValue10);
			}

			{
				FieldValue fieldValue11 = new FieldValue();
				fieldValue11.setName("Freight");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DECIMAL);
				typedValue.setValue(detail.getFreight());
				System.out.println("\t\t12c detail.getFreight() " + detail.getFreight());
				fieldValue11.setValue(typedValue);
				fieldValues.add(fieldValue11);
			}

			{
				FieldValue fieldValue12 = new FieldValue();
				fieldValue12.setName("Currency Equivalent");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DECIMAL);
				typedValue.setValue(detail.getCurrencyEquivalent());
				System.out.println("\t\t12c detail.getCurrency_equivalent() " + detail.getCurrencyEquivalent());
				fieldValue12.setValue(typedValue);
				fieldValues.add(fieldValue12);
			}

//			{
//				FieldValue fieldValue13 = new FieldValue();
//				fieldValue13.setName("Due date");
//				TypedValue typedValue = new TypedValue();
//				typedValue.setType(FieldType.DATE);
//				typedValue.setValue(detail.getDueDate());
//				System.out.println("\t\t12c detail.getDue_date() " + detail.getDueDate());
//				fieldValue13.setValue(typedValue);
//				fieldValues.add(fieldValue13);
//			}
//
//			{
//				FieldValue fieldValue14 = new FieldValue();
//				fieldValue14.setName("Invoice Date");
//				TypedValue typedValue = new TypedValue();
//				typedValue.setType(FieldType.DATE);
//				typedValue.setValue(detail.getInvoiceDate());
//				System.out.println("\t\t12c detail.getInvoice_date() " + detail.getInvoiceDate());
//				fieldValue14.setValue(typedValue);
//				fieldValues.add(fieldValue14);
//			}

			{
				FieldValue fieldValue15 = new FieldValue();
				fieldValue15.setName("PO Number");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getPoNumber());
				System.out.println("\t\t12c detail.getPo_number() " + detail.getPoNumber());
				fieldValue15.setValue(typedValue);
				fieldValues.add(fieldValue15);
			}

			{
				FieldValue fieldValue16 = new FieldValue();
				fieldValue16.setName("InvoiceDescription");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				String tmpDesc = detail.getDescription();
				System.out.println("\t\t12c detail.getDescription() " + tmpDesc);
				int len = (null != tmpDesc) ? tmpDesc.length() : 0;
				System.out.println("\t\t12c lenght " + len);
				if (len < 200) {
					typedValue.setValue(tmpDesc);
				} else {
					System.out.println("\t\t12c Description() " + tmpDesc.substring(0, 198));
					typedValue.setValue(tmpDesc.substring(0, 198));
				}

//                System.out.println("detail.getDescription() "+detail.getDescription());
				fieldValue16.setValue(typedValue);
				fieldValues.add(fieldValue16);
			}
			// 923018-
			{
				FieldValue fieldValue17 = new FieldValue();
				fieldValue17.setName("Small_Business");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getSmallBusiness());
				System.out.println("\t\t12c detail.getSmall_Business() " + detail.getSmallBusiness());
				fieldValue17.setValue(typedValue);
				fieldValues.add(fieldValue17);
			}

			{
				FieldValue fieldValue18 = new FieldValue();
				fieldValue18.setName("On-Hold");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInvoiceHoldName());
				System.out.println("\t\t12c detail.getInvoice_Hold_Name() " + detail.getInvoiceHoldName());
				fieldValue18.setValue(typedValue);
				fieldValues.add(fieldValue18);
			}

//			{
//				FieldValue fieldValue19 = new FieldValue();
//				fieldValue19.setName("PO_Hold_Release_Date");
//				TypedValue typedValue = new TypedValue();
//				typedValue.setType(FieldType.DATE);
//				typedValue.setValue(detail.getPoHoldReleaseDate());
//				System.out.println("\t\t12c detail.getPo_Hold_Release_Date() " + detail.getPoHoldReleaseDate());
//				fieldValue19.setValue(typedValue);
//				fieldValues.add(fieldValue19);
//			}
//
//			{
//				FieldValue fieldValue20 = new FieldValue();
//				fieldValue20.setName("Findel_Hold_Release_Date");
//				TypedValue typedValue = new TypedValue();
//				typedValue.setType(FieldType.DATE);
//				typedValue.setValue(detail.getFindelHoldReleaseDate());
//				System.out.println("\t\t12c detail.getFindel_Hold_Release_Date() " + detail.getFindelHoldReleaseDate());
//				fieldValue20.setValue(typedValue);
//				fieldValues.add(fieldValue20);
//			}

			// 923018

			docUpdateService.updateDocument(new Holder<String>(docID == null ? "" : docID), null, fieldValues, false);
			System.out.println("\t\t12c Updating Webcenter IPM successful for DocID ---" + docID);
			// noOfMatchedRecords++;

		} catch (Exception e) {
			System.out.println(
					"\t\t12c Updating Webcenter IPM failed for DocID --- " + docID + " with error " + e.getMessage());
			if ("2.IPM_2523145".equalsIgnoreCase(docID)) {
				System.out.println("\t\t12c Not Writting any error for doc id ---" + docID);
			} else {
				e.printStackTrace();
			}

			// e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		
	}
}
