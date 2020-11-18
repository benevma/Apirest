package my.rest.api;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bean.ChartBean;
import bean.InputExpertBean;
import bean.OutputBean;
import bean.OutputExpertBean;
import my.rest.api.db.DaoService;
import my.rest.api.db.IDaoService;
import my.rest.api.db.bean.DaoInputBean;
import my.rest.api.git.GitOperationService;
import my.rest.api.git.IGitOperationService;
import my.rest.api.nl.bean.Category;
import my.rest.api.nl.client.INlClientService;
import my.rest.api.nl.client.NlClientService;
import my.rest.api.utils.ApiRestPropertiesUtil;

@Path("/service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApiService {
	
	IGitOperationService gitService = null;//Inject this service (ex. with spring)
	
	IDaoService daoService = null;//Inject this service (ex. with spring)
	
	INlClientService aiService = null;//Inject this service (ex. with spring)
	
	@POST
	@Path("/analyze")
	public Response postAnalyze(InputExpertBean info) {
		
		//Need to update file to git folder
		if(ApiRestPropertiesUtil.getInstance().isUpdateGit()){
			gitService = new GitOperationService();
			gitService.pushFile(info.getDocuments());
		}
		
		//Invoke ai services
		aiService = NlClientService.getInstance();
		ArrayList<DaoInputBean> aiOutput = aiService.evaluateDocuments(info.getDocuments());
		
		//Invoke db service
		if(aiOutput!=null && aiOutput.size()>0){
			//store data to db
			daoService = new DaoService();
			daoService.insertDb(aiOutput);
		}
		
		//build output
		OutputExpertBean outputBean = new OutputExpertBean();
		outputBean.setEsito("OK");
		ArrayList<OutputBean> contenuti = new ArrayList<OutputBean>();
		outputBean.setValue(contenuti);
		
		if(aiOutput!=null && aiOutput.size()>0){
			for(DaoInputBean input : aiOutput){

				OutputBean infoOut = new OutputBean();
				infoOut.setFilename(input.getFileName());

				HashMap<String, ChartBean> chartbeans = new HashMap<String, ChartBean>();
				
				if(input.getCategorize()!=null
						&& input.getCategorize().getData()!=null
						&& input.getCategorize().getData().getCategories()!=null
						&& input.getCategorize().getData().getCategories().size()>0){
					

					for(Category cat : input.getCategorize().getData().getCategories()){
						ChartBean chartCurrent = chartbeans.containsKey(cat.getLabel())?chartbeans.get(cat.getLabel()):new ChartBean(cat.getLabel());
						chartCurrent.increaseCount();
						chartbeans.put(cat.getLabel(), chartCurrent);
					}
					
					ArrayList<ChartBean> catArray = new ArrayList<ChartBean>();
					for(String key : chartbeans.keySet()){
						catArray.add(chartbeans.get(key));
					}
					infoOut.setCategories(catArray);
				}
				
				contenuti.add(infoOut);
			}
		}
		
		return Response.status(200).entity(outputBean).build();

	}
		
}
