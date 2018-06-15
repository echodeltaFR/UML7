package model;

public class UmlCompositionLink extends UmlRelationship {

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
