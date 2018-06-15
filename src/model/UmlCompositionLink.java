package model;

/**
 * 
 * This class represent a composition link between two classes.
 *
 */
public class UmlCompositionLink extends UmlRelationship {
	
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -1913007182750651787L;

	/**
	 * Build a new composition link.
	 * @param elementA
	 * 		The first class of the relation.
	 * @param elementB
	 * 		The second class of the relation.
	 */
	public UmlCompositionLink(UmlClass elementA, UmlClass elementB) {
		super(elementA, elementB);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof UmlCompositionLink) {
			return super.equals(o);
		}
		return false;
	}
}
