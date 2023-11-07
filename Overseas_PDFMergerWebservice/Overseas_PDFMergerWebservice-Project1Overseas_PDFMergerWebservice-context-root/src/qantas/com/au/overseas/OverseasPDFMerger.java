/*    */ package qantas.com.au.overseas;
/*    */ 
/*    */ import javax.jws.WebMethod;
/*    */ import javax.jws.WebParam;
/*    */ import javax.jws.WebService;
/*    */ import javax.xml.ws.BindingType;
/*    */ import qantas.com.au.overseas.OverseasOutput;
/*    */ import qantas.com.au.utility.MergePDF;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @WebService(portName = "OverseasPDFMergerSoap12HttpPort")
/*    */ @BindingType("http://www.w3.org/2003/05/soap/bindings/HTTP/")
/*    */ public class OverseasPDFMerger
/*    */ {
/*    */   @WebMethod(operationName = "mergePDF")
/*    */   public OverseasOutput mergePDF(@WebParam(name = "invoice_id") String invoice_id, @WebParam(name = "invoice_number") String invoice_number, @WebParam(name = "original_filePath") String original_filePath, @WebParam(name = "originalfile_name") String originalfile_name) {
/* 23 */     System.out.println("Inside mergePDF");
/* 24 */     MergePDF mergePDF = new MergePDF();
/* 25 */     String mergedFilePath = null;
/*    */     
/* 27 */     System.out.println("Inputs : invoice_id : " + invoice_id);
/* 28 */     System.out.println("Inputs : invoice_number : " + invoice_number);
/* 29 */     System.out.println("Inputs : original_filePath : " + original_filePath);
/* 30 */     System.out.println("Inputs : originalfile_name : " + originalfile_name);
/*    */     
/*    */     try {
/* 33 */       mergedFilePath = mergePDF.mergerPDF(invoice_id, original_filePath);
/* 34 */     } catch (Exception e) {
/* 35 */       e.printStackTrace();
/*    */     } 
/* 37 */     OverseasOutput output = new OverseasOutput();
/* 38 */     output.setMergedfile_filepath(mergedFilePath);
/* 39 */     if (mergedFilePath != null) {
/*    */       
/* 41 */       output.setMergered_filename(mergedFilePath.substring(mergedFilePath.lastIndexOf("/") + 1, mergedFilePath.length()));
/* 42 */       System.out.println("mergedFileName :: " + mergedFilePath);
/*    */     } 
/*    */ 
/*    */     
/* 46 */     System.out.println("mergedFilePath :: " + mergedFilePath);
/* 47 */     return output;
/*    */   }
/*    */ }


/* Location:              C:\Users\2033471\Downloads\overseas_ear.ear!\Overseas_PDFMergerWebservice-Project1Overseas_PDFMergerWebservice-context-root.war!\WEB-INF\classes\qantas\com\au\overseas\OverseasPDFMerger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */