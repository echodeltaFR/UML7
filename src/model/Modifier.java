package model;

/**
 * Enum representing the modifiers
 * @see UmlEntity
 * @author fabien, bastien
 *
 */
public enum Modifier {
	FINAL("final"),
	STATIC("static"),
	ABSTRACT("abstract"),
	VOLATILE("volatile"),
	TRANSIENT("transient"),
	SYNCHRONIZED("synchronized");
	
	// Attributes
	
	/**
	 * name of the modifier
	 */
	private String name;
	
	// Constructor
	
	/**
	 * Constructor of a modifier with a name
	 * @param name name of the modifier
	 */
	Modifier(String name) {
		this.name = name;
	}
	
	// Methods
	/**
	 * Returns the name of the modifier
	 * @return String name of the modifier
	 */
	public String toString() {
		return this.name;
	}	
	
}
