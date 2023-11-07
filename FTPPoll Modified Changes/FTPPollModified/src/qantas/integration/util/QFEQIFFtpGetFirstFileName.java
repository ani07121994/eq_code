//
// Copyright (c) 2002 Oracle Corp
// System       : eQ
// Subsystem    : Integration
// File         : QFEQIFFtpGetFirstFileName.java
// Classes      : QFEQIFFtpGetFirstFileName
//
// Change History
// Date     Version	Author      Description
// ----     ------- ------      ------------
// 03/02/04	1.2	    Luke Lam    Created.
//

package qantas.integration.util;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Socket;
import java.sql.Connection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import qantas.integration.util.ftp.QFEQIFFtpClient;


/**
 * The QFEQIFFtpGetFirstFileName class extends the WFFunctionAPI class.
 * It returns the first file name in the current directory.
 *
 * @author Oracle Consulting
 * @version $version$
 *
 * @see QFEQIFMoveFile
 */
public class QFEQIFFtpGetFirstFileName extends QFEQIFWorkflowBase
{
    //private static final Logger logger = Logger.getLogger("fout");
	private static final Logger logger = QFEQIFLogger.getLogger(QFEQIFFtpGetFirstFileName.class.getName());
    private final String CLASS_NAME = getClass().getName();
    private static String resultOut = "";

    /**
    * It returns the first file name in the current directory.
    * This method is the main entry point to call Oracle 9iFS APIs.
    *
    * @param p_WCtx the workflow context
    * @return true if it executes successfully.
    */
    
    public String execute(String remoteFileName, String wfFtpHost, String wfFtpPort, String wfFtpUser, String wfFtpPwd, String wfFtpPath, String attrib1, String attrib2, String xferMode)
    {
        final String METHOD_NAME = CLASS_NAME + ".execute";
        logger.info(QFEQIFConstant.ENTER + METHOD_NAME);
        
        String fname = null;
        resultOut = QFEQIFConstant.WF_FTP_RCODE_SUCCESS;
        
        //get crypto instance for pwd decryption
        Connection conn = QFEQIFDatabaseConn.getConnection();
        QFEQIFCryptoSOA crypto = new QFEQIFCryptoSOA(conn);
        Socket sock = null;
        QFEQIFFtpClient ftpClient = null;
        LineNumberReader reader = null;
        InputStreamReader ir = null;
        
        try
        {
            //ftp get the file first
            ftpClient = new QFEQIFFtpClient(isBinaryXfer(xferMode), isPassive(attrib1));
            boolean l_isConnected = ftpClient.connect(wfFtpHost, Integer.parseInt(wfFtpPort), wfFtpUser, crypto.decrypt(wfFtpPwd));
    
            if(l_isConnected) {
                if(!wfFtpPath.equals(QFEQIFConstant.BLANK))
                {
                    if(!ftpClient.changeDir(wfFtpPath))
                        resultOut = QFEQIFConstant.WF_FTP_RCODE_ERROR;
                }
            
                //get the socket for file retrieve
                sock = ftpClient.getDataSocket(ftpClient.FTP_CMD_LIST + remoteFileName);
                
                if(sock != null) {
                    // Read bytes from server
                	ir = new InputStreamReader(sock.getInputStream());
                    reader = new LineNumberReader(ir);
                    
                    // Just get the first file
                    fname = reader.readLine();
                
                    if(fname != null && !fname.endsWith(".filepart"))
                    {
                        logger.info("Remote file: "+fname);
                        if(isInTransitFile(fname, ftpClient, wfFtpPath)){
                        	fname = null;
                        }
                    }
                    else {
                        logger.info("There isn't any remote file!");
                        resultOut = QFEQIFConstant.WF_FTP_RCODE_ERROR;
                    }
                    //sock.close();
                } 
                else // can't get/find the specified file. 
                {
                    logger.info("Cannot get/find the remote file name");
                    resultOut = QFEQIFConstant.WF_FTP_RCODE_ERROR;
                }
                //ftpClient.logout();
            } 
            else //ftp connect fails
            {
                resultOut = QFEQIFConstant.WF_FTP_RCODE_FTP_ERROR;
            }
        } catch (Exception e) {
            resultOut = QFEQIFConstant.WF_FTP_RCODE_ERROR;
            logger.info("Exception caught: "+e.getMessage());
        }finally{
        	try{
        		if(null != ir){
        			ir.close();                 // Closing InputStreamReader
        		}
        		if(null != sock){				// Closing socket
            		sock.close();
            	}
        		if(null != ftpClient){			// Logout from FTP Client
        			ftpClient.logout();
        		}
        		if(null != reader){				// Closing BufferedReader
        			reader.close();
        		}
        		if(null != conn){				// Closing DB connection
        			conn.commit();
        			conn.close();
        			QFEQIFDatabaseConn.closeConnection();
        		}
        	}catch(Exception e){
        		logger.info("Method Name :" + METHOD_NAME);
        		logger.log(Level.WARNING, "Exception occured while closing resources ");
            	logger.log(Level.SEVERE, e.getMessage(), e);
        	}
        	
        }
    
        logger.info("resultOut: "+resultOut);
        logger.info(QFEQIFConstant.EXIT + METHOD_NAME);
        return fname;
    }
    
