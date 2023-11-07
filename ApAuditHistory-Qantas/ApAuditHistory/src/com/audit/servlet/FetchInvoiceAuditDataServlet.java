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
        
        System.out.println(json);
        response.setContentType("application/json");
        response.getWriter().write(json);
		
	}catch(Exception e){
		e.printStackTrace();
		/*String json = null;
		response.setContentType("application/json");
        response.getWriter().write("error");*/
		
        request.setAttribute("GROUPING_EXCEPTION", new Exception( e.getMessage(),e));
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		System.out.println("json parse error");
	}
	}

}
