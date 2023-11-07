package qantas.eqportal.utility;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OWCServletContextListener implements ServletContextListener {
    public OWCServletContextListener() {
        super();
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Servlet context initialized at"+servletContextEvent.getServletContext().getContextPath());
        /*TreeMap<String,TreeMap<String,String[]>> owcRuleMap = OWCPropertyLoader.getInstance().getAp_owc_rule_map();//created in instance of the singleton class for the first time
        for(Map.Entry<String,TreeMap<String,String[]>> outer_entry : owcRuleMap.entrySet()) {
          String outer_key = outer_entry.getKey();
          System.out.println("Application name ====== "+outer_key); 
          TreeMap<String,String[]> link_Visble_Grp_map = outer_entry.getValue();
            
            for(Map.Entry<String,String []> inner_entry : link_Visble_Grp_map.entrySet()){
             String inner_key = inner_entry.getKey();
             System.out.println("Application link ====== "+inner_key);   
             String [] visible_groups =   inner_entry.getValue(); 
                for(String group : visible_groups ){
                System.out.println("ApplicationName===="+outer_key+"====Link======"+inner_key +"========GroupName========="+group);    
                    
                }
            }

          //System.out.println(key + " => " + value);
        }*/
        
        // TODO Implement this method
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // TODO Implement this method
    }
}
