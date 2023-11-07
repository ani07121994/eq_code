EQFILES_INVOICE_SEARCH_QUERY=\
select invoice_number,supplier_name,site_id,invoice_id,invoice_date,invoice_tot_amount,internal_status from js_ap_invoice_table \
where invoice_number = ? and internal_status not like \
'%DUPLICATE INVOICE REJECTED%' and internal_status not like '%AUTO REJECTED BY SYSTEM%' \


AP_COMMENTS_TABLE_QUERY=\
select description from ap_comments_table where category = ? and invoice_id = ? \
and name = ? \


EQFILES_AUDIT_QUERY_LATEST= \
SELECT INVOICE_ID, \
       SUPPLIER_ID, \
       SUPPLIER_NAME, \
       SUPPLIER_NUMBER, \
       SITE_ID, \
       PO_NUMBER, \
       TAX_AMOUNT, \
       WITHHOLDING_TAX, \
       INVOICE_DATE, \
       'INVOICE FROM WFR TO BPM' INTERNAL_STATUS, \
       '' modified_by, \
       ALTERNATE_APPROVER, \
       DOCUMENT_TYPE, \
       INVOICE_TYPE, \
       ORG_ID, \
       INVOICE_NUMBER, \
       SITE_NAME, \
       TAX_REG_NUMBER, \
       INVOICE_TOT_AMOUNT, \
       CURRENCY_CODE, \
       CERTIFIER_NAME, \
       EMPLOYEE_NUMBER, \
       CERTIFIER_EMAIL_ADD, \
       INVALID_REASON, \
       PO_TYPE, \
       INVALID_REASON_TYPE, \
       DOC_ID, \
       STATUS, \
       AP_OPERATION_COMMENTS, \
       CERTIFIER_REJ_REASON, \
       CERTIFIER_REJ_COMMENTS, \
       CERTIFIER_REASSIGN_TO, \
       CERTIFIER_REASSIGN_COMMENTS, \
       CERTIFIER_APPROVE_COMMENTS, \
       CERTIFIER_BY, \
       LAST_UPDATED_DATE, \
       '' reassigned_by \
  FROM js_ap_audit_invoice_table a \
 WHERE invoice_id = ? \
   AND internal_status = 'DATA FROM WFR TO BPM' \
   AND LAST_UPDATED_DATE = \
       (SELECT MIN(LAST_UPDATED_DATE) \
          FROM js_ap_audit_invoice_table \
         WHERE invoice_id = a.invoice_id \
           AND internal_status = a.internal_status) \
   AND rownum = 1 \
UNION ALL \
SELECT distinct INVOICE_ID, \
       SUPPLIER_ID, \
       SUPPLIER_NAME, \
       SUPPLIER_NUMBER, \
       SITE_ID, \
       PO_NUMBER, \
       TAX_AMOUNT, \
       WITHHOLDING_TAX, \
       INVOICE_DATE, \
       'INVOICE IN AP EXCEPTIONS' INTERNAL_STATUS, \
        modified_by, \
       ALTERNATE_APPROVER, \
       DOCUMENT_TYPE, \
       INVOICE_TYPE, \
       ORG_ID, \
       INVOICE_NUMBER, \
       SITE_NAME, \
       TAX_REG_NUMBER, \
       INVOICE_TOT_AMOUNT, \
       CURRENCY_CODE, \
       CERTIFIER_NAME, \
       EMPLOYEE_NUMBER, \
       CERTIFIER_EMAIL_ADD, \
       INVALID_REASON, \
       PO_TYPE, \
       INVALID_REASON_TYPE, \
       DOC_ID, \
       STATUS, \
       AP_OPERATION_COMMENTS, \
       CERTIFIER_REJ_REASON, \
       CERTIFIER_REJ_COMMENTS, \
       CERTIFIER_REASSIGN_TO, \
       CERTIFIER_REASSIGN_COMMENTS, \
       CERTIFIER_APPROVE_COMMENTS, \
       CERTIFIER_BY, \
       LAST_UPDATED_DATE, \
       '' reassigned_by \
  FROM js_ap_audit_invoice_table a \
 WHERE invoice_id = ? \
   AND internal_status = 'INVOICE UPDATED BY AP GROUP' \
   UNION ALL \
