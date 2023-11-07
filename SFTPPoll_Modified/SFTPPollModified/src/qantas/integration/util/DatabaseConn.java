package qantas.integration.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatabaseConn {
	
    private static Connection connect;
    private static DatabaseConn instance;
    private static final Logger logger = SFTPLogger.getLogger(DatabaseConn.class.getName());
    private DatabaseConn()
    {
    	FileInputStream fis = null;
        try {
            String configFile = System.getenv("QFEQIF_CONFIG");
            Properties pro = new Properties();
            fis = new FileInputStream(configFile);
            pro.load(fis);
            String dsName = pro.getProperty("IHUB_DATA_SOURCE");
            
            Context ic = new InitialContext();
            DataSource ds = (DataSource)ic.lookup(dsName);
            connect = ds.getConnection();
            logger.info("Successfully created database connection.");
        } catch(Exception fnf) {
            System.err.println(fnf.getMessage());
            logger.log(Level.WARNING, "Exception while creating database conncetion ");
        	logger.log(Level.SEVERE, fnf.getMessage(), fnf);
        }finally{
        	try{
        		if(null != fis){
            		fis.close();
            	}
        	}catch(Exception e){
        		logger.log(Level.WARNING, "Exception while closing the property file ");
            	logger.log(Level.SEVERE, e.getMessage(), e);
        	}
        	
        }
    
    }
    
    public static Connection getConnection()
    {
    
      if(instance  == null) {
    
          instance=new DatabaseConn();
      }
    
      return connect;
    }
    
    public static void closeConnection() 
    {  
        try {
            if (instance != null)
            {
                connect.close();
                instance  = null;
                logger.info("Successfully closed database connection.");
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
            logger.log(Level.WARNING, "Exception while closing database conncetion ");
        	logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
