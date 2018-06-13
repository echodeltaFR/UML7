package model;

/**
 * Enum representing the visibility.
 * @see UmlEntity
 * @author fabien, bastien
 *
 */
public enum Visibility {
	
	PRIVATE,
	PUBLIC,
	PROTECTED,
	PACKAGE;
	
	/**
	 * Returns the symbol of a visibility.
	 * @return The symbol of a visibility
	 */
	@Override
	public String toString() {
		return this.name();
	}
	
}
