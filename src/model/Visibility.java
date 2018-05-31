package model;

public enum Visibility {
	
	PRIVATE("-"),
	PUBLIC("+"),
	PROTECTED("#");
	
	private String symbol;
	
	Visibility(String symbol) {
		this.symbol = symbol;
	}
	
	public String toString() {
		return this.symbol;
	}
	
}
