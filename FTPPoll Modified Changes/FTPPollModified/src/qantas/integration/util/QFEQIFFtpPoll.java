package qantas.integration.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import qantas.integration.util.ftp.QFEQIFFtpClient;


public class QFEQIFFtpPoll extends QFEQIFWorkflowBase {
    
	private static final Logger logger = QFEQIFLogger.getLogger(QFEQIFFtpPoll.class.getName());
    public static ArrayList<String> if_list = new ArrayList<String>();
    public static String temp_path = "";
    
    public static void readFromConfig() {
        Properties pro = new Properties();
        String configFilePath = "";
        FileInputStream fis = null;
        
        try {
            configFilePath = System.getenv("QFEQIF_CONFIG");
            fis = new FileInputStream(configFilePath);
            pro.load(fis);
            String interfaces = pro.getProperty("wf13.id.new");
            logger.info("interfaces to be polled are : " + interfaces);
            
            String[] list = interfaces.split(",");
            
            for(int i=0; i<list.length; i++) {
                if_list.add(i, list[i]);
            }
        } catch(FileNotFoundException fnfex) {
        	logger.log(Level.WARNING, "Config File not found ");
        	logger.log(Level.SEVERE, fnfex.getMessage(), fnfex);
        } catch(IOException ioex) {
        	logger.log(Level.WARNING, "Error reading IHub Config file ");
        	logger.log(Level.SEVERE, ioex.getMessage(), ioex);           
        }finally{
        	try{
        		if(null != fis){
            		fis.close();
            	}
        	}catch(Exception e){
        		logger.log(Level.WARNING, "Exception in readFromConfig() ");
            	logger.log(Level.SEVERE, e.getMessage(), e);
        	}
        	
        }
    }
    
    public static String[] getInterfacePath(String ifId) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String path = "";
        String fname = "";
        String[] rVal = new String[2];
        
        try {
            conn = QFEQIFDatabaseConn.getConnection();
            String sql = "select qif.file_path, qif.remote_filename from QFEQIF_INTERFACES qif where qif.if_id= '" + ifId + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                path = rs.getString(1) + "/incoming";
                fname = rs.getString(2);
            }
            rVal[0] = path;
            rVal[1] = fname;
        } catch(Exception e) {
        	logger.log(Level.WARNING, "Database read occurs while reading interface paths ");
        	logger.log(Level.SEVERE, e.getMessage(), e); 
            e.printStackTrace();
            } finally {
            	try{
            		if(null != stmt){
            			stmt.close();
            		}
            		if(null != rs){
            			rs.close();
            		}
            		if(null != conn){
                		conn.close();
                		QFEQIFDatabaseConn.closeConnection();
                	}
            		
            	}catch(Exception e){
            		logger.log(Level.WARNING, "Exception in getInterfacePath(String ifId) method while closing the resources ");
                	logger.log(Level.SEVERE, e.getMessage(), e);
            	}
            }
        
        return rVal;
    }
    
    public static List<Map<String, String>> getFTPPath(String ifId) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Map<String, String>> ftpDetails = new ArrayList<Map<String,String>>();
        try {
            conn = QFEQIFDatabaseConn.getConnection();
            StringBuffer sb = new StringBuffer();
            sb.append("select ftp.address, ftp.username, ftp.password, ftp.path, ftp.ftpport, ftp.ftpmode, ftp.attribute1, ftp.attribute2");
            sb.append(" from qfeqif_ftp_addr ftp");
            sb.append(" where ftp.id in (select addr_id from qfeqif_if_addr adr where adr.if_id='" + ifId + "'");
            sb.append(" and adr.addr_type='FTP')");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sb.toString());
            while(rs.next()) {
            	Map<String, String> map = new HashMap<String, String>();
                map.put("host", rs.getString(1));
                map.put("user", rs.getString(2));
                map.put("password", rs.getString(3));
                map.put("path", rs.getString(4));
                map.put("port", rs.getString(5));
                map.put("mode", getAttribValue(rs.getString(6)));
                map.put("attrib1", getAttribValue(rs.getString(7)));
                map.put("attrib2", getAttribValue(rs.getString(8)));
                ftpDetails.add(map);
            }
                
        } catch(Exception e) {
        	logger.log(Level.WARNING, "Exception occured in getFTPPath(String ifId) method ");
        	logger.log(Level.SEVERE, e.getMessage(), e);
            } finally {
            	try{
            		if(null != stmt){
                		stmt.close();
                	}
            		if(null != rs){
            			rs.close();
            		}
            		if(null != conn){
            			conn.close();
            			QFEQIFDatabaseConn.closeConnection();
            		}
                  
            	}catch(Exception e){
            		logger.log(Level.WARNING, "Exception occured in getFTPPath(String ifId) method while closing the resources ");
                	logger.log(Level.SEVERE, e.getMessage(), e);
            	}
            	
            }
        return ftpDetails;
    }
    
    public static void execute() {
        String[] if_detl = new String[] {};
        List<Map<String, String>> ftpDetails = new ArrayList<Map<String,String>>();
        Connection conn= null;
        Statement stmt = null;
        ResultSet rs = null;
        
        String ifsAdminUser = "";
        String ifsAdminPwd = "";
        String ifsService = "";
        String ifsSysPwd = "";
        
        String wfFtpHost = "";
        String wfFtpPort = "";
        String wfFtpUser = "";
        String wfFtpPwd = "";
        String wfFtpPath = "";
        String attrib1 = "";
        String attrib2 = "";
        String xferMode = "";
        String fmodTime = "";
        
        String TARGET_FOLDER = "";
        String remoteFileName = "";
        
        try {
            conn = QFEQIFDatabaseConn.getConnection();
            String sql = "select * from qfeqif_properties qfe where qfe.name in ('IFS_ADMIN_USER','IFS_ADMIN_PWD','IFS_SERVICE','IFS_SYS_PWD')";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                String name = rs.getString("NAME").trim();
                String value = rs.getString("VALUE").trim();
                if(name.equals("IFS_ADMIN_USER")) {
                    ifsAdminUser = value;
                }
                if(name.equals("IFS_ADMIN_PWD")) {
                    ifsAdminPwd = value;
                }
                if(name.equals("IFS_SERVICE")) {
                    ifsService = value;
                }
                if(name.equals("IFS_SYS_PWD")) {
                    ifsSysPwd = value;
                }
            }
            
            Iterator<String> itr = if_list.iterator();
            logger.info("List of interface Ids :" + if_list);
            while(itr.hasNext()) {
                String ifId = itr.next().toString();
                logger.info("Current interface :: " + ifId);
                if_detl = getInterfacePath(ifId);
                
                TARGET_FOLDER = if_detl[0];
                remoteFileName = getAttribValue(if_detl[1]);
                
                ftpDetails = getFTPPath(ifId);
                
                for(Map<String, String> ftp_detl : ftpDetails){
                	
                	/*if(("LOCALPATH").equalsIgnoreCase(ftp_detl.get("path").toString()))
                    {
                    	processDirectInterface(conn,TARGET_FOLDER,ifId);
                    }
                	else {*/
                	 
                	 
                	wfFtpHost = ftp_detl.get("host").toString();
                    wfFtpPort = ftp_detl.get("port").toString();
                    wfFtpUser = ftp_detl.get("user").toString();
                    wfFtpPwd = ftp_detl.get("password").toString();
                    wfFtpPath = ftp_detl.get("path").toString();
                    attrib1 = ftp_detl.get("attrib1").toString();
                    attrib2 = ftp_detl.get("attrib2").toString();
                    xferMode = ftp_detl.get("mode").toString();
                    
                    
                    
                    try {
                        QFEQIFFtpGetFirstFileName FirstFile = new QFEQIFFtpGetFirstFileName();
                        String fname = FirstFile.execute(remoteFileName, wfFtpHost, wfFtpPort, wfFtpUser, wfFtpPwd, wfFtpPath, attrib1, attrib2, xferMode);
                        if(fname != null && !fname.endsWith(".filepart")) {
                        	logger.info("Polling started for file " + fname);
                            QFEQIFCryptoSOA crypto = new QFEQIFCryptoSOA(QFEQIFDatabaseConn.getConnection());
                            QFEQIFFtpClient ftpClient = new QFEQIFFtpClient(true, true);
                            boolean l_isConnected = ftpClient.connect(wfFtpHost, Integer.parseInt(wfFtpPort), wfFtpUser, crypto.decrypt(wfFtpPwd));
                            
                            if(l_isConnected) {
                                ftpClient.changeDir(wfFtpPath);
                                fmodTime = ftpClient.MDMT(fname);
                                fmodTime = fmodTime.trim().substring(4, fmodTime.length());
                                if(fmodTime.length() != 14){
                                	fmodTime = ftpClient.MDMT(fname);
                                	fmodTime = fmodTime.trim().substring(4, fmodTime.length());
                                }
                            }
                            ftpClient.logout();
                            
                            if(fmodTime.length() != 14){
                            	throw new Exception("Could not able to get a proper file modification date");
                            }
                            
                            QFEQIFFileLockingUtility fileService = new QFEQIFFileLockingUtility();
                            if(fileService.getLock(fname, fmodTime, ifId)) {
                                try {
                                    logger.info("File available for download to eQ");
                                    QFEQIFFtpGetFile GetFile = new QFEQIFFtpGetFile();
                                    boolean rVal = GetFile.execute(fname, TARGET_FOLDER, ifsAdminUser, ifsAdminPwd, ifsService, ifsSysPwd, wfFtpHost, wfFtpPort, wfFtpUser, wfFtpPwd, wfFtpPath, attrib1, attrib2, xferMode);
                                    
                                    if(rVal) {
                                    	//logger.info(fname + " is successfully uploaded to CMSDK");
                                    	logger.info(fname + " is successfully uploaded");
                                        QFEQIFFtpDeleteFile DeleteFile = new QFEQIFFtpDeleteFile();
                                        DeleteFile.execute(fname, wfFtpHost, wfFtpPort, wfFtpUser, wfFtpPwd, wfFtpPath, attrib1, attrib2, xferMode);
                                        logger.info(fname + " is deleted from interface " + ifId);
                                        fileService.releaseLock(fname, fmodTime, QFEQIFConstant.FTP_DOWNLOAD_SUCCESS);
                                        logger.info("Lock has been released from " + fname);
                                      //  processDirectInterface(conn,TARGET_FOLDER,ifId);
                                    }else{
                                        fileService.deleteFileEntry(fname, fmodTime, ifId);
                                        logger.info(fname + " is successfully deleted from locking table");
                                    }
                                } catch (Exception ex) {
                                	logger.log(Level.WARNING, "Error getting/deleting the file");
                                	logger.log(Level.SEVERE, ex.getMessage(), ex);
                                	fileService.deleteFileEntry(fname, fmodTime, ifId);
                                	logger.info(fname + " is successfully deleted from locking table");
                                }
                            } else {
                                logger.info("File Already Read.");
                            }
                        }
                    } catch (Exception e) {
                    	logger.log(Level.WARNING, "Caught FTP Exception for " + ifId);
                    	logger.log(Level.SEVERE, e.getMessage(), e);
                    }
                   /* try {
                    processDirectInterface(conn,TARGET_FOLDER,ifId);
                    }
                    catch(Exception e)
                    {
                    	logger.log(Level.WARNING, "Error in processDirectInterface method ");
                    	logger.log(Level.SEVERE, e.getMessage(), e);
                    }*/
               // }
                } 
            }
        } catch (Exception e) {
        	logger.log(Level.WARNING, "Error in execute ");
        	logger.log(Level.SEVERE, e.getMessage(), e);
            } finally {
            	try{
            		if(null != stmt){
            			stmt.close();
            		}
            		if(null != rs){
            			rs.close();
            		}
            		if(null != conn){
            			conn.close();
            			QFEQIFDatabaseConn.closeConnection();
            		}
            	}catch(Exception e){
            		logger.log(Level.WARNING, "Excpetion occured while closing the resources ");
                	logger.log(Level.SEVERE, e.getMessage(), e);
            	}  
            }
        
    }
    
    private static void processDirectInterface(Connection conn, String loc, String ifId) {
    	
    	logger.info(ifId + " is the current ifId");
    	logger.info(loc + " is the location ");
		//String location = "/u02_psp_soa_ap/DATA" + loc; //923018- Commented for SIT
    	String location = loc;
        File folder = new File(location);
        File[] listOfFiles = folder.listFiles();
        if(null != listOfFiles)
        {
        for(File file : listOfFiles)
        {
        	
        	String fname = file.getName();
        	logger.info(fname + " is the current file name");
        	QFEQIFDirectFileLockingUtility fService = new QFEQIFDirectFileLockingUtility();     
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            String fmod = sdf.format(file.lastModified());
        	if(fService.getLock(fname,fmod,ifId)) {
        		try {
        		conn = QFEQIFDatabaseConn.getConnection();
        		int rtVal = insertSoaQueue(conn, fname, ifId, loc);
        		logger.info("Return Value " + rtVal);
        		if(rtVal == 0) {
        			fService.releaseLock(fname, fmod, QFEQIFConstant.FTP_DOWNLOAD_SUCCESS);
                    logger.info("Lock has been released from " + fname);
        		}
        		else {
        			logger.info(fname + " was unable to process from stored Procedure");
        			fService.deleteFileEntry(fname, fmod, ifId);
                	logger.info(fname + " is successfully deleted from locking table");
        		}
        			
                
        		}
        		catch (Exception ex) {
                	logger.log(Level.WARNING, "Error getting/deleting the file");
                	logger.log(Level.SEVERE, ex.getMessage(), ex);
                	fService.deleteFileEntry(fname, fmod, ifId);
                	logger.info(fname + " is successfully deleted from locking table");
                }
        	
        	}
        	else {
                logger.info("File Already Read.");
            }
            
        }
        }
	}

	private static int insertSoaQueue(Connection conn, String fname, String ifId, String location) {

        CallableStatement cstmt = null;
        int rtnVal = 0;
        try {
    	cstmt = conn.prepareCall ("{? = call QFEQIF_CMSDK_WF_PKG.NewFile (?, ?, ?, ?)}");
    	cstmt.registerOutParameter (1, Types.INTEGER);
    	cstmt.setString (2, fname);
        cstmt.setString (3, ifId); 
        cstmt.setString (4, location);
        cstmt.setInt(5, 0);
        cstmt.execute();
        logger.info(fname + " corresponding procedure has been executed");
        rtnVal = cstmt.getInt(1);
        }
        catch(Exception e)
        {
        	logger.log(Level.WARNING, "Error in insertQueue ");
        	logger.log(Level.SEVERE, e.getMessage(), e);
        	rtnVal = -1;
        }
        finally {
        	if(null != cstmt){
    			try {
					cstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
    		}
        }
		
		return rtnVal;
	}

	public static boolean checkFilePattern(String fname, String regex) {
        if(regex!= null) {
            if(regex.trim().equals("")){
                return true;
            } else {
                regex = regex.replace(".", "\\.").replace("*", ".*");
                final Pattern pattern = Pattern.compile(regex);
                return pattern.matcher(fname).matches();
            }
        } else {
            return true;
        }
    }
    
    /**
     * Returns the attribute value.
     * @param p_attrib the attrib name
     * @return the attrib value or blank
     */
     
     public static String getAttribValue(String p_attrib)
     {
        String attribVal = QFEQIFConstant.BLANK;
        try {
            attribVal = QFEQIFUtil.toBlank(p_attrib);
        } catch(Exception e) {
        }
        return attribVal;
     }
    
    private static String stackTraceToString(Throwable e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
            readFromConfig();
            execute();
    }
}
