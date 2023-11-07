/*     */ package ap.quantas.com.imaging;
/*     */ 
/*     */ class FileDescriptor {
/*     */   private String filename;
/*     */   
/*     */   private byte[] bytedata;
/*     */   
/*     */   public FileDescriptor() {}
/*     */   
/*     */   public FileDescriptor(String filename, byte[] bytedata) {
/* 122 */     this.filename = filename;
/* 123 */     this.bytedata = bytedata;
/*     */   }
/*     */   
/*     */   public void setFilename(String filename) {
/* 128 */     this.filename = filename;
/*     */   }
/*     */   
/*     */   public String getFilename() {
/* 132 */     return this.filename;
/*     */   }
/*     */   
/*     */   public void setBytedata(byte[] bytedata) {
/* 136 */     this.bytedata = bytedata;
/*     */   }
/*     */   
/*     */   public byte[] getBytedata() {
/* 140 */     return this.bytedata;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\FileDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */