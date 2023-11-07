/*     */ package qantas.eq.integration.ftp;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.PrintWriter;
/*     */ import java.net.InetAddress;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.logging.Logger;
/*     */ import qantas.eq.integration.QFEQIFBase;
/*     */ import qantas.eq.integration.QFEQIFLogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QFEQIFFtpClient
/*     */   implements QFEQIFBase
/*     */ {
/*  38 */   private final String CLASS_NAME = getClass().getName();
/*  39 */   private static Logger _QFEQQFEQIFLogger = QFEQIFLogger.getLogger(QFEQIFFtpClient.class.getName());
/*     */   
/*  41 */   private String m_server = "";
/*  42 */   private String m_user = "";
/*     */   
/*  44 */   private boolean m_isBinary = true;
/*  45 */   private boolean m_isPassive = true;
/*  46 */   private int m_timeout = 10000;
/*     */   
/*  48 */   private int m_port = 21;
/*     */   
/*     */   private Socket m_socket;
/*     */   
/*     */   private BufferedReader m_reader;
/*     */   
/*     */   private PrintWriter m_writer;
/*     */   
/*     */   public static final String FTP_CMD_USER = "USER ";
/*     */   
/*     */   public static final String FTP_CMD_PWD = "PASS ";
/*     */   
/*     */   public static final String FTP_CMD_QUIT = "QUIT";
/*     */   
/*     */   public static final String FTP_CMD_PORT = "PORT ";
/*     */   
/*     */   public static final String FTP_CMD_STOR = "STOR ";
/*     */   
/*     */   public static final String FTP_CMD_RETR = "RETR ";
/*     */   
/*     */   public static final String FTP_CMD_TYPE = "TYPE ";
/*     */   
/*     */   public static final String FTP_CMD_CWD = "CWD ";
/*     */   
/*     */   public static final String FTP_CMD_PASV = "PASV";
/*     */   
/*     */   public static final String FTP_CMD_SITE = "SITE ";
/*     */   
/*     */   public static final String FTP_CMD_DELE = "DELE ";
/*     */   
/*     */   public static final String FTP_CMD_LIST = "NLST ";
/*     */   
/*     */   public static final String FTP_BINARY_XFER_CODE = "I";
/*     */   
/*     */   public static final String FTP_ASCII_XFER_CODE = "A";
/*     */   
/*     */   public static final String FTP_CODE_OPENED = "220";
/*     */   
/*     */   public static final String FTP_CODE_200 = "200";
/*     */   
/*     */   public static final String FTP_CODE_227 = "227";
/*     */   public static final String FTP_CODE_226 = "226";
/*     */   public static final String FTP_CODE_250 = "250";
/*     */   public static final String FTP_CODE_331 = "331";
/*     */   public static final String FTP_CODE_230 = "230";
/*     */   public static final String FTP_CODE_150 = "150";
/*     */   public static final String FTP_CODE_125 = "125";
/*     */   public static final String FTP_CODE_550 = "550";
/*     */   public static final String FTP_CODE_553 = "553";
/*     */   
/*     */   public QFEQIFFtpClient() {}
/*     */   
/*     */   public QFEQIFFtpClient(boolean p_isPassive)
/*     */   {
/* 102 */     m_isPassive = p_isPassive;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public QFEQIFFtpClient(boolean p_isBinary, boolean p_isPassive)
/*     */   {
/* 115 */     m_isBinary = p_isBinary;
/* 116 */     m_isPassive = p_isPassive;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean connect(String p_server, String p_user, String p_password)
/*     */     throws IOException, Exception
/*     */   {
/* 130 */     return connect(p_server, 21, p_user, p_password);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean connect(String p_server, int p_port, String p_user, String p_password)
/*     */     throws IOException, Exception
/*     */   {
/* 145 */     String METHOD_NAME = CLASS_NAME + ".connect";
/* 146 */     _QFEQQFEQIFLogger.info("Entering " + METHOD_NAME);
/*     */     
/*     */ 
/* 149 */     m_server = p_server;
/* 150 */     m_port = p_port;
/* 151 */     m_user = p_user;
/*     */     
/* 153 */     boolean statusConnection = false;
/*     */     
/* 155 */     _QFEQQFEQIFLogger.info("Connecting to server " + m_server + " on port " + p_port);
/*     */     
/*     */ 
/*     */ 
/* 159 */     m_socket = new Socket(m_server, m_port);
/*     */     
/* 161 */     m_reader = new BufferedReader(new InputStreamReader(m_socket.getInputStream(), "UTF-8"));
/* 162 */     m_writer = new PrintWriter(new OutputStreamWriter(m_socket.getOutputStream(), "UTF-8"), true);
/*     */     
/* 164 */     if (!getReplyCode().equals("220"))
/*     */     {
/* 166 */       statusConnection = false;
/*     */     }
/*     */     else
/*     */     {
/* 170 */       statusConnection = login(p_user, p_password);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 179 */     _QFEQQFEQIFLogger.info("Exiting " + METHOD_NAME);
/* 180 */     return statusConnection;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String getReplyCode()
/*     */     throws IOException
/*     */   {
/* 197 */     StringBuffer reply = new StringBuffer(m_reader.readLine());
/* 198 */     String replyCode = reply.toString().substring(0, 3);
/*     */     
/* 200 */     _QFEQQFEQIFLogger.info("Response code: " + reply.toString());
/*     */     
/*     */ 
/* 203 */     if (reply.charAt(3) == '-')
/*     */     {
/* 205 */       boolean complete = false;
/* 206 */       while (!complete)
/*     */       {
/* 208 */         String line = m_reader.readLine();
/*     */         
/*     */ 
/* 211 */         if ((line.length() > 3) && (line.substring(0, 3).equals(replyCode)) && (line.charAt(3) == ' '))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 216 */           complete = true;
/*     */         }
/*     */       }
/*     */     }
/* 220 */     return replyCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected String issueCommand(String p_command)
/*     */     throws IOException
/*     */   {
/* 234 */     if (p_command.indexOf("PASS ") == -1)
/*     */     {
/* 236 */       _QFEQQFEQIFLogger.info("Cmd: " + p_command);
/*     */     }
/*     */     
/* 239 */     m_writer.write(p_command + "\r\n");
/* 240 */     m_writer.flush();
/* 241 */     if (p_command.equals("PASV"))
/*     */     {
/* 243 */       return getPassiveReplyCode();
/*     */     }
/*     */     
/*     */ 
/* 247 */     return getReplyCode();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean login(String p_user, String p_password)
/*     */     throws Exception
/*     */   {
/* 262 */     String METHOD_NAME = CLASS_NAME + ".login";
/* 263 */     _QFEQQFEQIFLogger.info("Entering " + METHOD_NAME);
/*     */     
/* 265 */     boolean loginStatus = false;
/*     */     
/* 267 */     String response = issueCommand("USER " + p_user);
/*     */     
/* 269 */     if (response.equals("331"))
/*     */     {
/*     */ 
/* 272 */       response = issueCommand("PASS " + p_password);
/* 273 */       if (response.equals("230"))
/*     */       {
/* 275 */         loginStatus = true;
/* 276 */         _QFEQQFEQIFLogger.info("Logged in");
/*     */       } else {
/* 278 */         throw new Exception();
/*     */       }
/*     */     }
/* 281 */     _QFEQQFEQIFLogger.info("Exiting " + METHOD_NAME);
/* 282 */     return loginStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void logout()
/*     */     throws IOException
/*     */   {
/* 292 */     String METHOD_NAME = CLASS_NAME + ".logout";
/* 293 */     _QFEQQFEQIFLogger.info("Entering " + METHOD_NAME);
/*     */     
/*     */ 
/* 296 */     String reply = issueCommand("QUIT");
/* 297 */     m_writer.close();
/* 298 */     m_reader.close();
/* 299 */     m_socket.close();
/*     */     
/* 301 */     _QFEQQFEQIFLogger.info("Exiting " + METHOD_NAME);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Socket getDataSocket(String p_cmd)
/*     */     throws IOException
/*     */   {
/* 314 */     Socket sock = null;
/*     */     
/*     */ 
/* 317 */     if (isPassiveXfer())
/*     */     {
/* 319 */       sock = getPassiveDataSocket(p_cmd);
/*     */     }
/*     */     else
/*     */     {
/* 323 */       sock = getActiveDataSocket(p_cmd);
/*     */     }
/*     */     
/* 326 */     return sock;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Socket getActiveDataSocket(String p_cmd)
/*     */     throws IOException
/*     */   {
/* 339 */     String METHOD_NAME = CLASS_NAME + ".getActiveDataSocket";
/* 340 */     _QFEQQFEQIFLogger.info("Entering " + METHOD_NAME);
/*     */     
/* 342 */     Socket sock = null;
/* 343 */     boolean putStatus = false;
/*     */     
/*     */ 
/* 346 */     ServerSocket serverSocket = new ServerSocket(0);
/*     */     
/*     */ 
/* 349 */     InetAddress localHost = m_socket.getLocalAddress();
/*     */     
/*     */ 
/* 352 */     byte[] hostBytes = localHost.getAddress();
/* 353 */     byte[] portBytes = toByteArray((short)serverSocket.getLocalPort());
/*     */     
/*     */ 
/* 356 */     String cmd = "PORT " + toUnsignedShort(hostBytes[0]) + "," + toUnsignedShort(hostBytes[1]) + "," + toUnsignedShort(hostBytes[2]) + "," + toUnsignedShort(hostBytes[3]) + "," + toUnsignedShort(portBytes[0]) + "," + toUnsignedShort(portBytes[1]);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 365 */     String reply = issueCommand(cmd);
/* 366 */     if (reply.equals("200"))
/*     */     {
/* 368 */       serverSocket.setSoTimeout(m_timeout);
/*     */       
/* 370 */       reply = issueCommand("TYPE " + (isBinaryXfer() ? "I" : "A"));
/* 371 */       if (reply.equals("200"))
/*     */       {
/*     */ 
/* 374 */         reply = issueCommand(p_cmd);
/* 375 */         if ((reply.equals("150")) || (reply.equals("125")))
/*     */         {
/* 377 */           sock = serverSocket.accept();
/*     */         }
/* 379 */         serverSocket.close();
/*     */         
/* 381 */         if ((!reply.equals("150")) && (!reply.equals("125")))
/*     */         {
/* 383 */           sock = null;
/*     */         }
/*     */       }
/*     */     }
/* 387 */     _QFEQQFEQIFLogger.info("Exiting " + METHOD_NAME);
/* 388 */     return sock;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean put(String p_remoteFile, BufferedInputStream p_inputStream)
/*     */     throws IOException
/*     */   {
/* 402 */     String METHOD_NAME = CLASS_NAME + ".put";
/* 403 */     _QFEQQFEQIFLogger.info("Entering " + METHOD_NAME);
/*     */     
/* 405 */     boolean putStatus = false;
/* 406 */     Socket sock = null;
/*     */     
/*     */ 
/* 409 */     sock = getDataSocket("STOR " + p_remoteFile);
/*     */     
/* 411 */     if (sock == null)
/*     */     {
/* 413 */       _QFEQQFEQIFLogger.info("===> Error. Unable to get a data socket.");
/* 414 */       _QFEQQFEQIFLogger.info("Exiting " + METHOD_NAME);
/* 415 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 428 */     BufferedOutputStream bos = new BufferedOutputStream(new DataOutputStream(sock.getOutputStream()));
/*     */     
/* 430 */     byte[] buf = new byte['?'];
/*     */     
/*     */ 
/* 433 */     int count = 0;
/* 434 */     while ((count = p_inputStream.read(buf)) > 0)
/*     */     {
/* 436 */       bos.write(buf, 0, count);
/*     */     }
/*     */     
/* 439 */     bos.flush();
/* 440 */     bos.close();
/*     */     
/*     */ 
/* 443 */     sock.close();
/* 444 */     String reply = getReplyCode();
/*     */     
/* 446 */     if ((reply.equals("226")) || (reply.equals("250")))
/*     */     {
/* 448 */       putStatus = true;
/*     */     }
/* 450 */     _QFEQQFEQIFLogger.info("Exiting " + METHOD_NAME);
/* 451 */     return putStatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean site(String p_cmd)
/*     */   {
/* 465 */     String reply = "";
/*     */     
/*     */     try
/*     */     {
/* 469 */       reply = issueCommand("SITE " + p_cmd);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 473 */       _QFEQQFEQIFLogger.info("SITE " + p_cmd + " - command not supported by server. " + ex.getMessage());
/*     */     }
/*     */     
/* 476 */     if (reply.equals("200")) {
/* 477 */       return true;
/*     */     }
/* 479 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean changeDir(String p_dir)
/*     */     throws IOException
/*     */   {
/* 492 */     String reply = issueCommand("CWD " + p_dir);
/* 493 */     if (reply.equals("250"))
/*     */     {
/* 495 */       return true;
/*     */     }
/* 497 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean delete(String p_file)
/*     */     throws IOException
/*     */   {
/* 510 */     String reply = issueCommand("DELE " + p_file);
/* 511 */     if (reply.equals("250"))
/*     */     {
/* 513 */       return true;
/*     */     }
/* 515 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private short toUnsignedShort(byte value)
/*     */   {
/* 526 */     return value < 0 ? (short)(value + 256) : (short)value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected byte[] toByteArray(short value)
/*     */   {
/* 537 */     byte[] bytes = new byte[2];
/* 538 */     bytes[0] = ((byte)(value >> 8));
/* 539 */     bytes[1] = ((byte)(value & 0xFF));
/* 540 */     return bytes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Socket getPassiveDataSocket(String p_cmd)
/*     */     throws IOException
/*     */   {
/* 553 */     String METHOD_NAME = CLASS_NAME + ".getPassiveDataSocket";
/* 554 */     _QFEQQFEQIFLogger.info("Entering " + METHOD_NAME);
/*     */     
/* 556 */     Socket sock = null;
/*     */     
/*     */ 
/* 559 */     String[] address = new String[6];
/*     */     
/*     */ 
/* 562 */     String reply = issueCommand("PASV");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 567 */     reply = reply.substring(reply.indexOf('(') + 1, reply.indexOf(')'));
/*     */     
/*     */ 
/* 570 */     StringTokenizer t = new StringTokenizer(reply, ",");
/* 571 */     for (int i = 0; i < 6; i++)
/*     */     {
/* 573 */       address[i] = t.nextToken();
/*     */     }
/*     */     
/*     */ 
/* 577 */     String SRV_IP = address[0] + '.' + address[1] + '.' + address[2] + '.' + address[3];
/*     */     
/*     */ 
/*     */ 
/* 581 */     int NEW_PORT = (Integer.parseInt(address[4]) << 8) + Integer.parseInt(address[5]);
/*     */     
/* 583 */     _QFEQQFEQIFLogger.info("Extracted Server IP: " + SRV_IP + ", Port Number: " + NEW_PORT);
/* 584 */     sock = new Socket(SRV_IP, NEW_PORT);
/*     */     
/* 586 */     if (sock != null)
/*     */     {
/* 588 */       sock.setSoTimeout(m_timeout);
/*     */       
/* 590 */       reply = issueCommand("TYPE " + (isBinaryXfer() ? "I" : "A"));
/* 591 */       if (reply.equals("200"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 596 */         reply = issueCommand(p_cmd);
/*     */         
/* 598 */         _QFEQQFEQIFLogger.info("--->" + reply);
/*     */         
/* 600 */         if ((reply.equals("150")) || (reply.equals("125")))
/*     */         {
/* 602 */           _QFEQQFEQIFLogger.info("Command executed successfully with reply code: " + reply);
/*     */         }
/*     */         else
/*     */         {
/* 606 */           sock = null;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 611 */         sock = null;
/*     */       }
/*     */     }
/* 614 */     _QFEQQFEQIFLogger.info("Exiting " + METHOD_NAME);
/* 615 */     return sock;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isPassiveXfer()
/*     */   {
/* 626 */     return m_isPassive;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isBinaryXfer()
/*     */   {
/* 637 */     return m_isBinary;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String getPassiveReplyCode()
/*     */     throws IOException
/*     */   {
/* 649 */     StringBuffer reply = new StringBuffer(m_reader.readLine());
/*     */     
/* 651 */     _QFEQQFEQIFLogger.info("Response code: " + reply.toString());
/*     */     
/* 653 */     return reply.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTimeout(int millis)
/*     */   {
/* 662 */     m_timeout = millis;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIsPassive(boolean p_isPassive)
/*     */   {
/* 671 */     m_isPassive = p_isPassive;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setIsBinary(boolean p_isBinary)
/*     */   {
/* 680 */     m_isBinary = p_isBinary;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static String stackTraceToString(Throwable e)
/*     */   {
/* 708 */     StringBuilder sb = new StringBuilder();
/* 709 */     for (StackTraceElement element : e.getStackTrace()) {
/* 710 */       sb.append(element.toString());
/* 711 */       sb.append("\n");
/*     */     }
/* 713 */     return sb.toString();
/*     */   }
/*     */ }

/* Location:           D:\Workspace\QantasIHubServices\ImportedClasses
 * Qualified Name:     qantas.eq.integration.ftp.QFEQIFFtpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */