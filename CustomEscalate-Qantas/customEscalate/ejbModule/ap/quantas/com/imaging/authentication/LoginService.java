package ap.quantas.com.imaging.authentication;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "LoginService", targetNamespace = "http://imaging.oracle/")
@XmlSeeAlso({ObjectFactory.class})
public interface LoginService {
  @WebMethod
  @WebResult(targetNamespace = "")
  @RequestWrapper(localName = "getUserInfo", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.authentication.GetUserInfo")
  @ResponseWrapper(localName = "getUserInfoResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.authentication.GetUserInfoResponse")
  SecurityMember getUserInfo() throws ImagingException;
  
  @WebMethod
  @RequestWrapper(localName = "logout", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.authentication.Logout")
  @ResponseWrapper(localName = "logoutResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.authentication.LogoutResponse")
  void logout() throws ImagingException;
  
  @WebMethod
  @RequestWrapper(localName = "login", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.authentication.Login")
  @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.authentication.LoginResponse")
  void login() throws ImagingException;
  
  @WebMethod
  @WebResult(targetNamespace = "")
  @RequestWrapper(localName = "getUserGroups", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.authentication.GetUserGroups")
  @ResponseWrapper(localName = "getUserGroupsResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.authentication.GetUserGroupsResponse")
  List<SecurityMember> getUserGroups() throws ImagingException;
  
  @WebMethod
  @WebResult(targetNamespace = "")
  @RequestWrapper(localName = "getUserRoles", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.authentication.GetUserRoles")
  @ResponseWrapper(localName = "getUserRolesResponse", targetNamespace = "http://imaging.oracle/", className = "com.tcs.qantas.AP.imaging.authentication.GetUserRolesResponse")
  List<SecurityMember> getUserRoles() throws ImagingException;
}


/* Location:              C:\Users\2146691\Downloads\customEscalate.jar!\ap\quantas\com\imaging\authentication\LoginService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */