package ap.quantas.com.ebsCalculateInvoiceDueDateWebService;
import java.math.BigDecimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.WebServiceRef;
import java.util.Date;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 130224.1947.04102)

public class DueDateService_pttBindingQSPortClient
{
  @WebServiceRef
  private static DueDateServicePttBindingQSService dueDateService_pttBindingQSService;

    public static void main(String[] args) {
        try {
            String supplierId = "472463"; 
            String siteID = "513648";
            String invoiceDT = "15/09/2015";
            String invScanDate="15-SEP-2015 00:00:00";
            //System.out.println("call");
            String calculatedDueDate1 = calculateInvoiceDueDate(supplierId, siteID, invoiceDT,invScanDate);

            System.out.println("---calculatedDueDate--by supplier id---"+calculatedDueDate1);            

        } catch (Exception e) {
            e.printStackTrace();
        }
           
     }
    
    public static String calculateInvoiceDueDate(String supplierId, String siteID, String invoiceDT,String invScanDate) {   
        String calculatedDueDate = null;
        try {
            //System.out.println("*****Main: Start ***************");            
            dueDateService_pttBindingQSService =
                    new DueDateServicePttBindingQSService();
            System.out.println("After initializing");
            ObjectFactory objectFactory = new ObjectFactory();
            BigDecimal valDouble = new BigDecimal(supplierId);
            BigDecimal siteIdTemp = new BigDecimal(siteID);
            JAXBElement<BigDecimal> supllierId =
                objectFactory.createAPPSINVOICEHEADERRECSUPPLIERID(valDouble);
            JAXBElement<BigDecimal> siteId =
                objectFactory.createAPPSINVOICEHEADERRECSITEID(siteIdTemp);
            //SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
//            String strdate = invoiceDT;
            Date utilDate = null;
            Date utilDate1=null;
            try {
                utilDate = dateformat.parse(invoiceDT);
                System.out.println("utilDate :" + utilDate);
               /* utilDate1 = dateformat.parse(invScanDate);
                System.out.println("utilDate1 :" + utilDate1);*/
            } catch (ParseException e) {
                e.printStackTrace();
            }
            XMLGregorianCalendar sampleDate = toXMLGregorianCalendar(utilDate);
          //  XMLGregorianCalendar sampleDate1 = toXMLGregorianCalendar(utilDate1);
            //           XMLGregorianCalendar sampleDate=toXMLGregorianCalendar(new Date(2016,8,27));
            //System.out.println(" Sample Date : " + sampleDate);
//System.out.println(" Sample Date : " + sampleDate1);
            JAXBElement<XMLGregorianCalendar> invoiceDate =
                objectFactory.createAPPSINVOICEHEADERRECINVOICEDATE(sampleDate);
           
            JAXBElement<String> invoiScaDate=objectFactory.createAPPSINVOICEHEADERRECHEADERATT6(invScanDate);
                
            APPSINVOICEHEADERREC invoiceHeaderObj =
                objectFactory.createAPPSINVOICEHEADERREC();
            //           invoiceHeaderObj.setCERTIFIERNAME(certifierName);
            invoiceHeaderObj.setSUPPLIERID(supllierId);
            invoiceHeaderObj.setSITEID(siteId);
            invoiceHeaderObj.setINVOICEDATE(invoiceDate);
            invoiceHeaderObj.setHEADERATT6(invoiScaDate);
            JAXBElement<APPSINVOICEHEADERREC> parentObj =
                objectFactory.createInputParametersPINVOICEIN(invoiceHeaderObj);
            InputParameters inputParam = objectFactory.createInputParameters();
            inputParam.setPINVOICEIN(parentObj);
            //            DueDateServicePtt dueDateService_ptt =
            //                dueDateService_pttBindingQSService.getDueDateService_pttBindingQSPort();
            DueDateServicePtt dueDateService_ptt =
                dueDateService_pttBindingQSService.getDueDateServicePttBindingQSPort();
            //System.out.println("***bef executing dueDateService_ptt***");
            //            OutputParameters ouptputParam =
            //                dueDateService_ptt.dueDateService(inputParam);
            OutputParameters ouptputParam =
                dueDateService_ptt.dueDateService(inputParam);
            //System.out.println("***after executing dueDateService_ptt***");
            System.out.println("***ouptputParam***" + ouptputParam);
            if (ouptputParam != null) {
                System.out.println("***** getPINVOICEIN **" +
                                   ouptputParam.getPINVOICEIN());
                if (ouptputParam.getPINVOICEIN() != null) {
                    System.out.println("***** getValue ::" +
                                       ouptputParam.getPINVOICEIN().getValue());
                    if (ouptputParam.getPINVOICEIN().getValue().getHEADERATT5() !=
                        null) {
                        calculatedDueDate =
                                ouptputParam.getPINVOICEIN().getValue().getHEADERATT5().getValue();
                        
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


