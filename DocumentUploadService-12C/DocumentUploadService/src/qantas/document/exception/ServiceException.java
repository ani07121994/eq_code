package qantas.document.exception;

import javax.xml.ws.WebFault;

@WebFault(name="ServiceException")
public class ServiceException extends Exception{
    private ServiceExceptionBean faultBean;
 
    public ServiceException(String message, ServiceExceptionBean faultInfo){
        super(message);
        faultBean = faultInfo;
    }
 
    public ServiceException(String message, ServiceExceptionBean faultInfo, Throwable cause) {
        super(message, cause);
        faultBean = faultInfo;
    }
 
    public ServiceExceptionBean getFaultInfo(){
        return faultBean;
    }
}