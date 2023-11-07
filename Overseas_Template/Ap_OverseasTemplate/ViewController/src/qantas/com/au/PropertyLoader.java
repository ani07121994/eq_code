package qantas.com.au;

import java.math.BigDecimal;

import java.util.HashMap;

public class PropertyLoader {
    
    private static PropertyLoader INSTANCE = null;
    
    private HashMap<String, Object> properties;
    
    private HashMap<Long, String> reasonCodeMap = null;
    private HashMap<Long, HashMap<Long, String>> reasonCodeTypeMap = null;
    
    private HashMap<String, BigDecimal> taxRatesMasterList = null;
    
    private HashMap<Long, String> internalStatusMap = null;
    
    private PropertyLoader() {        
        properties = new HashMap<String, Object>();
        reasonCodeMap = new HashMap<Long, String>();
        reasonCodeTypeMap = new HashMap<Long, HashMap<Long, String>>();
        taxRatesMasterList = new HashMap<String, BigDecimal>();
        internalStatusMap = new HashMap<Long, String>();
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


    public HashMap<Long, String> getReasonCodeMap() {
        return reasonCodeMap;
    }

    public HashMap<Long, HashMap<Long, String>> getReasonCodeTypeMap() {
        return reasonCodeTypeMap;
    }


    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    public HashMap<String, Object> getProperties() {
        return properties;
    }


    public void setTaxRatesMasterList(HashMap<String, BigDecimal> taxRatesMasterList) {
        this.taxRatesMasterList = taxRatesMasterList;
    }

    public HashMap<String, BigDecimal> getTaxRatesMasterList() {
        return taxRatesMasterList;
    }


    public void setInternalStatusMap(HashMap<Long, String> internalStatusMap) {
        this.internalStatusMap = internalStatusMap;
    }

    public HashMap<Long, String> getInternalStatusMap() {
        return internalStatusMap;
    }
}