SELECT INVOICE_ID, \
       SUPPLIER_ID, \
       SUPPLIER_NAME, \
       SUPPLIER_NUMBER, \
       SITE_ID, \
       PO_NUMBER, \
       TAX_AMOUNT, \
       WITHHOLDING_TAX, \
       INVOICE_DATE, \
       decode(CERTIFIER_REASSIGN_COMMENTS, \
              NULL, \
              decode(invalid_reason, \
                     'CERTIFIER REJECTION', \
                     'INVOICE REJECTED BY : ' || employee_number, \
                     internal_status), \
              'INVOICE REASSIGNED BY : ' || \
              nvl((substr(CERTIFIER_REASSIGN_COMMENTS, \
                     length('Reassigned by User  '), \
                     instr(CERTIFIER_REASSIGN_COMMENTS, 'on') - \
                     length('Reassigned by User  ') - 1)),employee_number)) internal_status, \
                     '' modified_by, \
       ALTERNATE_APPROVER, \
       DOCUMENT_TYPE, \
       INVOICE_TYPE, \
       ORG_ID, \
       INVOICE_NUMBER, \
       SITE_NAME, \
       TAX_REG_NUMBER, \
       INVOICE_TOT_AMOUNT, \
       CURRENCY_CODE, \
       CERTIFIER_NAME, \
       EMPLOYEE_NUMBER, \
       CERTIFIER_EMAIL_ADD, \
       INVALID_REASON, \
       PO_TYPE, \
       INVALID_REASON_TYPE, \
       DOC_ID, \
       STATUS, \
       AP_OPERATION_COMMENTS, \
       CERTIFIER_REJ_REASON, \
       CERTIFIER_REJ_COMMENTS, \
       CERTIFIER_REASSIGN_TO, \
       CERTIFIER_REASSIGN_COMMENTS, \
       CERTIFIER_APPROVE_COMMENTS, \
       CERTIFIER_BY, \
       LAST_UPDATED_DATE, \
       substr(CERTIFIER_REASSIGN_COMMENTS, \
              length('Reassigned by User  '), \
              instr(CERTIFIER_REASSIGN_COMMENTS, 'on') - \
              length('Reassigned by User  ') - 1) reassigned_by \
  FROM js_ap_audit_invoice_table a \
 WHERE invoice_id = ? \
   AND internal_status = 'INVOICE PENDING FOR CERTIFICATION' \
    AND nvl(certifier_reassign_comments,'E') not like 'Invoice Released :%' \
   AND  (rowid,employee_number) IN (select max(rowid),employee_number from js_ap_audit_invoice_table \
   where internal_status=a.internal_status \
    and invoice_id=a.invoice_id \
   group by decode(CERTIFIER_REASSIGN_COMMENTS, \
              NULL, \
              decode(invalid_reason, \
                     'CERTIFIER REJECTION', \
                     'INVOICE REJECTED BY : ' || employee_number, \
                     internal_status), \
              'INVOICE REASSIGNED BY : ' || \
              nvl((substr(CERTIFIER_REASSIGN_COMMENTS, \
                     length('Reassigned by User  '), \
                     instr(CERTIFIER_REASSIGN_COMMENTS, 'on') - \
                     length('Reassigned by User  ') - 1)),employee_number)),employee_number) \
 GROUP BY INVOICE_ID, \
          SUPPLIER_ID, \
          SUPPLIER_NAME, \
          SUPPLIER_NUMBER, \
          SITE_ID, \
          PO_NUMBER, \
          TAX_AMOUNT, \
          WITHHOLDING_TAX, \
          INVOICE_DATE, \
          INTERNAL_STATUS, \
          CERTIFIER_CANCEL_BY, \
          CERTIFIER_CANCEL_ON, \
          ALTERNATE_APPROVER, \
          DOCUMENT_TYPE, \
          INVOICE_TYPE, \
          ORG_ID, \
          INVOICE_NUMBER, \
          SITE_NAME, \
          TAX_REG_NUMBER, \
          INVOICE_TOT_AMOUNT, \
          CURRENCY_CODE, \
          CERTIFIER_NAME, \
          EMPLOYEE_NUMBER, \
          CERTIFIER_EMAIL_ADD, \
          INVALID_REASON, \
          PO_TYPE, \
          INVALID_REASON_TYPE, \
          DOC_ID, \
          STATUS, \
          AP_OPERATION_COMMENTS, \
          CERTIFIER_REJ_REASON, \
          CERTIFIER_REJ_COMMENTS, \
          CERTIFIER_REASSIGN_TO, \
          CERTIFIER_REASSIGN_COMMENTS, \
          CERTIFIER_APPROVE_COMMENTS, \
          CERTIFIER_BY, \
          LAST_UPDATED_DATE, \
          substr(CERTIFIER_REASSIGN_COMMENTS, \
                 length('Reassigned by User  '), \
                 instr(CERTIFIER_REASSIGN_COMMENTS, 'on') - \
                 length('Reassigned by User  ') - 1) \
 UNION ALL \
 SELECT INVOICE_ID, \
       SUPPLIER_ID, \
       SUPPLIER_NAME, \
       SUPPLIER_NUMBER, \
       SITE_ID, \
       PO_NUMBER, \
       TAX_AMOUNT, \
       WITHHOLDING_TAX, \
       INVOICE_DATE, \
        INTERNAL_STATUS, \
       '' modified_by, \
       ALTERNATE_APPROVER, \
       DOCUMENT_TYPE, \
       INVOICE_TYPE, \
       ORG_ID, \
       INVOICE_NUMBER, \
       SITE_NAME, \
       TAX_REG_NUMBER, \
       INVOICE_TOT_AMOUNT, \
       CURRENCY_CODE, \
       CERTIFIER_NAME, \
       EMPLOYEE_NUMBER, \
       CERTIFIER_EMAIL_ADD, \
       INVALID_REASON, \
       PO_TYPE, \
       INVALID_REASON_TYPE, \
       DOC_ID, \
       STATUS, \
       AP_OPERATION_COMMENTS, \
       CERTIFIER_REJ_REASON, \
       CERTIFIER_REJ_COMMENTS, \
       CERTIFIER_REASSIGN_TO, \
       CERTIFIER_REASSIGN_COMMENTS, \
       CERTIFIER_APPROVE_COMMENTS, \
       CERTIFIER_BY, \
       LAST_UPDATED_DATE, \
       '' reassigned_by \
  FROM js_ap_audit_invoice_table a \
 WHERE invoice_id = ? \
   AND internal_status = 'INVOICE IN AP INTERFACE' \
   AND LAST_UPDATED_DATE = \
       (SELECT MAX(LAST_UPDATED_DATE) \
          FROM js_ap_audit_invoice_table \
         WHERE invoice_id = a.invoice_id \
           AND internal_status = a.internal_status) \
   AND rownum = 1 \
 UNION ALL \
 SELECT INVOICE_ID, \
       SUPPLIER_ID, \
       SUPPLIER_NAME, \
       SUPPLIER_NUMBER, \
       SITE_ID, \
       PO_NUMBER, \
       TAX_AMOUNT, \
       WITHHOLDING_TAX, \
       INVOICE_DATE, \
       'INVOICE PENDING FOR CERTIFICATION : HOLD' INTERNAL_STATUS, \
       '' modified_by, \
       ALTERNATE_APPROVER, \
       DOCUMENT_TYPE, \
       INVOICE_TYPE, \
       ORG_ID, \
       INVOICE_NUMBER, \
       SITE_NAME, \
       TAX_REG_NUMBER, \
       INVOICE_TOT_AMOUNT, \
       CURRENCY_CODE, \
       CERTIFIER_NAME, \
       EMPLOYEE_NUMBER, \
       CERTIFIER_EMAIL_ADD, \
       INVALID_REASON, \
       PO_TYPE, \
       INVALID_REASON_TYPE, \
       DOC_ID, \
       STATUS, \
       AP_OPERATION_COMMENTS, \
       CERTIFIER_REJ_REASON, \
       CERTIFIER_REJ_COMMENTS, \
       CERTIFIER_REASSIGN_TO, \
       CERTIFIER_REASSIGN_COMMENTS, \
       CERTIFIER_APPROVE_COMMENTS, \
       CERTIFIER_BY, \
       LAST_UPDATED_DATE, \
       '' reassigned_by \
  FROM js_ap_audit_invoice_table a \
 WHERE invoice_id = ? \
   AND upper(internal_status) = upper('Invoice on Hold') \
   AND certifier_reassign_comments like 'Invoice on Hold :%' \
   AND LAST_UPDATED_DATE = \
       (SELECT MAX(LAST_UPDATED_DATE) \
          FROM js_ap_audit_invoice_table \
         WHERE invoice_id = a.invoice_id \
           AND internal_status = a.internal_status) \
   AND rownum = 1 \
    UNION ALL \
 SELECT INVOICE_ID, \
       SUPPLIER_ID, \
       SUPPLIER_NAME, \
       SUPPLIER_NUMBER, \
       SITE_ID, \
       PO_NUMBER, \
       TAX_AMOUNT, \
       WITHHOLDING_TAX, \
       INVOICE_DATE, \
       'INVOICE PENDING FOR CERTIFICATION : RELEASED' INTERNAL_STATUS, \
       '' modified_by, \
       ALTERNATE_APPROVER, \
       DOCUMENT_TYPE, \
       INVOICE_TYPE, \
       ORG_ID, \
       INVOICE_NUMBER, \
       SITE_NAME, \
       TAX_REG_NUMBER, \
       INVOICE_TOT_AMOUNT, \
       CURRENCY_CODE, \
       CERTIFIER_NAME, \
       EMPLOYEE_NUMBER, \
       CERTIFIER_EMAIL_ADD, \
       INVALID_REASON, \
       PO_TYPE, \
       INVALID_REASON_TYPE, \
       DOC_ID, \
       STATUS, \
       AP_OPERATION_COMMENTS, \
       CERTIFIER_REJ_REASON, \
       CERTIFIER_REJ_COMMENTS, \
       CERTIFIER_REASSIGN_TO, \
       CERTIFIER_REASSIGN_COMMENTS, \
       CERTIFIER_APPROVE_COMMENTS, \
       CERTIFIER_BY, \
       LAST_UPDATED_DATE, \
       '' reassigned_by \
  FROM js_ap_audit_invoice_table a \
 WHERE invoice_id = ? \
   AND certifier_reassign_comments like 'Invoice Released :%' \
   AND rownum = 1 \
   UNION ALL \
 SELECT INVOICE_ID, \
       SUPPLIER_ID, \
       SUPPLIER_NAME, \
       SUPPLIER_NUMBER, \
       SITE_ID, \
       PO_NUMBER, \
       TAX_AMOUNT, \
       WITHHOLDING_TAX, \
       INVOICE_DATE, \
       INTERNAL_STATUS, \
       '' modified_by, \
       ALTERNATE_APPROVER, \
       DOCUMENT_TYPE, \
       INVOICE_TYPE, \
       ORG_ID, \
       INVOICE_NUMBER, \
       SITE_NAME, \
       TAX_REG_NUMBER, \
       INVOICE_TOT_AMOUNT, \
       CURRENCY_CODE, \
       CERTIFIER_NAME, \
       EMPLOYEE_NUMBER, \
       CERTIFIER_EMAIL_ADD, \
       INVALID_REASON, \
       PO_TYPE, \
       INVALID_REASON_TYPE, \
       DOC_ID, \
       STATUS, \
       AP_OPERATION_COMMENTS, \
       CERTIFIER_REJ_REASON, \
       CERTIFIER_REJ_COMMENTS, \
       CERTIFIER_REASSIGN_TO, \
       CERTIFIER_REASSIGN_COMMENTS, \
       CERTIFIER_APPROVE_COMMENTS, \
       CERTIFIER_BY, \
       LAST_UPDATED_DATE, \
       '' reassigned_by \
  FROM js_ap_audit_invoice_table a \
 WHERE invoice_id = ? \
   AND internal_status = 'INVOICE APPROVED BY CERTIFIER' \
   AND LAST_UPDATED_DATE = \
       (SELECT MAX(LAST_UPDATED_DATE) \
          FROM js_ap_audit_invoice_table \
         WHERE invoice_id = a.invoice_id \
           AND internal_status = a.internal_status) \
   AND rownum = 1 \
 ORDER BY last_updated_date \

 
 
 
