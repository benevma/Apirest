package my.rest.api.nl.client;

import java.util.ArrayList;

import bean.InputBean;
import my.rest.api.db.bean.DaoInputBean;

public interface INlClientService {
	
	public ArrayList<DaoInputBean> evaluateDocuments(InputBean[] documents);
	
	
}
