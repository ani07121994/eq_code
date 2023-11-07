package com.qantas.ap.quartz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;













//import ap.quantas.com.PropertyLoader;
import ap.quantas.com.imaging.WSSecurityHeaderSOAPHandler;
import ap.quantas.com.imaging.documentUpdate.DocumentService;
import ap.quantas.com.imaging.documentUpdate.DocumentService_Service;
import ap.quantas.com.imaging.documentUpdate.FieldValue;
import ap.quantas.com.imaging.documentUpdate.TypedValue;
import ap.quantas.com.imaging.documentUpdate.FieldType;

public class Demo
{
	//private static volatile boolean IS_RUNNING = false;
	/*private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static Date getLastUpdatedTimestampFromPropertyTable(Properties props)
	{
		Connection eqfilesDb = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Date retDate = null; 
		try
		{
			eqfilesDb = DBUtil.getEqfilesConnection();
			String query = props.getProperty("TIMESTAMP_CHECK_QUERY");
			ps = eqfilesDb.prepareStatement( query );			
			rs = ps.executeQuery();
			rs.next();
			retDate = DATE_FORMAT.parse(rs.getString(1));
		}
		catch(Exception ex)
		{
			//ex.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try
				{
					ps.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try
				{
					rs.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			if(eqfilesDb!=null)
			{
				try {
					eqfilesDb.close();
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		}
		return retDate;
	}
	
	private static void updateLastUpdatedTimestampFromPropertyTable(Connection conn, Properties props, Date dt, String insertOrUpdate) {		
		String url = "jdbc:oracle:thin:@eqdr-db1:16013:SOAPSP1";
		PreparedStatement ps = null;			
		try {
			//conn = DBUtil.getEqfilesConnection();
			
			//String eqfilesQuery = props.getProperty("EQFILES_QUERY");
			conn = DriverManager.getConnection(url,"eqfiles","soapSp009");
			
			String query = null;
			if(insertOrUpdate.equalsIgnoreCase("insert")) {
				System.out.println("===== inserting last update timestamp =====");
				query = props.getProperty("TIMESTAMP_INSERT_QUERY");
			} else if(insertOrUpdate.equalsIgnoreCase("update")) {
				System.out.println("===== updating last update timestamp =====");
				query = props.getProperty("TIMESTAMP_UPDATE_QUERY");
			}
			ps = conn.prepareStatement( query );		
			ps.setString(1, DATE_FORMAT.format(dt));			
			ps.executeUpdate();	
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}						
		}
	}*/
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		System.out.println("===== Imaging Update for Manual : START ======");
		System.out.println("===== "+new Date()+" =====");
		//System.out.println("===== Loading query =====");
		
		Properties props = new Properties();
			