EQFILES_AUDIT_QUERY_UPDATED =\
SELECT INVOICE_ID,  \
       SUPPLIER_ID,  \
       SUPPLIER_NAME,  \
       SUPPLIER_NUMBER,  \
       SITE_ID,  \
       PO_NUMBER,  \
       TAX_AMOUNT,  \
       WITHHOLDING_TAX,  \
       INVOICE_DATE,  \
       'INVOICE FROM WFR TO BPM' INTERNAL_STATUS,  \
       '' modified_by,  \
       ALTERNATE_APPROVER,  \
       DOCUMENT_TYPE,  \
       INVOICE_TYPE,  \
       ORG_ID,  \
       INVOICE_NUMBER,  \
       SITE_NAME,  \
       TAX_REG_NUMBER,  \
       INVOICE_TOT_AMOUNT,  \
       CURRENCY_CODE,  \
       CERTIFIER_NAME,  \
       EMPLOYEE_NUMBER,  \
       CERTIFIER_EMAIL_ADD,  \
       INVALID_REASON,  \
       PO_TYPE,  \
       INVALID_REASON_TYPE,  \
       DOC_ID,  \
       STATUS,  \
       AP_OPERATION_COMMENTS,  \
       CERTIFIER_REJ_REASON,  \
       CERTIFIER_REJ_COMMENTS,  \
       CERTIFIER_REASSIGN_TO,  \
       CERTIFIER_REASSIGN_COMMENTS,  \
       CERTIFIER_APPROVE_COMMENTS,  \
       CERTIFIER_BY,  \
       LAST_UPDATED_DATE,  \
       '' reassigned_by  \
  FROM js_ap_audit_invoice_table a  \
 WHERE invoice_id = ?  \
   AND internal_status = 'DATA FROM WFR TO BPM'  \
   AND LAST_UPDATED_DATE =  \
       (SELECT MIN(LAST_UPDATED_DATE)  \
          FROM js_ap_audit_invoice_table  \
         WHERE invoice_id = a.invoice_id  \
           AND internal_status = a.internal_status)  \
   AND rownum = 1  \
