package model;

// LEs types primitifs en JAVA comment le liéer prprement à UMLMethod et UMLPramas ?
/**
 * Primitive type in Java
 * @author fmeslet
 * @version 1.0
 */
public enum UmlEnumPrimitiveType {
	INT("int"),
	DOUBLE("double"),
	FLOAT("float"),
	CHAR("char"),
	STRING("string"),
	BOOLEAN("boolean"),
	BYTE("byte"),
	SHORT("short"),
	LONG("long");
	
	private String name;
	
	UmlEnumPrimitiveType(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
