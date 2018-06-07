package model;

import java.util.Set;
import java.util.HashSet;

/**
 * Class which allow to create a method
 * @author fmeslet, echodeltaFR
 * @version 1.2
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

	/** Constructor. Creates a method with several modifiers.
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
	 * Add a method parameter.
	 * @param param the method parameter to add
	 */
	public void addParam(UmlParams param) {
		this.params.add(param);
	}

	/**
	 * Add method parameters.
	 * @param params the method parameters to add
	 */
	public void addParams(Set<UmlParams> params) {
		this.params.addAll(params);
	}

	/**
	 * Delete a method parameter.
	 * @param param the method parameter to remove
	 */
	public void removeParam(UmlParams param) {
		this.params.remove(param);
	}
	/**
	 * Delete method parameters.
	 * @param params the method parameters to delete
	 */
	public void removeParams(Set<UmlParams> params) {
		this.params.removeAll(params);
	}

	// Getters & Setters

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
	 * Get the method parameters.
	 * @return The method parameters
	 */
	public Set<UmlParams> getParams(){
		return this.params;
	}

	/**
	 * Set the method name.
	 * @param name The name of the method
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the method return type.
	 * @param returnType The return type
	 */
	public void setReturnType(UmlType returnType) {
		this.returnType = returnType;
	}

}
