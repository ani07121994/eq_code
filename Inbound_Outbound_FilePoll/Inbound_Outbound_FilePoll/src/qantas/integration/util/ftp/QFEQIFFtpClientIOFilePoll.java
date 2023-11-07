//
// Copyright (c) 2002 Oracle Corp
// System       : eQ
// Subsystem    : Integration
// File         : QFEQIFFtpClient.java
// Classes      : QFEQIFFtpClient
//
// Change History
// Date     Version	Author      Description
// ----     ------- ------      ------------
// 03/02/04 1.03    Luke Lam    Added delete function.
// 19/12/03 1.02    Luke Lam    Fixed fpt put to check for 125 return code.
// 17/12/03 1.01    Luke Lam    Trap permission denied error.
// 30/09/03 1.01    Luke Lam    Default timeout to 10 seconds.
// 25/06/03 1.01    Luke Lam    Added PASV support.
// 16/12/02	1.00    Luke Lam    Created.
//
package qantas.integration.util.ftp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import qantas.integration.util.QFEQIFBaseIOFilePoll;
import qantas.integration.util.QFEQIFConstantIOFilePoll;
import qantas.integration.util.QFEQIFLoggerIOFilePoll;


/**
 * QFEQIFFtpClient is a simple ftp client implementation. It assumes active socket, no proxy server, and utf8 charset.
 * It implements connect, logout, login, changeDir, put.
 *
 * @author Oracle Consulting
 * @version $version$
 *
 */
public class QFEQIFFtpClientIOFilePoll implements QFEQIFBaseIOFilePoll
{
  private static final Logger logger = QFEQIFLoggerIOFilePoll.getLogger(QFEQIFFtpClientIOFilePoll.class.getName());
  private final String CLASS_NAME = getClass().getName();

  private String m_server = QFEQIFConstantIOFilePoll.BLANK;
  private String m_user = QFEQIFConstantIOFilePoll.BLANK;

  private boolean m_isBinary = true;
  private boolean m_isPassive = true;
  private int m_timeout = 10000; //10 seconds default

  private int m_port = 21;
  private Socket m_socket;
  private BufferedReader m_reader;
  private PrintWriter m_writer;

  //ftp commands
  public final static String FTP_CMD_USER = "USER ";
  public final static String FTP_CMD_PWD = "PASS ";
  public final static String FTP_CMD_QUIT = "QUIT";
  public final static String FTP_CMD_PORT = "PORT ";
  public final static String FTP_CMD_STOR = "STOR ";
  public final static String FTP_CMD_RETR = "RETR ";
  public final static String FTP_CMD_TYPE = "TYPE ";
  public final static String FTP_CMD_CWD = "CWD ";
  public final static String FTP_CMD_PASV = "PASV";
  public final static String FTP_CMD_SITE = "SITE ";
  public final static String FTP_CMD_DELE = "DELE ";
  public final static String FTP_CMD_LIST = "NLST ";
  
  public final static String FTP_BINARY_XFER_CODE = "I";
  public final static String FTP_ASCII_XFER_CODE = "A";

  //ftp reply codes
  public final static String FTP_CODE_OPENED = "220";
  public final static String FTP_CODE_200 = "200";
  public final static String FTP_CODE_227 = "227";
  public final static String FTP_CODE_226 = "226";
  public final static String FTP_CODE_250 = "250";
  public final static String FTP_CODE_331 = "331";
  public final static String FTP_CODE_230 = "230";
  public final static String FTP_CODE_150 = "150";  // ready for STOR
  public final static String FTP_CODE_125 = "125";  // v1.03 - Storing data set (MVS ftp server)
  public final static String FTP_CODE_550 = "550";  // v1.04 - No such file or directory or permission denied on DELE
  public final static String FTP_CODE_553 = "553";  // v1.03 - permission denied on STOR

 /**
  * Constructor
  *
  */
  public QFEQIFFtpClientIOFilePoll()
  {
    super();
  }

 /**
  * Constructor
  *
  * @param p_isPassive set the passive mode
  *
  */
  public QFEQIFFtpClientIOFilePoll(boolean p_isPassive)
  {
    super();
    m_isPassive = p_isPassive;
  }

