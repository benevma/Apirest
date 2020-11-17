package bean;

public class OutputBean implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String filename;
	
	String analyze;//as example
	

	String categorize;//as example


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getAnalyze() {
		return analyze;
	}


	public void setAnalyze(String analyze) {
		this.analyze = analyze;
	}


	public String getCategorize() {
		return categorize;
	}


	public void setCategorize(String categorize) {
		this.categorize = categorize;
	}


	
}