			try
			{
				props.load(Demo.class.getResourceAsStream("queries.sql"));
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			
		Date currentTimestamp = new Date();
			
		Date lastUpdateTimestamp = null;
		boolean firstRun = true;
		String ebsQuery = props.getProperty("EBS_QUERY");
		String ebs2="SELECT ai.invoice_num \r\n" + 
				"      ,ai.invoice_id \r\n" + 
				"      ,as1.segment1 supplier_number \r\n" + 
				"      ,as1.vendor_id supplier_id \r\n" + 
				"      ,ass.vendor_site_id site_id \r\n" + 
				"      ,ai.org_id \r\n" + 
				"      ,hou.NAME \r\n" + 
				"      ,ai.invoice_currency_code \r\n" + 
				"      ,ai.invoice_amount \r\n" + 
				"      ,to_char(ai.invoice_date \r\n" + 
				"              ,'YYYY-MM-DD') invoice_date \r\n" + 
				"      ,ail.freight \r\n" + 
				"      ,ail.aog \r\n" + 
				"      ,ail.due_date \r\n" + 
				"      ,ail.witholding_tax \r\n" + 
				"      ,(SELECT ph.segment1 \r\n" + 
				"          FROM apps.po_headers_all       ph \r\n" + 
				"              ,apps.ap_invoice_lines_all ail \r\n" + 
				"         WHERE ail.po_header_id = ph.po_header_id \r\n" + 
				"           AND nvl(ail.discarded_flag \r\n" + 
				"                  ,'N') <> 'Y' \r\n" + 
				"           AND rownum < 2 \r\n" + 
				"           AND ail.invoice_id = ai.invoice_id) po_number \r\n" + 
				"      ,ai.invoice_type_lookup_code ap_invoice_type \r\n" + 
				"      ,ai.SOURCE ap_invoice_source \r\n" + 
				"      ,decode((SELECT COUNT(1) \r\n" + 
				"                FROM apps.fnd_lookup_values flv \r\n" + 
				"               WHERE flv.lookup_type = 'QFEQ_JETSTAR_JBA_SETUP_CONTROL' \r\n" + 
				"                 AND flv.lookup_code = ai.org_id) \r\n" + 
				"             ,1 \r\n" + 
				"             ,nvl((SELECT APPS.jseq_ap_inv_img_process.amount_rounding(flv.tag,(conversion_rate * ai.invoice_amount)) \r\n" + 
				"                    FROM gl.gl_daily_rates \r\n" + 
				"                        ,apps.fnd_lookup_values flv \r\n" + 
				"                   WHERE conversion_date = ai.gl_date \r\n" + 
				"                     AND from_currency = ai.invoice_currency_code \r\n" + 
				"                     AND to_currency = flv.tag \r\n" + 
				"                     AND conversion_type = 1000 \r\n" + 
				"                     AND flv.lookup_type = \r\n" + 
				"                         'QFEQ_JETSTAR_JBA_SETUP_CONTROL' \r\n" + 
				"                     AND flv.lookup_code = ai.org_id) \r\n" + 
				"                 ,ai.invoice_amount) \r\n" + 
				"             ,nvl(ai.base_amount \r\n" + 
				"                 ,ai.invoice_amount)) currency_equivalent \r\n" + 
				"      ,regexp_substr(ai.attribute15 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2) image_url \r\n" + 
				"      ,regexp_substr(ai.global_attribute2 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2)  image_url2 \r\n" + 
				"      ,regexp_substr(ai.global_attribute3 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2)  image_url3 \r\n" + 
				"      ,'eQ ' || initcap(decode(ai.cancelled_date \r\n" + 
				"                              ,NULL \r\n" + 
				"                              ,decode(ai.payment_status_flag \r\n" + 
				"                                     ,'Y' \r\n" + 
				"                                     ,'Paid' \r\n" + 
				"                                     ,decode(hist.response \r\n" + 
				"                                            ,NULL \r\n" + 
				"                                            ,'Created' \r\n" + 
				"                                            ,hist.response)) \r\n" + 
				"                              ,'Cancelled')) invoice_status \r\n" + 
				"      ,hist.approver_name pending_with_approved_by \r\n" + 
				"      ,hist.last_update_date action_date \r\n" + 
				"      ,paymnt.check_number payment_number \r\n" + 
				"      ,to_char(paymnt.check_date \r\n" + 
				"              ,'YYYY-MM-DD') payment_date \r\n" + 
				"    ,ai.description\r\n" + 
				"      ,as1.SMALL_BUSINESS_FLAG Small_Business\r\n" + 
				"      ,(SELECT HOLD_LOOKUP_CODE \r\n" + 
				"          FROM (SELECT HOLD_LOOKUP_CODE, HOLD_ID \r\n" + 
				"                  FROM apps.ap_holds_all aha1 \r\n" + 
				"                 WHERE aha1.invoice_id = ai.invoice_id \r\n" + 
				"                   and aha1.release_lookup_code is null \r\n" + 
				"                 ORDER BY HOLD_ID) \r\n" + 
				"         WHERE ROWNUM = 1 \r\n" + 
				"        UNION  \r\n" + 
				"        SELECT HOLD_LOOKUP_CODE \r\n" + 
				"          FROM (SELECT HOLD_LOOKUP_CODE, HOLD_ID, LAST_UPDATE_DATE \r\n" + 
				"                  FROM apps.ap_holds_all aha1 \r\n" + 
				"                 WHERE aha1.invoice_id = ai.invoice_id \r\n" + 
				"                   AND NOT EXISTS \r\n" + 
				"                 (SELECT 1 \r\n" + 
				"                          FROM apps.ap_holds_all aha2 \r\n" + 
				"                         WHERE aha1.invoice_id = aha2.invoice_id \r\n" + 
				"                           AND aha2.release_lookup_code is null) \r\n" + 
				"                 ORDER BY LAST_UPDATE_DATE DESC) \r\n" + 
				"         WHERE ROWNUM = 1) Invoice_Hold_Name \r\n" + 
				",(SELECT TO_CHAR(LAST_UPDATE_DATE, 'DD-MM-YYYY HH24:MI:SS' )\r\n" + 
				"          FROM (SELECT LAST_UPDATE_DATE \r\n" + 
				"                  FROM apps.ap_holds_all aha1 \r\n" + 
				"                 WHERE aha1.invoice_id = ai.invoice_id \r\n" + 
				"                   and aha1.release_lookup_code is NOT null \r\n" + 
				"                   AND HOLD_LOOKUP_CODE IN \r\n" + 
				"                       ('AMT ORD', 'AMT REC', 'MAX AMT ORD', 'MAX AMT REC', \r\n" + 
				"                        'QTY ORD', 'QTY REC') \r\n" + 
				"                   AND NOT EXISTS \r\n" + 
				"                 (SELECT 1 \r\n" + 
				"                          FROM apps.ap_holds_all aha2 \r\n" + 
				"                         WHERE aha2.invoice_id = aha1.invoice_id \r\n" + 
				"                           and aha2.release_lookup_code is null \r\n" + 
				"                           AND HOLD_LOOKUP_CODE IN \r\n" + 
				"                               ('AMT ORD', 'AMT REC', 'MAX AMT ORD', \r\n" + 
				"                                'MAX AMT REC', 'QTY ORD', 'QTY REC')) \r\n" + 
				"                 ORDER BY LAST_UPDATE_DATE DESC) \r\n" + 
				"         WHERE ROWNUM = 1) PO_Hold_Release_Date \r\n" + 
				" ,(SELECT TO_CHAR(APPROVAL_DATE, 'DD-MM-YYYY HH24:MI:SS' )\r\n" + 
				"          FROM (SELECT LAST_UPDATE_DATE APPROVAL_DATE \r\n" + 
				"                  FROM apps.ap_holds_all aha1 \r\n" + 
				"                 WHERE aha1.invoice_id = AI.INVOICE_ID \r\n" + 
				"                   and aha1.release_lookup_code is NOT null \r\n" + 
				"                   AND HOLD_LOOKUP_CODE = 'Accounting Hold' \r\n" + 
				"                   AND AI.WFAPPROVAL_STATUS = 'WFAPPROVED' \r\n" + 
				"                 order by LAST_UPDATE_DATE DESC) \r\n" + 
				"         WHERE ROWNUM = 1) Findel_Hold_Release_Date \r\n" + 
				"  FROM apps.ap_invoices_all ai \r\n" + 
				"      ,apps.ap_suppliers as1 \r\n" + 
				"      ,apps.ap_supplier_sites_all ass \r\n" + 
				"      ,(SELECT * \r\n" + 
				"          FROM (SELECT rank() over(PARTITION BY invoice_id ORDER BY aha.invoice_id, aha.last_update_date DESC, aha.approval_history_id DESC) sl_no \r\n" + 
				"                      ,aha.* \r\n" + 
				"                  FROM apps.ap_inv_aprvl_hist_all aha) \r\n" + 
				"         WHERE sl_no = 1) hist \r\n" + 
				"      ,(SELECT ac.check_number \r\n" + 
				"              ,ac.check_date \r\n" + 
				"              ,aip.invoice_id \r\n" + 
				"          FROM apps.ap_invoice_payments_all aip \r\n" + 
				"              ,apps.ap_checks_all           ac \r\n" + 
				"         WHERE ac.check_id = aip.check_id \r\n" + 
				"           AND ac.void_date IS NULL) paymnt \r\n" + 
				"      ,(SELECT SUM(decode(ail.line_type_lookup_code \r\n" + 
				"                         ,'AWT' \r\n" + 
				"                         ,amount \r\n" + 
				"                         ,0)) witholding_tax \r\n" + 
				"              ,SUM(decode(ail.line_type_lookup_code \r\n" + 
				"                         ,'FREIGHT' \r\n" + 
				"                         ,amount \r\n" + 
				"                         ,0)) freight \r\n" + 
				"              ,SUM(decode(ail.line_type_lookup_code \r\n" + 
				"                         ,'MISCELLANEOUS' \r\n" + 
				"                         ,amount \r\n" + 
				"                         ,0)) aog \r\n" + 
				"              ,aps.due_date \r\n" + 
				"              ,aps.invoice_id \r\n" + 
				"          FROM apps.ap_payment_schedules_all aps \r\n" + 
				"              ,apps.ap_invoice_lines_all     ail \r\n" + 
				"         WHERE aps.invoice_id = ail.invoice_id \r\n" + 
				"         GROUP BY aps.invoice_id \r\n" + 
				"                 ,aps.due_date) ail \r\n" + 
				"      ,apps.fnd_lookup_values flv \r\n" + 
				"      ,apps.hr_operating_units hou \r\n" + 
				"      --added for checking the hold release date\r\n" + 
				"      ,(SELECT max(ah.LAST_UPDATE_DATE) hold_release_date,ah.invoice_id\r\n" + 
				"  FROM apps.ap_holds_all ah\r\n" + 
				" WHERE  ah.release_lookup_code is NOT null\r\n" + 
				"   AND ah.HOLD_LOOKUP_CODE in\r\n" + 
				"       ('Accounting Hold', 'AMT ORD', 'AMT REC', 'MAX AMT ORD',\r\n" + 
				"        'MAX AMT REC', 'QTY ORD', 'QTY REC') group by ah.invoice_id) hold\r\n" + 
				"      --\r\n" + 
				" WHERE ai.SOURCE = flv.lookup_code \r\n" + 
				"   AND flv.lookup_type = 'SOURCE' \r\n" + 
				"   AND flv.attribute15 = 'Y' \r\n" + 
				"   AND ai.vendor_id = as1.vendor_id \r\n" + 
				"   AND ass.vendor_id = as1.vendor_id \r\n" + 
				"   AND ass.vendor_site_id = ai.vendor_site_id \r\n" + 
				"   AND ai.invoice_id = hist.invoice_id(+) \r\n" + 
				"   AND paymnt.invoice_id(+) = ai.invoice_id \r\n" + 
				"   AND ail.invoice_id = ai.invoice_id    \r\n" + 
				"   and hold.invoice_id(+) = ai.invoice_id   \r\n" + 
				"   AND ai.org_id = hou.organization_id \r\n" + 
				"   AND ai.creation_date > '01-JAN-2016' \r\n" + 
				"   AND upper(ai.attribute15)  like '%HTTP%'  \r\n" + 
				"   AND (ai.last_update_date >= to_date('2021-12-07 04:55:17', 'YYYY-MM-DD HH24:MI:ss') OR \r\n" + 
				"       hist.last_update_date >= to_date('2021-12-07 04:55:17', 'YYYY-MM-DD HH24:MI:ss') or\r\n" + 
				"       hold.hold_release_date  >= to_date('2021-12-07 04:55:17', 'YYYY-MM-DD HH24:MI:ss')) \r\n" + 
				"   AND (ai.last_update_date < to_date('2021-12-07 08:55:17', 'YYYY-MM-DD HH24:MI:ss') OR \r\n" + 
				"       hist.last_update_date < to_date('2021-12-07 08:55:17', 'YYYY-MM-DD HH24:MI:ss') or\r\n" + 
				"       hold.hold_release_date  < to_date('2021-12-07 08:55:17', 'YYYY-MM-DD HH24:MI:ss' ))\r\n" + 
				"UNION ALL \r\n" + 
				"SELECT ai.invoice_num \r\n" + 
				"      ,ai.invoice_id \r\n" + 
				"      ,as1.segment1 supplier_number \r\n" + 
				"      ,as1.vendor_id supplier_id \r\n" + 
				"      ,ass.vendor_site_id site_id \r\n" + 
				"      ,ai.org_id \r\n" + 
				"      ,hou.NAME \r\n" + 
				"      ,ai.invoice_currency_code \r\n" + 
				"      ,ai.invoice_amount \r\n" + 
				"      ,to_char(ai.invoice_date \r\n" + 
				"              ,'YYYY-MM-DD') invoice_date \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL po_number \r\n" + 
				"      ,ai.invoice_type_lookup_code ap_invoice_type \r\n" + 
				"      ,ai.SOURCE ap_invoice_source \r\n" + 
				"      ,NULL \r\n" + 
				"      ,regexp_substr(ai.attribute15 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2) image_url \r\n" + 
				"      ,regexp_substr(ai.global_attribute2 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2)  image_url2 \r\n" + 
				"      ,regexp_substr(ai.global_attribute3 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2)  image_url3 \r\n" + 
				"      ,'eQ ' || decode(status \r\n" + 
				"                      ,'REJECTED' \r\n" + 
				"                      ,'Interface Rejected' \r\n" + 
				"                      ,NULL \r\n" + 
				"                      ,'Awaiting Import' \r\n" + 
				"                      ,status) \r\n" + 
				"      ,NULL last_actioned_by \r\n" + 
				"      ,NULL last_action_date \r\n" + 
				"      ,NULL payment_number \r\n" + 
				"      ,NULL payment_date \r\n" + 
				"    ,ai.description \r\n" + 
				"      ,as1.SMALL_BUSINESS_FLAG Small_Business \r\n" + 
				"    ,NULL Invoice_Hold_Name \r\n" + 
				"    ,NULL PO_Hold_Release_Date \r\n" + 
				"    ,NULL Findel_Hold_Release_Date \r\n" + 
				"  FROM apps.ap_invoices_interface ai \r\n" + 
				"      ,apps.ap_suppliers          as1 \r\n" + 
				"      ,apps.ap_supplier_sites_all ass \r\n" + 
				"      ,apps.fnd_lookup_values     flv \r\n" + 
				"      ,apps.hr_operating_units    hou \r\n" + 
				" WHERE ai.SOURCE = flv.lookup_code \r\n" + 
				"   AND flv.lookup_type = 'SOURCE' \r\n" + 
				"   AND flv.attribute15 = 'Y' \r\n" + 
				"   AND ai.vendor_id = as1.vendor_id(+) \r\n" + 
				"   AND ass.vendor_site_id(+) = ai.vendor_site_id \r\n" + 
				"   AND ai.org_id = hou.organization_id \r\n" + 
				"   AND nvl(status \r\n" + 
				"          ,'NEW') <> 'PROCESSED' \r\n" + 
				"   AND upper(ai.attribute15)  like '%HTTP%' \r\n" + 
				"UNION ALL \r\n" + 
				"SELECT ai.invoice_num \r\n" + 
				"      ,ai.invoice_id \r\n" + 
				"      ,as1.segment1 supplier_number \r\n" + 
				"      ,as1.vendor_id supplier_id \r\n" + 
				"      ,ass.vendor_site_id site_id \r\n" + 
				"      ,ai.org_id \r\n" + 
				"      ,hou.NAME \r\n" + 
				"      ,ai.invoice_currency_code \r\n" + 
				"      ,ai.invoice_amount \r\n" + 
				"      ,to_char(ai.invoice_date \r\n" + 
				"              ,'YYYY-MM-DD') invoice_date \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL po_number \r\n" + 
				"      ,ai.invoice_type_lookup_code ap_invoice_type \r\n" + 
				"      ,ai.SOURCE ap_invoice_source \r\n" + 
				"      ,NULL \r\n" + 
				"      ,regexp_substr(ai.attribute15 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2) image_url \r\n" + 
				"      ,regexp_substr(ai.global_attribute2 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2)  image_url2 \r\n" + 
				"      ,regexp_substr(ai.global_attribute3 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2)  image_url3 \r\n" + 
				"      ,'eQ Interface Deleted' \r\n" + 
				"      ,NULL last_actioned_by \r\n" + 
				"      ,NULL last_action_date \r\n" + 
				"      ,NULL payment_number \r\n" + 
				"      ,NULL payment_date \r\n" + 
				"    ,ai.description \r\n" + 
				"      ,as1.SMALL_BUSINESS_FLAG Small_Business   \r\n" + 
				"    ,NULL Invoice_Hold_Name \r\n" + 
				"    ,NULL PO_Hold_Release_Date \r\n" + 
				"    ,NULL Findel_Hold_Release_Date \r\n" + 
				"  FROM bolinf.qfeq_ap_inv_intrfc_del_audit ai \r\n" + 
				"      ,apps.ap_suppliers                   as1 \r\n" + 
				"      ,apps.ap_supplier_sites_all          ass \r\n" + 
				"      ,apps.fnd_lookup_values              flv \r\n" + 
				"      ,apps.hr_operating_units             hou \r\n" + 
				" WHERE ai.SOURCE = flv.lookup_code \r\n" + 
				"   AND flv.lookup_type = 'SOURCE' \r\n" + 
				"   AND flv.attribute15 = 'Y' \r\n" + 
				"   AND ai.vendor_id = as1.vendor_id(+) \r\n" + 
				"   AND ass.vendor_site_id(+) = ai.vendor_site_id \r\n" + 
				"   AND ai.org_id = hou.organization_id ";
				
			
		String ebs1="SELECT ai.invoice_num " + 
				",ai.invoice_id " + 
				",as1.segment1 supplier_number" + 
				",as1.vendor_id supplier_id " + 
				",ass.vendor_site_id site_id" + 
				",ai.org_id" + 
				",hou.NAME \r\n" + 
				" ,ai.invoice_currency_code \r\n" + 
				",ai.invoice_amount \r\n" + 
				",to_char(ai.invoice_date" + 
				",'YYYY-MM-DD') invoice_date " + 
				",ail.freight " + 
				",ail.aog " + 
				",ail.due_date " + 
				",ail.witholding_tax " + 
				"      ,(SELECT ph.segment1 \r\n" + 
				"          FROM apps.po_headers_all       ph \r\n" + 
				"              ,apps.ap_invoice_lines_all ail \r\n" + 
				"         WHERE ail.po_header_id = ph.po_header_id \r\n" + 
				"           AND nvl(ail.discarded_flag \r\n" + 
				"                  ,'N') <> 'Y' \r\n" + 
				"           AND rownum < 2 \r\n" + 
				"           AND ail.invoice_id = ai.invoice_id) po_number \r\n" + 
				"      ,ai.invoice_type_lookup_code ap_invoice_type \r\n" + 
				"      ,ai.SOURCE ap_invoice_source \r\n" + 
				"      ,decode((SELECT COUNT(1) \r\n" + 
				"                FROM apps.fnd_lookup_values flv \r\n" + 
				"               WHERE flv.lookup_type = 'QFEQ_JETSTAR_JBA_SETUP_CONTROL' \r\n" + 
				"                 AND flv.lookup_code = ai.org_id) \r\n" + 
				"             ,1 \r\n" + 
				"             ,nvl((SELECT APPS.jseq_ap_inv_img_process.amount_rounding(flv.tag,(conversion_rate * ai.invoice_amount)) \r\n" + 
				"                    FROM gl.gl_daily_rates \r\n" + 
				"                        ,apps.fnd_lookup_values flv \r\n" + 
				"                   WHERE conversion_date = ai.gl_date \r\n" + 
				"                     AND from_currency = ai.invoice_currency_code \r\n" + 
				"                     AND to_currency = flv.tag \r\n" + 
				"                     AND conversion_type = 1000 \r\n" + 
				"                     AND flv.lookup_type = \r\n" + 
				"                         'QFEQ_JETSTAR_JBA_SETUP_CONTROL' \r\n" + 
				"                     AND flv.lookup_code = ai.org_id) \r\n" + 
				"                 ,ai.invoice_amount) \r\n" + 
				"             ,nvl(ai.base_amount \r\n" + 
				"                 ,ai.invoice_amount)) currency_equivalent \r\n" + 
				"      ,regexp_substr(ai.attribute15 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2) image_url \r\n" + 
				"      ,regexp_substr(ai.global_attribute2 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2)  image_url2 \r\n" + 
				"      ,regexp_substr(ai.global_attribute3 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2)  image_url3 \r\n" + 
				"      ,'eQ ' || initcap(decode(ai.cancelled_date \r\n" + 
				"                              ,NULL \r\n" + 
				"                              ,decode(ai.payment_status_flag \r\n" + 
				"                                     ,'Y' \r\n" + 
				"                                     ,'Paid' \r\n" + 
				"                                     ,decode(hist.response \r\n" + 
				"                                            ,NULL \r\n" + 
				"                                            ,'Created' \r\n" + 
				"                                            ,hist.response)) \r\n" + 
				"                              ,'Cancelled')) invoice_status \r\n" + 
				"      ,hist.approver_name pending_with_approved_by \r\n" + 
				"      ,hist.last_update_date action_date \r\n" + 
				"      ,paymnt.check_number payment_number \r\n" + 
				"      ,to_char(paymnt.check_date \r\n" + 
				"              ,'YYYY-MM-DD') payment_date \r\n" + 
				"	  ,ai.description\r\n" + 
				"      ,as1.SMALL_BUSINESS_FLAG Small_Business\r\n" + 
				"      ,(SELECT HOLD_LOOKUP_CODE \r\n" + 
				"          FROM (SELECT HOLD_LOOKUP_CODE, HOLD_ID \r\n" + 
				"                  FROM apps.ap_holds_all aha1 \r\n" + 
				"                 WHERE aha1.invoice_id = ai.invoice_id \r\n" + 
				"                   and aha1.release_lookup_code is null \r\n" + 
				"                 ORDER BY HOLD_ID) \r\n" + 
				"         WHERE ROWNUM = 1 \r\n" + 
				"        UNION  \r\n" + 
				"        SELECT HOLD_LOOKUP_CODE \r\n" + 
				"          FROM (SELECT HOLD_LOOKUP_CODE, HOLD_ID, LAST_UPDATE_DATE \r\n" + 
				"                  FROM apps.ap_holds_all aha1 \r\n" + 
				"                 WHERE aha1.invoice_id = ai.invoice_id \r\n" + 
				"                   AND NOT EXISTS \r\n" + 
				"                 (SELECT 1 \r\n" + 
				"                          FROM apps.ap_holds_all aha2 \r\n" + 
				"                         WHERE aha1.invoice_id = aha2.invoice_id \r\n" + 
				"                           AND aha2.release_lookup_code is null) \r\n" + 
				"                 ORDER BY LAST_UPDATE_DATE DESC) \r\n" + 
				"         WHERE ROWNUM = 1) Invoice_Hold_Name \r\n" + 
				",(SELECT TRUNC(LAST_UPDATE_DATE) \r\n" + 
				"          FROM (SELECT LAST_UPDATE_DATE \r\n" + 
				"                  FROM apps.ap_holds_all aha1 \r\n" + 
				"                 WHERE aha1.invoice_id = ai.invoice_id \r\n" + 
				"                   and aha1.release_lookup_code is NOT null \r\n" + 
				"                   AND HOLD_LOOKUP_CODE IN \r\n" + 
				"                       ('AMT ORD', 'AMT REC', 'MAX AMT ORD', 'MAX AMT REC', \r\n" + 
				"                        'QTY ORD', 'QTY REC') \r\n" + 
				"                   AND NOT EXISTS \r\n" + 
				"                 (SELECT 1 \r\n" + 
				"                          FROM apps.ap_holds_all aha2 \r\n" + 
				"                         WHERE aha2.invoice_id = aha1.invoice_id \r\n" + 
				"                           and aha2.release_lookup_code is null \r\n" + 
				"                           AND HOLD_LOOKUP_CODE IN \r\n" + 
				"                               ('AMT ORD', 'AMT REC', 'MAX AMT ORD', \r\n" + 
				"                                'MAX AMT REC', 'QTY ORD', 'QTY REC')) \r\n" + 
				"                 ORDER BY LAST_UPDATE_DATE DESC) \r\n" + 
				"         WHERE ROWNUM = 1) PO_Hold_Release_Date \r\n" + 
				" ,(SELECT APPROVAL_DATE \r\n" + 
				"          FROM (SELECT TRUNC(LAST_UPDATE_DATE) APPROVAL_DATE \r\n" + 
				"                  FROM apps.ap_holds_all aha1 \r\n" + 
				"                 WHERE aha1.invoice_id = AI.INVOICE_ID \r\n" + 
				"                   and aha1.release_lookup_code is NOT null \r\n" + 
				"                   AND HOLD_LOOKUP_CODE = 'Accounting Hold' \r\n" + 
				"                   AND AI.WFAPPROVAL_STATUS = 'WFAPPROVED' \r\n" + 
				"                 order by LAST_UPDATE_DATE DESC) \r\n" + 
				"         WHERE ROWNUM = 1) Findel_Hold_Release_Date \r\n" + 
				"  FROM apps.ap_invoices_all ai \r\n" + 
				"      ,apps.ap_suppliers as1 \r\n" + 
				"      ,apps.ap_supplier_sites_all ass \r\n" + 
				"      ,(SELECT * \r\n" + 
				"          FROM (SELECT rank() over(PARTITION BY invoice_id ORDER BY aha.invoice_id, aha.last_update_date DESC, aha.approval_history_id DESC) sl_no \r\n" + 
				"                      ,aha.* \r\n" + 
				"                  FROM apps.ap_inv_aprvl_hist_all aha) \r\n" + 
				"         WHERE sl_no = 1) hist \r\n" + 
				"      ,(SELECT ac.check_number \r\n" + 
				"              ,ac.check_date \r\n" + 
				"              ,aip.invoice_id \r\n" + 
				"          FROM apps.ap_invoice_payments_all aip \r\n" + 
				"              ,apps.ap_checks_all           ac \r\n" + 
				"         WHERE ac.check_id = aip.check_id \r\n" + 
				"           AND ac.void_date IS NULL) paymnt \r\n" + 
				"      ,(SELECT SUM(decode(ail.line_type_lookup_code \r\n" + 
				"                         ,'AWT' \r\n" + 
				"                         ,amount \r\n" + 
				"                         ,0)) witholding_tax \r\n" + 
				"              ,SUM(decode(ail.line_type_lookup_code \r\n" + 
				"                         ,'FREIGHT' \r\n" + 
				"                         ,amount \r\n" + 
				"                         ,0)) freight \r\n" + 
				"              ,SUM(decode(ail.line_type_lookup_code \r\n" + 
				"                         ,'MISCELLANEOUS' \r\n" + 
				"                         ,amount \r\n" + 
				"                         ,0)) aog \r\n" + 
				"              ,aps.due_date \r\n" + 
				"              ,aps.invoice_id \r\n" + 
				"          FROM apps.ap_payment_schedules_all aps \r\n" + 
				"              ,apps.ap_invoice_lines_all     ail \r\n" + 
				"         WHERE aps.invoice_id = ail.invoice_id \r\n" + 
				"         GROUP BY aps.invoice_id \r\n" + 
				"                 ,aps.due_date) ail \r\n" + 
				"      ,apps.fnd_lookup_values flv \r\n" + 
				"      ,apps.hr_operating_units hou \r\n" + 
				" WHERE ai.SOURCE = flv.lookup_code \r\n" + 
				"   AND flv.lookup_type = 'SOURCE' \r\n" + 
				"   AND flv.attribute15 = 'Y' \r\n" + 
				"   AND ai.vendor_id = as1.vendor_id \r\n" + 
				"   AND ass.vendor_id = as1.vendor_id \r\n" + 
				"   AND ass.vendor_site_id = ai.vendor_site_id \r\n" + 
				"   AND ai.invoice_id = hist.invoice_id(+) \r\n" + 
				"   AND paymnt.invoice_id(+) = ai.invoice_id \r\n" + 
				"   AND ail.invoice_id = ai.invoice_id \r\n" + 
				"   AND ai.org_id = hou.organization_id \r\n" + 
				"   AND ai.creation_date > '01-JAN-2016' \r\n" + 
				"   AND upper(ai.attribute15)  like '%HTTP%'  \r\n" + 
				"   AND (ai.last_update_date >= to_date(?, 'YYYY-MM-DD HH24:MI:ss') OR \r\n" + 
				"       hist.last_update_date >= to_date(?, 'YYYY-MM-DD HH24:MI:ss') ) \r\n" + 
				"AND (ai.last_update_date < to_date(?, 'YYYY-MM-DD HH24:MI:ss') OR \r\n" + 
				"       hist.last_update_date < to_date(?, 'YYYY-MM-DD HH24:MI:ss') ) \r\n" + 
				"UNION ALL \r\n" + 
				"SELECT ai.invoice_num \r\n" + 
				"      ,ai.invoice_id \r\n" + 
				"      ,as1.segment1 supplier_number \r\n" + 
				"      ,as1.vendor_id supplier_id \r\n" + 
				"      ,ass.vendor_site_id site_id \r\n" + 
				"      ,ai.org_id \r\n" + 
				"      ,hou.NAME \r\n" + 
				"      ,ai.invoice_currency_code \r\n" + 
				"      ,ai.invoice_amount \r\n" + 
				"      ,to_char(ai.invoice_date \r\n" + 
				"              ,'YYYY-MM-DD') invoice_date \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL po_number \r\n" + 
				"      ,ai.invoice_type_lookup_code ap_invoice_type \r\n" + 
				"      ,ai.SOURCE ap_invoice_source \r\n" + 
				"      ,NULL \r\n" + 
				"      ,regexp_substr(ai.attribute15 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2) image_url \r\n" + 
				"      ,regexp_substr(ai.global_attribute2 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2)  image_url2 \r\n" + 
				"      ,regexp_substr(ai.global_attribute3 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2)  image_url3 \r\n" + 
				"      ,'eQ ' || decode(status \r\n" + 
				"                      ,'REJECTED' \r\n" + 
				"                      ,'Interface Rejected' \r\n" + 
				"                      ,NULL \r\n" + 
				"                      ,'Awaiting Import' \r\n" + 
				"                      ,status) \r\n" + 
				"      ,NULL last_actioned_by \r\n" + 
				"      ,NULL last_action_date \r\n" + 
				"      ,NULL payment_number \r\n" + 
				"      ,NULL payment_date \r\n" + 
				"	  ,ai.description \r\n" + 
				"      ,as1.SMALL_BUSINESS_FLAG Small_Business \r\n" + 
				"	  ,NULL Invoice_Hold_Name \r\n" + 
				"	  ,NULL PO_Hold_Release_Date \r\n" + 
				"	  ,NULL Findel_Hold_Release_Date \r\n" + 
				"  FROM apps.ap_invoices_interface ai \r\n" + 
				"      ,apps.ap_suppliers          as1 \r\n" + 
				"      ,apps.ap_supplier_sites_all ass \r\n" + 
				"      ,apps.fnd_lookup_values     flv \r\n" + 
				"      ,apps.hr_operating_units    hou \r\n" + 
				" WHERE ai.SOURCE = flv.lookup_code \r\n" + 
				"   AND flv.lookup_type = 'SOURCE' \r\n" + 
				"   AND flv.attribute15 = 'Y' \r\n" + 
				"   AND ai.vendor_id = as1.vendor_id(+) \r\n" + 
				"   AND ass.vendor_site_id(+) = ai.vendor_site_id \r\n" + 
				"   AND ai.org_id = hou.organization_id \r\n" + 
				"   AND nvl(status \r\n" + 
				"          ,'NEW') <> 'PROCESSED' \r\n" + 
				"   AND upper(ai.attribute15)  like '%HTTP%' \r\n" + 
				"UNION ALL \r\n" + 
				"SELECT ai.invoice_num \r\n" + 
				"      ,ai.invoice_id \r\n" + 
				"      ,as1.segment1 supplier_number \r\n" + 
				"      ,as1.vendor_id supplier_id \r\n" + 
				"      ,ass.vendor_site_id site_id \r\n" + 
				"      ,ai.org_id \r\n" + 
				"      ,hou.NAME \r\n" + 
				"      ,ai.invoice_currency_code \r\n" + 
				"      ,ai.invoice_amount \r\n" + 
				"      ,to_char(ai.invoice_date \r\n" + 
				"              ,'YYYY-MM-DD') invoice_date \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL \r\n" + 
				"      ,NULL po_number \r\n" + 
				"      ,ai.invoice_type_lookup_code ap_invoice_type \r\n" + 
				"      ,ai.SOURCE ap_invoice_source \r\n" + 
				"      ,NULL \r\n" + 
				"      ,regexp_substr(ai.attribute15 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2) image_url \r\n" + 
				"      ,regexp_substr(ai.global_attribute2 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2)  image_url2 \r\n" + 
				"      ,regexp_substr(ai.global_attribute3 \r\n" + 
				"                          ,'[^_]+' \r\n" + 
				"                          ,1 \r\n" + 
				"                          ,2)  image_url3 \r\n" + 
				"      ,'eQ Interface Deleted' \r\n" + 
				"      ,NULL last_actioned_by \r\n" + 
				"      ,NULL last_action_date \r\n" + 
				"      ,NULL payment_number \r\n" + 
				"      ,NULL payment_date \r\n" + 
				"	  ,ai.description \r\n" + 
				"      ,as1.SMALL_BUSINESS_FLAG Small_Business 	\r\n" + 
				"	  ,NULL Invoice_Hold_Name \r\n" + 
				"	  ,NULL PO_Hold_Release_Date \r\n" + 
				"	  ,NULL Findel_Hold_Release_Date \r\n" + 
				"  FROM bolinf.qfeq_ap_inv_intrfc_del_audit ai \r\n" + 
				"      ,apps.ap_suppliers                   as1 \r\n" + 
				"      ,apps.ap_supplier_sites_all          ass \r\n" + 
				"      ,apps.fnd_lookup_values              flv \r\n" + 
				",apps.hr_operating_units             hou \r\n" + 
				"WHERE ai.SOURCE = flv.lookup_code \r\n" + 
				"AND flv.lookup_type = 'SOURCE' \r\n" + 
				"AND flv.attribute15 = 'Y' \r\n" + 
				"AND ai.vendor_id = as1.vendor_id(+) \r\n" + 
				"AND ass.vendor_site_id(+) = ai.vendor_site_id \r\n" + 
				"AND ai.org_id = hou.organization_id   ";
		System.out.println( "===== ebsQuery : ");
		System.out.println("*****");
		System.out.println();
		//System.out.println(ebsQuery);
		
		
		System.out.println(" ::::: ");
		System.out.println(ebs2);
		System.out.println();
		System.out.println("*******");
		//System.out.println(" lenght of ebsQuery "+ebsQuery.length());
		
		
		try{
			int count = 0;
			
			
			String s="SELECT max(POLL_DATE) FROM QFEQIF_FTP_DIRECT_INTERFACES WHERE FILE_NAME = 'IF106_TEST_20211116_5.dat' AND IF_ID = 'IF106'";

			 Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@eqprod-db1.qantas.com.au:16010:PEBSDB1","appsview","Password08");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@eqsit-soa.qantas.com.au:16013:SOASIT","eqfiles","eqfiles");
			PreparedStatement ps = con.prepareStatement(s);
			//PreparedStatement ps = con.prepareStatement("select count(*) from apps.ap_invoices_interface where attribute12 like '%IMGPROCESS%' and status = 'REJECTED' and source IN ('P2P PO BASED','P2P NON PO INVOICE')");

			 ResultSet rs = ps.executeQuery();
			//Timestamp polldate = new Timestamp(System.currentTimeMillis());
			Timestamp currenttime = new Timestamp(System.currentTimeMillis());
			Long timediff;
			Timestamp polldate=null;
			//int size = rs.getFetchSize();
			//System.out.println("size"+size);
			int c  =0;
			while(rs.next()) {
				c++;
				polldate =rs.getTimestamp(1);
				String st=rs.getString(1);
				if(polldate!=null) {
					System.out.println("BBBB");
				}
				else {
					System.out.println("XXX");
				}
				if(st!=null) {
					System.out.println("HI");
				}else {
					System.out.println("Hello");
				}
				
				System.out.println(polldate);
				
			}
			/*if(size > 0 && rs.isFirst()) {
				System.out.println( " inside if");
			polldate = rs.getTimestamp(1);
			}*/
			System.out.println("polldate"+polldate);
			timediff = currenttime.getTime() - polldate.getTime();
			
			System.out.println(" timediff ::"+timediff);
			}catch(Exception e){
				e.printStackTrace();
				//return -1;
			}
	/*	lastUpdateTimestamp = getLastUpdatedTimestampFromPropertyTable(props);
			
			if(lastUpdateTimestamp!=null)
			{
				System.out.println("Last updated timestamp found in DB ...");
				firstRun = false;
			}
			else
			{
				try
				{
					lastUpdateTimestamp = new Date( currentTimestamp.getTime() - DATE_FORMAT.parse("2016-06-14 00:00:00").getTime() );
				}
				catch (Exception e)
				{
					lastUpdateTimestamp = new Date( currentTimestamp.getTime() - 120*24*3600*1000l );
				}
				
				System.out.println("Last updated timestamp not found in DB ... will be defaulted ...");
				firstRun = true;
			}
			
			
			System.out.println("----- firstRun : "+firstRun);
			System.out.println("----- lastUpdateTimestamp : "+lastUpdateTimestamp);
			System.out.println("----- currentTimestamp : "+currentTimestamp);*/
			
			
			/*ArrayList<StatusDetails> statusList = new ArrayList<StatusDetails>();
			Connection ebsDb = null;
			PreparedStatement ps1 = null;
			ResultSet rs1 = null;
			String url = "jdbc:oracle:thin:@eqdev-db1:16010:DEV";*/
	        
