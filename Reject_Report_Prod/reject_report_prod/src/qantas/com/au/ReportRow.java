package qantas.com.au;

import java.util.ArrayList;

public class ReportRow {
  public String mailId;
  
  public Integer total_mailCount;
  
  public Integer mail_count_WithAttchmts;
  
  public Integer mail_count_WithoutAttchmts;
  
  public Integer mail_count_morethan_OneMB;
  
  public ArrayList<String> attachment_typs = new ArrayList<String>();
  
  public String report_name;
  
  public String getMailId() {
    return this.mailId;
  }
  
  public void setMailId(String mailId) {
    this.mailId = mailId;
  }
  
  public Integer getTotal_mailCount() {
    return this.total_mailCount;
  }
  
  public void setTotal_mailCount(Integer total_mailCount) {
    this.total_mailCount = total_mailCount;
  }
  
  public Integer getMail_count_WithAttchmts() {
    return this.mail_count_WithAttchmts;
  }
  
  public void setMail_count_WithAttchmts(Integer mail_count_WithAttchmts) {
    this.mail_count_WithAttchmts = mail_count_WithAttchmts;
  }
  
  public Integer getMail_count_WithoutAttchmts() {
    return this.mail_count_WithoutAttchmts;
  }
  
  public void setMail_count_WithoutAttchmts(Integer mail_count_WithoutAttchmts) {
    this.mail_count_WithoutAttchmts = mail_count_WithoutAttchmts;
  }
  
  public Integer getMail_count_morethan_OneMB() {
    return this.mail_count_morethan_OneMB;
  }
  
  public void setMail_count_morethan_OneMB(Integer mail_count_morethan_OneMB) {
    this.mail_count_morethan_OneMB = mail_count_morethan_OneMB;
  }
  
  public ArrayList<String> getAttachment_typs() {
    return this.attachment_typs;
  }
  
  public void setAttachment_typs(ArrayList<String> attachment_typs) {
    this.attachment_typs = attachment_typs;
  }
  
  public String getReport_name() {
    return this.report_name;
  }
  
  public void setReport_name(String report_name) {
    this.report_name = report_name;
  }
}