 /**
  * Constructor
  *
  * @param p_isBinary sets the binary mode
  * @param p_isPassive sets the passive mode
  *
  */
  public QFEQIFFtpClientIOFilePoll(boolean p_isBinary, boolean p_isPassive)
  {
    super();
    m_isBinary = p_isBinary;
    m_isPassive = p_isPassive;
  }

 /**
  * Connects the the remote ftp server
  *
  * @param p_server the remote ftp server
  * @param p_user the remote ftp server user name
  * @param p_password the remote ftp server user password
  * @return  true if successful
  *
  */
	public boolean connect(String p_server, String p_user, String p_password)
	{
		return connect(p_server, 21, p_user, p_password);
	}

 /**
  * Connects the the remote ftp server
  *
  * @param p_server the remote ftp server
  * @param p_port the remote ftp server port
  * @param p_user the remote ftp server user name
  * @param p_password the remote ftp server user password
  * @return  true if successful
  *
  */
  public boolean connect(String p_server, int p_port, String p_user, String p_password)
  {
    final String METHOD_NAME = CLASS_NAME + ".connect";
    logger.info(QFEQIFConstantIOFilePoll.ENTER + METHOD_NAME);

    m_server = p_server;
    m_port = p_port;
    m_user = p_user;

    boolean statusConnection = false;

    logger.info("Connecting to server " + m_server + " on port " + p_port);

    try
    {
      m_socket = new Socket(m_server, m_port);

      m_reader = new BufferedReader(new InputStreamReader(m_socket.getInputStream(), QFEQIFConstantIOFilePoll.ENCODING_UTF8));
      m_writer = new PrintWriter(new OutputStreamWriter(m_socket.getOutputStream(), QFEQIFConstantIOFilePoll.ENCODING_UTF8), true);
      
      String replyCode = getReplyCode();
      logger.info("Reply Code :" + replyCode);
      if(!replyCode.equals(FTP_CODE_OPENED))
      {
        statusConnection = false;
        logger.info("Connection Status :" + statusConnection);
      }
      else
      {
        statusConnection = login(p_user, p_password);
        logger.info("Connection Status :" + statusConnection);
      }
    }
    catch(IOException ex)
    {
        //logger.info("IOException caught: "+ex.getMessage());
    	logger.log(Level.WARNING, "Exception occured in " + METHOD_NAME);
    	logger.log(Level.SEVERE, ex.getMessage(), ex);
    	//logger.info("Exception occured in " + METHOD_NAME);
    	//logger.error("Exception occured in connect(String p_server, int p_port, String p_user, String p_password) method ", ex);
    }

    logger.info(QFEQIFConstantIOFilePoll.EXIT + METHOD_NAME);
    return statusConnection;
  }

 /**
  * Reads the FTP server's reply to a previously
  * issued command. RFC 959 states that a reply
  * consists of the 3 digit code followed by text.
  * The 3 digit code is followed by a hyphen if it
  * is a muliline response, and the last line starts
  * with the same 3 digit code.
  *
  * @return  reply string
  *
 	* @exception IOException if the operation fails
  */
  private String getReplyCode() throws IOException
  {
    StringBuffer reply = new StringBuffer(m_reader.readLine());
    String replyCode = reply.toString().substring(0, 3);

    logger.info("Reply code: "+reply.toString());

    // check for multiline response and consume the subsequent lines.
    if (reply.charAt(3) == QFEQIFConstantIOFilePoll.DASH_CHAR)
    {
      boolean complete = false;
      while (!complete)
      {
        String line = m_reader.readLine();
        //System.out.println(line);
        logger.info("Line value " + line);
        if (line.length() > 3 &&
          line.substring(0, 3).equals(replyCode) &&
          line.charAt(3) == QFEQIFConstantIOFilePoll.SPACE_CHAR)
        {
          //reply.append(line.substring(3));
          complete = true;
        }
      }
    }
    return replyCode;
  }

 /**
  * Sends a command to the FTP server and returns the server's reply
  *
  * @param p_command the ftp command
  * @return  reply to the supplied command
  *
 	* @exception IOException if the operation fails
  */
  protected String issueCommand(String p_command) throws IOException
  {
    //don't trace password!
    if(p_command.indexOf(FTP_CMD_PWD)==-1)
    {
      logger.info("Cmd: " + p_command);
    }

    m_writer.write(p_command + QFEQIFConstantIOFilePoll.NEW_LINE);
    m_writer.flush();
    logger.info("Command :" + p_command);
    if(p_command.equals(FTP_CMD_PASV))
    {
      return getPassiveReplyCode();
    }
    else
    {
      return getReplyCode();
    }
  }
  
  protected String issueCommand(String p_command, boolean displayProperty) throws IOException
  {
    //don't trace password!
    if(p_command.indexOf(FTP_CMD_PWD)==-1)
    {
    	if(displayProperty){
    		logger.info("Cmd: " + p_command);
    	}
    }
    
    m_writer.write(p_command + QFEQIFConstantIOFilePoll.NEW_LINE);
    m_writer.flush();
    if(displayProperty){
    	 logger.info("Command :" + p_command);
    }
    if(p_command.equals(FTP_CMD_PASV))
    {
      return getPassiveReplyCode();
    }
    else
    {
      return getReplyCode();
    }
  }

 /**
  * Login into an account on the FTP server. This call completes the entire login process
  *
  * @param   p_user       user name
  * @param   p_password   password
  * @return  true if success else false
 	*
 	* @exception IOException if the operation fails
  */
  public boolean login(String p_user, String p_password) throws IOException
  {
    final String METHOD_NAME = CLASS_NAME + ".login";
    logger.info(QFEQIFConstantIOFilePoll.ENTER + METHOD_NAME);

    boolean loginStatus = false;
    logger.info("Starting login process");
    String response = issueCommand(FTP_CMD_USER + p_user);
    logger.info("FTP command issued " + FTP_CMD_USER + p_user);
    logger.info("Reply after FTP command issued " + response);

    if(response.equals(FTP_CODE_331))
    {
      response = issueCommand(FTP_CMD_PWD + p_password, false);
      logger.info("Reply after FTP command issued " + response);
      if(response.equals(FTP_CODE_230))
      {
        loginStatus = true;
      }
    }
    logger.info("Logged in");
    logger.info(QFEQIFConstantIOFilePoll.EXIT + METHOD_NAME);
    return loginStatus;
  }

 /**
  * Quits connection
  *
 	* @exception IOException if the operation fails
  */
  public void logout() throws IOException
  {
    final String METHOD_NAME = CLASS_NAME + ".logout";
    logger.info(QFEQIFConstantIOFilePoll.ENTER + METHOD_NAME);

    //reply 221
    logger.info("FTP command issued " + FTP_CMD_QUIT);
    String reply = issueCommand(FTP_CMD_QUIT);
    m_writer.close();
    m_reader.close();
    m_socket.close();
    logger.info("Logged out successfully");
    logger.info(QFEQIFConstantIOFilePoll.EXIT + METHOD_NAME);
  }

 /**
  * returns a socket for data transfer
  *
  * @param  p_cmd  the LIST, RETR and STOR cmds
  * @return Socket if successful
  *
  * @exception  IOException      if operation fails
  */
  public Socket getDataSocket(String p_cmd) throws IOException
  {
    Socket sock = null;

    //get the data socket for xfer
    if(isPassiveXfer())
    {
      sock = getPassiveDataSocket(p_cmd);
    }
    else
    {
      sock = getActiveDataSocket(p_cmd);
    }

    return sock;
  }