			/*try
			{*/
		
		//Connection Part Imaging
				System.out.println("Connecting Imaging");
				
				DocumentService docUpdateService = new DocumentService_Service().getDocumentServicePort();
	            BindingProvider bindingProvider = (BindingProvider)docUpdateService;
	            @SuppressWarnings("rawtypes")
	            List<Handler> handlerChain = new ArrayList<Handler>();
	            // for PROD environment.
	            handlerChain.add(new WSSecurityHeaderSOAPHandler(
		 					"eqadmin",
		 					"eQs0a@dmin123"
		 		// for TEST environment.
	            /*handlerChain.add(new WSSecurityHeaderSOAPHandler(
	           		 					"eqadmin",
	           		 					"weblogic1"*/
		 		// for TEST environment.
		 		/*handlerChain.add(new WSSecurityHeaderSOAPHandler(
		 		           		 		"eqadmin",
		 		           		 		"weblogic1"*/
	                                 )
	                            );
	            
	            System.out.println("Imaging Connection Successful");
	    
	    // Connection Part Imaging End        
	         
	            bindingProvider.getBinding().setHandlerChain(handlerChain);
	            ArrayList<String> failedUpdateList = new ArrayList<String>();
	            
	          
	            
	            	String docID=null;
	            	String[] docIDList = {"35.IPM_1891328","35.IPM_1895100","35.IPM_1891745"};
	            	System.out.println("Total docs to be updated :"+docIDList.length);
	            	for(int i =0 ; i< docIDList.length ; i++){
	            	try
	            	{         
	            	
	            		docID = docIDList[i];
	            		System.out.println("docID is "+docIDList[i]);
	            		
	            		
		                List<FieldValue> fieldValues = new ArrayList<FieldValue>();	                 
		                
		                {
		                	FieldValue fieldValue1 = new FieldValue();
		                	fieldValue1.setName("Activity");             
			                TypedValue typedValue = new TypedValue();
			                typedValue.setType( FieldType.TEXT );
			                typedValue.setValue("Auto Rejected By System");
			                fieldValue1.setValue(typedValue);
			                fieldValues.add(fieldValue1);
		                }
		                
		                {
		                	FieldValue fieldValue2 = new FieldValue();
		                	fieldValue2.setName("Username");             
			                TypedValue typedValue = new TypedValue();
			                typedValue.setType( FieldType.TEXT );
			                typedValue.setValue( "sysadmin" );
			                fieldValue2.setValue(typedValue);
			                fieldValues.add(fieldValue2);
		                }
		                
		                {
		                	FieldValue fieldValue4 = new FieldValue();
		                	fieldValue4.setName("Invalid Reason");             
			                TypedValue typedValue = new TypedValue();
			                typedValue.setType( FieldType.TEXT );
			                typedValue.setValue("REJECT");
			                fieldValue4.setValue(typedValue);
			                fieldValues.add(fieldValue4);
		                }
		              
		                docUpdateService.updateDocument(new Holder<String>(docID==null?"":docID), null, fieldValues, false);
		                System.out.println("\t\tUpdating Webcenter IPM successful ---");
		                //noOfMatchedRecords++;
		                
		                // docUpdateService.updateDocument(new Holder<String>(docID==null?"":docID), null, fieldValues, false);
		                //System.out.println("\t\tUpdating Webcenter IPM successful for DocID ---" +docID);
		            }
	            	catch (Exception e)
	            	{
		                System.out.println("\t\tUpdating Webcenter IPM failed --- "+e.getMessage());
		                failedUpdateList.add(docID);
		                e.printStackTrace();
		            	}
	            	
	}
					System.out.println("===== Number of failed updates : "+failedUpdateList.size());
					System.out.println("===== Failed update list : "+failedUpdateList);
					
