/*     */ package qantas.com.au.utility;
/*     */ 
/*     */ import com.itextpdf.text.BadElementException;
/*     */ import com.itextpdf.text.BaseColor;
/*     */ import com.itextpdf.text.Document;
/*     */ import com.itextpdf.text.DocumentException;
/*     */ import com.itextpdf.text.Element;
/*     */ import com.itextpdf.text.Image;
/*     */ import com.itextpdf.text.Paragraph;
/*     */ import com.itextpdf.text.Phrase;
/*     */ import com.itextpdf.text.Rectangle;
/*     */ import com.itextpdf.text.pdf.ColumnText;
/*     */ import com.itextpdf.text.pdf.PdfContentByte;
/*     */ import com.itextpdf.text.pdf.PdfPageEventHelper;
/*     */ import com.itextpdf.text.pdf.PdfWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HeaderFooterPageEvent
/*     */   extends PdfPageEventHelper
/*     */ {
/*  32 */   Image footerimg = null;
/*  33 */   Image headerimg = null;
/*  34 */   Image whitebg = null;
/*     */   
/*     */   PdfWriter writer;
/*  37 */   private final Map<String, Integer> pageByTitle = new HashMap<String, Integer>();
/*     */   public HeaderFooterPageEvent(PdfWriter writer, HttpServletRequest request) throws BadElementException, MalformedURLException, IOException {
/*  39 */     this.writer = writer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  58 */     InputStream footer = qantas.com.au.utility.HeaderFooterPageEvent.class.getClassLoader().getResourceAsStream("footer.png");
/*  59 */     this.footerimg = Image.getInstance(ImageIO.read(footer), null);
/*     */ 
/*     */     
/*  62 */     this.footerimg.scaleToFit(500.0F, 500.0F);
/*  63 */     this.footerimg.setAlignment(6);
/*  64 */     this.footerimg.setAlignment(1);
/*  65 */     this.footerimg.setAbsolutePosition(50.0F, 15.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     InputStream logo = qantas.com.au.utility.HeaderFooterPageEvent.class.getClassLoader().getResourceAsStream("Logo.png");
/*  71 */     this.headerimg = Image.getInstance(ImageIO.read(logo), null);
/*     */     
/*  73 */     this.headerimg.scaleToFit(100.0F, 100.0F);
/*  74 */     this.headerimg.setAlignment(4);
/*     */     
/*  76 */     this.headerimg.setAbsolutePosition(50.0F, 800.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onStartPage(PdfWriter writer, Document document) {
/*  93 */     PdfContentByte cb = this.writer.getDirectContent();
/*     */     try {
/*  95 */       writer.add((Element)new Paragraph("test for overlapping!!"));
/*     */       
/*  97 */       cb.addImage(this.headerimg);
/*     */ 
/*     */       
/* 100 */       System.out.println();
/* 101 */     } catch (DocumentException e) {
/*     */       
/* 103 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEndPage(PdfWriter writer, Document document) {
/* 110 */     System.out.println("onEndPage>>>" + writer.getPageNumber());
/* 111 */     Rectangle rect = writer.getBoxSize("art");
/* 112 */     rect.setGrayFill(2.5F);
/* 113 */     rect.setBackgroundColor(BaseColor.RED);
/* 114 */     ColumnText.showTextAligned(writer.getDirectContent(), 1, new Phrase(" " + writer.getPageNumber()), 275.0F, rect.getBottom(), 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     PdfContentByte cb = writer.getDirectContent();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 127 */       writer.add((Element)new Paragraph("test for overlapping!!"));
/* 128 */       writer.add((Element)new Paragraph("test for overlapping!!"));
/*     */       
/* 130 */       cb.addImage(this.footerimg);
/*     */     }
/* 132 */     catch (DocumentException e) {
/*     */       
/* 134 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onChapter(PdfWriter writer, Document document, float paragraphPosition, Paragraph title) {
/* 145 */     this.pageByTitle.put(title.getContent(), Integer.valueOf(writer.getPageNumber()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onSection(PdfWriter writer, Document document, float paragraphPosition, int depth, Paragraph title) {
/* 151 */     this.pageByTitle.put(title.getContent(), Integer.valueOf(writer.getPageNumber()));
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\overseas_ear.ear!\Overseas_PDFMergerWebservice-Project1Overseas_PDFMergerWebservice-context-root.war!\WEB-INF\classes\qantas\com\a\\utility\HeaderFooterPageEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */