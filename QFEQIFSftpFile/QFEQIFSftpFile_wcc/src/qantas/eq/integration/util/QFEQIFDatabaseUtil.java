package qantas.eq.integration.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * @purpose QFEQIFDatabaseUtil class contains all the required utility methods to
 *          communicate with the database server 
 *          
 * @author  Tata Consultancy Services
 * 
 * @version 1.0
 *
 */
public class QFEQIFDatabaseUtil {
	
    private static Connection connect;
    private static QFEQIFDatabaseUtil instance;
    private static final Logger logger = QFEQIFSftpLogger.getLogger(QFEQIFDatabaseUtil.class.getName());
	
    /**
     * This constructor used to create a connection to the database when called
     */
	private QFEQIFDatabaseUtil(){
		
        try{
        	
            String configFile = System.getenv("QFEQIF_CONFIG");
            Properties pro = new Properties();
            pro.load(new FileInputStream(configFile));
            String dsName = pro.getProperty("IHUB_DATA_SOURCE");
            
            Context ic = new InitialContext();
            DataSource ds = (DataSource)ic.lookup(dsName);
            connect = ds.getConnection();
            logger.info("Database connection opened");
            
        }catch(Exception exception){
        	
        	logger.log(Level.WARNING,"SQl Exception occured");
			logger.log(Level.SEVERE, exception.getMessage(), exception);
            
        }
	}
	
	/**
	 * This method is called to return a database connection
	 * @return connect (Database connection)
	 */
    public static Connection getConnection(){
        if(instance  == null){
            instance = new QFEQIFDatabaseUtil();
        }
        
        logger.info("Database connection returned");
        
        return connect;
    }
    
    /**
     * This method close any open database connection
     */
    public static void closeConnection() {  
        try{
        	
            if(instance != null){
                connect.close();
                instance  = null;
            }
            
            logger.info("Database connection closed");
            
        }catch(SQLException e){
        	
        	logger.log(Level.WARNING,"SQl Exception occured");
			logger.log(Level.SEVERE, e.getMessage(), e);
			
        }
     }

}
