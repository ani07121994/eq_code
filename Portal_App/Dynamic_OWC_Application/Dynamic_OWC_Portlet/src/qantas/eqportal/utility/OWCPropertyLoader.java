package qantas.eqportal.utility;

import java.util.TreeMap;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class OWCPropertyLoader {
    
    private String deployment_environment = "PROD"; // to be changed for a different instance(DEV/PSP/PROD)
    private static OWCPropertyLoader INSTANCE = null;
    
    private static LDAPUtility ldapUtility;
    
    private  TreeMap<String,TreeMap<String,String[]>>   ap_owc_rule_map=new  TreeMap<String, TreeMap<String,String[]>>();
    
    private static TreeMap<String,String []> js_owc_rule_map  =new  TreeMap<String, String []>();


    /**For Ap groups ***/
    private static String [] ap_owc_bpm_visble_groups = new String[]{"OWC_CERTIFIER","OWC_CERTIFIER_IMAGING","owc_ap_all"};
    private static String [] ap_owc_verifier_visble_groups = new String[]{"OWC_CERTIFIER","OWC_CERTIFIER_IMAGING","owc_ap_all"};
    private static String [] ap_owc_bam_visble_groups = new String[]{"OWC_BAM","owc_ap_all"};
    private static String [] ap_owc_imaging_visble_groups = new String[]{"OWC_CERTIFIER","OWC_CERTIFIER_IMAGING","owc_ap_all"};
    private static String []application_name  = new String[]{"OWC Web Verifier","OWC Imaging", "OWC BPM Workspace" , "OWC BAM Dashboard"};
    private HashMap<String,String> links = new  HashMap<String,String>();
    
    private OWCPropertyLoader(){
        getPropertiesFromFile(); //load properties from owc_proprties file
        System.out.println("links size ::"+links.size());
        
        for(Map.Entry<String,String> entry : links.entrySet()) {
            
            System.out.println("Entry  of links::"+entry.getKey() + "==="+entry.getValue());    
        }
        //System.out.println(links.get("verifier"));    
        
        
        
        
        
        
        
        
        /*String link_href=null; 
        //links.get("verifier")
        if(links.get("verifier")!=null){
         link_href =links.get("verifier");    
        TreeMap<String,String[]> ap_owc_verifier_map =new TreeMap<String,String[]>();
        ap_owc_verifier_map.put(link_href, ap_owc_verifier_visble_groups);
        ap_owc_rule_map.put(application_name[0],ap_owc_verifier_map);
            System.out.println("verifier addded");
        }
        
         if(links.get("imaging")!=null){
        link_href  =links.get("imaging");
        TreeMap<String,String[]> ap_owc_imaging_map =new TreeMap<String,String[]>();
        ap_owc_imaging_map.put(link_href, ap_owc_imaging_visble_groups);
        ap_owc_rule_map.put(application_name[1],ap_owc_imaging_map);
            System.out.println("imaging addded");
        }
        
        if(links.get("bpm")!=null){
        link_href = links.get("bpm");
        TreeMap<String,String[]> ap_owc_bpm_map =new TreeMap<String,String[]>();
        ap_owc_bpm_map.put(link_href, ap_owc_bpm_visble_groups);
        ap_owc_rule_map.put(application_name[2],ap_owc_bpm_map);
            System.out.println("bpm addded");
        }
        
        if(links.get("bam")!=null){
        link_href = links.get("bam");
        TreeMap<String,String[]> ap_owc_bam_map =new TreeMap<String,String[]>();
        ap_owc_bam_map.put(link_href, ap_owc_bam_visble_groups);
        System.out.println("bam addded");
        ap_owc_rule_map.put(application_name[3],ap_owc_bam_map);
        }*/
        
        ap_owc_rule_map.put(application_name[0], new TreeMap<String,String[]>());
        ap_owc_rule_map.get(application_name[0]).put(links.get("AP.OWC.Web.Verifier.Link"), ap_owc_verifier_visble_groups);
        
        ap_owc_rule_map.put(application_name[1], new TreeMap<String,String[]>());
        ap_owc_rule_map.get(application_name[1]).put(links.get("AP.OWC.Imaging.Link"),ap_owc_imaging_visble_groups);
        
        ap_owc_rule_map.put(application_name[2],   new TreeMap<String,String[]>());
        ap_owc_rule_map.get(application_name[2]).put(links.get("AP.OWC.BPM.Workspace.Link"), ap_owc_bpm_visble_groups);
        
        ap_owc_rule_map.put(application_name[3],  new TreeMap<String,String[]>());
        ap_owc_rule_map.get(application_name[3]).put(links.get("AP.OWC.BAM.Dashboard.Link"), ap_owc_bam_visble_groups);
        
        ldapUtility=new LDAPUtility();
        System.out.println("All properties loaded updated"+ap_owc_rule_map.size());
        
        
    }
    
   
    
    
    private void getPropertiesFromFile(){
            Properties prop = new Properties();
            InputStream input = null;

            try {
                   
                    input = OWCPropertyLoader.class.getClassLoader().getResourceAsStream("owc_application.properties");
                    if(input==null){
                        System.out.println("Sorry, unable to find owc_application.properties");
                        return;
                    }

                    prop.load(input);

                    
                Enumeration<?> e = prop.propertyNames();
                while (e.hasMoreElements()) {
                        String key = (String) e.nextElement();
                        String value = prop.getProperty(key);
                        System.out.println("Key : " + key + ", Value : " + value);
                    System.out.println("Before checking properties");
                    if(key!=null && key.toString().contains("AP.OWC.Web.Verifier.Link") && key.toString().contains(deployment_environment)){
                        System.out.println("Match found ");
                        links.put("AP.OWC.Web.Verifier.Link", value); 
                    }
                    else if(key!=null && key.toString().contains("AP.OWC.BPM.Workspace.Link") && key.toString().contains(deployment_environment)){
                        System.out.println("Match found ");
                        links.put("AP.OWC.BPM.Workspace.Link", value);
                    }
                    else if(key!=null && key.toString().contains("AP.OWC.BAM.Dashboard.Link") && key.toString().contains(deployment_environment)){
                        System.out.println("Match found ");
                        links.put("AP.OWC.BAM.Dashboard.Link", value);
                    }
                    else if(key!=null && key.toString().contains("AP.OWC.Imaging.Link") && key.toString().contains(deployment_environment)){
                        System.out.println("Match found ");
                        links.put("AP.OWC.Imaging.Link", value);
                    }
                    //24th Jan 2019
                    else if(key!=null && key.toString().contains("AP.OWC.Invoice.Template.Link") && key.toString().contains(deployment_environment)){
                        System.out.println("Match found ");
                        links.put("AP.OWC.Invoice.Template.Link", value);
                    }
                    //WCC Change by 923018 - Start
                    else if(key!=null && key.toString().contains("AP.OWC.WCC.Link") && key.toString().contains(deployment_environment)){
                        System.out.println("Match found ");
                        links.put("AP.OWC.WCC.Link", value);
                    }
                    //WCC Change by 923018 - End
                    
                    
                    
                    
                    else if(key!=null && key.toString().contains("JS.OWC.Web.Verifier.Link") && key.toString().contains(deployment_environment)){
                        System.out.println("Match found ");
                        links.put("JS.OWC.Web.Verifier.Link", value); 
                    }
                    else if(key!=null && key.toString().contains("JS.OWC.BPM.Workspace.Link") && key.toString().contains(deployment_environment)){
                        System.out.println("Match found ");
                        links.put("JS.OWC.BPM.Workspace.Link", value);
                    }
                    else if(key!=null && key.toString().contains("JS.OWC.BAM.Dashboard.Link") && key.toString().contains(deployment_environment)){
                        System.out.println("Match found ");
                        links.put("JS.OWC.BAM.Dashboard.Link", value);
                    }
                    else if(key!=null && key.toString().contains("JS.OWC.Imaging.Link") && key.toString().contains(deployment_environment)){
                        System.out.println("Match found ");
                        links.put("JS.OWC.Imaging.Link", value);
                    }
                    //24th Jan 2019
                    else if(key!=null && key.toString().contains("JS.OWC.Invoice.Template.Link") && key.toString().contains(deployment_environment)){
                        System.out.println("Match found ");
                        links.put("JS.OWC.Invoice.Template.Link", value);
                    }
                    
                    
                    
                        
                }
                System.out.println("End of while");   

            } catch (IOException ex) {
                    ex.printStackTrace();
            } finally{
                    if(input!=null){
                            try {
                                    input.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
            }

        }
    
    
    
    
    
    
    public static synchronized OWCPropertyLoader getInstance(){
        
        if(INSTANCE== null){
           INSTANCE =new  OWCPropertyLoader(); 
        }
        return INSTANCE;
        
    }


    public void setAp_owc_rule_map(TreeMap<String, TreeMap<String, String[]>> ap_owc_rule_map) {
        this.ap_owc_rule_map = ap_owc_rule_map;
    }

    public TreeMap<String, TreeMap<String, String[]>> getAp_owc_rule_map() {
        return ap_owc_rule_map;
    }

    public static void setLdapUtility(LDAPUtility ldapUtility) {
        OWCPropertyLoader.ldapUtility = ldapUtility;
    }

    public static LDAPUtility getLdapUtility() {
        return ldapUtility;
    }

    public void setLinks(HashMap<String, String> links) {
        this.links = links;
    }

    public HashMap<String, String> getLinks() {
        return links;
    }

}
