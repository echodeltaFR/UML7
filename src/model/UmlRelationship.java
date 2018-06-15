package model;

import java.io.Serializable;

/**
 * Uml Relationship
 * @author Charly Courilleau
 */
public abstract class UmlRelationship implements Serializable {
	
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


	protected UmlRelationship(UmlClass elementA, UmlClass elementB) {
		assert elementA != null && elementB != null;
		this.classA = elementA;
		this.classB = elementB;
		this.roleA = "";
		this.roleB = "";
		this.relationName = "";
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
		  if (relationName == null) {
			    throw new IllegalArgumentException("Invalid relation name (null is not allowed)");
		  }
		  this.relationName = relationName;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof UmlRelationship) {
			UmlRelationship r = (UmlRelationship) o;
			if (
					r.classA.equals(this.classA) &&
					r.classB.equals(this.classB) &&
					r.relationName.equals(this.relationName) &&
					r.roleA.equals(this.roleA) &&
					r.roleB.equals(this.roleB)
					) {
				return true;
			}
		}
		return false;
	}
}