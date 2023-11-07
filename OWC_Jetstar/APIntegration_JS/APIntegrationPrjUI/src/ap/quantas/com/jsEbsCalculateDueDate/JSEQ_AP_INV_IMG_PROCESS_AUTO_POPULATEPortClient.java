package ap.quantas.com.jsEbsCalculateDueDate;


import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.GregorianCalendar;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102)

public class JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEPortClient
{
  @WebServiceRef
  private static JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEService jSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEService;


  public static void main1(String [] args){
      
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      final String dateStr = "02/02/1998";
      
      try{
      final Date date = format.parse(dateStr);

      GregorianCalendar gregory = new GregorianCalendar();
      gregory.setTime(date);

      XMLGregorianCalendar calendar = DatatypeFactory.newInstance()
              .newXMLGregorianCalendar(
                  gregory);
          
          System.out.println("Calendar ::" +calendar);
      
          }catch(Exception e){
            StackTraceElement[] element = e.getStackTrace();
        }
      
  }


  public static void main(String [] args)
  {
    /* jSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEService = new JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEService();
    JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE_ptt jSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE_ptt = jSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEService.getJSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEPort(); */
    
    String supplierId = "25981"; 
    String siteID = "170524";
    String invoiceDT = "22/06/2017";
    String invoiceScanDate ="18-JAN-2017";

    String calculatedDueDate1 = calculateInvoiceDueDate(supplierId, siteID, invoiceDT,invoiceScanDate);
   // System.out.println("calculated due date :"+calculatedDueDate1);
    
  }
  
    public static String calculateInvoiceDueDate(String supplierId, String siteID, String invoiceDT,String invScanDate) {   
        String calculatedDueDate = null;
        try {
            System.out.println("*****Main: Start ***************");   
            System.out.println("invoiceDT  from calculateInvoiceDueDate:: "+invoiceDT); 
            jSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEService =
                    new JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEService();
            System.out.println("After initializing");
            ObjectFactory objectFactory = new ObjectFactory();
            BigDecimal valDouble = new BigDecimal(supplierId);
            BigDecimal siteIdTemp = new BigDecimal(siteID);
            JAXBElement<BigDecimal> supllierId =
                objectFactory.createAPPSJSEQINVOICEHEADERRECSUPPLIERID(valDouble);
            JAXBElement<BigDecimal> siteId =
                objectFactory.createAPPSJSEQINVOICEHEADERRECSITEID(siteIdTemp);
            //SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
    //            String strdate = invoiceDT;
    JAXBElement<String> invoiScaDate=objectFactory.createAPPSJSEQINVOICEHEADERRECHEADERATT6(invScanDate) ;
            Date utilDate = null;
          /*  
            try {
                utilDate = dateformat.parse(invoiceDT);
                System.out.println("utilDate :" + utilDate);
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            //XMLGregorianCalendar sampleDate = toXMLGregorianCalendar(utilDate);
            //           XMLGregorianCalendar sampleDate=toXMLGregorianCalendar(new Date(2016,8,27));
            //System.out.println(" Sample Date : " + sampleDate);
            JAXBElement<XMLGregorianCalendar> invoiceDate =
                objectFactory.createAPPSJSEQINVOICEHEADERRECINVOICEDATE(toXMLGregorianCalendar(dateformat.parse(invoiceDT)));
            APPSJSEQINVOICEHEADERREC invoiceHeaderObj =
                objectFactory.createAPPSJSEQINVOICEHEADERREC();
            //           invoiceHeaderObj.setCERTIFIERNAME(certifierName);
            invoiceHeaderObj.setSUPPLIERID(supllierId);
            invoiceHeaderObj.setSITEID(siteId);
            invoiceHeaderObj.setINVOICEDATE(invoiceDate);
            invoiceHeaderObj.setHEADERATT6(invoiScaDate);
            JAXBElement<APPSJSEQINVOICEHEADERREC> parentObj =
                objectFactory.createInputParametersPINVOICEIN(invoiceHeaderObj);
            InputParameters inputParam = objectFactory.createInputParameters();
            inputParam.setPINVOICEIN(parentObj);
            //            DueDateServicePtt dueDateService_ptt =
            //                dueDateService_pttBindingQSService.getDueDateService_pttBindingQSPort();
            JSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE_ptt jSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE_ptt = jSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEService.getJSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATEPort();
            System.out.println("***bef executing dueDateService_ptt***");
            //            OutputParameters ouptputParam =
            //                dueDateService_ptt.dueDateService(inputParam);
            OutputParameters ouptputParam =
                jSEQ_AP_INV_IMG_PROCESS_AUTO_POPULATE_ptt.jseqAPINVIMGPROCESSAUTOPOPULATE(inputParam);
            System.out.println("***after executing dueDateService_ptt***");
            System.out.println("***ouptputParam***" + ouptputParam);
            if (ouptputParam != null) {
                System.out.println("***** getPINVOICEIN **" +
                                   ouptputParam.getPINVOICEIN());
                if (ouptputParam.getPINVOICEIN() != null) {
                    
                    //System.out.println("***** getValue ::"+ouptputParam.getPINVOICEIN().getValue().getHEADERATT6().getValue());
                    
                    
                    
                    if (ouptputParam.getPINVOICEIN().getValue().getHEADERATT5() !=
                        null) {
                        calculatedDueDate =
                                ouptputParam.getPINVOICEIN().getValue().getHEADERATT5().getValue();
                        System.out.println("***** calculatedDueDate ::"+calculatedDueDate);
                        
                    }

                }
            }
            
            System.out.println("*****Main: End ***************");
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return calculatedDueDate;
    }
    
    public static XMLGregorianCalendar toXMLGregorianCalendar(Date date){
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            ex.printStackTrace();
        }
        return xmlCalendar;
    }
}
