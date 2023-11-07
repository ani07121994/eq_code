package ap.quantas.com.ebsCalculateInvoiceDueDateWebService;

public class TestClient {
  
    
    public static String calculateInvoiceDueDate(String supplierId, String siteId, String invoiceDate) {        
        String calculatedDueDate = null;        
        try {
            java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
            cal.setTime(new java.text.SimpleDateFormat("dd/MM/yyyy").parse(invoiceDate));       
            
            DueDateServicePttBindingQSService service = new DueDateServicePttBindingQSService();
            
            ap.quantas.com.ebsCalculateInvoiceDueDateWebService.ObjectFactory objFact = new ap.quantas.com.ebsCalculateInvoiceDueDateWebService.ObjectFactory();
            
            ap.quantas.com.ebsCalculateInvoiceDueDateWebService.APPSINVOICEHEADERREC record = objFact.createAPPSINVOICEHEADERREC();
            ap.quantas.com.ebsCalculateInvoiceDueDateWebService.InputParameters input = objFact.createInputParameters();
            input.setPINVOICEIN( objFact.createInputParametersPINVOICEIN(record) );
            
            input.getPINVOICEIN().getValue().setSUPPLIERID( objFact.createAPPSINVOICEHEADERRECSUPPLIERID( new java.math.BigDecimal( supplierId  ) ) );        
            input.getPINVOICEIN().getValue().setSITEID( objFact.createAPPSINVOICEHEADERRECSITEID( new java.math.BigDecimal( siteId  ) ) );
            input.getPINVOICEIN().getValue().setINVOICEDATE( objFact.createAPPSINVOICEHEADERRECINVOICEDATE( javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(cal) ) );         
            
            ap.quantas.com.ebsCalculateInvoiceDueDateWebService.OutputParameters output = service.getDueDateServicePttBindingQSPort().dueDateService(input);
            
            if(output.getPINVOICEIN().getValue().getHEADERATT5()!=null) {
                calculatedDueDate = output.getPINVOICEIN().getValue().getHEADERATT5().getValue();
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return calculatedDueDate;
    }
    
  
                                    
    
    public static void main(String a[]) {
        
        
        String supplierId = "105970";   
       
        String siteId = "122112";
        String invoiceDate = "27/02/2016";
        String calculatedDueDate1 = calculateInvoiceDueDate(supplierId, siteId, invoiceDate);
        
        System.out.println("---calculatedDueDate--by supplier id---"+calculatedDueDate1);
        
      
    }
}
