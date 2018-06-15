package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import exception.ExceptionAttribute;
import exception.ExceptionUml;
import exception.ExceptionMethode;
import generator.DiagramElementVisitor;

/**
 * Abstract class, an UML component, parent of
 * types classes ( UmlClass, UmlEnum, UmlInterface, ...)
 * @see UmlEnum
 * @see UmlInterface
 * @see UmlClass
 * @see UmlEntity
 * @see UmlType
 * @author bastien
 *
 */
public abstract class UmlRefType extends UmlEntity implements UmlType {
	
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = 5120005105606691065L;

	/** List of the component methods. */
	private List<UmlMethod> methodsList;
	
	/** List of the component attributes. */
	private List<UmlAttribute> attributesList;
	
	// Constructor
	
	/**
	 * Constructor with a name.
	 * @param name Name of the component
	 */
	public UmlRefType(String name) {
		super(name);
		methodsList = new ArrayList<>();
		attributesList = new ArrayList<>();
	}
	
	/**
	 * Constructor with a name and a list of methods.
	 * @param name Name of the component
	 * @param methods Methods of the component
	 */
	public UmlRefType(String name, List<UmlMethod> methods) {
		this(name,methods,null);
	}
	
	/**
	 * Constructor with a name, a list of methods and a list of attributes.
	 * @param name Name of the component
	 * @param methods Methods of the component
	 * @param attributes Attributes of the component
	 */
	public UmlRefType(String name, List<UmlMethod> methods, List<UmlAttribute> attributes) {
		this(name, methods, attributes, null, null);
	}
	
	/**
	 * Constructor with a name, a list of methods, a list of attributes, and a visibility.
	 * @param name Name of the component
	 * @param methods Methods of the component
	 * @param attributes Attributes of the component
	 * @param visibility Visibility of the component
	 * @throws ExceptionUml 
	 */
	public UmlRefType(String name, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility) {
		this(name, methods, attributes, visibility, null);
	}
	
	/**
	 * Constructor with a name, a list of methods, a list of attributes, a visibility and a set of modifiers.
	 * @param name Name of the component
	 * @param methods Methods of the component
	 * @param attributes Attributes of the component
	 * @param visibility Visibility of the component
	 * @param modifiers Modifiers of the component
	 * @throws ExceptionUml 
	 */
	public UmlRefType(String name, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility, Set<Modifier> modifiers) {
		super(name, visibility, modifiers);
		if (methods == null) {
			methodsList = new ArrayList<>();
		} else {
			methodsList = methods;
		}
		if (attributes == null) {
			attributesList = new ArrayList<>();
		} else {
			attributesList = attributes;
		}
	}

	// Methods
	
	/**
	 * Getter list of methods.
	 * @return The list of methods
	 */
	public List<UmlMethod> getMethodsList() {
		return methodsList;
	}
	
	/**
	 * Setter list of methods.
	 * @param methodsList List of methods
	 * @throws ExceptionMethode 
	 * @throws ExceptionUml 
	 */
	public final void setMethodsList(List<UmlMethod> methodsList) throws ExceptionMethode  {
		this.checkMethods(methodsList);
		this.methodsList = methodsList;
		this.setChangedAndNotify();
	}

	/**
	 * Getter list of attributes.
	 * @return The list of attributes
	 */
	public List<UmlAttribute> getAttributesList() {
		return attributesList;
	}

	/**
	 * Setter list of attributes.
	 * @param attributesList List of attributes
	 * @throws ExceptionAttribute 
	 * @throws ExceptionUml 
	 */
	public final void setAttributesList(List<UmlAttribute> attributesList) throws ExceptionAttribute {
		checkAttributes(attributesList);
		this.attributesList = attributesList;
		this.setChangedAndNotify();
	}

	
	/**
	 * Add a method to the methods list.
	 * @param method Method of a component
	 * @throws ExceptionMethode 
	 */
	public final void addMethod(UmlMethod method) throws ExceptionMethode {
		checkMethod(method);
		if (this.methodsList.add(method)) {
			this.setChangedAndNotify();
		}
	}
	
	/**
	 * Add an attribute to the attributes list .
	 * @param attribute Attribute of a component
	 * @throws ExceptionAttribute 
	 * @throws ExceptionUml 
	 */
	public final void addAttribute(UmlAttribute attribute) throws ExceptionAttribute {
		this.checkAttribute(attribute);
		if (this.attributesList.add(attribute)) {
			this.setChangedAndNotify();
		}
	}

	/**
	 * Remove a method from the methods list.
	 * @param method Method of a component
	 */
	public void removeMethod(UmlMethod method) {
		if (this.methodsList.remove(method)) {
			this.setChangedAndNotify();
		}
	}
	
	/**
	 * Remove an attribute from the attributes list.
	 * @param attribute Attribute of a component
	 */
	public void removeAttribute(UmlAttribute attribute) {
		if (this.attributesList.remove(attribute)) {
			this.setChangedAndNotify();
		}
	}
	
	@Override
	public String getTypeName() {
		return this.getName();
	}
	/**
	 * 
	 * @param attributes
	 * @throws ExceptionUml
	 */
	protected abstract void checkAttribute(UmlAttribute attribute) throws ExceptionAttribute;
	protected abstract void checkAttributes(List<UmlAttribute> attributes) throws ExceptionAttribute;
	protected abstract void checkMethod(UmlMethod method) throws ExceptionMethode;
	protected abstract void checkMethods(List<UmlMethod> methods) throws ExceptionMethode;
	/**
	 * Visit accept by the element. 
	 * @param visitor the visitor of the element
	 */
	public abstract void accept(DiagramElementVisitor visitor);
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof UmlRefType) {
			UmlRefType r = (UmlRefType) o;
			if (
					super.equals(r) &&
					r.attributesList.equals(this.attributesList) &&
					r.methodsList.equals(this.methodsList)
					) {
				return true;
			}
		}
		return false;
	}
}

