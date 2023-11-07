package qantas.integration.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;


public class SFTPPoll {
	
	private static final Logger logger = SFTPLogger.getLogger(SFTPPoll.class.getName());
	
    public static ArrayList<String> interfaceList = new ArrayList<String>();
    
	public static void readFromConfig() {
        Properties pro        = new Properties();
        FileInputStream fis   = null;
        
        try {
            fis = new FileInputStream(System.getenv("QFEQIF_CONFIG"));
            pro.load(fis);
            
            String interfaces = pro.getProperty("wf13.id.sftp");
            logger.info("interfaces to be polled are : " + interfaces);
            
            String[] list = interfaces.split(",");
            
            for(int i=0; i<list.length; i++) {
            	interfaceList.add(i, list[i]);
            }
        } 
        catch(FileNotFoundException fnfex) {
        	logger.log(Level.WARNING, "Config File not found ");
        	logger.log(Level.SEVERE, fnfex.getMessage(), fnfex);
        } 
        catch(IOException ioex) {
        	logger.log(Level.WARNING, "Error reading IHub Config file ");
        	logger.log(Level.SEVERE, ioex.getMessage(), ioex);           
        }
        finally {
        	try {
        		if(null != fis) {
            		fis.close();
            	}
        	}
        	catch(Exception e) {
        		logger.log(Level.WARNING, "Exception in readFromConfig() ");
            	logger.log(Level.SEVERE, e.getMessage(), e);
        	}
        	
        }
    }
	
	public static String[] getInterfacePath(String ifId) {
		Connection conn        = null;
        PreparedStatement stmt = null;
        ResultSet rs           = null;
        
        String path   = "";
        String fname  = "";
        String[] rVal = new String[2];
        
        try {
            conn = DatabaseConn.getConnection();
            stmt = conn.prepareStatement("select qif.file_path, qif.remote_filename from QFEQIF_INTERFACES qif where qif.if_id = ?");
            stmt.setString(1, ifId);
            rs = stmt.executeQuery();
            while(rs.next()) {
                path = rs.getString(1) + "/incoming";
                fname = rs.getString(2);
            }
            rVal[0] = path;
            rVal[1] = fname;
        } 
        catch(Exception e) {
        	logger.log(Level.WARNING, "Database read occurs while reading interface paths ");
        	logger.log(Level.SEVERE, e.getMessage(), e);
        } 
        finally {
            	try{
            		if(null != stmt){
            			stmt.close();
            		}
            		if(null != rs){
            			rs.close();
            		}
            		if(null != conn){
                		conn.close();
                		DatabaseConn.closeConnection();
                	}
            	}
            	catch(Exception e) {
            		logger.log(Level.WARNING, "Exception in getInterfacePath(String ifId) method while closing the resources ");
                	logger.log(Level.SEVERE, e.getMessage(), e);
            	}
            }
        
        return rVal;
	}
	
