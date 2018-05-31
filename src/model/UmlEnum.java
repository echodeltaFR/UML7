package model;

import java.util.ArrayList;
/**
 * Class representing Enum type in UML, extends UmlComponent
 * @see UmlComponent
 * @author bastien
 *
 */
public class UmlEnum extends UmlComponent {
	
	// Attributes
	
	
	/**
	 * List of Enum values
	 */
	private ArrayList<String> valuesList;
	
	// Constructors
	
	/**
	 * Constructor with a name
	 * @param name name of the Enum
	 */
	public UmlEnum(String name) {
		super(name);
		valuesList = new ArrayList<String>();
	}
	
	/**
	 * Constructor with a name, a list of values
	 * @param name name of the Enum
	 * @param values values of the Enum
	 */
	public UmlEnum(String name, ArrayList<String> values) {
		super(name);
		valuesList = new ArrayList<String>(values);
	}
	
	/**
	 * Constructor with a name, a list of values, a list of methods
	 * @param name name of the Enum
	 * @param values values of the Enum
	 * @param methods methods of the Enum
	 */
	public UmlEnum(String name, ArrayList<String> values, ArrayList<UmlMethod> methods) {
		super(name, methods);
		valuesList = new ArrayList<String>(values);
	}
	
	/**
	 * Constructor with a name, a list of values, a list of methods, a list of attributes
	 * @param name name of the Enum
	 * @param values values of the Enum
	 * @param methods methods of the Enum
	 * @param attributes attributes of the ENum
	 */
	public UmlEnum(String name, ArrayList<String> values, ArrayList<UmlMethod> methods, ArrayList<UmlAttribute> attributes) {
		super(name, methods, attributes);
		valuesList = new ArrayList<String>(values);
	}
	
	/**
	 *  TODO add needed constructors with visibility and modifiers
	 */
	
	// Methods

	/**
	 * Add a value to the values list
	 * @param value value of the Enum
	 */
	public void addValue(String value) {
		this.valuesList.add(value);
	}
	
	
	/**
	 * Remove a value from the values list
	 * @param value value of the Enum
	 */
	public void removeValue(String value) {
		this.valuesList.remove(value);
	}
}
