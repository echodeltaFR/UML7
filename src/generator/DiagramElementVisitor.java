package generator;

import model.UmlClass;
import model.UmlInterface;
import model.UmlEnum;

/**
 * Class which allow to visit a diagram element.
 * @author fmeslet
 * @version 1.0
 */
public interface DiagramElementVisitor {

	/**
	 * Constant which define a tabulation
	 */
	public static final String TAB = "    "; 
	
	/**
	 * Visit a class component. 
	 * @param umlClass the class component visited
	 */
	public void visit(UmlClass umlClass);
	
	/**
	 * Visit an enum component. 
	 * @param umlEnum the enum component visited
	 */
	public void visit(UmlEnum umlEnum);
	
	/**
	 * Visit an interface component.
	 * @param umlInterface the interface component visited
	 */
	public void visit(UmlInterface umlInterface);
}
