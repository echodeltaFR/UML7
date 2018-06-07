package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Class which allow to create a method
 * @author fmeslet, echodeltaFR
 * @version 1.1
 */
public class UmlMethod extends UmlEntity {

	/**
	 * Method parameters.
	 */
	private Set<UmlParams> params;
	/**
	 * Method return type.
	 */
	private UmlType returnType;
	/**
	 * Method name.
	 */
	private String name;

	// Constructors

	/**
	 * Constructor. Creates a method with name.
	 * @param name method name
	 */
	public UmlMethod(String name) {
		super();
		this.name = name;
		this.params = new HashSet<UmlParams>();
		this.returnType = null;
	}

	/** Constructor. Creates a method with one parameter
	 * and one modifier.
	 * @param name method name
	 * @param param method parameter
	 * @param returnType method return type
	 * @param visibility method visibility
	 * @param modifier method modifier
	 */
	public UmlMethod(String name,
			UmlParams param,
			UmlType returnType,
			Visibility visibility,
			Modifier modifier) {
		super(visibility, modifier);
		this.name = name;
		this.params = new HashSet<UmlParams>();
		this.params.add(param);
		this.returnType = returnType;
	}

	/** Constructor. Creates a method with one parameter
	 * and several modifiers.
	 * @param name method name
	 * @param param method parameter
	 * @param returnType method return type
	 * @param visibility method visibility
	 * @param modifiers method modifiers
	 */
	public UmlMethod(String name,
			UmlParams param,
			UmlType returnType,
			Visibility visibility,
			Set<Modifier> modifiers) {
		super(visibility, modifiers);
		this.name = name;
		this.params = new HashSet<UmlParams>();
		this.params.add(param);
		this.returnType = returnType;
	}

	/** Constructor. Creates a method with several parameters
	 * and one modifier.
	 * @param name method name
	 * @param params method parameters
	 * @param returnType method return type
	 * @param visibility method visibility
	 * @param modifier method modifier
	 */
	public UmlMethod(String name,
			Set<UmlParams> params,
			UmlType returnType,
			Visibility visibility,
			Modifier modifier) {
		super(visibility, modifier);
		this.name = name;
		this.params = new HashSet<UmlParams>(params);
		this.returnType = returnType;
	}

	/** Constructor. Creates a method with several parameters
	 * and several modifiers.
	 * @param name method name
	 * @param params method parameters
	 * @param returnType method return type
	 * @param visibility method visibility
	 * @param modifiers method modifiers
	 */
	public UmlMethod(String name,
			Set<UmlParams> params,
			UmlType returnType,
			Visibility visibility,
			Set<Modifier> modifiers) {
		super(visibility, modifiers);
		this.name = name;
		this.params = new HashSet<UmlParams>(params);
		this.returnType = returnType;
	}

	// Methods

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
