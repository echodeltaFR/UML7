package model;

import java.util.Set;

import exception.ExceptionModifier;
import exception.ExceptionVisibility;

import java.util.HashSet;

/**
 * Class which allow to create a method
 * @author fmeslet, echodeltaFR
 * @see UmlEntity
 * @version 1.3
 */
public class UmlMethod extends UmlEntity {
	
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -5705911605829253462L;

	/** Method parameters. */
	private Set<UmlParams> params;

	/** Method return type. */
	private UmlType returnType;

	// Constructors

	/**
	 * Constructor. Creates a method with name.
	 * @param name Method name
	 */
	public UmlMethod(String name) {
		super(name);
		this.params = new HashSet<>();
		this.returnType = PrimitiveType.VOID;
	}

	/** Constructor. Creates a method with several modifiers.
	 * @param name Method name
	 * @param params Method parameters
	 * @param returnType Method return type
	 * @param visibility Method visibility
	 * @param modifiers Method modifiers
	 */
	public UmlMethod(String name,
			Set<UmlParams> params,
			UmlType returnType,
			Visibility visibility,
			Set<Modifier> modifiers) {
		super(name, visibility, modifiers);
		if (params == null) {
			this.params = new HashSet<>();
		}
		else {
			this.params = new HashSet<>(params);
		}
		if (returnType == null) {
			this.returnType = PrimitiveType.VOID;
		} else {
			this.returnType = returnType;
		}
	}

	// Methods

	/**
	 * Add a method parameter.
	 * @param param The method parameter to add
	 */
	public void addParam(UmlParams param) {
		if (this.params.add(param)) {
			this.setChangedAndNotify();
		}
	}

	/**
	 * Add method parameters.
	 * @param params The method parameters to add
	 */
	public void addParams(Set<UmlParams> params) {
		if (this.params.addAll(params)) {
			this.setChangedAndNotify();
		}
	}

	/**
	 * Delete a method parameter.
	 * @param param The method parameter to remove
	 */
	public void removeParam(UmlParams param) {
		if(this.params.remove(param)) {
			this.setChangedAndNotify();
		}
	}
	/**
	 * Delete method parameters.
	 * @param params The method parameters to delete
	 */
	public void removeParams(Set<UmlParams> params) {
		if (this.params.removeAll(params)) {
			this.setChangedAndNotify();
		}
		
	}

	// Getters & Setters

	/**
	 * Get return type.
	 * @return The return type of the method
	 */
	public UmlType getReturnType() {
		return this.returnType;
	}

	/**
	 * Get the method parameters.
	 * @return The parameters of the method
	 */
	public Set<UmlParams> getParams(){
		return this.params;
	}

	/**
	 * Set the method return type.
	 * @param returnType The return type
	 */
	public void setReturnType(UmlType returnType) {
		if (returnType == null) throw new IllegalArgumentException("Return type can't be null");
		this.returnType = returnType;
		this.setChangedAndNotify();
	}
	
	@Override
	protected final void checkVisibility(Visibility visibility) throws ExceptionVisibility {
		
		
	}

	@Override
	protected void checkModifier(Modifier modifier) throws ExceptionModifier {
	}

	@Override
	protected void checkModifiers(Set<Modifier> modifiers) throws ExceptionModifier {
		if(modifiers.contains(Modifier.ABSTRACT) && modifiers.size()>1)
			throw new ExceptionModifier("Abstract modifiers cannot be used in conjunction with other modifiers");
		if(modifiers.contains(Modifier.FINAL)&&modifiers.contains(Modifier.VOLATILE))
			throw new ExceptionModifier("the modifier of attribute conflicts");
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof UmlMethod) {
			UmlMethod m = (UmlMethod) o;
			if (
					super.equals(o) &&
					m.params.equals(this.params) &&
					m.returnType.equals(this.returnType)
					) {
				return true;
			}
		}
		return false;
	}
}