 /**
  * Opens an active socket connection for transfer
  *
  * @param  p_cmd  the LIST, RETR and STOR cmds
  * @return Socket if successful
  *
  * @exception  IOException      if operation fails
  */
  public Socket getActiveDataSocket(String p_cmd) throws IOException
  {
    final String METHOD_NAME = CLASS_NAME + ".getActiveDataSocket";
    logger.info(QFEQIFConstantIOFilePoll.ENTER + METHOD_NAME);
    
    Socket sock = null;
    boolean putStatus = false;
    
    // use any available port
    ServerSocket serverSocket = new ServerSocket(0);
    
    // get the local address to which the control socket is bound.
    InetAddress localHost =  m_socket.getLocalAddress();
    
    // send the PORT command to the server
    byte[] hostBytes = localHost.getAddress();
    byte[] portBytes = toByteArray((short)serverSocket.getLocalPort());
    
    // assemble the PORT command
    String cmd = new StringBuffer (FTP_CMD_PORT)
                .append (toUnsignedShort (hostBytes[0])) .append (QFEQIFConstantIOFilePoll.COMMA)
                .append (toUnsignedShort (hostBytes[1])) .append (QFEQIFConstantIOFilePoll.COMMA)
                .append (toUnsignedShort (hostBytes[2])) .append (QFEQIFConstantIOFilePoll.COMMA)
                .append (toUnsignedShort (hostBytes[3])) .append (QFEQIFConstantIOFilePoll.COMMA)
                .append (toUnsignedShort (portBytes[0])) .append (QFEQIFConstantIOFilePoll.COMMA)
                .append (toUnsignedShort (portBytes[1])) .toString ();
    logger.info("Command prepared " + cmd);
    
    // send command and check reply
    String reply = issueCommand(cmd);
    logger.info("FTP command issued " + cmd);
    logger.info("Reply from ftp server after command issued " + reply);
    if(reply.equals(FTP_CODE_200))
    {
        serverSocket.setSoTimeout(m_timeout);
        
        reply = issueCommand(FTP_CMD_TYPE + (isBinaryXfer()? FTP_BINARY_XFER_CODE:FTP_ASCII_XFER_CODE));
        logger.info("FTP command issued " + FTP_CMD_TYPE + (isBinaryXfer()? FTP_BINARY_XFER_CODE:FTP_ASCII_XFER_CODE));
        logger.info("Reply from ftp server after command issued " + reply);
        if(reply.equals(FTP_CODE_200))
        {
            // send the command
            reply = issueCommand(p_cmd);
            logger.info("FTP command issued " + p_cmd);
            logger.info("Reply from ftp server after command issued " + reply);
            if(reply.equals(FTP_CODE_150)||reply.equals(FTP_CODE_125))
            {
                sock = serverSocket.accept();
            }
            serverSocket.close();
            
            if(!reply.equals(FTP_CODE_150)&&!reply.equals(FTP_CODE_125))
            {
                sock = null;
            }
        }
    }
    logger.info(QFEQIFConstantIOFilePoll.EXIT + METHOD_NAME);
    return sock;
  }

 /**
  * Puts data onto the FTP server using ACTIVE socket. It is placed in the current directory. It overrides the file if exists.
  *
  * @param  p_remoteFile  name of remote file
  * @param  p_inputStream the file stream
	* @return true if successful
  *
  *  @exception  IOException      if operation fails
  */
  public boolean put(String p_remoteFile, BufferedInputStream p_inputStream) throws IOException
  {
    final String METHOD_NAME = CLASS_NAME + ".put";
    logger.info(QFEQIFConstantIOFilePoll.ENTER + METHOD_NAME);

    boolean putStatus = false;
    Socket sock = null;

    //get the data socket for xfer
    sock = getDataSocket(FTP_CMD_STOR + p_remoteFile);

    if(sock == null)
    {
      logger.info("===> Error. Unable to get a data socket.");
      logger.info(QFEQIFConstantIOFilePoll.EXIT + METHOD_NAME);
      return false;
    }
/*
    if(isPassiveXfer())
    {
      sock = getPassiveDataSocket(FTP_CMD_STOR + p_remoteFile);
    }
    else
    {
      sock = getDataSocket(FTP_CMD_STOR + p_remoteFile);
    }
*/
    // get an output stream
    BufferedOutputStream bos = new BufferedOutputStream(new DataOutputStream(sock.getOutputStream()));

    byte[] buf = new byte[1024];

    // read a chunk at a time and write to the data socket
    int count = 0;
    while ((count = p_inputStream.read(buf)) > 0)
    {
      bos.write(buf, 0, count);
    }
    
 	// flush and clean up
    bos.flush();
    bos.close();

    // and close the data socket
    sock.close();
    String reply = getReplyCode();

    if(reply.equals(FTP_CODE_226)||reply.equals(FTP_CODE_250))
    {
      putStatus = true;
    }
    logger.info("Put status " + putStatus);
    logger.info(QFEQIFConstantIOFilePoll.EXIT + METHOD_NAME);
	return putStatus;
  }

