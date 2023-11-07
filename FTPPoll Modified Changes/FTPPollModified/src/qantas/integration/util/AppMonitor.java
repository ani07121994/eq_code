package qantas.integration.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppMonitor {

    private static final AppMonitor instance = new AppMonitor();
    private static Properties eQIhubProperty = new Properties();
    private static long defaultScheduleDelay = 0;  
    
    private static final Logger logger = QFEQIFLogger.getLogger(AppMonitor.class.getName());
    
    private Timer timer;  
    static FTPPollTask task = null; 
    
    public static AppMonitor getInstance() {
    	FileInputStream fis = null;
        try {
        	fis = new FileInputStream(System.getenv("QFEQIF_CONFIG"));
            eQIhubProperty.load(fis);
            defaultScheduleDelay = Long.parseLong(eQIhubProperty.getProperty("FTP_POLLING_INTERVAL"));
        } catch (Exception e) {
        	logger.log(Level.WARNING, "Error setting Log file location ");
        	logger.log(Level.SEVERE, e.getMessage(), e);
        }finally{
        	try{
        		if(null != fis)
        			fis.close();
        	}catch(Exception e){
        		logger.log(Level.WARNING, "Error in closing the property file");
        		logger.log(Level.SEVERE, e.getMessage(), e);
        	}
        }
        return instance;
    }
    
    protected AppMonitor() {
        timer = new Timer(true);
    }
    
    public void startPolling() {
    	logger.info("***********File polling started***********");
        try {
            QFEQIFFtpPoll.readFromConfig();
            task = new FTPPollTask();
            timer.schedule(task, 5*1000, defaultScheduleDelay);   
        } catch (Exception e) {
        	logger.log(Level.WARNING, "Exception in startPolling() method ");
        	logger.log(Level.SEVERE, e.getMessage(), e);
        } 
    }
    
    public void stopPolling() {
        if(task != null) {
        	logger.info("***********File polling stopped***********");
            task.cancel();
        }
    }
}
