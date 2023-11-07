package qantas.integration.util.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import qantas.integration.util.AppMonitor;


public class TriggerAppServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        System.out.println("***********************Starting FTP Polling Program**************************");
        super.init(config);
        AppMonitor pollFTP = AppMonitor.getInstance();
        pollFTP.startPolling();
//        AppMonitor.main(new String[] {});
//        FTPUtil.incoming_path_list = new ArrayList();
//        FTPUtil.incoming_path_list.add("/home/appldev/devIncoming/ftp_loc1");
//        FTPUtil.incoming_path_list.add("/home/appldev/devIncoming/ftp_loc2");
//        FTPUtil.incoming_path_list.add("/home/appldev/devIncoming/ftp_loc3");
//        FTPUtil.readFromConfig();
//        FTPUtil.getInterfacePath();
//        
//        try {
//            JobDetail job = JobBuilder.newJob(FTPUtil.class).withIdentity("PollSFTP", "qantas").build();
//            Trigger trigger = TriggerBuilder
//                                    .newTrigger()
//                                    .withIdentity("startPolling", "qantas")
//                                    .withSchedule(
//                                            SimpleScheduleBuilder.simpleSchedule()
//                                                    .withIntervalInSeconds(60*5).repeatForever())
//                                    .build();
//            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//                            scheduler.start();
//                            scheduler.scheduleJob(job, trigger);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        try{
//            FTPUtil.main();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
                                                           IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>TriggerAppServlet</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a GET. This is the reply.</p>");
        out.println("</body></html>");
        out.close();
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException,
                                                            IOException {
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
