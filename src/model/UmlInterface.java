package model;

//import java.util.Collection;
import java.util.List;

/**
 * Class representing Interface type in UML, extends UmlComponent
 * @see UmlComponent
 * @author bastien
 *
 */
public class UmlInterface extends UmlComponent {
	
	// Constructor
	
	/**
	 * Constructor of an interface with a name
	 * @param name name of the interface
	 */
	public UmlInterface(String name) {
		super(name);
		this.setName(name);
	}
	
	/**
	 * Constructor of an interface with a name and a list of methods
	 * @param name name of the interface
	 * @param methods of the interface
	 */
	public UmlInterface(String name, List<UmlMethod> methods) {
		super(name, methods);
	}
	
	/**
	 * Constructor of an interface with a name, a list of methods and a list of attributes
	 * @param name of the interface
	 * @param methods of the interface
	 * @param attributes of the interface
	 */
	public UmlInterface(String name, List<UmlMethod> methods, List<UmlAttribute> attributes) {
		super(name, methods, attributes);
	}
	
	/**
	 *  TODO add needed constructors with visibility and modifiers
	 */
}
