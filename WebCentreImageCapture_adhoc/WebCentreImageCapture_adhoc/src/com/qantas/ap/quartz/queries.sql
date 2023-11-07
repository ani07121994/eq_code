TIMESTAMP_CHECK_QUERY=\
select value from ap_properties_table where name='IMAGING_UPDATE_LAST_UPDATE_TIMESTAMP_12c'

TIMESTAMP_INSERT_QUERY=\
insert into ap_properties_table values('IMAGING_UPDATE_LAST_UPDATE_TIMESTAMP_12c', ?)


INSERT_ERROR_RECORD_QUERY=\
insert into ECM_UPDATE_STATUS values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)

TIMESTAMP_UPDATE_QUERY=\
update ap_properties_table set value=? where name='IMAGING_UPDATE_LAST_UPDATE_TIMESTAMP_12c'


EBS_QUERY=\
SELECT ai.invoice_num \ 
      ,ai.invoice_id \
      ,as1.segment1 supplier_number \
      ,as1.vendor_id supplier_id \
      ,ass.vendor_site_id site_id \
      ,ai.org_id \
      ,hou.NAME \
      ,ai.invoice_currency_code 
      ,ai.invoice_amount 
      ,to_char(ai.invoice_date 
              ,'YYYY-MM-DD') invoice_date 
      ,ail.freight 
      ,ail.aog 
      ,ail.due_date 
      ,ail.witholding_tax 
      ,(SELECT ph.segment1 
          FROM apps.po_headers_all       ph 
              ,apps.ap_invoice_lines_all ail 
         WHERE ail.po_header_id = ph.po_header_id 
           AND nvl(ail.discarded_flag 
                  ,'N') <> 'Y' 
           AND rownum < 2 
           AND ail.invoice_id = ai.invoice_id) po_number 
      ,ai.invoice_type_lookup_code ap_invoice_type 
      ,ai.SOURCE ap_invoice_source 
      ,decode((SELECT COUNT(1) 
                FROM apps.fnd_lookup_values flv 
               WHERE flv.lookup_type = 'QFEQ_JETSTAR_JBA_SETUP_CONTROL' 
                 AND flv.lookup_code = ai.org_id) 
             ,1 
             ,nvl((SELECT APPS.jseq_ap_inv_img_process.amount_rounding(flv.tag,(conversion_rate * ai.invoice_amount)) 
                    FROM gl.gl_daily_rates 
                        ,apps.fnd_lookup_values flv 
                   WHERE conversion_date = ai.gl_date 
                     AND from_currency = ai.invoice_currency_code 
                     AND to_currency = flv.tag 
                     AND conversion_type = 1000 
                     AND flv.lookup_type = 
                         'QFEQ_JETSTAR_JBA_SETUP_CONTROL' 
                     AND flv.lookup_code = ai.org_id) 
                 ,ai.invoice_amount) 
             ,nvl(ai.base_amount 
                 ,ai.invoice_amount)) currency_equivalent 
      ,regexp_substr(ai.attribute15 
                          ,'[^_]+' 
                          ,1 
                          ,2) image_url 
      ,regexp_substr(ai.global_attribute2 
                          ,'[^_]+' 
                          ,1 
                          ,2)  image_url2 
      ,regexp_substr(ai.global_attribute3 
                          ,'[^_]+' 
                          ,1 
                          ,2)  image_url3 
      ,'eQ ' || initcap(decode(ai.cancelled_date 
                              ,NULL 
                              ,decode(ai.payment_status_flag 
                                     ,'Y' 
                                     ,'Paid' 
                                     ,decode(hist.response 
                                            ,NULL 
                                            ,'Created' 
                                            ,hist.response)) 
                              ,'Cancelled')) invoice_status 
      ,hist.approver_name pending_with_approved_by 
      ,hist.last_update_date action_date 
      ,paymnt.check_number payment_number 
      ,to_char(paymnt.check_date 
              ,'YYYY-MM-DD') payment_date 
	  ,ai.description
      ,as1.SMALL_BUSINESS_FLAG Small_Business
      ,(SELECT HOLD_LOOKUP_CODE 
          FROM (SELECT HOLD_LOOKUP_CODE, HOLD_ID 
                  FROM apps.ap_holds_all aha1 
                 WHERE aha1.invoice_id = ai.invoice_id 
                   and aha1.release_lookup_code is null 
                 ORDER BY HOLD_ID) 
         WHERE ROWNUM = 1 
        UNION  
        SELECT HOLD_LOOKUP_CODE 
          FROM (SELECT HOLD_LOOKUP_CODE, HOLD_ID, LAST_UPDATE_DATE 
                  FROM apps.ap_holds_all aha1 
                 WHERE aha1.invoice_id = ai.invoice_id 
                   AND NOT EXISTS 
                 (SELECT 1 
                          FROM apps.ap_holds_all aha2 
                         WHERE aha1.invoice_id = aha2.invoice_id 
                           AND aha2.release_lookup_code is null) 
                 ORDER BY LAST_UPDATE_DATE DESC) 
         WHERE ROWNUM = 1) Invoice_Hold_Name 
