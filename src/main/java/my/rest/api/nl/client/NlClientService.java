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
		
	private static NlClientService service = null;
	private static WebResource webResourceAnalyze = null;
	private static WebResource webResourceCategorize = null;
	
	private NlClientService(){}
	
	public static NlClientService getInstance(){
		if(service==null){
			//Client init
			Client client = Client.create();
			service = new NlClientService();
			webResourceAnalyze = client
			           .resource(ApiRestPropertiesUtil.getInstance().getAnalyzeurl());
			webResourceCategorize = client
			           .resource(ApiRestPropertiesUtil.getInstance().getCategorizeurl());
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
				response = webResourceAnalyze
					    .header("Content-Type", "application/json;charset=UTF-8")
					    .header("Authorization", "Bearer " + ApiRestPropertiesUtil.getInstance().getBearer();)
				        .post(ClientResponse.class,request);
			} catch (UniformInterfaceException e) {
				System.out.println("webResourceAnalyze UniformInterfaceException "+doc.getName());
				//retrieve mock response just for testing
				responseAnalyze = ClientUtils.getObjectFromJsonString(ApiRestPropertiesUtil.getInstance().getAnalyzemock(), AnalyzeResponse.class);
			} catch (ClientHandlerException e) {
				System.out.println("webResourceAnalyze ClientHandlerException "+doc.getName());
				//retrieve mock response just for testing
				responseAnalyze = ClientUtils.getObjectFromJsonString(ApiRestPropertiesUtil.getInstance().getAnalyzemock(), AnalyzeResponse.class);
			}finally{
				if(response!=null
						&& response.getStatus() == 200){
				 
				 responseAnalyze = ClientUtils.getObjectFromResponse(response, AnalyzeResponse.class);
				 
				}
			}
			
			daoInput.setAnalize(responseAnalyze);

			CategorizeResponse responseCategorize = null;
			
			try {
				
				response = webResourceCategorize
					    .header("Content-Type", "application/json;charset=UTF-8")
					    .header("Authorization", "Bearer " + ApiRestPropertiesUtil.getInstance().getBearer();)
				        .post(ClientResponse.class,request);
				
			} catch (UniformInterfaceException e) {
				System.out.println("webResourceCategorize UniformInterfaceException "+doc.getName());
				//retrieve mock response just for testing
				responseCategorize = ClientUtils.getObjectFromJsonString(ApiRestPropertiesUtil.getInstance().getCategorizemock(), CategorizeResponse.class);
			} catch (ClientHandlerException e) {
				System.out.println("webResourceCategorize ClientHandlerException "+doc.getName());
				//retrieve mock response just for testing
				responseCategorize = ClientUtils.getObjectFromJsonString(ApiRestPropertiesUtil.getInstance().getCategorizemock(), CategorizeResponse.class);
			}finally{
				if(response!=null
						&& response.getStatus() == 200){
					
					responseCategorize = ClientUtils.getObjectFromResponse(response,CategorizeResponse.class);
					
				}
			}
			daoInput.setCategorize(responseCategorize);
			
			output.add(daoInput);
		}
		
		return output;
     
	}
	
	
}
