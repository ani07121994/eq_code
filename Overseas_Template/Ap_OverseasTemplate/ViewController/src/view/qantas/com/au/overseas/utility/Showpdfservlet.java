package view.qantas.com.au.overseas.utility;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import java.net.URLDecoder;

import javax.servlet.*;
import javax.servlet.http.*;

public class Showpdfservlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
        public static final String deployment_env = "PROD";
        String  overseas_path ="";
        public String getOverseasPath(){

                if(deployment_env.equals("DEV")){
                  overseas_path=  "/u02_soa_dev/Oracle/Middleware/Upload/";

                }else if(deployment_env.equals("PSP")){
              overseas_path=  "/u02_psp_soa_ap/DATA/INVOICES/";

            }else if(deployment_env.equals("PROD")){
              overseas_path=  "/u02_prod_soa_ap/DATA/INVOICES/TEMPLATE/QF/";
            }
            else if(deployment_env.equals("SIT")){
//                          overseas_path=  "/u02_sa_soadev/Oracle/Middleware/Upload/";
                            overseas_path=  "/u02_serv_pl_ap/SOAAPP/DATA/INVOICES/TEMPLATE/";
                        }
            else if(deployment_env.equals("SITDB")){
                          overseas_path=  "/u02_serv_pl_ap/SOAAPP/DATA/INVOICES/TEMPLATE/";
                        }
           return  overseas_path;
        }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
                                                           IOException {
        response.setContentType(CONTENT_TYPE);

            String requestedFile = request.getParameter("name");
            //String filePath ="/home/soacrp2app/QFEQSOAOUT";
            //String filePath ="/u02_sa_soadev/Oracle/Middleware/Upload"; ---- for SIT
            //String filePath ="/u03/PSP/SOA/";
           // String filePath ="/u02_psp_soa_ap/DATA/INVOICES/";
            String filePath =getOverseasPath();
            File file = new File(filePath, URLDecoder.decode(requestedFile, "UTF-8"));

            //response.setBufferSize(8192);
            response.setContentType("application/pdf");
            response.setHeader("Content-Length", String.valueOf(file.length()));
            response.setHeader("Content-Disposition", "filename=\"" + file.getName() + "\"");
            BufferedInputStream input =null;
             //BufferedOutputStream output =null;
                ServletOutputStream stream =response.getOutputStream();

            try {
                // Open streams.
                input = new BufferedInputStream(new FileInputStream(file));
               // output = new BufferedOutputStream(response.getOutputStream(), (int)file.length());
                // Write file contents to response.
                byte[] buffer = new byte[(int)file.length()];
                int length;
                while ((length = input.read(buffer)) > 0) {
                          stream.write(buffer, 0, length);
                 }
                stream.flush();
                stream.close();

            }
            catch(Exception e ){
                e.printStackTrace();
            }
            finally{
                try{
                input.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }

               // response.resetBuffer();

    }
    }