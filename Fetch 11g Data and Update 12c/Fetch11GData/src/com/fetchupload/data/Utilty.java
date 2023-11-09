package com.fetchupload.data;

public class Utilty {

	public static String bigAppsQuery="select * from (SELECT ai.invoice_num,ai.invoice_id,as1.segment1 supplier_number,as1.vendor_id supplier_id,ass.vendor_site_id site_id,ai.org_id,hou.NAME,ai.invoice_currency_code,ai.invoice_amount\r\n" + 
			",to_char(ai.invoice_date,'YYYY-MM-DD') invoice_date,ail.freight,ail.aog,ail.due_date,ail.witholding_tax,(SELECT ph.segment1 FROM apps.po_headers_all       ph,apps.ap_invoice_lines_all ail\r\n" + 
			"WHERE ail.po_header_id = ph.po_header_id AND nvl(ail.discarded_flag,'N') <> 'Y' AND rownum < 2 AND ail.invoice_id = ai.invoice_id) po_number,ai.invoice_type_lookup_code ap_invoice_type\r\n" + 
			",ai.SOURCE ap_invoice_source,decode((SELECT COUNT(1) FROM apps.fnd_lookup_values flv WHERE flv.lookup_type = 'QFEQ_JETSTAR_JBA_SETUP_CONTROL' AND flv.lookup_code = ai.org_id),1\r\n" + 
			",nvl((SELECT APPS.jseq_ap_inv_img_process.amount_rounding(flv.tag,(conversion_rate * ai.invoice_amount)) FROM gl.gl_daily_rates,apps.fnd_lookup_values flv WHERE conversion_date = ai.gl_date\r\n" + 
			"AND from_currency = ai.invoice_currency_code AND to_currency = flv.tag AND conversion_type = 1000 AND flv.lookup_type ='QFEQ_JETSTAR_JBA_SETUP_CONTROL' AND flv.lookup_code = ai.org_id),ai.invoice_amount)\r\n" + 
			",nvl(ai.base_amount,ai.invoice_amount)) currency_equivalent,regexp_substr(ai.attribute15,'[^_]+',1,2) image_url,regexp_substr(ai.global_attribute2,'[^_]+',1,2)  image_url2,regexp_substr(ai.global_attribute3,'[^_]+',1,2)  image_url3\r\n" + 
			"      ,'eQ ' || initcap(decode(ai.cancelled_date\r\n" + 
			"                              ,NULL\r\n" + 
			"                              ,decode(ai.payment_status_flag\r\n" + 
			"                                     ,'Y'\r\n" + 
			"                                     ,'Paid'\r\n" + 
			"                                     ,decode(hist.response\r\n" + 
			"                                            ,NULL\r\n" + 
			"                                            ,'Created'\r\n" + 
			"                                            ,hist.response))\r\n" + 
			"                              ,'Cancelled')) invoice_status\r\n" + 
			"      ,hist.approver_name pending_with_approved_by\r\n" + 
			"      ,hist.last_update_date action_date\r\n" + 
			"      ,paymnt.check_number payment_number\r\n" + 
			"      ,to_char(paymnt.check_date\r\n" + 
			"              ,'YYYY-MM-DD') payment_date\r\n" + 
			"    ,ai.description\r\n" + 
			"      ,as1.SMALL_BUSINESS_FLAG Small_Business\r\n" + 
			"      ,(SELECT HOLD_LOOKUP_CODE\r\n" + 
			"          FROM (SELECT HOLD_LOOKUP_CODE, HOLD_ID\r\n" + 
			"                  FROM apps.ap_holds_all aha1\r\n" + 
			"                 WHERE aha1.invoice_id = ai.invoice_id\r\n" + 
			"                   and aha1.release_lookup_code is null\r\n" + 
			"                 ORDER BY HOLD_ID)\r\n" + 
			"         WHERE ROWNUM = 1\r\n" + 
			"        UNION  \r\n" + 
			"        SELECT HOLD_LOOKUP_CODE\r\n" + 
			"          FROM (SELECT HOLD_LOOKUP_CODE, HOLD_ID, LAST_UPDATE_DATE\r\n" + 
			"                  FROM apps.ap_holds_all aha1\r\n" + 
			"                 WHERE aha1.invoice_id = ai.invoice_id\r\n" + 
			"                   AND NOT EXISTS\r\n" + 
			"                 (SELECT 1\r\n" + 
			"                          FROM apps.ap_holds_all aha2\r\n" + 
			"                         WHERE aha1.invoice_id = aha2.invoice_id\r\n" + 
			"                           AND aha2.release_lookup_code is null)\r\n" + 
			"                 ORDER BY LAST_UPDATE_DATE DESC)\r\n" + 
			"         WHERE ROWNUM = 1) Invoice_Hold_Name\r\n" + 
			",(SELECT TRUNC(LAST_UPDATE_DATE)\r\n" + 
			"          FROM (SELECT LAST_UPDATE_DATE\r\n" + 
			"                  FROM apps.ap_holds_all aha1\r\n" + 
			"                 WHERE aha1.invoice_id = ai.invoice_id\r\n" + 
			"                   and aha1.release_lookup_code is NOT null\r\n" + 
			"                   AND HOLD_LOOKUP_CODE IN\r\n" + 
			"                       ('AMT ORD', 'AMT REC', 'MAX AMT ORD', 'MAX AMT REC',\r\n" + 
			"                        'QTY ORD', 'QTY REC')\r\n" + 
			"                   AND NOT EXISTS\r\n" + 
			"                 (SELECT 1\r\n" + 
			"                          FROM apps.ap_holds_all aha2\r\n" + 
			"                         WHERE aha2.invoice_id = aha1.invoice_id\r\n" + 
			"                           and aha2.release_lookup_code is null\r\n" + 
			"                           AND HOLD_LOOKUP_CODE IN\r\n" + 
			"                               ('AMT ORD', 'AMT REC', 'MAX AMT ORD',\r\n" + 
			"                                'MAX AMT REC', 'QTY ORD', 'QTY REC'))\r\n" + 
			"                 ORDER BY LAST_UPDATE_DATE DESC)\r\n" + 
			"         WHERE ROWNUM = 1) PO_Hold_Release_Date\r\n" + 
			" ,(SELECT APPROVAL_DATE\r\n" + 
			"          FROM (SELECT TRUNC(LAST_UPDATE_DATE) APPROVAL_DATE\r\n" + 
			"                  FROM apps.ap_holds_all aha1\r\n" + 
			"                 WHERE aha1.invoice_id = AI.INVOICE_ID\r\n" + 
			"                   and aha1.release_lookup_code is NOT null\r\n" + 
			"                   AND HOLD_LOOKUP_CODE = 'Accounting Hold'\r\n" + 
			"                   AND AI.WFAPPROVAL_STATUS = 'WFAPPROVED'\r\n" + 
			"                 order by LAST_UPDATE_DATE DESC)\r\n" + 
			"         WHERE ROWNUM = 1) Findel_Hold_Release_Date\r\n" + 
			"  FROM apps.ap_invoices_all ai\r\n" + 
			"	,apps.qfeq_owc_image_url_dispute qd\r\n" + 
			"      ,apps.ap_suppliers as1\r\n" + 
			"      ,apps.ap_supplier_sites_all ass\r\n" + 
			"      ,(SELECT *\r\n" + 
			"          FROM (SELECT rank() over(PARTITION BY invoice_id ORDER BY aha.invoice_id, aha.last_update_date DESC, aha.approval_history_id DESC) sl_no\r\n" + 
			"                      ,aha.*\r\n" + 
			"                  FROM apps.ap_inv_aprvl_hist_all aha)\r\n" + 
			"         WHERE sl_no = 1) hist\r\n" + 
			"      ,(SELECT ac.check_number\r\n" + 
			"              ,ac.check_date\r\n" + 
			"              ,aip.invoice_id\r\n" + 
			"          FROM apps.ap_invoice_payments_all aip\r\n" + 
			"              ,apps.ap_checks_all           ac\r\n" + 
			"         WHERE ac.check_id = aip.check_id\r\n" + 
			"           AND ac.void_date IS NULL) paymnt\r\n" + 
			"      ,(SELECT SUM(decode(ail.line_type_lookup_code\r\n" + 
			"                         ,'AWT'\r\n" + 
			"                         ,amount\r\n" + 
			"                         ,0)) witholding_tax\r\n" + 
			"              ,SUM(decode(ail.line_type_lookup_code\r\n" + 
			"                         ,'FREIGHT'\r\n" + 
			"                         ,amount\r\n" + 
			"                         ,0)) freight\r\n" + 
			"              ,SUM(decode(ail.line_type_lookup_code\r\n" + 
			"                         ,'MISCELLANEOUS'\r\n" + 
			"                         ,amount\r\n" + 
			"                         ,0)) aog\r\n" + 
			"              ,aps.due_date\r\n" + 
			"              ,aps.invoice_id\r\n" + 
			"          FROM apps.ap_payment_schedules_all aps\r\n" + 
			"              ,apps.ap_invoice_lines_all     ail\r\n" + 
			"         WHERE aps.invoice_id = ail.invoice_id\r\n" + 
			"         GROUP BY aps.invoice_id\r\n" + 
			"                 ,aps.due_date) ail\r\n" + 
			"      ,apps.fnd_lookup_values flv\r\n" + 
			"      ,apps.hr_operating_units hou\r\n" + 
			"      --added for checking the hold release date\r\n" + 
			"      ,(SELECT max(ah.LAST_UPDATE_DATE) hold_release_date,ah.invoice_id\r\n" + 
			"  FROM apps.ap_holds_all ah\r\n" + 
			" WHERE  ah.release_lookup_code is NOT null\r\n" + 
			"   AND ah.HOLD_LOOKUP_CODE in\r\n" + 
			"       ('Accounting Hold', 'AMT ORD', 'AMT REC', 'MAX AMT ORD',\r\n" + 
			"        'MAX AMT REC', 'QTY ORD', 'QTY REC') group by ah.invoice_id) hold\r\n" + 
			"      --\r\n" + 
			" WHERE ai.SOURCE = flv.lookup_code\r\n" + 
			"   AND flv.lookup_type = 'SOURCE'\r\n" + 
			"   AND flv.attribute15 = 'Y'\r\n" + 
			"   AND ai.vendor_id = as1.vendor_id\r\n" + 
			"   AND ass.vendor_id = as1.vendor_id\r\n" + 
			"   AND ass.vendor_site_id = ai.vendor_site_id\r\n" + 
			"   AND ai.invoice_id = hist.invoice_id(+)\r\n" + 
			"   AND paymnt.invoice_id(+) = ai.invoice_id\r\n" + 
			"   AND ail.invoice_id = ai.invoice_id    \r\n" + 
			"   and hold.invoice_id(+) = ai.invoice_id  \r\n" + 
			"   AND ai.org_id = hou.organization_id\r\n" + 
			"   AND ai.creation_date > '01-JAN-2016'\r\n" + 
			"   AND upper(ai.attribute15)  like '%HTTP%'\r\n" + 
			"	 AND qd.invoice_number = ai.invoice_num(+)) where image_url=regexp_substr(?,'[^_]+',1,2)";
}
