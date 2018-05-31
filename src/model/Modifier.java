package model;

public enum Modifier {
	FINAL("final"),
	STATIC("static"),
	ABSTRACT("abstract"),
	VOLATILE("volatile"),
	TRANSIENT("transient"),
	SYNCHRONIZED("synchronized");
	
	private String name;
	
	Modifier(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}	
	
}
