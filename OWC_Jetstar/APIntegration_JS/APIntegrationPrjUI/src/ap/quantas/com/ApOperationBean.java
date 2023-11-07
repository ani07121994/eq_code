package ap.quantas.com;

import ap.quantas.com.bamUpdateWebService.DataObjectOperationsByID;
import ap.quantas.com.ebsAutofillWebservice.APPSINVOICEHEADERREC;
import ap.quantas.com.ebsAutofillWebservice.APPSINVOICEINTBLTYPE;
import ap.quantas.com.ebsAutofillWebservice.APPSINVOICELINEREC;
import ap.quantas.com.ebsAutofillWebservice.InputParameters;
import ap.quantas.com.ebsAutofillWebservice.ObjectFactory;
import ap.quantas.com.ebsAutofillWebservice.OutputParameters;
import ap.quantas.com.ebsAutofillWebservice.UpdatePttBindingQSService;
import ap.quantas.com.ebsCalculateInvoiceDueDateWebService.DueDateService_pttBindingQSPortClient;

import ap.quantas.com.imaging.ImagingWSTestClient;
import ap.quantas.com.imaging.ImagingWSTestClient.*;
import ap.quantas.com.imaging.documentUpdate.DocumentService;
import ap.quantas.com.imaging.WSSecurityHeaderSOAPHandler;
import ap.quantas.com.imaging.documentUpdate.DocumentService_Service;
import ap.quantas.com.imaging.documentUpdate.FieldType;
import ap.quantas.com.imaging.documentUpdate.FieldValue;

import ap.quantas.com.imaging.documentUpdate.TypedValue;

import javax.xml.ws.handler.Handler;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import java.lang.reflect.Method;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import java.util.Map;
import java.util.Timer;

import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import javax.activation.FileDataSource;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.PhaseId;

import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.naming.InitialContext;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import javax.xml.transform.stream.StreamResult;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.xpath.XPath;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import model.APOperationAMImpl;
import model.EbsAMImpl;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.render.ClientEvent;


import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.bpel.services.workflow.StaleObjectException;
import oracle.bpel.services.workflow.WorkflowException;
import oracle.bpel.services.workflow.client.IWorkflowServiceClient;
import oracle.bpel.services.workflow.query.ITaskQueryService;
import oracle.bpel.services.workflow.repos.Predicate;
import oracle.bpel.services.workflow.repos.TableConstants;
import oracle.bpel.services.workflow.task.ITaskService;
import oracle.bpel.services.workflow.task.model.Task;
import oracle.bpel.services.workflow.verification.IWorkflowContext;
import oracle.bpel.services.workflow.worklist.adf.ADFWorklistBeanUtil;
import oracle.bpel.services.workflow.worklist.adf.InvokeActionBean;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.NameValuePairs;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.uicli.binding.JUCtrlHierBinding;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.event.RangeChangeEvent;
import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.model.RowKeySetImpl;
import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.ComponentUtils;
import org.apache.myfaces.trinidad.util.Service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// imaging web service related imports
//import ap.quantas.com.imaging.documentContentService.DocumentContentService;
//import ap.quantas.com.imaging.documentContentService.DocumentContentService_Service;
//import ap.quantas.com.imaging.documentContentService.Rendition;
//import ap.quantas.com.imaging.documentContentService.RenditionOutput;

import oracle.imaging.DocumentContentService;
import oracle.imaging.DocumentContentService_Service;
import oracle.imaging.Rendition;
import oracle.imaging.RenditionOutput;

import java.io.FileOutputStream;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

import ap.quantas.com.ContentIdGenerator;

import ap.quantas.com.jsEbsCalculateDueDate.JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEPortClient;

import java.util.LinkedHashMap;

import oracle.bpel.services.workflow.task.model.CustomAttributesType;
import oracle.bpel.services.workflow.task.model.SystemAttributesType;

import org.w3c.dom.NamedNodeMap;

public class ApOperationBean {
    private RichPopup p1;
    private RichPopup p2;
    private RichPopup p4;
    private RichPopup p5;
    private RichInputText supNameIt;
    private RichInputText siteIdIt;
    private RichInputText invNumIt;
    private RichInputText taxRegIt;
    private RichInputText poNumIt;
    private RichInputText lineIdIt;
    private RichInputText certNameIt;
    private RichInputText currencyIt;
    private RichInputDate invDateId;
    private RichInputText taxTotIt;
    private RichInputText headerTotIt;
    private RichInputText certEmailIt;
    private RichInputText supNamePopupIt;
    private RichTable supDetailsTable;
    private RichInputText siteNamePopupIt;
    private RichTable siteDetailsTable;
    private RichInputText poNumPopupIt;
    private RichTable poDetailsTable;

    private String emailTo;
    private String emailCc;
    private String emailBcc;
    private String emailFrom;
    private String emailSubj;
    private String emailBody;
    private String mailData;
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private RichPopup emailPopup;
    private RichTable lineDetailsTable;
    private RichSelectOneChoice reasonSOC;
    private RichSelectOneChoice statusSOC;
    private RichSelectOneChoice typeSOC;
    private RichPanelFormLayout expPsl1;
    private RichPanelFormLayout expPfl1;
    private RichPopup commentPopup;
    private RichInputText commentsIt;
    private RichInputText commentsPopupIt;
    private RichPopup certCommentsPopup;
    private RichInputText certCommentsPopupIt;
    private RichInputText certCommentsIt;
    private String invoiceId;
    private transient boolean isDataLoaded = false;
    private int counter = 0;
    private RichPanelGroupLayout exceptionPgl;
    private RichPanelGroupLayout lineTableOuterPgl;
    private RichPanelGroupLayout headerOuterPgl;
    private RichPopup p8;
    private RichPopup p9;
    private RichPopup p10;
    private RichSelectOneChoice docTypeSoc;
    private RichPopup validationErrorPopup;
    private RichOutputText validationErrorMessage;
    private RichSelectOneChoice invoiceTypeSoc;
    private RichInputText suppNumIt;
    private RichInputText siteNameIt;

    private RichInputText operatingUnitIt;

    private RichTable certifierNameDetailsTable;
    private RichInputText certifierNamePopupIT;
    private RichInputText poLineNumPopupIt;
    private RichTable poLineNumberTable;
    private RichInputText siteCurrencyPopupIt;
    private RichInputText currencyCodePopupIT;
    private RichTable currencyCodeDetailsTable;
    private RichOutputText validationErrorMessage1;
    private RichInputText employeeNoIt;
    private RichTable taxRateCodeDetailsTable;
    private RichPopup validationErrorPopup1;
    private RichInputText taxRateCodePopupIt;
    private RichOutputText exceptionOt;
    private RichPanelGroupLayout exceptionMsgPgl;
    private boolean isAPPageLoadCompleted = false;
    private RichInputText isLineItemPopup;
    private RichInputText clientID;
    private RichCommandButton selectPOLineNumPopup;
    private RichInputText bpmTaskAcquiredByUserIdIt;
    private RichForm apOperationPageForm;
    private RichCommandButton matchButton;
    private RichCommandButton notifyButton;
    private RichCommandButton saveButton;
    private RichCommandButton submitButton;
    private RichInputText supplierID;
    private RichInputText documentIdIt;
    private RichInputText descPopupIt;
    private RichPopup descPopup;
    private RichSelectOneChoice siteLOVSoc;
    private RichInputText lineTotal;
    private RichInputText taxRateCodeLine;
    private RichInputText taxAmountLine;
    private RichSelectOneChoice reasonSoc;
    private RichSelectOneChoice reasonTypeSoc;
    private RichCommandImageLink addRowIcon;
    private RichCommandImageLink deleteRowIcon;
    private RichOutputText lineTotalSum;
    private RichOutputText taxAmountSum;

    private PropertyLoader propertyLoader = PropertyLoader.getInstance();
    private RichOutputText certifierNameErrorOT;
    private int certifierFlag = 0;
    private String chosenCertifierName;
    private String chosenEmployeeId;
    private RichInputText bpmStatus;
    private RichCommandButton syncButton;
    private RichSelectOneChoice searchByCertifiername;
    private RichSelectBooleanCheckbox parentCheckBox;
    private RichSelectBooleanCheckbox subCheckBox;
    private RichTable apCommentsTable;
    private RichPopup apCommentsTableDescPopup;
    private RichInputText apCommentsTableDescPopUpIt;
    private RichCommandButton onAPCommentsTableDescriptionPopupOKClick;
    private RichOutputText sumOfTaxTotal;
    private RichOutputText sumOfLineTotal;
    private RichInputText whtAmountIt;
    private RichInputText freight;
    private RichInputText aog;
    private RichPopup p13;
    private RichInputText whtCodePopupIT;
    private RichTable whtCodeDetailsTable;
    private RichSelectBooleanCheckbox whtRequiredFlag;
    private RichInputText whtCodeColumn;
    private RichCommandImageLink whtCodeSearchIcon;

    oracle.jbo.domain.Number freight_total;
    oracle.jbo.domain.Number aog_total;
    protected static String tempQuantity = null, tempUnitPrice = null, tempTaxRateCode = null;

    public ApOperationBean() {
        //        super();
        //        try{
        //            if(resolveExpression("#{ApOperationBean}") != null)
        //                System.out.println("Req Scope ApOperationBean: "+(ApOperationBean)resolveExpression("#{ApOperationBean}"));
        //        }
        //        catch(Exception e) {
        //            e.printStackTrace();
        //        }

        //        System.out.println("Start: ApOperationBean");
        //        System.out.println("counter: "+counter);
        //        counter++;
        //        BindingContext bindingContext = null;
        //        BindingContainer bindingContainer = null;
        //        OperationBinding operationBinding = null;
        //        System.out.println("isDataLoadedgv: "+isDataLoaded);
        //        if(!isDataLoaded){
        //            try {
        //                invoiceId = getInvoiceId();
        //
        //                bindingContext = BindingContext.getCurrent();
        //                bindingContainer = bindingContext.getCurrentBindingsEntry();
        //                operationBinding = bindingContainer.getOperationBinding("executeHeaderLineItemDetails");
        //                System.out.println("operationBinding: "+operationBinding);
        //                if(operationBinding != null && invoiceId != null)
        //                {
        //                    operationBinding.getParamsMap().put("invoiceId",invoiceId);
        //                    System.out.println("operationBinding: "+operationBinding);
        //                    System.out.println("operationBinding paramMap: "+operationBinding.getParamsMap());
        //                    operationBinding.execute();
        //                    isDataLoaded = true;
        //                    System.out.println("executeHeaderLineItemDetails executed");
        //                }
        //            }
        //            catch(Exception e) {
        //                e.printStackTrace();
        //            }
        //        }
        //
        //
        //        System.out.println("ApOperationBean obj: "+ApOperationBean.this);
        //        System.out.println("End: ApOperationBean");

        //System.out.println("ApOperationBean Updatedddddd Const");

    }

    private String getInvoiceId() {
        String invoiceIdFromBinding = null;
        if (resolveExpression("#{bindings.invoiceID.inputValue}") != null)
            invoiceIdFromBinding = resolveExpression("#{bindings.invoiceID.inputValue}").toString();


        System.out.println("--------------Invoice Id From Binding: " + invoiceIdFromBinding);


        return invoiceIdFromBinding;
    }
    // added by sourav and santha

    private String getSupplierName() {
        String supplierNameFromBinding = null;
        if (resolveExpression("#{bindings.SupplierName.inputValue}") != null)
            supplierNameFromBinding = resolveExpression("#{bindings.SupplierName.inputValue}").toString();


        System.out.println("--------------supplierNameFromBinding: " + supplierNameFromBinding);

        return supplierNameFromBinding;
    }
    // added by sourav and santha
    private String getSiteId() {
        String siteNameFromBinding = null;
        if (resolveExpression("#{bindings.SiteId.inputValue}") != null)
            siteNameFromBinding = resolveExpression("#{bindings.SiteId.inputValue}").toString();


        System.out.println("--------------siteNameFromBinding: " + siteNameFromBinding);

        return siteNameFromBinding;
    }


    private void recursiveDisableUIComponents(UIComponent parent) {
        List<UIComponent> children = parent.getChildren();
        if (children == null || children.size() == 0) {
            return;
        }

        for (UIComponent child : children) {
            //child.setValueExpression(arg0, arg1);

            //System.out.println(child.getClass()+", "+child);
            if (child instanceof RichInputText) {
                ((RichInputText) child).setDisabled(true);
                ((RichInputText) child).setReadOnly(true);
            } else if (child instanceof RichSelectOneChoice) {
                ((RichSelectOneChoice) child).setDisabled(true);
                ((RichSelectOneChoice) child).setReadOnly(true);
            } else if (child instanceof RichCommandButton) {
                ((RichCommandButton) child).setDisabled(true);
            } else {

                recursiveDisableUIComponents(child);
            }
        }
    }


    public void makeFormReadOnly(FacesContext facesContext, UIComponent component) {
        try {
            Method[] methods = component.getClass().getMethods();
            for (Method method : methods) {
                if (method.getName().equals("getChildren")) {
                    List<UIComponent> listaComp = (List<UIComponent>) method.invoke(component);
                    for (UIComponent comp : listaComp) {
                        makeFormReadOnly(facesContext, comp);
                    }
                }
            }
            component.setValueExpression("readOnly", getValueExpression(facesContext, "#{true}"));
            component.setValueExpression("disabled", getValueExpression(facesContext, "#{true}"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ValueExpression getValueExpression(FacesContext facesContext, String name) {
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        return elFactory.createValueExpression(elContext, name, Object.class);
    }

    public void onPageLoad(ClientEvent clientEvent) {
        System.out.println("Start: onPageLoad");
        try {
            AdfFacesContext.getCurrentInstance()
                           .getPageFlowScope()
                           .put("js_onPageLoadFlag", "yes");
            System.out.println("-----js_onPageLoadFlag : " + AdfFacesContext.getCurrentInstance()
                                                                            .getPageFlowScope()
                                                                            .get("js_onPageLoadFlag"));
            System.out.println("New logic changes in Js onPageLoad 16-02-2023");

            FacesContext context = FacesContext.getCurrentInstance();
            String ctx =
                (String) context.getApplication()
                .evaluateExpressionGet(context, "#{pageFlowScope.bpmWorklistContext}", String.class);
            IWorkflowServiceClient workflowSvcClient = ADFWorklistBeanUtil.getWorkflowServiceClient();
            //currentTask.getSystemAttributes().getState()

            ITaskQueryService wfQueryService = workflowSvcClient.getTaskQueryService();

            String taskId =
                (String) context.getApplication()
                .evaluateExpressionGet(context, "#{pageFlowScope.bpmWorklistTaskId}", String.class);

            tempQuantity = null;
            tempUnitPrice = null;
            tempTaxRateCode = null;
            IWorkflowContext wfContext;
            String userName = "";
            wfContext = wfQueryService.getWorkflowContext(ctx);


            System.out.println("Before getting task 16-02-2023 ::  " + taskId);
            Task task = wfQueryService.getTaskDetailsById(wfContext, taskId);
            String state = null;
            if (task != null) {

                System.out.println("Task is not null");


                state = task.getSystemAttributes().getState();

                System.out.println("State of current task  ::  " + state != null ? state : "is null");

            }

            userName = wfContext.getUser();


            System.out.println("----- BPM User : " + userName);
            System.out.println("wht required flag value in APOperationBean :" + AdfFacesContext.getCurrentInstance().getPageFlowScope().get("whtRequiredFlag"));

            oracle.jbo.domain.Number amount;

            String acquiredByUserId =
                bpmTaskAcquiredByUserIdIt.getValue() == null ? null : (String) bpmTaskAcquiredByUserIdIt.getValue();

            if (userName != null && acquiredByUserId != null && !userName.equals(acquiredByUserId)) {

                recursiveDisableUIComponents(apOperationPageForm);

                System.out.println("acquired by different user");

                matchButton.setDisabled(true);
                notifyButton.setDisabled(true);
                saveButton.setDisabled(true);
                submitButton.setDisabled(true);
                addRowIcon.setDisabled(true);
                deleteRowIcon.setDisabled(true);
                whtRequiredFlag.setDisabled(true); //wht required flag change on page load : sourav


                if (AdfFacesContext.getCurrentInstance()
                                   .getPageFlowScope()
                                   .get("whtRequiredFlag") != null && AdfFacesContext.getCurrentInstance()
                                                                                     .getPageFlowScope()
                                                                                     .get("whtRequiredFlag")
                                                                                     .toString()
                                                                                     .equals("no")) {
                    //whtRequiredFlag.setSelected(false); // on 26th may
                    whtCodeColumn.setDisabled(true);
                    whtCodeSearchIcon.setDisabled(true);
                }
                /*
                    if(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("whtRequiredFlag")!=null
                       && AdfFacesContext.getCurrentInstance().getPageFlowScope().get("whtRequiredFlag").toString().equals("yes")  && AdfFacesContext.getCurrentInstance().getPageFlowScope().get("defaultWHTCode")!=null

                        && !(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("adfPage_InternalStatus")!=null &&  (AdfFacesContext.getCurrentInstance().getPageFlowScope().get("adfPage_InternalStatus").toString().equals("From_ADF_APOps_Submit")

                           ||AdfFacesContext.getCurrentInstance().getPageFlowScope().get("adfPage_InternalStatus").toString().equalsIgnoreCase("From_ADF_APOps_Save")))

                     &&(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("InvalidReason")!=null && !AdfFacesContext.getCurrentInstance().getPageFlowScope().get("InvalidReason").toString().equalsIgnoreCase("CERTIFIER REJECTION"))
                     || !(ADFContext.getCurrent().getPageFlowScope().get("HeaderAttr8Check")!=null && ADFContext.getCurrent().getPageFlowScope().get("HeaderAttr8Check").toString().equals("yes"))){
                        //whtRequiredFlag.setSelected(true); // on 26th may
                        modifyWhtCodeColumn(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("defaultWHTCode").toString());
                    }
                    */
                AdfFacesContext.getCurrentInstance().addPartialTarget(apOperationPageForm);

                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                validationErrorPopup.show(hints);
                this.validationErrorMessage.setValue("Currently this task is acquired by a different user with userid '" +
                                                     acquiredByUserId + "'. You cannot make any changes to this task.");
            }

            if (userName != null && acquiredByUserId != null && userName.equals(acquiredByUserId)) {

                System.out.println("setting wht code changes from pageload");

                // System.out.println("WHT REQUIRED CHECKBOX VAL :"+whtRequiredFlag.isSelected());

                /* if(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("whtRequiredFlag")!=null && AdfFacesContext.getCurrentInstance().getPageFlowScope().get("whtRequiredFlag").toString().equals("yes")
                 && AdfFacesContext.getCurrentInstance().getPageFlowScope().get("defaultWHTCode")!=null && !(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("adfPage_InternalStatus")!=null &&  (AdfFacesContext.getCurrentInstance().getPageFlowScope().get("adfPage_InternalStatus").toString().equals("From_ADF_APOps_Submit")
                      ||AdfFacesContext.getCurrentInstance().getPageFlowScope().get("adfPage_InternalStatus").toString().equalsIgnoreCase("From_ADF_APOps_Save")))
                 &&(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("InvalidReason")!=null && !AdfFacesContext.getCurrentInstance().getPageFlowScope().get("InvalidReason").toString().equalsIgnoreCase("CERTIFIER REJECTION"))
                 ||
                !(ADFContext.getCurrent().getPageFlowScope().get("HeaderAttr8Check")!=null && ADFContext.getCurrent().getPageFlowScope().get("HeaderAttr8Check").toString().equals("yes")))
                */
                if (AdfFacesContext.getCurrentInstance()
                                   .getPageFlowScope()
                                   .get("whtRequiredFlag") != null && AdfFacesContext.getCurrentInstance()
                                                                                     .getPageFlowScope()
                                                                                     .get("whtRequiredFlag")
                                                                                     .toString()
                                                                                     .equals("yes")) {

                    whtRequiredFlag.setDisabled(false);
                    //whtRequiredFlag.setSelected(true); commented today
                    //modifyWhtCodeColumn(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("defaultWHTCode").toString()); commented today
                    //System.out.println("WHT Amount Value on Page Load AP Operation Bean :"+AdfFacesContext.getCurrentInstance().getPageFlowScope().get("whtAmount") != null ? AdfFacesContext.getCurrentInstance().getPageFlowScope().get("whtAmount").toString() : "Calculated WHT Amount is null ");

                    if (ADFContext.getCurrent()
                                  .getPageFlowScope()
                                  .get("whtAmount") != null && ADFContext.getCurrent()
                                                                         .getPageFlowScope()
                                                                         .get("WHTFlagOnPageLoad")
                                                                         .toString()
                                                                         .equalsIgnoreCase("false")) {

                        try {
                            System.out.println("setting default wht amount on page load from AP Bean");
                            amount = new oracle.jbo.domain.Number(Double.parseDouble(ADFContext.getCurrent()
                                                                                               .getPageFlowScope()
                                                                                               .get("whtAmount")
                                                                                               .toString()));
                            whtAmountIt.setValue(amount);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    if (ADFContext.getCurrent()
                                  .getPageFlowScope()
                                  .get("errorMessage") != null && !ADFContext.getCurrent()
                                                                             .getPageFlowScope()
                                                                             .get("errorMessage")
                                                                             .toString()
                                                                             .equalsIgnoreCase("success")) {
                        RichPopup.PopupHints hints = new RichPopup.PopupHints();
                        validationErrorPopup.show(hints);
                        this.validationErrorMessage.setValue(ADFContext.getCurrent()
                                                                       .getPageFlowScope()
                                                                       .get("errorMessage")
                                                                       .toString());
                    }
                } else if (AdfFacesContext.getCurrentInstance()
                                          .getPageFlowScope()
                                          .get("whtRequiredFlag") != null && AdfFacesContext.getCurrentInstance()
                                                                                            .getPageFlowScope()
                                                                                            .get("whtRequiredFlag")
                                                                                            .toString()
                                                                                            .equals("no")) {
                    System.out.println("else block acquired by user : wht not required");
                    whtRequiredFlag.setDisabled(true);
                    //whtRequiredFlag.setSelected(false); // on 26th may
                    whtCodeColumn.setDisabled(true);
                    whtCodeSearchIcon.setDisabled(true);
                }

                if (!whtRequiredFlag.isSelected()) {
                    System.out.println("setting wht code column disabled on page load");
                    whtCodeColumn.setDisabled(true);
                    whtCodeSearchIcon.setDisabled(true);
                }

                AdfFacesContext.getCurrentInstance().addPartialTarget(apOperationPageForm);
            }

            if (userName != null && acquiredByUserId == null) {

                recursiveDisableUIComponents(apOperationPageForm);
                System.out.println("task not acquired");

                matchButton.setDisabled(true);
                notifyButton.setDisabled(true);
                saveButton.setDisabled(true);
                submitButton.setDisabled(true);
                addRowIcon.setDisabled(true);
                deleteRowIcon.setDisabled(true);
                whtRequiredFlag.setDisabled(true); //wht required flag change on page load : sourav
                System.out.println("whtRequiredFlag :" + AdfFacesContext.getCurrentInstance()
                                                                        .getPageFlowScope()
                                                                        .get("whtRequiredFlag"));
                if (AdfFacesContext.getCurrentInstance()
                                   .getPageFlowScope()
                                   .get("whtRequiredFlag") != null && AdfFacesContext.getCurrentInstance()
                                                                                     .getPageFlowScope()
                                                                                     .get("whtRequiredFlag")
                                                                                     .toString()
                                                                                     .equals("no")) {

                    whtCodeColumn.setDisabled(true);
                    whtCodeSearchIcon.setDisabled(true);
                }


                /*  if(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("whtRequiredFlag")!=null && AdfFacesContext.getCurrentInstance().getPageFlowScope().get("whtRequiredFlag").toString().equals("yes")
                   && AdfFacesContext.getCurrentInstance().getPageFlowScope().get("defaultWHTCode")!=null

                    && !(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("adfPage_InternalStatus")!=null &&  (AdfFacesContext.getCurrentInstance().getPageFlowScope().get("adfPage_InternalStatus").toString().equals("From_ADF_APOps_Submit")
                        ||AdfFacesContext.getCurrentInstance().getPageFlowScope().get("adfPage_InternalStatus").toString().equalsIgnoreCase("From_ADF_APOps_Save")))
                    &&(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("InvalidReason")!=null && !AdfFacesContext.getCurrentInstance().getPageFlowScope().get("InvalidReason").toString().equalsIgnoreCase("CERTIFIER REJECTION"))

                    || !(ADFContext.getCurrent().getPageFlowScope().get("HeaderAttr8Check")!=null && ADFContext.getCurrent().getPageFlowScope().get("HeaderAttr8Check").toString().equals("yes")))
                    modifyWhtCodeColumn(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("defaultWHTCode").toString());*/ //cpmmented today

                AdfFacesContext.getCurrentInstance().addPartialTarget(apOperationPageForm);

                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                validationErrorPopup.show(hints);
                this.validationErrorMessage.setValue("This task has not been acquired. It is recommended that a task is claimed before making any changes to it. This avoids concurrent updates by multiple users.");
            }

            AdfFacesContext.getCurrentInstance()
                           .getPageFlowScope()
                           .put("certifierFlagInScope", 0);
            System.out.println("AdfFacesContext.getCurrentInstance().getPageFlowScope() page load " +
                               AdfFacesContext.getCurrentInstance()
                                                                                                                     .getPageFlowScope()
                                                                                                                     .get("certifierFlagInScope"));

            if (state != null && state.equals("COMPLETED")) {
                matchButton.setDisabled(true);
                notifyButton.setDisabled(true);
                saveButton.setDisabled(true);
                submitButton.setDisabled(true);
                addRowIcon.setDisabled(true);
                deleteRowIcon.setDisabled(true);
                whtRequiredFlag.setDisabled(true);
                syncButton.setDisabled(true);


            }


        } catch (WorkflowException e) {
            e.printStackTrace();
        }


        //String showSavedSuccessMsg = AdfFacesContext.getCurrentInstance().getPageFlowScope().get("showSavedSuccessMsg")!=null ? AdfFacesContext.getCurrentInstance().getPageFlowScope().get("showSavedSuccessMsg").toString():"";
        String showSavedSuccessMsg = FacesContext.getCurrentInstance()
                                                 .getExternalContext()
                                                 .getSessionMap()
                                                 .get("showSavedSuccessMsg") != null ? FacesContext.getCurrentInstance()
                                                                                                   .getExternalContext()
                                                                                                   .getSessionMap()
                                                                                                   .get("showSavedSuccessMsg")
                                                                                                   .toString() : "";
        System.out.println("inside page load showSavedSuccessMsg :::" + showSavedSuccessMsg);

        if (showSavedSuccessMsg.equalsIgnoreCase("Record has been Saved Successfully")) {
            //AdfFacesContext.getCurrentInstance().getPageFlowScope().put("showSavedSuccessMsg", "");
            FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getSessionMap()
                        .put("showSavedSuccessMsg", "");
            //            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            //            validationErrorPopup.show(hints);
            //            this.validationErrorMessage.setValue("Record has been Saved Successfully");
        }
        //To-DO
        //check showSavedSuccessMsg - if found show saved msg, remove attribute


        System.out.println("End: onPageLoad");
    }

    public void afterPhase(javax.faces.event.PhaseEvent phaseEvent) {
        /*
        System.out.println("Start: AfterPhase");
        System.out.println("--------------phaseEvent: "+phaseEvent.getPhaseId());
        System.out.println("--------------invoice id: "+getInvoiceId());
        System.out.println("--------------Supplier Name: "+getSupplierName());
        System.out.println("--------------Site Name: "+getSiteId());



        if (phaseEvent.getPhaseId() == PhaseId.PROCESS_VALIDATIONS) {
            System.out.println("--------------PROCESS_VALIDATIONS");
//                    FacesContext fctx = FacesContext.getCurrentInstance();
//                    FacesMessage message =
//                        new FacesMessage("PROCESS_VALIDATIONS");
//                    fctx.addMessage(null, message);
        }

        if (phaseEvent.getPhaseId() == PhaseId.INVOKE_APPLICATION) {
            if(
                (   ADFContext.getCurrent().getCurrent().getSessionScope().get("onLoadCounter") == null
                    ||
                    (ADFContext.getCurrent().getCurrent().getSessionScope().get("onLoadCounter") != null
                     &&
                   !ADFContext.getCurrent().getCurrent().getSessionScope().get("onLoadCounter").equals("1"))
                )
                ||
                (   ADFContext.getCurrent().getCurrent().getSessionScope().get("onLoadInvoiceID") == null
                    ||
                    (ADFContext.getCurrent().getCurrent().getSessionScope().get("onLoadInvoiceID") != null
                     &&
                   !ADFContext.getCurrent().getCurrent().getSessionScope().get("onLoadInvoiceID").equals(getInvoiceId()))
                )
            )
            {
                System.out.println("--------------INVOKE_APPLICATION");
    //            String invId = null;
    //            invId = getInvoiceId();
                String reasonCode = null;
                String reasonType = null;
                Map<String, String> headerMap =  null;

                //Start: Need to work on #1
//                RowSetIterator rowSetIterator = null;
//                String reasonId = null;
                //End: Need to work on #1
                try
                {

    //                System.out.println("-----------Reason Code: "+resolveExpression("#{bindings.reasonCode.inputValue}"));
    //                System.out.println("-----------Reason Type: "+resolveExpression("#{bindings.reasonType.inputValue}"));
    //                setExpressionResetValue("#{bindings.ReasonCodeVO1.inputValue}",resolveExpression("#{bindings.reasonCode.inputValue}"));
    //                setExpressionResetValue("#{bindings.ReasonTypeVO2.inputValue}",resolveExpression("#{bindings.reasonType.inputValue}"));


                    //            AdfFacesContext.getCurrentInstance().getViewScope().put("reason", new oracle.jbo.domain.Number(Integer.parseInt("6")));

    //                BindingContext bctx = BindingContext.getCurrent();
    //                BindingContainer bindingContainer = bctx.getCurrentBindingsEntry();
    //                OperationBinding operationBinding = bindingContainer.getOperationBinding("executeHeaderLineItemDetails");
    //                System.out.println("operationBinding: "+operationBinding);
    //                operationBinding.getParamsMap().put("invoiceId",getInvoiceId());
    //                operationBinding.execute();

                    headerMap = Utility.getAm().executeHeaderLineItemDetailsWithReturn(getInvoiceId(),getSupplierName(),getSiteId());
                    if(headerMap != null) {
                        if(headerMap.get("reason") != null)
                        {
                            System.out.println("reason: "+headerMap.get("reason"));
                            setExpressionResetValue("#{bindings.ReasonCodeVO1.inputValue}", headerMap.get("reason").toString());


                            //Start: Need to work on #1
//                            ViewObjectImpl vo = Utility.getAm().getReasonCodeVO2();
//                            ViewCriteria vc = vo.getViewCriteria("ReasonCodeVOCriteria");
//                            vo.applyViewCriteria(vc);
//                            vo.setNamedWhereClauseParam("bind_reason",  headerMap.get("reason").toString());
//                            vo.executeQuery();
//                            System.out.println("Count: "+vo.getEstimatedRowCount());
//                            if(vo.getEstimatedRowCount() > 0){
//                                rowSetIterator = vo.createRowSetIterator(null);
//                                while(rowSetIterator.hasNext()) {
//                                    Row row = rowSetIterator.next();
//                                    if (null != row) {
//                                        if(row.getAttribute("ReasonType") != null)
//                                        {
//                                            System.out.println("-------------reason: "+row.getAttribute("ReasonType").toString());
//                                            reasonId = row.getAttribute("Id").toString();
//                                        }
//                                        System.out.println("-------------reasonId: "+reasonId);
//                                    }
//                                }
//                            }
//
//                            ViewObjectImpl vo2 = Utility.getAm().getReasonTypeVO2();
//                            ViewCriteria vc2 = vo2.getViewCriteria("ReasonTypeVOCriteria");
//                            vo2.applyViewCriteria(vc2);
//                            vo2.setNamedWhereClauseParam("bindReasonId", reasonId);
//                            vo2.executeQuery();
//                            System.out.println("--------------Count of type: "+vo2.getEstimatedRowCount());
                            //End: Need to work on #1


                        }
                        //Start: Comment out if working on #1
                        if(headerMap.get("reasonType") != null)
                        {
                            System.out.println("reasonType: "+headerMap.get("reasonType"));
                            setExpressionResetValue("#{bindings.ReasonTypeVO2.inputValue}", headerMap.get("reasonType").toString());
                        }
                        //End: Comment out if working on #1

                        if(headerMap.get("docType") != null)
                        {
                            System.out.println("doc: "+headerMap.get("docType"));
                            if(headerMap.get("docType").equals("INVOICE")) {
                                docTypeSoc.setValue("Invoice");
                            }
                            else {
                                docTypeSoc.setValue("Credit Note");
                            }
                        }
                        if(headerMap.get("invType") != null)
                        {
                            System.out.println("inv: "+headerMap.get("invType"));
                            if(headerMap.get("invType").equals("PO")) {
                                invoiceTypeSoc.setValue("PO Invoice");
                            }
                            else {
                                invoiceTypeSoc.setValue("Non PO Invoice");
                            }
                        }

                        if(headerMap.get("exceptionMsg") != null)
                        {
                            exceptionOt.setValue(headerMap.get("exceptionMsg").toString());
                        }

                        if(headerMap.get("suppNo") != null)
                        {
                            suppNumIt.setValue(headerMap.get("suppNo").toString());
                        }

                        if(headerMap.get("siteName") != null)
                        {
                            siteNameIt.setValue(headerMap.get("siteName").toString());
                        }

                        if(headerMap.get("orgUnit") != null)
                        {
                            operatingUnitIt.setValue(headerMap.get("orgUnit").toString());
                        }
                    }

                    AdfFacesContext.getCurrentInstance().addPartialTarget(docTypeSoc);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(invoiceTypeSoc);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(reasonSOC);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(exceptionPgl);
                    System.out.println("-----------reasonSOC val: "+reasonSOC.getValue());

                    AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(lineTableOuterPgl);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(exceptionMsgPgl);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                finally {
                    //Start: Need to work on #1
//                    if(rowSetIterator != null)
//                    {
//                        rowSetIterator.closeRowSetIterator();
//                    }
                    //End: Need to work on #1
                }
                ADFContext.getCurrent().getCurrent().getSessionScope().put("onLoadCounter", "1");
                ADFContext.getCurrent().getCurrent().getSessionScope().put("onLoadInvoiceID", getInvoiceId());
            }
        }

        if (phaseEvent.getPhaseId() == PhaseId.RENDER_RESPONSE) {
            System.out.println("--------------RENDER_RESPONSE");
        }

        if (phaseEvent.getPhaseId() == PhaseId.RESTORE_VIEW) {
            System.out.println("-------------Inside RESTORE_VIEW-------------");
//            Map<String, String> headerMap =  null;
//            try
//            {
//                AdfFacesContext.getCurrentInstance().getPageFlowScope().put("testVal", "1");
//
//                headerMap = Utility.getAm().executeHeaderLineItemDetailsWithReturn(getInvoiceId());
//                if(headerMap != null) {
//                    if(headerMap.get("reason") != null)
//                    {
//                        System.out.println("reason: "+headerMap.get("reason"));
//                        setExpressionResetValue("#{bindings.ReasonCodeVO1.inputValue}", headerMap.get("reason").toString());
//                    }
//                    if(headerMap.get("reasonType") != null)
//                    {
//                        System.out.println("reasonType: "+headerMap.get("reasonType"));
//                        setExpressionResetValue("#{bindings.ReasonTypeVO2.inputValue}", headerMap.get("reasonType").toString());
//                    }
//
//                    if(headerMap.get("docType") != null)
//                    {
//                        System.out.println("doc: "+headerMap.get("docType"));
//                        if(headerMap.get("docType").equals("INVOICE")) {
//                            docTypeSoc.setValue("Invoice");
//                        }
//                        else {
//                            docTypeSoc.setValue("Credit Note");
//                        }
//                    }
//                    if(headerMap.get("invType") != null)
//                    {
//                        System.out.println("inv: "+headerMap.get("invType"));
//                        if(headerMap.get("invType").equals("PO")) {
//                            invoiceTypeSoc.setValue("PO Invoice");
//                        }
//                        else {
//                            invoiceTypeSoc.setValue("Non PO Invoice");
//                        }
//                    }
//                }
//
//                AdfFacesContext.getCurrentInstance().addPartialTarget(docTypeSoc);
//                AdfFacesContext.getCurrentInstance().addPartialTarget(invoiceTypeSoc);
//                AdfFacesContext.getCurrentInstance().addPartialTarget(reasonSOC);
//                AdfFacesContext.getCurrentInstance().addPartialTarget(exceptionPgl);
//                System.out.println("-----------reasonSOC val: "+reasonSOC.getValue());
//
//                AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);
//                AdfFacesContext.getCurrentInstance().addPartialTarget(lineTableOuterPgl);
//                AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
//            }
//            catch(Exception e) {
//                e.printStackTrace();
//            }
        }

        System.out.println("End: AfterPhase");

*/
    }

    public void onSaveClick(ActionEvent actionEvent) {
        System.out.println("Start: onSaveClick");
        try {
            String apGroupUserName = "";
            apGroupUserName = getAPGroupUserName();
            //System.out.println("apGroupUserName in onSaveClick ::: "+ apGroupUserName);
            String invNum = null;
            if (invNumIt.getValue() != null) {
                invNum = (String) invNumIt.getValue();
            }
            String enteredSiteId = null;
            if (siteIdIt.getValue() != null) {
                enteredSiteId = siteIdIt.getValue().toString();
            }
            String enteredSupName = null;
            if (supNameIt.getValue() != null) {
                enteredSupName = supNameIt.getValue().toString();
            }

            /* String invDate = null;
            if(invDateId.getValue()!=null && ((oracle.jbo.domain.Date)invDateId.getValue()).getValue()!=null) {
            invDate = ((oracle.jbo.domain.Date)invDateId.getValue()).getValue().toString(); */

            oracle.jbo.domain.Date invDate = null;
            if (invDateId.getValue() != null) {
                invDate = ((oracle.jbo.domain.Date) invDateId.getValue());
            }
            //            double lineTotaldb = Double.MIN_VALUE;
            //              if(lineIdIt.getValue()!=null) {
            //                lineTotaldb = Double.parseDouble((String)lineIdIt.getValue());
            //                System.out.println("**********lineTotal**********"+lineTotaldb);
            //              }
            //              oracle.jbo.domain.Number lineTotal=new oracle.jbo.domain.Number(0);
            //                try {
            //                    lineTotal = new oracle.jbo.domain.Number(lineTotaldb);
            //                } catch (SQLException e) {
            //                }

            //            String lineTotal=(lineIdIt.getValue()!=null)?lineIdIt.getValue().toString():null;
            String enteredTotalAmount = null;
            if (headerTotIt.getValue() != null) {
                enteredTotalAmount = headerTotIt.getValue().toString();
            }
            String invoiceId = getInvoiceId();
            //System.out.println("invoiceId b4 mathod call"+invoiceId);
            if (!checkDuplicateRecord(invNum, enteredSiteId, enteredSupName, invDate, enteredTotalAmount, invoiceId,
                                      "SAVE")) {
                validateAndDoSaveOperation(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End: onSaveClick");
    }


    boolean checkDuplicateRecord(String invNum, String siteID, String supplierName, oracle.jbo.domain.Date invoiceDate,
                                 String headerTotal, String invoiceId, String actionTaken) {

        boolean skipCheckingLogicFlag = false;

        System.out.println("----- checkDuplicateRecord ----- START");
        System.out.println("----- actionTaken : " + actionTaken);
        if (actionTaken.equalsIgnoreCase("SAVE")) {
            skipCheckingLogicFlag = false;
        } else {

            String invalidReason =
                (String) resolveExpression("#{bindings.InvalidReasonId.selectedValue ne ' ' ? bindings.InvalidReasonId.selectedValue.attributeValues[1] : ''}");
            //System.out.println("----- Invalid Reason : "+invalidReason);
            if (invalidReason != null && invalidReason.equals("REJECT")) {
                skipCheckingLogicFlag = true;
            } else {
                skipCheckingLogicFlag = false;
            }
        }


        if (skipCheckingLogicFlag) {
            return false;
        }

        RowSetIterator rs = null;
        try {
            /*System.out.println("invNum" + invNum);
            System.out.println("siteID" + siteID);
            System.out.println("SupplierName" + supplierName);
            System.out.println("invoiceDate" + invoiceDate);
            System.out.println("headerTotal" + headerTotal);
            System.out.println("invoiceId" + invoiceId);*/
            DCBindingContainer bindings = getBindings();
            System.out.println("After getting binding");
            DCIteratorBinding dcIteratorBindings = bindings.findIteratorBinding("DuplicateRecordCheckVO1Iterator");
            //System.out.println("After finding iterator");
            ViewObjectImpl duplicateRecordVO = (ViewObjectImpl) dcIteratorBindings.getViewObject();
            System.out.println("duplicateRecordVO b4 execute rowCount" + duplicateRecordVO.getEstimatedRowCount());
            //            ViewCriteria vc =
            //                headerVO.getViewCriteria("HeaderDetailsEOViewCriteriaWithInvNo");
            //            headerVO.applyViewCriteria(vc);
            duplicateRecordVO.setNamedWhereClauseParam("bv_invoiceNumber", invNum);
            duplicateRecordVO.executeQuery();
            System.out.println("duplicateRecordVO rowCount" + duplicateRecordVO.getEstimatedRowCount());
            rs = duplicateRecordVO.createRowSetIterator(null);


            ArrayList<String> exclusionList = new ArrayList<String>();
            RowSetIterator rsExclusionList = null;
            try {
                ViewObjectImpl DuplicateInvoiceExclusionStatusListVO =
                    (ViewObjectImpl) (bindings.findIteratorBinding("DuplicateInvoiceExclusionStatusListVO1Iterator")
                                      .getViewObject());
                DuplicateInvoiceExclusionStatusListVO.executeQuery();
                System.out.println("----- DuplicateInvoiceExclusionStatusListVO rowCount : " +
                                   DuplicateInvoiceExclusionStatusListVO.getEstimatedRowCount());
                rsExclusionList = DuplicateInvoiceExclusionStatusListVO.createRowSetIterator(null);
                while (rsExclusionList.hasNext()) {
                    Row r = rsExclusionList.next();
                    String internalStatus = (String) r.getAttribute("InternalStatus");
                    //System.out.println("----- \tinternalStatus : "+internalStatus);
                    exclusionList.add(internalStatus);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rsExclusionList != null)
                    rsExclusionList.closeRowSetIterator();
            }

            System.out.println("----- : " + exclusionList);


            while (rs.hasNext()) {
                Row r = rs.next();
                /*System.out.println("r - " + r);
                System.out.println("Attribute InvoiceNumber - " +
                                   r.getAttribute("InvoiceNumber"));
                System.out.println("InternalStatus" +
                                   r.getAttribute("InternalStatus"));
                System.out.println("invNum" + r.getAttribute("InvoiceNumber"));
                System.out.println("siteID" + r.getAttribute("SiteId"));
                System.out.println("SupplierName" +
                                   r.getAttribute("SupplierName"));
                System.out.println("invoiceDate" +
                                   r.getAttribute("InvoiceDate"));*/
                java.sql.Date invoiceSqlDate = invoiceDate.dateValue();
                java.sql.Date invoiceSqlDateFromDB =
                    ((oracle.jbo.domain.Date) r.getAttribute("InvoiceDate")).dateValue();
                //System.out.println("headerTotal" + r.getAttribute("InvoiceTotAmount"));
                System.out.println("InvoiceId" + r.getAttribute("InvoiceId"));


                if (!(r.getAttribute("InvoiceId").equals(invoiceId))) {
                    if (r.getAttribute("InvoiceNumber").equals(invNum) && r.getAttribute("SiteId").equals(siteID) &&
                        r.getAttribute("SupplierName").equals(supplierName) &&
                        invoiceSqlDateFromDB.equals(invoiceSqlDate) &&
                        r.getAttribute("InvoiceTotAmount").equals(headerTotal)) {
                        //INVOICE IN AP EXCEPTIONS
                        // INVOICE PENDING FOR CERTIFICATION
                        // INVOICE IN APINTERFACE

                        String internalStatus = (String) r.getAttribute("InternalStatus");
                        if (exclusionList.contains(internalStatus)) {

                            /*if (r.getAttribute("InternalStatus").equals("INVOICE IN AP EXCEPTIONS") ||
                            r.getAttribute("InternalStatus").equals("INVOICE PENDING FOR CERTIFICATION") ||
                            r.getAttribute("InternalStatus").equals("INVOICE IN AP INTERFACE")) { */

                            //System.out.println("Within if block as matched the criteria");
                            String validationErrorMessage =
                                "Invoice already processed or pending in BPM with same set of information against the supplier and site.";
                            RichPopup.PopupHints hints1 = new RichPopup.PopupHints();
                            validationErrorPopup.show(hints1);
                            this.validationErrorMessage.setValue(validationErrorMessage);
                            return true;
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (rs != null)
                rs.closeRowSetIterator();
        }
        return false;
    }

    public void onSubmitClick(ActionEvent actionEvent) {
        System.out.println("Start: onSubmitClick");
        int executeSubmit = 0;
        try {
            //All validations to be skipped if reasonType is reject
            /* if(reasonSoc.getValue()!=null && reasonSoc.getValue().toString().equals("16")){
                    System.out.println("To be rejected >>>"+reasonSoc.getValue().toString());

                    validateAndDoSaveOperation(true);  //update the record in table
                    approveTask();
                    closeAPWindow();
                }

                else{*/

            /* ****************** */
            String description = null;
            String commentsDate = null;
            //(statusSOC.getValue()==null || (statusSOC.getValue()!=null && statusSOC.getValue().equals("")))
            if (!(commentsIt.getValue() == null ||
                  (commentsIt.getValue() != null && commentsIt.getValue().equals("")))) {
                description = commentsIt.getValue().toString();
            }
            //String name = "ADF";


            String invNum = null;
            if (invNumIt.getValue() != null) {
                invNum = (String) invNumIt.getValue();
            }
            String enteredSiteId = null;
            if (siteIdIt.getValue() != null) {
                enteredSiteId = siteIdIt.getValue().toString();
            }
            String enteredSupName = null;
            if (supNameIt.getValue() != null) {
                enteredSupName = supNameIt.getValue().toString();
            }

            /* String invDate = null;
                        if(invDateId.getValue()!=null && ((oracle.jbo.domain.Date)invDateId.getValue()).getValue()!=null) {
                        invDate = ((oracle.jbo.domain.Date)invDateId.getValue()).getValue().toString(); */

            oracle.jbo.domain.Date invDate = null;
            if (invDateId.getValue() != null) {
                invDate = ((oracle.jbo.domain.Date) invDateId.getValue());
            }
            //            double lineTotaldb = Double.MIN_VALUE;
            //              if(lineIdIt.getValue()!=null) {
            //                lineTotaldb = Double.parseDouble((String)lineIdIt.getValue());
            //                System.out.println("**********lineTotal**********"+lineTotaldb);
            //              }
            //              oracle.jbo.domain.Number lineTotal=new oracle.jbo.domain.Number(0);
            //                try {
            //                    lineTotal = new oracle.jbo.domain.Number(lineTotaldb);
            //                } catch (SQLException e) {
            //                }

            //            String lineTotal=(lineIdIt.getValue()!=null)?lineIdIt.getValue().toString():null;

            String enteredTotalAmount = null;
            if (headerTotIt.getValue() != null) {
                enteredTotalAmount = headerTotIt.getValue().toString();
            }
            String invoiceId = getInvoiceId();
            //System.out.println("invoiceId b4 mathod call"+invoiceId);
            String creditInvoiceCheck = validateCreditNote();


            if (creditInvoiceCheck != null) {
                if (creditInvoiceCheck.equalsIgnoreCase("credit")) {
                    //System.out.println("creditInvoiceCheck ==== credit");
                    String validationErrorMessage =
                        "Amount values cannot be in positive for the document type as CREDIT";
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    validationErrorPopup.show(hints);
                    this.validationErrorMessage.setValue(validationErrorMessage);
                    return;
                } else if (creditInvoiceCheck.equalsIgnoreCase("invoice")) {
                    //System.out.println("creditInvoiceCheck ==== invoice");
                    String validationErrorMessage =
                        "Amount values cannot be in negetive for the document type as INVOICE";
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    validationErrorPopup.show(hints);
                    this.validationErrorMessage.setValue(validationErrorMessage);
                    return;
                }
            }

            /*

                        // Migs LINE Change : Sourav - 28th November,2018
                        //Requirement : if type is invoice then all line amount values > 0 ;if doctype is credit note then all line values should be <0
                        String reasonID = null;
                        if(reasonSoc.getValue()!=null && !reasonSoc.getValue().equals("")){
                            reasonID = reasonSoc.getValue().toString();
                        }
                        if(!reasonID.equals("16")){
                        String documentType = docTypeSoc.getValue()!=null ? docTypeSoc.getValue().toString():null;
                        String lineAmountMagnitudeError = checkLineAmountMagnitude(documentType);
                        if(lineAmountMagnitudeError != null) {

                            System.out.println("LineAmount Magnitude Error");

                            String validationErrorMessage = lineAmountMagnitudeError;
                            RichPopup.PopupHints hints = new RichPopup.PopupHints();
                            validationErrorPopup.show(hints);
                            this.validationErrorMessage.setValue(validationErrorMessage);
                            return;
                        }

                        }

                        */

            //Check atleast one line is of LINE Type -BY SOURAV-20THJuly //


            boolean checkLineTypePresent = checkLineTypePresent();
            if (!checkLineTypePresent && (reasonSoc.getValue() != null && !reasonSoc.getValue()
                                                                                    .toString()
                                                                                    .equals("16"))) {

                //System.out.println("No LINE type present");
                String validationErrorMessage = "Atleast one Line Type as LINE must be present";
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                validationErrorPopup.show(hints);
                this.validationErrorMessage.setValue(validationErrorMessage);
                return;

            }


            if (!checkDuplicateRecord(invNum, enteredSiteId, enteredSupName, invDate, enteredTotalAmount, invoiceId,
                                      "SUBMIT")) {
                System.out.println("invoiceTypeSoc.getValue() " + invoiceTypeSoc.getValue());
                System.out.println("reasonSoc.getValue() " + reasonSoc.getValue() + ".");
                String invalidReason =
                    (String) resolveExpression("#{bindings.InvalidReasonId.selectedValue ne ' ' ? bindings.InvalidReasonId.selectedValue.attributeValues[1] : ''}");
                // String invalidReason = (String)AdfFacesContext.getCurrentInstance().getPageFlowScope().get("invalidReason");
                // System.out.println("Invalid reason type"+invalidReason);

                if (invoiceTypeSoc.getValue().equals("Non PO Invoice") && !invalidReason.equals("REJECT")) {
                    System.out.println("Yes this is non po invoice and reason is other than reject");
                    // if(reasonSoc.getSubmittedValue()!="REJECT")
                    //System.out.println("certNameIt.getValue()"+certNameIt.getValue());

                    if (certNameIt.getValue() != null && !((String) certNameIt.getValue()).trim().equals("")) {
                        System.out.println(" before Certifier flag is " + certifierFlag);
                        certifierFlag = (Integer) AdfFacesContext.getCurrentInstance()
                                                                 .getPageFlowScope()
                                                                 .get("certifierFlagInScope");
                        System.out.println("new certifier flag is " + certifierFlag);
                        if (certifierFlag == 0) {
                            String enteredCertifierName = (String) certNameIt.getValue();
                            DCBindingContainer dcBindingContainer =
                                (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                            DCIteratorBinding dcIteratorBinding =
                                dcBindingContainer.findIteratorBinding("CertifierNameVO1Iterator");
                            ViewObjectImpl certifierNameVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                            ViewCriteria vc = certifierNameVO.getViewCriteria("CertifierNameVOCriteria1");
                            certifierNameVO.applyViewCriteria(vc);
                            // certifierNameVO.clearCache();
                            certifierNameVO.setNamedWhereClauseParam("bindName", enteredCertifierName);
                            //System.out.println("-----------Dynamic Query-----------");
                            //System.out.println(certifierNameVO.getQuery());
                            certifierNameVO.executeQuery();
                            int noOfRows = certifierNameVO.getRowCount();
                            //System.out.println("No of rows fetched by certifiernamevo is "+noOfRows);
                            if (noOfRows == 1) {
                                //System.out.println("Executing No of rows is "+noOfRows);
                                String selectedEmployeeNo = null;
                                String selectedcertifierEmail = null;
                                Row row = certifierNameVO.next();
                                if (row.getAttribute("EmployeeNumber") != null) {
                                    //System.out.println("Employee no is "+row.getAttribute("EmployeeNumber"));
                                    selectedEmployeeNo = row.getAttribute("EmployeeNumber").toString();
                                    //System.out.println("Employe Number "+selectedEmployeeNo);

                                }
                                //System.out.println("Email address is "+row.getAttribute("EmailAddress"));
                                if (row.getAttribute("EmailAddress") != null) {
                                    selectedcertifierEmail = row.getAttribute("EmailAddress").toString();
                                }
                                // certNameIt.setValue(selectedCertifierName);
                                employeeNoIt.setValue(selectedEmployeeNo);
                                System.out.println("EmployeeNOIt.getvalue " + employeeNoIt.getValue());
                                if (selectedcertifierEmail != null) {
                                    certEmailIt.setValue(selectedcertifierEmail);
                                } else {
                                    certEmailIt.setValue("");
                                }
                                AdfFacesContext.getCurrentInstance()
                                               .getPageFlowScope()
                                               .put("certifierFlagInScope", 1);
                                System.out.println("AdfFacesContext.getCurrentInstance().getPageFlowScope() setting" +
                                                   AdfFacesContext.getCurrentInstance()
                                                                                                                                      .getPageFlowScope()
                                                                                                                                      .get("certifierFlagInScope"));
                                certifierFlag = 1;
                                AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);

                            } else if (noOfRows != 1) {
                                System.out.println("Executing No of rows more than one  " + noOfRows);
                                // certifierNameErrorOT.setValue("More than one  CertifierName has matched the entered CertifierName. So please select a valid Certifier Name.");
                                // certifierNameErrorOT.setVisible(true);


                                // AdfFacesContext.getCurrentInstance().addPartialTarget(certifierNameErrorOT);
                                DCBindingContainer dcBindingContainer1 =
                                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                                DCIteratorBinding dcIteratorBinding1 =
                                    dcBindingContainer1.findIteratorBinding("CertifierNameVO1Iterator");
                                ViewObjectImpl certifierNameVO1 = (ViewObjectImpl) dcIteratorBinding1.getViewObject();
                                ViewCriteria vc1 = certifierNameVO1.getViewCriteria("CertifierNameVOCriteria");
                                certifierNameVO1.applyViewCriteria(vc1);

                                certifierNameVO1.setNamedWhereClauseParam("bindName", enteredCertifierName);
                                //System.out.println("-----------Dynamic Query-----------");
                                //System.out.println(certifierNameVO1.getQuery());
                                certifierNameVO1.executeQuery();

                                int noOfRows1 = certifierNameVO1.getRowCount();
                                if (noOfRows1 ==
                                    1) {
                                    //System.out.println("inside rows"+noOfRows1);
                                    String validationErrorMessage =
                           "Please confirm the Certifier Name matched against the name you had entered by selecting it.";
                                    RichPopup.PopupHints hints1 = new RichPopup.PopupHints();
                                    validationErrorPopup.show(hints1);
                                    this.validationErrorMessage.setValue(validationErrorMessage);
                                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                                    p10.show(hints);
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(certifierNameDetailsTable);
                                } else if (noOfRows1 == 0) {
                                    System.out.println("inside rows" + noOfRows1);
                                    //  certifierFlag=0;
                                    AdfFacesContext.getCurrentInstance()
                                                   .getPageFlowScope()
                                                   .put("certifierFlagInScope", 0);
                                    System.out.println("AdfFacesContext.getCurrentInstance().getPageFlowScope() novalue " +
                                                       AdfFacesContext.getCurrentInstance()
                                                                                                                                           .getPageFlowScope()
                                                                                                                                           .get("certifierFlagInScope"));
                                    String validationErrorMessage =
                                        "Invalid Certifier Name. Please select a valid Certifier Name.";
                                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                                    validationErrorPopup.show(hints);
                                    this.validationErrorMessage.setValue(validationErrorMessage);
                                } else if (noOfRows1 > 1) {
                                    System.out.println("inside rows" + noOfRows1);
                                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                                    p10.show(hints);
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(certifierNameDetailsTable);
                                    String validationErrorMessage =
                                        "More than one record found against the Certifier Name you had entered. Please select a record from the list shown.";
                                    RichPopup.PopupHints hints1 = new RichPopup.PopupHints();
                                    validationErrorPopup.show(hints1);
                                    this.validationErrorMessage.setValue(validationErrorMessage);
                                }

                            }
                        }
                        System.out.println("At last Certifier flag is " + certifierFlag);
                        if (certifierFlag == 1) {
                            if (validateAndDoSaveOperation(true)) {
                                System.out.println("non po and non reject");

                                //                    BindingContext bpmUpdatebindingContext = BindingContext.getCurrent();
                                //                    BindingContainer bpmUpdatebindingContainer = bpmUpdatebindingContext.getCurrentBindingsEntry();
                                //                    OperationBinding bpmUpdateoperationBinding = bpmUpdatebindingContainer.getOperationBinding("update");
                                //                    System.out.println("bpmUpdateoperationBinding :::"+bpmUpdateoperationBinding);
                                //                    bpmUpdateoperationBinding.execute();

                                updateTask();
                                //                    if(description != null)
                                //                    {
                                //                        saveAPComments(getInvoiceId(),commentsDate,description,name);
                                //                    }
                                /*BindingContext bctx = BindingContext.getCurrent();
                                BindingContainer bindings = bctx.getCurrentBindingsEntry();
                                OperationBinding operationBinding =  bindings.getOperationBinding("APPROVE");
                                operationBinding.execute();
                                System.out.println("APPROVED");*/
                                approveTask();
                                closeAPWindow();
                            }
                        }

                    } else {
                        System.out.println("certifier null");
                        String validationErrorMessage =
                            "Certifier Name is Blank. Certifier Name is mandatory for a Non-PO Invoice.";
                        RichPopup.PopupHints hints = new RichPopup.PopupHints();
                        validationErrorPopup.show(hints);
                        this.validationErrorMessage.setValue(validationErrorMessage);

                    }
                } else {
                    System.out.println("Yes this is  po invoice");
                    System.out.println("Yes this may be  po invoice or reason may be reject");
                    if (validateAndDoSaveOperation(true)) {
                        System.out.println("passed val n dosave");
                        /*BindingContext bctx = BindingContext.getCurrent();
                               BindingContainer bindings = bctx.getCurrentBindingsEntry();
                               OperationBinding operationBinding =  bindings.getOperationBinding("APPROVE");
                               operationBinding.execute();
                               System.out.println("APPROVED");*/
                        //                   if(description != null)
                        //                   {
                        //                       saveAPComments(getInvoiceId(),commentsDate,description,name);
                        //                   }
                        approveTask();
                        closeAPWindow();
                    }
                }

                //            invokeActionBean =(InvokeActionBean) resolveExpression("#{requestScope.invokeActionBean)");
                //            invokeActionBean.setOperation(actionEvent);
                //            invokeActionBean.invokeOperation();
            }

        }
        //}
        catch (Exception e) {
            e.printStackTrace();
            //            invokeActionBean =(InvokeActionBean) resolveExpression("#{invokeActionBean)");
            //            invokeActionBean.setOperation(actionEvent);
            //            invokeActionBean.invokeOperation();
        }
        System.out.println("End: onSubmitClick");
    }

    public void closeAPWindow() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext ectx = facesContext.getExternalContext();
        ExtendedRenderKitService service = Service.getRenderKitService(facesContext, ExtendedRenderKitService.class);

        //window.opener.location.reload(); KD - TO DO LATER
        service.addScript(facesContext, "alert('Invoice submitted successfully');window.close();");
        //service.addScript(facesContext, "window.close()");
        //service.addScript(facesContext, "window.close();window.opener.location.href = window.opener.location.href;");
    }

    /* public boolean validateAndDoSaveOperation(boolean needValidation) {
        System.out.println("Start: populateAllHeaderValues");
        HashMap<String,String> headerList = new HashMap<String,String>();

        String reasonType = null;
        if(typeSOC.getValue() != null)
            reasonType = getReasonId(typeSOC.getValue().toString());
        //reasonType = "1";//TO BE REOMOVED LATER

        String supName = (String)supNameIt.getValue();

        String rejReason = null;
        String comments = null;
        String certComments = null;

        long siteId = -1;
        if(siteIdIt.getValue()!=null) {
            siteId = (long)(((oracle.jbo.domain.Number)siteIdIt.getValue()).getValue());
        }

        String invNum = (String)invNumIt.getValue();
        String taxRegNum = null;
        if(taxRegIt.getValue()!=null && ( ((oracle.jbo.domain.Number)(taxRegIt.getValue()))!=null)) {
            taxRegNum = ((oracle.jbo.domain.Number)(taxRegIt.getValue())) + "";
        }

        String poNum = (String)poNumIt.getValue();


        String certName = (String)certNameIt.getValue();
        String certEmail = (String)certEmailIt.getValue();

        String currency = (String)currencyIt.getValue();
        String invDate = null;
        if(invDateId.getValue()!=null && ((oracle.jbo.domain.Date)invDateId.getValue()).getValue()!=null) {
            invDate = ((oracle.jbo.domain.Date)invDateId.getValue()).getValue().toString();
        }
        double taxTotal = -1.0;
        if(taxTotIt.getValue()!=null) {
            taxTotal = ((oracle.jbo.domain.Number)taxTotIt.getValue()).getValue();
        }

        double headerTotal = -1.0;
        if(headerTotIt.getValue()!=null) {
            headerTotal = ((oracle.jbo.domain.Number)headerTotIt.getValue()).getValue();
        }

        double lineTotal = -1;
        if(lineIdIt.getValue()!=null) {
            lineTotal = Double.parseDouble((String)lineIdIt.getValue());
        }



        String reason = (String)reasonSOC.getValue();
        String type = (String)typeSOC.getValue();
        String status = (String)statusSOC.getValue();


        String invoiceType = (String)invoiceTypeSoc.getValue();
        String docType = (String)docTypeSoc.getValue();
        String operatingUnit = (String)operatingUnitIt.getValue();

        //System.out.println(Arrays.toString(new String[]{supName, siteId, invNum, taxRegNum, poNum, lineTotal, certName, currency, invDate, taxTotal, headerTotal, certEmail, reason, type, status}));

        RowSetIterator rowSetIterator = null;
        try {

            //TO-DO : Add java validation



            String validationErrorMessage = null;

            //If reason = REJECT
            if(!reason.equals("REJECT") && needValidation) {

                //Certifier Name+Email mandatory for NON-PO Invoice
                if(validationErrorMessage==null && (supName==null || (supName!=null && supName.trim().equals("")))) {
                    //validationErrorMessage = "Supplier Name is missing!";
                    setExpressionResetValue("#{bindings.ReasonCodeVO1.inputValue}","VENDOR NOT FOUND");
                    setExpressionResetValue("#{bindings.ReasonTypeVO2.inputValue}","NO EXACT MATCH");
                    ViewObjectImpl vo = Utility.getAm().getErrorCodeLookupVO1();
                    System.out.println("--typeSOC--"+reasonType);
                    vo.setNamedWhereClauseParam("bindReasonType", reasonType);
                    vo.executeQuery();
                    RowSetIterator rs = vo.createRowSetIterator(null);
                    rs.reset();
                    String errorMessageLookup = null;
                    while(rs.hasNext()){
                        Row r = rs.next();
                        errorMessageLookup = (String)r.getAttribute("ErrorMessage");                }

                    validationErrorMessage = errorMessageLookup;
                }
                if(validationErrorMessage==null && siteId==-1) {
                    //validationErrorMessage = "Site ID is missing!";
                    setExpressionResetValue("#{bindings.ReasonCodeVO1.inputValue}","VENDOR NOT FOUND");
                    setExpressionResetValue("#{bindings.ReasonTypeVO2.inputValue}","NO EXACT MATCH");
                    ViewObjectImpl vo = Utility.getAm().getErrorCodeLookupVO1();
                    System.out.println("--typeSOC--"+reasonType);
                    vo.setNamedWhereClauseParam("bindReasonType", reasonType);
                    vo.executeQuery();
                    RowSetIterator rs = vo.createRowSetIterator(null);
                    rs.reset();
                    String errorMessageLookup = null;
                    while(rs.hasNext()){
                        Row r = rs.next();
                        errorMessageLookup = (String)r.getAttribute("ErrorMessage");                }

                    validationErrorMessage = errorMessageLookup;
                }
                if(validationErrorMessage==null && (invNum==null || (invNum!=null && invNum.trim().equals("")))) {
                    validationErrorMessage = "Invoice Number is missing!";
                }
                if(validationErrorMessage==null && (invDate==null || (invDate!=null && invDate.trim().equals("")))) {
                    validationErrorMessage = "Invoice Date is missing!";
                }
                if(validationErrorMessage==null && taxTotal==-1.0) {
                    validationErrorMessage = "Tax Total Amount is missing!";
                }
                if(validationErrorMessage==null && headerTotal==-1.0) {
                    validationErrorMessage = "Header Total Amount is missing!";
                }


                if(validationErrorMessage==null && invoiceType.equalsIgnoreCase("non po invoice")) {
                    if(certName==null || (certName!=null && certName.trim().equals(""))) {
                        validationErrorMessage = "Certifier Name is mandatory for Non-PO Invoice!";
                    } else if(certEmail==null || (certEmail!=null && certEmail.trim().equals(""))) {
                        validationErrorMessage = "Certifier Email is mandatory for Non-PO Invoice!";
                    }
                }
                if(validationErrorMessage==null && invoiceType.equalsIgnoreCase("po invoice")) {
                    if(poNum==null || (poNum!=null && poNum.trim().equals(""))) {
                        validationErrorMessage = "PO Number is mandatory for PO Invoice!";
                    }
                }


                //Iteration Start
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
                ViewObjectImpl lineVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
        //            vo.executeQuery();
               ArrayList<HashMap<String, Object>> lineItems = new ArrayList<HashMap<String,Object>>();
                System.out.println("------------Count: "+lineVO.getEstimatedRowCount());

        //            while( lineVO.hasNext() ) {
        //                Row row = lineVO.next();
                    rowSetIterator = lineVO.createRowSetIterator(null);
                    while(rowSetIterator.hasNext()) {
                        Row row = rowSetIterator.next();
                        System.out.println("----- Line Item ----");

                        long lineItem_LineNumber = -1;
                        if(row.getAttribute("LineNumber")!=null) {
                            lineItem_LineNumber = (long)(((oracle.jbo.domain.Number)row.getAttribute("LineNumber")).getValue());
                        }

                        String lineItem_Description = (String)row.getAttribute("LineDescription");

                        double lineItem_LineTotal = -1.0;
                        double lineItem_Quantity = -1.0;
                        double lineItem_UnitPrice = -1.0;

                        String taxRateCode = (String)row.getAttribute("TaxRateCode");

                        String lineItem_poNumber = (String)row.getAttribute("LinePoNum");
                        String lineItem_poLineNumber = (String)row.getAttribute("PoLineNum");

                        System.out.println("-----------Amount: "+row.getAttribute("LineTotalAmount"));
                        if(row.getAttribute("LineTotalAmount")!=null) {
                            lineItem_LineTotal = ((oracle.jbo.domain.Number)row.getAttribute("LineTotalAmount")).getValue();
                        }
                        if(row.getAttribute("Quantity")!=null) {
                            lineItem_Quantity = ((oracle.jbo.domain.Number)row.getAttribute("Quantity")).getValue();
                        }
                        if(row.getAttribute("UnitPrice")!=null) {
                            lineItem_UnitPrice = ((oracle.jbo.domain.Number)row.getAttribute("UnitPrice")).getValue();
                        }



                    System.out.println("\t Line Total : "+lineItem_LineTotal);

                    HashMap<String, Object> lineItem = new HashMap<String, Object>();
                    lineItem.put("LineNumber",          lineItem_LineNumber);
                    lineItem.put("LineDescription",     lineItem_Description);
                    lineItem.put("LineTotalAmount",     lineItem_LineTotal);
                    lineItem.put("Quantity",            lineItem_Quantity);
                    lineItem.put("UnitPrice",           lineItem_UnitPrice);
                    lineItem.put("TaxRateCode",         taxRateCode);

                    lineItem.put("LinePoNum",           lineItem_poNumber);
                    lineItem.put("PoLineNum",           lineItem_poLineNumber);

                    lineItems.add(lineItem);
                }

                //End of Iteration










        //            DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        //            DCIteratorBinding iterator = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        //
        //            ArrayList<HashMap<String, Object>> lineItems = new ArrayList<HashMap<String,Object>>();
        //
        //            if (iterator.getViewObject().hasNext()) {
        //                Row row = iterator.getViewObject().next();
        //
        //                System.out.println("----- Line Item ----");
        //
        //                double lineItem_LineTotal = -1;
        //
        //                if(row.getAttribute("LineTotalAmount")!=null) {
        //                    lineItem_LineTotal = ((oracle.jbo.domain.Number)row.getAttribute("LineTotalAmount")).getValue();
        //                }
        //
        //                System.out.println("\t Line Total : "+lineItem_LineTotal);
        //
        //                HashMap<String, Object> lineItem = new HashMap<String, Object>();
        //                lineItem.put("LineTotalAmount", lineItem_LineTotal);
        //
        //                lineItems.add(lineItem);
        //            }

                System.out.println("----- End of Line Items -----");


                double lineItems_TotalAmount_Sum = 0;

                for(int i=0; i<lineItems.size(); i++) {
                    lineItems_TotalAmount_Sum += (Double)lineItems.get(i).get("LineTotalAmount");

                    if(validationErrorMessage==null && invoiceType.equalsIgnoreCase("po invoice")) {

                        if(validationErrorMessage==null && (lineItems.get(i).get("LinePoNum")==null || (lineItems.get(i).get("LinePoNum")!=null && ((String)lineItems.get(i).get("LinePoNum")).trim().equals("")))) {
                            validationErrorMessage = "PO Number is missing for the following Line Item :<br/>"
                                                     + "Line Number : "+(Long)(lineItems.get(i).get("LineNumber"))+", Description : "+lineItems.get(i).get("LineDescription");
                            break;
                        } else if(validationErrorMessage==null && (lineItems.get(i).get("PoLineNum")==null || (lineItems.get(i).get("PoLineNum")!=null && ((String)lineItems.get(i).get("PoLineNum")).trim().equals("")))) {
                            validationErrorMessage = "PO Line Number is missing for the following Line Item :<br/>"
                                                     + "Line Number : "+(Long)(lineItems.get(i).get("LineNumber"))+", Description : "+lineItems.get(i).get("LineDescription");
                            break;
                        }

                    }

                    if(validationErrorMessage==null && (Double)lineItems.get(i).get("Quantity")==-1.0) {
                        validationErrorMessage = "Quantity is missing for the following Line Item :<br/>"
                                                 + "Line Number : "+(Long)(lineItems.get(i).get("LineNumber"))+", Description : "+lineItems.get(i).get("LineDescription");
                        break;
                    }
                    if(validationErrorMessage==null && (Double)lineItems.get(i).get("UnitPrice")==-1.0) {
                        validationErrorMessage = "Unit Price Amount is missing for the following Line Item :<br/>"
                                                 + "Line Number : "+(Long)(lineItems.get(i).get("LineNumber"))+", Description : "+lineItems.get(i).get("LineDescription");
                        break;
                    }
                    if(validationErrorMessage==null && (lineItems.get(i).get("TaxRateCode")==null || (lineItems.get(i).get("TaxRateCode")!=null && ((String)lineItems.get(i).get("TaxRateCode")).trim().equals("")))) {
                        validationErrorMessage = "Tax Rate Code is missing for the following Line Item :<br/>"
                                                 + "Line Number : "+(Long)(lineItems.get(i).get("LineNumber"))+", Description : "+lineItems.get(i).get("LineDescription");
                        break;
                    }
                }

                System.out.println("Line Total : "+lineTotal+", Sum of Line Item Line Total : "+ lineItems_TotalAmount_Sum);

                if(validationErrorMessage==null && lineTotal!=lineItems_TotalAmount_Sum) {
                    validationErrorMessage = "Sum of Line Item Total Amount(s) should exactly match with Invoice Line Total Amount";
                }



                if(validationErrorMessage==null && headerTotal==0.0) {
                    setExpressionResetValue("#{bindings.ReasonCodeVO1.inputValue}","ZERO VALUE INVOICE");
                    setExpressionResetValue("#{bindings.ReasonTypeVO2.inputValue}","INVALID INVOICE");
                    ViewObjectImpl vo = Utility.getAm().getErrorCodeLookupVO1();
                    System.out.println("--typeSOC--"+reasonType);
                    vo.setNamedWhereClauseParam("bindReasonType", reasonType);
                    vo.executeQuery();
                    RowSetIterator rs = vo.createRowSetIterator(null);
                    rs.reset();
                    String errorMessageLookup = null;
                    while(rs.hasNext()){
                        Row r = rs.next();
                        errorMessageLookup = (String)r.getAttribute("ErrorMessage");                }

                    validationErrorMessage = errorMessageLookup;
                }
            }


            if(validationErrorMessage!=null) {

                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                validationErrorPopup.show(hints);

                this.validationErrorMessage.setValue(validationErrorMessage);
                return false;

            } else {
                if(resolveExpression("#{bindings.CertifierRejReason.inputValue}") != null)
                    rejReason = resolveExpression("#{bindings.CertifierRejReason.inputValue}").toString();
                if(resolveExpression("#{bindings.ApOperationComments.inputValue}") != null)
                    comments = resolveExpression("#{bindings.ApOperationComments.inputValue}").toString();
                if(resolveExpression("#{bindings.CertifierRejComments.inputValue}") != null)
                    certComments = resolveExpression("#{bindings.CertifierRejComments.inputValue}").toString();
                doSaveOperation(supName, (siteId==-1?"":(""+siteId)),
                                invNum,taxRegNum,poNum,
                                (lineTotal==-1?"":(""+lineTotal)),
                                certName,currency,invDate,
                                (taxTotal==-1?"":(""+taxTotal)),
                                (headerTotal==-1?"":(""+headerTotal)),
                                certEmail,rejReason,comments,certComments,reason, type, status, docType, invoiceType, operatingUnit);
                dbCommit();

                if(!needValidation)
                {
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    validationErrorPopup.show(hints);
                    this.validationErrorMessage.setValue("Saved Successfully.");
                }
                return true;
            }


            }
            catch(Exception e) {
                e.printStackTrace();
            }finally{
            if(rowSetIterator!=null){
                rowSetIterator.closeRowSetIterator();
            }
        }
        System.out.println("End: populateAllHeaderValues");
        return false;

    }*/

    public void setValueToEL(String el, Object val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        ValueExpression exp = expressionFactory.createValueExpression(elContext, el, Object.class);
        exp.setValue(elContext, val);
    }

    public void valueChanged(ValueChangeEvent valueChangeEvent) {
        System.out.println("\n******** New Value: " + valueChangeEvent.getNewValue());
        AdfFacesContext.getCurrentInstance()
                       .getPageFlowScope()
                       .put("newReasonID", valueChangeEvent.getNewValue());
    }


    /**
     * @return DCBindingContainer
     */
    public DCBindingContainer getBindings() {
        return (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    /**
     *
     * @param needValidation
     * @return
     */
    public boolean validateAndDoSaveOperation(boolean needValidation) {
        System.out.println("Start: validateAndDoSaveOperation");
        String reasonId = null;
        String reasonTypeId = null;
        String statusStr = null;
        String rejReason = null;
        String comments = null;
        String certComments = null;
        String supName = null;
        long siteId = -1;
        RowSetIterator lineItemItr = null;

        String commentsDate = null;

        String description = null;

        /*Start : Added on 5th Dec WHT validation*/

        String selectedSiteId_wht = siteIdIt.getValue() != null ? siteIdIt.getValue().toString() : null;
        String orgID_wht = getOrganizationId().toString();
        String currency_wht = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;
        String invDate_wht = invDateId.getValue() != null ? invDateId.getValue().toString() : null;
        getWHTAmount(selectedSiteId_wht, invDate_wht, currency_wht, orgID_wht);


        oracle.jbo.domain.Number amount;

        try {
            BindingContext bindingContext = null;
            BindingContainer bindingContainer = null;
            OperationBinding operationBinding = null;

            bindingContext = BindingContext.getCurrent();
            bindingContainer = bindingContext.getCurrentBindingsEntry();
            operationBinding = bindingContainer.getOperationBinding("calculateWHTAmount");

            operationBinding.getParamsMap().put("SupplierSiteNumber", selectedSiteId_wht);
            operationBinding.getParamsMap().put("invoiceDate", invDate_wht);
            operationBinding.getParamsMap().put("currencyCodes", currency_wht);
            operationBinding.getParamsMap().put("orgID", orgID_wht);

            operationBinding.execute();

            if (ADFContext.getCurrent()
                          .getPageFlowScope()
                          .get("whtAmount") != null) {

                System.out.println("Setting WHT Amount by new Logic");
                amount = new oracle.jbo.domain.Number(Double.parseDouble(ADFContext.getCurrent()
                                                                                   .getPageFlowScope()
                                                                                   .get("whtAmount")
                                                                                   .toString()));
                whtAmountIt.setValue(amount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(whtAmountIt);
            }
            //Added on 5th Dec else if block
            else if (ADFContext.getCurrent()
                               .getPageFlowScope()
                               .get("whtAmount") == null) {

                whtAmountIt.setValue("");
                System.out.println("Refreshing WHT amount");
                AdfFacesContext.getCurrentInstance().addPartialTarget(whtAmountIt);
            }
            if (ADFContext.getCurrent()
                          .getPageFlowScope()
                          .get("errorMessage") != null && !ADFContext.getCurrent()
                                                                     .getPageFlowScope()
                                                                     .get("errorMessage")
                                                                     .toString()
                                                                     .equalsIgnoreCase("success")) {

                whtAmountIt.setValue("");

                System.out.println("Refreshing WHT amount after errorMessage ::" + ADFContext.getCurrent()
                                                                                             .getPageFlowScope()
                                                                                             .get("errorMessage")
                                                                                             .toString());
                AdfFacesContext.getCurrentInstance().addPartialTarget(whtAmountIt);
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                //System.out.println("oPENING THE POP UP!!");
                validationErrorPopup.show(hints);
                this.validationErrorMessage.setValue(ADFContext.getCurrent()
                                                               .getPageFlowScope()
                                                               .get("errorMessage")
                                                               .toString());
                return false;

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        /*End : Added on 5th Dec WHT validation*/


        if (!(commentsIt.getValue() == null || (commentsIt.getValue() != null && commentsIt.getValue().equals("")))) {
            description = commentsIt.getValue().toString();
        }

        String name = getAPGroupUserName();


        //           if(!needValidation && description!= null)
        //           saveAPComments(getInvoiceId(),commentsDate,description,name);

        //        System.out.println("\n******** Selected Value1: "+ resolveExpression("#{bindings.InvalidCode.selectedValue.attributeValues[0]}"));
        //        System.out.println("\n******** Selected Value2: "+ resolveExpression("#{bindings.InvalidCode.selectedValue.attributeValues[1]}"));
        //
        //        if(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("newReasonID")!= null){
        //            reasonId = (String)(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("newReasonID")).toString();
        //            System.out.println("reasonId:"+reasonId);
        //        }
        //        if(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("newReasonTypeID")!= null){
        //            reasonTypeId = (String)(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("newReasonTypeID")).toString();
        //            System.out.println("reasonTypeId:"+reasonTypeId);
        //        }
        //
        //
        //        System.out.println("\n******** Selected Value10: "+ resolveExpression("#{bindings.InvalidCode.attributeValue}"));
        //        System.out.println("\n******** Selected Value11: "+ resolveExpression("#{bindings.InvalidCode.inputValue}"));

        /* DCBindingContainer bindings =getBindings();
        DCIteratorBinding dcIteratorBindings = bindings.findIteratorBinding("HeaderDetailsEOView1Iterator");
        ViewObject headerVO = dcIteratorBindings.getViewObject();
        Row headerRow = headerVO.getCurrentRow();
        if(headerRow!= null){
            String invalidCodeStr = (String)headerRow.getAttribute("InvalidCode");
            reasonId = invalidCodeStr;
            System.out.println("\n******** invalidCodeStr: "+ invalidCodeStr);

        }*/


        /* if(typeSOC!= null && typeSOC.getValue() != null){
               reasonTypeId = typeSOC.getValue().toString();
           }*/

        if (resolveExpression("#{bindings.InvalidReasonId.attributeValue}") != null) {
            reasonId =
                "" +
                ((java.math.BigDecimal) resolveExpression("#{bindings.InvalidReasonId.attributeValue}")).intValue();
        }

        System.out.println("validateAndDoSaveOperation>>reasonId>>" + reasonId);

        if (resolveExpression("#{bindings.InvalidReasonTypeId.attributeValue}") != null) {
            reasonTypeId =
                "" +
                ((java.math.BigDecimal) resolveExpression("#{bindings.InvalidReasonTypeId.attributeValue}")).intValue();
        }

        System.out.println("validateAndDoSaveOperation>>reasonTypeId>>" + reasonTypeId);
        System.out.println("reasonId>> " + reasonId + " <<reasonTypeId>> " + reasonTypeId);
        /*   this.setValueToEL("#{bindings.InvalidReasonTypeId.inputValue}",
                          valueChangeEvent.getNewValue()); */
        //Updates the model
        /*System.out.println("\n******** Selected Value: " +
                           resolveExpression("#{bindings.InvalidReasonTypeId.attributeValue}"));
        System.out.println("\n******** Display Value: " +
                           resolveExpression("#{bindings.InvalidReasonTypeId.selectedValue ne ' ' ? bindings.InvalidReasonTypeId.selectedValue.attributeValues[1] : ''}"));*/
        String invalidReasonType =
            (String) resolveExpression("#{bindings.InvalidReasonTypeId.selectedValue ne ' ' ? bindings.InvalidReasonTypeId.selectedValue.attributeValues[1] : ''}");

        // String invalidReasonType = (String)AdfFacesContext.getCurrentInstance().getPageFlowScope().get("invalidReasonType");
        System.out.println("Invalid reason type" + invalidReasonType);

        /*System.out.println("\n******** Selected Value: " +
                           resolveExpression("#{bindings.InvalidReasonId.attributeValue}"));
        System.out.println("\n******** Display Value: " +
                           resolveExpression("#{bindings.InvalidReasonId.selectedValue ne ' ' ? bindings.InvalidReasonId.selectedValue.attributeValues[1] : ''}"));*/
        String invalidReason =
            (String) resolveExpression("#{bindings.InvalidReasonId.selectedValue ne ' ' ? bindings.InvalidReasonId.selectedValue.attributeValues[1] : ''}");
        // String invalidReason = (String)AdfFacesContext.getCurrentInstance().getPageFlowScope().get("invalidReason");
        System.out.println("Invalid reason type11" + invalidReason);

        if (invalidReason != null && invalidReason.equals("REJECT")) {

            needValidation = false;
            System.out.println("needvalidation flag set to :: " + needValidation);
        }


        if (!needValidation) {
            if (statusSOC != null && statusSOC.getValue() != null) {
                statusStr = (String) statusSOC.getValue();
            }
        }

        if (supNameIt != null && supNameIt.getValue() != null) {
            supName = (String) supNameIt.getValue();
        }

        if (siteIdIt.getValue() != null) {
            siteId = (long) (((oracle.jbo.domain.Number) siteIdIt.getValue()).getValue());
        }

        String invNum = (String) invNumIt.getValue();
        String taxRegNum = null;
        if (taxRegIt.getValue() != null && (((oracle.jbo.domain.Number) (taxRegIt.getValue())) != null)) {
            taxRegNum = ((oracle.jbo.domain.Number) (taxRegIt.getValue())) + "";
        }

        String poNum = (String) poNumIt.getValue();
        String certName = (String) certNameIt.getValue();
        String certEmail = (String) certEmailIt.getValue();
        String currency = (String) currencyIt.getValue();
        String invDate = null;
        String certNo = (String) employeeNoIt.getValue();

        if (invDateId.getValue() != null && ((oracle.jbo.domain.Date) invDateId.getValue()).getValue() != null) {
            invDate = ((oracle.jbo.domain.Date) invDateId.getValue()).getValue().toString();
        }
        double taxTotal = Double.MIN_VALUE;
        if (taxTotIt.getValue() != null) {
            taxTotal = ((oracle.jbo.domain.Number) taxTotIt.getValue()).getValue();
            System.out.println("**********taxTotal**********" + taxTotal);
        }
        double headerTotal = Double.MIN_VALUE;
        if (headerTotIt.getValue() != null) {
            headerTotal = ((oracle.jbo.domain.Number) headerTotIt.getValue()).getValue();
            System.out.println("**********headerTotal**********" + headerTotal);

        }
        double lineTotal = Double.MIN_VALUE;
        if (lineIdIt.getValue() != null) {
            lineTotal = Double.parseDouble((String) lineIdIt.getValue());
            System.out.println("**********lineTotal**********" + lineTotal);
        }

        System.out.println(" --- lineIdIt.getValue() --- " + lineIdIt.getValue());

        String invoiceType = (String) invoiceTypeSoc.getValue();
        String docType = (String) docTypeSoc.getValue();
        String operatingUnit = (String) operatingUnitIt.getValue();
        try {
            String validationErrorMessage = null;
            if (!(reasonSoc.getValue() != null && reasonSoc.getValue()
                                                           .toString()
                                                           .equals("16"))) { //added by A.D

                if (reasonTypeSoc.getValue() == null || reasonTypeSoc.equals("")) {
                    validationErrorMessage = "Please select a Reason Type";
                }
                if (reasonSoc.getValue() == null || reasonSoc.equals("")) {
                    validationErrorMessage = "Please select a Reason";
                }
            }
            // Reject id in parent table is 16 // REJECT
            //Image review id in parent table is 20 // IMAGE REVIEW

            System.out.println("--- before  check --- 0");

            if ((reasonId != null && (!reasonId.equals("16") && !reasonId.equals("20"))) && needValidation) {
                if (validationErrorMessage == null && ((headerTotal == 0.0) || (headerTotal == Double.MIN_VALUE))) {

                    System.out.println("--- validation block --- 0");
                    setExpressionResetValue("#{bindings.InvalidReasonId.inputValue}", "4");
                    setExpressionResetValue("#{bindings.InvalidReasonTypeId.inputValue}", "4");
                    System.out.println("get" + resolveExpression("#{bindings.InvalidReasonId.attributeValue}") +
                                       "<<>>" + resolveExpression("#{bindings.InvalidReasonTypeId.attributeValue}"));
                    ViewObjectImpl vo = Utility.getAm().getErrorCodeLookupVO1();
                    System.out.println("reasonTypeId:" + reasonTypeId);
                    vo.setNamedWhereClauseParam("bindReasonType", reasonTypeId);
                    vo.executeQuery();
                    RowSetIterator rs = null;
                    try {
                        rs = vo.createRowSetIterator(null);
                        rs.reset();
                        String errorMessageLookup = null;
                        while (rs.hasNext()) {
                            Row r = rs.next();
                            errorMessageLookup = (String) r.getAttribute("ErrorMessage");
                        }
                        validationErrorMessage = errorMessageLookup;
                        System.out.println("--- validation block --- 0");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (rs != null) {
                            try {
                                rs.closeRowSetIterator();
                            } catch (Exception ex) {
                                ex.printStackTrace();

                            }
                        }
                    }
                }

                //System.out.println("--- before  check --- 1");
                //Iteration Start over line items
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding =
                    dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
                ViewObjectImpl lineVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                //            vo.executeQuery();
                ArrayList<HashMap<String, Object>> lineItems = new ArrayList<HashMap<String, Object>>();
                System.out.println("------------lineVO Count: " + lineVO.getEstimatedRowCount());

                //            while( lineVO.hasNext() ) {
                //                Row row = lineVO.next();
                lineItemItr = lineVO.createRowSetIterator(null);
                while (lineItemItr.hasNext()) {
                    Row row = lineItemItr.next();
                    //System.out.println("----- Line Item ----");

                    long lineItem_LineNumber = -1;
                    if (row.getAttribute("LineNumber") != null) {
                        lineItem_LineNumber =
                            (long) (((oracle.jbo.domain.Number) row.getAttribute("LineNumber")).getValue());
                    }

                    String lineItem_Description = (String) row.getAttribute("LineDescription");

                    double lineItem_LineTotal = -1.0;
                    double lineItem_Quantity = -1.0;
                    double lineItem_UnitPrice = -1.0;

                    String taxRateCode = (String) row.getAttribute("TaxRateCode");
                    String whtCode = (String) row.getAttribute("WhtCode");
                    System.out.println("ValidateAndSaveOperation WhtCode : " + whtCode);
                    double lineItem_TaxAmount = -1.0;

                    String lineItem_poNumber = (String) row.getAttribute("LinePoNum");
                    String lineItem_poLineNumber = (String) row.getAttribute("PoLineNum");

                    System.out.println("-----------Amount: " + row.getAttribute("LineTotalAmount"));
                    if (row.getAttribute("LineTotalAmount") != null) {
                        lineItem_LineTotal =
                            ((oracle.jbo.domain.Number) row.getAttribute("LineTotalAmount")).getValue();
                    }
                    if (row.getAttribute("Quantity") != null) {
                        lineItem_Quantity = ((oracle.jbo.domain.Number) row.getAttribute("Quantity")).getValue();
                    }
                    if (row.getAttribute("UnitPrice") != null) {
                        lineItem_UnitPrice = ((oracle.jbo.domain.Number) row.getAttribute("UnitPrice")).getValue();
                    }

                    if (row.getAttribute("TaxAmountLineitem") != null) {
                        try {
                            lineItem_TaxAmount = Double.parseDouble((String) row.getAttribute("TaxAmountLineitem"));
                            System.out.println("lineItem_TaxAmount within TaxAmountLineitem" + lineItem_TaxAmount);

                        } catch (Exception e) {

                            lineItem_TaxAmount = -1.0;
                            e.printStackTrace();
                        }
                    }

                    System.out.println("\tline item tax amount : " + lineItem_TaxAmount);

                    System.out.println("\t Line Total : " + lineItem_LineTotal);
                    HashMap<String, Object> lineItem = new HashMap<String, Object>();
                    lineItem.put("LineNumber", lineItem_LineNumber);
                    lineItem.put("LineDescription", lineItem_Description);
                    lineItem.put("LineTotalAmount", lineItem_LineTotal);
                    lineItem.put("Quantity", lineItem_Quantity);
                    lineItem.put("UnitPrice", lineItem_UnitPrice);
                    lineItem.put("TaxRateCode", taxRateCode);
                    lineItem.put("LinePoNum", lineItem_poNumber);
                    lineItem.put("PoLineNum", lineItem_poLineNumber);
                    lineItem.put("TaxAmountLineitem", lineItem_TaxAmount);
                    lineItem.put("WhtCode", whtCode);
                    lineItems.add(lineItem);
                }

                //End of Iteration

                double lineItems_TotalAmount_Sum = 0;
                double lineItems_TaxAmount_Sum = 0;

                for (int i = 0; i < lineItems.size(); i++) {

                    lineItems_TotalAmount_Sum += (Double) lineItems.get(i).get("LineTotalAmount");
                    lineItems_TaxAmount_Sum += (Double) lineItems.get(i).get("TaxAmountLineitem");
                }

                System.out.println("Line Total **: " + lineTotal + ", Sum of Line Item Line Total** : " +
                                   lineItems_TotalAmount_Sum + ", Tax Total **: " + taxTotal +
                                   ", Sum of Line Item Tax Total **:" + lineItems_TaxAmount_Sum +
                                   ", Header Total** : " + headerTotal);

                //if(validationErrorMessage==null && headerTotal!=(taxTotal+lineItems_TotalAmount_Sum) && lineItems.size()>0) { ---- Commented by Pinky
                // DEACTIVATED FOR NOW
                /*
                       if(validationErrorMessage==null && headerTotal!=(taxTotal+lineTotal) && lineItems.size()>0) {
                       //validationErrorMessage = "Sum of Line Item Total Amount(s) should exactly match with Invoice Line Total Amount";
                       System.out.println("validatuion bock --1");
                       setExpressionResetValue("#{bindings.InvalidReasonId.inputValue}","5");
//                       setExpressionResetValue("#{bindings.ReasonTypeVO2.inputValue}","LINES<>TOTAL");
                       setExpressionResetValue("#{bindings.InvalidReasonTypeId.inputValue}","5");
                         System.out.println("get"+resolveExpression("#{bindings.InvalidReasonId.attributeValue}")+"<<>>"+ resolveExpression("#{bindings.InvalidReasonTypeId.attributeValue}"));
                       ViewObjectImpl vo = Utility.getAm().getErrorCodeLookupVO1();
                       System.out.println("reasonTypeId ************:"+reasonTypeId);
                       vo.setNamedWhereClauseParam("bindReasonType", 5);
                       vo.executeQuery();
                       RowSetIterator rs = vo.createRowSetIterator(null);
                       rs.reset();
                       String errorMessageLookup = null;
                       while(rs.hasNext()){
                           Row r = rs.next();
                           errorMessageLookup = (String)r.getAttribute("ErrorMessage");
                        }
                        validationErrorMessage = errorMessageLookup;
                     }*/


                /*
                   if(validationErrorMessage==null && lineItems_TotalAmount_Sum!=lineTotal && lineItems.size()>0) {
                       System.out.println("validation block2");
                   //validationErrorMessage = "Sum of Line Item Total Amount(s) should exactly match with Invoice Line Total Amount";
                   setExpressionResetValue("#{bindings.InvalidReasonId.inputValue}","5");
                   //                       setExpressionResetValue("#{bindings.ReasonTypeVO2.inputValue}","LINES<>TOTAL");
                   setExpressionResetValue("#{bindings.InvalidReasonTypeId.inputValue}","5");
                       System.out.println("get"+resolveExpression("#{bindings.InvalidReasonId.attributeValue}")+"<<>>"+ resolveExpression("#{bindings.InvalidReasonTypeId.attributeValue}"));
                   ViewObjectImpl vo = Utility.getAm().getErrorCodeLookupVO1();
                   System.out.println("reasonTypeId ************:"+reasonTypeId);
                   vo.setNamedWhereClauseParam("bindReasonType", 5);
                   vo.executeQuery();
                   RowSetIterator rs = vo.createRowSetIterator(null);
                   rs.reset();
                   String errorMessageLookup = null;
                   while(rs.hasNext()){
                       Row r = rs.next();
                       errorMessageLookup = (String)r.getAttribute("ErrorMessage");
                    }
                    validationErrorMessage = errorMessageLookup;
                   }*/

                //Certifier Name+Email mandatory for NON-PO Invoice
                if (validationErrorMessage == null &&
                    (supName == null || (supName != null && supName.trim().equals("")))) {

                    System.out.println("--- validation block --- 3");
                    //validationErrorMessage = "Supplier Name is missing!";
                    setExpressionResetValue("#{bindings.InvalidReasonId.inputValue}", "6");
                    //                       setExpressionResetValue("#{bindings.ReasonTypeVO2.inputValue}","NO EXACT MATCH");
                    setExpressionResetValue("#{bindings.InvalidReasonTypeId.inputValue}", "9");
                    System.out.println("get" + resolveExpression("#{bindings.InvalidReasonId.attributeValue}") +
                                       "<<>>" + resolveExpression("#{bindings.InvalidReasonTypeId.attributeValue}"));
                    ViewObjectImpl vo = Utility.getAm().getErrorCodeLookupVO1();
                    System.out.println("reasonTypeId:" + reasonTypeId);
                    vo.setNamedWhereClauseParam("bindReasonType", 9);
                    vo.executeQuery();
                    RowSetIterator rs = null;
                    try {
                        rs = vo.createRowSetIterator(null);
                        rs.reset();
                        String errorMessageLookup = null;
                        while (rs.hasNext()) {
                            Row r = rs.next();
                            errorMessageLookup = (String) r.getAttribute("ErrorMessage");
                        }
                        validationErrorMessage = errorMessageLookup;
                        System.out.println("--- validation block --- 3");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (rs != null) {
                            try {
                                rs.closeRowSetIterator();
                            } catch (Exception ex) {
                                ex.printStackTrace();

                            }
                        }
                    }
                }
                if (validationErrorMessage == null && siteId == -1) {

                    System.out.println("--- validation block --- 4");
                    //validationErrorMessage = "Site ID is missing!";
                    setExpressionResetValue("#{bindings.InvalidReasonId.inputValue}", "6");
                    //                       setExpressionResetValue("#{bindings.ReasonTypeVO2.inputValue}","NO EXACT MATCH");
                    setExpressionResetValue("#{bindings.InvalidReasonTypeId.inputValue}", "9");
                    System.out.println("get" + resolveExpression("#{bindings.InvalidReasonId.attributeValue}") +
                                       "<<>>" + resolveExpression("#{bindings.InvalidReasonTypeId.attributeValue}"));
                    ViewObjectImpl vo = Utility.getAm().getErrorCodeLookupVO1();
                    System.out.println("reasonTypeId:" + reasonTypeId);
                    vo.setNamedWhereClauseParam("bindReasonType", 9);
                    vo.executeQuery();
                    RowSetIterator rs = null;
                    try {
                        rs = vo.createRowSetIterator(null);
                        rs.reset();
                        String errorMessageLookup = null;
                        while (rs.hasNext()) {
                            Row r = rs.next();
                            errorMessageLookup = (String) r.getAttribute("ErrorMessage");
                        }

                        validationErrorMessage = errorMessageLookup;
                        System.out.println("--- validation block --- 4");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (rs != null) {
                            try {
                                rs.closeRowSetIterator();
                            } catch (Exception ex) {
                                ex.printStackTrace();

                            }
                        }
                    }
                }
                //                    DEACTIVATED FOR NOW
                /*
                   if(validationErrorMessage==null && lineItems.size()>0 && taxTotal!=lineItems_TaxAmount_Sum) {
                       System.out.println("--- validation block --- 5");
                       setExpressionResetValue("#{bindings.InvalidReasonId.inputValue}","13");
//                       setExpressionResetValue("#{bindings.ReasonTypeVO2.inputValue}","TAX TOTAL MISMATCH");
                       setExpressionResetValue("#{bindings.InvalidReasonTypeId.inputValue}","27");
                       System.out.println("get"+resolveExpression("#{bindings.InvalidReasonId.attributeValue}")+"<<>>"+ resolveExpression("#{bindings.InvalidReasonTypeId.attributeValue}"));
                       ViewObjectImpl vo = Utility.getAm().getErrorCodeLookupVO1();
                       System.out.println("reasonTypeId:"+reasonTypeId);
                       vo.setNamedWhereClauseParam("bindReasonType", 27);
                       vo.executeQuery();
                       RowSetIterator rs = vo.createRowSetIterator(null);
                       rs.reset();
                       String errorMessageLookup = null;
                       while(rs.hasNext()){
                           Row r = rs.next();
                           errorMessageLookup = (String)r.getAttribute("ErrorMessage");                }

                       validationErrorMessage = errorMessageLookup;
                       System.out.println("--- validation block --- 5");
                   }*/
                if (validationErrorMessage == null &&
                    (invNum == null || (invNum != null && invNum.trim().equals("")))) {
                    validationErrorMessage = "Invoice Number cannot be Blank";
                }
                if (validationErrorMessage == null &&
                    (invDate == null || (invDate != null && invDate.trim().equals("")))) {
                    validationErrorMessage = "Invoice Date cannot be Blank";
                }
                if (validationErrorMessage == null && taxTotal == Double.MIN_VALUE) {
                    validationErrorMessage = "Tax Total Amount cannot be Blank";
                }
                /*if(validationErrorMessage==null && headerTotal==Double.MIN_VALUE) {
                validationErrorMessage = "Header Toal Amount is missing!";
                   }*/
                //

                if (validationErrorMessage == null && invoiceType.equalsIgnoreCase("non po invoice")) {
                    if (certName == null || (certName != null && certName.trim().equals(""))) {
                        validationErrorMessage =
                            "Certifier Name is Blank. Certifier Name is mandatory for a Non-PO Invoice.";
                    } else if (certEmail == null || (certEmail != null && certEmail.trim().equals(""))) {
                        validationErrorMessage =
                            "Certifier Email is Blank. Certifier Email is mandatory for a Non-PO Invoice.";
                    }
                }
                if (validationErrorMessage == null && invoiceType.equalsIgnoreCase("po invoice")) {
                    if (poNum == null || (poNum != null && poNum.trim().equals(""))) {
                        validationErrorMessage = "PO Number is Blank. PO Number is mandatory for a PO Invoice.";
                    }
                }


                //            DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                //            DCIteratorBinding iterator = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
                //
                //            ArrayList<HashMap<String, Object>> lineItems = new ArrayList<HashMap<String,Object>>();
                //
                //            if (iterator.getViewObject().hasNext()) {
                //                Row row = iterator.getViewObject().next();
                //
                //                System.out.println("----- Line Item ----");
                //
                //                double lineItem_LineTotal = -1;
                //
                //                if(row.getAttribute("LineTotalAmount")!=null) {
                //                    lineItem_LineTotal = ((oracle.jbo.domain.Number)row.getAttribute("LineTotalAmount")).getValue();
                //                }
                //
                //                System.out.println("\t Line Total : "+lineItem_LineTotal);
                //
                //                HashMap<String, Object> lineItem = new HashMap<String, Object>();
                //                lineItem.put("LineTotalAmount", lineItem_LineTotal);
                //
                //                lineItems.add(lineItem);
                //            }

                System.out.println("----- End of Line Items -----");

                //double lineItems_TaxAmount_Sum = 0;

                for (int i = 0; i < lineItems.size(); i++) {

                    //lineItems_TaxAmount_Sum += (Double)lineItems.get(i).get("LineTotalAmount");

                    if (validationErrorMessage == null && invoiceType.equalsIgnoreCase("po invoice")) {

                        if (validationErrorMessage == null &&
                            (lineItems.get(i).get("LinePoNum") == null ||
                             (lineItems.get(i).get("LinePoNum") != null &&
                              ((String) lineItems.get(i).get("LinePoNum")).trim().equals("")))) {
                            validationErrorMessage =
                                "PO Number is missing for the following Line Item :<br/>" + "Line Number : " +
                                (Long) (lineItems.get(i).get("LineNumber")) + ", Description : " +
                                lineItems.get(i).get("LineDescription");
                            break;
                        } else if (validationErrorMessage == null &&
                                   (lineItems.get(i).get("PoLineNum") == null ||
                                    (lineItems.get(i).get("PoLineNum") != null &&
                                     ((String) lineItems.get(i).get("PoLineNum")).trim().equals("")))) {
                            validationErrorMessage =
                                "PO Line Number is missing for the following Line Item :<br/>" + "Line Number : " +
                                (Long) (lineItems.get(i).get("LineNumber")) + ", Description : " +
                                lineItems.get(i).get("LineDescription");
                            break;
                        }

                    }

                    /* Added by Sourav on 8th may line description validation */

                    //&& (lineItems.get(i).get("TaxRateCode")==null || (lineItems.get(i).get("TaxRateCode")!=null && ((String)lineItems.get(i).get("TaxRateCode")).trim().equals("")))


                    if (validationErrorMessage == null &&
                        (lineItems.get(i).get("LineDescription") == null ||
                         (lineItems.get(i).get("LineDescription") != null &&
                          ((String) lineItems.get(i).get("LineDescription")).trim().equals("")))) {
                        validationErrorMessage =
                            "Line description is missing for the following Line Item :<br/>" + "Line Number : " +
                            (Long) (lineItems.get(i).get("LineNumber")) + ", Description : " +
                            lineItems.get(i).get("LineDescription");
                        break;
                    }
                    if (validationErrorMessage == null && (Double) lineItems.get(i).get("Quantity") == -1.0 &&
                        invoiceType.equalsIgnoreCase("po invoice") && docType.equalsIgnoreCase("Invoice")) {
                        validationErrorMessage =
                            "Quantity is missing for the following Line Item :<br/>" + "Line Number : " +
                            (Long) (lineItems.get(i).get("LineNumber")) + ", Description : " +
                            lineItems.get(i).get("LineDescription");
                        break;
                    }
                    if (validationErrorMessage == null && (Double) lineItems.get(i).get("UnitPrice") == -1.0 &&
                        invoiceType.equalsIgnoreCase("po invoice") && docType.equalsIgnoreCase("Invoice")) {
                        validationErrorMessage =
                            "Unit Price Amount is missing for the following Line Item :<br/>" + "Line Number : " +
                            (Long) (lineItems.get(i).get("LineNumber")) + ", Description : " +
                            lineItems.get(i).get("LineDescription");
                        break;
                    }
                    //9-Sept adding wht code validation ::pinky

                    System.out.println("validationErrorMessage : " + validationErrorMessage);
                    System.out.println("whtRequiredFlag : " + whtRequiredFlag.getValue().toString());
                    System.out.println("LineItem i : " + lineItems.get(i).get("WhtCode"));

                    //                       if(validationErrorMessage==null && whtRequiredFlag.getValue().toString().equalsIgnoreCase("true")  && (lineItems.get(i).get("WhtCode")==null || (lineItems.get(i).get("WhtCode")!=null && ((String)lineItems.get(i).get("WhtCode")).trim().equals("")))) {
                    //                           System.out.println("WHT code missing block");
                    ////                           if(validationErrorMessage==null && invoiceType.equalsIgnoreCase("non po invoice")) {
                    //                               validationErrorMessage = "WHT Code is missing for the following Line Item :<br/>"
                    //                                                        + "Line Number : "+(Long)(lineItems.get(i).get("LineNumber"))+", Description : "+lineItems.get(i).get("LineDescription");
                    //                               break;
                    ////                           }
                    //                       }

                    if (validationErrorMessage == null &&
                        (lineItems.get(i).get("TaxRateCode") == null ||
                         (lineItems.get(i).get("TaxRateCode") != null &&
                          ((String) lineItems.get(i).get("TaxRateCode")).trim().equals("")))) {
                        if (validationErrorMessage == null && invoiceType.equalsIgnoreCase("non po invoice")) {
                            validationErrorMessage =
                                "Tax Rate Code is missing for the following Line Item :<br/>" + "Line Number : " +
                                (Long) (lineItems.get(i).get("LineNumber")) + ", Description : " +
                                lineItems.get(i).get("LineDescription");
                            break;
                        }
                    }
                }
            }

            if (validationErrorMessage != null) {
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                validationErrorPopup.show(hints);
                this.validationErrorMessage.setValue(validationErrorMessage);
                return false;

            } else {

                System.out.println("Inside else before saving----");
                if (resolveExpression("#{bindings.CertifierRejReason.inputValue}") != null)
                    rejReason = resolveExpression("#{bindings.CertifierRejReason.inputValue}").toString();
                if (resolveExpression("#{bindings.ApOperationComments.inputValue}") != null)
                    comments = resolveExpression("#{bindings.ApOperationComments.inputValue}").toString();
                if (resolveExpression("#{bindings.CertifierRejComments.inputValue}") != null)
                    certComments = resolveExpression("#{bindings.CertifierRejComments.inputValue}").toString();
                if ((needValidation) && (reasonId != null && (!reasonId.equals("16") && !reasonId.equals("20")))) {
                    System.out.println("setting the reason code and type for NONE");
                    reasonId = "14";
                    reasonTypeId = "29";

                }
                //System.out.println("Cerfier name tosave is"+certName);
                System.out.println("Certifier no tosave is" + certNo);
                doSaveOperation(supName, (siteId == -1 ? "" : ("" + siteId)), invNum, taxRegNum, poNum,
                                (lineTotal == Double.MIN_VALUE ? "" : formattedDecimalNumber(lineTotal)), certName,
                                currency, invDate,
                                (taxTotal == Double.MIN_VALUE ? "" : formattedDecimalNumber(taxTotal)),
                                (headerTotal == Double.MIN_VALUE ? "" : formattedDecimalNumber(headerTotal)), certEmail,
                                rejReason, comments, certComments, reasonId, reasonTypeId, statusStr, docType,
                                invoiceType, operatingUnit, invalidReasonType, invalidReason, needValidation, certNo);

                /* Saving to comments table on submit button from AP Operations page*/

                /*  if(description!= null && needValidation)
                   {
                        saveAPComments(getInvoiceId(),commentsDate,description,name);
                   }*/

                /* Saving to comments table on both submit and save*/

                if (description != null && name != null && getInvoiceId() != null) {
                    System.out.println("Saving comments on save or submit click");
                    saveAPComments(getInvoiceId(), commentsDate, description, name);

                }

                System.out.println("--- before  committing");

                dbCommit();
                //needValidation=false;
                if (!needValidation) { //changed on 19th Sept 2017 by A.D
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    validationErrorPopup.show(hints);
                    this.validationErrorMessage.setValue("Record has been Saved Successfully");


                    //AdfFacesContext.getCurrentInstance().getPageFlowScope().put("showSavedSuccessMsg","Record has been Saved Successfully");
                    FacesContext.getCurrentInstance()
                                .getExternalContext()
                                .getSessionMap()
                                .put("showSavedSuccessMsg", "Record has been Saved Successfully");
                    System.out.println("inside save click showSavedSuccessMsg ::" +
                                       FacesContext.getCurrentInstance()
                                                                                                .getExternalContext()
                                                                                                .getSessionMap()
                                                                                                .get("showSavedSuccessMsg"));

                    FacesContext fctx = FacesContext.getCurrentInstance();
                    ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);

                    String myJavaScriptCode = "location.reload();";
                    //erks.addScript(fctx, myJavaScriptCode );
                    //refreshPage();

                    //To-DO
                    //set pfs var : showSavedSuccessMsg
                    //javascript code to refresh the page
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lineItemItr != null) {
                try {
                    lineItemItr.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        System.out.println("End: validateAndDoSaveOperation");
        return false;

    }

    public static String formattedDecimalNumber(double d) {
        String retStr = String.format("%.2f", d);

        if (retStr.endsWith(".00")) {

            retStr = retStr.substring(0, retStr.length() - 3);
        }

        return retStr;
    }


    public static Object resolveExpression(String expression) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
        return valueExp.getValue(elContext);
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public void doSaveOperation(String supName, String siteId, String invNum, String taxRegNum, String poNum,
                                String lineId, String certName, String currency, String invDate, String taxTotal,
                                String headerTotal, String certEmail, String rejReason, String comments,
                                String certComments, String reason, String type, String status, String docType,
                                String invoiceType, String operatingUnit, String invalidReasonType,
                                String invalidReason, Boolean needValidation, String certNo) {
        System.out.println("Start: doSaveOperation");
        BindingContext bindingContext = null;
        BindingContainer bindingContainer = null;
        OperationBinding operationBinding = null;

        BindingContext bpmUpdatebindingContext = null;
        BindingContainer bpmUpdatebindingContainer = null;
        OperationBinding bpmUpdateoperationBinding = null;

        // Store status field value in BPM Status Attribute

        /* if(!(statusSOC.getValue()==null || (statusSOC.getValue()!=null && statusSOC.getValue().equals(""))))
        {

             bpmStatus.setValue(statusSOC.getValue().toString());
             System.out.println("BPM Status :::"+bpmStatus.getValue());
             AdfFacesContext.getCurrentInstance().addPartialTarget(bpmStatus);
        }*/
        System.out.println("----- in save invalidreasontype" + invalidReasonType);
        System.out.println("----- in save invalidreason" + invalidReason);
        try {
            if (!needValidation) {
                //                bpmUpdatebindingContext = BindingContext.getCurrent();
                //                bpmUpdatebindingContainer = bpmUpdatebindingContext.getCurrentBindingsEntry();
                //                bpmUpdateoperationBinding = bpmUpdatebindingContainer.getOperationBinding("update");
                //                System.out.println("bpmUpdateoperationBinding :::"+bpmUpdateoperationBinding);
                //                bpmUpdateoperationBinding.execute();

                updateTask();
            }

            bindingContext = BindingContext.getCurrent();
            bindingContainer = bindingContext.getCurrentBindingsEntry();
            operationBinding = bindingContainer.getOperationBinding("saveAPOperationDetails");
            operationBinding.getParamsMap().put("flag", needValidation);
            operationBinding.getParamsMap().put("invoiceId", getInvoiceId());
            operationBinding.getParamsMap().put("supName", supName);
            operationBinding.getParamsMap().put("siteId", siteId);
            operationBinding.getParamsMap().put("invNum", invNum);
            operationBinding.getParamsMap().put("taxRegNum", taxRegNum);
            operationBinding.getParamsMap().put("poNum", poNum);
            operationBinding.getParamsMap().put("lineTotal", lineId);
            operationBinding.getParamsMap().put("certName", certName);
            operationBinding.getParamsMap().put("currency", currency);


            if (invDate != null) {
                System.out.println("Invoice date is not null " + invDate);
                operationBinding.getParamsMap().put("invDate", invDate);
            } else {
                //System.out.println("Invoice date is null hence setting the default date as sys date"+ new Date());
                System.out.println("Invoice date is null hence setting the default date as sys date jbo date" +
                                   new Date());
                operationBinding.getParamsMap().put("invDate", new oracle.jbo.domain.Date());

            }
            operationBinding.getParamsMap().put("taxTotal", taxTotal);
            operationBinding.getParamsMap().put("headerTotal", headerTotal);
            operationBinding.getParamsMap().put("certEmail", certEmail);

            operationBinding.getParamsMap().put("rejReason", rejReason);
            operationBinding.getParamsMap().put("comments", comments);
            operationBinding.getParamsMap().put("certComments", certComments);

            operationBinding.getParamsMap().put("reason", reason);
            operationBinding.getParamsMap().put("type", type);
            operationBinding.getParamsMap().put("status", status);
            operationBinding.getParamsMap().put("docType", docType);
            operationBinding.getParamsMap().put("invoiceType", invoiceType);
            operationBinding.getParamsMap().put("operatingUnit", operatingUnit);
            operationBinding.getParamsMap().put("invalidReasonType", invalidReasonType);
            operationBinding.getParamsMap().put("invalidReason", invalidReason);
            operationBinding.getParamsMap().put("employeeNo", certNo);
            operationBinding.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End: doSaveOperation");
    }

    //    public static String charRepeat(char ch, int n) {
    //        StringBuffer sb = new StringBuffer();
    //        for(int i=0;i<n;i++) {
    //            sb.append(ch);
    //        }
    //        return sb.toString();
    //    }
    //
    //    public static void showElement(Node obj, int... level) {
    //        String indent = null;
    //        int nextLevel = 0;
    //        //System.out.println(Arrays.toString(level));
    //        if(level==null || level.length==0) {
    //            indent = "";
    //            nextLevel = 1;
    //        } else {
    //            indent = charRepeat('\t',level[0]);
    //            nextLevel = level[0] + 1;
    //        }
    //
    //
    //            Node e = (Node)obj;
    //            System.out.println(indent + e.getNodeName()+" : "+e.getNodeValue());
    //            if(e.getChildNodes()!=null && e.getChildNodes().getLength()>0) {
    //                for(int i=0; i<e.getChildNodes().getLength(); i++) {
    //                    showElement(e.getChildNodes().item(i), nextLevel);
    //                }
    //            }
    //
    //    }

    //    public static void main(String[] a) {
    //        try {
    //            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    //            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    //            Document doc = docBuilder.parse(new File("D:\\task_payload.xml"));
    //
    //            Element e = doc.getDocumentElement();
    //
    //            showElement(e);
    //
    //
    //            System.out.println("===== AFTER UPDATE =====");
    //
    //            Map namespacemap = new HashMap();
    //            namespacemap.put("ns0", "http://xmlns.oracle.com/bpel/workflow/task");
    //            //updateElement(doc, "task/title", "Internal Status : "+new Date());
    //            setPayloadValue(e,"/ns0:task/ns0:payload/ns0:Status",namespacemap,"Hello12345");
    //
    //            showElement(e);
    //
    //
    //
    //
    //        } catch(Exception e) {
    //            e.printStackTrace();
    //        }
    //
    //    }

    public static void setPayloadValue(Element payload, String xpath, Map namespacemap, String value) {
        try {
            XPathUtils.setNodeValue(payload, namespacemap, xpath, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void updateElement(Document e, String xpathXpr, String newValue) throws XPathExpressionException {
        System.out.println("----- updateElement : START");
        XPath xPath = XPathFactory.newInstance().newXPath();

        Node node = (Node) xPath.compile(xpathXpr).evaluate(e, XPathConstants.NODE);
        node.setNodeValue(newValue);
        node.setTextContent(newValue);

        System.out.println("----- updateElement : END");
    }

    public void approveTask() {
        System.out.println("----- approveTask ----- START ---- -" + new Date());
        FacesContext context = FacesContext.getCurrentInstance();
        String ctx =
            (String) context.getApplication()
            .evaluateExpressionGet(context, "#{pageFlowScope.bpmWorklistContext}", String.class);
        String taskId =
            (String) context.getApplication()
            .evaluateExpressionGet(context, "#{pageFlowScope.bpmWorklistTaskId}", String.class);
        System.out.println("----- bpmWorklistContext : " + ctx + ", bpmWorklistTaskId : " + taskId);
        IWorkflowServiceClient workflowSvcClient = ADFWorklistBeanUtil.getWorkflowServiceClient();
        ITaskQueryService wfQueryService = workflowSvcClient.getTaskQueryService();
        ITaskService taskSvc = workflowSvcClient.getTaskService();

        IWorkflowContext wfContext;

        try {
            wfContext = wfQueryService.getWorkflowContext(ctx);
            Task currentTask = wfQueryService.getTaskDetailsById(wfContext, taskId);
            System.out.println("----- Approving task : START -----");
            taskSvc.updateTaskOutcome(wfContext, currentTask, "APPROVE");
            System.out.println("----- Approving task : END -----");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("----- approveTask ----- END ----- " + new Date());
    }


    public void updateTask() {
        System.out.println("----- updateTask ----- START ---- -" + new Date());
        FacesContext context = FacesContext.getCurrentInstance();
        String ctx =
            (String) context.getApplication()
            .evaluateExpressionGet(context, "#{pageFlowScope.bpmWorklistContext}", String.class);

        String taskId =
            (String) context.getApplication()
            .evaluateExpressionGet(context, "#{pageFlowScope.bpmWorklistTaskId}", String.class);

        System.out.println("----- bpmWorklistContext : " + ctx + ", bpmWorklistTaskId : " + taskId);

        IWorkflowServiceClient workflowSvcClient = ADFWorklistBeanUtil.getWorkflowServiceClient();
        ITaskQueryService wfQueryService = workflowSvcClient.getTaskQueryService();
        ITaskService taskSvc = workflowSvcClient.getTaskService();

        //        List queryColumns = new ArrayList();
        //        queryColumns.add("TASKNUMBER");
        //        queryColumns.add("TITLE");
        //        queryColumns.add("PRIORITY");
        //        queryColumns.add("STATE");
        //        queryColumns.add("ENDDATE");


        IWorkflowContext wfContext;
        String userName = "";
        try {
            wfContext = wfQueryService.getWorkflowContext(ctx);

            //Predicate taskIdPredicate = new Predicate(TableConstants.WFTASK_TASKID_COLUMN, Predicate.OP_EQ, taskId);

            Task currentTask = wfQueryService.getTaskDetailsById(wfContext, taskId);


            Element payload = currentTask.getPayloadAsElement();
            Document document = payload.getOwnerDocument();

            DocumentBuilderFactory domFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = domFact.newDocumentBuilder();

            DOMSource domSource = new DOMSource(document);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);

            /*System.out.println("----- PAYLOAD START -----");
            System.out.println(writer.toString());
            System.out.println("----- PAYLOAD END -----");*/


            System.out.println("----- Updating task field START -----");

            Map namespacemap = new HashMap();
            namespacemap.put("ns0", "http://xmlns.oracle.com/bpel/workflow/task");

            String selectedStatus = (statusSOC.getValue() == null) ? "-1" : (String) statusSOC.getValue();
            System.out.println("-----Selected Status : " + selectedStatus);
            try {
                selectedStatus = PropertyLoader.getInstance()
                                               .getInternalStatusMap()
                                               .get(Long.parseLong(selectedStatus));
                System.out.println("-----Selected Status value : " + selectedStatus);
            } catch (Exception ex) {
                //                ex.printStackTrace();
                System.out.println("UpdateTask Exception : " + ex.getMessage());
            }

            System.out.println("----- Selected value for internal Status : " + selectedStatus);

            setPayloadValue(payload, "/ns0:task/ns0:payload/ns0:Status", namespacemap, selectedStatus);


            currentTask.setPayloadAsElement(payload);
            taskSvc.updateTask(wfContext, currentTask);

            System.out.println("----- Updating task field END -----");

        } catch (WorkflowException wfEx) {
            wfEx.printStackTrace();
        } catch (ParserConfigurationException pcEx) {
            pcEx.printStackTrace();
        } catch (TransformerConfigurationException tcEx) {
            tcEx.printStackTrace();
        } catch (TransformerException tEx) {
            tEx.printStackTrace();
        } catch (StaleObjectException stObjEx) {
            stObjEx.printStackTrace();
        }
        //        catch(XPathExpressionException xpEx) {
        //            xpEx.printStackTrace();
        //        }

        System.out.println("----- updateTask ----- END ----- " + new Date());

    }

    public void updateTaskOnSync() {

        System.out.println("----- updateTaskOnSync ----- START ---- -" + new Date());
        FacesContext context = FacesContext.getCurrentInstance();
        String ctx =
            (String) context.getApplication()
            .evaluateExpressionGet(context, "#{pageFlowScope.bpmWorklistContext}", String.class);

        String taskId =
            (String) context.getApplication()
            .evaluateExpressionGet(context, "#{pageFlowScope.bpmWorklistTaskId}", String.class);

        System.out.println("----- bpmWorklistContext : " + ctx + ", bpmWorklistTaskId : " + taskId);

        IWorkflowServiceClient workflowSvcClient = ADFWorklistBeanUtil.getWorkflowServiceClient();
        ITaskQueryService wfQueryService = workflowSvcClient.getTaskQueryService();
        ITaskService taskSvc = workflowSvcClient.getTaskService();

        IWorkflowContext wfContext;
        String userName = "";
        try {
            wfContext = wfQueryService.getWorkflowContext(ctx);

            //Predicate taskIdPredicate = new Predicate(TableConstants.WFTASK_TASKID_COLUMN, Predicate.OP_EQ, taskId);

            Task currentTask = wfQueryService.getTaskDetailsById(wfContext, taskId);


            Element payload = currentTask.getPayloadAsElement();
            Document document = payload.getOwnerDocument();

            DocumentBuilderFactory domFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = domFact.newDocumentBuilder();

            DOMSource domSource = new DOMSource(document);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);

            /*System.out.println("----- PAYLOAD START -----");
            System.out.println(writer.toString());
            System.out.println("----- PAYLOAD END -----");*/


            System.out.println("----- Updating task field START -----");

            Map namespacemap = new HashMap();
            namespacemap.put("ns0", "http://xmlns.oracle.com/bpel/workflow/task");

            String selectedStatus = (statusSOC.getValue() == null) ? "-1" : (String) statusSOC.getValue();
            System.out.println("-----Selected Status : " + selectedStatus);
            try {
                selectedStatus = PropertyLoader.getInstance()
                                               .getInternalStatusMap()
                                               .get(Long.parseLong(selectedStatus));
                System.out.println("-----Selected Status value : " + selectedStatus);
            } catch (Exception ex) {
                //                ex.printStackTrace();
                System.out.println("UpdateTaskOnSync Exception : " + ex.getMessage());
            }
            //System.out.println("----- Selected value for internal Status : "+selectedStatus);
            //supplier name
            String suppname = supNameIt.getValue() != null ? supNameIt.getValue().toString() : null;
            //System.out.println("----- Selected value for Supplier name : "+suppname);

            //invoice number
            String invNum = invNumIt.getValue() != null ? invNumIt.getValue().toString() : null;
            //System.out.println("----- Selected value for invoice number : "+invNum);

            //invoice total amount
            String invTotalAmnt = headerTotIt.getValue() != null ? headerTotIt.getValue().toString() : null;
            System.out.println("----- Selected value for invoice total amount : " + invTotalAmnt);


            //invoice date
            /* String invDate = invDateId.getValue()!= null ? invDateId.getValue().toString():null;
            System.out.println("----- Selected value for invoice date : "+invDate); */
            oracle.jbo.domain.Date invDate = null;
            if (invDateId.getValue() != null) {
                invDate = ((oracle.jbo.domain.Date) invDateId.getValue());
            }


            //            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
            //            String invoiceDate = DATE_FORMAT.format(invDate.getValue());
            //            System.out.println("----- Selected value for invoice date in yyyy-MM-dd format : " + invoiceDate);

            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
            String invoiceDate = invDate != null ? DATE_FORMAT.format(invDate.getValue()) : null;
            System.out.println("----- Selected value for invoice date in dd/MM/yyyy format : " + invoiceDate);

            //Po number
            String poNum = poNumIt.getValue() != null ? poNumIt.getValue().toString() : null;
            //System.out.println("----- Selected value for po no : "+poNum);

            //currency
            String currency = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;
            //System.out.println("----- Selected value for currency : "+currency);

            //operating unit
            String operatingUnit = operatingUnitIt.getValue() != null ? operatingUnitIt.getValue().toString() : null;
            //System.out.println("----- Selected value for operating unit : "+operatingUnit);


            //due date
            String dueDate = null;
            //supplier name
            String suppId = (String) ADFContext.getCurrent()
                                               .getPageFlowScope()
                                               .get("supplier_id_value");
            System.out.println("----- Selected value for Supplier ID : " + suppId);


            String siteId = siteIdIt.getValue() != null ? siteIdIt.getValue().toString() : null;
            System.out.println("----- Selected value for Site ID : " + siteId);

            String invScanDat = null;
            invScanDat = ADFContext.getCurrent()
                                   .getPageFlowScope()
                                   .get("invoiceScanDate") != null ? (String) ADFContext.getCurrent()
                                                                                        .getPageFlowScope()
                                                                                        .get("invoiceScanDate") : null;
            //System.out.println("----- Selected value for invScanDat : "+invScanDat);

            //dueDate = ap.quantas.com.ebsCalculateInvoiceDueDateWebService.DueDateService_pttBindingQSPortClient.calculateInvoiceDueDate(suppId, siteId, invoiceDate);
            dueDate =
                JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEPortClient.calculateInvoiceDueDate(suppId, siteId, invoiceDate,
                                                                                        invScanDat);
            System.out.println("----- Calculated value for Due Date : " + dueDate);
            java.util.Date dueDateBpm = null;
            String dueDateBpmStr = null;
            SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dueDateBpm = dueDate != null ? DATE_FORMAT.parse(dueDate) : null;
                dueDateBpmStr = dueDateBpm != null ? DATE_FORMAT2.format(dueDateBpm) : null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("----- Calculated value for Due Date after formatting : " + dueDateBpmStr);
            //setPayloadValue(payload,"/ns0:task/ns0:payload/ns0:Status",namespacemap, selectedStatus);
            setPayloadValue(payload, "/ns0:task/ns0:payload/ns0:SupplierName", namespacemap, suppname);
            setPayloadValue(payload, "/ns0:task/ns0:payload/ns0:InvoiceNumber", namespacemap, invNum);
            setPayloadValue(payload, "/ns0:task/ns0:payload/ns0:InvoiceTotal", namespacemap, invTotalAmnt);
            setPayloadValue(payload, "/ns0:task/ns0:payload/ns0:Duedate", namespacemap, dueDateBpmStr);
            setPayloadValue(payload, "/ns0:task/ns0:payload/ns0:InvoiceDate", namespacemap, invoiceDate);
            setPayloadValue(payload, "/ns0:task/ns0:payload/ns0:PONumber", namespacemap, poNum);
            setPayloadValue(payload, "/ns0:task/ns0:payload/ns0:OperatingUnit", namespacemap, operatingUnit);
            setPayloadValue(payload, "/ns0:task/ns0:payload/ns0:Currency", namespacemap, currency);

            currentTask.setPayloadAsElement(payload);
            taskSvc.updateTask(wfContext, currentTask);

            System.out.println("----- Updating task field END -----");

        } catch (WorkflowException wfEx) {
            wfEx.printStackTrace();
        } catch (ParserConfigurationException pcEx) {
            pcEx.printStackTrace();
        } catch (TransformerConfigurationException tcEx) {
            tcEx.printStackTrace();
        } catch (TransformerException tEx) {
            tEx.printStackTrace();
        } catch (StaleObjectException stObjEx) {
            stObjEx.printStackTrace();
        }
        //        catch(XPathExpressionException xpEx) {
        //            xpEx.printStackTrace();
        //        }

        System.out.println("----- updateTaskOnSync ----- END ----- " + new Date());
    }

    public void openSupNamePopup(ActionEvent actionEvent) {
        System.out.println("Start: openSupNamePopup");
        try {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p1.show(hints);

            System.out.println("currency Code :" + currencyIt.getValue() != null ? currencyIt.getValue().toString() :
                               null);

            String enteredSupName = null;
            if (supNameIt.getValue() != null) {
                enteredSupName = supNameIt.getValue().toString();
                System.out.println("supNameIt.getValue(): " + enteredSupName);
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("SitesVO1Iterator");
                ViewObjectImpl suppNameVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = suppNameVO.getViewCriteria("SitesVOCriteria");
                suppNameVO.applyViewCriteria(vc);
                suppNameVO.setNamedWhereClauseParam("bindVendorName", enteredSupName);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(suppNameVO.getQuery());
                suppNameVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(supDetailsTable);

            }
            /* else {
                System.out.println("supNameIt.getValue(): "+enteredSupName);
                enteredSupName="";
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("SitesVO1Iterator");
                ViewObjectImpl suppNameVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = suppNameVO.getViewCriteria("SitesVOCriteria");
                suppNameVO.applyViewCriteria(vc);
                suppNameVO.setNamedWhereClauseParam("bindVendorName", enteredSupName);
                System.out.println("-----------Dynamic Query-----------");
                System.out.println(suppNameVO.getQuery());
                suppNameVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(supDetailsTable);
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End: openSupNamePopup");
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void openSiteIdPopup(ActionEvent actionEvent) {
        System.out.println("Start openSiteIdPopup");
        try {
            siteNamePopupIt.setValue(siteIdIt.getValue());
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p2.show(hints);
            String enteredSiteId = null;
            String enteredSiteName = null;
            if (supNameIt.getValue() != null && !supNameIt.getValue().equals("")) {
                enteredSiteName = supNameIt.getValue().toString();
                System.out.println("supNameIt.getValue(): " + enteredSiteName);
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("SitesDetailsVO1Iterator");
                ViewObjectImpl siteNameVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = siteNameVO.getViewCriteria("SitesDetailsVOCriteria2");
                siteNameVO.applyViewCriteria(vc);
                siteNameVO.setNamedWhereClauseParam("bindSupplierName", enteredSiteName);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(siteNameVO.getQuery());
                siteNameVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(siteDetailsTable);
            } else if (siteIdIt.getValue() != null && !siteIdIt.getValue().equals("")) {
                enteredSiteId = siteIdIt.getValue().toString();
                System.out.println("siteIdIt.getValue(): " + enteredSiteId);
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("SitesDetailsVO1Iterator");
                ViewObjectImpl siteNameVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = siteNameVO.getViewCriteria("SitesDetailsVOCriteria1");
                siteNameVO.applyViewCriteria(vc);
                siteNameVO.setNamedWhereClauseParam("bindSiteId", enteredSiteId);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(siteNameVO.getQuery());
                siteNameVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(siteDetailsTable);
            } else if ((supNameIt.getValue() == null || supNameIt.getValue().equals("")) &&
                       (siteIdIt.getValue() == null || siteIdIt.getValue().equals(""))) {
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("SitesDetailsVO1Iterator");
                ViewObjectImpl siteNameVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                siteNameVO.removeApplyViewCriteriaName("SitesDetailsVOCriteria1");
                siteNameVO.removeApplyViewCriteriaName("SitesDetailsVOCriteria2");
                siteNameVO.removeApplyViewCriteriaName("SitesDetailsVOCriteria");
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(siteNameVO.getQuery());
                siteNameVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(siteDetailsTable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openSiteIdPopup");

    }

    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }

    public void showPONumberPopup(ActionEvent actionEvent) {

        Object isLineItemPopupParam = actionEvent.getComponent()
                                                 .getAttributes()
                                                 .get("isLineItemPopup");
        System.out.println(" ----- showPONumberPopup : " + isLineItemPopupParam);

        if (isLineItemPopupParam != null && isLineItemPopupParam.toString() != null &&
            isLineItemPopupParam.toString().equalsIgnoreCase("yes")) {
            this.isLineItemPopup.setValue("yes");
        } else {
            this.isLineItemPopup.setValue("no");
        }

        poNumPopupIt.setValue(poNumIt.getValue());

        System.out.println("Start showPONumberPopup");
        try {

            String enteredPonumber = null;
            String enteredSiteId = null;

            //                  if(siteIdIt.getValue() != null) {
            //                        enteredSiteId = siteIdIt.getValue().toString();
            //                        System.out.println("siteIdIt.getValue(): "+enteredSiteId);
            //                        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            //                        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
            //                        ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
            //                        ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria1");
            //                        poNOVO.applyViewCriteria(vc);
            //                        poNOVO.setNamedWhereClauseParam("bindSiteId", enteredSiteId);
            //                        System.out.println("-----------Dynamic Query-----------");
            //                        System.out.println(poNOVO.getQuery());
            //                        poNOVO.executeQuery();
            //                        AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
            //                    }
            //                else if(poNumIt.getValue() != null) {
            //                        enteredPonumber = poNumIt.getValue().toString();
            //                        System.out.println("poNumIt.getValue(): "+enteredPonumber);
            //                        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            //                        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
            //                        ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
            //                        ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria");
            //                        poNOVO.applyViewCriteria(vc);
            //                        poNOVO.setNamedWhereClauseParam("bindPONum", enteredPonumber);
            //                        System.out.println("-----------Dynamic Query-----------");
            //                        System.out.println(poNOVO.getQuery());
            //                        poNOVO.executeQuery();
            //                        AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
            //                        }
            //
            //                else if(siteIdIt.getValue()==null && poNumIt.getValue()==null){

            /*System.out.println("----- Site ID ------- : ["+siteIdIt.getValue()+"]");
                System.out.println("----- PO Number ----- : ["+poNumIt.getValue()+"]");  */

            if (siteIdIt.getValue() != null) {
                System.out.println("Inside Both Null condition ");
                /* enteredPonumber = poNumIt.getValue().toString();
                        System.out.println("poNumIt.getValue(): "+enteredPonumber);*/
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                ViewObjectImpl poNOVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria2");
                poNOVO.applyViewCriteria(vc);
                poNOVO.setNamedWhereClauseParam("bindPONum", poNumIt.getValue() == null ? "" : poNumIt.getValue()
                                                                                                      .toString()
                                                                                                      .trim());
                poNOVO.setNamedWhereClauseParam("bindSiteId", siteIdIt.getValue()
                                                                      .toString()
                                                                      .trim());
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(poNOVO.getQuery());
                poNOVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
                //   AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);

            } else {
                //                    this.validationErrorMessage.setValue("Site Id must be selected first to search for a PO.");
                //                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                //                    validationErrorPopup.show(hints);
                enteredPonumber = poNumIt.getValue() == null ? "" : poNumIt.getValue()
                                                                           .toString()
                                                                           .trim();
                System.out.println("poNumIt.getValue(): " + enteredPonumber);
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                ViewObjectImpl poNOVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria");
                poNOVO.applyViewCriteria(vc);
                poNOVO.setNamedWhereClauseParam("bindPONum", enteredPonumber);
                // System.out.println("-----------Dynamic Query-----------");
                // System.out.println(poNOVO.getQuery());
                poNOVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);


            }

            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p4.show(hints);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End showPONumberPopup");
    }
    /*public void showPONumberPopup(ActionEvent actionEvent) {
        System.out.println("Start showPONumberPopup");
        try {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p4.show(hints);
            String enteredPONum=null;
            //String enteredSupName=null;
            String enteredSiteId=null;
            if(supNameIt.getValue()!=null) {
                enteredSupName = supNameIt.getValue().toString();
            }
            if(siteIdIt.getValue()!=null) {
                enteredSiteId = siteIdIt.getValue().toString();
            }
            if(enteredSiteId==null){
                if(poNumIt.getValue() != null)
                enteredPONum = poNumIt.getValue().toString();
                System.out.println("poNumPopupIt.getValue(): "+enteredPONum);
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                ViewObjectImpl poNumVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = poNumVO.getViewCriteria("POVOCriteria");
                poNumVO.applyViewCriteria(vc);
                poNumVO.setNamedWhereClauseParam("bindPONum", enteredPONum);
                System.out.println("-----------Dynamic Query-----------");
                System.out.println(poNumVO.getQuery());
                poNumVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);


            }
            else{
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                ViewObjectImpl poNumVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = poNumVO.getViewCriteria("POVOCriteria1");
                poNumVO.applyViewCriteria(vc);
                System.out.println("siteid" +enteredSiteId);
                //poNumVO.setNamedWhereClauseParam("bindSupplierName", enteredSupName);
                poNumVO.setNamedWhereClauseParam("bindSiteId", enteredSiteId);
                System.out.println("-----------Dynamic Query-----------");
                System.out.println(poNumVO.getQuery());
                poNumVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End showPONumberPopup");
    }*/

    //    public void showPONumberPopup(ActionEvent actionEvent) {
    //        System.out.println("Start showPONumberPopup");
    //        try {
    //            RichPopup.PopupHints hints = new RichPopup.PopupHints();
    //            p4.show(hints);
    //			String enteredPONum=null;
    //            String enteredSupName=null;
    //            String enteredSiteId=null;
    //            if(supNameIt.getValue()!=null) {
    //                enteredSupName = supNameIt.getValue().toString();
    //            }
    //            if(siteIdIt.getValue()!=null) {
    //                enteredSiteId = siteIdIt.getValue().toString();
    //            }
    //            if(enteredSupName==null && enteredSiteId==null){
    //                if(poNumIt.getValue() != null)
    //                    enteredPONum = poNumIt.getValue().toString();
    //                System.out.println("poNumPopupIt.getValue(): "+enteredPONum);
    //                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
    //                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
    //                ViewObjectImpl poNumVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
    //                ViewCriteria vc = poNumVO.getViewCriteria("POVOCriteria");
    //                poNumVO.applyViewCriteria(vc);
    //                poNumVO.setNamedWhereClauseParam("bindPONum", enteredPONum);
    //                System.out.println("-----------Dynamic Query-----------");
    //                System.out.println(poNumVO.getQuery());
    //                poNumVO.executeQuery();
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
    //
    //
    //            }
    //            else{
    //                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
    //                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
    //                ViewObjectImpl poNumVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
    //                ViewCriteria vc = poNumVO.getViewCriteria("POVOCriteria1");
    //                poNumVO.applyViewCriteria(vc);
    //                poNumVO.setNamedWhereClauseParam("bindSupplierName", enteredSupName);
    //                poNumVO.setNamedWhereClauseParam("bindSiteId", enteredSiteId);
    //                System.out.println("-----------Dynamic Query-----------");
    //                System.out.println(poNumVO.getQuery());
    //                poNumVO.executeQuery();
    //                AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
    //            }
    //        }
    //        catch(Exception e) {
    //            e.printStackTrace();
    //        }
    //        System.out.println("End showPONumberPopup");
    //    }

    /*  public void showPONumberTablePopup(ActionEvent actionEvent) {
        System.out.println("Start showPONumberTablePopup");
        try {
           // String enteredPonumber=null;
            //poNumIt
            String enteredPonumber = null;
            String enteredSiteId = null;
                if(poNumIt.getValue() != null) {
                    enteredPonumber = poNumIt.getValue().toString();
                    System.out.println("poNumIt.getValue(): "+enteredPonumber);
                    DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                    DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                    ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                    ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria");
                    poNOVO.applyViewCriteria(vc);
                    poNOVO.setNamedWhereClauseParam("bindPONum", enteredPonumber);
                    System.out.println("-----------Dynamic Query-----------");
                    System.out.println(poNOVO.getQuery());
                    poNOVO.executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
                }
                else if(siteIdIt.getValue() != null) {
                    enteredSiteId = siteIdIt.getValue().toString();
                    System.out.println("siteIdIt.getValue(): "+enteredSiteId);
                    DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                    DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                    ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                    ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria1");
                    poNOVO.applyViewCriteria(vc);
                    poNOVO.setNamedWhereClauseParam("bindSiteId", enteredSiteId);
                    System.out.println("-----------Dynamic Query-----------");
                    System.out.println(poNOVO.getQuery());
                    poNOVO.executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
                }

            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p4.show(hints);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End showPONumberTablePopup");
    }*/
    public void showPONumberTablePopup(ActionEvent actionEvent) {
        System.out.println("Start showPONumberTablePopup");
        RowSetIterator lineItemRSIter = null;
        Object isLineItemPopupParam = actionEvent.getComponent()
                                                 .getAttributes()
                                                 .get("isLineItemPopup");
        System.out.println(" ----- showPONumberPopup : " + isLineItemPopupParam);


        String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        System.out.println(" ----- clientID : " + clientId);
        this.clientID.setValue(clientId);


        if (isLineItemPopupParam != null && isLineItemPopupParam.toString() != null &&
            isLineItemPopupParam.toString().equalsIgnoreCase("yes")) {
            this.isLineItemPopup.setValue("yes");
        } else {
            this.isLineItemPopup.setValue("no");
        }

        try {
            String enteredSiteId = null;
            //poNumIt
            String enteredPonumber = null;

            RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
            Iterator rowKeySetIt = rowKeySet.iterator();
            DCIteratorBinding lineItemIter =
                ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry())
                .findIteratorBinding("LineItemDetailsEOView1Iterator");
            lineItemRSIter = lineItemIter.getRowSetIterator();
            while (rowKeySetIt.hasNext()) {
                Key key = (Key) ((List) rowKeySetIt.next()).get(0);
                Row currentRow = lineItemRSIter.getRow(key);
                if (currentRow != null) {
                    //System.out.println("----- typedInPONumber ----- "+currentRow.getAttribute("LinePoNum"));

                    enteredPonumber = currentRow.getAttribute("LinePoNum") == null ? "" : currentRow.getAttribute("LinePoNum")
                                                                                                    .toString()
                                                                                                    .trim();
                }
            }
            poNumPopupIt.setValue(enteredPonumber);


            if (siteIdIt.getValue() != null) {


                //pt1:t1:0:it35::content
                /* enteredPonumber = poNumIt.getValue().toString();
                      System.out.println("poNumIt.getValue(): "+enteredPonumber);*/
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                ViewObjectImpl poNOVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria2");
                poNOVO.applyViewCriteria(vc);
                poNOVO.setNamedWhereClauseParam("bindPONum", enteredPonumber);
                poNOVO.setNamedWhereClauseParam("bindSiteId", siteIdIt.getValue()
                                                                      .toString()
                                                                      .trim());
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(poNOVO.getQuery());
                poNOVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
                //   AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);

            } else {
                //                  this.validationErrorMessage.setValue("Site Id must be selected first to search for a PO.");
                //                  validationErrorPopup.show(new RichPopup.PopupHints());
                //enteredPonumber = poNumIt.getValue()==null?"":poNumIt.getValue().toString().trim();
                System.out.println("poNumIt.getValue(): " + enteredPonumber);
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                ViewObjectImpl poNOVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria");
                poNOVO.applyViewCriteria(vc);
                poNOVO.setNamedWhereClauseParam("bindPONum", enteredPonumber);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(poNOVO.getQuery());
                poNOVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);

            }
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p4.show(hints);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lineItemRSIter != null) {
                try {
                    lineItemRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        System.out.println("End showPONumberTablePopup");
    }


    public void setP4(RichPopup p4) {
        this.p4 = p4;
    }

    public RichPopup getP4() {
        return p4;
    }

    public void setP5(RichPopup p5) {
        this.p5 = p5;
    }

    public RichPopup getP5() {
        return p5;
    }

    public void setSupNameIt(RichInputText supNameIt) {
        this.supNameIt = supNameIt;
    }

    public RichInputText getSupNameIt() {
        return supNameIt;
    }

    public void setSiteIdIt(RichInputText siteIdIt) {
        this.siteIdIt = siteIdIt;
    }

    public RichInputText getSiteIdIt() {
        return siteIdIt;
    }

    public void setInvNumIt(RichInputText invNumIt) {
        this.invNumIt = invNumIt;
    }

    public RichInputText getInvNumIt() {
        return invNumIt;
    }

    public void setTaxRegIt(RichInputText taxRegIt) {
        this.taxRegIt = taxRegIt;
    }

    public RichInputText getTaxRegIt() {
        return taxRegIt;
    }

    public void setPoNumIt(RichInputText poNumIt) {
        this.poNumIt = poNumIt;
    }

    public RichInputText getPoNumIt() {
        return poNumIt;
    }

    public void setLineIdIt(RichInputText lineIdIt) {
        this.lineIdIt = lineIdIt;
    }

    public RichInputText getLineIdIt() {
        return lineIdIt;
    }

    public void setCertNameIt(RichInputText certNameIt) {
        this.certNameIt = certNameIt;
    }

    public RichInputText getCertNameIt() {
        return certNameIt;
    }

    public void setCurrencyIt(RichInputText currencyIt) {
        this.currencyIt = currencyIt;
    }

    public RichInputText getCurrencyIt() {
        return currencyIt;
    }

    public void setInvDateId(RichInputDate invDateId) {
        this.invDateId = invDateId;
    }

    public RichInputDate getInvDateId() {
        return invDateId;
    }

    public void setTaxTotIt(RichInputText taxTotIt) {
        this.taxTotIt = taxTotIt;
    }

    public RichInputText getTaxTotIt() {
        return taxTotIt;
    }

    public void setHeaderTotIt(RichInputText headerTotIt) {
        this.headerTotIt = headerTotIt;
    }

    public RichInputText getHeaderTotIt() {
        return headerTotIt;
    }

    public void setCertEmailIt(RichInputText certEmailIt) {
        this.certEmailIt = certEmailIt;
    }

    public RichInputText getCertEmailIt() {
        return certEmailIt;
    }

    public void setSupNamePopupIt(RichInputText supNamePopupIt) {
        this.supNamePopupIt = supNamePopupIt;
    }

    public RichInputText getSupNamePopupIt() {
        return supNamePopupIt;
    }

    public void onSupNamePopUpGoClick(ActionEvent actionEvent) {
        System.out.println("Start onSupNamePopUpGoClick");
        String enteredSupName = null;
        try {
            if (supNamePopupIt.getValue() != null) {
                enteredSupName = supNamePopupIt.getValue().toString();
                System.out.println("supNamePopupIt.getValue(): " + enteredSupName);
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("SitesVO1Iterator");
                ViewObjectImpl suppNameVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = suppNameVO.getViewCriteria("SitesVOCriteria");
                suppNameVO.applyViewCriteria(vc);
                suppNameVO.setNamedWhereClauseParam("bindVendorName", enteredSupName);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(suppNameVO.getQuery());
                suppNameVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(supDetailsTable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onSupNamePopUpGoClick");
    }

    public void setSupDetailsTable(RichTable supDetailsTable) {
        this.supDetailsTable = supDetailsTable;
    }

    public RichTable getSupDetailsTable() {
        return supDetailsTable;
    }

    public void setSiteNamePopupIt(RichInputText siteNamePopupIt) {
        this.siteNamePopupIt = siteNamePopupIt;
    }

    public RichInputText getSiteNamePopupIt() {
        return siteNamePopupIt;
    }

    public void onSiteNamePopUpGoClick(ActionEvent actionEvent) {
        System.out.println("Start onSiteNamePopUpGoClick");
        String enteredSiteName = null;
        String enteredSupplierName = null;
        String searchType = null;
        try {
            if (siteNamePopupIt.getValue() != null) {
                enteredSiteName = siteNamePopupIt.getValue().toString();
                if (supNameIt.getValue() != null) {
                    enteredSupplierName = supNameIt.getValue().toString();
                    System.out.println("entered supplier name" + enteredSupplierName);

                }
                if (siteLOVSoc.getValue() != null) {
                    searchType = siteLOVSoc.getValue().toString();
                    System.out.println("siteLOVSoc.getValue(): " + searchType);
                }
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("SitesDetailsVO1Iterator");
                ViewObjectImpl siteNameVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = null;

                System.out.println("siteNamePopupIt.getValue(): " + enteredSiteName);
                if (searchType != null && searchType.equals("SiteId")) {
                    vc = siteNameVO.getViewCriteria("SitesDetailsVOCriteria1");
                    siteNameVO.applyViewCriteria(vc);
                    siteNameVO.setNamedWhereClauseParam("bindSiteId", enteredSiteName);
                    siteNameVO.setNamedWhereClauseParam("bindSupplierName", enteredSupplierName);
                }

                /*start 2nd May:::  Inclusion of Bank account in the vendor site search both on serach filter and the search results*/
                else if ((searchType != null && searchType.equals("BankAccountNo")) &&
                         siteNamePopupIt.getValue() != null) {
                    vc = siteNameVO.getViewCriteria("SitesDetailsVOCriteria_byBankAccountNo");
                    siteNameVO.applyViewCriteria(vc);

                    siteNameVO.setNamedWhereClauseParam("bindBankAccountNo", siteNamePopupIt.getValue().toString());
                    siteNameVO.setNamedWhereClauseParam("bindSupplierName",
                                                        enteredSupplierName); //TODO : check if supplier's name is to be inculded in the criteria

                }
                /*end 2nd May:::  Inclusion of Bank account in the vendor site search both on serach filter and the search results*/


                else if ((searchType != null && searchType.equals("ABNNumber")) && siteNamePopupIt.getValue() != null) {
                    //Search by ABN Number    -27th July 2017
                    vc = siteNameVO.getViewCriteria("SitesDetailsVOCriteria_ABNNumber");
                    siteNameVO.applyViewCriteria(vc);

                    siteNameVO.setNamedWhereClauseParam("bindABNNumber", siteNamePopupIt.getValue().toString());
                    siteNameVO.setNamedWhereClauseParam("bindSupplierName", enteredSupplierName);

                }


                else if ((searchType != null && searchType.equals("SupplierNumber")) &&
                         siteNamePopupIt.getValue() != null) {
                    //Search by supplier number  -27th July 2017
                    vc = siteNameVO.getViewCriteria("SitesDetailsVOCriteria_bySupplierNumber");
                    siteNameVO.applyViewCriteria(vc);

                    siteNameVO.setNamedWhereClauseParam("bindSupplierNumber", siteNamePopupIt.getValue().toString());
                    siteNameVO.setNamedWhereClauseParam("bindSupplierName", enteredSupplierName);

                }


                else {
                    vc = siteNameVO.getViewCriteria("SitesDetailsVOCriteria");
                    siteNameVO.applyViewCriteria(vc);
                    siteNameVO.setNamedWhereClauseParam("bindSiteName", enteredSiteName);
                    siteNameVO.setNamedWhereClauseParam("bindSupplierName", enteredSupplierName);
                }


                //System.out.println(siteNameVO.getQuery());
                siteNameVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(siteDetailsTable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onSiteNamePopUpGoClick");

    }

    public void setSiteDetailsTable(RichTable siteDetailsTable) {
        this.siteDetailsTable = siteDetailsTable;
    }

    public RichTable getSiteDetailsTable() {
        return siteDetailsTable;
    }

    public void setPoNumPopupIt(RichInputText poNumPopupIt) {
        this.poNumPopupIt = poNumPopupIt;
    }

    public RichInputText getPoNumPopupIt() {
        return poNumPopupIt;
    }

    public void onPONumPopupGoClick(ActionEvent actionEvent) {
        System.out.println("Start onPONumPopupGoClick");
        String enteredPONum = null;
        try {
            if (siteIdIt.getValue() != null) {
                System.out.println("Inside Both Null condition ");
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                ViewObjectImpl poNOVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria2");
                poNOVO.applyViewCriteria(vc);
                poNOVO.setNamedWhereClauseParam("bindPONum",
                                                poNumPopupIt.getValue() == null ? "" :
                                                poNumPopupIt.getValue()
                                                                                                                .toString()
                                                                                                                .trim());
                poNOVO.setNamedWhereClauseParam("bindSiteId", siteIdIt.getValue()
                                                                      .toString()
                                                                      .trim());
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(poNOVO.getQuery());
                poNOVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
            } else {

                enteredPONum = poNumPopupIt.getValue() == null ? "" : poNumPopupIt.getValue()
                                                                                  .toString()
                                                                                  .trim();
                System.out.println("poNumIt.getValue(): " + enteredPONum);
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                ViewObjectImpl poNOVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria");
                poNOVO.applyViewCriteria(vc);
                poNOVO.setNamedWhereClauseParam("bindPONum", enteredPONum);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(poNOVO.getQuery());
                poNOVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onPONumPopupGoClick");
    }

    public void setPoDetailsTable(RichTable poDetailsTable) {
        this.poDetailsTable = poDetailsTable;
    }

    public RichTable getPoDetailsTable() {
        return poDetailsTable;
    }


    /*---------Form Email Notification----------*/


    public void initEmailParams() {
        String reasonTypeId = null;
        if (resolveExpression("#{bindings.InvalidReasonTypeId.attributeValue}") != null) {
            reasonTypeId =
                "" +
                ((java.math.BigDecimal) resolveExpression("#{bindings.InvalidReasonTypeId.attributeValue}")).intValue();
        }

        System.out.println("initEmailParams>>reasonTypeId>>" + reasonTypeId);

        DCBindingContainer dcBindingContainer =
            (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("GetEmailDetailsVO1Iterator");
        ViewObjectImpl vo = (ViewObjectImpl) dcIteratorBinding.getViewObject();
        ViewCriteria vc = vo.getViewCriteria("GetEmailDetailsVOCriteria");
        vo.applyViewCriteria(vc);
        vo.setNamedWhereClauseParam("bindReasonTypeId", reasonTypeId);
        vo.executeQuery();

        String emailBodyString = null;
        StringBuilder emailBody = new StringBuilder();
        //String val = "Hi this is www.google.com http://yahoo.com aksdjgh";

        while (vo.hasNext()) {
            Row row = vo.next();
            //           String emailTo = (String)row.getAttribute("EmailTo");
            //           String emailCC = (String)row.getAttribute("Cc");
            this.setEmailTo((String) row.getAttribute("EmailTo"));
            this.setEmailCc((String) row.getAttribute("Cc"));
            this.setEmailBcc((String) row.getAttribute("Bcc"));
            String emailSubject = (String) row.getAttribute("Subject");

            this.setEmailSubj(modifyEmail(emailSubject));

            AdfFacesContext.getCurrentInstance()
                           .getPageFlowScope()
                           .put("emailFrom", row.getAttribute("EmailFrom"));
            //                emailBodyString = returnUrlModifier((String)row.getAttribute("Body"));
            if (row.getAttribute("Body") != null)
                emailBodyString = (String) row.getAttribute("Body");
            String modifiedemailBodyString = modifyEmail(emailBodyString);
            emailBody.append(modifiedemailBodyString);
            System.out.println("-----------emailBody: " + emailBody);
            this.setEmailBody(modifiedemailBodyString);

            /*System.out.println("emailTo:: "+emailTo);
            System.out.println("emailCc:: "+emailCc);
            System.out.println("emailBCc:: "+emailBcc);
            System.out.println("emailSubj:: "+emailSubj);
            System.out.println("emailFrom:: "+ AdfFacesContext.getCurrentInstance().getPageFlowScope().get("emailFrom"));
            System.out.println("emailBody:: "+emailBody);*/
        }

    }

    private String returnUrlModifier(String body) {
        String[] parts = body.split(" ");
        String finalString = "";
        CharSequence s1 = "https://";
        CharSequence s2 = "www";
        CharSequence s3 = "http://";
        for (String item : parts) {

            if (item.contains(s1) || item.contains(s2) || item.contains(s3)) {
                //System.out.println(item);
                item = "<a href='" + item + "'>" + item + "</a>";

                //System.out.println("FormattecL: "+item);
            }

            finalString = finalString.concat(item + " ");
        }
        System.out.println("-----FinalString: " + finalString);
        return finalString;
    }

    public String sendMailAction() {
        //System.out.println("***** Sending mails which are pending on mailing queue *****");
        try {
            String mailFrom = null;
            if (AdfFacesContext.getCurrentInstance()
                               .getPageFlowScope()
                               .get("emailFrom") != null) {
                mailFrom = (String) AdfFacesContext.getCurrentInstance()
                                                   .getPageFlowScope()
                                                   .get("emailFrom");
            }

            String fileUploadPath = null;
            String imageFileUploadPath = null;
            /* if(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("fileUploadPath") != null){
                    fileUploadPath = (String)AdfFacesContext.getCurrentInstance().getPageFlowScope().get("fileUploadPath");
                } */

            // Get the invoice attachment

            //String docId = (String)ADFContext.getCurrent().getPageFlowScope().get("Docid_value");
            String docId = null;
            if (resolveExpression("#{bindings.attr1.inputValue}") != null)
                docId = resolveExpression("#{bindings.attr1.inputValue}").toString();
            System.out.println("doc id in sendMailAction ::: " + docId);
            //docId = "9.IPM_039606";
            FileDescriptor fd = getFileFromImaging(docId);
            if (fd != null) {

                System.out.println(fd.getFilename());
                System.out.println(fd.getBytedata().length);
                try {
                    new FileOutputStream(resolveExpression("#{ApOperationBean.propertyLoader.properties['FILE_UPLOAD_SERVER_PATH']}")
                                         .toString() + fd.getFilename()).write(fd.getBytedata());
                    fileUploadPath =
                        resolveExpression("#{ApOperationBean.propertyLoader.properties['FILE_UPLOAD_SERVER_PATH']}")
                        .toString() + fd.getFilename();
                    System.out.println("DONE");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (mailFrom == null ||
                (mailFrom != null && mailFrom.trim().equals(""))) {
                //mailFrom = "apexceptions@qantas.com.au"; //TO-DO : Change this from hardcoded to prop driven

                mailFrom =
resolveExpression("#{ApOperationBean.propertyLoader.properties['NOTIFICATION_EMAIL_ID']}").toString();

            }

            InitialContext ic = new InitialContext();
            Session session = (Session) ic.lookup("smtp/mailSession");
            //session.setDebug(false);
            MimeMessage msg = new MimeMessage(session);
            try {
                msg.setFrom(InternetAddress.parse(mailFrom, false)[0]);
                if (emailTo != null) {
                    try {
                        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo, false));
                    } catch (Exception parseEx) {

                    }

                }
                if (emailCc != null) {
                    try {
                        msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(emailCc, false));
                    } catch (Exception parseEx) {

                    }

                }

                if (emailBcc != null) {
                    try {
                        msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(emailBcc, false));
                    } catch (Exception parseEx) {

                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                /* experimental code start */
                String cid = ContentIdGenerator.getContentId();
                /* experimental code end */

                String subject = emailSubj;
                String body = emailBody;
                String modifiedBody = setEmailLink(body);
                modifiedBody = modifiedBody + "<br>" + "<img src=\"cid:" + cid + "\" />";
                msg.setSubject(subject);
                msg.setSentDate(new java.util.Date());
                // Content is stored in a MIME multi-part message
                // create and fill the first message part
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setContent(modifiedBody, "text/html; charset=utf-8");

                // create the second message part
                MimeBodyPart mbp2 = new MimeBodyPart();
                DataSource source = new FileDataSource(fileUploadPath);
                mbp2.setDataHandler(new DataHandler(source));
                System.out.println("FileName is-" +
                                   fileUploadPath.substring(fileUploadPath.lastIndexOf("/") + 1,
                                                            fileUploadPath.length()));
                mbp2.setFileName(fileUploadPath.substring(fileUploadPath.lastIndexOf("/") + 1,
                                                          fileUploadPath.length()));

                //create the image body part
                MimeBodyPart imagePart = new MimeBodyPart();
                imageFileUploadPath =
                    resolveExpression("#{ApOperationBean.propertyLoader.properties['FILE_UPLOAD_SERVER_PATH']}")
                    .toString() + "jetstarlogo.png";
                imagePart.attachFile(imageFileUploadPath);
                imagePart.setContentID("<" + cid + ">");
                imagePart.setDisposition(MimeBodyPart.INLINE);

                // create the Multipart and add its parts to it
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                mp.addBodyPart(mbp2);
                mp.addBodyPart(imagePart);

                //msg.setContent(modifiedBody, "text/html; charset=utf-8");
                msg.setContent(mp);
                Transport.send(msg);
                emailPopup.hide();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return "";
    }

    private Object resolvElDC(String data) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, "#{data." + data + ".dataProvider}", Object.class);
        return valueExp.getValue(elContext);
    }


    public void setEmailTo(String emailTo) {
        String oldEmailTo = this.emailTo;
        this.emailTo = emailTo;
        propertyChangeSupport.firePropertyChange("emailTo", oldEmailTo, emailTo);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailCc(String emailCc) {
        String oldEmailCc = this.emailCc;
        this.emailCc = emailCc;
        propertyChangeSupport.firePropertyChange("emailCc", oldEmailCc, emailCc);
    }

    public String getEmailCc() {
        return emailCc;
    }

    public void setEmailSubj(String emailSubj) {
        String oldEmailSubj = this.emailSubj;
        this.emailSubj = emailSubj;
        propertyChangeSupport.firePropertyChange("emailSubj", oldEmailSubj, emailSubj);
    }

    public String getEmailSubj() {
        return emailSubj;
    }

    public void setEmailBody(String emailBody) {
        String oldEmailBody = this.emailBody;
        this.emailBody = emailBody;
        propertyChangeSupport.firePropertyChange("emailBody", oldEmailBody, emailBody);
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setMailData(String mailData) {
        String oldMailData = this.mailData;
        this.mailData = mailData;
        propertyChangeSupport.firePropertyChange("mailData", oldMailData, mailData);
    }

    public String getMailData() {
        return mailData;
    }

    public void setEmailFrom(String emailFrom) {
        String oldEmailFrom = this.emailFrom;
        this.emailFrom = emailFrom;
        propertyChangeSupport.firePropertyChange("emailFrom", oldEmailFrom, emailFrom);
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void onNotifyClick(ActionEvent actionEvent) {
        System.out.println("Start onNotifyClick");
        try {
            initEmailParams();
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            emailPopup.show(hints);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onNotifyClick");
    }

    public void setEmailPopup(RichPopup emailPopup) {
        this.emailPopup = emailPopup;
    }

    public RichPopup getEmailPopup() {
        return emailPopup;
    }
    /*--------end of email--------*/

    public void onRemoveLineRow(ActionEvent actionEvent) {
        System.out.println("Start onRemoveLineRow");
        /* *********************** */
        boolean flag = false;
        ViewObject lineVo =
            ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry())
            .findIteratorBinding("LineItemDetailsEOView1Iterator").getViewObject();
        RowSetIterator rsiLineItem = lineVo.createRowSetIterator(null);
        while (rsiLineItem.hasNext()) {

            //System.out.println("inside while ...........");
            Row lineItemRow = rsiLineItem.next();
            /*System.out.println("is slected value ::"+ lineItemRow.getAttribute("isSelected"));
            System.out.println("is line number::"+ lineItemRow.getAttribute("LineNumber")); */


            if (lineItemRow.getAttribute("isSelected") != null && lineItemRow.getAttribute("isSelected").equals("Y")) {
                flag = true;
            }
        }
        rsiLineItem.closeRowSetIterator();


        if (!flag) {
            String validationErrorMessage = "PLease select checkbox before deleting the row";
            RichPopup.PopupHints hints1 = new RichPopup.PopupHints();
            validationErrorPopup.show(hints1);
            this.validationErrorMessage.setValue(validationErrorMessage);
            return;
        }

        /* ********************* */
        if (flag) {
            DecimalFormat df = new DecimalFormat("#0.00");
            String lineNumber = null;
            RowSetIterator lineItemRSIter = null;
            try {
                /*added by Sourav linetotal & taxtotal*/
                /* RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
                Iterator rowKeySetIt = rowKeySet.iterator();
                DCIteratorBinding lineItemIter =
                    ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");
                lineItemRSIter = lineItemIter.getRowSetIterator();
                double sumLineTotalAmnt = 0;
                double sumTaxTotalAmnt = 0;
                if (lineTotalSum.getValue() != null) {
                    sumLineTotalAmnt =
                            Double.parseDouble(lineTotalSum.getValue().toString());
                }
                if (taxAmountSum.getValue() != null) {
                    sumTaxTotalAmnt =
                            Double.parseDouble(taxAmountSum.getValue().toString());
                }
                while (rowKeySetIt.hasNext()) {
                    Key key = (Key)((List)rowKeySetIt.next()).get(0);
                    Row currentRow = lineItemRSIter.getRow(key);
                    if (currentRow != null) {
                        System.out.println("----- typedInPONumber ----- " +
                                           currentRow.getAttribute("LineTotalAmount"));
                        sumLineTotalAmnt =
                                currentRow.getAttribute("LineTotalAmount") ==
                                null ? sumLineTotalAmnt :
                                (sumLineTotalAmnt - Double.parseDouble(currentRow.getAttribute("LineTotalAmount").toString().trim()));
                        sumTaxTotalAmnt =
                                currentRow.getAttribute("Attr1") == null ?
                                sumTaxTotalAmnt :
                                (sumTaxTotalAmnt - Double.parseDouble(currentRow.getAttribute("Attr1").toString().trim()));
                    }
                }
                lineTotalSum.setValue(df.format(sumLineTotalAmnt));
                taxAmountSum.setValue(df.format(sumTaxTotalAmnt));*/
                /*added by Sourav linetotal & taxtotal*/
                //            RowKeySet selectedEmps = lineDetailsTable.getSelectedRowKeys();
                //            Iterator selectedter = selectedEmps.iterator();
                //
                //            while (selectedter.hasNext()) {
                //                String rowKey = selectedter.next().toString();
                //                System.out.println("------------rowKey: "+rowKey);
                //                BindingContext bctx = BindingContext.getCurrent();
                //                BindingContainer bindings = bctx.getCurrentBindingsEntry();
                //                OperationBinding operationBinding =  bindings.getOperationBinding("removeRowWithKey");
                //                operationBinding.getParamsMap().put("rowKey",rowKey);
                //                operationBinding.execute();
                //                dbCommit();
                //            }
                //            System.out.println("RowkeySet: "+resolveExpression("#{bindings.LineItemDetailsEOView11.collectionModel.selectedRow}"));
                //            BindingContext bctx = BindingContext.getCurrent();
                //            BindingContainer bindings = bctx.getCurrentBindingsEntry();
                //            OperationBinding operationBinding =  bindings.getOperationBinding("removeRowWithKey");
                //            operationBinding.getParamsMap().put("rowKey",resolveExpression("#{bindings.LineItemDetailsEOView11.collectionModel.selectedRow}").toString());
                //            operationBinding.execute();
                //            dbCommit();


                /*Object _selectedRowData = lineDetailsTable.getSelectedRowData();
             //cast to JUCtrlHierNodeBinding, which is the ADF object
             //that represents a row
             JUCtrlHierNodeBinding _nodeBinding = (JUCtrlHierNodeBinding) _selectedRowData;
             //get the row key from the node binding and set it
             //as the current row in the iterator
             Key _rwKey = _nodeBinding.getRowKey();
             dcItteratorBindings.setCurrentRowWithKey(_rwKey.toStringFormat(true));


            ViewObject voTableData = dcItteratorBindings.getViewObject();
            Row rowSelected = voTableData.getCurrentRow();
            System.out.println("Line Id: "+rowSelected.getAttribute("LineNumber"));

            String lineNumber = AdfFacesContext.getCurrentInstance().getViewScope().get("lineNumber")+"";
            System.out.println("lineNumber: "+lineNumber);
            */

                /*DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcItteratorBindings = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
            RowKeySet rksSelectedRows = lineDetailsTable.getSelectedRowKeys();

            Iterator itrSelectedRows = rksSelectedRows.iterator();

            RowSetIterator rsiSelectedRows =  dcItteratorBindings.getRowSetIterator();
            while (itrSelectedRows.hasNext()) {
                Key key = (Key)((List)itrSelectedRows.next()).get(0);

                Row myRow = rsiSelectedRows.getRow(key);
                System.out.println("Line Id: "+myRow.getAttribute("LineNumber"));
                lineNumber = myRow.getAttribute("LineNumber").toString();
            }*/

                DCBindingContainer bindings =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcItteratorBindings = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
                lineNumber = AdfFacesContext.getCurrentInstance()
                                            .getViewScope()
                                            .get("lineNumber") + "";
                //System.out.println("Line Id: " + lineNumber);


                OperationBinding operationBinding = bindings.getOperationBinding("removeLineItemRow");
                operationBinding.getParamsMap().put("invoiceId", getInvoiceId());
                //            operationBinding.getParamsMap().put("lineId",rowSelected.getAttribute("LineNumber")+"");
                //            operationBinding.getParamsMap().put("lineId",lineNumber);
                operationBinding.execute();

                //            OperationBinding comt = bindings.getOperationBinding("Commit");
                //            comt.execute();
                parentCheckBox.resetValue();
                subCheckBox.resetValue();
                AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);


                //            AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (lineItemRSIter != null) {
                    try {
                        lineItemRSIter.closeRowSetIterator();
                    } catch (Exception ex) {
                        ex.printStackTrace();

                    }
                }
            }
            System.out.println("End onRemoveLineRow");
        }
    }

    private void dbCommit() {
        System.out.println("Start dbCommit");
        try {
            BindingContext bctx = BindingContext.getCurrent();
            BindingContainer bindings = bctx.getCurrentBindingsEntry();
            OperationBinding operationBinding = bindings.getOperationBinding("Commit");
            operationBinding.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End dbCommit");
    }

    public void setLineDetailsTable(RichTable lineDetailsTable) {
        this.lineDetailsTable = lineDetailsTable;
    }

    public RichTable getLineDetailsTable() {
        return lineDetailsTable;
    }

    public void onAddLineItemRow(ActionEvent actionEvent) {
        System.out.println("Start onAddLineItemRow");
        AdfFacesContext.getCurrentInstance()
                       .getPageFlowScope()
                       .put("TaxRateCodePS", null);
        try {
tempQuantity = null;
            tempUnitPrice = null;
            tempTaxRateCode = null;
            System.out.println("---------getInvoiceId(): " + getInvoiceId());
            BindingContext bctx = BindingContext.getCurrent();
            BindingContainer bindings = bctx.getCurrentBindingsEntry();
            OperationBinding operationBinding = bindings.getOperationBinding("addLineItemRow");

            operationBinding.getParamsMap().put("invoiceId", getInvoiceId());
            operationBinding.execute();
            DCBindingContainer bindings2 = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

            ViewObject lineVo = bindings2.findIteratorBinding("LineItemDetailsEOView1Iterator").getViewObject();
            RowSetIterator rsi2 = lineVo.createRowSetIterator(null);
            DecimalFormat df = new DecimalFormat("#0.00");
            double lineTotal = 0;
            double taxTotal = 0;
            System.out.println("rsi2 :::: " + rsi2.getRowCount() + " next ?? " + rsi2.hasNext());
            while (rsi2.hasNext()) {
                //System.out.println("inside while ...........");
                Row newRow1 = rsi2.next();
                //System.out.println("Line total ::: "+ newRow1.getAttribute("LineTotalAmount"));
                if (newRow1.getAttribute("LineTotalAmount") != null) {
                    lineTotal = lineTotal + Double.parseDouble(newRow1.getAttribute("LineTotalAmount")
                                                                      .toString()
                                                                      .trim());
                }
                if (newRow1.getAttribute("TaxAmountLineitem") != null) {
                    taxTotal = taxTotal + Double.parseDouble(newRow1.getAttribute("TaxAmountLineitem")
                                                                    .toString()
                                                                    .trim());
                }

            }
            rsi2.closeRowSetIterator();
            System.out.println("lineTotal ::: " + lineTotal + " taxTotal ::: " + taxTotal);
            //            lineTotalSum.setValue(df.format(lineTotal));
            //            taxAmountSum.setValue(df.format(taxTotal));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(lineTotalSum);
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(taxAmountSum);
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);


            //AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);
            AdfFacesContext.getCurrentInstance().addPartialTarget(lineTableOuterPgl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onAddLineItemRow");
    }


    public void setReasonSOC(RichSelectOneChoice reasonSOC) {
        this.reasonSOC = reasonSOC;
    }

    public RichSelectOneChoice getReasonSOC() {
        return reasonSOC;
    }

    public void setStatusSOC(RichSelectOneChoice statusSOC) {
        this.statusSOC = statusSOC;
    }

    public RichSelectOneChoice getStatusSOC() {
        return statusSOC;
    }

    public void setTypeSOC(RichSelectOneChoice typeSOC) {
        this.typeSOC = typeSOC;
    }

    public RichSelectOneChoice getTypeSOC() {
        return typeSOC;
    }

    public void setExpPsl1(RichPanelFormLayout expPsl1) {
        this.expPsl1 = expPsl1;
    }

    public RichPanelFormLayout getExpPsl1() {
        return expPsl1;
    }

    public void setExpPfl1(RichPanelFormLayout expPfl1) {
        this.expPfl1 = expPfl1;
    }

    public RichPanelFormLayout getExpPfl1() {
        return expPfl1;
    }

    public static void setExpressionValue(String expression, Object newValue) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);

        //Check that the input newValue can be cast to the property type
        //expected by the managed bean.
        //If the managed Bean expects a primitive we rely on Auto-Unboxing
        //I could do a more comprehensive check and conversion from the object
        //to the equivilent primitive but life is too short
        Class bindClass = valueExp.getType(elContext);
        if (bindClass.isPrimitive() || bindClass.isInstance(newValue)) {
            valueExp.setValue(elContext, newValue);
        }
    }

    public static void setExpressionResetValue(String expression, Object newValue) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Application app = ctx.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = ctx.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
        valueExp.setValue(elContext, newValue);
    }

    public void setCommentPopup(RichPopup commentPopup) {
        this.commentPopup = commentPopup;
    }

    public RichPopup getCommentPopup() {
        return commentPopup;
    }

    public void onCommentsClick(ActionEvent actionEvent) {
        System.out.println("Start onCommentsClick");
        String commentsVal = null;
        try {
            if (commentsIt.getValue() != null)
                commentsVal = commentsIt.getValue().toString();
            //System.out.println("commentsIt: "+commentsIt);
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            commentsPopupIt.setValue(commentsVal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(commentsPopupIt);
            commentPopup.show(hints);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onCommentsClick");
    }

    public void onCertCommentsClick(ActionEvent actionEvent) {
        System.out.println("Start onCertCommentsClick");
        String commentsVal = null;
        try {
            if (certCommentsIt.getValue() != null)
                commentsVal = certCommentsIt.getValue().toString();
            //System.out.println("certCommentsIt: "+certCommentsIt);
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            certCommentsPopupIt.setValue(commentsVal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCommentsPopupIt);
            certCommentsPopup.show(hints);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onCertCommentsClick");
    }

    public void setCommentsIt(RichInputText commentsIt) {
        this.commentsIt = commentsIt;
    }

    public RichInputText getCommentsIt() {
        return commentsIt;
    }

    public void setCommentsPopupIt(RichInputText commentsPopupIt) {
        this.commentsPopupIt = commentsPopupIt;
    }

    public RichInputText getCommentsPopupIt() {
        return commentsPopupIt;
    }

    public void onCommentsPopupOKClick(ActionEvent actionEvent) {
        System.out.println("Start onCommentsPopupOKClick");
        String commentsVal = null;
        try {
            if (commentsPopupIt.getValue() != null)
                commentsVal = commentsPopupIt.getValue().toString();
            //System.out.println("commentsPopupIt: "+commentsPopupIt);
            commentsIt.setValue(commentsVal);
            commentPopup.hide();
            AdfFacesContext.getCurrentInstance().addPartialTarget(commentsIt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onCommentsPopupOKClick");
    }

    public void setCertCommentsPopup(RichPopup certCommentsPopup) {
        this.certCommentsPopup = certCommentsPopup;
    }

    public RichPopup getCertCommentsPopup() {
        return certCommentsPopup;
    }

    public void setCertCommentsPopupIt(RichInputText certCommentsPopupIt) {
        this.certCommentsPopupIt = certCommentsPopupIt;
    }

    public RichInputText getCertCommentsPopupIt() {
        return certCommentsPopupIt;
    }

    public void onCertCommentsPopupOKClick(ActionEvent actionEvent) {
        System.out.println("Start onCertCommentsPopupOKClick");
        String commentsVal = null;
        try {
            if (certCommentsPopupIt.getValue() != null)
                commentsVal = certCommentsPopupIt.getValue().toString();
            //System.out.println("certCommentsPopupIt: "+certCommentsPopupIt);
            certCommentsIt.setValue(commentsVal);
            certCommentsPopup.hide();
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCommentsIt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onCertCommentsPopupOKClick");
    }

    public void setCertCommentsIt(RichInputText certCommentsIt) {
        this.certCommentsIt = certCommentsIt;
    }

    public RichInputText getCertCommentsIt() {
        return certCommentsIt;
    }

    public void onMatchClick(ActionEvent actionEvent) {
        System.out.println("Start onMatchClick");
        RowSetIterator rsi = null;
        //RowSetIterator rsi1=null;
        RowSetIterator rsI = null;
        RowSetIterator rsi2 = null;
        RowSetIterator rowIt = null;
        try {
            //            setExpressionResetValue("#{bindings.ReasonTypeVO1.inputValue}",new oracle.jbo.domain.Number(Integer.parseInt("6")));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(reasonSOC);

            ObjectFactory factory = new ObjectFactory();
            UpdatePttBindingQSService service = new UpdatePttBindingQSService();
            InputParameters inputParams = new InputParameters();
            APPSINVOICEHEADERREC header = new APPSINVOICEHEADERREC();

            /* Get the header details values */
            DCBindingContainer bindings = getBindings();
            DCIteratorBinding dcIteratorBindings = bindings.findIteratorBinding("HeaderDetailsEOView1Iterator");
            ViewObject headerVO = dcIteratorBindings.getViewObject();
            Row headerRow = headerVO.getCurrentRow();
            if (headerRow != null) {
                String documentType =
                    headerRow.getAttribute("DocumentType") != null ? headerRow.getAttribute("DocumentType").toString() :
                    null;
                System.out.println("DocumentType ::: " + documentType);
                String invoiceType =
                    headerRow.getAttribute("InvoiceType") != null ? headerRow.getAttribute("InvoiceType").toString() :
                    null;
                System.out.println("InvoiceType ::: " + invoiceType);
                BigDecimal orgId = null;
                String invoiceNumber =
                    headerRow.getAttribute("InvoiceNumber") != null ?
                    headerRow.getAttribute("InvoiceNumber").toString() : null;
                System.out.println("InvoiceNumber ::: " + invoiceNumber);
                String invoiceDate = ((oracle.jbo.domain.Date) headerRow.getAttribute("InvoiceDate")).toString();
                System.out.println("InvoiceDate ::: " + invoiceDate);
                BigDecimal supplierId = null;
                String supplierNumber =
                    headerRow.getAttribute("SupplierNumber") != null ?
                    headerRow.getAttribute("SupplierNumber").toString() : null;
                System.out.println("SupplierNumber ::: " + supplierNumber);
                String supplierName =
                    headerRow.getAttribute("SupplierName") != null ? headerRow.getAttribute("SupplierName").toString() :
                    null;
                System.out.println("SupplierName ::: " + supplierName);
                String siteId =
                    headerRow.getAttribute("SiteId") != null ? headerRow.getAttribute("SiteId").toString() : null;
                System.out.println("SiteId ::: " + siteId);

                //Populate SupplierId and orgId

                ApplicationModule am = null;
                try {
                    String amDef = "model.EbsAM";
                    String config = "EbsAMLocal";
                    am = Configuration.createRootApplicationModule(amDef, config);
                    EbsAMImpl amImpl = (EbsAMImpl) am;
                    ViewObjectImpl suppNameVO = amImpl.getSitesVO1();
                    ViewCriteria viewCrit = suppNameVO.getViewCriteria("SitesVOCriteriaSupNameSiteID");
                    suppNameVO.applyViewCriteria(viewCrit);
                    suppNameVO.setNamedWhereClauseParam("bindVendorName", supplierName);
                    suppNameVO.setNamedWhereClauseParam("bvSiteID", siteId);
                    suppNameVO.executeQuery();
                    if (suppNameVO.getEstimatedRowCount() > 0) {
                        System.out.println("--- Match found for Supplier Name : " + suppNameVO.getEstimatedRowCount() +
                                           " records.");
                        rowIt = suppNameVO.createRowSetIterator(null);
                        while (rowIt.hasNext()) {
                            Row rowData = rowIt.next();
                            try {
                                System.out.println("--- Matched Supplier Number : " +
                                                   rowData.getAttribute("VendorNumber"));
                                supplierId =
                                    rowData.getAttribute("VendorId") == null ? null :
                                    (BigDecimal) rowData.getAttribute("VendorId");
                                orgId =
                                    rowData.getAttribute("OrgId") == null ? null :
                                    (BigDecimal) rowData.getAttribute("OrgId");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    System.out.println("supplierId ::: " + supplierId);
                    System.out.println("orgId ::: " + orgId);
                    String siteName =
                        headerRow.getAttribute("SiteName") != null ? headerRow.getAttribute("SiteName").toString() :
                        null;
                    System.out.println("SiteName ::: " + siteName);
                    String poNumber =
                        headerRow.getAttribute("PoNumber") != null ? headerRow.getAttribute("PoNumber").toString() :
                        null;
                    System.out.println("poNumber ::: " + poNumber);
                    String taxRegNumber =
                        headerRow.getAttribute("TaxRegNumber") != null ?
                        headerRow.getAttribute("TaxRegNumber").toString() : null;
                    System.out.println("taxRegNumber ::: " + taxRegNumber);
                    BigDecimal taxAmount =
                        headerRow.getAttribute("TaxAmount") != null ?
                        ((Number) headerRow.getAttribute("TaxAmount")).bigDecimalValue() : null;
                    System.out.println("taxAmount ::: " + taxAmount);
                    String witholdingTax = "0.00";
                    BigDecimal invoiceTotAmount =
                        headerRow.getAttribute("InvoiceTotAmount") != null ?
                        ((Number) headerRow.getAttribute("InvoiceTotAmount")).bigDecimalValue() : null;
                    System.out.println("invoiceTotAmount ::: " + invoiceTotAmount);
                    String currencyCode =
                        headerRow.getAttribute("CurrencyCode") != null ?
                        headerRow.getAttribute("CurrencyCode").toString() : null;
                    System.out.println("currencyCode ::: " + currencyCode);
                    String invalidCode = "0";
                    //String certifierName = (String)headerRow.getAttribute("CertifierName");
                    //String certifierEmailAdd = (String)headerRow.getAttribute("CertifierEmailAdd");
                    //String attr2 = (String)headerRow.getAttribute("Attr2");
                    //String attr1 = (String)headerRow.getAttribute("Attr1");
                    //String employeeNumber = (String)headerRow.getAttribute("EmployeeNumber");


                    GregorianCalendar cal = new GregorianCalendar();
                    cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(invoiceDate));

                    // set the header parameters
                    header.setDOCUMENTTYPE(factory.createAPPSINVOICEHEADERRECDOCUMENTTYPE(documentType));
                    header.setINVOICETYPE(factory.createAPPSINVOICEHEADERRECINVOICETYPE(invoiceType));
                    header.setORGID(factory.createAPPSINVOICEHEADERRECORGID(orgId));
                    header.setINVOICENUMBER(factory.createAPPSINVOICEHEADERRECINVOICENUMBER(invoiceNumber));
                    header.setINVOICEDATE(factory.createAPPSINVOICEHEADERRECINVOICEDATE(DatatypeFactory.newInstance()
                                                                                        .newXMLGregorianCalendar(cal)));
                    header.setSUPPLIERID(factory.createAPPSINVOICEHEADERRECSUPPLIERID(supplierId));
                    //header.setSUPPLIERNAME(factory.createAPPSINVOICEHEADERRECSUPPLIERNAME(supplierName));
                    //header.setSUPPLIERNUMBER(factory.createAPPSINVOICEHEADERRECSUPPLIERNUMBER(supplierNumber));
                    header.setSITEID(factory.createAPPSINVOICEHEADERRECSITEID(siteId != null ? new BigDecimal(siteId) :
                                                                              null));
                    //header.setSITENAME(factory.createAPPSINVOICEHEADERRECSITENAME(siteName));
                    header.setPONUMBER(factory.createAPPSINVOICEHEADERRECPONUMBER(poNumber));
                    //header.setTAXREGISTRATIONNUMBER(factory.createAPPSINVOICEHEADERRECTAXREGISTRATIONNUMBER(taxRegNumber));
                    //header.setHEADERTAXTOTAL(factory.createAPPSINVOICEHEADERRECHEADERTAXTOTAL(taxAmount));
                    //header.setWITHHOLDINGTAX(factory.createAPPSINVOICEHEADERRECWITHHOLDINGTAX(witholdingTax));
                    //header.setINVOICETOTALAMOUNT(factory.createAPPSINVOICEHEADERRECINVOICETOTALAMOUNT(invoiceTotAmount));
                    header.setCURRENCYCODE(factory.createAPPSINVOICEHEADERRECCURRENCYCODE(currencyCode));
                    //header.setCERTIFIERNAME(factory.createAPPSINVOICEHEADERRECCERTIFIERNAME(null));
                    //header.setCERTIFIEREMPLOYEENO(factory.createAPPSINVOICEHEADERRECCERTIFIEREMPLOYEENO(null));
                    //header.setCERTIFIEREMAILADD(factory.createAPPSINVOICEHEADERRECCERTIFIEREMAILADD(null));

                    //header.setINVALIDREASON(factory.createAPPSINVOICEHEADERRECINVALIDREASON(null));
                    //header.setINVALIDREASON(factory.createAPPSINVOICEHEADERRECINVALIDREASON("NONE"));

                    //header.setINVALIDCODE(factory.createAPPSINVOICEHEADERRECINVALIDCODE(invalidCode));
                    //header.setINVALIDCODE(factory.createAPPSINVOICEHEADERRECINVALIDCODE(invalidCode));
                    /*
                header.setPOTYPE(factory.createAPPSINVOICEHEADERRECPOTYPE(null));
                header.setALTERNATEAPPROVEREMPLOYEENO(factory.createAPPSINVOICEHEADERRECALTERNATEAPPROVEREMPLOYEENO(null));
                header.setCERTIFIERCOMMENTS(factory.createAPPSINVOICEHEADERRECCERTIFIERCOMMENTS(null));
                header.setINVOICEIMAGEURL(factory.createAPPSINVOICEHEADERRECINVOICEIMAGEURL(null));
                header.setHEADERATT4(factory.createAPPSINVOICEHEADERRECHEADERATT4(null));
                header.setHEADERATT5(factory.createAPPSINVOICEHEADERRECHEADERATT5(null));
                header.setHEADERATT6(factory.createAPPSINVOICEHEADERRECHEADERATT6(null));
                header.setHEADERATT7(factory.createAPPSINVOICEHEADERRECHEADERATT7(null));
                header.setHEADERATT8(factory.createAPPSINVOICEHEADERRECHEADERATT8(null));
                header.setHEADERATT9(factory.createAPPSINVOICEHEADERRECHEADERATT9(null));
                header.setHEADERATT10(factory.createAPPSINVOICEHEADERRECHEADERATT10(null));
                header.setIMAGEURL(factory.createAPPSINVOICEHEADERRECIMAGEURL(null));
                header.setPRIORITY(factory.createAPPSINVOICEHEADERRECPRIORITY(null));
                header.setREASONTYPE(factory.createAPPSINVOICEHEADERRECREASONTYPE(null));
                header.setSTATUS(factory.createAPPSINVOICEHEADERRECSTATUS(null));
                header.setREJECTIONREASON(factory.createAPPSINVOICEHEADERRECREJECTIONREASON(null));*/

                    JAXBElement<APPSINVOICEHEADERREC> header_ = factory.createInputParametersPINVOICEIN(header);
                    inputParams.setPINVOICEIN(header_);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (am != null) {
                        Configuration.releaseRootApplicationModule(am, false); //added by rahadevan for adf code fix//
                    }
                }
            }

            /* Get the line details values */


            DCBindingContainer lineDetailsBindings =
                (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            ViewObject lineItemVo =
                lineDetailsBindings.findIteratorBinding("LineItemDetailsEOView1Iterator").getViewObject();


            rsi = lineItemVo.createRowSetIterator(null);

            // set the line parameters
            APPSINVOICEINTBLTYPE lines = new APPSINVOICEINTBLTYPE();
            System.out.println("fetched row count BEFORE ::: " + rsi.getFetchedRowCount());
            //System.out.println("Row count :::: "+ rsi.getRowCount());

            while (rsi.hasNext()) {
                System.out.println("------ Inside while before ------");
                Row nextRow = rsi.next();
                System.out.println("------ Inside while before ------ " + "Line number :: " +
                                   nextRow.getAttribute("LineNumber"));

                APPSINVOICELINEREC line = new APPSINVOICELINEREC();

                line.setLINENO(factory.createAPPSINVOICELINERECLINENO(nextRow.getAttribute("LineNumber") != null ?
                                                                      nextRow.getAttribute("LineNumber").toString() :
                                                                      null));
                line.setLINETYPE(factory.createAPPSINVOICELINERECLINETYPE("LINE")); ///?????
                line.setLINEPONUMBER(factory.createAPPSINVOICELINERECLINEPONUMBER(nextRow.getAttribute("LinePoNum") !=
                                                                                  null ?
                                                                                  nextRow.getAttribute("LinePoNum")
                                                                                  .toString() : null));
                line.setPOLINENUMBER(factory.createAPPSINVOICELINERECPOLINENUMBER(nextRow.getAttribute("PoLineNum") !=
                                                                                  null ?
                                                                                  new BigDecimal(nextRow.getAttribute("PoLineNum")
                                                                                                 .toString()) : null));
                line.setLINEDESCRIPTION(factory.createAPPSINVOICELINERECLINEDESCRIPTION(nextRow.getAttribute("LineDescription") !=
                                                                                        null ?
                                                                                        nextRow.getAttribute("LineDescription")
                                                                                        .toString() : null));
                line.setQUANTITY(factory.createAPPSINVOICELINERECQUANTITY(nextRow.getAttribute("Quantity") != null ?
                                                                          new BigDecimal(nextRow.getAttribute("Quantity")
                                                                                         .toString()) : null));
                line.setUOM(factory.createAPPSINVOICELINERECUOM(nextRow.getAttribute("Uom") != null ?
                                                                nextRow.getAttribute("Uom").toString() : null));
                line.setUNITPRICE(factory.createAPPSINVOICELINERECUNITPRICE(nextRow.getAttribute("UnitPrice") != null ?
                                                                            new BigDecimal(nextRow.getAttribute("UnitPrice")
                                                                                           .toString()) : null));
                line.setLINETOTALAMOUNT(factory.createAPPSINVOICELINERECLINETOTALAMOUNT(nextRow.getAttribute("LineTotalAmount") !=
                                                                                        null ?
                                                                                        new BigDecimal(nextRow.getAttribute("LineTotalAmount")
                                                                                                       .toString()) :
                                                                                        null));
                line.setTAXRATE(factory.createAPPSINVOICELINERECTAXRATE(null));
                line.setTAXRATECODE(factory.createAPPSINVOICELINERECTAXRATECODE(nextRow.getAttribute("TaxRateCode") !=
                                                                                null ?
                                                                                nextRow.getAttribute("TaxRateCode")
                                                                                .toString() : null));
                line.setLINETAXAMOUNT(factory.createAPPSINVOICELINERECLINETAXAMOUNT(nextRow.getAttribute("TaxAmountLineitem") !=
                                                                                    null ?
                                                                                    new BigDecimal(nextRow.getAttribute("TaxAmountLineitem")
                                                                                                   .toString()) :
                                                                                    null));
                line.setPROJECTNO(factory.createAPPSINVOICELINERECPROJECTNO(null));
                line.setTASKNO(factory.createAPPSINVOICELINERECTASKNO(null));
                line.setEXPENDITUREORG(factory.createAPPSINVOICELINERECEXPENDITUREORG(null));
                line.setEXPENDITUREDATE(factory.createAPPSINVOICELINERECEXPENDITUREDATE(null));
                line.setEXPENDITURETYPE(factory.createAPPSINVOICELINERECEXPENDITURETYPE(null));
                line.setGLCODE(factory.createAPPSINVOICELINERECGLCODE(null));
                line.setLINEAATT1(factory.createAPPSINVOICELINERECLINEAATT1(null));
                line.setLINEAATT2(factory.createAPPSINVOICELINERECLINEAATT2(null));
                line.setLINEAATT3(factory.createAPPSINVOICELINERECLINEAATT3(null));
                line.setLINEAATT4(factory.createAPPSINVOICELINERECLINEAATT4(null));
                line.setLINEAATT5(factory.createAPPSINVOICELINERECLINEAATT5(null));
                line.setLINEAATT6(factory.createAPPSINVOICELINERECLINEAATT6(null));
                line.setLINEAATT7(factory.createAPPSINVOICELINERECLINEAATT7(null));
                line.setLINEAATT8(factory.createAPPSINVOICELINERECLINEAATT8(null));
                line.setLINEAATT9(factory.createAPPSINVOICELINERECLINEAATT9(null));
                line.setLINEAATT10(factory.createAPPSINVOICELINERECLINEAATT10(null));

                lines.getPINVLINEITEM().add(line);

            }

            JAXBElement<APPSINVOICEINTBLTYPE> lines_ = factory.createInputParametersPINVLINE(lines);
            inputParams.setPINVLINE(lines_);

            System.out.println("--- service callout");
            OutputParameters ouputParams = service.getUpdatePttBindingQSPort().update(inputParams);
            System.out.println("--- service callout done");
            if (rsi != null) {
                try {
                    rsi.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
            System.out.println("--- Output from proc ---");
            System.out.println("lines : " + ouputParams.getPINVLINE()
                                                       .getValue()
                                                       .getPINVLINEITEM()
                                                       .size());

            //            BindingContainer lineDetailsBindings1 =
            //                BindingContext.getCurrent().getCurrentBindingsEntry();
            //            DCIteratorBinding dciter1 =
            //                (DCIteratorBinding)lineDetailsBindings1.get("LineItemDetailsEOView1Iterator");
            //             rsi1 = dciter1.getRowSetIterator();
            //            System.out.println("fetched row count AFTER ::: "+ rsi1.getFetchedRowCount());

            /* Start Delete all rows from line detail table VO */
            DCBindingContainer dc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            ViewObject myVo = dc.findIteratorBinding("LineItemDetailsEOView1Iterator").getViewObject();
            rsI = myVo.createRowSetIterator(null);
            while (rsI.hasNext()) {
                rsI.next().remove();
            }

            rsI.closeRowSetIterator();

            /* End Delete all rows from line detail table VO */

            /* Start Add lines returned by the procedure to the line detail table VO */
            DCBindingContainer bindings2 = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

            ViewObject lineVo = bindings2.findIteratorBinding("LineItemDetailsEOView1Iterator").getViewObject();
            int lastRowIndex = lineVo.getRangeIndexOf(lineVo.last());

            for (APPSINVOICELINEREC lineData : ouputParams.getPINVLINE()
                                                          .getValue()
                                                          .getPINVLINEITEM()) {
                System.out.println("------ LINE RECORD START ------");

                Row newRow = lineVo.createRow();

                try {
                    System.out.println("getLINENO() : " + lineData.getLINENO().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINETYPE() : " + lineData.getLINETYPE().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINEPONUMBER() : " + lineData.getLINEPONUMBER().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getPOLINENUMBER() : " + lineData.getPOLINENUMBER().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINEDESCRIPTION() : " + lineData.getLINEDESCRIPTION().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getQUANTITY() : " + lineData.getQUANTITY().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getUOM() : " + lineData.getUOM().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getUNITPRICE() : " + lineData.getUNITPRICE().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINETOTALAMOUNT() : " + lineData.getLINETOTALAMOUNT().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getTAXRATE() : " + lineData.getTAXRATE().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getTAXRATECODE() : " + lineData.getTAXRATECODE().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINETAXAMOUNT() : " + lineData.getLINETAXAMOUNT().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getPROJECTNO() : " + lineData.getPROJECTNO().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getTASKNO() : " + lineData.getTASKNO().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getEXPENDITUREORG() : " + lineData.getEXPENDITUREORG().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getEXPENDITUREDATE() : " + lineData.getEXPENDITUREDATE().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getEXPENDITURETYPE() : " + lineData.getEXPENDITURETYPE().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getGLCODE() : " + lineData.getGLCODE().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINEAATT1() : " + lineData.getLINEAATT1().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINEAATT2() : " + lineData.getLINEAATT2().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINEAATT3() : " + lineData.getLINEAATT3().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINEAATT4() : " + lineData.getLINEAATT4().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINEAATT5() : " + lineData.getLINEAATT5().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINEAATT6() : " + lineData.getLINEAATT6().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINEAATT7() : " + lineData.getLINEAATT7().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINEAATT8() : " + lineData.getLINEAATT8().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINEAATT9() : " + lineData.getLINEAATT9().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    System.out.println("getLINEAATT10() : " + lineData.getLINEAATT10().getValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                newRow.setAttribute("InvoiceId", getInvoiceId());
                newRow.setAttribute("LineNumber", lineData.getLINENO().getValue());
                newRow.setAttribute("LinePoNum", lineData.getLINEPONUMBER().getValue());
                newRow.setAttribute("PoLineNum", lineData.getPOLINENUMBER().getValue());
                newRow.setAttribute("LineDescription", lineData.getLINEDESCRIPTION().getValue());
                newRow.setAttribute("Quantity", lineData.getQUANTITY().getValue());
                newRow.setAttribute("Uom", lineData.getUOM().getValue());
                newRow.setAttribute("UnitPrice", lineData.getUNITPRICE().getValue());
                newRow.setAttribute("LineTotalAmount", lineData.getLINETOTALAMOUNT().getValue());
                newRow.setAttribute("TaxRate", lineData.getTAXRATE().getValue());
                newRow.setAttribute("TaxRateCode", lineData.getTAXRATECODE().getValue());
                newRow.setAttribute("TaxAmountLineitem", lineData.getLINETAXAMOUNT().getValue());

                lineVo.insertRowAtRangeIndex(lastRowIndex + 1, newRow);
                System.out.println("lastRowIndex : " + lastRowIndex);
                lastRowIndex++;

                System.out.println("------ LINE RECORD END ------");
            }
            /* End Add lines returned by the procedure to the line detail table VO */

            /* if(rsi1!=null) {
            try {
                rsi1.closeRowSetIterator();
            } catch(Exception ex) {
                ex.printStackTrace();

        }
        } */
            //AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);
            /* BindingContainer lineDetailsBindings2 = BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dciter2 = (DCIteratorBinding)lineDetailsBindings2.get("LineItemDetailsEOView1Iterator"); */
            rsi2 = lineVo.createRowSetIterator(null);
            DecimalFormat df = new DecimalFormat("#0.00");
            double lineTotal = 0;
            double taxTotal = 0;
            System.out.println("rsi2 :::: " + rsi2.getRowCount() + " next ?? " + rsi2.hasNext());
            while (rsi2.hasNext()) {
                System.out.println("inside while ...........");
                Row newRow1 = rsi2.next();
                System.out.println("Line total ::: " + newRow1.getAttribute("LineTotalAmount"));
                if (newRow1.getAttribute("LineTotalAmount") != null) {
                    lineTotal = lineTotal + Double.parseDouble(newRow1.getAttribute("LineTotalAmount")
                                                                      .toString()
                                                                      .trim());
                }
                if (newRow1.getAttribute("TaxAmountLineitem") != null) {
                    taxTotal = taxTotal + Double.parseDouble(newRow1.getAttribute("TaxAmountLineitem")
                                                                    .toString()
                                                                    .trim());
                }

            }
            System.out.println("lineTotal ::: " + lineTotal + " taxTotal ::: " + taxTotal);
            //        lineTotalSum.setValue(df.format(lineTotal));
            //        taxAmountSum.setValue(df.format(taxTotal));
            //        AdfFacesContext.getCurrentInstance().addPartialTarget(lineTotalSum);
            //        AdfFacesContext.getCurrentInstance().addPartialTarget(taxAmountSum);
            //        AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rsi2 != null) {
                try {
                    rsi2.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (rowIt != null) {
                try {
                    rowIt.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        System.out.println("End onMatchClick");
    }

    public void setExceptionPgl(RichPanelGroupLayout exceptionPgl) {
        this.exceptionPgl = exceptionPgl;
    }

    public RichPanelGroupLayout getExceptionPgl() {
        return exceptionPgl;
    }

    public void setLineTableOuterPgl(RichPanelGroupLayout lineTableOuterPgl) {
        this.lineTableOuterPgl = lineTableOuterPgl;
    }

    public RichPanelGroupLayout getLineTableOuterPgl() {
        return lineTableOuterPgl;
    }

    public void setHeaderOuterPgl(RichPanelGroupLayout headerOuterPgl) {
        this.headerOuterPgl = headerOuterPgl;
    }

    public RichPanelGroupLayout getHeaderOuterPgl() {
        return headerOuterPgl;
    }

    public void setP8(RichPopup p8) {
        this.p8 = p8;
    }

    public RichPopup getP8() {
        return p8;
    }

    public void showPOLineNumPopup(ActionEvent actionEvent) {
        // Add event code here...

        String enteredPonumber = null;
        RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
        Iterator rowKeySetIt = rowKeySet.iterator();
        DCIteratorBinding lineItemIter =
            ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry())
            .findIteratorBinding("LineItemDetailsEOView1Iterator");
        RowSetIterator lineItemRSIter = null;
        try {
            lineItemRSIter = lineItemIter.getRowSetIterator();
            while (rowKeySetIt.hasNext()) {
                Key key = (Key) ((List) rowKeySetIt.next()).get(0);
                Row currentRow = lineItemRSIter.getRow(key);
                if (currentRow != null) {
                    System.out.println("----- typedInPONumber ----- " + currentRow.getAttribute("LinePoNum"));

                    enteredPonumber = currentRow.getAttribute("LinePoNum") == null ? "" : currentRow.getAttribute("LinePoNum")
                                                                                                    .toString()
                                                                                                    .trim();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lineItemRSIter != null) {
                try {
                    lineItemRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        oracle.jbo.domain.Number supplierId =
            supplierID.getValue() == null ? null : (oracle.jbo.domain.Number) supplierID.getValue();


        //Populate SupplierId
        try {
            DCBindingContainer dcBindingContainer =
                (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("SitesDetailsVO1Iterator");
            ViewObjectImpl suppNameVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();

            ViewCriteria viewCrit = suppNameVO.getViewCriteria("SitesDetailsVOCriteria2");
            suppNameVO.applyViewCriteria(viewCrit);
            suppNameVO.setNamedWhereClauseParam("bindSupplierName",
                                                supNameIt.getValue() == null ? null : (String) supNameIt.getValue());
            suppNameVO.executeQuery();


            if (suppNameVO.getEstimatedRowCount() > 0) {
                System.out.println("--- Match found for Supplier Name : " + suppNameVO.getEstimatedRowCount() +
                                   " records.");
                RowSetIterator rowIt = null;
                try {
                    rowIt = suppNameVO.createRowSetIterator(null);
                    while (rowIt.hasNext()) {
                        Row rowData = rowIt.next();
                        try {
                            System.out.println("--- Matched Supplier Number : " + rowData.getAttribute("VendorNumber"));
                            BigDecimal vendorId =
                                rowData.getAttribute("VendorId") == null ? null :
                                (BigDecimal) rowData.getAttribute("VendorId");
                            supplierId = vendorId == null ? null : new oracle.jbo.domain.Number(vendorId.intValue());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (rowIt != null) {
                        try {
                            rowIt.closeRowSetIterator();
                        } catch (Exception ex) {
                            ex.printStackTrace();

                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        oracle.jbo.domain.Number siteId =
            siteIdIt.getValue() == null ? null : (oracle.jbo.domain.Number) siteIdIt.getValue();

        System.out.println("----- supplierId : " + supplierId + ", siteId : " + siteId);


        if (!enteredPonumber.equals("")) {
            if (supplierId != null && siteId == null) {
                System.out.println("----- Filtering line items PO by supplier ID only");
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding =
                    dcBindingContainer.findIteratorBinding("POLineNumberDetailsVO1Iterator");
                ViewObjectImpl poNOVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = poNOVO.getViewCriteria("POLineNumberDetailsVOCriteria_filterByVendorId");
                poNOVO.applyViewCriteria(vc);
                poNOVO.setNamedWhereClauseParam("po_number", enteredPonumber);
                poNOVO.setNamedWhereClauseParam("vendor_id", supplierId);
                //System.out.println("-----------Dynamic Query POLine Number-----------");
                //System.out.println(poNOVO.getQuery());
                poNOVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poLineNumberTable);
            } else if (supplierId != null && siteId != null) {
                System.out.println("----- Filtering line items PO by supplier ID and site ID");
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding =
                    dcBindingContainer.findIteratorBinding("POLineNumberDetailsVO1Iterator");
                ViewObjectImpl poNOVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = poNOVO.getViewCriteria("POLineNumberDetailsVOCriteria_filterByVendorIdSiteId");
                poNOVO.applyViewCriteria(vc);
                poNOVO.setNamedWhereClauseParam("po_number", enteredPonumber);
                poNOVO.setNamedWhereClauseParam("vendor_id", supplierId);
                poNOVO.setNamedWhereClauseParam("site_id", siteId);
                //System.out.println("-----------Dynamic Query Query POLine Number-----------");
                //System.out.println(poNOVO.getQuery());
                poNOVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poLineNumberTable);
            } else {
                System.out.println("----- Filtering line items PO by typed in PO number only");
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding =
                    dcBindingContainer.findIteratorBinding("POLineNumberDetailsVO1Iterator");
                ViewObjectImpl poNOVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                poNOVO.setNamedWhereClauseParam("po_number", enteredPonumber);
                //System.out.println("-----------Dynamic Query POLine Number-----------");
                //System.out.println(poNOVO.getQuery());
                poNOVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poLineNumberTable);
            }


            String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
            System.out.println(" ----- clientID : " + clientId);
            this.clientID.setValue(clientId);

            System.out.println("Start showPOLineNumPopup");
            try {
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                p8.show(hints);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.validationErrorMessage.setValue("Line Item PO Number must be entered to search for PO Line Number");
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            validationErrorPopup.show(hints);
        }


        System.out.println("End showPOLineNumPopup");
    }

    public void onPoLineNumPopUpGoClick(ActionEvent actionEvent) {
        System.out.println("Start onPoLineNumPopUpGoClick");

        String enteredPonumber = null;
        RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
        Iterator rowKeySetIt = rowKeySet.iterator();
        DCIteratorBinding lineItemIter =
            ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry())
            .findIteratorBinding("LineItemDetailsEOView1Iterator");
        RowSetIterator lineItemRSIter = null;
        try {
            lineItemRSIter = lineItemIter.getRowSetIterator();
            while (rowKeySetIt.hasNext()) {
                Key key = (Key) ((List) rowKeySetIt.next()).get(0);
                Row currentRow = lineItemRSIter.getRow(key);
                if (currentRow != null) {
                    System.out.println("----- typedInPONumber ----- " + currentRow.getAttribute("LinePoNum"));

                    enteredPonumber = currentRow.getAttribute("LinePoNum") == null ? "" : currentRow.getAttribute("LinePoNum")
                                                                                                    .toString()
                                                                                                    .trim();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lineItemRSIter != null) {
                try {
                    lineItemRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        String enteredPoLineNum = null;
        try {
            if (poLineNumPopupIt.getValue() != null) {
                enteredPoLineNum = poLineNumPopupIt.getValue().toString();
                System.out.println("poLineNumPopupIt.getValue(): " + enteredPoLineNum);
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding =
                    dcBindingContainer.findIteratorBinding("POLineDetailsVO1Iterator");
                ViewObjectImpl poLineNumVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = poLineNumVO.getViewCriteria("POLineDetailsVOCriteria_lookupForLineNum");
                poLineNumVO.applyViewCriteria(vc);
                poLineNumVO.setNamedWhereClauseParam("bindPoLineNum", enteredPonumber);
                poLineNumVO.setNamedWhereClauseParam("bindPoLineNumber", enteredPoLineNum);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(poLineNumVO.getQuery());
                poLineNumVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poLineNumberTable);

            } else if (poLineNumPopupIt.getValue() == null) {
                enteredPoLineNum = poLineNumPopupIt.getValue().toString();
                System.out.println("poLineNumPopupIt.getValue(): " + enteredPoLineNum);
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding =
                    dcBindingContainer.findIteratorBinding("POLineDetailsVO1Iterator");
                ViewObjectImpl poLineNumVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = poLineNumVO.getViewCriteria("POLineDetailsVOCriteria");
                poLineNumVO.applyViewCriteria(vc);
                poLineNumVO.setNamedWhereClauseParam("bindPoLineNum", enteredPonumber);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(poLineNumVO.getQuery());
                poLineNumVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poLineNumberTable);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onPoLineNumPopUpGoClick");
    }

    /*
     * Business logic shared by Pinky :
     * Tax Rate code LOV
     * (PO invoice) :
     *  -- Depend on line level PO
     *  -- if not then header level PO
     *  -- if header level PO is not present then Site id .
     *  -- Nothing there then user should restricted .
     * (Non –PO invoice)
     *  -- Depending on header level Site ID the tax rate code should be populated
     * and if no site ID is provided then user should be restricted.
     *
     */
    public boolean searchTaxRateCodeLookupVO(String invoiceType, String siteId, String poNumber, String linePoNum,
                                             String taxRateCode, boolean flag) {

        DCBindingContainer dcBindingContainer =
            (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("TaxRateCodeLookupVO1Iterator");
        ViewObjectImpl taxRateCodeLookupVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
        ViewCriteria vc = null;

        try {
            if (invoiceType.equalsIgnoreCase("PO Invoice")) {
                if (linePoNum != null && !linePoNum.trim().equals("")) { //If line level PO is present
                    System.out.println("----- Condition 1 -----");
                    vc = taxRateCodeLookupVO.getViewCriteria("TaxRateCodeLookupVOCriteria_lookupByPoNumber");
                    taxRateCodeLookupVO.applyViewCriteria(vc);
                    taxRateCodeLookupVO.setNamedWhereClauseParam("bind_poNumber", linePoNum);
                    taxRateCodeLookupVO.setNamedWhereClauseParam("bind_taxRateCode", taxRateCode);
                    taxRateCodeLookupVO.executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateCodeDetailsTable);
                    if (flag)
                        p9.show(new RichPopup.PopupHints());
                } else if (poNumber != null && !poNumber.trim().equals("")) { //If header level PO is present
                    System.out.println("----- Condition 2 -----");
                    vc = taxRateCodeLookupVO.getViewCriteria("TaxRateCodeLookupVOCriteria_lookupByPoNumber");
                    taxRateCodeLookupVO.applyViewCriteria(vc);
                    taxRateCodeLookupVO.setNamedWhereClauseParam("bind_poNumber", poNumber);
                    taxRateCodeLookupVO.setNamedWhereClauseParam("bind_taxRateCode", taxRateCode);
                    taxRateCodeLookupVO.executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateCodeDetailsTable);
                    if (flag)
                        p9.show(new RichPopup.PopupHints());
                } else if (siteId != null && !siteId.trim().equals("")) { //If Site id is present
                    System.out.println("----- Condition 3 -----");
                    vc = taxRateCodeLookupVO.getViewCriteria("TaxRateCodeLookupVOCriteria_lookupBySiteId");
                    taxRateCodeLookupVO.applyViewCriteria(vc);
                    taxRateCodeLookupVO.setNamedWhereClauseParam("bind_siteId", siteId);
                    taxRateCodeLookupVO.setNamedWhereClauseParam("bind_taxRateCode", taxRateCode);
                    taxRateCodeLookupVO.executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateCodeDetailsTable);
                    if (flag)
                        p9.show(new RichPopup.PopupHints());
                } else { //Show error popup
                    System.out.println("----- Condition 4 -----");
                    this.validationErrorMessage.setValue("PO Number or Site Id are Mandatory for a PO invoice for Tax Rate Code"); //Directly copied from Pinky's code
                    if (flag)
                        validationErrorPopup.show(new RichPopup.PopupHints());
                    return false;
                }
            } else {
                if (siteId != null && !siteId.trim().equals("")) { //If Site id is present
                    System.out.println("----- Condition 5 -----");
                    vc = taxRateCodeLookupVO.getViewCriteria("TaxRateCodeLookupVOCriteria_lookupBySiteId");
                    taxRateCodeLookupVO.applyViewCriteria(vc);
                    taxRateCodeLookupVO.setNamedWhereClauseParam("bind_siteId", siteId);
                    taxRateCodeLookupVO.setNamedWhereClauseParam("bind_taxRateCode", taxRateCode);
                    taxRateCodeLookupVO.executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateCodeDetailsTable);
                    if (flag)
                        p9.show(new RichPopup.PopupHints());
                } else { //Show error popup
                    System.out.println("----- Condition 6 -----");
                    this.validationErrorMessage.setValue("Site Id is mandatory for a Non-PO Invoice for Tax Rate Code"); //Directly copied from Pinky's code
                    if (flag)
                        validationErrorPopup.show(new RichPopup.PopupHints());
                    return false;
                }
            }
            System.out.println("taxRateCodeLookupVO.getEstimatedRowCount()" +
                               taxRateCodeLookupVO.getEstimatedRowCount());
            String taxRate = null;
            if (taxRateCodeLookupVO.getEstimatedRowCount() > 0 &&
                !(taxRateCode == null || (taxRateCode != null && taxRateCode.trim().equals("")))) {
                //                       RowSetIterator rsi = glIter.getViewObject().createRowSetIterator(null);
                System.out.println("taxRateCodeLookupVO.getEstimatedRowCount()" +
                                   taxRateCodeLookupVO.getEstimatedRowCount());
                RowSetIterator rsi = null;
                try {
                    rsi = taxRateCodeLookupVO.createRowSetIterator(null);
                    while (rsi.next() != null) {
                        Row taxRow = rsi.getCurrentRow();
                        System.out.println("TaxRate ::" + taxRow.getAttribute("TaxRate"));
                        // Add your logic here if condition
                        taxRate = taxRow.getAttribute("TaxRate").toString();
                        System.out.println("Within While taxRate" + taxRate);
                        AdfFacesContext.getCurrentInstance()
                                       .getPageFlowScope()
                                       .put("taxRate", taxRate);
                        System.out.println("within while" + AdfFacesContext.getCurrentInstance()
                                                                           .getPageFlowScope()
                                                                           .get("taxRate"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (rsi != null) {
                        try {
                            rsi.closeRowSetIterator();
                        } catch (Exception ex) {
                            ex.printStackTrace();

                        }
                    }
                }
                //rsi.closeRowSetIterator();
            } else {
                System.out.println("***  taxRate :: ***");
                AdfFacesContext.getCurrentInstance()
                               .getPageFlowScope()
                               .put("taxRate", null);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }


    public void openTaxRateCodePopup(ActionEvent actionEvent) {
        System.out.println("Start openTaxRateCodePopup");
        String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        System.out.println(" ----- clientID : " + clientId);
        this.clientID.setValue(clientId);

        String linePoNumber = null;
        String taxRateCode = null;

        RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
        Iterator rowKeySetIt = rowKeySet.iterator();
        DCIteratorBinding lineItemIter =
            ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry())
            .findIteratorBinding("LineItemDetailsEOView1Iterator");
        RowSetIterator lineItemRSIter = null;
        try {
            lineItemRSIter = lineItemIter.getRowSetIterator();
            while (rowKeySetIt.hasNext()) {
                Key key = (Key) ((List) rowKeySetIt.next()).get(0);
                Row currentRow = lineItemRSIter.getRow(key);
                if (currentRow != null) {
                    //System.out.println("----- linePoNumber ----- "+currentRow.getAttribute("LinePoNum"));
                    linePoNumber = currentRow.getAttribute("LinePoNum") == null ? "" : currentRow.getAttribute("LinePoNum")
                                                                                                 .toString()
                                                                                                 .trim();
                    taxRateCode = currentRow.getAttribute("TaxRateCode") == null ? "" : currentRow.getAttribute("TaxRateCode")
                                                                                                  .toString()
                                                                                                  .trim();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lineItemRSIter != null) {
                try {
                    lineItemRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        linePoNumber = linePoNumber == null ? "" : linePoNumber.trim();
        taxRateCode = taxRateCode == null ? "" : taxRateCode.trim();

        String invoiceType = (String) invoiceTypeSoc.getValue();

        invoiceType = invoiceType == null ? "" : invoiceType.trim();

        String poNumber = (String) poNumIt.getValue();

        poNumber = poNumber == null ? "" : poNumber.trim();

        String siteId = null;
        if (siteIdIt.getValue() != null) {
            siteId = "" + ((oracle.jbo.domain.Number) siteIdIt.getValue()).getValue();
        }


        siteId = siteId == null ? "" : siteId.trim();
        boolean flag = true;
        if (searchTaxRateCodeLookupVO(invoiceType, siteId, poNumber, linePoNumber, taxRateCode, flag)) {
            taxRateCodePopupIt.setValue(taxRateCode);
            AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateCodePopupIt);
        }

        System.out.println("End openTaxRateCodePopup");
    }

    public void openTaxRateCodePopup_notUsedAnymore(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openTaxRateCodePopup");

        String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        System.out.println(" ----- clientID : " + clientId);
        this.clientID.setValue(clientId);

        String enteredSiteID = null;
        String enteredPoNumIt = null;
        String InvoiceType = null; //---Pinky----//
        boolean isTaxratecode = false; //---Pinky----//
        String valMsg = ""; //---Pinky----//
        //--------------------------Added By Pinky Start----------------------------------//

        String enteredPonumber = null;
        RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
        Iterator rowKeySetIt = rowKeySet.iterator();
        DCIteratorBinding lineItemIter =
            ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry())
            .findIteratorBinding("LineItemDetailsEOView1Iterator");
        RowSetIterator lineItemRSIter = lineItemIter.getRowSetIterator();
        while (rowKeySetIt.hasNext()) {
            Key key = (Key) ((List) rowKeySetIt.next()).get(0);
            Row currentRow = lineItemRSIter.getRow(key);
            if (currentRow != null) {
                System.out.println("----- typedInPONumber ----- " + currentRow.getAttribute("LinePoNum"));

                enteredPonumber = currentRow.getAttribute("LinePoNum") == null ? "" : currentRow.getAttribute("LinePoNum")
                                                                                                .toString()
                                                                                                .trim();
            }
        }


        try {

            InvoiceType = (String) invoiceTypeSoc.getValue();
            System.out.println(" ----- InvoiceType ----- : " + InvoiceType);

            if (InvoiceType.equals("PO Invoice")) {

                if (!enteredPonumber.equals("")) { //line level PO is present


                } else {


                }


                if (poNumIt.getValue() == null) {
                    if (siteIdIt.getValue() == null) {
                        isTaxratecode = false;
                        valMsg = "PO Number or Site Id are Mandatory for a PO invoice for Tax Rate Code";
                    } else {
                        isTaxratecode = true;
                        enteredSiteID = siteIdIt.getValue().toString();
                    }
                } else {
                    isTaxratecode = true;
                    enteredPoNumIt = poNumIt.getValue().toString();
                }
            } else {
                if (siteIdIt.getValue() == null) {
                    isTaxratecode = false;
                    valMsg = "Site Id is mandatory for Non-PO Invoice for TAX rate code";
                } else {
                    isTaxratecode = true;
                    enteredSiteID = siteIdIt.getValue().toString();
                }
            }
            //----------------------------------------Added By Pinky End --------------------------//


            //if(siteIdIt.getValue()!=null && poNumIt.getValue()!=null)---- commented by pinky
            if (isTaxratecode) {
                System.out.println("Valid Case");
                //enteredSiteID = siteIdIt.getValue().toString();---- commented by pinky
                //System.out.println("siteIdIt.getValue(): "+enteredSiteID);
                // enteredPoNumIt = poNumIt.getValue().toString(); ---- commented by pinky
                System.out.println("poNumIt.getValue(): " + enteredPoNumIt);

                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("TaxRateCodeVO1Iterator");
                ViewObjectImpl taxRateCodeVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                //  ViewCriteria vc = poLineNumVO.getViewCriteria("POLineDetailsVOCriteria");
                //  poLineNumVO.applyViewCriteria(vc);
                taxRateCodeVO.setNamedWhereClauseParam("bind_siteId", enteredSiteID);
                taxRateCodeVO.setNamedWhereClauseParam("bind_poNum", enteredPoNumIt);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(taxRateCodeVO.getQuery());
                taxRateCodeVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateCodeDetailsTable);

                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                p9.show(hints);

            } else {
                System.out.println("----- Invalid Case");
                //String valMsg = "PO Number and Site Id are Mandatory";  ---- commented by pinky
                this.validationErrorMessage.setValue(valMsg);
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                validationErrorPopup.show(hints);

            }


            //            if(siteIdIt.getValue()!=null || poNumIt.getValue()!=null)
            //            {
            //                System.out.println("1");
            //                if(siteIdIt.getValue()!=null){
            //                    System.out.println("2");
            //                    enteredSiteID = siteIdIt.getValue().toString();
            //                    System.out.println("siteIdIt.getValue(): "+enteredSiteID);
            //                    if(poNumIt.getValue()!=null)
            //                    {
            //                            System.out.println("3");
            //                            enteredPoNumIt = poNumIt.getValue().toString();
            //                            System.out.println("poNumIt.getValue(): "+enteredPoNumIt);
            //                            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            //                            p9.show(hints);
            //                            try{
            //
            //                                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            //                                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("TaxRateCodeVO1Iterator");
            //                                ViewObjectImpl taxRateCodeVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
            //                              //  ViewCriteria vc = poLineNumVO.getViewCriteria("POLineDetailsVOCriteria");
            //                              //  poLineNumVO.applyViewCriteria(vc);
            //                                taxRateCodeVO.setNamedWhereClauseParam("bind_siteId", enteredSiteID);
            //                                taxRateCodeVO.setNamedWhereClauseParam("bind_poNum", enteredPoNumIt);
            //                                System.out.println("-----------Dynamic Query-----------");
            //                                System.out.println(taxRateCodeVO.getQuery());
            //                                taxRateCodeVO.executeQuery();
            //                                AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateCodeDetailsTable);
            //                            }catch(Exception e)
            //                            {
            //                                e.printStackTrace();
            //                            }
            //
            //                        }
            //                    else{
            //                        System.out.println("4");
            //                        validationErrorMessage.setValue("PO Number is Mandatory");
            //                        validationErrorMessage1.setVisible(false);
            //                        AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorPopup1);
            //                        RichPopup.PopupHints hints = new RichPopup.PopupHints();
            //                        validationErrorPopup1.show(hints);
            //                        AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorPopup1);
            //                    }
            //                }
            //                else{
            //                    System.out.println("5");
            //                    validationErrorMessage.setValue("Site Id is Mandatory");
            //                    validationErrorMessage1.setVisible(false);
            //                    AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorPopup1);
            //                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
            //                    validationErrorPopup1.show(hints);
            //                    AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorPopup1);
            //                }
            //            }else{
            //                System.out.println("6");
            //                validationErrorMessage.setValue("PO Number is Mandatory");
            //                validationErrorMessage1.setVisible(true);
            //                validationErrorMessage1.setValue("Site Id is Mandatory");
            //                RichPopup.PopupHints hints = new RichPopup.PopupHints();
            //                validationErrorPopup1.show(hints);
            //                AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorPopup1);
            //            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openTaxRateCodePopup");
    }


    public void setP9(RichPopup p9) {
        this.p9 = p9;
    }

    public RichPopup getP9() {
        return p9;
    }

    /* public void onCertNameClick(ActionEvent actionEvent) {
        System.out.println("Start onCertNameClick");
        try {

            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p10.show(hints);
            String enteredCertifierName = null;
            if(certNameIt.getValue() != null) {
                enteredCertifierName = certNameIt.getValue().toString();
                System.out.println("certNameIt.getValue(): "+enteredCertifierName);
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CertifierNameVO1Iterator");
                ViewObjectImpl certifierNameVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = certifierNameVO.getViewCriteria("CertifierNameVOCriteria");
                certifierNameVO.applyViewCriteria(vc);
                certifierNameVO.setNamedWhereClauseParam("bindName", enteredCertifierName);
                System.out.println("-----------Dynamic Query-----------");
                System.out.println(certifierNameVO.getQuery());
                certifierNameVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(certifierNameDetailsTable);

            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onCertNameClick");
    }*/

    public boolean isAPPageLoaded() {
        System.out.println("Start:::::::::::::::::: isAPPageLoaded");
        String invalidCodeStr = null;
        String invalidTypeStr = null;
        /* DCBindingContainer bindings =getBindings();
        DCIteratorBinding dcIteratorBindings = bindings.findIteratorBinding("HeaderDetailsEOView1Iterator");
        Row headerRow = dcIteratorBindings.getCurrentRow();
        if(headerRow!= null){
             invalidCodeStr = (String)headerRow.getAttribute("InvalidCode");
            invalidTypeStr = (String)headerRow.getAttribute("InvalidReasonTypeId");
            System.out.println("******** invalidCodeStr: "+ invalidCodeStr);
            System.out.println("******** invalidTypeStr: "+ invalidTypeStr);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("newReasonID", invalidCodeStr);
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("newReasonTypeID", invalidTypeStr);

        }*/
        if (AdfFacesContext.getCurrentInstance()
                           .getPageFlowScope()
                           .get("newReasonID") != null) {
            invalidCodeStr = (String) (AdfFacesContext.getCurrentInstance()
                                                      .getPageFlowScope()
                                                      .get("newReasonID")).toString();
            System.out.println("invalidCodeStr:" + invalidCodeStr);
        }
        if (AdfFacesContext.getCurrentInstance()
                           .getPageFlowScope()
                           .get("newReasonTypeID") != null) {
            invalidTypeStr = (AdfFacesContext.getCurrentInstance()
                                             .getPageFlowScope()
                                             .get("newReasonTypeID")).toString();
            System.out.println("invalidTypeStr:" + invalidTypeStr);
            setExpressionResetValue("#{bindings.ReasonCodeVO1.inputValue}", invalidTypeStr);
        }


        ViewObjectImpl vo2 = Utility.getAm().getReasonTypeVO2();
        ViewCriteria vc2 = vo2.getViewCriteria("ReasonTypeVOCriteria");
        vo2.applyViewCriteria(vc2);
        vo2.setNamedWhereClauseParam("bindReasonId", invalidCodeStr);
        vo2.executeQuery();
        System.out.println("--------------Count of type: " + vo2.getEstimatedRowCount());
        System.out.println("End:::::::::::::::::: isAPPageLoaded");
        return true;
    }

    public void onCertNameClick(ActionEvent actionEvent) {
        System.out.println("Start onCertNameClick updated ");
        try {

            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p10.show(hints);
            String enteredCertifierName = null;
            if (certNameIt.getValue() != null) {
                enteredCertifierName = certNameIt.getValue().toString();
                System.out.println("certNameIt.getValue() updated: " + enteredCertifierName);
            }
            DCBindingContainer dcBindingContainer =
                (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CertifierNameVO1Iterator");
            ViewObjectImpl certifierNameVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
            ViewCriteria vc = certifierNameVO.getViewCriteria("CertifierNameVOCriteria");
            certifierNameVO.applyViewCriteria(vc);
            // certifierNameVO.clearCache();
            certifierNameVO.setNamedWhereClauseParam("bindName", enteredCertifierName);
            //System.out.println("-----------Dynamic Query for Certifier-----------");
            //System.out.println(certifierNameVO.getQuery());
            certifierNameVO.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(certifierNameDetailsTable);

            //}


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onCertNameClick");
    }

    public void setP10(RichPopup p10) {
        this.p10 = p10;
    }

    public RichPopup getP10() {
        return p10;
    }

    public void onReasonTypeChange(ValueChangeEvent valueChangeEvent) {
        System.out.println("Start onReasonTypeChange");
        //System.out.println("\n******** New Value: "+valueChangeEvent.getNewValue());
        AdfFacesContext.getCurrentInstance()
                       .getPageFlowScope()
                       .put("newReasonTypeID", valueChangeEvent.getNewValue());
        System.out.println("End onReasonTypeChange");
    }

    public void onReasonCodeChange(ValueChangeEvent valueChangeEvent) {
        System.out.println("Start onReasonCodeChange");
        RowSetIterator rowSetIterator = null;
        String reasonId = null;
        try {
            System.out.println("\n******** New Value: " + valueChangeEvent.getNewValue());
            AdfFacesContext.getCurrentInstance()
                           .getPageFlowScope()
                           .put("newReasonID", valueChangeEvent.getNewValue());

            /*System.out.println("valueChangeEvent new value: "+valueChangeEvent.getNewValue());
            System.out.println("onLoadCounter: "+ADFContext.getCurrent().getCurrent().getSessionScope().get("onLoadCounter"));
            System.out.println("---------------testVal: "+AdfFacesContext.getCurrentInstance().getPageFlowScope().get("testVal"));*/
            if (valueChangeEvent.getNewValue() != null) {
                /* ViewObjectImpl vo = Utility.getAm().getReasonCodeVO2();
                ViewCriteria vc = vo.getViewCriteria("ReasonCodeVOCriteria");
                vo.applyViewCriteria(vc);
                vo.setNamedWhereClauseParam("bindReasonId", valueChangeEvent.getNewValue().toString());
                vo.executeQuery();
                System.out.println("Count: "+vo.getEstimatedRowCount());
                if(vo.getEstimatedRowCount() > 0){
                    rowSetIterator = vo.createRowSetIterator(null);
                    while(rowSetIterator.hasNext()) {
                        Row row = rowSetIterator.next();
                        if (null != row) {
                            if(row.getAttribute("ReasonType") != null)
                            {
                                System.out.println("-------------reason: "+row.getAttribute("ReasonType").toString());
                                reasonId = row.getAttribute("Id").toString();
                            }
                            System.out.println("-------------reasonId: "+reasonId);
                        }
                    }
                }*/


                ViewObjectImpl vo2 = Utility.getAm().getReasonTypeVO2();
                ViewCriteria vc2 = vo2.getViewCriteria("ReasonTypeVOCriteria");
                vo2.applyViewCriteria(vc2);
                vo2.setNamedWhereClauseParam("bindReasonId", valueChangeEvent.getNewValue().toString());
                vo2.executeQuery();
                System.out.println("--------------Count of type: " + vo2.getEstimatedRowCount());

                //AdfFacesContext.getCurrentInstance().addPartialTarget(exceptionPgl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onReasonCodeChange");
    }

    public void setDocTypeSoc(RichSelectOneChoice docTypeSoc) {
        this.docTypeSoc = docTypeSoc;
    }

    public RichSelectOneChoice getDocTypeSoc() {
        return docTypeSoc;
    }

    public void setValidationErrorMessage(RichOutputText validationErrorMessage) {
        this.validationErrorMessage = validationErrorMessage;
    }

    public RichOutputText getValidationErrorMessage() {
        return validationErrorMessage;
    }

    public void setValidationErrorPopup(RichPopup validationErrorPopup) {
        this.validationErrorPopup = validationErrorPopup;
    }

    public RichPopup getValidationErrorPopup() {
        return validationErrorPopup;
    }

    public void setInvoiceTypeSoc(RichSelectOneChoice invoiceType) {
        this.invoiceTypeSoc = invoiceType;
    }

    public RichSelectOneChoice getInvoiceTypeSoc() {
        return invoiceTypeSoc;
    }


    public void selectSupplierName(ActionEvent actionEvent) {
        System.out.println("Start: selectSupplierName");
        String selectedSupplierName = null;
        String supplierNum = null;
        String selectedSiteId = null;
        String selectedSiteName = null;
        String operatingUnit = null;
        String whtCode = null;
        oracle.jbo.domain.Number supNo;
        String orgID = null;
        String whtFlag = null;
        RowKeySet selectedSupplier = supDetailsTable.getSelectedRowKeys();
        Iterator selectedSupIter = selectedSupplier.iterator();
        DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = bindings.findIteratorBinding("SitesVO1Iterator");
        RowSetIterator empRSIter = null;
        try {
            empRSIter = empIter.getRowSetIterator();
            while (selectedSupIter.hasNext()) {
                Key key = (Key) ((List) selectedSupIter.next()).get(0);
                Row currentRow = empRSIter.getRow(key);
                System.out.println(currentRow.getAttribute("VendorName"));
                selectedSupplierName = currentRow.getAttribute("VendorName").toString();
                supplierNum = currentRow.getAttribute("VendorNumber").toString();
                selectedSiteId = currentRow.getAttribute("VendorSiteId").toString();
                selectedSiteName = currentRow.getAttribute("VendorSiteCode").toString();
                operatingUnit = currentRow.getAttribute("OperatingUnit").toString();
                orgID = currentRow.getAttribute("OrgId") != null ? currentRow.getAttribute("OrgId").toString() : null;
                whtFlag =
                    currentRow.getAttribute("WhtFlag") != null ? currentRow.getAttribute("WhtFlag").toString() : null;
                whtCode =
                    currentRow.getAttribute("WhtCode") != null ? currentRow.getAttribute("WhtCode").toString() : null;
                ADFContext.getCurrent()
                          .getPageFlowScope()
                          .put("defaultWHTCode", whtCode);
                String supplierId = currentRow.getAttribute("VendorId").toString();
                System.out.println("***** Setting Supplier ID for Supplier LOV select ***** : " + supplierId);
                ADFContext.getCurrent()
                          .getPageFlowScope()
                          .put("supplier_id_value", supplierId);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (empRSIter != null) {
                try {
                    empRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        supNo = new oracle.jbo.domain.Number(Integer.parseInt(supplierNum));
        System.out.println("supNo: " + supNo);
        supNameIt.setValue(selectedSupplierName);
        suppNumIt.setValue(supNo);
        siteIdIt.setValue(selectedSiteId);
        siteNameIt.setValue(selectedSiteName);
        String invDate = invDateId.getValue() != null ? invDateId.getValue().toString() : null;
        String currency = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;

        /*System.out.println("Invoice Date :"+invDate);
        System.out.println("Currency :"+currency);
        System.out.println("Org ID :"+orgID);
        System.out.println("Site ID :"+selectedSiteId);*/


        if (whtFlag != null && whtFlag.equalsIgnoreCase("Y")) {

            System.out.println("setting y flag from suppleir");
            whtRequiredFlag.setSelected(true);
            whtRequiredFlag.setDisabled(false);
            whtCodeSearchIcon.setDisabled(false);
            whtCodeColumn.setDisabled(false);
            modifyWhtCodeColumn(whtCode);
            ADFContext.getCurrent()
                      .getPageFlowScope()
                      .put("WHTReqdFlag", "true");
            AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);

            System.out.println("calling getWHTAmount from selectsupplier");
            getWHTAmount(selectedSiteId, invDate, currency, orgID);

        } else if (whtFlag != null && whtFlag.equalsIgnoreCase("N")) {

            System.out.println("clearing wht code from supplier");
            whtRequiredFlag.setSelected(false);
            whtRequiredFlag.setDisabled(true);
            whtCodeSearchIcon.setDisabled(true);
            whtCodeColumn.setDisabled(true);
            ADFContext.getCurrent()
                      .getPageFlowScope()
                      .put("WHTReqdFlag", "false");
            modifyWhtCodeColumn(null);

            whtAmountIt.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(whtAmountIt);

        } else {
            whtRequiredFlag.setSelected(false);
            whtRequiredFlag.setDisabled(true);
            whtCodeSearchIcon.setDisabled(true);
            whtCodeColumn.setDisabled(true);
            ADFContext.getCurrent()
                      .getPageFlowScope()
                      .put("WHTReqdFlag", "false");
            modifyWhtCodeColumn(null);

            whtAmountIt.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(whtAmountIt);
        }
        operatingUnitIt.setValue(operatingUnit);
        poNumIt.setValue("");
        //        siteIdIt.setValue("");
        //        siteNameIt.setValue("");

        AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
        AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);
        p1.hide();
        System.out.println("End selectSupplierName");
    }

    public void cancelSupplierName(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start: cancelSupplierName");

        p1.hide();

        System.out.println("End: cancelSupplierName");
    }

    public void cancelSiteId(ActionEvent actionEvent) {
        System.out.println("Start: cancelSiteId");

        p2.hide();

        System.out.println("End: cancelSiteId");
    }

    public void selectSiteId(ActionEvent actionEvent) {
        System.out.println("Start: selectSiteId");
        String selectedSiteId = null;
        String selectedSiteName = null;
        String selectedOperatingUnit = null;
        String selectedSupplierName = null;
        String supplierNum = null;
        String whtFlag = null;
        String whtCode = null;
        String orgID = null;
        RowKeySet selectedSite = siteDetailsTable.getSelectedRowKeys();
        Iterator selectedSiteIter = selectedSite.iterator();
        DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = bindings.findIteratorBinding("SitesDetailsVO1Iterator");
        RowSetIterator empRSIter = null;
        oracle.jbo.domain.Number supNo;
        try {
            empRSIter = empIter.getRowSetIterator();
            while (selectedSiteIter.hasNext()) {
                Key key = (Key) ((List) selectedSiteIter.next()).get(0);
                Row currentRow = empRSIter.getRow(key);
                System.out.println(currentRow.getAttribute("VendorSiteId"));
                selectedSiteId = currentRow.getAttribute("VendorSiteId").toString();
                selectedSiteName = currentRow.getAttribute("VendorSiteCode").toString();
                selectedOperatingUnit = currentRow.getAttribute("OperatingUnit").toString();
                selectedSupplierName = currentRow.getAttribute("VendorName").toString();
                supplierNum = currentRow.getAttribute("VendorNumber").toString();
                whtFlag =
                    currentRow.getAttribute("WhtFlag") != null ? currentRow.getAttribute("WhtFlag").toString() : null;
                whtCode =
                    currentRow.getAttribute("WhtCode") != null ? currentRow.getAttribute("WhtCode").toString() : null;
                orgID = currentRow.getAttribute("OrgId") != null ? currentRow.getAttribute("OrgId").toString() : null;
                ADFContext.getCurrent()
                          .getPageFlowScope()
                          .put("defaultWHTCode", whtCode);
                String supplierId = currentRow.getAttribute("VendorId").toString();
                System.out.println("***** Setting Supplier ID for Supplier LOV select ***** : " + supplierId);
                ADFContext.getCurrent()
                          .getPageFlowScope()
                          .put("supplier_id_value", supplierId);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (empRSIter != null) {
                try {
                    empRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        siteIdIt.setValue(selectedSiteId);
        siteNameIt.setValue(selectedSiteName);
        operatingUnitIt.setValue(selectedOperatingUnit);
        supNo = new oracle.jbo.domain.Number(Integer.parseInt(supplierNum));
        System.out.println("supNo: " + supNo);
        supNameIt.setValue(selectedSupplierName);
        suppNumIt.setValue(supNo);

        String invDate = invDateId.getValue() != null ? invDateId.getValue().toString() : null;
        String currency = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;

        System.out.println("wht code from select supplier" + whtCode);
        if (whtFlag != null && whtFlag.equalsIgnoreCase("Y")) {

            System.out.println("setting y flag from site select");
            whtRequiredFlag.setSelected(true);
            ADFContext.getCurrent()
                      .getPageFlowScope()
                      .put("WHTReqdFlag", "true");
            whtRequiredFlag.setDisabled(false);
            whtCodeSearchIcon.setDisabled(false);
            whtCodeColumn.setDisabled(false);
            modifyWhtCodeColumn(whtCode);

            System.out.println("calling getWHTAmount from selectsite");

            getWHTAmount(selectedSiteId, invDate, currency, orgID);

        } else if (whtFlag != null && whtFlag.equalsIgnoreCase("N")) {

            System.out.println("setting null whtcolumn from select site id");
            whtRequiredFlag.setSelected(false);
            ADFContext.getCurrent()
                      .getPageFlowScope()
                      .put("WHTReqdFlag", "false");
            whtRequiredFlag.setDisabled(true);
            whtCodeSearchIcon.setDisabled(true);
            whtCodeColumn.setDisabled(true);
            modifyWhtCodeColumn(null);

            whtAmountIt.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(whtAmountIt);
        } else {

            whtRequiredFlag.setSelected(false);
            ADFContext.getCurrent()
                      .getPageFlowScope()
                      .put("WHTReqdFlag", "false");
            whtRequiredFlag.setDisabled(true);
            whtCodeSearchIcon.setDisabled(true);
            whtCodeColumn.setDisabled(true);
            modifyWhtCodeColumn(null);

            whtAmountIt.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(whtAmountIt);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
        AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);

        p2.hide();
        System.out.println("End selectSiteId");
    }

    public void cancelPONumber(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start: cancelSiteId");
        poNumPopupIt.setValue("");
        p4.hide();

        System.out.println("End: cancelSiteId");
    }

    public void selectPONumber(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start: selectPONumber");

        boolean isLineItemPopup =
            (this.isLineItemPopup.getValue() != null && this.isLineItemPopup
                                                                                  .getValue()
                                                                                  .toString()
                                                                                  .equalsIgnoreCase("yes")) ? true :
            false;

        System.out.println("-----isLineItemPopup-----" + isLineItemPopup);
        String orgID = null;
        String selectedPONumber = null;
        String selectedOperatingUnit = null;
        String selectedSiteId = null;
        String selectedSiteName = null;
        String selectedSupplierName = null;
        String selectedSupplierNum = null;
        oracle.jbo.domain.Number supNo;
        RowKeySet selectedPONum = poDetailsTable.getSelectedRowKeys();
        Iterator selectedSiteIter = selectedPONum.iterator();
        DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = bindings.findIteratorBinding("POVO1Iterator");
        RowSetIterator empRSIter = null;
        try {
            empRSIter = empIter.getRowSetIterator();
            while (selectedSiteIter.hasNext()) {
                Key key = (Key) ((List) selectedSiteIter.next()).get(0);
                Row currentRow = empRSIter.getRow(key);
                // System.out.println(currentRow.getAttribute("PoNum"));
                selectedPONumber = currentRow.getAttribute("PoNum").toString();
                selectedSupplierName = currentRow.getAttribute("VendorName").toString();
                selectedSupplierNum = currentRow.getAttribute("VendorNumber").toString();
                selectedSiteId = currentRow.getAttribute("VendorSiteId").toString();
                selectedSiteName = currentRow.getAttribute("VendorSiteCode").toString();
                selectedOperatingUnit = currentRow.getAttribute("OperatingUnit").toString();
                //orgID = currentRow.getAttribute("OrgID") != null ? currentRow.getAttribute("OrgID").toString() : null;   // TODO:ask for org id in poNumber popup
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (empRSIter != null) {
                try {
                    empRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }

        if (isLineItemPopup) {
            //poNumPopupIt.setValue(selectedPONumber);

            int selectedRowNum = -1;
            //            RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
            //            Iterator rowKeySetIt = rowKeySet.iterator();
            //            DCIteratorBinding lineItemIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");
            //            RowSetIterator lineItemRSIter = lineItemIter.getRowSetIterator();
            //             while(rowKeySetIt.hasNext()){
            //               Key key = (Key)((List)rowKeySetIt.next()).get(0);
            //               Row currentRow = lineItemRSIter.getRow(key);
            //                 if(currentRow!=null) {
            //                    System.out.println("----- SELECTED LINE NUMBER ----- "+currentRow.getAttribute("LineNumber"));
            //
            //                    selectedRowNum = Integer.parseInt(currentRow.getAttribute("LineNumber").toString());
            //                 }
            //             }

            if (clientID.getValue() != null) {
                selectedRowNum = Integer.parseInt(clientID.getValue()
                                                          .toString()
                                                          .split(":")[2]);
                System.out.println(" ----- Selected row has client id pattern : " + selectedRowNum);
            }


            if (selectedRowNum != -1) {
                String componentIDPoNumber = "pt1:t1:" + selectedRowNum + ":it35::content";
                System.out.println("----- componentIDPoNumber ----- " + componentIDPoNumber + ", selectedPONumber : " +
                                   selectedPONumber);

                FacesContext fctx = FacesContext.getCurrentInstance();
                ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);

                String myJavaScriptCode =
                    "document.getElementById('" + componentIDPoNumber + "').value = '" + selectedPONumber + "';";


                erks.addScript(fctx, myJavaScriptCode);

                erks.addScript(fctx, "document.getElementById('" + componentIDPoNumber + "').focus();");
                erks.addScript(fctx,
                               "AdfActionEvent.queue(AdfPage.PAGE.findComponentByAbsoluteId('" + "pt1:t1:" +
                               selectedRowNum + ":it35" + "'), true);");

            }


        } else {
            poNumIt.setValue(selectedPONumber);

            if (supNameIt.getValue() == null) {
                supNo = new oracle.jbo.domain.Number(Integer.parseInt(selectedSupplierNum));
                supNameIt.setValue(selectedSupplierName);
                suppNumIt.setValue(supNo);

            }
            if (siteIdIt.getValue() == null) {
                siteIdIt.setValue(selectedSiteId);
                siteNameIt.setValue(selectedSiteName);
                operatingUnitIt.setValue(selectedOperatingUnit);

            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
            p4.hide();
        }

        AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
        p4.hide();

        poNumPopupIt.setValue("");


        System.out.println("End selectPONumber");

    }

    public void setSuppNumIt(RichInputText suppNumIt) {
        this.suppNumIt = suppNumIt;
    }

    public RichInputText getSuppNumIt() {
        return suppNumIt;
    }

    public void setSiteNameIt(RichInputText siteNameIt) {
        this.siteNameIt = siteNameIt;
    }

    public RichInputText getSiteNameIt() {
        return siteNameIt;
    }


    public void setOperatingUnitIt(RichInputText operatingUnitIt) {
        this.operatingUnitIt = operatingUnitIt;
    }

    public RichInputText getOperatingUnitIt() {
        return operatingUnitIt;
    }

    public void setCertifierNameDetailsTable(RichTable certifierNameDetailsTable) {
        this.certifierNameDetailsTable = certifierNameDetailsTable;
    }

    public RichTable getCertifierNameDetailsTable() {
        return certifierNameDetailsTable;
    }

    public void setCertifierNamePopupIT(RichInputText certifierNamePopupIT) {
        this.certifierNamePopupIT = certifierNamePopupIT;
    }

    public RichInputText getCertifierNamePopupIT() {
        return certifierNamePopupIT;
    }

    public void setPoLineNumPopupIt(RichInputText poLineNumPopupIt) {
        this.poLineNumPopupIt = poLineNumPopupIt;
    }

    public RichInputText getPoLineNumPopupIt() {
        return poLineNumPopupIt;
    }

    public void setPoLineNumberTable(RichTable poLineNumberTable) {
        this.poLineNumberTable = poLineNumberTable;
    }

    public RichTable getPoLineNumberTable() {
        return poLineNumberTable;
    }

    public void setSiteCurrencyPopupIt(RichInputText siteCurrencyPopupIt) {
        this.siteCurrencyPopupIt = siteCurrencyPopupIt;
    }

    public RichInputText getSiteCurrencyPopupIt() {
        return siteCurrencyPopupIt;
    }

    public void setCurrencyCodePopupIT(RichInputText currencyCodePopupIT) {
        this.currencyCodePopupIT = currencyCodePopupIT;
    }

    public RichInputText getCurrencyCodePopupIT() {
        return currencyCodePopupIT;
    }

    public void setCurrencyCodeDetailsTable(RichTable currencyCodeDetailsTable) {
        this.currencyCodeDetailsTable = currencyCodeDetailsTable;
    }

    public RichTable getCurrencyCodeDetailsTable() {
        return currencyCodeDetailsTable;
    }

    public void setValidationErrorMessage1(RichOutputText validationErrorMessage1) {
        this.validationErrorMessage1 = validationErrorMessage1;
    }

    public RichOutputText getValidationErrorMessage1() {
        return validationErrorMessage1;
    }

    public void setEmployeeNoIt(RichInputText employeeNoIt) {
        this.employeeNoIt = employeeNoIt;
    }

    public RichInputText getEmployeeNoIt() {
        return employeeNoIt;
    }

    public void setTaxRateCodeDetailsTable(RichTable taxRateCodeDetailsTable) {
        this.taxRateCodeDetailsTable = taxRateCodeDetailsTable;
    }

    public RichTable getTaxRateCodeDetailsTable() {
        return taxRateCodeDetailsTable;
    }

    public void cancelCertifierName(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start: cancelCertifierName");
        certifierNameErrorOT.setVisible(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(certifierNameErrorOT);
        p10.hide();

        System.out.println("End: cancelCertifierName");
    }

    public void unitPriceNumberValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object != null) {
            //System.out.println("Checking");
            String name = object.toString();
            String expression = "^[-]{0,1}[0-9]+(\\.[0-9]{1,5})?$";
            CharSequence inputStr = name;
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(inputStr);
            String msg = "Please enter number with maximum 5 decimal points";
            if (matcher.matches()) {

            } else {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
            }
        }
    }


    public void numberValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object != null) {
            System.out.println("Checking");
            String name = object.toString();

            String clientId = uIComponent.getClientId(facesContext);
            System.out.println("----- clientId ----- " + clientId);


            String expression =
                (clientId.contains("it6") || clientId.contains("it29") || clientId.contains("it41")) ?
                "^[-]{0,1}[0-9]+(\\.[0-9]{1,9})?$" : "^[-]{0,1}[0-9]+(\\.[0-9]{1,2})?$";
            String msg =
                (clientId.contains("it6") || clientId.contains("it29") || clientId.contains("it41")) ?
                "Please enter number with maximum 9 decimal points." :
                "Please enter number with maximum 2 decimal points.";
            CharSequence inputStr = name;
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(inputStr);
            System.out.println("Error msg in Number Validator :" + msg);

            if (matcher.matches()) {

            } else {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
            }
        }
    }

    public void validatePrecisionAmount(FacesContext facesContext, UIComponent uIComponent, Object object) {

        System.out.println("Checking validatePrecisionAmount");
        if (object != null && currencyIt.getValue() != null) {

            String amountToBeValidated = object.toString();
            System.out.println("Checking validatePrecisionAmount object not null with value :: " + object.toString());
            DCBindingContainer dcBindingContainer =
                (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding =
                dcBindingContainer.findIteratorBinding("ValidatePrecisionAmount1Iterator");
            ViewObjectImpl validatePrecisionVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
            validatePrecisionVO.setNamedWhereClauseParam("bv_p_currency", currencyIt.getValue().toString());
            validatePrecisionVO.setNamedWhereClauseParam("bv_p_amount", amountToBeValidated);
            validatePrecisionVO.executeQuery();
            String validatePrecisionMessage = null;
            while (validatePrecisionVO.hasNext()) {
                System.out.println("validatePrecisionVO.hasNext() not null");
                Row row = validatePrecisionVO.next(); // Get the next row in the result set.
                int attributeCount = row.getAttributeCount();
                System.out.println("AtrributeCount :: " + attributeCount + " :AttributeName :" +
                                   row.getAttribute(row.getAttributeNames()[0]));
                String[] attributeNames = row.getAttributeNames();
                if (row.getAttributeNames() != null && row.getAttribute(row.getAttributeNames()[0]) != null) {
                    validatePrecisionMessage = row.getAttribute(attributeNames[0]).toString();
                }
            }


            if (validatePrecisionMessage != null) {
                System.out.println("severity error is present::");
                if (AdfFacesContext.getCurrentInstance()
                                   .getPageFlowScope()
                                   .get("js_onPageLoadFlag") == null) {

                    System.out.println("Executing onpagelaod before severity error ::");
                    onPageLoad(null);
                }
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, validatePrecisionMessage,
                                                              null));
            }
        }
    }

    /* public void selectcertifierName(ActionEvent actionEvent) {
        System.out.println("Start: selectcertifierName");
        String selectedCertifierLastName=null;
        String selectedCertifierFirstName=null;
        String selectedCertifierFullName=null;
        String selectedEmployeeNo=null;
        String selectedcertifierEmail=null;
        try
        {
            RowKeySet selectedCertifier = certifierNameDetailsTable.getSelectedRowKeys();
            Iterator selectedCertifierIter = selectedCertifier.iterator();
            DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding empIter = bindings.findIteratorBinding("CertifierNameVO1Iterator");
            RowSetIterator empRSIter = empIter.getRowSetIterator();
            while(selectedCertifierIter.hasNext()){
                System.out.println("-------------Inside while------------");
                Key key = (Key)((List)selectedCertifierIter.next()).get(0);
                Row currentRow = empRSIter.getRow(key);
                System.out.println(currentRow.getAttribute("FirstName"));
                if(currentRow.getAttribute("FirstName") != null)
                {
                    selectedCertifierFirstName=currentRow.getAttribute("FirstName").toString();
                }
                System.out.println(currentRow.getAttribute("LastName"));
                if(currentRow.getAttribute("LastName") != null)
                {
                   selectedCertifierLastName=currentRow.getAttribute("LastName").toString();
                }
                System.out.println(currentRow.getAttribute("EmployeeNumber"));
                if(currentRow.getAttribute("EmployeeNumber") != null)
                {
                    selectedEmployeeNo=currentRow.getAttribute("EmployeeNumber").toString();
                }
                System.out.println(currentRow.getAttribute("EmailAddress"));
                if(currentRow.getAttribute("EmailAddress") != null)
                {
                    selectedcertifierEmail=currentRow.getAttribute("EmailAddress").toString();
                }
            }
            selectedCertifierFullName = selectedCertifierFirstName + " " +selectedCertifierLastName;
            if(selectedCertifierFullName != null)
            {
                certNameIt.setValue(selectedCertifierFullName.trim());
            }
            employeeNoIt.setValue(selectedEmployeeNo);
            if(selectedcertifierEmail!=null){
                certEmailIt.setValue(selectedcertifierEmail);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
            p10.hide();
            System.out.println("End selectcertifierName");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
            */

    public void selectcertifierName(ActionEvent actionEvent) {
        System.out.println("Start: selectcertifierName");
        String selectedCertifierName = null;
        String selectedEmployeeNo = null;
        String selectedcertifierEmail = null;
        RowKeySet selectedCertifier = certifierNameDetailsTable.getSelectedRowKeys();
        Iterator selectedCertifierIter = selectedCertifier.iterator();
        DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = bindings.findIteratorBinding("CertifierNameVO1Iterator");
        RowSetIterator empRSIter = null;
        try {
            empRSIter = empIter.getRowSetIterator();
            while (selectedCertifierIter.hasNext()) {
                Key key = (Key) ((List) selectedCertifierIter.next()).get(0);
                Row currentRow = empRSIter.getRow(key);
                System.out.println(currentRow.getAttribute("Conname"));
                selectedCertifierName = currentRow.getAttribute("Conname").toString();
                System.out.println(currentRow.getAttribute("EmployeeNumber"));
                selectedEmployeeNo = currentRow.getAttribute("EmployeeNumber").toString();
                System.out.println(currentRow.getAttribute("EmailAddress"));
                if (currentRow.getAttribute("EmailAddress") != null)
                    selectedcertifierEmail = currentRow.getAttribute("EmailAddress").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (empRSIter != null) {
                try {
                    empRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        certNameIt.setValue(selectedCertifierName);
        employeeNoIt.setValue(selectedEmployeeNo);
        if (selectedcertifierEmail != null) {
            certEmailIt.setValue(selectedcertifierEmail);
        } else {
            certEmailIt.setValue("");
        }
        certifierFlag = 1; // for validating while clicking submit
        System.out.println("Certifier flag is " + certifierFlag);
        AdfFacesContext.getCurrentInstance()
                       .getPageFlowScope()
                       .put("certifierFlagInScope", certifierFlag);
        System.out.println("AdfFacesContext.getCurrentInstance().getPageFlowScope() " +
                           AdfFacesContext.getCurrentInstance()
                                                                                                       .getPageFlowScope()
                                                                                                       .get("certifierFlagInScope"));
        chosenCertifierName = selectedCertifierName;
        chosenEmployeeId = selectedEmployeeNo;
        //System.out.println("Chosencertifiername is"+chosenCertifierName);
        //System.out.println("chosenEmployeeId is"+chosenEmployeeId);
        // certifierNameErrorOT.setVisible(false);
        //  AdfFacesContext.getCurrentInstance().addPartialTarget(certifierNameErrorOT);
        AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
        p10.hide();
        System.out.println("End selectcertifierName");
    }


    /*  public void onCerNamePopUpGoClick(ActionEvent actionEvent) {
        System.out.println("Start onCerNamePopUpGoClick");
        String enteredCertifierName = null;
        try {
            if(certifierNamePopupIT.getValue() != null) {
                            enteredCertifierName = certifierNamePopupIT.getValue().toString();
                            System.out.println("certifierNamePopupIT.getValue(): "+enteredCertifierName);
                            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CertifierNameVO1Iterator");
                            ViewObjectImpl certifierNameVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                            ViewCriteria vc = certifierNameVO.getViewCriteria("CertifierNameVOCriteria");
                            certifierNameVO.applyViewCriteria(vc);
                            certifierNameVO.setNamedWhereClauseParam("bindLastName", enteredCertifierName);
                            System.out.println("-----------Dynamic Query-----------");
                            System.out.println(certifierNameVO.getQuery());
                            certifierNameVO.executeQuery();
                            AdfFacesContext.getCurrentInstance().addPartialTarget(certifierNameDetailsTable);

            }  }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onCerNamePopUpGoClick");
    }*/
    public void onCerNamePopUpGoClick(ActionEvent actionEvent) {
        System.out.println("Start onCerNamePopUpGoClick");
        String enteredCertifierVal = null;
        String searchType = null;
        try {
            if (certifierNamePopupIT.getValue() != null) {
                enteredCertifierVal = certifierNamePopupIT.getValue().toString();
                System.out.println("certifierNamePopupIT.getValue(): " + enteredCertifierVal);
                if (searchByCertifiername.getValue() != null) {
                    searchType = searchByCertifiername.getValue().toString();
                    //System.out.println("searchByCertifiername.getValue(): "+searchType);
                }
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding =
                    dcBindingContainer.findIteratorBinding("CertifierNameVO1Iterator");
                ViewObjectImpl certifierNameVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = certifierNameVO.getViewCriteria("CertifierNameVOCriteria");
                if (searchType != null && searchType.equals("certName")) {
                    certifierNameVO.applyViewCriteria(vc);
                    certifierNameVO.setNamedWhereClauseParam("bindName", enteredCertifierVal);
                    certifierNameVO.setNamedWhereClauseParam("bvEmpNumber", null);
                    certifierNameVO.setNamedWhereClauseParam("bvPreferredName", null);
                    //                                     System.out.println("On 5thSep Changed Certifier Query String (Serach by certName):: ----->"+certifierNameVO.getQuery());

                    certifierNameVO.executeQuery();
                }
                if (searchType != null && searchType.equals("empNumber")) {
                    certifierNameVO.applyViewCriteria(vc);
                    certifierNameVO.setNamedWhereClauseParam("bvEmpNumber", enteredCertifierVal);
                    certifierNameVO.setNamedWhereClauseParam("bindName", null);
                    certifierNameVO.setNamedWhereClauseParam("bvPreferredName", null);
                    //                                     System.out.println("On 5thSep Changed Certifier Query String (Serach by empNumber) :: ----->"+certifierNameVO.getQuery());
                    certifierNameVO.executeQuery();
                }
                if (searchType != null && searchType.equals("preferredName")) {
                    certifierNameVO.applyViewCriteria(vc);
                    certifierNameVO.setNamedWhereClauseParam("bvPreferredName", enteredCertifierVal);
                    certifierNameVO.setNamedWhereClauseParam("bindName", null);
                    certifierNameVO.setNamedWhereClauseParam("bvEmpNumber", null);
                    //                                     System.out.println("On 5thSep Changed Certifier Query String (Serach by preferredName):: ----->"+certifierNameVO.getQuery());
                    certifierNameVO.executeQuery();
                }
                AdfFacesContext.getCurrentInstance().addPartialTarget(certifierNameDetailsTable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onCerNamePopUpGoClick");
    }


    public void openCurrencyPopup(ActionEvent actionEvent) {
        System.out.println("Start openCurrencyPopup");
        try {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p5.show(hints);
            String enteredCurrCode = null;

            if (currencyIt.getValue() != null) {
                enteredCurrCode = currencyIt.getValue().toString();
                System.out.println("currencyIt.getValue(): " + enteredCurrCode);
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CurrencyCodeVO1Iterator");
                ViewObjectImpl currencyCodeVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = currencyCodeVO.getViewCriteria("CurrencyCodeVOCriteria");
                currencyCodeVO.applyViewCriteria(vc);
                currencyCodeVO.setNamedWhereClauseParam("bindCurrencyCode", enteredCurrCode);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(currencyCodeVO.getQuery());
                currencyCodeVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(currencyCodeDetailsTable);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openCurrencyPopup");
    }


    public void cancelCurrencyCode(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start: cancelCurrencyCode");

        p5.hide();

        System.out.println("End: cancelCurrencyCode");
    }

    public void selectCurrencyCode(ActionEvent actionEvent) {
        System.out.println("Start: selectCurrencyCode");
        String selectedCurrencyCode = null;
        //String selectedEmployeeNo=null;
        //String selectedcertifierEmail=null;
        RowKeySet selectedCurrency = currencyCodeDetailsTable.getSelectedRowKeys();
        Iterator selectedCurrencyIter = selectedCurrency.iterator();
        DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = bindings.findIteratorBinding("CurrencyCodeVO1Iterator");
        RowSetIterator empRSIter = null;
        try {
            empRSIter = empIter.getRowSetIterator();
            while (selectedCurrencyIter.hasNext()) {
                Key key = (Key) ((List) selectedCurrencyIter.next()).get(0);
                Row currentRow = empRSIter.getRow(key);
                //System.out.println(currentRow.getAttribute("CurrencyCode"));
                selectedCurrencyCode = currentRow.getAttribute("CurrencyCode").toString();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (empRSIter != null) {
                try {
                    empRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        currencyIt.setValue(selectedCurrencyCode);

        AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
        p5.hide();
        System.out.println("End selectCurrencyCode");
    }

    public void onCurrencyCodePopUpGoClick(ActionEvent actionEvent) {
        System.out.println("Start onCurrencyCodePopUpGoClick");
        String enteredCurrCode = null;
        try {
            if (currencyCodePopupIT.getValue() != null) {
                enteredCurrCode = currencyCodePopupIT.getValue().toString();
                System.out.println("currencyCodePopupIT.getValue(): " + enteredCurrCode);
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CurrencyCodeVO1Iterator");
                ViewObjectImpl currencyCodeVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = currencyCodeVO.getViewCriteria("CurrencyCodeVOCriteria");
                currencyCodeVO.applyViewCriteria(vc);
                currencyCodeVO.setNamedWhereClauseParam("bindCurrencyCode", enteredCurrCode);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(currencyCodeVO.getQuery());
                currencyCodeVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(currencyCodeDetailsTable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onCurrencyCodePopUpGoClick");
    }

    public void setValidationErrorPopup1(RichPopup validationErrorPopup1) {
        this.validationErrorPopup1 = validationErrorPopup1;
    }

    public RichPopup getValidationErrorPopup1() {
        return validationErrorPopup1;
    }

    public void setTaxRateCodePopupIt(RichInputText taxRateCodePopupIt) {
        this.taxRateCodePopupIt = taxRateCodePopupIt;
    }

    public RichInputText getTaxRateCodePopupIt() {
        return taxRateCodePopupIt;
    }

    public void onTaxRateCodePopupGoClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start onTaxRateCodePopupGoClick");
        //        String enteredTaxCode = null;
        //        try {
        //            if(taxRateCodePopupIt.getValue() != null) {
        //                enteredTaxCode = taxRateCodePopupIt.getValue().toString();
        //                System.out.println("taxRateCodePopupIt.getValue(): "+enteredTaxCode);
        //                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        //                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("TaxRateCodeVO1Iterator");
        //                ViewObjectImpl taxRateCodeVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
        //                ViewCriteria vc = taxRateCodeVO.getViewCriteria("TaxRateCodeVOCriteria");
        //                taxRateCodeVO.applyViewCriteria(vc);
        //                taxRateCodeVO.setNamedWhereClauseParam("bindTaxRateCode", enteredTaxCode);
        //                System.out.println("-----------Dynamic Query-----------");
        //                System.out.println(taxRateCodeVO.getQuery());
        //                taxRateCodeVO.executeQuery();
        //                AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateCodeDetailsTable);
        //            }
        //        }
        //        catch(Exception e) {
        //            e.printStackTrace();
        //        }

        //        String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        //        System.out.println(" ----- clientID : "+clientId);
        //        this.clientID.setValue(clientId);

        String linePoNumber = null;
        String taxRateCode = null;

        RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
        Iterator rowKeySetIt = rowKeySet.iterator();
        DCIteratorBinding lineItemIter =
            ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry())
            .findIteratorBinding("LineItemDetailsEOView1Iterator");
        RowSetIterator lineItemRSIter = null;
        try {
            lineItemRSIter = lineItemIter.getRowSetIterator();
            while (rowKeySetIt.hasNext()) {
                Key key = (Key) ((List) rowKeySetIt.next()).get(0);
                Row currentRow = lineItemRSIter.getRow(key);
                if (currentRow != null) {
                    //System.out.println("----- linePoNumber ----- "+currentRow.getAttribute("LinePoNum"));
                    linePoNumber = currentRow.getAttribute("LinePoNum") == null ? "" : currentRow.getAttribute("LinePoNum")
                                                                                                 .toString()
                                                                                                 .trim();
                    taxRateCode = currentRow.getAttribute("TaxRateCode") == null ? "" : currentRow.getAttribute("TaxRateCode")
                                                                                                  .toString()
                                                                                                  .trim();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lineItemRSIter != null) {
                try {
                    lineItemRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        linePoNumber = linePoNumber == null ? "" : linePoNumber.trim();

        taxRateCode = (String) taxRateCodePopupIt.getValue();

        taxRateCode = taxRateCode == null ? "" : taxRateCode.trim();

        String invoiceType = (String) invoiceTypeSoc.getValue();

        invoiceType = invoiceType == null ? "" : invoiceType.trim();

        String poNumber = (String) poNumIt.getValue();

        poNumber = poNumber == null ? "" : poNumber.trim();

        String siteId = null;
        ;
        if (siteIdIt.getValue() != null) {
            siteId = "" + ((oracle.jbo.domain.Number) siteIdIt.getValue()).getValue();
        }
        siteId = siteId == null ? "" : siteId.trim();
        boolean flag = true;
        searchTaxRateCodeLookupVO(invoiceType, siteId, poNumber, linePoNumber, taxRateCode, flag);


        System.out.println("End onTaxRateCodePopupGoClick");

    }

    public void cancelTaxRateCodePopup(ActionEvent actionEvent) {
        p9.hide();
    }

    public void cancelPoLinePopupClick(ActionEvent actionEvent) {
        System.out.println("Start: cancelPoLinePopupClick");
        p8.hide();
        System.out.println("End: cancelPoLinePopupClick");
    }

    public String getReasonId(String reasonType) {
        System.out.println("Start getReasonId");
        RowSetIterator rowSetIterator = null;
        String reasonId = null;
        try {
            if (reasonType != null) {
                ViewObjectImpl vo = Utility.getAm().getReasonTypeVO3();
                ViewCriteria vc = vo.getViewCriteria("ReasonTypeVOCriteria1");
                vo.applyViewCriteria(vc);
                vo.setNamedWhereClauseParam("bindReasonType", reasonType);
                vo.executeQuery();
                //System.out.println("-------------Header Rows: "+vo.getEstimatedRowCount());
                if (vo.getEstimatedRowCount() > 0) {
                    rowSetIterator = vo.createRowSetIterator(null);
                    while (rowSetIterator.hasNext()) {
                        Row row = rowSetIterator.next();
                        if (null != row && row.getAttribute("Id") != null) {
                            reasonId = row.getAttribute("Id").toString();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rowSetIterator != null) {
                try {
                    rowSetIterator.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        System.out.println("End getReasonId");
        return reasonId;
    }

    public void setExceptionOt(RichOutputText exceptionOt) {
        this.exceptionOt = exceptionOt;
    }

    public RichOutputText getExceptionOt() {
        return exceptionOt;
    }

    public void setExceptionMsgPgl(RichPanelGroupLayout exceptionMsgPgl) {
        this.exceptionMsgPgl = exceptionMsgPgl;
    }

    public RichPanelGroupLayout getExceptionMsgPgl() {
        return exceptionMsgPgl;
    }

    public void setIsLineItemPopup(RichInputText isLineItemPopup) {
        this.isLineItemPopup = isLineItemPopup;
    }

    public RichInputText getIsLineItemPopup() {
        return isLineItemPopup;
    }

    public void setClientID(RichInputText clientID) {
        this.clientID = clientID;
    }

    public RichInputText getClientID() {
        return clientID;
    }

    public void selectTaxRateCodePopup(ActionEvent actionEvent) {
        //TO KD
        System.out.println("Start: selectTaxRateCodePopup");

        String orgId = null;
        String currency = null;
        String tax_code = null;
        String amount = null;
        String taxRoundAmount = null;

        RowSetIterator empRSIter = null;
        String selectedTaxRate = null;
        String selectedTaxRateCode = null;
        RowSetIterator lineItemRSIter = null;

        if (getOrganizationId() != null) {
            orgId = getOrganizationId().toString();
        }

        //orgId =.getValue()!=null ? orgIdIt.getValue().toString() : null; TO-DO: STORE ORG ID IN GLOBAL VARIABLE
        currency = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;

        try {
            RowKeySet selectedPONum = taxRateCodeDetailsTable.getSelectedRowKeys();
            Iterator selectedSiteIter = selectedPONum.iterator();
            DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding empIter = bindings.findIteratorBinding("TaxRateCodeLookupVO1Iterator");

            empRSIter = empIter.getRowSetIterator();
            while (selectedSiteIter.hasNext()) {
                Key key = (Key) ((List) selectedSiteIter.next()).get(0);
                Row currentRow = empRSIter.getRow(key);
                System.out.println(currentRow.getAttribute("TaxRateCode"));
                if (currentRow.getAttribute("TaxRate") != null) {
                    selectedTaxRate = ((java.math.BigDecimal) currentRow.getAttribute("TaxRate")).doubleValue() + "";
                    // AdfFacesContext.getCurrentInstance().getPageFlowScope().put("taxRatePS", selectedTaxRate);

                }
                System.out.println("set taxRatePS***" + AdfFacesContext.getCurrentInstance()
                                                                       .getPageFlowScope()
                                                                       .get("taxRatePS"));
                selectedTaxRateCode = currentRow.getAttribute("TaxRateCode").toString();
                //AdfFacesContext.getCurrentInstance().getPageFlowScope().put("TaxRateCodePS", selectedTaxRateCode);
                System.out.println("set TaxRateCodePS***" + AdfFacesContext.getCurrentInstance()
                                                                           .getPageFlowScope()
                                                                           .get("TaxRateCodePS"));
            }
            //              commented on 22  may
            RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
            Iterator rowKeySetIt = rowKeySet.iterator();
            DCIteratorBinding lineItemIter =
                ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry())
                .findIteratorBinding("LineItemDetailsEOView1Iterator");


            lineItemRSIter = lineItemIter.getRowSetIterator();
            while (rowKeySetIt.hasNext()) {
                Key key = (Key) ((List) rowKeySetIt.next()).get(0);
                Row currentLineItemRow = lineItemRSIter.getRow(key);
                if (currentLineItemRow != null) {
                    System.out.println("----- typedInTaxRateCode ----- " +
                                       currentLineItemRow.getAttribute("TaxRateCode"));
                    currentLineItemRow.setAttribute("TaxRateCode", selectedTaxRateCode);
                    System.out.println("----- selectedTaxCode ----- " + currentLineItemRow.getAttribute("TaxRateCode"));
                    amount =
                        currentLineItemRow.getAttribute("LineTotalAmount") != null ?
                        currentLineItemRow.getAttribute("LineTotalAmount").toString() : null;

                    System.out.println("Line Amount : " + amount);

                    if (orgId != null && currency != null && selectedTaxRateCode != null && amount != null) {

                        DCBindingContainer dcBindingContainer =
                            (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dcIteratorBinding =
                            dcBindingContainer.findIteratorBinding("ValidateTaxCalcRounding1Iterator");
                        ViewObjectImpl validateTaxAmountRoundingVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                        validateTaxAmountRoundingVO.setNamedWhereClauseParam("bv_orgId", orgId);
                        validateTaxAmountRoundingVO.setNamedWhereClauseParam("bv_currency", currency);
                        validateTaxAmountRoundingVO.setNamedWhereClauseParam("bv_tax_code", selectedTaxRateCode);
                        validateTaxAmountRoundingVO.setNamedWhereClauseParam("bv_amount", amount);
                        validateTaxAmountRoundingVO.executeQuery();

                        while (validateTaxAmountRoundingVO.hasNext()) {
                            Row row = validateTaxAmountRoundingVO.next();
                            int attributeCount = row.getAttributeCount();
                            System.out.println("AtrributeCount :: " + attributeCount + "Atrribute Name is :: " +
                                               row.getAttribute(row.getAttributeNames()[0]));
                            String[] attributeNames = row.getAttributeNames();
                            if (row.getAttribute(row.getAttributeNames()[0]) != null) {
                                taxRoundAmount = row.getAttribute(attributeNames[0]).toString();
                                System.out.println("taxRoundAmount :: " + taxRoundAmount);
                            }
                        }
                    }

                    currentLineItemRow.setAttribute("TaxAmountLineitem", taxRoundAmount);


                }
            }


            AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);
            //getCalculatedTaxAmountFromEBS(selectedTaxRateCode, "Tax");


            AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
            p9.hide();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (empRSIter != null) {
                try {
                    empRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
            if (lineItemRSIter != null) {
                try {
                    lineItemRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        System.out.println("End selectTaxRateCodePopup");
    }


    public void setSelectPOLineNumPopup(RichCommandButton selectPOLineNumPopup) {
        this.selectPOLineNumPopup = selectPOLineNumPopup;
    }

    public RichCommandButton getSelectPOLineNumPopup() {
        return selectPOLineNumPopup;
    }


    public void cancelPOLineNumPopup(ActionEvent actionEvent) {

        ////
        p8.hide();
    }


    private static String getJavascriptElementByIdExpressionStr(String componentId) {
        return "document.getElementById('" + componentId + "').value";
    }

    private static String getJavascriptStringEmptyCheckExpressionStr(String componentId) {
        String str = getJavascriptElementByIdExpressionStr(componentId);
        return str + "==null || " + str + "==''";
    }

    private static String getJavascriptStringValueCheckExpressionStr(String componentId, String value) {
        String str = getJavascriptElementByIdExpressionStr(componentId);
        return str + "=='" + value + "'";
    }

    private static String getJavascriptElementSetValueExpressionStr(String componentId, String value) {
        return getJavascriptElementByIdExpressionStr(componentId) + " = " + value + ";";
    }

    private static String getJavascriptIsNaNExpressionStr(String componentId) {
        String str = getJavascriptElementByIdExpressionStr(componentId);
        return "isNaN( parseFloat(" + str + ") )";
    }

    public void selectPOLineNumPopup(ActionEvent actionEvent) {
        //TO KD
        System.out.println("Start: selectPOLineNumPopup");


        BigDecimal poLineNumber = null;
        BigDecimal quantity = null;
        String uom = null;
        BigDecimal unitPrice = null;
        String lineDesctiption = null;
tempQuantity = null;
        tempUnitPrice = null;
        tempTaxRateCode = null;
        String taxRateCode = null;
        BigDecimal taxAmount = null;

        RowSetIterator lineItemRSIter = null;
        RowSetIterator empRSIter = null;
        try {
            RowKeySet selectedPONum = poLineNumberTable.getSelectedRowKeys();
            Iterator selectedSiteIter = selectedPONum.iterator();
            DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding empIter = bindings.findIteratorBinding("POLineNumberDetailsVO1Iterator");
            empRSIter = empIter.getRowSetIterator();
            while (selectedSiteIter.hasNext()) {
                Key key = (Key) ((List) selectedSiteIter.next()).get(0);
                Row currentRow = empRSIter.getRow(key);

                poLineNumber =
                    currentRow.getAttribute("LineNum") == null ? null : (BigDecimal) currentRow.getAttribute("LineNum");
                quantity =
                    currentRow.getAttribute("Quantity") == null ? null :
                    (BigDecimal) currentRow.getAttribute("Quantity");
                uom = currentRow.getAttribute("Uom") == null ? null : (String) currentRow.getAttribute("Uom");
                unitPrice =
                    currentRow.getAttribute("UnitPrice") == null ? null :
                    (BigDecimal) currentRow.getAttribute("UnitPrice");
                lineDesctiption =
                    currentRow.getAttribute("ItemDescription") == null ? null :
                    (String) currentRow.getAttribute("ItemDescription");
                taxRateCode =
                    currentRow.getAttribute("TaxRateCode") == null ? null :
                    (String) currentRow.getAttribute("TaxRateCode");
                taxAmount =
                    currentRow.getAttribute("TaxRate") == null ? null : (BigDecimal) currentRow.getAttribute("TaxRate");


                //System.out.println("----- poLineNumber : "+poLineNumber+", quantity : "+quantity+", uom : "+uom+", unitPrice : "+unitPrice+", lineDesctiption : "+lineDesctiption+", taxRateCode : "+taxRateCode+", taxAmount : "+taxAmount);
            }

tempQuantity = quantity.toString();
            tempUnitPrice = unitPrice.toString();
            tempTaxRateCode = taxRateCode.toString();
            System.out.println("PO Line Number Selection Quantity :" + tempQuantity + " : UnitPrice : " +
                               tempUnitPrice + " : TaxRateCode :" + tempTaxRateCode);

            //poNumPopupIt.setValue(selectedPONumber);

            int selectedRowNum = -1;

            if (clientID.getValue() != null) {
                selectedRowNum = Integer.parseInt(clientID.getValue()
                                                          .toString()
                                                          .split(":")[2]);
                System.out.println(" ----- Selected row has client id pattern : " + selectedRowNum);
            }


            if (selectedRowNum != -1) {
                FacesContext fctx = FacesContext.getCurrentInstance();
                ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);

                //Tax Rate
                RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
                Iterator rowKeySetIt = rowKeySet.iterator();
                DCIteratorBinding lineItemIter =
                    ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry())
                    .findIteratorBinding("LineItemDetailsEOView1Iterator");

                lineItemRSIter = lineItemIter.getRowSetIterator();
                while (rowKeySetIt.hasNext()) {
                    Key key = (Key) ((List) rowKeySetIt.next()).get(0);
                    Row currentRow = lineItemRSIter.getRow(key);
                    System.out.println("current row :: " + currentRow);
                    if (currentRow != null) {
                        System.out.println("current row not null ............................");
                        //System.out.println("line description value ::: "+ currentRow.getAttribute("LineDescription"));
                        try {
                            currentRow.setAttribute("TaxRate",
                                                    taxAmount == null ? null :
                                                    new oracle.jbo.domain.Number(taxAmount.doubleValue()));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);

                //PO Line Number
                if (poLineNumber != null) {
                    erks.addScript(fctx,
                                   "document.getElementById('" + ("pt1:t1:" + selectedRowNum + ":it38::content") +
                                   "').value = '" + poLineNumber.intValue() + "'");
                }


                //Quantity
                if (quantity != null) {
                    quantity = quantity.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    erks.addScript(fctx,
                                   "if(" +
                                   getJavascriptStringEmptyCheckExpressionStr("pt1:t1:" + selectedRowNum +
                                                                              ":it41::content") + " || " +
                                   getJavascriptStringValueCheckExpressionStr("pt1:t1:" + selectedRowNum +
                                                                              ":it41::content", "0") + " ) {" +
                                   getJavascriptElementSetValueExpressionStr("pt1:t1:" + selectedRowNum +
                                                                             ":it41::content",
                                                                             "'" + quantity.doubleValue() + "'") + "}");
                }

                //UOM
                /*if(uom!=null) {
                     erks.addScript(fctx,
                        "if("+ getJavascriptStringEmptyCheckExpressionStr( "pt1:t1:"+selectedRowNum+":it42::content" ) + ") {" +
                               getJavascriptElementSetValueExpressionStr(  "pt1:t1:"+selectedRowNum+":it42::content", "'"+uom+"'") +
                        "}"
                     );
                 }*/
                if (uom != null) {
                    erks.addScript(fctx,
                                   getJavascriptElementSetValueExpressionStr("pt1:t1:" + selectedRowNum +
                                                                             ":it42::content", "'" + uom + "'"));
                }


                //Unit Price
                /*if(unitPrice!=null) {
                     unitPrice = unitPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                     erks.addScript(fctx,
                        "if("+ getJavascriptStringEmptyCheckExpressionStr( "pt1:t1:"+selectedRowNum+":it6::content" ) + ") {" +
                               getJavascriptElementSetValueExpressionStr(  "pt1:t1:"+selectedRowNum+":it6::content", "'"+unitPrice.doubleValue()+"'") +
                        "}"
                     );
                 }*/
                if (unitPrice != null) {
                    unitPrice = unitPrice.setScale(5, BigDecimal.ROUND_HALF_EVEN);
                    erks.addScript(fctx,
                                   getJavascriptElementSetValueExpressionStr("pt1:t1:" + selectedRowNum +
                                                                             ":it6::content",
                                                                             "'" + unitPrice.doubleValue() + "'"));
                }


                //Line Description
                if (lineDesctiption != null) {
                    erks.addScript(fctx,
                                   "if(" +
                                   getJavascriptStringEmptyCheckExpressionStr("pt1:t1:" + selectedRowNum +
                                                                              ":it39::content") + ") {" +
                                   getJavascriptElementSetValueExpressionStr("pt1:t1:" + selectedRowNum +
                                                                             ":it39::content",
                                                                             "'" + lineDesctiption + "'") + "}");
                }

                //Tax Rate Code
                if (taxRateCode != null) {
                    erks.addScript(fctx,
                                   getJavascriptElementSetValueExpressionStr("pt1:t1:" + selectedRowNum +
                                                                             ":it5::content", "'" + taxRateCode + "'"));
                }


                //Line Total
                if (unitPrice != null) {
                    //double lineTotal = quantity.doubleValue()*unitPrice.doubleValue();
                    //erks.addScript(fctx, "document.getElementById('" + ("pt1:t1:"+selectedRowNum+":it34::content") + "').value = parseFloat('"+ lineTotal +"').toFixed(2)");

                    String quantityValue = "pt1:t1:" + selectedRowNum + ":it41::content";
                    String unitPriceValue = "pt1:t1:" + selectedRowNum + ":it6::content";

                    String lineTotalAmount = "pt1:t1:" + selectedRowNum + ":it34::content";
                    erks.addScript(fctx,
                                   "if(!" + getJavascriptIsNaNExpressionStr(quantityValue) + " && !" +
                                   getJavascriptIsNaNExpressionStr(unitPriceValue) + ") { " +
                                   " document.getElementById('" + lineTotalAmount +
                                   "').value = (parseFloat(document.getElementById('" + quantityValue +
                                   "').value) * parseFloat(document.getElementById('" + unitPriceValue +
                                   "').value)).toFixed(2);" + "}");

                    //                     System.out.println(
                    //                         "if(!"+getJavascriptIsNaNExpressionStr(quantityValue)+" && !"+getJavascriptIsNaNExpressionStr(unitPriceValue)+") { " +
                    //                         " document.getElementById('"+lineTotalAmount+"').value = (parseFloat(document.getElementById('"+quantityValue+"').value) * parseFloat(document.getElementById('" + unitPriceValue + "').value)).toFixed(2);" +
                    //                         "}");


                    if (taxAmount != null) {
                        double calculatedTaxAmount = taxAmount.doubleValue() * 0.01;
                        //erks.addScript(fctx, "document.getElementById('" + ("pt1:t1:"+selectedRowNum+":ot7::content") + "').value = parseFloat('"+ taxAmount +"').toFixed(2)");


                        String script =
                            "if( !isNaN(parseFloat(document.getElementById('" + lineTotalAmount + "').value)) && " +
                            calculatedTaxAmount + ">=0.0) { " + "    document.getElementById('" + "pt1:t1:" +
                            selectedRowNum + ":ot7::content" + "').value = (parseFloat(document.getElementById('" +
                            lineTotalAmount + "').value) * " + calculatedTaxAmount + ").toFixed(2)" + "}";

                        erks.addScript(fctx, script);

                    }
                }


                erks.addScript(fctx,
                               "document.getElementById('" + "pt1:t1:" + selectedRowNum + ":it38::content" +
                               "').focus();");
                erks.addScript(fctx,
                               "AdfActionEvent.queue(AdfPage.PAGE.findComponentByAbsoluteId('" + "pt1:t1:" +
                               selectedRowNum + ":it38" + "'), true);");

                //erks.addScript(fctx, "document.getElementById('"+"pt1:t1:"+selectedRowNum+":it36::content"+"').value = document.getElementById('"+"pt1:t1:"+selectedRowNum+":it36::content"+"').value");


            }

            AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
            p8.hide();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lineItemRSIter != null) {
                try {
                    lineItemRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
            if (empRSIter != null) {
                try {
                    empRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        System.out.println("End selectPOLineNumPopup");
    }

    public void setBpmTaskAcquiredByUserIdIt(RichInputText bpmTaskAcquiredByUserIdIt) {
        this.bpmTaskAcquiredByUserIdIt = bpmTaskAcquiredByUserIdIt;
    }

    public RichInputText getBpmTaskAcquiredByUserIdIt() {
        return bpmTaskAcquiredByUserIdIt;
    }

    public void setApOperationPageForm(RichForm apOperationPageForm) {
        this.apOperationPageForm = apOperationPageForm;
    }

    public RichForm getApOperationPageForm() {
        return apOperationPageForm;
    }

    public void setMatchButton(RichCommandButton matchButton) {
        this.matchButton = matchButton;
    }

    public RichCommandButton getMatchButton() {
        return matchButton;
    }

    public void setNotifyButton(RichCommandButton notifyButton) {
        this.notifyButton = notifyButton;
    }

    public RichCommandButton getNotifyButton() {
        return notifyButton;
    }

    public void setSaveButton(RichCommandButton saveButton) {
        this.saveButton = saveButton;
    }

    public RichCommandButton getSaveButton() {
        return saveButton;
    }

    public void setSubmitButton(RichCommandButton submitButton) {
        this.submitButton = submitButton;
    }

    public RichCommandButton getSubmitButton() {
        return submitButton;
    }

    public void setSupplierID(RichInputText supplierID) {
        this.supplierID = supplierID;
    }

    public RichInputText getSupplierID() {
        return supplierID;
    }

    private String modifyEmail(String emailString) {
        String supplierName = null;
        String siteId = null;
        String invoiceNum = null;
        if (supNameIt.getValue() != null) {
            supplierName = supNameIt.getValue().toString();
            if (emailString.contains("&SupplierName")) {
                emailString = emailString.replaceAll("&SupplierName", supplierName);
            }
        }


        if (siteIdIt.getValue() != null) {
            siteId = siteIdIt.getValue().toString();
            //System.out.println("site id :" + siteId );
            if (emailString.contains("&SiteID")) {
                emailString = emailString.replaceAll("&SiteID", siteId);
            }
        }
        if (invNumIt.getValue() != null) {
            invoiceNum = invNumIt.getValue().toString();
            System.out.println("ivoice Number " + invoiceNum);
            if (emailString.contains("&InvoiceNum")) {
                emailString = emailString.replaceAll("&InvoiceNum", invoiceNum);
            }
        }
        System.out.println("Modified Email Body : " + emailString);
        return emailString;
    }

    public void cancelMailAction(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start: cancelMailAction");

        emailPopup.hide();

        System.out.println("End: cancelMailAction");

    }

    public void setEmailBcc(String emailBcc) {
        String oldEmailBcc = this.emailBcc;
        this.emailBcc = emailBcc;
        propertyChangeSupport.firePropertyChange("emailBcc", oldEmailBcc, emailBcc);
    }

    public String getEmailBcc() {
        return emailBcc;
    }

    private String setEmailLink(String body) {
        String bodyPart = null;
        String documentId = null;
        if (documentIdIt.getValue() != null)
            documentId = documentIdIt.getValue().toString();
        System.out.println("document id in setEmailLink ::: " + documentId);
        if (body != null && body.contains("Click here")) {
            /*  int index = body.indexOf("Click here");
            bodyPart = body.substring(index, body.length());
            System.out.println("body part :: "+ bodyPart); */
            body =
                body.replace("Click here",
                             "<a href=\"" +
                             resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGE_URL_ADF']}")
                             .toString() + documentId + "\">Click here</a>");
        }
        System.out.println("body in setEmailLink :: " + body);
        return body;
    }

    public void setDocumentIdIt(RichInputText documentIdIt) {
        this.documentIdIt = documentIdIt;
    }

    public RichInputText getDocumentIdIt() {
        return documentIdIt;
    }

    public void restrict2DigitsAfterDecimal(FacesContext facesContext, UIComponent uIComponent, Object object) {
        oracle.jbo.domain.Number value = (oracle.jbo.domain.Number) object;
        String str = value.toString();
        System.out.println(str);
        if (str.indexOf(".") != -1 && (str.length() - str.indexOf(".") > 2)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                          "Enter Only Numbers (with maximum 2 digits after decimal place)",
                                                          null));
        }
    }

    public void onDescriptionPopupOKClick(ActionEvent actionEvent) {
        System.out.println("Start onDescriptionPopupOKClick");
        DCBindingContainer bindings = getBinding();
        DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        //System.out.println("lineItemIter ::"+lineItemIter);
        ViewObject empVO = lineItemIter.getViewObject();
        Row selectedRow = empVO.getCurrentRow();
        //System.out.println("selectedRow :: "+selectedRow);
        if (selectedRow != null) {
            //System.out.println("**  Indise if ***");
            String descVal = null;
            try {
                if (descPopupIt.getValue() != null)
                    descVal = descPopupIt.getValue().toString();
                //System.out.println("Description PopupIt: "+descPopupIt);
                selectedRow.setAttribute("LineDescription", descVal);
                //                                    commentsIt.setValue(descVal);
                descPopup.hide();
                AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        System.out.println("End onDescriptionPopupOKClick");
    }


    private DCBindingContainer getBinding() {
        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer bindings = (DCBindingContainer) bc.getCurrentBindingsEntry();
        return bindings;
    }

    public void setDescPopupIt(RichInputText descPopupIt) {
        this.descPopupIt = descPopupIt;
    }

    public RichInputText getDescPopupIt() {
        return descPopupIt;
    }

    public void setDescPopup(RichPopup descPopup) {
        this.descPopup = descPopup;
    }

    public RichPopup getDescPopup() {
        return descPopup;
    }

    public void onDescClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start onDescClick");
        String commentsVal = null;
        DCBindingContainer bindings = getBinding();
        DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        //System.out.println("lineItemIter ::"+lineItemIter);
        ViewObject empVO = lineItemIter.getViewObject();
        Row selectedRow = empVO.getCurrentRow();
        //System.out.println("selectedRow :: "+selectedRow);
        if (selectedRow != null) {
            try {
                if (selectedRow.getAttribute("LineDescription") != null)
                    commentsVal = selectedRow.getAttribute("LineDescription").toString();
                //System.out.println("commentsVal****: "+commentsVal);
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                descPopupIt.setValue(commentsVal);
                AdfFacesContext.getCurrentInstance().addPartialTarget(descPopupIt);
                descPopup.show(hints);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("End onDescClick");
    }

    public void onCommentsTableDescClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start onCommentsTableDescClick");
        String commentsVal = null;
        DCBindingContainer bindings = getBinding();
        DCIteratorBinding commentsTableIter = bindings.findIteratorBinding("ApCommentsTableVO1Iterator");
        //System.out.println("commentsTableIter ::"+commentsTableIter);
        ViewObject commentsVO = commentsTableIter.getViewObject();
        Row selectedRow = commentsVO.getCurrentRow();
        System.out.println("selectedRow :: " + selectedRow);
        if (selectedRow != null) {
            try {
                if (selectedRow.getAttribute("Description") != null)
                    commentsVal = selectedRow.getAttribute("Description").toString();
                System.out.println("commentsVal****: " + commentsVal);
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                apCommentsTableDescPopUpIt.setValue(commentsVal);
                AdfFacesContext.getCurrentInstance().addPartialTarget(apCommentsTableDescPopUpIt);
                apCommentsTableDescPopup.show(hints);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("End onCommentsTableDescClick");
    }

    public void calculateLineTotalfromQuantity(ValueChangeEvent valueChangeEvent) {
        System.out.println("Within calculateLineTotalfromQuantity");
        /*System.out.println("valueChangeEvent.getNewValue()"+valueChangeEvent.getNewValue());
        System.out.println("valueChangeEvent.getOldValue()"+valueChangeEvent.getOldValue());  */

        String currencyCode = null;
        currencyCode = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;
        System.out.println("calculateLineTotalfromQuantity currencyCode" + currencyCode);

        DCBindingContainer bindings = getBinding();
        DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObject empVO = lineItemIter.getViewObject();
		int count = empVO.getRowCount();
        System.out.println("Table Row Index Quantity : " + lineDetailsTable.getRowIndex());
        int index = lineDetailsTable.getRowIndex();
//        Row selectedRow = empVO.getCurrentRow();
        Row selectedRow = getCustomCurrentRow();
        oracle.jbo.domain.Number line_total = null;
        double quantity = 0;
        double unitPrice = 0;
        double lineTot = 0;
		String stringUnitPrice = null;
        if (selectedRow != null) {
            System.out.println("selectedRow :: " + selectedRow);
            //        if(selectedRow.getAttribute("TaxRateCode")!=null){
            //        System.out.println("Tax Rate code from calculateLineTotalFromQuantity"+selectedRow.getAttribute("TaxRateCode"));
            //        }
//System.out.println("Count : " + index + " Invoice Type : " + invoiceTypeSoc.getValue().toString());
            if (invoiceTypeSoc.getValue()
                              .toString()
                              .equalsIgnoreCase("PO Invoice") && tempUnitPrice != null) {
                tempQuantity = valueChangeEvent.getNewValue().toString();
                System.out.println("Enter Po Loop");
                stringUnitPrice = tempUnitPrice;
            } else {
                try {
                    stringUnitPrice =
                        selectedRow.getAttribute("UnitPrice").toString() != null ?
                        selectedRow.getAttribute("UnitPrice").toString() : null;
                } catch (Exception e) {
                    stringUnitPrice = null;
                    System.out.println("Exception : " + e.getMessage());
                }
            }
            System.out.println("Quantity : " + tempQuantity+" UnitPrice : "+stringUnitPrice);
            //System.out.println("UnitPrice : " + stringUnitPrice);
            try {
                if (valueChangeEvent.getNewValue() != null && stringUnitPrice != null) {
                    System.out.println("Quantity****" + selectedRow.getAttribute("Quantity"));
                    //                    quantity=Long.parseLong(selectedRow.getAttribute("Quantity").toString());
                    quantity = Double.parseDouble(valueChangeEvent.getNewValue().toString());
                    System.out.println("UnitPrice****" + selectedRow.getAttribute("UnitPrice"));
                    // unitPrice = Double.parseDouble(selectedRow.getAttribute("UnitPrice").toString());
					unitPrice = Double.parseDouble(stringUnitPrice);
                    lineTot = quantity * unitPrice;
                    System.out.println("lineTot*******" + lineTot);
                    line_total = new oracle.jbo.domain.Number(lineTot);
                    System.out.println("line_total**************" + line_total);
                    //selectedRow.setAttribute("LineTotalAmount",line_total);

                    //                    if(currencyCode == null || (currencyCode!=null && currencyCode.trim().equals(""))){
                    //                       // throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter currency Code",null));
                    //
                    //                    }else{
//                    System.out.println("Calling round amount func from QUANTITY value change");
                    roundAmount(currencyCode, Double.toString(lineTot), "LineTotalAmount");

                    //                    BigDecimal decimalValue = new BigDecimal(line_total.doubleValue());
                    //                    decimalValue = decimalValue.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    //                    selectedRow.setAttribute("LineTotalAmount",new oracle.jbo.domain.Number(decimalValue.doubleValue()));

                    getCalculatedTaxAmountFromEBS(Double.toString(lineTot), "LineTotal");
                    //calculateTaxAmount(lineTot);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(lineTotal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(sumOfTaxTotal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(sumOfLineTotal);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (index!=0 && invoiceTypeSoc.getValue().toString().equalsIgnoreCase("PO Invoice")){
                tempQuantity = null;
                tempUnitPrice = null;
//                tempTaxRateCode=null;
        }
        System.out.println("End calculateLineTotalfromQuantity");
    }

    public void calculateLineTotlFromUnit(ValueChangeEvent valueChangeEvent) {
        System.out.println("Within calculateLineTotlFromUnit");
        DCBindingContainer bindings = getBinding();
        DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObject empVO = lineItemIter.getViewObject();
int count = empVO.getRowCount();
        System.out.println("Table Row Index UnitPrice : " + lineDetailsTable.getRowIndex());
        int index = lineDetailsTable.getRowIndex();
//        Row selectedRow = empVO.getCurrentRow();
        Row selectedRow = getCustomCurrentRow();
        oracle.jbo.domain.Number line_total = null;
        double quantity = 0;
        double unitPrice = 0;
        double lineTot = 0;
        String currencyCode = null;
String stringQuantity = null;
        currencyCode = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;
        System.out.println("calculateLineTotlFromUnit currencyCode" + currencyCode);

        if (selectedRow != null) {
            System.out.println("selectedRow :: " + selectedRow);
            //        if(selectedRow.getAttribute("TaxRateCode")!=null){
            //        System.out.println("Tax Rate code from calculateLineTotlFromUnit"+selectedRow.getAttribute("TaxRateCode"));
            //        }
 System.out.println("Count : " + index + " Invoice Type : " + invoiceTypeSoc.getValue().toString());
            if (invoiceTypeSoc.getValue()
                              .toString()
                              .equalsIgnoreCase("PO Invoice") && tempQuantity != null) {
                tempUnitPrice = valueChangeEvent.getNewValue().toString();
                System.out.println("Enter Po Loop");
                stringQuantity = tempQuantity;
            } else {
                try {
                    stringQuantity =
                        selectedRow.getAttribute("Quantity").toString() != null ?
                        selectedRow.getAttribute("Quantity").toString() : null;
                } catch (Exception e) {
                    stringQuantity = null;
                    System.out.println("Exception : " + e.getMessage());
                }
            }
            System.out.println("Quantity : " + stringQuantity+" UnitPrice : "+tempUnitPrice);
            //System.out.println("UnitPrice : " + tempUnitPrice);
            try {
                if (valueChangeEvent.getNewValue() != null && stringQuantity != null) {
                    //                    if(selectedRow.getAttribute("Quantity")!=null && selectedRow.getAttribute("UnitPrice")!=null){
                    System.out.println("Quantity****" + selectedRow.getAttribute("Quantity"));
                    System.out.println("UnitPrice****" + selectedRow.getAttribute("UnitPrice"));
                   // quantity = Double.parseDouble(selectedRow.getAttribute("Quantity").toString());
					quantity = Double.parseDouble(stringQuantity);
                    unitPrice = Double.parseDouble(valueChangeEvent.getNewValue().toString());
                    lineTot = quantity * unitPrice;
                    System.out.println("lineTot*******" + lineTot);
                    line_total = new oracle.jbo.domain.Number(lineTot);
                    System.out.println("line_total**************" + line_total);

                    //selectedRow.setAttribute("LineTotalAmount",line_total);


                    //                        if(currencyCode == null || (currencyCode!=null && currencyCode.trim().equals(""))){
                    //                            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter currency Code",null));
                    //
                    //                        }else{
                    //System.out.println("Calling round amount func from QUANTITY value change");
                    roundAmount(currencyCode, Double.toString(lineTot), "LineTotalAmount");
                    //  }
                    //                    BigDecimal decimalValue = new BigDecimal(line_total.doubleValue());
                    //                    decimalValue = decimalValue.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    //                    selectedRow.setAttribute("LineTotalAmount",new oracle.jbo.domain.Number(decimalValue.doubleValue()));
                    //


                    //calculateTaxAmount(lineTot);

                    getCalculatedTaxAmountFromEBS(Double.toString(lineTot), "LineTotal");
                    AdfFacesContext.getCurrentInstance().addPartialTarget(lineTotal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(sumOfTaxTotal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(sumOfLineTotal);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (index!=0 && invoiceTypeSoc.getValue().toString().equalsIgnoreCase("PO Invoice")){
                tempQuantity = null;
                tempUnitPrice = null;
//                tempTaxRateCode=null;
        }
        System.out.println("End calculateLineTotlFromUnit");
    }

    public void calculateTaxAmountFromLineTot(ValueChangeEvent valueChangeEvent) {

        System.out.println("inside line total value change listener");
        double lineTotalVar = 0;
        //        double sum = 0.0;
        DecimalFormat df = new DecimalFormat("#0.00");
        //        double lineTotalVarOldValue = 0.0;
        //        if(lineTotalSum.getValue()!=null)
        //        sum = Double.parseDouble(lineTotalSum.getValue().toString());

        //        if(valueChangeEvent.getOldValue()!=null)
        //        lineTotalVarOldValue = Double.parseDouble(valueChangeEvent.getOldValue().toString());

        if (valueChangeEvent.getNewValue() != null) {
            lineTotalVar = Double.parseDouble(valueChangeEvent.getNewValue().toString());
            //        sum -= lineTotalVarOldValue;
            //        sum += lineTotalVar;
            //        lineTotalSum.setValue(df.format(sum));
            //        System.out.println("lineTotalVarOldValue"+lineTotalVarOldValue);
            //        System.out.println("Sum of line total----"+sum);
            System.out.println("lineTotalVar****" + lineTotalVar);
            //calculateTaxAmount(lineTotalVar);
            getCalculatedTaxAmountFromEBS(valueChangeEvent.getNewValue().toString(), "LineTotal");

        }
        //        else if(valueChangeEvent.getNewValue()==null){
        //
        //            sum -= lineTotalVarOldValue;
        //            lineTotalSum.setValue(df.format(sum));
        //            System.out.println("lineTotalVarOldValue when new value null" + lineTotalVarOldValue);
        //
        //        }
    }

    private void calculateTaxAmount(double lineTotal) {
        oracle.jbo.domain.Number taxRateLineItem = null;
        double lineTot = 0;
        double taxRatecal = 0;
        String linePoNumber = null;
        String taxRateCode = null;

        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer bindings = (DCBindingContainer) bc.getCurrentBindingsEntry();
        DCIteratorBinding glIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        System.out.println("glIter ::" + glIter);
        ViewObject lineItemVO = glIter.getViewObject();
        Row selectedRow = lineItemVO.getCurrentRow();
        //System.out.println("selectedRow :: "+selectedRow);

        linePoNumber = linePoNumber == null ? "" : linePoNumber.trim();
        taxRateCode = AdfFacesContext.getCurrentInstance()
                                     .getPageFlowScope()
                                     .get("TaxRateCodePS") == null ? null : AdfFacesContext.getCurrentInstance()
                                                                                           .getPageFlowScope()
                                                                                           .get("TaxRateCodePS")
                                                                                           .toString();
        //System.out.println("b4 if taxRateCode*******"+taxRateCode);
        if (taxRateCode != null) {
            System.out.println("taxRateCode*******" + taxRateCode);
            System.out.println("linePoNumber*******" + linePoNumber);
        }
        String invoiceType = (String) invoiceTypeSoc.getValue();
        invoiceType = invoiceType == null ? "" : invoiceType.trim();
        String poNumber = (String) poNumIt.getValue();
        poNumber = poNumber == null ? "" : poNumber.trim();
        String siteId = null;
        if (siteIdIt.getValue() != null) {
            //           siteId = ""+((oracle.jbo.domain.Number)siteIdIt.getValue()).getValue();
            siteId = "" + siteIdIt.getValue().toString();
        }
        siteId = siteId == null ? "" : siteId.trim();
        boolean flag = false;

        if (searchTaxRateCodeLookupVO(invoiceType, siteId, poNumber, linePoNumber, taxRateCode, flag)) {
            lineTot = lineTotal;
            System.out.println("in search tax rate**" + AdfFacesContext.getCurrentInstance()
                                                                       .getPageFlowScope()
                                                                       .get("taxRate"));
            if ((AdfFacesContext.getCurrentInstance()
                                .getPageFlowScope()
                                .get("taxRate")) != null) {
                try {
                    taxRatecal = Double.parseDouble((AdfFacesContext.getCurrentInstance()
                                                                    .getPageFlowScope()
                                                                    .get("taxRate")).toString());
                    taxRatecal = (lineTot * taxRatecal) / 100;
                    //System.out.println("taxRatecal*******"+taxRatecal);
                    taxRateLineItem = new oracle.jbo.domain.Number(taxRatecal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("taxRateLineItem**************" + taxRateLineItem);
                if (taxRateLineItem != null) {

                    BigDecimal decimalValue = new BigDecimal(taxRateLineItem.doubleValue());
                    decimalValue = decimalValue.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    try {
                        selectedRow.setAttribute("TaxAmountLineitem",
                                                 new oracle.jbo.domain.Number(decimalValue.doubleValue()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    //selectedRow.setAttribute("Attr1",taxRateLineItem);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(taxAmountLine);
                }
            }
        }
    }

    public void calculateTaxAmountFromTaxRateCode(ValueChangeEvent valueChangeEvent) {

        System.out.println("Within calculateTaxAmountFromTaxRateCode**");
        if (valueChangeEvent.getNewValue() != null)
            getCalculatedTaxAmountFromEBS(valueChangeEvent.getNewValue().toString(), "Tax");

        /* String taxRateCode =null;
        if(valueChangeEvent.getNewValue()!=null){
        taxRateCode=valueChangeEvent.getNewValue().toString();
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("TaxRateCodePS", taxRateCode);
            getCalculatedTaxAmountFromEBS(valueChangeEvent.getNewValue().toString(),"Tax");
        }
//        else{
//        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("TaxRateCodePS", null);
//        }
        System.out.println("TaxRateCodePS calculateTaxAmountFromTaxRateCode"+AdfFacesContext.getCurrentInstance().getPageFlowScope().get("TaxRateCodePS"));*/
        //        calculateTaxAmount(lineTotalVar);
    }

    public void setLineTotal(RichInputText lineTotal) {
        this.lineTotal = lineTotal;
    }

    public RichInputText getLineTotal() {
        return lineTotal;
    }

    public void setTaxRateCodeLine(RichInputText taxRateCodeLine) {
        this.taxRateCodeLine = taxRateCodeLine;
    }

    public RichInputText getTaxRateCodeLine() {
        return taxRateCodeLine;
    }

    public void setTaxAmountLine(RichInputText taxAmountLine) {
        this.taxAmountLine = taxAmountLine;
    }

    public RichInputText getTaxAmountLine() {
        return taxAmountLine;
    }

    public void setSiteLOVSoc(RichSelectOneChoice siteLOVSoc) {
        this.siteLOVSoc = siteLOVSoc;
    }

    public RichSelectOneChoice getSiteLOVSoc() {
        return siteLOVSoc;
    }

    public void setReasonSoc(RichSelectOneChoice reasonSoc) {
        this.reasonSoc = reasonSoc;
    }

    public RichSelectOneChoice getReasonSoc() {
        return reasonSoc;
    }

    public void setReasonTypeSoc(RichSelectOneChoice reasonTypeSoc) {
        this.reasonTypeSoc = reasonTypeSoc;
    }

    public RichSelectOneChoice getReasonTypeSoc() {
        return reasonTypeSoc;
    }

    public void setAddRowIcon(RichCommandImageLink addRowIcon) {
        this.addRowIcon = addRowIcon;
    }

    public RichCommandImageLink getAddRowIcon() {
        return addRowIcon;
    }

    public void setDeleteRowIcon(RichCommandImageLink deleteRowIcon) {
        this.deleteRowIcon = deleteRowIcon;
    }

    public RichCommandImageLink getDeleteRowIcon() {
        return deleteRowIcon;
    }


    public void taxRateCodeValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {

        //        if(object.toString()!=null){
        if (object.toString().length() > 0) {
            String taxRateCode = object.toString();
            String linePoNumber = null;

            UIComponent poNumComponent = ComponentUtils.findRelativeComponent(uIComponent, "it35");
            linePoNumber =
                ((RichInputText) poNumComponent).getValue() != null ?
                ((RichInputText) poNumComponent).getValue().toString() : "";
            System.out.println("----- linePoNumber ----- " + linePoNumber);
            //System.out.println(uIComponent.getClientId(facesContext)+" --- "+poNumComponent.getClientId(facesContext));

            /*
                RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();  //Save currently selected row
//                Iterator rowKeySetIt = rowKeySet.iterator();
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
                DCIteratorBinding lineItemIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");
                RowSetIterator lineItemRSIter = lineItemIter.getViewObject().createRowSetIterator(null);
//                while(rowKeySetIt.hasNext()){
//                   Key key = (Key)((List)rowKeySetIt.next()).get(0);
//                   Row currentRow = lineItemRSIter.getRow(key);
//                     if(currentRow!=null) {
//                        System.out.println("----- TaxRateCode ----- "+taxRateCode);
//                         System.out.println("----- LinePoNum ----- "+currentRow.getAttribute("LinePoNum"));
//                        linePoNumber = currentRow.getAttribute("LinePoNum")==null?"":currentRow.getAttribute("LinePoNum").toString().trim();
//                        //taxRateCode = currentRow.getAttribute("TaxRateCode")==null?"":currentRow.getAttribute("TaxRateCode").toString().trim();
//                     }
//                 }


                System.out.println("ROW SET ITERATOR");
                while(lineItemRSIter.hasNext()) {
                    Row currentRow = lineItemRSIter.next();
                    System.out.println(currentRow.getAttribute("LineNumber")==null?"":currentRow.getAttribute("LineNumber").toString().trim());
                    System.out.println(currentRow.getAttribute("LinePoNum")==null?"":currentRow.getAttribute("LinePoNum").toString().trim());
                    System.out.println(currentRow.getAttribute("TaxRateCode")==null?"":currentRow.getAttribute("TaxRateCode").toString().trim());
                    String taxRateCode_CurrentRow = currentRow.getAttribute("TaxRateCode")==null?"":currentRow.getAttribute("TaxRateCode").toString().trim();
                    String linePoNumber_CurrentRow = currentRow.getAttribute("LinePoNum")==null?"":currentRow.getAttribute("LinePoNum").toString().trim();
                    if(taxRateCode_CurrentRow.equalsIgnoreCase(taxRateCode)) {
                        linePoNumber = linePoNumber_CurrentRow;
                        System.out.println("\tTax Rate Code match");
                        break;
                    }

                }

            //EXPERIMENTAL CODE START

            String componentId = uIComponent.getClientId(facesContext);
            String parentComponentId = uIComponent.getParent().getClientId(facesContext);
            System.out.println("----- taxRateCodeValidator ----- componentId : "+componentId+", "+uIComponent.getClass());
            System.out.println("----- taxRateCodeValidator ----- parent componentId : "+parentComponentId+", "+ uIComponent.getParent().getClass());
            ArrayList<String> childrenComponentId = new ArrayList<String>();


            System.out.println("----- taxRateCodeValidator ----- parent parent componentId : "+uIComponent.getParent().getParent().getClientId(facesContext)+", "+uIComponent.getParent().getParent().getClientId(facesContext).getClass());
            System.out.println("----- taxRateCodeValidator ----- parent parent parent componentId : "+uIComponent.getParent().getParent().getParent().getClientId(facesContext)+", "+uIComponent.getParent().getParent().getParent().getClientId(facesContext).getClass());


            String componentID_poNum = ("pt1:t1:" + componentId.split(":")[2] + ":it35");


            try {
                System.out.println(ComponentUtils.findRelativeComponent(uIComponent, "it35"));

                System.out.println( "-----" + getUIComponent("pt1:t1:0:it35") );


            } catch(Exception ex) {
                ex.printStackTrace();
            }

            /*

            //Load table data into map



            try {

              DCIteratorBinding  _tableIteratorBinding  =  ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");

              RowSetIterator _rRowSetIterator = _tableIteratorBinding.getRowSetIterator();

              ArrayList<Row> allRows = new ArrayList<Row>();

              for (int i=0 ; i<_tableIteratorBinding.getViewObject().getRowCountInRange(); i++ ) {
              Row row = (Row)_tableIteratorBinding.getRowAtRangeIndex(i);
                  allRows.add(row);

                  System.out.println("---row added");
              }

//              while(_rRowSetIterator.hasNext()) {
//                  System.out.println("---row added");
//                  Row row = _rRowSetIterator.next();
//                  allRows.add(row);
//              }

              for(int i=0; i<allRows.size(); i++) {
                  Row row = allRows.get(i);
                  System.out.println("---row---"+i);
                  _rRowSetIterator.setCurrentRow(row);


                  UIComponent poNumComp = ((RichColumn)lineDetailsTable.getChildren().get(1)).getChildren().get(0).getChildren().get(0);

                  System.out.println("\t\t\t----- poNumComp : "+poNumComp.getClientId(facesContext)+", "+poNumComp.getClass());


            //                       for(UIComponent uc : lineDetailsTable.getChildren()) {
            //                        System.out.println( uc.getClientId(facesContext) + " >> " + uc.getClass());
            //
            //                           RichColumn rc = (RichColumn)uc;
            //
            //                           for(UIComponent uc_ : rc.getChildren()) {
            //                               System.out.println( "\t" + uc_.getClientId(facesContext) + " >> " + uc_.getClass());
            //
            //
            //                           }
            //                       }


              }


            } catch(Exception ex) {
              ex.printStackTrace();
            }

            lineDetailsTable.setSelectedRowKeys(rowKeySet);
            //EXPERIMENTAL CODE END*/

            linePoNumber = linePoNumber == null ? "" : linePoNumber.trim();
            taxRateCode = taxRateCode == null ? "" : taxRateCode.trim();
            String invoiceType = (String) invoiceTypeSoc.getValue();

            invoiceType = invoiceType == null ? "" : invoiceType.trim();

            String poNumber = (String) poNumIt.getValue();

            poNumber = poNumber == null ? "" : poNumber.trim();

            String siteId = null;
            if (siteIdIt.getValue() != null && !(siteIdIt.getValue().equals(""))) {
                siteId = siteIdIt.getValue().toString();
            }


            siteId = siteId == null ? "" : siteId.trim();

            boolean valFlag =
                searchTaxRateCodeLookupVO(invoiceType, siteId, poNumber, linePoNumber, taxRateCode, false);
            System.out.println("Outside if case valflag ::: " + valFlag);
            if (valFlag) {
                //System.out.println("Inside if case valflag ::: "+ valFlag);
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding =
                    dcBindingContainer.findIteratorBinding("TaxRateCodeLookupVO1Iterator");
                ViewObjectImpl taxRateCodeLookupVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                // System.out.println("--- taxRateCodeLookupVO.getEstimatedRowCount() --- "+taxRateCodeLookupVO.getEstimatedRowCount());
                boolean flag = false;
                if (taxRateCodeLookupVO.getEstimatedRowCount() > 0) {
                    RowSetIterator rsi = null;
                    try {
                        rsi = taxRateCodeLookupVO.createRowSetIterator(null);
                        while (rsi.hasNext()) {

                            Row row = rsi.next();

                            if (row.getAttribute("TaxRateCode") != null &&
                                ((String) row.getAttribute("TaxRateCode")).equals(taxRateCode)) {
                                flag = true;
                                break;
                            }

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (rsi != null) {
                            try {
                                rsi.closeRowSetIterator();
                            } catch (Exception ex) {
                                ex.printStackTrace();

                            }
                        }
                    }
                }
                if (!flag) {
                    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                  "Please enter valid Tax Rate Code", null));
                }
            } else { //check from the tax-rate-code master list to decide if the taxratecode value is acceptable
                System.out.println("TaxRateCode else block");
                Iterator<String> it = PropertyLoader.getInstance()
                                                    .getTaxRatesMasterList()
                                                    .keySet()
                                                    .iterator();
                boolean flag = false;
                while (it.hasNext()) {
                    String trc = it.next();
                    if (trc != null && trc.trim().equalsIgnoreCase(taxRateCode)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                  "Please enter valid Tax Rate Code", null));
                }

            }
        }

    }


    public void lineItemsNavigationListener(RangeChangeEvent rangeChangeEvent) {
        //        FacesContext fctx = FacesContext.getCurrentInstance();
        //        ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
        //        erks.addScript(fctx, "document.getElementById('pt1:t1:0:it36::content').value = document.getElementById('pt1:t1:0:it36::content').value;");
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(lineTableOuterPgl);
    }


    // find a jsf component inside the JSF page
    private UIComponent getUIComponent(String name) {
        FacesContext facesCtx = FacesContext.getCurrentInstance();
        return facesCtx.getViewRoot().findComponent(name);
    }

    // find a UIComponent inside a UIComponent
    private UIComponent getUIComponent(UIComponent component, String name) {
        if (component != null)
            System.out.println(component.getId());

        List<UIComponent> items = component.getChildren();
        Iterator<UIComponent> facets = component.getFacetsAndChildren();

        if (items.size() > 0) {
            //System.out.println("got childern");
            for (UIComponent item : items) {
                UIComponent found = getUIComponent(item, name);
                if (found != null) {
                    return found;
                }
                if (item.getId().equalsIgnoreCase(name)) {
                    return item;
                }
            }
        } else if (facets.hasNext()) {
            //System.out.println("got facets");
            while (facets.hasNext()) {
                UIComponent facet = facets.next();
                UIComponent found = getUIComponent(facet, name);
                if (found != null) {
                    return found;
                }
                if (facet.getId().equalsIgnoreCase(name)) {
                    return facet;
                }
            }
        }
        return null;
    }


    public void setPropertyLoader(PropertyLoader propertyLoader) {
        this.propertyLoader = propertyLoader;
    }

    public PropertyLoader getPropertyLoader() {
        return propertyLoader;
    }

    public void setLineTotalSum(RichOutputText lineTotalSum) {
        this.lineTotalSum = lineTotalSum;
    }

    public RichOutputText getLineTotalSum() {
        return lineTotalSum;
    }

    public void setTaxAmountSum(RichOutputText taxAmountSum) {
        this.taxAmountSum = taxAmountSum;
    }

    public RichOutputText getTaxAmountSum() {
        return taxAmountSum;
    }

    //    public void calculateTaxAmountSum(ValueChangeEvent valueChangeEvent) {
    //        System.out.println("Inside calculateTaxAmountSum");
    //        double taxTotalVar=0;
    //        double sum = 0.0;
    //        double taxTotalVarOldValue = 0.0;
    //        DecimalFormat df = new DecimalFormat("#0.00");
    //
    //        if(taxAmountSum.getValue()!=null)
    //        sum = Double.parseDouble(taxAmountSum.getValue().toString());
    //
    //        if(valueChangeEvent.getOldValue()!=null)
    //        taxTotalVarOldValue = Double.parseDouble(valueChangeEvent.getOldValue().toString());
    //
    //
    //        if(valueChangeEvent.getNewValue()!=null){
    //                try {
    //                    taxTotalVar=Double.parseDouble(valueChangeEvent.getNewValue().toString());
    //                } catch(Exception e) {
    //                    taxTotalVar = 0;
    //                }
    //                sum -= taxTotalVarOldValue;
    //                sum += taxTotalVar;
    //                taxAmountSum.setValue(df.format(sum));
    //                System.out.println("taxTotalVarOldValue"+taxTotalVarOldValue);
    //                System.out.println("Sum of tax amount total----"+sum);
    //                System.out.println("sumTotalVar****"+taxTotalVar);
    //                }
    //
    //        else if(valueChangeEvent.getNewValue()==null){
    //
    //                    sum -= taxTotalVarOldValue;
    //                    taxAmountSum.setValue(df.format(sum));
    //                    System.out.println("taxTotalVarOldValue when new value null" + taxTotalVarOldValue);
    //        }
    //    }

    /*   public void recalculateLineAndTaxTotal() {

        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dciter = (DCIteratorBinding) bindings.get("LineItemDetailsEOView1Iterator");
        RowSetIterator rsi=null;
        double taxTotalAmount = 0;
        try{
            rsi = dciter.getRowSetIterator();



        while(rsi.hasNext()){
            Row nextRow = rsi.next();
            oracle.jbo.domain.Number taxAmount = nextRow.getAttribute("Attr1")==null ? null : (oracle.jbo.domain.Number)nextRow.getAttribute("Attr1");
            taxTotalAmount += (taxAmount == null ? 0.0 : taxAmount.doubleValue());
        }
        }catch(Exception e)
        {
            e.printStackTrace();
            }
        finally{
                    if(rsi!=null) {
                        try {
                            rsi.closeRowSetIterator();
                        } catch(Exception ex) {
                            ex.printStackTrace();

                    }
                    }
                }
        taxAmountSum.setValue(taxTotalAmount);
        System.out.println("taxTotalAmount : " + taxTotalAmount);
        AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);

    }*/
    public void setCertifierNameErrorOT(RichOutputText certifierNameErrorOT) {
        this.certifierNameErrorOT = certifierNameErrorOT;
    }

    public RichOutputText getCertifierNameErrorOT() {
        return certifierNameErrorOT;
    }

    public void certifierNamevalueChanged(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        System.out.println("executing certifiername value change listener");

        AdfFacesContext.getCurrentInstance()
                       .getPageFlowScope()
                       .put("certifierFlagInScope", 0);
        System.out.println("AdfFacesContext.getCurrentInstance().getPageFlowScope() setting" +
                           AdfFacesContext.getCurrentInstance()
                                                                                                              .getPageFlowScope()
                                                                                                              .get("certifierFlagInScope"));


        System.out.println("finishing certifiername value change listener");
    }

    public void setBpmStatus(RichInputText bpmStatus) {
        this.bpmStatus = bpmStatus;
    }

    public RichInputText getBpmStatus() {
        return bpmStatus;
    }

    public void onStatusChange(ValueChangeEvent valueChangeEvent) {
        System.out.println("inside onStatusChange valuechangelistener");
        if (!(statusSOC.getValue() == null || (statusSOC.getValue() != null && statusSOC.getValue().equals("")))) {

            bpmStatus.setValue(valueChangeEvent.getNewValue().toString());
            System.out.println("BPM Status :::" + bpmStatus.getValue());
            AdfFacesContext.getCurrentInstance().addPartialTarget(bpmStatus);
        }
    }

    protected void refreshPage() {

        FacesContext fc = FacesContext.getCurrentInstance();
        String refreshpage = fc.getViewRoot().getViewId();
        ViewHandler ViewH = fc.getApplication().getViewHandler();
        UIViewRoot UIV = ViewH.createView(fc, refreshpage);
        UIV.setViewId(refreshpage);
        fc.setViewRoot(UIV);
    }

    public void setSyncButton(RichCommandButton syncButton) {
        this.syncButton = syncButton;
    }

    public RichCommandButton getSyncButton() {
        return syncButton;
    }

    public void updateEcmFields() {
        System.out.println("Start updateEcmFields");
        //String userId = null;
        String suppName = null;
        String invoiceNum = null;
        String invoiceDate = null;
        String invoiceTotal = null;
        String poNumber = null;
        String siteId = null;
        String supplierNumber = null;
        String certifierName = null;
        String selectedStatus = null;
        String apGroupUserName = null;
        String freightVar = null;
        String aogVar = null;
        String currencyEquivalent = null;
        String whtAmount = null;
        String operatingUnitName = null;


        try {


            //supplier name
            suppName = supNameIt.getValue() != null ? supNameIt.getValue().toString() : null;
            System.out.println("----- Selected value for Supplier name : " + suppName);

            //invoice number
            invoiceNum = invNumIt.getValue() != null ? invNumIt.getValue().toString() : null;
            System.out.println("----- Selected value for invoiceNum : " + invoiceNum);

            //invoice date
            //                invoiceDate = invDateId.getValue()!= null ? invDateId.getValue().toString():null;
            //                System.out.println("----- Selected value for invoiceDate : "+invoiceDate);
            oracle.jbo.domain.Date invDate = null;
            if (invDateId.getValue() != null) {
                invDate = ((oracle.jbo.domain.Date) invDateId.getValue());
            }
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
            invoiceDate = DATE_FORMAT.format(invDate.getValue());
            //System.out.println("----- Selected value for invoice date in yyyy-MM-dd format : " + invoiceDate);

            SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat("dd/MM/yyyy");
            String invoiceDate2 = DATE_FORMAT2.format(invDate.getValue());
            //System.out.println("----- Selected value for invoice date in dd/MM/yyyy format : " + invoiceDate2);

            //invoice total
            invoiceTotal = headerTotIt.getValue() != null ? headerTotIt.getValue().toString() : null;
            //System.out.println("----- Selected value for invoiceTotal : "+invoiceTotal);

            //po number
            poNumber = poNumIt.getValue() != null ? poNumIt.getValue().toString() : null;
            //System.out.println("----- Selected value for poNumber : "+poNumber);

            //site id
            siteId = siteIdIt.getValue() != null ? siteIdIt.getValue().toString() : null;
            //System.out.println("----- Selected value for siteId : "+siteId);

            //operatingUnitName

            operatingUnitName = operatingUnitIt.getValue() != null ? operatingUnitIt.getValue().toString() : null;
            System.out.println("----- Selected value for operating unit : " + operatingUnitName);

            //supplier number
            supplierNumber = suppNumIt.getValue() != null ? suppNumIt.getValue().toString() : null;
            //System.out.println("----- Selected value for supplier number : "+supplierNumber);

            //certifier name
            certifierName = certNameIt.getValue() != null ? certNameIt.getValue().toString() : null;
            //System.out.println("----- Selected value for certifier name : "+certifierName);

            //Invoice Type
            String invoiceType = invoiceTypeSoc.getValue() != null ? invoiceTypeSoc.getValue().toString() : null;
            //System.out.println("----- Selected value for invoice type : "+invoiceType);


            /*start :Added on 28thFeb 2018(reasonTYPE TO BE included in ecm update)**/

            //reasonType Type
            /*String reasonType = reasonTypeSoc.getValue()!=null ? reasonTypeSoc.getValue().toString():null;
                System.out.println("----- Selected value for reasonType type to be updated in ecm : "+reasonType);*/

            String reasonType =
                (String) resolveExpression("#{bindings.InvalidReasonTypeId.selectedValue ne ' ' ? bindings.InvalidReasonTypeId.selectedValue.attributeValues[1] : ''}");
            //System.out.println("----Selected invalidreasontype to be updated in ecm 19th ---"+reasonType.toString());
            /*end : Added on 28thFeb 2018**/


            if (invoiceType.equalsIgnoreCase("PO Invoice")) {
                invoiceType = "PO";
            } else {
                invoiceType = "NO-PO";
            }

            //Currency
            String currency = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;
            System.out.println("----- Selected value for currency : " + currency);

            //Document type
            String documentType = docTypeSoc.getValue() != null ? docTypeSoc.getValue().toString() : null;
            System.out.println("----- Selected value for document type : " + documentType);
            if (documentType.equalsIgnoreCase("Credit Note")) {
                documentType = "CREDIT";
            } else {
                documentType = "INVOICE";
            }

            //Supplier ID
            String suppId = (String) ADFContext.getCurrent()
                                               .getPageFlowScope()
                                               .get("supplier_id_value");
            System.out.println("----- Selected value for Supplier ID : " + suppId);

            String invScanDat = null;
            invScanDat = ADFContext.getCurrent()
                                   .getPageFlowScope()
                                   .get("invoiceScanDate") != null ? (String) ADFContext.getCurrent()
                                                                                        .getPageFlowScope()
                                                                                        .get("invoiceScanDate") : null;
            System.out.println("----- Selected value for invScanDat : " + invScanDat);

            //due date

            System.out.println("----- Before calling calculateInvoiceDueDate invoiceDate: " + invoiceDate2);
            String dueDate = null;
            // dueDate = JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEPortClient.calculateInvoiceDueDate(suppId, siteId, invoiceDate,invScanDat);
            dueDate =
                JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEPortClient.calculateInvoiceDueDate(suppId, siteId, invoiceDate2,
                                                                                        invScanDat);

            System.out.println("Due date from webservice :: " + dueDate);
            java.util.Date dueDateEcm = null;
            String dueDateEcmStr = null;
            try {
                if (dueDate != null) {
                    dueDateEcm = DATE_FORMAT2.parse(dueDate);
                    dueDateEcmStr = DATE_FORMAT.format(dueDateEcm);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("----- Selected value for due date in ECM : " + dueDateEcmStr);

            //Status
            selectedStatus = (statusSOC.getValue() == null) ? "-1" : (String) statusSOC.getValue();
            System.out.println("-----Selected Status : " + selectedStatus);
            try {
                selectedStatus = PropertyLoader.getInstance()
                                               .getInternalStatusMap()
                                               .get(Long.parseLong(selectedStatus));
                System.out.println("-----Selected Status value : " + selectedStatus);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("----- Selected value for internal Status : " + selectedStatus);

            //Org ID
            ApplicationModule am = null;
            RowSetIterator rowIt = null;
            String orgId = null;
            BigDecimal org_Id = null;
            String amDef = "model.EbsAM";
            String config = "EbsAMLocal";
            am = Configuration.createRootApplicationModule(amDef, config);
            EbsAMImpl amImpl;
            amImpl = (EbsAMImpl) am;
            ViewObjectImpl suppNameVO = amImpl.getSitesVO1();
            ViewCriteria viewCrit = suppNameVO.getViewCriteria("SitesVOCriteriaSupNameSiteID");
            suppNameVO.applyViewCriteria(viewCrit);
            suppNameVO.setNamedWhereClauseParam("bindVendorName", suppName);
            suppNameVO.setNamedWhereClauseParam("bvSiteID", siteId);
            suppNameVO.executeQuery();
            if (suppNameVO.getEstimatedRowCount() > 0) {
                /*System.out.println("--- Match found for Supplier Name : " +
                                       suppNameVO.getEstimatedRowCount() +
                                       " records.");*/
                rowIt = suppNameVO.createRowSetIterator(null);
                while (rowIt.hasNext()) {
                    Row rowData = rowIt.next();
                    try {
                        //System.out.println("--- Matched Supplier Number : " +rowData.getAttribute("VendorNumber"));

                        //orgId = rowData.getAttribute("OrgId") == null ? null :(String)rowData.getAttribute("OrgId");

                        org_Id =
                            rowData.getAttribute("OrgId") == null ? null : (BigDecimal) rowData.getAttribute("OrgId");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("orgId ::: " + orgId);
            if (rowIt != null) {
                try {
                    rowIt.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (am != null) {
                try {
                    Configuration.releaseRootApplicationModule(am, true);
                } catch (Exception ex2) {
                    ex2.printStackTrace();
                }
            }

            //apGroupUserName
            apGroupUserName = getAPGroupUserName();
            System.out.println("apGroupUserName in onSyncClick method ::: " + apGroupUserName);

            //WHT amount
            whtAmount = whtAmountIt.getValue() != null ? whtAmountIt.getValue().toString() : null;
            System.out.println("----- Selected value for whtAmount : " + whtAmount);


            Object docId = resolveExpression("#{bindings.attr1.inputValue}");

            System.out.println(" --- Updating Webcenter IPM --- docId : " + (docId == null ? "" : docId.toString()));
            DocumentService docUpdateService = new DocumentService_Service().getDocumentServicePort();
            BindingProvider bindingProvider = (BindingProvider) docUpdateService;
            @SuppressWarnings("rawtypes")
            List<Handler> handlerChain = new ArrayList<Handler>();
            handlerChain.add(new WSSecurityHeaderSOAPHandler(resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGING_DOCUMENT_SERVICE_USERNAME']}")
                                                             .toString(),
                                                             resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGING_DOCUMENT_SERVICE_PASSWORD']}")
                                                             .toString()));
            bindingProvider.getBinding().setHandlerChain(handlerChain);
            List<FieldValue> fieldValues = new ArrayList<FieldValue>();


            FieldValue fieldValue1 = new FieldValue();
            fieldValue1.setName("Supplier Name");
            TypedValue typedValue1 = new TypedValue();
            typedValue1.setType(FieldType.TEXT);
            typedValue1.setValue(suppName);
            fieldValue1.setValue(typedValue1);
            //System.out.println("Supplier Name update success");

            FieldValue fieldValue2 = new FieldValue();
            fieldValue2.setName("Invoice Number");
            TypedValue typedValue2 = new TypedValue();
            typedValue2.setType(FieldType.TEXT);
            typedValue2.setValue(invoiceNum);
            fieldValue2.setValue(typedValue2);
            //System.out.println("Invoice Number update success");

            FieldValue fieldValue3 = new FieldValue();
            fieldValue3.setName("Invoice Date");
            TypedValue typedValue3 = new TypedValue();
            typedValue3.setType(FieldType.DATE);
            typedValue3.setValue(invoiceDate); // changed for jetstar
            fieldValue3.setValue(typedValue3);
            //System.out.println("Invoice Date update success");

            FieldValue fieldValue4 = new FieldValue();
            fieldValue4.setName("Invoice Total");
            TypedValue typedValue4 = new TypedValue();
            typedValue4.setType(FieldType.DECIMAL);
            typedValue4.setValue(invoiceTotal);
            fieldValue4.setValue(typedValue4);
            //System.out.println("Invoice Total update success");

            FieldValue fieldValue5 = new FieldValue();
            fieldValue5.setName("PO Number");
            TypedValue typedValue5 = new TypedValue();
            typedValue5.setType(FieldType.TEXT);
            typedValue5.setValue(poNumber);
            fieldValue5.setValue(typedValue5);
            //System.out.println("PO Number update success");

            FieldValue fieldValue6 = new FieldValue();
            fieldValue6.setName("Site ID");
            TypedValue typedValue6 = new TypedValue();
            typedValue6.setType(FieldType.TEXT);
            typedValue6.setValue(siteId);
            fieldValue6.setValue(typedValue6);
            //System.out.println("Site ID update success");

            FieldValue fieldValue7 = new FieldValue();
            fieldValue7.setName("Supplier Number");
            TypedValue typedValue7 = new TypedValue();
            typedValue7.setType(FieldType.TEXT);
            typedValue7.setValue(supplierNumber);
            fieldValue7.setValue(typedValue7);
            //System.out.println("Supplier Number update success");

            FieldValue fieldValue8 = new FieldValue();
            fieldValue8.setName("Certifier Name");
            TypedValue typedValue8 = new TypedValue();
            typedValue8.setType(FieldType.TEXT);
            typedValue8.setValue(certifierName);
            fieldValue8.setValue(typedValue8);
            //System.out.println("Certifier Name update success");

            FieldValue fieldValue9 = new FieldValue();
            fieldValue9.setName("Invoice Type");
            TypedValue typedValue9 = new TypedValue();
            typedValue9.setType(FieldType.TEXT);
            typedValue9.setValue(invoiceType);
            fieldValue9.setValue(typedValue9);
            //System.out.println("Invoice Type update success");

            FieldValue fieldValue10 = new FieldValue();
            fieldValue10.setName("Currency");
            TypedValue typedValue10 = new TypedValue();
            typedValue10.setType(FieldType.TEXT);
            typedValue10.setValue(currency);
            fieldValue10.setValue(typedValue10);
            //System.out.println("Currency update success");

            FieldValue fieldValue11 = new FieldValue();
            fieldValue11.setName("Document Type");
            TypedValue typedValue11 = new TypedValue();
            typedValue11.setType(FieldType.TEXT);
            typedValue11.setValue(documentType);
            fieldValue11.setValue(typedValue11);
            //System.out.println("Document Type update success");

            FieldValue fieldValue12 = new FieldValue();
            fieldValue12.setName("Supplier ID");
            TypedValue typedValue12 = new TypedValue();
            typedValue12.setType(FieldType.TEXT);
            typedValue12.setValue(suppId);
            fieldValue12.setValue(typedValue12);
            //System.out.println("Supplier ID update success");

            FieldValue fieldValue13 = new FieldValue();
            fieldValue13.setName("OrgID");
            TypedValue typedValue13 = new TypedValue();
            typedValue13.setType(FieldType.TEXT);
            typedValue13.setValue(org_Id == null ? null : org_Id.intValue() + "");
            fieldValue13.setValue(typedValue13);
            //System.out.println("OrgID update success");

            FieldValue fieldValue14 = new FieldValue();
            fieldValue14.setName("Due date");
            TypedValue typedValue14 = new TypedValue();
            typedValue14.setType(FieldType.DATE);
            typedValue14.setValue(dueDateEcmStr);
            fieldValue14.setValue(typedValue14);
            //System.out.println("Due date update success");

            FieldValue fieldValue15 = new FieldValue();
            fieldValue15.setName("Internal Status");
            TypedValue typedValue15 = new TypedValue();
            typedValue15.setType(FieldType.TEXT);
            typedValue15.setValue(selectedStatus);
            fieldValue15.setValue(typedValue15);
            //System.out.println("Internal Status update success");

            FieldValue fieldValue16 = new FieldValue();
            fieldValue16.setName("AP Username");
            TypedValue typedValue16 = new TypedValue();
            typedValue16.setType(FieldType.TEXT);
            typedValue16.setValue(apGroupUserName);
            fieldValue16.setValue(typedValue16);
            //System.out.println("AP Username update success");


            FieldValue fieldValue17 = new FieldValue();
            fieldValue17.setName("WHT Amount");
            TypedValue typedValue17 = new TypedValue();
            typedValue17.setType(FieldType.DECIMAL);
            typedValue17.setValue(whtAmount);
            fieldValue17.setValue(typedValue17);
            //System.out.println("WHT Amount update success");


            FieldValue fieldValue18 = new FieldValue();
            fieldValue18.setName("Operating Unit Name");
            TypedValue typedValue18 = new TypedValue();
            typedValue18.setType(FieldType.TEXT);
            typedValue18.setValue(operatingUnitName);
            fieldValue18.setValue(typedValue18);
            //System.out.println("Operating Unit update success");


            FieldValue fieldValue19 = new FieldValue();
            fieldValue19.setName("Reason Type");
            TypedValue typedValue19 = new TypedValue();
            typedValue19.setType(FieldType.TEXT);
            typedValue19.setValue(reasonType);
            fieldValue19.setValue(typedValue19);
            //System.out.println("Reason Type updated successfully");


            fieldValues.add(fieldValue1);
            fieldValues.add(fieldValue2);
            fieldValues.add(fieldValue3);
            fieldValues.add(fieldValue4);
            fieldValues.add(fieldValue5);
            fieldValues.add(fieldValue6);
            fieldValues.add(fieldValue7);
            fieldValues.add(fieldValue8);
            fieldValues.add(fieldValue9);
            fieldValues.add(fieldValue10);
            fieldValues.add(fieldValue11);
            fieldValues.add(fieldValue12);
            fieldValues.add(fieldValue13);
            fieldValues.add(fieldValue14);
            fieldValues.add(fieldValue15);
            fieldValues.add(fieldValue16);
            fieldValues.add(fieldValue17);
            fieldValues.add(fieldValue18);
            fieldValues.add(fieldValue19);


            docUpdateService.updateDocument(new Holder<String>(docId == null ? "" : docId.toString()), null,
                                            fieldValues, false);
            System.out.println(" --- Updating Webcenter IPM successful ---");
        } catch (Exception e) {
            System.out.println(" --- Updating Webcenter IPM failed ---" + e.getMessage());
            e.printStackTrace();
            //e.printStackTrace();
        }

        System.out.println("End updateEcmFields");
    }

    public void onSyncClick(ActionEvent actionEvent) {
        try {
            // Update BPM task
            updateTaskOnSync();
            // Update ECM fields
            updateEcmFields();
            Utility.getAm()
                   .getDBTransaction()
                   .commit();
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            validationErrorPopup.show(hints);
            this.validationErrorMessage.setValue("Modified Data Synced in ECM and BPM View");
        } catch (Exception e) {
            System.out.println(" --- Modified Data Sync in ECM and BPM View failed ---" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void setSearchByCertifiername(RichSelectOneChoice searchByCertifiername) {
        this.searchByCertifiername = searchByCertifiername;
    }

    public RichSelectOneChoice getSearchByCertifiername() {
        return searchByCertifiername;
    }

    /**Method to upload file to actual path on Server*/
    private String uploadFile(UploadedFile file) {

        UploadedFile myfile = file;
        String path = null;
        if (myfile == null) {

        } else {
            // All uploaded files will be stored in below path
            path = "/u02_sa_soadev/Oracle/Middleware/Upload/" + myfile.getFilename();
            InputStream inputStream = null;
            try {
                FileOutputStream out = new FileOutputStream(path);
                inputStream = myfile.getInputStream();
                byte[] buffer = new byte[8192];
                int bytesRead = 0;
                while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                out.flush();
                out.close();
            } catch (Exception ex) {
                // handle exception
                ex.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        //Returns the path where file is stored
        return path;
    }

    public void uploadFileVCE(ValueChangeEvent vce) {
        // Add event code here...
        if (vce.getNewValue() != null) {
            //Get File Object from VC Event
            UploadedFile fileVal = (UploadedFile) vce.getNewValue();
            String path = uploadFile(fileVal);
            System.out.println("File path in server :::: " + path);
            AdfFacesContext.getCurrentInstance()
                           .getPageFlowScope()
                           .put("fileUploadPath", path);
            System.out.println("File path in pageflowscope :::: " + AdfFacesContext.getCurrentInstance()
                                                                                   .getPageFlowScope()
                                                                                   .get("fileUploadPath"));
        }
    }

    public static FileDescriptor getFileFromImaging(String docId) {
        try {

            FileDescriptor fd = new FileDescriptor();


            System.out.println(" --- getFileFromImaging --- docId : " + docId);
            DocumentContentService documentContentService =
                new DocumentContentService_Service().getDocumentContentServicePort();
            BindingProvider bindingProvider = (BindingProvider) documentContentService;
            @SuppressWarnings("rawtypes")
            List<Handler> handlerChain = new ArrayList<Handler>();
            handlerChain.add(new WSSecurityHeaderSOAPHandler(resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGING_DOCUMENT_CONTENT_SERVICE_USERNAME']}")
                                                             .toString(),
                                                             resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGING_DOCUMENT_CONTENT_SERVICE_PASSWORD']}")
                                                             .toString()));
            bindingProvider.getBinding().setHandlerChain(handlerChain);


            Rendition rendition =
                documentContentService.retrieveRendition(docId, false, true, RenditionOutput.ORIGINALORTIFF, null);
            System.out.println(" --- getFileFromImaging --- : getOriginalFilename : " +
                               rendition.getOriginalFilename());
            byte[] byteData = rendition.getContent();
            //System.out.println(" --- getFileFromImaging --- : Length of document byte data : "+byteData.length);
            String mimeType = rendition.getMimeType();
            mimeType = mimeType.substring(mimeType.lastIndexOf("/") + 1, mimeType.length());
            //System.out.println(mimeType);


            fd.setBytedata(byteData);
            fd.setFilename(rendition.getOriginalFilename() == null ? ("invoice_document." + mimeType) :
                           rendition.getOriginalFilename());

            System.out.println(" --- getFileFromImaging : Done ---");
            return fd;
        } catch (Exception e) {
            System.out.println(" --- getFileFromImaging : Exception");
            e.printStackTrace();
            return null;
        }


    }

    private void saveAPComments(String invoiceID, String commentsDate, String description, String name) {


        System.out.println("Start : saveAPComments");
        System.out.println("Invoice ID in saveAPComments" + invoiceID);
        try {
            BindingContext bctx = BindingContext.getCurrent();
            BindingContainer bindings = bctx.getCurrentBindingsEntry();
            OperationBinding operationBinding = bindings.getOperationBinding("addCommentsTableRow");

            operationBinding.getParamsMap().put("invoiceID", invoiceID);
            operationBinding.getParamsMap().put("commentsDate", commentsDate);
            operationBinding.getParamsMap().put("description", description);
            operationBinding.getParamsMap().put("name", name);
            operationBinding.getParamsMap().put("category", "AP Operation");
            operationBinding.execute();
            DCBindingContainer bindings2 = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();

            AdfFacesContext.getCurrentInstance().addPartialTarget(apCommentsTable);

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("End : saveAPComments");

    }

    public String validateCreditNote() {
        String flag = null;
        //Document type
        String documentType = docTypeSoc.getValue() != null ? docTypeSoc.getValue().toString() : null;
        System.out.println("----- Selected value for document type : " + documentType);
        double taxTotal = Double.MIN_VALUE;
        if (taxTotIt.getValue() != null) {
            taxTotal = ((oracle.jbo.domain.Number) taxTotIt.getValue()).getValue();
            System.out.println("**********taxTotal**********" + taxTotal);
        }
        double headerTotal = Double.MIN_VALUE;
        if (headerTotIt.getValue() != null) {
            headerTotal = ((oracle.jbo.domain.Number) headerTotIt.getValue()).getValue();
            System.out.println("**********headerTotal**********" + headerTotal);

        }
        double lineTotal = Double.MIN_VALUE;
        if (lineIdIt.getValue() != null) {
            lineTotal = Double.parseDouble((String) lineIdIt.getValue());
            System.out.println("**********lineTotal**********" + lineTotal);
        }
        String reason = null;
        if (reasonSoc.getValue() != null && !reasonSoc.getValue().equals("")) {
            reason = reasonSoc.getValue().toString();
        }
        System.out.println("documentType==== " + documentType + " taxTotal=== " + taxTotal + " headerTotal==== " +
                           headerTotal + " lineTotal=== " + lineTotal + " reason=== " + reason);
        if (!reason.equalsIgnoreCase("16")) {
            //System.out.println("inside if reason ......");
            if (documentType.equalsIgnoreCase("Credit Note") &&
                (headerTotal >= 0.0 || lineTotal >= 0.0 || taxTotal > 0.0)) {
                //System.out.println("inside if credit validation ....");
                flag = "credit";
            } else if (documentType.equalsIgnoreCase("Invoice") &&
                       (headerTotal < 0.0 || lineTotal < 0.0 || taxTotal < 0.0)) {
                //System.out.println("inside if invoice validation ....");
                flag = "invoice";
            }
        }
        System.out.println("flag value in validateCreditNote() " + flag);
        return flag;
    }

    public String getAPGroupUserName() {
        System.out.println("----- getAPGroupUserName ----- START ---- -" + new Date());
        FacesContext context = FacesContext.getCurrentInstance();
        String ctx =
            (String) context.getApplication()
            .evaluateExpressionGet(context, "#{pageFlowScope.bpmWorklistContext}", String.class);

        String taskId =
            (String) context.getApplication()
            .evaluateExpressionGet(context, "#{pageFlowScope.bpmWorklistTaskId}", String.class);

        System.out.println("----- bpmWorklistContext : " + ctx + ", bpmWorklistTaskId : " + taskId);

        IWorkflowServiceClient workflowSvcClient = ADFWorklistBeanUtil.getWorkflowServiceClient();
        ITaskQueryService wfQueryService = workflowSvcClient.getTaskQueryService();
        ITaskService taskSvc = workflowSvcClient.getTaskService();

        IWorkflowContext wfContext;
        String userID = "";
        String certifierName = null;
        String acquiredByUserName = "";
        try {
            wfContext = wfQueryService.getWorkflowContext(ctx);
            userID = wfContext.getUser();


            DCBindingContainer dcBindingContainer =
                (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("searchCertifierVO1Iterator");
            ViewObjectImpl certifierNameVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
            //                  ViewCriteria vc = certifierNameVO.getViewCriteria("CertifierNameVOCriteria1");
            //                  certifierNameVO.applyViewCriteria(vc);
            certifierNameVO.setNamedWhereClauseParam("bindName", userID);
            certifierNameVO.executeQuery();
            int noOfRows = certifierNameVO.getRowCount();
            System.out.println("No of rows fetched by searchcertifiernameVO is " + noOfRows);
            if (noOfRows == 1) {
                //System.out.println("Executing No of rows is "+noOfRows);
                Row row = certifierNameVO.next();
                if (row.getAttribute("FirstName") != null) {

                    certifierName = row.getAttribute("FirstName").toString();
                    //System.out.println("certifer name in  getAPGroupUserName"+certifierName);
                }
            }
            if (noOfRows == 0) {
                certifierName = "eqadmin";
            }


            //Predicate taskIdPredicate = new Predicate(TableConstants.WFTASK_TASKID_COLUMN, Predicate.OP_EQ, taskId);

            // Task currentTask = wfQueryService.getTaskDetailsById(wfContext, taskId);

            /* CustomAttributesType customAttributesType = currentTask.getCustomAttributes();
                  String expiry = customAttributesType.getCustomAttributeString1();
                  System.out.println("Expiry time ::: "+ expiry);
                  customAttributesType.setCustomAttributeString1("0");
                  taskSvc.updateTask(wfContext, currentTask); */

            //                  SystemAttributesType systemAttributesType = currentTask.getSystemAttributes();
            //                  acquiredByUserName = systemAttributesType.getAcquiredByDisplayName();
            //                  System.out.println("acquiredByUserName :::::: "+ acquiredByUserName);
            //                  userName = systemAttributesType.getUpdatedBy().getDisplayName();
            //                  System.out.println("userName :::::: "+ userName);

            //System.out.println("----- Updating task field END -----");


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("----- getAPGroupUserName ----- END ----- " + new Date());
        System.out.println("certifer name in  getAPGroupUserName" + certifierName);
        return certifierName;
    }


    /*  public void updateTaskWithExpiry() {
            System.out.println("----- updateTask ----- START ---- -"+new Date());
            FacesContext context = FacesContext.getCurrentInstance();
            String ctx = (String)context.getApplication().evaluateExpressionGet(context,"#{pageFlowScope.bpmWorklistContext}",String.class);

            String taskId = (String)context.getApplication().evaluateExpressionGet(context,"#{pageFlowScope.bpmWorklistTaskId}",String.class);

            System.out.println("----- bpmWorklistContext : "+ctx+", bpmWorklistTaskId : "+taskId);

            IWorkflowServiceClient workflowSvcClient = ADFWorklistBeanUtil.getWorkflowServiceClient();
            ITaskQueryService wfQueryService = workflowSvcClient.getTaskQueryService();
            ITaskService taskSvc = workflowSvcClient.getTaskService();

            IWorkflowContext wfContext;
            String userName = "";
            try {
                wfContext = wfQueryService.getWorkflowContext(ctx);

                //Predicate taskIdPredicate = new Predicate(TableConstants.WFTASK_TASKID_COLUMN, Predicate.OP_EQ, taskId);

                Task currentTask = wfQueryService.getTaskDetailsById(wfContext, taskId);

                CustomAttributesType customAttributesType = currentTask.getCustomAttributes();
                String expiry = customAttributesType.getCustomAttributeString1();
                System.out.println("Expiry time ::: "+ expiry);
                customAttributesType.setCustomAttributeString1("0");

                taskSvc.updateTask(wfContext, currentTask);

                System.out.println("----- Updating task field END -----");

            } catch(WorkflowException  wfEx) {
                wfEx.printStackTrace();
            } catch(ParserConfigurationException  pcEx) {
                pcEx.printStackTrace();
            } catch(TransformerConfigurationException tcEx) {
                tcEx.printStackTrace();
            } catch(TransformerException tEx) {
                tEx.printStackTrace();
            } catch(StaleObjectException stObjEx) {
                stObjEx.printStackTrace();
            }
        //        catch(XPathExpressionException xpEx) {
        //            xpEx.printStackTrace();
        //        }

            System.out.println("----- updateTask ----- END ----- "+new Date());

        } */

    public void selectAllCheckBoxVCL(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        try {
            System.out.println("xdebug c1 : In selectAllChoiceBoxLN with value = " + valueChangeEvent.getNewValue());
            //        boolean isSelected = valueChangeEvent.getNewValue();
            //        boolean isSelected = ((Boolean)valueChangeEvent.getNewValue()).booleanValue();
            String selectedVal = null;
            selectedVal = valueChangeEvent.getNewValue().toString();
            //System.out.println("xdebug c2: selectedVal : " + selectedVal);

            BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding lineItemiter = (DCIteratorBinding) bindings.get("LineItemDetailsEOView1Iterator");

            ViewObject lineItemVo = lineItemiter.getViewObject();
            System.out.println("line count" + lineItemVo.getEstimatedRowCount());

            RowSetIterator lineItemrsi = lineItemVo.createRowSetIterator(null);
            if (lineItemrsi != null) {
                int i = 0;
                Row row = null;
                lineItemrsi.reset();

                while (lineItemrsi.hasNext()) {
                    //System.out.println("within while");
                    if (i == 0) {
                        row = lineItemrsi.first();
                        //System.out.println("line number of selected rows::"+row.getAttribute("LineNumber"));
                    } else {
                        row = lineItemrsi.next();
                        //System.out.println("line number of else selected rows::"+row.getAttribute("LineNumber"));
                    }

                    if (selectedVal.equals("true")) {
                        //System.out.println("within if block");
                        row.setAttribute("isSelected", "Y");
                    } else {
                        //System.out.println("within else block");
                        row.setAttribute("isSelected", "N");
                    }
                    i++;
                }
                lineItemrsi.closeRowSetIterator();
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    //    public void selectSingleCheckBox(ValueChangeEvent valueChangeEvent) {
    //        // Add event code here...
    //            try {
    //            System.out.println(" In selectSingleCheckBox with value = " +
    //                               valueChangeEvent.getNewValue());
    //            //        boolean isSelected = valueChangeEvent.getNewValue();
    //            //        boolean isSelected = ((Boolean)valueChangeEvent.getNewValue()).booleanValue();
    //            String selectedVal = null;
    //            selectedVal = valueChangeEvent.getNewValue().toString();
    //            System.out.println(" selectedVal : " + selectedVal);
    //
    //            BindingContainer bindings =
    //                BindingContext.getCurrent().getCurrentBindingsEntry();
    //            DCIteratorBinding lineItemiter =
    //                (DCIteratorBinding)bindings.get("LineItemDetailsEOView1Iterator");
    //
    //            ViewObject lineItemVo = lineItemiter.getViewObject();
    //            System.out.println("line count" +
    //                               lineItemVo.getEstimatedRowCount());
    //            Row row = null;
    //            row = lineItemVo.getCurrentRow();
    //
    //            //
    //            //            while (lineItemrsi.hasNext()) {
    //            //                System.out.println("within while");
    //            //                if (i == 0){
    //            //                    row = lineItemrsi.first();
    //            //                    System.out.println("line number of selected rows::"+row.getAttribute("LineNumber"));
    //            //                }
    //            //                else{
    //            //                    row = lineItemrsi.next();
    //            //                    System.out.println("line number of else selected rows::"+row.getAttribute("LineNumber"));
    //            //                }
    //
    //            if (selectedVal.equals("true")) {
    //                System.out.println("within if block");
    //                row.setAttribute("isSelected", "Y");
    //            } else {
    //                System.out.println("within else block");
    //                row.setAttribute("isSelected", "N");
    //            }
    //        } catch (Exception e) {
    //            // TODO: Add catch code
    //            e.printStackTrace();
    //        }
    //    }

    public void setParentCheckBox(RichSelectBooleanCheckbox parentCheckBox) {
        this.parentCheckBox = parentCheckBox;
    }

    public RichSelectBooleanCheckbox getParentCheckBox() {
        return parentCheckBox;
    }

    public void setSubCheckBox(RichSelectBooleanCheckbox subCheckBox) {
        this.subCheckBox = subCheckBox;
    }

    public RichSelectBooleanCheckbox getSubCheckBox() {
        return subCheckBox;
    }


    public void setApCommentsTable(RichTable apCommentsTable) {
        this.apCommentsTable = apCommentsTable;
    }

    public RichTable getApCommentsTable() {
        return apCommentsTable;
    }

    public void setApCommentsTableDescPopup(RichPopup apCommentsTableDescPopup) {
        this.apCommentsTableDescPopup = apCommentsTableDescPopup;
    }

    public RichPopup getApCommentsTableDescPopup() {
        return apCommentsTableDescPopup;
    }

    public void setApCommentsTableDescPopUpIt(RichInputText apCommentsTableDescPopUpIt) {
        this.apCommentsTableDescPopUpIt = apCommentsTableDescPopUpIt;
    }

    public RichInputText getApCommentsTableDescPopUpIt() {
        return apCommentsTableDescPopUpIt;
    }

    public void setOnAPCommentsTableDescriptionPopupOKClick(RichCommandButton onAPCommentsTableDescriptionPopupOKClick) {
        this.onAPCommentsTableDescriptionPopupOKClick = onAPCommentsTableDescriptionPopupOKClick;
    }

    public RichCommandButton getOnAPCommentsTableDescriptionPopupOKClick() {
        return onAPCommentsTableDescriptionPopupOKClick;
    }

    public void onApCommentsTableDescriptionPopupOKClick(ActionEvent actionEvent) {
        System.out.println("Start onApCommentsTableDescriptionPopupOKClick");
        apCommentsTableDescPopup.hide();

        System.out.println("End onApCommentsTableDescriptionPopupOKClick");

    }

    public void setSumOfTaxTotal(RichOutputText sumOfTaxTotal) {
        this.sumOfTaxTotal = sumOfTaxTotal;
    }

    public RichOutputText getSumOfTaxTotal() {
        return sumOfTaxTotal;
    }

    public void setSumOfLineTotal(RichOutputText sumOfLineTotal) {
        this.sumOfLineTotal = sumOfLineTotal;
    }

    public RichOutputText getSumOfLineTotal() {
        return sumOfLineTotal;
    }

    public void setWhtAmountIt(RichInputText whtAmountIt) {
        this.whtAmountIt = whtAmountIt;
    }

    public RichInputText getWhtAmountIt() {
        return whtAmountIt;
    }

    public void setFreight(RichInputText freight) {
        this.freight = freight;
    }

    public RichInputText getFreight() {
        return freight;
    }

    public void setAog(RichInputText aog) {
        this.aog = aog;
    }

    public RichInputText getAog() {
        return aog;
    }

    public void openWhtCodePopup(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openWhtCodePopup");
        String enteredWhtCode = null;
        RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
        Iterator rowKeySetIt = rowKeySet.iterator();
        DCIteratorBinding lineItemIter =
            ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry())
            .findIteratorBinding("LineItemDetailsEOView1Iterator");
        RowSetIterator lineItemRSIter = null;
        try {
            lineItemRSIter = lineItemIter.getRowSetIterator();
            while (rowKeySetIt.hasNext()) {
                Key key = (Key) ((List) rowKeySetIt.next()).get(0);
                Row currentRow = lineItemRSIter.getRow(key);
                if (currentRow != null) {
                    //System.out.println("----- typedInWhtCode ----- "+currentRow.getAttribute("WhtCode"));
                    enteredWhtCode = currentRow.getAttribute("WhtCode") == null ? "" : currentRow.getAttribute("WhtCode")
                                                                                                 .toString()
                                                                                                 .trim();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* finally{
                    if(lineItemRSIter!=null) {
                        try {
                            lineItemRSIter.closeRowSetIterator();
                        } catch(Exception ex) {
                            ex.printStackTrace();

                    }
                    }
                } */

        String suppName = null;
        String siteId = null;

        suppName = supNameIt.getValue() != null ? supNameIt.getValue().toString() : null;
        System.out.println("----- Selected value for Supplier name : " + suppName);

        siteId = siteIdIt.getValue() != null ? siteIdIt.getValue().toString() : null;
        System.out.println("----- Selected value for siteId : " + siteId);

        //Org ID
        BigDecimal org_Id = getOrganizationId();
        System.out.println("ORG id value from utility method : " + org_Id);

        DCBindingContainer dcBindingContainer =
            (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("WhtCodeVO1Iterator");
        ViewObjectImpl whtCodeVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
        ViewCriteria vc = whtCodeVO.getViewCriteria("WhtCodeVOCriteria");
        whtCodeVO.applyViewCriteria(vc);
        whtCodeVO.setNamedWhereClauseParam("bindOrgId", org_Id);
        whtCodeVO.setNamedWhereClauseParam("bindWhtCode", enteredWhtCode);
        //System.out.println("-----------Dynamic Query-----------");
        //System.out.println(whtCodeVO.getQuery());
        whtCodeVO.executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(whtCodeDetailsTable);

        String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        System.out.println(" ----- clientID : " + clientId);

        this.clientID.setValue(clientId);

        try {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p13.show(hints);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("End openWhtCodePopup");
    }

    public void setP13(RichPopup p13) {
        this.p13 = p13;
    }

    public RichPopup getP13() {
        return p13;
    }

    public void cancelWhtCode(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start: cancelWhtCode");
        p13.hide();
        System.out.println("End: cancelWhtCode");
    }

    public void selectWhtCode(ActionEvent actionEvent) {
        // Add event code here...

        String selectedSiteId = siteIdIt.getValue() != null ? siteIdIt.getValue().toString() : null;
        String orgID = getOrganizationId().toString();
        String currency = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;
        String invDate = invDateId.getValue() != null ? invDateId.getValue().toString() : null;


        System.out.println("Start selectWhtCode");
        String selectedWhtCode = null;
        RowKeySet whtCodeRowKeySet = whtCodeDetailsTable.getSelectedRowKeys();
        Iterator whtCodeIter = whtCodeRowKeySet.iterator();
        DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding whtCodeVoIter = bindings.findIteratorBinding("WhtCodeVO1Iterator");
        RowSetIterator whtCodeVoRSIter = null;
        try {
            whtCodeVoRSIter = whtCodeVoIter.getRowSetIterator();
            while (whtCodeIter.hasNext()) {
                Key key = (Key) ((List) whtCodeIter.next()).get(0);
                Row currentRow = whtCodeVoRSIter.getRow(key);
                //System.out.println(currentRow.getAttribute("WhtCode"));
                selectedWhtCode = currentRow.getAttribute("WhtCode").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (whtCodeVoRSIter != null) {
                try {
                    whtCodeVoRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }

        RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
        Iterator rowKeySetIt = rowKeySet.iterator();
        DCIteratorBinding lineItemIter =
            ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry())
            .findIteratorBinding("LineItemDetailsEOView1Iterator");
        RowSetIterator lineItemRSIter = null;
        try {
            lineItemRSIter = lineItemIter.getRowSetIterator();
            while (rowKeySetIt.hasNext()) {
                Key key = (Key) ((List) rowKeySetIt.next()).get(0);
                Row currentLineItemRow = lineItemRSIter.getRow(key);
                if (currentLineItemRow != null) {
                    //System.out.println("----- typedInWhtCode ----- "+currentLineItemRow.getAttribute("WhtCode"));
                    currentLineItemRow.setAttribute("WhtCode", selectedWhtCode);
                    //System.out.println("----- selectedWhtCode ----- "+currentLineItemRow.getAttribute("WhtCode"));

                }
            }

            AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);

            System.out.println("calling getWHTAmount from selectWHTCode");

            getWHTAmount(selectedSiteId, invDate, currency, orgID);
            p13.hide();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lineItemRSIter != null) {
                try {
                    lineItemRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        System.out.println("End selectWhtCode");
    }

    public void setWhtCodePopupIT(RichInputText whtCodePopupIT) {
        this.whtCodePopupIT = whtCodePopupIT;
    }

    public RichInputText getWhtCodePopupIT() {
        return whtCodePopupIT;
    }

    public void onWhtCodePopupGoClick(ActionEvent actionEvent) {
        // Add event code here...

        System.out.println("Start onWhtCodePopupGoClick");
        String enteredWhtCode = null;
        try {

            enteredWhtCode = whtCodePopupIT.getValue() != null ? whtCodePopupIT.getValue().toString() : null;
            System.out.println("currencyCodePopupIT.getValue(): " + enteredWhtCode);

            BigDecimal org_Id = getOrganizationId();
            System.out.println("ORG id value from utility method : " + org_Id);

            DCBindingContainer dcBindingContainer =
                (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("WhtCodeVO1Iterator");
            ViewObjectImpl whtCodeVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
            ViewCriteria vc = whtCodeVO.getViewCriteria("WhtCodeVOCriteria");
            whtCodeVO.applyViewCriteria(vc);
            whtCodeVO.setNamedWhereClauseParam("bindOrgId", org_Id);
            whtCodeVO.setNamedWhereClauseParam("bindWhtCode", enteredWhtCode);
            //System.out.println("-----------Dynamic Query-----------");
            //System.out.println(whtCodeVO.getQuery());
            whtCodeVO.executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(whtCodeDetailsTable);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onWhtCodePopupGoClick");
    }

    public BigDecimal getOrganizationId() {
        String suppName = null;
        String siteId = null;

        suppName = supNameIt.getValue() != null ? supNameIt.getValue().toString() : null;
        System.out.println("----- Selected value for Supplier name : " + suppName);

        siteId = siteIdIt.getValue() != null ? siteIdIt.getValue().toString() : null;
        System.out.println("----- Selected value for siteId : " + siteId);

        //Org ID
        ApplicationModule am = null;
        RowSetIterator rowIt = null;
        BigDecimal org_Id = null;
        String amDef = "model.EbsAM";
        String config = "EbsAMLocal";
        am = Configuration.createRootApplicationModule(amDef, config);
        EbsAMImpl amImpl = (EbsAMImpl) am;
        ViewObjectImpl suppNameVO = amImpl.getSitesVO1();
        ViewCriteria viewCrit = suppNameVO.getViewCriteria("SitesVOCriteriaSupNameSiteID");
        suppNameVO.applyViewCriteria(viewCrit);
        suppNameVO.setNamedWhereClauseParam("bindVendorName", suppName);
        suppNameVO.setNamedWhereClauseParam("bvSiteID", siteId);
        suppNameVO.executeQuery();
        if (suppNameVO.getEstimatedRowCount() > 0) {
            /*System.out.println("--- Match found for Supplier Name : " +
                                                   suppNameVO.getEstimatedRowCount() +
                                                   " records.");*/
            rowIt = suppNameVO.createRowSetIterator(null);
            while (rowIt.hasNext()) {
                Row rowData = rowIt.next();
                try {
                    org_Id = rowData.getAttribute("OrgId") == null ? null : (BigDecimal) rowData.getAttribute("OrgId");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //System.out.println("orgId ::: "+ org_Id);
        if (rowIt != null) {
            try {
                rowIt.closeRowSetIterator();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (am != null) {
            try {
                Configuration.releaseRootApplicationModule(am, true);
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }

        return org_Id;
    }

    public void setWhtCodeDetailsTable(RichTable whtCodeDetailsTable) {
        this.whtCodeDetailsTable = whtCodeDetailsTable;
    }

    public RichTable getWhtCodeDetailsTable() {
        return whtCodeDetailsTable;
    }


    public void setWhtRequiredFlag(RichSelectBooleanCheckbox whtRequiredFlag) {
        this.whtRequiredFlag = whtRequiredFlag;
    }

    public RichSelectBooleanCheckbox getWhtRequiredFlag() {
        return whtRequiredFlag;
    }


    public void setWhtCodeColumn(RichInputText whtCodeColumn) {
        this.whtCodeColumn = whtCodeColumn;
    }

    public RichInputText getWhtCodeColumn() {
        return whtCodeColumn;
    }

    public void onChangeWHtReqdFlag(ValueChangeEvent valueChangeEvent) {

        System.out.println("inside : onChangeWHtReqdFlag ");
        System.out.println("valueChangeEvent.getNewValue()" + valueChangeEvent.getNewValue());
        System.out.println("whtrequiredflag is selected or not :" + whtRequiredFlag.isSelected());

        String selectedSiteId = siteIdIt.getValue() != null ? siteIdIt.getValue().toString() : null;
        String invDate = invDateId.getValue() != null ? invDateId.getValue().toString() : null;
        String currency = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;
        String orgId = getOrganizationId() != null ? getOrganizationId().toString() : null;

        if (valueChangeEvent.getNewValue() != null && !whtRequiredFlag.isSelected()) {
            try {
                //System.out.println("checkbox is not selected");
                modifyWhtCodeColumn(null);
                whtCodeColumn.setDisabled(true);
                whtCodeSearchIcon.setDisabled(true);
                ADFContext.getCurrent()
                          .getPageFlowScope()
                          .put("WHTReqdFlag", "false");
                System.out.println("clearing wht amount value");
                whtAmountIt.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(whtAmountIt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (valueChangeEvent.getNewValue() != null && whtRequiredFlag.isSelected()) {
            try {
                //System.out.println("checkbox is selected");
                modifyWhtCodeColumn(ADFContext.getCurrent()
                                              .getPageFlowScope()
                                              .get("defaultWHTCode") != null ? ADFContext.getCurrent()
                                                                                         .getPageFlowScope()
                                                                                         .get("defaultWHTCode")
                                                                                         .toString() : null);
                whtCodeColumn.setDisabled(false);
                whtCodeSearchIcon.setDisabled(false);
                ADFContext.getCurrent()
                          .getPageFlowScope()
                          .put("WHTReqdFlag", "true");
                System.out.println("calling get wht amount from whtAmount");
                getWHTAmount(selectedSiteId, invDate, currency, orgId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);

    }

    public void setWhtCodeSearchIcon(RichCommandImageLink whtCodeSearchIcon) {
        this.whtCodeSearchIcon = whtCodeSearchIcon;
    }

    public RichCommandImageLink getWhtCodeSearchIcon() {
        return whtCodeSearchIcon;
    }

    public void modifyWhtCodeColumn(String codeVal) {

        System.out.println("inside : modifyWhtCodeColumn()");
        String invoiceId = getInvoiceId();
        RowSetIterator rowSetIterator = null;
        try {
            DCBindingContainer dcBindingContainer =
                (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding =
                dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
            ViewObjectImpl vo2 = (ViewObjectImpl) dcIteratorBinding.getViewObject();
            rowSetIterator = null;

            rowSetIterator = vo2.createRowSetIterator(null);

            while (rowSetIterator.hasNext()) {
                Row row = rowSetIterator.next();
                if (row != null) {
                    //System.out.println("Codeval : "+codeVal);
                    row.setAttribute("WhtCode", codeVal);
                    //System.out.println("WHTCode value :: "+row.getAttribute("WhtCode"));


                }
            }


            /*Chaning VO */

            /* ViewObjectImpl viewObject = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                viewObject.executeQuery();
                while (viewObject.hasNext()) {
                  Row row = viewObject.next();
                    if(row!=null){

                        row.setAttribute("WhtCode", codeVal);
                        System.out.println("WHTCode value :: "+row.getAttribute("WhtCode"));
                    }
                  // DO what do you want in Row
                }*/


            AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rowSetIterator != null) {
                rowSetIterator.reset();
                rowSetIterator.closeRowSetIterator();
            }
        }

        AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);
        System.out.println("End : modifyWhtCodeColumn()");
    }

    public void getWHTAmount(String selectedSiteId, String invDate, String currency, String orgId) {

        System.out.println("Inside : getWHTAmount APOperation Bean");

        oracle.jbo.domain.Number amount;

        try {
            BindingContext bindingContext = null;
            BindingContainer bindingContainer = null;
            OperationBinding operationBinding = null;

            bindingContext = BindingContext.getCurrent();
            bindingContainer = bindingContext.getCurrentBindingsEntry();
            operationBinding = bindingContainer.getOperationBinding("calculateWHTAmount");

            operationBinding.getParamsMap().put("SupplierSiteNumber", selectedSiteId);
            operationBinding.getParamsMap().put("invoiceDate", invDate);
            operationBinding.getParamsMap().put("currencyCodes", currency);
            operationBinding.getParamsMap().put("orgID", orgId);

            operationBinding.execute();

            if (ADFContext.getCurrent()
                          .getPageFlowScope()
                          .get("whtAmount") != null) {

                System.out.println("Setting WHT Amount by new Logic");
                amount = new oracle.jbo.domain.Number(Double.parseDouble(ADFContext.getCurrent()
                                                                                   .getPageFlowScope()
                                                                                   .get("whtAmount")
                                                                                   .toString()));
                whtAmountIt.setValue(amount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(whtAmountIt);
            }
            //Added on 5th Dec else if block
            else if (ADFContext.getCurrent()
                               .getPageFlowScope()
                               .get("whtAmount") == null) {

                whtAmountIt.setValue("");
                //System.out.println("Refreshing WHT amount");
                AdfFacesContext.getCurrentInstance().addPartialTarget(whtAmountIt);
            }
            if (!(ADFContext.getCurrent()
                            .getPageFlowScope()
                            .get("errorMessage") != null && ADFContext.getCurrent()
                                                                      .getPageFlowScope()
                                                                      .get("errorMessage")
                                                                      .toString()
                                                                      .equalsIgnoreCase("success"))) {

                whtAmountIt.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(whtAmountIt);
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                validationErrorPopup.show(hints);
                this.validationErrorMessage.setValue(ADFContext.getCurrent()
                                                               .getPageFlowScope()
                                                               .get("errorMessage")
                                                               .toString());


            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Ends : getWHTAmount APOperation Bean");
    }
public Row getCustomCurrentRow(){
        DCBindingContainer bindings = getBinding();
        DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        LinkedHashMap<Integer,Row> map=new LinkedHashMap();
        ViewObject empVO = lineItemIter.getViewObject();
        Row selectedRow = null;
        if (invoiceTypeSoc.getValue()
                          .toString()
                          .equalsIgnoreCase("PO Invoice")) {
            try {
                RowSetIterator rsi = empVO.createRowSetIterator(null);
                int i=0;
                while (rsi.hasNext()) {
                    i++;
                    selectedRow = rsi.next();
                    System.out.println("Demo Quantity :" + selectedRow.getAttribute("Quantity")+ " UnitPrice : "+selectedRow.getAttribute("UnitPrice")+" LineTotalAmount :"+selectedRow.getAttribute("LineTotalAmount")+" TaxRateCode : "+selectedRow.getAttribute("TaxRateCode"));
//                    System.out.println("Demo UnitPrice :" + selectedRow.getAttribute("UnitPrice"));
//                    System.out.println("Demo row :" + selectedRow.getAttribute("LineTotalAmount"));
//                    System.out.println("Demo TaxRateCode :" + selectedRow.getAttribute("TaxRateCode"));
                    map.put(i, selectedRow);
                }
                System.out.println(map);
                if (map.containsKey(lineDetailsTable.getRowIndex()+1)){
                    System.out.println("Loop Sucessfully");
                    selectedRow=map.get(lineDetailsTable.getRowIndex()+1);
                    return selectedRow;
                }
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
				selectedRow=empVO.getCurrentRow();
				return selectedRow;
            }
        }else{
            selectedRow=empVO.getCurrentRow();
            return selectedRow;
        }
        return selectedRow;
    }

    public void roundAmount(String currencyCode, String lineAmount, String attributeName) {

        System.out.println("Inside : roundAmount");


        try {

            DCBindingContainer dcBindingContainer =
                (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding =
                dcBindingContainer.findIteratorBinding("ValidateRoundingAmount1Iterator");
            ViewObjectImpl validateRoundAmountVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
            validateRoundAmountVO.setNamedWhereClauseParam("bv_p_currency", currencyCode);
            validateRoundAmountVO.setNamedWhereClauseParam("bv_p_amount", lineAmount);
            //System.out.println("-----------Dynamic Query-----------");
            //System.out.println(validateGLCodeVO.getQuery());

            validateRoundAmountVO.executeQuery();
            String roundAmount = null;
            while (validateRoundAmountVO.hasNext()) {
                //System.out.println("validateRoundAmountVO.hasNext() not null");
                Row row = validateRoundAmountVO.next(); // Get the next row in the result set.
                int attributeCount = row.getAttributeCount();
                //System.out.println("AtrributeCount :: "+attributeCount );
                String[] attributeNames = row.getAttributeNames();
                if (row.getAttribute(row.getAttributeNames()[0]) != null) {
                    roundAmount = row.getAttribute(attributeNames[0]).toString();
				System.out.println("Round Amount : " + roundAmount);
                }
            }


            DCBindingContainer bindings = getBinding();
            DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
            ViewObject empVO = lineItemIter.getViewObject();
            Row selectedRow = getCustomCurrentRow();
            //System.out.println("selectedRow :: "+selectedRow);
            if (selectedRow != null) {

                System.out.println("set lineAmount");
                //lineTotal.setValue(roundAmount);
                //System.out.println("taxamountIt set to value"+lineTotal.getValue());

                selectedRow.setAttribute(attributeName, roundAmount);
                //System.out.println("Rounded Value of "+"attributeName :: " +selectedRow.getAttribute(attributeName));

                //LineTotalAmount

                if (attributeName != null && attributeName.equals("LineTotalAmount")) {
                    AdfFacesContext.getCurrentInstance().addPartialTarget(lineTotal);
                }

                //AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);

            }
        } catch (Exception e) {

            e.printStackTrace();
        }


        System.out.println("End : roundAmount");
    }

    public void getCalculatedTaxAmountFromEBS(String newValue_of_changedField, String fieldName) {
                System.out.println("calculateTaxAmountFromLineTot line total new value :: " + newValue_of_changedField+" FieldName :"+fieldName);
        DCBindingContainer bindings = getBinding();
        DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObject empVO = lineItemIter.getViewObject();
int index = lineDetailsTable.getRowIndex();
        System.out.println("EBS Index : " + index);
//        Row selectedRow = empVO.getCurrentRow();
        Row selectedRow =getCustomCurrentRow();
        String orgId = null;
        String currency = null;
        String tax_code = null;
        String amount = null;

        if (getOrganizationId() != null) {
            orgId = getOrganizationId().toString();
        }

        if (selectedRow != null) {
            System.out.println("SelectedRow found!!");
            //orgId =orgIdIt.getValue()!=null ? orgIdIt.getValue().toString() : null;
            currency = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;

            if (fieldName.equals("LineTotal")) {
                amount = newValue_of_changedField != null ? newValue_of_changedField : null;
if (invoiceTypeSoc.getValue()
                                  .toString()
                                  .equalsIgnoreCase("PO Invoice") && tempTaxRateCode != null) {
                    System.out.println("Enter Temp Tax Loop TempTaxRateCode : " + tempTaxRateCode);
                    tax_code = tempTaxRateCode;
                } else {
                tax_code =
                    selectedRow.getAttribute("TaxRateCode") != null ?
                    selectedRow.getAttribute("TaxRateCode").toString() : null;
				}
            } else {
                amount =
                    selectedRow.getAttribute("LineTotalAmount") != null ?
                    selectedRow.getAttribute("LineTotalAmount").toString() : null;
                tax_code = newValue_of_changedField != null ? newValue_of_changedField : null;
            }

System.out.println("orgId : " + orgId+ " Currency : "+currency+" tax_code : "+tax_code+" amount : "+amount);
            /*System.out.println("orgId :: "+orgId!=null ?orgId : "orgId is coming null");
            System.out.println("currency :: "+currency!=null?currency : "currency is coming blank");
            System.out.println("tax_code :: "+ tax_code!=null ? tax_code : "tax_code is coming blank");
            System.out.println("amount :: " + amount!=null ? amount : "amount is coming blank");*/

            if (orgId != null && currency != null && tax_code != null &&
                amount !=
                null) {
                //Calling ValidateTaxCalcRounding func if all in params are non-empty
                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding =
                    dcBindingContainer.findIteratorBinding("ValidateTaxCalcRounding1Iterator");
                ViewObjectImpl validateTaxAmountRoundingVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                validateTaxAmountRoundingVO.setNamedWhereClauseParam("bv_orgId", orgId);
                validateTaxAmountRoundingVO.setNamedWhereClauseParam("bv_currency", currency);
                validateTaxAmountRoundingVO.setNamedWhereClauseParam("bv_tax_code", tax_code);
                validateTaxAmountRoundingVO.setNamedWhereClauseParam("bv_amount", amount);
                validateTaxAmountRoundingVO.executeQuery();
                String taxRoundAmount = null;
                while (validateTaxAmountRoundingVO.hasNext()) {
                    Row row = validateTaxAmountRoundingVO.next();
                    int attributeCount = row.getAttributeCount();
                    //System.out.println("AtrributeCount :: "+attributeCount + "Atrribute Name is :: "+row.getAttribute(row.getAttributeNames()[0]));
                    String[] attributeNames = row.getAttributeNames();
                    if (row.getAttribute(row.getAttributeNames()[0]) != null) {
                        taxRoundAmount = row.getAttribute(attributeNames[0]).toString();
                        System.out.println("taxRoundAmount :: " + taxRoundAmount);
                    }
                }

                selectedRow.setAttribute("TaxAmountLineitem", taxRoundAmount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(taxAmountLine);
            }

        }

    }

    private boolean checkLineTypePresent() {

        System.out.println("Start : checkLineTypePresent");
        DCBindingContainer dcBindingContainer =
            (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObjectImpl lineVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
        RowSetIterator lineItemItr = null;

        lineItemItr = lineVO.createRowSetIterator(null);
        boolean checkLineTypePresent = false;
        try {
            while (lineItemItr.hasNext()) {

                Row row = lineItemItr.next();
                if (row != null) {
                    String lineType = (String) row.getAttribute("LineType");

                    if (lineType != null && lineType.trim().equalsIgnoreCase("LINE")) {
                        checkLineTypePresent = true;
                        break;
                    } else
                        continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lineItemItr != null) {
                lineItemItr.closeRowSetIterator();
            }
        }
        return checkLineTypePresent;
    }


    public void onTestTaskClick(ActionEvent actionEvent) throws WorkflowException {
        FacesContext context = FacesContext.getCurrentInstance();
        String ctx =
            (String) context.getApplication()
            .evaluateExpressionGet(context, "#{pageFlowScope.bpmWorklistContext}", String.class);
        IWorkflowServiceClient workflowSvcClient = ADFWorklistBeanUtil.getWorkflowServiceClient();
        //currentTask.getSystemAttributes().getState()
        String invoiceid = null;
        ITaskQueryService wfQueryService = workflowSvcClient.getTaskQueryService();

        IWorkflowContext wfContext;
        String userName = "";
        wfContext = wfQueryService.getWorkflowContext(ctx);

        String taskId =
            (String) context.getApplication()
            .evaluateExpressionGet(context, "#{pageFlowScope.bpmWorklistTaskId}", String.class);
        System.out.println("Inside onTestTaskClick ");
        Task task = wfQueryService.getTaskDetailsById(wfContext, taskId);

        Element payload = task.getPayloadAsElement();
        NodeList nList = payload.getChildNodes();

        System.out.println("Length of nodeList :: " + nList.getLength());

        if (nList.getLength() > 0) {

            for (int count = 0; count < nList.getLength(); count++) {

                Node currentNode = nList.item(count);
                if (currentNode.getNodeType() == Node.ELEMENT_NODE) {

                    // get node name and value
                    /* System.out.println("currentNode Node Name =" + currentNode.getNodeName() + " [OPEN]");
                                    System.out.println("currentNode Node Value =" + currentNode.getTextContent());*/


                    if (currentNode.getNodeName()
                                   .trim()
                                   .contains("InvoiceID")) {
                        invoiceid = currentNode.getTextContent();
                        System.out.println("InvoiceID found on trim ::::" + currentNode.getNodeName() + "--->" +
                                           currentNode.getTextContent());
                        break;

                    }


                    /*if (currentNode.getNodeName().contains("Invoice")){
                                        if (currentNode.getNodeName().contains("ID")){

                                                        invoiceid =currentNode.getTextContent();
                                                                            System.out.println("InvoiceID found  ::::"+currentNode.getNodeName()+"--->"+currentNode.getTextContent());
                                                        break;
                                         }

                                     System.out.println("Invoice Found "+currentNode.getNodeName());

                                }*/


                    /* if (currentNode.hasAttributes()) {

                                            // get attributes names and values
                                            NamedNodeMap nodeMap = currentNode.getAttributes();

                                            for (int i = 0; i < nodeMap.getLength(); i++) {

                                                    Node node = nodeMap.item(i);
                                                    System.out.println("attr name : " + node.getNodeName());
                                                    System.out.println("attr value : " + node.getNodeValue());

                                            }

                                    }

                                    if (currentNode.hasChildNodes()) {


                                        NodeList nCurrentList = currentNode.getChildNodes();




                                            for(int i =0;i<nCurrentList.getLength(); i++ ){

                                                   Node innerNode =nCurrentList.item(i);
                                                if (innerNode.getNodeType() == Node.ELEMENT_NODE) {
                                                        // get node name and value
                                                        System.out.println("Inner nNode Name =" + innerNode.getNodeName() + " [OPEN]");
                                                        System.out.println("Inner Node Value =" + innerNode.getTextContent());
                                                        if(innerNode.getNodeName().equals("InvoiceID")){
                                                            invoiceid =innerNode.getTextContent();
                                                            System.out.println("invoiceid is found!!!!!!!"+invoiceid);
                                                            break;
                                                         }


                                                   }

                                        }
                                            // loop again if has child nodes


                                    }

                                    System.out.println("Node Name =" + currentNode.getNodeName() + " [CLOSE]");

                            }*/

                }
            }

        }


        System.out.println("invoiceid :::" + invoiceid);


    }

    public void calculateWHTAmountOnValueChange(ValueChangeEvent valueChangeEvent) {
        System.out.println("calculateWHTAmountOnValueChange newww!!");
        /*Added on 30th  Nov*/
        String selectedSiteId = siteIdIt.getValue() != null ? siteIdIt.getValue().toString() : null;
        String orgID = getOrganizationId().toString();
        String currency = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;
        String invDate = invDateId.getValue() != null ? invDateId.getValue().toString() : null;
        String selectedWhtCode =
            valueChangeEvent.getNewValue() != null ? valueChangeEvent.getNewValue().toString() : null;
        //System.out.println("Valuechange event :: "+selectedWhtCode);

        ADFContext.getCurrent()
                  .getPageFlowScope()
                  .put("calculateWHTAmountOnValueChange", selectedWhtCode);


        getWHTAmount(selectedSiteId, invDate, currency, orgID);
        System.out.println("Done!!");

    }


    public void calculateWHTAmountOnValueChange2(ValueChangeEvent valueChangeEvent) {
        System.out.println("calculateWHTAmountOnValueChange newww!!");
        /*Added on 30th  Nov*/
        String selectedSiteId = siteIdIt.getValue() != null ? siteIdIt.getValue().toString() : null;
        String orgID = getOrganizationId().toString();
        String currency = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;
        String invDate = invDateId.getValue() != null ? invDateId.getValue().toString() : null;
        String selectedWhtCode =
            valueChangeEvent.getNewValue() != null ? valueChangeEvent.getNewValue().toString() : null;
        System.out.println("Valuechange event :: " + selectedWhtCode);

        //getWHTAmount(selectedSiteId, invDate, currency, orgID);


        RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
        Iterator rowKeySetIt = rowKeySet.iterator();
        DCIteratorBinding lineItemIter =
            ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry())
            .findIteratorBinding("LineItemDetailsEOView1Iterator");
        RowSetIterator lineItemRSIter = null;
        try {
            lineItemRSIter = lineItemIter.getRowSetIterator();
            while (rowKeySetIt.hasNext()) {
                Key key = (Key) ((List) rowKeySetIt.next()).get(0);
                Row currentLineItemRow = lineItemRSIter.getRow(key);
                if (currentLineItemRow != null) {
                    currentLineItemRow.setAttribute("WhtCode", selectedWhtCode);
                    System.out.println("----- Valuechange event selectedWhtCode ----- " +
                                       currentLineItemRow.getAttribute("WhtCode"));
                }
            }

            //AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);

            //System.out.println("Valuechange eventcalling getWHTAmount from selectWHTCode");

            //getWHTAmount(selectedSiteId, invDate, currency, orgID);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lineItemRSIter != null) {
                try {
                    lineItemRSIter.closeRowSetIterator();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
        System.out.println("End selectWhtCode");


        getWHTAmount(selectedSiteId, invDate, currency, orgID);


    }


    public void calculateWHTAmountOnValueChange1(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String enteredWhtCode =
            valueChangeEvent.getNewValue() != null ? valueChangeEvent.getNewValue().toString() : null;

        String selectedSiteId = siteIdIt.getValue() != null ? siteIdIt.getValue().toString() : null;
        String orgID = getOrganizationId().toString();
        String currency = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;
        String invDate = invDateId.getValue() != null ? invDateId.getValue().toString() : null;
        String selectedWhtCode =
            valueChangeEvent.getNewValue() != null ? valueChangeEvent.getNewValue().toString() : null;
        System.out.println("Valuechange event :: " + selectedWhtCode);
        boolean validateWHTCode = false;


        /*Start : Validating whtCode */

        try {


            System.out.println("currencyCodePopupIT.getValue(): " + enteredWhtCode);

            BigDecimal org_Id = getOrganizationId();
            //System.out.println("ORG id value from utility method : "+ org_Id);

            DCBindingContainer dcBindingContainer =
                (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("WhtCodeVO1Iterator");
            ViewObjectImpl whtCodeVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
            ViewCriteria vc = whtCodeVO.getViewCriteria("WhtCodeVOCriteria");
            whtCodeVO.applyViewCriteria(vc);
            whtCodeVO.setNamedWhereClauseParam("bindOrgId", org_Id);
            whtCodeVO.setNamedWhereClauseParam("bindWhtCode", enteredWhtCode);
            //System.out.println("-----------Dynamic Query-----------");
            //System.out.println(whtCodeVO.getQuery());
            whtCodeVO.executeQuery();

            while (whtCodeVO.hasNext()) {
                Row row = whtCodeVO.next();
                int attributeCount = row.getAttributeCount();
                //System.out.println("AtrributeCount :: "+attributeCount + "Atrribute Name is :: "+row.getAttribute(row.getAttributeNames()[0]));
                String[] attributeNames = row.getAttributeNames();
                if (row.getAttribute(row.getAttributeNames()[0]) !=
                    null) {
                    //System.out.println("Valid WHT Code :: "+ row.getAttribute(attributeNames[0]).toString());

                    if (enteredWhtCode != null &&
                        (enteredWhtCode.equals(row.getAttribute(attributeNames[0]).toString()))) {
                        validateWHTCode = true;
                        break;
                    }
                }
            }


            //AdfFacesContext.getCurrentInstance().addPartialTarget(whtCodeDetailsTable);

        } catch (Exception e) {
            e.printStackTrace();
        }


        /*Ends :Validating wht code */


        /* System.out.println("Start selectWhtCode");
            String selectedWhtCode = null;
            RowKeySet whtCodeRowKeySet = whtCodeDetailsTable.getSelectedRowKeys();
            Iterator whtCodeIter = whtCodeRowKeySet.iterator();
            DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding whtCodeVoIter = bindings.findIteratorBinding("WhtCodeVO1Iterator");
            RowSetIterator whtCodeVoRSIter=null;
            try{
                whtCodeVoRSIter = whtCodeVoIter.getRowSetIterator();
                while(whtCodeIter.hasNext()){
                   Key key = (Key)((List)whtCodeIter.next()).get(0);
                   Row currentRow = whtCodeVoRSIter.getRow(key);
                   System.out.println(currentRow.getAttribute("WhtCode"));
                   selectedWhtCode=currentRow.getAttribute("WhtCode").toString();
                }
            }catch(Exception e)
            {e.printStackTrace();
             }
            finally{
                        if(whtCodeVoRSIter!=null) {
                            try {
                                whtCodeVoRSIter.closeRowSetIterator();
                            } catch(Exception ex) {
                                ex.printStackTrace();

                        }
                        }
                    }*/
        if (validateWHTCode) {
            RowKeySet rowKeySet = lineDetailsTable.getSelectedRowKeys();
            Iterator rowKeySetIt = rowKeySet.iterator();
            DCIteratorBinding lineItemIter =
                ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry())
                .findIteratorBinding("LineItemDetailsEOView1Iterator");
            RowSetIterator lineItemRSIter = null;
            try {
                lineItemRSIter = lineItemIter.getRowSetIterator();
                while (rowKeySetIt.hasNext()) {
                    Key key = (Key) ((List) rowKeySetIt.next()).get(0);
                    Row currentLineItemRow = lineItemRSIter.getRow(key);
                    if (currentLineItemRow != null) {
                        currentLineItemRow.setAttribute("WhtCode", selectedWhtCode);
                        //System.out.println("----- Valuechange event selectedWhtCode ----- "+currentLineItemRow.getAttribute("WhtCode"));
                    }
                }

                AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);

                //System.out.println("Valuechange eventcalling getWHTAmount from selectWHTCode");

                getWHTAmount(selectedSiteId, invDate, currency, orgID);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (lineItemRSIter != null) {
                    try {
                        lineItemRSIter.closeRowSetIterator();
                    } catch (Exception ex) {
                        ex.printStackTrace();

                    }
                }
            }
            System.out.println("End selectWhtCode");

        } else {
            //System.out.println("Invalid WHT code thereby resetting to blank");
            DCBindingContainer bindings = getBinding();
            DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
            ViewObject empVO = lineItemIter.getViewObject();
            Row selectedRow = empVO.getCurrentRow();
            //System.out.println("WhtCode value :: "+selectedRow.getAttribute("WhtCode").toString());
            selectedRow.setAttribute("WhtCode", null);
            //System.out.println("WhtCode value :: "+selectedRow.getAttribute("WhtCode"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(whtCodeColumn);
            AdfFacesContext.getCurrentInstance().addPartialTarget(lineDetailsTable);


            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Not a valid WHTCODE", null));


        }
    }

    public void validateWHTAmountOnChnage(FacesContext facesContext, UIComponent uIComponent, Object object) {
        // Add event code here...
        String wht_code = object.toString();
        System.out.println("Test String :" + wht_code.length());
        System.out.println("Validate WhtReqiredFlag :" + whtRequiredFlag.getValue().toString());
        if (wht_code.length() > 0) {
            String enteredWhtCode = object != null ? object.toString().toString() : null;

            String selectedSiteId = siteIdIt.getValue() != null ? siteIdIt.getValue().toString() : null;
            String orgID = getOrganizationId().toString();
            String currency = currencyIt.getValue() != null ? currencyIt.getValue().toString() : null;
            String invDate = invDateId.getValue() != null ? invDateId.getValue().toString() : null;

            System.out.println("validateWHTAmountOnChnage :: " + enteredWhtCode);
            boolean validateWHTCode = false;


            /*Start : Validating whtCode */

            try {


                System.out.println("currencyCodePopupIT.getValue(): " + enteredWhtCode);

                BigDecimal org_Id = getOrganizationId();
                System.out.println("ORG id value from utility method : " + org_Id);

                DCBindingContainer dcBindingContainer =
                    (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("WhtCodeVO1Iterator");
                ViewObjectImpl whtCodeVO = (ViewObjectImpl) dcIteratorBinding.getViewObject();
                ViewCriteria vc = whtCodeVO.getViewCriteria("WhtCodeVOCriteria");
                whtCodeVO.applyViewCriteria(vc);
                whtCodeVO.setNamedWhereClauseParam("bindOrgId", org_Id);
                whtCodeVO.setNamedWhereClauseParam("bindWhtCode", enteredWhtCode);
                //                                    System.out.println("-----------Dynamic Query-----------");
                //                                    System.out.println(whtCodeVO.getQuery());
                whtCodeVO.executeQuery();

                if (whtCodeVO.getEstimatedRowCount() > 0) {
                    System.out.println("Enter Loop");
                    RowSetIterator rowIt = null;
                    try {
                        rowIt = whtCodeVO.createRowSetIterator(null);
                        while (rowIt.hasNext()) {
                            System.out.println("Enter While Loop");
                            Row row = rowIt.next();
                            int attributeCount = row.getAttributeCount();
                            System.out.println("Valid WHT Code :" + row.getAttribute("WhtCode"));
                            System.out.println("AtrributeCount :: " + attributeCount + "Atrribute Name is :: " +
                                               row.getAttribute(row.getAttributeNames()[0]));
                            String[] attributeNames = row.getAttributeNames();
                            if (row.getAttribute(row.getAttributeNames()[0]) != null) {
                                System.out.println("Valid WHT Code :: " +
                                                   row.getAttribute(attributeNames[0]).toString());

                                if (enteredWhtCode != null &&
                                    (enteredWhtCode.equals(row.getAttribute(attributeNames[0]).toString()))) {
                                    System.out.println("ValidateWHTCode : " + validateWHTCode);
                                    validateWHTCode = true;
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (rowIt != null) {
                            try {
                                rowIt.closeRowSetIterator();
                            } catch (Exception ex) {
                                ex.printStackTrace();

                            }
                        }
                    }
                }


                //AdfFacesContext.getCurrentInstance().addPartialTarget(whtCodeDetailsTable);

            } catch (Exception e) {
                e.printStackTrace();
            }


            if (!validateWHTCode) {


                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                              "Please enter a valid WHT Code", null));
            }


        }
    }
    /*

    private String checkLineAmountMagnitude(String documentType) {

            String magnitudeError = null;
            System.out.println("Start : checkLineAmountMagnitude");
            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
            ViewObjectImpl lineVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
            RowSetIterator lineItemItr = null;
            lineItemItr = lineVO.createRowSetIterator(null);
        try{

                if(documentType.equalsIgnoreCase("Credit Note")){
                    System.out.println("inside credit note");
                    while(lineItemItr.hasNext()) {

                         Row row = lineItemItr.next();
                         if(row != null){
                             if(row.getAttribute("LineTotalAmount") != null && Double.parseDouble(row.getAttribute("LineTotalAmount").toString().trim()) > 0){
                                 magnitudeError = "Line Total Amount Value in line No "+row.getAttribute("LineNumber")+" cannot be positive for Credit Note";
                                 return magnitudeError;

                             }
                             else if(row.getAttribute("TaxRate") != null && Double.parseDouble(row.getAttribute("TaxRate").toString().trim()) > 0){
                                 magnitudeError = "Tax Amount Value in line No "+row.getAttribute("LineNumber")+" cannot be positive for Credit Note";
                                 return magnitudeError;
                             }
                         }

                    }

                }

                if(documentType.equalsIgnoreCase("Invoice")){
                    System.out.println("Inside Invoice");
                    while(lineItemItr.hasNext()) {

                         Row row = lineItemItr.next();
                         if(row != null){
                             if(row.getAttribute("LineTotalAmount") != null && Double.parseDouble(row.getAttribute("LineTotalAmount").toString().trim()) < 0){
                                 magnitudeError = "Line Total Amount Value in line No "+row.getAttribute("LineNumber")+" cannot be negative for Invoice";
                                 return magnitudeError;

                             }
                             else if(row.getAttribute("TaxRate") != null && Double.parseDouble(row.getAttribute("TaxRate").toString().trim()) < 0){
                                 magnitudeError = "Tax Amount Value in line No "+row.getAttribute("LineNumber")+" cannot be negative for Invoice";
                                 return magnitudeError;
                             }
                         }

                    }
                }
        }
                catch(Exception e){
                    e.printStackTrace();
                    }finally{
                        if(lineItemItr != null)
                            lineItemItr.closeRowSetIterator();
                    }
        return magnitudeError;
    }*/
}


class FileDescriptor {
    private String filename;
    private byte[] bytedata;

    public FileDescriptor() {
    }

    public FileDescriptor(String filename, byte[] bytedata) {
        super();
        this.filename = filename;
        this.bytedata = bytedata;
    }


    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setBytedata(byte[] bytedata) {
        this.bytedata = bytedata;
    }

    public byte[] getBytedata() {
        return bytedata;
    }
}
