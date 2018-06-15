package model;

public class UmlCompositionLink extends UmlRelationship {
	
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -1913007182750651787L;

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