,(SELECT TRUNC(LAST_UPDATE_DATE) 
          FROM (SELECT LAST_UPDATE_DATE 
                  FROM apps.ap_holds_all aha1 
                 WHERE aha1.invoice_id = ai.invoice_id 
                   and aha1.release_lookup_code is NOT null 
                   AND HOLD_LOOKUP_CODE IN 
                       ('AMT ORD', 'AMT REC', 'MAX AMT ORD', 'MAX AMT REC', 
                        'QTY ORD', 'QTY REC') 
                   AND NOT EXISTS 
                 (SELECT 1 
                          FROM apps.ap_holds_all aha2 
                         WHERE aha2.invoice_id = aha1.invoice_id 
                           and aha2.release_lookup_code is null 
                           AND HOLD_LOOKUP_CODE IN 
                               ('AMT ORD', 'AMT REC', 'MAX AMT ORD', 
                                'MAX AMT REC', 'QTY ORD', 'QTY REC')) 
                 ORDER BY LAST_UPDATE_DATE DESC) 
         WHERE ROWNUM = 1) PO_Hold_Release_Date 
 ,(SELECT APPROVAL_DATE 
          FROM (SELECT TRUNC(LAST_UPDATE_DATE) APPROVAL_DATE 
                  FROM apps.ap_holds_all aha1 
                 WHERE aha1.invoice_id = AI.INVOICE_ID 
                   and aha1.release_lookup_code is NOT null 
                   AND HOLD_LOOKUP_CODE = 'Accounting Hold' 
                   AND AI.WFAPPROVAL_STATUS = 'WFAPPROVED' 
                 order by LAST_UPDATE_DATE DESC) 
         WHERE ROWNUM = 1) Findel_Hold_Release_Date 
  FROM apps.ap_invoices_all ai 
      ,apps.ap_suppliers as1 
      ,apps.ap_supplier_sites_all ass 
      ,(SELECT * 
          FROM (SELECT rank() over(PARTITION BY invoice_id ORDER BY aha.invoice_id, aha.last_update_date DESC, aha.approval_history_id DESC) sl_no 
                      ,aha.* 
                  FROM apps.ap_inv_aprvl_hist_all aha) 
         WHERE sl_no = 1) hist 
      ,(SELECT ac.check_number 
              ,ac.check_date 
              ,aip.invoice_id 
          FROM apps.ap_invoice_payments_all aip 
              ,apps.ap_checks_all           ac 
         WHERE ac.check_id = aip.check_id 
           AND ac.void_date IS NULL) paymnt 
      ,(SELECT SUM(decode(ail.line_type_lookup_code 
                         ,'AWT' 
                         ,amount 
                         ,0)) witholding_tax 
              ,SUM(decode(ail.line_type_lookup_code 
                         ,'FREIGHT' 
                         ,amount 
                         ,0)) freight 
              ,SUM(decode(ail.line_type_lookup_code 
                         ,'MISCELLANEOUS' 
                         ,amount 
                         ,0)) aog 
              ,aps.due_date 
              ,aps.invoice_id 
          FROM apps.ap_payment_schedules_all aps 
              ,apps.ap_invoice_lines_all     ail 
         WHERE aps.invoice_id = ail.invoice_id 
         GROUP BY aps.invoice_id 
                 ,aps.due_date) ail 
      ,apps.fnd_lookup_values flv 
      ,apps.hr_operating_units hou 
 WHERE ai.SOURCE = flv.lookup_code 
   AND flv.lookup_type = 'SOURCE' 
   AND flv.attribute15 = 'Y' 
   AND ai.vendor_id = as1.vendor_id 
   AND ass.vendor_id = as1.vendor_id 
   AND ass.vendor_site_id = ai.vendor_site_id 
   AND ai.invoice_id = hist.invoice_id(+) 
   AND paymnt.invoice_id(+) = ai.invoice_id 
   AND ail.invoice_id = ai.invoice_id 
   AND ai.org_id = hou.organization_id 
   AND ai.creation_date > '01-JAN-2016' 
   AND upper(ai.attribute15)  like '%HTTP%'  
   AND (ai.last_update_date >= to_date(?, 'YYYY-MM-DD HH24:MI:ss') OR 
       hist.last_update_date >= to_date(?, 'YYYY-MM-DD HH24:MI:ss') ) 
   AND (ai.last_update_date < to_date(?, 'YYYY-MM-DD HH24:MI:ss') OR 
       hist.last_update_date < to_date(?, 'YYYY-MM-DD HH24:MI:ss') ) 
