package com.audit.utility;

public class Constant {
	
    public enum ENV_TYPE{
	    DEV,
	    SIT,
	    PSP,
	    SAUAT,
	    PROD;
	    public String value() {
	       return name();
	    }
	    public static ENV_TYPE fromValue(String v) {
	        return valueOf(v);
	    }
	}
	    
	public static final ENV_TYPE compileFor = Constant.ENV_TYPE.PROD;	    
	
    public static final String getEbsDataSourceName() {
        
        if(compileFor == Constant.ENV_TYPE.valueOf("DEV")) {
            return "jdbc/DEV_EBS";
        } else if(compileFor == Constant.ENV_TYPE.valueOf("SIT")) {
            return "jdbc/PATCH_APPS";
        } else if(compileFor == Constant.ENV_TYPE.valueOf("PSP")) {
            return "jdbc/PROD_APPS_NXA";
        } else if(compileFor == Constant.ENV_TYPE.valueOf("PROD")) {
            return "jdbc/PROD_APPS_NXA";
        } else if(compileFor == Constant.ENV_TYPE.valueOf("SAUAT")) {
            return "jdbc/SAUAT_APPS_NXA";
        } else {
            return "jdbc/ORACLE_EXADATA";
        }
        
    }
    
    public static String getEqfilesDataSourceName() {
        
        if(compileFor == Constant.ENV_TYPE.valueOf("DEV")) {
            return "jdbc/DEV_EQFILES";
        } else if(compileFor == Constant.ENV_TYPE.valueOf("SIT")) {
            return "jdbc/PATCH_EQFILES";
        } else if(compileFor == Constant.ENV_TYPE.valueOf("PSP")) {
            return "jdbc/PROD_EQFILES_NXA";
        } else if(compileFor == Constant.ENV_TYPE.valueOf("PROD")) {
            return "jdbc/PROD_EQFILES_NXA";
        } else if(compileFor == Constant.ENV_TYPE.valueOf("SAUAT")) {
            return "jdbc/SAUAT_EQFILES_NXA";
        } else {
            return "jdbc/ORACLE_EXADATA";
    
        
    }
	
    }


}
