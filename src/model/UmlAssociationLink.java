package model;

/**
 * Association Link
 * @author Charly Courilleau
 *
 */
public class UmlAssociationLink extends UmlRelationship {

	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -7424926719140109927L;

	/**
	 * Build a new association link between the two classes.
	 * @param theClassA
	 * 		The first class of the relation
	 * @param theClassB
	 * 		The second class of the relation
	 */
	public UmlAssociationLink(UmlClass theClassA,  UmlClass theClassB) {
		super(theClassA, theClassB);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof UmlAssociationLink) {
			return super.equals(o);
		}
		return false;
	}
}
