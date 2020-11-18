package bean;

public class ChartBean {
	
	String type;
	int count;

	public ChartBean(String type){
		this.type=type;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void increaseCount() {
		this.count += 1;
	}
	public void addCount(int values){
		count+=values;
	}
	
}
