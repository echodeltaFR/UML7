package model;

/**
 * Extension Link
 * @author Charly Courilleau
 *
 */
public class UmlExtendLink extends UmlRelationship {

	public UmlExtendLink(UmlClass theClassA, UmlClass theClassB) {
		super(theClassA, theClassB);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof UmlExtendLink) {
			return super.equals(o);
		}
		return false;
	}
}
