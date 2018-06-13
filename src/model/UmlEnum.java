package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import exception.ExceptionAttribute;
import exception.ExceptionInitialization;
import exception.ExceptionMethode;
import generator.DiagramElementVisitor;
/**
 * Class representing Enum type in UML.
 * @see UmlRefType
 * @author bastien
 *
 */
public class UmlEnum extends UmlRefType {
	
	// Attributes
	
	/** List of Enum values */
	private List<String> valuesList;
	
	// Constructors

	/**
	 * Constructor with a name.
	 * @param name Name of the Enum
	 */
	public UmlEnum(String name) {
		super(name);
		valuesList = new ArrayList<String>();
	}
	
	/**
	 * Constructor with a name and a list of values.
	 * @param name Name of the Enum
	 * @param values Values of the Enum
	 */
	public UmlEnum(String name, List<String> values) {
		super(name);
		valuesList = new ArrayList<String>(values);
	}
	
	/**
	 * Constructor with a name, a list of values and a list of methods.
	 * @param name Name of the Enum
	 * @param values Values of the Enum
	 * @param methods Methods of the Enum
	 */
	public UmlEnum(String name, List<String> values, List<UmlMethod> methods) {
		super(name, methods);
		valuesList = new ArrayList<>(values);
	}
	
	/**
	 * Constructor with a name, a list of values, a list of methods and a list of attributes.
	 * @param name Name of the Enum
	 * @param values Values of the Enum
	 * @param methods Methods of the Enum
	 * @param attributes Attributes of the ENum
	 */
	public UmlEnum(String name, List<String> values, List<UmlMethod> methods, List<UmlAttribute> attributes) {
		super(name, methods, attributes);
		valuesList = new ArrayList<>(values);
	}
	
	/**
	 * Constructor with a name, a list of values, a list of methods, a list of attributes, a visibility and a set of modifiers.
	 * @param name Name of the Enum
	 * @param values Values of the Enum
	 * @param methods Methods of the Enum
	 * @param attributes Attributes of the ENum
	 * @param visibility Visibility of the component
	 * @param modifiers A set of modifiers
	 */
	public UmlEnum(String name, List<String> values, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility, Set<Modifier> modifiers) {
		super(name, methods, attributes, visibility, modifiers);
		valuesList = new ArrayList<>(values);
	}
	// Methods
	
	/**
	 * Setter list of Enum values.
	 * @param valuesList List of values
	 */
	public void setValuesList(List<String> valuesList) {
		this.valuesList = valuesList;
	}

	/**
	 * Add a value to the values list.
	 * @param value Value of the Enum
	 */
	public void addValue(String value) {
		this.valuesList.add(value);
	}

	/**
	 * Remove a value from the values list.
	 * @param value Value of the Enum
	 */
	public void removeValue(String value) {
		this.valuesList.remove(value);
	}

	/**
	 * Getter list of attributes.
	 * @return The list of attributes
	 */
	public List<String> getValuesList() {
		return this.valuesList;
	}


	@Override
	public void accept(DiagramElementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	protected void checkAttribute(UmlAttribute attribute) throws ExceptionAttribute {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkAttributes(List<UmlAttribute> attributes) throws ExceptionAttribute {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkMethod(UmlMethod method) throws ExceptionMethode {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkMethods(List<UmlMethod> methods) throws ExceptionMethode {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkVisibility(Visibility visibility) throws ExceptionInitialization {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkModifier(Modifier modifier) throws ExceptionInitialization {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkModifier(Set<Modifier> modifiers) throws ExceptionInitialization {
		// TODO Auto-generated method stub
		
	}

}
