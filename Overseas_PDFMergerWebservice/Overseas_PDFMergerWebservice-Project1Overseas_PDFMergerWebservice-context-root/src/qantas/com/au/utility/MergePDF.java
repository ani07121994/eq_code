/*     */ package qantas.com.au.utility;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import org.apache.pdfbox.exceptions.COSVisitorException;
/*     */ import org.apache.pdfbox.pdmodel.PDDocument;
/*     */ import org.apache.pdfbox.util.PDFMergerUtility;
/*     */ import qantas.com.au.utility.GeneratePDF;
/*     */ 
/*     */ public class MergePDF
/*     */ {
/*     */   public static final String deployment_env = "PROD";
/*  13 */   String overseas_path = "";
/*     */   
/*     */   public String getOverseasPath() {
/*  16 */     if (deployment_env.equals("PSP")) {
/*  17 */       this.overseas_path = "/u02_psp_soa_ap/DATA/INVOICES";
/*     */     }
/*  19 */     else if (deployment_env.equals("PROD")) {
/*  20 */       this.overseas_path = "/u02_prod_soa_ap/DATA/INVOICES/TEMPLATE/QF";
/*     */     }
/*  22 */     else if (deployment_env.equals("SIT")) {
/*  23 */       this.overseas_path = "/u02_sa_soadev/Oracle/Middleware/Upload";
/*     */     } 
/*     */     
/*  26 */     return this.overseas_path;
/*     */   }
/*     */ 
/*     */   
/*     */   public String mergerPDF(String invoiceId, String original_filePath) throws IOException, COSVisitorException {
/*  31 */     System.out.println("Inside 2nd merge pdf");
/*  32 */     File file_original = new File(original_filePath);
/*  33 */     PDDocument doc1 = PDDocument.load(file_original);
/*  34 */     GeneratePDF generatePDF = new GeneratePDF();
/*  35 */     String generatedForm_path = null;
/*     */ 
/*     */ 
/*     */     
/*  39 */     String destinationPAth = original_filePath.replace("Invoice-SUBMITTED-", "");
/*  40 */     System.out.println("New destination path------------" + destinationPAth);
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  45 */       generatedForm_path = generatePDF.pdfForm(invoiceId);
/*  46 */       System.out.println("Generated Form Path received in mergePDF : " + generatedForm_path);
/*     */       
/*  48 */       File file_generatedInvoice = new File(generatedForm_path);
/*  49 */       PDDocument doc2 = PDDocument.load(file_generatedInvoice);
/*     */ 
/*     */       
/*  52 */       PDFMergerUtility PDFmerger = new PDFMergerUtility();
/*     */ 
/*     */ 
/*     */       
/*  56 */       PDFmerger.setDestinationFileName(destinationPAth);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  63 */       PDFmerger.addSource(file_generatedInvoice);
/*  64 */       PDFmerger.addSource(file_original);
/*     */ 
/*     */       
/*  67 */       PDFmerger.mergeDocuments();
/*     */       
/*  69 */       System.out.println("Documents merged");
/*     */       
/*  71 */       doc1.close();
/*  72 */       doc2.close();
/*     */     }
/*  74 */     catch (Exception e) {
/*  75 */       e.printStackTrace();
/*     */     } 
/*  77 */     return destinationPAth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) throws IOException, COSVisitorException {
/*  86 */     File file_original = new File("D:\\Appraisal User Manual.pdf");
/*  87 */     PDDocument doc1 = PDDocument.load(file_original);
/*     */     
/*  89 */     File file_generatedInvoice = new File("D:\\Test_imaging_docretrieve.pdf");
/*  90 */     PDDocument doc2 = PDDocument.load(file_generatedInvoice);
/*     */ 
/*     */     
/*  93 */     PDFMergerUtility PDFmerger = new PDFMergerUtility();
/*     */ 
/*     */     
/*  96 */     PDFmerger.setDestinationFileName("D:\\anwesha\\merged.pdf");
/*     */ 
/*     */     
/*  99 */     PDFmerger.addSource(file_original);
/* 100 */     PDFmerger.addSource(file_generatedInvoice);
/*     */ 
/*     */     
/* 103 */     PDFmerger.mergeDocuments();
/*     */     
/* 105 */     System.out.println("Documents merged");
/*     */     
/* 107 */     doc1.close();
/* 108 */     doc2.close();
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\overseas_ear.ear!\Overseas_PDFMergerWebservice-Project1Overseas_PDFMergerWebservice-context-root.war!\WEB-INF\classes\qantas\com\a\\utility\MergePDF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */