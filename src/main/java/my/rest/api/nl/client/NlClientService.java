package my.rest.api.nl.client;

import java.util.ArrayList;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import bean.InputBean;
import my.rest.api.db.bean.DaoInputBean;
import my.rest.api.nl.bean.AnalysisRequest;
import my.rest.api.nl.bean.AnalyzeResponse;
import my.rest.api.nl.bean.CategorizeResponse;
import my.rest.api.nl.bean.Document;
import my.rest.api.utils.ClientUtils;

public class NlClientService implements INlClientService{
	
	private static WebResource webResourceAnalyze;	
	private static WebResource webResourceCategorize;	
	
	private static NlClientService service = null;
	
	private NlClientService(){}
	
	public static NlClientService getInstance(){
		if(service==null){
			service = new NlClientService();
			//Client init
			Client client = Client.create();

			webResourceAnalyze = client
			           .resource(INlClientService.ANALYZE_URL);
            //add header: Authorization Bearer Rc7JE8P7XUgSCPogsdfdLMfITqQQrjg
            String value = "Bearer " + INlClientService.BEARER;
            webResourceAnalyze.setProperty("Authorization", value);
            
            webResourceCategorize = client
			           .resource(INlClientService.CATEGORIZE_URL);
            webResourceCategorize.setProperty("Authorization", value);
		}
		return service;
	}
	
	/**
	 *Invoke AI  analzye and categorize
	 */
	public ArrayList<DaoInputBean> evaluateDocuments(InputBean[] documents){
		
		ArrayList<DaoInputBean> output = new ArrayList<DaoInputBean>();
		
		for(InputBean doc : documents){
			DaoInputBean daoInput= new DaoInputBean();
			daoInput.setFileName(doc.getName());
			AnalysisRequest request = new AnalysisRequest();
			Document docNl = new Document();
			docNl.setText(doc.getContent());
			request.setDocument(docNl);
			ClientResponse response = null;
			
			AnalyzeResponse responseAnalyze = null;
			
			try {
				response = webResourceAnalyze.accept("application/json")
				        .post(ClientResponse.class,request);
			} catch (UniformInterfaceException e) {
				System.out.println("webResourceAnalyze UniformInterfaceException "+doc.getName());
				//retrieve mock response just for testing
				responseAnalyze = ClientUtils.getObjectFromJsonString(INlClientService.ANALIZE_MOCK, AnalyzeResponse.class);
			} catch (ClientHandlerException e) {
				System.out.println("webResourceAnalyze ClientHandlerException "+doc.getName());
				//retrieve mock response just for testing
				responseAnalyze = ClientUtils.getObjectFromJsonString(INlClientService.ANALIZE_MOCK, AnalyzeResponse.class);
			}finally{
				if(response!=null
						&& response.getStatus() == 200){
					responseAnalyze = response.getEntity(AnalyzeResponse.class);
				}
			}
			
			daoInput.setAnalize(responseAnalyze);

			CategorizeResponse responseCategorize = null;
			
			try {
				response = webResourceCategorize.accept("application/json")
				        .post(ClientResponse.class,request);
			} catch (UniformInterfaceException e) {
				System.out.println("webResourceCategorize UniformInterfaceException "+doc.getName());
				//retrieve mock response just for testing
				responseCategorize = ClientUtils.getObjectFromJsonString(INlClientService.CATEGORIZE_MOCK, CategorizeResponse.class);
			} catch (ClientHandlerException e) {
				System.out.println("webResourceCategorize ClientHandlerException "+doc.getName());
				//retrieve mock response just for testing
				responseCategorize = ClientUtils.getObjectFromJsonString(INlClientService.CATEGORIZE_MOCK, CategorizeResponse.class);
			}finally{
				if(response!=null
						&& response.getStatus() == 200){
					responseCategorize = response.getEntity(CategorizeResponse.class);
				}
			}
			daoInput.setCategorize(responseCategorize);
			
			output.add(daoInput);
		}
		
		return output;
     
	}
	
	
}
