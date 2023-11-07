package ap.quantas.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class AuditHistoryScreen extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
                                                           IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect("/bpm/workflow/APIntegrationPrjUI_JetStar/faces/adf.task-flow?adf.tfId=AuditHT_TaskFlow&adf.tfDoc=%2FWEB-INF%2FAuditHT_TaskFlow.xml&invoiceId="+request.getParameter("invoiceId"));
        return;    
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException,
                                                            IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect("/bpm/workflow/APIntegrationPrjUI_JetStar/faces/adf.task-flow?adf.tfId=AuditHT_TaskFlow&adf.tfDoc=%2FWEB-INF%2FAuditHT_TaskFlow.xml&invoiceId="+request.getParameter("invoiceId"));
        return;    
    }
}
