package model;

import java.util.ArrayList;

/**
 * class representing Interface type in UML
 * @author bastien
 *
 */
public class UmlInterface {
	
	// Attributes
	
	/**
	 * Name of the Interface
	 */
	private String name;
	
	/**
	 * List of Interface methods
	 */
	private ArrayList<UmlMethod> methodsList = new ArrayList<UmlMethod>();
	
	// Constructor
	public UmlInterface(String name) {
		this.setName(name);
		 methodsList = new ArrayList<UmlMethod>();
	}
	
	public UmlInterface(String name, ArrayList<UmlMethod> methods) {
		this.setName(name);
		 methodsList = new ArrayList<UmlMethod>(methods); 
	}
	
	// Methods
	
	/**
	 * Add a method to the methods list
	 * @param method
	 */
	public void addMethod(UmlMethod method) {
		this.methodsList.add(method);
	}
	
	/**
	 * Remove a method from the methods list
	 * @param method
	 */
	public void removeMethod(UmlMethod method) {
		this.methodsList.remove(method);
	}
	
	/**
	 * Getter name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
