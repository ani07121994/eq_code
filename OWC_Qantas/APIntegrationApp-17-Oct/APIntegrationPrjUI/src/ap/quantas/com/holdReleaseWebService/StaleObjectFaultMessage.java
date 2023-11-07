package ap.quantas.com.holdReleaseWebService;

import javax.xml.ws.WebFault;

@WebFault(faultBean="ap.quantas.com.holdReleaseWebService.oracle.xmlns.bpel.workflow.taskservice.FaultMessageType",
  targetNamespace="http://xmlns.oracle.com/bpel/workflow/taskService",
  name="staleObjectFault")
public class StaleObjectFaultMessage
  extends Exception
{
  private ap.quantas.com.holdReleaseWebService.oracle.xmlns.bpel.workflow.taskservice.FaultMessageType faultInfo;

  public StaleObjectFaultMessage(String message,
                                 ap.quantas.com.holdReleaseWebService.oracle.xmlns.bpel.workflow.taskservice.FaultMessageType faultInfo)
  {
    super(message);
    this.faultInfo = faultInfo;
  }

  public StaleObjectFaultMessage(String message,
                                 ap.quantas.com.holdReleaseWebService.oracle.xmlns.bpel.workflow.taskservice.FaultMessageType faultInfo,
                                 Throwable t)
  {
    super(message,t);
    this.faultInfo = faultInfo;
  }

  public ap.quantas.com.holdReleaseWebService.oracle.xmlns.bpel.workflow.taskservice.FaultMessageType getFaultInfo()
  {
    return faultInfo;
  }

  public void setFaultInfo(ap.quantas.com.holdReleaseWebService.oracle.xmlns.bpel.workflow.taskservice.FaultMessageType faultInfo)
  {
    this.faultInfo = faultInfo;
  }
}
// !DO NOT EDIT THIS FILE!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102)