UNION ALL  \
SELECT distinct INVOICE_ID,  \
       SUPPLIER_ID,  \
       SUPPLIER_NAME,  \
       SUPPLIER_NUMBER,  \
       SITE_ID,  \
       PO_NUMBER,  \
       TAX_AMOUNT,  \
       WITHHOLDING_TAX,  \
       INVOICE_DATE,  \
       'INVOICE IN AP EXCEPTIONS' INTERNAL_STATUS,  \
        modified_by,  \
       ALTERNATE_APPROVER,  \
       DOCUMENT_TYPE,  \
       INVOICE_TYPE,  \
       ORG_ID,  \
       INVOICE_NUMBER,  \
       SITE_NAME,  \
       TAX_REG_NUMBER,  \
       INVOICE_TOT_AMOUNT,  \
       CURRENCY_CODE,  \
       CERTIFIER_NAME,  \
       EMPLOYEE_NUMBER,  \
       CERTIFIER_EMAIL_ADD,  \
       INVALID_REASON,  \
       PO_TYPE,  \
       INVALID_REASON_TYPE,  \
       DOC_ID,  \
       STATUS,  \
       (select LISTAGG(description, ',') WITHIN \
        GROUP( \
       ORDER BY description) \
       from js_ap_comments_table \
      where category like 'AP Operation%' \
       and invoice_id = a.invoice_id \
       and trunc(comments_date)=trunc(a.LAST_UPDATED_DATE) )AP_OPERATION_COMMENTS,  \
       CERTIFIER_REJ_REASON,  \
       CERTIFIER_REJ_COMMENTS,  \
       CERTIFIER_REASSIGN_TO,  \
       CERTIFIER_REASSIGN_COMMENTS,  \
       CERTIFIER_APPROVE_COMMENTS,  \
       CERTIFIER_BY,  \
       LAST_UPDATED_DATE,  \
       '' reassigned_by  \
  FROM js_ap_audit_invoice_table a  \
 WHERE invoice_id = ?  \
   AND internal_status = 'INVOICE UPDATED BY AP GROUP'  \
   UNION ALL  \
SELECT INVOICE_ID,  \
       SUPPLIER_ID,  \
       SUPPLIER_NAME,  \
       SUPPLIER_NUMBER,  \
       SITE_ID,  \
       PO_NUMBER,  \
       TAX_AMOUNT,  \
       WITHHOLDING_TAX,  \
       INVOICE_DATE,  \
       decode(CERTIFIER_REASSIGN_COMMENTS,  \
              NULL,  \
              internal_status,  \
              'INVOICE REASSIGNED BY : ' ||  \
              nvl((substr(CERTIFIER_REASSIGN_COMMENTS,  \
                     length('Reassigned by User  '),  \
                     instr(CERTIFIER_REASSIGN_COMMENTS, 'on') -  \
                     length('Reassigned by User  ') - 1)),employee_number)) internal_status,  \
                     '' modified_by,  \
       ALTERNATE_APPROVER,  \
       DOCUMENT_TYPE,  \
       INVOICE_TYPE,  \
       ORG_ID,  \
       INVOICE_NUMBER,  \
       SITE_NAME,  \
       TAX_REG_NUMBER,  \
       INVOICE_TOT_AMOUNT,  \
       CURRENCY_CODE,  \
       CERTIFIER_NAME,  \
       EMPLOYEE_NUMBER,  \
       CERTIFIER_EMAIL_ADD,  \
       INVALID_REASON,  \
       PO_TYPE,  \
       INVALID_REASON_TYPE,  \
       DOC_ID,  \
       STATUS,  \
       AP_OPERATION_COMMENTS,  \
       CERTIFIER_REJ_REASON,  \
       CERTIFIER_REJ_COMMENTS,  \
       CERTIFIER_REASSIGN_TO,  \
       CERTIFIER_REASSIGN_COMMENTS,  \
       CERTIFIER_APPROVE_COMMENTS,  \
       CERTIFIER_BY,  \
       LAST_UPDATED_DATE,  \
       substr(CERTIFIER_REASSIGN_COMMENTS,  \
              length('Reassigned by User  '),  \
              instr(CERTIFIER_REASSIGN_COMMENTS, 'on') -  \
              length('Reassigned by User  ') - 1) reassigned_by  \
  FROM js_ap_audit_invoice_table a  \
 WHERE invoice_id = ?  \
   AND internal_status = 'INVOICE PENDING FOR CERTIFICATION'  \
    AND nvl(certifier_reassign_comments,'E') not like 'Invoice Released :%'  \
   AND  (rowid,employee_number) IN (select max(rowid),employee_number from js_ap_audit_invoice_table  \
   where internal_status=a.internal_status  \
    and invoice_id=a.invoice_id  \
   group by decode(CERTIFIER_REASSIGN_COMMENTS,  \
              NULL,  \
              decode(invalid_reason,  \
                     'CERTIFIER REJECTION',  \
                     'INVOICE REJECTED BY : ' || employee_number,  \
                     internal_status),  \
              'INVOICE REASSIGNED BY : ' ||  \
              nvl((substr(CERTIFIER_REASSIGN_COMMENTS,  \
                     length('Reassigned by User  '),  \
                     instr(CERTIFIER_REASSIGN_COMMENTS, 'on') -  \
                     length('Reassigned by User  ') - 1)),employee_number)),employee_number)  \
 GROUP BY INVOICE_ID,  \
          SUPPLIER_ID,  \
          SUPPLIER_NAME,  \
          SUPPLIER_NUMBER,  \
          SITE_ID,  \
          PO_NUMBER,  \
          TAX_AMOUNT,  \
          WITHHOLDING_TAX,  \
          INVOICE_DATE,  \
          INTERNAL_STATUS,  \
          CERTIFIER_CANCEL_BY,  \
          CERTIFIER_CANCEL_ON,  \
          ALTERNATE_APPROVER,  \
          DOCUMENT_TYPE,  \
          INVOICE_TYPE, \
          ORG_ID,  \
          INVOICE_NUMBER, \
          SITE_NAME,  \
          TAX_REG_NUMBER,  \
          INVOICE_TOT_AMOUNT,  \
          CURRENCY_CODE, \
          CERTIFIER_NAME, \
          EMPLOYEE_NUMBER,  \
          CERTIFIER_EMAIL_ADD,  \
          INVALID_REASON, \
          PO_TYPE, \
          INVALID_REASON_TYPE,  \
          DOC_ID,  \
          STATUS,  \
          AP_OPERATION_COMMENTS, \
          CERTIFIER_REJ_REASON,  \
          CERTIFIER_REJ_COMMENTS, \
          CERTIFIER_REASSIGN_TO,  \
          CERTIFIER_REASSIGN_COMMENTS,  \
          CERTIFIER_APPROVE_COMMENTS,  \
          CERTIFIER_BY,  \
          LAST_UPDATED_DATE,  \
          substr(CERTIFIER_REASSIGN_COMMENTS,  \
                 length('Reassigned by User  '),  \
                 instr(CERTIFIER_REASSIGN_COMMENTS, 'on') -  \
                 length('Reassigned by User  ') - 1)  \
 UNION ALL  \
 SELECT INVOICE_ID,  \
       SUPPLIER_ID,  \
       SUPPLIER_NAME,  \
       SUPPLIER_NUMBER,  \
       SITE_ID,  \
       PO_NUMBER,  \
       TAX_AMOUNT,  \
       WITHHOLDING_TAX,  \
       INVOICE_DATE,  \
        INTERNAL_STATUS,  \
       '' modified_by,  \
       ALTERNATE_APPROVER,  \
       DOCUMENT_TYPE,  \
       INVOICE_TYPE,  \
       ORG_ID,  \
       INVOICE_NUMBER,  \
       SITE_NAME,  \
       TAX_REG_NUMBER,  \
       INVOICE_TOT_AMOUNT,  \
       CURRENCY_CODE,  \
       CERTIFIER_NAME,  \
       EMPLOYEE_NUMBER,  \
       CERTIFIER_EMAIL_ADD,  \
       INVALID_REASON,  \
       PO_TYPE,  \
       INVALID_REASON_TYPE,  \
       DOC_ID,  \
       STATUS,  \
       AP_OPERATION_COMMENTS,  \
       CERTIFIER_REJ_REASON,  \
       CERTIFIER_REJ_COMMENTS,  \
       CERTIFIER_REASSIGN_TO,  \
       CERTIFIER_REASSIGN_COMMENTS,  \
       CERTIFIER_APPROVE_COMMENTS,  \
       CERTIFIER_BY,  \
       LAST_UPDATED_DATE, \
       '' reassigned_by \
  FROM js_ap_audit_invoice_table a \
 WHERE invoice_id = ?  \
   AND internal_status = 'INVOICE IN AP INTERFACE'  \
   AND LAST_UPDATED_DATE =  \
       (SELECT MAX(LAST_UPDATED_DATE)  \
          FROM js_ap_audit_invoice_table  \
         WHERE invoice_id = a.invoice_id  \
           AND internal_status = a.internal_status)  \
   AND rownum = 1  \
 UNION ALL  \
 SELECT INVOICE_ID,  \
       SUPPLIER_ID,  \
       SUPPLIER_NAME,  \
       SUPPLIER_NUMBER,  \
       SITE_ID,  \
       PO_NUMBER,  \
       TAX_AMOUNT,  \
       WITHHOLDING_TAX,  \
       INVOICE_DATE,  \
       'INVOICE PENDING FOR CERTIFICATION : HOLD' INTERNAL_STATUS,  \
       '' modified_by,  \
       ALTERNATE_APPROVER,  \
       DOCUMENT_TYPE,  \
       INVOICE_TYPE,  \
       ORG_ID,  \
       INVOICE_NUMBER,  \
       SITE_NAME,  \
       TAX_REG_NUMBER,  \
       INVOICE_TOT_AMOUNT,  \
       CURRENCY_CODE, \
       CERTIFIER_NAME,  \
       EMPLOYEE_NUMBER,  \
       CERTIFIER_EMAIL_ADD,  \
       INVALID_REASON, \
       PO_TYPE,  \
       INVALID_REASON_TYPE,  \
       DOC_ID,  \
       STATUS,  \
       AP_OPERATION_COMMENTS,  \
       CERTIFIER_REJ_REASON,  \
       CERTIFIER_REJ_COMMENTS,  \
       CERTIFIER_REASSIGN_TO,  \
       CERTIFIER_REASSIGN_COMMENTS,  \
       CERTIFIER_APPROVE_COMMENTS,  \
       CERTIFIER_BY,  \
       LAST_UPDATED_DATE,  \
       '' reassigned_by  \
  FROM js_ap_audit_invoice_table a  \
 WHERE invoice_id = ?  \
   AND upper(internal_status) = upper('Invoice on Hold')  \
   AND certifier_reassign_comments like 'Invoice on Hold :%'  \
   AND LAST_UPDATED_DATE =  \
       (SELECT MAX(LAST_UPDATED_DATE)  \
          FROM js_ap_audit_invoice_table  \
         WHERE invoice_id = a.invoice_id  \
           AND internal_status = a.internal_status)  \
   AND rownum = 1  \
    UNION ALL  \
 SELECT INVOICE_ID,  \
       SUPPLIER_ID,  \
       SUPPLIER_NAME,  \
       SUPPLIER_NUMBER,  \
       SITE_ID,  \
       PO_NUMBER,  \
       TAX_AMOUNT,  \
       WITHHOLDING_TAX,  \
       INVOICE_DATE,  \
       'INVOICE PENDING FOR CERTIFICATION : RELEASED' INTERNAL_STATUS,  \
       '' modified_by,  \
       ALTERNATE_APPROVER,  \
       DOCUMENT_TYPE, \
       INVOICE_TYPE,  \
       ORG_ID,  \
       INVOICE_NUMBER,  \
       SITE_NAME,  \
       TAX_REG_NUMBER,  \
       INVOICE_TOT_AMOUNT,  \
       CURRENCY_CODE,  \
       CERTIFIER_NAME,  \
       EMPLOYEE_NUMBER,  \
       CERTIFIER_EMAIL_ADD,  \
       INVALID_REASON,  \
       PO_TYPE,  \
       INVALID_REASON_TYPE,  \
       DOC_ID,  \
       STATUS,  \
       AP_OPERATION_COMMENTS,  \
       CERTIFIER_REJ_REASON,  \
       CERTIFIER_REJ_COMMENTS,  \
       CERTIFIER_REASSIGN_TO,  \
       CERTIFIER_REASSIGN_COMMENTS,  \
       CERTIFIER_APPROVE_COMMENTS,  \
       CERTIFIER_BY,  \
       LAST_UPDATED_DATE,  \
       '' reassigned_by  \
  FROM js_ap_audit_invoice_table a  \
 WHERE invoice_id = ?  \
   AND internal_status = 'INVOICE PENDING FOR CERTIFICATION' \
   AND certifier_reassign_comments like 'Invoice Released :%'  \
   AND rownum = 1  \
   UNION ALL  \
 SELECT INVOICE_ID, \
       SUPPLIER_ID,  \
       SUPPLIER_NAME,  \
       SUPPLIER_NUMBER,  \
       SITE_ID,  \
       PO_NUMBER,  \
       TAX_AMOUNT,  \
       WITHHOLDING_TAX, \
       INVOICE_DATE,  \
       INTERNAL_STATUS,  \
       '' modified_by,  \
       ALTERNATE_APPROVER,  \
       DOCUMENT_TYPE,  \
       INVOICE_TYPE,  \
       ORG_ID,  \
       INVOICE_NUMBER,  \
       SITE_NAME,  \
       TAX_REG_NUMBER,  \
       INVOICE_TOT_AMOUNT,  \
       CURRENCY_CODE,  \
       CERTIFIER_NAME,  \
       EMPLOYEE_NUMBER,  \
       CERTIFIER_EMAIL_ADD, \
       INVALID_REASON, \
       PO_TYPE,  \
       INVALID_REASON_TYPE,  \
       DOC_ID,  \
       STATUS,  \
       AP_OPERATION_COMMENTS,  \
       CERTIFIER_REJ_REASON,  \
       CERTIFIER_REJ_COMMENTS,  \
       CERTIFIER_REASSIGN_TO,  \
       CERTIFIER_REASSIGN_COMMENTS,  \
       CERTIFIER_APPROVE_COMMENTS,  \
       CERTIFIER_BY,  \
       LAST_UPDATED_DATE,  \
       '' reassigned_by  \
  FROM js_ap_audit_invoice_table a  \
 WHERE invoice_id = ?  \
   AND internal_status = 'INVOICE APPROVED BY CERTIFIER'  \
   AND LAST_UPDATED_DATE =  \
       (SELECT MAX(LAST_UPDATED_DATE)  \
          FROM js_ap_audit_invoice_table  \
         WHERE invoice_id = a.invoice_id  \
           AND internal_status = a.internal_status)  \
   AND rownum = 1  \
   UNION ALL \
   SELECT INVOICE_ID,  \
       SUPPLIER_ID,   \
       SUPPLIER_NAME,  \
       SUPPLIER_NUMBER, \
       SITE_ID,   \
       PO_NUMBER,  \
       TAX_AMOUNT,  \
       WITHHOLDING_TAX, \
       INVOICE_DATE,   \
       decode(employee_number,null,'INVOICE REJECTED BY CERTIFIER ','INVOICE REJECTED BY : ' || employee_number) INTERNAL_STATUS, \
       '' modified_by,   \
       ALTERNATE_APPROVER, \
       DOCUMENT_TYPE,   \
       INVOICE_TYPE,   \
       ORG_ID,   \
       INVOICE_NUMBER, \
       SITE_NAME,   \
       TAX_REG_NUMBER, \
       INVOICE_TOT_AMOUNT, \
       CURRENCY_CODE,   \
       CERTIFIER_NAME,   \
       EMPLOYEE_NUMBER,   \
       CERTIFIER_EMAIL_ADD, \
       INVALID_REASON,  \
       PO_TYPE,   \
       INVALID_REASON_TYPE, \
       DOC_ID,   \
       STATUS,   \
       AP_OPERATION_COMMENTS, \
       CERTIFIER_REJ_REASON,   \
       CERTIFIER_REJ_COMMENTS,  \
       CERTIFIER_REASSIGN_TO,   \
       CERTIFIER_REASSIGN_COMMENTS, \
       CERTIFIER_APPROVE_COMMENTS,   \
       CERTIFIER_BY,   \
       LAST_UPDATED_DATE, \
       '' reassigned_by   \
  FROM js_ap_audit_invoice_table a \
 WHERE invoice_id = ?   \
   AND internal_status = 'INVOICE REJECTED BY CERTIFIER' \
   AND LAST_UPDATED_DATE =   \
       (SELECT MAX(LAST_UPDATED_DATE) \
          FROM js_ap_audit_invoice_table  \
         WHERE invoice_id = a.invoice_id \
           AND internal_status = a.internal_status) \
   AND rownum = 1   \
