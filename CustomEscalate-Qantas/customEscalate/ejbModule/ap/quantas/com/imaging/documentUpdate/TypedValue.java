/*    */ package ap.quantas.com.imaging.documentUpdate;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlAttribute;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ import javax.xml.bind.annotation.XmlValue;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "TypedValue", propOrder = {"value"})
/*    */ public class TypedValue
/*    */ {
/*    */   @XmlValue
/*    */   protected String value;
/*    */   @XmlAttribute
/*    */   protected FieldType type;
/*    */   
/*    */   public String getValue() {
/* 48 */     return this.value;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setValue(String value) {
/* 60 */     this.value = value;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FieldType getType() {
/* 72 */     return this.type;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setType(FieldType value) {
/* 84 */     this.type = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\documentUpdate\TypedValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */