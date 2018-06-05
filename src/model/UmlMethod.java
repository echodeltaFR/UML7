package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Class which allow to create a method
 * @author fmeslet
 * @version 1.0
 */
public class UmlMethod extends UmlEntity{

	/**
	 * Method parameters.
	 */
	private List<UmlParams> params;
	/**
	 * Method return type.
	 */
	private UmlType returnType;
	/**
	 * Method name.
	 */
	private String name;
	
	/**
	 * Build a class method.
	 * @param params method parameter
	 * @param returnType method return type
	 * @param name method name
	 * @param visibility method visibility
	 * @param modifier method modifiers
	 */
	public UmlMethod(List<UmlParams> params,  
			UmlType returnType,
			String name,
			Visibility visibility,
			Set<Modifier> modifier) {
		super(visibility, modifier);
		this.returnType = returnType;
		if (params != null) {
			this.params = new ArrayList<UmlParams>(params);
		} else {
			this.params = new ArrayList<UmlParams>();
		}
		this.name = name;
	}
	
	/**
	 * Add all the method parameters.
	 * @param params the method parameters to add
	 */
	public void addAllParams(List<UmlParams> params) {
		this.params.addAll(params);
	}
	
	/**
	 * Add a method parameter.
	 * @param param the method parameters to add
	 */
	public void addParams(UmlParams param) {
		this.params.add(param);
	}
	
	/**
	 * Add return type.
	 * @param returnType return type
	 */
	public void setReturnType(UmlType returnType) {
		this.returnType = returnType;
	}
	
	/**
	 * Delete return type.
	 */
	public void removeReturnType() {
		this.returnType = null;
	}
	
	/**
	 * Get return type.
	 * @return returnType return type
	 */
	public UmlType getReturnType() {
		return this.returnType;
	}
	
	/**
	 * Get method name.
	 * @return the method name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the method parameter(s).
	 * @return method parameter(s)
	 */
	public List<UmlParams> getParams(){
		return this.params;
	}
	
	/**
	 * Delete the method parameter.
	 * @param params method parameter
	 */
	public void removeParams(UmlParams params) {
		this.params.remove(params);
	}
	
	/**
	 * Delete the method parameters.
	 * @param params the method parameters to delete
	 */
	public void removeAllParams(List<String> params) {
		this.params.removeAll(params);
	}
	
}
