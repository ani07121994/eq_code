package com.qantas.ap.quartz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/*import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.security.auth.login.FailedLoginException;*/
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

import ap.qantas.util.ECMUpdateLogger;
import ap.quantas.com.PropertyLoader;
//import ap.quantas.com.bamUpdateWebService.DataObjectOperationsByID;
//import ap.quantas.com.bamUpdateWebService.DataObjectOperationsByID_Service;
import ap.quantas.com.imaging.WSSecurityHeaderSOAPHandler;
import ap.quantas.com.imaging.documentUpdate.DocumentService;
import ap.quantas.com.imaging.documentUpdate.DocumentService_Service;
import ap.quantas.com.imaging.documentUpdate.FieldType;
import ap.quantas.com.imaging.documentUpdate.FieldValue;
import ap.quantas.com.imaging.documentUpdate.TypedValue;

public class ImagingUpdateTask {

	private static final Logger logger = ECMUpdateLogger.getLogger(ImagingUpdateTask.class.getName());

	private static volatile boolean IS_RUNNING = false;
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private ArrayList<String> failedUpdateList;
	private HashMap<String, String> ErrorList;

	private String ebsJavaQuery = "SELECT ai.invoice_num \r\n" + "      ,ai.invoice_id \r\n"
			+ "      ,as1.segment1 supplier_number \r\n" + "      ,as1.vendor_id supplier_id \r\n"
			+ "      ,ass.vendor_site_id site_id \r\n" + "      ,ai.org_id \r\n" + "      ,hou.NAME \r\n"
			+ "      ,ai.invoice_currency_code \r\n" + "      ,ai.invoice_amount \r\n"
			+ "      ,to_char(ai.invoice_date \r\n" + "              ,'YYYY-MM-DD') invoice_date \r\n"
			+ "      ,ail.freight \r\n" + "      ,ail.aog \r\n" + "      ,ail.due_date \r\n"
			+ "      ,ail.witholding_tax \r\n" + "      ,(SELECT ph.segment1 \r\n"
			+ "          FROM apps.po_headers_all       ph \r\n" + "              ,apps.ap_invoice_lines_all ail \r\n"
			+ "         WHERE ail.po_header_id = ph.po_header_id \r\n" + "           AND nvl(ail.discarded_flag \r\n"
			+ "                  ,'N') <> 'Y' \r\n" + "           AND rownum < 2 \r\n"
			+ "           AND ail.invoice_id = ai.invoice_id) po_number \r\n"
			+ "      ,ai.invoice_type_lookup_code ap_invoice_type \r\n" + "      ,ai.SOURCE ap_invoice_source \r\n"
			+ "      ,decode((SELECT COUNT(1) \r\n" + "                FROM apps.fnd_lookup_values flv \r\n"
			+ "               WHERE flv.lookup_type = 'QFEQ_JETSTAR_JBA_SETUP_CONTROL' \r\n"
			+ "                 AND flv.lookup_code = ai.org_id) \r\n" + "             ,1 \r\n"
			+ "             ,nvl((SELECT APPS.jseq_ap_inv_img_process.amount_rounding(flv.tag,(conversion_rate * ai.invoice_amount)) \r\n"
			+ "                    FROM gl.gl_daily_rates \r\n"
			+ "                        ,apps.fnd_lookup_values flv \r\n"
			+ "                   WHERE conversion_date = ai.gl_date \r\n"
			+ "                     AND from_currency = ai.invoice_currency_code \r\n"
			+ "                     AND to_currency = flv.tag \r\n"
			+ "                     AND conversion_type = 1000 \r\n" + "                     AND flv.lookup_type = \r\n"
			+ "                         'QFEQ_JETSTAR_JBA_SETUP_CONTROL' \r\n"
			+ "                     AND flv.lookup_code = ai.org_id) \r\n" + "                 ,ai.invoice_amount) \r\n"
			+ "             ,nvl(ai.base_amount \r\n" + "                 ,ai.invoice_amount)) currency_equivalent \r\n"
			+ "      ,regexp_substr(ai.attribute15 \r\n" + "                          ,'[^_]+' \r\n"
			+ "                          ,1 \r\n" + "                          ,2) image_url \r\n"
			+ "      ,regexp_substr(ai.global_attribute2 \r\n" + "                          ,'[^_]+' \r\n"
			+ "                          ,1 \r\n" + "                          ,2)  image_url2 \r\n"
			+ "      ,regexp_substr(ai.global_attribute3 \r\n" + "                          ,'[^_]+' \r\n"
			+ "                          ,1 \r\n" + "                          ,2)  image_url3 \r\n"
			+ "      ,'eQ ' || initcap(decode(ai.cancelled_date \r\n" + "                              ,NULL \r\n"
			+ "                              ,decode(ai.payment_status_flag \r\n"
			+ "                                     ,'Y' \r\n" + "                                     ,'Paid' \r\n"
			+ "                                     ,decode(hist.response \r\n"
			+ "                                            ,NULL \r\n"
			+ "                                            ,'Created' \r\n"
			+ "                                            ,hist.response)) \r\n"
			+ "                              ,'Cancelled')) invoice_status \r\n"
			+ "      ,hist.approver_name pending_with_approved_by \r\n"
			+ "      ,hist.last_update_date action_date \r\n" + "      ,paymnt.check_number payment_number \r\n"
			+ "      ,to_char(paymnt.check_date \r\n" + "              ,'YYYY-MM-DD') payment_date \r\n"
			+ "    ,ai.description\r\n" + "      ,as1.SMALL_BUSINESS_FLAG Small_Business\r\n"
			+ "      ,(SELECT HOLD_LOOKUP_CODE \r\n" + "          FROM (SELECT HOLD_LOOKUP_CODE, HOLD_ID \r\n"
			+ "                  FROM apps.ap_holds_all aha1 \r\n"
			+ "                 WHERE aha1.invoice_id = ai.invoice_id \r\n"
			+ "                   and aha1.release_lookup_code is null \r\n" + "                 ORDER BY HOLD_ID) \r\n"
			+ "         WHERE ROWNUM = 1 \r\n" + "        UNION  \r\n" + "        SELECT HOLD_LOOKUP_CODE \r\n"
			+ "          FROM (SELECT HOLD_LOOKUP_CODE, HOLD_ID, LAST_UPDATE_DATE \r\n"
			+ "                  FROM apps.ap_holds_all aha1 \r\n"
			+ "                 WHERE aha1.invoice_id = ai.invoice_id \r\n" + "                   AND NOT EXISTS \r\n"
			+ "                 (SELECT 1 \r\n" + "                          FROM apps.ap_holds_all aha2 \r\n"
			+ "                         WHERE aha1.invoice_id = aha2.invoice_id \r\n"
			+ "                           AND aha2.release_lookup_code is null) \r\n"
			+ "                 ORDER BY LAST_UPDATE_DATE DESC) \r\n"
			+ "         WHERE ROWNUM = 1) Invoice_Hold_Name \r\n" + ",(SELECT TRUNC(LAST_UPDATE_DATE) \r\n"
			+ "          FROM (SELECT LAST_UPDATE_DATE \r\n" + "                  FROM apps.ap_holds_all aha1 \r\n"
			+ "                 WHERE aha1.invoice_id = ai.invoice_id \r\n"
			+ "                   and aha1.release_lookup_code is NOT null \r\n"
			+ "                   AND HOLD_LOOKUP_CODE IN \r\n"
			+ "                       ('AMT ORD', 'AMT REC', 'MAX AMT ORD', 'MAX AMT REC', \r\n"
			+ "                        'QTY ORD', 'QTY REC') \r\n" + "                   AND NOT EXISTS \r\n"
			+ "                 (SELECT 1 \r\n" + "                          FROM apps.ap_holds_all aha2 \r\n"
			+ "                         WHERE aha2.invoice_id = aha1.invoice_id \r\n"
			+ "                           and aha2.release_lookup_code is null \r\n"
			+ "                           AND HOLD_LOOKUP_CODE IN \r\n"
			+ "                               ('AMT ORD', 'AMT REC', 'MAX AMT ORD', \r\n"
			+ "                                'MAX AMT REC', 'QTY ORD', 'QTY REC')) \r\n"
			+ "                 ORDER BY LAST_UPDATE_DATE DESC) \r\n"
			+ "         WHERE ROWNUM = 1) PO_Hold_Release_Date \r\n" + " ,(SELECT APPROVAL_DATE \r\n"
			+ "          FROM (SELECT TRUNC(LAST_UPDATE_DATE) APPROVAL_DATE \r\n"
			+ "                  FROM apps.ap_holds_all aha1 \r\n"
			+ "                 WHERE aha1.invoice_id = AI.INVOICE_ID \r\n"
			+ "                   and aha1.release_lookup_code is NOT null \r\n"
			+ "                   AND HOLD_LOOKUP_CODE = 'Accounting Hold' \r\n"
			+ "                   AND AI.WFAPPROVAL_STATUS = 'WFAPPROVED' \r\n"
			+ "                 order by LAST_UPDATE_DATE DESC) \r\n"
			+ "         WHERE ROWNUM = 1) Findel_Hold_Release_Date \r\n" + "  FROM apps.ap_invoices_all ai \r\n"
			+ "      ,apps.ap_suppliers as1 \r\n" + "      ,apps.ap_supplier_sites_all ass \r\n"
			+ "      ,(SELECT * \r\n"
			+ "          FROM (SELECT rank() over(PARTITION BY invoice_id ORDER BY aha.invoice_id, aha.last_update_date DESC, aha.approval_history_id DESC) sl_no \r\n"
			+ "                      ,aha.* \r\n" + "                  FROM apps.ap_inv_aprvl_hist_all aha) \r\n"
			+ "         WHERE sl_no = 1) hist \r\n" + "      ,(SELECT ac.check_number \r\n"
			+ "              ,ac.check_date \r\n" + "              ,aip.invoice_id \r\n"
			+ "          FROM apps.ap_invoice_payments_all aip \r\n"
			+ "              ,apps.ap_checks_all           ac \r\n" + "         WHERE ac.check_id = aip.check_id \r\n"
			+ "           AND ac.void_date IS NULL) paymnt \r\n"
			+ "      ,(SELECT SUM(decode(ail.line_type_lookup_code \r\n" + "                         ,'AWT' \r\n"
			+ "                         ,amount \r\n" + "                         ,0)) witholding_tax \r\n"
			+ "              ,SUM(decode(ail.line_type_lookup_code \r\n" + "                         ,'FREIGHT' \r\n"
			+ "                         ,amount \r\n" + "                         ,0)) freight \r\n"
			+ "              ,SUM(decode(ail.line_type_lookup_code \r\n"
			+ "                         ,'MISCELLANEOUS' \r\n" + "                         ,amount \r\n"
			+ "                         ,0)) aog \r\n" + "              ,aps.due_date \r\n"
			+ "              ,aps.invoice_id \r\n" + "          FROM apps.ap_payment_schedules_all aps \r\n"
			+ "              ,apps.ap_invoice_lines_all     ail \r\n"
			+ "         WHERE aps.invoice_id = ail.invoice_id \r\n" + "         GROUP BY aps.invoice_id \r\n"
			+ "                 ,aps.due_date) ail \r\n" + "      ,apps.fnd_lookup_values flv \r\n"
			+ "      ,apps.hr_operating_units hou \r\n" + "      --added for checking the hold release date\r\n"
			+ "      ,(SELECT max(ah.LAST_UPDATE_DATE) hold_release_date,ah.invoice_id\r\n"
			+ "  FROM apps.ap_holds_all ah\r\n" + " WHERE  ah.release_lookup_code is NOT null\r\n"
			+ "   AND ah.HOLD_LOOKUP_CODE in\r\n"
			+ "       ('Accounting Hold', 'AMT ORD', 'AMT REC', 'MAX AMT ORD',\r\n"
			+ "        'MAX AMT REC', 'QTY ORD', 'QTY REC') group by ah.invoice_id) hold\r\n" + "      --\r\n"
			+ " WHERE ai.SOURCE = flv.lookup_code \r\n" + "   AND flv.lookup_type = 'SOURCE' \r\n"
			+ "   AND flv.attribute15 = 'Y' \r\n" + "   AND ai.vendor_id = as1.vendor_id \r\n"
			+ "   AND ass.vendor_id = as1.vendor_id \r\n" + "   AND ass.vendor_site_id = ai.vendor_site_id \r\n"
			+ "   AND ai.invoice_id = hist.invoice_id(+) \r\n" + "   AND paymnt.invoice_id(+) = ai.invoice_id \r\n"
			+ "   AND ail.invoice_id = ai.invoice_id    \r\n" + "   and hold.invoice_id(+) = ai.invoice_id   \r\n"
			+ "   AND ai.org_id = hou.organization_id \r\n" + "   AND ai.creation_date > '01-JAN-2016' \r\n"
			+ "   AND upper(ai.attribute15)  like '%HTTP%'  \r\n"
			+ "   AND (ai.last_update_date >= to_date(?, 'YYYY-MM-DD HH24:MI:ss') OR \r\n"
			+ "       hist.last_update_date >= to_date(?, 'YYYY-MM-DD HH24:MI:ss') or\r\n"
			+ "       hold.hold_release_date  >= to_date(?, 'YYYY-MM-DD HH24:MI:ss')) \r\n"
			+ "   AND (ai.last_update_date < to_date(?, 'YYYY-MM-DD HH24:MI:ss') OR \r\n"
			+ "       hist.last_update_date < to_date(?, 'YYYY-MM-DD HH24:MI:ss') or\r\n"
			+ "       hold.hold_release_date  < to_date(?, 'YYYY-MM-DD HH24:MI:ss' ))\r\n" + "\r\n" + "UNION ALL \r\n"
			+ "SELECT ai.invoice_num \r\n" + "      ,ai.invoice_id \r\n" + "      ,as1.segment1 supplier_number \r\n"
			+ "      ,as1.vendor_id supplier_id \r\n" + "      ,ass.vendor_site_id site_id \r\n"
			+ "      ,ai.org_id \r\n" + "      ,hou.NAME \r\n" + "      ,ai.invoice_currency_code \r\n"
			+ "      ,ai.invoice_amount \r\n" + "      ,to_char(ai.invoice_date \r\n"
			+ "              ,'YYYY-MM-DD') invoice_date \r\n" + "      ,NULL \r\n" + "      ,NULL \r\n"
			+ "      ,NULL \r\n" + "      ,NULL \r\n" + "      ,NULL po_number \r\n"
			+ "      ,ai.invoice_type_lookup_code ap_invoice_type \r\n" + "      ,ai.SOURCE ap_invoice_source \r\n"
			+ "      ,NULL \r\n" + "      ,regexp_substr(ai.attribute15 \r\n"
			+ "                          ,'[^_]+' \r\n" + "                          ,1 \r\n"
			+ "                          ,2) image_url \r\n" + "      ,regexp_substr(ai.global_attribute2 \r\n"
			+ "                          ,'[^_]+' \r\n" + "                          ,1 \r\n"
			+ "                          ,2)  image_url2 \r\n" + "      ,regexp_substr(ai.global_attribute3 \r\n"
			+ "                          ,'[^_]+' \r\n" + "                          ,1 \r\n"
			+ "                          ,2)  image_url3 \r\n" + "      ,'eQ ' || decode(status \r\n"
			+ "                      ,'REJECTED' \r\n" + "                      ,'Interface Rejected' \r\n"
			+ "                      ,NULL \r\n" + "                      ,'Awaiting Import' \r\n"
			+ "                      ,status) \r\n" + "      ,NULL last_actioned_by \r\n"
			+ "      ,NULL last_action_date \r\n" + "      ,NULL payment_number \r\n" + "      ,NULL payment_date \r\n"
			+ "    ,ai.description \r\n" + "      ,as1.SMALL_BUSINESS_FLAG Small_Business \r\n"
			+ "    ,NULL Invoice_Hold_Name \r\n" + "    ,NULL PO_Hold_Release_Date \r\n"
			+ "    ,NULL Findel_Hold_Release_Date \r\n" + "  FROM apps.ap_invoices_interface ai \r\n"
			+ "      ,apps.ap_suppliers          as1 \r\n" + "      ,apps.ap_supplier_sites_all ass \r\n"
			+ "      ,apps.fnd_lookup_values     flv \r\n" + "      ,apps.hr_operating_units    hou \r\n"
			+ " WHERE ai.SOURCE = flv.lookup_code \r\n" + "   AND flv.lookup_type = 'SOURCE' \r\n"
			+ "   AND flv.attribute15 = 'Y' \r\n" + "   AND ai.vendor_id = as1.vendor_id(+) \r\n"
			+ "   AND ass.vendor_site_id(+) = ai.vendor_site_id \r\n" + "   AND ai.org_id = hou.organization_id \r\n"
			+ "   AND nvl(status \r\n" + "          ,'NEW') <> 'PROCESSED' \r\n"
			+ "   AND upper(ai.attribute15)  like '%HTTP%' \r\n" + "UNION ALL \r\n" + "SELECT ai.invoice_num \r\n"
			+ "      ,ai.invoice_id \r\n" + "      ,as1.segment1 supplier_number \r\n"
			+ "      ,as1.vendor_id supplier_id \r\n" + "      ,ass.vendor_site_id site_id \r\n"
			+ "      ,ai.org_id \r\n" + "      ,hou.NAME \r\n" + "      ,ai.invoice_currency_code \r\n"
			+ "      ,ai.invoice_amount \r\n" + "      ,to_char(ai.invoice_date \r\n"
			+ "              ,'YYYY-MM-DD') invoice_date \r\n" + "      ,NULL \r\n" + "      ,NULL \r\n"
			+ "      ,NULL \r\n" + "      ,NULL \r\n" + "      ,NULL po_number \r\n"
			+ "      ,ai.invoice_type_lookup_code ap_invoice_type \r\n" + "      ,ai.SOURCE ap_invoice_source \r\n"
			+ "      ,NULL \r\n" + "      ,regexp_substr(ai.attribute15 \r\n"
			+ "                          ,'[^_]+' \r\n" + "                          ,1 \r\n"
			+ "                          ,2) image_url \r\n" + "      ,regexp_substr(ai.global_attribute2 \r\n"
			+ "                          ,'[^_]+' \r\n" + "                          ,1 \r\n"
			+ "                          ,2)  image_url2 \r\n" + "      ,regexp_substr(ai.global_attribute3 \r\n"
			+ "                          ,'[^_]+' \r\n" + "                          ,1 \r\n"
			+ "                          ,2)  image_url3 \r\n" + "      ,'eQ Interface Deleted' \r\n"
			+ "      ,NULL last_actioned_by \r\n" + "      ,NULL last_action_date \r\n"
			+ "      ,NULL payment_number \r\n" + "      ,NULL payment_date \r\n" + "    ,ai.description \r\n"
			+ "      ,as1.SMALL_BUSINESS_FLAG Small_Business   \r\n" + "    ,NULL Invoice_Hold_Name \r\n"
			+ "    ,NULL PO_Hold_Release_Date \r\n" + "    ,NULL Findel_Hold_Release_Date \r\n"
			+ "  FROM bolinf.qfeq_ap_inv_intrfc_del_audit ai \r\n"
			+ "      ,apps.ap_suppliers                   as1 \r\n"
			+ "      ,apps.ap_supplier_sites_all          ass \r\n"
			+ "      ,apps.fnd_lookup_values              flv \r\n"
			+ "      ,apps.hr_operating_units             hou \r\n" + " WHERE ai.SOURCE = flv.lookup_code \r\n"
			+ "   AND flv.lookup_type = 'SOURCE' \r\n" + "   AND flv.attribute15 = 'Y' \r\n"
			+ "   AND ai.vendor_id = as1.vendor_id(+) \r\n" + "   AND ass.vendor_site_id(+) = ai.vendor_site_id \r\n"
			+ "   AND ai.org_id = hou.organization_id ";

