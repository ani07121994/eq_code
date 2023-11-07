package view.qantas.com.au.overseas.utility;

import javax.faces.context.FacesContext;

import javax.naming.NamingException;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;

public class UserDetails {
    public UserDetails() {
        super();
    }
    public String userName;
    private String imagePath;
    private String headerText;
    
    public String getHeaderText(){
        String orgId=(String) ADFContext.getCurrent().getPageFlowScope().get("ORG");
        System.out.println("Header Text Block : "+orgId);
        if (orgId.equalsIgnoreCase("JS")){
            headerText= "OWC Invoice Template JS";
        }
        else{
            headerText="OWC Invoice Template QF";
        }
        return headerText;
    }
    
    public String getImagePath(){
        String orgId=(String) ADFContext.getCurrent().getPageFlowScope().get("ORG");
        System.out.println("Image Path Block : "+orgId);
        if (orgId.equalsIgnoreCase("JS")){
            imagePath="/Images/jetstarlogo.png";
        }
        else{
            imagePath="/Images/qantaslogo.gif";
        }
        return imagePath;
    }
    
    public String getShowUserDetails(){
        System.out.println("SEtting header user on page template load");
        ADFContext afcontext =   ADFContext.getCurrent();
       
            
            HttpServletRequest req = (HttpServletRequest) afcontext.getEnvironment().getRequest(); 
            String user = req.getHeader("Proxy-Remote-User")!= null ? req.getHeader("Proxy-Remote-User").toString() : null;
            System.out.println("user :: "+user);
             setUserName(user);   
            return userName;
            
      

    }
    
    public void logout(){
                
        System.out.println("Session has been invalidated");         
        FacesContext fctx = FacesContext.getCurrentInstance();
        HttpSession session =(HttpSession)fctx.getExternalContext().getSession(false);
        session.invalidate();
        System.out.println("Session has been invalidated");
        return;
       
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return "TestUser";
    }
}