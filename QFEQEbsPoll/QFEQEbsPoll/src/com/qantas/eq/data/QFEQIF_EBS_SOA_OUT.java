/*     */ package com.qantas.eq.data;
/*     */ 
/*     */ import java.sql.Clob;
/*     */ import java.sql.Date;
/*     */ import java.sql.SQLData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLInput;
/*     */ import java.sql.SQLOutput;
/*     */ 
/*     */ public class QFEQIF_EBS_SOA_OUT implements SQLData {
/*     */   private String sql_type;
/*     */   
/*     */   public String ITEMTYPE;
/*     */   
/*     */   public String ITEMKEY;
/*     */   
/*     */   public String File_Name;
/*     */   
/*     */   public String File_path;
/*     */   
/*     */   public String CMREQID;
/*     */   
/*     */   public String CMRETCODE;
/*     */   
/*     */   public String CMRETMSG;
/*     */   
/*     */   public String CMRECCNT;
/*     */   
/*     */   public String EVENT_NAME;
/*     */   
/*     */   public String EVENT_KEY;
/*     */   
/*     */   public Clob Payload;
/*     */   
/*     */   public Date Queue_date;
/*     */   
/*     */   public QFEQIF_EBS_SOA_OUT() {}
/*     */   
/*     */   public QFEQIF_EBS_SOA_OUT(String sql_type, String ITEMTYPE, String ITEMKEY, String File_Name, String File_path, String CMREQID, String CMRETCODE, String CMRETMSG, String CMRECCNT, String EVENT_NAME, String EVENT_KEY, Clob Payload, Date Queue_date) {
/*  36 */     this.sql_type = sql_type;
/*  37 */     this.ITEMTYPE = ITEMTYPE;
/*  38 */     this.ITEMKEY = ITEMKEY;
/*  39 */     this.File_Name = File_Name;
/*  40 */     this.File_path = File_path;
/*  41 */     this.CMREQID = CMREQID;
/*  42 */     this.CMRETCODE = CMRETCODE;
/*  43 */     this.CMRETMSG = CMRETMSG;
/*  44 */     this.CMRECCNT = CMRECCNT;
/*  45 */     this.EVENT_NAME = EVENT_NAME;
/*  46 */     this.EVENT_KEY = EVENT_KEY;
/*  47 */     this.Payload = Payload;
/*  48 */     this.Queue_date = Queue_date;
/*     */   }
/*     */   
/*     */   public String getSQLTypeName() throws SQLException {
/*  53 */     return this.sql_type;
/*     */   }
/*     */   
/*     */   public void readSQL(SQLInput stream, String typeName) throws SQLException {
/*  58 */     this.sql_type = typeName;
/*  59 */     this.ITEMTYPE = stream.readString();
/*  60 */     this.ITEMKEY = stream.readString();
/*  61 */     this.File_Name = stream.readString();
/*  62 */     this.File_path = stream.readString();
/*  63 */     this.CMREQID = stream.readString();
/*  64 */     this.CMRETCODE = stream.readString();
/*  65 */     this.CMRETMSG = stream.readString();
/*  66 */     this.CMRECCNT = stream.readString();
/*  67 */     this.EVENT_NAME = stream.readString();
/*  68 */     this.EVENT_KEY = stream.readString();
/*  69 */     this.Payload = stream.readClob();
/*  71 */     this.Queue_date = stream.readDate();
/*     */   }
/*     */   
/*     */   public void writeSQL(SQLOutput stream) throws SQLException {
/*  76 */     stream.writeString(this.ITEMTYPE);
/*  77 */     stream.writeString(this.ITEMKEY);
/*  78 */     stream.writeString(this.File_Name);
/*  79 */     stream.writeString(this.File_path);
/*  80 */     stream.writeString(this.CMREQID);
/*  81 */     stream.writeString(this.CMRETCODE);
/*  82 */     stream.writeString(this.CMRETMSG);
/*  83 */     stream.writeString(this.CMRECCNT);
/*  84 */     stream.writeString(this.EVENT_NAME);
/*  85 */     stream.writeString(this.EVENT_KEY);
/*  86 */     stream.writeClob(this.Payload);
/*  87 */     stream.writeDate(this.Queue_date);
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     String ret_str = "";
/*  93 */     ret_str = ret_str + "[QFEQIF_EBS_SOA_OUT]\n";
/*  94 */     ret_str = ret_str + "ITEMTYPE: " + this.ITEMTYPE + "\n";
/*  95 */     ret_str = ret_str + "ITEMKEY: " + this.ITEMKEY + "\n";
/*  96 */     ret_str = ret_str + "File_Name: " + this.File_Name + "\n";
/*  97 */     ret_str = ret_str + "File_path: " + this.File_path + "\n";
/*  98 */     ret_str = ret_str + "CMREQID: " + this.CMREQID + "\n";
/*  99 */     ret_str = ret_str + "CMRETCODE: " + this.CMRETCODE + "\n";
/* 100 */     ret_str = ret_str + "CMRETMSG: " + this.CMRETMSG + "\n";
/* 101 */     ret_str = ret_str + "CMRECCNT: " + this.CMRECCNT + "\n";
/* 102 */     ret_str = ret_str + "EVENT_NAME: " + this.EVENT_NAME + "\n";
/* 103 */     ret_str = ret_str + "EVENT_KEY: " + this.EVENT_KEY + "\n";
/* 104 */     ret_str = ret_str + "Queue_date: " + this.Queue_date;
/* 106 */     return ret_str;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\QFEQEbsPoll.war!\WEB-INF\classes\com\qantas\eq\data\QFEQIF_EBS_SOA_OUT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */