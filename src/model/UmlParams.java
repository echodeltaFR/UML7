package model;

/**
 * Classe which represent a method parameter.
 * @author fmeslet
 * @version 1.0
 */
public class UmlParams {

	/**
	 * Parameter type
	 */
	private String type;
	
	/**
	 * Parameter name.
	 */
	private String name;
	
	/**
	 * Create a parameter.
	 * @param type of parameter
	 * @param name of parameter
	 */
	public UmlParams(UmlComponent type, String name) {
		this.type = type.getName();
		this.name = name;
	}
	
	/**
	 * Get the parameter type.
	 * @return type of parameter
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the parameter type.
	 * @param type parameter type
	 */
	public void setType(UmlComponent type) {
		this.type = type.getName();
	}

	/**
	 * Get the parameter name.
	 * @return parameter name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the parameter name.
	 * @param name parameter name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
