package model;

import java.util.List;
import java.util.Set;

import generator.DiagramElementVisitor;


public class UmlClass extends UmlComponent{
	/**
	 * Constructor with a name
	 * @param name the name of the UmlClass
	 */
	public UmlClass(String name) {
		super(name);
	}
	
	/**
	 * Constructor with a name and a list of methods
	 * @param name the name of the UmlClass
	 * @param methods all of methods of the UmlClass
	 */
	public UmlClass(String name, List<UmlMethod> methods) {
		super(name, methods);
	}
	
	/**
	 * Constructor with a name, a list of methods and a list of attributes
	 * @param name the name of the component
	 * @param methods all of methods of the UmlClass
	 * @param attributes all of attributes of the UmlClass
	 */
	public UmlClass(String name, List<UmlMethod> methods, List<UmlAttribute> attributes) {
		super(name, methods, attributes);
	}
	
	
	/**
	 * Constructor with a name, a list of methods, a list of attributes, a visibility and a set of modifiers
	 * @param name the name of the component
	 * @param methods all of methods of the UmlClass
	 * @param attributes all of attributes of the UmlClass
	 * @param visibility visibility of the component
	 * @param modifiers modifiers of the component
	 */
	public UmlClass(String name, List<UmlMethod> methods, List<UmlAttribute> attributes, Visibility visibility, Set<Modifier> modifiers) {
		super(name, methods, attributes, visibility, modifiers);
	}
	
	
	@Override
	public void accept(DiagramElementVisitor visitor) {
		visitor.visit(this);
	}
}
