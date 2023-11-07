/*     */ package ap.quantas.com.imaging.documentSearchService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentSearchService.Operator;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchValue;
/*     */ import ap.quantas.com.imaging.documentSearchService.TypedValue;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "searchParameter2", propOrder = {"parameterName", "prompt", "operatorText", "defaultOperator", "possibleOperators", "defaultValue", "readOnly", "required", "picklist"})
/*     */ public class SearchParameter2 {
/*     */   protected String parameterName;
/*     */   
/*     */   protected String prompt;
/*     */   
/*     */   protected String operatorText;
/*     */   
/*     */   protected Operator defaultOperator;
/*     */   
/*     */   protected PossibleOperators possibleOperators;
/*     */   
/*     */   protected SearchValue defaultValue;
/*     */   
/*     */   protected boolean readOnly;
/*     */   
/*     */   protected boolean required;
/*     */   
/*     */   protected List<TypedValue> picklist;
/*     */   
/*     */   public String getParameterName() {
/*  81 */     return this.parameterName;
/*     */   }
/*     */   
/*     */   public void setParameterName(String value) {
/*  93 */     this.parameterName = value;
/*     */   }
/*     */   
/*     */   public String getPrompt() {
/* 105 */     return this.prompt;
/*     */   }
/*     */   
/*     */   public void setPrompt(String value) {
/* 117 */     this.prompt = value;
/*     */   }
/*     */   
/*     */   public String getOperatorText() {
/* 129 */     return this.operatorText;
/*     */   }
/*     */   
/*     */   public void setOperatorText(String value) {
/* 141 */     this.operatorText = value;
/*     */   }
/*     */   
/*     */   public Operator getDefaultOperator() {
/* 153 */     return this.defaultOperator;
/*     */   }
/*     */   
/*     */   public void setDefaultOperator(Operator value) {
/* 165 */     this.defaultOperator = value;
/*     */   }
/*     */   
/*     */   public PossibleOperators getPossibleOperators() {
/* 177 */     return this.possibleOperators;
/*     */   }
/*     */   
/*     */   public void setPossibleOperators(PossibleOperators value) {
/* 189 */     this.possibleOperators = value;
/*     */   }
/*     */   
/*     */   public SearchValue getDefaultValue() {
/* 201 */     return this.defaultValue;
/*     */   }
/*     */   
/*     */   public void setDefaultValue(SearchValue value) {
/* 213 */     this.defaultValue = value;
/*     */   }
/*     */   
/*     */   public boolean isReadOnly() {
/* 221 */     return this.readOnly;
/*     */   }
/*     */   
/*     */   public void setReadOnly(boolean value) {
/* 229 */     this.readOnly = value;
/*     */   }
/*     */   
/*     */   public boolean isRequired() {
/* 237 */     return this.required;
/*     */   }
/*     */   
/*     */   public void setRequired(boolean value) {
/* 245 */     this.required = value;
/*     */   }
/*     */   
/*     */   public List<TypedValue> getPicklist() {
/* 271 */     if (this.picklist == null)
/* 272 */       this.picklist = new ArrayList<TypedValue>(); 
/* 274 */     return this.picklist;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SearchParameter2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */