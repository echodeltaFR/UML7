package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class, an UML component, parent of types classes ( UmlClass, UmlEnum, UmlInterface, ...), extends UmlEntity
 * @see UmlEnum
 * @see UmlInterface
 * @see UmlClass
 * @see UmlEntity
 * @author bastien
 *
 */
abstract class UmlComponent extends UmlEntity {

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
		methodsList = new ArrayList<>();
		attributesList = new ArrayList<>();
	}
	
	/**
	 * Constructor with a name,  a list of methods
	 * @param name name of the component
	 * @param methods methods of the component
	 */
	public UmlComponent(String name, List<UmlMethod> methods) {
		super();
		this.name = name;
		methodsList = new ArrayList<>(methods);
		attributesList = new ArrayList<>();
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
		methodsList = new ArrayList<>(methods);
		attributesList = new ArrayList<>(attributes);
	}
	
	/**
	 * TODO add needed constructors with visibility and modifiers
	 */
	
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
	}

	
	/**
	 * Add a method to the methods list
	 * @param method of a component
	 */
	public void addMethod(UmlMethod method) {
		this.methodsList.add(method);
	}
	
	/**
	 * Add an attribute to the attributes list 
	 * @param attribute of a component
	 */
	public void addAttribute(UmlAttribute attribute) {
		this.attributesList.add(attribute);
	}
	
	/**
	 * Remove a method from the methods list
	 * @param method method of a component
	 */
	public void removeMethod(UmlMethod method) {
		this.methodsList.remove(method);
	}
	
	/**
	 * Remove an attribute from the attributes list 
	 * @param attribute of a component
	 */
	public void removeAttribute(UmlAttribute attribute) {
		this.attributesList.remove(attribute);
	}
}

