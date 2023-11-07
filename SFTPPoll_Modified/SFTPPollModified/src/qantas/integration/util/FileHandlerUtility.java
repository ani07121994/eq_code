package qantas.integration.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import oracle.ifs.adk.filesystem.IfsFileSystem;
import oracle.ifs.beans.LibrarySession;
import oracle.ifs.beans.PublicObject;
import oracle.ifs.common.IfsException;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class FileHandlerUtility {
	
private static final Logger logger = SFTPLogger.getLogger(FileHandlerUtility.class.getName());
	
	private LibrarySession lSession   = null;
	private Session session           = null;
	private Channel channel           = null;
	private ChannelSftp channelSftp   = null;
	private InputStream contentStream = null;
	
	public boolean moveToCMSDK(String fileName, String targetFolder, String ifsAdminUser, String ifsAdminPwd, String ifsService, String ifsSysPwd, String sftpHost, int sftpPort, String sftpUser, String sftpPwd, String sftpSSHKey, String sftpPath, String sftpMode){
		
		SFTPClient sftpClient = new SFTPClient();
		CMSDKClient cmsdkClient = new CMSDKClient();
		boolean flag = false;
		
		try {
	        session = sftpClient.openSFTPSession(sftpHost, sftpUser, sftpPwd, sftpSSHKey, sftpPort, sftpMode);
	        channel = sftpClient.openSFTPChannel(session);
			channelSftp = (ChannelSftp) channel;
			contentStream = channelSftp.get(sftpPath + "/" + fileName);
			
			//lSession = cmsdkClient.createLibrarySession(ifsService, ifsSysPwd, ifsAdminUser, ifsAdminPwd);
			
			//flag = createDocument(targetFolder, fileName, contentStream);
			flag = createDocumentLocal(targetFolder, fileName, contentStream);
		}
		catch (Exception e) {
			logger.log(Level.WARNING, "Exception occured in toCMSDK method while trying to move the file from STP server to CMSDk");
        	logger.log(Level.SEVERE, e.getMessage(), e);
        	return false;
		}
		finally {
			try {
				if (null != contentStream)
					contentStream.close();
				sftpClient.closeSFTPSession(session);
				sftpClient.closeChannel(channel);
				sftpClient.closeChannelSFTP(channelSftp);
				cmsdkClient.closeLibrarySession(lSession);
			}
			catch(Exception exception) {
				logger.log(Level.WARNING,"Exception while closing resources");
				logger.log(Level.SEVERE, exception.getMessage(), exception);
			}
		}
		
		return flag;
	}
	//Jan 2021
	private boolean createDocumentLocal(String targetFolder, String fileName, InputStream stream) {
		
		boolean rval = false;
		String filePath = (targetFolder + "/" + fileName);
		File file = new File(filePath);
		if(file.exists())
		{
			try {
			logger.info(fileName + " File exists");
			file.delete();
			logger.info("Previous file deleted.");
			}
			catch(Exception e)
			{
				rval = false;
				logger.log(Level.WARNING,"Can't delete this file! "+fileName);
				logger.log(Level.SEVERE, e.getMessage(), e);
			}
		}
		try {
			Files.copy(stream, file.toPath());
			rval = true;
		} catch (IOException e) {
			rval = false;
			logger.log(Level.WARNING, "Exception caught for path" + filePath);
        	logger.log(Level.SEVERE, e.getMessage(), e);
		}

		return rval;
	}

	public boolean createDocument(String filePath, String fileName, InputStream contentStream){
		
		PublicObject po   = null;
		IfsFileSystem ifs = null;
		
		try {
			ifs = new IfsFileSystem(lSession);
			
			try {
		    	po = ifs.findPublicObjectByPath(filePath + "/" + fileName);
		    } catch(IfsException fex) {
		    	po = null;
		    	logger.info("No file with the name " + fileName + " is present in CMSDK folder");
		    }
			
			if(po != null) // file exists the remove it
		    {
		      try {
		        ifs.delete(po);
		        logger.info("Previous file deleted. " + fileName);
		      } catch(IfsException fex) {        
		        logger.info("Can't delete this file! " + fileName);
		        logger.log(Level.WARNING, "Exception occured in createDocument() method ");
	        	logger.log(Level.SEVERE, fex.getMessage(), fex);
	        	return false;
		      }
		    }
			
			// Now create the file.
		    ifs.createDocument(fileName, contentStream, filePath, null, false, null);
		    
		    logger.info("New file created. "+fileName);  
		}
		catch (Exception e) {
			logger.log(Level.WARNING, "Exception occured in createDocument() method while trying to create file in CMSDk");
        	logger.log(Level.SEVERE, e.getMessage(), e);
        	return false;
		}
		
		return true;
	}
	
	public boolean deleteFile(String fileName, String sftpHost, int sftpPort, String sftpUser, String sftpPwd, String sftpSSHKey, String sftpPath, String sftpMode){
		
		SFTPClient sftpClient = new SFTPClient();
		
		try {
	        session = sftpClient.openSFTPSession(sftpHost, sftpUser, sftpPwd, sftpSSHKey, sftpPort, sftpMode);
	        channel = sftpClient.openSFTPChannel(session);
			channelSftp = (ChannelSftp) channel;
			logger.info("File path " + sftpPath + "/" + fileName);
			channelSftp.rm(sftpPath + "/" + fileName);
		}
		catch (Exception e) {
			logger.log(Level.WARNING, "Exception occured in deleteFile() method while trying to delete a file from CMSDk");
        	logger.log(Level.SEVERE, e.getMessage(), e);
        	return false;
		}
		finally {
			try {
				sftpClient.closeSFTPSession(session);
				sftpClient.closeChannel(channel);
				sftpClient.closeChannelSFTP(channelSftp);
			}
			catch(Exception exception) {
				logger.log(Level.WARNING,"Exception while closing resources");
				logger.log(Level.SEVERE, exception.getMessage(), exception);
			}
		}
		
		return true;
	}
	
}
