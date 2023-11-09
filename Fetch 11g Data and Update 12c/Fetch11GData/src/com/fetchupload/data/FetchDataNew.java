package com.fetchupload.data;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fetch.data.WriteFile;

public class FetchDataNew {

	public Connection getConnection(String db) {
		Connection conn = null;
		try {
			// step1 load the driver class

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object for Imaging DB

			if (db.equalsIgnoreCase("eqfiles")) {
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@eqprod-db1.qantas.com.au:16010:PSOADB.qantas.com.au", "eqfiles",
						"soaprod008"); // prod
//				conn = DriverManager.getConnection("jdbc:oracle:thin:@eqdr-db1:16010:SOAPSP.qantas.com.au", "eqfiles",
//						"soapSp009"); // psp
			} else {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@eqprod-db1.qantas.com.au:16010:ebs_PEBSDB",
						"appsview", "Password08"); // prod
//				conn = DriverManager.getConnection("jdbc:oracle:thin:@eqprod-db1.qantas.com.au:16010:ebs_PEBSDB",
//						"appsview", "Password08"); // psp
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void callApInvoiceQuery(String docId) {
		// Eqfiles Db Detail
		Connection connEqfiles = getConnection("eqfiles");
		PreparedStatement preparedStatementEqfiles = null;
		ResultSet resultSetEqfiles = null;
		String captureBatchId = "";

		try {
			String queryEqfiles = "select HEADER_ATTR7 from JS_AP_INVOICE_TABLE where DOC_ID=? and INTERNAL_STATUS='INVOICE IN AP INTERFACE'";
			preparedStatementEqfiles = connEqfiles.prepareStatement(queryEqfiles);
			preparedStatementEqfiles.setString(1, docId);
			resultSetEqfiles = preparedStatementEqfiles.executeQuery();
			while (resultSetEqfiles.next()) {
				captureBatchId = resultSetEqfiles.getString(1);
			}
		} catch (Exception e) {
			try {
				resultSetEqfiles.close();
				preparedStatementEqfiles.close();
				connEqfiles.close();
				System.out.println("Eqfiles DB Connection Close Catch : " + connEqfiles.isClosed());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				resultSetEqfiles.close();
				preparedStatementEqfiles.close();
				connEqfiles.close();
				System.out.println("Eqfiles DB Connection Close : " + connEqfiles.isClosed());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public List<String> callAppsDbFirstQuery() {
		// Apps Db Detail
		Connection connApps = getConnection("apps");
		PreparedStatement preparedStatementApps = null;
		ResultSet resultSetApps = null;
		List<String> appsList = new ArrayList<>();
//		appsList.add("4.IPM_021435");
		appsList.add("3.IPM_1995635");
		appsList.add("3.IPM_1995640");
		appsList.add("3.IPM_1995654");
		appsList.add("3.IPM_1995743");
		appsList.add("3.IPM_1995849");
		appsList.add("3.IPM_1995864");
		appsList.add("3.IPM_1995922");
		appsList.add("3.IPM_1995945");
		appsList.add("3.IPM_1995946");
		appsList.add("3.IPM_1995224");

//		try {
//			String queryAppsFirst = "SELECT qd.*,ai.wfapproval_status,ai.payment_status_flag,ai.attribute15 eQ_Image_URL FROM apps.qfeq_owc_image_url_dispute qd, apps.ap_invoices_all ai WHERE qd.invoice_number = ai.invoice_num(+) AND QD.SITE_ID = AI.VENDOR_SITE_ID(+)  AND ai.payment_status_flag = 'Y' and qd.source='JETSTAR'";
//			preparedStatementApps = connApps.prepareStatement(queryAppsFirst);
//			resultSetApps = preparedStatementApps.executeQuery();
//			while (resultSetApps.next()) {
//				System.out.println("First : " + resultSetApps.getString(1));
//				appsList.add(resultSetApps.getString("DOC_ID"));
//
//			}
//		} catch (Exception e) {
//			try {
//				resultSetApps.close();
//				preparedStatementApps.close();
//				connApps.close();
//				System.out.println("Apps DB Big Connection Close Catch : " + connApps.isClosed());
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//			e.printStackTrace();
//		} finally {
//			try {
//				resultSetApps.close();
//				preparedStatementApps.close();
//				connApps.close();
//				System.out.println("Apps DB Big Connection Close : " + connApps.isClosed());
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		return appsList;
	}

	public String getFilePath(String value) {
		ReadExcelSheetData r = new ReadExcelSheetData();
		String filePath = null;
		String fileName = null;
		try {
			filePath = r.getMapData(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;

	}

	public String getFileName(String filePath) {
		return new File(filePath).getName();
	}

	public void callFirstQuery() {
		// Apps Db Detail
		Connection connApps = null;
		PreparedStatement preparedStatementApps = null;
		ResultSet resultSetApps = null;
		List<MetaDataDAO> metaDataList = new ArrayList<>();
		MetaDataDAO metaDataDAO = null;

		// Eqfiles Db Detail
		Connection connEqfiles = null;
		PreparedStatement preparedStatementEqfiles = null;
		ResultSet resultSetEqfiles = null;
		String captureBatchId = "";
		boolean status = false;
		String filePath = null;
		String fileName = null;
		String invoiceId = null;
		String siteId = null;
		List<DocIDDAO> docIdList = new ArrayList<>();
		List<String> appsList = callAppsDbFirstQuery();
		for (String firstQueryDocId : appsList) {
			System.out.println("Doc Id : " + firstQueryDocId);
			try {
				connEqfiles = getConnection("eqfiles");
				String queryEqfiles = "select * from JS_AP_INVOICE_TABLE where DOC_ID=? and INTERNAL_STATUS='INVOICE IN AP INTERFACE'";
				preparedStatementEqfiles = connEqfiles.prepareStatement(queryEqfiles);
				preparedStatementEqfiles.setString(1, firstQueryDocId);
				resultSetEqfiles = preparedStatementEqfiles.executeQuery();

				while (resultSetEqfiles.next()) {
					metaDataDAO = new MetaDataDAO();
					metaDataDAO.setCaptureBatchId(resultSetEqfiles.getString("HEADER_ATTR7"));
					filePath = getFilePath(resultSetEqfiles.getString("HEADER_ATTR7"));
					fileName = getFileName(filePath);
					metaDataDAO.setInvalidReason(resultSetEqfiles.getString("INVALID_REASON"));
					metaDataDAO.setReasonType(resultSetEqfiles.getString("INVALID_REASON_TYPE"));
					metaDataDAO.setInternalStatus(resultSetEqfiles.getString("INTERNAL_STATUS"));
					metaDataDAO.setPriority(resultSetEqfiles.getString("HEADER_ATTR5"));
					metaDataDAO.setDocumentType(resultSetEqfiles.getString("DOCUMENT_TYPE"));
					if (resultSetEqfiles.getString("INVOICE_TYPE").trim().contains("Non")) {
						System.out.println("Setting Data");
						metaDataDAO.setInvoiceType("NO-PO");
					} else {
						metaDataDAO.setInvoiceType(resultSetEqfiles.getString("INVOICE_TYPE"));
					}
//					metaDataDAO.setInvoiceType(resultSetEqfiles.getString("INVOICE_TYPE"));
					metaDataDAO.setSupplierName(resultSetEqfiles.getString("SUPPLIER_NAME"));
					metaDataDAO.setCertifierName(resultSetEqfiles.getString("CERTIFIER_NAME"));
					metaDataDAO.setScanDate(resultSetEqfiles.getString("HEADER_ATTR6"));
					metaDataDAO.seteQInterfaceDate(resultSetEqfiles.getString("MODIFIED_ON"));
					metaDataDAO.setSupplierEmailId(resultSetEqfiles.getString("CERTIFIER_EMAIL_ADD"));
					metaDataDAO.setCertificationPendingDate(resultSetEqfiles.getString("CERTIFICATION_DATE"));
					captureBatchId = resultSetEqfiles.getString(1);
//					metaDataDAO.setSource("JETSTAR INVOICE");
					metaDataDAO.setUserName("");
					metaDataDAO.setWfrUserName("");
					metaDataDAO.setApUserName("");
				}
			} catch (Exception e) {
				try {
					resultSetEqfiles.close();
					preparedStatementEqfiles.close();
					connEqfiles.close();
					System.out.println("Eqfiles DB Connection Close Catch : " + connEqfiles.isClosed());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				try {
					resultSetEqfiles.close();
					preparedStatementEqfiles.close();
					connEqfiles.close();
					System.out.println("Eqfiles DB Connection Close : " + connEqfiles.isClosed());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			try {
				connApps = getConnection("apps");
				preparedStatementApps = connApps.prepareStatement(Utilty.bigAppsQuery);
				preparedStatementApps.setString(1, firstQueryDocId);
				resultSetApps = preparedStatementApps.executeQuery();
				while (resultSetApps.next()) {
					status = true;
//					metaDataDAO = new MetaDataDAO();
					invoiceId = resultSetApps.getString(1);
					siteId = resultSetApps.getString(5);
					System.out.println("Invoice Number : " + resultSetApps.getString(1));
					System.out.println("Invoice Id : " + resultSetApps.getString(2));
					metaDataDAO.setInvoiceNum(resultSetApps.getString(1));
					metaDataDAO.setInvoiceId(resultSetApps.getString(2));
					metaDataDAO.setSupplierNumber(resultSetApps.getString(3));
					metaDataDAO.setSupplierId(resultSetApps.getString(4));
					metaDataDAO.setSiteId(resultSetApps.getString(5));
					metaDataDAO.setOrgId(resultSetApps.getString(6));
					metaDataDAO.setName(resultSetApps.getString(7));
					metaDataDAO.setInvoiceCurrencycode(resultSetApps.getString(8));
					metaDataDAO.setInvoiceAmount(resultSetApps.getString(9));
					metaDataDAO.setInvoiceDate(resultSetApps.getString(10));
					metaDataDAO.setFreight(resultSetApps.getString(11));
					metaDataDAO.setAog(resultSetApps.getString(12));
					metaDataDAO.setDueDate(resultSetApps.getString(13));
					metaDataDAO.setWithholdingTax(resultSetApps.getString(14));
					metaDataDAO.setPoNumber(resultSetApps.getString(15));
					System.out.println(resultSetApps.getString(16));
					if (resultSetApps.getString(17).contains("JETSTAR")) {
						metaDataDAO.setApInvoiceSource("JETSTAR INVOICE");
					} else {
						metaDataDAO.setApInvoiceSource("P2P INVOICE");
					}
					metaDataDAO.setCurrencyEquivalent(resultSetApps.getString(18));
					metaDataDAO.setImageUrl(resultSetApps.getString(19));
					metaDataDAO.setImageUrl2(resultSetApps.getString(20));
					metaDataDAO.setImageUrl3(resultSetApps.getString(21));
					metaDataDAO.setInvoiceStatus(resultSetApps.getString(22));
					metaDataDAO.setPendingWithApprovedBy(resultSetApps.getString(23));
					metaDataDAO.setActionDate(resultSetApps.getString(24));
					metaDataDAO.setPaymentNumber(resultSetApps.getString(25));
					metaDataDAO.setPaymentDate(resultSetApps.getString(26));
					metaDataDAO.setDescription(resultSetApps.getString(27));
					metaDataDAO.setSmallBusiness(resultSetApps.getString(28));
					metaDataDAO.setInvoiceHoldName(resultSetApps.getString(29));
					metaDataDAO.setPoHoldReleaseDate(resultSetApps.getString(30));
					metaDataDAO.setFindelHoldReleaseDate(resultSetApps.getString(31));
					metaDataList.add(metaDataDAO);

				}
				System.out.println("Data : " + metaDataDAO.toString());
//				CreateDocumentSample.createDocumentTest(metaDataDAO);
				if (status == true) {
					status = false;
					String doc = CreateDocumentImaging.createDocument(metaDataDAO,
//							filePath, fileName);
							"C:\\Users\\2292543\\Downloads\\2663817_2_20230112_Seisuke.Kozaki@jetstar.com_A_TR_Kansai International Airport_23011067.pdf.pdf",
							"2663817_2_20230112_Seisuke.Kozaki@jetstar.com_A_TR_Kansai International Airport_23011067.pdf.pdf");
					if (doc != null && !doc.equalsIgnoreCase("")) {
						docIdList.add(new DocIDDAO(doc, firstQueryDocId, invoiceId, siteId));
					}
					invoiceId = "";
					siteId = "";
				}
			} catch (Exception e) {
				try {
					resultSetApps.close();
					preparedStatementApps.close();
					connApps.close();
					System.out.println("Apps DB Connection Close Catch : " + connApps.isClosed());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				try {
					resultSetApps.close();
					preparedStatementApps.close();
					connApps.close();
					System.out.println("Apps DB Connection Close : " + connApps.isClosed());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		WriteXLSX.writeDataToExcel("./DocIdList.xlsx", docIdList);
	}

	public static void main(String[] args) {

		FetchDataNew dataNew = new FetchDataNew();
		dataNew.callFirstQuery();

//		// Apps Db Detail
//		Connection connApps = null;
//		PreparedStatement preparedStatementApps = null;
//		ResultSet resultSetApps = null;
//
//		try {
//			// step1 load the driver class
//
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//
//			// step2 create the connection object for Imaging DB
//
//			connApps = DriverManager.getConnection("jdbc:oracle:thin:@eqprod-db1.qantas.com.au:16010:ebs_PEBSDB",
//					"appsview", "Password08");
//
//			String queryAppsFirst = "SELECT qd.*,ai.wfapproval_status,ai.payment_status_flag,ai.attribute15 eQ_Image_URL FROM apps.qfeq_owc_image_url_dispute qd, apps.ap_invoices_all ai WHERE qd.invoice_number = ai.invoice_num(+) AND QD.SITE_ID = AI.VENDOR_SITE_ID(+)  AND ai.payment_status_flag = 'Y'";
//			preparedStatementApps = connApps.prepareStatement(queryAppsFirst);
//			resultSetApps = preparedStatementApps.executeQuery();
//			while (resultSetApps.next()) {
//				System.out.println("First : " + resultSetApps.getString(1));
//			}
//
//		} catch (Exception e) {
//			try {
//				resultSetApps.close();
//				preparedStatementApps.close();
//				connApps.close();
//				System.out.println("Apps DB Connection Close Catch : " + connApps.isClosed());
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//			e.printStackTrace();
//		} finally {
//			try {
//				resultSetApps.close();
//				preparedStatementApps.close();
//				connApps.close();
//				System.out.println("Apps DB Connection Close : " + connApps.isClosed());
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
	}
}
