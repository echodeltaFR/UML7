package model;

/**
 * Enum representing the visibility
 * @see UmlEntity
 * @author fabien, bastien
 *
 */
public enum Visibility {
	
	PRIVATE("-"),
	PUBLIC("+"),
	PROTECTED("#");
	
	// Attributes
	
	/**
	 * symbol corresponding to a visibility
	 */
	private String symbol;
	
	// Constructor
	
	/**
	 * Constructor of a visibility with a symbol
	 * @param symbol symbol of a visibility
	 */
	Visibility(String symbol){
		this.symbol = symbol;
	}
	
	// Methods
	
	/**
	 * Returns the symbol of a visibility
	 * @return String symbol of a visibility
	 */
	@Override
	public String toString() {
		return this.symbol;
	}
	
}