 /**
  *  Run a site-specific command on the
  *  server. Support for commands is dependent
  *  on the server
  *
  *  @param  command   the site command to run
  *  @return true if command ok, false if
  *          command not implemented
  */
  public boolean site(String p_cmd)
  { 
    String reply = "";
    try
    {
      // send the command
      reply = issueCommand(FTP_CMD_SITE + p_cmd);
      logger.info("FTP command issued " + FTP_CMD_SITE + p_cmd);
      logger.info("Reply code after FTP command issued " + reply);
    }
    catch(Exception ex)
    {
    	logger.log(Level.WARNING, "Exception while issuing command in site(String p_cmd) method ");
    	logger.log(Level.SEVERE, ex.getMessage(), ex);
    	//logger.info(FTP_CMD_SITE + p_cmd + " - command not supported by server. "+ex.getMessage());
        //logger.error("Exception while issuing command in site(String p_cmd) method ", ex);
    }
    
    if(reply.equals(FTP_CODE_200))
      return true;
    else
      return false;
  }

 /**
  * Change the remote working directory
  *
  * @param  p_dir  name of remote directory
  * @return true if successful
  *
  * @exception IOException if failes
  */
  public boolean changeDir(String p_dir) throws IOException
  {
    String reply = issueCommand(FTP_CMD_CWD + p_dir);
    logger.info("FTP command issued " + FTP_CMD_CWD + p_dir);
    logger.info("Reply code after FTP command issued " + reply);
    if(reply.equals(FTP_CODE_250))
    {
      return true;
    }
    return false;
  }

 /**
  * Deletes the specified file. v1.03.
  * 
  * @param  p_file  name of remote file
  * @return true if successful
  *
  * @exception IOException if fails
  */
  public boolean delete(String p_file) throws IOException
  {
    String reply = issueCommand(FTP_CMD_DELE + p_file);
    logger.info("FTP command issued " + FTP_CMD_CWD + p_file);
    logger.info("Reply code after FTP command issued " + reply);
    if(reply.equals(FTP_CODE_250))
    {
      return true;
    }
    return false;
  }

 /**
  * Helper method to convert a byte into an unsigned short value
  *
  * @param  value   value to convert
  * @return  the byte value as an unsigned short
  */
  private short toUnsignedShort(byte value)
  {
    return ( value < 0 ) ? (short) (value + 256) : (short) value;
  }

 /**
  * Convert a short into a byte array
  *
  * @param  value   value to convert
  * @return  a byte array
  */
  protected byte[] toByteArray (short value)
  {
    byte[] bytes = new byte[2];
    bytes[0] = (byte) (value >> 8);     // bits 1- 8
    bytes[1] = (byte) (value & 0x00FF); // bits 9-16
    return bytes;
  }

 /**
  * Opens a passive socket connection for transfer
  *
  * @param  p_cmd  the LIST, RETR and STOR cmds
	* @return Socket if successful
  *
  *  @exception  IOException      if operation fails
  */
  private Socket getPassiveDataSocket(String p_cmd) throws IOException
  {
    final String METHOD_NAME = CLASS_NAME + ".getPassiveDataSocket";
    logger.info(QFEQIFConstantIOFilePoll.ENTER + METHOD_NAME);

		Socket sock = null;

		// array that holds the outputed address and port number.
		String[] address = new String[6];

		// send command and check reply
		String reply = issueCommand(FTP_CMD_PASV);
		logger.info("FTP command issued " + FTP_CMD_CWD + FTP_CMD_PASV);
	    logger.info("Reply code after FTP command issued " + reply);

		// Extract the address & port numbers from the string like
    // Response code: 227 Entering Passive Mode (10,11,40,79,230,109)

		reply = reply.substring(reply.indexOf('(') + 1, reply.indexOf(')'));

		// put the 'reply' to the array 'address'
		StringTokenizer t = new StringTokenizer(reply, ",");
		for(int i = 0; i < 6; i++)
    {
			address[i] = t.nextToken();
    }

		// Returned server address
		String SRV_IP = address[0] + '.' + address[1] + '.' + address[2] + '.' + address[3];

		// Get the port number by
		// Left shift the first number by 8
		int NEW_PORT = (Integer.parseInt(address[4]) << 8) + Integer.parseInt(address[5]);

    logger.info("Extracted Server IP: " + SRV_IP + ", Port Number: " + NEW_PORT);
		sock = new Socket(SRV_IP, NEW_PORT);

    if(sock != null)
    {
      sock.setSoTimeout(m_timeout);

      reply = issueCommand(FTP_CMD_TYPE + (isBinaryXfer()? FTP_BINARY_XFER_CODE:FTP_ASCII_XFER_CODE));
      logger.info("FTP command issued " + FTP_CMD_TYPE + (isBinaryXfer()? FTP_BINARY_XFER_CODE:FTP_ASCII_XFER_CODE));
	  logger.info("Reply code after FTP command issued " + reply);
      if(reply.equals(FTP_CODE_200))
      {
    		// send the command
    		// These commands will return 125 or 150 when success.

        reply = issueCommand(p_cmd);

        logger.info("FTP command issued " + p_cmd);
  	  	logger.info("Reply code after FTP command issued " + reply);

        if(reply.equals(FTP_CODE_150)||reply.equals(FTP_CODE_125))
        {
          logger.info("Command executed successfully with reply code: "+reply);
        }
        else
        {
          sock = null;
        }
      }
      else
      {
        sock = null;
      }
    }
    logger.info(QFEQIFConstantIOFilePoll.EXIT + METHOD_NAME);
		return sock;
	}

