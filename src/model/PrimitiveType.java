package model;

/**
 * Primitive type in Java.
 * @author fmeslet
 * @version 1.0
 */
public enum PrimitiveType implements UmlType{
	INT("int"),
	DOUBLE("double"),
	FLOAT("float"),
	CHAR("char"),
	STRING("string"),
	BOOLEAN("boolean"),
	BYTE("byte"),
	SHORT("short"),
	LONG("long");
	
	/**
	 * Primitive type name.
	 */
	private String name;
	
	/**
	 * Build a primitive type.
	 * @param name primitive type name
	 */
	PrimitiveType(String name) {
		this.name = name;
	}
	
<<<<<<< HEAD:src/model/UmlEnumPrimitiveType.java
	@Override
=======
	/**
	 * Get the string name of the primitive type.
	 * @return the primitive type name
	 */
>>>>>>> Ajout des types et des types primitifs:src/model/PrimitiveType.java
	public String toString() {
		return this.name;
	}
}
