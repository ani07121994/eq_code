package qantas.eqportal.utility;

import java.io.File;	
import java.io.FileInputStream;	
import java.io.IOException;	
import java.net.URL;	
import java.util.ArrayList;	
import java.util.Arrays;	
import java.util.Enumeration;	
import java.util.HashMap;	
import java.util.Hashtable;	
import java.util.List;	
import java.util.Set;	
	
import javax.management.MBeanServer;	
import javax.management.ObjectName;	
import javax.naming.InitialContext;	
import javax.naming.NamingEnumeration;	
import javax.naming.directory.Attribute;	
import javax.naming.directory.Attributes;	
import javax.naming.directory.SearchControls;	
import javax.naming.directory.SearchResult;	
import javax.naming.ldap.InitialLdapContext;	
import javax.naming.ldap.LdapContext;	
import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;	
import javax.servlet.http.HttpSession;	


	
import weblogic.security.internal.SerializedSystemIni;	
import weblogic.security.internal.encryption.ClearOrEncryptedService;
import weblogic.security.internal.encryption.EncryptionService;	
	

public class LDAPUtility {
    
    private static String LDAP_HOST;    
    private static String LDAP_PORT;    
    private static String LDAP_USERBASEDN;      
    private static String LDAP_GROUPBASEDN;     
    private static String LDAP_ADMIN_USERNAME = "whatever";     
    private static String LDAP_ADMIN_PASSWORD = "whatever";     
    
    public LDAPUtility() {   
            try {   
                MBeanServer connection = getMBeanServer();                
                ObjectName defaultAuthenticator = getAuthenticator(connection);                
                        
                try {       
                    String domainHome = System.getProperty("domain.home");
                    String configFileLocation = domainHome = domainHome + File.separator + "config" + File.separator + "config.xml";
                            
                    File configFile = new File(configFileLocation); 
                    FileInputStream fIn = new FileInputStream(configFile);  
                    byte[] fileContents = new byte[(int)configFile.length()]        ;
                            
                    fIn.read(fileContents); 
                            
                    fIn.close();    
                            
                    String fileContentsStr = new String(fileContents, "UTF-8");
                            
                            
                    int start = 0;int end = 0;      
                    for (;;) {      
                        start = fileContentsStr.indexOf("<sec:authentication-provider", start);
                        end = fileContentsStr.indexOf(" </sec:authentication-provider>", start);
                                
                                
                        int index1 = fileContentsStr.indexOf("<sec:name>", start);
                        int index2 = fileContentsStr.indexOf("</sec:name>", index1);
                                
                                
                        if ((index1 > start) && (index2 < end)) {   
                            String name = fileContentsStr.substring(index1 + 10, index2);
                                    
                                    
                                    
                            if (defaultAuthenticator.getCanonicalName().contains(name)) {
                                String princripal = fileContentsStr.substring(fileContentsStr.indexOf("<wls:principal>", start) + "<wls:principal>".length(), fileContentsStr.indexOf("</wls:principal>", start));  
                                                                   
                                String credentialEncrypted = fileContentsStr.substring(fileContentsStr.indexOf("<wls:credential-encrypted>", start) + "<wls:credential-encrypted>".length(), fileContentsStr.indexOf("</wls:credential-encrypted>", start));        
                                                                    
                                EncryptionService encryptSrv = SerializedSystemIni.getEncryptionService();
                                ClearOrEncryptedService ces = new ClearOrEncryptedService(encryptSrv);
                                String decryptedPassword = ces.decrypt(credentialEncrypted);
                                        
                                        
                                LDAP_ADMIN_USERNAME = princripal;   
                                LDAP_ADMIN_PASSWORD = decryptedPassword;    
                                        
                                break;      
                            }       
                        }   
                        start = end + 1;    
                    }                
                } catch (Exception ex) {                
                    ex.printStackTrace();   
                }   
                        
                        
                LDAP_HOST = getHost(defaultAuthenticator, connection);
                        
                LDAP_PORT = getPort(defaultAuthenticator, connection);
                        
                LDAP_USERBASEDN = getUserBaseDN(defaultAuthenticator, connection);
                        
                LDAP_GROUPBASEDN = getGroupBaseDN(defaultAuthenticator, connection);
            } catch (Exception ref) {
                ref.printStackTrace();      
            }       
        }   
            
        private MBeanServer getMBeanServer() {
            MBeanServer connection; 
            try {   
                InitialContext ctx = new InitialContext();                    
                connection = (MBeanServer)ctx.lookup("java:comp/env/jmx/runtime");
            } catch (Exception e) {
                throw new RuntimeException(e); 
            }
            return connection;      
        }   
            
        private ObjectName getAuthenticator(MBeanServer connection) {       
            ObjectName authenticator = null;        
            try {   
                ObjectName[] authenticationsProviders = (ObjectName[])connection.getAttribute(new ObjectName("Security:Name=myrealm"), "AuthenticationProviders");
                for (ObjectName authenticationsProvider : authenticationsProviders) {       
                    if (authenticationsProvider.getCanonicalName().toLowerCase().contains("eqoid")) {
                        authenticator = authenticationsProvider;    
                    }       
                }   
            } catch (Exception e) { 
                e.printStackTrace();        
            }       
            return authenticator;   
        }   
            
        private String getHost(ObjectName defaultAuthenticator, MBeanServer connection) throws Exception {
            String result = (String)connection.getAttribute(defaultAuthenticator, "Host");
            return result;  
        }   
            
        private String getPort(ObjectName defaultAuthenticator, MBeanServer connection) throws Exception {
            String result = ((Integer)connection.getAttribute(defaultAuthenticator, "Port")).toString();
            return result;  
        }   
            
        private String getUserBaseDN(ObjectName defaultAuthenticator, MBeanServer connection) throws Exception {
            String result = (String)connection.getAttribute(defaultAuthenticator, "UserBaseDN");
            return result;  
        }   
                
        private String getGroupBaseDN(ObjectName defaultAuthenticator, MBeanServer connection) throws Exception {
            String result = (String)connection.getAttribute(defaultAuthenticator, "GroupBaseDN");
            return result;  
        }   
            
        public HashMap<String, String> getRequestHeaders(HttpServletRequest request) {      
            HashMap<String, String> map = new HashMap();    
            
            HttpServletRequest myrequest = request;
                    
            Enumeration<String> reqHeaders = myrequest.getHeaderNames();    
            while (reqHeaders.hasMoreElements()) {  
                    
                String header = (String)reqHeaders.nextElement();   
                
                String value = myrequest.getHeader(header); 
                
                        
                map.put(header, value);     
            }       
                    
                    
            return map;     
        }   
            
            
        public String getRequestHeaderValue(HttpServletRequest request,String header) {     
            return (String)getRequestHeaders(request).get(header);  
        }   
            
        public String getRequestHeaderNames(HttpServletRequest request) {   
        HashMap<String, String> m = getRequestHeaders(request);     
        return Arrays.toString(m.keySet().toArray(new String[m.size()]));
        }   
            
        public String getProxyServerIP(HttpServletRequest request) {        
        
            HttpServletRequest myrequest = request;
            String currentIP = myrequest.getRemoteAddr();   
            return myrequest.getRemoteAddr();       
        }   
            
        public String getProxyServerHost(HttpServletRequest request) {      
            
            HttpServletRequest myrequest = request;
            String currentIP = myrequest.getRemoteAddr();   
            return myrequest.getRemoteHost();       
        }   
            
            
            
            
            
            
            
            
            
        public static HashMap<String, Object> getUserDetails(String username) {     
            ArrayList<String> user_attributes = new ArrayList();    
            user_attributes.add("cn");      
            user_attributes.add("givenname");       
            user_attributes.add("sn");      
                    
                    
            HashMap<String, Object> details = null; 
                    
            Hashtable<String, Object> env = new Hashtable();        
            env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
            env.put("java.naming.provider.url", "ldap://" + LDAP_HOST + ":" + LDAP_PORT);
            env.put("java.naming.security.authentication", "simple");       
            env.put("java.naming.security.principal", LDAP_ADMIN_USERNAME);
            env.put("java.naming.security.credentials", LDAP_ADMIN_PASSWORD);
            LdapContext ctx = null; 
            try {   
                ctx = new InitialLdapContext(env, null);    
                ctx.setRequestControls(null);       
                details = new HashMap();    
                        
                Attributes attributes = ctx.getAttributes("cn=" + username  + "," + LDAP_USERBASEDN);
                NamingEnumeration<? extends Attribute> namingEnumAttr = attributes.getAll();
                while (namingEnumAttr.hasMoreElements()) {  
                    Attribute attr = (Attribute)namingEnumAttr.next();      
                    String attrId = attr.getID();   
                    if (user_attributes.contains(attrId)) { 
                        NamingEnumeration attrValues = attr.getAll();       
                        while (attrValues.hasMoreElements()) {      
                        Object attrValue = attrValues.next();       
                                
                        details.put(attrId, (attrValue instanceof String) ? (String)attrValue : attrValue.getClass().toString());
                        }   
                        attrValues.close(); 
                    }       
                }   
                namingEnumAttr.close();     
                        
                        
                SearchControls searchControls = new SearchControls();       
                searchControls.setSearchScope(2);   
                searchControls.setTimeLimit(30000); 
                String[] attrIDs = { "memberOf" };  
                searchControls.setReturningAttributes(attrIDs);     
                        
                NamingEnumeration<?> namingEnum = ctx.search(LDAP_USERBASEDN, "(&(objectclass=person)(cn=" + username + "))", searchControls);
                        
                        
                        
                while (namingEnum.hasMore()) {      
                    SearchResult result = (SearchResult)namingEnum.next();  
                    Attributes attrs = result.getAttributes();      
                            
                    NamingEnumeration enu = attrs.getAll(); 
                    if (enu != null) {      
                        while (enu.hasMoreElements()) {     
                            Attribute attr = (Attribute)enu.next(); 
                            String attrName = attr.getID(); 
                            ArrayList<String> groups = new ArrayList();     
                            if (attrName.equals("memberof"))        
                            {       
                                NamingEnumeration attrValues = attr.getAll();       
                                while (attrValues.hasMoreElements()) {      
                                    Object attrValue = attrValues.next();   
                                            
                                            
                                    String groupname = (attrValue instanceof String)        ? attrValue.toString() : attrValue.getClass().toString();
                                            
                                            
                                    groups.add(groupname);  
                                }   
                                attrValues.close(); 
                            }       
                            details.put("group", groups);   
                        }   
                    }       
                            
                            
                    enu.close();    
                }   
                        
                namingEnum.close(); 
                        
                        
                        
                        
                        
                        
                        
                if (ctx != null) {  
                    try {   
                    ctx.close();    
                    } catch (Exception ex) {        
                    ex.printStackTrace();   
                    }       
                }   
                        
                        
                        
                if (details.get("givenname") != null) {     
                    String firstname = (String)details.get("givenname");
                    String lastname = details.get("sn") == null ? "" : (String)details.get("sn");
                    String fullname = firstname + " " + lastname;   
                    details.put("fullname", fullname.trim());
                }   
            } catch (Exception localException1) {
                localException1.printStackTrace();
            } finally {     
                if (ctx != null) {  
                    try {   
                        ctx.close();        
                    } catch (Exception ex) {        
                        ex.printStackTrace();       
                    }       
                }   
            }       
                    
            return details; 
        }   
        
        public static boolean isUserMemberOfGroup(String username, String group, HashMap<String, Object> details) {        
            if ((details != null) && (details.get("group") != null)) {      
                ArrayList<String> groups = (ArrayList)details.get("group")  ;
                if (groups.contains(group + "," + LDAP_GROUPBASEDN)) {      
                    return true;    
                }   
            }       
            return false;   
        }
            
            
        public static boolean isUserMemberOfGroup(String username, String group) {  
            HashMap<String, Object> details = getUserDetails(username);     
            if ((details != null) && (details.get("group") != null)) {      
                ArrayList<String> groups = (ArrayList)details.get("group")  ;
                if (groups.contains(group + "," + LDAP_GROUPBASEDN)) {      
                    return true;    
                }   
            }       
            return false;   
        }   
}
