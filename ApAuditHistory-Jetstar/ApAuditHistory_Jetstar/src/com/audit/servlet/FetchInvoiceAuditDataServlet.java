package com.audit.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.audit.dao.FetchFromDB;
import com.audit.pojo.Invoice;
import com.audit.pojo.InvoiceAudit;
import com.google.gson.Gson;

/**
 * Servlet implementation class FetchInvoiceAuditDataServlet
 */
@WebServlet("/FetchInvoiceAuditDataServlet")
public class FetchInvoiceAuditDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchInvoiceAuditDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside post of fetchinvoicedata audit servlet");
		
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) { /*report an error*/ }
		  
		  System.out.println("request json string :"+jb.toString());
		  
		  
		  try {
			  
			 JSONObject obj  = new JSONObject(jb.toString());
		    System.out.println( obj.get("invoiceID"));
		
		    
		FetchFromDB ob = new FetchFromDB();
		
		
		
		ArrayList<InvoiceAudit> InvoiceAuditList = ob.getAuditDatafromDB(Integer.parseInt(obj.get("invoiceID").toString()));
		
		System.out.println("mo of elemenets received back in servlet : "+InvoiceAuditList.size());
		
		String json = new Gson().toJson(InvoiceAuditList);
		
		//String json1 = "[{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"NO-PO\",\"documentType\":\"INVOICE\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"0\",\"siteId\":\"996595\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"15/08/2018 11:02:17 AM\",\"comments\":\"\",\"internalStatus\":\"INVOICE FROM WFR TO BPM\",\"reasonType\":\"NONE\",\"statusCamelCase\":\"Invoice From Wfr To Bpm\",\"firstName\":\"\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"Non PO Invoice\",\"documentType\":\"Invoice\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"16/08/2018 01:15:07 PM\",\"comments\":\"\",\"internalStatus\":\"INVOICE IN AP EXCEPTIONS\",\"reasonType\":\"NONE\",\"certifierName\":\"Rona Gregorio\",\"employeeNumber\":\"201789\",\"statusCamelCase\":\"Invoice In Ap Exceptions\",\"firstName\":\"Shane\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"NO-PO\",\"documentType\":\"INVOICE\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"16/08/2018 01:15:26 PM\",\"comments\":\"\",\"internalStatus\":\"INVOICE PENDING FOR CERTIFICATION\",\"reasonType\":\"SUCCESS\",\"certifierName\":\"Shane O\\u0027Sullivan\",\"employeeNumber\":\"201789\",\"statusCamelCase\":\"Invoice Pending For Certification\",\"firstName\":\"Shane\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"Non PO Invoice\",\"documentType\":\"Invoice\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"19/09/2018 10:33:24 AM\",\"comments\":\"Please certify an forward for approval to CO\\n\",\"internalStatus\":\"INVOICE REASSIGNED BY : 610416\",\"reasonType\":\"SUCCESS\",\"certifierName\":\"Inna Minin\",\"employeeNumber\":\"616754\",\"statusCamelCase\":\"Invoice Reassigned By : Lynette OLeary\",\"employeeReassignedNo\":\"610416\",\"firstName\":\"Inna\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"Non PO Invoice\",\"documentType\":\"Invoice\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"25/09/2018 12:46:00 PM\",\"comments\":\"Please certify, provide few details and send it to Claudine\\n\",\"internalStatus\":\"INVOICE REASSIGNED BY : 616754\",\"reasonType\":\"SUCCESS\",\"certifierName\":\"Shane O\\u0027Sullivan\",\"employeeNumber\":\"201789\",\"statusCamelCase\":\"Invoice Reassigned By : Inna Minin\",\"employeeReassignedNo\":\"616754\",\"firstName\":\"Shane\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"Non PO Invoice\",\"documentType\":\"Invoice\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"15/10/2018 01:15:34 PM\",\"comments\":\"Please certify, provide few details and send it to Claudine\\n\",\"internalStatus\":\"INVOICE REASSIGNED BY : 616754\",\"reasonType\":\"SUCCESS\",\"certifierName\":\"O’Leary, Lynette Joy (Lynette)\",\"employeeNumber\":\"610416\",\"statusCamelCase\":\"Invoice Reassigned By : Inna Minin\",\"employeeReassignedNo\":\"616754\",\"firstName\":\"Lynette\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"Non PO Invoice\",\"documentType\":\"Invoice\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"25/10/2018 10:19:13 AM\",\"comments\":\"Please certify\\n\",\"internalStatus\":\"INVOICE REASSIGNED BY : 610416\",\"reasonType\":\"SUCCESS\",\"certifierName\":\"Shane O\\u0027Sullivan\",\"employeeNumber\":\"201789\",\"statusCamelCase\":\"Invoice Reassigned By : Lynette OLeary\",\"employeeReassignedNo\":\"610416\",\"firstName\":\"Shane\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"Non PO Invoice\",\"documentType\":\"Invoice\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"22/11/2018 01:53:37 PM\",\"comments\":\"Please certify\\n\",\"internalStatus\":\"INVOICE REASSIGNED BY : 610416\",\"reasonType\":\"INCORRECT INVOICE AMOUNT\",\"certifierName\":\"O’Leary, Lynette Joy (Lynette)\",\"employeeNumber\":\"610416\",\"statusCamelCase\":\"Invoice Reassigned By : Lynette OLeary\",\"employeeReassignedNo\":\"610416\",\"firstName\":\"Lynette\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"Non PO Invoice\",\"documentType\":\"Invoice\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"23/11/2018 10:56:32 AM\",\"comments\":\"As advised by PM (Shane O\\u0027Sullivan) incorrect invoice amount - being followed up with vendor - Lynette OLeary\\n\",\"internalStatus\":\"INVOICE IN AP EXCEPTIONS\",\"reasonType\":\"NONE\",\"certifierName\":\"Jamariene Kay Mapili\",\"employeeNumber\":\"610416\",\"statusCamelCase\":\"Invoice In Ap Exceptions\",\"firstName\":\"Lynette\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"NO-PO\",\"documentType\":\"INVOICE\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"23/11/2018 10:56:51 AM\",\"comments\":\"\",\"internalStatus\":\"INVOICE PENDING FOR CERTIFICATION\",\"reasonType\":\"SUCCESS\",\"certifierName\":\"Lynette OLeary\",\"employeeNumber\":\"610416\",\"statusCamelCase\":\"Invoice Pending For Certification\",\"firstName\":\"Lynette\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"Non PO Invoice\",\"documentType\":\"Invoice\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"30/11/2018 03:40:11 PM\",\"comments\":\"\",\"internalStatus\":\"INVOICE PENDING FOR CERTIFICATION\",\"reasonType\":\"OTHER\",\"certifierName\":\"Lynette OLeary\",\"employeeNumber\":\"610416\",\"statusCamelCase\":\"Invoice Pending For Certification\",\"firstName\":\"Lynette\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"Non PO Invoice\",\"documentType\":\"Invoice\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"30/11/2018 03:40:49 PM\",\"comments\":\"\",\"internalStatus\":\"INVOICE PENDING FOR CERTIFICATION\",\"reasonType\":\"OTHER\",\"certifierName\":\"Jamariene Kay Mapili\",\"employeeNumber\":\"201357\",\"statusCamelCase\":\"Invoice Pending For Certification\",\"firstName\":\"Jamariene Kay\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"Non PO Invoice\",\"documentType\":\"Invoice\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"30/11/2018 03:44:51 PM\",\"comments\":\"Rejected as per advise from Inna\\n\",\"internalStatus\":\"INVOICE REJECTED BY : 201357\",\"certifierName\":\"Jamariene Kay Mapili\",\"employeeNumber\":\"201357\",\"statusCamelCase\":\"Invoice Rejected By : Jamariene Kay Mapili\",\"firstName\":\"Jamariene Kay\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"Non PO Invoice\",\"documentType\":\"Invoice\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"30/11/2018 03:44:59 PM\",\"comments\":\"\",\"internalStatus\":\"INVOICE IN AP EXCEPTIONS\",\"reasonType\":\"NONE\",\"certifierName\":\"Jamariene Kay Mapili\",\"employeeNumber\":\"201357\",\"statusCamelCase\":\"Invoice In Ap Exceptions\",\"firstName\":\"Jamariene Kay\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"Non PO Invoice\",\"documentType\":\"Invoice\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"docId\":\"2.IPM_2282441\",\"lastUpdatedDate\":\"30/11/2018 03:45:16 PM\",\"comments\":\"Rejected as per advise from Inna\\n\",\"internalStatus\":\"INVOICE REJECTED BY AP GROUP\",\"reasonType\":\"NONE\",\"certifierName\":\"Jamariene Kay Mapili\",\"employeeNumber\":\"201357\",\"statusCamelCase\":\"Invoice Rejected By : Jamariene Kay Mapili\",\"firstName\":\"Jamariene Kay\",\"panelBorderColor\":\"green\"},{\"invoiceNo\":\"35789\",\"invoiceDate\":\"29-07-18\",\"invoiceType\":\"Non PO Invoice\",\"documentType\":\"Invoice\",\"supplierId\":\"953360\",\"supplierName\":\"Accesshq\",\"supplierNumber\":\"2085246\",\"siteId\":\"996595\",\"siteName\":\"MELBOURNE\",\"currencyCode\":\"AUD\",\"taxRegNumber\":\"13069942552\",\"taxAmount\":\"4215.0\",\"invoiceTotalAmount\":\"46365.0\",\"lastUpdatedDate\":\"30/11/2018 03:45:16 PM\",\"internalStatus\":\"INVOICE IN AP EXCEPTIONS\",\"certifierName\":\"\",\"statusCamelCase\":\"Invoice In Ap Exceptions\",\"panelBorderColor\":\"red\"}]";
        
		System.out.println(json);
		response.setContentType("application/json");
        response.getWriter().write(json);
		
	}catch(Exception e){
		e.printStackTrace();
		
        request.setAttribute("GROUPING_EXCEPTION", new Exception( e.getMessage(),e));
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		System.out.println("json parse error");
	}
	}

}
