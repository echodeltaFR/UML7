package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import exception.ExceptionAttribute;
import exception.ExceptionUml;
import exception.ExceptionVisibility;
import exception.ExceptionMethode;
import exception.ExceptionModifier;
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
	 * @throws ExceptionMethode
	 */
	public UmlEnum(String name, List<String> values, List<UmlMethod> methods) throws ExceptionMethode {
		super(name, methods);
		this.checkMethods(methods);
		valuesList = new ArrayList<>(values);
	}
	
	/**
	 * Constructor with a name, a list of values, a list of methods, a list of attributes
	 * @param name name of the Enum
	 * @param values values of the Enum
	 * @param methods methods of the Enum
	 * @param attributes attributes of the ENum
	 * @throws ExceptionUml 
	 */
	public UmlEnum(String name, List<String> values, List<UmlMethod> methods, List<UmlAttribute> attributes) throws ExceptionUml {
		super(name, methods, attributes);
		this.checkMethods(methods);
		this.checkAttributes(attributes);
		valuesList = new ArrayList<>(values);
	}
	
	/**
	 * Constructor with a name, a list of values, a list of methods, a list of attributes, and a visibility.
	 * @param name name of the Enum
	 * @param values values of the Enum
	 * @param methods methods of the Enum
	 * @param attributes attributes of the ENum
	 * @param visibility visibility of the component
	 * @throws ExceptionUml 
	 */
	public UmlEnum(String name, List<String> values, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility) throws ExceptionUml {
		super(name, methods, attributes, visibility);
		this.checkMethods(methods);
		this.checkAttributes(attributes);
		this.checkVisibility(visibility);
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
		if(attribute.getModifiers().contains(Modifier.ABSTRACT))
			throw new ExceptionAttribute("Member variable cannot be set to abstract");
	}

	@Override
	protected void checkAttributes(List<UmlAttribute> attributes) throws ExceptionAttribute {
		// TODO Auto-generated method stub
		for(int i = 0 ;i < attributes.size(); i++) {
			if(attributes.get(i).getModifiers().contains(Modifier.ABSTRACT))
				throw new ExceptionAttribute("Member variable cannot be set to abstract");
		}
	}

	@Override
	protected void checkMethod(UmlMethod method) throws ExceptionMethode {
		// TODO Auto-generated method stub
		if(method.getVisibility() != Visibility.PUBLIC )
			throw new ExceptionMethode("Access modifiers can only be public");
		if(method.getModifiers().contains(Modifier.STATIC))
			throw new ExceptionMethode("Non-access modifier cannot be STATIC");
		if(method.getModifiers().contains(Modifier.VOLATILE))
			throw new ExceptionMethode("Non-access modifier cannot be VOLATILE");
		if(method.getModifiers().contains(Modifier.TRANSIENT))
			throw new ExceptionMethode("Non-access modifier cannot be TRANSIENT");
	}

	@Override
	protected void checkMethods(List<UmlMethod> methods) throws ExceptionMethode {
		// TODO Auto-generated method stub
		for(int i = 0;i < methods.size();i++) {
			if(methods.get(i).getVisibility() != Visibility.PUBLIC )
				throw new ExceptionMethode("Access modifiers can only be public");
			if(methods.get(i).getModifiers().contains(Modifier.STATIC))
				throw new ExceptionMethode("Non-access modifier cannot be STATIC");
			if(methods.get(i).getModifiers().contains(Modifier.VOLATILE))
				throw new ExceptionMethode("Non-access modifier cannot be VOLATILE");
			if(methods.get(i).getModifiers().contains(Modifier.TRANSIENT))
				throw new ExceptionMethode("Non-access modifier cannot be TRANSIENT");
		}
	}

	@Override
	protected void checkVisibility(Visibility visibility) throws ExceptionVisibility {
		// TODO Auto-generated method stub
		if(visibility != Visibility.PUBLIC)
			throw new ExceptionVisibility("Enumeration class can only be public or default");
	}

	@Override
	protected void checkModifier(Modifier modifier) throws ExceptionModifier {
		// TODO Auto-generated method stub
		if(modifier != null)
			throw new ExceptionModifier("Enumerated classes cannot have non-access modifiers");
	}

	@Override
	protected void checkModifiers(Set<Modifier> modifiers) throws ExceptionModifier {
		if(modifiers != null)
			throw new ExceptionModifier("Enumerated classes cannot have non-access modifiers");
	}
	
	/**
	 * Check this object equality with another.
	 * @return true if o is an UmlEnum with the same name, values, attribute, methods and modifiers.
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof UmlEnum) {
			UmlEnum e = (UmlEnum) o;
			if (
					super.equals(e) &&
					this.valuesList.equals(e.valuesList)
					) {
				return true;
			}
		}
		return false;
	}

}
