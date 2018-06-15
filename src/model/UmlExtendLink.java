package model;

/**
 * Extension Link
 * @author Charly Courilleau
 *
 */
public class UmlExtendLink extends UmlRelationship {

	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -6887736003542354263L;

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