	public static List<Map<String, String>> getFTPPath(String ifId) {
        Connection conn        = null;
        PreparedStatement stmt = null;
        ResultSet rs           = null;
        
        List<Map<String, String>> sftpDetails = new ArrayList<Map<String,String>>();
        
        try {
            conn = DatabaseConn.getConnection();
       
            //stmt = conn.prepareStatement("select sftp.address, sftp.username, sftp.password, sftp.path, sftp.ftpport, sftp.attribute1 from qfeqif_ftp_addr sftp where sftp.id in (select addr_id from qfeqif_if_addr adr where adr.if_id = ? and adr.addr_type = ?)");
            stmt = conn.prepareStatement("select sftp.address, sftp.username, sftp.password, sftp.path, sftp.sftpauthtype, sftp.sftpport, sftp.sftp_ssh_key from qfeqif_sftp_addr sftp  where sftp.id in (select addr_id from qfeqif_if_addr adr where adr.if_id = ? and adr.addr_type = ?)");
            stmt.setString(1, ifId);
            stmt.setString(2, "SFTP");
            rs = stmt.executeQuery();
            while(rs.next()) {
            	Map<String, String> map = new HashMap<String, String>();
                map.put("host", rs.getString(1));
                map.put("user", rs.getString(2));
                map.put("password", rs.getString(3));
                map.put("path", rs.getString(4));
                map.put("authType", rs.getString(5));
                map.put("port", rs.getString(6));
                map.put("sshKey", rs.getString(7));
                sftpDetails.add(map);
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
            			DatabaseConn.closeConnection();
            		}
                  
            	}catch(Exception e){
            		logger.log(Level.WARNING, "Exception occured in getFTPPath(String ifId) method while closing the resources ");
                	logger.log(Level.SEVERE, e.getMessage(), e);
            	}
            	
            }
        return sftpDetails;
    }
	
	public static void execute() {
        String[] ifDetl                     = new String[] {};
        List<Map<String, String>> ftpDetails = new ArrayList<Map<String,String>>();
       
        Connection conn         = null;
        PreparedStatement stmt  = null;
        ResultSet rs            = null;
        Session session         = null;
        Channel channel         = null;
		ChannelSftp channelSftp = null;
        
        String ifsAdminUser = "";
        String ifsAdminPwd  = "";
        String ifsService   = "";
        String ifsSysPwd    = "";
        
        String sftpHost   = "";
        String sftpPort   = "";
        String sftpUser   = "";
        String sftpPwd    = "";
        String sftpPath   = "";
        String sftpMode   = "";
        String fmodTime   = "";
        String sftpSSHKey = "";
        
        String targetFolder  = "";
        String remoteFileName = "";
        
        try {
            conn = DatabaseConn.getConnection();
            stmt = conn.prepareStatement("select * from qfeqif_properties qfe where qfe.name in ('IFS_ADMIN_USER','IFS_ADMIN_PWD','IFS_SERVICE','IFS_SYS_PWD','SFTP_SSH_KEY')");
            rs = stmt.executeQuery();
            
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
                /*if(name.equals("SFTP_SSH_KEY")) {
                    sftpSSHKey = value;
                }*/
            }
            
            Iterator<String> itr = interfaceList.iterator();
            logger.info("List of interface Ids :" + interfaceList);
            while(itr.hasNext()) {
                String ifId = itr.next().toString();
                logger.info("Current interface :: " + ifId);
                
                ifDetl = getInterfacePath(ifId);
              //  targetFolder = "/u02_psp_soa_ap/DATA" + ifDetl[0];
                targetFolder = ifDetl[0];
                String procedurePath = ifDetl[0];
                remoteFileName = getAttribValue(ifDetl[1]);
                
                ftpDetails = getFTPPath(ifId);
                for(Map<String, String> ftp_detl : ftpDetails){
                	
                	
                	sftpHost = ftp_detl.get("host").toString();
                	sftpPort = ftp_detl.get("port").toString();
                	sftpUser = ftp_detl.get("user").toString();
                	if(ftp_detl.get("password") != null && ftp_detl.get("password") != "")
                	{
                		sftpPwd  = ftp_detl.get("password").toString();
                	}
                	sftpPath = ftp_detl.get("path").toString();
                    sftpMode = ftp_detl.get("authType").toString();
                    if(ftp_detl.get("sshKey") != null && ftp_detl.get("sshKey") != "")
                	{
                    	sftpSSHKey = ftp_detl.get("sshKey").toString();
                	}
                    
                    try {
                    	GetFirstFile firstFile = new GetFirstFile();
                    	String fname = firstFile.execute(sftpHost, sftpUser, sftpPwd, sftpMode, sftpSSHKey, Integer.parseInt(sftpPort), sftpPath, remoteFileName);
                    	logger.info("file name " + fname);
                        if(fname != null && !fname.endsWith(".filepart")) {
                        	logger.info("Polling started for file " + fname);
                            DecryptionUtility decrypt = new DecryptionUtility();
                            SFTPClient sftpClient = new SFTPClient();
                            try {
                            	if(sftpPwd != null && sftpPwd != "")
                            	{
                            		session = sftpClient.openSFTPSession(sftpHost, sftpUser, decrypt.decryptText(sftpPwd), sftpSSHKey, Integer.parseInt(sftpPort), sftpMode);
                            	}
                            	else
                            	{
                            		session = sftpClient.openSFTPSession(sftpHost, sftpUser, sftpPwd, sftpSSHKey, Integer.parseInt(sftpPort), sftpMode);
                            	}
                            	//session = sftpClient.openSFTPSession(sftpHost, sftpUser, decrypt.decryptText(sftpPwd), sftpSSHKey, Integer.parseInt(sftpPort), sftpMode);
                            	channel = sftpClient.openSFTPChannel(session);
                    			channelSftp = (ChannelSftp) channel;
                    			
                    			if(session.isConnected()){
                                	fmodTime = channelSftp.lstat(sftpPath + "/" + fname).getMtimeString().substring(0, 19);
                                	logger.info("lastModified " + fmodTime);
                                }
                            }
                            catch (Exception e) {
                            	logger.log(Level.WARNING, "Caught SFTP Exception for " + ifId);
                            	logger.log(Level.SEVERE, e.getMessage(), e);
                            }
                            finally {
                            	sftpClient.closeSFTPSession(session);
                    			sftpClient.closeChannel(channel);
                    			sftpClient.closeChannelSFTP(channelSftp);
                            }
                            
                            FileLockingUtility fileService = new FileLockingUtility();
                            if(fileService.getLock(fname, fmodTime, ifId)) {
                                try {
                                    logger.info("File available for download to eQ");
                                    FileHandlerUtility fileHandler = new FileHandlerUtility();
                                    boolean rVal;
                                    if(sftpPwd != null && sftpPwd != "")
                                    {
                                    	//rVal = fileHandler.moveToCMSDK(fname, targetFolder, ifsAdminUser, decrypt.decryptText(ifsAdminPwd), ifsService, decrypt.decryptText(ifsSysPwd), sftpHost, Integer.parseInt(sftpPort), sftpUser, decrypt.decryptText(sftpPwd), sftpSSHKey, sftpPath, sftpMode);
                                    	rVal = fileHandler.moveToCMSDK(fname, targetFolder, ifsAdminUser, decrypt.decryptText(ifsAdminPwd), ifsService, decrypt.decryptText(ifsSysPwd), sftpHost, Integer.parseInt(sftpPort), sftpUser, decrypt.decryptText(sftpPwd), sftpSSHKey, sftpPath, sftpMode);
                                    }
                                    else
                                    {
                                    	rVal = fileHandler.moveToCMSDK(fname, targetFolder, ifsAdminUser, decrypt.decryptText(ifsAdminPwd), ifsService, decrypt.decryptText(ifsSysPwd), sftpHost, Integer.parseInt(sftpPort), sftpUser, sftpPwd, sftpSSHKey, sftpPath, sftpMode);
                                    }
                                    //boolean rVal = fileHandler.moveToCMSDK(fname, targetFolder, ifsAdminUser, decrypt.decryptText(ifsAdminPwd), ifsService, decrypt.decryptText(ifsSysPwd), sftpHost, Integer.parseInt(sftpPort), sftpUser, decrypt.decryptText(sftpPwd), sftpSSHKey, sftpPath, sftpMode);
                                    if(rVal) {
                                    	//logger.info(fname + " is successfully uploaded to CMSDK");
                                    	logger.info(fname + " is successfully uploaded to");
                                    	if(sftpPwd != null && sftpPwd != "")
                                        {
                                    		fileHandler.deleteFile(fname, sftpHost, Integer.parseInt(sftpPort), sftpUser, decrypt.decryptText(sftpPwd), sftpSSHKey, sftpPath, sftpMode);
                                        }
                                    	else
                                    	{
                                    		fileHandler.deleteFile(fname, sftpHost, Integer.parseInt(sftpPort), sftpUser, sftpPwd, sftpSSHKey, sftpPath, sftpMode);
                                    	}
                                    	//fileHandler.deleteFile(fname, sftpHost, Integer.parseInt(sftpPort), sftpUser, decrypt.decryptText(sftpPwd), sftpSSHKey, sftpPath, sftpMode);
                                        logger.info(fname + " is deleted from interface " + ifId);
                                        fileService.releaseLock(fname, fmodTime, "SUCCESS");
                                        logger.info("Lock has been released from " + fname);
                                        //processDirectInterface(conn,procedurePath,ifId);
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
                    	logger.log(Level.WARNING, "Caught SFTP Exception for " + ifId);
                    	logger.log(Level.SEVERE, e.getMessage(), e);
                    }
                
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
            			DatabaseConn.closeConnection();
            		}
            	}catch(Exception e){
            		logger.log(Level.WARNING, "Excpetion occured while closing the resources ");
                	logger.log(Level.SEVERE, e.getMessage(), e);
            	}  
            }
    }
	
	 private static void processDirectInterface(Connection conn, String targetFolder, String ifId) {
		
		 	logger.info(ifId + " is the current ifId");
			//String location = "/u02_psp_soa_ap/DATA" + targetFolder; //923018
			String location =  targetFolder;
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
	        		conn = DatabaseConn.getConnection();
	        		int rtVal = insertSoaQueue(conn, fname, ifId, targetFolder);
	        		logger.info("Return Value " + rtVal);
	        		if(rtVal == 0) {
	        			fService.releaseLock(fname, fmod, "SUCCESS");
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

	/**
     * Returns the attribute value.
     * @param p_attrib the attrib name
     * @return the attrib value or blank
     */
     public static String getAttribValue(String p_attrib)
     {
        String attribVal = "";
        try {
            attribVal = (p_attrib==null?"":p_attrib);
        } catch(Exception e) {
        	logger.log(Level.WARNING, "Excpetion occured in getAttribValue(String p_attrib) method ");
        	logger.log(Level.SEVERE, e.getMessage(), e);
        }
        return attribVal;
     }

}
