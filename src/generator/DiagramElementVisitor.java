package generator;

import model.UmlClass;
import model.UmlInterface;
import model.UmlEnum;

/**
 * Class which allow to visit a diagram element.
 * @author fmeslet
 * @see UmlClass
 * @see UmlInterface
 * @see UmlEnum
 * @version 1.0
 */
public interface DiagramElementVisitor {

	/**
	 * Constant which define a tabulation.
	 */
	public static final String TAB = "    "; 
	
	/**
	 * Visit a class component. 
	 * @param umlClass The class component visited
	 */
	public void visit(UmlClass umlClass);
	
	/**
	 * Visit an enum component. 
	 * @param umlEnum The enum component visited
	 */
	public void visit(UmlEnum umlEnum);
	
	/**
	 * Visit an interface component.
	 * @param umlInterface The interface component visited
	 */
	public void visit(UmlInterface umlInterface);
}
