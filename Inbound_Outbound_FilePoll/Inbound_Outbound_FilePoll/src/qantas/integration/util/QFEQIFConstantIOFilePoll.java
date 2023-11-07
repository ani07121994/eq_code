package qantas.integration.util;

public class QFEQIFConstantIOFilePoll {

    public final static String ENTER = "Entering ";
    public final static String EXIT = "Exiting ";
    public static final String BLANK = "";

    //logging constant
    public static final String QFEQIF_TRACE_FLAG = "QFEQIF_TRACE_FLAG";
    public static final String YES_STR = "Y";
    public static final String QFEQIF_LOG_FILE =
        "/u02/Oracle/Middleware/user_projects/domains/soadev_domain/servers/soa_server1/logs/qfeqif_log_file.log";

    //ftp constant
    public final static String ENCODING_UTF8 = "UTF-8";
    public static final char DASH_CHAR = '-';
    public static final char SPACE_CHAR = ' ';
    public static final String NEW_LINE = "\r\n";
    public static final String COMMA = ",";
    public static final String FTP_RCODE_IFS_ERROR = "IFSLOGIN";
    public static final String FTP_RCODE_ERROR = "ERROR";

    public static final String FILE_NAME = "FILENAME";

    public static final String WF_FTP_RCODE_SUCCESS = "SUCCESS";
    public static final String WF_FTP_RCODE_ERROR = "ERROR";
    public static final String WF_FTP_RCODE_FTP_ERROR = "FTPLOGIN";
    public static final String WF_FTP_RCODE_IFS_ERROR = "IFSLOGIN";

    public static final String WF_FTP_MODE_PASSIVE = "P";
    public static final String WF_FTP_XFER_ASCII = "A";
    public static final String WF_FTP_XFER_BINARY = "I";

    public static final String GPG_WF_OSCMD = "wfgpg.sh";
    public static final String GPG_MODE_ENCRYPT = "E";
    public static final String GPG_MODE_DECRYPT = "D";
    public static final String GPG_EXT_GPG = ".gpg";
    public static final String GPG_EXT_CLR = ".clr";
    public static final String GPG_EXT_ENCRYPT = ".enc.asc";
    public static final String GPG_EXT_PUBLIC = ".pub.asc";
    public static final String GPG_EXT_SECRET = ".sec.asc";
    public static final String GPG_EXT_DATA = ".dat";


    public static final String PATH_DELIMITER = "/";

    // misc constants
    public static final String KEY_CODE_IN = "IN";
    public static final String SPACE_STR = " ";
    public static final String NO_STR = "N";
    public static final String FTP_RCODE_SUCCESS = "SUCCESS";
    public static final String BPEL_FTP_RCODE_SUCCESS = "SUCCESS";
    public static final String BPEL_FTP_RCODE_ERROR = "ERROR";
    public static final String BPEL_FTP_RCODE_FTP_ERROR = "FTPLOGIN";
    public static final String BPEL_FTP_RCODE_IFS_ERROR = "IFSLOGIN";

    public static final String IF_ADDR_TYPE = "FTP";
    public static final String FTP_DOWNLOAD_SUCCESS = "COMPLETE";
    public static final String FTP_DOWNLOAD_ERROR = "FAILED";
    
    public static final String QF_COMPILATION_ENVIRONMENT = "DEV";
    public static final String OSB_URL_INSTANCE =  "http://eqdev-soa.qantas.com.au:16015";
    // "https://eqosbpsp.qantas.com.au";
}
