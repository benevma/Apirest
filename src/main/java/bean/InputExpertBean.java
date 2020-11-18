package bean;

public class InputExpertBean  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InputBean[] documents;
	
	public InputBean[] getDocuments() {
		return documents;
	}
	public void setDocuments(InputBean[] documents) {
		this.documents = documents;
	}
}	
