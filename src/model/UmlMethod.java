package model;

import java.util.Set;

import exception.ExceptionInitialization;

import java.util.HashSet;

/**
 * Class which allow to create a method
 * @author fmeslet, echodeltaFR
 * @version 1.3
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
		this.params = new HashSet<>();
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
		if (params == null) {
			this.params = new HashSet<>();
		}
		else {
			this.params = new HashSet<>(params);
		}
		this.returnType = returnType;
	}

	// Methods

	/**
	 * Add a method parameter.
	 * @param param the method parameter to add
	 */
	public void addParam(UmlParams param) {
		if (this.params.add(param)) {
			this.setChangedAndNotify();
		}
	}

	/**
	 * Add method parameters.
	 * @param params the method parameters to add
	 */
	public void addParams(Set<UmlParams> params) {
		if (this.params.addAll(params)) {
			this.setChangedAndNotify();
		}
	}

	/**
	 * Delete a method parameter.
	 * @param param the method parameter to remove
	 */
	public void removeParam(UmlParams param) {
		if(this.params.remove(param)) {
			this.setChangedAndNotify();
		}
	}
	/**
	 * Delete method parameters.
	 * @param params the method parameters to delete
	 */
	public void removeParams(Set<UmlParams> params) {
		if (this.params.removeAll(params)) {
			this.setChangedAndNotify();
		}
		
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
		this.setChangedAndNotify();
	}

	/**
	 * Set the method return type.
	 * @param returnType The return type
	 */
	public void setReturnType(UmlType returnType) {
		this.returnType = returnType;
		this.setChangedAndNotify();
	}

	@Override
	protected void checkVisibility(Visibility visibility) throws ExceptionInitialization {
		
		
	}

	@Override
	protected void checkModifier(Modifier modifier) throws ExceptionInitialization {
		
		
	}

	@Override
	protected void checkModifier(Set<Modifier> modifiers) throws ExceptionInitialization {
		// TODO Auto-generated method stub
		
	}

}