					//System.out.println("===== Updating timestamp in properties table");
					//System.out.println("===== Updated successfully.");
	            	
					/*if (failedUpdateList.size()>0)
					{
					System.out.println("===== Number of failed updates : "+failedUpdateList.size());
					System.out.println("===== Failed to update LastUpdatedTimestamp in properties table");
					System.out.println("===== Please check for ERROR/Image_url coulumn returned from EBS Query for Failed update list : " + failedUpdateList);
				
					//mail part implementation below in case ECM update failed
					String failedList = "Failed update list : "+failedUpdateList;
					System.out.println("===== sending Mail");
					
					Session session = null;
					Properties properties = System.getProperties();
					properties.setProperty("mail.smtp.host","172.28.188.7");
					session = Session.getDefaultInstance(properties);
					Message msg = new MimeMessage(session);
					msg.setFrom(InternetAddress.parse("ecmUpdateAlert@qantas.com.au",false)[0]);
				
		            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse("rahul.kumar@qantas.com.au"));
		           
		            
		            msg.setSubject("Doc ID failed list");
		            msg.setSentDate(new java.util.Date());
		            msg.setContent("Hi Rahul "+failedList, "text/html; charset=utf-8");
		            Transport.send(msg);
					
		            System.out.println("===== Mail sent successfully");
					}
					else
					{
						//do nothing
					}
			}
					catch (Exception e) {
						e.printStackTrace();
					} */
					
	          
			System.out.println("===== Imaging Update for Manual : END ======");
			System.out.println("===== "+new Date()+" =====");		
	
	
}
}
				
			
		
		
		

