package ap.quantas.com.js.eQApprovalService;

import ap.quantas.com.js_eQApprovalService.JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTLService;

import ap.quantas.com.js_eQApprovalService.JSEQ_AP_INV_IMG_PROCESS_APPROVER_DTL_ptt;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

public class TestClient {
    

    public static void main(String[] args) {


        try {
            
          /*  JSEQAPINVIMGPROCESSAPPROVERDTLService service =
                new JSEQAPINVIMGPROCESSAPPROVERDTLService();
            JSEQAPINVIMGPROCESSAPPROVERDTLPtt port =
                service.getJSEQAPINVIMGPROCESSAPPROVERDTLPort();

            ObjectFactory objectFactory = new ObjectFactory();
            InputParameters inputParameters =
                objectFactory.createInputParameters();

            APPSQFEQIFAPINVINVINFO APPSQFEQIFAPINVINVINFO =
                new APPSQFEQIFAPINVINVINFO();
            APPSQFEQIFAPINVINVINFO.setALTERNETAPPROVERNUMBER(objectFactory.createAPPSQFEQIFAPINVINVINFOALTERNETAPPROVERNUMBER("209502"));
            APPSQFEQIFAPINVINVINFO.setREQUESTERNUMBER(objectFactory.createAPPSQFEQIFAPINVINVINFOREQUESTERNUMBER("205739"));
            APPSQFEQIFAPINVINVINFO.setINVOICEAMOUNT(objectFactory.createAPPSQFEQIFAPINVINVINFOINVOICEAMOUNT(new BigDecimal(1000.0)));
            APPSQFEQIFAPINVINVINFO.setORGID(objectFactory.createAPPSQFEQIFAPINVINVINFOORGID(new BigDecimal(7092.0)));

            inputParameters.setINVDETAILS(objectFactory.createInputParametersINVDETAILS(APPSQFEQIFAPINVINVINFO));


            APPSQFEQIFAPINVINVDISTTBLTYP invHeaderTableTypeOnject =
                objectFactory.createAPPSQFEQIFAPINVINVDISTTBLTYP();


            APPSQFEQIFAPINVINVDISTINFO lineitem =
                new APPSQFEQIFAPINVINVDISTINFO();
            lineitem.setLINENUMBER(objectFactory.createAPPSQFEQIFAPINVINVDISTINFOLINENUMBER(new BigDecimal(1.0)));
            lineitem.setLINETYPE(objectFactory.createAPPSQFEQIFAPINVINVDISTINFOLINETYPE("ITEM"));
            lineitem.setGLCODECOMB(objectFactory.createAPPSQFEQIFAPINVINVDISTINFOGLCODECOMB("IM.576712.705800.000000.00"));


            ArrayList<APPSQFEQIFAPINVINVDISTINFO> lineitems =
                new ArrayList<APPSQFEQIFAPINVINVDISTINFO>();
            lineitems.add(lineitem);

            invHeaderTableTypeOnject.invdistdtlitem = lineitems;


            inputParameters.setINVDISTDTL(objectFactory.createInputParametersINVDISTDTL(invHeaderTableTypeOnject));


            OutputParameters outputParameters =
                port.jseqAPINVIMGPROCESSAPPROVERDTL(inputParameters);
            
            
            System.out.println("----- NEW CODE : "+outputParameters.getOUTRESULT().getValue().getOUTRESULTITEM().size());*/
            
            
            
            
                        List<APPSQFEQIFAPINVINVDISTINFO> invoiceLineItemdetailsList =new ArrayList<APPSQFEQIFAPINVINVDISTINFO>();
                        ObjectFactory objectFactory1 =new ObjectFactory();
                        APPSQFEQIFAPINVINVDISTINFO lineItemobj=new APPSQFEQIFAPINVINVDISTINFO();
                        lineItemobj.setLINENUMBER( objectFactory1.createAPPSQFEQIFAPINVINVDISTINFOLINENUMBER(new BigDecimal(1)));
                        lineItemobj.setLINETYPE( objectFactory1.createAPPSQFEQIFAPINVINVDISTINFOLINETYPE("ITEM"));
                        lineItemobj.setGLCODECOMB( objectFactory1.createAPPSQFEQIFAPINVINVDISTINFOGLCODECOMB("IM.576712.705800.000000.00"));

                        invoiceLineItemdetailsList.add(lineItemobj);                    
                        invoiceLineItemdetailsList.add(lineItemobj);                    
                        
                      
                      
                      
                      getApproverDetails("209502", "205739", new BigDecimal(500), new BigDecimal(7092), invoiceLineItemdetailsList);
            
            
            
            

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        
    }
    
    
    
    public static List<APPSQFEQIFAPINVAPPROVERREC> getApproverDetails(String reqesterNumber,
                                            String alternateApprvNumber,
                                            BigDecimal invoiceamount,
                                            BigDecimal orgid, List<APPSQFEQIFAPINVINVDISTINFO> lineItemTableDetails){
        
        
        System.out.println("***** Inside getApproverDetails   reqesterNumber :: "+reqesterNumber+"::alternateApprvNumber ::"+ alternateApprvNumber +
                           "::invoiceamount ::"+ invoiceamount +"::orgid::" +orgid);
        
        
        
       // List<APPSQFEQIFAPINVINVDISTINFO> newList = new ArrayList<APPSQFEQIFAPINVINVDISTINFO>();
       //             newList = lineItemTableDetails;

        
        System.out.println("Printing data inside getApproverDetails :: " );            
        for (int i = 0; i < lineItemTableDetails.size(); i++) {
            
            System.out.println("getLinenumber" +
                                               lineItemTableDetails.get(i).getLINENUMBER().getValue());
                            System.out.println("getLinetype" +
                                               lineItemTableDetails.get(i).getLINETYPE().getValue());
                            System.out.println("getGlcodecomb" +
                                               lineItemTableDetails.get(i).getGLCODECOMB().getValue());   
        }
        
        
        
        
    JSEQAPINVIMGPROCESSAPPROVERDTLService service =
        new JSEQAPINVIMGPROCESSAPPROVERDTLService();
    JSEQAPINVIMGPROCESSAPPROVERDTLPtt port =
        service.getJSEQAPINVIMGPROCESSAPPROVERDTLPort();
        
        ObjectFactory objectFactory =new  ObjectFactory();
        InputParameters inputParams= objectFactory.createInputParameters();
        
        APPSQFEQIFAPINVINVINFO invoiceHeaderObj =  objectFactory.createAPPSQFEQIFAPINVINVINFO();
        invoiceHeaderObj.setALTERNETAPPROVERNUMBER(objectFactory.createAPPSQFEQIFAPINVINVINFOALTERNETAPPROVERNUMBER(alternateApprvNumber));
        invoiceHeaderObj.setINVOICEAMOUNT(objectFactory.createAPPSQFEQIFAPINVINVINFOINVOICEAMOUNT(invoiceamount));
        invoiceHeaderObj.setORGID(objectFactory.createAPPSQFEQIFAPINVINVINFOORGID(orgid));
        invoiceHeaderObj.setREQUESTERNUMBER(objectFactory.createAPPSQFEQIFAPINVINVINFOREQUESTERNUMBER(reqesterNumber));
        
        
        inputParams.setINVDETAILS(objectFactory.createInputParametersINVDETAILS(invoiceHeaderObj));
        
        APPSQFEQIFAPINVINVDISTTBLTYP invHeaderTableTypeOnject = objectFactory.createAPPSQFEQIFAPINVINVDISTTBLTYP();
        invHeaderTableTypeOnject.invdistdtlitem =lineItemTableDetails;
        
        inputParams.setINVDISTDTL(objectFactory.createInputParametersINVDISTDTL(invHeaderTableTypeOnject));
        
        
        
        OutputParameters ouptputParams =port.jseqAPINVIMGPROCESSAPPROVERDTL(inputParams);
        
        if(ouptputParams!=null){
            
            System.out.println("***** getApproverDetails getPINVOICEIN **" +
                                           ouptputParams.getOUTRESULT().getValue().getOUTRESULTITEM().size());
    
            System.out.println("Inside getApproverDetails Status" +
                               ouptputParams.getSTATUS().getValue());
            System.out.println("Inside getApproverDetails message" +
                               ouptputParams.getMESSAGE().getValue());
            
    
                        
            if(ouptputParams.getOUTRESULT()!=null){
                APPSQFEQIFAPINVAPRVROUTTBLTP outputResultItem = ouptputParams.getOUTRESULT().getValue();
               // System.out.println("Inside getApproverDetails appapprovelimit" + outputResultItem.getOUTRESULTITEM().get(0).appapprovelimit);     
                List<APPSQFEQIFAPINVAPPROVERREC> listOutput =outputResultItem.getOUTRESULTITEM();  
    
                if(listOutput!=null && listOutput.size()>0) {
                    for(APPSQFEQIFAPINVAPPROVERREC listItem :listOutput) {
                        System.out.println("Printing the listitem ");
                        System.out.println("Inside getApproverDetails appapprovelimit" + listItem.appapprovelimit!=null ?listItem.appapprovelimit.getValue() :"appapprovelimit is blank");
                        System.out.println("Inside getApproverDetails appemail"+listItem.appemail!=null ? listItem.appemail.getValue() : "appemail is blank");
                        System.out.println("Inside getApproverDetails appposition"+listItem.appposition!=null ? listItem.appposition.getValue(): "appposition is blank");
                        System.out.println("Inside getApproverDetails appfndlcategory"+listItem.appfndlcategory!=null ? listItem.appfndlcategory.getValue() : "appfndlcategory is blank" );
                        System.out.println("Inside getApproverDetails appemail"+listItem.appemail!=null ? listItem.appemail.getValue() : "appemail is blank");
    
                            
                        
                    }
                }           
            
            
            return listOutput;
            
            
        }
              
    
   
    
}
              return null;

          }
}





