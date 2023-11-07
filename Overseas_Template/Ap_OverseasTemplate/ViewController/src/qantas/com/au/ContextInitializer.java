package qantas.com.au;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import javax.sql.DataSource;

import qantas.com.au.overseas.model.EQfiles_APModuleImpl;
import qantas.com.au.overseas.model.EBS_AMImpl;

import qantas.com.au.overseas.model.common.EQfiles_APModule;

import oracle.adf.share.ADFContext;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.client.Configuration;
import oracle.jbo.server.ViewObjectImpl;

public class ContextInitializer implements ServletContextListener {
    public ContextInitializer() {
        super();
    }

    public static final String deployment_env = "PROD";

    public DataSource getDataSource_ebs() throws NamingException {

        //NamingManager.setInitialContextFactoryBuilder(new DatabaseContextFactory());
        String jndi_name = "";

        if (deployment_env.equals("DEV")) {
            jndi_name = "jdbc/DEV_APPS_NXA";
        }
        if (deployment_env.equals("SIT")) {
            jndi_name = "jdbc/CRP2_APPS_NXA";
        } else if (deployment_env.equals("PSP")) {
            jndi_name = "jdbc/PROD_APPS_NXA";
        } else if (deployment_env.equals("PROD")) {
            jndi_name = "jdbc/PROD_APPS_NXA";
        }
        else if (deployment_env.equals("SITDB")) {
                   jndi_name = "jdbc/CRP2_APPS_NXA";
               }

       // jndi_name = "jdbc/PROD_APPS_NXA";
        System.out.println("heyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy :: "+jndi_name);
        Context initContext = new InitialContext();
        DataSource ds = (DataSource)initContext.lookup(jndi_name);

        return ds;
    }

    public DataSource getDataSource_soa() throws NamingException {

        //NamingManager.setInitialContextFactoryBuilder(new DatabaseContextFactory());
        String jndi_name = "";

        if (deployment_env.equals("DEV")) {
            jndi_name = "jdbc/DEV_EQFILES_NXA";
        }
        if (deployment_env.equals("SIT")) {
            jndi_name = "jdbc/CRP2_EQFILES_NXA";
        } else if (deployment_env.equals("PSP")) {
            jndi_name = "jdbc/PROD_EQFILES_NXA";
        } else if (deployment_env.equals("PROD")) {
            jndi_name = "jdbc/PROD_EQFILES_NXA";
        }
        else if (deployment_env.equals("SITDB")) {
                   jndi_name = "jdbc/CRP2_EQFILES_NXA";
               }

       // jndi_name = "jdbc/PROD_EQFILES_NXA";
        System.out.println("heyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy :: "+jndi_name);
        Context initContext = new InitialContext();
        DataSource ds = (DataSource)initContext.lookup(jndi_name);

        return ds;
    }



    public void contextInitialized(ServletContextEvent servletContextEvent) {

        System.out.println("Context Initialized during deployment");

        System.out.println("--- loading properties ---");
        ResultSet rs = null;
        ResultSet rs2 = null;
        Connection conn = null;
        Connection conn2 = null;
        try {
            conn = getDataSource_ebs().getConnection();
            rs =
    conn.createStatement().executeQuery("select tax_rate_code, percentage_rate from \n" +
    "(SELECT DISTINCT zb.tax_rate_code\n" +
    "               ,zb.percentage_rate\n" +
    "               ,zov.org_id\n" +
    "  FROM zx_rates_b            zb\n" +
    "      ,zx_rates_tl           zt\n" +
    "      ,zx_id_tcc_mapping_all zov\n" +
    "-- ,apps.ap_supplier_sites_all assa\n" +
    " WHERE zb.tax_rate_id = zt.tax_rate_id\n" +
    "   AND zov.tax_rate_code_id = zb.tax_rate_id\n" +
    "      -- AND assa.org_id = zov.org_id            \n" +
    "   AND zb.active_flag = 'Y'\n" +
    "   AND rate_type_code <> 'RECOVERY'\n" +
    "   AND trunc(SYSDATE) BETWEEN zb.effective_from AND\n" +
    "       nvl(zb.effective_to\n" +
    "          ,trunc(SYSDATE) + 1)\n" +
    "   AND decode(record_type_code\n" +
    "             ,'MIGRATED'\n" +
    "             ,'INPUT'\n" +
    "             ,'USER_DEFINED'\n" +
    "             ,zov.tax_type) = nvl(zb.tax_class\n" +
    "                                 ,'GST')\n" +
    ") group by tax_rate_code,percentage_rate");
            int n = 1;
            while (rs.next()) {
                System.out.println("Record Overseas Master List Loaded" + n++);
//                System.out.println("tax_rate_code ::--- "+rs.getString(1) +"-----percentage_rate"+rs.getString(2));
               // PropertyLoader.getInstance().addProperty(rs.getString(1),rs.getString(1));
                PropertyLoader.getInstance().getTaxRatesMasterList().put(rs.getString(1), new BigDecimal(rs.getString(2)));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (conn != null)
                    System.out.println("Closing connection after contextInitialization");
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


        try {
            conn2 = getDataSource_soa().getConnection();
            rs2 =
            conn2.createStatement().executeQuery("select * from ap_properties_table");
            while (rs2.next()) {

                           PropertyLoader.getInstance().addProperty(rs2.getString(1),
                                                                    rs2.getString(2));
                       }

        } catch (Exception e) {

            e.printStackTrace();
        }

        finally {
            try {
                if (rs2 != null) {
                    rs2.close();
                }

                if (conn2 != null)
                    System.out.println("Closing connection after contextInitialization");
                conn2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }













        System.out.println(PropertyLoader.getInstance().getProperty("IMAGE_URL"));

        System.out.println("--- property loaded successfully ---" +PropertyLoader.getInstance().getProperty("OVERSEAS_FILE_UPLOAD"));

    }






    public void contextInitialized_old(ServletContextEvent servletContextEvent) {
        System.out.println("Context Initialized during deployment");

        System.out.println("--- loading properties ---");

        ApplicationModule am1 = null;
       /* try {
            String amDef = "model.APOperationAM";
            String config = "APOperationAMLocal";
            am1 = Configuration.createRootApplicationModule(amDef, config);
            EQfiles_APModuleImpl eqfilesDB = (EQfiles_APModuleImpl)am1;

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

                System.out.println("---reasonCodeId---"+reasonCodeId+", reasonCode---"+reasonCode);
                PropertyLoader.getInstance().getReasonCodeMap().put(reasonCodeId, reasonCode);


                invalidReasonTypeVO.setNamedWhereClauseParam("bvReasonId", reasonCodeId);
                invalidReasonTypeVO.executeQuery();
                RowSetIterator invalidReasonTypeVOIt = invalidReasonTypeVO.createRowSetIterator(null);

                HashMap<Long, String> reasonTypeMap =  new HashMap<Long, String>();
                while(invalidReasonTypeVOIt.hasNext()) {
                    Row innerRow = invalidReasonTypeVOIt.next();

                    long reasonTypeId = ((java.math.BigDecimal)innerRow.getAttribute("Id")).longValue();
                    String reasonType = (String)innerRow.getAttribute("ReasonType");

                    System.out.println("\t---reasonTypeId---"+reasonTypeId+", reasonType---"+reasonType);

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
                System.out.println("\t---Internal Status--- id : "+id+", reasonType : "+value);
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
        }*/



        ApplicationModule am2 = null;
        try {
            String amDef = "model.EbsAM";
            String config = "EbsAMLocal";
            am2 = Configuration.createRootApplicationModule(amDef, config);
            EBS_AMImpl amImpl = (EBS_AMImpl)am2;
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
                   System.out.println("***contextInitialized_old***");
//                   System.out.println("key taxRateCode ::: "+taxRateCode + " value taxRate ::: "+ taxRate);

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