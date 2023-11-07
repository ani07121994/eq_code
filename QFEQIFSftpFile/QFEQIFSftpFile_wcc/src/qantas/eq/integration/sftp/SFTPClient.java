package qantas.eq.integration.sftp;

import java.util.Properties;
import java.util.logging.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import qantas.eq.integration.util.QFEQIFSftpLogger;

/**
 * @purpose SFTPClient class contains all the required utility methods to
 *          communicate with the SFTP server 
 *          
 * @author  Tata Consultancy Services
 * 
 * @version 1.0
 *
 */

public class SFTPClient {
	
	private static final Logger logger = QFEQIFSftpLogger.getLogger(SFTPClient.class.getName());
	
	/**
	 * Create a SFTP session and return the same
	 * @param  host
	 * @param  user
	 * @param  pwd
	 * @param  port
	 * @return session (A SFTP session to work with)
	 * @throws JSchException
	 */
	public Session openSFTPSession(String host, String user, String pwd, String sshKey, int port, String authType) throws JSchException{
		
		Session session = null;
		
		JSch jsch = new JSch();
		
		if("PASSWORD".equals(authType)){
			session = jsch.getSession(user, host, port);
			session.setPassword(pwd);
		}else{
			jsch.addIdentity(sshKey);
			session = jsch.getSession(user, host, port);
		}
		logger.info("HOST ::: "+host+" USER ::::: "+user+" PWD : "+pwd+" SSH KEY : "+sshKey+" AUTH TYPE "+authType);
		Properties config = new Properties();
		/*//config.put("cipher.s2c", 
		           "aes128-cbc,aes192-cbc,aes256-cbc,3des-cbc,blowfish-cbc,aes128-ctr,aes192-ctr,aes256-ctr");
		//config.put("cipher.c2s",
		           "aes128-cbc,aes192-cbc,aes256-cbc,3des-cbc,blowfish-cbc,aes128-ctr,aes192-ctr,aes256-ctr");
		//config.put("kex", "diffie-hellman-group14-sha1,diffie-hellman-group-exchange-sha256");*/
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		logger.info(" BEFORE SESSION CONNECT");
		session.connect();
		logger.info(" AFTER SESSION CONNECT");
		return session;
	}
	
	/**
	 * Close the opened SFTP session
	 * @param session
	 */
	public void closeSFTPSession(Session session){
		if(null != session){
			session.disconnect();
		}
	}
	
	/**
	 * Open a SFTP channel using a SFTP session and return the same
	 * @param  session
	 * @return channel (SFTP Channel)
	 * @throws JSchException
	 */
	public Channel openSFTPChannel(Session session) throws JSchException{
		Channel channel = null;
		logger.info(" BEFORE OPEN CHANNEL");
		channel = session.openChannel("sftp");
		channel.connect();
		
		return channel;
	}
	
	/**
	 * Close SFTP Channel
	 * @param channel
	 */
	public void closeChannel(Channel channel){
		if(null != channel){
			channel.disconnect();
		}
	}
	
	/**
	 * Close ChannelSFTP
	 * @param channelSftp
	 */
	public void closeChannelSFTP(ChannelSftp channelSftp){
		if(null != channelSftp){
			channelSftp.disconnect();
		}
	}

}
