
package ap.quantas.com.holdReleaseWebService.oracle.xmlns.bpel.workflow.taskservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ap.quantas.com.holdReleaseWebService.oracle.bpel.services.workflow.common.model.WorkflowContextType;
import ap.quantas.com.holdReleaseWebService.oracle.bpel.services.workflow.task.model.Task;


/**
 * <p>Java class for taskServiceContextTaskTaskIdBaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskServiceContextTaskTaskIdBaseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/common}workflowContext" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{http://xmlns.oracle.com/bpel/workflow/task}task"/>
 *           &lt;element name="taskId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/choice>
 *         &lt;element name="skipCallback" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taskServiceContextTaskTaskIdBaseType", propOrder = {
    "workflowContext",
    "task",
    "taskId",
    "skipCallback"
})
@XmlSeeAlso({
    RequestInfoForTaskType.class,
    RemoveDocumentType.class,
    AddCommentType.class,
    RenewTaskType.class,
    ReassignTaskType.class,
    RouteTaskType.class,
    RemoveAttachmentType.class,
    UpdateTaskOutcomeType.class,
    ReevaluateTaskType.class,
    OverrideRoutingSlipType.class,
    AddDocumentType.class,
    AddAttachmentType.class,
    DelegateTaskType.class
})
public class TaskServiceContextTaskTaskIdBaseType {

    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/common")
    protected WorkflowContextType workflowContext;
    @XmlElement(namespace = "http://xmlns.oracle.com/bpel/workflow/task")
    protected Task task;
    protected String taskId;
    protected Boolean skipCallback;

    /**
     * Gets the value of the workflowContext property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowContextType }
     *     
     */
    public WorkflowContextType getWorkflowContext() {
        return workflowContext;
    }

    /**
     * Sets the value of the workflowContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowContextType }
     *     
     */
    public void setWorkflowContext(WorkflowContextType value) {
        this.workflowContext = value;
    }

    /**
     * Gets the value of the task property.
     * 
     * @return
     *     possible object is
     *     {@link Task }
     *     
     */
    public Task getTask() {
        return task;
    }

    /**
     * Sets the value of the task property.
     * 
     * @param value
     *     allowed object is
     *     {@link Task }
     *     
     */
    public void setTask(Task value) {
        this.task = value;
    }

    /**
     * Gets the value of the taskId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Sets the value of the taskId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskId(String value) {
        this.taskId = value;
    }

    /**
     * Gets the value of the skipCallback property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkipCallback() {
        return skipCallback;
    }

    /**
     * Sets the value of the skipCallback property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkipCallback(Boolean value) {
        this.skipCallback = value;
    }

}
