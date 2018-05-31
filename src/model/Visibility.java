package Agile;

public enum Visibility {
	
	PRIVATE("-"),
	PUBLIC("+"),
	PROTECTED("#");
	
	private String name;
	
	Visibility(String name) {
		this.name = name;
	}
	
	public String getUmlName() {
		return this.name();
	}
	
}