	public ImagingUpdateTask() {
		logger.log(Level.INFO, "Starting the 12c imagingUpdateTask");
	}

	private static Date getLastUpdatedTimestampFromPropertyTable(Properties props) {
		Connection eqfilesDb = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		Date retDate = null;

		try {
			eqfilesDb = DBUtil.getEqfilesConnection();
			String query = props.getProperty("TIMESTAMP_CHECK_QUERY");
			ps = eqfilesDb.prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			retDate = DATE_FORMAT.parse(rs.getString(1));
		} catch (Exception ex) {
			// ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (eqfilesDb != null) {
				try {
					eqfilesDb.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return retDate;
	}

	private static void updateLastUpdatedTimestampFromPropertyTable(Connection conn, Properties props, Date dt,
			String insertOrUpdate) {
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getEqfilesConnection();
			String query = null;
			if (insertOrUpdate.equalsIgnoreCase("insert")) {
				logger.log(Level.INFO, "===== 12c inserting last update timestamp =====");
				query = props.getProperty("TIMESTAMP_INSERT_QUERY");
			} else if (insertOrUpdate.equalsIgnoreCase("update")) {
				logger.log(Level.INFO, "=====12c updating last update timestamp =====");
				query = props.getProperty("TIMESTAMP_UPDATE_QUERY");
			}
			ps = conn.prepareStatement(query);
			ps.setString(1, DATE_FORMAT.format(dt));
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void insertErrorRecord(Connection conn, Properties props, StatusDetails errorRecord, String errorMsg,
			String docID) {
		logger.log(Level.INFO, "=====12c insertErrorRecord method START ====== ");
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getEqfilesConnection();
			String query = null;

			query = props.getProperty("INSERT_ERROR_RECORD_QUERY");

			ps = conn.prepareStatement(query);
			ps.setString(1, errorRecord.getInvoice_num());
			ps.setString(2, errorRecord.getInvoice_status());
			ps.setString(3, errorRecord.getApprover_name());
			ps.setString(4, errorRecord.getPayment_number());
			ps.setString(5, errorRecord.getPayment_date());
			ps.setString(6, errorRecord.getSupplier_id());
			ps.setString(7, errorRecord.getOperating_unit_name());
			ps.setString(8, errorRecord.getCurrency());
			ps.setString(9, errorRecord.getInvoice_total());
			ps.setString(10, errorRecord.getAog());
			ps.setString(11, errorRecord.getFreight());
			ps.setString(12, errorRecord.getCurrency_equivalent());
			ps.setString(13, errorRecord.getDue_date());
			ps.setString(14, errorRecord.getInvoice_date());
			ps.setString(15, errorRecord.getPo_number());
			ps.setString(16, errorRecord.getDescription());
			ps.setString(17, "12c error " + errorMsg);
			ps.setString(18, DATE_FORMAT.format(new Date()));
			logger.log(Level.INFO, "12c===== inserting record for docId ======" + docID);
			ps.setString(19, docID);
			// 923018

			ps.setString(20, errorRecord.getSmall_Business());
			ps.setString(21, errorRecord.getInvoice_Hold_Name());
			ps.setString(22, errorRecord.getPo_Hold_Release_Date());
			ps.setString(23, errorRecord.getFindel_Hold_Release_Date());

			// 923018

			ps.executeUpdate();

		} catch (Exception ex) {
			logger.log(Level.INFO, "12c===== insertErrorRecord method Error ======" + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void run() {

		logger.log(Level.INFO, "12c===== Imaging Update for EBS Internal Status : START ======");
		logger.log(Level.INFO, "12c===== New changes ::: ======");
		logger.log(Level.INFO, "12c===== " + new Date() + " =====");
		String initials = null;
		failedUpdateList = new ArrayList<String>();
		ErrorList = new HashMap<String, String>();
		if (Constant.compileFor.value().equalsIgnoreCase("PROD")) {
			initials = "3.IPM_";
		} else {
			initials = "4.IPM_";
		}

		if (IS_RUNNING) {

			logger.log(Level.INFO, "12c===== Previous execution of job is still running =====");

		} else {
			IS_RUNNING = true;

			logger.log(Level.INFO, "12c===== Loading query =====");
			Properties props = new Properties();

			try {
				props.load(this.getClass().getResourceAsStream("queries.sql"));
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			Date currentTimestamp = new Date();

			Date lastUpdateTimestamp = null;
			boolean firstRun = true;
			lastUpdateTimestamp = getLastUpdatedTimestampFromPropertyTable(props);
			if (lastUpdateTimestamp != null) {
				logger.log(Level.INFO, "12c Last updated timestamp found in DB ...");
				firstRun = false;
			} else {

				try {
					lastUpdateTimestamp = new Date(
							currentTimestamp.getTime() - DATE_FORMAT.parse("2016-06-14 00:00:00").getTime());
				} catch (Exception e) {
					lastUpdateTimestamp = new Date(currentTimestamp.getTime() - 120 * 24 * 3600 * 1000l);
				}
				logger.log(Level.INFO, "12c Last updated timestamp not found in DB ... will be defaulted ...");
				firstRun = true;
			}

			logger.log(Level.INFO, "12c ===== firstRun : " + firstRun);

			logger.log(Level.INFO, "12c===== lastUpdateTimestamp : " + lastUpdateTimestamp);
			logger.log(Level.INFO, "12c===== lastUpdateTimestamp format : " + DATE_FORMAT.format(lastUpdateTimestamp));
			logger.log(Level.INFO, "12c===== currentTimestamp : " + currentTimestamp);
			logger.log(Level.INFO, "12c===== currentTimestamp format : " + DATE_FORMAT.format(currentTimestamp));

			ArrayList<StatusDetails> statusList = new ArrayList<StatusDetails>();
			Connection ebsDb = null;
			PreparedStatement ps1 = null;
			ResultSet rs1 = null;
			try {
				// String ebsQuery = props.getProperty("EBS_QUERY");
				String ebsQuery = ebsJavaQuery;

				// logger.log(Level.INFO, "===== ebsJavaQuery : "+ebsJavaQuery);
				// logger.log(Level.INFO, "===== ebsJavaQuery length : "+ebsJavaQuery);
				logger.log(Level.INFO, "12c===== ebsQuery : " + ebsQuery);
				logger.log(Level.INFO, "12c===== ebsQuery length : " + ebsQuery.length());
				ebsDb = DBUtil.getEbsConnection();

				ps1 = ebsDb.prepareStatement(ebsJavaQuery);
				logger.log(Level.INFO, "12c===== ps1 after ");

				ps1.setString(1, DATE_FORMAT.format(lastUpdateTimestamp));
				ps1.setString(2, DATE_FORMAT.format(lastUpdateTimestamp));
				ps1.setString(3, DATE_FORMAT.format(lastUpdateTimestamp));

				ps1.setString(4, DATE_FORMAT.format(currentTimestamp));
				ps1.setString(5, DATE_FORMAT.format(currentTimestamp));
				ps1.setString(6, DATE_FORMAT.format(currentTimestamp));

				rs1 = ps1.executeQuery();
				logger.log(Level.INFO, "12c QUERY EXECUTED --------");
				logger.log(Level.INFO, "12c FETCHING DETAILS FROM QUERY --------");
				logger.log(Level.INFO, "12c resultset data --------" + rs1);
				while (rs1.next()) {

					StatusDetails details = new StatusDetails();

					details.setInvoice_num(rs1.getString("invoice_num"));
					logger.log(Level.INFO, "12c invoice_num from DB " + rs1.getString("invoice_num"));
					details.setSupplier_number(rs1.getString("supplier_number"));
					details.setSite_id(rs1.getString("site_id"));
					details.setOrg_id(rs1.getString("org_id"));
					details.setInvoice_status(rs1.getString("invoice_status"));
					details.setImage_url(rs1.getString("image_url"));
					// logger.log(Level.INFO, "Image Url from DB " + rs1.getString("image_url"));

					// Two columns newly added for Finessecost
					details.setImage_url2(rs1.getString("image_url2"));
					// logger.log(Level.INFO, "Image Url2 from DB " + rs1.getString("image_url2"));
					details.setImage_url3(rs1.getString("image_url3"));
					// logger.log(Level.INFO, "Image Url3 from DB " + rs1.getString("image_url3"));
					// Finessecost End

					details.setApprover_name(rs1.getString("pending_with_approved_by"));
					details.setPayment_date(rs1.getString("payment_date"));
					details.setPayment_number(rs1.getString("payment_number"));

					// Newly added for ECM Update
					details.setSupplier_id(rs1.getString("supplier_id"));
					details.setOperating_unit_name(rs1.getString("NAME"));
					details.setCurrency(rs1.getString("invoice_currency_code"));
					details.setInvoice_total(rs1.getString("invoice_amount"));
					details.setAog(rs1.getString("aog"));
					details.setFreight(rs1.getString("freight"));
					details.setCurrency_equivalent(rs1.getString("currency_equivalent"));
					details.setDue_date(rs1.getString("due_date"));
					details.setInvoice_date(rs1.getString("invoice_date"));
					details.setPo_number(rs1.getString("po_number"));
					// System.out.println("rs1.getString(\"description\")
					// "+rs1.getString("description"));
					details.setDescription(rs1.getString("description"));
					// 923018-Addition of four fields in ECM Start
					details.setSmall_Business(rs1.getString("Small_Business"));
					logger.log(Level.INFO, "12c Small_Business " + rs1.getString("Small_Business"));
					details.setInvoice_Hold_Name(rs1.getString("Invoice_Hold_Name"));
					logger.log(Level.INFO, "12c Invoice_Hold_Name " + rs1.getString("Invoice_Hold_Name"));
					details.setPo_Hold_Release_Date(rs1.getString("PO_Hold_Release_Date"));
					logger.log(Level.INFO, "12c PO_Hold_Release_Date " + rs1.getString("PO_Hold_Release_Date"));
					details.setFindel_Hold_Release_Date(rs1.getString("Findel_Hold_Release_Date"));
					logger.log(Level.INFO, "12c Findel_Hold_Release_Date " + rs1.getString("Findel_Hold_Release_Date"));
					// 923018-Addition of four fields in ECM End
					// ECM Update End

					statusList.add(details);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs1 != null) {
					try {
						rs1.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (ps1 != null) {
					try {
						ps1.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (ebsDb != null) {
					try {
						ebsDb.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

			logger.log(Level.INFO, "12c QUERY EXECUTION END --------");
			logger.log(Level.INFO, "12c Total number of records from EBS : " + statusList.size());

			Connection eqfilesDb = null;
			try {

//				eqfilesDb = DBUtil.getEqfilesConnection();
				// String eqfilesQuery = props.getProperty("EQFILES_QUERY");
				// PreparedStatement invoiceSearchQuery = eqfilesDb.prepareStatement(
				// eqfilesQuery );

				logger.log(Level.INFO, "12c CONNECTING IMAGING ---------");

				DocumentService docUpdateService = new DocumentService_Service().getDocumentServicePort();
				BindingProvider bindingProvider = (BindingProvider) docUpdateService;
				@SuppressWarnings("rawtypes")
				List<Handler> handlerChain = new ArrayList<Handler>();
				handlerChain.add(new WSSecurityHeaderSOAPHandler(
						PropertyLoader.getInstance().getProperty("IMAGING_DOCUMENT_SERVICE_USERNAME_12C").toString(),
						PropertyLoader.getInstance().getProperty("IMAGING_DOCUMENT_SERVICE_PASSWORD_12C").toString()));

				logger.log(Level.INFO, "12c IMAGING CONNECTION SUCCESSFUL -------");
				bindingProvider.getBinding().setHandlerChain(handlerChain);

				/*
				 * DataObjectOperationsByID svc = new
				 * DataObjectOperationsByID_Service().getDataObjectOperationsByID();
				 * BindingProvider bindingProvider2 = (BindingProvider)svc;
				 * 
				 * @SuppressWarnings("rawtypes") List<Handler> handlerChain2 = new
				 * ArrayList<Handler>(); handlerChain2.add(new
				 * ap.quantas.com.bamUpdateWebService.WSSecurityHeaderSOAPHandler(
				 * PropertyLoader.getInstance().getProperty("BAM_DATA_OBJECT_SERVICE_USERNAME").
				 * toString(),
				 * PropertyLoader.getInstance().getProperty("BAM_DATA_OBJECT_SERVICE_PASSWORD").
				 * toString() ) ); bindingProvider2.getBinding().setHandlerChain(handlerChain2);
				 */

				// int noOfMatchedRecords = 0;

				/* ArrayList<String> failedUpdateList = new ArrayList<String>(); */
				// String[] split;

				String docID = null;
				for (StatusDetails detail : statusList) {
					logger.log(Level.INFO, "12c Inside Update For loop....");
					// String docID = "35.IPM_010721";
					logger.log(Level.INFO, "12c Invoice Number ........." + detail.getInvoice_num());
					String imgUrl = detail.getImage_url();
					if (imgUrl != null) {
						logger.log(Level.INFO, "12c Image URL : " + imgUrl);
						// docID = "2.IPM_"+imgUrl;
						docID = initials + imgUrl;
						logger.log(Level.INFO, "12c imgUrl fetched from " + Constant.compileFor.value()
								+ " env. having docID :" + docID);
						updateDocCustom(detail, docID, docUpdateService, props, eqfilesDb);
						logger.log(Level.INFO, "12c All records updated against imgUrl, docID  :" + docID);
					}

					String imgUrl2 = detail.getImage_url2();
					if (imgUrl2 != null) {

						logger.log(Level.INFO, "12c Image URL2 : " + imgUrl2);
						docID = initials + imgUrl2;
						logger.log(Level.INFO, "12c imgUrl2 fetched from " + Constant.compileFor.value()
								+ " env. having docID :" + docID);
						updateDocCustom(detail, docID, docUpdateService, props, eqfilesDb);
						logger.log(Level.INFO, "12c All records updated against imgUrl2, docID  :" + docID);
					}

					String imgUrl3 = detail.getImage_url3();
					if (imgUrl3 != null) {
						logger.log(Level.INFO, "12c Image URL3 : " + imgUrl3);
						docID = initials + imgUrl3;
						logger.log(Level.INFO, "12c imgUrl3 fetched from " + Constant.compileFor.value()
								+ " env. having docID :" + docID);
						updateDocCustom(detail, docID, docUpdateService, props, eqfilesDb);
						logger.log(Level.INFO, "12c All records updated against imgUrl3, docID  :" + docID);
					}

					// split = imgUrl.split("=");
					// String docURL = split[0];
					// String docID = split[1];
					// logger.log(Level.INFO, "docURL..."+docURL);

				}

				// logger.log(Level.INFO, "===== Total records updated : "+noOfMatchedRecords);

				if (failedUpdateList.size() > 0) {
					logger.log(Level.INFO, "12c ===== Number of failed updates : " + failedUpdateList.size());
					logger.log(Level.INFO, "12c ===== Failed to update LastUpdatedTimestamp in properties table");
					logger.log(Level.INFO,
							"12c ===== Please check for ERROR/Image_url coulumn returned from EBS Query for Failed update list : "
									+ failedUpdateList);

					// mail part implementation below in case ECM update failed
					String successCount = String.valueOf(statusList.size() - failedUpdateList.size());
					logger.log(Level.INFO, "12c ===== Number of successful updates : " + successCount);
					// String failedList = "Failed update DocID list : "+failedUpdateList;
					logger.log(Level.INFO, "12c ===== sending Mail");
					String failedError = "<p>";

					Session session = null;
					Properties properties = System.getProperties();
					// properties.setProperty("mail.smtp.host","eqdr-soa-ap1");//12c psp
					 properties.setProperty("mail.smtp.host","172.28.188.7");//PROD
//					properties.setProperty("mail.smtp.host", "172.27.42.7");// PSP
					session = Session.getDefaultInstance(properties);
					Message msg = new MimeMessage(session);
					msg.setFrom(InternetAddress.parse("ecmNotification@qantas.com.au", false)[0]);

					msg.setRecipients(Message.RecipientType.TO, InternetAddress
							.parse("anirban.saha@qantas.com.au,pinkyroy@qantas.com.au,kakali.chowdhury@qantas.com.au"));

					Iterator<Map.Entry<String, String>> itr = ErrorList.entrySet().iterator();
					logger.log(Level.INFO, "12c ===== Size ===  :: " + ErrorList.size());
					while (itr.hasNext()) {
						Map.Entry<String, String> entry = itr.next();
						/*
						 * System.out.println("Key = " + entry.getKey() + ", Value = " +
						 * entry.getValue());
						 */
						failedError = failedError.concat(entry.getKey()).concat(" - ").concat(entry.getValue())
								.concat("<br>");
					}
					logger.log(Level.INFO, "12c ===== Doc Id List  ===" + failedError);
					msg.setSubject("Doc ID failed list for 12c " + Constant.compileFor.value());
					msg.setSentDate(new java.util.Date());
					msg.setContent(
							"<p>Hi All,</p></br><p>ECM update is completed, Below is the generated report for same :</p></br><p>Code was running for duration: From "
									+ lastUpdateTimestamp + " to " + currentTimestamp
									+ "</p></br><p>Total number of records from EBS within this period: "
									+ statusList.size() + "</p></br><p>Successfully updated for number of records: "
									+ successCount + "</p></br><p>Failed to update for number of records: "
									+ failedUpdateList.size()
									+ "</p></br><p>Kindly check logs for error occurred.</p></br><p>Doc IDs against failed update: "
									+ failedError + "</p></br><p>Regards</p></br><p>eQ OWC Support Team</p>",
							"text/html; charset=utf-8");
					Transport.send(msg);

					logger.log(Level.INFO, "12c ===== Mail sent successfully");
				}
				// else
				// {

				logger.log(Level.INFO, "12c ===== Updating LastUpdatedTimestamp in properties table");
				eqfilesDb = DBUtil.getEqfilesConnection();
				updateLastUpdatedTimestampFromPropertyTable(eqfilesDb, props, currentTimestamp,
						firstRun ? "insert" : "update");

				logger.log(Level.INFO, "12c ===== LastUpdatedTimestamp Updated successfully");
				// }

			} catch (Exception e) {
				// logger.error(e.getMessage(), e);
				// OR
				logger.log(Level.INFO, e.getMessage(), e);
				e.printStackTrace();

			} finally {
				if (eqfilesDb != null) {
					try {
						eqfilesDb.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}

			IS_RUNNING = false;
		}

		failedUpdateList = null;
		logger.log(Level.INFO, "12c ===== Imaging Update for EBS Internal Status : END ======");
		logger.log(Level.INFO, "12c ===== " + new Date() + " =====");

	}

	public void updateDocCustom(StatusDetails detail, String docID, DocumentService docUpdateService, Properties props,
			Connection conn) {

		logger.log(Level.INFO, "12c Updating for DOCID :::" + docID);

		try

		{
			List<FieldValue> fieldValues = new ArrayList<FieldValue>();

			{
				FieldValue fieldValue1 = new FieldValue();
				fieldValue1.setName("Activity");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInvoice_status());
				logger.log(Level.INFO, "\t\t12c detail.getInvoice_status() " + detail.getInvoice_status());
				fieldValue1.setValue(typedValue);
				fieldValues.add(fieldValue1);
			}

			{
				FieldValue fieldValue2 = new FieldValue();
				fieldValue2.setName("Approver Name");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getApprover_name());
				logger.log(Level.INFO, "\t\t12c detail.getApprover_name() " + detail.getApprover_name());
				fieldValue2.setValue(typedValue);
				fieldValues.add(fieldValue2);
			}

			{
				FieldValue fieldValue3 = new FieldValue();
				fieldValue3.setName("Payment Number");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getPayment_number());
				logger.log(Level.INFO, "\t\t12c detail.getPayment_number() " + detail.getPayment_number());
				fieldValue3.setValue(typedValue);
				fieldValues.add(fieldValue3);
			}

			{
				FieldValue fieldValue4 = new FieldValue();
				fieldValue4.setName("Invoice Number");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInvoice_num());
				logger.log(Level.INFO, "\t\t12c detail.getInvoice_num() " + detail.getInvoice_num());
				fieldValue4.setValue(typedValue);
				fieldValues.add(fieldValue4);
			}

			{
				FieldValue fieldValue5 = new FieldValue();
				fieldValue5.setName("Payment Date");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DATE);
				typedValue.setValue(detail.getPayment_date());
				logger.log(Level.INFO, "\t\t12c detail.getPayment_date() " + detail.getPayment_date());
				fieldValue5.setValue(typedValue);
				fieldValues.add(fieldValue5);
			}

			// newly added
			{
				FieldValue fieldValue6 = new FieldValue();
				fieldValue6.setName("Supplier ID");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getSupplier_id());
				logger.log(Level.INFO, "\t\t12c detail.getSupplier_id() " + detail.getSupplier_id());
				fieldValue6.setValue(typedValue);
				fieldValues.add(fieldValue6);
			}

			{
				FieldValue fieldValue7 = new FieldValue();
				fieldValue7.setName("Operating Unit Name");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getOperating_unit_name());
				logger.log(Level.INFO, "\t\t12c detail.getOperating_unit_name() " + detail.getOperating_unit_name());
				fieldValue7.setValue(typedValue);
				fieldValues.add(fieldValue7);
			}

			{
				FieldValue fieldValue8 = new FieldValue();
				fieldValue8.setName("Currency");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getCurrency());
				logger.log(Level.INFO, "\t\t12c detail.getCurrency() " + detail.getCurrency());
				fieldValue8.setValue(typedValue);
				fieldValues.add(fieldValue8);
			}

			{
				FieldValue fieldValue9 = new FieldValue();
				fieldValue9.setName("Invoice Total");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DECIMAL);
				typedValue.setValue(detail.getInvoice_total());
				logger.log(Level.INFO, "\t\t12c detail.getInvoice_total() " + detail.getInvoice_total());
				fieldValue9.setValue(typedValue);
				fieldValues.add(fieldValue9);
			}

			{
				FieldValue fieldValue10 = new FieldValue();
				fieldValue10.setName("AOG");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DECIMAL);
				typedValue.setValue(detail.getAog());
				logger.log(Level.INFO, "\t\t12c detail.getAog() " + detail.getAog());
				fieldValue10.setValue(typedValue);
				fieldValues.add(fieldValue10);
			}

			{
				FieldValue fieldValue11 = new FieldValue();
				fieldValue11.setName("Freight");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DECIMAL);
				typedValue.setValue(detail.getFreight());
				logger.log(Level.INFO, "\t\t12c detail.getFreight() " + detail.getFreight());
				fieldValue11.setValue(typedValue);
				fieldValues.add(fieldValue11);
			}

			{
				FieldValue fieldValue12 = new FieldValue();
				fieldValue12.setName("Currency Equivalent");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DECIMAL);
				typedValue.setValue(detail.getCurrency_equivalent());
				logger.log(Level.INFO, "\t\t12c detail.getCurrency_equivalent() " + detail.getCurrency_equivalent());
				fieldValue12.setValue(typedValue);
				fieldValues.add(fieldValue12);
			}

			{
				FieldValue fieldValue13 = new FieldValue();
				fieldValue13.setName("Due date");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DATE);
				typedValue.setValue(detail.getDue_date());
				logger.log(Level.INFO, "\t\t12c detail.getDue_date() " + detail.getDue_date());
				fieldValue13.setValue(typedValue);
				fieldValues.add(fieldValue13);
			}

			{
				FieldValue fieldValue14 = new FieldValue();
				fieldValue14.setName("Invoice Date");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DATE);
				typedValue.setValue(detail.getInvoice_date());
				logger.log(Level.INFO, "\t\t12c detail.getInvoice_date() " + detail.getInvoice_date());
				fieldValue14.setValue(typedValue);
				fieldValues.add(fieldValue14);
			}

			{
				FieldValue fieldValue15 = new FieldValue();
				fieldValue15.setName("PO Number");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getPo_number());
				logger.log(Level.INFO, "\t\t12c detail.getPo_number() " + detail.getPo_number());
				fieldValue15.setValue(typedValue);
				fieldValues.add(fieldValue15);
			}

			{
				FieldValue fieldValue16 = new FieldValue();
				fieldValue16.setName("InvoiceDescription");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				String tmpDesc = detail.getDescription();
				logger.log(Level.INFO, "\t\t12c detail.getDescription() " + tmpDesc);
				int len = (null != tmpDesc) ? tmpDesc.length() : 0;
				logger.log(Level.INFO, "\t\t12c lenght " + len);
				if (len < 200) {
					typedValue.setValue(tmpDesc);
				} else {
					logger.log(Level.INFO, "\t\t12c Description() " + tmpDesc.substring(0, 198));
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
				typedValue.setValue(detail.getSmall_Business());
				logger.log(Level.INFO, "\t\t12c detail.getSmall_Business() " + detail.getSmall_Business());
				fieldValue17.setValue(typedValue);
				fieldValues.add(fieldValue17);
			}

			{
				FieldValue fieldValue18 = new FieldValue();
				fieldValue18.setName("On-Hold");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.TEXT);
				typedValue.setValue(detail.getInvoice_Hold_Name());
				logger.log(Level.INFO, "\t\t12c detail.getInvoice_Hold_Name() " + detail.getInvoice_Hold_Name());
				fieldValue18.setValue(typedValue);
				fieldValues.add(fieldValue18);
			}

			{
				FieldValue fieldValue19 = new FieldValue();
				fieldValue19.setName("PO_Hold_Release_Date");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DATE);
				typedValue.setValue(detail.getPo_Hold_Release_Date());
				logger.log(Level.INFO, "\t\t12c detail.getPo_Hold_Release_Date() " + detail.getPo_Hold_Release_Date());
				fieldValue19.setValue(typedValue);
				fieldValues.add(fieldValue19);
			}

			{
				FieldValue fieldValue20 = new FieldValue();
				fieldValue20.setName("Findel_Hold_Release_Date");
				TypedValue typedValue = new TypedValue();
				typedValue.setType(FieldType.DATE);
				typedValue.setValue(detail.getFindel_Hold_Release_Date());
				logger.log(Level.INFO,
						"\t\t12c detail.getFindel_Hold_Release_Date() " + detail.getFindel_Hold_Release_Date());
				fieldValue20.setValue(typedValue);
				fieldValues.add(fieldValue20);
			}

			// 923018

			docUpdateService.updateDocument(new Holder<String>(docID == null ? "" : docID), null, fieldValues, false);
			logger.log(Level.INFO, "\t\t12c Updating Webcenter IPM successful for DocID ---" + docID);
			// noOfMatchedRecords++;

		} catch (Exception e) {

			logger.log(Level.INFO,
					"\t\t12c Updating Webcenter IPM failed for DocID --- " + docID + " with error " + e.getMessage());
			if ("2.IPM_2523145".equalsIgnoreCase(docID)) {
				logger.log(Level.INFO, "\t\t12c Not Writting any error for doc id ---" + docID);
			} else {
				ErrorList.put(docID, e.getMessage());
				logger.log(Level.INFO, "12c Error " + e);
				// e.printStackTrace();
				failedUpdateList.add(docID);
				insertErrorRecord(conn, props, detail, e.getMessage(), docID);
			}

			// e.printStackTrace();
		}
	}

}