 /**
  * Returns the passive flag.
  *
	* @return true if passive else false
  *
  */
  public boolean isPassiveXfer()
  {
    return this.m_isPassive;
  }

 /**
  * Returns the binary flag.
  *
	* @return true if binary else false
  *
  */
  public boolean isBinaryXfer()
  {
    return this.m_isBinary;
  }

 /**
  * Returns the whole reply string if in passive mode.
  *
	* @return the whole reply string
  *
  * @exception IOException if failes
  */
  private String getPassiveReplyCode() throws IOException
  {
    StringBuffer reply = new StringBuffer(m_reader.readLine());

    logger.info("Response code: "+reply.toString());

    return reply.toString();
  }

 /**
  * Sets the timeout period in millisecond.
  *
  */
  public void setTimeout(int millis)
  {
    m_timeout = millis;
  }

 /**
  * Sets the passive mode.
  *
  */
  public void setIsPassive(boolean p_isPassive)
  {
    m_isPassive = p_isPassive;
  }

 /**
  * Sets the binary mode.
  *
  */
  public void setIsBinary(boolean p_isBinary)
  {
    m_isBinary = p_isBinary;
  }
/*
  //little tester
  public static void main(String[] args) throws IOException
  {
    QFEQIFFtpClient test = new QFEQIFFtpClient(false,true);

    //test.connect("localhost",21,"system","manager9ifs");
    //test.connect("syduepd01.qantas.com.au","bol-lla8","xxx");
    test.connect("10.11.40.79",10595,"qfeqif003","xxx");
    //test.connect("10.11.40.79",21,"ortqns2o","xxx");
    //test.connect("10.11.40.73",21,"aptqntsi","xxx");

    //test.changeDir("integration");

    //File myfile1 = new File("d:/sql.log");

    InputStream instr = (InputStream)new StringBufferInputStream("passive ascii data content");

    BufferedInputStream binstr = new BufferedInputStream(instr);

    test.put("testfile1passiveascii.data", binstr);
    test.logout();
  }
*/
 
 public String MDMT(String p_cmd) {
     String reply = "";
     String p_command = "MDTM " + p_cmd;
     logger.info("Command >> " + p_command);
     try
     {
         m_writer.write(p_command + QFEQIFConstantIOFilePoll.NEW_LINE);
         m_writer.flush();
         reply = m_reader.readLine();
         logger.info("Mod time >> " + reply);
     }
     catch(Exception ex)
     {
    	 logger.log(Level.WARNING, "Exception occured in MDMT(String p_cmd) ");
     	 logger.log(Level.SEVERE, ex.getMessage(), ex);
    	 //logger.info("MDTM " + p_cmd + " - command not supported by server. "+ex.getMessage());
         //logger.error("Exception occured in MDMT(String p_cmd)", ex); 
     }
     return reply;
 }
}