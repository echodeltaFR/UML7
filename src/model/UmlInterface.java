package projet_long;

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
	private ArrayList<String> methodsList = new ArrayList<String>();
	
	// Constructor
	public UmlInterface(String name) {
		this.setName(name);
		 methodsList = new ArrayList<String>();
	}
	
	public UmlInterface(String name, ArrayList<String> methods) {
		this.setName(name);
		 methodsList = new ArrayList<String>(methods); 
	}
	
	// Methods
	
	/**
	 * Add a method to the methods list
	 * @param method
	 */
	public void addMethod(String method) {
		this.methodsList.add(method);
	}
	
	/**
	 * Remove a method from the methods list
	 * @param method
	 */
	public void removeMethod(String method) {
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
