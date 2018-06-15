package model;

/**
 * Association Link
 * @author Charly Courilleau
 *
 */
public class UmlAssociationLink extends UmlRelationship {

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
