package bean;

import java.util.ArrayList;

public class OutputBean implements java.io.Serializable{
	
	String filename;
	
	ArrayList<ChartBean> categories;//as example
	


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public ArrayList<ChartBean> getCategories() {
		return categories;
	}


	public void setCategories(ArrayList<ChartBean> categories) {
		this.categories = categories;
	}

	
}
