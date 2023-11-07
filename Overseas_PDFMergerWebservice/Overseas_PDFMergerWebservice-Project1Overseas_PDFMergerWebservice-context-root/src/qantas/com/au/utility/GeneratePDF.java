/*     */ package qantas.com.au.utility;
/*     */ 
/*     */ import com.itextpdf.text.BaseColor;
/*     */ import com.itextpdf.text.DocListener;
/*     */ import com.itextpdf.text.Document;
/*     */ import com.itextpdf.text.DocumentException;
/*     */ import com.itextpdf.text.Rectangle;
/*     */ import com.itextpdf.text.html.simpleparser.HTMLWorker;
/*     */ import com.itextpdf.text.pdf.PdfPageEvent;
/*     */ import com.itextpdf.text.pdf.PdfWriter;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.StringReader;
/*     */ import java.io.StringWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import javax.naming.InitialContext;
/*     */ import javax.naming.NamingException;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.sql.DataSource;
/*     */ import javax.xml.bind.JAXBContext;
/*     */ import javax.xml.bind.Marshaller;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import javax.xml.transform.stream.StreamSource;
/*     */ import qantas.com.au.utility.HeaderFooterPageEvent;
/*     */ import qantas.com.au.utility.InvoiceDO;
/*     */
/*     */ public class GeneratePDF
/*     */ {
/*     */   public static final String deployment_env = "PROD";
/*  54 */   String overseas_path = "";
/*  55 */   String conn_name = "";
/*     */   
/*     */   public String getOverseasPath() {
/*  58 */     if (deployment_env.equals("PSP")) {
/*  59 */       this.overseas_path = "/u02_psp_soa_ap/DATA/INVOICES";
/*     */     }
/*  61 */     else if (deployment_env.equals("PROD")) {
/*  62 */       this.overseas_path = "/u02_prod_soa_ap/DATA/INVOICES/TEMPLATE/QF";
/*     */     }
/*  64 */     else if (deployment_env.equals("DEV")) {
/*  65 */       this.overseas_path = "/u02_soa_dev/Oracle/Middleware/Upload";
/*     */     } 
/*     */     
/*  68 */     return this.overseas_path;
/*     */   }
/*     */   
/*     */   public String getConnName() {
/*  72 */     if (deployment_env.equals("DEV")) {
/*  73 */       this.conn_name = "jdbc/DEV_EQFILES_NXA";
/*     */     }
/*  75 */     else if (deployment_env.equals("PSP")) {
/*  76 */       this.conn_name = "jdbc/PROD_EQFILES_NXA";
/*     */     } 
			  else if (deployment_env.equals("PROD")) {
/*  76 */       this.conn_name = "jdbc/PROD_EQFILES_NXA";
/*     */     } 
/*     */     
/*  79 */     return this.conn_name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String pdfForm1(String invoice_id, ArrayList<String> navigationMap, HttpServletRequest request) throws Exception {
/*  85 */     qantas.com.au.utility.GeneratePDF GetPdfForm = new qantas.com.au.utility.GeneratePDF();
/*  86 */     Document document = new Document();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     String generated_filePath = getOverseasPath() + File.separator + "InvoiceHeader_" + invoice_id + ".pdf";
/*     */     
/*  93 */     File invoice_generated_file = new File(generated_filePath);
/*  94 */     OutputStream os = new FileOutputStream(invoice_generated_file);
/*     */     
/*  96 */     PdfWriter pdfwriter = PdfWriter.getInstance(document, os);
/*     */ 
/*     */ 
/*     */     
/* 100 */     Rectangle rect = new Rectangle(5.0F, 5.0F, 550.0F, 800.0F);
/* 101 */     pdfwriter.setBoxSize("art", rect);
/* 102 */     rect.setBackgroundColor(BaseColor.RED);
/*     */     
/* 104 */     System.out.println("Inside getPdfForm----------------------------------------------------->" + request.getRequestURI());
/*     */ 
/*     */     
/* 107 */     HeaderFooterPageEvent event = new HeaderFooterPageEvent(pdfwriter, request);
/*     */ 
/*     */     
/* 110 */     pdfwriter.setPageEvent((PdfPageEvent)event);
/*     */ 
/*     */     
/* 113 */     document.open();
/*     */     
/* 115 */     String htm_page = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     StringBuilder ids_form = new StringBuilder();
/*     */     
/* 122 */     htm_page = getContentToAppendInPdf(InvoiceDO.class, GetPdfForm.getInvoiceDetals(invoice_id), "personInfo");
/*     */     
/* 124 */     ids_form.append(htm_page.toString());
/* 125 */     HTMLWorker htmlWorker = new HTMLWorker((DocListener)document);
/* 126 */     StringReader strReader = new StringReader(ids_form.toString());
/* 127 */     htmlWorker.parse(strReader);
/* 128 */     strReader.close();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     document.close();
/* 134 */     os.close();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     return invoice_generated_file.getAbsolutePath();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getContentToAppendInPdf(Class<?> dyanmicClass, Object obj, String pageName) throws Exception {
/* 144 */     JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] { dyanmicClass });
/* 145 */     Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
/*     */     
/* 147 */     jaxbMarshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/*     */     
/* 149 */     StringWriter stringWriter = new StringWriter();
/* 150 */     jaxbMarshaller.marshal(obj, stringWriter);
/*     */ 
/*     */ 
/*     */     
/* 154 */     stringWriter.close();
/* 155 */     StringWriter writer = new StringWriter();
/* 156 */     TransformerFactory tFactory = TransformerFactory.newInstance();
/* 157 */     Transformer transformer = null;
/* 158 */     InputStream in = null;
/*     */ 
/*     */ 
/*     */     
/* 162 */     in = qantas.com.au.utility.GeneratePDF.class.getResourceAsStream("invoice_summary.xsl");
/*     */     
/* 164 */     transformer = tFactory.newTransformer(new StreamSource(in));
/*     */ 
/*     */     
/* 167 */     transformer.transform(new StreamSource(new ByteArrayInputStream(stringWriter.toString().getBytes())), new StreamResult(writer));
/*     */ 
/*     */     
/* 170 */     String strResult = writer.toString();
/*     */     
/* 172 */     return strResult;
/*     */   }
/*     */ 
/*     */   public String pdfForm(String invoice_id) throws Exception {
/* 182 */     qantas.com.au.utility.GeneratePDF GetPdfForm = new qantas.com.au.utility.GeneratePDF();
/* 183 */     Document document = new Document();
/*     */     
/* 185 */     String generated_filePath = getOverseasPath() + File.separator + "InvoiceHeader_" + invoice_id + ".pdf";
/* 186 */     File invoice_generated_file = new File(generated_filePath);
/* 187 */     OutputStream os = new FileOutputStream(invoice_generated_file);
/*     */     
/* 189 */     PdfWriter pdfwriter = PdfWriter.getInstance(document, os);
/*     */ 
/*     */ 
/*     */     
/* 193 */     Rectangle rect = new Rectangle(5.0F, 5.0F, 550.0F, 800.0F);
/* 194 */     pdfwriter.setBoxSize("art", rect);
/* 195 */     rect.setBackgroundColor(BaseColor.RED);
/*     */ 
/*     */ 
/*     */     
/* 199 */     System.out.println("/************* Opening the document to write ********************/");
/* 200 */     document.open();
/*     */     
/* 202 */     String htm_page = null;
/*     */ 
/* 207 */     StringBuilder ids_form = new StringBuilder();
/*     */     
/* 209 */     htm_page = getContentToAppendInPdf(InvoiceDO.class, GetPdfForm.getInvoiceDetals(invoice_id), "personInfo");
/*     */     
/* 211 */     ids_form.append(htm_page.toString());
/* 212 */     HTMLWorker htmlWorker = new HTMLWorker((DocListener)document);
/* 213 */     StringReader strReader = new StringReader(ids_form.toString());
/* 214 */     htmlWorker.parse(strReader);
/* 215 */     strReader.close();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 220 */     document.close();
/* 221 */     os.close();
/* 222 */     System.out.println("Generated filepath in pdfForm : " + generated_filePath);
/*     */     
/* 224 */     return generated_filePath;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws FileNotFoundException, DocumentException, Exception {
/* 232 */     qantas.com.au.utility.GeneratePDF GetPdfForm = new qantas.com.au.utility.GeneratePDF();
/* 233 */     Document document = new Document();
/*     */ 
/*     */     
/* 236 */     File invoice_generated_file = new File("D:\\InvoiceHeader_194901_invID.pdf");
/* 237 */     OutputStream os = new FileOutputStream(invoice_generated_file);
/*     */     
/* 239 */     PdfWriter pdfwriter = PdfWriter.getInstance(document, os);
/*     */ 
/*     */ 
/*     */     
/* 243 */     Rectangle rect = new Rectangle(5.0F, 5.0F, 550.0F, 800.0F);
/* 244 */     pdfwriter.setBoxSize("art", rect);
/* 245 */     rect.setBackgroundColor(BaseColor.RED);
/*     */ 	  document.open();
/*     */     
/* 252 */     String htm_page = null;
/*     */     StringBuilder ids_form = new StringBuilder();
/*     */     
/* 259 */     htm_page = getContentToAppendInPdf(InvoiceDO.class, GetPdfForm.getInvoiceDetals("1235"), "personInfo");
/*     */     
/* 261 */     ids_form.append(htm_page.toString());
/* 262 */     HTMLWorker htmlWorker = new HTMLWorker((DocListener)document);
/* 263 */     StringReader strReader = new StringReader(ids_form.toString());
/* 264 */     htmlWorker.parse(strReader);
/* 265 */     strReader.close();
/*     */ 
/* 270 */     document.close();
/* 271 */     os.close();
/*     */   }
/*     */ 
			public InvoiceDO getInvoiceDetals1(String invoiceId) throws NamingException {
/* 278 */     InvoiceDO invoiceDetailsObj = new InvoiceDO();
/* 279 */     invoiceDetailsObj.setDocumentType("DOCUMENT_TYPE");
/* 280 */     invoiceDetailsObj.setSupplierName("SUPPLIER_NAME");
/* 281 */     invoiceDetailsObj.setSiteId(null);
/* 282 */     invoiceDetailsObj.setInvNumber(null);
/* 283 */     invoiceDetailsObj.setTaxRegistrationNumber(null);
/* 284 */     invoiceDetailsObj.setPoNumber(null);
/* 285 */     invoiceDetailsObj.setCurrency("sdfsdf");
/* 286 */     invoiceDetailsObj.setCertifierName("CERTIFIER_NAME");
/* 287 */     invoiceDetailsObj.setCertEmailAddress("CERTIFIER_EMAIL_ADD");
/* 288 */     invoiceDetailsObj.setCertifierFlag("true");
/* 289 */     invoiceDetailsObj.setAlternateApprover("ALTERNATE_APPROVER");
/* 290 */     invoiceDetailsObj.setInvType("INVOICE_TYPE");
/* 291 */     invoiceDetailsObj.setSupplierNo(null);
/* 292 */     invoiceDetailsObj.setSiteName("SITE_NAME");
/* 293 */     invoiceDetailsObj.setInvoiceDate(null);
/* 294 */     invoiceDetailsObj.setOperatingUnit("ATTR2");
/* 295 */     invoiceDetailsObj.setLineTotal(null);
/* 296 */     invoiceDetailsObj.setTaxTotal(null);
/* 297 */     invoiceDetailsObj.setHeaderTotal(null);
/* 298 */     invoiceDetailsObj.setEmployeeNo(null);
/* 299 */     invoiceDetailsObj.setNoteToApprover(null);
/* 300 */     invoiceDetailsObj.setPaymentChequeNo(null);
/* 301 */     invoiceDetailsObj.setPaymentWithInv("true");
/* 302 */     invoiceDetailsObj.setPaymentWired("true");
/* 303 */     invoiceDetailsObj.setPaymentMan("true");
/* 304 */     return invoiceDetailsObj;
/*     */   }
/*     */   
/*     */   public InvoiceDO getInvoiceDetals(String invoiceId) throws NamingException {
/* 308 */     Connection conn = null;
/* 309 */     InitialContext context = new InitialContext();
/*     */     
/* 311 */     DataSource dataSource = (DataSource)context.lookup(getConnName());
/*     */     try {
/* 313 */       conn = dataSource.getConnection();
/* 314 */       PreparedStatement invoiceDetails = conn.prepareStatement("select * from ap_invoice_overseas_table where invoice_id=?");
/*     */       
/* 316 */       invoiceDetails.setString(1, invoiceId);
/* 317 */       ResultSet rs = invoiceDetails.executeQuery();
/* 318 */       if (rs.next()) {
/* 319 */         InvoiceDO invoiceDetailsObj = new InvoiceDO();
/* 320 */         invoiceDetailsObj.setDocumentType((rs.getString("DOCUMENT_TYPE") != null) ? rs.getString("DOCUMENT_TYPE") : null);
/* 321 */         invoiceDetailsObj.setSupplierName((rs.getString("SUPPLIER_NAME") != null) ? rs.getString("SUPPLIER_NAME") : null);
/* 322 */         invoiceDetailsObj.setSiteId((rs.getString("SITE_ID") != null) ? rs.getString("SITE_ID") : null);
/* 323 */         invoiceDetailsObj.setInvNumber((rs.getString("INVOICE_NUMBER") != null) ? rs.getString("INVOICE_NUMBER") : null);
/* 324 */         invoiceDetailsObj.setTaxRegistrationNumber((rs.getString("TAX_REG_NUMBER") != null) ? rs.getString("TAX_REG_NUMBER") : null);
/*     */         
/* 326 */         invoiceDetailsObj.setPoNumber((rs.getString("PO_NUMBER") != null) ? rs.getString("PO_NUMBER") : null);
/* 327 */         invoiceDetailsObj.setCurrency((rs.getString("CURRENCY_CODE") != null) ? rs.getString("CURRENCY_CODE") : null);
/* 328 */         invoiceDetailsObj.setCertifierName((rs.getString("CERTIFIER_NAME") != null) ? rs.getString("CERTIFIER_NAME") : null);
/* 329 */         invoiceDetailsObj.setCertEmailAddress((rs.getString("CERTIFIER_EMAIL_ADD") != null) ? rs.getString("CERTIFIER_EMAIL_ADD") : null);
/*     */         
/* 331 */         invoiceDetailsObj.setAlternateApprover((rs.getString("ALTERNATE_APPROVER") != null) ? rs.getString("ALTERNATE_APPROVER") : null);
/* 332 */         invoiceDetailsObj.setInvType((rs.getString("INVOICE_TYPE") != null) ? rs.getString("INVOICE_TYPE") : null);
/* 333 */         invoiceDetailsObj.setSupplierNo((rs.getString("SUPPLIER_NUMBER") != null) ? rs.getString("SUPPLIER_NUMBER") : null);
/* 334 */         invoiceDetailsObj.setSiteName((rs.getString("SITE_NAME") != null) ? rs.getString("SITE_NAME") : null);
/*     */ 
/*     */ 
/*     */         
/* 338 */         System.out.println("Date from Database : " + rs.getDate("INVOICE_DATE"));
/* 339 */         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
/* 340 */         System.out.println("Date after formatting : " + sdf.format((rs.getDate("INVOICE_DATE") != null) ? rs.getDate("INVOICE_DATE") : null));
/* 341 */         invoiceDetailsObj.setInvoiceDate(sdf.format((rs.getDate("INVOICE_DATE") != null) ? rs.getDate("INVOICE_DATE") : null));
/*     */ 
/*     */ 
/*     */         
/* 345 */         invoiceDetailsObj.setOperatingUnit(rs.getString("ATTR2"));
/* 346 */         invoiceDetailsObj.setLineTotal(rs.getString("ATTR1"));
/* 347 */         invoiceDetailsObj.setTaxTotal(rs.getString("TAX_AMOUNT"));
/* 348 */         invoiceDetailsObj.setHeaderTotal(rs.getString("INVOICE_TOT_AMOUNT"));
/* 349 */         invoiceDetailsObj.setEmployeeNo((rs.getString("EMPLOYEE_NUMBER") != null) ? rs.getString("EMPLOYEE_NUMBER") : null);
/* 350 */         invoiceDetailsObj.setNoteToApprover((rs.getString("AP_OPERATION_COMMENTS") != null) ? rs.getString("AP_OPERATION_COMMENTS") : null);
/* 351 */         invoiceDetailsObj.setPaymentChequeNo((rs.getString("ATTR16") != null) ? rs.getString("ATTR16") : null);
/*     */ 
/*     */         
/* 354 */         invoiceDetailsObj.setPaymentWithInv((rs.getString("ATTR15") != null) ? rs.getString("ATTR15") : null);
/* 355 */         invoiceDetailsObj.setPaymentWired((rs.getString("ATTR14") != null) ? rs.getString("ATTR14") : null);
/* 356 */         invoiceDetailsObj.setPaymentMan((rs.getString("ATTR12") != null) ? rs.getString("ATTR12") : null);
/* 357 */         invoiceDetailsObj.setRequestFlag((rs.getString("ATTR11") != null) ? rs.getString("ATTR11") : null);
/*     */         
/* 359 */         System.out.println("Attr16 value in database  : " + rs.getString("ATTR16"));
/* 360 */         System.out.println("Attr15 value in database  : " + rs.getString("ATTR15"));
/* 361 */         System.out.println("Attr12 value in database  : " + rs.getString("ATTR12"));
/* 362 */         System.out.println("Attr11 value in database  : " + rs.getString("ATTR11"));
/* 363 */         System.out.println("Attr14 value in database  : " + rs.getString("ATTR14"));
/*     */         
/* 365 */         System.out.println("Returing invoice address");
/*     */         
/* 367 */         return invoiceDetailsObj;
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 372 */     catch (Exception e) {
/* 373 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 376 */         conn.close();
/* 377 */       } catch (SQLException e) {
/*     */         
/* 379 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 384 */     return null;
/*     */   }
/*     */ }

