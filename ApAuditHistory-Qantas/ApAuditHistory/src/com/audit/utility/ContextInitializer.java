package com.audit.utility;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class ContextInitializer implements ServletContextListener {
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
        
        
        
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
