package ap.quantas.com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Handler;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ap.qantas.util.ECMUpdateLogger;

import com.qantas.ap.quartz.DBUtil;

public class ContextInitializer implements ServletContextListener {
	
	private ServletContext context = null;
	
    public ContextInitializer() {
        super();
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context Initialized during deployment");
        
        System.out.println("--- loading properties ---");
        
        Connection conn = null;
        try {       
                conn = DBUtil.getEqfilesConnection();
                
                ResultSet rs =  conn.createStatement().executeQuery("select * from ap_properties_table");
                while(rs.next()) {                	
                	PropertyLoader.getInstance().addProperty(rs.getString("name"), rs.getString("value"));
                	
                	System.out.println(rs.getString("name") + " >> "+rs.getString("value"));
                }
       
            
        } catch(Exception ex) {
           ex.printStackTrace(); 
        } finally {
            if(conn!=null) {
            	try {
            		conn.close();
            	} catch (Exception e) {
            		e.printStackTrace();
				}
            	
            }
        }
        
        
        System.out.println("--- properties loaded ---");
        
        
        org.springframework.scheduling.timer.MethodInvokingTimerTaskFactoryBean a;
        
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	context = servletContextEvent.getServletContext();
        Logger logger = ECMUpdateLogger.getLogger(ContextInitializer.class.getName());
        for(Handler h : logger.getHandlers()){
            h.close();  
        }
    }
}
