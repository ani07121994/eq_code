package qantas.integration.util.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qantas.integration.util.SFTPLogger;
import qantas.integration.util.SFTPPollDriver;

/**
 * Servlet implementation class TriggerAppServlet
 */
public class TriggerAppServlet extends HttpServlet {
	
	private static final Logger logger = SFTPLogger.getLogger(TriggerAppServlet.class.getName());
	
	private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
       
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	SFTPPollDriver sftpPoll = SFTPPollDriver.getInstance();
    	sftpPoll.startPolling();
    	logger.info("Initialized");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>TriggerAppServlet</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a GET. This is the reply.</p>");
        out.println("</body></html>");
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>TriggerAppServlet</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a POST. This is the reply.</p>");
        out.println("</body></html>");
        out.close();
	}

}
