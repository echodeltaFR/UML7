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
import model.UmlRefType;

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
		for(UmlRefType element : diagram.getUmlElements()) {
            element.accept(this);
        }
	}
	
	private String generateAttribute(UmlRefType component) {
		String attributeCode = "";
		
		// Add the attributes
		for(UmlAttribute attribut : component.getAttributesList()) {
			attributeCode =  attributeCode + "\n" + DiagramElementVisitor.TAB
						+ this.convertVisibility(attribut) + " ";
			
			// Add the attribute modifier
			if(!attribut.getModifiers().isEmpty()) {
				for(Modifier modifier : attribut.getModifiers()) {
					attributeCode = attributeCode + modifier.toString() + " ";
				}
			}
			
			// Add type and name
			attributeCode = attributeCode
							+ attribut.getType().getTypeName() + " "
							+ attribut.getName()
							+ ";";
		}
		return attributeCode;
	}
	
	private String generateMethod(UmlRefType component) {
		String methodCode = "";
		
		// Print the class method
		for(UmlMethod method : component.getMethodsList()) {
			methodCode = methodCode +  "\n" + DiagramElementVisitor.TAB 
					+ this.convertVisibility(method) + " ";

			// Add the method modifier
			if(!method.getModifiers().isEmpty()) {
				for(Modifier modifier : method.getModifiers()) {
					methodCode = methodCode + modifier.toString() + " ";
				}
			}
			
			// Add the method name and return type
			methodCode = methodCode 
					+ method.getReturnType().getTypeName() + " "
					+ method.getName()
					+ "(";
			
			// Add the method parameters
			if (method.getParams().size()!=0) {
				for(UmlParams params : method.getParams()) {
					methodCode = methodCode 
							+ params.getType().getTypeName() + " "
							+ params.getName() + ", ";
				}
				methodCode = methodCode.substring(0, methodCode.length()-2);
			}
			methodCode = methodCode + ");";
		}
		return methodCode;
	}
	
	public void visit(UmlEnum umlEnum) {
		this.internal(umlEnum, "enum");
	}

	@Override
	public void visit(UmlClass umlClass) {
		this.internal(umlClass, "class");
	}

	@Override
	public void visit(UmlInterface umlInterface) {
		this.internal(umlInterface, "interface");
	}
	
	private void internal(UmlRefType component, String refType) {
		String componentCode;
		
		// Add the element visibility
		componentCode = this.convertVisibility(component) + " ";
		
		// Add the modifier of the class
		if(!component.getModifiers().isEmpty()) {
			for(Modifier modifier : component.getModifiers()) {
				componentCode = componentCode + modifier.toString() + " ";
			}
		}
		
		// Add the class name
		componentCode = componentCode
					+ refType + " "
					+ component.getName() + " {\n"
					+ this.generateAttribute(component) 
					+ "\n"
					+ this.generateMethod(component)
					+ "\n\n}\n";
		
		// Add code to a file
		this.code.put(component.getName() + ".java", componentCode);
	}
	
	public HashMap<String, String> getCode() {
		return this.code;
	}
	
	public void setDiagram(UmlDiagram diagram) {
		this.diagram = diagram;
	}
	
}
