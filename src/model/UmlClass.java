package model;

import java.util.ArrayList;


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
	public UmlClass(String name, ArrayList<UmlMethod> methods) {
		super(name, methods);
	}
	/**
	 * Constructor with a name, a list of methods and a list of attributes
	 * @param name the name of the component
	 * @param methods all of methods of the UmlClass
	 * @param attributes all of attributes of the UmlClass
	 */
	public UmlClass(String name, ArrayList<UmlMethod> methods, ArrayList<UmlAttribute> attributes) {
		super(name, methods, attributes);
	}
}
