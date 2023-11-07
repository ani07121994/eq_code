package ap.quantas.com;


import ap.qantas.com.eQApprovalDetailsService.APPSQFEQIFAPINVAPPROVERREC;
import ap.qantas.com.eQApprovalDetailsService.APPSQFEQIFAPINVINVDISTINFO;
import ap.qantas.com.eQApprovalDetailsService.ApproverDetails_pttBindingQSPortClient;
import ap.qantas.com.eQApprovalDetailsService.ApproverDetailsPttBindingQSService;

import ap.qantas.com.eQApprovalDetailsService.InputParameters;

import ap.qantas.com.eQApprovalDetailsService.ObjectFactory;

import ap.qantas.com.eQApprovalDetailsService.OutputParameters;

import ap.quantas.com.bamUpdateWebService.DataObjectOperationsByID;
import ap.quantas.com.bamUpdateWebService.DataObjectOperationsByID_Service;
import ap.qantas.com.eQApprovalDetailsService.LineItemTable;

import ap.quantas.com.holdReleaseWebService.StaleObjectFaultMessage;
import ap.quantas.com.holdReleaseWebService.TaskService_Service;
import ap.quantas.com.holdReleaseWebService.WorkflowErrorMessage;
import ap.quantas.com.holdReleaseWebService.oracle.bpel.services.workflow.common.model.CredentialType;
import ap.quantas.com.holdReleaseWebService.oracle.bpel.services.workflow.common.model.WorkflowContextType;
import ap.quantas.com.holdReleaseWebService.oracle.xmlns.bpel.workflow.taskservice.TaskServiceContextTaskTaskIdBaseType;
import ap.quantas.com.imaging.WSSecurityHeaderSOAPHandler;
import ap.quantas.com.imaging.documentUpdate.DocumentService;

import ap.quantas.com.imaging.documentUpdate.DocumentService_Service;

import ap.quantas.com.imaging.documentUpdate.FieldType;
import ap.quantas.com.imaging.documentUpdate.FieldValue;

import ap.quantas.com.imaging.documentUpdate.TypedValue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import java.util.Set;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.PhaseId;

import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

import model.APOperationAMImpl;

import model.EbsAMImpl;

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
import oracle.adf.view.rich.component.rich.output.RichInlineFrame;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.bpel.services.workflow.StaleObjectException;
import oracle.bpel.services.workflow.WorkflowException;
import oracle.bpel.services.workflow.client.IWorkflowServiceClient;

import oracle.bpel.services.workflow.query.ITaskQueryService;
import oracle.bpel.services.workflow.task.ITaskService;
import oracle.bpel.services.workflow.task.model.CustomAttributesType;
import oracle.bpel.services.workflow.task.model.SystemAttributesType;
import oracle.bpel.services.workflow.task.model.Task;
import oracle.bpel.services.workflow.verification.IWorkflowContext;
import oracle.bpel.services.workflow.worklist.adf.ADFWorklistBeanUtil;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Number;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.ComponentUtils;
import org.apache.myfaces.trinidad.util.Service;

public class CertifierUIBean {
    private RichInlineFrame invInlineFrame;
    //TODO: Remove Hardcoding
    String docId = "2.IPM_001550";
    private RichPanelGroupLayout outerPgl;
    private RichTable lineItemsTable;
    private RichPanelGroupLayout bottomOuterPgl;
    private RichPopup p1;
    private RichPopup p2;
    private RichPopup p3;
    private RichPopup p4;
    private RichPopup p5;
    private RichPopup p6;
    private RichInputText expOrgPopUpIt;
    private RichTable expOrgTable;
    private RichInputText projNoPopupIt;
    private RichTable projDtlTable;
    private RichInputText taskNoPopupIt;
    private RichTable taskDtlTable;
    private RichInputText poNumberIt;
    private RichInputText alternateApproverIt;
    private RichInputText eleciRemNoIt;
    private RichInputText companyNameIt;
    private RichInputText costCentreIT;
    private RichInputText accountNameIt;
    private RichInputText analysisCodeIt;
    private RichInputText counterPartyIt;
    private RichPopup p9;
    private RichInputText companyNamePopupIt;
    private RichTable companyDetailsTable;
    private RichPopup p10;
    private RichInputText costCentrePopupIt;
    private RichTable costCentreDetailsTable;
    private RichPopup p11;
    private RichInputText accountNamePopupIt;
    private RichTable accountDetailsTable;
    private RichPopup p12;
    private RichInputText analysisCodePopupIt;
    private RichTable analysisCodeDetailsTable;
    private RichPopup p13;
    private RichInputText counterPartyPopupIt;
    private RichTable counterPartyDetailsTable;
    private RichInputText clientID;
    private RichInputText invoiceTypeIT;
    private RichInputText siteIdIt;
    private RichInputText taxRateCodePopupIt;
    private RichTable taxRateCodeDetailsTable;
    private RichPopup validationErrorPopup;
    private RichOutputText validationErrorMessage;
    private RichPopup p16;
    private RichPopup p14;
    private RichTable alternateApproverDetailsTable;
    private RichInputText alternateAppoverPopupIT;
    private RichInputText projectNoIT;
    private RichInputText taskNoIT;
    private RichInputText expOrgIT;
    private RichPopup p7;
    private RichPopup p8;
    private RichInputText reassignPopupIT;
    private RichTable reassignDetailsTable;
    private RichInputText reassignToIT;
    private RichPanelFormLayout glCodePgl;
    private RichInputText reassingToIDPopupIT;
    private RichInputText expenditurePopupIT;
    private RichInputDate expDateIT;
    private RichPopup commentPopup;
    private RichInputText commentsPopupIt;
    private RichInputText commentsIt;
    private RichCommandImageLink showPONumberPopup;
    private RichInputText poNumIt;
    private RichInputText poNumPopupIt;
    private RichTable poDetailsTable;
    private RichPopup p17;
    private RichOutputText companyNameOt;
    private RichOutputText costCentreOt;
    private RichOutputText accountNameOt;
    private RichOutputText analysisCodeOt;
    private RichOutputText counterPartyOt;

    private RichInputText orgIdIt;
    private RichInputText projectIdIt;
    private RichPopup p18;
    private RichInputText expTypePopUpIt;
    private RichTable expTypeDetailsTable;
    private RichInputText expTypeIt;
    private RichCommandImageLink glCodeSearchIcon;
    private RichInputText glCode;
    private RichCommandImageLink projectNoSearchIcon;
    private RichOutputText glCodeErrorOt;
    private RichInputText rejectionReasonIt;
    private RichPanelFormLayout pf12;
    private RichPanelGroupLayout pg147;
    private RichSelectOneChoice lineTypeSOC;
    private RichInputText taxAmountIt;
    private HashMap<Integer,Double> taxAmount=null;
    private RichInputText lineNoIt;
    private RichPanelGroupLayout pg148;
    private RichSelectOneChoice invalidReasonCodeSoc;
    private RichOutputText invalidReasonOt;
    private RichCommandButton onReassignCommentsClick;
    private RichInputText reassignCommentsPopupIt;
    private RichInputText reassignCommentsIt;
    private RichPopup reassignCommentPopup;
    private RichTable poNoCertifierTable;
    private RichSelectOneChoice companySoc;
    private RichSelectOneChoice costcenterSoc;
    private RichSelectOneChoice accountSoc;
    private RichSelectOneChoice analysisCodeSoc;
    private RichSelectOneChoice counterPartySoc;
    private RichPopup descPopup;
    private RichInputText descPopupIt;
    private RichInputText lineIdIt;
    private RichInputText taxTotIt;
    private RichInputText headerTotIt;
    private RichInputText operatingUnitIt;
    private RichInputText lineTotal;
    private RichSelectOneChoice reasonTypeSoc;
    private RichInputText supplierName;
    private RichInputText reassignCommentsText;
    private RichPopup reassignmentDisabledPopoUp;
    private RichInputText disabledReassignmentInputText;
    private RichInputText certifierApproveComments;
    private RichPopup certifierApprovePopup;
    private RichInputText certifierApprovePopupIt;
    private RichOutputText lineTotalSum;
    private RichOutputText taxAmountSum;
    private RichInputText siteName;
    private RichTable apCommentsTable;
    private RichPopup apCommentsTableDescPopup;
    private RichInputText apCommentsTableDescPopUpIt;
    private RichSelectBooleanCheckbox subCheckBox;
    private RichSelectBooleanCheckbox parentCheckBox;
    private RichOutputText sumOfLineTotal;
    private RichOutputText sumOfTaxTotal;
    private RichPopup p20;
    private RichPopup p24;
    private RichInputText holdCommentsIt;
    private RichInputText releaseCommentsIt;
    private RichCommandButton holdButton;
    private RichCommandButton releaseButton;
    private RichForm certifierPageForm;
    private RichSelectOneChoice searchByCertifiername;

    private RichPopup certifierApproverListPopUp;
    private RichTable eqApproverDetailsTable;
    private RichCommandButton autoFillButton;
    private RichCommandButton rejectButton;
    private RichCommandButton reassignButton;
    private RichCommandButton submitButton;
    private RichCommandButton saveButton;
    private RichInputText taskIdIt;
    private RichInputText reassignEmailIdIT;
    private RichInputText recCode;
    private RichPopup p26;
    private RichInputText poNumLinePopupIt;
    private RichInputText onLinePONumPopupGoClick;
    private RichInputText linePONumPopUpIt;
    private RichCommandImageLink taskNoSearchIcon;
    private RichCommandImageLink expenditureOrgSearchIcon;
    private RichCommandImageLink expenditureTypeSearchIcon;
    private RichCommandImageLink linePONumberSearchIcon;
    private RichInputText linePONumIT;
    private RichCommandImageLink poLineNumberSearchIcon;
    private RichInputText poLineNumIT;
    private RichTable poLineNumberTable;
    private RichPopup p27;
    private RichInputText poLineNumPopupIt;
    private RichInputText poNumClientID;
    private RichInputText isLineItemPopup;
    private RichInputText isPOLineItemPopup;
    private RichInputText linePONumClientID;
    private RichInputText poLineNumClientID;
    private RichInputText documentTypeIT;
    private RichInputText electRemittencePopUpIt;
    private RichPopup electRemittencePopup;
    private RichInputText invNumIt;

    private  RichCommandImageLink electRemittenceLink;

    public int saveoperationvar; //added by raha for exception handling requirement
    //public String selectedProjectId=null; //added by raha for
    //NO PO 923018- Start
    private RichOutputText noPOErrorMessage;
    private RichPanelGroupLayout noPOPanelGroupLaylout;
        //NO PO 923018 -End

    public CertifierUIBean() {
        //System.out.println("Within Certifier constructor");
        taxAmount=new HashMap<Integer,Double>();

    }

    public void afterPhase(javax.faces.event.PhaseEvent phaseEvent) {
    }

    public static APOperationAMImpl getAm() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Application app = fc.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, "#{data.APOperationAMDataControl.dataProvider}",
                                            Object.class);
        return (APOperationAMImpl)valueExp.getValue(elContext);
    }

    private String getInvoiceId() {
        String invoiceIdFromBinding = null;;
        if(resolveExpression("#{bindings.invoiceID.inputValue}") != null)
            invoiceIdFromBinding = resolveExpression("#{bindings.invoiceID.inputValue}").toString();

        //TODO: Remove hardcoding
//        if(invoiceIdFromBinding == null)
//            invoiceIdFromBinding = "1";

        return invoiceIdFromBinding;
    }

    public void setInvInlineFrame(RichInlineFrame invInlineFrame) {
        this.invInlineFrame = invInlineFrame;
    }

    public RichInlineFrame getInvInlineFrame() {
        return invInlineFrame;
    }

    public static Object resolveExpression(String expression)
    {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp =
        elFactory.createValueExpression(elContext, expression, Object.class);
        return valueExp.getValue(elContext);
    }

    public static FacesContext getFacesContext()
    {
        return FacesContext.getCurrentInstance();
    }

    public void setOuterPgl(RichPanelGroupLayout outerPgl) {
        this.outerPgl = outerPgl;
    }

    public RichPanelGroupLayout getOuterPgl() {
        return outerPgl;
    }

    public void setLineItemsTable(RichTable lineItemsTable) {
        this.lineItemsTable = lineItemsTable;
    }

    public RichTable getLineItemsTable() {
        return lineItemsTable;
    }

    public void setBottomOuterPgl(RichPanelGroupLayout bottomOuterPgl) {
        this.bottomOuterPgl = bottomOuterPgl;
    }

    public RichPanelGroupLayout getBottomOuterPgl() {
        return bottomOuterPgl;
    }

    public static void setExpressionResetValue(String expression,
                                              Object newValue) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Application app = ctx.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = ctx.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
        valueExp.setValue(elContext, newValue);
    }

    public void onRejectClick(ActionEvent actionEvent) {
        System.out.println("Start onRejectClick");
        try {

            setExpressionResetValue("#{bindings.InvalidReasonId.inputValue}","18");
            AdfFacesContext.getCurrentInstance().addPartialTarget(invalidReasonCodeSoc);
            //Object InvalidReasonIdAttribute = ADFUtils.evaluateEL("#{bindings.InvalidReasonId.selectedValue.attributeValues[1]");
            //System.out.println("INVALID_REASON ::::: "+ InvalidReasonIdAttribute);
            RichPopup.PopupHints hints = new RichPopup.PopupHints();

            commentsIt.setValue("");
            p1.show(hints);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onRejectClick");
    }

    public void onReassignClick(ActionEvent actionEvent) {
        System.out.println("Start onReassignClick");
        try {
            // clear the fields of reassign to and comments
            reassignToIT.setValue("");
            reassignCommentsIt.setValue("");
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p2.show(hints);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onReassignClick");
    }
    public void onHoldClick(ActionEvent actionEvent) {
        System.out.println("Start onHoldClick");
        try {

            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p20.show(hints);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onHoldClick");
    }

    public void onReleaseClick(ActionEvent actionEvent) {
        System.out.println("Start onReleaseClick");
        try {

            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p24.show(hints);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onReleaseClick");
    }

    public boolean validateEmptyLines(){
        RowSetIterator lineItemItr = null;
        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObjectImpl lineVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
        //System.out.println("------------lineVO Count validateEmptyLines(): "+lineVO.getEstimatedRowCount());
        lineItemItr = lineVO.createRowSetIterator(null);
        String message= null;
        Integer line;
        boolean validateFlag = true;
        while(lineItemItr.hasNext()) {
         Row lineRow = lineItemItr.next();
         if(lineRow.getAttribute("LineTotalAmount")==null || lineRow.getAttribute("LineTotalAmount").equals("")) {
             validateFlag = false;
             line = ((oracle.jbo.domain.Number)lineRow.getAttribute("LineNumber")).intValue();
             message="Please Enter the Line total in the line "+ line +" before submitting the invoice";
             callFacesMessage(message);
             break;
         }
         else if(lineRow.getAttribute("TaxRateCode")==null || lineRow.getAttribute("TaxRateCode").equals("")){
             validateFlag = false;
             line = ((oracle.jbo.domain.Number)lineRow.getAttribute("LineNumber")).intValue();
             message="Please Enter the Tax code in the line "+ line +" before submit";
             callFacesMessage(message);
             break;
         }
         //Added by Raha 18*12*2019 for addition of tax amount and linetot sum validation
          else if(lineRow.getAttribute("TaxAmountLineitem")==null || lineRow.getAttribute("TaxAmountLineitem").equals("")){
              validateFlag = false;
              line = ((oracle.jbo.domain.Number)lineRow.getAttribute("LineNumber")).intValue();
              message="Please Enter the Tax Amount in the line "+ line +" before submit";
              callFacesMessage(message);
              break;
          }
        }// ended by raha
        return validateFlag;
    }

    public boolean validateAmountCalculation() {
        double lineTotal = Double.MIN_VALUE;
        String invNum = null;
        String message=null;
        String taxamount=null;
        double sumoflinetot= Double.MIN_VALUE;
        double sumOfTaxTot= Double.MIN_VALUE;

        if(invNumIt.getValue()!=null){
            invNum = (String)invNumIt.getValue();
        }
        if(lineIdIt.getValue()!=null) {
            lineTotal = Double.parseDouble((String)lineIdIt.getValue());
            System.out.println("invNum: "+invNum+"  **********lineTotal**********"+lineTotal);
        }

        double taxTotal = Double.MIN_VALUE;
        if(taxTotIt.getValue()!=null) {
            taxTotal = ((oracle.jbo.domain.Number)taxTotIt.getValue()).getValue();
            System.out.println("invNum: "+invNum+"   **********taxTotal**********"+taxTotal);
        }
        double headerTotal = Double.MIN_VALUE;
        if(headerTotIt.getValue()!=null) {
            headerTotal = ((oracle.jbo.domain.Number)headerTotIt.getValue()).getValue();
            System.out.println("invNum: "+invNum+"    **********headerTotal**********"+headerTotal);

        }
       /* if(taxAmountIt.getValue()!=null) {
            taxamount = taxAmountIt.getValue().toString();
            System.out.println("invNum: "+invNum+"    **********taxamount**********"+taxamount);

        }*/
       //Added by Raha 18*12*2019 for addition of tax amount and linetot sum validation
        if(sumOfLineTotal.getValue()!=null) {
            sumoflinetot = Double.parseDouble((String)(sumOfLineTotal.getValue().toString()));
            System.out.println("invNum: "+invNum+"    **********sumoflinetot**********"+sumoflinetot);

        }
        if(sumOfTaxTotal.getValue()!=null) {
            sumOfTaxTot = Double.parseDouble((String)(sumOfTaxTotal.getValue().toString()));
            System.out.println("invNum: "+invNum+"    **********sumofTaxtot**********"+sumOfTaxTot);

        }//ended by raha
        RowSetIterator lineItemItr = null;
        RowSetIterator rs = null;
        try{

        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObjectImpl lineVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();

        ArrayList<HashMap<String, Object>> lineItems = new ArrayList<HashMap<String,Object>>();
        //System.out.println("------------lineVO Count: "+lineVO.getEstimatedRowCount());


        lineItemItr = lineVO.createRowSetIterator(null);
        while(lineItemItr.hasNext()) {
            Row row = lineItemItr.next();
            //System.out.println("----- Line Item ----");
            long lineItem_LineNumber = -1;
            if(row.getAttribute("LineNumber")!=null) {
                lineItem_LineNumber = (long)(((oracle.jbo.domain.Number)row.getAttribute("LineNumber")).getValue());
            }
            double lineItem_LineTotal = 0.0;
            double lineItem_TaxAmount = 0.0;
            //System.out.println("-----------Amount: "+row.getAttribute("LineTotalAmount"));
            if(row.getAttribute("LineTotalAmount")!=null) {
                lineItem_LineTotal = ((oracle.jbo.domain.Number)row.getAttribute("LineTotalAmount")).getValue();
            }
            if(row.getAttribute("TaxAmountLineitem")!=null) {
                try {
                    lineItem_TaxAmount = Double.parseDouble((String)row.getAttribute("TaxAmountLineitem"));
                    //System.out.println("lineItem_TaxAmount within TaxAmountLineitem: "+lineItem_TaxAmount);
                } catch(Exception e) {
                    lineItem_TaxAmount = 0.0;
                    e.printStackTrace();
                }
            }

            //System.out.println("\tline item tax amount : "+lineItem_TaxAmount);

            //System.out.println("\t Line Total : "+lineItem_LineTotal);
            HashMap<String, Object> lineItem = new HashMap<String, Object>();
            lineItem.put("LineNumber",          lineItem_LineNumber);
            lineItem.put("LineTotalAmount",     lineItem_LineTotal);
            lineItem.put("TaxAmountLineitem",              lineItem_TaxAmount);
            lineItems.add(lineItem);
        }

        double lineItems_TotalAmount_Sum = 0;
        double lineItems_TaxAmount_Sum = 0;

        for(int i=0; i<lineItems.size(); i++) {
            lineItems_TotalAmount_Sum += (Double)lineItems.get(i).get("LineTotalAmount");
            lineItems_TaxAmount_Sum += (Double)lineItems.get(i).get("TaxAmountLineitem");
        }

            System.out.println("invNum: "+invNum+"   -----lineItems_TotalAmount_Sum:"+lineItems_TotalAmount_Sum+", lineItems_TaxAmount_Sum:"+lineItems_TaxAmount_Sum);
            System.out.println("invNum: "+invNum+"   -----lineItems_TotalAmount_Sum+lineItems_TaxAmount_Sum:"+(lineItems_TotalAmount_Sum+lineItems_TaxAmount_Sum));

        DecimalFormat newFormat = new DecimalFormat("#.##");

            System.out.println("invNum: "+invNum+"  -----Left side : "+Double.valueOf(newFormat.format(lineItems_TotalAmount_Sum+lineItems_TaxAmount_Sum)).doubleValue());
            System.out.println("invNum: "+invNum+"  -----Right side : "+Double.valueOf(newFormat.format(headerTotal)).doubleValue());


        //if(lineItems_TotalAmount_Sum+lineItems_TaxAmount_Sum!=headerTotal) {
        if( Double.valueOf(newFormat.format(lineItems_TotalAmount_Sum+lineItems_TaxAmount_Sum)).doubleValue() != Double.valueOf(newFormat.format(headerTotal)).doubleValue() ) {
            ViewObjectImpl vo = Utility.getAm().getErrorCodeLookupVO1();

            vo.setNamedWhereClauseParam("bindReasonType", 5);
            vo.executeQuery();
            rs = vo.createRowSetIterator(null);
            rs.reset();
            String errorMessageLookup = null;
            while(rs.hasNext()){
                Row r = rs.next();
                errorMessageLookup = (String)r.getAttribute("ErrorMessage");
            }

            String poNum = poNumIt.getValue()!=null ? poNumIt.getValue().toString() : null;

            if( errorMessageLookup!=null && ( poNum==null || (poNum!=null && poNum.trim().equals("")) ) ) {
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                validationErrorPopup.show(hints);
                this.validationErrorMessage.setValue(errorMessageLookup);
                return false;
            }
        }
            //System.out.println("lineIdIt::::"+lineIdIt.getValue().toString());
           // System.out.println("tax amount:::"+taxamount);
            //Added by Raha 18*12*2019 for addition of tax amount and linetot sum validation
            if(sumoflinetot!=lineTotal){
                System.out.println("inside linetotal validation");
                message="Line total and Header Line total is not matching , please correct that to submit";
                callFacesMessage(message);
                return false;
            }
            if(sumOfTaxTot!=taxTotal){
                System.out.println("inside taxtotal validation");
                message="Line Tax Total and Header Tax total is not matching , please correct that to submit";
                callFacesMessage(message);
                return false;
            }
            //ended by raha
            /*else if(taxamount==null){
                System.out.println("Tax amount should not be null value");
                message="Tax amount should not be null value";
                callFacesMessage(message);
                return false;
            }*/
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
                if(lineItemItr!=null) {
                    try {
                        //lineItemItr.closeRowSetIterator();
                    } catch(Exception ex) {
                        ex.printStackTrace();
                }
                }
                    if(rs!=null) {
                        try {
                            //rs.closeRowSetIterator();
                        } catch(Exception ex) {
                            ex.printStackTrace();
                    }
                    }
                }

        return true;
    }



    public void onSubmitClick(ActionEvent actionEvent) {
        System.out.println("Start onSubmitClick");
        //glCode
        String poNum;
        RowSetIterator lineItemItr = null;
      //  submitFromCertifier();
        try{
             boolean flagGlCodePresent=false;
             poNum = poNumIt.getValue()!=null ? poNumIt.getValue().toString() : null;
            //System.out.println("onSubmitClick ::::  "+ ""+ "poNum ::: "+ poNum);
            String invNum = null;
            if(invNumIt.getValue()!=null){
                invNum = (String)invNumIt.getValue();
            }
            //923018-Start
            String invoiceType=null;
            if(resolveExpression("#{bindings.InvoiceType.inputValue}") != null)
                invoiceType = resolveExpression("#{bindings.InvoiceType.inputValue}").toString();
            String noPoSiteStatus=(String)ADFContext.getCurrent().getPageFlowScope().get("NOPOStatusFlag");
            //System.out.println("invoiceType : "+invoiceType);
            System.out.println("noPoStatus : "+noPoSiteStatus);
            if("Non PO Invoice".equalsIgnoreCase(invoiceType) && "Y".equalsIgnoreCase(noPoSiteStatus)&& ( poNum==null || (poNum!=null && poNum.trim().equals("")))){
                System.out.println("************Certifier Validation NO PO is executing *****************");

               // String message = "<html> Some message"+"Goto <a href=http://www.google.com>Google</a></html>";
               String message =
                "<html>This Supplier requires a valid & open Purchase Order (PO). See Procurement SharePoint page for Qantas Group Purchasing Policy & Guidelines.<br><br>" +"You must enter the valid & approved PO number below and match PO line/s.<br>" +
                "Ensure you receipt your PO in iProcurement to process your invoice for payment.<br><br>" +
                "<a href = \"mailto: procurementhelp@qantas.com.au\">Contact procurementhelp@qantas.com.au for assistance if required</a>" +
                "</html>";

           /* String message =
                 "<html>This Supplier requires a valid Purchase Order (PO) as part of the <br><a onclick=\"window.open ('http://www.google.com', ''); return false\" href=\"javascript:void(0);\"> ABBB Qantas Group Purchasing Policy & Guidelines</a>.<br><br>" +"You must enter a valid PO number and match PO line/s.<br>" +
                 "Ensure you receipt your PO in iProcurement to process your invoice for payment.<br><br>" +
                 "Contact <a href = \"mailto: procurementhelp@qantas.com.au\">procurementhelp@qantas.com.au</a> for assistance if required" +
                 "</html>";*/

                //System.out.println("message ::::: : "+message);
                callFacesMessage(message);
                return;
            }
            //923018 -End
              if(!( poNum==null || (poNum!=null && poNum.trim().equals(""))) ){
             // samplecheck();

              System.out.println("PO Number is present");

              /*** Validation of Header PO***/
             /*
              if(!isValidHeaderPO(poNum)){
                String message=null;
                message="Please enter valid Header PO Number";
                callFacesMessage(message);
                return;
              }*/
             /*
              /**** Check for empty Line level PO
              if(!emptyLineLevelPO())
                  return;

              /** Add validations of line level POs

              if(!validateLinePOs())
                return;
              */
            /*  if(!validateEmptyLines()) {
                    return;
                          }

              if(!validateTaxAmount()){
                    return;
                }

              if(!validateAmountCalculation()) {
                    return;
                }*/

            System.out.println("invNum:"+invNum+" ****************************** IF BLOCK *************");
              submitFromCertifier();
                      }
                else{

                System.out.println("invNum:"+invNum+" ****************************** ELSE BLOCK *************");
        DCBindingContainer dc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        ViewObject lineItemVO= dc.findIteratorBinding("LineItemDetailsEOView1Iterator").getViewObject();

        if(lineItemVO.getEstimatedRowCount()>0){
             lineItemItr=lineItemVO.createRowSetIterator(null);
             while(lineItemItr.hasNext()) {
                 Row lineItemRow=lineItemItr.next();
                 /**GBP issue fix code */

                 boolean isValidGLCode = false;
                 String message =null;
                 Integer line=1;
                 boolean flag_validCode = false;

                 if (lineItemRow.getAttribute("TaxRateCode") != null ) {

                     // isValidGLCode = false;
                     String enteredTaxrate =lineItemRow.getAttribute("TaxRateCode").toString();
                     System.out.println("invNum:"+invNum+"GBP ISSUE ::: enteredTaxrate "+ enteredTaxrate);
                     //System.out.println("GBP ISSUE ::: isValidGLCode "+ isValidGLCode);


                    /**check if entered Taxrate falls with the validtax rate code **/


                     DCBindingContainer dcBindingContainer_tax = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                     DCIteratorBinding dcIteratorBinding_tax = dcBindingContainer_tax.findIteratorBinding("TaxRateCodeLookupVO1Iterator");
                     ViewObjectImpl taxRateCodeVO = (ViewObjectImpl)dcIteratorBinding_tax.getViewObject();
                     ViewCriteria vc1_tax = taxRateCodeVO.getViewCriteria("TaxRateCodeLookupVOCriteria_lookupBySiteId");
                     taxRateCodeVO.applyViewCriteria(vc1_tax);
                     taxRateCodeVO.setNamedWhereClauseParam("bind_siteId", siteIdIt.getValue()==null?"":siteIdIt.getValue().toString().trim());
                     taxRateCodeVO.setNamedWhereClauseParam("bind_taxRateCode",lineItemRow.getAttribute("TaxRateCode").toString());
                     taxRateCodeVO.executeQuery();
                     System.out.println("taxRateCodeVO.executeQuery() gbp issue "+taxRateCodeVO.getEstimatedRowCount());
                     String flagValue=AdfFacesContext.getCurrentInstance().getPageFlowScope().get("LineItemAddFlagCertifier").toString();
                     boolean flag=Boolean.parseBoolean(flagValue);
                     System.out.println("Adf Scope LineItemAddFlagCertifier : "+AdfFacesContext.getCurrentInstance().getPageFlowScope().get("LineItemAddFlagCertifier"));
                     if(flag){
                         if (taxRateCodeVO.getEstimatedRowCount()>0)
                         {
                          Row row = taxRateCodeVO.getCurrentRow(); // Get the next row in the result set.
                         //                             System.out.println("Current Row : "+taxRateCodeVO.getCurrentRow());
                            System.out.println("Row Index : "+taxRateCodeVO.getCurrentRowIndex());
                             System.out.println("taxratecode of the current line row ::"+row.getAttribute("TaxRateCode"));
                             if(row.getAttribute("TaxRateCode")!=null && row.getAttribute("TaxRateCode").toString().equals(enteredTaxrate)){
                                 flag_validCode=true;
                                 System.out.println("Flag ValidCode : "+flag_validCode);
                             }
                         }
                     }
                     else{
                         while (taxRateCodeVO.hasNext())
                         {
                          Row row = taxRateCodeVO.next(); // Get the next row in the result set.
                            System.out.println("Row Index : "+taxRateCodeVO.getCurrentRowIndex());
                             System.out.println("taxratecode of the current line row ::"+row.getAttribute("TaxRateCode"));
                             if(row.getAttribute("TaxRateCode")!=null && row.getAttribute("TaxRateCode").toString().equals(enteredTaxrate)){
                                 flag_validCode=true;
                                 System.out.println("Flag ValidCode : "+flag_validCode);
                             }
                         } //end of while loop for taxrate check
                     }

                       if(!flag_validCode){
                         message="The tax rate code entered by you in line "+line+"is invalid. Please re-enter a valid tax rate code in order to submit";
                         callFacesMessage(message);


                      return;

                     }

                    /**check if entered Taxrate falls with the validtax rate code **/

                 }
                 //923018-New validation message on quantity ,unit price and line Total
                                  if(lineItemRow.getAttribute("UnitPrice")!=null  && lineItemRow.getAttribute("Quantity")!=null  && lineItemRow.getAttribute("LineTotalAmount")!=null ) {

                                      double lineItems_TotalAmount =  Double.parseDouble(lineItemRow.getAttribute("LineTotalAmount").toString().trim());
                                      double lineItems_Quantity = Double.parseDouble(lineItemRow.getAttribute("Quantity").toString().trim()) ;
                                      double lineItems_Unit = Double.parseDouble(lineItemRow.getAttribute("UnitPrice").toString().trim());
                                      double match_Total=lineItems_Quantity*lineItems_Unit;
                                      System.out.println("match_Total  inside onSubmitClick ::: "+match_Total+"  Line Total **: "+lineItems_TotalAmount+", lineItems_Quantity ** : "+ lineItems_Quantity+", lineItems_Unit **: "+lineItems_Unit);
                                      if(match_Total != lineItems_TotalAmount){
                                              Integer line1 = ((oracle.jbo.domain.Number)lineItemRow.getAttribute("LineNumber")).intValue();
                                         String message1 =  "Line Total should match to Unit Price*Qantity in "
                                                               + "Line Number : "+line1;
                                                                   callFacesMessage(message1);
                                                                   return;
                                          }

                                  }
                  //923018-New validation message on quantity ,unit price and line Total
                 line++;

                 /**GBP issue fix code **/










                 if(lineItemRow.getAttribute("GlNo")!=null || lineItemRow.getAttribute("ProjectNo") != null){
                     //System.out.println("GLNo ::"+lineItemRow.getAttribute("GlNo"));
                     //System.out.println("ProjectNo ::"+lineItemRow.getAttribute("ProjectNo"));
                     flagGlCodePresent=true;

                 }
             }
        }

        System.out.println("flagGlCodePresent"+flagGlCodePresent);
        if(flagGlCodePresent){

            ApproverDetails_pttBindingQSPortClient approverDetailsClient=new ApproverDetails_pttBindingQSPortClient();
            String alternateApproverName=null;
            String alternateApproverNo=null;
//            enteredProjNo!=null && !enteredProjNo.equals("") && enteredProjNo!="" && enteredProjNo.trim()!=null && !enteredProjNo.trim().isEmpty()
//            if(alternateApproverIt!=null || (alternateApproverIt!=null && !alternateApproverIt.equals(""))){
//              alternateApproverName= alternateApproverIt.getValue().toString();
//              System.out.println("alternateApproverName***"+alternateApproverName);
//            }

//            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("approverID", approverPersonID);
            alternateApproverNo=AdfFacesContext.getCurrentInstance().getPageFlowScope().get("approverID")!=null?AdfFacesContext.getCurrentInstance().getPageFlowScope().get("approverID").toString():null;

            /* Get the header details values */
            DCBindingContainer bindings = getBindings();
            DCIteratorBinding dcIteratorBindings =
                bindings.findIteratorBinding("HeaderDetailsEOView1Iterator");
            ViewObject headerVO = dcIteratorBindings.getViewObject();
            Row headerRow = headerVO.getCurrentRow();
            BigDecimal orgId = null;
            String orgIDStr=null;
            BigDecimal supplierId = null;
            BigDecimal invoiceTotAmountbd =null;
            String siteId=null;
            if (headerRow != null) {
                String supplierName =
                    headerRow.getAttribute("SupplierName") != null ?
                    headerRow.getAttribute("SupplierName").toString() : null;
                //System.out.println("SupplierName ::: "+ supplierName);
                siteId =
                    headerRow.getAttribute("SiteId") != null ? headerRow.getAttribute("SiteId").toString() :
                    null;
                //System.out.println("SiteId ::: "+ siteId);
                }



       String orgIdstr= AdfFacesContext.getCurrentInstance().getPageFlowScope().get("OrgID")!=null?AdfFacesContext.getCurrentInstance().getPageFlowScope().get("OrgID").toString():null;
       orgId=new BigDecimal(orgIdstr);
       System.out.println("orgId From pageflowscope"+orgId);

                BigDecimal invoiceTotAmount =
                    headerRow.getAttribute("InvoiceTotAmount") != null ?
                    ((Number)headerRow.getAttribute("InvoiceTotAmount")).bigDecimalValue() :
                    null;
                //System.out.println("invoiceTotAmount ::: "+ invoiceTotAmount);
                String requestorNo=null;
                requestorNo=fetchEmployeeID();
//                requestorNo = AdfFacesContext.getCurrentInstance().getPageFlowScope().get("employeeNumber")!=null?AdfFacesContext.getCurrentInstance().getPageFlowScope().get("employeeNumber").toString():null;
                System.out.println("requestorNo :::"+requestorNo);

//                DCBindingContainer dc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
//                ViewObject lineItemVO= dc.findIteratorBinding("LineItemDetailsEOView1Iterator").getViewObject();
//                rsI = lineItemVO.createRowSetIterator(null);

                List<APPSQFEQIFAPINVINVDISTINFO> invoiceLineItemdetailsList =new ArrayList<APPSQFEQIFAPINVINVDISTINFO>();
                ObjectFactory objectFactory =new ap.qantas.com.eQApprovalDetailsService.ObjectFactory();

//                List<LineItemTable> lineItemRows=new ArrayList<LineItemTable>();
//                while(rsI.hasNext()){

                for(int i=0;i<lineItemVO.getEstimatedRowCount();i++){
                    BigDecimal lineNo=null;
                    String lineType=null;
                    String glCodeComb=null;


                    lineNo=new BigDecimal(lineItemVO.getCurrentRow().getAttribute("LineNumber").toString());
//                    lineType=lineItemVO.getCurrentRow().getAttribute("LineType").toString();
                    lineType="ITEM";
                    glCodeComb=lineItemVO.getCurrentRow().getAttribute("GlNo")!=null?lineItemVO.getCurrentRow().getAttribute("GlNo").toString():null;
                    /*System.out.println("line item details************");
                    System.out.println("lineNo"+lineNo);
                    System.out.println("lineType"+lineType);
                    System.out.println("glCodeComb"+glCodeComb);*/

//                    LineItemTable lineItemobj= new LineItemTable();

                    APPSQFEQIFAPINVINVDISTINFO lineItemobj=new APPSQFEQIFAPINVINVDISTINFO();
                    objectFactory.createAPPSQFEQIFAPINVINVDISTINFOLINENUMBER(lineNo);
                    lineItemobj.setLINENUMBER( objectFactory.createAPPSQFEQIFAPINVINVDISTINFOLINENUMBER(lineNo));
                    lineItemobj.setLINETYPE( objectFactory.createAPPSQFEQIFAPINVINVDISTINFOLINETYPE(lineType));
                    lineItemobj.setGLCODECOMB( objectFactory.createAPPSQFEQIFAPINVINVDISTINFOGLCODECOMB(glCodeComb));
//                    lineItemobj.setLinenumber(lineNo);
//                    lineItemobj.setLinetype(lineType);
//                    lineItemobj.setGlcodecomb(glCodeComb);

//                    lineItemRows.set(i, lineItemobj);
                    invoiceLineItemdetailsList.add(i, lineItemobj);

                }


                List<APPSQFEQIFAPINVAPPROVERREC> approverListheaderObj=new ArrayList<APPSQFEQIFAPINVAPPROVERREC>();
                System.out.println("size of approverListheaderObj.size()"+approverListheaderObj.size());
//                APPSQFEQIFAPINVAPPROVERREC approverList=new APPSQFEQIFAPINVAPPROVERREC();

               /*  public static List<APPSQFEQIFAPINVAPPROVERREC> getApproverDetails(String reqestorNumber,
                                          String alternateApprvNumber,
                                          BigDecimal invoiceamount,
                                          BigDecimal orgid,
                                          List<APPSQFEQIFAPINVINVDISTINFO> lineItemTableDetails) */


                approverListheaderObj=approverDetailsClient.getApproverDetails(requestorNo, alternateApproverNo, invoiceTotAmount,orgId, invoiceLineItemdetailsList);
//                approverListheaderObj=approverDetailsC
                if(approverListheaderObj.size()>0){
                    for(int i=0;i<approverListheaderObj.size();i++){
                        String approvername =
                            approverListheaderObj.get(i).getAPPNAME().getValue();
                        String appoverEmail =
                            approverListheaderObj.get(i).getAPPEMAIL().getValue();
                        BigDecimal appempno =
                            approverListheaderObj.get(i).getAPPEMPNO().getValue();
                        String appposition =
                            approverListheaderObj.get(i).getAPPPOSITION().getValue();
                        String appfndlcategory =
                             approverListheaderObj.get(i).getAPPFNDLCATEGORY().getValue();

                        /*System.out.println("approvername1" + "****" + i + "****" +
                                           approvername);
                        System.out.println("appoverEmail1" + "****" + i + "****" +
                                           appoverEmail);
                        System.out.println("appempno1" + "****" + i + "****" +
                                           appempno);
                        System.out.println("appposition1" + "****" + i + "****" +
                                           appposition);
                        System.out.println("appfndlcategory1" + "****" + i + "****" +
                                           appfndlcategory);*/
                    }
                }

            DCBindingContainer dcCon = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            ViewObject eqApproverDetailsVO= dcCon.findIteratorBinding("eQApproverDetails1Iterator").getViewObject();

//                           ViewObject lineVo= bindings2.findIteratorBinding("eQApproverDetails1Iterator").getViewObject();
//                           int lastRowIndex = lineVo.getRangeIndexOf(lineVo.last());

//                               for (APPSINVOICELINEREC lineData :
//                                    ouputParams.getPINVLINE().getValue().getPINVLINEITEM()) {
//                                   System.out.println("------ LINE RECORD START ------");
                eqApproverDetailsVO.clearCache();
                int lastRowIndex = eqApproverDetailsVO.getRangeIndexOf(eqApproverDetailsVO.last());
                //System.out.println("lastRowIndex :::"+lastRowIndex);
                  System.out.println("eqApproverDetailsVO.getRangeSize()"+eqApproverDetailsVO.getRangeSize());
                  if(approverListheaderObj.size()>0){
                    System.out.println("sizze od approverListheaderObj.size()::"+approverListheaderObj.size());
                    int newLineNumber = 1;
                    for(int i=0;i<approverListheaderObj.size();i++){

                        Row newRow = eqApproverDetailsVO.createRow();

//                        if (newRow!=null){
//                                       System.out.println("LineNumber :"+newRow.getAttribute("LineNumber"));
//                                       if (newRow.getAttribute("LineNumber")!=null){
//                                           newLineNumber = Integer.parseInt(newRow.getAttribute("LineNumber").toString());
//                                           newLineNumber++;
//                                       }
//                                    }
                        //System.out.println("Setting sequence number as "+newLineNumber +"for approver name "+approverListheaderObj.get(i).getAPPNAME().getValue());
                        newRow.setAttribute("lineSeqNumber", newLineNumber);
                        //newRow.setAttribute("lineSeqNumber", i+1);
                        newRow.setAttribute("approverName", approverListheaderObj.get(i).getAPPNAME().getValue());
                        newRow.setAttribute("appoverEmail", approverListheaderObj.get(i).getAPPEMAIL().getValue());
                        newRow.setAttribute("appEmpNo", approverListheaderObj.get(i).getAPPEMPNO().getValue());
                        newRow.setAttribute("appPosition", approverListheaderObj.get(i).getAPPPOSITION().getValue());
                        newRow.setAttribute("appFindelCategory", approverListheaderObj.get(i).getAPPFNDLCATEGORY().getValue());

//                newRow.setAttribute("appApproveLimit", approverListheaderObj.get(i).getAPPAPPROVELIMIT().getValue());
//                        eqApproverDetailsVO.insertRowAtRangeIndex(lastRowIndex+1, newRow);
                        eqApproverDetailsVO.insertRow(newRow);
                        newLineNumber++;
                        lastRowIndex++;
                        //System.out.println("lastRowIndex"+lastRowIndex);
                    }
                        AdfFacesContext.getCurrentInstance().addPartialTarget(eqApproverDetailsTable);

                  certifierApproverListPopUp.setRendered(true);}


         }
        else{
            certifierApproverListPopUp.setRendered(false);
            System.out.println("if GL code is not present");
            String message=null;
            message="Please enter GL code or Project No to show the approval details";
            callFacesMessage(message);

        }
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                certifierApproverListPopUp.show(hints);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
                    if(lineItemItr!=null) {
                        try {
                            lineItemItr.closeRowSetIterator();
                        } catch(Exception ex) {
                            ex.printStackTrace();
                    }
                    }
                }


       /* RichPopup.PopupHints hints = new RichPopup.PopupHints();
        certifierApproverListPopUp.show(hints);*/
        System.out.println("End on Submit Click");
    }
    public void closeCertifierWindow() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext ectx = facesContext.getExternalContext();
        ExtendedRenderKitService service = Service.getRenderKitService(facesContext, ExtendedRenderKitService.class);

        service.addScript(facesContext, "alert('Invoice Certified Successfully');window.close();");

    }

    public void closeCertifierWindowOnReject() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext ectx = facesContext.getExternalContext();
        ExtendedRenderKitService service = Service.getRenderKitService(facesContext, ExtendedRenderKitService.class);

        service.addScript(facesContext, "alert('Invoice Rejected Successfully');window.close();");

    }

    public void closeCertifierWindowOnReassign() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext ectx = facesContext.getExternalContext();
        ExtendedRenderKitService service = Service.getRenderKitService(facesContext, ExtendedRenderKitService.class);

        service.addScript(facesContext, "alert('Invoice Reassigned Successfully');window.close();");

    }

   /*  public void closeCertifierWindow() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext ectx = facesContext.getExternalContext();
        ExtendedRenderKitService service = Service.getRenderKitService(facesContext, ExtendedRenderKitService.class);

        service.addScript(facesContext, "alert('Invoice approved successfully.');window.close();");

    } */

    public void cancelAlternateApprover(ActionEvent actionEvent) {
       // Add event code here...
       //System.out.println("Start: cancelAlternateApprover");
        alternateAppoverPopupIT.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(alternateAppoverPopupIT);
       p14.hide();

       //System.out.println("End: cancelAlternateApprover");
    }
    public void selectAlternateApprover(ActionEvent actionEvent) {
              System.out.println("Start: selectAlternateApprover");
              String selectedAlternateApprover=null;
              RowKeySet selectedAltApprover = alternateApproverDetailsTable.getSelectedRowKeys();
              Iterator selectedAltApproverIter = selectedAltApprover.iterator();
              DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
              DCIteratorBinding empIter = bindings.findIteratorBinding("CertifierNameVO_ActiveOnlyRecords1Iterator");
              RowSetIterator empRSIter=null;
              try{
                  empRSIter = empIter.getRowSetIterator();
              while(selectedAltApproverIter.hasNext()){
                 Key key = (Key)((List)selectedAltApproverIter.next()).get(0);
                 Row currentRow = empRSIter.getRow(key);
                 System.out.println(currentRow.getAttribute("Conname"));
                   selectedAlternateApprover=currentRow.getAttribute("Conname").toString();

                    if(currentRow.getAttribute("EmployeeNumber")!=null){
                      String approverPersonID=currentRow.getAttribute("EmployeeNumber").toString();
                      System.out.println("approverPersonID get Value*****"+approverPersonID);
                      AdfFacesContext.getCurrentInstance().getPageFlowScope().put("approverID", approverPersonID);
                  }
              }
              }catch(Exception e)
              {
                  e.printStackTrace();
                  }
              finally{
                          if(empRSIter!=null) {
                              try {
                                  empRSIter.closeRowSetIterator();
                              } catch(Exception ex) {
                                  ex.printStackTrace();

                          }
                          }
                      }
              alternateApproverIt.setValue(selectedAlternateApprover);
              AdfFacesContext.getCurrentInstance().addPartialTarget(outerPgl);
              alternateAppoverPopupIT.setValue("");
              AdfFacesContext.getCurrentInstance().addPartialTarget(alternateAppoverPopupIT);
              p14.hide();
              System.out.println("End selectAlternateApprover");
          }
    public void searchAltApprover(ActionEvent actionEvent) {
        System.out.println("Start searchAltApprover");
        try {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p14.show(hints);
            String enteredAlternateApprover = null;
            if(alternateApproverIt.getValue() != null) {
                            enteredAlternateApprover = alternateApproverIt.getValue().toString();
                            System.out.println("alternateApproverIt.getValue(): "+enteredAlternateApprover);
            }

            FacesContext context = FacesContext.getCurrentInstance();
            String ctx = (String)context.getApplication().evaluateExpressionGet(context,"#{pageFlowScope.bpmWorklistContext}",String.class);
            IWorkflowServiceClient workflowSvcClient = ADFWorklistBeanUtil.getWorkflowServiceClient();
            ITaskQueryService wfQueryService = workflowSvcClient.getTaskQueryService();
            IWorkflowContext wfContext;
            String employeeID = "";
            wfContext = wfQueryService.getWorkflowContext(ctx);
            employeeID = wfContext.getUser();

            System.out.println("----- BPM User ID : "+employeeID);

            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CertifierNameVO_ActiveOnlyRecords1Iterator");
            ViewObjectImpl certifierNameVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
            ViewCriteria vc = certifierNameVO.getViewCriteria("CertifierNameVOCriteria");
            certifierNameVO.applyViewCriteria(vc);
            // certifierNameVO.clearCache();
            certifierNameVO.setNamedWhereClauseParam("bindName", enteredAlternateApprover);
                certifierNameVO.setNamedWhereClauseParam("bvEmployeeID", employeeID);
            //System.out.println("-----------Dynamic Query-----------");
            //System.out.println(certifierNameVO.getQuery());
            certifierNameVO.executeQuery();
            String alterNameApproverNumber=null;
            if(certifierNameVO.getEstimatedRowCount()>0){
                while (certifierNameVO.hasNext()) {
                  Row row = certifierNameVO.next(); // Get the next row in the result set.
                  if(null != row.getAttribute("EmployeeNumber"))
                  {
                  alterNameApproverNumber = row.getAttribute("EmployeeNumber").toString();
                  System.out.println("alterNameApproverNumber"+alterNameApproverNumber);
                  ADFContext.getCurrent().getViewScope().put("alterNameApproverNumber", alterNameApproverNumber);
                  }
                }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(alternateApproverDetailsTable);

           // }


        }
        catch(Exception e) {
//            e.printStackTrace();
System.out.println("SearchAltApprover Exception : "+e.getMessage());
        }
        System.out.println("End searchAltApprover");
    }

    // Added by rahadevan for electronic remittance //
    public void onElectRemittence(ActionEvent actionEvent) {

           System.out.println("Start onElectRemittence");
            String commentsVal = null;
            try {
                if(eleciRemNoIt.getValue() != null)
                    commentsVal = eleciRemNoIt.getValue().toString();
                System.out.println("commentsVal: "+commentsVal);
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                electRemittencePopUpIt.setValue(commentsVal);
                AdfFacesContext.getCurrentInstance().addPartialTarget(electRemittencePopUpIt);
                electRemittencePopup.show(hints);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            System.out.println("End onElectRemittence");

       }

    public void onElectRemittencePopupOKClick(ActionEvent actionEvent) {
          System.out.println("Start onElectRemittencePopupOKClick");
          String commentsVal = null;
          try {
              if(electRemittencePopUpIt.getValue() != null)
                  commentsVal = electRemittencePopUpIt.getValue().toString();
              System.out.println("electRemittencePopUpIt: "+electRemittencePopUpIt);
              eleciRemNoIt.setValue(commentsVal);
              electRemittencePopup.hide();
              AdfFacesContext.getCurrentInstance().addPartialTarget(eleciRemNoIt);
          }
          catch(Exception e) {
              e.printStackTrace();
          }
          System.out.println("End onElectRemittencePopupOKClick");
      }
    //ended //

    public void onAlternateApproverPopUpGoClick(ActionEvent actionEvent) {
           System.out.println("Start onCerNamePopUpGoClick");
           String enteredAlternateApprover = null;
           try {
               if(alternateAppoverPopupIT.getValue() != null) {
                               enteredAlternateApprover = alternateAppoverPopupIT.getValue().toString();
                               //System.out.println("certifierNamePopupIT.getValue(): "+enteredAlternateApprover);
               }
                               DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                               DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CertifierNameVO_ActiveOnlyRecords1Iterator");
                               ViewObjectImpl certifierNameVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                               ViewCriteria vc = certifierNameVO.getViewCriteria("CertifierNameVOCriteria");
                               certifierNameVO.applyViewCriteria(vc);
                             // certifierNameVO.clearCache();
                               certifierNameVO.setNamedWhereClauseParam("bindName", enteredAlternateApprover);
                               //System.out.println("-----------Dynamic Query-----------");
                               //System.out.println(certifierNameVO.getQuery());
                               certifierNameVO.executeQuery();
                               AdfFacesContext.getCurrentInstance().addPartialTarget(alternateApproverDetailsTable);

              // }
           }
           catch(Exception e) {
               e.printStackTrace();
           }
           System.out.println("End onCerNamePopUpGoClick");
       }




    public void onAddLineItemRow(ActionEvent actionEvent) {
        System.out.println("Start onAddLineItemRow");
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("TaxRateCodePS", null);
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("LineItemAddFlagCertifier", true);
        try {
            System.out.println("Add Line Item Flag Value:"+AdfFacesContext.getCurrentInstance().getPageFlowScope().get("LineItemAddFlagCertifier"));
            BindingContext bctx = BindingContext.getCurrent();
            BindingContainer bindings = bctx.getCurrentBindingsEntry();
            OperationBinding operationBinding =  bindings.getOperationBinding("addLineItemRow");
            operationBinding.getParamsMap().put("invoiceId",getInvoiceId());
            operationBinding.execute();
            AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onAddLineItemRow");
    }



   public void onRemoveLineItemRow(ActionEvent actionEvent) {
           System.out.println("Start onRemoveLineRow");
           boolean flag=false;
                  ViewObject lineVo =
                      ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator").getViewObject();
                  RowSetIterator rsiLineItem= lineVo.createRowSetIterator(null);
                  while (rsiLineItem.hasNext()) {
                       //System.out.println("inside while ...........");
                       Row lineItemRow = rsiLineItem.next();
                       //System.out.println("is slected value ::"+ lineItemRow.getAttribute("isSelected"));
                       //System.out.println("is line number::"+ lineItemRow.getAttribute("LineNumber"));

                       if (lineItemRow.getAttribute("isSelected") != null &&
                           lineItemRow.getAttribute("isSelected").equals("Y")) {
                           flag = true;
                       }
                   }
                   rsiLineItem.closeRowSetIterator();


                   if(!flag) {
                       String validationErrorMessage =
                           "Please select checkbox before deleting the row";
                       RichPopup.PopupHints hints1 =
                           new RichPopup.PopupHints();
                       validationErrorPopup.show(hints1);
                       this.validationErrorMessage.setValue(validationErrorMessage);
                       return;
                   }
           if (flag) {
           String lineNumber = null;
           AdfFacesContext.getCurrentInstance().getPageFlowScope().put("LineItemAddFlagCertifier", true);
           System.out.println("Remove Line Item Flag Value:"+AdfFacesContext.getCurrentInstance().getPageFlowScope().get("LineItemAddFlagCertifier"));
           RowSetIterator lineItemRSIter=null;
           try {
               RowKeySet rowKeySet = lineItemsTable.getSelectedRowKeys();
               Iterator rowKeySetIt = rowKeySet.iterator();
               DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
               DCIteratorBinding dcItteratorBindings = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
               lineNumber = AdfFacesContext.getCurrentInstance().getViewScope().get("lineNumber")+"";
               //System.out.println("Line Id: "+lineNumber);

                   lineItemRSIter = dcItteratorBindings.getRowSetIterator();
               double sumLineTotalAmnt = 0;
               double sumTaxTotalAmnt = 0;
               DecimalFormat df = new DecimalFormat("#0.00");
               /* if(lineTotalSum.getValue() !=null){
                   sumLineTotalAmnt = Double.parseDouble(lineTotalSum.getValue().toString());
               }
               if(taxAmountSum.getValue() !=null){
                   sumTaxTotalAmnt = Double.parseDouble(taxAmountSum.getValue().toString());
               } */
                while(rowKeySetIt.hasNext()){
                  Key key = (Key)((List)rowKeySetIt.next()).get(0);
                  Row currentRow = lineItemRSIter.getRow(key);
                    if(currentRow!=null) {
                       System.out.println("----- typedInPONumber ----- "+currentRow.getAttribute("LineTotalAmount"));
                       sumLineTotalAmnt = currentRow.getAttribute("LineTotalAmount")==null? sumLineTotalAmnt : (sumLineTotalAmnt - Double.parseDouble(currentRow.getAttribute("LineTotalAmount").toString().trim()));
                       sumTaxTotalAmnt = (currentRow.getAttribute("TaxAmountLineitem")==null || (currentRow.getAttribute("TaxAmountLineitem")!=null && currentRow.getAttribute("TaxAmountLineitem").toString().trim().equals("")))
                           ? sumTaxTotalAmnt : (sumTaxTotalAmnt - Double.parseDouble(currentRow.getAttribute("TaxAmountLineitem").toString().trim()));
                    }
                }
               //lineTotalSum.setValue(df.format(sumLineTotalAmnt));
               //taxAmountSum.setValue(df.format(sumTaxTotalAmnt));


               OperationBinding operationBinding =  bindings.getOperationBinding("removeLineItemRow");
               operationBinding.getParamsMap().put("invoiceId",getInvoiceId());
           //            operationBinding.getParamsMap().put("lineId",rowSelected.getAttribute("LineNumber")+"");
           //            operationBinding.getParamsMap().put("lineId",lineNumber);
               operationBinding.execute();
               parentCheckBox.resetValue();
               subCheckBox.resetValue();
               AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);

   //            AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
           }
           catch(Exception e) {
               e.printStackTrace();
           }
           finally{
                       if(lineItemRSIter!=null) {
                           try {
                               lineItemRSIter.closeRowSetIterator();
                           } catch(Exception ex) {
                               ex.printStackTrace();
                           }
                       }
                   }
           }
           System.out.println("End onRemoveLineRow");
       }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }

    public void cancelProjectNoPopUP(ActionEvent actionEvent) {
    // Add event code here...
    //System.out.println("Start: cancelProjectNoPopUP");
    projNoPopupIt.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(projNoPopupIt);
    p3.hide();

    //System.out.println("End: cancelProjectNoPopUP");
    }
    public void selectProjectNoPopUP(ActionEvent actionEvent) {
        //TO KD
        System.out.println("Start: selectProjectNoPopUP");



        String selectedProjectNo="";
        String selectedProjectId="";

        RowKeySet selectedProjectNum = projDtlTable.getSelectedRowKeys();
        Iterator selectedProjectIter = selectedProjectNum.iterator();
        DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = bindings.findIteratorBinding("ProjectNumberVO1Iterator");
        RowSetIterator empRSIter=null;
        try{
            empRSIter = empIter.getRowSetIterator();
        while(selectedProjectIter.hasNext()){
           Key key = (Key)((List)selectedProjectIter.next()).get(0);
           Row currentRow = empRSIter.getRow(key);
           System.out.println(currentRow.getAttribute("ProjectNumber"));
             selectedProjectNo=currentRow.getAttribute("ProjectNumber").toString();
             System.out.println(currentRow.getAttribute("ProjectId"));
               selectedProjectId=currentRow.getAttribute("ProjectId").toString();

         }
        }catch(Exception e)
        {
            e.printStackTrace();
            }
        finally{
                    if(empRSIter!=null) {
                        try {
                            empRSIter.closeRowSetIterator();
                        } catch(Exception ex) {
                            ex.printStackTrace();

                    }
                    }
                }
            //poNumPopupIt.setValue(selectedPONumber);
            //System.out.println("selected project number :::" +selectedProjectId);
            int selectedRowNum = -1;

            if(clientID.getValue()!=null) {
                selectedRowNum = Integer.parseInt(clientID.getValue().toString().split(":")[2]);
                //System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);
            }


             if(selectedRowNum!=-1) {


                 String componentIDPoNumber = "pt1:t1:"+selectedRowNum+":it21::content";
                 //System.out.println("----- componentIDPoNumber ----- "+componentIDPoNumber+", selectedPONumber : "+selectedProjectNo);

                 String componentIDProjectNo = "pt1:t1:"+selectedRowNum+":it88::content";
                 //System.out.println("----- componentIDProjectNo ----- "+componentIDProjectNo+", selectedProjectId : "+selectedProjectId);

                 FacesContext fctx = FacesContext.getCurrentInstance();
                 ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                 String myJavaScriptCode = "document.getElementById('"+componentIDPoNumber+"').value = '"+selectedProjectNo+"'";
                 String myJavaScriptCode1 = "document.getElementById('"+componentIDProjectNo+"').value = '"+selectedProjectId+"'";

                 String myJavaScriptCode2 = "document.getElementById('"+componentIDPoNumber+"').blur()";
                 String myJavaScriptCode3 = "document.getElementById('"+componentIDProjectNo+"').blur()";
                 String myJavaScriptCode4 = "document.getElementById('"+componentIDProjectNo+"').blur()";
                 String myJavaScriptCode5 = "document.getElementById('pt1:hiddenButtonID').click()";

                 erks.addScript(fctx, myJavaScriptCode );
                 erks.addScript(fctx, myJavaScriptCode1 );
                 erks.addScript(fctx, myJavaScriptCode2 );
                 erks.addScript(fctx, myJavaScriptCode3 );
                 erks.addScript(fctx, myJavaScriptCode4 );
                 erks.addScript(fctx, myJavaScriptCode5 );
             }

        //AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
        projNoPopupIt.setValue("");


            //expTypeIt.setDisabled(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
            //System.out.println("table refreshed********************");

        AdfFacesContext.getCurrentInstance().addPartialTarget(projNoPopupIt);
        p3.hide();
        System.out.println("End selectProjectNoPopUP");
    }
    public void openProjectNoPopUPCE(ClientEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openProjectNoPopUPCE");
        String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        //System.out.println(" ----- clientID : "+clientId);
        this.clientID.setValue(clientId);
        try {
            String enteredProjNo=null;
            String enteredOrgIdIt=null;
            if(orgIdIt.getValue() != null) {
                enteredOrgIdIt = orgIdIt.getValue().toString();
                System.out.println("orgIdIt.getValue(): "+enteredOrgIdIt);
            }
            else{
                    System.out.println("orgIdIt.getValue(): "+orgIdIt.getValue());
                }
           if(projectNoIT.getValue() != null) {
                enteredProjNo = projectNoIT.getValue().toString();
                System.out.println("projectNoIT.getValue(): "+enteredProjNo);
            }
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ProjectNumberVO1Iterator");
             ViewObjectImpl projectNumberVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
               ViewCriteria vc = projectNumberVO.getViewCriteria("ProjectNumberVOCriteria");
                projectNumberVO.applyViewCriteria(vc);
                projectNumberVO.setNamedWhereClauseParam("bindOrgID", enteredOrgIdIt);
                projectNumberVO.setNamedWhereClauseParam("bindProjectNo", enteredProjNo);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(projectNumberVO.getQuery());
                projectNumberVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(projDtlTable);
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                p3.show(hints);
           // }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openProjectNoPopUPCE");

    }


    public void openProjectNoPopUP(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openProjectNoPopUP");
        String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        //System.out.println(" ----- clientID : "+clientId);
        this.clientID.setValue(clientId);
        try {
            String enteredProjNo=null;
            String enteredOrgIdIt=null;
            if(orgIdIt.getValue() != null) {
                enteredOrgIdIt = orgIdIt.getValue().toString();
                System.out.println("orgIdIt.getValue(): "+enteredOrgIdIt);
            }
            else{
                    System.out.println("orgIdIt.getValue(): "+orgIdIt.getValue());
                }
           if(projectNoIT.getValue() != null) {
                enteredProjNo = projectNoIT.getValue().toString();
                System.out.println("projectNoIT.getValue(): "+enteredProjNo);
            }
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ProjectNumberVO1Iterator");
             ViewObjectImpl projectNumberVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
               ViewCriteria vc = projectNumberVO.getViewCriteria("ProjectNumberVOCriteria");
                projectNumberVO.applyViewCriteria(vc);
                projectNumberVO.setNamedWhereClauseParam("bindOrgID", enteredOrgIdIt);
                projectNumberVO.setNamedWhereClauseParam("bindProjectNo", enteredProjNo);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(projectNumberVO.getQuery());
                projectNumberVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(projDtlTable);
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                p3.show(hints);
           // }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openProjectNoPopUP");

    }

    public void validateProjectNo(ClientEvent clientEvent) {
        // Add event code here...
        RichInputText inputTxt =  (RichInputText) clientEvent.getComponent();

        Map  parameters = clientEvent.getParameters();
        System.out.println("SubmittedValue = "+parameters.get("submittedValue"));
        System.out.println("LocalValue = " +parameters.get("localValue"));


        System.out.println("Start validateProjectNo");
     //  String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
     String clientId =  clientEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        //System.out.println(" ----- clientID : "+clientId);
        this.clientID.setValue(clientId);

        String selectedProjectNo=null;
        String selectedProjectId=null;

        try {
            String enteredProjNo=null;
            String enteredOrgIdIt=null;
            if(orgIdIt.getValue() != null) {
                enteredOrgIdIt = orgIdIt.getValue().toString().trim();
                System.out.println("orgIdIt.getValue(): "+enteredOrgIdIt);
            }
            else{
                    System.out.println("orgIdIt.getValue(): "+orgIdIt.getValue());
                }
//
                                enteredProjNo=(String)parameters.get("submittedValue");
                    System.out.println("ProjNo.getValue(): "+enteredProjNo);

            int selectedRowNum = -1;

            if(clientID.getValue()!=null) {
                selectedRowNum = Integer.parseInt(clientID.getValue().toString().split(":")[2]);
                //System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);
            }

            if(enteredProjNo!=null && !enteredProjNo.equals("") && enteredProjNo!="" && enteredProjNo.trim()!=null && !enteredProjNo.trim().isEmpty() &&
               enteredOrgIdIt!=null && !enteredOrgIdIt.equals("") && enteredOrgIdIt!="" && enteredOrgIdIt.trim()!=null && !enteredOrgIdIt.trim().isEmpty()){

                boolean invalidQuery=true;


                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ProjectNumberVO1Iterator");
             ViewObjectImpl projectNumberValidateVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
               ViewCriteria vc = projectNumberValidateVO.getViewCriteria("ProjectNumberVOCriteria1");
                projectNumberValidateVO.applyViewCriteria(vc);
                projectNumberValidateVO.setNamedWhereClauseParam("bindOrgID", enteredOrgIdIt.trim());
                projectNumberValidateVO.setNamedWhereClauseParam("bindProjectNo", enteredProjNo.trim());
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(projectNumberValidateVO.getQuery());
                projectNumberValidateVO.executeQuery();
//                while(projectNumberValidateVO.hasNext()){
                    //                        Row row = projectNumberValidateVO.next();
                                     // 30-11-2022 Replace next() to first()
                                        if (projectNumberValidateVO.getEstimatedRowCount()>0){
                                        Row row = projectNumberValidateVO.first();
                    if(row.getAttribute("ProjectNumber") != null && row.getAttribute("ProjectId") != null){
                    System.out.println(row.getAttribute("ProjectNumber"));
                     selectedProjectNo=row.getAttribute("ProjectNumber").toString();
                       // counterPartyIt.setValue(selectedProjNo);

                        System.out.println(row.getAttribute("ProjectId"));
                         selectedProjectId=row.getAttribute("ProjectId").toString();
                        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("ProjectId",selectedProjectId);
                        System.out.println("PROJECTID"+selectedProjectId);
                         //   counterPartyIt.setValue(selectedCounterParty);
                         if(selectedRowNum!=-1) {


                             String componentIDProjectNo = "pt1:t1:"+selectedRowNum+":it21::content";
                             System.out.println("----- componentIDPoNumber ----- "+componentIDProjectNo+", selectedPONumber : "+selectedProjectNo);

                             String componentIDProjectId = "pt1:t1:"+selectedRowNum+":it88::content";
                             System.out.println("----- componentIDProjectNo ----- "+componentIDProjectId+", selectedProjectId : "+selectedProjectId);

                             FacesContext fctx = FacesContext.getCurrentInstance();
                             ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                             String myJavaScriptCode = "document.getElementById('"+componentIDProjectNo+"').value = '"+selectedProjectNo+"'";
                             String myJavaScriptCode1 = "document.getElementById('"+componentIDProjectId+"').value = '"+selectedProjectId+"'";


                             erks.addScript(fctx, myJavaScriptCode );
                             erks.addScript(fctx, myJavaScriptCode1 );

                         }
                    }
                    else{

                           System.out.println("Invalid Project number");
                           String vallMsg="Please Enter a valid Project Number";
                           this.validationErrorMessage.setValue(vallMsg);
                           AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                           RichPopup.PopupHints hints = new RichPopup.PopupHints();
                           validationErrorPopup.show(hints);




                            if(selectedRowNum!=-1) {


                                String componentIDProjectNo = "pt1:t1:"+selectedRowNum+":it21::content";
                                System.out.println("----- componentIDPoNumber ----- "+componentIDProjectNo+", selectedPONumber : "+"");

                                String componentIDProjectId = "pt1:t1:"+selectedRowNum+":it88::content";
                                System.out.println("----- componentIDProjectNo ----- "+componentIDProjectId+", selectedProjectId : "+"");

                                FacesContext fctx = FacesContext.getCurrentInstance();
                                ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                                String myJavaScriptCode = "document.getElementById('"+componentIDProjectNo+"').value = '"+""+"'";
                                String myJavaScriptCode1 = "document.getElementById('"+componentIDProjectId+"').value = '"+""+"'";


                                erks.addScript(fctx, myJavaScriptCode );
                                erks.addScript(fctx, myJavaScriptCode1 );

                            }
                            //counterPartyIt.setValue("");
                        }

                    invalidQuery=false;
                }
                    if(invalidQuery)
                    {
                        System.out.println("Executing"+invalidQuery);
                           /* FacesMessage Message =
                                new FacesMessage("Please Enter a valid Counter Party");
                            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                            FacesContext fc = FacesContext.getCurrentInstance();
                            fc.addMessage(null, Message);*/
                           System.out.println("Invalid Project number");
                           String vallMsg="Please Enter a valid Project Number";
                           this.validationErrorMessage.setValue(vallMsg);
                           AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                           RichPopup.PopupHints hints = new RichPopup.PopupHints();
                           validationErrorPopup.show(hints);



                            //counterPartyOt.setValue("");
                            if(selectedRowNum!=-1) {


                                String componentIDProjectNo = "pt1:t1:"+selectedRowNum+":it21::content";
                                System.out.println("----- componentIDPoNumber ----- "+componentIDProjectNo+", selectedPONumber : "+"");

                                String componentIDProjectId = "pt1:t1:"+selectedRowNum+":it88::content";
                                System.out.println("----- componentIDProjectNo ----- "+componentIDProjectId+", selectedProjectId : "+"");

                                FacesContext fctx = FacesContext.getCurrentInstance();
                                ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                                String myJavaScriptCode = "document.getElementById('"+componentIDProjectNo+"').value = '"+""+"'";
                                String myJavaScriptCode1 = "document.getElementById('"+componentIDProjectId+"').value = '"+""+"'";


                                erks.addScript(fctx, myJavaScriptCode );
                                erks.addScript(fctx, myJavaScriptCode1 );

                            }
                        }
             //   AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
             //   System.out.println("table refreshed********************");

           // }
            }
            else{
                    if(selectedRowNum!=-1) {


                        String componentIDProjectId = "pt1:t1:"+selectedRowNum+":it88::content";
                        System.out.println("----- componentIDProjectNo ----- "+componentIDProjectId+", selectedProjectId : "+"");

                        FacesContext fctx = FacesContext.getCurrentInstance();
                        ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);

                        String myJavaScriptCode1 = "document.getElementById('"+componentIDProjectId+"').value = '"+""+"'";
                        erks.addScript(fctx, myJavaScriptCode1 );


                    }
                }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End validateProjectNo");

    }



    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }

    public RichPopup getP3() {
        return p3;
    }

    public void onProNoPopUpGoClick(ActionEvent actionEvent) {
        System.out.println("Start onProNoPopUpGoClick");
        String enteredProjNo = null;

        try {
            if(projNoPopupIt.getValue() != null) {
                enteredProjNo = projNoPopupIt.getValue().toString();
                System.out.println("projNo.getValue(): "+enteredProjNo);
            }
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ProjectNumberVO1Iterator");
                ViewObjectImpl projectNumberVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = projectNumberVO.getViewCriteria("ProjectNumberVOCriteria");
                projectNumberVO.applyViewCriteria(vc);
                projectNumberVO.setNamedWhereClauseParam("bindProjectNo", enteredProjNo);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(projectNumberVO.getQuery());
                projectNumberVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(projDtlTable);
            //}
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onProNoPopUpGoClick");
    }

    public void validateTaskNo(ClientEvent clientEvent) {
        // Add event code here...
        RichInputText inputTxt =  (RichInputText) clientEvent.getComponent();

        Map  parameters = clientEvent.getParameters();
        System.out.println("SubmittedValue = "+parameters.get("submittedValue"));
        System.out.println("LocalValue = " +parameters.get("localValue"));

        System.out.println("Start validateTaskNo");
      //  String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
      String clientId = clientEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        System.out.println(" ----- clientID : "+clientId);
        this.clientID.setValue(clientId);

        try {
            String enteredTaskNo=null;
            String enteredProjectId=setProjectIdIt();
          //  String enteredProjectId=null;
         //   System.out.println("New Project id in openTaskNoPopup :: "+ enteredProjectId);
            String selectedTaskNo=null;
         /*   if(projectIdIt.getValue() != null) {
                enteredProjectId = projectIdIt.getValue().toString();
                System.out.println("projectIdIt.getValue(): "+enteredProjectId);
            }  */

            enteredTaskNo=(String)parameters.get("submittedValue");
            System.out.println("TaskNo.getValue(): "+enteredTaskNo);

            int selectedRowNum = -1;

            if(clientID.getValue()!=null) {
            selectedRowNum = Integer.parseInt(clientID.getValue().toString().split(":")[2]);
            System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);
            }

            if(enteredTaskNo!=null && !enteredTaskNo.equals("") && enteredTaskNo!="" && enteredTaskNo.trim()!=null && !enteredTaskNo.trim().isEmpty() &&
            enteredProjectId!=null && !enteredProjectId.equals("") && enteredProjectId!="" && enteredProjectId.trim()!=null && !enteredProjectId.trim().isEmpty()){

              boolean invalidQuery=true;
            String selectedTaskId="";
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("TaskNumberVO1Iterator");
                ViewObjectImpl taskNumberValidateVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = taskNumberValidateVO.getViewCriteria("TaskNumberVOCriteria2");
                taskNumberValidateVO.applyViewCriteria(vc);
                taskNumberValidateVO.setNamedWhereClauseParam("bindprojectId", enteredProjectId);
                taskNumberValidateVO.setNamedWhereClauseParam("bindTaskNo", enteredTaskNo);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(taskNumberValidateVO.getQuery());
                taskNumberValidateVO.executeQuery();
System.out.println("Row Count : "+taskNumberValidateVO.getEstimatedRowCount());
                                //            while(taskNumberValidateVO.hasNext()){
                                //                    Row row = taskNumberValidateVO.next();
                                // 14-12-2022 Change next() to first()
                                if (taskNumberValidateVO.getEstimatedRowCount()>0){
                                Row row = taskNumberValidateVO.first();
                                if(row.getAttribute("TaskNumber") != null){
                                System.out.println(row.getAttribute("TaskNumber"));
                                selectedTaskNo=row.getAttribute("TaskNumber").toString();
                                        System.out.println(row.getAttribute("TaskId"));
                                selectedTaskId=row.getAttribute("TaskId").toString();
                                System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);

                     if(selectedRowNum!=-1) {

//                         String componentIDTaskNumber = "pt1:t1:"+selectedRowNum+":it15::content";
//                         System.out.println("----- componentIDPoNumber ----- "+componentIDTaskNumber+", selectedPONumber : "+selectedTaskNo);
//
//                         FacesContext fctx = FacesContext.getCurrentInstance();
//                         ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
//                         String myJavaScriptCode = "document.getElementById('"+componentIDTaskNumber+"').value = '"+selectedTaskNo+"'";
//                         erks.addScript(fctx, myJavaScriptCode );

                         			 String componentIDPoNumber = "pt1:t1:"+selectedRowNum+":it15::content";
                         System.out.println("----- componentIDPoNumber ----- "+componentIDPoNumber+", selectedPONumber : "+selectedTaskNo);
                         String componentIDTaskIdNumber = "pt1:t1:"+selectedRowNum+":it81::content";
                         System.out.println("----- componentIDTaskIdNumber ----- "+componentIDTaskIdNumber+", selectedTaskId : "+selectedTaskId);
                         FacesContext fctx = FacesContext.getCurrentInstance();
                         ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                         String myJavaScriptCode = "document.getElementById('"+componentIDPoNumber+"').value = '"+selectedTaskNo+"'";
                         String myJavaScriptCode1 = "document.getElementById('"+componentIDTaskIdNumber+"').value = '"+selectedTaskId+"'";
                         String myJavaScriptCode2 = "document.getElementById('"+componentIDPoNumber+"').blur()";
                         String myJavaScriptCode3 = "document.getElementById('"+componentIDTaskIdNumber+"').blur()";
                         erks.addScript(fctx, myJavaScriptCode );
                         erks.addScript(fctx, myJavaScriptCode1 );
                         erks.addScript(fctx, myJavaScriptCode2);
                         erks.addScript(fctx, myJavaScriptCode3);

                     }
                }
                else{

                       System.out.println("Invalid Task number");
                       String vallMsg="Please Enter a valid Task Number";
                       this.validationErrorMessage.setValue(vallMsg);
                       AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                       RichPopup.PopupHints hints = new RichPopup.PopupHints();
                       validationErrorPopup.show(hints);

                        if(selectedRowNum!=-1) {


                            String componentIDTaskNumber = "pt1:t1:"+selectedRowNum+":it15::content";
                            System.out.println("----- componentIDTaskNumber ----- "+componentIDTaskNumber+", selectedTaskNo : "+"");

                            FacesContext fctx = FacesContext.getCurrentInstance();
                            ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                            String myJavaScriptCode = "document.getElementById('"+componentIDTaskNumber+"').value = '"+""+"'";
                            erks.addScript(fctx, myJavaScriptCode );

                        }

                    }

                invalidQuery=false;
            }
            if(invalidQuery)
            {
                System.out.println("Executing"+invalidQuery);

                   System.out.println("Invalid Task number");
                   String vallMsg="Please Enter a valid Task Number";
                   this.validationErrorMessage.setValue(vallMsg);
                   AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                   RichPopup.PopupHints hints = new RichPopup.PopupHints();
                   validationErrorPopup.show(hints);

                    //counterPartyOt.setValue("");
                    if(selectedRowNum!=-1) {


                        String componentIDTaskNumber = "pt1:t1:"+selectedRowNum+":it15::content";
                        System.out.println("----- componentIDTaskNumber ----- "+componentIDTaskNumber+", selectedTaskNumber : "+"");

                        FacesContext fctx = FacesContext.getCurrentInstance();
                        ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                        String myJavaScriptCode = "document.getElementById('"+componentIDTaskNumber+"').value = '"+""+"'";
                        erks.addScript(fctx, myJavaScriptCode );

                    }
                }
       //     AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
      //      System.out.println("table refreshed********************");

            // }
            }
            else{
            if(selectedRowNum!=-1) {

                String componentIDTaskNumber = "pt1:t1:"+selectedRowNum+":it15::content";
                System.out.println("----- componentIDTaskNumber ----- "+componentIDTaskNumber+", selectedTaskNo : "+"");

                FacesContext fctx = FacesContext.getCurrentInstance();
                ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                String myJavaScriptCode = "document.getElementById('"+componentIDTaskNumber+"').value = '"+""+"'";
                erks.addScript(fctx, myJavaScriptCode );

            }
            }



        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End validateTaskNo");
    }

    public void openTaskNoPopup(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openTaskNoPopup");
        String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        //System.out.println(" ----- clientID : "+clientId);
        this.clientID.setValue(clientId);
        try {
            String enteredTaskNo=null;
            String enteredProjectId=setProjectIdIt();
            System.out.println("New Project id in openTaskNoPopup :: "+ enteredProjectId);

            /* if(projectIdIt.getValue() != null) {
                enteredProjectId = projectIdIt.getValue().toString();
                System.out.println("projectIdIt.getValue(): "+enteredProjectId);
            } */

            if(taskNoIT.getValue() != null) {
                enteredTaskNo = taskNoIT.getValue().toString();
                System.out.println("taskNoIT.getValue(): "+enteredTaskNo);
            }
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("TaskNumberVO1Iterator");
                ViewObjectImpl taskNumberVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = taskNumberVO.getViewCriteria("TaskNumberVOCriteria");
                taskNumberVO.applyViewCriteria(vc);
                taskNumberVO.setNamedWhereClauseParam("bindprojectId", enteredProjectId);
                taskNumberVO.setNamedWhereClauseParam("bindTaskNo", enteredTaskNo);
               // System.out.println("-----------Dynamic Query-----------");
                //System.out.println(taskNumberVO.getQuery());
                taskNumberVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(taskDtlTable);

            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p4.show(hints);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openTaskNoPopup");
    }

    public void setP4(RichPopup p4) {
        this.p4 = p4;
    }

    public RichPopup getP4() {
        return p4;
    }

    public void onTaskNoPopUpGoClick(ActionEvent actionEvent) {
        System.out.println("Start onTaskNoPopUpGoClick");
        String enteredTaskNo = null;
        String enteredProjectId=null;
        try {
            if(taskNoPopupIt.getValue() != null) {
                enteredTaskNo = taskNoPopupIt.getValue().toString();
                System.out.println("taskNoPopupIt.getValue(): "+enteredTaskNo);
            }
            enteredProjectId=setProjectIdIt();
                        System.out.println("New Project id in openTaskNoPopup :: "+ enteredProjectId);

//            if(projectIdIt.getValue() != null) {
//                enteredProjectId = projectIdIt.getValue().toString();
//                System.out.println("projectIdIt.getValue(): "+enteredProjectId);
//            }
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("TaskNumberVO1Iterator");
                ViewObjectImpl taskNumberVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = taskNumberVO.getViewCriteria("TaskNumberVOCriteria");
                taskNumberVO.applyViewCriteria(vc);
                taskNumberVO.setNamedWhereClauseParam("bindTaskNo", enteredTaskNo);
                taskNumberVO.setNamedWhereClauseParam("bindprojectId", enteredProjectId);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(taskNumberVO.getQuery());
                taskNumberVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(taskDtlTable);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onTaskNoPopUpGoClick");
    }

    public void cancelTaskNoPopUp(ActionEvent actionEvent) {
    // Add event code here...
        //System.out.println("Start: cancelTaskNoPopUp");
        taskNoPopupIt.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(taskNoPopupIt);
        p4.hide();

    //System.out.println("End: cancelTaskNoPopUp");
    }
    public void selectTaskNoPopUp(ActionEvent actionEvent) {
        //TO KD
        System.out.println("Start: selectTaskNoPopUp");



        String selectedTaskNo="";
        String selectedTaskId="";
        //RowKeySet selectedTaskNum = projDtlTable.getSelectedRowKeys();    wrong binding
        RowKeySet selectedTaskNum = taskDtlTable.getSelectedRowKeys();
        Iterator selectedTaskIter = selectedTaskNum.iterator();
        DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = bindings.findIteratorBinding("TaskNumberVO1Iterator");
        RowSetIterator empRSIter=null;
        try{
            empRSIter = empIter.getRowSetIterator();
        while(selectedTaskIter.hasNext()){
           Key key = (Key)((List)selectedTaskIter.next()).get(0);
           Row currentRow = empRSIter.getRow(key);
           System.out.println(currentRow.getAttribute("TaskNumber"));
             selectedTaskNo=currentRow.getAttribute("TaskNumber").toString();
             System.out.println(currentRow.getAttribute("TaskId"));
               selectedTaskId=currentRow.getAttribute("TaskId").toString();

         }
        }catch(Exception e)
        {
            e.printStackTrace();
            }
        finally{
                    if(empRSIter!=null) {
                        try {
                            empRSIter.closeRowSetIterator();
                        } catch(Exception ex) {
                            ex.printStackTrace();

                    }
                    }
                }
            //poNumPopupIt.setValue(selectedPONumber);

            int selectedRowNum = -1;

            if(clientID.getValue()!=null) {
                selectedRowNum = Integer.parseInt(clientID.getValue().toString().split(":")[2]);
                System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);
            }


             if(selectedRowNum!=-1) {


                 String componentIDPoNumber = "pt1:t1:"+selectedRowNum+":it15::content";
                 //System.out.println("----- componentIDPoNumber ----- "+componentIDPoNumber+", selectedPONumber : "+selectedTaskNo);

                 String componentIDTaskIdNumber = "pt1:t1:"+selectedRowNum+":it85::content";
                 //System.out.println("----- componentIDTaskIdNumber ----- "+componentIDTaskIdNumber+", selectedTaskId : "+selectedTaskId);

                 FacesContext fctx = FacesContext.getCurrentInstance();
                 ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                 String myJavaScriptCode = "document.getElementById('"+componentIDPoNumber+"').value = '"+selectedTaskNo+"'";
                 String myJavaScriptCode1 = "document.getElementById('"+componentIDTaskIdNumber+"').value = '"+selectedTaskId+"'";
                 String myJavaScriptCode2 = "document.getElementById('"+componentIDPoNumber+"').blur()";
                 String myJavaScriptCode3 = "document.getElementById('"+componentIDTaskIdNumber+"').blur()";
                 erks.addScript(fctx, myJavaScriptCode );
                 erks.addScript(fctx, myJavaScriptCode1 );
                 erks.addScript(fctx, myJavaScriptCode2);
                 erks.addScript(fctx, myJavaScriptCode3);
             }

        //AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
        taskNoPopupIt.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(taskNoPopupIt);
        p4.hide();
        System.out.println("End selectTaskNoPopUp");
    }

    public void validateExpenditureOrg(ClientEvent clientEvent) {
        // Add event code here...
        RichInputText inputTxt =  (RichInputText) clientEvent.getComponent();

        Map  parameters = clientEvent.getParameters();
        System.out.println("SubmittedValue = "+parameters.get("submittedValue"));
        System.out.println("LocalValue = " +parameters.get("localValue"));

        System.out.println("Start validateExpenditureOrg");
      //  String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
      String clientId = clientEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        System.out.println(" ----- clientID : "+clientId);
        this.clientID.setValue(clientId);

        try {
            String selectedExpenditureOrg=null;
           String enteredProjectId=setProjectIdIt();
          //  String enteredProjectId=null;
         //   System.out.println("New Project id in openTaskNoPopup :: "+ enteredProjectId);
         String enteredOrgIdIt=null;
         if(orgIdIt.getValue() != null) {
             enteredOrgIdIt = orgIdIt.getValue().toString();
             System.out.println("orgIdIt.getValue(): "+enteredOrgIdIt);
         }
         else{
                 System.out.println("orgIdIt.getValue(): "+orgIdIt.getValue());
             }
            String enteredExpOrg=null;
          //  if(projectIdIt.getValue() != null) {
             //   enteredProjectId = projectIdIt.getValue().toString();
                System.out.println("projectIdIt.getValue(): "+enteredProjectId);
          //  }

            enteredExpOrg=(String)parameters.get("submittedValue");
            System.out.println("ExpenditureOrg.getValue(): "+enteredExpOrg);

            int selectedRowNum = -1;

            if(clientID.getValue()!=null) {
            selectedRowNum = Integer.parseInt(clientID.getValue().toString().split(":")[2]);
            System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);
            }

            if(enteredExpOrg!=null && !enteredExpOrg.equals("") && enteredExpOrg!="" && enteredExpOrg.trim()!=null && !enteredExpOrg.trim().isEmpty() &&
            enteredOrgIdIt!=null && !enteredOrgIdIt.equals("") && enteredOrgIdIt!="" && enteredOrgIdIt.trim()!=null && !enteredOrgIdIt.trim().isEmpty()){

              boolean invalidQuery=true;
            System.out.println("orgid added"+enteredOrgIdIt);
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ExpenditureOrgVO1Iterator");
                ViewObjectImpl expOrgValidateVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = expOrgValidateVO.getViewCriteria("ExpenditureOrgVOCriteria1");
                expOrgValidateVO.applyViewCriteria(vc);
                expOrgValidateVO.setNamedWhereClauseParam("bind_expOrg", enteredExpOrg);
                expOrgValidateVO.setNamedWhereClauseParam("bindOrgID", enteredOrgIdIt);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(expOrgValidateVO.getQuery());
                expOrgValidateVO.executeQuery();
             int noOfRows= expOrgValidateVO.getRowCount();
             System.out.println(" No of Rows"+noOfRows);
             if(noOfRows==1)
             {
//                     Row row = expOrgValidateVO.next();
// 12-12-2022 Change next() to getCurrentRow()
                                          Row row = expOrgValidateVO.getCurrentRow();
                     if(row.getAttribute("ExpenditureOrg") != null){
                     System.out.println(row.getAttribute("ExpenditureOrg"));
                     selectedExpenditureOrg=row.getAttribute("ExpenditureOrg").toString();

                      if(selectedRowNum!=-1) {


                          String componentIDExpenditureOrg = "pt1:t1:"+selectedRowNum+":it20::content";
                          System.out.println("----- componentIDExpenditureOrg ----- "+componentIDExpenditureOrg+", selectedExpenditureOrg : "+selectedExpenditureOrg);

                          FacesContext fctx = FacesContext.getCurrentInstance();
                          ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                          String myJavaScriptCode = "document.getElementById('"+componentIDExpenditureOrg+"').value = '"+selectedExpenditureOrg+"'";
                          erks.addScript(fctx, myJavaScriptCode );

                      }
                     }
                     else{

                             System.out.println("Invalid Expenditure Org");
                             String vallMsg="Please Enter a valid Expenditure Org";
                            this.validationErrorMessage.setValue(vallMsg);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                            RichPopup.PopupHints hints = new RichPopup.PopupHints();
                            validationErrorPopup.show(hints);

                             if(selectedRowNum!=-1) {

                                 String componentIDExpenditureOrg = "pt1:t1:"+selectedRowNum+":it20::content";
                                 System.out.println("----- componentIDExpenditureOrg ----- "+componentIDExpenditureOrg+", selectedExpenditureOrg : "+"");

                                 FacesContext fctx = FacesContext.getCurrentInstance();
                                 ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                                 String myJavaScriptCode = "document.getElementById('"+componentIDExpenditureOrg+"').value = '"+""+"'";
                                 erks.addScript(fctx, myJavaScriptCode );

                             }

                         }
                     invalidQuery=false;
                 }
             else
             {

                 System.out.println("Inside else");
                 System.out.println("org id added"+enteredOrgIdIt);
                     DCBindingContainer dcBindingContainer1 = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                     DCIteratorBinding dcIteratorBinding1 = dcBindingContainer1.findIteratorBinding("ExpenditureOrgVO1Iterator");
                     ViewObjectImpl expOrgValidatePopupVO = (ViewObjectImpl)dcIteratorBinding1.getViewObject();
                     ViewCriteria vc1 = expOrgValidatePopupVO.getViewCriteria("ExpenditureOrgVOCriteria");
                     expOrgValidatePopupVO.applyViewCriteria(vc1);
                     expOrgValidatePopupVO.setNamedWhereClauseParam("bind_expOrg", enteredExpOrg);
                     expOrgValidatePopupVO.setNamedWhereClauseParam("bindOrgID", enteredOrgIdIt);
                     //System.out.println("-----------Dynamic Query-----------");
                     //System.out.println(expOrgValidatePopupVO.getQuery());
                     expOrgValidatePopupVO.executeQuery();
                 int popupRows=expOrgValidatePopupVO.getRowCount();
                 if(popupRows>=1)
                 {
                     invalidQuery=false;
                     AdfFacesContext.getCurrentInstance().addPartialTarget(expOrgTable);

                     RichPopup.PopupHints hints = new RichPopup.PopupHints();
                     p5.show(hints);
                 }

                 }
            if(invalidQuery)
            {
                System.out.println("Executing"+invalidQuery);

                   System.out.println("Invalid Expenditure Org");
                   String vallMsg="Please Enter a valid Expenditure Org";
                   this.validationErrorMessage.setValue(vallMsg);
                   AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                   RichPopup.PopupHints hints = new RichPopup.PopupHints();
                   validationErrorPopup.show(hints);

                    //counterPartyOt.setValue("");
                    if(selectedRowNum!=-1) {


                        String componentIDExpenditureOrg = "pt1:t1:"+selectedRowNum+":it20::content";
                        System.out.println("----- componentIDExpenditureOrg ----- "+componentIDExpenditureOrg+", selectedExpenditureOrg : "+"");

                        FacesContext fctx = FacesContext.getCurrentInstance();
                        ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                        String myJavaScriptCode = "document.getElementById('"+componentIDExpenditureOrg+"').value = '"+""+"'";
                        erks.addScript(fctx, myJavaScriptCode );

                    }
                }
         //   AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
         //   System.out.println("table refreshed********************");

            // }
            }
            else{
            if(selectedRowNum!=-1) {

                String componentIDExpenditureOrg = "pt1:t1:"+selectedRowNum+":it20::content";
                System.out.println("----- componentIDExpenditureOrg ----- "+componentIDExpenditureOrg+", selectedExpenditureOrg : "+"");

                FacesContext fctx = FacesContext.getCurrentInstance();
                ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                String myJavaScriptCode = "document.getElementById('"+componentIDExpenditureOrg+"').value = '"+""+"'";
                erks.addScript(fctx, myJavaScriptCode );

            }
            }



        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End validateExpenditureOrg");
    }


    public void openExpenditureOrgPopup(ActionEvent actionEvent) {

        // Add event code here...
        System.out.println("Start openExpenditureOrgPopup");
        String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        //System.out.println(" ----- clientID : "+clientId);
        this.clientID.setValue(clientId);
        try {
            String enteredExpOrg=null;
            if(expOrgIT.getValue() != null) {
                enteredExpOrg = expOrgIT.getValue().toString();
                enteredExpOrg = enteredExpOrg + "%";
                System.out.println("enteredExpOrg: "+enteredExpOrg);
            }
            String enteredOrgIdIt=null;
                   if(orgIdIt.getValue() != null) {
                       enteredOrgIdIt = orgIdIt.getValue().toString();
                       System.out.println("orgIdIt.getValue(): "+enteredOrgIdIt);
                   }
                   else{
                           System.out.println("orgIdIt.getValue(): "+orgIdIt.getValue());
                       }

                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ExpenditureOrgVO1Iterator");
                ViewObjectImpl expOrgVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = expOrgVO.getViewCriteria("ExpenditureOrgVOCriteria");
                expOrgVO.applyViewCriteria(vc);
                expOrgVO.setNamedWhereClauseParam("bind_expOrg", enteredExpOrg);
                 expOrgVO.setNamedWhereClauseParam("bindOrgID", enteredOrgIdIt);
               // System.out.println("-----------Dynamic Query-----------");
               // System.out.println(expOrgVO.getQuery());
                expOrgVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(expOrgTable);

            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p5.show(hints);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openExpenditureOrgPopup");


    }
    public void cancelExpenditureOrgPopup(ActionEvent actionEvent) {
    // Add event code here...
        //System.out.println("Start: cancelExpenditureOrgPopup");
        expOrgPopUpIt.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(expOrgPopUpIt);
        p5.hide();

        //System.out.println("End: cancelExpenditureOrgPopup");
    }
    public void selectExpenditureOrgPopup(ActionEvent actionEvent) {
        //TO KD
        System.out.println("Start: selectExpenditureOrgPopup");



        String selectedExpenditureOrg="";

        RowKeySet selectedExpenditureOrgUnit = expOrgTable.getSelectedRowKeys();
        Iterator selectedExpenditureIter = selectedExpenditureOrgUnit.iterator();
        DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = bindings.findIteratorBinding("ExpenditureOrgVO1Iterator");
        RowSetIterator empRSIter=null;
        try{
            empRSIter = empIter.getRowSetIterator();
        while(selectedExpenditureIter.hasNext()){
           Key key = (Key)((List)selectedExpenditureIter.next()).get(0);
           Row currentRow = empRSIter.getRow(key);
           System.out.println(currentRow.getAttribute("ExpenditureOrg"));
             selectedExpenditureOrg=currentRow.getAttribute("ExpenditureOrg").toString();

         }
        }catch(Exception e)
        {
            e.printStackTrace();
            }
        finally{
                    if(empRSIter!=null) {
                        try {
                            empRSIter.closeRowSetIterator();
                        } catch(Exception ex) {
                            ex.printStackTrace();

                    }
                    }
                }

            //poNumPopupIt.setValue(selectedPONumber);

            int selectedRowNum = -1;

            if(clientID.getValue()!=null) {
                selectedRowNum = Integer.parseInt(clientID.getValue().toString().split(":")[2]);
                //System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);
            }


             if(selectedRowNum!=-1) {


                 String componentIDPoNumber = "pt1:t1:"+selectedRowNum+":it20::content";
                 //System.out.println("----- componentIDPoNumber ----- "+componentIDPoNumber+", selectedPONumber : "+selectedExpenditureOrg);

                 FacesContext fctx = FacesContext.getCurrentInstance();
                 ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                 String myJavaScriptCode = "document.getElementById('"+componentIDPoNumber+"').value = '"+selectedExpenditureOrg+"'";
                 erks.addScript(fctx, myJavaScriptCode );
             }
       AdfFacesContext.getCurrentInstance().addPartialTarget(outerPgl);
        expOrgPopUpIt.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(expOrgPopUpIt);
        p5.hide();
        System.out.println("End selectExpenditureOrgPopup");
    }

    public void setP5(RichPopup p5) {
        this.p5 = p5;
    }

    public RichPopup getP5() {
        return p5;
    }

    public void setP6(RichPopup p6) {
        this.p6 = p6;
    }

    public RichPopup getP6() {
        return p6;
    }

    public void openGLCodePopup(ActionEvent actionEvent) {

        System.out.println("Start openGLCodePopup");
        try {
                    System.out.println("Start openExpenditureOrgPopup");
                    String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
                    //System.out.println(" ----- clientID : "+clientId);
                    this.clientID.setValue(clientId);
                    String selectedCode = null;
                    RowKeySet selectedGLcode = lineItemsTable.getSelectedRowKeys();
                    Iterator selectedGlCodeIter = selectedGLcode.iterator();
                    DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                    DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
                    RowSetIterator empRSIter=null;
            try{
                        empRSIter = lineItemIter.getRowSetIterator();
                    while(selectedGlCodeIter.hasNext()){
                       Key key = (Key)((List)selectedGlCodeIter.next()).get(0);
                       Row currentRow = empRSIter.getRow(key);
                       //System.out.println(currentRow.getAttribute("GlNo"));
                       selectedCode = currentRow.getAttribute("GlNo")!=null ? currentRow.getAttribute("GlNo").toString() : null;
            }
            }catch(Exception e)
            {
                e.printStackTrace();
                }
            finally{
                        if(empRSIter!=null) {
                            try {
                                empRSIter.closeRowSetIterator();
                            } catch(Exception ex) {
                                ex.printStackTrace();

                        }
                        }
                    }
                    //System.out.println("Selected GL code ::: "+ selectedCode);
                    String[] temp;
                    String delimeter = "\\.";
                    String companyName = null;
                    String costCentre = null;
                    String account = null;
                    String analysisCode = null;
                    String counterParty = null;

             if(selectedCode != null){
               String selectedGlCodeWithDot=selectedCode+".";
               System.out.println("SelectedGLCode "+selectedGlCodeWithDot);
                    char[] selectedGlCodeChar=selectedGlCodeWithDot.toCharArray();
                           int startPosition=0;
                           int endPosition=0;
                           char[][] selectedGlCodeCharArray=new char[5][15];
                           int i=0;
                           int position=0;
                    for(char glCodes:selectedGlCodeChar)
                           {
                            //System.out.println("glCodes "+glCodes);
                         //   String value=Character.toString(glCodes);

                            if(glCodes=='.')
                            {
                                endPosition=position;
                               selectedGlCodeWithDot.getChars(startPosition, endPosition, selectedGlCodeCharArray[i], 0);
                               position++;
                               startPosition=position;
                               i++;
                                if(i>4)
                                 break;
                            }
                            else
                            {
                                position++;
                            }

                           }
                    for(int j=0;j<i;j++)
                           {
                                //System.out.println("----"+j+"----");
                               for(char w:selectedGlCodeCharArray[j]){
                               if(w!=0)
                               {
                                 //System.out.println(""+w);
                               }


                               }
                           }
                     companyName=String.valueOf(selectedGlCodeCharArray[0]);
                     costCentre=String.valueOf(selectedGlCodeCharArray[1]);
                     account=String.valueOf(selectedGlCodeCharArray[2]);
                     analysisCode=String.valueOf(selectedGlCodeCharArray[3]);
                     counterParty=String.valueOf(selectedGlCodeCharArray[4]);

                     /*System.out.println("companyName="+companyName.trim()+".");
                     System.out.println("costCentre="+costCentre.trim()+".");
                    System.out.println("account="+account.trim()+".");
                    System.out.println("analysisCode="+analysisCode.trim()+".");
                     System.out.println("counterParty="+counterParty.trim()+"."); */

                    companyNameIt.setValue(companyName.trim());
                    costCentreIT.setValue(costCentre.trim());
                    accountNameIt.setValue(account.trim());
                    analysisCodeIt.setValue(analysisCode.trim());
                    counterPartyIt.setValue(counterParty.trim());

                    /*System.out.println("company name in first popup :::"+ companyName);
                    System.out.println("company desc in first popup :::"+ executeGLCodeCompanyVO(companyName.trim(), null, true));
                    System.out.println("cost center name in first popup :::"+ companyName);
                    System.out.println("Cost Center desc in first popup :::"+ executeGLCodeCostCentreVO(costCentre.trim(), null, true));*/

                    companyNameOt.setValue(executeGLCodeCompanyVO(companyName.trim(), null, true));
                    costCentreOt.setValue(executeGLCodeCostCentreVO(costCentre.trim(), null, true));
                    accountNameOt.setValue(executeGLCodeAccountVO(account.trim(), null, true));
                    analysisCodeOt.setValue(executeGLCodeAnalysisVO(analysisCode.trim(), null, true));
                    counterPartyOt.setValue(executeGLCodeCounterPartyVO(counterParty.trim(), null, true));
                }
                else{
                    companyNameIt.setValue("");
                    costCentreIT.setValue("");
                    accountNameIt.setValue("");
                    analysisCodeIt.setValue("");
                    counterPartyIt.setValue("");

                    /*System.out.println("company name in first popup :::"+ companyName);
                    System.out.println("company desc in first popup :::"+ executeGLCodeCompanyVO(companyName, null, true));
                    System.out.println("cost center name in first popup :::"+ companyName);
                    System.out.println("Cost Center desc in first popup :::"+ executeGLCodeCostCentreVO(costCentre, null, true));*/

                    companyNameOt.setValue(executeGLCodeCompanyVO(companyName, null, true));
                    costCentreOt.setValue(executeGLCodeCostCentreVO(costCentre, null, true));
                    accountNameOt.setValue(executeGLCodeAccountVO(account, null, true));
                    analysisCodeOt.setValue(executeGLCodeAnalysisVO(analysisCode, null, true));
                    counterPartyOt.setValue(executeGLCodeCounterPartyVO(counterParty, null, true));
                }


                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    p6.show(hints);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openGLCodePopup");
    }

    public void onExpOrgGoClick(ActionEvent actionEvent) {
        System.out.println("Start onExpOrgGoClick");
        String enteredExpOrg = null;
        try {
            if(expOrgPopUpIt.getValue() != null) {
                enteredExpOrg = expOrgPopUpIt.getValue().toString();
                enteredExpOrg = enteredExpOrg + "%";
                System.out.println("enteredExpOrg: "+enteredExpOrg);
            }
            String enteredOrgIdIt=null;
                  if(orgIdIt.getValue() != null) {
                      enteredOrgIdIt = orgIdIt.getValue().toString();
                      System.out.println("orgIdIt.getValue(): "+enteredOrgIdIt);
                  }
                  else{
                          System.out.println("orgIdIt.getValue(): "+orgIdIt.getValue());
                      }

                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ExpenditureOrgVO1Iterator");
                ViewObjectImpl expOrgVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = expOrgVO.getViewCriteria("ExpenditureOrgVOCriteria");
                expOrgVO.applyViewCriteria(vc);
                expOrgVO.setNamedWhereClauseParam("bind_expOrg", enteredExpOrg);
                expOrgVO.setNamedWhereClauseParam("bindOrgID", enteredOrgIdIt);
               // System.out.println("-----------Dynamic Query-----------");
                //System.out.println(expOrgVO.getQuery());
                expOrgVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(expOrgTable);
           // }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onExpOrgGoClick");
    }



    public void onTaxRateCodePopupGoClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start onTaxRateCodePopupGoClick");
        String enteredTaxCode = null;
        String siteId = null;
        try {
            if(taxRateCodePopupIt.getValue() != null) {
                enteredTaxCode = taxRateCodePopupIt.getValue().toString();
                //System.out.println("taxRateCodePopupIt.getValue(): "+enteredTaxCode);
            }
            if(siteIdIt.getValue() != null){
                siteId = siteIdIt.getValue().toString();
                //System.out.println("siteIdIt.getValue().toString();: "+siteId);
            }
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("TaxRateCodeLookupVO1Iterator");
                ViewObjectImpl taxRateCodeVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = taxRateCodeVO.getViewCriteria("TaxRateCodeLookupVOCriteria_lookupBySiteId");
                taxRateCodeVO.applyViewCriteria(vc);
                taxRateCodeVO.setNamedWhereClauseParam("bind_taxRateCode", enteredTaxCode);
                taxRateCodeVO.setNamedWhereClauseParam("bind_siteId", siteId);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(taxRateCodeVO.getQuery());
                taxRateCodeVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateCodeDetailsTable);
           // }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onTaxRateCodePopupGoClick");

    }

    public void selectTaxRateCodePopup(ActionEvent actionEvent) {
        //Added
        System.out.println("Start: selectTaxRateCodePopup");



        String selectedTaxRateCode=null;
        //String selectedTaxRate=null;
        BigDecimal taxAmount = null;
        RowKeySet selectedPONum = taxRateCodeDetailsTable.getSelectedRowKeys();
        Iterator selectedSiteIter = selectedPONum.iterator();
        DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = bindings.findIteratorBinding("TaxRateCodeLookupVO1Iterator");
        RowSetIterator empRSIter=null;
        try{
            empRSIter = empIter.getRowSetIterator();
        while(selectedSiteIter.hasNext()){
           Key key = (Key)((List)selectedSiteIter.next()).get(0);
           Row currentRow = empRSIter.getRow(key);
           //System.out.println(currentRow.getAttribute("TaxRateCode"));
//             if(currentRow.getAttribute("TaxRate")!=null) {
//                 selectedTaxRate= ((java.math.BigDecimal)currentRow.getAttribute("TaxRate")).doubleValue() +"";
//             }
            taxAmount = currentRow.getAttribute("TaxRate") == null ? null : (java.math.BigDecimal)currentRow.getAttribute("TaxRate");
             selectedTaxRateCode=currentRow.getAttribute("TaxRateCode").toString();
             AdfFacesContext.getCurrentInstance().getPageFlowScope().put("TaxRateCodePS", selectedTaxRateCode);
             //System.out.println("set TaxRateCodePS***"+AdfFacesContext.getCurrentInstance().getPageFlowScope().get("TaxRateCodePS"));

         }

        }catch(Exception e)
        {
            e.printStackTrace();
            }

        finally{
                    if(empRSIter!=null) {
                        try {
                            empRSIter.closeRowSetIterator();
                        } catch(Exception ex) {
                            ex.printStackTrace();

                    }
                    }
                }
            //poNumPopupIt.setValue(selectedPONumber);

            int selectedRowNum = -1;

            if(clientID.getValue()!=null) {
                selectedRowNum = Integer.parseInt(clientID.getValue().toString().split(":")[2]);
                //System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);
            }


             if(selectedRowNum!=-1) {

                 //Tax Rate
                 RowKeySet rowKeySet = lineItemsTable.getSelectedRowKeys();
                 Iterator rowKeySetIt = rowKeySet.iterator();
                 DCIteratorBinding lineItemIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");
                 RowSetIterator  lineItemRSIter=null;
                 try{
                     lineItemRSIter = lineItemIter.getRowSetIterator();
                  while(rowKeySetIt.hasNext()){
                    Key key = (Key)((List)rowKeySetIt.next()).get(0);
                    Row currentRow = lineItemRSIter.getRow(key);
                      //System.out.println("current row :: "+ currentRow);
                      if(currentRow!=null) {
                         //System.out.println("current row not null ............................");
                         //System.out.println("line description value ::: "+ currentRow.getAttribute("LineDescription"));
                         try {
                             currentRow.setAttribute("TaxRate", taxAmount == null ? null : new oracle.jbo.domain.Number(taxAmount.doubleValue()));
                         } catch(Exception ex) {
                             ex.printStackTrace();
                         }
                      }
                  }
                 }catch(Exception e)
                 {
                     e.printStackTrace();
                     }
                 finally{
                             if(lineItemRSIter!=null) {
                                 try {
                                     lineItemRSIter.closeRowSetIterator();
                                 } catch(Exception ex) {
                                     ex.printStackTrace();

                             }
                             }
                         }
                 AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);


                 String componentIDPoNumber = "pt1:t1:"+selectedRowNum+":it30::content";
                 //System.out.println("----- componentIDPoNumber ----- "+componentIDPoNumber+", selectedPONumber : "+selectedTaxRateCode);

                 String lineTotalInputText = "pt1:t1:"+selectedRowNum+":it18::content";
                 String taxAmountInputText = "pt1:t1:"+selectedRowNum+":it59::content";

                 double selectedTaxRateCodeValue = 0.0;
                 try {
                     //selectedTaxRateCodeValue = Double.parseDouble(selectedTaxRate)/100.0f;
                     selectedTaxRateCodeValue = (taxAmount == null ? 0.0 : taxAmount.doubleValue())/100.0f;

                 } catch(Exception ex) {
                     ex.printStackTrace();
                 }

                 FacesContext fctx = FacesContext.getCurrentInstance();
                 ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                 String myJavaScriptCode = "document.getElementById('"+componentIDPoNumber+"').value = '"+selectedTaxRateCode+"'";

                 String myJavaScriptCode2 =
                 "if(!isNaN(parseFloat(document.getElementById('"+lineTotalInputText+"').value)) && "+selectedTaxRateCodeValue+">=0.0) { " +
                 "    document.getElementById('"+taxAmountInputText+"').value = (parseFloat(document.getElementById('"+lineTotalInputText+"').value) * "+selectedTaxRateCodeValue+").toFixed(2); " +
                 "}";

                 erks.addScript(fctx, myJavaScriptCode);
                 erks.addScript(fctx, myJavaScriptCode2);

                 erks.addScript(fctx, "document.getElementById('"+componentIDPoNumber+"').focus();");
                 erks.addScript(fctx, "AdfActionEvent.queue(AdfPage.PAGE.findComponentByAbsoluteId('" + "pt1:t1:"+selectedRowNum+":it30" + "'), true);");
                 //recalculateLineAndTaxTotal();
                 AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
             }

        AdfFacesContext.getCurrentInstance().addPartialTarget(outerPgl);
        p7.hide();
        System.out.println("End selectTaxRateCodePopup");
    }

    public void cancelTaxRateCodePopup(ActionEvent actionEvent) {
        //System.out.println("start cancelTaxRateCodePopup" );
        taxRateCodePopupIt.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateCodePopupIt);
        p7.hide();
        //System.out.println("start cancelTaxRateCodePopup" );
    }

    public void setExpOrgPopUpIt(RichInputText expOrgPopUpIt) {
        this.expOrgPopUpIt = expOrgPopUpIt;
    }

    public RichInputText getExpOrgPopUpIt() {
        return expOrgPopUpIt;
    }

    public void setExpOrgTable(RichTable expOrgTable) {
        this.expOrgTable = expOrgTable;
    }

    public RichTable getExpOrgTable() {
        return expOrgTable;
    }

    public void setProjNoPopupIt(RichInputText projNoPopupIt) {
        this.projNoPopupIt = projNoPopupIt;
    }

    public RichInputText getProjNoPopupIt() {
        return projNoPopupIt;
    }

    public void setProjDtlTable(RichTable projDtlTable) {
        this.projDtlTable = projDtlTable;
    }

    public RichTable getProjDtlTable() {
        return projDtlTable;
    }

    public void setTaskNoPopupIt(RichInputText taskNoPopupIt) {
        this.taskNoPopupIt = taskNoPopupIt;
    }

    public RichInputText getTaskNoPopupIt() {
        return taskNoPopupIt;
    }

    public void setTaskDtlTable(RichTable taskDtlTable) {
        this.taskDtlTable = taskDtlTable;
    }

    public RichTable getTaskDtlTable() {
        return taskDtlTable;
    }

    public void cancelRejectPopup(ActionEvent actionEvent) {
        // Add event code here...
        //System.out.println("start cancelRejectPopup");
        commentsIt.setValue("");
        //rejectionReasonIt.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(pf12);
        p1.hide();
        //System.out.println("End cancelRejectPopup");
    }
    public void onPopUpRejectClick(ActionEvent actionEvent) {
        System.out.println("Start onPopUpRejectClick");
        try {
            String rejectComment = null;
            String invalidReason = null;
            if (commentsIt.getValue() != null) {
                rejectComment = commentsIt.getValue().toString();
            }
            System.out.println("rejector comments in popup :: " +
                               rejectComment);
            if(invalidReasonOt.getValue()!=null){
                invalidReason = invalidReasonOt.getValue().toString();
                System.out.println("invalid reason ::: "+ invalidReason);
            }
            if(reasonTypeSoc.getValue() != null && !reasonTypeSoc.equals("")){
            String invalidReasonType = (String)AdfFacesContext.getCurrentInstance().getPageFlowScope().get("invalidReasonType");
            doRejectOperation(rejectComment, invalidReason, invalidReasonType);
            BindingContext bctx = BindingContext.getCurrent();
            BindingContainer bindings = bctx.getCurrentBindingsEntry();
            OperationBinding operationBinding =
                bindings.getOperationBinding("REJECT");
            operationBinding.execute();
            commentsIt.setValue("");
            //rejectionReasonIt.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(pf12);
            closeCertifierWindowOnReject();
            p1.hide();
            }
            else{
                callFacesMessage("Please select a Reason Type");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onPopUpRejectClick");
    }

    public void cancelReassignPopUp(ActionEvent actionEvent) {
       // Add event code here...
       //System.out.println("Start: cancelReassignPopUp");
        reassignToIT.setValue("");
        reassignCommentsIt.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(reassignToIT);
        AdfFacesContext.getCurrentInstance().addPartialTarget(reassignCommentsIt);
       p2.hide();

       //System.out.println("End: cancelReassignPopUp");
    }

    public void cancelHoldPopUp(ActionEvent actionEvent) {
       // Add event code here...
       //System.out.println("Start: cancelHoldPopUp");
       p20.hide();

       //System.out.println("End: cancelHoldPopUp");
    }

    public void cancelReleasePopUp(ActionEvent actionEvent) {
       // Add event code here...
       //System.out.println("Start: cancelReleasePopUp");
       p24.hide();

       //System.out.println("End: cancelReleasePopUp");
    }

    public void onPopupReassignClick(ActionEvent actionEvent) {
        System.out.println("Start onPopupReassignClick");
        String userId = null;
        String name = null;
        String groupName = null;
        String reassignComments = null;
        String emailId=null;
                try {
                    if(reassingToIDPopupIT.getValue()!=null)
                    {
                        userId=reassingToIDPopupIT.getValue().toString();
                        //System.out.println("reassingToIDPopupIT.getValue()"+userId);
                    }
                    if(reassignToIT.getValue()!=null) {
                        name = reassignToIT.getValue().toString();
                        //System.out.println("reassignToIT.getValue() ressigned name "+ name);
                    }

            if(reassignEmailIdIT.getValue()!=null) {
                emailId = reassignEmailIdIT.getValue().toString();
                //System.out.println("reassignEmailIdIT.getValue() ressigned emailId "+ emailId);
            }
            if(reassignCommentsIt.getValue()!=null) {
                reassignComments = reassignCommentsIt.getValue().toString();
                //System.out.println("reassignCommentsIt.getValue() ressigned comments "+ reassignComments);
            }

            /*System.out.println("username in reassign"+name);
            System.out.println("userId in reassign :" +userId);
            System.out.println("emailId in reassign :" +emailId);*/
              if(reassignComments!=null)
                    {
                        doReassignOperation(name,userId,reassignComments,emailId);
                    }
            BindingContext bctx = BindingContext.getCurrent();
            BindingContainer bindings = bctx.getCurrentBindingsEntry();
            OperationBinding operationBinding =  bindings.getOperationBinding("Reasign");
            operationBinding.getParamsMap().put("userName",userId);
            operationBinding.getParamsMap().put("groupName",groupName);
            operationBinding.execute();
            closeCertifierWindowOnReassign();



            try {

                Object docId = resolveExpression("#{bindings.attr1.inputValue}");

                //System.out.println(" --- Updating Webcenter IPM --- docId : "+(docId==null?"":docId.toString()));
                DocumentService docUpdateService = new DocumentService_Service().getDocumentServicePort();
                 BindingProvider bindingProvider = (BindingProvider)docUpdateService;
                 @SuppressWarnings("rawtypes")
                 List<Handler> handlerChain = new ArrayList<Handler>();
                 handlerChain.add(new WSSecurityHeaderSOAPHandler(
                                          resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGING_DOCUMENT_SERVICE_USERNAME']}").toString(),
                                          resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGING_DOCUMENT_SERVICE_PASSWORD']}").toString()
                                      )
                                 );
                 bindingProvider.getBinding().setHandlerChain(handlerChain);
                 List<FieldValue> fieldValues = new ArrayList<FieldValue>();


                FieldValue fieldValue1 = new FieldValue();
                fieldValue1.setName("Certifier Name");
                TypedValue typedValue1 = new TypedValue();
                typedValue1.setType( FieldType.TEXT );
                typedValue1.setValue( name );
                fieldValue1.setValue(typedValue1);

                FieldValue fieldValue2 = new FieldValue();
                fieldValue2.setName("Username");
                TypedValue typedValue2 = new TypedValue();
                typedValue2.setType( FieldType.TEXT );
                typedValue2.setValue( userId );
                fieldValue2.setValue(typedValue2);


                fieldValues.add(fieldValue1);
                fieldValues.add(fieldValue2);


                docUpdateService.updateDocument(new Holder<String>(docId==null?"":docId.toString()), null, fieldValues, false);





                System.out.println(" --- Updating Webcenter IPM successful ---");
            } catch (Exception e) {
                System.out.println(" --- Updating Webcenter IPM failed ---"+e.getMessage());
                e.printStackTrace();
                //e.printStackTrace();
            }

            try {
                String invoiceId = getInvoiceId();
                System.out.println(" --- Updating Data Object in BAM --- invoiceId : "+invoiceId);


                DataObjectOperationsByID svc = new DataObjectOperationsByID_Service().getDataObjectOperationsByID();
                BindingProvider bindingProvider = (BindingProvider)svc;
                @SuppressWarnings("rawtypes")
                List<Handler> handlerChain = new ArrayList<Handler>();
                handlerChain.add(new ap.quantas.com.bamUpdateWebService.WSSecurityHeaderSOAPHandler(
                                        resolveExpression("#{ApOperationBean.propertyLoader.properties['BAM_DATA_OBJECT_SERVICE_USERNAME']}").toString(),
                                        resolveExpression("#{ApOperationBean.propertyLoader.properties['BAM_DATA_OBJECT_SERVICE_PASSWORD']}").toString()
                                     )
                                );
                bindingProvider.getBinding().setHandlerChain(handlerChain);

               String xmlPayload = "<_dep1><_BPM_INVOICE_ID>"+invoiceId+"</_BPM_INVOICE_ID><_CERTIFIER_NAME>"+name+"</_CERTIFIER_NAME><_USERNAME>"+userId+"</_USERNAME><_CERTIFIER_ID>"+userId+"</_CERTIFIER_ID><_EQ_LAST_UPDATED_DATE>"+new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date())+"</_EQ_LAST_UPDATED_DATE></_dep1>";
               boolean result = svc.upsert("/AP/QFEQIF_BPM_DO", "_BPM_INVOICE_ID", xmlPayload);

               System.out.println(" --- Updating Data Object in BAM success status --- "+result);


            } catch (Exception e) {
                System.out.println(" --- Updating Data Object in BAM ---"+e.getMessage());
//                e.printStackTrace();
                //e.printStackTrace();
            }
            //alternateApproverIt.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(alternateApproverIt);
            p2.hide();
        }
        catch(Exception e) {
System.out.println("onPopupReassignClick() Exception : "+e.getMessage());
//            e.printStackTrace();
        }
        System.out.println("End onPopupReassignClick");
    }

    private boolean  validateAndDoSaveOperation() {
        String invNum = null;
        if(invNumIt.getValue()!=null){
            invNum = (String)invNumIt.getValue();
        }
        System.out.println("invNum: "+invNum+"  Start : validateAndDoSaveOperation");
        try{
            boolean isValid=false;
            isValid=true;// validateRequiredField();
            String alternateApprover=null;
            if(isValid){
//              if(poNumIt.getValue()!=null && alternateApproverIt.getValue()!=null){
                String poNum= poNumIt.getValue()==null ? "" : poNumIt.getValue().toString();
                if(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("approverID")!=null){
                    //System.out.println("get Approver ID:::::"+AdfFacesContext.getCurrentInstance().getPageFlowScope().get("approverID"));
                    //alternateApprover=alternateApproverIt.getValue()==null ? "" : alternateApproverIt.getValue().toString();
                    alternateApprover=alternateApproverIt.getValue()==null ? "" : AdfFacesContext.getCurrentInstance().getPageFlowScope().get("approverID").toString();
                }
                    doSaveOperation(poNum,alternateApprover);
                    return true;
//                }
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End validateAndDoSaveOperation");
        return false;

    }



    private void doSaveOperation(String poNum,String alternateApprover) {
        try{
            //923018 -Start
            System.out.println("Start : doSaveOperation");
            String invoiceType=null;
            boolean updateStatus=false;
            if(resolveExpression("#{bindings.InvoiceType.inputValue}") != null)
                        invoiceType = resolveExpression("#{bindings.InvoiceType.inputValue}").toString();
           String noPoSiteStatus=(String)ADFContext.getCurrent().getPageFlowScope().get("NOPOStatusFlag");
           System.out.println("invoiceType : "+invoiceType);
           if(noPoSiteStatus!=null)
             System.out.println("noPoStatus : "+noPoSiteStatus);
            if("Non PO Invoice".equalsIgnoreCase(invoiceType) && "Y".equalsIgnoreCase(noPoSiteStatus)&& poNum!=null && !poNum.trim().equals("")){
                updateStatus=true;
                System.out.println("doSaveOperation :: noPoStatus : True ");
            }
            //923018 - End
              String valfromscd= Utility.getAm().saveCertifierDetails(updateStatus,resolveExpression("#{bindings.invoiceID.inputValue}").toString(), poNum, alternateApprover);//923018 change method signature added invoice type
               //System.out.println("valfromscd::"+valfromscd);
              if(valfromscd != null){   //added by raha for exception requirement 19th oct release
                saveoperationvar= 2;
                //System.out.println("error message is showing");
                /* String vallMsg="Please Do the operation again";
                this.validationErrorMessage.setValue(vallMsg);
                AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                validationErrorPopup.show(hints);
                return; */
        }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End doSaveOperation");

    }

    private void doSaveLineDetailsOperation() {
        try{
            String invNum = null;
            if(invNumIt.getValue()!=null){
                invNum = (String)invNumIt.getValue();
            }
            System.out.println("invNum:"+invNum+"Start : doSaveLineDetailsOperation");
            Utility.getAm().saveLineDetails();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End doSaveLineDetailsOperation");

    }

    private void doRejectOperation(String rejectComment, String invalidReason, String invalidReasonType) {
        System.out.println("Start : doRejectOperation");
        try {
            String name = getAPGroupUserName();
            //System.out.println("apgroup user name in reject :: "+ name);
            String commentsDate = null;
            //System.out.println("Reject Comment before saveCertifierRejectComments"+rejectComment);
            if(rejectComment != null){
                saveCertifierRejectComments(getInvoiceId(),commentsDate,rejectComment,name);
            }
            Utility.getAm().rejectCertifierDetails(resolveExpression("#{bindings.invoiceID.inputValue}").toString(), rejectComment, invalidReason, invalidReasonType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End doRejectOperation");

    }

    public void unitPriceNumberValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
            if(object!=null){
                //System.out.println("Checking");
                String name=object.toString();
                String expression="^[-]{0,1}[0-9]+(\\.[0-9]{1,5})?$";
                CharSequence inputStr=name;
                Pattern pattern=Pattern.compile(expression);
                Matcher matcher=pattern.matcher(inputStr);
                String msg="Please enter number with maximum 5 decimal points";
                if(matcher.matches()){

                }
                else{
                    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null));
                }
            }
        }


    public void numberValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
           if(object!=null){
               //System.out.println("Checking");
               String name=object.toString();

               String clientId = uIComponent.getClientId(facesContext);
               //System.out.println("----- clientId ----- "+clientId);


               String expression = (clientId.contains("it6") || clientId.contains("it29") || clientId.contains("it23")) ? "^[-]{0,1}[0-9]+(\\.[0-9]{1,9})?$" : "^[-]{0,1}[0-9]+(\\.[0-9]{1,2})?$" ;
               String msg = (clientId.contains("it6") || clientId.contains("it29") || clientId.contains("it23")) ? "Please enter number with maximum 9 decimal points." : "Please enter number with maximum 2 decimal points.";
               CharSequence inputStr=name;
               Pattern pattern=Pattern.compile(expression);
               Matcher matcher=pattern.matcher(inputStr);

               if(matcher.matches()){

               }
               else{
                   throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null));
               }
           }
       }


    public void setPoNumberIt(RichInputText poNumberIt) {
        this.poNumberIt = poNumberIt;
    }

    public RichInputText getPoNumberIt() {
        return poNumberIt;
    }

    public void setAlternateApproverIt(RichInputText alternateApproverIt) {
        this.alternateApproverIt = alternateApproverIt;
    }

    public RichInputText getAlternateApproverIt() {
        return alternateApproverIt;
    }
    public void seteleciRemNoIt(RichInputText eleciRemNoIt) {
        this.eleciRemNoIt = eleciRemNoIt;
    }

    public RichInputText geteleciRemNoIt() {
        return eleciRemNoIt;
    }

    public void cancelCompanyGLCode(ActionEvent actionEvent) {
           // Add event code here...
           //System.out.println("Start: cancelCompanyGLCode");
           companyNamePopupIt.setValue("");
           AdfFacesContext.getCurrentInstance().addPartialTarget(companyNamePopupIt);
           p9.hide();

           //System.out.println("End: cancelCompanyGLCode");
       }
    public void selectCompanyGLCode(ActionEvent actionEvent) {
          System.out.println("Start: selectCompanyGLCode");
          String selectedCompany=null;
          String selectedCompanyDesc = null;
          RowKeySet selectedCompanyName = companyDetailsTable.getSelectedRowKeys();
          Iterator selectedCompanyIter = selectedCompanyName.iterator();
          DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
          DCIteratorBinding comIter = bindings.findIteratorBinding("CompanyCounterPartyVO1Iterator");
          RowSetIterator comRSIter=null;
          try{
              comRSIter = comIter.getRowSetIterator();
          while(selectedCompanyIter.hasNext()){
             Key key = (Key)((List)selectedCompanyIter.next()).get(0);
             Row currentRow = comRSIter.getRow(key);
              if(currentRow.getAttribute("Company") != null){
             //System.out.println(currentRow.getAttribute("Company"));
               selectedCompany=currentRow.getAttribute("Company").toString();
               companyNameIt.setValue(selectedCompany);
              }
              else{
                   companyNameIt.setValue("");
                  }
               if(currentRow.getAttribute("CompanyDescription") != null){
                   selectedCompanyDesc=currentRow.getAttribute("CompanyDescription").toString();
                   //System.out.println("company desc in inner popup ::: "+ selectedCompanyDesc);
                   companyNameOt.setValue(selectedCompanyDesc);
               }else{
                   companyNameOt.setValue("");
               }
           }
          }catch(Exception e)
          {e.printStackTrace();
           }
          finally{
                      if(comRSIter!=null) {
                          try {
                              comRSIter.closeRowSetIterator();
                          } catch(Exception ex) {
                              ex.printStackTrace();

                      }
                      }
                  }
          //System.out.println("company desc set in output text ::: "+ companyNameOt.getValue());
          AdfFacesContext.getCurrentInstance().addPartialTarget(companyNameIt);
          AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
          companyNamePopupIt.setValue("");
          AdfFacesContext.getCurrentInstance().addPartialTarget(companyNamePopupIt);
          p9.hide();
          System.out.println("End selectCompanyGLCode");
      }


    public void openGLCodeCompanyPopupClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openGLCodeCompanyPopupClick");
        try {

            String enteredCompany = null;
            String searchType = null;

                if(companyNamePopupIt.getValue() != null) {
                    enteredCompany = companyNamePopupIt.getValue().toString();
                    //System.out.println("companyNamePopupIt.getValue(): "+enteredCompany);
                    }
                if(companySoc.getValue() != null) {
                    searchType = companySoc.getValue().toString();
                    //System.out.println("companySoc.getValue(): "+searchType);
                }
                 executeGLCodeCompanyVO(enteredCompany, searchType, false);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(companyDetailsTable);

             //   }

            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p9.show(hints);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openGLCodeCompanyPopupClick");
    }

    public void openGLCodeCompanyPopup(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openGLCodeCompanyPopup");
        try {

            String enteredCompany = null;

                if(companyNameIt.getValue() != null) {
                    enteredCompany = companyNameIt.getValue().toString();
                    //System.out.println("companyNameIt.getValue(): "+enteredCompany);
                }
                    DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                    DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CompanyCounterPartyVO1Iterator");
                    ViewObjectImpl companyPopupVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                    ViewCriteria vc = companyPopupVO.getViewCriteria("CompanyVOCriteria");
                    companyPopupVO.applyViewCriteria(vc);
                    companyPopupVO.setNamedWhereClauseParam("bindCompanyName", enteredCompany);
                    //System.out.println("-----------Dynamic Query-----------");
                    //System.out.println(companyPopupVO.getQuery());
                    companyPopupVO.executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(companyDetailsTable);

             //   }
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p9.show(hints);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openGLCodeCompanyPopup");
    }

    public void openGLCodeCostCenterPopup(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openGLCodeCostCenterPopup");
        try {

            String enteredCostCentre = null;

                if(costCentreIT.getValue() != null) {
                    enteredCostCentre = costCentreIT.getValue().toString();
                    //System.out.println("costCentreIT.getValue(): "+enteredCostCentre);
                }
                    DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                    DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CostCentreVO1Iterator");
                    ViewObjectImpl costCentreVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                    ViewCriteria vc = costCentreVO.getViewCriteria("CostCentreVOCriteria");
                    costCentreVO.applyViewCriteria(vc);
                    costCentreVO.setNamedWhereClauseParam("bindCostCentre", enteredCostCentre);
                    //System.out.println("-----------Dynamic Query-----------");
                    //System.out.println(costCentreVO.getQuery());
                    costCentreVO.executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(costCentreDetailsTable);
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    p10.show(hints);
              //  }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openGLCodeCostCenterPopup");

    }


    public void openGLCodeCostCenterPopupclick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openGLCodeCostCenterPopupclick");
        try {

            String enteredCostCentre = null;
            String searchType = null;
                if(costCentrePopupIt.getValue() != null) {
                    enteredCostCentre = costCentrePopupIt.getValue().toString();
                    //System.out.println("costCentrePopupIt.getValue(): "+enteredCostCentre);
                }
                if(costcenterSoc.getValue() != null) {
                    searchType = costcenterSoc.getValue().toString();
                    //System.out.println("costcenterSoc.getValue(): "+searchType);
                }

                    executeGLCodeCostCentreVO(enteredCostCentre, searchType, false);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(costCentreDetailsTable);
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    p10.show(hints);
               // }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openGLCodeCostCenterPopupclick");

    }

    public void cancelCostCentreGLCode(ActionEvent actionEvent) {
           // Add event code here...
           //System.out.println("Start: cancelCostCentreGLCode");
           costCentrePopupIt.setValue("");
           AdfFacesContext.getCurrentInstance().addPartialTarget(costCentrePopupIt);
           p10.hide();

           //System.out.println("End: cancelCostCentreGLCode");
       }
    public void selectCostCentreGLCode(ActionEvent actionEvent) {
          System.out.println("Start: selectCostCentreGLCode");
          String selectedCostCentre=null;
          String costCenterDesc = null;
       //   String selectedEmployeeNo=null;
        //  String selectedcertifierEmail=null;
          RowKeySet selectedCostCentreName = costCentreDetailsTable.getSelectedRowKeys();
          Iterator selectedCostCentreIter = selectedCostCentreName.iterator();
          DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
          DCIteratorBinding costCentreIter = bindings.findIteratorBinding("CostCentreVO1Iterator");
          RowSetIterator costCentreRSIter=null;
          try{
              costCentreRSIter = costCentreIter.getRowSetIterator();
          while(selectedCostCentreIter.hasNext()){
             Key key = (Key)((List)selectedCostCentreIter.next()).get(0);
             Row currentRow = costCentreRSIter.getRow(key);
               if(currentRow.getAttribute("Costcentre") != null)
               {
                //System.out.println(currentRow.getAttribute("Costcentre"));
               selectedCostCentre=currentRow.getAttribute("Costcentre").toString();
                   costCentreIT.setValue(selectedCostCentre);
               }
              else
               {
                   costCentreIT.setValue("");
                   }
               if(currentRow.getAttribute("Description") != null){
                                  costCenterDesc=currentRow.getAttribute("Description").toString();
                                  //System.out.println("company desc in inner popup ::: "+ costCenterDesc);
                                  costCentreOt.setValue(costCenterDesc);
                              }else{
                                  costCentreOt.setValue("");
                              }

           }
          }catch(Exception e)
          {
              e.printStackTrace();
              }
          finally{
                      if(costCentreRSIter!=null) {
                          try {
                              costCentreRSIter.closeRowSetIterator();
                          } catch(Exception ex) {
                              ex.printStackTrace();

                      }
                      }
                  }
          //System.out.println("cost center desc set in output text ::: "+ costCentreOt.getValue());
          AdfFacesContext.getCurrentInstance().addPartialTarget(costCentreIT);
          AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
          costCentrePopupIt.setValue("");
          AdfFacesContext.getCurrentInstance().addPartialTarget(costCentrePopupIt);
          p10.hide();
          System.out.println("End selectCostCentreGLCode");
      }

    public void openGLCodeAccountPopup(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openGLCodeAccountPopup");
        try {

            String enteredAccount = null;

                if(accountNameIt.getValue() != null) {
                    enteredAccount = accountNameIt.getValue().toString();
                    //System.out.println("accountNameIt.getValue(): "+enteredAccount);
                }
                    DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                    DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("AccountVO1Iterator");
                    ViewObjectImpl accountVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                    ViewCriteria vc = accountVO.getViewCriteria("AccountVOCriteria");
                    accountVO.applyViewCriteria(vc);
                    accountVO.setNamedWhereClauseParam("bindAccountName", enteredAccount);
                    //System.out.println("-----------Dynamic Query-----------");
                    //System.out.println(accountVO.getQuery());
                    accountVO.executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(accountDetailsTable);
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    p11.show(hints);

             //   }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openGLCodeAccountPopup");
    }

    public void cancelAccountGLCode(ActionEvent actionEvent) {
           // Add event code here...
           //System.out.println("Start: cancelAccountGLCode");
           accountNamePopupIt.setValue("");
           AdfFacesContext.getCurrentInstance().addPartialTarget(accountNamePopupIt);
           p11.hide();

           //System.out.println("End: cancelAccountGLCode");
       }
    public void selectAccountGLCode(ActionEvent actionEvent) {
          System.out.println("Start: selectAccountGLCode");
          String selectedAccount=null;
          String selectedAccountDescription = null;
       //   String selectedEmployeeNo=null;
        //  String selectedcertifierEmail=null;
          RowKeySet selectedAccountName = accountDetailsTable.getSelectedRowKeys();
          Iterator selectedCertifierIter = selectedAccountName.iterator();
          DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
          DCIteratorBinding accIter = bindings.findIteratorBinding("AccountVO1Iterator");
          RowSetIterator accRSIter=null;
          try{
              accRSIter = accIter.getRowSetIterator();
          while(selectedCertifierIter.hasNext()){
             Key key = (Key)((List)selectedCertifierIter.next()).get(0);
             Row currentRow = accRSIter.getRow(key);
               if(currentRow.getAttribute("Account") != null)
               {
                //System.out.println(currentRow.getAttribute("Account"));
               selectedAccount=currentRow.getAttribute("Account").toString();
               accountNameIt.setValue(selectedAccount);
               }
              else
               {
                     accountNameIt.setValue("");
                   }
               if(currentRow.getAttribute("AccountDescription") != null){
                                  selectedAccountDescription=currentRow.getAttribute("AccountDescription").toString();
                                  //System.out.println("company desc in inner popup ::: "+ selectedAccountDescription);
                                  accountNameOt.setValue(selectedAccountDescription);
                              }else{
                                  accountNameOt.setValue("");
                              }

           }
          }catch(Exception e)
          {
              e.printStackTrace();
              }
          finally{
                      if(accRSIter!=null) {
                          try {
                              accRSIter.closeRowSetIterator();
                          } catch(Exception ex) {
                              ex.printStackTrace();

                      }
                      }
                  }

          AdfFacesContext.getCurrentInstance().addPartialTarget(accountNameIt);
          AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
          accountNamePopupIt.setValue("");
          AdfFacesContext.getCurrentInstance().addPartialTarget(accountNamePopupIt);
          p11.hide();
          System.out.println("End selectAccountGLCode");
      }


    public void openGLCodeAccountPopupClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openGLCodeAccountPopupClick");
        try {

            String enteredAccount = null;
            String searchType = null;
                if(accountNamePopupIt.getValue() != null) {
                    enteredAccount = accountNamePopupIt.getValue().toString();
                    //System.out.println("accountNamePopupIt.getValue(): "+enteredAccount);
                }
                if(accountSoc.getValue() != null) {
                    searchType = accountSoc.getValue().toString();
                    System.out.println("accountSoc.getValue(): "+searchType);
                }
                    executeGLCodeAccountVO(enteredAccount, searchType, false);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(accountDetailsTable);
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    p11.show(hints);
              //  }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openGLCodeAccountPopupClick");
    }


    public void openGLCodeAnalysisPopup(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openGLCodeAnalysisPopup");
        try {


            String enteredAnalysiscode = null;

                if(analysisCodeIt.getValue() != null) {
                    enteredAnalysiscode = analysisCodeIt.getValue().toString();
                    //System.out.println("analysisCodeIt.getValue(): "+enteredAnalysiscode);
                }
                    DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                    DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("AnalysisCodeVO1Iterator");
                    ViewObjectImpl analysisCodeVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                    ViewCriteria vc = analysisCodeVO.getViewCriteria("AnalysisCodeVOCriteria");
                    analysisCodeVO.applyViewCriteria(vc);
                    analysisCodeVO.setNamedWhereClauseParam("bindAnalysisCode", enteredAnalysiscode);
                    //System.out.println("-----------Dynamic Query-----------");
                   // System.out.println(analysisCodeVO.getQuery());
                    analysisCodeVO.executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(analysisCodeDetailsTable);
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    p12.show(hints);
             //   }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openGLCodeAnalysisPopup");
    }

    public void openGLCodeAnalysisCodePopupClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openGLCodeAnalysisCodePopupClick");
        try {

            String enteredAnalysisCode = null;
            String searchType = null;
                if(analysisCodePopupIt.getValue() != null) {
                    enteredAnalysisCode = analysisCodePopupIt.getValue().toString();
                    //System.out.println("analysisCodePopupIt.getValue(): "+enteredAnalysisCode);
                }
                if(analysisCodeSoc.getValue() != null) {
                    searchType = analysisCodeSoc.getValue().toString();
                    //System.out.println("analysisCodeSoc.getValue(): "+searchType);
                }

                    executeGLCodeAnalysisVO(enteredAnalysisCode, searchType, false);

                    AdfFacesContext.getCurrentInstance().addPartialTarget(analysisCodeDetailsTable);
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    p12.show(hints);
             //   }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openGLCodeAnalysisCodePopupClick");
    }
    public void cancelAnalysisCodeGLCode(ActionEvent actionEvent) {
           // Add event code here...
           //System.out.println("Start: cancelAnalysisCodeGLCode");
           analysisCodePopupIt.setValue("");
           AdfFacesContext.getCurrentInstance().addPartialTarget(analysisCodePopupIt);
           p12.hide();

           //System.out.println("End: cancelAnalysisCodeGLCode");
       }
    public void selectAnalysisCodeGLCode(ActionEvent actionEvent) {
          System.out.println("Start: selectAnalysisCodeGLCode");
          String selectedAnalysisCode=null;
          String analysisDesc = null;
       //   String selectedEmployeeNo=null;
        //  String selectedcertifierEmail=null;
          RowKeySet selectedAnalysisCodeSet = analysisCodeDetailsTable.getSelectedRowKeys();
          Iterator selectedAnalysisCodeIter = selectedAnalysisCodeSet.iterator();
          DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
          DCIteratorBinding analysiscodeIter = bindings.findIteratorBinding("AnalysisCodeVO1Iterator");
          RowSetIterator analysiscodeRSIter=null;
          try{
              analysiscodeRSIter = analysiscodeIter.getRowSetIterator();
          while(selectedAnalysisCodeIter.hasNext()){
             Key key = (Key)((List)selectedAnalysisCodeIter.next()).get(0);
             Row currentRow = analysiscodeRSIter.getRow(key);
               if(currentRow.getAttribute("Analysiscode") != null)
               {
             //System.out.println(currentRow.getAttribute("Analysiscode"));
               selectedAnalysisCode=currentRow.getAttribute("Analysiscode").toString();
                   analysisCodeIt.setValue(selectedAnalysisCode);
               }
              else
               {
                       analysisCodeIt.setValue("");
                   }
               if(currentRow.getAttribute("Description") != null)
               {
               //System.out.println(currentRow.getAttribute("Description"));
               analysisDesc=currentRow.getAttribute("Description").toString();
                   analysisCodeOt.setValue(analysisDesc);
               }
               else
               {
                       analysisCodeOt.setValue("");
                   }

           }
          }catch(Exception e)
          {
              e.printStackTrace();
              }
          finally{
                      if(analysiscodeRSIter!=null) {
                          try {
                              analysiscodeRSIter.closeRowSetIterator();
                          } catch(Exception ex) {
                              ex.printStackTrace();

                      }
                      }
                  }
          AdfFacesContext.getCurrentInstance().addPartialTarget(analysisCodeIt);
          AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
          analysisCodePopupIt.setValue("");
          AdfFacesContext.getCurrentInstance().addPartialTarget(analysisCodePopupIt);

          p12.hide();
          System.out.println("End selectAnalysisCodeGLCode");
      }


    public void openGLCodeCounterPartyPopup(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start openGLCodeCounterPartyPopup");
        try {
            String enteredCounterParty = null;

                if(counterPartyIt.getValue() != null) {
                    enteredCounterParty = counterPartyIt.getValue().toString();
                    //System.out.println("counterPartyIt.getValue(): "+enteredCounterParty);

                }

                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CompanyCounterPartyVO1Iterator");
                ViewObjectImpl counterPartyVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria counterPartyvc = counterPartyVO.getViewCriteria("CounterPartyVOCriteria");
                counterPartyVO.applyViewCriteria(counterPartyvc);
                counterPartyVO.setNamedWhereClauseParam("bindCounterParty", enteredCounterParty);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(counterPartyVO.getQuery());
                counterPartyVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(counterPartyDetailsTable);
         //   }
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p13.show(hints);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openGLCodeCounterPartyPopup");
    }

    public void openGLCodeCounterPartyPopupClick(ActionEvent actionEvent) {
        System.out.println("Start openGLCodeCounterPartyPopupClick");
        try {
            String enteredCounterParty = null;
            String searchType = null;
                if(counterPartyPopupIt.getValue() != null) {
                    enteredCounterParty = counterPartyPopupIt.getValue().toString();
                    //System.out.println("counterPartyPopupIt.getValue(): "+enteredCounterParty);

                }
                if(counterPartySoc.getValue() != null) {
                    searchType = counterPartySoc.getValue().toString();
                    //System.out.println("counterPartySoc.getValue(): "+enteredCounterParty);

                }

                executeGLCodeCounterPartyVO(enteredCounterParty, searchType, false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(counterPartyDetailsTable);
            //}
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p13.show(hints);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End openGLCodeCounterPartyPopupClick");
    }
    public void cancelCounterPartyGLCode(ActionEvent actionEvent) {
           // Add event code here...
           //System.out.println("Start: cancelCounterPartyGLCode");
           counterPartyPopupIt.setValue("");
           AdfFacesContext.getCurrentInstance().addPartialTarget(counterPartyPopupIt);
           p13.hide();

           //System.out.println("End: cancelCounterPartyGLCode");
       }
    public void selectCounterPartyGLCode(ActionEvent actionEvent) {
          System.out.println("Start: selectCounterPartyGLCode");
          String selectedCompany=null;
          String selectedCounterPartDesc = null;
          RowKeySet selectedCompanyName = counterPartyDetailsTable.getSelectedRowKeys();
          Iterator selectedCompanyIter = selectedCompanyName.iterator();
          DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
          DCIteratorBinding comIter = bindings.findIteratorBinding("CompanyCounterPartyVO1Iterator");
          RowSetIterator comRSIter=null;
          try{
              comRSIter = comIter.getRowSetIterator();
          while(selectedCompanyIter.hasNext()){
             Key key = (Key)((List)selectedCompanyIter.next()).get(0);
             Row currentRow = comRSIter.getRow(key);
              if(currentRow.getAttribute("Company") != null){
             //System.out.println(currentRow.getAttribute("Company"));
               selectedCompany=currentRow.getAttribute("Company").toString();
                  counterPartyIt.setValue(selectedCompany);
              }
              else{
                   counterPartyIt.setValue("");
                  }
               if(currentRow.getAttribute("CompanyDescription") != null){
               //System.out.println(currentRow.getAttribute("CompanyDescription"));
                selectedCounterPartDesc=currentRow.getAttribute("CompanyDescription").toString();
                   counterPartyOt.setValue(selectedCounterPartDesc);
               }
               else{
                    counterPartyOt.setValue("");
                   }

           }
          }catch(Exception e){
              e.printStackTrace();
              }
          finally{
                      if(comRSIter!=null) {
                          try {
                              comRSIter.closeRowSetIterator();
                          } catch(Exception ex) {
                              ex.printStackTrace();

                      }
                      }
                  }

          AdfFacesContext.getCurrentInstance().addPartialTarget(counterPartyIt);
          AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
          counterPartyPopupIt.setValue("");
          AdfFacesContext.getCurrentInstance().addPartialTarget(counterPartyPopupIt);
          p13.hide();
          System.out.println("End selectCounterPartyGLCode");
      }



    public void cancelReassignTo(ActionEvent actionEvent) {
       // Add event code here...
       //System.out.println("Start: cancelReassign");
        reassignPopupIT.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(reassignPopupIT);
       p8.hide();

       //System.out.println("End: cancelReassign");
    }
    public void selectReassignTo(ActionEvent actionEvent) {
              System.out.println("Start: selectReassignTo");
              String selectedReassignTo=null;
              String selectedReassignToId=null;
              String selectedReassignToEmailId=null;
              RowKeySet selectedReassign = reassignDetailsTable.getSelectedRowKeys();
              Iterator selectedReassignIter = selectedReassign.iterator();
              DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
              DCIteratorBinding reassignIter = bindings.findIteratorBinding("CertifierNameVO_ActiveOnlyRecords1Iterator");
              RowSetIterator reassignRSIter=null;
              try{
                  reassignRSIter = reassignIter.getRowSetIterator();
              while(selectedReassignIter.hasNext()){
                 Key key = (Key)((List)selectedReassignIter.next()).get(0);
                 Row currentRow = reassignRSIter.getRow(key);
                 //System.out.println(currentRow.getAttribute("Conname"));
                   selectedReassignTo=currentRow.getAttribute("Conname").toString();
                   selectedReassignToId=currentRow.getAttribute("EmployeeNumber").toString();
                  selectedReassignToEmailId=currentRow.getAttribute("EmailAddress").toString();
              }
              }catch(Exception e)
              {
                  e.printStackTrace();
                  }
              finally{
                          if(reassignRSIter!=null) {
                              try {
                                  reassignRSIter.closeRowSetIterator();
                              } catch(Exception ex) {
                                  ex.printStackTrace();

                          }
                          }
                      }

              reassignToIT.setValue(selectedReassignTo);
              reassingToIDPopupIT.setValue(selectedReassignToId);
              reassignEmailIdIT.setValue(selectedReassignToEmailId);
             // AdfFacesContext.getCurrentInstance().addPartialTarget(outerPgl);
              reassignPopupIT.setValue("");
              AdfFacesContext.getCurrentInstance().addPartialTarget(reassignToIT);
              AdfFacesContext.getCurrentInstance().addPartialTarget(reassignPopupIT);
              AdfFacesContext.getCurrentInstance().addPartialTarget(reassignEmailIdIT);
              AdfFacesContext.getCurrentInstance().addPartialTarget(reassingToIDPopupIT);
              p8.hide();
              System.out.println("End selectReassignTo");
          }
    public void searchReassignTo(ActionEvent actionEvent) {
        System.out.println("Start searchReassignTo");
        try {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            p8.show(hints);
            String enteredReassignTo = null;
            if(reassignToIT.getValue() != null) {
                            enteredReassignTo = reassignToIT.getValue().toString();
                            //System.out.println("reassignToIT.getValue(): "+enteredReassignTo);
            }
                            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CertifierNameVO_ActiveOnlyRecords1Iterator");
                            ViewObjectImpl reassignToVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                            ViewCriteria reassignToVc = reassignToVO.getViewCriteria("CertifierNameVOCriteria");
                            reassignToVO.applyViewCriteria(reassignToVc);
                           // certifierNameVO.clearCache();
                            reassignToVO.setNamedWhereClauseParam("bindName", enteredReassignTo);
                            //System.out.println("-----------Dynamic Query-----------");
                            //System.out.println(reassignToVO.getQuery());
                            reassignToVO.executeQuery();
                            AdfFacesContext.getCurrentInstance().addPartialTarget(reassignDetailsTable);

           // }


        }
        catch(Exception e) {
            System.out.println("SearchReassign Exception : "+e.getMessage());
        }
        System.out.println("End searchReassignTo");
    }

    public void onReassignToPopUpGoClick(ActionEvent actionEvent) {
           System.out.println("Start onReassignPopUpGoClick");
           String enteredReassignPerson = null;
           String searchType = null;
           try {
               if(reassignPopupIT.getValue() != null) {
                               enteredReassignPerson = reassignPopupIT.getValue().toString();
                               //System.out.println("reassignPopupIT.getValue(): "+enteredReassignPerson);
                               if(searchByCertifiername.getValue() != null) {
                                       searchType = searchByCertifiername.getValue().toString();
                                       //System.out.println("searchByCertifiername.getValue(): "+searchType);
                               }

                               DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                               DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CertifierNameVO_ActiveOnlyRecords1Iterator");
                               ViewObjectImpl reassignToVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                               ViewCriteria reassignToVc = reassignToVO.getViewCriteria("CertifierNameVO_ActiveOnlyRecordsCriteria");
                               if(searchType != null && searchType.equals("certName")){
                                       //System.out.println("inside certName if");
                                       reassignToVO.applyViewCriteria(reassignToVc);
                                       reassignToVO.setNamedWhereClauseParam("bindName", enteredReassignPerson);
                                       reassignToVO.setNamedWhereClauseParam("bvEmployeeID", null);
                                       reassignToVO.setNamedWhereClauseParam("bindEmailAddress", null);
                                       //System.out.println(reassignToVO.getQuery());
                                       reassignToVO.executeQuery();
                               }
                               if(searchType != null && searchType.equals("empNumber")){
                                       //System.out.println("inside empNumber if");
                                       reassignToVO.applyViewCriteria(reassignToVc);
                                       reassignToVO.setNamedWhereClauseParam("bvEmployeeID", enteredReassignPerson);
                                       reassignToVO.setNamedWhereClauseParam("bindName", null);
                                       reassignToVO.setNamedWhereClauseParam("bindEmailAddress", null);
                                       //System.out.println(reassignToVO.getQuery());
                                       reassignToVO.executeQuery();
                               }
                               if(searchType != null && searchType.equals("email")){
                                       //System.out.println("inside email if");
                                       reassignToVO.applyViewCriteria(reassignToVc);
                                       reassignToVO.setNamedWhereClauseParam("bindEmailAddress", enteredReassignPerson);
                                       reassignToVO.setNamedWhereClauseParam("bindName", null);
                                       reassignToVO.setNamedWhereClauseParam("bvEmployeeID", null);
                                       //System.out.println(reassignToVO.getQuery());
                                       reassignToVO.executeQuery();
                               }
                               AdfFacesContext.getCurrentInstance().addPartialTarget(reassignDetailsTable);

              }
           }
           catch(Exception e) {
               e.printStackTrace();
           }
           System.out.println("End onReassignPopUpGoClick");
       }


    public void setCompanyNameIt(RichInputText companyNameIt) {
        this.companyNameIt = companyNameIt;
    }

    public RichInputText getCompanyNameIt() {
        return companyNameIt;
    }

    public void setCostCentreIT(RichInputText costCentreIT) {
        this.costCentreIT = costCentreIT;
    }

    public RichInputText getCostCentreIT() {
        return costCentreIT;
    }

    public void setAccountNameIt(RichInputText accountNameIt) {
        this.accountNameIt = accountNameIt;
    }

    public RichInputText getAccountNameIt() {
        return accountNameIt;
    }

    public void setAnalysisCodeIt(RichInputText analysisCodeIt) {
        this.analysisCodeIt = analysisCodeIt;
    }

    public RichInputText getAnalysisCodeIt() {
        return analysisCodeIt;
    }

    public void setCounterPartyIt(RichInputText counterPartyIt) {
        this.counterPartyIt = counterPartyIt;
    }

    public RichInputText getCounterPartyIt() {
        return counterPartyIt;
    }

    public void setP9(RichPopup p9) {
        this.p9 = p9;
    }

    public RichPopup getP9() {
        return p9;
    }

    public void setCompanyNamePopupIt(RichInputText companyNamePopupIt) {
        this.companyNamePopupIt = companyNamePopupIt;
    }

    public RichInputText getCompanyNamePopupIt() {
        return companyNamePopupIt;
    }

    public void setCompanyDetailsTable(RichTable companyDetailsTable) {
        this.companyDetailsTable = companyDetailsTable;
    }

    public RichTable getCompanyDetailsTable() {
        return companyDetailsTable;
    }

    public void setP10(RichPopup p10) {
        this.p10 = p10;
    }

    public RichPopup getP10() {
        return p10;
    }

    public void setCostCentrePopupIt(RichInputText costCentrePopupIt) {
        this.costCentrePopupIt = costCentrePopupIt;
    }

    public RichInputText getCostCentrePopupIt() {
        return costCentrePopupIt;
    }

    public void setCostCentreDetailsTable(RichTable costCentreDetailsTable) {
        this.costCentreDetailsTable = costCentreDetailsTable;
    }

    public RichTable getCostCentreDetailsTable() {
        return costCentreDetailsTable;
    }

    public void setP11(RichPopup p11) {
        this.p11 = p11;
    }

    public RichPopup getP11() {
        return p11;
    }

    public void setAccountNamePopupIt(RichInputText accountNamePopupIt) {
        this.accountNamePopupIt = accountNamePopupIt;
    }

    public RichInputText getAccountNamePopupIt() {
        return accountNamePopupIt;
    }

    public void setAccountDetailsTable(RichTable accountDetailsTable) {
        this.accountDetailsTable = accountDetailsTable;
    }

    public RichTable getAccountDetailsTable() {
        return accountDetailsTable;
    }

    public void setP12(RichPopup p12) {
        this.p12 = p12;
    }

    public RichPopup getP12() {
        return p12;
    }

    public void setAnalysisCodePopupIt(RichInputText analysisCodePopupIt) {
        this.analysisCodePopupIt = analysisCodePopupIt;
    }

    public RichInputText getAnalysisCodePopupIt() {
        return analysisCodePopupIt;
    }

    public void setAnalysisCodeDetailsTable(RichTable analysisCodeDetailsTable) {
        this.analysisCodeDetailsTable = analysisCodeDetailsTable;
    }

    public RichTable getAnalysisCodeDetailsTable() {
        return analysisCodeDetailsTable;
    }

    public void setP13(RichPopup p13) {
        this.p13 = p13;
    }

    public RichPopup getP13() {
        return p13;
    }

    public void setCounterPartyPopupIt(RichInputText counterPartyPopupIt) {
        this.counterPartyPopupIt = counterPartyPopupIt;
    }

    public RichInputText getCounterPartyPopupIt() {
        return counterPartyPopupIt;
    }

    public void setCounterPartyDetailsTable(RichTable counterPartyDetailsTable) {
        this.counterPartyDetailsTable = counterPartyDetailsTable;
    }

    public RichTable getCounterPartyDetailsTable() {
        return counterPartyDetailsTable;
    }

    public void setClientID(RichInputText clientID) {
        this.clientID = clientID;
    }

    public RichInputText getClientID() {
        return clientID;
    }

    public void setInvoiceTypeIT(RichInputText invoiceTypeIT) {
        this.invoiceTypeIT = invoiceTypeIT;
    }

    public RichInputText getInvoiceTypeIT() {
        return invoiceTypeIT;
    }

    public void setSiteIdIt(RichInputText siteIdIt) {
        this.siteIdIt = siteIdIt;
    }

    public RichInputText getSiteIdIt() {
        return siteIdIt;
    }

    public void setTaxRateCodePopupIt(RichInputText taxRateCodePopupIt) {
        this.taxRateCodePopupIt = taxRateCodePopupIt;
    }

    public RichInputText getTaxRateCodePopupIt() {
        return taxRateCodePopupIt;
    }

    public void setTaxRateCodeDetailsTable(RichTable taxRateCodeDetailsTable) {
        this.taxRateCodeDetailsTable = taxRateCodeDetailsTable;
    }

    public RichTable getTaxRateCodeDetailsTable() {
        return taxRateCodeDetailsTable;
    }

    public void setValidationErrorPopup(RichPopup validationErrorPopup) {
        this.validationErrorPopup = validationErrorPopup;
    }

    public RichPopup getValidationErrorPopup() {
        return validationErrorPopup;
    }

    public void setValidationErrorMessage(RichOutputText validationErrorMessage) {
        this.validationErrorMessage = validationErrorMessage;
    }

    public RichOutputText getValidationErrorMessage() {
        return validationErrorMessage;
    }

    public void validateExpenditureType(ClientEvent clientEvent) {
        // Add event code here...
        RichInputText inputTxt =  (RichInputText) clientEvent.getComponent();

        Map  parameters = clientEvent.getParameters();
        System.out.println("SubmittedValue = "+parameters.get("submittedValue"));
        System.out.println("LocalValue = " +parameters.get("localValue"));

        oracle.jbo.domain.Date expDate = null;
        String expenditureDate = null;

        System.out.println("Start validateExpenditureType");
        String clientId = clientEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        System.out.println(" ----- clientID : "+clientId);
        this.clientID.setValue(clientId);

        int selectedRowNum = -1;

        if(clientID.getValue()!=null) {
                selectedRowNum = Integer.parseInt(clientID.getValue().toString().split(":")[2]);
                System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);
        }

        try {
            String enteredExpenditureType=null;
            String enteredProjectId=setProjectIdIt();
            expDate = getExpenditureDate ();

            System.out.println("Expenditure Date value : "+expDate);

            /**** Check whether expenditure date is present or not ****/

            if(expDate == null){

                System.out.println("Expenditure Date blank");
                String vallMsg="Please Enter Expenditure Date before entering Expenditure Type";
                this.validationErrorMessage.setValue(vallMsg);
                AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                validationErrorPopup.show(hints);

                 if(selectedRowNum!=-1) {

                     String componentIDExpType = "pt1:t1:"+selectedRowNum+":it28::content";
                     System.out.println("----- componentIDExpType ----- "+componentIDExpType+", selectedExpType : "+"");
                     FacesContext fctx = FacesContext.getCurrentInstance();
                     ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                     String myJavaScriptCode = "document.getElementById('"+componentIDExpType+"').value = '"+""+"'";
                     erks.addScript(fctx, myJavaScriptCode );

                 }

                    System.out.println("returning from Validate method on null date");
            }

            else{


                SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
                expenditureDate = expDate != null ? DATE_FORMAT.format(expDate.getValue()): null;

                System.out.println("printing even after return");

                String selectedExpType=null;
                System.out.println("projectIdIt.getValue(): "+enteredProjectId);


                enteredExpenditureType=(String)parameters.get("submittedValue");
                System.out.println("ExpType.getValue(): "+enteredExpenditureType);

                if(enteredExpenditureType!=null && !enteredExpenditureType.equals("") && enteredExpenditureType!="" && enteredExpenditureType.trim()!=null && !enteredExpenditureType.trim().isEmpty() &&
                enteredProjectId!=null && !enteredProjectId.equals("") && enteredProjectId!="" && enteredProjectId.trim()!=null && !enteredProjectId.trim().isEmpty()){

                  boolean invalidQuery=true;

                    DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                    DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ExpenditureTypeVO1Iterator");
                    ViewObjectImpl expenditureTypeValidateVo = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                    ViewCriteria vc = expenditureTypeValidateVo.getViewCriteria("ExpenditureTypeVOCriteria2");
                    expenditureTypeValidateVo.applyViewCriteria(vc);
                    expenditureTypeValidateVo.setNamedWhereClauseParam("bindProjectId", enteredProjectId);
                    expenditureTypeValidateVo.setNamedWhereClauseParam("bindExpType", enteredExpenditureType);
                    expenditureTypeValidateVo.setNamedWhereClauseParam("bindExpDate", expenditureDate);
                    expenditureTypeValidateVo.executeQuery();
                    System.out.println("Expenditure Type Row Count : "+expenditureTypeValidateVo.getEstimatedRowCount());
                                        //            while(expenditureTypeValidateVo.hasNext()){
                                        //                    Row row = expenditureTypeValidateVo.next();
                                        // 14-12-2022 Change next() to getCurrentRow()
                                        if (expenditureTypeValidateVo.getEstimatedRowCount()>0){
                                        Row row = expenditureTypeValidateVo.getCurrentRow();
                    if(row.getAttribute("ExpenditureType") != null){
                    System.out.println(row.getAttribute("ExpenditureType"));
                     selectedExpType=row.getAttribute("ExpenditureType").toString();

                         if(selectedRowNum!=-1) {

                             String componentIDExpType = "pt1:t1:"+selectedRowNum+":it28::content";
                             System.out.println("----- componentIDExpType ----- "+componentIDExpType+", selectedExpType : "+selectedExpType);

                             FacesContext fctx = FacesContext.getCurrentInstance();
                             ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                             String myJavaScriptCode = "document.getElementById('"+componentIDExpType+"').value = '"+selectedExpType+"'";
                             erks.addScript(fctx, myJavaScriptCode );

                         }
                    }
                    else{

                           System.out.println("Invalid Expenditure type");
                           String vallMsg="Please Enter a valid Expenditure Type";
                           this.validationErrorMessage.setValue(vallMsg);
                           AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                           RichPopup.PopupHints hints = new RichPopup.PopupHints();
                           validationErrorPopup.show(hints);

                            if(selectedRowNum!=-1) {


                                String componentIDExpType = "pt1:t1:"+selectedRowNum+":it28::content";
                                System.out.println("----- componentIDExpType ----- "+componentIDExpType+", selectedExpType : "+"");

                                FacesContext fctx = FacesContext.getCurrentInstance();
                                ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                                String myJavaScriptCode = "document.getElementById('"+componentIDExpType+"').value = '"+""+"'";
                                erks.addScript(fctx, myJavaScriptCode );

                            }

                        }

                    invalidQuery=false;
                }
                if(invalidQuery)
                {
                    System.out.println("Executing"+invalidQuery);

                       System.out.println("Invalid ExpenditureType");
                       String vallMsg="Please Enter a valid Expenditure Type";
                       this.validationErrorMessage.setValue(vallMsg);
                       AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                       RichPopup.PopupHints hints = new RichPopup.PopupHints();
                       validationErrorPopup.show(hints);
                        if(selectedRowNum!=-1) {

                            String componentIDExpType = "pt1:t1:"+selectedRowNum+":it28::content";
                            System.out.println("----- componentIDExpType ----- "+componentIDExpType+", selectedExpType : "+"");

                            FacesContext fctx = FacesContext.getCurrentInstance();
                            ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                            String myJavaScriptCode = "document.getElementById('"+componentIDExpType+"').value = '"+""+"'";
                            erks.addScript(fctx, myJavaScriptCode );

                        }
                    }
                }
                else{
                if(selectedRowNum!=-1) {

                    String componentIDExpType = "pt1:t1:"+selectedRowNum+":it28::content";
                    System.out.println("----- componentIDExpType ----- "+componentIDExpType+", selectedExpType : "+"");

                    FacesContext fctx = FacesContext.getCurrentInstance();
                    ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                    String myJavaScriptCode = "document.getElementById('"+componentIDExpType+"').value = '"+""+"'";
                    erks.addScript(fctx, myJavaScriptCode );
                    }
                }
                }
            }

        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End validateExpenditureType");
    }


    public void openExpenditureTypePopup(ActionEvent actionEvent) {
        System.out.println("Start openExpenditureTypePopup");
        String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        System.out.println(" ----- clientID : "+clientId);
        this.clientID.setValue(clientId);
        String enteredProjectId=null;
        String enteredTaskId=null;
        RowSetIterator rsIter = null;
        String expenditureDate = null; //Exp Date Change : 18th August : Sourav
        String invNum = null;
        if(invNumIt.getValue()!=null){
        invNum = (String)invNumIt.getValue();
        }
            try{
            /*RowKeySet rowKeySet = lineItemsTable.getSelectedRowKeys();
            Iterator rowKeySetIt = rowKeySet.iterator();
            DCIteratorBinding lineItemIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");
            RowSetIterator lineItemRSIter=null;
            try{
                lineItemRSIter = lineItemIter.getRowSetIterator();
             while(rowKeySetIt.hasNext()){
               Key key = (Key)((List)rowKeySetIt.next()).get(0);
               Row currentRow = lineItemRSIter.getRow(key);
                 if(currentRow!=null) {
                    System.out.println("----- Project ID ----- "+currentRow.getAttribute("Attr4"));
                    enteredProjectId = currentRow.getAttribute("Attr4")==null?"":currentRow.getAttribute("Attr4").toString().trim();

                     System.out.println("----- Task ID ----- "+currentRow.getAttribute("Attr3"));
                     enteredTaskId = currentRow.getAttribute("Attr3")==null?"":currentRow.getAttribute("Attr3").toString().trim();



                    System.out.println("----- Expenditure Date in openExpenditureTypePopup----- "+currentRow.getAttribute("ExpenditureDate"));*/

                    oracle.jbo.domain.Date expDate = null;

                                   DCBindingContainer dcb = (DCBindingContainer)getBindings();
                                   DCIteratorBinding dcItr = dcb .findIteratorBinding("LineItemDetailsEOView1Iterator");
                                   rsIter = dcItr .getRowSetIterator();
                                   Row rowObj = rsIter .getCurrentRow();

                                   System.out.println("invNum: "+invNum+ " Project ID Current Row " + rowObj.getAttribute("Attr4"));
                                   System.out.println("invNum: "+invNum+ " Task ID Current Row " + rowObj.getAttribute("Attr3"));
                                   //System.out.println("projectid: "+projectIdIt.getValue());
                                   //System.out.println("Taskid: "+taskIdIt.getValue());
                                   //System.out.println("ENTERED task NO" + rowObj.getAttribute("TaskNo"));
                                   System.out.println(" invNum: "+invNum+ " Expenditure Current Row " + rowObj.getAttribute("ExpenditureDate"));

                                    enteredProjectId = rowObj.getAttribute("Attr4")==null?"":rowObj.getAttribute("Attr4").toString().trim();
                                    enteredTaskId = rowObj.getAttribute("Attr3")==null?"":rowObj.getAttribute("Attr3").toString().trim();
                                    if("".equalsIgnoreCase(enteredProjectId)){
                                    enteredProjectId=setProjectIdIt();//added by raha for projectno manual
                                    }
                                    if("".equalsIgnoreCase(enteredTaskId)){
                                    enteredTaskId=setTaskIdIt();//added by raha for projectno manual
                                    }
                                    System.out.println("invNum: "+invNum+ " enteredProjectId "+enteredProjectId);//added by raha for projectno manual
                                    System.out.println("invNum: "+invNum+ " enteredtaskId "+enteredTaskId);//added by raha for projectno manual

                    /*** Exp Date change : 18th August : Sourav ***/
                    if(rowObj.getAttribute("ExpenditureDate") == null) {

                        System.out.println("Expenditure Date empty hence exp type popup does not open");
                        String vallMsg="Please enter Expenditure Date in line no "+ rowObj.getAttribute("LineNumber") +" for Expenditure Type";
                        this.validationErrorMessage.setValue(vallMsg);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                        RichPopup.PopupHints hints = new RichPopup.PopupHints();
                        validationErrorPopup.show(hints);
                        return;
                    }

                    expDate = ((oracle.jbo.domain.Date)rowObj.getAttribute("ExpenditureDate"));
                    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
                    expenditureDate = expDate != null ? DATE_FORMAT.format(expDate.getValue()): null;


             }
            catch(Exception e)
            {
                e.printStackTrace();
                }/*finally{
                    if(rsIter != null)
                        rsIter.closeRowSetIterator();
                }*/

        try{
               // String enteredProjectId = setProjectIdIt();
                String enteredExpenditureType = null;
                System.out.println("invNum: "+invNum+ " New Project id in openExpenditureTypePopup :: "+ enteredProjectId);
                System.out.println("invNum: "+invNum+ " New Exp Date in openExpenditureTypePopup :: "+ expenditureDate);
                    if(expTypeIt.getValue() != null){
                        enteredExpenditureType = expTypeIt.getValue().toString();
                        System.out.println("expTypeIt.getValue(): "+enteredExpenditureType);
                    }
                        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ExpenditureTypeVO1Iterator");
                        ViewObjectImpl expenditureTypeVo = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                        ViewCriteria vc = expenditureTypeVo.getViewCriteria("ExpenditureTypeVOCriteria");
                        expenditureTypeVo.applyViewCriteria(vc);
                        expenditureTypeVo.setNamedWhereClauseParam("bindProjectId", enteredProjectId);
                        //expenditureTypeVo.setNamedWhereClauseParam("bindExpType", null);//added by raha for projectno manual
                        expenditureTypeVo.setNamedWhereClauseParam("bindExpType", enteredExpenditureType );//added by raha for additional expenditure type bug fix 13*11*2019
                        expenditureTypeVo.setNamedWhereClauseParam("bindTaskId", enteredTaskId);
                        expenditureTypeVo.setNamedWhereClauseParam("bindExpDate", expenditureDate);
                        expenditureTypeVo.executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(expTypeDetailsTable);

                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                p18.show(hints);
            }
        catch(Exception e){
                e.printStackTrace();
            }

        System.out.println("invNum: "+invNum+ "End: openExpenditureTypePopup");
    }


    public void onExpTypeGoClick(ActionEvent actionEvent) {
        // Add event code here...

        oracle.jbo.domain.Date expDate = null;
        String expenditureDate = null;
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");


        System.out.println("Start onExpTypeGoClick");
        String enteredExpType = null;
        String enteredProjectId=null;
        String enteredTaskId=null;
        RowSetIterator rsIter = null;
        String invNum = null;
        String taskNo = null;
        if(invNumIt.getValue()!=null){
        invNum = (String)invNumIt.getValue();
        }
        /*if(taskNoIT.getValue() != null) {
            taskNo = taskNoIT.getValue().toString();
            System.out.println("invNum:"+invNum+ "taskNoIT.getValue(): "+taskNo);
        }
        System.out.println("invNum:"+invNum+ "taskNoIT2.getValue(): "+taskNo);*/
        try{
            /*RowKeySet rowKeySet = lineItemsTable.getSelectedRowKeys();
            Iterator rowKeySetIt = rowKeySet.iterator();
            DCIteratorBinding lineItemIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");
            RowSetIterator lineItemRSIter=null;
            try{
                lineItemRSIter = lineItemIter.getRowSetIterator();
             while(rowKeySetIt.hasNext()){
               Key key = (Key)((List)rowKeySetIt.next()).get(0);
               Row currentRow = lineItemRSIter.getRow(key);
                 if(currentRow!=null) {
                    System.out.println("----- Project ID ----- "+currentRow.getAttribute("Attr4"));
                    enteredProjectId = currentRow.getAttribute("Attr4")==null?"":currentRow.getAttribute("Attr4").toString().trim();

                     System.out.println("----- Task ID ----- "+currentRow.getAttribute("Attr3"));
                     enteredTaskId = currentRow.getAttribute("Attr3")==null?"":currentRow.getAttribute("Attr3").toString().trim();

                     expDate = (oracle.jbo.domain.Date)currentRow.getAttribute("ExpenditureDate");
                     expenditureDate = expDate != null ? DATE_FORMAT.format(expDate.getValue()): null;

                     System.out.println("----- Expenditure Date ----- "+expenditureDate);*/


                                               DCBindingContainer dcb = (DCBindingContainer)getBindings();
                                               DCIteratorBinding dcItr = dcb .findIteratorBinding("LineItemDetailsEOView1Iterator");
                                               rsIter = dcItr .getRowSetIterator();
                                               Row rowObj = rsIter .getCurrentRow();

                                               System.out.println("Project ID Current Row" + rowObj.getAttribute("Attr4"));
                                               System.out.println("Task ID Current Row" + rowObj.getAttribute("Attr3"));
                                               System.out.println("Expenditure Current Row" + rowObj.getAttribute("ExpenditureDate"));
                                               System.out.println("ENTERED task NO" + rowObj.getAttribute("TaskNo"));

                                               enteredProjectId =rowObj.getAttribute("Attr4")==null?"":rowObj.getAttribute("Attr4").toString().trim();
                                               enteredTaskId =rowObj.getAttribute("Attr3")==null?"":rowObj.getAttribute("Attr3").toString().trim();
                                               if("".equalsIgnoreCase(enteredProjectId)){
                                               enteredProjectId=setProjectIdIt();//added by raha for projectno manual
                                               }
                                               if("".equalsIgnoreCase(enteredTaskId)){
                                               enteredTaskId=setTaskIdIt();//added by raha for projectno manual
                                               }
                                               System.out.println("invNum:"+invNum+ "enteredProjectId"+enteredProjectId);//added by raha for projectno manual
                                               System.out.println("invNum:"+invNum+ "enteredtaskId"+enteredTaskId); //added by raha for projectno manual

                                /*** Exp Date change : 18th August : Sourav ***/
                                if(rowObj.getAttribute("ExpenditureDate") == null) {

                                    System.out.println("Expenditure Date empty hence exp type popup does not open");
                                    String vallMsg="Please enter Expenditure Date in line no "+ rowObj.getAttribute("LineNumber") +" for Expenditure Type";
                                    this.validationErrorMessage.setValue(vallMsg);
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                                    validationErrorPopup.show(hints);
                                    return;
                                }

                                expDate = ((oracle.jbo.domain.Date)rowObj.getAttribute("ExpenditureDate"));

                                expenditureDate = expDate != null ? DATE_FORMAT.format(expDate.getValue()): null;


        }

            catch(Exception e)
            {
            e.printStackTrace();
            }/*finally{
            if(rsIter != null){
                rsIter.closeRowSetIterator();
            }
            }*/

        try {
            if(expTypePopUpIt.getValue() != null) {
                enteredExpType = expTypePopUpIt.getValue().toString();
                System.out.println("expTypePopUpIt.getValue(): "+enteredExpType);
            }

//
//                if(projectIdIt.getValue() != null) {
//                    enteredProjectId = projectIdIt.getValue().toString();
//                    System.out.println("projectIdIt.getValue(): "+enteredProjectId);
//                }
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ExpenditureTypeVO1Iterator");
                ViewObjectImpl expenditureTypeVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = expenditureTypeVO.getViewCriteria("ExpenditureTypeVOCriteria");
                expenditureTypeVO.applyViewCriteria(vc);
                expenditureTypeVO.setNamedWhereClauseParam("bindExpType", enteredExpType);
                expenditureTypeVO.setNamedWhereClauseParam("bindProjectId", enteredProjectId);
                expenditureTypeVO.setNamedWhereClauseParam("bindTaskId", enteredTaskId);
                expenditureTypeVO.setNamedWhereClauseParam("bindExpDate", expenditureDate);
                expenditureTypeVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(expTypeDetailsTable);
            //}
        }
        catch(Exception e) {
            e.printStackTrace();
            }
        System.out.println("End onExpTypeGoClick");
    }

    public void cancelExpenditureTypePopup(ActionEvent actionEvent) {
        // Add event code here...

        //System.out.println("Start: cancelExpenditureTypePopup");
        expTypePopUpIt.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(expTypePopUpIt);
        p18.hide();

        //System.out.println("End: cancelExpenditureTypePopup");
    }

    public void selectExpenditureTypePopup(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start: selectExpenditureTypePopup");



        String selectedExpType="";

        RowKeySet selectedExp = expTypeDetailsTable.getSelectedRowKeys();
        Iterator selectedExpTypeIter = selectedExp.iterator();
        DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = bindings.findIteratorBinding("ExpenditureTypeVO1Iterator");
        RowSetIterator empRSIter=null;
        try{
            empRSIter = empIter.getRowSetIterator();
        while(selectedExpTypeIter.hasNext()){
           Key key = (Key)((List)selectedExpTypeIter.next()).get(0);
           Row currentRow = empRSIter.getRow(key);
           //System.out.println(currentRow.getAttribute("ExpenditureType"));
             selectedExpType=currentRow.getAttribute("ExpenditureType").toString();

         }
        }catch(Exception e)
        {
            e.printStackTrace();
            }
        finally{
                    if(empRSIter!=null) {
                        try {
                            empRSIter.closeRowSetIterator();
                        } catch(Exception ex) {
                            ex.printStackTrace();

                    }
                    }
                }
            //poNumPopupIt.setValue(selectedPONumber);

            int selectedRowNum = -1;

            if(clientID.getValue()!=null) {
                selectedRowNum = Integer.parseInt(clientID.getValue().toString().split(":")[2]);
                //System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);
            }


             if(selectedRowNum!=-1) {


                 String componentIDPoNumber = "pt1:t1:"+selectedRowNum+":it28::content";
                 //System.out.println("----- componentIDPoNumber ----- "+componentIDPoNumber+", selectedExpType : "+selectedExpType);

                 FacesContext fctx = FacesContext.getCurrentInstance();
                 ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                 String myJavaScriptCode = "document.getElementById('"+componentIDPoNumber+"').value = '"+selectedExpType+"'";
                 erks.addScript(fctx, myJavaScriptCode );
             }

        //AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
        expTypePopUpIt.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(expTypePopUpIt);
        p18.hide();
        System.out.println("End selectExpenditureTypePopup");
    }

    public void setP16(RichPopup p16) {
        this.p16 = p16;
    }

    public RichPopup getP16() {
        return p16;
    }

    public void setP14(RichPopup p14) {
        this.p14 = p14;
    }

    public RichPopup getP14() {
        return p14;
    }

    public void setAlternateApproverDetailsTable(RichTable alternateApproverDetailsTable) {
        this.alternateApproverDetailsTable = alternateApproverDetailsTable;
    }

    public RichTable getAlternateApproverDetailsTable() {
        return alternateApproverDetailsTable;
    }

    public void setAlternateAppoverPopupIT(RichInputText alternateAppoverPopupIT) {
        this.alternateAppoverPopupIT = alternateAppoverPopupIT;
    }

    public RichInputText getAlternateAppoverPopupIT() {
        return alternateAppoverPopupIT;
    }

    public void setProjectNoIT(RichInputText projectNoIT) {
        this.projectNoIT = projectNoIT;
    }

    public RichInputText getProjectNoIT() {
        return projectNoIT;
    }

    public void setTaskNoIT(RichInputText taskNoIT) {
        this.taskNoIT = taskNoIT;
    }

    public RichInputText getTaskNoIT() {
        return taskNoIT;
    }

    public void setExpOrgIT(RichInputText expOrgIT) {
        this.expOrgIT = expOrgIT;
    }

    public RichInputText getExpOrgIT() {
        return expOrgIT;
    }

    public void setP7(RichPopup p7) {
        this.p7 = p7;
    }

    public RichPopup getP7() {
        return p7;
    }

    public void setP8(RichPopup p8) {
        this.p8 = p8;
    }

    public RichPopup getP8() {
        return p8;
    }

    public void setReassignPopupIT(RichInputText reassignPopupIT) {
        this.reassignPopupIT = reassignPopupIT;
    }

    public RichInputText getReassignPopupIT() {
        return reassignPopupIT;
    }

    public void setReassignDetailsTable(RichTable reassignDetailsTable) {
        this.reassignDetailsTable = reassignDetailsTable;
    }

    public RichTable getReassignDetailsTable() {
        return reassignDetailsTable;
    }

    public void setReassignToIT(RichInputText reassignToIT) {
        this.reassignToIT = reassignToIT;
    }

    public RichInputText getReassignToIT() {
        return reassignToIT;
    }

   /* public void cancelGLCodePopup(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start : cancelGLCodePopup");
        p3.hide();
    }*/

    public void clearGLCodePopUp(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start : clearGLCodePopUp");
        companyNameIt.setValue("");
        costCentreIT.setValue("");
        accountNameIt.setValue("");
        analysisCodeIt.setValue("");
        counterPartyIt.setValue("");

        companyNameOt.setValue(null);
        costCentreOt.setValue(null);
        accountNameOt.setValue(null);
        analysisCodeOt.setValue(null);
        counterPartyOt.setValue(null);

        AdfFacesContext.getCurrentInstance().addPartialTarget(companyNameOt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(costCentreOt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(accountNameOt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(analysisCodeOt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(counterPartyOt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);

        System.out.println("end: clearGLCodePopUp");

    }
    public void cancelGLCodePopup(ActionEvent actionEvent) {
    // Add event code here...
    System.out.println("Start: cancelGLCodePopup");
        companyNameIt.setValue("");
        costCentreIT.setValue("");
        accountNameIt.setValue("");
        analysisCodeIt.setValue("");
        counterPartyIt.setValue("");

        AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
         p6.hide();

    System.out.println("End: cancelGLCodePopup");
    }
    public void selectGLCodePopUP(ActionEvent actionEvent) {
        //TO KD
        System.out.println("Start: selectGLCodePopUP");
        String selectedGLCode=null;
        String companyName=null;
        String costCentre=null;
        String analysisCode=null;
        String accountName=null;
        String counterParty=null;
        String orgId=null;
        String glCodeError=null;
        //System.out.println("companyNameIt: "+companyNameIt.getValue()+".");
        if(companyNameIt.getValue()!=null)
        {
            companyName=companyNameIt.getValue().toString();
                //System.out.println("companyName: "+companyName);
            }
        //System.out.println("costCentreIT: "+costCentreIT.getValue()+".");
        if(costCentreIT.getValue()!=null)
        {
            costCentre=costCentreIT.getValue().toString();
                //System.out.println("costCentre: "+costCentre);
            }
        //System.out.println("analysisCodeIt: "+analysisCodeIt.getValue()+".");
        if(analysisCodeIt.getValue()!=null)
        {
            analysisCode=analysisCodeIt.getValue().toString();
                //System.out.println("analysisCode: "+analysisCode);
            }
        //System.out.println("accountNameIt: "+accountNameIt.getValue()+".");
        if(accountNameIt.getValue()!=null)
        {
            accountName=accountNameIt.getValue().toString();
                //System.out.println("accountName: "+accountName);
            }
        //System.out.println("counterPartyIt: "+counterPartyIt.getValue()+".");
        if(counterPartyIt.getValue()!=null)
        {
            counterParty=counterPartyIt.getValue().toString();
                //System.out.println("counterParty: "+counterParty);
            }

       //System.out.println("Org Id:"+orgIdIt.getValue()+".");
           if(orgIdIt.getValue()!=null)
           {
               orgId=orgIdIt.getValue().toString();
                   //System.out.println("orgIdIt: "+orgId);
               }
        if(companyName!=null && costCentre!=null && analysisCode!=null && accountName!=null && counterParty!=null
           && companyName!="" && costCentre!="" && analysisCode!="" && accountName!="" && counterParty!=""
           && companyName.trim()!=null && costCentre.trim()!=null && analysisCode.trim()!=null && accountName.trim()!=null && counterParty.trim()!=null
           && !companyName.trim().isEmpty() && !costCentre.trim().isEmpty() && !analysisCode.trim().isEmpty() && !accountName.trim().isEmpty() && !counterParty.trim().isEmpty())
        {
                //System.out.println("----------------If Not Empty--------------");
                //selectedGLCode=companyNameIt.getValue().toString()+"."+costCentreIT.getValue().toString()+"."+accountNameIt.getValue().toString()+"."+analysisCodeIt.getValue().toString()+"."+counterPartyIt.getValue().toString();

                //checking whether the data exixts or not
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CompanyCounterPartyVO1Iterator");
                ViewObjectImpl companySelectVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = companySelectVO.getViewCriteria("CompanyVOCriteria1");
                companySelectVO.applyViewCriteria(vc);
                companySelectVO.setNamedWhereClauseParam("bindCompanyName", companyName);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(companySelectVO.getQuery());
                companySelectVO.executeQuery();

                if(companySelectVO.getEstimatedRowCount()==0){

                    //System.out.println("Invalid Company name");
                    String vallMsg="Please Choose a valid Company Name";
                    this.validationErrorMessage.setValue(vallMsg);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    validationErrorPopup.show(hints);
                }
                else
                {
                        DCBindingContainer dcBindingContainer1 = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dcIteratorBinding1 = dcBindingContainer1.findIteratorBinding("CostCentreVO1Iterator");
                        ViewObjectImpl costCentreSelectVO = (ViewObjectImpl)dcIteratorBinding1.getViewObject();
                        ViewCriteria vc1 = costCentreSelectVO.getViewCriteria("CostCentreVOCriteria1");
                        costCentreSelectVO.applyViewCriteria(vc1);
                        costCentreSelectVO.setNamedWhereClauseParam("bindCostCentre", costCentre);
                        //System.out.println("-----------Dynamic Query-----------");
                        //System.out.println(costCentreSelectVO.getQuery());
                        costCentreSelectVO.executeQuery();
                        if(costCentreSelectVO.getEstimatedRowCount()==0){

                            //System.out.println("Invalid CostCentre name");
                            String vallMsg="Please Choose a valid Cost Centre Code";
                            this.validationErrorMessage.setValue(vallMsg);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                            RichPopup.PopupHints hints = new RichPopup.PopupHints();
                            validationErrorPopup.show(hints);
                        }
                    else
                        {
                                DCBindingContainer dcBindingContainer2 = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                                DCIteratorBinding dcIteratorBinding2 = dcBindingContainer2.findIteratorBinding("AccountVO1Iterator");
                                ViewObjectImpl accountCodeSelectVO = (ViewObjectImpl)dcIteratorBinding2.getViewObject();
                                ViewCriteria vc2 = accountCodeSelectVO.getViewCriteria("AccountVOCriteria1");
                                accountCodeSelectVO.applyViewCriteria(vc2);
                                accountCodeSelectVO.setNamedWhereClauseParam("bindAccountName", accountName);
                                //System.out.println("-----------Dynamic Query-----------");
                                //System.out.println(costCentreSelectVO.getQuery());
                                accountCodeSelectVO.executeQuery();
                                if(accountCodeSelectVO.getEstimatedRowCount()==0){

                                    //System.out.println("Invalid  Account name");
                                    String vallMsg="Please Choose a valid Account Code";
                                    this.validationErrorMessage.setValue(vallMsg);
                                    AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                                    validationErrorPopup.show(hints);
                                }
                            else
                                {
                                        DCBindingContainer dcBindingContainer3 = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                                        DCIteratorBinding dcIteratorBinding3 = dcBindingContainer3.findIteratorBinding("AnalysisCodeVO1Iterator");
                                        ViewObjectImpl analysisCodeSelectVO = (ViewObjectImpl)dcIteratorBinding3.getViewObject();
                                        ViewCriteria vc3 = analysisCodeSelectVO.getViewCriteria("AnalysisCodeVOCriteria1");
                                        analysisCodeSelectVO.applyViewCriteria(vc3);
                                        analysisCodeSelectVO.setNamedWhereClauseParam("bindAnalysisCode", analysisCode);
                                        //System.out.println("-----------Dynamic Query-----------");
                                        //System.out.println(costCentreSelectVO.getQuery());
                                        analysisCodeSelectVO.executeQuery();
                                        if(analysisCodeSelectVO.getEstimatedRowCount()==0){

                                            //System.out.println("Invalid Analysis code");
                                            String vallMsg="Please Choose a valid Analysis Code";
                                            this.validationErrorMessage.setValue(vallMsg);
                                            AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                                            RichPopup.PopupHints hints = new RichPopup.PopupHints();
                                            validationErrorPopup.show(hints);
                                        }
                                    else
                                        {
                                                DCBindingContainer dcBindingContainer4 = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                                                DCIteratorBinding dcIteratorBinding4 = dcBindingContainer4.findIteratorBinding("CompanyCounterPartyVO1Iterator");
                                                ViewObjectImpl counterPartySelectVO = (ViewObjectImpl)dcIteratorBinding4.getViewObject();
                                                ViewCriteria vc4 = counterPartySelectVO.getViewCriteria("CounterPartyVOCriteria1");
                                                counterPartySelectVO.applyViewCriteria(vc4);
                                                counterPartySelectVO.setNamedWhereClauseParam("bindCounterParty", companyName);
                                                //System.out.println("-----------Dynamic Query-----------");
                                                //System.out.println(companySelectVO.getQuery());
                                                counterPartySelectVO.executeQuery();

                                                if(counterPartySelectVO.getEstimatedRowCount()==0){

                                                    //System.out.println("Invalid Counter Party");
                                                    String vallMsg="Please Choose a valid Counter Party Code";
                                                    this.validationErrorMessage.setValue(vallMsg);
                                                    AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                                                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                                                    validationErrorPopup.show(hints);
                                                }
                                            else
                                                {
                                                        selectedGLCode=companyName+"."+costCentre+"."+accountName+"."+analysisCode+"."+counterParty;
                                                        System.out.println("selected gl code id"+selectedGLCode);

                                                        DCBindingContainer dcBindingContainer5 = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                                                        DCIteratorBinding dcIteratorBinding5 = dcBindingContainer5.findIteratorBinding("ValidateGLCodeVO1Iterator");
                                                        ViewObjectImpl validateGLCodeVO = (ViewObjectImpl)dcIteratorBinding5.getViewObject();
                                                     /*   ViewCriteria vc5 = validateGLCodeVO.getViewCriteria("CounterPartyVOCriteria1");
                                                        validateGLCodeVO.applyViewCriteria(vc5);*/
                                                        validateGLCodeVO.setNamedWhereClauseParam("bindGLCode",selectedGLCode);
                                                        validateGLCodeVO.setNamedWhereClauseParam("bindOrgID",orgId);
                                                        //System.out.println("-----------Dynamic Query-----------");
                                                        //System.out.println(validateGLCodeVO.getQuery());
                                                        validateGLCodeVO.executeQuery();
                                                        while (validateGLCodeVO.hasNext()) {
                                                          Row row = validateGLCodeVO.next(); // Get the next row in the result set.
                                                          //System.out.println("Validglcode ."+ row.getAttribute("Validglcode")+".");
                                                            if(null != row.getAttribute("Validglcode"))
                                                           glCodeError = row.getAttribute("Validglcode").toString();
                                                         else
                                                            glCodeError="N";
                                                          System.out.println("glCodeError"+glCodeError);
                                                        }

                                                       if( !glCodeError.equals("Y") && !glCodeError.equals("N"))
                                                       {
                                                       System.out.println("Inside if glcode error" +glCodeError);
                                                           glCodeErrorOt.setValue(glCodeError);
                                                               AdfFacesContext.getCurrentInstance().addPartialTarget(glCodeErrorOt);
                                                               //System.out.println("glCodeErrorOt.getvalue"+glCodeErrorOt.getValue());
                                                            AdfFacesContext.getCurrentInstance().addPartialTarget(pg148);
                                                           }
                                                       else{
                                                        int selectedRowNum = -1;

                                                        if(clientID.getValue()!=null) {
                                                            selectedRowNum = Integer.parseInt(clientID.getValue().toString().split(":")[2]);
                                                            //System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);
                                                        }


                                                         if(selectedRowNum!=-1) {

                                                             String componentIDRecCodeFlag = "pt1:t1:"+selectedRowNum+":it94::content";
                                                             System.out.println("----- componentIDRecCodeFlag ----- "+componentIDRecCodeFlag+", glCodeError : "+glCodeError);

                                                             String componentIDRecCode = "pt1:t1:"+selectedRowNum+":it93::content";
                                                             System.out.println("----- componentIDRecCode ----- "+componentIDRecCode);

                                                             FacesContext fctx = FacesContext.getCurrentInstance();
                                                             ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                                                             String myJavaScriptCode2 = "document.getElementById('pt1:hiddenButtonID').click()";

                                                             if(glCodeError.equals("Y")){
                                                             String myJavaScriptCode1 = "document.getElementById('"+componentIDRecCodeFlag+"').value = '"+glCodeError+"'";
                                                             erks.addScript(fctx, myJavaScriptCode1 );
                                                             System.out.println("Rec Code flag set from selectglcode ");
                                                                                                                         }
                                                             else{
                                                                 String temp="";
                                                                     String myJavaScriptCode1 = "document.getElementById('"+componentIDRecCodeFlag+"').value = '"+temp+"'";
                                                                     erks.addScript(fctx, myJavaScriptCode1 );
                                                                     String myJavaScriptCode3 = "document.getElementById('"+componentIDRecCode+"').value = '"+temp+"'";
                                                                     erks.addScript(fctx, myJavaScriptCode3 );
                                                                     System.out.println("Rec Code flag set from selectglcode as null");
                                                                 }
                                                             erks.addScript(fctx, myJavaScriptCode2 );
                                                             String componentIDPoNumber = "pt1:t1:"+selectedRowNum+":it17::content";
                                                             System.out.println("----- componentIDPoNumber ----- "+componentIDPoNumber+", selectedPONumber : "+selectedGLCode);


                                                             String myJavaScriptCode = "document.getElementById('"+componentIDPoNumber+"').value = '"+selectedGLCode+"'";
                                                             erks.addScript(fctx, myJavaScriptCode );
                                                             erks.addScript(fctx, myJavaScriptCode2 );
                                                         }

                                                        //AdfFacesContext.getCurrentInstance().addPartialTarget(headerOuterPgl);
                                                        companyNameIt.setValue("");
                                                        costCentreIT.setValue("");
                                                        accountNameIt.setValue("");
                                                        analysisCodeIt.setValue("");
                                                        counterPartyIt.setValue("");
                                                           glCodeErrorOt.setValue("");
                                                        AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
                                                        p6.hide();
                                                        System.out.println("End selectGLCodePopUP");
                                                       }

                                                    }
                                            }
                                    }
                            }
                    }

            }
        //if(companyName==null || costCentre==null || analysisCode==null || accountName==null || counterParty==null || companyName=="" || costCentre=="" || analysisCode=="" || accountName=="" || counterParty=="")
      else  {
               System.out.println("Invalid Case Gl code");
               String vallMsg="All Fields are Mandatory.  Please enter a valid Code in each Accounting Segment";
               this.validationErrorMessage.setValue(vallMsg);
               AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
               RichPopup.PopupHints hints = new RichPopup.PopupHints();
               validationErrorPopup.show(hints);

        }

            //poNumPopupIt.setValue(selectedPONumber);

    }


    public void setGlCodePgl(RichPanelFormLayout glCodePgl) {
        this.glCodePgl = glCodePgl;
    }

    public RichPanelFormLayout getGlCodePgl() {
        return glCodePgl;
    }



    public void setReassingToIDPopupIT(RichInputText reassingToIDPopupIT) {
        this.reassingToIDPopupIT = reassingToIDPopupIT;
    }

    public RichInputText getReassingToIDPopupIT() {
        return reassingToIDPopupIT;
    }


    public void setExpenditurePopupIT(RichInputText expenditurePopupIT) {
        this.expenditurePopupIT = expenditurePopupIT;
    }

    public RichInputText getExpenditurePopupIT() {
        return expenditurePopupIT;
    }

    public void setExpDateIT(RichInputDate expDateIT) {
        this.expDateIT = expDateIT;
    }

    public RichInputDate getExpDateIT() {
        return expDateIT;
    }
    public void setCommentPopup(RichPopup commentPopup) {
        this.commentPopup = commentPopup;
    }

    public RichPopup getCommentPopup() {
        return commentPopup;
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
            if(commentsPopupIt.getValue() != null)
                commentsVal = commentsPopupIt.getValue().toString();
            //System.out.println("commentsPopupIt: "+commentsPopupIt);
            commentsIt.setValue(commentsVal);

            AdfFacesContext.getCurrentInstance().addPartialTarget(commentsIt);
            commentsPopupIt.setValue("");
            AdfFacesContext.getCurrentInstance().addPartialTarget(commentsPopupIt);
            commentPopup.hide();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onCommentsPopupOKClick");
    }

    public void setCommentsIt(RichInputText commentsIt) {
        this.commentsIt = commentsIt;
    }

    public RichInputText getCommentsIt() {
        return commentsIt;
    }



    public void onCommentsClick(ActionEvent actionEvent) {
        System.out.println("Start onCommentsClick");
        String commentsVal = null;
        try {
            if(commentsIt.getValue() != null)
                commentsVal = commentsIt.getValue().toString();
            //System.out.println("commentsIt: "+commentsIt);
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            commentsPopupIt.setValue(commentsVal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(commentsPopupIt);
            commentPopup.show(hints);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onCommentsClick");
    }

    public void setShowPONumberPopup(RichCommandImageLink showPONumberPopup) {
        this.showPONumberPopup = showPONumberPopup;
    }

    public RichCommandImageLink getShowPONumberPopup() {
        return showPONumberPopup;
    }

    public void setPoNumIt(RichInputText poNumIt) {
        this.poNumIt = poNumIt;
    }

    public RichInputText getPoNumIt() {
        return poNumIt;
    }

    public void cancelPONumber(ActionEvent actionEvent) {
        // Add event code here...
        //System.out.println("Start: cancelPONumber");
        poNumPopupIt.setValue("");
        p17.hide();

        //System.out.println("End: cancelPONumber");

    }

    public void selectPONumber(ActionEvent actionEvent) {

        try {

            System.out.println("Start: selectPONumber");
            boolean isPOLineItemPopup = (this.isPOLineItemPopup.getValue()!=null && this.isPOLineItemPopup.getValue().toString().equalsIgnoreCase("yes")) ? true : false;
            System.out.println("-----isLineItemPopup-----"+isPOLineItemPopup);


            String selectedPONumber = null;
            String selectedOperatingUnit = null;
            BigDecimal selectedSiteId =null;
            String selectedSiteName = null;
            oracle.jbo.domain.Number selectedSiteIDNumber=null;
            RowKeySet selectedPONum = poNoCertifierTable.getSelectedRowKeys();
            Iterator selectedSiteIter = selectedPONum.iterator();
            DCBindingContainer bindings =
                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding empIter =
                bindings.findIteratorBinding("PoNoCertifierVO1Iterator");
            RowSetIterator empRSIter = null;
            try {
                empRSIter = empIter.getRowSetIterator();
                while (selectedSiteIter.hasNext()) {
                    Key key = (Key)((List)selectedSiteIter.next()).get(0);
                    Row currentRow = empRSIter.getRow(key);
                    System.out.println(currentRow.getAttribute("PoNum"));
                    selectedPONumber =
                            currentRow.getAttribute("PoNum") == null ? null :
                            currentRow.getAttribute("PoNum").toString();
                    if(currentRow.getAttribute("VendorSiteId")!=null){
                    selectedSiteId =(java.math.BigDecimal)currentRow.getAttribute("VendorSiteId");
                    selectedSiteIDNumber = new oracle.jbo.domain.Number(selectedSiteId);
                    }
                    selectedSiteName =
                            currentRow.getAttribute("VendorSiteCode") == null ?
                            null :
                            currentRow.getAttribute("VendorSiteCode").toString();
                    selectedOperatingUnit =
                            currentRow.getAttribute("OperatingUnit") == null ?
                            null :
                            currentRow.getAttribute("OperatingUnit").toString();
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
            /*System.out.println("selectedPONumber"+selectedPONumber);
            System.out.println("selectedSiteId"+selectedSiteIDNumber);
            System.out.println("selectedSiteName"+selectedSiteName);
            System.out.println("selectedOperating Unit"+selectedOperatingUnit);*/
            if(selectedPONumber!=null && selectedSiteIDNumber!=null && selectedSiteName!=null && selectedOperatingUnit!=null && !selectedPONumber.trim().equals("")  && !selectedSiteIDNumber.equals("")
                 && !selectedSiteName.trim().equals("")  && !selectedOperatingUnit.trim().equals("")  && !isPOLineItemPopup)
            {
                System.out.println("Passed Null check condition");
                poNumIt.setValue(selectedPONumber);
                siteIdIt.setValue(selectedSiteIDNumber);
                siteName.setValue(selectedSiteName);
                operatingUnitIt.setValue(selectedOperatingUnit);


            /** Added for PO line NO change : 18th Aug : Sourav **/




                System.out.println("Value change fired manually from selectPONumber from header");
                System.out.println("new value of PO selected in select PO NUmber : " + selectedPONumber);

                 ADFContext.getCurrent().getPageFlowScope().put("header_selectedPONumber", selectedPONumber);

                RowSetIterator lineItemItr = null;
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
                ViewObjectImpl lineVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                System.out.println("------------lineVO Count validatelineDescription(): "+lineVO.getEstimatedRowCount());
                lineItemItr = lineVO.createRowSetIterator(null);

                while(lineItemItr.hasNext()) {
                            Row lineRow = lineItemItr.next();
                            lineRow.setAttribute("GlNo",null);
                            lineRow.setAttribute("Attr5",null); //make rec code empty
                            lineRow.setAttribute("Attr4",null); //make projectID empty
                            lineRow.setAttribute("ProjectNo",null);
                            lineRow.setAttribute("Attr3",null); //make taskid empty
                            lineRow.setAttribute("TaskNo",null);
                            lineRow.setAttribute("ExpinditureOrg",null);
                            lineRow.setAttribute("ExpenditureDate",null);
                            lineRow.setAttribute("Attr10",null); //make expenditure type empty
                            /*default line level po column values with  header PO number value*/
                            lineRow.setAttribute("LinePoNum",selectedPONumber!=null ? selectedPONumber : null);


                }

                if(lineItemItr != null){
                    lineItemItr.closeRowSetIterator();
                }

                /*** Disable all above fields and corresponding search icons ***/

                        //GL
                        glCodeSearchIcon.setDisabled(true);
                        glCode.setDisabled(true);

                        //Project No
                        projectNoSearchIcon.setDisabled(true);
                        projectNoIT.setDisabled(true);

                        /** Enable line PO and PO line no columns **/

                        linePONumberSearchIcon.setDisabled(false);
                        linePONumIT.setDisabled(false);

                        poLineNumberSearchIcon.setDisabled(false);
                        poLineNumIT.setDisabled(false);


                /** 18th Aug Change ends **/
            }
            else{

                    System.out.println("Entered else");
                    poNumIt.setValue("");
                }

                if(isPOLineItemPopup) {

                    System.out.println("Setting line level PO Number from select PONumber method");

                    int selectedRowNum = -1;
                    if(poNumClientID.getValue()!=null) {
                        selectedRowNum = Integer.parseInt(poNumClientID.getValue().toString().split(":")[2]);
                        System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);
                    }

                    if(selectedRowNum!=-1) {
                        String componentIDPoNumber = "pt1:t1:"+selectedRowNum+":it351::content";
                        System.out.println("----- componentIDPoNumber ----- "+componentIDPoNumber+", selectedPONumber : "+selectedPONumber);

                        FacesContext fctx = FacesContext.getCurrentInstance();
                        ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);

                        String myJavaScriptCode = "document.getElementById('"+componentIDPoNumber+"').value = '"+selectedPONumber+"';";


                        erks.addScript(fctx, myJavaScriptCode );

                        erks.addScript(fctx, "document.getElementById('"+componentIDPoNumber+"').focus();");
                        erks.addScript(fctx, "AdfActionEvent.queue(AdfPage.PAGE.findComponentByAbsoluteId('" + "pt1:t1:"+selectedRowNum+":it351" + "'), true);");

                    }


                }

            AdfFacesContext.getCurrentInstance().addPartialTarget(poNumIt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(siteIdIt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(siteName);
            AdfFacesContext.getCurrentInstance().addPartialTarget(operatingUnitIt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(outerPgl);
            AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);

            p17.hide();
            poNumPopupIt.setValue("");

            System.out.println("End selectPONumber");
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }


    }

    public void setPoNumPopupIt(RichInputText poNumPopupIt) {
        this.poNumPopupIt = poNumPopupIt;
    }

    public RichInputText getPoNumPopupIt() {
        return poNumPopupIt;
    }

    public void onPONumPopupGoClick(ActionEvent actionEvent) {

        System.out.println("Start onPONumPopupGoClick");

        try {

                System.out.println("Inside try ");
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("PoNoCertifierVO1Iterator");
                ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = poNOVO.getViewCriteria("PoNoCertifierVOCriteria");
                poNOVO.applyViewCriteria(vc);
                if(poNumPopupIt.getValue() != null){
                    poNOVO.setNamedWhereClauseParam("bindPONum", poNumPopupIt.getValue()==null?"":poNumPopupIt.getValue().toString().trim());
                    poNOVO.setNamedWhereClauseParam("bindOperatingUnit", operatingUnitIt.getValue()==null?"":operatingUnitIt.getValue().toString().trim());
                    poNOVO.setNamedWhereClauseParam("bindSupplierName", supplierName.getValue()==null?"":supplierName.getValue().toString().trim());
                    poNOVO.setNamedWhereClauseParam("bindSiteID", null);
                    poNOVO.executeQuery();
                //poNOVO.setNamedWhereClauseParam("bindSiteID", siteIdIt.getValue()==null?"":siteIdIt.getValue().toString().trim());
                }
                else{
                    poNOVO.setNamedWhereClauseParam("bindPONum", poNumPopupIt.getValue()==null?"":poNumPopupIt.getValue().toString().trim());
                    poNOVO.setNamedWhereClauseParam("bindOperatingUnit", operatingUnitIt.getValue()==null?"":operatingUnitIt.getValue().toString().trim());
                    poNOVO.setNamedWhereClauseParam("bindSupplierName", supplierName.getValue()==null?"":supplierName.getValue().toString().trim());
                    poNOVO.setNamedWhereClauseParam("bindSiteID", siteIdIt.getValue()==null?"":siteIdIt.getValue().toString().trim());
                    poNOVO.executeQuery();
                }

                //System.out.println("No of rows fetched****"+poNOVO.getEstimatedRowCount());
                //System.out.println("***After Execution****");
                AdfFacesContext.getCurrentInstance().addPartialTarget(poNoCertifierTable);
        }
        catch(Exception e) {
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

    public void showPONumberPopup(ActionEvent actionEvent) {
            poNumPopupIt.setValue(poNumIt.getValue());
            System.out.println("Start showPONumberPopup");
            try {

                        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("PoNoCertifierVO1Iterator");
                        ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                        ViewCriteria vc = poNOVO.getViewCriteria("PoNoCertifierVOCriteria");
                        poNOVO.applyViewCriteria(vc);
                        poNOVO.setNamedWhereClauseParam("bindPONum", poNumIt.getValue()==null?"":poNumIt.getValue().toString().trim());
                        poNOVO.setNamedWhereClauseParam("bindOperatingUnit", operatingUnitIt.getValue() == null?"" : operatingUnitIt.getValue().toString().trim());
                        poNOVO.setNamedWhereClauseParam("bindSupplierName", supplierName.getValue()==null?"":supplierName.getValue().toString().trim());
                        poNOVO.setNamedWhereClauseParam("bindSiteID", null);
//                        System.out.println("***After Execution poNOVO****"+poNOVO.getQuery());
//                      System.out.println("Dynamic query :: "+poNOVO.getQuery());
                        poNOVO.executeQuery();
                        //System.out.println("No of rows fetched****"+poNOVO.getEstimatedRowCount());
                        //System.out.println("***After Execution****");
                        AdfFacesContext.getCurrentInstance().addPartialTarget(poNoCertifierTable);

                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                p17.show(hints);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            System.out.println("End showPONumberPopup");
        }
    public void setP17(RichPopup p17) {
        this.p17 = p17;
    }

    public RichPopup getP17() {
        return p17;
    }
    public void changeOnLineType(ValueChangeEvent valueChangeEvent) {
            System.out.println("Start :::: changeOnLineType");
            DecimalFormat df = new DecimalFormat("#0.00");

            RowKeySet selectedRow = lineItemsTable.getSelectedRowKeys();
            Iterator selectedRowIter = selectedRow.iterator();
            DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding analysiscodeIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");

            try{
               RowSetIterator analysiscodeRSIter = analysiscodeIter.getRowSetIterator();


            if(valueChangeEvent.getNewValue().toString().equalsIgnoreCase("NON TAXABLE LINE")) {
                while(selectedRowIter.hasNext()){
                   Key key = (Key)((List)selectedRowIter.next()).get(0);
                   Row currentRow = analysiscodeRSIter.getRow(key);
                     if(currentRow.getAttribute("TaxAmountLineitem")!=null && !currentRow.getAttribute("TaxAmountLineitem").equals(""))
                     {
                            //taxSum -= Double.parseDouble(currentRow.getAttribute("TaxAmountLineitem").toString());
                            currentRow.setAttribute("TaxAmountLineitem", "0");
                            //taxAmountSum.setValue(df.format(taxSum));

                     }

                }

            }
            else if((valueChangeEvent.getOldValue()!=null && valueChangeEvent.getOldValue().toString().equalsIgnoreCase("NON TAXABLE LINE")) && (valueChangeEvent.getNewValue().toString().equalsIgnoreCase("TAXABLE LINE") || valueChangeEvent.getNewValue().toString().equalsIgnoreCase("ADJUSTMENT LINE"))){

                while(selectedRowIter.hasNext()){
                   Key key = (Key)((List)selectedRowIter.next()).get(0);
                   Row currentRow = analysiscodeRSIter.getRow(key);
                     if(currentRow.getAttribute("TaxAmountLineitem")!=null && !currentRow.getAttribute("TaxAmountLineitem").equals(""))
                     {

                         String taxRateCode = currentRow.getAttribute("TaxRateCode")==null?"":(String)currentRow.getAttribute("TaxRateCode");

                         BigDecimal taxRate = PropertyLoader.getInstance().getTaxRatesMasterList().get(taxRateCode);

                         oracle.jbo.domain.Number lineTotalAmount = (oracle.jbo.domain.Number)currentRow.getAttribute("LineTotalAmount");


                         double calculatedTax = (lineTotalAmount==null?0.0:lineTotalAmount.doubleValue()) * (taxRate==null?0.0:taxRate.doubleValue()) / 100.0;



                         currentRow.setAttribute("TaxAmountLineitem", df.format(calculatedTax));


                            //taxSum += Double.parseDouble(currentRow.getAttribute("TaxAmountLineitem").toString());
                            //taxAmountSum.setValue(df.format(taxSum));

                     }

                }

            }
            }catch(Exception e)
            {
                e.printStackTrace();
                }
        /*finally{
                    if(analysiscodeRSIter!=null) {
                        try {
                            analysiscodeRSIter.closeRowSetIterator();
                        } catch(Exception ex) {
                            ex.printStackTrace();

                    }
                    }
                }*/
            AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
    }
    public void openTaxRateCodePopup(ActionEvent actionEvent) {

        System.out.println("Start : openTaxRateCodePopup");

        //System.out.println("Start openTaxRateCodePopup");
        String clientId = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
        //System.out.println(" ----- clientID : "+clientId);
        this.clientID.setValue(clientId);

        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("TaxRateCodeLookupVO1Iterator");
        ViewObjectImpl taxRateCodeLookupVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
        ViewCriteria vc = null;
        String taxRateCode = null;
        String siteId = null;
        try{
            RowKeySet rowKeySet = lineItemsTable.getSelectedRowKeys();
            Iterator rowKeySetIt = rowKeySet.iterator();
            DCIteratorBinding lineItemIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");
            RowSetIterator lineItemRSIter=null;
            try{
                lineItemRSIter = lineItemIter.getRowSetIterator();
             while(rowKeySetIt.hasNext()){
               Key key = (Key)((List)rowKeySetIt.next()).get(0);
               Row currentRow = lineItemRSIter.getRow(key);
                 if(currentRow!=null) {
                    //System.out.println("----- TaxRateCode ----- "+currentRow.getAttribute("TaxRateCode"));
                    taxRateCode = currentRow.getAttribute("TaxRateCode")==null?"":currentRow.getAttribute("TaxRateCode").toString().trim();
                 }
             }
            }catch(Exception e)
            {e.printStackTrace();
             }
            /*finally{
                        if(lineItemRSIter!=null) {
                            try {
                                lineItemRSIter.closeRowSetIterator();
                            } catch(Exception ex) {
                                ex.printStackTrace();

                        }
                        }
                    }*/
            if(siteIdIt.getValue()!=null) {
               siteId = ""+((oracle.jbo.domain.Number)siteIdIt.getValue()).getValue();
            }
            taxRateCode = taxRateCode==null ? "" : taxRateCode.trim();
            siteId = siteId==null ? "" : siteId.trim();

            //System.out.println("siteIdIt.getValue(): "+siteId);
            //System.out.println("TaxRateCode ="+ taxRateCode);

            //If Site id is present

            if(siteId!=null && !siteId.trim().equals("")) {
                            vc = taxRateCodeLookupVO.getViewCriteria("TaxRateCodeLookupVOCriteria_lookupBySiteId");
                            taxRateCodeLookupVO.applyViewCriteria(vc);
                            taxRateCodeLookupVO.setNamedWhereClauseParam("bind_siteId",siteId);
                            taxRateCodeLookupVO.setNamedWhereClauseParam("bind_taxRateCode",taxRateCode);
                            taxRateCodeLookupVO.executeQuery();
                            System.out.println("taxRateCodeLookupVO.getEstimatedRowCount()******************"+taxRateCodeLookupVO.getEstimatedRowCount());
                            AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateCodeDetailsTable);
                            RichPopup.PopupHints hints = new RichPopup.PopupHints();
                            taxRateCodePopupIt.setValue(taxRateCode);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateCodePopupIt);
                            p7.show(hints);
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setOrgIdIt(RichInputText orgIdIt) {
        this.orgIdIt = orgIdIt;
    }

    public RichInputText getOrgIdIt() {
        return orgIdIt;
    }

    public void setProjectIdIt(RichInputText projectIdIt) {
        this.projectIdIt = projectIdIt;
    }

    public RichInputText getProjectIdIt() {
        return projectIdIt;
    }

    public void setP18(RichPopup p18) {
        this.p18 = p18;
    }

    public RichPopup getP18() {
        return p18;
    }
    public void setExpTypePopUpIt(RichInputText expTypePopUpIt) {
        this.expTypePopUpIt = expTypePopUpIt;
    }

    public RichInputText getExpTypePopUpIt() {
        return expTypePopUpIt;
    }



    public void setExpTypeDetailsTable(RichTable expTypeDetailsTable) {
        this.expTypeDetailsTable = expTypeDetailsTable;
    }

    public RichTable getExpTypeDetailsTable() {
        return expTypeDetailsTable;
    }

    public void setExpTypeIt(RichInputText expTypeIt) {
        this.expTypeIt = expTypeIt;
    }

    public RichInputText getExpTypeIt() {
        return expTypeIt;
    }
    public void setCompanyNameOt(RichOutputText companyNameOt) {
        this.companyNameOt = companyNameOt;
    }

    public RichOutputText getCompanyNameOt() {
        return companyNameOt;
    }

    public void setCostCentreOt(RichOutputText costCentreOt) {
        this.costCentreOt = costCentreOt;
    }

    public RichOutputText getCostCentreOt() {
        return costCentreOt;
    }

    public void setAccountNameOt(RichOutputText accountNameOt) {
        this.accountNameOt = accountNameOt;
    }

    public RichOutputText getAccountNameOt() {
        return accountNameOt;
    }

    public void setAnalysisCodeOt(RichOutputText analysisCodeOt) {
        this.analysisCodeOt = analysisCodeOt;
    }

    public RichOutputText getAnalysisCodeOt() {
        return analysisCodeOt;
    }

    public void setCounterPartyOt(RichOutputText counterPartyOt) {
        this.counterPartyOt = counterPartyOt;
    }

    public RichOutputText getCounterPartyOt() {
        return counterPartyOt;
    }

    public void onKeyPressNotify(ClientEvent clientEvent) {
        // get a hold of the input text component
        System.out.println("onKeyPressNotify");
        RichInputText inputTxt =  (RichInputText) clientEvent.getComponent();
        //do some work on it here (e.g. manipulating its readOnly state)
        //�
        //Get access to the payload
       Map  parameters = clientEvent.getParameters();
       //System.out.println("SubmittedValue = "+parameters.get("submittedValue"));
       //System.out.println("LocalValue = " +parameters.get("localValue"));
    }

    public void validateGLCode(ClientEvent clientEvent) {
        // Add event code here...
        System.out.println("Start validateGLCode");
        RichInputText inputTxt =  (RichInputText) clientEvent.getComponent();
        //do some work on it here (e.g. manipulating its readOnly state)
        //�
        //Get access to the payloadclient
        Map  parameters = clientEvent.getParameters();
        //System.out.println("SubmittedValue = "+parameters.get("submittedValue"));
        //System.out.println("LocalValue = " +parameters.get("localValue"));

        String glCodeError=null;

        try {
                String orgId=null;

                //System.out.println("Org Id:"+orgIdIt.getValue()+".");
                    if(orgIdIt.getValue()!=null)
                    {
                        orgId=orgIdIt.getValue().toString();
                            //System.out.println("orgIdIt: "+orgId);
                        }
            String enteredGLCode = null;

            enteredGLCode=(String)parameters.get("submittedValue");

            if(enteredGLCode!=null && !enteredGLCode.equals("") && enteredGLCode!="" && enteredGLCode.trim()!=null && !enteredGLCode.trim().isEmpty()){

                    //System.out.println("GLCode.getValue(): "+enteredGLCode);
                  //System.out.println("NOt null");
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ValidateGLCodeVO1Iterator");
                ViewObjectImpl validateGLCodeVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();

                validateGLCodeVO.setNamedWhereClauseParam("bindGLCode",enteredGLCode);
                validateGLCodeVO.setNamedWhereClauseParam("bindOrgID",orgId);
                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(validateGLCodeVO.getQuery());
                validateGLCodeVO.executeQuery();
                while (validateGLCodeVO.hasNext()) {
                  Row row = validateGLCodeVO.next(); // Get the next row in the result set.
                  //System.out.println("Validglcode ."+ row.getAttribute("Validglcode")+".");
                    if(row.getAttribute("Validglcode") != null)

                    glCodeError = row.getAttribute("Validglcode").toString();

                    else

                    glCodeError ="N";

                    System.out.println("glCodeError"+glCodeError);
                }

                DCBindingContainer bindings = getBinding();
                DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
                ViewObject empVO = lineItemIter.getViewObject();
                Row selectedRow=empVO.getCurrentRow();

                if(!glCodeError.equals("Y") && !glCodeError.equals("N"))
                {

                       this.validationErrorMessage.setValue(glCodeError);
                       AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                       RichPopup.PopupHints hints = new RichPopup.PopupHints();
                       validationErrorPopup.show(hints);
                       selectedRow.setAttribute("RecCodeFlag", null);
                       selectedRow.setAttribute("Attr5", null);
                       System.out.println("rec Code value set as "+ selectedRow.getAttribute("RecCodeFlag"));
                   }
                else {

                    if(glCodeError.equals("Y"))
                        selectedRow.setAttribute("RecCodeFlag", glCodeError);
                    else{
                            selectedRow.setAttribute("RecCodeFlag", null);
                        selectedRow.setAttribute("Attr5", null);
                    }
                       System.out.println("rec Code value set as "+glCodeError);

                   }
                ADFContext.getCurrent().getPageFlowScope().put("tabPressRECCode", "tabpressed");
                System.out.println("Tab Presssed "+ ADFContext.getCurrent().getPageFlowScope().get("tabPressRECCode"));
              AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);

            }
            }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End validateGLCode");
        AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
    }


     public void validateGLCodeCompany(ClientEvent clientEvent) {
         // Add event code here...
         System.out.println("Start validateGLCodeCompany");
         RichInputText inputTxt =  (RichInputText) clientEvent.getComponent();
         //do some work on it here (e.g. manipulating its readOnly state)
         //�
         //Get access to the payload
         Map  parameters = clientEvent.getParameters();
         System.out.println("SubmittedValue = "+parameters.get("submittedValue"));
         System.out.println("LocalValue = " +parameters.get("localValue"));

         String selectedCompany=null;
         String selectedCompanyDesc=null;
         try {

             String enteredCompany = null;
                      // enteredCompany = companyNameIt.getValue().toString();
             enteredCompany=(String)parameters.get("submittedValue");
            //     if(companyNameIt.getValue() != null && companyNameIt.getValue().equals("")) {
             if(enteredCompany!=null && !enteredCompany.equals("") && enteredCompany!="" && enteredCompany.trim()!=null && !enteredCompany.trim().isEmpty()){
                    // enteredCompany = companyNameIt.getValue().toString();
                     //System.out.println("companyNameIt.getValue(): "+enteredCompany);
                   //System.out.println("NOt null");
                     DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                     DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CompanyCounterPartyVO1Iterator");
                     ViewObjectImpl companyValidateVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                     ViewCriteria vc = companyValidateVO.getViewCriteria("CompanyVOCriteria2");
                     companyValidateVO.applyViewCriteria(vc);
                     companyValidateVO.setNamedWhereClauseParam("bindCompanyName", enteredCompany);
                     //System.out.println("-----------Dynamic Query-----------");
                     //System.out.println(companyValidateVO.getQuery());
                     companyValidateVO.executeQuery();
                     boolean invalidQuery=true;
                     System.out.println("invalid query"+invalidQuery);
                   while(companyValidateVO.hasNext()){
                     Row row = companyValidateVO.next(); // Get the next row in the result set.
                     if(row.getAttribute("Company") != null){
                     //System.out.println("1."+row.getAttribute("Company"));
                      selectedCompany=row.getAttribute("Company").toString();
                     // companyNameIt.setValue(selectedCompany);
                        // inputTxt.setValue(selectedCompany);
                        String componentIDGlCode = "it58::content";
                        System.out.println("----- componentIDGlCode ----- "+componentIDGlCode+", selectedGLCode : "+selectedCompany);

                        FacesContext fctx = FacesContext.getCurrentInstance();
                        ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                        String myJavaScriptCode = "document.getElementById('"+componentIDGlCode+"').value = '"+selectedCompany+"'";
                        erks.addScript(fctx, myJavaScriptCode);

                      //System.out.println("selectedCompany"+selectedCompany);
                     }
                     else{
                            /* FacesMessage Message =
                                 new FacesMessage("Please Enter a valid Company Name");
                             Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                             FacesContext fc = FacesContext.getCurrentInstance();
                             fc.addMessage(null, Message);*/
                            //System.out.println("2.Invalid Company name");
                            String vallMsg="Please Enter a valid Company Name";
                            this.validationErrorMessage.setValue(vallMsg);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                            RichPopup.PopupHints hints = new RichPopup.PopupHints();
                            validationErrorPopup.show(hints);
                             companyNameIt.setValue("");
                         }
                      if(row.getAttribute("CompanyDescription") != null){
                          selectedCompanyDesc=row.getAttribute("CompanyDescription").toString();
                          //System.out.println("3.company desc in inner popup ::: "+ selectedCompanyDesc);
                          companyNameOt.setValue(selectedCompanyDesc);
                      }else{
                          companyNameOt.setValue("");
                      }

                      invalidQuery=false;
                 }
                   if(invalidQuery)
                   {
                       //System.out.println("Executing"+invalidQuery);

                           //System.out.println("4.Invalid Company name");
                           String vallMsg="Please Enter a valid Company Name";
                           this.validationErrorMessage.setValue(vallMsg);
                           AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                           RichPopup.PopupHints hints = new RichPopup.PopupHints();
                           validationErrorPopup.show(hints);
                           companyNameOt.setValue("");
                           String componentIDGlCode = "it58::content";
                           //System.out.println("----- componentIDGlCode ----- "+componentIDGlCode+", selectedGLCode : "+selectedCompany);

                           FacesContext fctx = FacesContext.getCurrentInstance();
                           ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                           String myJavaScriptCode = "document.getElementById('"+componentIDGlCode+"').value = '"+""+"'";
                           erks.addScript(fctx, myJavaScriptCode);

                         //  companyNameIt.setValue("");
                       }
                  AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);   // AdfFacesContext.getCurrentInstance().addPartialTarget(companyDetailsTable);
                 }
             else{
                 //System.out.println("l 5");
                     companyNameIt.setValue("");
                     companyNameOt.setValue("");
                     AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
                 }
                   }
         catch(Exception e) {
             e.printStackTrace();
         }
         System.out.println("End validateGLCodeCompany");
     }

             public void validateGLCodeCostCenter(ClientEvent clientEvent) {
         // Add event code here...

         RichInputText inputTxt =  (RichInputText) clientEvent.getComponent();
         //do some work on it here (e.g. manipulating its readOnly state)
         //�
         //Get access to the payload
         Map  parameters = clientEvent.getParameters();
         System.out.println("SubmittedValue = "+parameters.get("submittedValue"));
         System.out.println("LocalValue = " +parameters.get("localValue"));

         System.out.println("Start validateGLCodeCostCenter");
         try {

             String enteredCostCentre = null;
             String selectedCostCentreDesc=null;
             String selectedCostCentre=null;
                // if(costCentreIT.getValue() != null) {
                   //  enteredCostCentre = costCentreIT.getValue().toString();
             enteredCostCentre=(String)parameters.get("submittedValue");
                     //System.out.println("costCentreIT.getValue(): "+enteredCostCentre);
              //   }
              if(enteredCostCentre!=null && !enteredCostCentre.equals("") && enteredCostCentre!="" && enteredCostCentre.trim()!=null && !enteredCostCentre.trim().isEmpty()){
         //     }
                       //System.out.println("costCentre Entered: "+enteredCostCentre);
                      //System.out.println("NOt null");
                     DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                     DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CostCentreVO1Iterator");
                     ViewObjectImpl costCentreValidateVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                     ViewCriteria vc = costCentreValidateVO.getViewCriteria("CostCentreVOCriteria2");
                     costCentreValidateVO.applyViewCriteria(vc);
                     costCentreValidateVO.setNamedWhereClauseParam("bindCostCentre", enteredCostCentre);
                     //System.out.println("-----------Dynamic Query-----------");
                     //System.out.println(costCentreValidateVO.getQuery());
                     costCentreValidateVO.executeQuery();
                 boolean invalidQuery=true;
                 System.out.println("invalid query"+invalidQuery);
             while(costCentreValidateVO.hasNext()){
                     Row row = costCentreValidateVO.next(); // Get the next row in the result set.
                     if(row.getAttribute("Costcentre") != null)
                                    {
                                  //System.out.println(row.getAttribute("Costcentre"));
                                    selectedCostCentre=row.getAttribute("Costcentre").toString();
                                        costCentreIT.setValue(selectedCostCentre);
                                    }
                     else{
                            /* FacesMessage Message =
                                 new FacesMessage("Please Enter a valid CostCentre Code");
                             Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                             FacesContext fc = FacesContext.getCurrentInstance();
                             fc.addMessage(null, Message);*/
                            System.out.println("Invalid Cost Centre Code");
                            String vallMsg="Please Enter a valid Cost Centre Code";
                            this.validationErrorMessage.setValue(vallMsg);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                            RichPopup.PopupHints hints = new RichPopup.PopupHints();
                            validationErrorPopup.show(hints);
                             costCentreIT.setValue("");
                         }
                     if(row.getAttribute("Description") != null){
                                                       selectedCostCentreDesc=row.getAttribute("Description").toString();
                                                       //System.out.println("company desc in inner popup ::: "+ selectedCostCentreDesc);
                                                       costCentreOt.setValue(selectedCostCentreDesc);
                                                   }else{
                                                       costCentreOt.setValue("");
                                                   }
                        invalidQuery=false;

                 }
                    // AdfFacesContext.getCurrentInstance().addPartialTarget(costCentreDetailsTable);
                    if(invalidQuery)
                    {
                        System.out.println("Executing"+invalidQuery);
                          /*  FacesMessage Message =
                                new FacesMessage("Please Enter a valid CostCentre Code");
                            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                            FacesContext fc = FacesContext.getCurrentInstance();
                            fc.addMessage(null, Message);*/
                          //System.out.println("Invalid Cost centre Code");
                          String vallMsg="Please Enter a valid CostCentre Code";
                          this.validationErrorMessage.setValue(vallMsg);
                          AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                          RichPopup.PopupHints hints = new RichPopup.PopupHints();
                          validationErrorPopup.show(hints);
                            costCentreOt.setValue("");
                            String componentIDGlCode = "it39::content";
                            //System.out.println("----- componentIDGlCode ----- "+componentIDGlCode+", selectedGLCode : ");

                            FacesContext fctx = FacesContext.getCurrentInstance();
                            ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                            String myJavaScriptCode = "document.getElementById('"+componentIDGlCode+"').value = '"+""+"'";
                            erks.addScript(fctx, myJavaScriptCode);

                        }
                    AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
             }
             else{
                 costCentreIT.setValue("");
                 costCentreOt.setValue("");
                 AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
             }

         }
         catch(Exception e) {
             e.printStackTrace();
         }
         System.out.println("End validateGLCodeCostCenter");

     }


    public void validateGLCodeAccount(ClientEvent clientEvent) {
       // Add event code here...

       RichInputText inputTxt =  (RichInputText) clientEvent.getComponent();
       //do some work on it here (e.g. manipulating its readOnly state)
       //�
       //Get access to the payload
       Map  parameters = clientEvent.getParameters();
       System.out.println("SubmittedValue = "+parameters.get("submittedValue"));
       System.out.println("LocalValue = " +parameters.get("localValue"));

       System.out.println("Start validateGLCodeAccount");
       try {

           String enteredAccount = null;
           String selectedAccount=null;
           String selectedAccountDesc=null;
              // if(accountNameIt.getValue() != null) {
                   //
                   //enteredAccount = accountNameIt.getValue().toString();
                 enteredAccount=(String)parameters.get("submittedValue");

                   //System.out.println("accountNameIt.getValue(): "+enteredAccount);
            //   }
            if(enteredAccount!=null && !enteredAccount.equals("") && enteredAccount!="" && enteredAccount.trim()!=null && !enteredAccount.trim().isEmpty()){
               //System.out.println("enteredAccount Entered: "+enteredAccount);
                            //System.out.println("NOt null");
                   DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                   DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("AccountVO1Iterator");
                   ViewObjectImpl accountValidateVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                   ViewCriteria vc = accountValidateVO.getViewCriteria("AccountVOCriteria2");
                   accountValidateVO.applyViewCriteria(vc);
                   accountValidateVO.setNamedWhereClauseParam("bindAccountName", enteredAccount);
                   //System.out.println("-----------Dynamic Query-----------");
                   //System.out.println(accountValidateVO.getQuery());
                   accountValidateVO.executeQuery();
               boolean invalidQuery=true;
               //System.out.println("invalid query"+invalidQuery);
           while(accountValidateVO.hasNext()){
                   Row row = accountValidateVO.next(); // Get th
                   if(row.getAttribute("Account") != null)
                   {
                   //System.out.println(row.getAttribute("Account"));
                   selectedAccount=row.getAttribute("Account").toString();
                   accountNameIt.setValue(selectedAccount);
                   }
                   else
                   {
                        /*   FacesMessage Message =
                               new FacesMessage("Please Enter a valid Account Code");
                           Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                           FacesContext fc = FacesContext.getCurrentInstance();
                           fc.addMessage(null, Message);*/
                        //System.out.println("Invalid Account Code");
                        String vallMsg="Please Enter a valid Account Code";
                        this.validationErrorMessage.setValue(vallMsg);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                        RichPopup.PopupHints hints = new RichPopup.PopupHints();
                        validationErrorPopup.show(hints);
                           accountNameIt.setValue("");
                       }
                   if(row.getAttribute("AccountDescription") != null){
                                      selectedAccountDesc=row.getAttribute("AccountDescription").toString();
                                      //System.out.println("company desc in inner popup ::: "+ selectedAccountDesc);
                                      accountNameOt.setValue(selectedAccountDesc);
                                  }else{
                                      accountNameOt.setValue("");
                                  }
               invalidQuery=false;
           }
               if(invalidQuery)
               {
                   //System.out.println("Executing"+invalidQuery);
                     /*  FacesMessage Message =
                           new FacesMessage("Please Enter a valid Account Code");
                       Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                       FacesContext fc = FacesContext.getCurrentInstance();
                       fc.addMessage(null, Message);*/
                     //System.out.println("Invalid Account Code");
                     String vallMsg="Please Enter a valid Account Code";
                     this.validationErrorMessage.setValue(vallMsg);
                     AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                     RichPopup.PopupHints hints = new RichPopup.PopupHints();
                     validationErrorPopup.show(hints);
                       accountNameOt.setValue("");
                       String componentIDGlCode = "it38::content";
                       //System.out.println("----- componentIDGlCode ----- "+componentIDGlCode+", selectedGLCode : ");

                       FacesContext fctx = FacesContext.getCurrentInstance();
                       ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                       String myJavaScriptCode = "document.getElementById('"+componentIDGlCode+"').value = '"+""+"'";
                       erks.addScript(fctx, myJavaScriptCode);
                   }
           AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
           }
           else{
               accountNameIt.setValue("");
               accountNameOt.setValue("");
               AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
           }
       }
       catch(Exception e) {
           e.printStackTrace();
       }
       System.out.println("End validateGLCodeAccount");
    }



     public void validateGLCodeAnalysis(ClientEvent clientEvent) {
         // Add event code here...
         RichInputText inputTxt =  (RichInputText) clientEvent.getComponent();

         Map  parameters = clientEvent.getParameters();
         System.out.println("SubmittedValue = "+parameters.get("submittedValue"));
         System.out.println("LocalValue = " +parameters.get("localValue"));


         System.out.println("Start validateGLCodeAnalysis");
         try {


             String enteredAnalysiscode = null;
             String selectedAnalysisCode=null;
             String selectedAnalysisdesc=null;
                // if(analysisCodeIt.getValue() != null) {
                    // enteredAnalysiscode = analysisCodeIt.getValue().toString();
             enteredAnalysiscode=(String)parameters.get("submittedValue");
                     //System.out.println("analysisCodeIt.getValue(): "+enteredAnalysiscode);
                // }
                if(enteredAnalysiscode!=null && !enteredAnalysiscode.equals("") && enteredAnalysiscode!="" && enteredAnalysiscode.trim()!=null && !enteredAnalysiscode.trim().isEmpty()){
                 //System.out.println("enteredAnalysiscode Entered: "+enteredAnalysiscode);
                             // System.out.println("NOt null");
                     DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                     DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("AnalysisCodeVO1Iterator");
                     ViewObjectImpl analysisCodevalidateVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                     ViewCriteria vc = analysisCodevalidateVO.getViewCriteria("AnalysisCodeVOCriteria2");
                     analysisCodevalidateVO.applyViewCriteria(vc);
                     analysisCodevalidateVO.setNamedWhereClauseParam("bindAnalysisCode", enteredAnalysiscode);
                     //System.out.println("-----------Dynamic Query-----------");
                     //System.out.println(analysisCodevalidateVO.getQuery());
                     analysisCodevalidateVO.executeQuery();
                 boolean invalidQuery=true;
                 //System.out.println("invalid query"+invalidQuery);
             while(analysisCodevalidateVO.hasNext()){
                     Row row = analysisCodevalidateVO.next(); // G
                     if(row.getAttribute("Analysiscode") != null)
                     {
                     //System.out.println(row.getAttribute("Analysiscode"));
                     selectedAnalysisCode=row.getAttribute("Analysiscode").toString();
                         analysisCodeIt.setValue(selectedAnalysisCode);
                     }
                     else
                     {
                          /*   FacesMessage Message =
                                 new FacesMessage("Please Enter a valid Analysis Code");
                             Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                             FacesContext fc = FacesContext.getCurrentInstance();
                             fc.addMessage(null, Message);*/
                          //System.out.println("Invalid Analysis Code");
                          String vallMsg="Please Enter a valid Analysis Code";
                          this.validationErrorMessage.setValue(vallMsg);
                          AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                          RichPopup.PopupHints hints = new RichPopup.PopupHints();
                          validationErrorPopup.show(hints);
                             analysisCodeIt.setValue("");
                         }
                     if(row.getAttribute("Description") != null)
                     {
                     //System.out.println(row.getAttribute("Description"));
                     selectedAnalysisdesc=row.getAttribute("Description").toString();
                         analysisCodeOt.setValue(selectedAnalysisdesc);
                     }
                     else
                     {
                             analysisCodeOt.setValue("");
                         }
                   invalidQuery=false;
             }
                 if(invalidQuery)
                 {
                     //System.out.println("Executing"+invalidQuery);
                        /* FacesMessage Message =
                             new FacesMessage("Please Enter a valid Analysis Code");
                         Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                         FacesContext fc = FacesContext.getCurrentInstance();
                         fc.addMessage(null, Message);*/
                        //System.out.println("Invalid Analysis Code");
                        String vallMsg="Please Enter a valid Analysis Code";
                        this.validationErrorMessage.setValue(vallMsg);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                        RichPopup.PopupHints hints = new RichPopup.PopupHints();
                        validationErrorPopup.show(hints);
                         analysisCodeOt.setValue("");
                         String componentIDGlCode = "it37::content";
                         //System.out.println("----- componentIDGlCode ----- "+componentIDGlCode+", selectedGLCode : ");

                         FacesContext fctx = FacesContext.getCurrentInstance();
                         ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                         String myJavaScriptCode = "document.getElementById('"+componentIDGlCode+"').value = '"+""+"'";
                         erks.addScript(fctx, myJavaScriptCode);
                     }
             AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);

             }
             else{
                 analysisCodeIt.setValue("");
                 analysisCodeOt.setValue("");
                 AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
             }
         }
         catch(Exception e) {
             e.printStackTrace();
         }
         System.out.println("End validateGLCodeAnalysis");
     }

     public void validateGLCodeCounterParty(ClientEvent clientEvent) {
         // Add event code here...
         RichInputText inputTxt =  (RichInputText) clientEvent.getComponent();

         Map  parameters = clientEvent.getParameters();
         System.out.println("SubmittedValue = "+parameters.get("submittedValue"));
         System.out.println("LocalValue = " +parameters.get("localValue"));

         System.out.println("Start validateGLCodeCounterParty");
         try {
             String enteredCounterParty = null;
             String selectedCounterParty=null;
             String selectedCounterPartyDesc=null;


                     enteredCounterParty=(String)parameters.get("submittedValue");
                     //System.out.println("counterPartyIt.getValue(): "+enteredCounterParty);

              //   }
              if(enteredCounterParty!=null && !enteredCounterParty.equals("") && enteredCounterParty!="" && enteredCounterParty.trim()!=null && !enteredCounterParty.trim().isEmpty()){
                 //System.out.println("enteredCounterParty Entered: "+enteredCounterParty);
                             // System.out.println("NOt null");
                 DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                 DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CompanyCounterPartyVO1Iterator");
                 ViewObjectImpl counterPartyValidateVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                 ViewCriteria counterPartyvc = counterPartyValidateVO.getViewCriteria("CounterPartyVOCriteria2");
                 counterPartyValidateVO.applyViewCriteria(counterPartyvc);
                 counterPartyValidateVO.setNamedWhereClauseParam("bindCounterParty", enteredCounterParty);
                 //System.out.println("-----------Dynamic Query-----------");
                 //System.out.println(counterPartyValidateVO.getQuery());
                 counterPartyValidateVO.executeQuery();
                 boolean invalidQuery=true;
                 System.out.println("invalid query"+invalidQuery);
             while(counterPartyValidateVO.hasNext()){
                     Row row = counterPartyValidateVO.next();
                 if(row.getAttribute("Company") != null){
                 //System.out.println(row.getAttribute("Company"));
                  selectedCounterParty=row.getAttribute("Company").toString();
                     counterPartyIt.setValue(selectedCounterParty);
                 }
                 else{
                        /* FacesMessage Message =
                             new FacesMessage("Please Enter a valid Counter Party");
                         Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                         FacesContext fc = FacesContext.getCurrentInstance();
                         fc.addMessage(null, Message);*/
                        System.out.println("Invalid Counter Party");
                        String vallMsg="Please Enter a valid Counter Party";
                        this.validationErrorMessage.setValue(vallMsg);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                        RichPopup.PopupHints hints = new RichPopup.PopupHints();
                        validationErrorPopup.show(hints);
                         counterPartyIt.setValue("");
                     }
                  if(row.getAttribute("CompanyDescription") != null){
                  //System.out.println(row.getAttribute("CompanyDescription"));
                   selectedCounterPartyDesc=row.getAttribute("CompanyDescription").toString();
                      counterPartyOt.setValue(selectedCounterPartyDesc);
                  }
                  else{
                       counterPartyOt.setValue("");
                      }
                 invalidQuery=false;
             }
                 if(invalidQuery)
                 {
                     //System.out.println("Executing"+invalidQuery);
                        /* FacesMessage Message =
                             new FacesMessage("Please Enter a valid Counter Party");
                         Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                         FacesContext fc = FacesContext.getCurrentInstance();
                         fc.addMessage(null, Message);*/
                        //System.out.println("Invalid Counter Party");
                        String vallMsg="Please Enter a valid Counter Party";
                        this.validationErrorMessage.setValue(vallMsg);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(validationErrorMessage);
                        RichPopup.PopupHints hints = new RichPopup.PopupHints();
                        validationErrorPopup.show(hints);
                         counterPartyOt.setValue("");
                         String componentIDGlCode = "it36::content";
                         //System.out.println("----- componentIDGlCode ----- "+componentIDGlCode+", selectedGLCode : ");

                         FacesContext fctx = FacesContext.getCurrentInstance();
                         ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                         String myJavaScriptCode = "document.getElementById('"+componentIDGlCode+"').value = '"+""+"'";
                         erks.addScript(fctx, myJavaScriptCode);
                     }
             AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
             }
             else{
                 counterPartyIt.setValue("");
                 counterPartyOt.setValue("");
                 AdfFacesContext.getCurrentInstance().addPartialTarget(glCodePgl);
             }
         }
         catch(Exception e) {
             e.printStackTrace();
         }
         System.out.println("End validateGLCodeCounterParty");
     }



    public String executeGLCodeCompanyVO(String company, String searchType, boolean isLineGlCode) {
                            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CompanyCounterPartyVO1Iterator");
                            ViewObjectImpl companyPopupVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                            ViewCriteria vc = null;
                            String companyDesc = null;
                            if(searchType != null && searchType.equals("CompanyDescription")){
                                vc = companyPopupVO.getViewCriteria("CompanyDescVOCriteria");
                                companyPopupVO.applyViewCriteria(vc);
                                companyPopupVO.setNamedWhereClauseParam("bindCompanyDesc", company);
                            }
                            else{
                                vc = companyPopupVO.getViewCriteria("CompanyVOCriteria");
                                companyPopupVO.applyViewCriteria(vc);
                                companyPopupVO.setNamedWhereClauseParam("bindCompanyName", company);
                            }
                            //System.out.println("-----------Dynamic Query-----------");
                            //System.out.println(companyPopupVO.getQuery());
                            companyPopupVO.executeQuery();
                            if(isLineGlCode && companyPopupVO.getEstimatedRowCount()==1){
                                while (companyPopupVO.hasNext()) {
                                  Row row = companyPopupVO.next(); // Get the next row in the result set.
                                  if(null != row.getAttribute("CompanyDescription"))
                                  companyDesc = row.getAttribute("CompanyDescription").toString();
                                }
                            }
                            //AdfFacesContext.getCurrentInstance().addPartialTarget(companyDetailsTable);
                            return companyDesc;

    }
    public String executeGLCodeCostCentreVO(String costCentreName, String searchType, boolean isLineGlCode) {

                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CostCentreVO1Iterator");
                ViewObjectImpl costCentreVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = null;
                String costCentreDesc = null;
                if(searchType != null && searchType.equals("Description")){
                    vc = costCentreVO.getViewCriteria("CostCentreDescVOCriteria");
                    costCentreVO.applyViewCriteria(vc);
                    costCentreVO.setNamedWhereClauseParam("bindCostCenterDesc", costCentreName);
                }
                else{
                    vc = costCentreVO.getViewCriteria("CostCentreVOCriteria");
                    costCentreVO.applyViewCriteria(vc);
                    costCentreVO.setNamedWhereClauseParam("bindCostCentre", costCentreName);
                }

                //System.out.println("-----------Dynamic Query-----------");
                costCentreVO.executeQuery();

                if(isLineGlCode && costCentreVO.getEstimatedRowCount()==1){
                    while (costCentreVO.hasNext()) {
                      Row row = costCentreVO.next(); // Get the next row in the result set.
                      if(null != row.getAttribute("Description"))
                      costCentreDesc = row.getAttribute("Description").toString();
                    }
                }
                //AdfFacesContext.getCurrentInstance().addPartialTarget(companyDetailsTable);
                return costCentreDesc;

    }
    public String executeGLCodeAccountVO(String accountName, String searchType, boolean isLineGlCode) {
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("AccountVO1Iterator");
                ViewObjectImpl accountPopupVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = null;
                String accountDesc = null;
                if(searchType != null && searchType.equals("AccountDescription")){
                    vc = accountPopupVO.getViewCriteria("AccountDescVOCriteria");
                    accountPopupVO.applyViewCriteria(vc);
                    accountPopupVO.setNamedWhereClauseParam("bindAccountDesc", accountName);
                }
                else{
                    vc = accountPopupVO.getViewCriteria("AccountVOCriteria");
                    accountPopupVO.applyViewCriteria(vc);
                    accountPopupVO.setNamedWhereClauseParam("bindAccountName", accountName);
                }

                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(accountPopupVO.getQuery());
                accountPopupVO.executeQuery();

                if(isLineGlCode && accountPopupVO.getEstimatedRowCount()==1){
                    while (accountPopupVO.hasNext()) {
                      Row row = accountPopupVO.next(); // Get the next row in the result set.
                      if(null != row.getAttribute("AccountDescription"))
                      accountDesc = row.getAttribute("AccountDescription").toString();
                    }
                }
                //AdfFacesContext.getCurrentInstance().addPartialTarget(companyDetailsTable);
                return accountDesc;

    }
    public String executeGLCodeAnalysisVO(String analysisCode, String searchType, boolean isLineGlCode) {
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("AnalysisCodeVO1Iterator");
                ViewObjectImpl analysisCodePopupVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = null;
                String analysisCodeDesc = null;
                if(searchType != null && searchType.equals("Description")){
                    vc = analysisCodePopupVO.getViewCriteria("AnalysisCodeDescVOCriteria");
                    analysisCodePopupVO.applyViewCriteria(vc);
                    analysisCodePopupVO.setNamedWhereClauseParam("bindAnalysiscodeDesc", analysisCode);
                }
                else{
                    vc = analysisCodePopupVO.getViewCriteria("AnalysisCodeVOCriteria");
                    analysisCodePopupVO.applyViewCriteria(vc);
                    analysisCodePopupVO.setNamedWhereClauseParam("bindAnalysisCode", analysisCode);
                }

                //System.out.println("-----------Dynamic Query-----------");
                //System.out.println(analysisCodePopupVO.getQuery());
                analysisCodePopupVO.executeQuery();

                if(isLineGlCode && analysisCodePopupVO.getEstimatedRowCount()==1){
                    while (analysisCodePopupVO.hasNext()) {
                      Row row = analysisCodePopupVO.next(); // Get the next row in the result set.
                      if(null != row.getAttribute("Description"))
                      analysisCodeDesc = row.getAttribute("Description").toString();
                    }
                }
                //AdfFacesContext.getCurrentInstance().addPartialTarget(companyDetailsTable);
                return analysisCodeDesc;

    }
    public String executeGLCodeCounterPartyVO(String companyName, String searchType, boolean isLineGlCode) {
                            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CompanyCounterPartyVO1Iterator");
                            ViewObjectImpl companyPopupVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                            ViewCriteria vc = null;
                            String companyDesc = null;
                            if(searchType != null && searchType.equals("CompanyDescription")){
                                vc = companyPopupVO.getViewCriteria("CompanyDescVOCriteria"); //CompanyVOCriteria
                                companyPopupVO.applyViewCriteria(vc);
                                companyPopupVO.setNamedWhereClauseParam("bindCompanyDesc", companyName); //bindCompanyName
                            }
                            else{
                                vc = companyPopupVO.getViewCriteria("CounterPartyVOCriteria"); //CompanyVOCriteria
                                companyPopupVO.applyViewCriteria(vc);
                                companyPopupVO.setNamedWhereClauseParam("bindCounterParty", companyName); //bindCompanyName
                            }

                            //System.out.println("-----------Dynamic Query-----------");
                            //System.out.println(companyPopupVO.getQuery());
                            companyPopupVO.executeQuery();

                            if(isLineGlCode && companyPopupVO.getEstimatedRowCount()==1){
                                while (companyPopupVO.hasNext()) {
                                  Row row = companyPopupVO.next(); // Get the next row in the result set.
                                  if(null != row.getAttribute("CompanyDescription"))
                                  companyDesc = row.getAttribute("CompanyDescription").toString();
                                }
                            }
                            //AdfFacesContext.getCurrentInstance().addPartialTarget(companyDetailsTable);
                            return companyDesc;

    }
  /*  public String executeGLCodeCompanyVO(String companyName, boolean isLineGlCode) {
                            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("CompanyCounterPartyVO1Iterator");
                            ViewObjectImpl companyPopupVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                            ViewCriteria vc = companyPopupVO.getViewCriteria("CompanyVOCriteria");
                            companyPopupVO.applyViewCriteria(vc);
                            companyPopupVO.setNamedWhereClauseParam("bindCompanyName", companyName);
                            System.out.println("-----------Dynamic Query-----------");
                            //System.out.println(companyPopupVO.getQuery());
                            companyPopupVO.executeQuery();
                            String companyDesc = null;
                            if(isLineGlCode && companyPopupVO.getEstimatedRowCount()==1){
                                while (companyPopupVO.hasNext()) {
                                  Row row = companyPopupVO.next(); // Get the next row in the result set.
                                  if(null != row.getAttribute("CompanyDescription"))
                                  companyDesc = row.getAttribute("CompanyDescription").toString();
                                }
                            }
                            //AdfFacesContext.getCurrentInstance().addPartialTarget(companyDetailsTable);
                            return companyDesc;

    }*/


    public void setGlCodeSearchIcon(RichCommandImageLink glCodeSearchIcon) {
        this.glCodeSearchIcon = glCodeSearchIcon;
    }

    public RichCommandImageLink getGlCodeSearchIcon() {
        return glCodeSearchIcon;
    }

    public void setGlCode(RichInputText glCode) {
        this.glCode = glCode;
    }

    public RichInputText getGlCode() {
        return glCode;
    }

    public void setProjectNoSearchIcon(RichCommandImageLink projectNoSearchIcon) {
        this.projectNoSearchIcon = projectNoSearchIcon;
    }

    public RichCommandImageLink getProjectNoSearchIcon() {
        return projectNoSearchIcon;
    }
    public void setGlCodeErrorOt(RichOutputText glCodeErrorOt) {
        this.glCodeErrorOt = glCodeErrorOt;
    }

    public RichOutputText getGlCodeErrorOt() {
        return glCodeErrorOt;
    }

    public void setRejectionReasonIt(RichInputText rejectionReasonIt) {
        this.rejectionReasonIt = rejectionReasonIt;
    }

    public RichInputText getRejectionReasonIt() {
        return rejectionReasonIt;
    }

    public void setPf12(RichPanelFormLayout pf12) {
        this.pf12 = pf12;
    }

    public RichPanelFormLayout getPf12() {
        return pf12;
    }

    public void setPg147(RichPanelGroupLayout pg147) {
        this.pg147 = pg147;
    }

    public RichPanelGroupLayout getPg147() {
        return pg147;
    }

    public void setLineTypeSOC(RichSelectOneChoice lineTypeSOC) {
        this.lineTypeSOC = lineTypeSOC;
    }

    public RichSelectOneChoice getLineTypeSOC() {
        return lineTypeSOC;
    }

    public void setTaxAmountIt(RichInputText taxAmountIt) {
        this.taxAmountIt = taxAmountIt;
    }

    public RichInputText getTaxAmountIt() {
        return taxAmountIt;
    }

    public void setLineNoIt(RichInputText lineNoIt) {
        this.lineNoIt = lineNoIt;
    }

    public RichInputText getLineNoIt() {
        return lineNoIt;
    }

    public void setPg148(RichPanelGroupLayout pg148) {
        this.pg148 = pg148;
    }

    public RichPanelGroupLayout getPg148() {
        return pg148;
    }
    private String taxAmountValue;


      public void setTaxAmountValue(String taxAmountValue) {
          this.taxAmountValue = taxAmountValue;
      }

      public String getTaxAmountValue() {
          return "";
      }
      public void callFacesMessage(String errorMessage){
        FacesMessage Message =
            new FacesMessage(errorMessage);
        Message.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, Message);
      }

    public void setInvalidReasonCodeSoc(RichSelectOneChoice invalidReasonCodeSoc) {
        this.invalidReasonCodeSoc = invalidReasonCodeSoc;
    }

    public RichSelectOneChoice getInvalidReasonCodeSoc() {
        return invalidReasonCodeSoc;
    }

    public void setInvalidReasonOt(RichOutputText invalidReasonOt) {
        this.invalidReasonOt = invalidReasonOt;
    }

    public RichOutputText getInvalidReasonOt() {
        return invalidReasonOt;
    }

    public void setValueToEL(String el, Object val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory =
            facesContext.getApplication().getExpressionFactory();
        ValueExpression exp =
            expressionFactory.createValueExpression(elContext, el,
                                                    Object.class);
        exp.setValue(elContext, val);
    }

    public void getInvalidReasonType(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        this.setValueToEL("#{bindings.InvalidReasonTypeId.inputValue}",
                          valueChangeEvent.getNewValue()); //Updates the model
        System.out.println("\n******** Selected Value: " +
                           resolveExpression("#{bindings.InvalidReasonTypeId.attributeValue}"));
        System.out.println("\n******** Display Value: " +
                           resolveExpression("#{bindings.InvalidReasonTypeId.selectedValue ne ' ' ? bindings.InvalidReasonTypeId.selectedValue.attributeValues[1] : ''}"));
        String invalidReasonType =
            (String)resolveExpression("#{bindings.InvalidReasonTypeId.selectedValue ne ' ' ? bindings.InvalidReasonTypeId.selectedValue.attributeValues[1] : ''}");
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("invalidReasonType", invalidReasonType);

    }

    public void onReassignCommenstClick(ActionEvent actionEvent) {
        System.out.println("Start onReassignCommenstClick");
                String commentsVal = null;
                try {
                    if(reassignCommentsIt.getValue() != null)
                        commentsVal = reassignCommentsIt.getValue().toString();
                    //System.out.println("commentsIt: "+reassignCommentsIt);
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    reassignCommentsPopupIt.setValue(commentsVal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(reassignCommentsPopupIt);
                    reassignCommentPopup.show(hints);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                System.out.println("End onReassignCommenstClick");
    }

    public void setReassignCommentsPopupIt(RichInputText reassignCommentsPopupIt) {
        this.reassignCommentsPopupIt = reassignCommentsPopupIt;
    }

    public RichInputText getReassignCommentsPopupIt() {
        return reassignCommentsPopupIt;
    }

    public void setReassignCommentsIt(RichInputText reassignCommentsIt) {
        this.reassignCommentsIt = reassignCommentsIt;
    }

    public RichInputText getReassignCommentsIt() {
        return reassignCommentsIt;
    }

    public void setReassignCommentPopup(RichPopup reassignCommentPopup) {
        this.reassignCommentPopup = reassignCommentPopup;
    }

    public RichPopup getReassignCommentPopup() {
        return reassignCommentPopup;
    }

    public void onReassignCommentsPopupOKClick(ActionEvent actionEvent) {
        System.out.println("Start onReassignCommentsPopupOKClick");
                String commentsVal = null;
                try {
                    if(reassignCommentsPopupIt.getValue() != null)
                        commentsVal = reassignCommentsPopupIt.getValue().toString();
                    //System.out.println("commentsPopupIt: "+reassignCommentsPopupIt);
                    reassignCommentsIt.setValue(commentsVal);

                    AdfFacesContext.getCurrentInstance().addPartialTarget(reassignCommentsIt);
                    reassignCommentsPopupIt.setValue("");
                    AdfFacesContext.getCurrentInstance().addPartialTarget(reassignCommentsPopupIt);
                    reassignCommentPopup.hide();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                System.out.println("End onReassignCommentsPopupOKClick");
    }

    private void doReassignOperation(String name, String userId,
                                     String reassignComments, String emailId) {
        System.out.println("Start : doReassignOperation");
                try{

                   // String userName = "";
                    //String apGroupUserName = "";
                   // String commentsDate = null;

                    /***Opened on 1.06.2018 for audit purpose *****/
                    FacesContext context = FacesContext.getCurrentInstance();
                    String ctx = (String)context.getApplication().evaluateExpressionGet(context,"#{pageFlowScope.bpmWorklistContext}",String.class);
                    String taskId = (String)context.getApplication().evaluateExpressionGet(context,"#{pageFlowScope.bpmWorklistTaskId}",String.class);
                    System.out.println("----- bpmWorklistContext : "+ctx+", bpmWorklistTaskId : "+taskId);
                    IWorkflowServiceClient workflowSvcClient = ADFWorklistBeanUtil.getWorkflowServiceClient();
                    ITaskQueryService wfQueryService = workflowSvcClient.getTaskQueryService();
                    ITaskService taskSvc = workflowSvcClient.getTaskService();

                    IWorkflowContext wfContext;
                    String userName = "";
                    String apGroupUserName = "";
                    String commentsDate = null;
                    wfContext = wfQueryService.getWorkflowContext(ctx);
                    userName = wfContext.getUser();
                    System.out.println("----- BPM User to be put on reassignComments: "+userName);

                    Task currentTask = wfQueryService.getTaskDetailsById(wfContext, taskId);
                    SystemAttributesType systemAttributesType = currentTask.getSystemAttributes();
                    apGroupUserName = systemAttributesType.getUpdatedBy().getDisplayName();
                    System.out.println("apGroupUserName in reassign :::::: "+ apGroupUserName);

                    /***Opened on 1.06.2018 for audit purpose *****/
                    String tobesavedinComments = reassignComments;
                    reassignComments = "Reassigned by User "+userName+" on "+new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + "\nComments : " + reassignComments;
                    apGroupUserName = getAPGroupUserName();
                    //System.out.println("User name in reassign :::: "+ apGroupUserName);
                    saveCertifierReassignComments(getInvoiceId(),commentsDate,tobesavedinComments,apGroupUserName);

                    Utility.getAm().reassignCertifier(resolveExpression("#{bindings.invoiceID.inputValue}").toString(),name, userId,reassignComments,emailId);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                System.out.println("End doReassignOperation");

    }
    public void setPoNoCertifierTable(RichTable poNoCertifierTable) {
        this.poNoCertifierTable = poNoCertifierTable;
    }


    public String getAPGroupUserName() {
              System.out.println("----- getAPGroupUserName ----- START ---- -"+new Date());
              FacesContext context = FacesContext.getCurrentInstance();
              String ctx = (String)context.getApplication().evaluateExpressionGet(context,"#{pageFlowScope.bpmWorklistContext}",String.class);

              String taskId = (String)context.getApplication().evaluateExpressionGet(context,"#{pageFlowScope.bpmWorklistTaskId}",String.class);

              //System.out.println("----- bpmWorklistContext : "+ctx+", bpmWorklistTaskId : "+taskId);

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


                  DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                  DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("searchCertifierVO1Iterator");
                  ViewObjectImpl certifierNameVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
    //                  ViewCriteria vc = certifierNameVO.getViewCriteria("CertifierNameVOCriteria1");
    //                  certifierNameVO.applyViewCriteria(vc);
                  certifierNameVO.setNamedWhereClauseParam("bindName", userID);
                  certifierNameVO.executeQuery();
                  int noOfRows=certifierNameVO.getRowCount();
                  //System.out.println("No of rows fetched by searchcertifiernameVO is "+noOfRows);
                  if(noOfRows==1){
                      //System.out.println("Executing No of rows is "+noOfRows);
                      Row row = certifierNameVO.next();
                      if(row.getAttribute("FirstName") != null){

                            certifierName=row.getAttribute("FirstName").toString();
                            //System.out.println("certifer name in  getAPGroupUserName"+certifierName);
                            }
                    }
                  if(noOfRows == 0){
                      certifierName = "eqadmin";
                  }



              } catch(Exception ex) {
                  ex.printStackTrace();
              }

              System.out.println("----- getAPGroupUserName ----- END ----- "+new Date());
              System.out.println("certifer name in  getAPGroupUserName"+certifierName);
              return certifierName;
          }


    public RichTable getPoNoCertifierTable() {
        return poNoCertifierTable;
    }

    public void validateCertifierPageLineItems(FacesContext facesContext,
                                               UIComponent uIComponent,
                                               Object object) {
        System.out.println("Start validateCertifierPageLineItems");
        String msg = null;



            boolean isValid = true;

            Integer line;
            /* added validation on submit"*/
            BindingContext bc = BindingContext.getCurrent();
            DCBindingContainer bindings =
                (DCBindingContainer)bc.getCurrentBindingsEntry();
            DCIteratorBinding glIter =
                bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
            if (glIter != null &&
                glIter.getRowSetIterator().getRowCount() > 0) {
                RowSetIterator rsi =null;
                try{
                   rsi= glIter.getViewObject().createRowSetIterator(null);
                Row glRow;
                while (rsi.next() != null) {
                    glRow = rsi.getCurrentRow();
                    //System.out.println("GlNo LineNo ::" + glRow.getAttribute("LineNumber"));
                    line = (glRow.getAttribute("LineNumber")==null) ? null : ((oracle.jbo.domain.Number)glRow.getAttribute("LineNumber")).intValue();
                    System.out.println(" Line ::" +line);

                    if (glRow.getAttribute("GlNo") == null && glRow.getAttribute("ProjectNo") == null) {

                        isValid = false;
                        msg="Enter valid GL Code or Project Details (Project No, Task No, Expenditure Org, Expenditure Date, and Expenditure Type) on Line No : "+line;
                        break;
                    }
                    else if(glRow.getAttribute("GlNo") == null && glRow.getAttribute("ProjectNo") != null){
                        String orgId= null;
                        String projectNo=(String)glRow.getAttribute("ProjectNo");
                        if(orgIdIt.getValue()!=null)
                        {
                            orgId=orgIdIt.getValue().toString();
                                //System.out.println("orgIdIt: "+orgId);
                        }

                        /* validate if proper project number entered*/
                        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ProjectNumberVO1Iterator");
                        ViewObjectImpl projectNumberVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                        ViewCriteria projectNoVc = projectNumberVO.getViewCriteria("ProjectNumberVOCriteria1");
                        projectNumberVO.applyViewCriteria(projectNoVc);
                        projectNumberVO.setNamedWhereClauseParam("bindOrgID", orgId);
                        projectNumberVO.setNamedWhereClauseParam("bindProjectNo", projectNo);
                        //System.out.println("-----------Dynamic Query-----------");
                        //System.out.println(projectNumberVO.getQuery());
                        projectNumberVO.executeQuery();
                        if(projectNumberVO.getEstimatedRowCount() ==0){
                            isValid = false;
                            msg = "Enter valid Project Number on Line No : "+line;
                            break;
                        }



                        if(glRow.getAttribute("TaskNo")==null){
                            isValid = false;
                            msg = "Enter valid Task Number on Line No : "+line;
                            break;
                        }
                        else{
                            //Task No Validation
                            String taskNo = (String)glRow.getAttribute("TaskNo");
                            String projectId = null;
                            if(projectIdIt.getValue()!= null) {
                                projectId = projectIdIt.getValue().toString();
                                System.out.println("projectIdIt.getValue()" + projectId);
                            }
                            DCBindingContainer dcBindingContainerTask = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                            DCIteratorBinding dcIteratorBindingTask = dcBindingContainerTask.findIteratorBinding("TaskNumberVO1Iterator");
                            ViewObjectImpl taskNumberVO = (ViewObjectImpl)dcIteratorBindingTask.getViewObject();
                            ViewCriteria vc = taskNumberVO.getViewCriteria("TaskNumberVOCriteria2");
                            taskNumberVO.applyViewCriteria(vc);
                            taskNumberVO.setNamedWhereClauseParam("bindprojectId", projectId);
                            taskNumberVO.setNamedWhereClauseParam("bindTaskNo", taskNo);
                            //System.out.println("-----------Dynamic Query-----------");
                            //System.out.println(taskNumberVO.getQuery());
                            taskNumberVO.executeQuery();
                            if(taskNumberVO.getEstimatedRowCount() ==0){
                                isValid = false;
                                msg = "Enter valid Task Number on Line No  : "+line;
                                break;
                            }

                        }
                        if(glRow.getAttribute("ExpinditureOrg")==null){
                            isValid = false;
                            msg = "Enter valid Expenditure Org. on Line No  : "+line;
                            break;
                        }
                        else{
                            //Expenditure Org Validation
                            //System.out.println(" validateCertifierPageLineItems org added");
                            String enteredOrgIdIt=null;
                            if(orgIdIt.getValue() != null) {
                                enteredOrgIdIt = orgIdIt.getValue().toString();
                                //System.out.println("orgIdIt.getValue(): "+enteredOrgIdIt);
                            }
                            else{
                                    //System.out.println("orgIdIt.getValue(): "+orgIdIt.getValue());
                                }

                            String expenditureOrg = (String)glRow.getAttribute("ExpinditureOrg");
                            DCBindingContainer dcBindingContainerOrg = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                            DCIteratorBinding dcIteratorBindingOrg = dcBindingContainerOrg.findIteratorBinding("ExpenditureOrgVO1Iterator");
                            ViewObjectImpl expOrgVO = (ViewObjectImpl)dcIteratorBindingOrg.getViewObject();
                            ViewCriteria vc = expOrgVO.getViewCriteria("ExpenditureOrgVOCriteria_filterByExpOrg");
                            expOrgVO.applyViewCriteria(vc);
                            expOrgVO.setNamedWhereClauseParam("bind_expOrg", expenditureOrg);
                            expOrgVO.setNamedWhereClauseParam("bindOrgID",enteredOrgIdIt );
                            //System.out.println("-----------Dynamic Query-----------");
                            //System.out.println(expOrgVO.getQuery());
                            expOrgVO.executeQuery();
                            if(expOrgVO.getEstimatedRowCount() ==0){
                                isValid = false;
                                msg = "Enter valid Expenditure Org on Line No : "+line;
                                break;
                            }

                        }
                        if(glRow.getAttribute("ExpenditureDate")==null){
                            isValid = false;
                            msg = "Enter valid Expenditure Date on Line No : "+line;
                            break;
                        }
                        if(glRow.getAttribute("Attr10")==null){
                            isValid = false;
                            msg = "Enter valid Expenditure Type on Line No : "+line;
                            break;
                        }
                        else{
                            //Expenditure Type Validation

                            String expenditureType = (String)glRow.getAttribute("Attr10");
                            String projectId = null;
                            if(projectIdIt.getValue()!= null) {
                                projectId = projectIdIt.getValue().toString();
                               // System.out.println("projectIdIt.getValue()" + projectId);
                            }
                            DCBindingContainer dcBindingContainerType = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                           DCIteratorBinding dcIteratorBindingType = dcBindingContainerType.findIteratorBinding("ExpenditureTypeVO1Iterator");
                           ViewObjectImpl expenditureTypeVo = (ViewObjectImpl)dcIteratorBindingType.getViewObject();
                           ViewCriteria vc = expenditureTypeVo.getViewCriteria("ExpenditureTypeVOCriteria2");
                           expenditureTypeVo.applyViewCriteria(vc);
                           expenditureTypeVo.setNamedWhereClauseParam("bindProjectId", projectId);
                           expenditureTypeVo.setNamedWhereClauseParam("bindExpType", expenditureType);


                           //System.out.println("-----------Dynamic Query-----------");
                           //System.out.println(expenditureTypeVo.getQuery());
                           expenditureTypeVo.executeQuery();
                            if(expenditureTypeVo.getEstimatedRowCount() ==0){
                                isValid = false;
                                msg = "Enter valid Expenditure Type on Line No : "+line;
                                break;
                            }

                        }
                    }
                    else{
                        String orgId=null;
                        String glCodeError=null;
                        String glcode=(String)glRow.getAttribute("GlNo");
                        System.out.println("selected gl code id"+glcode);

                            System.out.println("Org Id:"+orgIdIt.getValue()+".");
                                if(orgIdIt.getValue()!=null)
                                {
                                    orgId=orgIdIt.getValue().toString();
                                        System.out.println("orgIdIt: "+orgId);
                                    }

                            DCBindingContainer dcBindingContainer5 = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                            DCIteratorBinding dcIteratorBinding5 = dcBindingContainer5.findIteratorBinding("ValidateGLCodeVO1Iterator");
                            ViewObjectImpl validateGLCodeVO = (ViewObjectImpl)dcIteratorBinding5.getViewObject();
                            /*   ViewCriteria vc5 = validateGLCodeVO.getViewCriteria("CounterPartyVOCriteria1");
                            validateGLCodeVO.applyViewCriteria(vc5);*/
                            validateGLCodeVO.setNamedWhereClauseParam("bindGLCode",glcode);
                            validateGLCodeVO.setNamedWhereClauseParam("bindOrgID",orgId);
                            //System.out.println("-----------Dynamic Query-----------");
                            //System.out.println(validateGLCodeVO.getQuery());
                            validateGLCodeVO.executeQuery();
                            while (validateGLCodeVO.hasNext()) {
                              Row row = validateGLCodeVO.next(); // Get the next row in the result set.
                              if(null != row.getAttribute("Validglcode"))
                              {
                              glCodeError = row.getAttribute("Validglcode").toString();
                                System.out.println("glCodeError"+glCodeError);
                                }
                            }
                            if(glCodeError!=null && !glCodeError.equals(""))
                            {
                            System.out.println("Inside if glcode error" +glCodeError);
                            isValid = false;
                            msg = "Enter valid GL Code on Line No "+line+" : "+glCodeError;
                            break;
                            }
                        }

                }
                }catch(Exception e)
                {e.printStackTrace();
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
               // rsi.closeRowSetIterator();
            }



            if(!isValid) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null));
            }


        System.out.println("End validateCertifierPageLineItems");
    }
    public void setCompanySoc(RichSelectOneChoice companySoc) {
        this.companySoc = companySoc;
    }

    public RichSelectOneChoice getCompanySoc() {
        return companySoc;
    }

    public void setCostcenterSoc(RichSelectOneChoice costcenterSoc) {
        this.costcenterSoc = costcenterSoc;
    }

    public RichSelectOneChoice getCostcenterSoc() {
        return costcenterSoc;
    }

    public void setAccountSoc(RichSelectOneChoice accountSoc) {
        this.accountSoc = accountSoc;
    }

    public RichSelectOneChoice getAccountSoc() {
        return accountSoc;
    }

    public void setAnalysisCodeSoc(RichSelectOneChoice analysisCodeSoc) {
        this.analysisCodeSoc = analysisCodeSoc;
    }

    public RichSelectOneChoice getAnalysisCodeSoc() {
        return analysisCodeSoc;
    }

    public void setCounterPartySoc(RichSelectOneChoice counterPartySoc) {
        this.counterPartySoc = counterPartySoc;
    }

    public RichSelectOneChoice getCounterPartySoc() {
        return counterPartySoc;
    }
    public void onDescClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start onDescClick");
        String commentsVal = null;
        DCBindingContainer bindings = getBinding();
        DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        //System.out.println("lineItemIter ::"+lineItemIter);
        ViewObject empVO = lineItemIter.getViewObject();
        Row selectedRow=empVO.getCurrentRow();
        //System.out.println("selectedRow :: "+selectedRow);
        if (selectedRow!=null){
                try {
                    if(selectedRow.getAttribute("LineDescription")!=null)
                    commentsVal = selectedRow.getAttribute("LineDescription").toString();
                    //System.out.println("commentsVal****: "+commentsVal);
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    descPopupIt.setValue(commentsVal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(descPopupIt);
                    descPopup.show(hints);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                }
        System.out.println("End onDescClick");
        }
    private DCBindingContainer getBinding() {
        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer bindings = (DCBindingContainer)bc.getCurrentBindingsEntry();
        return bindings;
    }

    public void setDescPopup(RichPopup descPopup) {
        this.descPopup = descPopup;
    }

    public RichPopup getDescPopup() {
        return descPopup;
    }

    public void setDescPopupIt(RichInputText descPopupIt) {
        this.descPopupIt = descPopupIt;
    }

    public RichInputText getDescPopupIt() {
        return descPopupIt;
    }

    public void onDescriptionPopupOKClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start onDescriptionPopupOKClick");
        DCBindingContainer bindings = getBinding();
        DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        //System.out.println("lineItemIter ::"+lineItemIter);
        ViewObject empVO = lineItemIter.getViewObject();
        Row selectedRow=empVO.getCurrentRow();
        //System.out.println("selectedRow :: "+selectedRow);
                if (selectedRow!=null){
                  //System.out.println("**  Indise if ***");
                  String descVal = null;
                  try {
                      if(descPopupIt.getValue() != null)
                          descVal = descPopupIt.getValue().toString();
                      //System.out.println("Description PopupIt: "+descPopupIt);
                      selectedRow.setAttribute("LineDescription",descVal);
        //                                    commentsIt.setValue(descVal);
                      descPopup.hide();
                      AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
                  }
                  catch(Exception e) {
                      e.printStackTrace();
                  }
          }
    }
    public void onCopyClick(ActionEvent actionEvent) {
        // Add event code here...
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dciter = (DCIteratorBinding) bindings.get("LineItemDetailsEOView1Iterator");
        RowSetIterator rsi=null;
        try{
            rsi = dciter.getRowSetIterator();
        Row firstRow = rsi.first();
        /*System.out.println("first row attribute ::: "+ firstRow.getAttribute("LineDescription"));

        System.out.println("first row line NO :::"+firstRow.getAttribute("LineNumber"));
        System.out.println("first row tax rate :::"+firstRow.getAttribute("TaxRate"));*/


        String GlNo = firstRow.getAttribute("GlNo")==null ? null : (String)firstRow.getAttribute("GlNo");
        String ProjectNo = firstRow.getAttribute("ProjectNo")==null ? null : (String)firstRow.getAttribute("ProjectNo");
        String TaskNo = firstRow.getAttribute("TaskNo")==null ? null : (String)firstRow.getAttribute("TaskNo");
        String ExpinditureOrg = firstRow.getAttribute("ExpinditureOrg")==null ? null : (String)firstRow.getAttribute("ExpinditureOrg");
        oracle.jbo.domain.Date ExpenditureDate = firstRow.getAttribute("ExpenditureDate")==null ? null : (oracle.jbo.domain.Date)firstRow.getAttribute("ExpenditureDate");
        String Attr10 = firstRow.getAttribute("Attr10")==null ? null : (String)firstRow.getAttribute("Attr10"); //ExpinditureType
        String taxRateCode = firstRow.getAttribute("TaxRateCode")==null ? null : (String)firstRow.getAttribute("TaxRateCode");
        oracle.jbo.domain.Number taxRate = firstRow.getAttribute("TaxRate")==null ? null : (oracle.jbo.domain.Number)firstRow.getAttribute("TaxRate");



        System.out.println("tax rate from first row :: "+ taxRate);
        double lineTotalAmount = 0;
        double taxRateAmount = 0;
        double taxAmount = 0;
        double taxAmountTotal = firstRow.getAttribute("TaxAmountLineitem")==null ? 0 : Double.parseDouble(firstRow.getAttribute("TaxAmountLineitem").toString()); // first row tax amount
        if(
            (GlNo==null||(GlNo!=null&&GlNo.trim().equals("")))
            &&
            (ProjectNo==null||(ProjectNo!=null&&ProjectNo.trim().equals("")))
        ) {
            callFacesMessage("Before copying, please Enter valid GL Account Code Combination or Project Details (Project No, Task No, Expenditure Org, Expenditure Date, and Expenditure Type) on Line No : 1");
            return;
        }
        while(rsi.hasNext()){
            Row nextRow = rsi.next();
            nextRow.setAttribute("GlNo",            GlNo);
            nextRow.setAttribute("ProjectNo",       ProjectNo);
            nextRow.setAttribute("TaskNo",          TaskNo);
            nextRow.setAttribute("ExpinditureOrg",  ExpinditureOrg);
            nextRow.setAttribute("ExpenditureDate", ExpenditureDate);
            nextRow.setAttribute("Attr10",          Attr10);
            if(nextRow.getAttribute("LineType") == null || (nextRow.getAttribute("LineType") != null && nextRow.getAttribute("LineType").toString().trim().equalsIgnoreCase("TAXABLE LINE"))){
               if(nextRow.getAttribute("LineDescription") == null
               ||
               (nextRow.getAttribute("LineDescription") != null && !nextRow.getAttribute("LineDescription").toString().trim().equalsIgnoreCase("adjustment line"))){
                    nextRow.setAttribute("TaxRateCode", taxRateCode);
                    nextRow.setAttribute("TaxRate", taxRate);

                    if(taxRateCode != null && !taxRateCode.equals("")){
                        oracle.jbo.domain.Number lineTotal = nextRow.getAttribute("LineTotalAmount")==null ? null : (oracle.jbo.domain.Number)nextRow.getAttribute("LineTotalAmount");
                        if(lineTotal != null){
                            lineTotalAmount = lineTotal.doubleValue();
                            taxRateAmount = taxRate.doubleValue();
                            taxAmount = lineTotalAmount * taxRateAmount/100;
                            taxAmountTotal += taxAmount;
                            DecimalFormat df = new DecimalFormat("#0.00");
                            nextRow.setAttribute("TaxAmountLineitem", df.format(taxAmount).toString());

                        }
                    }
                }

            }

        }
            //taxAmountSum.setValue(taxAmountTotal);
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

        //recalculateLineAndTaxTotal();
        AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
    }

    public void setLineIdIt(RichInputText lineIdIt) {
        this.lineIdIt = lineIdIt;
    }

    public RichInputText getLineIdIt() {
        return lineIdIt;
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
    public String setProjectIdIt() {
        // Add event code here...
        System.out.println("Start setProjectIdIt");
        String selectedProjNo = null;
        String projectId = null;
        String enteredOrgIdIt=null;
        RowSetIterator rsIter = null;
        if(orgIdIt.getValue() != null) {
            enteredOrgIdIt = orgIdIt.getValue().toString();
            System.out.println("orgIdIt.getValue(): "+enteredOrgIdIt);
        }



        try{
                DCBindingContainer dcb = (DCBindingContainer)getBindings();
                DCIteratorBinding dcItr = dcb .findIteratorBinding("LineItemDetailsEOView1Iterator");
                rsIter = dcItr .getRowSetIterator();
                Row rowObj = rsIter .getCurrentRow();


                if(rowObj != null){

                    //System.out.println("trying new method");
                    System.out.println("ProjectNo ::"+rowObj.getAttribute("ProjectNo"));
                    selectedProjNo=rowObj.getAttribute("ProjectNo").toString();

                }

                }catch(Exception e){
                    e.printStackTrace();
                    }/*finally{
                        if(rsIter !=  null)
                            rsIter.closeRowSetIterator();
                    }*/

         System.out.println("Entered Project No : "+selectedProjNo);

        /*DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");



      ViewObject lineItemVO=     lineItemIter.getViewObject();
            System.out.println("RowCount::"+lineItemVO.getEstimatedRowCount());




        RowSetIterator rsi=null;
        try{
            rsi = lineItemVO.createRowSetIterator(null);
        while (rsi.next() != null) {
            Row lineItemRow = rsi.getCurrentRow();
            System.out.println("ProjectNo ::"+lineItemRow.getAttribute("ProjectNo"));
            selectedProjNo=lineItemRow.getAttribute("ProjectNo").toString();
            System.out.println("Within While ProjectNo"+selectedProjNo);

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
                 }*/
        /* ************** */
        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ProjectNumberVO1Iterator");
        ViewObjectImpl projectNumberVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
        ViewCriteria vc = projectNumberVO.getViewCriteria("ProjectNumberVOCriteria1");
        projectNumberVO.applyViewCriteria(vc);
        projectNumberVO.setNamedWhereClauseParam("bindOrgID", enteredOrgIdIt.trim());
        projectNumberVO.setNamedWhereClauseParam("bindProjectNo", selectedProjNo.trim());
        projectNumberVO.executeQuery();
        System.out.println("row count ::: "+ projectNumberVO.getEstimatedRowCount());
        if(projectNumberVO.getEstimatedRowCount() > 0){
 //            Row row = projectNumberVO.getCurrentRow();
            // 30-11-2022 Replace getCurrentRow() to first()
            Row row = projectNumberVO.first();
			projectId = row.getAttribute("ProjectId") == null ? null : row.getAttribute("ProjectId").toString().trim();
        }
        System.out.println("project id in setProjectIdIt :: "+ projectId);
        System.out.println("End setProjectIdIt");
        return projectId;
    }
    //Added by raha for projectno and taskno manual
    public String setTaskIdIt() {
        String projectId = null;
        String taskId=null;
        projectId=setProjectIdIt();
        String invNum = null;
        String taskNo = null;
        RowSetIterator rsIter = null;
        if(invNumIt.getValue()!=null){
        invNum = (String)invNumIt.getValue();
        }
        /*if(taskNoIT.getValue() != null) {
            taskNo = taskNoIT.getValue().toString();
            System.out.println("invNum:"+invNum+ "taskNoIT.getValue(): "+taskNo);
        }
        System.out.println("invNum:"+invNum+ "inside settaskid newprojectid4::"+projectId);*/
        //Added by raha for expenditure type bug fix 13*11*2019
        try{
        DCBindingContainer dcb = (DCBindingContainer)getBindings();
        DCIteratorBinding dcItr = dcb .findIteratorBinding("LineItemDetailsEOView1Iterator");
        rsIter = dcItr .getRowSetIterator();
        Row rowObj = rsIter .getCurrentRow();
        taskNo=rowObj.getAttribute("TaskNo")==null?"":rowObj.getAttribute("TaskNo").toString().trim();
        System.out.println("invNum: "+invNum+ "ENTERED task NO " + rowObj.getAttribute("TaskNo"));
        }
         catch(Exception e)
         {
            e.printStackTrace();
            }
        //ended by raha
        try{
        DCBindingContainer dcBindingContainerTask = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBindingTask = dcBindingContainerTask.findIteratorBinding("TaskNumberVO1Iterator");
        ViewObjectImpl taskNumberVO = (ViewObjectImpl)dcIteratorBindingTask.getViewObject();
        ViewCriteria vc = taskNumberVO.getViewCriteria("TaskNumberVOCriteria2");
        taskNumberVO.applyViewCriteria(vc);
        taskNumberVO.setNamedWhereClauseParam("bindprojectId", projectId);
        taskNumberVO.setNamedWhereClauseParam("bindTaskNo", taskNo);
        System.out.println("invNum:"+invNum+ "taskNoIT.getValue(): "+taskNo);
        //System.out.println("invNum:"+invNum+ "  -----------Dynamic Query-----------");
        //System.out.println(taskNumberVO.getQuery());
        taskNumberVO.executeQuery();
        System.out.println("invNum: "+invNum+ " row count ::: "+ taskNumberVO.getEstimatedRowCount());
        if(taskNumberVO.getEstimatedRowCount() > 0){
            Row row = taskNumberVO.first();
            taskId = row.getAttribute("TaskId") == null ? null : row.getAttribute("TaskId").toString().trim();
        }
        }catch(Exception e)
        {
           e.printStackTrace();
           }
        System.out.println("invNum: "+invNum+ " taskId in setTaskIdIt :: "+ taskId);
        System.out.println("invNum: "+invNum+  " End setTaskIdIt");
        return taskId;

    }
    //ended by raha


    private oracle.jbo.domain.Date getExpenditureDate() {

        System.out.println("getExpenditureDate : starts");


        DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObject lineItemVO=     lineItemIter.getViewObject();
        //System.out.println("RowCount::"+lineItemVO.getEstimatedRowCount());

        oracle.jbo.domain.Date expDate = null;
        /* ********************* */

        RowSetIterator rsi=null;
        try{
            rsi = lineItemVO.createRowSetIterator(null);
            while (rsi.next() != null) {
            Row lineItemRow = rsi.getCurrentRow();
                System.out.println("Expenditure Date ::"+lineItemRow.getAttribute("ExpenditureDate"));
                expDate = (oracle.jbo.domain.Date)lineItemRow.getAttribute("ExpenditureDate");

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

        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
        String expenditureDate = expDate != null ? DATE_FORMAT.format(expDate.getValue()): null;
        System.out.println("date value in GetExpenditureDate : "+expenditureDate);
        System.out.println("GetExpenditureDate : ends");
        return expDate;
    }

    public void setOperatingUnitIt(RichInputText operatingUnitIt) {
        this.operatingUnitIt = operatingUnitIt;
    }

    public RichInputText getOperatingUnitIt() {
        return operatingUnitIt;
    }
    public void calculateLineTotal(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        System.out.println("Within calculateLineTotal");
        //System.out.println("valueChangeEvent.getNewValue()"+valueChangeEvent.getNewValue());
//        System.out.println("valueChangeEvent.getOldValue()"+valueChangeEvent.getOldValue());
        DCBindingContainer bindings = getBinding();
        DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObject empVO = lineItemIter.getViewObject();
        Row selectedRow=empVO.getCurrentRow();
        oracle.jbo.domain.Number line_total=null;
        double quantity=0;
        double unitPrice=0;
        double lineTot=0;
        if (selectedRow!=null){
        //System.out.println("selectedRow :: "+selectedRow);
//        if(selectedRow.getAttribute("TaxRateCode")!=null){
//        System.out.println("Tax Rate code from calculateLineTotalFromQuantity"+selectedRow.getAttribute("TaxRateCode"));
//        }
                try {
                    if(valueChangeEvent.getNewValue()!=null && selectedRow.getAttribute("UnitPrice")!=null){
                    //System.out.println("Quantity****"+ selectedRow.getAttribute("Quantity"));
        //                    quantity=Long.parseLong(selectedRow.getAttribute("Quantity").toString());
                    quantity=Double.parseDouble(valueChangeEvent.getNewValue().toString());
                    //System.out.println("UnitPrice****"+selectedRow.getAttribute("UnitPrice"));
                    unitPrice=Double.parseDouble(selectedRow.getAttribute("UnitPrice").toString());
                    lineTot=quantity*unitPrice;
                    //System.out.println("lineTot*******"+lineTot);
                    line_total=new oracle.jbo.domain.Number(lineTot);
                    System.out.println("line_total**************"+line_total);
                    //selectedRow.setAttribute("LineTotalAmount",line_total);

                    BigDecimal decimalValue = new BigDecimal(line_total.doubleValue());
                    decimalValue = decimalValue.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    selectedRow.setAttribute("LineTotalAmount",new oracle.jbo.domain.Number(decimalValue.doubleValue()));

                    calculateTaxAmount(lineTot);
                        //recalculateLineAndTaxTotal_onTabout();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(lineTotal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(sumOfTaxTotal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(sumOfLineTotal);
                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                }
        System.out.println("End calculateLineTotal");
    }

    public void setLineTotal(RichInputText lineTotal) {
        this.lineTotal = lineTotal;
    }

    public RichInputText getLineTotal() {
        return lineTotal;
    }

    public void calculateLineTotlFromUnit(ValueChangeEvent valueChangeEvent) {
        System.out.println("Within calculateLineTotlFromUnit");
        //        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("taxRate", null);
        DCBindingContainer bindings = getBinding();
        DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObject empVO = lineItemIter.getViewObject();
        Row selectedRow=empVO.getCurrentRow();
        oracle.jbo.domain.Number line_total=null;
        double quantity=0;
        double unitPrice=0;
        double lineTot=0;
        if (selectedRow!=null){
//        System.out.println("selectedRow :: "+selectedRow);
//        if(selectedRow.getAttribute("TaxRateCode")!=null){
//        System.out.println("Tax Rate code from calculateLineTotlFromUnit"+selectedRow.getAttribute("TaxRateCode"));
//        }
                    //System.out.println("TaxRateCode calculateLineTotlFromUnit****"+selectedRow.getAttribute("TaxRateCode"));
                try {
                    if(valueChangeEvent.getNewValue()!=null && selectedRow.getAttribute("Quantity")!=null)
                    //System.out.println("Quantity****"+ selectedRow.getAttribute("Quantity"));
                    //System.out.println("UnitPrice****"+selectedRow.getAttribute("UnitPrice"));
                    quantity=Double.parseDouble(selectedRow.getAttribute("Quantity").toString());
                    unitPrice=Double.parseDouble(valueChangeEvent.getNewValue().toString());
                    lineTot=quantity*unitPrice;
                    //System.out.println("lineTot*******"+lineTot);
                    line_total=new oracle.jbo.domain.Number(lineTot);
                    //System.out.println("line_total**************"+line_total);

                    //selectedRow.setAttribute("LineTotalAmount",line_total);
                    BigDecimal decimalValue = new BigDecimal(line_total.doubleValue());
                    decimalValue = decimalValue.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    selectedRow.setAttribute("LineTotalAmount",new oracle.jbo.domain.Number(decimalValue.doubleValue()));

                    calculateTaxAmount(lineTot);

                   // recalculateLineAndTaxTotal_onTabout();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(lineTotal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(sumOfTaxTotal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(sumOfLineTotal);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                }
        System.out.println("End calculateLineTotlFromUnit");
    }

    public void calculateTaxAmountFromLineTot(ValueChangeEvent valueChangeEvent) {
        double lineTotalVar=0;
        double sum = 0.0;
       double lineTotalVarOldValue = 0.0;
        DecimalFormat df = new DecimalFormat("#0.00");
//       if(lineTotalSum.getValue()!=null)
//       sum = Double.parseDouble(lineTotalSum.getValue().toString());
       //nextRow.setAttribute("TaxAmountLineitem", df.format(taxAmount).toString());
       if(valueChangeEvent.getOldValue()!=null)
       lineTotalVarOldValue = Double.parseDouble(valueChangeEvent.getOldValue().toString());


        if(valueChangeEvent.getNewValue()!=null){
        lineTotalVar=Double.parseDouble(valueChangeEvent.getNewValue().toString());
//            sum -= lineTotalVarOldValue;
//            sum += lineTotalVar;
//            lineTotalSum.setValue(df.format(sum));
//            System.out.println("lineTotalVarOldValue"+lineTotalVarOldValue);
//            System.out.println("Sum of line total----"+sum);
//            System.out.println("lineTotalVar****"+lineTotalVar);
            calculateTaxAmount(lineTotalVar);
        }
//        else if(valueChangeEvent.getNewValue()==null){
//
//            sum -= lineTotalVarOldValue;
//            lineTotalSum.setValue(df.format(sum));
//            System.out.println("lineTotalVarOldValue when new value null" + lineTotalVarOldValue);
//            }

        //recalculateLineAndTaxTotal_onTabout();
    }


    private void calculateTaxAmount(double lineTotal) {

        oracle.jbo.domain.Number taxRateLineItem=null;
        double lineTot=0;
        double taxRatecal=0;

            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("TaxRateCodeLookupVO1Iterator");
            ViewObjectImpl taxRateCodeLookupVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
            ViewCriteria vc = null;
            String taxRateCode = null;
            String siteId = null;
            try{
                RowKeySet rowKeySet = lineItemsTable.getSelectedRowKeys();
                Iterator rowKeySetIt = rowKeySet.iterator();
                DCIteratorBinding lineItemIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");
                RowSetIterator lineItemRSIter=null;
                Row currentRow=null;
                try{
                    lineItemRSIter = lineItemIter.getRowSetIterator();

                 while(rowKeySetIt.hasNext()){
                   Key key = (Key)((List)rowKeySetIt.next()).get(0);
                   currentRow = lineItemRSIter.getRow(key);
                     if(currentRow!=null) {
                        System.out.println("----- TaxRateCode ----- "+currentRow.getAttribute("TaxRateCode"));
                        taxRateCode = currentRow.getAttribute("TaxRateCode")==null?"":currentRow.getAttribute("TaxRateCode").toString().trim();
                     }
                 }
                }catch(Exception e)
                {e.printStackTrace();
                 }
                /*finally{
                            if(lineItemRSIter!=null) {
                                try {
                                    lineItemRSIter.closeRowSetIterator();
                                } catch(Exception ex) {
                                    ex.printStackTrace();

                            }
                            }
                        }*/
                taxRateCode =  AdfFacesContext.getCurrentInstance().getPageFlowScope().get("TaxRateCodePS")==null ? null :  AdfFacesContext.getCurrentInstance().getPageFlowScope().get("TaxRateCodePS").toString();
                System.out.println("b4 if taxRateCode*******"+taxRateCode);
                if(taxRateCode!=null){
                System.out.println("taxRateCode*******"+taxRateCode);
                }
                if(siteIdIt.getValue()!=null) {
                   siteId = ""+((oracle.jbo.domain.Number)siteIdIt.getValue()).getValue();
                }
                taxRateCode = taxRateCode==null ? "" : taxRateCode.trim();
                siteId = siteId==null ? "" : siteId.trim();

                System.out.println("siteIdIt.getValue(): "+siteId);
                System.out.println("TaxRateCode ="+ taxRateCode);

                //If Site id is present

                if(siteId!=null && !siteId.trim().equals("")) {
                                vc = taxRateCodeLookupVO.getViewCriteria("TaxRateCodeLookupVOCriteria_lookupBySiteId");
                                taxRateCodeLookupVO.applyViewCriteria(vc);
                                taxRateCodeLookupVO.setNamedWhereClauseParam("bind_siteId",siteId);
                                taxRateCodeLookupVO.setNamedWhereClauseParam("bind_taxRateCode",taxRateCode);
                                taxRateCodeLookupVO.executeQuery();
                                System.out.println("taxRateCodeLookupVO.getEstimatedRowCount()******************"+taxRateCodeLookupVO.getEstimatedRowCount());

                }

                System.out.println("taxRateCodeLookupVO.getEstimatedRowCount()"+taxRateCodeLookupVO.getEstimatedRowCount());
                            String taxRate=null;
                            if (taxRateCodeLookupVO.getEstimatedRowCount() > 0 && !(taxRateCode==null || (taxRateCode!=null && taxRateCode.trim().equals("")))) {
                               System.out.println("taxRateCodeLookupVO.getEstimatedRowCount()"+taxRateCodeLookupVO.getEstimatedRowCount());
                               RowSetIterator rsi=null;
                               try{
                                   rsi = taxRateCodeLookupVO.createRowSetIterator(null);
                               while (rsi.next() != null) {
                                   Row taxRow = rsi.getCurrentRow();
                                   System.out.println("TaxRate ::"+taxRow.getAttribute("TaxRate"));
                                   taxRate=taxRow.getAttribute("TaxRate").toString();
                                   System.out.println("Within While taxRate"+taxRate);

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
                              // rsi.closeRowSetIterator();
                            }else{
                                System.out.println("***  taxRate :: ***");

                            }


                lineTot=lineTotal;

                if(taxRate!=null){
                try{

                    taxRatecal=Double.parseDouble(taxRate);
                    taxRatecal=(lineTot*taxRatecal)/100;
                    System.out.println("taxRatecal*******"+taxRatecal);
                    taxRateLineItem=new oracle.jbo.domain.Number(taxRatecal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("taxRateLineItem**************"+taxRateLineItem);

                if(taxRateLineItem!=null) {
                    //currentRow.setAttribute("Attr1",taxRateLineItem);
                    BigDecimal decimalValue = new BigDecimal(taxRateLineItem.doubleValue());
                    decimalValue = decimalValue.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    try {
                        currentRow.setAttribute("TaxAmountLineitem",new oracle.jbo.domain.Number(decimalValue.doubleValue()));
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                    AdfFacesContext.getCurrentInstance().addPartialTarget(taxAmountIt);
                }
                }

            }
            catch(Exception e) {
                e.printStackTrace();
            }

    }


    public BigDecimal taxamountStaticCalculation(String valueChangeEvent) {

      String  taxRateCode = null;
        BigDecimal taxRate = null;
        if(valueChangeEvent!=null){
        taxRateCode=valueChangeEvent;
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("TaxRateCodePS", taxRateCode);

        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("TaxRateCodeLookupVO1Iterator");
        ViewObjectImpl taxRateCodeLookupVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
        ViewCriteria vc = null;
        String siteId = null;
        try{
            if(siteIdIt.getValue()!=null) {
               siteId = ""+((oracle.jbo.domain.Number)siteIdIt.getValue()).getValue();
            }
            taxRateCode = taxRateCode==null ? "" : taxRateCode.trim();
            siteId = siteId==null ? "" : siteId.trim();

            System.out.println("siteIdIt.getValue(): "+siteId);
            System.out.println("TaxRateCode ="+ taxRateCode);

            //If Site id is present

            if(siteId!=null && !siteId.trim().equals("")) {
                vc = taxRateCodeLookupVO.getViewCriteria("TaxRateCodeLookupVOCriteria_lookupBySiteId");
                taxRateCodeLookupVO.applyViewCriteria(vc);
                taxRateCodeLookupVO.setNamedWhereClauseParam("bind_siteId",siteId);
                taxRateCodeLookupVO.setNamedWhereClauseParam("bind_taxRateCode",taxRateCode);
                taxRateCodeLookupVO.executeQuery();
            }
            RowKeySet rowKeySet = lineItemsTable.getSelectedRowKeys();
            Iterator rowKeySetIt = rowKeySet.iterator();
            DCIteratorBinding lineItemIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");
            RowSetIterator lineItemRSIter=null;
            try{
                lineItemRSIter = lineItemIter.getRowSetIterator();
            while(rowKeySetIt.hasNext()){
              Key key = (Key)((List)rowKeySetIt.next()).get(0);
              Row currentRow = lineItemRSIter.getRow(key);
              //System.out.println("current row :: "+ currentRow);
              if(currentRow!=null) {
                //System.out.println("current row not null ............................");
                try {
                  if(taxRateCodeLookupVO.getEstimatedRowCount() == 1){
                    Row row = taxRateCodeLookupVO.first();
                    taxRate = row.getAttribute("TaxRate") == null ? null : (java.math.BigDecimal)row.getAttribute("TaxRate");
                    currentRow.setAttribute("TaxRate", taxRate == null ? null : new oracle.jbo.domain.Number(taxRate.doubleValue()));

                  }
                  else{
                    currentRow.setAttribute("TaxRate", null);
                  }
                }
                catch(Exception ex) {
                ex.printStackTrace();
                }
              }
            }
            }catch(Exception e)
            {
                e.printStackTrace();
                }
            /*finally{
                        if(lineItemRSIter!=null) {
                            try {
                                lineItemRSIter.closeRowSetIterator();
                            } catch(Exception ex) {
                                ex.printStackTrace();

                        }
                        }
                    }*/

        }
        catch(Exception e) {
        e.printStackTrace();
        }
        }
        else{
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("TaxRateCodePS", null);
        }
        //recalculateLineAndTaxTotal_onTabout();

        System.out.println("TaxRateCodePS calculateTaxAmountFromTaxRateCode"+AdfFacesContext.getCurrentInstance().getPageFlowScope().get("TaxRateCodePS"));
        return taxRate;

    }

    public void calculateTaxAmountFromTaxRateCode(ValueChangeEvent valueChangeEvent) {

        System.out.println("Within calculateTaxAmountFromTaxRateCode**");
          String taxRateCode =null;
          BigDecimal taxRate = null;
          if(valueChangeEvent.getNewValue()!=null){
          taxRateCode=valueChangeEvent.getNewValue().toString();
          AdfFacesContext.getCurrentInstance().getPageFlowScope().put("TaxRateCodePS", taxRateCode);

          DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
          DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("TaxRateCodeLookupVO1Iterator");
          ViewObjectImpl taxRateCodeLookupVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
          ViewCriteria vc = null;
          String siteId = null;
          try{
              if(siteIdIt.getValue()!=null) {
                 siteId = ""+((oracle.jbo.domain.Number)siteIdIt.getValue()).getValue();
              }
              taxRateCode = taxRateCode==null ? "" : taxRateCode.trim();
              siteId = siteId==null ? "" : siteId.trim();

              System.out.println("siteIdIt.getValue(): "+siteId);
              System.out.println("TaxRateCode ="+ taxRateCode);

              //If Site id is present

              if(siteId!=null && !siteId.trim().equals("")) {
                  vc = taxRateCodeLookupVO.getViewCriteria("TaxRateCodeLookupVOCriteria_lookupBySiteId");
                  taxRateCodeLookupVO.applyViewCriteria(vc);
                  taxRateCodeLookupVO.setNamedWhereClauseParam("bind_siteId",siteId);
                  taxRateCodeLookupVO.setNamedWhereClauseParam("bind_taxRateCode",taxRateCode);
                  taxRateCodeLookupVO.executeQuery();
              }
              RowKeySet rowKeySet = lineItemsTable.getSelectedRowKeys();
              Iterator rowKeySetIt = rowKeySet.iterator();
              DCIteratorBinding lineItemIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");
              RowSetIterator lineItemRSIter=null;
              try{
                  lineItemRSIter = lineItemIter.getRowSetIterator();
              while(rowKeySetIt.hasNext()){
                Key key = (Key)((List)rowKeySetIt.next()).get(0);
                Row currentRow = lineItemRSIter.getRow(key);
                System.out.println("current row :: "+ currentRow);
                if(currentRow!=null) {
                  System.out.println("current row not null ............................");
                  try {
                    if(taxRateCodeLookupVO.getEstimatedRowCount() == 1){
                      Row row = taxRateCodeLookupVO.first();
                      taxRate = row.getAttribute("TaxRate") == null ? null : (java.math.BigDecimal)row.getAttribute("TaxRate");
                      currentRow.setAttribute("TaxRate", taxRate == null ? null : new oracle.jbo.domain.Number(taxRate.doubleValue()));

                    }
                    else{
                      currentRow.setAttribute("TaxRate", null);
                    }
                  }
                  catch(Exception ex) {
                  ex.printStackTrace();
                  }
                }
              }
              }catch(Exception e)
              {
                  e.printStackTrace();
                  }
              /*finally{
                          if(lineItemRSIter!=null) {
                              try {
                                  lineItemRSIter.closeRowSetIterator();
                              } catch(Exception ex) {
                                  ex.printStackTrace();

                          }
                          }
                      }*/

          }
          catch(Exception e) {
          e.printStackTrace();
          }
          }
          else{
          AdfFacesContext.getCurrentInstance().getPageFlowScope().put("TaxRateCodePS", null);
          }
          //recalculateLineAndTaxTotal_onTabout();
          AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
          System.out.println("TaxRateCodePS calculateTaxAmountFromTaxRateCode"+AdfFacesContext.getCurrentInstance().getPageFlowScope().get("TaxRateCodePS"));

      }
    public void setReasonTypeSoc(RichSelectOneChoice reasonTypeSoc) {
        this.reasonTypeSoc = reasonTypeSoc;
    }

    public RichSelectOneChoice getReasonTypeSoc() {
        return reasonTypeSoc;
    }

    public void setSupplierName(RichInputText supplierName) {
        this.supplierName = supplierName;
    }

    public RichInputText getSupplierName() {
        return supplierName;
    }

    public void ReassignComments(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void onReassignComments(ActionEvent actionEvent) {
        // Add event code here...
               System.out.println("Start onReassignComments");
                String commentsVal = null;
                try {
                    if(reassignCommentsText.getValue() != null)
                        commentsVal = reassignCommentsText.getValue().toString();
                    //System.out.println("commentsVal: "+commentsVal);
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    disabledReassignmentInputText.setValue(commentsVal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(disabledReassignmentInputText);
                    reassignmentDisabledPopoUp.show(hints);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                System.out.println("End onReassignComments");
    }

    public void setReassignCommentsText(RichInputText reassignCommentsText) {
        this.reassignCommentsText = reassignCommentsText;
    }

    public RichInputText getReassignCommentsText() {
        return reassignCommentsText;
    }

    public void setReassignmentDisabledPopoUp(RichPopup reassignmentDisabledPopoUp) {
        this.reassignmentDisabledPopoUp = reassignmentDisabledPopoUp;
    }

    public RichPopup getReassignmentDisabledPopoUp() {
        return reassignmentDisabledPopoUp;
    }

    public void setDisabledReassignmentInputText(RichInputText disabledReassignmentInputText) {
        this.disabledReassignmentInputText = disabledReassignmentInputText;
    }

    public RichInputText getDisabledReassignmentInputText() {
        return disabledReassignmentInputText;
    }

    public void onDisablePopupOk(ActionEvent actionEvent) {
        System.out.println("Start onDisablePopupOk");
        String commentsVal = null;
        try {
            reassignmentDisabledPopoUp.hide();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onDisablePopupOk");
    }

    public void onCertifierApproveComments(ActionEvent actionEvent) {
        System.out.println("Start onCertifierApproveComments");
         String commentsVal = null;
         try {
             if(certifierApproveComments.getValue() != null)
                 commentsVal = certifierApproveComments.getValue().toString();
             //System.out.println("commentsVal: "+commentsVal);
             RichPopup.PopupHints hints = new RichPopup.PopupHints();
             certifierApprovePopupIt.setValue(commentsVal);
             AdfFacesContext.getCurrentInstance().addPartialTarget(certifierApprovePopupIt);
             certifierApprovePopup.show(hints);
         }
         catch(Exception e) {
             e.printStackTrace();
         }
         System.out.println("End onCertifierApproveComments");
    }

    public void setCertifierApproveComments(RichInputText certifierApproveComments) {
        this.certifierApproveComments = certifierApproveComments;
    }

    public RichInputText getCertifierApproveComments() {
        return certifierApproveComments;
    }

    public void setCertifierApprovePopup(RichPopup certifierApprovePopup) {
        this.certifierApprovePopup = certifierApprovePopup;
    }

    public RichPopup getCertifierApprovePopup() {
        return certifierApprovePopup;
    }

    public void setCertifierApprovePopupIt(RichInputText certifierApprovePopupIt) {
        this.certifierApprovePopupIt = certifierApprovePopupIt;
    }

    public RichInputText getCertifierApprovePopupIt() {
        return certifierApprovePopupIt;
    }

    public void oncertifierApprovePopupOKClick(ActionEvent actionEvent) {
        System.out.println("Start oncertifierApprovePopupOKClick");
        String commentsVal = null;
        try {
            if(certifierApprovePopupIt.getValue() != null)
                commentsVal = certifierApprovePopupIt.getValue().toString();
            //System.out.println("commentsPopupIt: "+certifierApprovePopupIt);
            certifierApproveComments.setValue(commentsVal);
            certifierApprovePopup.hide();
            AdfFacesContext.getCurrentInstance().addPartialTarget(certifierApproveComments);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End oncertifierApprovePopupOKClick");
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

    public void calculateTaxAmountSum(ValueChangeEvent valueChangeEvent) {
        System.out.println("Inside calculateTaxAmountSum");


    }


	//net-worth : @7000AUD as of July2-2016
    public void onSaveClick(ActionEvent actionEvent) {
        // Add event code here...
        //APOperationAMImpl aMImpl = getAm();
        String alternateApprover=null;

        if(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("approverID")!=null){
            System.out.println("get Approver ID:::::"+AdfFacesContext.getCurrentInstance().getPageFlowScope().get("approverID"));
            //alternateApprover=alternateApproverIt.getValue()==null ? "" : alternateApproverIt.getValue().toString();
            alternateApprover=alternateApproverIt.getValue()==null ? "" : AdfFacesContext.getCurrentInstance().getPageFlowScope().get("approverID").toString();
        }

        System.out.println("Alternate Approver "+alternateApprover);
        Utility.getAm().saveOperationCertifierPage(resolveExpression("#{bindings.invoiceID.inputValue}").toString(),alternateApprover);

        Utility.getAm().getDBTransaction().commit();
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        validationErrorPopup.show(hints);


        /*clearing comments*/
        //System.out.println("Clearingg comments on save action in order to avoid duplicacy :: ");
        commentsIt.setValue("");
        AdfFacesContext.getCurrentInstance().addPartialTarget(commentsIt);
        //System.out.println("done clearing comments on save action in order to avoid duplicacy :: ");
        /*clearing comments*/


        this.validationErrorMessage.setValue("Record has been Saved Successfully");
    }
    public boolean validatelineDescription(){
            RowSetIterator lineItemItr = null;
            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
            ViewObjectImpl lineVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
            String invNum = null;
            if(invNumIt.getValue()!=null){
            invNum = (String)invNumIt.getValue();
            }
            System.out.println("invNum: "+invNum+"     ------------Inside validatelineDescription()");
            lineItemItr = lineVO.createRowSetIterator(null);
            String message= null;
            Integer line;
//            boolean validateFlag = true;
            while(lineItemItr.hasNext()) {
             //System.out.println("LineDescription within while");
             Row lineRow = lineItemItr.next();
             //System.out.println("LineDescription within line row");
             if(lineRow.getAttribute("LineDescription")==null || lineRow.getAttribute("LineDescription").equals("")) {
//                 validateFlag = false;
                 //System.out.println("LineDescription is not present");
                 line = ((oracle.jbo.domain.Number)lineRow.getAttribute("LineNumber")).intValue();
                 message="Please enter the line description on the invoice line "+ line +"";
                 callFacesMessage(message);
                 return true;
             }
                //923018-New validation message on quantity ,unit price and line Total
                                if(lineRow.getAttribute("UnitPrice")!=null  && lineRow.getAttribute("Quantity")!=null  && lineRow.getAttribute("LineTotalAmount")!=null ) {

                                    double lineItems_TotalAmount =  Double.parseDouble(lineRow.getAttribute("LineTotalAmount").toString().trim());
                                    double lineItems_Quantity = Double.parseDouble(lineRow.getAttribute("Quantity").toString().trim()) ;
                                    double lineItems_Unit = Double.parseDouble(lineRow.getAttribute("UnitPrice").toString().trim());
                                    double match_Total=lineItems_Quantity*lineItems_Unit;
                                    System.out.println("match_Total inside validatelineDescription ::: "+match_Total+"  Line Total **: "+lineItems_TotalAmount+", lineItems_Quantity ** : "+ lineItems_Quantity+", lineItems_Unit **: "+lineItems_Unit);
                                    if(match_Total != lineItems_TotalAmount){
                                           Integer line1 = ((oracle.jbo.domain.Number)lineRow.getAttribute("LineNumber")).intValue();
                                       String message1 =  "Line Total should match to Unit Price*Qantity in "
                                                             + "Line Number : "+line1;
                                                                 callFacesMessage(message1);
                                                                 return true;
                                        }

                                }
                                //923018-New validation message on quantity ,unit price and line Total
            }
            return false;
        }

    public void setSiteName(RichInputText siteName) {
        this.siteName = siteName;
    }

    public RichInputText getSiteName() {
        return siteName;
    }

    public boolean validateTaxAmount() {
        String invNum = null;
        if(invNumIt.getValue()!=null){
        invNum = (String)invNumIt.getValue();
        }
        System.out.println("invNum: "+invNum+" Inside validateTaxAmount");
        RowSetIterator lineItemItr = null;
        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObjectImpl lineVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
        //System.out.println("------------lineVO Count validatelineDescription(): "+lineVO.getEstimatedRowCount());
        lineItemItr = lineVO.createRowSetIterator(null);
        String message= null;
        Integer line;
        boolean flag = true;

        while(lineItemItr.hasNext()) {

         Row lineRow = lineItemItr.next();
         String taxRateCode = lineRow.getAttribute("TaxRateCode")==null?"":(String)lineRow.getAttribute("TaxRateCode");

         if(!((lineRow.getAttribute("LineTotalAmount")==null || lineRow.getAttribute("LineTotalAmount").equals(""))&& taxRateCode.equals(""))) {

             BigDecimal taxRate = PropertyLoader.getInstance().getTaxRatesMasterList().get(taxRateCode);

             /**Added on 2nd May 2018**/

            /* if(taxRate == null){
                 throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please enter valid Tax Rate Code",null));
             */

             /**Ended on 2nd May 2018**/

             double taxRateVal = taxRate.doubleValue();
             System.out.println("invNum: "+invNum+"  tax rate  ======= "+ taxRateVal);

             double lineTotal = Double.parseDouble(lineRow.getAttribute("LineTotalAmount").toString().trim());
             double correctTaxAmount = (taxRateVal*lineTotal)/100;
             oracle.jbo.domain.Number taxRateLineItem = null;
             try {
                taxRateLineItem = new oracle.jbo.domain.Number(correctTaxAmount);
             } catch (SQLException e) {
                e.printStackTrace();
             }
             BigDecimal decimalValue = new BigDecimal(taxRateLineItem.doubleValue());
             decimalValue = decimalValue.setScale(2, BigDecimal.ROUND_HALF_EVEN);
             correctTaxAmount = decimalValue.doubleValue();
             System.out.println("invNum: "+invNum+"   Correct Tax Amount :"+correctTaxAmount);

             if(!(lineRow.getAttribute("TaxAmountLineitem")==null || lineRow.getAttribute("TaxAmountLineitem").toString().trim().equals(""))){

                 double enteredTaxAmount = Double.parseDouble(lineRow.getAttribute("TaxAmountLineitem").toString());
                 oracle.jbo.domain.Number amount = null;
                    try {
                        amount = new oracle.jbo.domain.Number(enteredTaxAmount);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    BigDecimal decimalValue1 = new BigDecimal(amount.doubleValue());
                 decimalValue1 = decimalValue1.setScale(2, BigDecimal.ROUND_HALF_EVEN);

                 double incorrectTaxAmount = decimalValue1.doubleValue();
                 //System.out.println("INcorrect Tax Amount :"+incorrectTaxAmount);
                 System.out.println("invNum: "+invNum+"   Max Range: "+(correctTaxAmount+1)+" Min Range :"+(correctTaxAmount-1));
                 if(!(incorrectTaxAmount<=correctTaxAmount+1 && incorrectTaxAmount>=correctTaxAmount-1)){
                     flag = false;
                     line = ((oracle.jbo.domain.Number)lineRow.getAttribute("LineNumber")).intValue();
                     message="The tax amount entered in "+line+" is not in line with the tax rate code. Please split the lines accordingly with tax amount and tax rates";
                     callFacesMessage(message);
                     break;
                 }
             }
         }
        }

        return flag;
    }

    public void saveCertifierRejectComments(String invoiceID,String commentsDate,String rejectComment,String name) {


         System.out.println("Start : saveCertifierRejectComments");
         //System.out.println("Invoice ID in saveCertifierRejectComments" + invoiceID);
         try{
             BindingContext bctx = BindingContext.getCurrent();
             BindingContainer bindings = bctx.getCurrentBindingsEntry();
             OperationBinding operationBinding =  bindings.getOperationBinding("addCommentsTableRow");

             operationBinding.getParamsMap().put("invoiceID",invoiceID);
             operationBinding.getParamsMap().put("commentsDate",commentsDate);
             operationBinding.getParamsMap().put("description",rejectComment);
             operationBinding.getParamsMap().put("name",name);
             operationBinding.getParamsMap().put("category","Certifier Rejection");
             operationBinding.execute();
             DCBindingContainer bindings2 =
                         (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

             AdfFacesContext.getCurrentInstance().addPartialTarget(apCommentsTable);

         }catch(Exception e){
             e.printStackTrace();
         }


         System.out.println("End : saveCertifierRejectComments");

     }

    public void setApCommentsTable(RichTable apCommentsTable) {
        this.apCommentsTable = apCommentsTable;
    }

    public RichTable getApCommentsTable() {
        return apCommentsTable;
    }

    public void saveCertifierReassignComments(String invoiceID,String commentsDate,String reassignComments,String name) {

                System.out.println("Start : saveCertifierReassignComments");
                System.out.println("Invoice ID in saveCertifierReassignComments" + invoiceID);
                try{
                    BindingContext bctx = BindingContext.getCurrent();
                    BindingContainer bindings = bctx.getCurrentBindingsEntry();
                    OperationBinding operationBinding =  bindings.getOperationBinding("addCommentsTableRow");

                    operationBinding.getParamsMap().put("invoiceID",invoiceID);
                    operationBinding.getParamsMap().put("commentsDate",commentsDate);
                    operationBinding.getParamsMap().put("description",reassignComments);
                    operationBinding.getParamsMap().put("name",name);
                    operationBinding.getParamsMap().put("category","Certifier Reassign");
                    operationBinding.execute();
                    DCBindingContainer bindings2 =
                                (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

                    AdfFacesContext.getCurrentInstance().addPartialTarget(apCommentsTable);

                }catch(Exception e){
                    e.printStackTrace();
                }


                System.out.println("End : saveCertifierReassignComments");

    }

    public void onCommentsTableDescClick(ActionEvent actionEvent) {
        System.out.println("Start onCommentsTableDescClick");
        String commentsVal = null;
        DCBindingContainer bindings = getBinding();
        DCIteratorBinding commentsTableIter = bindings.findIteratorBinding("ApCommentsTableVO1Iterator");
        //System.out.println("commentsTableIter ::"+commentsTableIter);
        ViewObject commentsVO = commentsTableIter.getViewObject();
        Row selectedRow=commentsVO.getCurrentRow();
        //System.out.println("selectedRow :: "+selectedRow);
        if (selectedRow!=null){
                try {
                    if(selectedRow.getAttribute("Description")!=null)
                    commentsVal = selectedRow.getAttribute("Description").toString();
                    //System.out.println("commentsVal****: "+commentsVal);
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    apCommentsTableDescPopUpIt.setValue(commentsVal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(apCommentsTableDescPopUpIt);
                    apCommentsTableDescPopup.show(hints);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                }
        System.out.println("End onCommentsTableDescClick");
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

    public void onApCommentsTableDescriptionPopupOKClick(ActionEvent actionEvent) {

            System.out.println("Start onApCommentsTableDescriptionPopupOKClick");
            apCommentsTableDescPopup.hide();

            System.out.println("End onApCommentsTableDescriptionPopupOKClick");

    }

    public void setSumOfLineTotal(RichOutputText sumOfLineTotal) {
        this.sumOfLineTotal = sumOfLineTotal;
    }

    public RichOutputText getSumOfLineTotal() {
        return sumOfLineTotal;
    }

    public void setSumOfTaxTotal(RichOutputText sumOfTaxTotal) {
        this.sumOfTaxTotal = sumOfTaxTotal;
    }

    public RichOutputText getSumOfTaxTotal() {
        return sumOfTaxTotal;
    }
    public void setSubCheckBox(RichSelectBooleanCheckbox subCheckBox) {
        this.subCheckBox = subCheckBox;
    }

    public RichSelectBooleanCheckbox getSubCheckBox() {
        return subCheckBox;
    }

    public void setParentCheckBox(RichSelectBooleanCheckbox parentCheckBox) {
        this.parentCheckBox = parentCheckBox;
    }

    public RichSelectBooleanCheckbox getParentCheckBox() {
        return parentCheckBox;
    }

    public void selectAllCheckBoxVCL(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        try {
                   System.out.println("xdebug c1 : In selectAllChoiceBoxLN with value = " +
                                      valueChangeEvent.getNewValue());
                   //        boolean isSelected = valueChangeEvent.getNewValue();
                   //        boolean isSelected = ((Boolean)valueChangeEvent.getNewValue()).booleanValue();
                   String selectedVal = null;
                   selectedVal = valueChangeEvent.getNewValue().toString();
                   //System.out.println("xdebug c2: selectedVal : " + selectedVal);

                   BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
                   DCIteratorBinding lineItemiter = (DCIteratorBinding) bindings.get("LineItemDetailsEOView1Iterator");

                   ViewObject lineItemVo = lineItemiter.getViewObject();
                   //System.out.println("line count"+lineItemVo.getEstimatedRowCount());

                   RowSetIterator lineItemrsi = lineItemVo.createRowSetIterator(null);
                   if(lineItemrsi!=null){
                   int i = 0;
                   Row row = null;
                   lineItemrsi.reset();

                   while (lineItemrsi.hasNext()) {
                       //System.out.println("within while");
                       if (i == 0){
                           row = lineItemrsi.first();
                           //System.out.println("line number of selected rows::"+row.getAttribute("LineNumber"));
                       }
                       else{
                           row = lineItemrsi.next();
                           //System.out.println("line number of else selected rows::"+row.getAttribute("LineNumber"));
                       }

                       if (selectedVal.equals("true")){
                           //System.out.println("within if block");
                           row.setAttribute("isSelected", "Y");
                       }
                       else{
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

    public void selectSingleCheckBox(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        try {
                    System.out.println(" In selectSingleCheckBox with value = " +
                                       valueChangeEvent.getNewValue());
                    //        boolean isSelected = valueChangeEvent.getNewValue();
                    //        boolean isSelected = ((Boolean)valueChangeEvent.getNewValue()).booleanValue();
                    String selectedVal = null;
                    selectedVal = valueChangeEvent.getNewValue().toString();
                    //System.out.println(" selectedVal : " + selectedVal);

                    BindingContainer bindings =
                        BindingContext.getCurrent().getCurrentBindingsEntry();
                    DCIteratorBinding lineItemiter =
                        (DCIteratorBinding)bindings.get("LineItemDetailsEOView1Iterator");

                    ViewObject lineItemVo = lineItemiter.getViewObject();
                    System.out.println("line count" +
                                       lineItemVo.getEstimatedRowCount());
                    Row row = null;
                    row = lineItemVo.getCurrentRow();

                    if (selectedVal.equals("true")) {
                        //System.out.println("within if block");
                        row.setAttribute("isSelected", "Y");
                    } else {
                        //System.out.println("within else block");
                        row.setAttribute("isSelected", "N");
                    }
                } catch (Exception e) {
                    // TODO: Add catch code
                    e.printStackTrace();
                }
    }


    public void updateStatus(String internalStatus,String comments){
        System.out.println("Start : updateStatus");
        try{
            if(comments!=null){
                System.out.println("comments updateStatus:: "+comments);

            }
        Utility.getAm().updateInternalStatus(resolveExpression("#{bindings.invoiceID.inputValue}").toString(), internalStatus);
     //Utility.getAm().updateHoldReleaseComments(resolveExpression("#{bindings.invoiceID.inputValue}").toString(),(internalStatus+":"+ comments));
     Utility.getAm().updateHoldReleaseComments(resolveExpression("#{bindings.invoiceID.inputValue}").toString(),(comments));





        Object docId = resolveExpression("#{bindings.attr1.inputValue}");
        //System.out.println(" --- Updating Webcenter IPM --- docId : "+(docId==null?"":docId.toString()));
        DocumentService docUpdateService = new DocumentService_Service().getDocumentServicePort();
         BindingProvider bindingProvider = (BindingProvider)docUpdateService;
         @SuppressWarnings("rawtypes")
         List<Handler> handlerChain = new ArrayList<Handler>();
         handlerChain.add(new WSSecurityHeaderSOAPHandler(
                                  resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGING_DOCUMENT_SERVICE_USERNAME']}").toString(),
                                  resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGING_DOCUMENT_SERVICE_PASSWORD']}").toString()
                              )
                         );
         bindingProvider.getBinding().setHandlerChain(handlerChain);
         List<FieldValue> fieldValues = new ArrayList<FieldValue>();


        FieldValue fieldValue1 = new FieldValue();
        fieldValue1.setName("Internal Status");
        TypedValue typedValue1 = new TypedValue();
        typedValue1.setType( FieldType.TEXT );
        typedValue1.setValue( internalStatus );
        fieldValue1.setValue(typedValue1);
        //System.out.println("Supplier Name update success");

        fieldValues.add(fieldValue1);

        docUpdateService.updateDocument(new Holder<String>(docId==null?"":docId.toString()), null, fieldValues, false);
        //System.out.println(" --- Updating Webcenter IPM successful ---");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("End : updateStatus");
    }

    public void holdTaskWithExpiry(ActionEvent actionEvent) {
        System.out.println("Start : holdTaskWithExpiry");
        //add comments in the comments table
        String name = getAPGroupUserName();
        String comments = null;
        if (holdCommentsIt.getValue() != null) {
            comments = holdCommentsIt.getValue().toString();
        }
        try{
                     BindingContext bctx = BindingContext.getCurrent();
                     BindingContainer bindings = bctx.getCurrentBindingsEntry();
                     OperationBinding operationBinding =  bindings.getOperationBinding("addCommentsTableRow");

                     operationBinding.getParamsMap().put("invoiceID",getInvoiceId());
                     operationBinding.getParamsMap().put("commentsDate",null);
                     operationBinding.getParamsMap().put("description",comments);
                     operationBinding.getParamsMap().put("name",name);
                     operationBinding.getParamsMap().put("category","Hold");
                     operationBinding.execute();
                     DCBindingContainer bindings2 =
                                 (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

                     AdfFacesContext.getCurrentInstance().addPartialTarget(apCommentsTable);

                 }catch(Exception e){
                     e.printStackTrace();
                 }

        // update status in transaction table and ecm
       String internalStatus = "Invoice on Hold";
        //updateStatus(internalStatus ,holdCommentsIt.getValue()!=null ?holdCommentsIt.getValue().toString():null);
        updateStatus(internalStatus,"Invoice on Hold :"+(holdCommentsIt.getValue()!=null ?holdCommentsIt.getValue().toString():null));


      FacesContext context = FacesContext.getCurrentInstance();
      String ctx = (String)context.getApplication().evaluateExpressionGet(context,"#{pageFlowScope.bpmWorklistContext}",String.class);

      String taskId = (String)context.getApplication().evaluateExpressionGet(context,"#{pageFlowScope.bpmWorklistTaskId}",String.class);

      System.out.println("----- bpmWorklistContext : "+ctx+", bpmWorklistTaskId : "+taskId);

      try {
          TaskService_Service service = new TaskService_Service();

          TaskServiceContextTaskTaskIdBaseType taskServiceContextTaskTaskIdBaseType =
              new TaskServiceContextTaskTaskIdBaseType();

          //taskServiceContextTaskTaskIdBaseType.setTaskId("465a3192-3652-4312-b69d-ef3a977cf2c1");
          taskServiceContextTaskTaskIdBaseType.setTaskId(taskId);

          WorkflowContextType workflowContextType =
              new WorkflowContextType();

          CredentialType credentialType = new CredentialType();
      //            credentialType.setLogin("eqadmin");
      //            credentialType.setPassword("weblogic1");
           credentialType.setLogin(resolveExpression("#{ApOperationBean.propertyLoader.properties['BPM_WORKSPACE_USERNAME']}").toString());
          credentialType.setPassword(resolveExpression("#{ApOperationBean.propertyLoader.properties['BPM_WORKSPACE_PASSWORD']}").toString());
          workflowContextType.setCredential(credentialType);


          taskServiceContextTaskTaskIdBaseType.setWorkflowContext(workflowContextType);

          service.getTaskServicePort().suspendTimers(taskServiceContextTaskTaskIdBaseType);


          //service.getTaskServicePort().resumeTimers(taskServiceContextTaskTaskIdBaseType);
          System.out.println("Done");
      } catch (StaleObjectFaultMessage sofm) {
          // TODO: Add catch code
          sofm.printStackTrace();
      } catch (WorkflowErrorMessage wem) {
          // TODO: Add catch code
          wem.printStackTrace();
      }

        p20.hide();
        holdButton.setVisible(false);
        releaseButton.setVisible(true);
        autoFillButton.setDisabled(true);
        rejectButton.setDisabled(true);
        reassignButton.setDisabled(true);
        saveButton.setDisabled(true);
        submitButton.setDisabled(true);
        System.out.println("End : holdTaskWithExpiry");
    }

    public void releaseTaskWithExpiry(ActionEvent actionEvent) {
        System.out.println("Start : releaseTaskWithExpiry");
        //add comments in the comments table
        String name = getAPGroupUserName();
        String comments = null;
        if (releaseCommentsIt.getValue() != null) {
            comments = releaseCommentsIt.getValue().toString();
        }
        try{
                     BindingContext bctx = BindingContext.getCurrent();
                     BindingContainer bindings = bctx.getCurrentBindingsEntry();
                     OperationBinding operationBinding =  bindings.getOperationBinding("addCommentsTableRow");

                     operationBinding.getParamsMap().put("invoiceID",getInvoiceId());
                     operationBinding.getParamsMap().put("commentsDate",null);
                     operationBinding.getParamsMap().put("description",comments);
                     operationBinding.getParamsMap().put("name",name);
                     operationBinding.getParamsMap().put("category","Resume");
                     operationBinding.execute();
                     DCBindingContainer bindings2 =
                                 (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();

                     AdfFacesContext.getCurrentInstance().addPartialTarget(apCommentsTable);

                 }catch(Exception e){
                     e.printStackTrace();
                 }

        // update status in transaction table and ecm
        String internalStatus = "INVOICE PENDING FOR CERTIFICATION";
        //updateStatus(internalStatus,releaseCommentsIt.getValue()!=null ?releaseCommentsIt.getValue().toString():null);
        updateStatus(internalStatus,"Invoice Released :"+(releaseCommentsIt.getValue()!=null ?releaseCommentsIt.getValue().toString():null));
      FacesContext context = FacesContext.getCurrentInstance();
      String ctx = (String)context.getApplication().evaluateExpressionGet(context,"#{pageFlowScope.bpmWorklistContext}",String.class);

      String taskId = (String)context.getApplication().evaluateExpressionGet(context,"#{pageFlowScope.bpmWorklistTaskId}",String.class);

      System.out.println("----- bpmWorklistContext : "+ctx+", bpmWorklistTaskId : "+taskId);

      try {
          TaskService_Service service = new TaskService_Service();

          TaskServiceContextTaskTaskIdBaseType taskServiceContextTaskTaskIdBaseType =
              new TaskServiceContextTaskTaskIdBaseType();

          //taskServiceContextTaskTaskIdBaseType.setTaskId("465a3192-3652-4312-b69d-ef3a977cf2c1");
          taskServiceContextTaskTaskIdBaseType.setTaskId(taskId);

          WorkflowContextType workflowContextType =
              new WorkflowContextType();

          CredentialType credentialType = new CredentialType();
      //            credentialType.setLogin("eqadmin");
      //            credentialType.setPassword("weblogic1");
           credentialType.setLogin(resolveExpression("#{ApOperationBean.propertyLoader.properties['BPM_WORKSPACE_USERNAME']}").toString());
          credentialType.setPassword(resolveExpression("#{ApOperationBean.propertyLoader.properties['BPM_WORKSPACE_PASSWORD']}").toString());
          workflowContextType.setCredential(credentialType);


          taskServiceContextTaskTaskIdBaseType.setWorkflowContext(workflowContextType);

         // service.getTaskServicePort().suspendTimers(taskServiceContextTaskTaskIdBaseType);


          service.getTaskServicePort().resumeTimers(taskServiceContextTaskTaskIdBaseType);
          System.out.println("Done");
      } catch (StaleObjectFaultMessage sofm) {
          // TODO: Add catch code
          sofm.printStackTrace();
      } catch (WorkflowErrorMessage wem) {
          // TODO: Add catch code
          wem.printStackTrace();
      }

        p24.hide();
        holdButton.setVisible(true);
        releaseButton.setVisible(false);
        autoFillButton.setDisabled(false);
        rejectButton.setDisabled(false);
        reassignButton.setDisabled(false);
        saveButton.setDisabled(false);
        submitButton.setDisabled(false);
        System.out.println("End : releaseTaskWithExpiry");
    }

    public void setP20(RichPopup p20) {
        this.p20 = p20;
    }

    public RichPopup getP20() {
        return p20;
    }

    public void setP24(RichPopup p24) {
        this.p24 = p24;
    }

    public RichPopup getP24() {
        return p24;
    }

    public void setHoldCommentsIt(RichInputText holdCommentsIt) {
        this.holdCommentsIt = holdCommentsIt;
    }

    public RichInputText getHoldCommentsIt() {
        return holdCommentsIt;
    }

    public void setReleaseCommentsIt(RichInputText releaseCommentsIt) {
        this.releaseCommentsIt = releaseCommentsIt;
    }

    public RichInputText getReleaseCommentsIt() {
        return releaseCommentsIt;
    }

    public void setHoldButton(RichCommandButton holdButton) {
        this.holdButton = holdButton;
    }

    public RichCommandButton getHoldButton() {
        return holdButton;
    }

    public void setReleaseButton(RichCommandButton releaseButton) {
        this.releaseButton = releaseButton;
    }

    public RichCommandButton getReleaseButton() {
        return releaseButton;
    }

    public void onPageLoad(ClientEvent clientEvent) {
        // Add event code here...

        System.out.println("Start: onPageLoad");
        try {
            //System.out.println("internal status on page load : "+ ADFContext.getCurrent().getPageFlowScope().get("internalStatus"));
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("LineItemAddFlagCertifier", false);
            System.out.println("On Page Load Flag Status:"+AdfFacesContext.getCurrentInstance().getPageFlowScope().get("LineItemAddFlagCertifier"));
            String internalStatus = (String)ADFContext.getCurrent().getPageFlowScope().get("internalStatus");
            if(internalStatus !=null && internalStatus.equalsIgnoreCase("Invoice on Hold")){
                holdButton.setVisible(false);
                releaseButton.setVisible(true);
                autoFillButton.setDisabled(true);
                rejectButton.setDisabled(true);
                reassignButton.setDisabled(true);
                saveButton.setDisabled(true);
                submitButton.setDisabled(true);
                AdfFacesContext.getCurrentInstance().addPartialTarget(certifierPageForm);
            }else{
                holdButton.setVisible(true);
                releaseButton.setVisible(false);
                autoFillButton.setDisabled(false);
                rejectButton.setDisabled(false);
                reassignButton.setDisabled(false);
                saveButton.setDisabled(false);
                submitButton.setDisabled(false);
                AdfFacesContext.getCurrentInstance().addPartialTarget(certifierPageForm);
            }
            // 923018 NO PO Start
            String invoiceTypeFlag = (String)ADFContext.getCurrent().getPageFlowScope().get("invoiceTypeFlag");
            String noPoStatus=(String)ADFContext.getCurrent().getPageFlowScope().get("NOPOStatusFlag");
            String noPoStatusBPM=(String)ADFContext.getCurrent().getPageFlowScope().get("NOPOStatusFlagBPM");
            System.out.println("invoiceTypeFlag : "+invoiceTypeFlag !=null ?invoiceTypeFlag :"NULL");
            System.out.println("noPoStatus : "+ noPoStatus !=null ?noPoStatus :"NULL");
            System.out.println("noPoStatusBPM : "+ noPoStatusBPM !=null ? noPoStatusBPM :"NULL");
            if( "Non PO Invoice".equalsIgnoreCase(invoiceTypeFlag) && !(noPoStatus.equalsIgnoreCase(noPoStatusBPM))){
                String internalStatusEcm=null;
                System.out.println(" Mismatch in BPM and SITE VO status  ::::  ");
                if("Y".equalsIgnoreCase(noPoStatus) && "N".equalsIgnoreCase(noPoStatusBPM)){
                    internalStatusEcm="NPNP Supplier";
                }else{
                    internalStatusEcm=" ";
                }
                try{
                    Object docId = resolveExpression("#{bindings.attr1.inputValue}");
                    System.out.println(" --- Updating Webcenter IPM --- docId : "+(docId==null?"":docId.toString()));
                    Object user=resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGING_DOCUMENT_SERVICE_USERNAME']}");
                    Object pass=resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGING_DOCUMENT_SERVICE_PASSWORD']}");
                    System.out.println(" --- Updating Webcenter IPM --- user : "+(user==null?"":user.toString()));
                    System.out.println(" --- Updating Webcenter IPM --- pass : "+(pass==null?"":pass.toString()));

                   // Object docId = resolveExpression("#{bindings.attr1.inputValue}");
                    //System.out.println(" --- Updating Webcenter IPM --- docId : "+(docId==null?"":docId.toString()));
                    DocumentService docUpdateService = new DocumentService_Service().getDocumentServicePort();
                     BindingProvider bindingProvider = (BindingProvider)docUpdateService;
                     @SuppressWarnings("rawtypes")
                     List<Handler> handlerChain = new ArrayList<Handler>();
                     handlerChain.add(new WSSecurityHeaderSOAPHandler(
                                              resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGING_DOCUMENT_SERVICE_USERNAME']}").toString(),
                                              resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGING_DOCUMENT_SERVICE_PASSWORD']}").toString()
                                          )
                                     );
                     bindingProvider.getBinding().setHandlerChain(handlerChain);
                     List<FieldValue> fieldValues = new ArrayList<FieldValue>();


                    FieldValue fieldValue1 = new FieldValue();
                    fieldValue1.setName("Internal Status");
                    TypedValue typedValue1 = new TypedValue();
                    typedValue1.setType( FieldType.TEXT );
                    typedValue1.setValue( internalStatusEcm );
                    fieldValue1.setValue(typedValue1);


                    fieldValues.add(fieldValue1);

                    docUpdateService.updateDocument(new Holder<String>(docId==null?"":docId.toString()), null, fieldValues, false);

                    System.out.println(" --- Updating Webcenter IPM successful ---");
                }catch (Exception e) {
                    System.out.println(" --- Updating Webcenter IPM failed ---"+e.getMessage());
                    e.printStackTrace();
                }

            }
            if("Non PO Invoice".equalsIgnoreCase(invoiceTypeFlag) && "Y".equalsIgnoreCase(noPoStatus)){
                System.out.println("************True logic is executing *****************");
                noPOErrorMessage.setVisible(true);
                noPOErrorMessage.setRendered(true);
            }else{
                System.out.println("************False logic is executing *****************");
                noPOErrorMessage.setVisible(false);
                noPOErrorMessage.setRendered(false);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(noPOErrorMessage);
            AdfFacesContext.getCurrentInstance().addPartialTarget(noPOPanelGroupLaylout);



           // resolveExpression("#{ApOperationBean.propertyLoader.properties['IMAGING_DOCUMENT_SERVICE_PASSWORD']}").toString()


            // 923018 NO PO End
            String poNum = poNumIt.getValue()!=null ? poNumIt.getValue().toString() : null;
            BindingContext bc = BindingContext.getCurrent();
            DCBindingContainer bindings =(DCBindingContainer)bc.getCurrentBindingsEntry();
            DCIteratorBinding recIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
            if (recIter != null &&  recIter.getRowSetIterator().getRowCount() > 0) {
                System.out.println("Entering lineitem check");
                RowSetIterator recRSI =null;
                try{
                    //System.out.println("Entering try");
                   recRSI= recIter.getViewObject().createRowSetIterator(null);
                Row recRow;
                    while(recRSI.hasNext())
                    {
                        recRow=recRSI.next();
                        if(recRow!=null)
                        {
                    /*System.out.println("LineNumber : "+recRow.getAttribute("LineNumber"));
                    System.out.println("GlNo : "+recRow.getAttribute("GlNo"));
                    System.out.println("REC Code : "+recRow.getAttribute("Attr5"));*/
                    if(recRow.getAttribute("GlNo")!=null && !recRow.getAttribute("GlNo").equals(""))
                    {
                        System.out.println("Org id "+ADFContext.getCurrent().getPageFlowScope().get("OrgID"));

                        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ValidateGLCodeVO1Iterator");
                        ViewObjectImpl validateGLCodeVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();

                        validateGLCodeVO.setNamedWhereClauseParam("bindGLCode",recRow.getAttribute("GlNo"));
                        validateGLCodeVO.setNamedWhereClauseParam("bindOrgID",ADFContext.getCurrent().getPageFlowScope().get("OrgID"));
                        //System.out.println("-----------Dynamic Query-----------");
                        //System.out.println(validateGLCodeVO.getQuery());
                        validateGLCodeVO.executeQuery();
                        while (validateGLCodeVO.hasNext()) {
                          Row row = validateGLCodeVO.next(); // Get the next row in the result set.
                          System.out.println("Validglcode ."+ row.getAttribute("Validglcode")+".");
                        if(row.getAttribute("Validglcode")!=null && !row.getAttribute("Validglcode").equals("") && row.getAttribute("Validglcode").equals("Y"))
                            recRow.setAttribute("RecCodeFlag", "Y");
                       else
                         recRow.setAttribute("RecCodeFlag", null);
                        }
                        System.out.println("REC Code flag is set as "+recRow.getAttribute("RecCodeFlag"));
                    }

                    else if(!( poNum==null || (poNum!=null && poNum.trim().equals(""))) ){

                        System.out.println("PO Number header check on page load : disable gl fields if present");


                            recRow.setAttribute("GlNo",null);
                            recRow.setAttribute("Attr5",null); //make rec code empty
                            recRow.setAttribute("Attr4",null); //make projectID empty
                            recRow.setAttribute("ProjectNo",null);
                            recRow.setAttribute("Attr3",null); //make taskid empty
                            recRow.setAttribute("TaskNo",null);
                            recRow.setAttribute("ExpinditureOrg",null);
                            recRow.setAttribute("ExpenditureDate",null);
                            recRow.setAttribute("Attr10",null); //make expenditure type empty


                        /*** Disable all above fields and corresponding search icons ***/

                        //GL
                        glCodeSearchIcon.setDisabled(true);
                        glCode.setDisabled(true);

                        //Project No
                        projectNoSearchIcon.setDisabled(true);
                        projectNoIT.setDisabled(true);


                        /** Enable line PO and PO line no columns **/

                        linePONumberSearchIcon.setDisabled(false);
                        linePONumIT.setDisabled(false);

                        poLineNumberSearchIcon.setDisabled(false);
                        poLineNumIT.setDisabled(false);

                        AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);



                    }


                            }
                    System.out.println("new REC Code Flag: "+recRow.getAttribute("RecCodeFlag"));
                        }
                }
                catch(Exception e)
                {
                   e.printStackTrace();
                   }
                    finally{
                                if(recRSI!=null){
                                    recRSI.closeRowSetIterator();
                                }
                            }
                    AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("End: onPageLoad");
    }

    public void setCertifierPageForm(RichForm certifierPageForm) {
        this.certifierPageForm = certifierPageForm;
    }

    public RichForm getCertifierPageForm() {
        return certifierPageForm;
    }

    public void setSearchByCertifiername(RichSelectOneChoice searchByCertifiername) {
        this.searchByCertifiername = searchByCertifiername;
    }

    public RichSelectOneChoice getSearchByCertifiername() {
        return searchByCertifiername;
    }

    public void setCertifierApproverListPopUp(RichPopup certifierApproverListPopUp) {
        this.certifierApproverListPopUp = certifierApproverListPopUp;
    }

    public RichPopup getCertifierApproverListPopUp() {
        return certifierApproverListPopUp;
    }


    public String submitFromCertifier() {

        String invNum = null;
        if(invNumIt.getValue()!=null){
        invNum = (String)invNumIt.getValue();
        }
        System.out.println("invNum: "+invNum+" Start onSubmitClick");
        String poNum=null;
            try {
                String invoiceType = null;;
                if(resolveExpression("#{bindings.InvoiceType.inputValue}") != null)
                    invoiceType = resolveExpression("#{bindings.InvoiceType.inputValue}").toString();
                 poNum = poNumIt.getValue()!=null ? poNumIt.getValue().toString() : null;
                System.out.println("invNum: "+invNum+" onSubmitClick ::::  "+ "invoiceType :: "+ invoiceType + "poNum ::: "+ poNum);
                boolean isValidedFinally=false;
                boolean isValidGLCode=true;
                boolean isValidProjectNo=true;
                boolean isNonPo = true;
                boolean isValidPoNum = true;
                boolean flagVar=true;

                /* Added validation for PONumber */

                if(!( poNum==null || (poNum!=null && poNum.trim().equals(""))) ){
                                    System.out.println("invNum:"+invNum+" Validating PO only if PO Number is Present");
                                    DCBindingContainer dcBindingContainer1 = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                                    DCIteratorBinding dcIteratorBinding1 = dcBindingContainer1.findIteratorBinding("PoNoCertifierVO1Iterator");
                                    ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding1.getViewObject();
                                    ViewCriteria vc1 = poNOVO.getViewCriteria("PoNoCertifierVOCriteriaEqualsPONum");
                                    poNOVO.applyViewCriteria(vc1);
                                    poNOVO.setNamedWhereClauseParam("bindPONum", poNum);
                                    poNOVO.setNamedWhereClauseParam("bindOperatingUnit", operatingUnitIt.getValue()==null?"":operatingUnitIt.getValue().toString().trim());
                                    poNOVO.setNamedWhereClauseParam("bindSupplierName", supplierName.getValue()==null?"":supplierName.getValue().toString().trim());
                                    poNOVO.setNamedWhereClauseParam("bindSiteID", siteIdIt.getValue()==null?"":siteIdIt.getValue().toString().trim());

                                    poNOVO.executeQuery();
                                    //System.out.println("poNOVO.getEstimatedRowCount()"+poNOVO.getEstimatedRowCount());
                                    if(poNOVO.getEstimatedRowCount() != 1)
                                        isValidPoNum = false;

                                   System.out.println("invNum:"+invNum+" isValidPoNum"+isValidPoNum);



                                    /**** Check for empty Line level PO ****/
                                    if(!emptyLineLevelPO())
                                        return null;


                                    /** Add validations of line level POs  **/

                                    if(!validateLinePOs())
                                      return null;


                                    /**** Check for empty lineType dropdowns *****/
                                    if(!emptyLineType())
                                        return null;

                                    if(!validTaxRateCode())
                                        return null;



                }

                Integer line;

                if(!validateEmptyLines()) {
                    return null;
                }

                if(!validateTaxAmount()){
                    return null;
                }

                if(!validateAmountCalculation()) {
                    return null;
                }



                // mix lines change : Sourav : uncomment when needed   29thMArch
            /*    String lineAmountMagnitudeError = checkLineAmountMagnitude();
                if(lineAmountMagnitudeError != null) {

                    System.out.println("LineAmount Magnitude Error");

                    String validationErrorMessage = lineAmountMagnitudeError;
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    validationErrorPopup.show(hints);
                    this.validationErrorMessage.setValue(validationErrorMessage);
                    return null;
                }*/



                /* added line description validation */
                flagVar= validatelineDescription();
                /*  **************** */
                if(!flagVar){
                if((invoiceType!=null && invoiceType.equalsIgnoreCase("Non PO Invoice"))&&(poNum==null || poNum.trim().equals(""))){
                    //System.out.println("Inside validation block ........................");

                /* added validation on submit"*/
                BindingContext bc = BindingContext.getCurrent();
                DCBindingContainer bindings =
                    (DCBindingContainer)bc.getCurrentBindingsEntry();
                DCIteratorBinding glIter =
                    bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
                if (glIter != null &&
                    glIter.getRowSetIterator().getRowCount() > 0) {
                    RowSetIterator rsi =null;
                    try{
                       rsi= glIter.getViewObject().createRowSetIterator(null);
                    Row glRow;
                    while (rsi.next() != null) {
                        glRow = rsi.getCurrentRow();
                        System.out.println("invNum:"+invNum+"  GlNo LineNo ::" + glRow.getAttribute("LineNumber"));
                        line = (glRow.getAttribute("LineNumber")==null) ? null : ((oracle.jbo.domain.Number)glRow.getAttribute("LineNumber")).intValue();
                        //System.out.println(" Line ::" +line);

                        String message=null;

                        /****tax rate code gbp issue fix****/
                        if (glRow.getAttribute("TaxRateCode") != null ) {

                            //isValidGLCode = false;
                            String enteredTaxrate =glRow.getAttribute("TaxRateCode").toString();
                            System.out.println("invNum:"+invNum+"  GBP ISSUE ::: enteredTaxrate "+ enteredTaxrate);
                            System.out.println("invNum:"+invNum+"  GBP ISSUE ::: isValidGLCode "+ isValidGLCode);


                           /**check if entered Taxrate falls with the validtax rate code **/


                           DCBindingContainer dcBindingContainer_tax = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                           DCIteratorBinding dcIteratorBinding_tax = dcBindingContainer_tax.findIteratorBinding("TaxRateCodeLookupVO1Iterator");
                           ViewObjectImpl taxRateCodeVO = (ViewObjectImpl)dcIteratorBinding_tax.getViewObject();
                           ViewCriteria vc1_tax = taxRateCodeVO.getViewCriteria("TaxRateCodeLookupVOCriteria_lookupBySiteId");
                            taxRateCodeVO.applyViewCriteria(vc1_tax);
                           taxRateCodeVO.setNamedWhereClauseParam("bind_siteId", siteIdIt.getValue()==null?"":siteIdIt.getValue().toString().trim());
                           taxRateCodeVO.setNamedWhereClauseParam("bind_taxRateCode",glRow.getAttribute("TaxRateCode").toString());
                           taxRateCodeVO.executeQuery();
                            System.out.println("invNum:"+invNum+ "  taxRateCodeVO.executeQuery() gbp issue "+taxRateCodeVO.getEstimatedRowCount());
                            boolean flag_validCode = false;
//                            while (taxRateCodeVO.hasNext()) {
                            // 17-08-23 2292543 Change while to if
                            // 07-09-23 2292543 change getCurrentRow to first
                                if (taxRateCodeVO.getEstimatedRowCount()>0){
                               Row row = taxRateCodeVO.first();

//                             Row row = taxRateCodeVO.next(); // Get the next row in the result set.
                               try{
                               System.out.println("invNum:"+invNum+"  taxratecode of the current line row ::"+row.getAttribute("TaxRateCode"));

                                if(row.getAttribute("TaxRateCode")!=null && row.getAttribute("TaxRateCode").toString().equals(enteredTaxrate)){
                                    flag_validCode=true;
                                }
                               }catch(Exception e){
                                   flag_validCode=false;
                                   e.printStackTrace();
                               }

                           } //end of while loop for taxrate check
                            if(!flag_validCode){
                                message="The tax rate code entered by you in line "+line+"is invalid. Please re-enter a valid tax rate code in order to submit";
                                callFacesMessage(message);
//                                break;
                            // 09-06-23 2292543 Replace break to return. break statment break complete while loop
                                return null;
                            }

                           /**check if entered Taxrate falls with the validtax rate code **/

                        }



                        /****tax rate code gbp issue fix****/

                        if (glRow.getAttribute("GlNo") == null && glRow.getAttribute("ProjectNo") == null) {

                            isValidGLCode = false;
                            message="Please Enter valid GL Account Code Combination or Project Details (Project No, Task No, Expenditure Org, Expenditure Date, and Expenditure Type) on Line No : "+line;
                            callFacesMessage(message);
                            break;
                        }
                        else if(glRow.getAttribute("GlNo") == null && glRow.getAttribute("ProjectNo") != null){
                            String orgId= null;
                            String projectNo=(String)glRow.getAttribute("ProjectNo");
                            if(orgIdIt.getValue()!=null)
                            {
                                orgId=orgIdIt.getValue().toString();
                                System.out.println("invNum:"+invNum+ "  orgIdIt: "+orgId);
                            }

                            /* validate if proper project number entered*/
                            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("ProjectNumberVO1Iterator");
                            ViewObjectImpl projectNumberVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                            ViewCriteria projectNoVc = projectNumberVO.getViewCriteria("ProjectNumberVOCriteria1");
                            projectNumberVO.applyViewCriteria(projectNoVc);
                            projectNumberVO.setNamedWhereClauseParam("bindOrgID", orgId);
                            projectNumberVO.setNamedWhereClauseParam("bindProjectNo", projectNo);
                            //System.out.println("-----------Dynamic Query-----------");
                            //System.out.println(projectNumberVO.getQuery());
                            projectNumberVO.executeQuery();
                            if(projectNumberVO.getEstimatedRowCount() ==0){
                                isValidProjectNo = false;
                                FacesMessage Message =
                                    new FacesMessage("Enter valid Project Number on Line No : "+line);
                                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                                FacesContext fc = FacesContext.getCurrentInstance();
                                fc.addMessage(null, Message);
                                break;
                            }



                            if(glRow.getAttribute("TaskNo")==null){
                                isValidGLCode = false;
                                message="Please Enter valid Task Number on Line No : "+line;
                                callFacesMessage(message);
                                break;
                            }
                            else{
                                //Task No Validation
                                String taskNo = (String)glRow.getAttribute("TaskNo");
                                String projectId = (String)glRow.getAttribute("Attr4");
                                System.out.println("invNum:"+invNum+ "  Project Id "+projectId);
                                System.out.println("invNum:"+invNum+ "  Task Id  "+glRow.getAttribute("Attr3"));
                                if(projectId == null){   //added by raha for projectno manual

                                 projectId=setProjectIdIt();

                                System.out.println("invNum:"+invNum+ "newprojectid1::"+projectId);
                                }//ended by raha
                              /*  if(projectIdIt.getValue()!= null) {
                                    projectId = projectIdIt.getValue().toString();
                                    System.out.println("projectIdIt.getValue()" + projectId);
                                }*/
                                DCBindingContainer dcBindingContainerTask = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                                DCIteratorBinding dcIteratorBindingTask = dcBindingContainerTask.findIteratorBinding("TaskNumberVO1Iterator");
                                ViewObjectImpl taskNumberVO = (ViewObjectImpl)dcIteratorBindingTask.getViewObject();
                                ViewCriteria vc = taskNumberVO.getViewCriteria("TaskNumberVOCriteria2");
                                taskNumberVO.applyViewCriteria(vc);
                                taskNumberVO.setNamedWhereClauseParam("bindprojectId", projectId);
                                taskNumberVO.setNamedWhereClauseParam("bindTaskNo", taskNo);
                                System.out.println("invNum:"+invNum+ "  -----------Dynamic Query-----------");
//                                System.out.println(taskNumberVO.getQuery());
                                taskNumberVO.executeQuery();
                                if(taskNumberVO.getEstimatedRowCount() ==0){
                                    isValidProjectNo = false;
                                    FacesMessage Message =
                                        new FacesMessage("Enter valid Task Number on Line No  : "+line);
                                    Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                                    FacesContext fc = FacesContext.getCurrentInstance();
                                    fc.addMessage(null, Message);
                                    break;
                                }

                            }
                            if(glRow.getAttribute("ExpinditureOrg")==null){
                                isValidGLCode = false;
                                message="Please Enter valid Expenditure Org. on Line No  : "+line;
                                callFacesMessage(message);
                                break;
                            }
                            else{
                                //Expenditure Org Validation
                                System.out.println("invNum:"+invNum+ "  on submit click org added");


                                String enteredOrgIdIt=null;
                                if(orgIdIt.getValue() != null) {
                                    enteredOrgIdIt = orgIdIt.getValue().toString();
                                    System.out.println("invNum:"+invNum+"  orgIdIt.getValue(): "+enteredOrgIdIt);
                                }
                                else{
                                        System.out.println("invNum:"+invNum+"  orgIdIt.getValue(): "+orgIdIt.getValue());
                                    }

                                String expenditureOrg = (String)glRow.getAttribute("ExpinditureOrg");
                                DCBindingContainer dcBindingContainerOrg = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                                DCIteratorBinding dcIteratorBindingOrg = dcBindingContainerOrg.findIteratorBinding("ExpenditureOrgVO1Iterator");
                                ViewObjectImpl expOrgVO = (ViewObjectImpl)dcIteratorBindingOrg.getViewObject();
                                ViewCriteria vc = expOrgVO.getViewCriteria("ExpenditureOrgVOCriteria_filterByExpOrg");
                                expOrgVO.applyViewCriteria(vc);
                                expOrgVO.setNamedWhereClauseParam("bind_expOrg", expenditureOrg);
                                expOrgVO.setNamedWhereClauseParam("bindOrgID", enteredOrgIdIt);
                                //System.out.println("-----------Dynamic Query-----------");
                                //System.out.println(expOrgVO.getQuery());
                                expOrgVO.executeQuery();
                                if(expOrgVO.getEstimatedRowCount() ==0){
                                    isValidProjectNo = false;
                                    FacesMessage Message =
                                        new FacesMessage("Enter valid Expenditure Org on Line No : "+line);
                                    Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                                    FacesContext fc = FacesContext.getCurrentInstance();
                                    fc.addMessage(null, Message);
                                    break;
                                }

                            }
                            if(glRow.getAttribute("ExpenditureDate")==null){
                                isValidGLCode = false;
                                message="Please Enter valid Expenditure Date on Line No : "+line;
                                callFacesMessage(message);
                                break;
                            }
                            else{
                                    System.out.println("invNum:"+invNum+ "  on submit click Expenditure Date added");
                                    String projectId = (String)glRow.getAttribute("Attr4");
                                    String validexpdateError=null;
                                    System.out.println("invNum:"+invNum+ "  Project Id "+projectId);
                                    String taskId = (String)glRow.getAttribute("Attr3");
                                    System.out.println("invNum:"+invNum+ "  Task Id  "+taskId);
                                    String enteredOrgIdIt=null;

                                    if(projectId == null){ //added by raha for projectno and taskno manual

                                     projectId=setProjectIdIt();

                                    System.out.println("invNum:"+invNum+ "newprojectid2::"+projectId);

                                    /*System.out.println("Start: selectTaskNoPopUp");



                                    String selectedTaskNo="";
                                    String selectedTaskId="";
                                    //RowKeySet selectedTaskNum = projDtlTable.getSelectedRowKeys();    wrong binding
                                    RowKeySet selectedTaskNum = taskDtlTable.getSelectedRowKeys();
                                    Iterator selectedTaskIter = selectedTaskNum.iterator();
                                    //DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                                    DCIteratorBinding empIter = bindings.findIteratorBinding("TaskNumberVO1Iterator");
                                    RowSetIterator empRSIter=null;
                                    empRSIter = empIter.getRowSetIterator();
                                    while(selectedTaskIter.hasNext()){
                                       Key key = (Key)((List)selectedTaskIter.next()).get(0);
                                       Row currentRow = empRSIter.getRow(key);
                                       System.out.println(currentRow.getAttribute("TaskNumber"));
                                         selectedTaskNo=currentRow.getAttribute("TaskNumber").toString();
                                         System.out.println(currentRow.getAttribute("TaskId"));
                                           selectedTaskId=currentRow.getAttribute("TaskId").toString();

                                     }*/

                                                }
                                if(taskId == null){
                                    taskId=setTaskIdIt();
                                    System.out.println("newtaskid1::"+taskId);
                                }//ended by raha
                                    if(orgIdIt.getValue() != null) {
                                        enteredOrgIdIt = orgIdIt.getValue().toString();
                                        System.out.println("invNum:"+invNum+ "  orgIdIt.getValue(): "+enteredOrgIdIt);
                                    }
                                    else{
                                            System.out.println("invNum:"+invNum+ "  orgIdIt.getValue(): "+orgIdIt.getValue());
                                        }
                                    oracle.jbo.domain.Date expDate = null;
                                    if(glRow.getAttribute("ExpenditureDate")!=null){
                                    expDate = ((oracle.jbo.domain.Date)glRow.getAttribute("ExpenditureDate"));
                                        System.out.println("invNum:"+invNum+ "  Expdate "+expDate);
                                    }

                                    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
                                    String expeditureDate = expDate != null ? DATE_FORMAT.format(expDate.getValue()): null;
                                    System.out.println("invNum:"+invNum+ "  ----- Selected value for invoice date in dd-MMM-yyyy format : " + expeditureDate);

                                   // String selectedProjectId = (String)ADFContext.getCurrent().getPageFlowScope().get("ProjectId");
                                    //System.out.println("projectidfromvalidate: "+selectedProjectId);
                                    DCBindingContainer dcBindingContainerEXPDate = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                                    DCIteratorBinding dcIteratorBindingEXPDate = dcBindingContainerEXPDate.findIteratorBinding("ExpenditureDateVO1Iterator");
                                    ViewObjectImpl expenditureDateVO = (ViewObjectImpl)dcIteratorBindingEXPDate.getViewObject();
                                    /*   ViewCriteria vc5 = validateGLCodeVO.getViewCriteria("CounterPartyVOCriteria1");
                                    validateGLCodeVO.applyViewCriteria(vc5);*/
                                    expenditureDateVO.setNamedWhereClauseParam("bindProjectId",projectId);
                                    expenditureDateVO.setNamedWhereClauseParam("bindOrgId",enteredOrgIdIt);
                                    expenditureDateVO.setNamedWhereClauseParam("bindTaskId",taskId);
                                    expenditureDateVO.setNamedWhereClauseParam("bindExpenditureDate",expeditureDate);
                                    //System.out.println("-----------Dynamic Query-----------");
                                    //System.out.println(validateGLCodeVO.getQuery());
                                    expenditureDateVO.executeQuery();
                                    //System.out.println("projectid: "+selectedProjectId);
                                    //System.out.println("Taskid: "+taskIdIt.getValue());
                                    while (expenditureDateVO.hasNext()) {
                                      Row row = expenditureDateVO.next(); // Get the next row in the result set.
                                      if(null != row.getAttribute("Validexpendituredatereason"))
                                      {
                                      validexpdateError = row.getAttribute("Validexpendituredatereason").toString();
                                        System.out.println("invNum:"+invNum+ "  Validexpendituredatereason "+validexpdateError);
                                        }
                                    }
                                    if(validexpdateError!=null && !validexpdateError.equals(""))
                                    {
                                        System.out.println("invNum:"+invNum+ "  Inside if glcode error" +validexpdateError);
                                        isValidProjectNo = false;
                                    FacesMessage Message =
                                        new FacesMessage("Please Enter valid Expenditure Date on  Line No "+line+" : "+validexpdateError);
                                    Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                                    FacesContext fc = FacesContext.getCurrentInstance();
                                    fc.addMessage(null, Message);
                                    break;
                                    }



                                }
                            if(glRow.getAttribute("Attr10")==null){
                                isValidGLCode = false;
                                message="Please Enter valid Expenditure Type on Line No : "+line;
                                callFacesMessage(message);
                                break;
                            }
                            else{
                                //Expenditure Type Validation

                                String expenditureType = (String)glRow.getAttribute("Attr10");
                               // String projectId = null;
                              /*  if(projectIdIt.getValue()!= null) {
                                    projectId = projectIdIt.getValue().toString();
                                    System.out.println("projectIdIt.getValue()" + projectId);
                                }*/
                              String projectId = (String)glRow.getAttribute("Attr4");
                                System.out.println("invNum:"+invNum+ "  Project Id "+projectId);
                                String taskId = (String)glRow.getAttribute("Attr3");
                                System.out.println("invNum:"+invNum+"  Task Id "+taskId);

                                if(projectId == null){   //added by raha for projectno manual

                                 projectId=setProjectIdIt();

                                System.out.println("invNum:"+invNum+ "newprojectid3::"+projectId);
                                }
                                if(taskId == null){
                                    taskId=setTaskIdIt();
                                    System.out.println("invNum:"+invNum+ "newtaskid1::"+taskId);
                                }//ended by raha

                                /*** Expenditure Date passing to ExpenditureType VO : 18th August,2018 : Sourav :START***/

                                oracle.jbo.domain.Date expDate = null;
                                expDate = ((oracle.jbo.domain.Date)glRow.getAttribute("ExpenditureDate"));
                                SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
                                String expeditureDate = expDate != null ? DATE_FORMAT.format(expDate.getValue()): null;
                                System.out.println("invNum:"+invNum+ "  Expdate in validate Expenditure Type on submit : " + expeditureDate);


                                DCBindingContainer dcBindingContainerType = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                               DCIteratorBinding dcIteratorBindingType = dcBindingContainerType.findIteratorBinding("ExpenditureTypeVO1Iterator");
                               ViewObjectImpl expenditureTypeVo = (ViewObjectImpl)dcIteratorBindingType.getViewObject();
                               ViewCriteria vc = expenditureTypeVo.getViewCriteria("ExpenditureTypeVOCriteria2");
                               expenditureTypeVo.applyViewCriteria(vc);
                               expenditureTypeVo.setNamedWhereClauseParam("bindProjectId", projectId);
                               expenditureTypeVo.setNamedWhereClauseParam("bindExpType", expenditureType);
                                expenditureTypeVo.setNamedWhereClauseParam("bindTaskId", taskId);
                                expenditureTypeVo.setNamedWhereClauseParam("bindExpDate", expeditureDate);


                               //System.out.println("-----------Dynamic Query-----------");
                               //System.out.println(expenditureTypeVo.getQuery());
                               expenditureTypeVo.executeQuery();
                                if(expenditureTypeVo.getEstimatedRowCount() ==0){
                                    isValidProjectNo = false;
                                    FacesMessage Message =
                                        new FacesMessage("Enter valid Expenditure Type on Line No : "+line);
                                    Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                                    FacesContext fc = FacesContext.getCurrentInstance();
                                    fc.addMessage(null, Message);
                                    break;
                                }

                            }
                        }
                        else{
                            String orgId=null;
                            String glCodeError=null;
                            String glcode=(String)glRow.getAttribute("GlNo");
                                System.out.println("invNum:"+invNum+ "  selected gl code id"+glcode);

                                System.out.println("invNum:"+invNum+"  Org Id:"+orgIdIt.getValue()+".");
                                    if(orgIdIt.getValue()!=null)
                                    {
                                        orgId=orgIdIt.getValue().toString();
                                            System.out.println("invNum:"+invNum+ "  orgIdIt: "+orgId);
                                        }

                                DCBindingContainer dcBindingContainer5 = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                                DCIteratorBinding dcIteratorBinding5 = dcBindingContainer5.findIteratorBinding("ValidateGLCodeVO1Iterator");
                                ViewObjectImpl validateGLCodeVO = (ViewObjectImpl)dcIteratorBinding5.getViewObject();
                                /*   ViewCriteria vc5 = validateGLCodeVO.getViewCriteria("CounterPartyVOCriteria1");
                                validateGLCodeVO.applyViewCriteria(vc5);*/
                                validateGLCodeVO.setNamedWhereClauseParam("bindGLCode",glcode);
                                validateGLCodeVO.setNamedWhereClauseParam("bindOrgID",orgId);
                                //System.out.println("-----------Dynamic Query-----------");
                                //System.out.println(validateGLCodeVO.getQuery());
                                validateGLCodeVO.executeQuery();
                                while (validateGLCodeVO.hasNext()) {
                                  Row row = validateGLCodeVO.next(); // Get the next row in the result set.
                                  if(null != row.getAttribute("Validglcode"))
                                  {
                                  glCodeError = row.getAttribute("Validglcode").toString();
                                    }
                                    else
                                    glCodeError ="N";
                                    System.out.println("invNum:"+invNum+ "  glCodeError "+glCodeError);
                                }
                                if(glCodeError!=null && !glCodeError.equals("") && !glCodeError.equals("Y") && !glCodeError.equals("N"))
                                {
                                    System.out.println("invNum:"+invNum+ " Inside if glcode error " +glCodeError);
                                isValidGLCode = false;
                                FacesMessage Message =
                                    new FacesMessage("Please Enter valid GL Account Code Combination Line No "+line+" : "+glCodeError);
                                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                                FacesContext fc = FacesContext.getCurrentInstance();
                                fc.addMessage(null, Message);
                                break;
                                }
                                else if(glCodeError.equals("Y")) {
                                        if(glRow.getAttribute("Attr5")==null || glRow.getAttribute("Attr5").equals(""))
                                        {
                                                System.out.println("invNum:"+invNum+ " Inside if valid glcode and checking reccodeerror " +glCodeError);
                                                System.out.println("invNum:"+invNum+ " Rec code is "+glRow.getAttribute("Attr5"));
                                                isValidGLCode = false;
                                                FacesMessage Message =
                                                    new FacesMessage("Please Enter REC Code on  Line No "+line);
                                                Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                                                FacesContext fc = FacesContext.getCurrentInstance();
                                                fc.addMessage(null, Message);
                                                break;
                                            }

                                    }
                            }

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
                    //rsi.closeRowSetIterator();
                }
                }
                else{
                    isNonPo = false;
                }
                System.out.println("invNum: "+invNum+ " isvalidFinally  "+isValidedFinally);
                System.out.println("invNum: "+invNum+ " isValidGLCode "+isValidGLCode);
                System.out.println("invNum: "+invNum+ " isValidProjectNo "+isValidProjectNo);
                System.out.println("invNum: "+invNum+ " isValidPoNum "+isValidPoNum);
                if((/*isValidedFinally &&*/ isValidGLCode && isValidProjectNo &&  isValidPoNum )){
                    /*System.out.println("insie if");
                    System.out.println("isvalidFinally"+isValidedFinally);
                    System.out.println("isValidGLCode"+isValidGLCode);*/

                    if(isNonPo == false){
                        doSaveLineDetailsOperation();
                    }
                    validateAndDoSaveOperation();
                    //added by raha for exception requirement 19th oct release
                    System.out.println("invNum: "+invNum+ " saveoperationvar "+saveoperationvar);
                    if(saveoperationvar==2){
                        //System.out.println("if block execution to show error message");
                        FacesMessage Message =
                            new FacesMessage("It seems like there is a system issue, please close the browser and try again after some time!");
                        Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext fc = FacesContext.getCurrentInstance();
                        fc.addMessage(null, Message);
                        saveoperationvar=0;
                    }//ended by raha
                    else{
                    BindingContext bctx = BindingContext.getCurrent();
                    BindingContainer bindingsContainer = bctx.getCurrentBindingsEntry();
                    OperationBinding operationBinding =  bindingsContainer.getOperationBinding("APPROVE");
                    operationBinding.execute();
                    closeCertifierWindow();
                    }
                }
                else{
                    if(isValidPoNum == false){
                        System.out.println("invNum:"+invNum+ "inside failed validation for PO");
                        FacesMessage Message =
                            new FacesMessage("Please Enter Valid PO Number");
                        Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        FacesContext fc = FacesContext.getCurrentInstance();
                        fc.addMessage(null, Message);
                    }
                }
            }
                if(!( poNum==null || (poNum!=null && poNum.trim().equals(""))) ){
                    System.out.println("invNum:"+invNum+ "POnumber before close "+poNum);
                }
                else
                {
                     certifierApproverListPopUp.hide();
                    }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        System.out.println( "invNum: "+invNum+"  End onSubmitClick");
        return null;
    }

    public String cancelApprovalListPoopup() {
        // Add event code here...
        certifierApproverListPopUp.hide();
        return null;
    }
    /**
     * @return DCBindingContainer
     */
    public DCBindingContainer getBindings(){
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setEqApproverDetailsTable(RichTable eqApproverDetailsTable) {
        this.eqApproverDetailsTable = eqApproverDetailsTable;
    }

    public RichTable getEqApproverDetailsTable() {
        return eqApproverDetailsTable;
    }
    public String fetchEmployeeID()  {
        System.out.println("----- getAPGroupUserName ----- START ---- -"+new Date());
        FacesContext context = FacesContext.getCurrentInstance();
        String ctx = (String)context.getApplication().evaluateExpressionGet(context,"#{pageFlowScope.bpmWorklistContext}",String.class);

        String taskId = (String)context.getApplication().evaluateExpressionGet(context,"#{pageFlowScope.bpmWorklistTaskId}",String.class);

        //System.out.println("----- bpmWorklistContext : "+ctx+", bpmWorklistTaskId : "+taskId);

        IWorkflowServiceClient workflowSvcClient = ADFWorklistBeanUtil.getWorkflowServiceClient();
        ITaskQueryService wfQueryService = workflowSvcClient.getTaskQueryService();
        IWorkflowContext wfContext;
        String userID = "";

        try {
            wfContext = wfQueryService.getWorkflowContext(ctx);
            userID = wfContext.getUser();
            System.out.println("userID ::****"+userID);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return userID;
    }

    public void setAutoFillButton(RichCommandButton autoFillButton) {
        this.autoFillButton = autoFillButton;
    }

    public RichCommandButton getAutoFillButton() {
        return autoFillButton;
    }

    public void setRejectButton(RichCommandButton rejectButton) {
        this.rejectButton = rejectButton;
    }

    public RichCommandButton getRejectButton() {
        return rejectButton;
    }

    public void setReassignButton(RichCommandButton reassignButton) {
        this.reassignButton = reassignButton;
    }

    public RichCommandButton getReassignButton() {
        return reassignButton;
    }

    public void setSubmitButton(RichCommandButton submitButton) {
        this.submitButton = submitButton;
    }

    public RichCommandButton getSubmitButton() {
        return submitButton;
    }

    public void setSaveButton(RichCommandButton saveButton) {
        this.saveButton = saveButton;
    }

    public RichCommandButton getSaveButton() {
        return saveButton;
    }

    public void setTaskIdIt(RichInputText taskIdIt) {
        this.taskIdIt = taskIdIt;
    }

    public RichInputText getTaskIdIt() {
        return taskIdIt;
    }

    public void samplecheck() {
        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer bindings =
            (DCBindingContainer)bc.getCurrentBindingsEntry();
        DCIteratorBinding glIter =
            bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        if (glIter != null &&
            glIter.getRowSetIterator().getRowCount() > 0) {
            RowSetIterator rsi =null;
            try{
               rsi= glIter.getViewObject().createRowSetIterator(null);
            Row glRow;
            while (rsi.next() != null) {
                glRow = rsi.getCurrentRow();

               System.out.println("Project Id "+glRow.getAttribute("Attr4"));
            System.out.println("Task Id  "+glRow.getAttribute("Attr3"));
            }
            }
            catch(Exception e)
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
    }
    }

    public void setReassignEmailIdIT(RichInputText reassignEmailIdIT) {
        this.reassignEmailIdIT = reassignEmailIdIT;
    }

    public RichInputText getReassignEmailIdIT() {
        return reassignEmailIdIT;
    }

    public void glCodeRecValueChangeEvent(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
      System.out.println("STart glCodeRecValueChangeEvent");
        System.out.println("GlCode NewValue : "+valueChangeEvent.getNewValue().toString());
        System.out.println("Tab Presssed "+ ADFContext.getCurrent().getPageFlowScope().get("tabPressRECCode"));

        if(!(ADFContext.getCurrent().getPageFlowScope().get("tabPressRECCode")!=null && ADFContext.getCurrent().getPageFlowScope().get("tabPressRECCode").equals("tabpressed")))
        {
        try{
       DCBindingContainer bindings = getBinding();
       DCIteratorBinding lineItemIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
       ViewObject empVO = lineItemIter.getViewObject();
       Row selectedRow=empVO.getCurrentRow();
       System.out.println("line number "+selectedRow.getAttribute("LineNumber"));
        selectedRow.setAttribute("RecCodeFlag", null);
            selectedRow.setAttribute("Attr5", null);
        System.out.println("RecCodeFlag "+selectedRow.getAttribute("RecCodeFlag"));

        }catch(Exception e)
           {
               e.printStackTrace();
               }

        }
        else
        {
                ADFContext.getCurrent().getPageFlowScope().put("tabPressRECCode",null);
                System.out.println("Tab Presssed in else part"+ ADFContext.getCurrent().getPageFlowScope().get("tabPressRECCode"));
            }

        AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
        System.out.println("End glCodeRecValueChangeEvent");
    }



    public void showPONumberTablePopup(ActionEvent actionEvent) {


            System.out.println("Start showPONumberTablePopup");
            RowSetIterator lineItemRSIter =null;

            /*Object isLineItemPopupParam =  actionEvent.getComponent().getAttributes().get("isLineItemPopup");
            System.out.println(" ----- showPONumberPopup : "+isLineItemPopupParam);*/
            String linePONumClientID = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
            //System.out.println(" ----- clientID : "+linePONumClientID);
            this.linePONumClientID.setValue(linePONumClientID);

            try {

                String enteredPonumber = null;
                RowKeySet rowKeySet = lineItemsTable.getSelectedRowKeys();
                Iterator rowKeySetIt = rowKeySet.iterator();
                DCIteratorBinding lineItemIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");
                lineItemRSIter = lineItemIter.getRowSetIterator();

                 while(rowKeySetIt.hasNext()){
                   Key key = (Key)((List)rowKeySetIt.next()).get(0);
                   Row currentRow = lineItemRSIter.getRow(key);
                     if(currentRow!=null) {
                        System.out.println("----- typedInPONumber ----- "+currentRow.getAttribute("LinePoNum"));

                        enteredPonumber = currentRow.getAttribute("LinePoNum")==null?"":currentRow.getAttribute("LinePoNum").toString().trim();
                     }
                 }

                linePONumPopUpIt.setValue(enteredPonumber);
                if(siteIdIt.getValue() != null) {


                        System.out.println("Site ID not null : it is : "+siteIdIt.getValue().toString().trim());
                        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                        ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                        ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria2");
                        poNOVO.applyViewCriteria(vc);
                        poNOVO.setNamedWhereClauseParam("bindPONum", enteredPonumber);
                        poNOVO.setNamedWhereClauseParam("bindSiteId", siteIdIt.getValue().toString().trim());
//                    System.out.println("Dynamic query :: "+poNOVO.getQuery());
                        poNOVO.executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
                } else {
                        System.out.println("Site ID  null");
                        System.out.println("poNumIt.getValue(): "+enteredPonumber);
                        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                        ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                        ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria");
                        poNOVO.applyViewCriteria(vc);
                        poNOVO.setNamedWhereClauseParam("bindPONum", enteredPonumber);
//                    System.out.println("Dynamic query :: "+poNOVO.getQuery());
                        poNOVO.executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
                }
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                p26.show(hints);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            finally{
                        if(lineItemRSIter!=null) {
                            try {
                                lineItemRSIter.closeRowSetIterator();
                            } catch(Exception ex) {
                                ex.printStackTrace();

                        }
                        }
                    }

            System.out.println("End showPONumberTablePopup");
        }



    public void hiddenButtonClickEvent(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Button Clicked");
    }

    public void setRecCode(RichInputText recCode) {
        this.recCode = recCode;
    }

    public RichInputText getRecCode() {
        return recCode;
    }

    public void cancelLinePONumber(ActionEvent actionEvent) {

        //System.out.println("Start: cancelLinePONumber");
        linePONumPopUpIt.setValue("");
        p26.hide();

        //System.out.println("End: cancelLinePONumber");

    }

    public void selectLinePONumber(ActionEvent actionEvent) {

        System.out.println("Start: selectLinePONumber");


        RowKeySet selectedPONum = poDetailsTable.getSelectedRowKeys();
        Iterator selectedSiteIter = selectedPONum.iterator();
        DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = bindings.findIteratorBinding("POVO1Iterator");
        RowSetIterator empRSIter=null;
        String selectedPONumber = null;

        try{

            empRSIter = empIter.getRowSetIterator();
            while(selectedSiteIter.hasNext()){
                    Key key = (Key)((List)selectedSiteIter.next()).get(0);
                    Row currentRow = empRSIter.getRow(key);
                    System.out.println(currentRow.getAttribute("PoNum"));
                     selectedPONumber=currentRow.getAttribute("PoNum").toString();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
                    if(empRSIter!=null) {
                        try {
                            empRSIter.closeRowSetIterator();
                        } catch(Exception ex) {
                            ex.printStackTrace();

                    }
                    }
                }

                    int selectedRowNum = -1;
                    System.out.println("linePONumClientID value in selectLinepoNumber method : " + linePONumClientID.getValue());
                    if(linePONumClientID.getValue()!=null) {
                        selectedRowNum = Integer.parseInt(linePONumClientID.getValue().toString().split(":")[2]);
                        System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);
                    }

                    if(selectedRowNum!=-1) {


                         String componentIDPoNumber = "pt1:t1:"+selectedRowNum+":it351::content";
                         System.out.println("----- componentIDPoNumber ----- "+componentIDPoNumber+", selectedPONumber : "+selectedPONumber);

                         FacesContext fctx = FacesContext.getCurrentInstance();
                         ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
                         String myJavaScriptCode = "document.getElementById('"+componentIDPoNumber+"').value = '"+selectedPONumber+"'";
                         erks.addScript(fctx, myJavaScriptCode );
                     }

                linePONumPopUpIt.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
                AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
                p26.hide();

        System.out.println("End: selectLinePONumber");

    }

    public void setP26(RichPopup p26) {
        this.p26 = p26;
    }

    public RichPopup getP26() {
        return p26;
    }

    public void setPoNumLinePopupIt(RichInputText poNumLinePopupIt) {
        this.poNumLinePopupIt = poNumLinePopupIt;
    }

    public RichInputText getPoNumLinePopupIt() {
        return poNumLinePopupIt;
    }

    public void setOnLinePONumPopupGoClick(RichInputText onLinePONumPopupGoClick) {
        this.onLinePONumPopupGoClick = onLinePONumPopupGoClick;
    }

    public RichInputText getOnLinePONumPopupGoClick() {
        return onLinePONumPopupGoClick;
    }

    public void onLinePONumPopupGoClick(ActionEvent actionEvent) {
        System.out.println("Start onPONumPopupGoClick");
        String enteredPONum = null;
        try {
            if(siteIdIt.getValue() != null) {
                System.out.println("Inside Both Null condition ");
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria2");
                poNOVO.applyViewCriteria(vc);
                poNOVO.setNamedWhereClauseParam("bindPONum", linePONumPopUpIt.getValue()==null?"":linePONumPopUpIt.getValue().toString().trim());
                poNOVO.setNamedWhereClauseParam("bindSiteId", siteIdIt.getValue().toString().trim());
                poNOVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);
            } else {

                enteredPONum = linePONumPopUpIt.getValue()==null?"":linePONumPopUpIt.getValue().toString().trim();
                System.out.println("linePONumPopUpIt.getValue(): "+enteredPONum);
                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria");
                poNOVO.applyViewCriteria(vc);
                poNOVO.setNamedWhereClauseParam("bindPONum", enteredPONum);
                poNOVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(poDetailsTable);

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("End onPONumPopupGoClick");
    }

    public void setLinePONumPopUpIt(RichInputText linePONumPopUpIt) {
        this.linePONumPopUpIt = linePONumPopUpIt;
    }

    public RichInputText getLinePONumPopUpIt() {
        return linePONumPopUpIt;
    }

    private boolean emptyLineLevelPO() {

        System.out.println("Validating empty line level PO : START");

        RowSetIterator lineItemItr = null;
        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObjectImpl lineVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
        System.out.println("------------lineVO Count validateEmptyLines(): "+lineVO.getEstimatedRowCount());
        lineItemItr = lineVO.createRowSetIterator(null);
        String message= null;
        Integer line;
        boolean validateFlag = true;
        while(lineItemItr.hasNext()) {
         Row lineRow = lineItemItr.next();
         if(lineRow.getAttribute("LinePoNum")==null || lineRow.getAttribute("LinePoNum").equals("")) {
             validateFlag = false;
             line = ((oracle.jbo.domain.Number)lineRow.getAttribute("LineNumber")).intValue();
             message="Please Enter the Line Level PO in line "+ line +" before submitting the invoice";
             callFacesMessage(message);
             break;
         }
         else if(lineRow.getAttribute("PoLineNum")==null || lineRow.getAttribute("PoLineNum").equals("")){
             validateFlag = false;
             line = ((oracle.jbo.domain.Number)lineRow.getAttribute("LineNumber")).intValue();
             message="Please Enter the PO Line No in line "+ line +" before submitting the invoice";
             callFacesMessage(message);
             break;
         }
        }

        if(lineItemItr != null)
            lineItemItr.closeRowSetIterator();

        System.out.println("Validating empty line level PO : ENDS");

        return validateFlag;

    }


    private boolean emptyLineType() {

        System.out.println("Validating empty line types : START");

        RowSetIterator lineItemItr = null;
        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObjectImpl lineVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
        System.out.println("------------lineVO Count validateEmptyLines(): "+lineVO.getEstimatedRowCount());
        lineItemItr = lineVO.createRowSetIterator(null);
        String message= null;
        Integer line;
        boolean validateFlag = true;
        while(lineItemItr.hasNext()) {
         Row lineRow = lineItemItr.next();
         if(lineRow.getAttribute("LineType")==null || lineRow.getAttribute("LineType").equals("")) {
             validateFlag = false;
             line = ((oracle.jbo.domain.Number)lineRow.getAttribute("LineNumber")).intValue();
             message="Please Enter the Line Type in line "+ line +" before submitting the invoice";
             callFacesMessage(message);
             break;
         }
        }

        if(lineItemItr != null)
            lineItemItr.closeRowSetIterator();

        System.out.println("Validating empty line level PO : ENDS");

        return validateFlag;

    }

    public void onHeaderPOValueChage(ValueChangeEvent valueChangeEvent) {

        System.out.println("Header PO Value Changed");


        /*** If PO present at Header level then empty all fields from GL Code onwards ****/

       // String headerPONumber = valueChangeEvent.getNewValue();

        if(valueChangeEvent.getNewValue() != null && !valueChangeEvent.getNewValue().toString().trim().equals("")){

        System.out.println("new value : " + valueChangeEvent.getNewValue().toString());

        String enteredPONumber = valueChangeEvent.getNewValue() != null ? valueChangeEvent.getNewValue().toString() : null;
        System.out.println("Entered PO Number in Value change : "+enteredPONumber);

        RowSetIterator lineItemItr = null;
        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObjectImpl lineVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
        System.out.println("lineVO Count validatelineDescription(): "+lineVO.getEstimatedRowCount());
        lineItemItr = lineVO.createRowSetIterator(null);

        while(lineItemItr.hasNext()) {
            Row lineRow = lineItemItr.next();
            lineRow.setAttribute("GlNo",null);
            lineRow.setAttribute("Attr5",null); //make rec code empty
            lineRow.setAttribute("Attr4",null); //make projectID empty
            lineRow.setAttribute("ProjectNo",null);
            lineRow.setAttribute("Attr3",null); //make taskid empty
            lineRow.setAttribute("TaskNo",null);
            lineRow.setAttribute("ExpinditureOrg",null);
            lineRow.setAttribute("ExpenditureDate",null);
            lineRow.setAttribute("Attr10",null); //make expenditure type empty
            lineRow.setAttribute("LinePoNum",enteredPONumber!=null ? enteredPONumber : null); //SetDefault Value in Line Level PO
        }

        /*** Disable all above fields and corresponding search icons ***/

        //GL
        glCodeSearchIcon.setDisabled(true);
        glCode.setDisabled(true);

        //Project No
        projectNoSearchIcon.setDisabled(true);
        projectNoIT.setDisabled(true);

        /*
        //REC
        recCode.setDisabled(true);

        //Task No
        taskNoSearchIcon.setDisabled(true);
        taskNoIT.setDisabled(true);

        //Expenditure Org
        expenditureOrgSearchIcon.setDisabled(true);
        expOrgIT.setDisabled(true);

        //Expenditure Date
        expDateIT.setDisabled(true);

        //expenditureType
        expenditureTypeSearchIcon.setDisabled(true);
        expTypeIt.setDisabled(true); */

        /** Enable line PO and PO line no columns **/

        linePONumberSearchIcon.setDisabled(false);
        linePONumIT.setDisabled(false);

        poLineNumberSearchIcon.setDisabled(false);
        poLineNumIT.setDisabled(false);

        ADFContext.getCurrent().getPageFlowScope().put("header_selectedPONumber", enteredPONumber);

        AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);

        if(lineItemItr != null){
            lineItemItr.closeRowSetIterator();
        }

    }

        else{


            System.out.println("new value when : " + valueChangeEvent.getNewValue());
            System.out.println("Header PO empty disable entered Line level POs and enable other GL related fields");

            /** Empty line level POs if present **/

            RowSetIterator lineItemItr = null;
            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
            ViewObjectImpl lineVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
            System.out.println("------------lineVO Count validatelineDescription(): "+lineVO.getEstimatedRowCount());
            lineItemItr = lineVO.createRowSetIterator(null);

            while(lineItemItr.hasNext()) {
                Row lineRow = lineItemItr.next();
                lineRow.setAttribute("LinePoNum",null); // Line Level PO
                lineRow.setAttribute("PoLineNum",null);  // PO Line No
            }

            ADFContext.getCurrent().getPageFlowScope().put("header_selectedPONumber", null); //empty default PO No in line level

            //GL
            glCodeSearchIcon.setDisabled(false);
            glCode.setDisabled(false);

            //Project No
            projectNoSearchIcon.setDisabled(false);
            projectNoIT.setDisabled(false);

            /** Disable PO fields at line level **/
            linePONumberSearchIcon.setDisabled(true);
            linePONumIT.setDisabled(true);

            poLineNumberSearchIcon.setDisabled(true);
            poLineNumIT.setDisabled(true);

            AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);

            if(lineItemItr != null){
                lineItemItr.closeRowSetIterator();
            }


        }

    }

    public void setTaskNoSearchIcon(RichCommandImageLink taskNoSearchIcon) {
        this.taskNoSearchIcon = taskNoSearchIcon;
    }

    public RichCommandImageLink getTaskNoSearchIcon() {
        return taskNoSearchIcon;
    }

    public void setExpenditureOrgSearchIcon(RichCommandImageLink expenditureOrgSearchIcon) {
        this.expenditureOrgSearchIcon = expenditureOrgSearchIcon;
    }

    public RichCommandImageLink getExpenditureOrgSearchIcon() {
        return expenditureOrgSearchIcon;
    }

    public void setExpenditureTypeSearchIcon(RichCommandImageLink expenditureTypeSearchIcon) {
        this.expenditureTypeSearchIcon = expenditureTypeSearchIcon;
    }

    public RichCommandImageLink getExpenditureTypeSearchIcon() {
        return expenditureTypeSearchIcon;
    }

    public void setLinePONumberSearchIcon(RichCommandImageLink linePONumberSearchIcon) {
        this.linePONumberSearchIcon = linePONumberSearchIcon;
    }

    public RichCommandImageLink getLinePONumberSearchIcon() {
        return linePONumberSearchIcon;
    }

    public void setLinePONumIT(RichInputText linePONumIT) {
        this.linePONumIT = linePONumIT;
    }

    public RichInputText getLinePONumIT() {
        return linePONumIT;
    }

    public void setPoLineNumberSearchIcon(RichCommandImageLink poLineNumberSearchIcon) {
        this.poLineNumberSearchIcon = poLineNumberSearchIcon;
    }

    public RichCommandImageLink getPoLineNumberSearchIcon() {
        return poLineNumberSearchIcon;
    }

    public void setPoLineNumIT(RichInputText poLineNumIT) {
        this.poLineNumIT = poLineNumIT;
    }

    public RichInputText getPoLineNumIT() {
        return poLineNumIT;
    }

    public void showPOLineNumPopup(ActionEvent actionEvent) {


                System.out.println("showPOLineNumPopup : STARTS");
                oracle.jbo.domain.Number supplierId = null;
                String enteredPonumber = null;
                RowKeySet rowKeySet = lineItemsTable.getSelectedRowKeys();
                /*Iterator rowKeySetIt = rowKeySet.iterator();
                DCIteratorBinding lineItemIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");
                RowSetIterator lineItemRSIter=null;*/
                DCBindingContainer dcb = (DCBindingContainer)getBindings();
                                       DCIteratorBinding dcItr = dcb .findIteratorBinding("LineItemDetailsEOView1Iterator");
                                       RowSetIterator rsIter = dcItr .getRowSetIterator();
                                       Row rowObj = rsIter .getCurrentRow();
                try{
                 /*lineItemRSIter = lineItemIter.getRowSetIterator();
                 while(rowKeySetIt.hasNext()){
                   Key key = (Key)((List)rowKeySetIt.next()).get(0);
                   Row currentRow = lineItemRSIter.getRow(key);
                     if(currentRow!=null) {
                        System.out.println("----- typedInPONumber ----- "+currentRow.getAttribute("LinePoNum"));

                        enteredPonumber = currentRow.getAttribute("LinePoNum")==null?"":currentRow.getAttribute("LinePoNum").toString().trim();
                     }
                 }*/
                    if(rowObj != null){
                        enteredPonumber = rowObj.getAttribute("LinePoNum")==null?"":rowObj.getAttribute("LinePoNum").toString().trim();
                    }


                }catch(Exception e)
                {
                    e.printStackTrace();
                    }
                finally{
                            if(rsIter!=null) {
                                try {
                                    rsIter.closeRowSetIterator();
                                } catch(Exception ex) {
                                    ex.printStackTrace();

                            }
                            }
                        }



                try{

                    DCBindingContainer bindings = getBindings();
                    DCIteratorBinding dcIteratorBindings =
                    bindings.findIteratorBinding("HeaderDetailsEOView1Iterator");
                    ViewObject headerVO = dcIteratorBindings.getViewObject();
                    Row headerRow = headerVO.getCurrentRow();
                    if (headerRow != null) {

                            supplierId = (oracle.jbo.domain.Number)headerRow.getAttribute("SupplierId");

                        }

                }
                catch(Exception e){
                    e.printStackTrace();
                }

                oracle.jbo.domain.Number siteId = siteIdIt.getValue()==null ? null : (oracle.jbo.domain.Number)siteIdIt.getValue();
                System.out.println("----- supplierId in showPOLineNoPopUp : "+supplierId+", siteId : "+siteId);


                if(!enteredPonumber.equals("")) {
                    if(supplierId!=null && siteId==null) {
                        System.out.println("----- Filtering line items PO by supplier ID only");
                        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POLineNumberDetailsVO1Iterator");
                        ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                        ViewCriteria vc = poNOVO.getViewCriteria("POLineNumberDetailsVOCriteria_filterByVendorId");
                        poNOVO.applyViewCriteria(vc);
                        poNOVO.setNamedWhereClauseParam("po_number", enteredPonumber);
                        poNOVO.setNamedWhereClauseParam("vendor_id", supplierId);
//                        System.out.println("Dynamic query :: "+poNOVO.getQuery());
                        poNOVO.executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(poLineNumberTable);
                    } else if(supplierId!=null && siteId!=null) {
                        System.out.println("----- Filtering line items PO by supplier ID and site ID");
                        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POLineNumberDetailsVO1Iterator");
                        ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                        ViewCriteria vc = poNOVO.getViewCriteria("POLineNumberDetailsVOCriteria_filterByVendorIdSiteId");
                        poNOVO.applyViewCriteria(vc);
                        poNOVO.setNamedWhereClauseParam("po_number", enteredPonumber);
                        poNOVO.setNamedWhereClauseParam("vendor_id", supplierId);
                        poNOVO.setNamedWhereClauseParam("site_id",   siteId);
//                        System.out.println("Dynamic query :: "+poNOVO.getQuery());
                        poNOVO.executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(poLineNumberTable);
                    } else {
                        System.out.println("----- Filtering line items PO by typed in PO number only");
                        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POLineNumberDetailsVO1Iterator");
                        ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                        poNOVO.setNamedWhereClauseParam("po_number", enteredPonumber);
//                        System.out.println("Dynamic query :: "+poNOVO.getQuery());
                        poNOVO.executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(poLineNumberTable);
                    }

                     String poLineNumClientID = actionEvent.getComponent().getClientId(FacesContext.getCurrentInstance());
                     System.out.println(" ----- clientID : "+poLineNumClientID);
                     this.poLineNumClientID.setValue(poLineNumClientID);


                     try {
                         RichPopup.PopupHints hints = new RichPopup.PopupHints();
                         p27.show(hints);
                     }
                     catch(Exception e) {
                         e.printStackTrace();
                     }
                 } else {
                     this.validationErrorMessage.setValue("Line Item PO Number must be entered to search for PO Line Number");
                     RichPopup.PopupHints hints = new RichPopup.PopupHints();
                     validationErrorPopup.show(hints);
                 }

                System.out.println("showPOLineNumPopup : ends");

            }


    public void selectPOLineNumPopup(ActionEvent actionEvent) {
        System.out.println("selectPOLineNumPopup : STARTS");


        BigDecimal poLineNumber = null;
        BigDecimal quantity = null;
        String uom = null;
        BigDecimal unitPrice = null;
        String lineDesctiption = null;

        String taxRateCode = null;
        BigDecimal taxAmount = null;

        RowSetIterator lineItemRSIter = null;
        RowSetIterator empRSIter =null;
        try{
        RowKeySet selectedPONum = poLineNumberTable.getSelectedRowKeys();
        Iterator selectedSiteIter = selectedPONum.iterator();
        DCBindingContainer bindings =(DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = bindings.findIteratorBinding("POLineNumberDetailsVO1Iterator");
         empRSIter = empIter.getRowSetIterator();
        while(selectedSiteIter.hasNext()){
           Key key = (Key)((List)selectedSiteIter.next()).get(0);
           Row currentRow = empRSIter.getRow(key);

            poLineNumber = currentRow.getAttribute("LineNum") == null ? null : (BigDecimal)currentRow.getAttribute("LineNum");
            quantity = currentRow.getAttribute("Quantity") == null ? null : (BigDecimal)currentRow.getAttribute("Quantity");
            uom = currentRow.getAttribute("Uom") == null ? null : (String)currentRow.getAttribute("Uom");
            unitPrice = currentRow.getAttribute("UnitPrice") == null ? null : (BigDecimal)currentRow.getAttribute("UnitPrice");
            lineDesctiption = currentRow.getAttribute("ItemDescription") == null ? null : (String)currentRow.getAttribute("ItemDescription");
            taxRateCode = currentRow.getAttribute("TaxRateCode") == null ? null : (String)currentRow.getAttribute("TaxRateCode");
            taxAmount = currentRow.getAttribute("TaxRate") == null ? null : (BigDecimal)currentRow.getAttribute("TaxRate");


            System.out.println("----- poLineNumber : "+poLineNumber+", quantity : "+quantity+", uom : "+uom+", unitPrice : "+unitPrice+", lineDesctiption : "+lineDesctiption+", taxRateCode : "+taxRateCode+", taxAmount : "+taxAmount);
         }

            int selectedRowNum = -1;

            if(poLineNumClientID.getValue()!=null) {
                selectedRowNum = Integer.parseInt(poLineNumClientID.getValue().toString().split(":")[2]);
                System.out.println(" ----- Selected row has client id pattern : "+selectedRowNum);
            }


             if(selectedRowNum!=-1) {
                 FacesContext fctx = FacesContext.getCurrentInstance();
                 ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);

                 //Tax Amount
                 RowKeySet rowKeySet = lineItemsTable.getSelectedRowKeys();
                 Iterator rowKeySetIt = rowKeySet.iterator();
                 DCIteratorBinding lineItemIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");

                 lineItemRSIter = lineItemIter.getRowSetIterator();
                  while(rowKeySetIt.hasNext()){
                    Key key = (Key)((List)rowKeySetIt.next()).get(0);
                    Row currentRow = lineItemRSIter.getRow(key);
                      //System.out.println("current row :: "+ currentRow);
                      if(currentRow!=null) {
                         System.out.println("current row not null ............................");
                         System.out.println("line description value ::: "+ currentRow.getAttribute("LineDescription"));
                         try {
                             currentRow.setAttribute("TaxRate", taxAmount == null ? null : new oracle.jbo.domain.Number(taxAmount.doubleValue()));
                         } catch(Exception ex) {
                             ex.printStackTrace();
                         }
                      }
                  }

            /*** Set line type value acc to line desc Value from PO Line NO popup ***/

            System.out.println("Setting dropdown value for line type in select polineno method");

            RowKeySet rowKeySet1 = lineItemsTable.getSelectedRowKeys();
            Iterator rowKeySetIt1 = rowKeySet1.iterator();
            DCIteratorBinding lineItemIter1 = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");

            lineItemRSIter = lineItemIter1.getRowSetIterator();
             while(rowKeySetIt1.hasNext()){
               Key key = (Key)((List)rowKeySetIt1.next()).get(0);
               Row currentRow = lineItemRSIter.getRow(key);
                 System.out.println("current row line description value :: "+ lineDesctiption.toUpperCase());
                 if(currentRow!=null) {
                    try {
                        if(lineDesctiption.toUpperCase().equals("TAXABLE LINE") || lineDesctiption.toUpperCase().equals("NON TAXABLE LINE") || lineDesctiption.toUpperCase().equals("ADJUSTMENT LINE"))
                           currentRow.setAttribute("LineType", lineDesctiption.toUpperCase());
                        else
                        currentRow.setAttribute("LineType", null);
                    } catch(Exception ex) {
                        ex.printStackTrace();
                        }
                 }
             }


                 //PO Line Number
                 if(poLineNumber!=null) {
                     erks.addScript(fctx, "document.getElementById('" + ("pt1:t1:"+selectedRowNum+":it381::content") + "').value = '"+poLineNumber.intValue()+"'");
                 }

                 //Quantity
                 if(quantity!=null) {
                     quantity = quantity.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                     erks.addScript(fctx,
//                         "if("+ getJavascriptStringEmptyCheckExpressionStr( "pt1:t1:"+selectedRowNum+":it23::content" ) + " || " + getJavascriptStringValueCheckExpressionStr ( "pt1:t1:"+selectedRowNum+":it23::content", "0" ) + " ) {" +
//                                getJavascriptElementSetValueExpressionStr(  "pt1:t1:"+selectedRowNum+":it23::content", "'"+quantity.doubleValue()+"'") +
//                         "}"
                            getJavascriptElementSetValueExpressionStr(  "pt1:t1:"+selectedRowNum+":it23::content", "'"+quantity+"'")
                     );
                 }

                 //UOM
                 if(uom!=null) {
                     erks.addScript(fctx,
                        getJavascriptElementSetValueExpressionStr(  "pt1:t1:"+selectedRowNum+":it26::content", "'"+uom+"'")
                     );
                 }



                 //Unit Price
                 if(unitPrice!=null) {
                     unitPrice = unitPrice.setScale(5, BigDecimal.ROUND_HALF_EVEN);
                     erks.addScript(fctx,
                        getJavascriptElementSetValueExpressionStr(  "pt1:t1:"+selectedRowNum+":it29::content", "'"+unitPrice.doubleValue()+"'")
                     );
                 }


                 //Line Description
                 if(lineDesctiption!=null) {
                     erks.addScript(fctx,
//                         "if("+ getJavascriptStringEmptyCheckExpressionStr( "pt1:t1:"+selectedRowNum+":it27::content" ) + ") {" +
//                                getJavascriptElementSetValueExpressionStr(  "pt1:t1:"+selectedRowNum+":it27::content", "'"+lineDesctiption+"'") +
//                         "}"
                            getJavascriptElementSetValueExpressionStr(  "pt1:t1:"+selectedRowNum+":it27::content", "'"+lineDesctiption+"'")
                    );


                /*Added on 16th August*/
                //Tax Rate Code
                if(taxRateCode!=null) {
                        erks.addScript(fctx, "document.getElementById('" + ("pt1:t1:"+selectedRowNum+":it30::content") + "').value = '"+taxRateCode+"'");
                       // BigDecimal taxRate = taxamountStaticCalculation(taxRateCode);
                       // double calculatedTax = (lineTotalAmount==null?0.0:lineTotalAmount.doubleValue()) * (taxRate==null?0.0:taxRate.doubleValue()) / 100.0;
                        //erks.addScript(fctx, "document.getElementById('" + ("pt1:t1:"+selectedRowNum+":it59::content") + "').value = '"+taxamount+"'");
                }
                //16th August Code ends


                //Line Total
                if(unitPrice!=null) {
                         //double lineTotal = quantity.doubleValue()*unitPrice.doubleValue();
                         //erks.addScript(fctx, "document.getElementById('" + ("pt1:t1:"+selectedRowNum+":it34::content") + "').value = parseFloat('"+ lineTotal +"').toFixed(2)");

                         String quantityValue = "pt1:t1:"+selectedRowNum+":it23::content"; //Quantity inputtxt id : it23
                         String unitPriceValue = "pt1:t1:"+selectedRowNum+":it29::content"; //UnitPrice inputtxt id : it29

                         String lineTotalAmount = "pt1:t1:"+selectedRowNum+":it18::content"; //UnitPrice inputtxt id : it18
                         erks.addScript(fctx,
                             "if(!"+getJavascriptIsNaNExpressionStr(quantityValue)+" && !"+getJavascriptIsNaNExpressionStr(unitPriceValue)+") { " +
                             " document.getElementById('"+lineTotalAmount+"').value = (parseFloat(document.getElementById('"+quantityValue+"').value) * parseFloat(document.getElementById('" + unitPriceValue + "').value)).toFixed(2);" +
                             "}");

                     if(taxAmount!=null) {
                         double calculatedTaxAmount = taxAmount.doubleValue()*0.01;
                         //erks.addScript(fctx, "document.getElementById('" + ("pt1:t1:"+selectedRowNum+":ot7::content") + "').value = parseFloat('"+ taxAmount +"').toFixed(2)");


                         String script =
                         "if( !isNaN(parseFloat(document.getElementById('"+lineTotalAmount+"').value)) && "+calculatedTaxAmount+">=0.0) { " +
                          "    document.getElementById('"+"pt1:t1:"+selectedRowNum+":it59::content"+"').value = (parseFloat(document.getElementById('"+lineTotalAmount+"').value) * "+calculatedTaxAmount+").toFixed(2)" +
                         "}";

                         //set tax amount from line total calculated above ; TaxAmount inputtxt id : it59
                         erks.addScript(fctx, script);

                     }

                     AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);

                 }

                 erks.addScript(fctx, "document.getElementById('"+"pt1:t1:"+selectedRowNum+":it381::content"+"').focus();");
                 erks.addScript(fctx, "AdfActionEvent.queue(AdfPage.PAGE.findComponentByAbsoluteId('" + "pt1:t1:"+selectedRowNum+":it381" + "'), true);");

             }
                AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
                p27.hide();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            }
        finally{
                    if(lineItemRSIter!=null) {
                        try {
                            lineItemRSIter.closeRowSetIterator();
                        }catch(Exception ex) {
                            ex.printStackTrace();

                        }
                    }
                    if(empRSIter!=null) {
                        try {
                            empRSIter.closeRowSetIterator();
                        } catch(Exception ex) {
                            ex.printStackTrace();

                        }
                    }
                }

        System.out.println("selectPOLineNumPopup : ENDS");
    }

    public void cancelPOLineNumPopup(ActionEvent actionEvent) {
        //System.out.println("Start: cancelLinePONumber");
        poLineNumPopupIt.setValue("");
        p27.hide();

        //System.out.println("End: cancelLinePONumber");
    }

    public void setPoLineNumberTable(RichTable poLineNumberTable) {
        this.poLineNumberTable = poLineNumberTable;
    }

    public RichTable getPoLineNumberTable() {
        return poLineNumberTable;
    }

    public void setP27(RichPopup p27) {
        this.p27 = p27;
    }

    public RichPopup getP27() {
        return p27;
    }


    public void setPoLineNumPopupIt(RichInputText poLineNumPopupIt) {
        this.poLineNumPopupIt = poLineNumPopupIt;
    }

    public RichInputText getPoLineNumPopupIt() {
        return poLineNumPopupIt;
    }

    public void onPoLineNumPopUpGoClick(ActionEvent actionEvent) {


        System.out.println("onPoLineNumPopUpGoClick : STARTS");

        String enteredPonumber = null;
        RowKeySet rowKeySet = lineItemsTable.getSelectedRowKeys();
        Iterator rowKeySetIt = rowKeySet.iterator();
        DCIteratorBinding lineItemIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("LineItemDetailsEOView1Iterator");
        RowSetIterator lineItemRSIter=null;
        try{
            lineItemRSIter = lineItemIter.getRowSetIterator();
         while(rowKeySetIt.hasNext()){
           Key key = (Key)((List)rowKeySetIt.next()).get(0);
           Row currentRow = lineItemRSIter.getRow(key);
             if(currentRow!=null) {
                System.out.println("----- typedInPONumber ----- "+currentRow.getAttribute("LinePoNum"));

                enteredPonumber = currentRow.getAttribute("LinePoNum")==null?"":currentRow.getAttribute("LinePoNum").toString().trim();
             }
         }
        }catch(Exception e)
        {
            e.printStackTrace();
            }
        finally{
                    if(lineItemRSIter!=null) {
                        try {
                            lineItemRSIter.closeRowSetIterator();
                        } catch(Exception ex) {
                            ex.printStackTrace();

                    }
                    }
                }
        String enteredPoLineNum=null;
        try {
            if(poLineNumPopupIt.getValue() != null) {
                            enteredPoLineNum = poLineNumPopupIt.getValue().toString();
                            System.out.println("poLineNumPopupIt.getValue(): "+enteredPoLineNum);
                            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POLineNumberDetailsVO1Iterator");
                            ViewObjectImpl poLineNumVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                            ViewCriteria vc = poLineNumVO.getViewCriteria("POLineDetailsVOCriteria_lookupForLineNum");
                            poLineNumVO.applyViewCriteria(vc);
                            poLineNumVO.setNamedWhereClauseParam("po_number", enteredPonumber);
                            poLineNumVO.setNamedWhereClauseParam("po_line_number", enteredPoLineNum);
                            poLineNumVO.executeQuery();
                            AdfFacesContext.getCurrentInstance().addPartialTarget(poLineNumberTable);

            }
            else if(poLineNumPopupIt.getValue() == null) {
                            enteredPoLineNum = poLineNumPopupIt.getValue().toString();
                            System.out.println("poLineNumPopupIt.getValue(): "+enteredPoLineNum);
                            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POLineNumberDetailsVO1Iterator");
                            ViewObjectImpl poLineNumVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                            ViewCriteria vc = poLineNumVO.getViewCriteria("POLineDetailsVOCriteria");
                            poLineNumVO.applyViewCriteria(vc);
                            poLineNumVO.setNamedWhereClauseParam("po_number", enteredPonumber);
                            poLineNumVO.executeQuery();
                            AdfFacesContext.getCurrentInstance().addPartialTarget(poLineNumberTable);

            }

            }
        catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("onPoLineNumPopUpGoClick : ENDS");

    }


    public boolean validateLinePOs(){

        System.out.println("validateLinePOs : starts");

        RowSetIterator lineItemItr = null;
        DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
        ViewObjectImpl lineVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
        System.out.println("------------lineVO Count validatelineDescription(): "+lineVO.getEstimatedRowCount());
        lineItemItr = lineVO.createRowSetIterator(null);
        boolean isValidLineLevelPONum = true;
        boolean isValidPOLineNum = true;
        boolean validateFlag = true;
        Integer line ;
        String message = null;
        oracle.jbo.domain.Number supplierId = null;
        String siteId  = siteIdIt.getValue().toString();

        try{

                            DCBindingContainer bindings = getBindings();
                            DCIteratorBinding dcIteratorBindings =
                            bindings.findIteratorBinding("HeaderDetailsEOView1Iterator");
                            ViewObject headerVO = dcIteratorBindings.getViewObject();
                            Row headerRow = headerVO.getCurrentRow();
                            if (headerRow != null) {

                                    supplierId = (oracle.jbo.domain.Number)headerRow.getAttribute("SupplierId");

                                }

                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }

        while(lineItemItr.hasNext()) {
            Row lineRow = lineItemItr.next();
            String lineLevelPONum = lineRow.getAttribute("LinePoNum").toString(); // Line Level PO
            String poLineNum = lineRow.getAttribute("PoLineNum").toString(); // PO Line NO
            isValidLineLevelPONum = validateLineLevelPONumbers(lineLevelPONum);
            isValidPOLineNum = validatePOLineNumbers(poLineNum,supplierId,siteId,lineLevelPONum);

            if(!isValidLineLevelPONum){

                validateFlag = false;
                line = ((oracle.jbo.domain.Number)lineRow.getAttribute("LineNumber")).intValue();
                //923018***********Start
               // message="Please Enter valid Line Level PO No in line "+ line +" before submitting the invoice";
                message =
                "<html>This Supplier requires a valid & open Purchase Order (PO). See Procurement SharePoint page for Qantas Group Purchasing Policy & Guidelines.<br><br>" +"You must enter the valid & approved PO number below and match PO line/s.<br>" +
                "Ensure you receipt your PO in iProcurement to process your invoice for payment.<br><br>" +
                "<a href = \"mailto: procurementhelp@qantas.com.au\">Contact procurementhelp@qantas.com.au for assistance if required</a>" +
                "</html>";
                //923018***** End
                callFacesMessage(message);
                break;
            }

            if(!isValidPOLineNum){

                validateFlag = false;
                line = ((oracle.jbo.domain.Number)lineRow.getAttribute("LineNumber")).intValue();
                //923018***********Start
               // message="Please Enter valid PO Line No in line "+ line +" before submitting the invoice";
                message =
                    "<html>This Supplier requires a valid & open Purchase Order (PO). See Procurement SharePoint page for Qantas Group Purchasing Policy & Guidelines.<br><br>" +"You must enter the valid & approved PO number below and match PO line/s.<br>" +
                    "Ensure you receipt your PO in iProcurement to process your invoice for payment.<br><br>" +
                    "<a href = \"mailto: procurementhelp@qantas.com.au\">Contact procurementhelp@qantas.com.au for assistance if required</a>" +
                    "</html>";
                    //923018***** End
                callFacesMessage(message);
                break;

            }

        }

        System.out.println("validateLinePOs : ends");
        return validateFlag;

    }

    public boolean validateLineLevelPONumbers(String lineLevelPONum){


        System.out.println("PO Numbers in validateLineLevelPONumbers : "+lineLevelPONum);
        boolean validLineLevelPOFlag = true;
        if(siteIdIt.getValue() != null) {

                                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POVO1Iterator");
                                ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                                ViewCriteria vc = poNOVO.getViewCriteria("POVOCriteria2");
                                poNOVO.applyViewCriteria(vc);
                                poNOVO.setNamedWhereClauseParam("bindPONum", lineLevelPONum);
                                poNOVO.setNamedWhereClauseParam("bindSiteId", siteIdIt.getValue().toString().trim());
                                poNOVO.executeQuery();

                                if(poNOVO.getEstimatedRowCount() == 0){

                                    validLineLevelPOFlag = false;
                                }

                        }
        System.out.println("Is line level PO valid ? : "+validLineLevelPOFlag);
        return validLineLevelPOFlag;
    }


    public boolean validatePOLineNumbers(String poLineNum,oracle.jbo.domain.Number supplierId,String siteId,String enteredPonumber){

        RowSetIterator rs = null;
        BigDecimal poLineNumber = null;
        boolean validPOLineNumberFlag = true;
        System.out.println("validatePOLineNumbers : STARTS");

                                System.out.println("----- Filtering line items PO by supplier ID and site ID");
                                DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                                DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("POLineNumberDetailsVO1Iterator");
                                ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
                                ViewCriteria vc = poNOVO.getViewCriteria("POLineNumberDetailsVOCriteria");
                                poNOVO.applyViewCriteria(vc);
                                poNOVO.setNamedWhereClauseParam("po_number", enteredPonumber);
                                poNOVO.setNamedWhereClauseParam("vendor_id", supplierId);
                                poNOVO.setNamedWhereClauseParam("site_id",   siteId);
                                poNOVO.setNamedWhereClauseParam("po_line_number",   poLineNum);
                                poNOVO.executeQuery();

                                if(poNOVO.getEstimatedRowCount() == 0){
                                    validPOLineNumberFlag = false;
                                }
                    if(rs !=null){
                        try{
                            rs.closeRowSetIterator();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }

        System.out.println("Is PO line no valid ? : "+validPOLineNumberFlag);
        return validPOLineNumberFlag;


    }

    //JavaScript Functions

    private static String getJavascriptElementByIdExpressionStr(String componentId) {
        return "document.getElementById('" + componentId + "').value";
    }

    private static String getJavascriptStringEmptyCheckExpressionStr(String componentId) {
        String str = getJavascriptElementByIdExpressionStr(componentId);
        return str + "==null || " + str + "==''";
    }

    private static String getJavascriptStringValueCheckExpressionStr(String componentId, String value) {
        String str = getJavascriptElementByIdExpressionStr(componentId);
        return str + "=='"+value+"'";
    }

    private static String getJavascriptElementSetValueExpressionStr(String componentId, String value) {
        return getJavascriptElementByIdExpressionStr(componentId) + " = " + value + ";";
    }

    private static String getJavascriptIsNaNExpressionStr(String componentId) {
        String str = getJavascriptElementByIdExpressionStr(componentId);
        return "isNaN( parseFloat(" + str + ") )";
    }

    private boolean isValidHeaderPO(String poNum) {

        boolean isValidPoNum = true;

        System.out.println("Validating PO only if PO Number is Present");
        DCBindingContainer dcBindingContainer1 = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcIteratorBinding1 = dcBindingContainer1.findIteratorBinding("PoNoCertifierVO1Iterator");
        ViewObjectImpl poNOVO = (ViewObjectImpl)dcIteratorBinding1.getViewObject();
        ViewCriteria vc1 = poNOVO.getViewCriteria("PoNoCertifierVOCriteriaEqualsPONum");
        poNOVO.applyViewCriteria(vc1);
        poNOVO.setNamedWhereClauseParam("bindPONum", poNum);
        poNOVO.setNamedWhereClauseParam("bindOperatingUnit", operatingUnitIt.getValue()==null?"":operatingUnitIt.getValue().toString().trim());
        poNOVO.setNamedWhereClauseParam("bindSupplierName", supplierName.getValue()==null?"":supplierName.getValue().toString().trim());
        poNOVO.setNamedWhereClauseParam("bindSiteID", siteIdIt.getValue()==null?"":siteIdIt.getValue().toString().trim());

        poNOVO.executeQuery();
        //System.out.println("poNOVO.getEstimatedRowCount()"+poNOVO.getEstimatedRowCount());
        if(poNOVO.getEstimatedRowCount() != 1)
            isValidPoNum = false;

        System.out.println("isValidPoNum"+isValidPoNum);


        return isValidPoNum;
    }

    private boolean validTaxRateCode() {


        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer bindings = (DCBindingContainer)bc.getCurrentBindingsEntry();
        DCIteratorBinding glIter = bindings.findIteratorBinding("LineItemDetailsEOView1Iterator");
        Integer line;
        boolean flag_validCode = false;
        if (glIter != null && glIter.getRowSetIterator().getRowCount() > 0) {
            RowSetIterator rsi =null;
            try{
               rsi= glIter.getViewObject().createRowSetIterator(null);
            Row glRow;
            while (rsi.next() != null) {
                glRow = rsi.getCurrentRow();
                System.out.println("GlNo LineNo ::" + glRow.getAttribute("LineNumber"));
                line = (glRow.getAttribute("LineNumber")==null) ? null : ((oracle.jbo.domain.Number)glRow.getAttribute("LineNumber")).intValue();
                System.out.println(" Line ::" +line);

                String message=null;

                /****tax rate code gbp issue fix****/
                if (glRow.getAttribute("TaxRateCode") != null ) {

                    //isValidGLCode = false;
                    String enteredTaxrate =glRow.getAttribute("TaxRateCode").toString();
                    System.out.println("GBP ISSUE ::: enteredTaxrate "+ enteredTaxrate);

                   /**check if entered Taxrate falls with the validtax rate code **/


                   DCBindingContainer dcBindingContainer_tax = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
                   DCIteratorBinding dcIteratorBinding_tax = dcBindingContainer_tax.findIteratorBinding("TaxRateCodeLookupVO1Iterator");
                   ViewObjectImpl taxRateCodeVO = (ViewObjectImpl)dcIteratorBinding_tax.getViewObject();
                   ViewCriteria vc1_tax = taxRateCodeVO.getViewCriteria("TaxRateCodeLookupVOCriteria_lookupBySiteId");
                    taxRateCodeVO.applyViewCriteria(vc1_tax);
                   taxRateCodeVO.setNamedWhereClauseParam("bind_siteId", siteIdIt.getValue()==null?"":siteIdIt.getValue().toString().trim());
                   taxRateCodeVO.setNamedWhereClauseParam("bind_taxRateCode",glRow.getAttribute("TaxRateCode").toString());
                   taxRateCodeVO.executeQuery();
                    System.out.println("taxRateCodeVO.executeQuery() gbp issue "+taxRateCodeVO.getEstimatedRowCount());

                    while (taxRateCodeVO.hasNext()) {
                     Row row = taxRateCodeVO.next(); // Get the next row in the result set.
                        System.out.println("taxratecode of the current line row ::"+row.getAttribute("TaxRateCode"));

                        if(row.getAttribute("TaxRateCode")!=null && row.getAttribute("TaxRateCode").toString().equals(enteredTaxrate)){
                            flag_validCode=true;
                        }


                   } //end of while loop for taxrate check
                    if(!flag_validCode){
                        message="The tax rate code entered by you in line "+line+"is invalid. Please re-enter a valid tax rate code in order to submit";
                        callFacesMessage(message);
                        break;
                    }

                   /**check if entered Taxrate falls with the validtax rate code **/

                }



    }
            }catch(Exception e){
                e.printStackTrace();
                }finally{
                if(rsi != null){
                    rsi.closeRowSetIterator();
                }
                }
        }

        return flag_validCode;
    }



    public void setPoNumClientID(RichInputText poNumClientID) {
        this.poNumClientID = poNumClientID;
    }

    public RichInputText getPoNumClientID() {
        return poNumClientID;
    }


    public void setIsLineItemPopup(RichInputText isLineItemPopup) {
        this.isLineItemPopup = isLineItemPopup;
    }

    public RichInputText getIsLineItemPopup() {
        return isLineItemPopup;
    }

    public void setIsPOLineItemPopup(RichInputText isPOLineItemPopup) {
        this.isPOLineItemPopup = isPOLineItemPopup;
    }

    public RichInputText getIsPOLineItemPopup() {
        return isPOLineItemPopup;
    }

    public void setLinePONumClientID(RichInputText linePONumClientID) {
        this.linePONumClientID = linePONumClientID;
    }

    public RichInputText getLinePONumClientID() {
        return linePONumClientID;
    }

    public void setPoLineNumClientID(RichInputText poLineNumClientID) {
        this.poLineNumClientID = poLineNumClientID;
    }

    public RichInputText getPoLineNumClientID() {
        return poLineNumClientID;
    }

    public void onValueChangeProjectNo(ValueChangeEvent valueChangeEvent) {
        System.out.println("onValueChangeProjectNo start");


        String newValue = valueChangeEvent.getNewValue() == null ? null : valueChangeEvent.getNewValue().toString().trim();
        System.out.println("new Value : " +newValue);


                                DCBindingContainer dcb = (DCBindingContainer)getBindings();
                                DCIteratorBinding dcItr = dcb .findIteratorBinding("LineItemDetailsEOView1Iterator");
                                RowSetIterator rsIter = dcItr .getRowSetIterator();
                                Row rowObj = rsIter .getCurrentRow();

                                System.out.println("Values before refereshing");
                                System.out.println("Current Row project no : " + rowObj.getAttribute("ProjectNo"));
                                System.out.println("Current Row lineNo : " + rowObj.getAttribute("LineNumber"));
                                System.out.println("Current Row ExpOrg : " + rowObj.getAttribute("ExpinditureOrg"));
                                System.out.println("Current Row taskID : " + rowObj.getAttribute("Attr3"));
                                System.out.println("Current Row ExpenditureDate : " + rowObj.getAttribute("ExpenditureDate"));

                                if(newValue == null || newValue.equals("")){

                                rowObj.setAttribute("Attr4", null); // projectID
                                rowObj.setAttribute("TaskNo", null); // taskNo
                                rowObj.setAttribute("Attr3", null); // taskID
                                rowObj.setAttribute("ExpinditureOrg", null); // ExpOrg
                                rowObj.setAttribute("Attr10", null); // ExpType
                                rowObj.setAttribute("ExpenditureDate", null); // ExpDate




                                AdfFacesContext.getCurrentInstance().addPartialTarget(lineItemsTable);
                                    System.out.println("Refresh done");
                                }

                                System.out.println("ProjectValueChangeEnd");
    }


    private String checkLineAmountMagnitude() {

            String magnitudeError = null;
            System.out.println("Start : checkLineAmountMagnitude");
            DCBindingContainer dcBindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            DCIteratorBinding dcIteratorBinding = dcBindingContainer.findIteratorBinding("LineItemDetailsEOView1Iterator");
            ViewObjectImpl lineVO = (ViewObjectImpl)dcIteratorBinding.getViewObject();
            RowSetIterator lineItemItr = null;
            lineItemItr = lineVO.createRowSetIterator(null);
            ArrayList<Double> list_of_lineAmount = new ArrayList<Double>();
            ArrayList<Double> list_of_taxAmount = new ArrayList<Double>();
            try{

                   while(lineItemItr.hasNext()) {

                         Row row = lineItemItr.next();
                         if(row != null){
                             if(row.getAttribute("LineTotalAmount") != null){
                                 //firstLineTotalVal = Double.parseDouble(row.getAttribute("LineTotalAmount").toString().trim());
                                 list_of_lineAmount.add(Double.parseDouble(row.getAttribute("LineTotalAmount").toString().trim()));

                             }
                             if(row.getAttribute("TaxAmountLineitem") != null){

                                 list_of_taxAmount.add(Double.parseDouble(row.getAttribute("TaxAmountLineitem").toString().trim()));
                             }
                         }

                    }
            }                catch(Exception e){
                    e.printStackTrace();
                    }finally{
                        if(lineItemItr != null)
                            lineItemItr.closeRowSetIterator();
                    }

                for(Double ob : list_of_lineAmount){
                    System.out.println("list_of_lineAmount val : "+ob.doubleValue());
                    if((list_of_lineAmount.get(0).doubleValue() > 0 && ob.doubleValue() < 0) || (list_of_lineAmount.get(0).doubleValue() > 0 && ob.doubleValue() < 0)){
                        return "Line Amount values in LineItems cannot have both positive and negative values";
                    }

                }

                 for(Double ob : list_of_taxAmount){
                     System.out.println("list_of_taxAmount val : "+ob.doubleValue());
                     if((list_of_taxAmount.get(0).doubleValue() > 0 && ob.doubleValue() < 0) || (list_of_taxAmount.get(0).doubleValue() > 0 && ob.doubleValue() < 0)){
                         return "Tax Amount values in LineItems cannot have both positive and negative values";
                     }
                 }

        return magnitudeError;
    }

    public void setDocumentTypeIT(RichInputText documentTypeIT) {
        this.documentTypeIT = documentTypeIT;
    }

    public RichInputText getDocumentTypeIT() {
        return documentTypeIT;
    }

    public void setElectRemittenceLink(RichCommandImageLink electRemittenceLink) {
        this.electRemittenceLink = electRemittenceLink;
    }

    public RichCommandImageLink getElectRemittenceLink() {
        return electRemittenceLink;
    }

    public void setElectRemittencePopUpIt(RichInputText electRemittencePopUpIt) {
        this.electRemittencePopUpIt = electRemittencePopUpIt;
    }

    public RichInputText getElectRemittencePopUpIt() {
        return electRemittencePopUpIt;
    }

    public void setElectRemittencePopup(RichPopup electRemittencePopup) {
        this.electRemittencePopup = electRemittencePopup;
    }

    public RichPopup getElectRemittencePopup() {
        return electRemittencePopup;
    }

    public void setInvNumIt(RichInputText invNumIt) {
        this.invNumIt = invNumIt;
    }

    public RichInputText getInvNumIt() {
        return invNumIt;
    }
    //NO PO 923018- Start
    public void setNoPOErrorMessage(RichOutputText noPOErrorMessage) {
        this.noPOErrorMessage = noPOErrorMessage;
    }

    public RichOutputText getNoPOErrorMessage() {
        return noPOErrorMessage;
    }

    public void setNoPOPanelGroupLaylout(RichPanelGroupLayout noPOPanelGroupLaylout) {
        this.noPOPanelGroupLaylout = noPOPanelGroupLaylout;
    }

    public RichPanelGroupLayout getNoPOPanelGroupLaylout() {
        return noPOPanelGroupLaylout;
    }
    ////NO PO 923018 -End
} //End of Class
