package qantas.integration.util.servlet;

import java.util.logging.Handler;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import qantas.integration.util.SFTPLogger;
import qantas.integration.util.SFTPPollDriver;

/**
 * Application Lifecycle Listener implementation class TriggerServletListner
 *
 */
public class TriggerServletListner implements ServletContextListener {
	
	private ServletContext context = null;
	
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event) {
    	context = event.getServletContext();
    	
    	SFTPPollDriver sftpPoll = SFTPPollDriver.getInstance();
        Logger logger = SFTPLogger.getLogger(TriggerServletListner.class.getName());
        
        for(Handler h : logger.getHandlers()) {
            h.close();  
        }
        
        sftpPoll.stopPolling();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
    	context = event.getServletContext();
    }
	
}
