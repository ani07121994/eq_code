/*     */ package ap.quantas.com.imaging.documentContentService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentContentService.AuditEventType;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
import java.util.Properties;

/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlSchemaType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ import javax.xml.datatype.XMLGregorianCalendar;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "AuditEvent", propOrder = {"subjectId", "type", "date", "userName", "param1", "param2", "properties"})
/*     */ public class AuditEvent {
/*     */   protected long subjectId;
/*     */   
/*     */   protected AuditEventType type;
/*     */   
/*     */   @XmlSchemaType(name = "dateTime")
/*     */   protected XMLGregorianCalendar date;
/*     */   
/*     */   protected String userName;
/*     */   
/*     */   protected String param1;
/*     */   
/*     */   protected String param2;
/*     */   
/*     */   @XmlElement(nillable = true)
/*     */   protected List<Properties> properties;
/*     */   
/*     */   public long getSubjectId() {
/*  77 */     return this.subjectId;
/*     */   }
/*     */   
/*     */   public void setSubjectId(long value) {
/*  85 */     this.subjectId = value;
/*     */   }
/*     */   
/*     */   public AuditEventType getType() {
/*  97 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(AuditEventType value) {
/* 109 */     this.type = value;
/*     */   }
/*     */   
/*     */   public XMLGregorianCalendar getDate() {
/* 121 */     return this.date;
/*     */   }
/*     */   
/*     */   public void setDate(XMLGregorianCalendar value) {
/* 133 */     this.date = value;
/*     */   }
/*     */   
/*     */   public String getUserName() {
/* 145 */     return this.userName;
/*     */   }
/*     */   
/*     */   public void setUserName(String value) {
/* 157 */     this.userName = value;
/*     */   }
/*     */   
/*     */   public String getParam1() {
/* 169 */     return this.param1;
/*     */   }
/*     */   
/*     */   public void setParam1(String value) {
/* 181 */     this.param1 = value;
/*     */   }
/*     */   
/*     */   public String getParam2() {
/* 193 */     return this.param2;
/*     */   }
/*     */   
/*     */   public void setParam2(String value) {
/* 205 */     this.param2 = value;
/*     */   }
/*     */   
/*     */   public List<Properties> getProperties() {
/* 231 */     if (this.properties == null)
/* 232 */       this.properties = new ArrayList<Properties>(); 
/* 234 */     return this.properties;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentContentService\AuditEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */