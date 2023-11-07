package qantas.integration.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppMonitorIOFilePoll {

    private static final AppMonitorIOFilePoll instance = new AppMonitorIOFilePoll();
    private static Properties eQIhubProperty = new Properties();
    private static long defaultScheduleDelay = 0;  
    
    private static final Logger logger = QFEQIFLoggerIOFilePoll.getLogger(AppMonitorIOFilePoll.class.getName());
    
    private Timer timer;  
    static FTPPollTaskIOFilePoll task = null; 
    
    public static AppMonitorIOFilePoll getInstance() {
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
    
    protected AppMonitorIOFilePoll() {
        timer = new Timer(true);
    }
    
    public void startPolling() {
    	logger.info("***********File polling started***********");
        try {
            QFEQIFFtpPollIOFilePoll.readFromConfig();
            task = new FTPPollTaskIOFilePoll();
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
