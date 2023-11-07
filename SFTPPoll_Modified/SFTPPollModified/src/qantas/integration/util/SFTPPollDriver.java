package qantas.integration.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SFTPPollDriver {
	
	private static final Logger logger = SFTPLogger.getLogger(SFTPPollDriver.class.getName());
	
	private static final SFTPPollDriver instance   = new SFTPPollDriver();
	private static Properties eQIhubProperty       = new Properties();
	static SFTPPollTask task                       = null;
	private static long defaultScheduleDelay       = 0; 
	
	private Timer timer;
	
	protected SFTPPollDriver(){
		timer = new Timer(true);
	}
	
	public static SFTPPollDriver getInstance() {
		FileInputStream fis = null;
		try {
			logger.info(System.getenv("QFEQIF_CONFIG"));
			fis = new FileInputStream(System.getenv("QFEQIF_CONFIG"));
			eQIhubProperty.load(fis);
			defaultScheduleDelay = Long.parseLong(eQIhubProperty.getProperty("FTP_POLLING_INTERVAL"));
			logger.info("defaultScheduleDelay - " + defaultScheduleDelay);
		}
		catch(Exception e) {
			logger.log(Level.WARNING, "Error reading ihub.properties");
        	logger.log(Level.SEVERE, e.getMessage(), e);
		}finally {
			try{
        		if(null != fis)
        			fis.close();
        	}catch(Exception e){
        		logger.log(Level.WARNING, "Error in closing the property file");
        		logger.log(Level.SEVERE, e.getMessage(), e);
        	}
		}
		
		logger.info("SFTPPollDriver Instance created");
		return instance;
	}
	
	public void startPolling() {
    	logger.info("***********SFTP polling started***********");
        try {
            SFTPPoll.readFromConfig();
            task = new SFTPPollTask();
            timer.schedule(task, 5*1000, defaultScheduleDelay);   
        } catch (Exception e) {
        	logger.log(Level.WARNING, "Exception in startPolling() method ");
        	logger.log(Level.SEVERE, e.getMessage(), e);
        } 
    }
	
	public void stopPolling() {
        if(task != null) {
        	logger.info("***********SFTP polling stopped***********");
            task.cancel();
        }
    }

}
