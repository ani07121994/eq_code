package ap.quantas.com;

import java.util.Iterator;

import java.util.List;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.model.RowKeySet;

public class AuditBean {
    private RichPopup approveCommentsPopUp;
    private RichInputText approveCommentsPopUpIt;
    private RichPopup rejectionCommentsPopUp;
    private RichInputText rejectionCommentsPopUpIt;

    private RichTable auditTable;
    private boolean approveCommentFlag;
    private boolean rejectionCommentFlag;
    private boolean reassignCommentFlag;
    private boolean apCommentFlag;
    private RichOutputText approveComments;
    private RichOutputText rejectionComments;
    private RichPopup apCommentsPopUp;
    private RichInputText apCommentsPopUpIt;
    private RichPopup reassignCommentsPopUp;
    private RichInputText reassignCommentsPopUpIt;
    private RichOutputText reassignComments;
    private RichOutputText apOperationComments;

    public AuditBean() {
        super();
    }
    
    public void setRejectionCommentFlag(boolean rejectionCommentFlag) {
        this.rejectionCommentFlag = rejectionCommentFlag;
    }

    public boolean isRejectionCommentFlag() {
        rejectionCommentFlag = false;
        if(rejectionComments.getValue() != null){
            if(rejectionComments.getValue().toString().length() >= 40)
                rejectionCommentFlag = true;
        }
        
        return rejectionCommentFlag;
    }
    
    public void setApproveCommentFlag(boolean approveCommentFlag) {
        this.approveCommentFlag = approveCommentFlag;
    }

    public boolean isApproveCommentFlag() {
        approveCommentFlag = false;
        if(approveComments.getValue() != null){
            if(approveComments.getValue().toString().length() >= 40)
                approveCommentFlag = true;
        }
        
        return approveCommentFlag;
    } 
    
    public void setReassignCommentFlag(boolean reassignCommentFlag) {
        this.reassignCommentFlag = reassignCommentFlag;
    }

    public boolean isReassignCommentFlag() {
        reassignCommentFlag = false;
        if(reassignComments.getValue() != null){
            if(reassignComments.getValue().toString().length() >= 40)
                reassignCommentFlag = true;
        }
        
        return reassignCommentFlag;
    }

    public void setApCommentFlag(boolean apCommentFlag) {
        this.apCommentFlag = apCommentFlag;
    }

    public boolean isApCommentFlag() {
        apCommentFlag = false;
        if(apOperationComments.getValue() != null){
            if(apOperationComments.getValue().toString().length() >= 40)
                apCommentFlag = true;
        }
        
        return apCommentFlag;
    }
    
    
    
    public void showAuditDetails(){
    
    try{
       // if(invoiceID != null) {
            //For Audit Table Details 
            String invoiceId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("invoiceId");
            System.out.println("Invoice ' Id="+invoiceId);
            ViewObjectImpl auditTableVO = Utility.getAm().getAuditTableVO1();
            //ViewCriteria vc = auditTableVO.getViewCriteria("AuditTableVOCriteria_byInvoiceID");
            //auditTableVO.applyViewCriteria(vc);
            auditTableVO.setNamedWhereClauseParam("bindInvoiceID", invoiceId);
            auditTableVO.executeQuery();
        
            RowSetIterator auditTableVOIt = auditTableVO.createRowSetIterator(null);
            while(auditTableVOIt.hasNext()) {
                Row row = auditTableVOIt.next();
                
                long InvalidReasonId = row.getAttribute("InvalidReasonId") == null ? -1 : ((java.math.BigDecimal)row.getAttribute("InvalidReasonId")).longValue();
                long InvalidReasonTypeId = row.getAttribute("InvalidReasonTypeId") == null ? -1 : ((java.math.BigDecimal)row.getAttribute("InvalidReasonTypeId")).longValue();
                
                String InvalidReason = PropertyLoader.getInstance().getReasonCodeMap().get(InvalidReasonId);
                String InvalidReasonType = PropertyLoader.getInstance().getReasonCodeTypeMap().get(InvalidReasonId).get(InvalidReasonTypeId);
                if(InvalidReason==null) {
                    InvalidReason = "";
                }
                if(InvalidReasonType==null) {
                    InvalidReasonType = "";
                }
                row.setAttribute("InvalidReason",InvalidReason);
                row.setAttribute("InvalidReasonType",InvalidReasonType);
            
            }
            
            
            
            System.out.println("Count Header Rows: "+auditTableVO.getEstimatedRowCount());
            
    
    
      //  }
    }
    catch(Exception e){
        e.printStackTrace();
        }
    }

   
    private DCBindingContainer getBinding() {
        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer bindings = (DCBindingContainer)bc.getCurrentBindingsEntry();
        return bindings;
    }
    
    public void onCertifierApproveCommentsClick(ActionEvent actionEvent) {
        // Add event code here... 
        System.out.println("Start onCertifierApproveCommentsClick");
            String approveCommentsVal = null;
        try{
                RowKeySet rowKeySet = auditTable.getSelectedRowKeys();    
                 Iterator rowKeySetIt = rowKeySet.iterator();            
                 DCIteratorBinding auditTableIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("AuditTableVO1Iterator");
                 RowSetIterator auditTableRSIter = auditTableIter.getRowSetIterator();
                 
                  while(rowKeySetIt.hasNext()){
                    Key key = (Key)((List)rowKeySetIt.next()).get(0);
                    Row currentRow = auditTableRSIter.getRow(key);
                      if(currentRow!=null) {
                         System.out.println("----- Certifier Approve Comments ----- "+currentRow.getAttribute("CertifierApproveComments")); 
                         approveCommentsVal = currentRow.getAttribute("CertifierApproveComments")==null?"":currentRow.getAttribute("CertifierApproveComments").toString().trim();
                      }
                      System.out.println("approveCommentsVal" + approveCommentsVal);
                  }
        
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    approveCommentsPopUpIt.setValue(approveCommentsVal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(approveCommentsPopUpIt);
                    approveCommentsPopUp.show(hints);        
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                
                System.out.println("End onCertifierApproveCommentsClick");
        }
            
    
    
        

    public void setApproveCommentsPopUp(RichPopup approveCommentsPopUp) {
        this.approveCommentsPopUp = approveCommentsPopUp;
    }

    public RichPopup getApproveCommentsPopUp() {
        return approveCommentsPopUp;
    }

    public void setApproveCommentsPopUpIt(RichInputText approveCommentsPopUpIt) {
        this.approveCommentsPopUpIt = approveCommentsPopUpIt;
    }

    public RichInputText getApproveCommentsPopUpIt() {
        return approveCommentsPopUpIt;
    }

    public void onApproveCommentsPopupOKClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start : onApproveCommentsPopupOKClick");
        approveCommentsPopUp.hide();
        
        System.out.println("End : onApproveCommentsPopupOKClick");
    }

    public void onCertifierRejectionCommentsClick(ActionEvent actionEvent) {
       
        System.out.println("Start onCertifierRejectionCommentsClick");
        String rejectionCommentsVal = null;
        try{
                    RowKeySet rowKeySet = auditTable.getSelectedRowKeys();    
                     Iterator rowKeySetIt = rowKeySet.iterator();            
                     DCIteratorBinding auditTableIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("AuditTableVO1Iterator");
                     RowSetIterator auditTableRSIter = auditTableIter.getRowSetIterator();
                     
                      while(rowKeySetIt.hasNext()){
                        Key key = (Key)((List)rowKeySetIt.next()).get(0);
                        Row currentRow = auditTableRSIter.getRow(key);
                          if(currentRow!=null) {
                             System.out.println("----- Certifier Rejection Comments ----- "+currentRow.getAttribute("CertifierRejComments")); 
                             rejectionCommentsVal = currentRow.getAttribute("CertifierRejComments")==null?"":currentRow.getAttribute("CertifierRejComments").toString().trim();
                          }
                          System.out.println("rejectionCommentsVal" + rejectionCommentsVal);
                      }
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    rejectionCommentsPopUpIt.setValue(rejectionCommentsVal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(rejectionCommentsPopUpIt);
                    rejectionCommentsPopUp.show(hints);        
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                
        System.out.println("End onCertifierRejectionCommentsClick");
    }

    public void setRejectionCommentsPopUp(RichPopup rejectionCommentsPopUp) {
        this.rejectionCommentsPopUp = rejectionCommentsPopUp;
    }

    public RichPopup getRejectionCommentsPopUp() {
        return rejectionCommentsPopUp;
    }

    public void setRejectionCommentsPopUpIt(RichInputText rejectionCommentsPopUpIt) {
        this.rejectionCommentsPopUpIt = rejectionCommentsPopUpIt;
    }

    public RichInputText getRejectionCommentsPopUpIt() {
        return rejectionCommentsPopUpIt;
    }

    public void onRejectionCommentsPopupOKClick(ActionEvent actionEvent) {
        
        System.out.println("Start : onRejectionCommentsPopupOKClick");
        rejectionCommentsPopUp.hide();
        
        System.out.println("End : onRejectionCommentsPopupOKClick");
    }


    public void setAuditTable(RichTable auditTable) {
        this.auditTable = auditTable;
    }

    public RichTable getAuditTable() {
        return auditTable;
    }

    public void setApproveComments(RichOutputText approveComments) {
        this.approveComments = approveComments;
    }

    public RichOutputText getApproveComments() {
        return approveComments;
    }

    public void setRejectionComments(RichOutputText rejectionComments) {
        this.rejectionComments = rejectionComments;
    }

    public RichOutputText getRejectionComments() {
        return rejectionComments;
    }


    public void setApCommentsPopUp(RichPopup apCommentsPopUp) {
        this.apCommentsPopUp = apCommentsPopUp;
    }

    public RichPopup getApCommentsPopUp() {
        return apCommentsPopUp;
    }

    public void setApCommentsPopUpIt(RichInputText apCommentsPopUpIt) {
        this.apCommentsPopUpIt = apCommentsPopUpIt;
    }

    public RichInputText getApCommentsPopUpIt() {
        return apCommentsPopUpIt;
    }

    public void onApCommentsPopupOKClick(ActionEvent actionEvent) {
        // Add event code here...
        
        System.out.println("Start : onApCommentsPopupOKClick");
        apCommentsPopUp.hide();
        
        System.out.println("End : onApCommentsPopupOKClick");
    }

    public void setReassignCommentsPopUp(RichPopup reassignCommentsPopUp) {
        this.reassignCommentsPopUp = reassignCommentsPopUp;
    }

    public RichPopup getReassignCommentsPopUp() {
        return reassignCommentsPopUp;
    }

    public void setReassignCommentsPopUpIt(RichInputText reassignCommentsPopUpIt) {
        this.reassignCommentsPopUpIt = reassignCommentsPopUpIt;
    }

    public RichInputText getReassignCommentsPopUpIt() {
        return reassignCommentsPopUpIt;
    }

    public void onReassignCommentsPopupOKClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start : onReassignCommentsPopupOKClick");
        reassignCommentsPopUp.hide();
        
        System.out.println("End : onReassignCommentsPopupOKClick");
    }

    public void onCertifierReassignCommentsClick(ActionEvent actionEvent) {
        
        System.out.println("Start onCertifierReassignCommentsClick");
        String reassignCommentsVal = null;
        try{
                    RowKeySet rowKeySet = auditTable.getSelectedRowKeys();    
                     Iterator rowKeySetIt = rowKeySet.iterator();            
                     DCIteratorBinding auditTableIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("AuditTableVO1Iterator");
                     RowSetIterator auditTableRSIter = auditTableIter.getRowSetIterator();
                     
                      while(rowKeySetIt.hasNext()){
                        Key key = (Key)((List)rowKeySetIt.next()).get(0);
                        Row currentRow = auditTableRSIter.getRow(key);
                          if(currentRow!=null) {
                             System.out.println("----- Certifier Reassign Comments ----- "+currentRow.getAttribute("CertifierReassignComments")); 
                             reassignCommentsVal = currentRow.getAttribute("CertifierReassignComments")==null?"":currentRow.getAttribute("CertifierReassignComments").toString().trim();
                          }
                          System.out.println("reassignCommentsVal" + reassignCommentsVal);
                      }
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    reassignCommentsPopUpIt.setValue(reassignCommentsVal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(reassignCommentsPopUpIt);
                    reassignCommentsPopUp.show(hints);        
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                
        System.out.println("End onCertifierReassignCommentsClick");
        
    }


    public void setReassignComments(RichOutputText reassignComments) {
        this.reassignComments = reassignComments;
    }

    public RichOutputText getReassignComments() {
        return reassignComments;
    }

    public void onAPOperationCommentsClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start onAPOperationCommentsClick");
        String apCommentsVal = null;
        try{
                    RowKeySet rowKeySet = auditTable.getSelectedRowKeys();    
                     Iterator rowKeySetIt = rowKeySet.iterator();            
                     DCIteratorBinding auditTableIter = ((DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry()).findIteratorBinding("AuditTableVO1Iterator");
                     RowSetIterator auditTableRSIter = auditTableIter.getRowSetIterator();
                     
                      while(rowKeySetIt.hasNext()){
                        Key key = (Key)((List)rowKeySetIt.next()).get(0);
                        Row currentRow = auditTableRSIter.getRow(key);
                          if(currentRow!=null) {
                             System.out.println("----- AP Operation Comments ----- "+currentRow.getAttribute("ApOperationComments")); 
                             apCommentsVal = currentRow.getAttribute("ApOperationComments")==null?"":currentRow.getAttribute("ApOperationComments").toString().trim();
                          }
                          System.out.println("apCommentsVal" + apCommentsVal);
                      }
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    apCommentsPopUpIt.setValue(apCommentsVal);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(apCommentsPopUpIt);
                    apCommentsPopUp.show(hints);        
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                
        System.out.println("End onAPOperationCommentsClick");
    }

    public void setApOperationComments(RichOutputText apOperationComments) {
        this.apOperationComments = apOperationComments;
    }

    public RichOutputText getApOperationComments() {
        return apOperationComments;
    }
}
