package generator;

import java.util.List;

import java.util.ArrayList;

import model.UmlClass;
import model.UmlInterface;
import model.UmlMethod;
import model.UmlParams;
import model.UmlEnum;
import model.UmlDiagram;
import model.UmlEntity;
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
		UmlInterface umlInterface = new UmlInterface("Mon Interface");
		umlInterface.addMethod(new UmlMethod());
		list.add(new UmlEnum("MonEnum"));
		list.add(new UmlInterface("MonInterface"));
		
		JavaGenerator generateur = new JavaGenerator();
		
		generateur.visitDiagram(new UmlDiagram("test", list));
	}
	
	public JavaGenerator() {
	}
	
	private String convertVisibility(UmlEntity component) {
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
			visibility = "";
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
		// Print the interface name with the visibility
		System.out.print(this.convertVisibility(UmlInterface)
				+ " "
				+ UmlInterface.getName() 
				+ "{");
		for(UmlMethod methods : UmlInterface.getMethodsList()) {
			System.out.println(this.convertVisibility(methods)
					+ methods.getVisibility()
					+ methods.getName()
					+ "(");
			for(UmlParams params : methods.getParams()) {
				System.out.print(params.getType()
						+ params.getName()
						+ params);
			}
					
			System.out.println("");
		}
		System.out.println("\n}");
	}
	
}
