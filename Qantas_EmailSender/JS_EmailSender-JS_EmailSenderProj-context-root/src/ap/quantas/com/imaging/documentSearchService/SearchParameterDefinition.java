/*     */ package ap.quantas.com.imaging.documentSearchService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentSearchService.NameId;
/*     */ import ap.quantas.com.imaging.documentSearchService.Operator;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchValue;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "SearchParameterDefinition", propOrder = {"defaultValue", "operatorText", "defaultOperator", "name", "possibleOperators", "prompt", "readOnly", "required", "picklistApplication", "picklistField"})
/*     */ public class SearchParameterDefinition {
/*     */   protected SearchValue defaultValue;
/*     */   
/*     */   protected String operatorText;
/*     */   
/*     */   protected Operator defaultOperator;
/*     */   
/*     */   protected String name;
/*     */   
/*     */   protected PossibleOperators possibleOperators;
/*     */   
/*     */   protected String prompt;
/*     */   
/*     */   protected boolean readOnly;
/*     */   
/*     */   protected boolean required;
/*     */   
/*     */   protected NameId picklistApplication;
/*     */   
/*     */   protected NameId picklistField;
/*     */   
/*     */   public SearchValue getDefaultValue() {
/*  84 */     return this.defaultValue;
/*     */   }
/*     */   
/*     */   public void setDefaultValue(SearchValue value) {
/*  96 */     this.defaultValue = value;
/*     */   }
/*     */   
/*     */   public String getOperatorText() {
/* 108 */     return this.operatorText;
/*     */   }
/*     */   
/*     */   public void setOperatorText(String value) {
/* 120 */     this.operatorText = value;
/*     */   }
/*     */   
/*     */   public Operator getDefaultOperator() {
/* 132 */     return this.defaultOperator;
/*     */   }
/*     */   
/*     */   public void setDefaultOperator(Operator value) {
/* 144 */     this.defaultOperator = value;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 156 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String value) {
/* 168 */     this.name = value;
/*     */   }
/*     */   
/*     */   public PossibleOperators getPossibleOperators() {
/* 180 */     return this.possibleOperators;
/*     */   }
/*     */   
/*     */   public void setPossibleOperators(PossibleOperators value) {
/* 192 */     this.possibleOperators = value;
/*     */   }
/*     */   
/*     */   public String getPrompt() {
/* 204 */     return this.prompt;
/*     */   }
/*     */   
/*     */   public void setPrompt(String value) {
/* 216 */     this.prompt = value;
/*     */   }
/*     */   
/*     */   public boolean isReadOnly() {
/* 224 */     return this.readOnly;
/*     */   }
/*     */   
/*     */   public void setReadOnly(boolean value) {
/* 232 */     this.readOnly = value;
/*     */   }
/*     */   
/*     */   public boolean isRequired() {
/* 240 */     return this.required;
/*     */   }
/*     */   
/*     */   public void setRequired(boolean value) {
/* 248 */     this.required = value;
/*     */   }
/*     */   
/*     */   public NameId getPicklistApplication() {
/* 260 */     return this.picklistApplication;
/*     */   }
/*     */   
/*     */   public void setPicklistApplication(NameId value) {
/* 272 */     this.picklistApplication = value;
/*     */   }
/*     */   
/*     */   public NameId getPicklistField() {
/* 284 */     return this.picklistField;
/*     */   }
/*     */   
/*     */   public void setPicklistField(NameId value) {
/* 296 */     this.picklistField = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\SearchParameterDefinition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */