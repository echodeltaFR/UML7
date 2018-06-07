package generator;

import java.util.HashMap;

import model.Modifier;
import model.UmlAttribute;
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
	
	private HashMap<String, String> code;
	
	private UmlDiagram diagram;
	
	public JavaGenerator(UmlDiagram diagram) {
		this.diagram = diagram;
		this.code = new HashMap<String, String>();
	}
	
	public JavaGenerator() {
		this.diagram = null;
		this.code = new HashMap<String, String>();
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
	
	public void generateCode(){
		// for each components in the diagram
		for(UmlComponent element : diagram.getUmlElements()) {
            element.accept(this);
        }
	}
	
	private String generateAttribute(UmlComponent component) {
		String attributeCode = "";
		
		// Add the attributes
		for(UmlAttribute attribut : component.getAttributesList()) {
			attributeCode =  "\n" + this.convertVisibility(attribut) + " ";
			
			// Add the attribute modifier
			if(!attribut.getModifier().isEmpty()) {
				for(Modifier modifier : attribut.getModifier()) {
					attributeCode = attributeCode + modifier.toString() + " ";
				}
			}
			
			// Add type and name
			attributeCode = attributeCode
							+ attribut.getType() + " "
							+ attribut.getName() + " "
							+ ";\n";
		}
		return attributeCode;
	}
	
	private String generateMethod(UmlComponent component) {
		String methodCode = "";
		
		// Print the class method
		for(UmlMethod method : component.getMethodsList()) {
			methodCode = "\n" + this.convertVisibility(method) + " ";
			
			// Add the method modifier
			if(!method.getModifier().isEmpty()) {
				for(Modifier modifier : method.getModifier()) {
					methodCode = methodCode + modifier.toString() + " ";
				}
			}
			
			// Add the method name and return type
			methodCode = methodCode 
					+ method.getReturnType().getTypeName() + " "
					+ method.getName()
					+ "(";
			
			// Add the method parameters
			for(UmlParams params : method.getParams()) {
				methodCode = methodCode 
						+ params.getType() + " "
						+ params.getName(); // Problème affichage de la virgule
			}
			methodCode = methodCode + ");";
		}
		return methodCode;
	}
	
	public void visit(UmlEnum umlEnum) {
		this.internal(umlEnum);
	}
	
//	@Override // Methode A supprimer
//	public void visitDiagram(UmlDiagram diagram) {
//		for(UmlComponent element : diagram.getUmlElements()) {
//            element.accept(this);
//        }
//	}

	@Override // Mettre en privée
	public void visit(UmlClass umlClass) {
		this.internal(umlClass);
	}

	@Override
	public void visit(UmlInterface umlInterface) {
		this.internal(umlInterface);
	}
	
	private void internal(UmlComponent component) {
		String componentCode;
		
		// Add the element visibility
		componentCode = this.convertVisibility(component) + " ";
		
		// Add the modifier of the class
		if(!component.getModifier().isEmpty()) {
			for(Modifier modifier : component.getModifier()) {
				componentCode = componentCode + modifier.toString() + " ";
			}
		}
		
		// Add the class name
		componentCode = componentCode + "{"
					+ component.getName() 
					+ this.generateAttribute(component) 
					+ this.generateMethod(component)
					+ "\n}";
		
		// Add code to a file
		this.code.put(component.getName(), componentCode);
	}
	
	public HashMap<String, String> getCode() {
		return this.code;
	}
	
}