UNION ALL \
SELECT INVOICE_ID, \
       SUPPLIER_ID, \
       SUPPLIER_NAME, \
       SUPPLIER_NUMBER, \
       SITE_ID, \
       PO_NUMBER, \
       TAX_AMOUNT, \
       WITHHOLDING_TAX, \
       INVOICE_DATE, \
        INTERNAL_STATUS, \
       '' modified_by, \
       ALTERNATE_APPROVER, \
       DOCUMENT_TYPE, \
       INVOICE_TYPE, \
       ORG_ID, \
       INVOICE_NUMBER, \
       SITE_NAME, \
       TAX_REG_NUMBER, \
       INVOICE_TOT_AMOUNT, \
       CURRENCY_CODE, \
       CERTIFIER_NAME, \
       EMPLOYEE_NUMBER, \
       CERTIFIER_EMAIL_ADD, \
       INVALID_REASON, \
       PO_TYPE, \
       INVALID_REASON_TYPE, \
       DOC_ID, \
       STATUS, \
       AP_OPERATION_COMMENTS, \
       CERTIFIER_REJ_REASON, \
       CERTIFIER_REJ_COMMENTS, \
       CERTIFIER_REASSIGN_TO, \
       CERTIFIER_REASSIGN_COMMENTS, \
       CERTIFIER_APPROVE_COMMENTS, \
       CERTIFIER_BY, \
       LAST_UPDATED_DATE, \
       '' reassigned_by \
  FROM js_ap_audit_invoice_table a \
 WHERE invoice_id = ? \
   AND internal_status = 'AUTO REJECTED BY SYSTEM' \
   AND LAST_UPDATED_DATE =  \
       (SELECT MAX(LAST_UPDATED_DATE) \
          FROM js_ap_audit_invoice_table \
         WHERE invoice_id = a.invoice_id \
           AND internal_status = a.internal_status) \
   AND rownum = 1 \
