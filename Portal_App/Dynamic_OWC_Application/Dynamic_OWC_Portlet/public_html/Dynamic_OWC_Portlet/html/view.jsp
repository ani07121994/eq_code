<%@ page contentType = "text/html; charset=windows-1252"
         pageEncoding = "windows-1252"
         import = "javax.portlet.*, java.util.*,  qantas.eqportal.utility.*, qantas.eqportal.owc.portlet.*"%>
<%@ taglib uri = "http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects/>

<style>
<!--
 /* Font Definitions */
 @font-face
	{font-family:"Cambria Math";
	panose-1:2 4 5 3 5 4 6 3 2 4;}
@font-face
	{font-family:Calibri;
	panose-1:2 15 5 2 2 2 4 3 2 4;}
 /* Style Definitions */
 p.MsoNormal, li.MsoNormal, div.MsoNormal
	{margin-top:0cm;
	margin-right:0cm;
	margin-bottom:8.0pt;
	margin-left:0cm;
	line-height:107%;
	font-size:11.0pt;
	font-family:"Calibri","sans-serif";}

	

.MsoChpDefault
	{font-family:"Calibri","sans-serif";}
.MsoPapDefault
	{margin-bottom:8.0pt;
	line-height:107%;}
@page WordSection1
	{size:595.3pt 841.9pt;
	margin:72.0pt 72.0pt 72.0pt 72.0pt;}
div.WordSection1
	{page:WordSection1;}
-->
</style>


<%

//get username from request and the groups
LDAPUtility ldapHelper = OWCPropertyLoader.getInstance().getLdapUtility();
HashMap<String,String> allHeaderMAp = ldapHelper.getRequestHeaders(request);

  for(Map.Entry<String,String> entry : allHeaderMAp.entrySet()){
      System.out.println("Headers map===== "+entry.getValue()+"==key=="+entry.getKey());
     }

String userName = request.getHeader("Proxy-Remote-User");
System.out.println("-----Proxy-Remote-User1 : "+userName);
System.out.println("-----Proxy-Remote-User111111111111111111111111111111111 : "+userName);
HashMap<String, Object> details = ldapHelper.getUserDetails(userName);
System.out.println("==="+userName+"===belongs to====== " +details.get("groups"));
/*TreeMap<String ,TreeMap<String,String[]>>  ap_owc_rule_map = OWCPropertyLoader.getInstance().getAp_owc_rule_map();
System.out.println("ap_owc_rule_map size :: "+ap_owc_rule_map.size());*/
LinkedHashMap<String,String> appName_linkMap = new  LinkedHashMap<String,String>(); //Appname---->Link mapping
HashMap<String,String> links= OWCPropertyLoader.getInstance().getLinks();


boolean owc_bpm_flag =false;
boolean	owc_certifier_flag =false;
boolean	owc_imaging_flag=false;
boolean owc_bam_flag=false;
boolean owc_invoice_template_flag=false;    // 18th Jan 2019 | 21st Jan
boolean ap_flag = false;
boolean owc_wcc_flag=false; //WCC Change by 923018

boolean js_owc_bpm_flag =false;
boolean	js_owc_certifier_flag =false;
boolean	js_owc_imaging_flag=false;
boolean js_owc_bam_flag=false;
boolean js_owc_invoice_template_flag=false;
boolean js_flag = false;
boolean js_owc_wcc_flag=false;//WCC Change by 923018

final String verifier_app_name= "OWC Web Verifier";
final String imaging_app_name= "OWC Imaging";
final String bpm_app_name= "OWC BPM Workspace";
final String bam_app_name= "OWC BAM Dashboard";
final String template_app_name= "OWC Invoice Template QF";   // 18th Jan 2019  21st Jan
final String wcc_app_name= "OWC WebCenter Content"; //WCC Change by 923018

boolean to_be_shown_bam=false;
boolean to_be_shown_bpm = false;
boolean to_be_shown_imaging=false;
boolean to_be_shown_template=false;   // 18th Jan 2019
boolean to_be_shown_wcc=false; //WCC Change by 923018




/*Starts on 2nd Jan 2018*/

    if ((details != null) && (details.get("group") != null)) {      
        ArrayList<String> groups = (ArrayList)details.get("group")  ;
        for(String item :groups ){
            System.out.println("=========items in a group========== :: "+ item );
            if(item.toLowerCase().contains("js") ){
            //24th Jan 2019
                  if(item.toLowerCase().contains("owc_js_all") && !js_owc_bpm_flag && !js_owc_certifier_flag && !js_owc_imaging_flag && !js_owc_bam_flag ){ // 
                        js_owc_bpm_flag =true;
                        js_owc_certifier_flag =true;
                        js_owc_imaging_flag=true;
                        js_owc_bam_flag=true;

                        js_flag=true;
                        appName_linkMap.put("js,"+links.get("JS.OWC.Web.Verifier.Link"),verifier_app_name);
                        appName_linkMap.put("js,"+links.get("JS.OWC.Imaging.Link"),imaging_app_name);
                        appName_linkMap.put("js,"+links.get("JS.OWC.BPM.Workspace.Link"),bpm_app_name);
                        appName_linkMap.put("js,"+links.get("JS.OWC.BAM.Dashboard.Link"),bam_app_name);
                        System.out.println("Js all added");
                        
                    
                  }
                   else if(item.toLowerCase().contains("certifier_imaging") && 
                    !js_owc_imaging_flag && !js_owc_bpm_flag){
                  
                      js_owc_bpm_flag = true;
                      js_owc_imaging_flag = true;
                     
                      js_flag=true;
                   
                    appName_linkMap.put("js,"+ links.get("JS.OWC.Imaging.Link"),imaging_app_name);
                    appName_linkMap.put("js,"+links.get("JS.OWC.BPM.Workspace.Link"),bpm_app_name);
                    System.out.println("Js certifier_imaging added");
                  }
                  else if(item.toLowerCase().contains("imaging") && !js_owc_imaging_flag){
                    js_owc_imaging_flag=true;
                    js_flag=true;
                    appName_linkMap.put("js,"+links.get("JS.OWC.Imaging.Link"),imaging_app_name);
                    System.out.println("Js imaging added");
                  }
                  else if(item.toLowerCase().contains("certifier")  && !js_owc_bpm_flag){
                    
                    js_owc_bpm_flag = true;
                    js_flag=true;
                    
                    appName_linkMap.put("js,"+links.get("JS.OWC.BPM.Workspace.Link"),bpm_app_name);
                    System.out.println("Js certifier added");
                  }
                   
                  else if(item.toLowerCase().contains("bam") && !js_owc_bam_flag){
                    js_owc_bam_flag =true;
                    js_flag=true;
                    appName_linkMap.put("js,"+links.get("JS.OWC.BAM.Dashboard.Link"),bam_app_name);
                    System.out.println("Js bam added");
                  }
                  
                 
              
              
            }
           
            
            else{  //For AP groups not containg js in group name
                  if(item.toLowerCase().contains("owc_ap_all") && !owc_bpm_flag && !owc_certifier_flag && !owc_imaging_flag && !owc_bam_flag && !owc_wcc_flag ){  
                        owc_bpm_flag =true;
                        owc_certifier_flag =true;
                        owc_imaging_flag=true;
                        owc_bam_flag=true;
                        
                        ap_flag=true;
                        appName_linkMap.put("ap,"+links.get("AP.OWC.Web.Verifier.Link"),verifier_app_name);
                        appName_linkMap.put("ap,"+links.get("AP.OWC.Imaging.Link"),imaging_app_name);
                        appName_linkMap.put("ap,"+links.get("AP.OWC.BPM.Workspace.Link"),bpm_app_name);
                        appName_linkMap.put("ap,"+links.get("AP.OWC.BAM.Dashboard.Link"),bam_app_name);
                        
                        //923018
                         /* appName_linkMap.put("ap,"+ links.get("AP.OWC.WCC.Link"),wcc_app_name);
                         owc_wcc_flag=true;
                         System.out.println("New imaging added");*/
                         //923018- end
                        System.out.println("AP bam certifier_imaging added");
                        
                  }
                  else if(item.toLowerCase().contains("certifier_imaging") && 
                    !owc_imaging_flag && !owc_bpm_flag){
                  
                      owc_bpm_flag = true;
                      owc_imaging_flag = true;
                     
                      ap_flag=true;
                      
                      appName_linkMap.put("ap,"+links.get("AP.OWC.Imaging.Link"),imaging_app_name);
                     appName_linkMap.put("ap,"+ links.get("AP.OWC.BPM.Workspace.Link"),bpm_app_name);
                     System.out.println("AP bam certifier_imaging added");
                  }
                  else if(item.toLowerCase().contains("imaging") && !owc_imaging_flag){
                    owc_imaging_flag=true;
                    ap_flag=true;
                    appName_linkMap.put("ap,"+links.get("AP.OWC.Imaging.Link"),imaging_app_name);
                
                    System.out.println("AP imaging added");
                  }
                  else if(item.toLowerCase().contains("certifier") && !owc_bpm_flag ){
                    owc_bpm_flag=true;
                   
                    ap_flag=true;
                    
                    appName_linkMap.put("ap,"+ links.get("AP.OWC.BPM.Workspace.Link"),bpm_app_name);
                    System.out.println("AP certifier added");
                  }
                  
                  else if(item.toLowerCase().contains("bam") && !owc_bam_flag){
                    owc_bam_flag =true;
                    ap_flag=true;
                    appName_linkMap.put("ap,"+ links.get("AP.OWC.BAM.Dashboard.Link"),bam_app_name);
                    System.out.println("AP BAM added");
                  }
                  // 21st Jan 2019
                  else if(item.toLowerCase().contains("owc_template_qf") && !owc_invoice_template_flag){
                    owc_invoice_template_flag=true;
                    ap_flag=true;
                    appName_linkMap.put("ap,"+ links.get("AP.OWC.Invoice.Template.Link"),template_app_name);
                    System.out.println("AP Invoice Template added");
                    }
                    //WCC Change by 923018- Start
                   // else if(item.toLowerCase().contains("owc_template_qf") && !owc_wcc_flag){
                    else if(item.toLowerCase().contains("owc_wcc") && !owc_wcc_flag){
                    owc_wcc_flag=true;
                    ap_flag=true;
                    appName_linkMap.put("ap,"+ links.get("AP.OWC.WCC.Link"),wcc_app_name);
                    System.out.println("AP WCC added");
                    }
                    //WCC Change by 923018 -End
                  
                  
                  
            }
            
           
            
            
            
            
        }
        
         
   } 
        
                
/*Ends on 2nd Jan 2018*/



System.out.println("Ap flag status :::======"+ap_flag);
System.out.println("JS flag status :::======"+js_flag);
if(appName_linkMap!=null && !appName_linkMap.isEmpty()) {
     for(Map.Entry<String,String> entry : appName_linkMap.entrySet()){
      System.out.println("Before rendering appName_linkMap===== "+entry.getValue()+"==key=="+entry.getKey());
     }
 }



%>
<% if(ap_flag || js_flag){ %>
<table width="100%" id="rg43557" border="0" cellpadding="0" cellspacing="0" ><tbody><tr align="left">
<td valign="top" style="padding:0px 0px 0px 0px;width:100%;"><div id="p35_695116_35_695103_695106"><table border="0" cellspacing="0" cellpadding="0" width="100%" class="PortletHeaderColor">
<tbody><tr class="PortletHeaderColor">
<td align="left" class="LeftCurve"><img src="/welcome_images/WebCenter/Qantas/pobtrans.gif" height="1" width="10" alt=""></td>
<td align="left" class="PortletHeaderColor" style="width:100%;white-space:nowrap">
<h2 style="display:inline" class="PortletHeaderText">My OWC Applications</h2>
&nbsp;&nbsp;&nbsp;</td>
<td align="right" class="PortletHeaderColor" style="white-space:nowrap">
&nbsp;
</td>
<td align="right" class="RightCurve"><img src="/welcome_images/WebCenter/Qantas/pobtrans.gif" width="10" alt=""></td>
</tr>
</tbody></table>
<table border="1" width="100%" cellpadding="2" cellspacing="0" class="RegionBorder">
<tbody><tr><td class="RegionHeaderColor" style="width:100%"><div id="pcnt35_695116_35_695103_695106">
<div class="WordSection1">

<%if(appName_linkMap!=null && !appName_linkMap.isEmpty()) {
String app_name_to_show_AP =null;
String app_name_to_show_JS =null;
 for(Map.Entry<String,String> entry : appName_linkMap.entrySet()){
 if(entry.getKey().contains("ap,")){
    // 18th Jan 2019 | 21st Jan
    //WCC Change by 923018
    if((entry.getValue().equals("OWC BPM Workspace") && !to_be_shown_bpm) ||(entry.getValue().equals("OWC BAM Dashboard") && !to_be_shown_bam)||
    (entry.getValue().equals("OWC Imaging") && !to_be_shown_imaging) ||  (entry.getValue().equals("OWC WebCenter Content") && !to_be_shown_wcc) || (entry.getValue().equals("OWC Invoice Template QF") && !to_be_shown_template) || entry.getValue().equals("OWC Web Verifier")){
         app_name_to_show_AP=entry.getValue();
         if(entry.getValue().equals("OWC Web Verifier")){
         app_name_to_show_AP ="OWC QF Web Verifier";
         }
         if(entry.getValue().equals("OWC BPM Workspace")){
         to_be_shown_bpm=true;
         }
         else if(entry.getValue().equals("OWC BAM Dashboard")){
         to_be_shown_bam=true;
         }
         else if(entry.getValue().equals("OWC Imaging")){
         to_be_shown_imaging=true;
         }
         else if(entry.getValue().equals("OWC Invoice Template QF")){
         to_be_shown_template=true;      // 18th Jan 2019
         }
         //WCC Change by 923018
         else if(entry.getValue().equals("OWC WebCenter Content")){
         to_be_shown_wcc=true;      
         }
         
         

        %>
  <!--31st Jan 2019 target attribute added to a attribute  -->         
<p class="MsoNormal" style="margin-bottom:0cm;margin-bottom:.0001pt;line-height:
normal;background:white"><span style="font-size:9.0pt;color:#2E72B0"><img border="0" width="19" height="17" id="Picture 5" src="/welcome_images/WebCenter/Qantas/folder.jpg"></span><span style="font-size:9.0pt;color:#2E72B0"> <a href="<%=entry.getKey().toString().split(",")[1]%>" target="_blank"><span style="color:#2E72B0;text-decoration:none"> <%=app_name_to_show_AP%> </span></a></span></p>

        <%
          }
         }
         %>
        
   <%if(entry.getKey().contains("js,")){
// 24th Jan 2019
//WCC Change by 923018
if((entry.getValue().equals("OWC BPM Workspace") && !to_be_shown_bpm) ||(entry.getValue().equals("OWC BAM Dashboard") && !to_be_shown_bam)||
    (entry.getValue().equals("OWC Imaging") && !to_be_shown_imaging) || (entry.getValue().equals("OWC WebCenter Content") && !to_be_shown_wcc) || (entry.getValue().equals("OWC Invoice Template QF") && !to_be_shown_template) || entry.getValue().equals("OWC Web Verifier")){
         app_name_to_show_JS=entry.getValue();
         if(entry.getValue().equals("OWC Web Verifier")){
         app_name_to_show_JS ="OWC JS Web Verifier";
         }
         if(entry.getValue().equals("OWC BPM Workspace")){
         to_be_shown_bpm=true;
         }
         else if(entry.getValue().equals("OWC BAM Dashboard")){
         to_be_shown_bam=true;
         }
         else if(entry.getValue().equals("OWC Imaging")){
         to_be_shown_imaging=true;
         }
         else if(entry.getValue().equals("OWC Invoice Template QF")){
         to_be_shown_template=true;      // 1st Feb 2019
         }
         //WCC Change by 923018
         else if(entry.getValue().equals("OWC WebCenter Content")){
         to_be_shown_wcc=true;      // 1st Feb 2019
         }

        %>
  <!--31st Jan 2019 target attribute added to a attribute  -->        
<p class="MsoNormal" style="margin-bottom:0cm;margin-bottom:.0001pt;line-height:
normal;background:white"><span style="font-size:9.0pt;color:#2E72B0"><img border="0" width="19" height="17" id="Picture 5" src="/welcome_images/WebCenter/Qantas/folder.jpg"></span><span style="font-size:9.0pt;color:#2E72B0"> <a href="<%=entry.getKey().toString().split(",")[1]%>" target="_blank"><span style="color:#2E72B0;text-decoration:none"> <%=app_name_to_show_JS%> </span></a></span></p>
        
        <%}
          }
         }
        } %>     
        
        
     
</div>


</div></td></tr>
</tbody></table>
</div></td></tr>
</tbody></table>


<%}%>




<hr/>
