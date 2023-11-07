package qantas.document.service;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import java.util.Map;

import javax.activation.DataHandler;







import oracle.imaging.BasicUserToken;
import oracle.imaging.DocumentContentService;
import oracle.imaging.DocumentService;
import oracle.imaging.ImagingException;
import oracle.imaging.NameId;
import oracle.imaging.RenderOptions;
import oracle.imaging.RenderPage;
import oracle.imaging.RenderResult;
import oracle.imaging.Rendition;
import oracle.imaging.Search;
import oracle.imaging.SearchArgument;
import oracle.imaging.SearchService;
import oracle.imaging.SearchValue;
import oracle.imaging.ServicesFactory;
import oracle.imaging.UserToken;
import qantas.document.exception.ServiceException;

public class DownloadDocument {
   public String getDocument(Map map) throws ServiceException {
	   
	  String strDowunloadDocName = "";
      try { // try-catch
 		 System.out.println("Map Values==="+map);

         UserToken credentials = new BasicUserToken((String)map.get("USER_NAME"), (String)map.get("PWD"));
         ServicesFactory servicesFactory =
            ServicesFactory.login(credentials, Locale.US, (String)map.get("IMAGING_URL"));

         //String InvoiceArr[] = {"ANC-30225203","ANC-30230047","ANC-30234100","HNL-30221844","HNL-30225627","HNL-30225629","HNL-30225779","HNL-30229927","HNL-30229929","HNL-30229930","HNL-30233370","HNL-30233371","HNL-30233372","HNLM-30222081","HNLM-30225628","HNLM-30225780","HNLM-30229928","HNLM-30230051","HNLM-30234083","ORD-30226341","ORD-30230130","ORD-30233614","ORD-30235326","ORD30230130","QRD30218755REV","303288","303289","RD296565","RD298553","RD298692","RD298880","RD298996","RD299802","RD300351","RD300352","RD300353","RD300354","RD300355","RD300356","RD300357","RD300358","RD300465","RD300466","RD300519","RD300539","RD300559","RD300650","RD300847","RD301827","RD301828","RD301829","RD301830","RD301831","RD301832","RD301833","RD301834","RD301942","RD301943","RD301997","RD302017","RD302037","RD302127","RD302323","RD303529","RD303785","RD303786","RD303787","RD303788","RD303789","RD303790","RD303791","RD303898","RD303899","RD303952","RD303972","RD303992","RD304082","RD304287","RI299535","RI301176","RI301180","RI301186","RI301189","RI301263","RI302632","RM17377","RM17394","UC4003038","UC4003182","UC4003335","UE4003074","UE4003217","UG3000116","UG3000121","UG3000126","UI4003107","UI4003255","UL4002976","UL4003116","UL4003264","UP297633","UP301056","UP301543","UW3200121","F0002758","F0002778","F0002792","F0002833","F0002917","F0002953","F0002973","F20160158","F20160215","F20160216","F20161374","F20161446","F20161491","F20162005","F20162062","F20162065","F20162135","F20162186","F20162232","F20162300","F20162301","F20162302","F20170065","F20170066","F20170143","F20170151","F20170152","F20I61490","100020800","100021354","100021355","100021356","11017576","11017577","11017585","11017821","11017822","11017859","11018099","11018100","11018120","11018393","11018394","11018396","11018674","11018675","11018676","11018957","11018958","11018964","11019205","11019206","11019240","11019496","11019500","11019502","11019790","11019791","11019803","11020051","11020052","11020059","11020341","11020342","11020353","11020602","11020603","11020633","11020875","11020876","11020886","11021162","11021170","11021190","11021419","11021420","11021450","11021754","11021758","11021759","11021942","11021953","11022133","11022134","11022314","11022319","11022488","11022489","12005290","12005549","12005623","12005731","12005778","12005913","12005986","12006081","12006123","12006234","12006306","12006420","12006515","12006557","12006680","12006768","12006834","12006891","12007029","12007063","12007198","13005025","13005542","13005775","13006010","13006127","14002565","14002700","14002736","14002796","14002830","14003050","14003070","14003209","14003232","14003242","16001595","16001847","16001957","16002165","17000477","17000544","17000682","18016346","18017073","18017245","18017556","18017557","18019194","18019566","18019803","18019804","18020475","18020758","18021117","18021246","18021440","18021441","18021520","18021920","18021921","18801102","2117257523","2117257755","2117258981","2117259141","2117259995","2117260145","2117260363","2117260596","2117261461","2117261473","2117255323","2117255324","2117255326","2117255327","2117256597","2117257967","2117258245","2117258246","2117258247","2117258249","2117259466","2117259467","2117259468","2117259469","2117260523","2117260882","2117260883","2117260884","2117260885","2117261915","2117262266","2117262267","ANC-30230047","ANC-30234100","HNL-30221844","HNL-30225627","HNL-30225629","HNL-30229927","HNL-30229929","HNL-30229930","HNL-30233370","HNL-30233371","HNL-30233372","HNLM-30222081","HNLM-30225628","HNLM-30229928","HNLM-30230051","HNLM-30234083","ORD-30226341","ORD-30230130","ORD-30233614","ORD-30235326","ORD30230130","QRD30218755REV"};

         DataHandler fileData = null;
         FileOutputStream outputStream = null;
         
         try { // try-finally to ensure logout
            SearchService searchService = servicesFactory.getSearchService();
            DocumentContentService docContentService = servicesFactory.getDocumentContentService();

            // The find the document with invoice number 1234 using the Invoices search
            List<SearchArgument> searchArguments = new ArrayList<SearchArgument>();

            //Start : Invoice Number
            SearchValue searchValue = new SearchValue(SearchValue.Type.TEXT, (String)map.get("Invoice_Number"));
            SearchArgument searchArgument = new SearchArgument("Invoice Number", searchValue);
            searchArgument.setOperatorValue(Search.Operator.CONTAINS);
            searchArguments.add(searchArgument);
            //End : Invoice Number
            
            //Start : Document Type
            searchValue = new SearchValue(SearchValue.Type.TEXT, (String)map.get("Document_Type"));
            searchArgument = new SearchArgument("Document Type", searchValue);
            searchArgument.setOperatorValue(Search.Operator.CONTAINS);
            searchArguments.add(searchArgument);
            //End : Document Type
            
            //Start : Site ID
            searchValue = new SearchValue(SearchValue.Type.TEXT, (String)map.get("Site_ID"));
            searchArgument = new SearchArgument("Site ID", searchValue);
            searchArgument.setOperatorValue(Search.Operator.CONTAINS);
            searchArguments.add(searchArgument);
            //End : Site ID            
                        
            Search.ResultSet resultSet = searchService.executeSavedSearch(new NameId((String)map.get("IMAGING_NAMEID")), searchArguments);

            if (resultSet.getTotalResults() == 0) {
               System.out.println("Document not found");
               strDowunloadDocName = "Document not found";
            }

            String documentId = resultSet.getResults().get(0).getDocumentId();
            strDowunloadDocName = resultSet.getResults().get(0).getDocument().getName();

            System.out.println("documentId="+documentId+", documentName="+strDowunloadDocName);

            // retrieve original native document content.
            fileData = docContentService.retrieve(documentId);
            File file = new File((String)map.get("Download_Path")+strDowunloadDocName);
            
            //Giving access 777 to the downloaded file.
            file.setReadable(true, false);
            file.setExecutable(true, false);
            file.setWritable(true, false);
            
            outputStream = new FileOutputStream(file);
           // outputStream = new FileOutputStream(documentName);
            fileData.writeTo(outputStream);
            if(outputStream != null){
            	outputStream.close();
            	outputStream.flush();
            }  
            

         }
         finally {
        	 try{
	            if (servicesFactory != null) {
	               servicesFactory.logout();
	            }
	            if(outputStream != null){
	            	outputStream.close();
	            }
        	 }catch(Exception e){
        		 
        	 }
         }
      }
      catch (Exception e) {
         System.out.println(e.getMessage());
      }
      return strDowunloadDocName;
   }
}