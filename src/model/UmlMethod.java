package Agile;
import java.util.ArrayList;

public class UmlMethod {

	private ArrayList<String> params;
	private String returnValue;
	private String name;
	private String visibility;
	private String modifier;
	
	public UmlMethod(String visibility, 
			String modifier, 
			ArrayList<String> params,  
			String returnValue,
			String name) {
		this.visibility = visibility;
		this.modifier = modifier;
		this.returnValue = returnValue;
		this.params = params;
		this.name = name;
	}
	
	public void addAllParams(ArrayList<String> params) {
		this.params.addAll(params);
	}
	
	public void addParams(String params) {
		this.params.add(params);
	}
	
	public void setReturn(String returnValue) {
		this.returnValue = returnValue;
	}
	
	public void removeReturn(String returnValue) {
		this.returnValue = null;
	}
	
	public void removeParams(ArrayList<String> params) {
		this.params.remove(params);
	}
	
}
