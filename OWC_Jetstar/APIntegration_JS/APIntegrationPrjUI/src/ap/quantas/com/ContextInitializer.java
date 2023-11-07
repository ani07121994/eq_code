package ap.quantas.com;

import java.math.BigDecimal;

import java.util.HashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import model.APOperationAMImpl;
import model.APOperationAMImpl;
//import model.EbsAMImpl;
import model.EbsAMImpl;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.client.Configuration;
import oracle.jbo.server.ViewObjectImpl;

public class ContextInitializer implements ServletContextListener {
    public ContextInitializer() {
        super();
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context Initialized during deployment");
        
        System.out.println("--- loading properties ---");
        
        ApplicationModule am1 = null;
        try {
            String amDef = "model.APOperationAM";
            String config = "APOperationAMLocal";
            am1 = Configuration.createRootApplicationModule(amDef, config);
            APOperationAMImpl eqfilesDB;
            eqfilesDB = (APOperationAMImpl) am1;

            ViewObjectImpl vo = eqfilesDB.getPropertyTableVO1();
            RowSetIterator rowsetIt = vo.createRowSetIterator(null);
            while(rowsetIt.hasNext()) {
                Row row = rowsetIt.next();
                PropertyLoader.getInstance().addProperty((String)row.getAttribute("Name"), (String)row.getAttribute("Value"));
            }
            
            //HashMap<Long, HashMap<Long, String>> 
            ViewObjectImpl invalidReasonVO = eqfilesDB.getReasonInvalidCodeVO1();                
            ViewObjectImpl invalidReasonTypeVO = eqfilesDB.getReasonInvalidTypeVO1();
                
            invalidReasonVO.executeQuery();    
            RowSetIterator invalidReasonVOIt = invalidReasonVO.createRowSetIterator(null);
            
            
            while(invalidReasonVOIt.hasNext()) {
                Row row = invalidReasonVOIt.next();                
                long reasonCodeId = ((java.math.BigDecimal)row.getAttribute("Id")).longValue();
                String reasonCode = (String)row.getAttribute("ReasonType");
                
                //System.out.println("---reasonCodeId---"+reasonCodeId+", reasonCode---"+reasonCode);
                PropertyLoader.getInstance().getReasonCodeMap().put(reasonCodeId, reasonCode);
                
                             
                invalidReasonTypeVO.setNamedWhereClauseParam("bvReasonId", reasonCodeId);
                invalidReasonTypeVO.executeQuery();
                RowSetIterator invalidReasonTypeVOIt = invalidReasonTypeVO.createRowSetIterator(null);
                
                HashMap<Long, String> reasonTypeMap =  new HashMap<Long, String>();
                while(invalidReasonTypeVOIt.hasNext()) {
                    Row innerRow = invalidReasonTypeVOIt.next(); 
                    
                    long reasonTypeId = ((java.math.BigDecimal)innerRow.getAttribute("Id")).longValue();
                    String reasonType = (String)innerRow.getAttribute("ReasonType");
                    
                    //System.out.println("\t---reasonTypeId---"+reasonTypeId+", reasonType---"+reasonType);
                    
                    reasonTypeMap.put(reasonTypeId, reasonType);
                }
                
                PropertyLoader.getInstance().getReasonCodeTypeMap().put(reasonCodeId, reasonTypeMap);
                    
            }
            
            
            ViewObjectImpl statusVO = eqfilesDB.getStatusVO1();    
            statusVO.executeQuery();
            RowSetIterator statusVOIt = statusVO.createRowSetIterator(null);
            while(statusVOIt.hasNext()) {
                Row row = statusVOIt.next();                
                long id = ((oracle.jbo.domain.Number)row.getAttribute("Id")).longValue();
                String value = (String)row.getAttribute("Value");
                PropertyLoader.getInstance().getInternalStatusMap().put(id, value);
                //System.out.println("\t---Internal Status--- id : "+id+", reasonType : "+value);
            }
            
           
            //PropertyLoader.getInstance().getReasonCodeMap().get(reasonCodeId) --- reason code
            //PropertyLoader.getInstance().getReasonCodeTypeMap().get(reasonCodeId).get(reasonTypeId) --- reason type
            
        } catch(Exception ex) {
           ex.printStackTrace(); 
        } finally {
            if(am1!=null) {
                try {
                    Configuration.releaseRootApplicationModule(am1, true);
                } catch(Exception ex1) {
                    ex1.printStackTrace(); 
                }
            }
        }
        
        
    
        ApplicationModule am2 = null;
        try {
            String amDef = "model.EbsAM";
            String config = "EbsAMLocal";
            am2 = Configuration.createRootApplicationModule(amDef, config);
            EbsAMImpl amImpl;
            amImpl = (EbsAMImpl) am2;
            ViewObjectImpl taxRateCodeMasterListVO1 = amImpl.getTaxRateCodeMasterListVO1();
            System.out.println("-----executeTaxRateCodeResultSet-----");
            taxRateCodeMasterListVO1.executeQuery();
            
            if(taxRateCodeMasterListVO1.getEstimatedRowCount()>0){                                         
               RowSetIterator rsi = taxRateCodeMasterListVO1.createRowSetIterator(null);                  
               while (rsi.hasNext()) {                   
                   Row taxRow = rsi.next();
                   //System.out.println("PercentageRate ::"+taxRow.getAttribute("PercentageRate"));
                   // Add your logic here if condition
                   BigDecimal taxRate = (BigDecimal)taxRow.getAttribute("PercentageRate");
                   String taxRateCode=taxRow.getAttribute("TaxRateCode").toString();
                   //System.out.println("key taxRateCode ::: "+taxRateCode + " value taxRate ::: "+ taxRate);
                   
                   PropertyLoader.getInstance().getTaxRatesMasterList().put(taxRateCode, taxRate);
               }
            }
        } catch(Exception ex) {
           ex.printStackTrace();
        } finally {
           if(am2!=null) {
               Configuration.releaseRootApplicationModule(am2, false);
           }
        }
            
        
        System.out.println(PropertyLoader.getInstance().getProperty("IMAGE_URL"));
        
        System.out.println("--- properties loaded ---");
        
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
