package qantas.integration.util;

import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;


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
	
	private static final Logger logger = SFTPLogger.getLogger(SFTPClient.class.getName());
	
	/**
	 * Create a SFTP session and return the same
	 * @param  host
	 * @param  user
	 * @param  pwd
	 * @param  port
	 * @return session (A SFTP session to work with)
	 * @throws JSchException
	 * @throws SQLException 
	 */
	public Session openSFTPSession(String host, String user, String pwd, String sshKey, int port, String authType) throws JSchException, SQLException{
		
		Session session = null;
		
		JSch jsch = new JSch();
		
		if("PASSWORD".equals(authType)){
			session = jsch.getSession(user, host, port);
			session.setPassword(pwd);
		}else{
			jsch.addIdentity(sshKey);
			session = jsch.getSession(user, host, port);
		}
		
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.connect();

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
