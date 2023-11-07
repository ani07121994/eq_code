/*     */ package ap.quantas.com.imaging;
/*     */ 
/*     */ import ap.quantas.com.imaging.FileDescriptor;
/*     */ import ap.quantas.com.imaging.WSSecurityHeaderSOAPHandler;
/*     */ import ap.quantas.com.imaging.documentContentService.DocumentContentService;
/*     */ import ap.quantas.com.imaging.documentContentService.DocumentContentService_Service;
/*     */ import ap.quantas.com.imaging.documentContentService.Rendition;
/*     */ import ap.quantas.com.imaging.documentContentService.RenditionOutput;
/*     */ import java.io.FileOutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.ws.BindingProvider;
/*     */ import javax.xml.ws.handler.Handler;
/*     */ 
/*     */ public class ImagingWSTestClient {
/*     */   public static FileDescriptor getFileFromImaging(String docId) {
/*     */     try {
/*  46 */       FileDescriptor fd = new FileDescriptor();
/*  49 */       System.out.println(" --- getFileFromImaging --- docId : " + docId);
/*  50 */       DocumentContentService documentContentService = (new DocumentContentService_Service()).getDocumentContentServicePort();
/*  51 */       BindingProvider bindingProvider = (BindingProvider)documentContentService;
/*  53 */       List<Handler> handlerChain = new ArrayList<Handler>();
/*  54 */       handlerChain.add(new WSSecurityHeaderSOAPHandler("weblogic", "wls123@PRD"));
/*  59 */       bindingProvider.getBinding().setHandlerChain(handlerChain);
/*  64 */       Rendition rendition = documentContentService.retrieveRendition(docId, false, true, RenditionOutput.ORIGINALORTIFF, null);
/*  65 */       System.out.println(" --- getFileFromImaging --- : getOriginalFilename : " + rendition.getOriginalFilename());
/*  66 */       byte[] byteData = rendition.getContent();
/*  67 */       System.out.println(" --- getFileFromImaging --- : Length of document byte data : " + byteData.length);
/*  68 */       String mimeType = rendition.getMimeType();
/*  69 */       mimeType = mimeType.substring(mimeType.lastIndexOf("/") + 1, mimeType.length());
/*  70 */       System.out.println(mimeType);
/*  73 */       fd.setBytedata(byteData);
/*  74 */       fd.setFilename((rendition.getOriginalFilename() == null) ? ("invoice_document." + mimeType) : rendition.getOriginalFilename());
/*  82 */       System.out.println(" --- getFileFromImaging : Done ---");
/*  83 */       return fd;
/*  84 */     } catch (Exception e) {
/*  85 */       System.out.println(" --- getFileFromImaging : Exception");
/*  86 */       e.printStackTrace();
/*  87 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/*  95 */     String docId = "9.IPM_039606";
/*  97 */     FileDescriptor fd = getFileFromImaging(docId);
/*  99 */     if (fd != null) {
/* 101 */       System.out.println(fd.getFilename());
/* 102 */       System.out.println((fd.getBytedata()).length);
/*     */       try {
/* 105 */         (new FileOutputStream("D:\\" + fd.getFilename())).write(fd.getBytedata());
/* 106 */         System.out.println("DONE");
/* 107 */       } catch (Exception ex) {
/* 108 */         ex.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\ImagingWSTestClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */