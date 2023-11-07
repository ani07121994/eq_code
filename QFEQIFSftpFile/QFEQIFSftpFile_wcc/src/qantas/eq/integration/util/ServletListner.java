package qantas.eq.integration.util;

import java.util.logging.Handler;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @purpose ServletListner listener handles the context initialized and the context 
 *          destroy event and perform some operations
 *          
 * @author  Tata Consultancy Services
 * 
 * @version 1.0
 *
 */
public class ServletListner implements ServletContextListener{
	
	private ServletContext context = null;

	/**
	 * This method will close all the log handler to delete .lck files from the log folder
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		context = event.getServletContext();
		Logger logger = QFEQIFSftpLogger.getLogger(ServletListner.class.getName());
        for(Handler h : logger.getHandlers()){
            h.close();  
        }
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
