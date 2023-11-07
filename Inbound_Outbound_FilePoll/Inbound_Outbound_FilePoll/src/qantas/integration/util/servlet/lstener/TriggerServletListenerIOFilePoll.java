package qantas.integration.util.servlet.lstener;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;




import qantas.integration.util.AppMonitorIOFilePoll;
import qantas.integration.util.QFEQIFLoggerIOFilePoll;
import qantas.integration.util.servlet.TriggerAppServletIOFilePoll;

public class TriggerServletListenerIOFilePoll implements ServletContextListener {
    private ServletContext context = null;
    static private FileHandler fileTxt;


    public void contextInitialized(ServletContextEvent event) {
        context = event.getServletContext();
        String logPath = System.getenv("QFEQIF_LOG_FILE");
        System.setProperty("QFEQIF_LOG_FILE", logPath);
    }

    public void contextDestroyed(ServletContextEvent event) {
        context = event.getServletContext();
        AppMonitorIOFilePoll monitor = AppMonitorIOFilePoll.getInstance();
        Logger logger = QFEQIFLoggerIOFilePoll.getLogger(TriggerServletListenerIOFilePoll.class.getName());
        for(Handler h : logger.getHandlers()){
            h.close();  
        }
        monitor.stopPolling();
    }
}
