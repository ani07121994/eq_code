package model.bpmutil;

public class BPMUserDetails {
    
    public BPMUserDetails() {
        super();
    }
    
    public String getAuthenticatedUserFromBPM(String username){
         return "Hello " + username; 
    }
    
}
