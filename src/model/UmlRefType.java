package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import exception.ExceptionAttribute;
import exception.ExceptionComposition;
import exception.ExceptionInitialization;
import exception.ExceptionMethode;
import generator.DiagramElementVisitor;

/**
 * Abstract class, an UML component, parent of
 * types classes ( UmlClass, UmlEnum, UmlInterface, ...)
 * @see UmlEnum
 * @see UmlInterface
 * @see UmlClass
 * @see UmlEntity
 * @author bastien
 *
 */
public abstract class UmlRefType extends UmlEntity implements UmlType {

	// Attributes
	
	/**
	 * List of the component methods */
	private List<UmlMethod> methodsList;
	
	/**
	 * List of the component attributes
	 */
	private List<UmlAttribute> attributesList;
	
	// Constructor
	
	/**
	 * Constructor with a name
	 * @param name name of the component
	 */
	public UmlRefType(String name) {
		super(name);
		methodsList = new ArrayList<>();
		attributesList = new ArrayList<>();
	}
	
	/**
	 * Constructor with a name,  a list of methods
	 * @param name name of the component
	 * @param methods methods of the component
	 */
	public UmlRefType(String name, List<UmlMethod> methods) {
		super(name);
		methodsList = methods;
		attributesList = new ArrayList<>();
	}
	
	/**
	 * Constructor with a name, a list of methods, a list of attributes
	 * @param name name of the component
	 * @param methods methods of the component
	 * @param attributes attributes of the component
	 */
	public UmlRefType(String name, List<UmlMethod> methods, List<UmlAttribute> attributes) {
		super(name);
		methodsList = methods;
		attributesList = attributes;
	}
	
	/**
	 * Constructor with a name, a list of methods, a list of attributes, a visibility and a set of modifiers
	 * @param name name of the component
	 * @param methods methods of the component
	 * @param attributes attributes of the component
	 * @param visibility visibility of the component
	 * @param modifiers modifiers of the component
	 * @throws ExceptionComposition 
	 */
	public UmlRefType(String name, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility, Set<Modifier> modifiers) {
		super(name, visibility, modifiers);
		methodsList = methods;
		attributesList = attributes;
	}
	
	
	// Methods
	
	/**
	 * Getter list of methods
	 * @return ArrayList<UmlMethod> list of methods
	 */
	public List<UmlMethod> getMethodsList() {
		return methodsList;
	}
	
	/**
	 * Setter list of methods
	 * @param methodsList list of methods
	 * @throws ExceptionMethode 
	 * @throws ExceptionComposition 
	 */
	public final void setMethodsList(List<UmlMethod> methodsList) throws ExceptionMethode  {
		this.checkMethods(methodsList);
		this.methodsList = methodsList;
		this.setChangedAndNotify();
	}

	/**
	 * Getter list of attributes
	 * @return ArrayList<UmlAttribute> list of attributes
	 */
	public List<UmlAttribute> getAttributesList() {
		return attributesList;
	}

	/**
	 * Setter list of attributes
	 * @param attributesList list of attributes
	 * @throws ExceptionAttribute 
	 * @throws ExceptionComposition 
	 */
	public final void setAttributesList(List<UmlAttribute> attributesList) throws ExceptionAttribute {
		checkAttributes(attributesList);
		this.attributesList = attributesList;
		this.setChangedAndNotify();
	}

	
	/**
	 * Add a method to the methods list
	 * @param method of a component
	 * @throws ExceptionMethode 
	 */
	public final void addMethod(UmlMethod method) throws ExceptionMethode {
		checkMethod(method);
		if(this.methodsList.add(method)) {
			this.setChangedAndNotify();
		}
	}
	
	/**
	 * Add an attribute to the attributes list 
	 * @param attribute of a component
	 * @throws ExceptionAttribute 
	 * @throws ExceptionComposition 
	 */
	public final void addAttribute(UmlAttribute attribute) throws ExceptionAttribute {
		this.checkAttribute(attribute);
		if (this.attributesList.add(attribute)) {
			this.setChangedAndNotify();
		}
	}
	
	

	/**
	 * Remove a method from the methods list
	 * @param method method of a component
	 */
	public void removeMethod(UmlMethod method) {
		if (this.methodsList.remove(method)) {
			this.setChangedAndNotify();
		}
	}
	
	/**
	 * Remove an attribute from the attributes list 
	 * @param attribute of a component
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
	 * @throws ExceptionComposition
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
	
}

