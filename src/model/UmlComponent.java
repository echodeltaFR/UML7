package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import generator.DiagramElementVisitor;

/**
 * Abstract class, an UML component, parent of types classes ( UmlClass, UmlEnum, UmlInterface, ...), extends UmlEntity
 * @see UmlEnum
 * @see UmlInterface
 * @see UmlClass
 * @see UmlEntity
 * @author bastien
 *
 */
public abstract class UmlComponent extends UmlEntity implements UmlType{

	// Attributes
	
	/**
	 * Name of an uml component
	 */
	private String name;
	
	/**
	 * List of the component methods
	 */
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
	public UmlComponent(String name) {
		super();
		this.name = name;
		methodsList = new ArrayList<UmlMethod>();
		attributesList = new ArrayList<UmlAttribute>();
	}
	
	/**
	 * Constructor with a name,  a list of methods
	 * @param name name of the component
	 * @param methods methods of the component
	 */
	public UmlComponent(String name, List<UmlMethod> methods) {
		super();
		this.name = name;
		methodsList = methods;
		attributesList = new ArrayList<UmlAttribute>();
	}
	
	/**
	 * Constructor with a name, a list of methods, a list of attributes
	 * @param name name of the component
	 * @param methods methods of the component
	 * @param attributes attributes of the component
	 */
	public UmlComponent(String name, List<UmlMethod> methods, List<UmlAttribute> attributes) {
		super();
		this.name = name;
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
	 */
	public UmlComponent(String name, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility, Set<Modifier> modifiers) {
		super(visibility, modifiers);
		this.name = name;
		methodsList = methods;
		attributesList = attributes;
	}
	
	
	// Methods
	
	/**
	 * Getter name of the component
	 * @return name of the component
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter name of the component
	 * @param name of the component
	 */
	public void setName(String name) {
		this.name = name;
		this.setChangedAndNotify();
	}
	
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
	 */
	public void setMethodsList(List<UmlMethod> methodsList) {
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
	 */
	public void setAttributesList(List<UmlAttribute> attributesList) {
		this.attributesList = attributesList;
		this.setChangedAndNotify();
	}

	
	/**
	 * Add a method to the methods list
	 * @param method of a component
	 */
	public void addMethod(UmlMethod method) {
		if(this.methodsList.add(method)) {
			this.setChangedAndNotify();
		};
	}
	
	/**
	 * Add an attribute to the attributes list 
	 * @param attribute of a component
	 */
	public void addAttribute(UmlAttribute attribute) {
		if (this.attributesList.add(attribute)) {
			this.setChangedAndNotify();
		};
	}
	
	/**
	 * Remove a method from the methods list
	 * @param method method of a component
	 */
	public void removeMethod(UmlMethod method) {
		if (this.methodsList.remove(method)) {
			this.setChangedAndNotify();
		};
	}
	
	/**
	 * Remove an attribute from the attributes list 
	 * @param attribute of a component
	 */
	public void removeAttribute(UmlAttribute attribute) {
		if (this.attributesList.remove(attribute)) {
			this.setChangedAndNotify();
		};
	}
	
	@Override
	public String getTypeName() {
		return this.name;
	}
	
	/**
	 * Visit accept by the element. 
	 * @param visitor the visitor of the element
	 */
	abstract public void accept(DiagramElementVisitor visitor);
	
}

