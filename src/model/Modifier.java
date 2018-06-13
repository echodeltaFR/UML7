package model;

/**
 * Enum representing the modifiers.
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
	
	/** The name of the modifier */
	private String name;
	
	// Constructor
	
	/**
	 * Constructor of a modifier with a name.
	 * @param name Name of the modifier
	 */
	Modifier(String name) {
		this.name = name;
	}
	
	// Methods
	/**
	 * Returns the name of the modifier.
	 * @return Tame of the modifier
	 */
	@Override
	public String toString() {
		return this.name;
	}	
	
}
