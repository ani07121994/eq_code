package com.query;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.query.dao.ImagingDAO;

public class QueryData {

	public static void main(String[] args) {
		// Imaging Detail
		Connection conImaging = null;
		PreparedStatement preparedStatementImaging = null;
		ResultSet resultSetImaging = null;
		List<ImagingDAO> imagingList = new ArrayList<>();
		ImagingDAO imagingDAO;

		// Apps Detail
		Connection conApps = null;
		PreparedStatement preparedStatementApps = null;
		ResultSet resultSetApps = null;
		List<String[]> listApps = new ArrayList<>();
		LocalDateTime dateTime=LocalDateTime.now();
		try {
			// step1 load the driver class

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object for Imaging DB

			conImaging = DriverManager.getConnection("jdbc:oracle:thin:@eqprod-owc-db1.qantas.com.au:16010:PRODOWC",
					"OWCPRDVIEW12C", "owcview");

			String queryImaging = "SELECT XIPM_APP_1_11 Invoice_Number,XIPM_APP_1_10 Site_ID,XIPM_APP_1_1 activity,XIPM_APP_1_17 scan_dt\r\n"
					+ "FROM OWCPRD12C_OCS.docmeta\r\n" + "WHERE XIPM_APP_1_31='JETSTAR INVOICE'\r\n"
					+ "AND XIPM_APP_1_1 LIKE 'eQ%'\r\n"
					+ "AND XIPM_APP_1_1 IS NOT NULL and (XIPM_APP_1_17 between ? and ?)\r\n"
					+ "order by XIPM_APP_1_17 desc";
			preparedStatementImaging = conImaging.prepareStatement(queryImaging);
			preparedStatementImaging.setString(1, "01-JAN-21");
			preparedStatementImaging.setString(2, "01-JAN-22");
			resultSetImaging = preparedStatementImaging.executeQuery();
			while (resultSetImaging.next()) {
				imagingDAO = new ImagingDAO();
				imagingDAO.setInvoiceNumber(resultSetImaging.getString(1));
				imagingDAO.setSiteID(resultSetImaging.getString(2));
				imagingDAO.setActivity(resultSetImaging.getString(3));
				imagingDAO.setScanDate(resultSetImaging.getString(4));
				imagingList.add(imagingDAO);
				System.out.println("Imaging List Added : "+imagingList.size());
			}
		} catch (Exception e) {
			try {
				resultSetImaging.close();
				preparedStatementImaging.close();
				conImaging.close();
				System.out.println("Imaging Connection Close Catch : " + conImaging.isClosed());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				resultSetImaging.close();
				preparedStatementImaging.close();
				conImaging.close();
				System.out.println("Imaging Connection Close : " + conImaging.isClosed());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		String queryApps = " SELECT ai.invoice_num \r\n" + "				 ,ai.invoice_id \r\n"
				+ "				 ,as1.segment1 supplier_number \r\n"
				+ "				 ,as1.vendor_id supplier_id \r\n" + "				 ,ass.vendor_site_id site_id \r\n"
				+ "				 ,ai.org_id \r\n" + "				 ,hou.NAME \r\n"
				+ "				 ,ai.invoice_currency_code \r\n" + "				 ,ai.invoice_amount \r\n"
				+ "				 ,to_char(ai.invoice_date \r\n"
				+ "				         ,'YYYY-MM-DD') invoice_date \r\n" + "				 ,ail.freight \r\n"
				+ "				 ,ail.aog \r\n" + "				 ,ail.due_date \r\n"
				+ "				 ,ail.witholding_tax \r\n" + "				 ,(SELECT ph.segment1 \r\n"
				+ "				     FROM apps.po_headers_all       ph \r\n"
				+ "				         ,apps.ap_invoice_lines_all ail \r\n"
				+ "				    WHERE ail.po_header_id = ph.po_header_id \r\n"
				+ "				      AND nvl(ail.discarded_flag \r\n" + "				             ,'N') <> 'Y' \r\n"
				+ "				      AND rownum < 2 \r\n"
				+ "				      AND ail.invoice_id = ai.invoice_id) po_number \r\n"
				+ "				 ,ai.invoice_type_lookup_code ap_invoice_type \r\n"
				+ "				 ,ai.SOURCE ap_invoice_source \r\n" + "				 ,decode((SELECT COUNT(1) \r\n"
				+ "				           FROM apps.fnd_lookup_values flv \r\n"
				+ "				          WHERE flv.lookup_type = 'QFEQ_JETSTAR_JBA_SETUP_CONTROL' \r\n"
				+ "				            AND flv.lookup_code = ai.org_id) \r\n" + "				        ,1 \r\n"
				+ "				        ,nvl((SELECT APPS.jseq_ap_inv_img_process.amount_rounding(flv.tag,(conversion_rate * ai.invoice_amount)) \r\n"
				+ "				               FROM gl.gl_daily_rates \r\n"
				+ "				                   ,apps.fnd_lookup_values flv \r\n"
				+ "				              WHERE conversion_date = ai.gl_date \r\n"
				+ "				                AND from_currency = ai.invoice_currency_code \r\n"
				+ "				                AND to_currency = flv.tag \r\n"
				+ "				                AND conversion_type = 1000 \r\n"
				+ "				                AND flv.lookup_type = \r\n"
				+ "				                    'QFEQ_JETSTAR_JBA_SETUP_CONTROL' \r\n"
				+ "				                AND flv.lookup_code = ai.org_id) \r\n"
				+ "				            ,ai.invoice_amount) \r\n"
				+ "				        ,nvl(ai.base_amount \r\n"
				+ "				            ,ai.invoice_amount)) currency_equivalent \r\n"
				+ "				 ,regexp_substr(ai.attribute15 \r\n"
				+ "				                     ,'[^_]+' \r\n" + "				                     ,1 \r\n"
				+ "				                     ,2) image_url \r\n"
				+ "				 ,regexp_substr(ai.global_attribute2 \r\n"
				+ "				                     ,'[^_]+' \r\n" + "				                     ,1 \r\n"
				+ "				                     ,2)  image_url2 \r\n"
				+ "				 ,regexp_substr(ai.global_attribute3 \r\n"
				+ "				                     ,'[^_]+' \r\n" + "				                     ,1 \r\n"
				+ "				                     ,2)  image_url3 \r\n"
				+ "				 ,'eQ ' || initcap(decode(ai.cancelled_date \r\n"
				+ "				                         ,NULL \r\n"
				+ "				                         ,decode(ai.payment_status_flag \r\n"
				+ "				                                ,'Y' \r\n"
				+ "				                                ,'Paid' \r\n"
				+ "				                                ,decode(hist.response \r\n"
				+ "				                                       ,NULL \r\n"
				+ "				                                       ,'Created' \r\n"
				+ "				                                       ,hist.response)) \r\n"
				+ "				                         ,'Cancelled')) invoice_status \r\n"
				+ "				 ,hist.approver_name pending_with_approved_by \r\n"
				+ "				 ,hist.last_update_date action_date \r\n"
				+ "				 ,paymnt.check_number payment_number \r\n"
				+ "				 ,to_char(paymnt.check_date \r\n"
				+ "				         ,'YYYY-MM-DD') payment_date \r\n" + "				    ,ai.description\r\n"
				+ "				 ,as1.SMALL_BUSINESS_FLAG Small_Business\r\n"
				+ "				 ,(SELECT HOLD_LOOKUP_CODE \r\n"
				+ "				     FROM (SELECT HOLD_LOOKUP_CODE, HOLD_ID \r\n"
				+ "				             FROM apps.ap_holds_all aha1 \r\n"
				+ "				            WHERE aha1.invoice_id = ai.invoice_id \r\n"
				+ "				              and aha1.release_lookup_code is null \r\n"
				+ "				            ORDER BY HOLD_ID) \r\n" + "				    WHERE ROWNUM = 1 \r\n"
				+ "				   UNION  \r\n" + "				   SELECT HOLD_LOOKUP_CODE \r\n"
				+ "				     FROM (SELECT HOLD_LOOKUP_CODE, HOLD_ID, LAST_UPDATE_DATE \r\n"
				+ "				             FROM apps.ap_holds_all aha1 \r\n"
				+ "				            WHERE aha1.invoice_id = ai.invoice_id \r\n"
				+ "				              AND NOT EXISTS \r\n" + "				            (SELECT 1 \r\n"
				+ "				                     FROM apps.ap_holds_all aha2 \r\n"
				+ "				                    WHERE aha1.invoice_id = aha2.invoice_id \r\n"
				+ "				                      AND aha2.release_lookup_code is null) \r\n"
				+ "				            ORDER BY LAST_UPDATE_DATE DESC) \r\n"
				+ "				    WHERE ROWNUM = 1) Invoice_Hold_Name \r\n"
				+ "				,(SELECT TRUNC(LAST_UPDATE_DATE) \r\n"
				+ "				     FROM (SELECT LAST_UPDATE_DATE \r\n"
				+ "				             FROM apps.ap_holds_all aha1 \r\n"
				+ "				            WHERE aha1.invoice_id = ai.invoice_id \r\n"
				+ "				              and aha1.release_lookup_code is NOT null \r\n"
				+ "				              AND HOLD_LOOKUP_CODE IN \r\n"
				+ "				                  ('AMT ORD', 'AMT REC', 'MAX AMT ORD', 'MAX AMT REC', \r\n"
				+ "				                   'QTY ORD', 'QTY REC') \r\n"
				+ "				              AND NOT EXISTS \r\n" + "				            (SELECT 1 \r\n"
				+ "				                     FROM apps.ap_holds_all aha2 \r\n"
				+ "				                    WHERE aha2.invoice_id = aha1.invoice_id \r\n"
				+ "				                      and aha2.release_lookup_code is null \r\n"
				+ "				                      AND HOLD_LOOKUP_CODE IN \r\n"
				+ "				                          ('AMT ORD', 'AMT REC', 'MAX AMT ORD', \r\n"
				+ "				                           'MAX AMT REC', 'QTY ORD', 'QTY REC')) \r\n"
				+ "				            ORDER BY LAST_UPDATE_DATE DESC) \r\n"
				+ "				    WHERE ROWNUM = 1) PO_Hold_Release_Date \r\n"
				+ "				 ,(SELECT APPROVAL_DATE \r\n"
				+ "				     FROM (SELECT TRUNC(LAST_UPDATE_DATE) APPROVAL_DATE \r\n"
				+ "				             FROM apps.ap_holds_all aha1 \r\n"
				+ "				            WHERE aha1.invoice_id = AI.INVOICE_ID \r\n"
				+ "				              and aha1.release_lookup_code is NOT null \r\n"
				+ "				              AND HOLD_LOOKUP_CODE = 'Accounting Hold' \r\n"
				+ "				              AND AI.WFAPPROVAL_STATUS = 'WFAPPROVED' \r\n"
				+ "				            order by LAST_UPDATE_DATE DESC) \r\n"
				+ "				    WHERE ROWNUM = 1) Findel_Hold_Release_Date \r\n"
				+ "				  FROM apps.ap_invoices_all ai \r\n" + "				 ,apps.ap_suppliers as1 \r\n"
				+ "				 ,apps.ap_supplier_sites_all ass \r\n" + "				 ,(SELECT * \r\n"
				+ "				     FROM (SELECT rank() over(PARTITION BY invoice_id ORDER BY aha.invoice_id, aha.last_update_date DESC, aha.approval_history_id DESC) sl_no \r\n"
				+ "				                 ,aha.* \r\n"
				+ "				             FROM apps.ap_inv_aprvl_hist_all aha) \r\n"
				+ "				    WHERE sl_no = 1) hist \r\n" + "				 ,(SELECT ac.check_number \r\n"
				+ "				         ,ac.check_date \r\n" + "				         ,aip.invoice_id \r\n"
				+ "				     FROM apps.ap_invoice_payments_all aip \r\n"
				+ "				         ,apps.ap_checks_all           ac \r\n"
				+ "				    WHERE ac.check_id = aip.check_id \r\n"
				+ "				      AND ac.void_date IS NULL) paymnt \r\n"
				+ "				 ,(SELECT SUM(decode(ail.line_type_lookup_code \r\n"
				+ "				                    ,'AWT' \r\n" + "				                    ,amount \r\n"
				+ "				                    ,0)) witholding_tax \r\n"
				+ "				         ,SUM(decode(ail.line_type_lookup_code \r\n"
				+ "				                    ,'FREIGHT' \r\n"
				+ "				                    ,amount \r\n"
				+ "				                    ,0)) freight \r\n"
				+ "				         ,SUM(decode(ail.line_type_lookup_code \r\n"
				+ "				                    ,'MISCELLANEOUS' \r\n"
				+ "				                    ,amount \r\n" + "				                    ,0)) aog \r\n"
				+ "				         ,aps.due_date \r\n" + "				         ,aps.invoice_id \r\n"
				+ "				     FROM apps.ap_payment_schedules_all aps \r\n"
				+ "				         ,apps.ap_invoice_lines_all     ail \r\n"
				+ "				    WHERE aps.invoice_id = ail.invoice_id \r\n"
				+ "				    GROUP BY aps.invoice_id \r\n" + "				            ,aps.due_date) ail \r\n"
				+ "				 ,apps.fnd_lookup_values flv \r\n" + "				 ,apps.hr_operating_units hou \r\n"
				+ "				 --added for checking the hold release date\r\n"
				+ "				 ,(SELECT max(ah.LAST_UPDATE_DATE) hold_release_date,ah.invoice_id\r\n"
				+ "				  FROM apps.ap_holds_all ah\r\n"
				+ "				 WHERE  ah.release_lookup_code is NOT null\r\n"
				+ "				   AND ah.HOLD_LOOKUP_CODE in\r\n"
				+ "				  ('Accounting Hold', 'AMT ORD', 'AMT REC', 'MAX AMT ORD',\r\n"
				+ "				   'MAX AMT REC', 'QTY ORD', 'QTY REC') group by ah.invoice_id) hold\r\n"
				+ "				 --\r\n" + "				 WHERE ai.SOURCE = flv.lookup_code \r\n"
				+ "				   AND flv.lookup_type = 'SOURCE' \r\n"
				+ "				   AND flv.attribute15 = 'Y' \r\n"
				+ "				   AND ai.vendor_id = as1.vendor_id \r\n"
				+ "				   AND ass.vendor_id = as1.vendor_id \r\n"
				+ "				   AND ass.vendor_site_id = ai.vendor_site_id \r\n"
				+ "				   AND ai.invoice_id = hist.invoice_id(+) \r\n"
				+ "				   AND paymnt.invoice_id(+) = ai.invoice_id \r\n"
				+ "				   AND ail.invoice_id = ai.invoice_id    \r\n"
				+ "				   and hold.invoice_id(+) = ai.invoice_id   \r\n"
				+ "				   AND ai.org_id = hou.organization_id \r\n"
				+ "				   AND ai.creation_date > '01-JAN-2016' \r\n"
				+ "				   AND upper(ai.attribute15)  like '%HTTP%'  \r\n"
				+ "				/*   AND (ai.last_update_date >= to_date('2020-06-14 05:13:57', 'YYYY-MM-DD HH24:MI:ss') OR \r\n"
				+ "				  hist.last_update_date >= to_date('2020-06-14 05:13:57', 'YYYY-MM-DD HH24:MI:ss') or\r\n"
				+ "				  hold.hold_release_date  >= to_date('2020-06-14 05:13:57', 'YYYY-MM-DD HH24:MI:ss')) \r\n"
				+ "				   AND (ai.last_update_date < to_date('2020-06-15 23:13:57', 'YYYY-MM-DD HH24:MI:ss') OR \r\n"
				+ "				  hist.last_update_date < to_date('2020-06-15 23:13:57', 'YYYY-MM-DD HH24:MI:ss') or\r\n"
				+ "				  hold.hold_release_date  < to_date('2020-06-15 23:13:57', 'YYYY-MM-DD HH24:MI:ss' ))*/\r\n"
				+ "                                  \r\n"
				+ "                                  and ai.vendor_site_id=? and ai.invoice_num=?";

		for (ImagingDAO dao : imagingList) {
//			System.out.println(dao.getInvoiceNumber() + "," + dao.getSiteID());
			try {
				// step2 create the connection object for Apps DB
				conApps = DriverManager.getConnection("jdbc:oracle:thin:@eqprod-db1.qantas.com.au:16010:ebs_PEBSDB",
						"appsview", "Password08");
				preparedStatementApps = conApps.prepareStatement(queryApps);
//				System.out.println("Connection created");
				preparedStatementApps.setString(1, dao.getSiteID());
				preparedStatementApps.setString(2, dao.getInvoiceNumber());
				resultSetApps = preparedStatementApps.executeQuery();
				while (resultSetApps.next()) {
					System.out.println("List Index : "+imagingList.indexOf(dao));
//					System.out.println(dao.getActivity() + " " + resultSetApps.getString("INVOICE_STATUS"));
					if (!dao.getActivity().equalsIgnoreCase(resultSetApps.getString("INVOICE_STATUS"))) {
						System.out.println("Imaging : "+dao.getActivity());
						System.out.println("Apps : "+resultSetApps.getString("INVOICE_STATUS"));
						listApps.add(new String[] { resultSetApps.getString("INVOICE_NUM"),
								resultSetApps.getString("SITE_ID"), resultSetApps.getString("INVOICE_STATUS"),
								dao.getActivity(), resultSetApps.getString("PAYMENT_NUMBER"),
								resultSetApps.getString("PAYMENT_DATE"), });
					}
				}
				
			} catch (Exception e) {
				try {
					resultSetApps.close();
					preparedStatementApps.close();
					conApps.close();
					System.out.println("Apps Connection Close Catch Block: " + conApps.isClosed());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				try {
					resultSetApps.close();
					preparedStatementApps.close();
					conApps.close();
					System.out.println("Apps Connection Close : " + conApps.isClosed());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		System.out.println("List Size : " + listApps.size());
		if (listApps.size() > 0) {
			System.out.println("Enter File Writing");
			WriteCSV.writeDataAtOnce("C:\\Code\\Pdf\\QueryData.csv", listApps);
		}
		LocalDateTime dateTime2=LocalDateTime.now();
		System.out.println("Time Difference : "+Duration.between(dateTime, dateTime2).toHours());
	}
}