UNION ALL 
SELECT ai.invoice_num 
      ,ai.invoice_id 
      ,as1.segment1 supplier_number 
      ,as1.vendor_id supplier_id 
      ,ass.vendor_site_id site_id 
      ,ai.org_id 
      ,hou.NAME 
      ,ai.invoice_currency_code 
      ,ai.invoice_amount 
      ,to_char(ai.invoice_date 
              ,'YYYY-MM-DD') invoice_date 
      ,NULL 
      ,NULL 
      ,NULL 
      ,NULL 
      ,NULL po_number 
      ,ai.invoice_type_lookup_code ap_invoice_type 
      ,ai.SOURCE ap_invoice_source 
      ,NULL 
      ,regexp_substr(ai.attribute15 
                          ,'[^_]+' 
                          ,1 
                          ,2) image_url 
      ,regexp_substr(ai.global_attribute2 
                          ,'[^_]+' 
                          ,1 
                          ,2)  image_url2 
      ,regexp_substr(ai.global_attribute3 
                          ,'[^_]+' 
                          ,1 
                          ,2)  image_url3 
      ,'eQ ' || decode(status 
                      ,'REJECTED' 
                      ,'Interface Rejected' 
                      ,NULL 
                      ,'Awaiting Import' 
                      ,status) 
      ,NULL last_actioned_by 
      ,NULL last_action_date 
      ,NULL payment_number 
      ,NULL payment_date 
	  ,ai.description 
      ,as1.SMALL_BUSINESS_FLAG Small_Business 
	  ,NULL Invoice_Hold_Name 
	  ,NULL PO_Hold_Release_Date 
	  ,NULL Findel_Hold_Release_Date 
  FROM apps.ap_invoices_interface ai 
      ,apps.ap_suppliers          as1 
      ,apps.ap_supplier_sites_all ass 
      ,apps.fnd_lookup_values     flv 
      ,apps.hr_operating_units    hou 
 WHERE ai.SOURCE = flv.lookup_code 
   AND flv.lookup_type = 'SOURCE' 
   AND flv.attribute15 = 'Y' 
   AND ai.vendor_id = as1.vendor_id(+) 
   AND ass.vendor_site_id(+) = ai.vendor_site_id 
   AND ai.org_id = hou.organization_id 
   AND nvl(status 
          ,'NEW') <> 'PROCESSED' 
   AND upper(ai.attribute15)  like '%HTTP%' 
UNION ALL 
SELECT ai.invoice_num 
      ,ai.invoice_id 
      ,as1.segment1 supplier_number 
      ,as1.vendor_id supplier_id 
      ,ass.vendor_site_id site_id 
      ,ai.org_id 
      ,hou.NAME 
      ,ai.invoice_currency_code 
      ,ai.invoice_amount 
      ,to_char(ai.invoice_date 
              ,'YYYY-MM-DD') invoice_date 
      ,NULL 
      ,NULL 
      ,NULL 
      ,NULL 
      ,NULL po_number 
      ,ai.invoice_type_lookup_code ap_invoice_type 
      ,ai.SOURCE ap_invoice_source 
      ,NULL 
      ,regexp_substr(ai.attribute15 
                          ,'[^_]+' 
                          ,1 
                          ,2) image_url 
      ,regexp_substr(ai.global_attribute2 
                          ,'[^_]+' 
                          ,1 
                          ,2)  image_url2 
      ,regexp_substr(ai.global_attribute3 
                          ,'[^_]+' 
                          ,1 
                          ,2)  image_url3 
      ,'eQ Interface Deleted' 
      ,NULL last_actioned_by 
      ,NULL last_action_date 
      ,NULL payment_number 
      ,NULL payment_date 
	  ,ai.description 
      ,as1.SMALL_BUSINESS_FLAG Small_Business 	
	  ,NULL Invoice_Hold_Name 
	  ,NULL PO_Hold_Release_Date 
	  ,NULL Findel_Hold_Release_Date 
  FROM bolinf.qfeq_ap_inv_intrfc_del_audit ai 
      ,apps.ap_suppliers                   as1 
      ,apps.ap_supplier_sites_all          ass 
      ,apps.fnd_lookup_values              flv 
      ,apps.hr_operating_units             hou 
 WHERE ai.SOURCE = flv.lookup_code 
   AND flv.lookup_type = 'SOURCE' 
   AND flv.attribute15 = 'Y' 
   AND ai.vendor_id = as1.vendor_id(+) 
   AND ass.vendor_site_id(+) = ai.vendor_site_id 
   AND ai.org_id = hou.organization_id   