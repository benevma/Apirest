package my.rest.api.db.bean;

import my.rest.api.nl.bean.AnalyzeResponse;
import my.rest.api.nl.bean.CategorizeResponse;

public class DaoInputBean {
	
	String fileName;
	AnalyzeResponse analize;
	CategorizeResponse categorize;
	
	public AnalyzeResponse getAnalize() {
		return analize;
	}
	public void setAnalize(AnalyzeResponse analize) {
		this.analize = analize;
	}
	public CategorizeResponse getCategorize() {
		return categorize;
	}
	public void setCategorize(CategorizeResponse categorize) {
		this.categorize = categorize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
}
