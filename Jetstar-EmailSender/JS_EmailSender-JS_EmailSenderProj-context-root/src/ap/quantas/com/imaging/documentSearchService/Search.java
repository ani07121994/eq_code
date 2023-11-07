/*     */ package ap.quantas.com.imaging.documentSearchService;
/*     */ 
/*     */ import ap.quantas.com.imaging.documentSearchService.Definition;
/*     */ import ap.quantas.com.imaging.documentSearchService.DefinitionPermissions;
/*     */ import ap.quantas.com.imaging.documentSearchService.SearchProperties;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElementRef;
/*     */ import javax.xml.bind.annotation.XmlType;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "Search", propOrder = {"properties", "parameterDefinitions", "searchExpressions", "resultColumns", "permissions", "security", "history"})
/*     */ public class Search
/*     */   extends Definition
/*     */ {
/*     */   @XmlElementRef(name = "properties", type = JAXBElement.class)
/*     */   protected JAXBElement<SearchProperties> properties;
/*     */   @XmlElementRef(name = "parameterDefinitions", type = JAXBElement.class)
/*     */   protected JAXBElement<ParameterDefinitions> parameterDefinitions;
/*     */   @XmlElementRef(name = "searchExpressions", type = JAXBElement.class)
/*     */   protected JAXBElement<SearchExpressions> searchExpressions;
/*     */   @XmlElementRef(name = "resultColumns", type = JAXBElement.class)
/*     */   protected JAXBElement<ResultColumns> resultColumns;
/*     */   @XmlElementRef(name = "permissions", type = JAXBElement.class)
/*     */   protected JAXBElement<DefinitionPermissions> permissions;
/*     */   @XmlElementRef(name = "security", type = JAXBElement.class)
/*     */   protected JAXBElement<Security> security;
/*     */   protected History history;
/*     */   
/*     */   public JAXBElement<SearchProperties> getProperties() {
/* 126 */     return this.properties;
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
/*     */   public void setProperties(JAXBElement<SearchProperties> value) {
/* 138 */     this.properties = value;
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
/*     */   public JAXBElement<ParameterDefinitions> getParameterDefinitions() {
/* 150 */     return this.parameterDefinitions;
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
/*     */   public void setParameterDefinitions(JAXBElement<ParameterDefinitions> value) {
/* 162 */     this.parameterDefinitions = value;
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
/*     */   public JAXBElement<SearchExpressions> getSearchExpressions() {
/* 174 */     return this.searchExpressions;
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
/*     */   public void setSearchExpressions(JAXBElement<SearchExpressions> value) {
/* 186 */     this.searchExpressions = value;
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
/*     */   public JAXBElement<ResultColumns> getResultColumns() {
/* 198 */     return this.resultColumns;
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
/*     */   public void setResultColumns(JAXBElement<ResultColumns> value) {
/* 210 */     this.resultColumns = value;
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
/*     */   public JAXBElement<DefinitionPermissions> getPermissions() {
/* 222 */     return this.permissions;
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
/*     */   public void setPermissions(JAXBElement<DefinitionPermissions> value) {
/* 234 */     this.permissions = value;
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
/*     */   public JAXBElement<Security> getSecurity() {
/* 246 */     return this.security;
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
/*     */   public void setSecurity(JAXBElement<Security> value) {
/* 258 */     this.security = value;
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
/*     */   public History getHistory() {
/* 270 */     return this.history;
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
/*     */   public void setHistory(History value) {
/* 282 */     this.history = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\Search.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */