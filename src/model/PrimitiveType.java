package model;

/**
 * Primitive type in Java.
 * @author fmeslet
 * @see UmlType
 * @version 1.0
 */
public enum PrimitiveType implements UmlType {
	INT("int"),
	DOUBLE("double"),
	FLOAT("float"),
	CHAR("char"),
	STRING("String"),
	BOOLEAN("boolean"),
	BYTE("byte"),
	SHORT("short"),
	LONG("long"),
	VOID("void");

	/** Primitive type name. */
	private String name;

	/**
	 * Build a primitive type.
	 * @param name Primitive type name
	 */
	PrimitiveType(String name) {
		this.name = name;
	}

	@Override
	/**
	 * Get the string name of the primitive type.
	 * @return The primitive type name
	 */
	public String getTypeName() {
		return this.name;
	}

}
