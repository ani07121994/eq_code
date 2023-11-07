
package ap.quantas.com.imaging.documentSearchService;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "ValidationException", targetNamespace = "http://imaging.oracle/")
public class ValidationException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ValidationFaultInfo faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ValidationException(String message, ValidationFaultInfo faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ValidationException(String message, ValidationFaultInfo faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ap.quantas.com.imaging.documentSearchService.ValidationFaultInfo
     */
    public ValidationFaultInfo getFaultInfo() {
        return faultInfo;
    }

}
