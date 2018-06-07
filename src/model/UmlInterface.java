package model;

import java.util.List;
import java.util.Set;

import generator.DiagramElementVisitor;

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
	 * @param name name name of the interface
	 * @param methods methods of the interface
	 */
	public UmlInterface(String name, List<UmlMethod> methods) {
		super(name, methods);
	}
	
	/**
	 * Constructor of an interface with a name, a list of methods and a list of attributes
	 * @param name name of the interface
	 * @param methods methods of the interface
	 * @param attributes attributes of the interface
	 */
	public UmlInterface(String name, List<UmlMethod> methods, List<UmlAttribute> attributes) {
		super(name, methods, attributes);
	}
	
	/**
	 * Constructor of an interface with a name, a list of methods, a list of attributes, a visibility and a modifier
	 * @param name name of the interface
	 * @param methods methods of the interface
	 * @param attributes attributes of the interface
	 * @param visibility visibility of the interface
	 * @param modifier modifier of the interface
	 */
	public UmlInterface(String name, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility, Modifier modifier) {
		super(name, methods, attributes);
	}
	
	/**
	 * Constructor of an interface with a name, a list of methods, a list of attributes a visibility and a set of modifiers
	 * @param name name of the interface
	 * @param methods  methods of the interface
	 * @param attributes attributes of the interface
	 * @param visibility visibility of the interface
	 * @param modifiers a set of modifiers of the interface
	 */
	public UmlInterface(String name, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility, Set<Modifier> modifiers) {
		super(name, methods, attributes);
	}
	
	
	@Override
	public void accept(DiagramElementVisitor visitor) {
		visitor.visit(this);
	}
}