class StatusDetails {
	private String invoice_num;
	private String supplier_number;
	private String site_id;
	private String org_id;
	private String invoice_status;
	private String image_url;
	private String image_url2;
	private String image_url3;
	private String approver_name;
	private String payment_number;
	private String payment_date;
	// newly added
	private String ap_invoice_source;
	private String supplier_id;
	private String operating_unit_name;
	private String invoice_total;
	private String aog;
	private String freight;
	private String currency_equivalent;
	private String due_date;
	private String invoice_date;
	private String po_number;
	private String currency;
	// 923018-Addition of four fields in ECM Start
	private String small_Business;
	private String invoice_Hold_Name;
	private String po_Hold_Release_Date;
	private String findel_Hold_Release_Date;
	// 923018-Addition of four fields in ECM End
	private String description;
	// 923018-Addition of four fields in ECM Start

	public String getSmall_Business() {
		return small_Business;
	}

	public void setSmall_Business(String small_Business) {
		this.small_Business = small_Business;
	}

	public String getInvoice_Hold_Name() {
		return invoice_Hold_Name;
	}

	public void setInvoice_Hold_Name(String invoice_Hold_Name) {
		this.invoice_Hold_Name = invoice_Hold_Name;
	}

	public String getPo_Hold_Release_Date() {
		return po_Hold_Release_Date;
	}

