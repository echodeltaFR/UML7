package model;

/**
 * Uml Relationship
 * @author Charly Courilleau
 */
public abstract class UmlRelationShip {
	
	/** Class A **/
	private UmlClass classA;
	
	/** Class B **/
	private UmlClass classB;
	
	/** classA's role **/
	private String roleA;
	
	/** classB's role **/
	private String roleB;
	
	/** Relation name **/
	private String relationName;


	protected UmlRelationShip(UmlClass elementA, UmlClass elementB) {
		assert elementA != null && elementB != null;
		this.classA = elementA;
		this.classB = elementB;
		this.roleA = "";
		this.roleB = "";
	}
	
	public String getRoleA() {
		return roleA;
	}

	public void setRoleA(String roleA) {
		this.roleA = roleA;
	}

	public String getRoleB() {
		return roleB;
	}

	public void setRoleB(String roleB) {
		this.roleB = roleB;
	}

	public UmlClass getClassA() {
		return classA;
	}

	public UmlClass getClassB() {
		return classB;
	}

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		assert relationName != null;
		this.relationName = relationName;
	}

}