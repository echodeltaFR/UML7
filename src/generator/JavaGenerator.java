package generator;

import java.util.List;

import javax.lang.model.element.Modifier;

import java.util.ArrayList;

import model.UmlClass;
import model.UmlInterface;
import model.UmlEnum;
import model.UmlDiagram;

import model.UmlComponent;

/**
 * Class which allow to generate Java code thanks to Uml diagram.
 * @author fmeslet
 * @version 1.0
 */
public class JavaGenerator implements DiagramElementVisitor {
	
	public static void main(String ars[]) {
		
		System.out.println("Test : Visited diagram\n");
		List<UmlComponent> list = new ArrayList<UmlComponent>();
		list.add(new UmlEnum("MonEnum"));
		list.add(new UmlInterface("MonInterface"));
		
		JavaGenerator generateur = new JavaGenerator();
		
		generateur.visitDiagram(new UmlDiagram("test", list));
	}
	
	public JavaGenerator() {
	}
	
	private String convertVisibility(UmlComponent component) {
		String visibility = null;
		
		switch(component.getVisibility().toString()) {
		case "+":
			visibility = "public";
			break;
		case "-":
			visibility = "private";
			break;
		case "#":
			visibility = "protected";
			break;
		default:
			visibility = "public";
		}
		return visibility;
	}
	
	public void visit(UmlEnum UmlEnum) {
		System.out.print(this.convertVisibility(UmlEnum)
				+ " "
				+ UmlEnum.getName()
				+ "{");
		System.out.println("\n}");
	}
	
	@Override
	public void visitDiagram(UmlDiagram diagram) {
		for(UmlComponent element : diagram.getUmlElements()) {
            element.accept(this);
        }
	}

	@Override
	public void visit(UmlClass UmlClass) {
		System.out.print(this.convertVisibility(UmlClass)
				+ " "
				+ UmlClass.getModifier()
				+ UmlClass.getName() 
				+ "{");
		System.out.println("\n}");
		
	}

	@Override
	public void visit(UmlInterface UmlInterface) {
		System.out.print(this.convertVisibility(UmlInterface)
				+ " "
				// + UmlInterface.getModifier()
				+ UmlInterface.getName() 
				+ "{");
		System.out.println("\n}");	
	}
	
}
