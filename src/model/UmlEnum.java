package projet_long;

import java.util.ArrayList;
/**
 * class representing Enum type in UML
 * @author bastien
 *
 */
public class UmlEnum {
	
	// Attributes
	
	/**
	 * Enum name
	 */
	private String name;
	
	/**
	 * List of Enum values
	 */
	private ArrayList<String> valuesList;
	
	/**
	 * List of Enum methods
	 */
	private ArrayList<String> methodsList;
	
	/**
	 * List of Enum attributes
	 */
	private ArrayList<String> attributesList;
	
	/**
	 * List of Enum modifiers
	 */
	private ArrayList<String> modifiersList;
	
	// Constructors
	
	/**
	 * Constructor with a name
	 * @param name
	 */
	public UmlEnum(String name) {
		this.name = name;
		valuesList = new ArrayList<String>();
		methodsList = new ArrayList<String>();
		attributesList = new ArrayList<String>();
		modifiersList = new ArrayList<String>();
	}
	
	/**
	 * Constructor with a name, a list of values
	 * @param name
	 * @param values
	 */
	public UmlEnum(String name, ArrayList<String> values) {
		this.name = name;
		valuesList = new ArrayList<String>(values);
		methodsList = new ArrayList<String>();
		attributesList = new ArrayList<String>();
		modifiersList = new ArrayList<String>();
	}
	
	/**
	 * Constructor with a name, a list of values, a list of methods
	 * @param name
	 * @param values
	 * @param methods
	 */
	public UmlEnum(String name, ArrayList<String> values, ArrayList<String> methods) {
		this.name = name;
		valuesList = new ArrayList<String>(values);
		methodsList = new ArrayList<String>(methods);
		attributesList = new ArrayList<String>();
		modifiersList = new ArrayList<String>();
	}
	
	/**
	 * Constructor with a name, a list of values, a list of methods, a list of attributes
	 * @param name
	 * @param values
	 * @param methods
	 * @param attributes
	 */
	public UmlEnum(String name, ArrayList<String> values, ArrayList<String> methods, ArrayList<String> attributes) {
		this.name = name;
		valuesList = new ArrayList<String>(values);
		methodsList = new ArrayList<String>(methods);
		attributesList = new ArrayList<String>(attributes);
		modifiersList = new ArrayList<String>();
	}
	
	/**
	 * Constructor with a name, a list of values, a list of methods, a list of attributes and a list of modifiers
	 * @param name
	 * @param values
	 * @param methods
	 * @param attributes
	 * @param modifiers
	 */
	public UmlEnum(String name, ArrayList<String> values, ArrayList<String> methods, ArrayList<String> attributes, ArrayList<String> modifiers) {
		this.name = name;
		valuesList = new ArrayList<String>(values);
		methodsList = new ArrayList<String>(methods);
		attributesList = new ArrayList<String>(attributes);
		modifiersList = new ArrayList<String>(modifiers);
	}
	
	
	// Methods

	/**
	 * Getter Enum value
	 * @return value Enum value
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter Enum value
	 * @param value Enum value
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Add a value to the values list
	 * @param value
	 */
	public void addValue(String value) {
		this.valuesList.add(value);
	}
	
	/**
	 * Add a method to the methods list
	 * @param method
	 */
	public void addMethod(String method) {
		this.methodsList.add(method);
	}
	
	/**
	 * Add an attribute to the attributes list 
	 * @param attribute
	 */
	public void addAttribute(String attribute) {
		this.attributesList.add(attribute);
	}
	
	/**
	 * Add a modifier to the modifier list.
	 * @param modifier
	 */
	public void addModifier(String modifier) {
		this.modifiersList.add(modifier);
	}
	
	/**
	 * Remove a value from the values list
	 * @param value
	 */
	public void removeValue(String value) {
		this.valuesList.remove(value);
	}
	
	/**
	 * Remove a method from the methods list
	 * @param method
	 */
	public void removeMethod(String method) {
		this.methodsList.remove(method);
	}
	
	/**
	 * Remove an attribute from the attributes list 
	 * @param attribute
	 */
	public void removeAttribute(String attribute) {
		this.attributesList.remove(attribute);
	}
	
	/**
	 * Remove a modifier from the modifier list.
	 * @param modifier
	 */
	public void removeModifier(String modifier) {
		this.modifiersList.remove(modifier);
	}
}
