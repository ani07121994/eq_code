package com.audit.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.audit.dao.FetchFromDB;
import com.audit.pojo.Invoice;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class FetchInvoiceDataServlet
 */
@WebServlet("/FetchInvoiceDataServlet")
public class FetchInvoiceDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchInvoiceDataServlet() {
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
		    System.out.println( obj.get("invoiceNum"));
		  
		  
		System.out.println("inside get of fetchinvoicedata");
		
		FetchFromDB ob = new FetchFromDB();
		
		ArrayList<Invoice> InvoiceList = ob.getDatafromDB(0,obj.get("invoiceNum").toString());
		
		
		//18756
		
		
		  
		String json = new Gson().toJson(InvoiceList);
        
        System.out.println("new json : "+json);
        
        response.setContentType("application/json");
        response.getWriter().write(json);
		  } catch (JSONException e) {
			    e.printStackTrace();
			  
			    request.setAttribute("GROUPING_EXCEPTION", new Exception( e.getMessage(),e));
		        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
			    //throw new IOException("Error parsing JSON request string");
			  }
		
	}

}