UNION ALL \
SELECT INVOICE_ID, \
       SUPPLIER_ID, \
       SUPPLIER_NAME, \
       SUPPLIER_NUMBER, \
       SITE_ID, \
       PO_NUMBER, \
       TAX_AMOUNT, \
       WITHHOLDING_TAX, \
       INVOICE_DATE, \
        INTERNAL_STATUS, \
       '' modified_by, \
       ALTERNATE_APPROVER, \
       DOCUMENT_TYPE, \
       INVOICE_TYPE, \
       ORG_ID, \
       INVOICE_NUMBER, \
       SITE_NAME, \
       TAX_REG_NUMBER, \
       INVOICE_TOT_AMOUNT, \
       CURRENCY_CODE, \
       CERTIFIER_NAME, \
       EMPLOYEE_NUMBER, \
       CERTIFIER_EMAIL_ADD, \
       INVALID_REASON, \
       PO_TYPE, \
       INVALID_REASON_TYPE, \
       DOC_ID, \
       STATUS, \
       AP_OPERATION_COMMENTS, \
       CERTIFIER_REJ_REASON, \
       CERTIFIER_REJ_COMMENTS, \
       CERTIFIER_REASSIGN_TO, \
       CERTIFIER_REASSIGN_COMMENTS, \
       CERTIFIER_APPROVE_COMMENTS, \
       CERTIFIER_BY, \
       LAST_UPDATED_DATE, \
       '' reassigned_by \
  FROM js_ap_audit_invoice_table a \
 WHERE invoice_id = ? \
   AND internal_status = 'DUPLICATE INVOICE REJECTED BY SYSTEM' \
   AND LAST_UPDATED_DATE = \
       (SELECT MAX(LAST_UPDATED_DATE) \
          FROM js_ap_audit_invoice_table \
         WHERE invoice_id = a.invoice_id  \
           AND internal_status = a.internal_status) \
   AND rownum = 1 \
   UNION ALL \
   SELECT INVOICE_ID, \
       SUPPLIER_ID, \
       SUPPLIER_NAME, \
       SUPPLIER_NUMBER, \
       SITE_ID, \
       PO_NUMBER, \
       TAX_AMOUNT, \
       WITHHOLDING_TAX, \
       INVOICE_DATE, \
        INTERNAL_STATUS, \
       '' modified_by, \
       ALTERNATE_APPROVER, \
       DOCUMENT_TYPE, \
       INVOICE_TYPE, \
       ORG_ID, \
       INVOICE_NUMBER, \
       SITE_NAME, \
       TAX_REG_NUMBER, \
       INVOICE_TOT_AMOUNT, \
       CURRENCY_CODE, \
       CERTIFIER_NAME, \
       EMPLOYEE_NUMBER, \
       CERTIFIER_EMAIL_ADD, \
       INVALID_REASON, \
       PO_TYPE, \
       INVALID_REASON_TYPE, \
       DOC_ID, \
       STATUS, \
       AP_OPERATION_COMMENTS, \
       CERTIFIER_REJ_REASON, \
       CERTIFIER_REJ_COMMENTS, \
       CERTIFIER_REASSIGN_TO, \
       CERTIFIER_REASSIGN_COMMENTS, \
       CERTIFIER_APPROVE_COMMENTS, \
       CERTIFIER_BY, \
       LAST_UPDATED_DATE, \
       '' reassigned_by \
  FROM js_ap_audit_invoice_table a \
 WHERE invoice_id = ? \
   AND internal_status = 'INVOICE REJECTED BY AP GROUP' \
   AND LAST_UPDATED_DATE = \
       (SELECT MAX(LAST_UPDATED_DATE) \
          FROM js_ap_audit_invoice_table \
         WHERE invoice_id = a.invoice_id  \
           AND internal_status = a.internal_status) \
   AND rownum = 1 \
ORDER BY last_updated_date  \

EBS_EMPLOYEE_NAME_QUERY=\
SELECT first_name,last_name \
FROM apps.per_all_people_f \
WHERE trunc(SYSDATE) BETWEEN trunc(effective_start_date) AND \
trunc(effective_end_date) \
AND current_employee_flag = 'Y' \
AND employee_number = ? \


EBS_AUDIT_QUERY=\
SELECT * \
 FROM (SELECT ai.invoice_id \
              ,ai.invoice_num \
              ,ai.vendor_id \
              ,ai.vendor_site_id \
              ,ai.org_id \
              ,ai.invoice_currency_code \
              ,ai.invoice_amount \
              ,to_char(ai.invoice_date \
                      ,'YYYY-MM-DD') invoice_date \
              ,'eQ Interface Deleted' \
              ,nvl(ai.last_update_date \
                  ,ai.creation_date) action_date \
              ,999 sl_no \
              ,regexp_substr(ai.attribute15 \
                            ,'[^_]+' \
                            ,1 \
                            ,2) doc_id \
          FROM bolinf.qfeq_ap_inv_intrfc_del_audit ai \
        UNION \
        SELECT ai.invoice_id \
              ,ai.invoice_num \
              ,ai.vendor_id \
              ,ai.vendor_site_id \
              ,ai.org_id \
              ,ai.invoice_currency_code \
              ,ai.invoice_amount \
              ,to_char(ai.invoice_date \
                      ,'YYYY-MM-DD') invoice_date \
              ,'eQ ' || decode(status \
                              ,'REJECTED' \
                              ,'Interface Rejected' \
                              ,NULL \
                              ,'Awaiting Import' \
                              ,status) \
              ,ai.creation_date action_date \
              ,999 sl_no \
              ,regexp_substr(ai.attribute15 \
                            ,'[^_]+' \
                            ,1 \
                            ,2) doc_id \
          FROM apps.ap_invoices_interface ai \
         WHERE nvl(status \
                  ,'NEW') <> 'PROCESSED' \
        UNION \
        SELECT ai.invoice_id \
              ,ai.invoice_num \
              ,ai.vendor_id \
              ,ai.vendor_site_id \
              ,ai.org_id \
              ,ai.invoice_currency_code \
              ,ai.invoice_amount \
              ,to_char(ai.invoice_date \
                      ,'YYYY-MM-DD') invoice_date \
              ,'eQ Created' status \
              ,ai.creation_date action_date \
              ,999 sl_no \
              ,regexp_substr(ai.attribute15 \
                            ,'[^_]+' \
                            ,1 \
                            ,2) doc_id \
          FROM apps.ap_invoices_all ai \
        UNION \
        SELECT ai.invoice_id \
              ,ai.invoice_num \
              ,ai.vendor_id \
              ,ai.vendor_site_id \
              ,ai.org_id \
              ,ai.invoice_currency_code \
              ,ai.invoice_amount \
              ,to_char(ai.invoice_date \
                      ,'YYYY-MM-DD') invoice_date \
              ,'eQ ' || initcap(hist.response) \
              ,hist.creation_date \
              ,hist.sl_no \
              ,regexp_substr(ai.attribute15 \
                            ,'[^_]+' \
                            ,1 \
                            ,2) doc_id \
          FROM (SELECT rank() over(PARTITION BY invoice_id ORDER BY aha.invoice_id, aha.last_update_date DESC, aha.approval_history_id DESC) sl_no \
                      ,aha.* \
                  FROM apps.ap_inv_aprvl_hist_all aha) hist \
              ,apps.ap_invoices_all ai \
         WHERE hist.invoice_id = ai.invoice_id \
        UNION \
        SELECT ai.invoice_id \
              ,ai.invoice_num \
              ,ai.vendor_id \
              ,ai.vendor_site_id \
              ,ai.org_id \
              ,ai.invoice_currency_code \
              ,ai.invoice_amount \
              ,to_char(ai.invoice_date \
                      ,'YYYY-MM-DD') invoice_date \
              ,'eQ Cancelled' status \
              ,ai.cancelled_date \
              ,0 \
              ,regexp_substr(ai.attribute15 \
                            ,'[^_]+' \
                            ,1 \
                            ,2) doc_id \
          FROM apps.ap_invoices_all ai \
         WHERE ai.cancelled_date IS NOT NULL \
        UNION \
        SELECT ai.invoice_id \
              ,ai.invoice_num \
              ,ai.vendor_id \
              ,ai.vendor_site_id \
              ,ai.org_id \
              ,ai.invoice_currency_code \
              ,ai.invoice_amount \
              ,to_char(ai.invoice_date \
                      ,'YYYY-MM-DD') invoice_date \
              ,'eQ Paid' status \
              ,ac.check_date \
              ,0 \
              ,regexp_substr(ai.attribute15 \
                            ,'[^_]+' \
                            ,1 \
                            ,2) doc_id \
          FROM apps.ap_invoice_payments_all aip \
              ,apps.ap_checks_all           ac \
              ,apps.ap_invoices_all         ai \
         WHERE ac.check_id = aip.check_id \
           AND ac.void_date IS NULL \
           AND ai.invoice_id = aip.invoice_id) \
