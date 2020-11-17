package bean;

public class InputExpertBean  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean update;
	InputBean[] documents;
	
	public boolean isUpdate() {
		return update;
	}
	public void setUpdate(boolean update) {
		this.update = update;
	}
	public InputBean[] getDocuments() {
		return documents;
	}
	public void setDocuments(InputBean[] documents) {
		this.documents = documents;
	}
		
	
	
}	
