package generator;

import model.UmlClass;
import model.UmlInterface;
import model.UmlEnum;

import model.UmlDiagram;

/**
 * Class which allow to visit a diagram element.
 * @author fmeslet
 * @version 1.0
 */
public interface DiagramElementVisitor {

	public void visit(UmlClass UmlClass);
	public void visit(UmlEnum UmlEnum);
	public void visit(UmlInterface UmlInterface);
	public void visitDiagram(UmlDiagram UmlDiagram);
	
}
