
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import oracle.imaging.*;



public class SearchInvoice {

	public static void main(String[] args) {
		try { // try-catch
	         UserToken credentials = new BasicUserToken("weblogic", "wls123@PRD");
	         ServicesFactory servicesFactory =
//	            ServicesFactory.login(credentials, Locale.US, "http://eqtest-capture1:16033/imaging");
	         		            ServicesFactory.login(credentials, Locale.US, "http://eqprod-capture1:16033/imaging");

	         try { // try-finally to ensure logout
	            SearchService searchService = servicesFactory.getSearchService();
	            NameId invoiceSearchNameId = null;
	            
	            // List the viewable applications to confirm that "Invoices" exists
	            
	            List<NameId> searchList = 
	               searchService.listSearches(Search.Ability.VIEW);
	            for (NameId nameId: searchList) {
	            	System.out.println(nameId.getName());
	            	if (nameId.getName().equals("JS_QF_Search_Invoice_ALL")) {
	                    invoiceSearchNameId = nameId;
	                 }
	               
	            }
	            System.out.println(invoiceSearchNameId);
	            // The find the document with invoice number 1234 using the Invoices search
	            List<SearchArgument> searchArguments = new ArrayList<SearchArgument>();
	            SearchValue searchValue = new SearchValue(SearchValue.Type.TEXT, "PQ000019");
	            SearchArgument searchArgument = new SearchArgument("Invoice Number", searchValue);
	            searchArgument.setOperatorValue(Search.Operator.EQUAL);
	            searchArguments.add(searchArgument);
	            Search.ResultSet resultSet =
	               searchService.executeSavedSearch(invoiceSearchNameId, searchArguments);
	            if (resultSet.getTotalResults() == 0) {
	               System.out.println("Document not found");
	            }
	            
	            //System.out.println(resultSet.getResults().get(5));
	            List<TypedValue> list = resultSet.getResults().get(0).getColumnValues();
	            for(int i = 0 ; i < list.size();i++){
	            	System.out.println("i = "+i+"\t"+list.get(i).getStringValue());
	            }
	            /*List<TypedValue> list = resultSet.getResults().get(0).getColumnValues();
	            System.out.println("Invoice number :"+list.get(13).getStringValue());
	            
	            String documentId = resultSet.getResults().get(0).getDocumentId();
	            String documentName = resultSet.getResults().get(0).getDocument().getName();
	            
	            System.out.println("documentId :"+documentId);
	            System.out.println("documentName :"+documentName);*/
	          
	         }
	         finally {
	            if (servicesFactory != null) {
	               try {
					servicesFactory.logout();
				} catch (oracle.imaging.ImagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            }
	         }
	}catch(Exception e){
		e.printStackTrace();
	}
		
}
}
