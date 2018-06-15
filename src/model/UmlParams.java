package model;

/**
 * Classe which represent a method parameter.
 * @author fmeslet
 * @version 1.0
 */
public class UmlParams {

	/** Parameter type. */
	private UmlType type;
	
	/** Parameter name. */
	private String name;
	
	/**
	 * Create a parameter.
	 * @param type The parameter type
	 * @param name The parameter name
	 */
	public UmlParams(UmlType type, String name) {
		this.type = type;
		this.name = name;
	}
	
	/**
	 * Get the parameter type.
	 * @return The parameter type
	 */
	public UmlType getType() {
		return type;
	}

	/**
	 * Set the parameter type.
	 * @param type The parameter type
	 */
	public void setType(UmlType type) {
		this.type = type;
	}

	/**
	 * Get the parameter name.
	 * @return The parameter name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the parameter name.
	 * @param name The parameter name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof UmlParams) {
			UmlParams p = (UmlParams) o;
			if (
					p.name.equals(this.name) &&
					p.type.equals(this.type)) {
				return true;
			}
		}
		return false;
	}
}
