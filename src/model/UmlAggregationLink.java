package model;

/**
 * Aggregation Link
 * @author Charly Courilleau
 *
 */
public class UmlAggregationLink extends UmlRelationship {

	
	/**
	 * Generated Serial ID
	 */
	private static final long serialVersionUID = -911950585085591534L;

	public UmlAggregationLink(UmlClass theClassA, UmlClass theClassB) {
		super(theClassA, theClassB);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof UmlAggregationLink) {
			return super.equals(o);
		}
		return false;
	}
}
