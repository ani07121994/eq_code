package ap.quantas.com.imaging.documentSearchService;

import ap.quantas.com.imaging.documentSearchService.DefinitionPermissions;
import ap.quantas.com.imaging.documentSearchService.DocumentPermissions;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasePermissions")
@XmlSeeAlso({DefinitionPermissions.class, DocumentPermissions.class})
public abstract class BasePermissions {}


/* Location:              C:\Users\2033471\Downloads\Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\imaging\documentSearchService\BasePermissions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */