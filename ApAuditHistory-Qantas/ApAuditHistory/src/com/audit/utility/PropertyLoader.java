package com.audit.utility;

import java.util.HashMap;

public class PropertyLoader {
    
    private static PropertyLoader INSTANCE = null;
    
    private HashMap<String, Object> properties;
    
   
   
    
    private PropertyLoader() {        
        properties = new HashMap<String, Object>();       
    }
    
    public static PropertyLoader getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new PropertyLoader();
        }
        return INSTANCE;
    }
    
    
    public void addProperty(String key, Object value) {
        properties.put(key, value);
    }
    
    public Object getProperty(String key) {
        return properties.get(key);
    }


 
    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    public HashMap<String, Object> getProperties() {
        return properties;
    }


 
}
