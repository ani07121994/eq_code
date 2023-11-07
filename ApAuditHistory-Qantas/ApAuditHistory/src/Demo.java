import java.util.Date;
import java.util.List;
import java.util.Locale;

import oracle.imaging.Application;
import oracle.imaging.ApplicationService;
import oracle.imaging.AuditEvent;
import oracle.imaging.BasicUserToken;
import oracle.imaging.Document;
import oracle.imaging.Document.FieldValue;
import oracle.imaging.DocumentContentService;
import oracle.imaging.DocumentService;
import oracle.imaging.ImagingException;
import oracle.imaging.ServicesFactory;
import oracle.imaging.UserToken;
import oracle.imaging.Document.SectionSet;
import oracle.imaging.Document.SectionFlag;


public class Demo {
public static void main(String[] args) {

try { // try-catch
			//UserToken credentials = new BasicUserToken("eqadmin", "weblogic1"); //	TEST
			UserToken credentials = new BasicUserToken("weblogic", "wls123@PRD"); //	PROD
			ServicesFactory servicesFactory = 
//			ServicesFactory.login(credentials, Locale.US,"http://eqtest-capture1:16033/imaging/ws");
					ServicesFactory.login(credentials, Locale.US,"http://eqprod-capture1:16033/imaging"); // Prod
			try { // try-finally to ensure logout
			DocumentService docService = servicesFactory.getDocumentService();

			
			SectionSet sectionSet = Document.SectionSet.of(Document.SectionFlag.FIELDVALUES);
			
			Document dd = docService.getDocument("2.IPM_1905717", sectionSet);
			
			List<FieldValue> listFields =  dd.getFieldValues();
			
			
			for(FieldValue ob : listFields){
				System.out.println(ob.getName() + "--> "+ob.getStringValue());
				if(ob.getName().equals("Invoice Number"))
				{
					System.out.println("Invoice Number : "+ob.getStringValue());
					break;
				}

			}
			
			}
finally {
			if (servicesFactory != null) {
			servicesFactory.logout();
			}
		}
	}
	catch (ImagingException e) {
		e.printStackTrace();
	}
}
}