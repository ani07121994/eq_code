package qantas.eq.integration.util;

import java.util.Hashtable;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @purpose QFEQIFSftpLogger class contains all the required utility methods for
 *          application logging
 *          
 * @author  Tata Consultancy Services
 * 
 * @version 1.0
 *
 */
public class QFEQIFSftpLogger {
	
	private static final String LOG_FILE_NAME        = "QFEQIFSftpFilewcc.%g.log";
	private static final int maxLogFileSize          = 100000000;
	private static final int maxBkupIndex            = 5;
    private static Hashtable<String, Logger> loggers = new Hashtable<String, Logger>();
    private static FileHandler handler               = null;
    
    /**
     * This method will retun a logger instance for logging purpose 
     * @param  loggerName
     * @return logger (java.util.logger instance)
     */
    public static Logger getLogger(String loggerName){
    	if(loggers.get(loggerName) != null)
            return (Logger)loggers.get(loggerName);
    	
    	try{
    		
    		if(handler == null){
    			boolean append = false;
    			handler = new FileHandler((new StringBuilder()).append(System.getenv("QFEQIF_LOG_FILE")).append("/").append(LOG_FILE_NAME).toString(), maxLogFileSize, maxBkupIndex, append);
                //handler = new FileHandler(LOG_FILE_NAME, maxLogFileSize, maxBkupIndex, append);
                System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tb %1$td, %1$tY %1$tl:%1$tM:%1$tS %1$Tp %2$s%n%4$s: %5$s%n");
                handler.setFormatter(new SimpleFormatter());
            }
    		
    	}catch(Exception e){
    		
    		e.printStackTrace();
    		
    	}
    	
    	Logger logger = Logger.getLogger(loggerName);
        logger.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
        loggers.put(loggerName, logger);
        return logger;
    }

}
