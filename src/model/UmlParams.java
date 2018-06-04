package model;

/**
 * Classe which represent a method parameter.
 * @author fmeslet
 * @version 1.0
 */
public class UmlParams {

	/**
	 * Parameter type.
	 */
	private UmlType type;
	
	/**
	 * Parameter name.
	 */
	private String name;
	
	/**
	 * Create a parameter.
	 * @param type of parameter
	 * @param name of parameter
	 */
	public UmlParams(UmlType type, String name) {
		this.type = type;
		this.name = name;
	}
	
	/**
	 * Get the parameter type.
	 * @return type of parameter
	 */
	public UmlType getType() {
		return type;
	}

	/**
	 * Set the parameter type.
	 * @param type parameter type
	 */
	public void setType(UmlType type) {
		this.type = type;
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