	public void setPo_Hold_Release_Date(String po_Hold_Release_Date) {
		this.po_Hold_Release_Date = po_Hold_Release_Date;
	}

	public String getFindel_Hold_Release_Date() {
		return findel_Hold_Release_Date;
	}

	public void setFindel_Hold_Release_Date(String findel_Hold_Release_Date) {
		this.findel_Hold_Release_Date = findel_Hold_Release_Date;
	}

	// 923018-Addition of four fields in ECM -End
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInvoice_num() {
		return invoice_num;
	}

	public void setInvoice_num(String invoice_num) {
		this.invoice_num = invoice_num;
	}

	public String getSupplier_number() {
		return supplier_number;
	}

	public void setSupplier_number(String supplier_number) {
		this.supplier_number = supplier_number;
	}

	public String getSite_id() {
		return site_id;
	}

	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}

	public String getOrg_id() {
		return org_id;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	public String getInvoice_status() {
		return invoice_status;
	}

	public void setInvoice_status(String invoice_status) {
		this.invoice_status = invoice_status;
	}

	public String getApprover_name() {
		return approver_name;
	}

	public void setApprover_name(String approver_name) {
		this.approver_name = approver_name;
	}

	public String getPayment_number() {
		return payment_number;
	}

	public void setPayment_number(String payment_number) {
		this.payment_number = payment_number;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getOperating_unit_name() {
		return operating_unit_name;
	}

	public void setOperating_unit_name(String operating_unit_name) {
		this.operating_unit_name = operating_unit_name;
	}

	public String getInvoice_total() {
		return invoice_total;
	}

	public void setInvoice_total(String invoice_total) {
		this.invoice_total = invoice_total;
	}

	public String getAog() {
		return aog;
	}

	public void setAog(String aog) {
		this.aog = aog;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getCurrency_equivalent() {
		return currency_equivalent;
	}

	public void setCurrency_equivalent(String currency_equivalent) {
		this.currency_equivalent = currency_equivalent;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public String getInvoice_date() {
		return invoice_date;
	}

	public void setInvoice_date(String invoice_date) {
		this.invoice_date = invoice_date;
	}

	public String getPo_number() {
		return po_number;
	}

	public void setPo_number(String po_number) {
		this.po_number = po_number;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAp_invoice_source() {
		return ap_invoice_source;
	}

	public void setAp_invoice_source(String ap_invoice_source) {
		this.ap_invoice_source = ap_invoice_source;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getImage_url2() {
		return image_url2;
	}

	public void setImage_url2(String image_url2) {
		this.image_url2 = image_url2;
	}

	public String getImage_url3() {
		return image_url3;
	}

	public void setImage_url3(String image_url3) {
		this.image_url3 = image_url3;
	}

	@Override
	public String toString() {
		return "StatusDetails [invoice_num=" + invoice_num + ", supplier_number=" + supplier_number + ", site_id="
				+ site_id + ", org_id=" + org_id + ", invoice_status=" + invoice_status + ", image_url=" + image_url
				+ ", image_url2=" + image_url2 + ", image_url3=" + image_url3 + ",supplier_id=" + supplier_id
				+ ", operating_unit_name=" + operating_unit_name + ", invoice_total=" + invoice_total + ", aog=" + aog
				+ ", freight=" + freight + ", currency_equivalent=" + currency_equivalent + ", due_date=" + due_date
				+ ", invoice_date=" + invoice_date + ", po_number=" + po_number + ", currency=" + currency
				+ ", small_Business=" + small_Business // 923018- Addition of four fields in ECM
				+ ", invoice_Hold_Name=" + invoice_Hold_Name + ", po_Hold_Release_Date=" + po_Hold_Release_Date
				+ ", findel_Hold_Release_Date=" + findel_Hold_Release_Date + ", description=" + description + "]";
	}

}