WHERE doc_id = ? \
   AND invoice_num = ? \
ORDER BY sl_no DESC \
 

EBS_AUDIT_QUERY_LATEST=\
SELECT * \
  FROM (SELECT ai.invoice_id \
              ,ai.invoice_num \
              ,ai.vendor_id \
              ,ai.vendor_site_id \
              ,ai.org_id \
              ,ai.invoice_currency_code \
              ,ai.invoice_amount \
              ,to_char(ai.invoice_date \
                      ,'YYYY-MM-DD') invoice_date \
              ,'eQ Interface Deleted' \
              ,nvl(ai.last_update_date \
                  ,ai.creation_date) action_date \
              ,999 sl_no \
              ,NULL approver_comments \
              ,NULL approver_name \
              ,regexp_substr(ai.attribute15 \
                            ,'[^_]+' \
                            ,1 \
                            ,2) doc_id \
          FROM bolinf.qfeq_ap_inv_intrfc_del_audit ai \
        UNION \
        SELECT ai.invoice_id \
              ,ai.invoice_num \
              ,ai.vendor_id \
              ,ai.vendor_site_id \
              ,ai.org_id \
              ,ai.invoice_currency_code \
              ,ai.invoice_amount \
              ,to_char(ai.invoice_date \
                      ,'YYYY-MM-DD') invoice_date \
              ,'eQ ' || decode(status \
                              ,'REJECTED' \
                              ,'Interface Rejected' \
                              ,NULL \
                              ,'Awaiting Import' \
                              ,status) \
              ,ai.creation_date action_date \
              ,999 sl_no \
              ,NULL \
              ,NULL \
              ,regexp_substr(ai.attribute15 \
                            ,'[^_]+' \
                            ,1 \
                            ,2) doc_id \
          FROM apps.ap_invoices_interface ai \
         WHERE nvl(status \
                  ,'NEW') <> 'PROCESSED' \
        UNION \
        SELECT ai.invoice_id \
              ,ai.invoice_num \
              ,ai.vendor_id \
              ,ai.vendor_site_id \
              ,ai.org_id \
              ,ai.invoice_currency_code \
              ,ai.invoice_amount \
              ,to_char(ai.invoice_date \
                      ,'YYYY-MM-DD') invoice_date \
              ,'eQ Created' status \
              ,ai.creation_date action_date \
              ,999 sl_no \
              ,NULL \
              ,null \
              ,regexp_substr(ai.attribute15 \
                            ,'[^_]+' \
                            ,1 \
                            ,2) doc_id \
          FROM apps.ap_invoices_all ai \
        UNION \
        SELECT ai.invoice_id \
              ,ai.invoice_num \
              ,ai.vendor_id \
              ,ai.vendor_site_id \
              ,ai.org_id \
              ,ai.invoice_currency_code \
              ,ai.invoice_amount \
              ,to_char(ai.invoice_date \
                      ,'YYYY-MM-DD') invoice_date \
              ,'eQ ' || initcap(hist.response) \
              ,hist.creation_date \
              ,hist.sl_no \
              ,hist.approver_comments \
              ,hist.approver_name \
              ,regexp_substr(ai.attribute15 \
                            ,'[^_]+' \
                            ,1 \
                            ,2) doc_id \
          FROM (SELECT rank() over(PARTITION BY invoice_id ORDER BY aha.invoice_id, aha.last_update_date DESC, aha.approval_history_id DESC) sl_no \
                      ,aha.* \
                  FROM apps.ap_inv_aprvl_hist_all aha) hist \
              ,apps.ap_invoices_all ai \
         WHERE hist.invoice_id = ai.invoice_id \
        UNION \
        SELECT ai.invoice_id \
              ,ai.invoice_num \
              ,ai.vendor_id \
              ,ai.vendor_site_id \
              ,ai.org_id \
              ,ai.invoice_currency_code \
              ,ai.invoice_amount \
              ,to_char(ai.invoice_date \
                      ,'YYYY-MM-DD') invoice_date \
              ,'eQ Cancelled' status \
              ,ai.cancelled_date \
              ,0 \
              ,NULL \
              ,NULL \
              ,regexp_substr(ai.attribute15 \
                            ,'[^_]+' \
                            ,1 \
                            ,2) doc_id \
          FROM apps.ap_invoices_all ai \
         WHERE ai.cancelled_date IS NOT NULL \
        UNION \
        SELECT ai.invoice_id \
              ,ai.invoice_num \
              ,ai.vendor_id \
              ,ai.vendor_site_id \
              ,ai.org_id \
              ,ai.invoice_currency_code \
              ,ai.invoice_amount \
              ,to_char(ai.invoice_date \
                      ,'YYYY-MM-DD') invoice_date \
              ,'eQ Paid' status \
              ,ac.check_date \
              ,0 \
              ,NULL \
              ,NULL \
              ,regexp_substr(ai.attribute15 \
                            ,'[^_]+' \
                            ,1 \
                            ,2) doc_id \
          FROM apps.ap_invoice_payments_all aip \
              ,apps.ap_checks_all           ac \
              ,apps.ap_invoices_all         ai \
         WHERE ac.check_id = aip.check_id \
           AND ac.void_date IS NULL \
           AND ai.invoice_id = aip.invoice_id) \
 WHERE doc_id = ? \
   AND invoice_num = ? \
 ORDER BY sl_no DESC \

