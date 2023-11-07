package qantas.integration.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class GetFirstFile {
	
	private static final Logger logger = SFTPLogger.getLogger(GetFirstFile.class.getName());
	
	public GetFirstFile() {
		logger.info("Object created");
	}
	
	public String execute(String sftpHost, String sftpUser, String sftpPwd, String sftpMode, String sftpSSHKey, int sftpPort, String sftpPath, String remoteFile) throws IOException {
		logger.info("Entering GetFirstFile execute() method"); 
		Session session         = null;
		Channel channel         = null;
		ChannelSftp channelSftp = null;
		InputStream fis         = null;
		
		String fileName = null;
		
		SFTPClient sftpClient = new SFTPClient();
		DecryptionUtility decypt = new DecryptionUtility();
		
		try {
			if(sftpPwd != null && sftpPwd != "")
			{
				sftpPwd = decypt.decryptText(sftpPwd);
			}
			//sftpPwd = decypt.decryptText(sftpPwd);
			session = sftpClient.openSFTPSession(sftpHost, sftpUser, sftpPwd, sftpSSHKey, sftpPort, sftpMode);
			channel = sftpClient.openSFTPChannel(session);
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(sftpPath);
			logger.info("Connected to SFTP host " + sftpHost);
			Vector<LsEntry> listOfFiles = channelSftp.ls(remoteFile);
			for(LsEntry entry : listOfFiles) {
				fileName = entry.getFilename();
				break;
			}
		}
		catch(JSchException sftpException) {
			logger.log(Level.WARNING,"SFTP exception occured");
			logger.log(Level.SEVERE, sftpException.getMessage(), sftpException);
			
		}
		catch(Exception exception) {
			logger.log(Level.WARNING,"Exception occured");
			logger.log(Level.SEVERE, exception.getMessage(), exception);
		}
		finally {
			if(null != fis)
				fis.close();
			sftpClient.closeSFTPSession(session);
			sftpClient.closeChannel(channel);
			sftpClient.closeChannelSFTP(channelSftp);
		}
		
		logger.info(fileName);
		
		return fileName;
	}

}