    /**
     * This method will check if a file is complete or in transit in a ftp server
     * @param  fileName
     * @param  ftpClient
     * @param  wfFtpPath
     * @return true  (If file is in transit)
     *         false (If file is complete)
     */
    public boolean isInTransitFile(String fileName, QFEQIFFtpClient ftpClient, String wfFtpPath){
    	boolean isModified = true;
    	try{
    		logger.info("Started checking if the file is in transit...");
    		int count     = Integer.parseInt(getPropertyValue("retry.count"));
    		logger.info("Count = " + count);
    		long sleepTime = Long.parseLong(getPropertyValue("retry.time"));
    		logger.info("Retry time = " + sleepTime);
    		String fmodTime1 = getFileModificationTime(fileName, ftpClient, wfFtpPath);
    		
            for(int i=1; i<=count; i++){
            	logger.info("Starting intransit file checking iteration count " + i);
            	logger.info("File last modified time before wait " + fmodTime1);
            	logger.info("Going to wait for " + sleepTime/1000 + " second");
            	Thread.sleep(sleepTime);
            	String fmodTime2 = getFileModificationTime(fileName, ftpClient, wfFtpPath);
            	logger.info("File last modified time after wait " + fmodTime2);
            	if(null != fmodTime1 && null != fmodTime2){
            		if(fmodTime1.equals(fmodTime2)){
            			logger.info("File is not modified...");
            			isModified = false;
            		}else{
            			logger.info("File is modified...");
            			fmodTime1 = fmodTime2;
            			isModified = true;
            		}
            	}else{
            		logger.info("File modification time is NULL which is not expected.");
            		break;
            	}
            	logger.info("Ending intransit file checking iteration count " + i);
            }
            
    	}catch(Exception ex){
    		logger.log(Level.WARNING, "Exception occured in isInTransitFile(String fileName, QFEQIFFtpClient ftpClient, String wfFtpPath) method");
        	logger.log(Level.SEVERE, ex.getMessage(), ex);
    		return isModified;
    	}
    	
    	logger.info("Returning file modication flag as " + isModified);
    	return isModified;
    	
    }
    
    /**
     * This method will get a property value from the ihub.properties file
     * @param keyValue
     * @return value (Value of the property from the ihub.properties)
     */
    public String getPropertyValue(String keyValue){
    	String value = null;
    	FileInputStream fis = null;
    	try{
    		Properties pro = new Properties();
        	String configFilePath = System.getenv("QFEQIF_CONFIG");
        	fis = new FileInputStream(configFilePath);
        	pro.load(fis); 
        	value = pro.getProperty(keyValue);
    	}catch(Exception ex){
    		logger.log(Level.WARNING, "Exception occured in getPropertyValue(String keyValue)  ");
        	logger.log(Level.SEVERE, ex.getMessage(), ex);
    	}finally{
    		try{
    			if(null != fis){
        			fis.close();
        		} 
    		}catch(Exception e){
    			logger.log(Level.WARNING, "Exception occured in getPropertyValue(String keyValue)");
            	logger.log(Level.SEVERE, e.getMessage(), e);
    		}
    	}
    	
    	return value;
    }
    
    /**
     * This method will return the last modification time of a file in the ftp server
     * @param  fileName
     * @param  ftpClient
     * @param  wfFtpPath
     * @return fmodTime (Last modification time of the file in the ftp server)
     */
    public String getFileModificationTime(String fileName, QFEQIFFtpClient ftpClient, String wfFtpPath){
    	String fmodTime = null;
    	try{
            fmodTime = ftpClient.MDMT(fileName);
            if((fmodTime.trim().substring(4, fmodTime.length())).length() != 14){
            	fmodTime = ftpClient.MDMT(fileName);
            }
            fmodTime = fmodTime.trim().substring(4, fmodTime.length());
            if(fmodTime.length() != 14){
            	fmodTime = null;
            	throw new Exception("Could not get a valid file modification time");
            }
    	}catch(Exception e){
    		logger.log(Level.WARNING, "Exception occured in getFileModificationTime(String fileName, QFEQIFFtpClient ftpClient, String wfFtpPath) ");
        	logger.log(Level.SEVERE, e.getMessage(), e);
    	}
    	
    	return fmodTime;
    }
}

