package ap.qantas.com.eQApprovalDetailsService;

import javax.xml.bind.JAXBElement;
import java.math.BigDecimal;

import java.util.ArrayList;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.ws.WebServiceRef;

public class ApproverDetails_pttBindingQSPortClient {
    @WebServiceRef
      private static ApproverDetailsPttBindingQSService approverDetails_pttBindingQSService;

      public static void main(String [] args)
      {
        System.out.println("CALLING PROXY SERVICE");
          try {
              String reqestorNumber = "287759"; 
              String alternateApprvNumber = "320665";
    //          String invoiceamount="5000";
    //          BigDecimal invoiceamount = new BigDecimal(1999999999999999);
              BigDecimal invoiceamount = new BigDecimal(5000);
              BigDecimal orgid =new BigDecimal(106);
      

              BigDecimal lineNo=new BigDecimal(1);
              String lineType="ITEM";
              String glCodeComb1="QF.100010.300000.000000.00";
              String glCodeComb2="QF.100134.520000.000000.00";
              
              List<LineItemTable> lineItemTableDetails = new ArrayList<LineItemTable>();
              LineItemTable obj1= new LineItemTable();
              obj1.setLinenumber(lineNo);
              obj1.setLinetype(lineType);
              obj1.setGlcodecomb(glCodeComb1);
              
              LineItemTable obj2=new LineItemTable();
              obj2.setLinenumber(lineNo);
              obj2.setLinetype(lineType);
              obj2.setGlcodecomb(glCodeComb2);

              
              lineItemTableDetails.add(0, obj1);
              lineItemTableDetails.add(1, obj2);
              
    //          List approverList = getApproverDetails(reqestorNumber, alternateApprvNumber, invoiceamount,orgid,lineItemTable);
              
    //          getApproverDetails(reqestorNumber, alternateApprvNumber, invoiceamount,orgid,lineItemTableDetails);
              System.out.println("******After final execution*****");        

          } catch (Exception e) {
              e.printStackTrace();
          }
        
        // Add your code to call the desired methods.
      }
        public static List<APPSQFEQIFAPINVAPPROVERREC> getApproverDetails(String reqestorNumber,
                                              String alternateApprvNumber,
                                              BigDecimal invoiceamount,
                                              BigDecimal orgid,
                                              List<APPSQFEQIFAPINVINVDISTINFO> lineItemTableDetails) {
            String calculatedDueDate = null;
            List<APPSQFEQIFAPINVAPPROVERREC> listOutput =null;
            try {
                System.out.println("*****Main: Start ***************");
                approverDetails_pttBindingQSService =
                        new ApproverDetailsPttBindingQSService();

                System.out.println("After initializing");
                ObjectFactory objectFactory =
                    new ObjectFactory();


                BigDecimal invAmount = invoiceamount;
                //            BigDecimal orgID = new BigDecimal(orgid);
                JAXBElement<String> jaxRequesternumber =
                    objectFactory.createAPPSQFEQIFAPINVINVINFOREQUESTERNUMBER(reqestorNumber);
                JAXBElement<String> jaxAlternetapprovernumber =
                    objectFactory.createAPPSQFEQIFAPINVINVINFOALTERNETAPPROVERNUMBER(alternateApprvNumber);
                JAXBElement<BigDecimal> jaxInvoiceAmount =
                    objectFactory.createAPPSQFEQIFAPINVINVINFOINVOICEAMOUNT(invAmount);
                JAXBElement<BigDecimal> jaxOrgid =
                    objectFactory.createAPPSQFEQIFAPINVINVINFOORGID(orgid);

                //            APPSINVOICEHEADERREC invoiceHeaderObj =
                //                objectFactory.createAPPSINVOICEHEADERREC();
                APPSQFEQIFAPINVINVINFO invoiceHeaderObj =
                    objectFactory.createAPPSQFEQIFAPINVINVINFO();
                //           invoiceHeaderObj.setCERTIFIERNAME(certifierName);
                invoiceHeaderObj.setREQUESTERNUMBER(jaxRequesternumber);
                invoiceHeaderObj.setALTERNETAPPROVERNUMBER(jaxAlternetapprovernumber);
                invoiceHeaderObj.setINVOICEAMOUNT(jaxInvoiceAmount);
                invoiceHeaderObj.setORGID(jaxOrgid);

                JAXBElement<APPSQFEQIFAPINVINVINFO> parentObj =
                    objectFactory.createInputParametersINVDETAILS(invoiceHeaderObj);

                InputParameters inputParam =
                    objectFactory.createInputParameters();

                //            inputParam.setPINVOICEIN(parentObj);
                inputParam.setINVDETAILS(parentObj);

                System.out.println("get Individual details" +
                                   inputParam.getINVDETAILS());

                /* ****************************************************** */

    //            List<LineItemTable> newList = new ArrayList<LineItemTable>();
                List<APPSQFEQIFAPINVINVDISTINFO> newList = new ArrayList<APPSQFEQIFAPINVINVDISTINFO>();
                newList = lineItemTableDetails;
                //            BigDecimal lineNo = null;
                System.out.println("***Size Of New List***" + newList.size());
                for (int i = 0; i < newList.size(); i++) {

                    //                if( newList.get(0) != null ) {
                    //                    if( newList.get(0) instanceof BigDecimal ) {
                    //                        lineNo = (new BigDecimal(newList.get(0)));
                    //                        System.out.println("***LINE NO ::"+lineNo);
                    //                    }
                    //                }
    //                System.out.println("getLinenumber" +
    //                                   newList.get(0).getLinenumber());
    //                System.out.println("getLinetype" +
    //                                   newList.get(0).getLinetype());
    //                System.out.println("getGlcodecomb" +
    //                                   newList.get(0).getGlcodecomb());
    //
                    System.out.println("getLinenumber" +
                                       newList.get(i).getLINENUMBER());
                    System.out.println("getLinetype" +
                                       newList.get(i).getLINETYPE());
                    System.out.println("getGlcodecomb" +
                                       newList.get(i).getGLCODECOMB());
                    



                }
    //            List<APPSQFEQIFAPINVINVDISTINFO> invoiceLineItemdetailsList =
    //                new ArrayList<APPSQFEQIFAPINVINVDISTINFO>();
    //            APPSQFEQIFAPINVINVDISTINFO lineInnerDetails1 =
    //                new APPSQFEQIFAPINVINVDISTINFO();
    //            APPSQFEQIFAPINVINVDISTINFO lineInnerDetails2 =
    //                new APPSQFEQIFAPINVINVDISTINFO();
                for (int i = 0; i < newList.size(); i++) {

                    System.out.println("Size >>" + newList.size());
    //                JAXBElement<BigDecimal> linenumber =
    //                    objectFactory.createAPPSQFEQIFAPINVINVDISTINFOLINENUMBER(new BigDecimal(1));
    //                JAXBElement<String> linetype =
    //                    objectFactory.createAPPSQFEQIFAPINVINVDISTINFOLINETYPE("Type");
    //                JAXBElement<String> glcodecomb =
    //                    objectFactory.createAPPSQFEQIFAPINVINVDISTINFOGLCODECOMB("QF.100010.300000.000000.00");
    //
    //                JAXBElement<BigDecimal> linenumber2 =
    //                    objectFactory.createAPPSQFEQIFAPINVINVDISTINFOLINENUMBER(new BigDecimal(1));
    //                JAXBElement<String> linetype2 =
    //                    objectFactory.createAPPSQFEQIFAPINVINVDISTINFOLINETYPE("Type");
    //                JAXBElement<String> glcodecomb2 =
    //                    objectFactory.createAPPSQFEQIFAPINVINVDISTINFOGLCODECOMB("QF.100134.520000.000000.00");
    //
    //                System.out.println("JAXBElement<BigDecimal> linenumber" +
    //                                   linenumber);
    //                System.out.println("JAXBElement<String> linetype" + linetype);
    //                System.out.println("JAXBElement<String> glcodecomb" +
    //                                   glcodecomb);

    //                lineInnerDetails1.setLINENUMBER(linenumber);
    //                lineInnerDetails1.setLINETYPE(linetype);
    //                lineInnerDetails1.setGLCODECOMB(glcodecomb);
    //
    //                lineInnerDetails2.setLINENUMBER(linenumber2);
    //                lineInnerDetails2.setLINETYPE(linetype2);
    //                lineInnerDetails2.setGLCODECOMB(glcodecomb2);


    //                invoiceLineItemdetailsList.add(lineInnerDetails1);
    //                invoiceLineItemdetailsList.add(lineInnerDetails2);

                }

                APPSQFEQIFAPINVINVDISTTBLTYP invHeaderTableTypeOnject = objectFactory.createAPPSQFEQIFAPINVINVDISTTBLTYP();
    //            invHeaderTableTypeOnject.invdistdtlitem = invoiceLineItemdetailsList;
                invHeaderTableTypeOnject.invdistdtlitem =lineItemTableDetails;


                JAXBElement<APPSQFEQIFAPINVINVDISTTBLTYP> invHeaderSecondOnject =objectFactory.createInputParametersINVDISTDTL(invHeaderTableTypeOnject);
                inputParam.setINVDISTDTL(invHeaderSecondOnject);
                System.out.println("getLineItemDetails" +
                                   inputParam.getINVDISTDTL());


                ApproverDetailsPtt approverDetails_ptt =
                    approverDetails_pttBindingQSService.getApproverDetailsPttBindingQSPort();
                System.out.println("***bef executing approverDetails_ptt***");

               OutputParameters ouptputParam =
                    approverDetails_ptt.approverDetails(inputParam);

                System.out.println("***after executing approverDetails_ptt***");
                System.out.println("***ouptputParam***" + ouptputParam);

                if (ouptputParam != null) {
                    System.out.println("***** getPINVOICEIN **" +
                                       ouptputParam.getOUTRESULT());

                    System.out.println("Status" +
                                       ouptputParam.getSTATUS().getValue());
                    System.out.println("message" +
                                       ouptputParam.getMESSAGE().getValue());
                    
                    if(ouptputParam!=null &&  ouptputParam.getMESSAGE()!=null && ouptputParam.getMESSAGE().getValue()!=null && ouptputParam.getMESSAGE().getValue().equals("NO APPROVWER FOUND")){
                        return null;
                    }
                    

                    JAXBElement<APPSQFEQIFAPINVAPRVROUTTBLTP> parentOutput =
                        ouptputParam.getOUTRESULT();
                    
                    if(parentOutput!=null){
                    APPSQFEQIFAPINVAPRVROUTTBLTP output = parentOutput.getValue();
                        
                    listOutput =output.outresultitem;
                   
                    
                    System.out.println("Size of output list::" +
                                       listOutput.size());

                    for (int i = 0; i < listOutput.size(); i++) {

                        System.out.println("**********OUTPUT List SIZE::" +
                                           listOutput.size());
                        String approvername1 =
                            listOutput.get(i).getAPPNAME().getValue();
                        String appoverEmail1 =
                            listOutput.get(i).getAPPEMAIL().getValue();
                        BigDecimal appempno1 =
                            listOutput.get(i).getAPPEMPNO().getValue();
                        String appposition1 =
                            listOutput.get(i).getAPPPOSITION().getValue();
                        

            
    //                Long testVal= listOutput.get(i).
    //                    System.out.println("&&&&testVal&&&&"+testVal);
    //                    JAXBElement<BigDecimal> appapprovelimit1 =
    //                        listOutput.get(i).getAPPAPPROVELIMIT();
    //                    System.out.println("listOutput.get(i).getAPPAPPROVELIMIT().getValue()++++++++++"+listOutput.get(i).getAPPAPPROVELIMIT());
    //                    String getAPPAPPROVELIMITString= String.valueOf(listOutput.get(i).getAPPAPPROVELIMIT().getValue());
    //                    System.out.println("+++++++getAPPAPPROVELIMITString++++++"+getAPPAPPROVELIMITString);
    //                    
    //                    long appapprovelimit2 = listOutput.get(i).getAPPAPPROVELIMIT().getValue();
    //                    System.out.println("appapprovelimit*****************"+appapprovelimit2);
                        
                       
                        
    //                    
    //                    BigDecimal test=new BigDecimal("999999999999999");
    //                    long lVal= test.longValue();
    //                    System.out.println("lVal::"+lVal);

                        System.out.println("approvername1" + "****" + i + "****" +
                                           approvername1);
                        System.out.println("appoverEmail1" + "****" + i + "****" +
                                           appoverEmail1);
                        System.out.println("appempno1" + "****" + i + "****" +
                                           appempno1);
                        System.out.println("appposition1" + "****" + i + "****" +
                                           appposition1);
                        
    //                    System.out.println("appapprovelimit1" + "****" + i +
    //                                       "****" + appapprovelimit1);
    //                    System.out.println("aproverLimitLongVal" + "****" + i +
    //                                       "****" + appapprovelimit2);


                    }
                    }

                }

                System.out.println("*****Main: End ***************");
            } catch (Exception e) {
                // TODO: Add catch code
                e.printStackTrace();
            }
            return listOutput;
        }
}
