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

	public static final String TAB = "    "; 
	
	public void visit(UmlClass umlClass);
	public void visit(UmlEnum umlEnum);
	public void visit(UmlInterface umlInterface);
	
}
