/*     */ package ap.quantas.com;
/*     */ 
/*     */ class FileDescriptor {
/*     */   private String filename;
/*     */   
/*     */   private byte[] bytedata;
/*     */   
/*     */   public FileDescriptor() {}
/*     */   
/*     */   public FileDescriptor(String filename, byte[] bytedata) {
/* 606 */     this.filename = filename;
/* 607 */     this.bytedata = bytedata;
/*     */   }
/*     */   
/*     */   public void setFilename(String filename) {
/* 612 */     this.filename = filename;
/*     */   }
/*     */   
/*     */   public String getFilename() {
/* 616 */     return this.filename;
/*     */   }
/*     */   
/*     */   public void setBytedata(byte[] bytedata) {
/* 620 */     this.bytedata = bytedata;
/*     */   }
/*     */   
/*     */   public byte[] getBytedata() {
/* 624 */     return this.bytedata;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\FileDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */