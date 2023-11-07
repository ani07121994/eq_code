/*     */ package ap.quantas.com.imaging.authentication;
/*     */ 
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlElementDecl;
/*     */ import javax.xml.bind.annotation.XmlRegistry;
/*     */ import javax.xml.namespace.QName;
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
/*     */ @XmlRegistry
/*     */ public class ObjectFactory
/*     */ {
/*  27 */   private static final QName _GetUserGroupsResponse_QNAME = new QName("http://imaging.oracle/", "getUserGroupsResponse");
/*  28 */   private static final QName _LogoutResponse_QNAME = new QName("http://imaging.oracle/", "logoutResponse");
/*  29 */   private static final QName _Login_QNAME = new QName("http://imaging.oracle/", "login");
/*  30 */   private static final QName _GetUserRoles_QNAME = new QName("http://imaging.oracle/", "getUserRoles");
/*  31 */   private static final QName _GetUserInfo_QNAME = new QName("http://imaging.oracle/", "getUserInfo");
/*  32 */   private static final QName _GetUserInfoResponse_QNAME = new QName("http://imaging.oracle/", "getUserInfoResponse");
/*  33 */   private static final QName _GetUserRolesResponse_QNAME = new QName("http://imaging.oracle/", "getUserRolesResponse");
/*  34 */   private static final QName _SecurityMember_QNAME = new QName("http://imaging.oracle/", "SecurityMember");
/*  35 */   private static final QName _LoginResponse_QNAME = new QName("http://imaging.oracle/", "loginResponse");
/*  36 */   private static final QName _GetUserGroups_QNAME = new QName("http://imaging.oracle/", "getUserGroups");
/*  37 */   private static final QName _Logout_QNAME = new QName("http://imaging.oracle/", "logout");
/*  38 */   private static final QName _ImagingException_QNAME = new QName("http://imaging.oracle/", "ImagingException");
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
/*     */   public GetUserInfoResponse createGetUserInfoResponse() {
/*  52 */     return new GetUserInfoResponse();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GetUserRolesResponse createGetUserRolesResponse() {
/*  60 */     return new GetUserRolesResponse();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GetUserRoles createGetUserRoles() {
/*  68 */     return new GetUserRoles();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SecurityMember createSecurityMember() {
/*  76 */     return new SecurityMember();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GetUserGroups createGetUserGroups() {
/*  84 */     return new GetUserGroups();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ImagingFaultInfo.FaultDetails createImagingFaultInfoFaultDetails() {
/*  92 */     return new ImagingFaultInfo.FaultDetails();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ImagingFaultInfo createImagingFaultInfo() {
/* 100 */     return new ImagingFaultInfo();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GetUserInfo createGetUserInfo() {
/* 108 */     return new GetUserInfo();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GetUserGroupsResponse createGetUserGroupsResponse() {
/* 116 */     return new GetUserGroupsResponse();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LogoutResponse createLogoutResponse() {
/* 124 */     return new LogoutResponse();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Logout createLogout() {
/* 132 */     return new Logout();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Login createLogin() {
/* 140 */     return new Login();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ImagingFaultDetail createImagingFaultDetail() {
/* 148 */     return new ImagingFaultDetail();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LoginResponse createLoginResponse() {
/* 156 */     return new LoginResponse();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getUserGroupsResponse")
/*     */   public JAXBElement<GetUserGroupsResponse> createGetUserGroupsResponse(GetUserGroupsResponse value) {
/* 165 */     return new JAXBElement<GetUserGroupsResponse>(_GetUserGroupsResponse_QNAME, GetUserGroupsResponse.class, null, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "logoutResponse")
/*     */   public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
/* 174 */     return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "login")
/*     */   public JAXBElement<Login> createLogin(Login value) {
/* 183 */     return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getUserRoles")
/*     */   public JAXBElement<GetUserRoles> createGetUserRoles(GetUserRoles value) {
/* 192 */     return new JAXBElement<GetUserRoles>(_GetUserRoles_QNAME, GetUserRoles.class, null, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getUserInfo")
/*     */   public JAXBElement<GetUserInfo> createGetUserInfo(GetUserInfo value) {
/* 201 */     return new JAXBElement<GetUserInfo>(_GetUserInfo_QNAME, GetUserInfo.class, null, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getUserInfoResponse")
/*     */   public JAXBElement<GetUserInfoResponse> createGetUserInfoResponse(GetUserInfoResponse value) {
/* 210 */     return new JAXBElement<GetUserInfoResponse>(_GetUserInfoResponse_QNAME, GetUserInfoResponse.class, null, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getUserRolesResponse")
/*     */   public JAXBElement<GetUserRolesResponse> createGetUserRolesResponse(GetUserRolesResponse value) {
/* 219 */     return new JAXBElement<GetUserRolesResponse>(_GetUserRolesResponse_QNAME, GetUserRolesResponse.class, null, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "SecurityMember")
/*     */   public JAXBElement<SecurityMember> createSecurityMember(SecurityMember value) {
/* 228 */     return new JAXBElement<SecurityMember>(_SecurityMember_QNAME, SecurityMember.class, null, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "loginResponse")
/*     */   public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
/* 237 */     return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "getUserGroups")
/*     */   public JAXBElement<GetUserGroups> createGetUserGroups(GetUserGroups value) {
/* 246 */     return new JAXBElement<GetUserGroups>(_GetUserGroups_QNAME, GetUserGroups.class, null, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "logout")
/*     */   public JAXBElement<Logout> createLogout(Logout value) {
/* 255 */     return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlElementDecl(namespace = "http://imaging.oracle/", name = "ImagingException")
/*     */   public JAXBElement<ImagingFaultInfo> createImagingException(ImagingFaultInfo value) {
/* 264 */     return new JAXBElement<ImagingFaultInfo>(_ImagingException_QNAME, ImagingFaultInfo.class, null, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\2146691\Downloads\JS_escalation_NXA_PROD.jar!\ap\quantas\com\imaging\authentication\ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */