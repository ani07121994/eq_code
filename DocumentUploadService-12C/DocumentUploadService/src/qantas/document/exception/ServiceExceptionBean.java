package qantas.document.exception;

public class ServiceExceptionBean {
    private String message;
 
    public ServiceExceptionBean() {
    }
    public ServiceExceptionBean(String message) {
        this.message = message;
    }
 
    public String getMessage() {
        return message;
    }
 
}