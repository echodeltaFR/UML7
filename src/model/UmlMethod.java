package model;
import java.util.ArrayList;
import java.util.List;

public class UmlMethod extends UmlEntity{

	private ArrayList<String> params;
	private String returnType;
	private String name;
	private Visibility visibility;
	private ArrayList<Modifier> modifier;
	
	public UmlMethod(ArrayList<String> params,  
			String returnValue,
			String name,
			Visibility visibility,
			ArrayList<Modifier> modifier) {
		super(visibility, modifier);
		this.returnType = returnValue;
		this.params = params;
		this.name = name;
		this.visibility = visibility;
		this.modifier = modifier;
	}
	
	public void addAllParams(ArrayList<String> params) {
		this.params.addAll(params);
	}
	
	public void addParams(String param) {
		this.params.add(param);
	}
	
	public void setReturn(String returnType) {
		this.returnType = returnType;
	}
	
	public void removeReturn() {
		this.returnType = null;
	}
	
	public String getReturnType() {
		return this.returnType;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<String> getParams(){
		return this.params;
	}
	
	public void removeParams(ArrayList<String> params) {
		this.params.removeAll(params);
	}
	
}
