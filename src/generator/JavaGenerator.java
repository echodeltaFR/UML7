package generator;

import java.util.HashMap;
import java.util.Map;

import model.Modifier;
import model.PrimitiveType;
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
 * Class which allows to generate Java code from UML diagram.
 * @author fmeslet
 * @see DiagramElementVisitor
 * @see UmlDiagram
 * @see UmlEntity
 * @see Visibility
 * @see UmlRefType
 * @see UmlAttribute
 * @see UmlMethod
 * @see UmlEnum
 * @see UmlParams
 * @see UmlInterface
 * @version 1.0
 */
public class JavaGenerator implements DiagramElementVisitor {
	
	private Map<String, String> code;
	
	private UmlDiagram diagram;
	
	/**
	 * Build a java generator.
	 * @param diagram Diagram we need in order to generate code
	 */
	public JavaGenerator(UmlDiagram diagram) {
		this.diagram = diagram;
		this.code = new HashMap<>();
	}
	
	/**
	 * Build a java generator.
	 */
	public JavaGenerator() {
		this.diagram = null;
		this.code = new HashMap<>();
	}
	
	/**
	 * Convert the name visibility of the component. 
	 * @param component The component
	 * @return The new visibility's name
	 */
	private String convertVisibility(UmlEntity component) {
		String visibility = null;
		
		switch(component.getVisibility()) {
		case PUBLIC:
			visibility = "public";
			break;
		case PRIVATE:
			visibility = "private";
			break;
		case PROTECTED:
			visibility = "protected";
			break;
		default:
			visibility = "public";
		}
		return visibility;
	}
	
	/**
	 * Generate diagram code.
	 */
	public void generateCode() {
		// for each components in the diagram
		for(UmlRefType element : diagram.getUmlElements()) {
			element.accept(this);
        }
	}
	
	/**
	 * Generate attributes for an uml component.
	 * @param component Component we need in order to generate attributes
	 * @return The attributes' code
	 */
	private String generateAttributes(UmlRefType component) {
		StringBuilder attributeCode = new StringBuilder();

		// Add the attributes
		for(UmlAttribute attribut : component.getAttributesList()) {
			attributeCode.append(DiagramElementVisitor.TAB
				+ this.convertVisibility(attribut) + " ");
			
			// Add the attribute modifier
			if(!attribut.getModifiers().isEmpty()) {
				for(Modifier modifier : attribut.getModifiers()) {
					attributeCode.append(modifier.toString() + " ");
				}
			}
			
			// Add type and name
			attributeCode.append(
					attribut.getType().getTypeName() + " "
					+ attribut.getName()
					+ ";\n");
		}
		return attributeCode.toString();
	}
	
	/**
 	* Generate methods for an UML component.
 	* @param component UML component we need in order to generate method
 	* @param generateBody False if we want to generate an interface or abstract method
 	* @return String which contains the methods' code
 	*/
	private String generateMethods(UmlRefType component, boolean generateBody) {
		StringBuilder methodCode = new StringBuilder();

		// Print the class method
		for(UmlMethod method : component.getMethodsList()) {
			methodCode.append(DiagramElementVisitor.TAB 
					+ this.convertVisibility(method) + " ");

			// Add the method modifier
			if(!method.getModifiers().isEmpty()) {
				for(Modifier modifier : method.getModifiers()) {
					if(modifier.equals(Modifier.ABSTRACT)) {
						generateBody = false;
					}
					methodCode.append(modifier.toString() + " ");
				}
			}
			
			// Add the method name and return type
			if (method.getReturnType() != null) {
				methodCode.append(method.getReturnType().getTypeName() + " "
						+ method.getName()
						+ "(");
			} else {
				methodCode.append("void "
						+ method.getName()
						+ "(");
			}
			
			
			// Add the method parameters
			if (!method.getParams().isEmpty()) {
				for(UmlParams params : method.getParams()) {
					methodCode.append(params.getType().getTypeName() + " "
							+ params.getName() + ", ");
				}
				String tmp = methodCode.substring(0, methodCode.length()-2);
				methodCode.setLength(0);
				methodCode.append(tmp);
			}

			methodCode.append(")");

			if (generateBody) {
				methodCode.append(" {\n");
				if (method.getReturnType() instanceof PrimitiveType) {
					PrimitiveType p = (PrimitiveType) method.getReturnType();
					switch(p.getTypeName()) {
					case "void" : break;
					case "int" : methodCode.append(DiagramElementVisitor.TAB + DiagramElementVisitor.TAB + "return 0;\n"); break;
					case "double" : methodCode.append(DiagramElementVisitor.TAB + DiagramElementVisitor.TAB + "return 0;\n"); break;
					case "float" : methodCode.append(DiagramElementVisitor.TAB + DiagramElementVisitor.TAB + "return 0;\n"); break;
					case "byte" : methodCode.append(DiagramElementVisitor.TAB + DiagramElementVisitor.TAB + "return 0;\n"); break;
					case "short" : methodCode.append(DiagramElementVisitor.TAB + DiagramElementVisitor.TAB + "return 0;\n"); break;
					case "long" : methodCode.append(DiagramElementVisitor.TAB + DiagramElementVisitor.TAB + "return 0;\n"); break;
					case "String" : methodCode.append(DiagramElementVisitor.TAB + DiagramElementVisitor.TAB + "return \"\";\n"); break;
					case "char" : methodCode.append(DiagramElementVisitor.TAB + DiagramElementVisitor.TAB + "return '';\n"); break;
					case "boolean" : methodCode.append(DiagramElementVisitor.TAB + DiagramElementVisitor.TAB + "return false;\n"); break;
					}
				}
				else {
					methodCode.append(DiagramElementVisitor.TAB + DiagramElementVisitor.TAB + "return null;\n");
				}
				methodCode.append(DiagramElementVisitor.TAB + "}\n\n");
			} else {
				methodCode.append(";\n\n");
			}
		}
		return methodCode.toString();
		
	}
	
	@Override
	public void visit(UmlEnum umlEnum) {
		this.generateJavaObject(umlEnum, "enum", true);
	}

	@Override
	public void visit(UmlClass umlClass) {
		boolean generateBody = true;
//		for(Modifier modifier : umlClass.getModifiers()) {
//			if(modifier.equals(Modifier.ABSTRACT)) {
//				generateBody = false;
//			}
//		}
		this.generateJavaObject(umlClass, "class", generateBody);
		
	}

	@Override
	public void visit(UmlInterface umlInterface) {
		this.generateJavaObject(umlInterface, "interface", false);
	}
	
	/**
	 * Generate code for an UML component.
	 * @param component The UML component
	 * @param refType The name of the UML component
	 * @param generateBody True if we need to generate body
	 */
	private void generateJavaObject(UmlRefType component, String refType, boolean generateBody) {
		StringBuilder componentCode = new StringBuilder();
		
		// Add the element visibility
		componentCode.append(this.convertVisibility(component) + " ");
		
		// Add the modifier of the class
		if(!component.getModifiers().isEmpty()) {
			for(Modifier modifier : component.getModifiers()) {
				componentCode.append(modifier.toString() + " ");
			}
		}
		
		// Add the class name
		componentCode.append(
					refType + " "
					+ component.getName() + " {\n\n"
					);
		
		// Check if it's an enum
		if(refType.equals("enum") && !((UmlEnum)component).getValuesList().isEmpty()) {
			for(String attribute : ((UmlEnum)component).getValuesList()) {
				componentCode.append(DiagramElementVisitor.TAB + attribute + ";\n");
			}
			componentCode.append("\n");
		}		
		
		// Put a return if no attributes was print 
		if(!component.getAttributesList().isEmpty()) {
			componentCode.append(this.generateAttributes(component) + "\n");
		}
		
		// Add the methods
		if(!component.getMethodsList().isEmpty()) {
			componentCode.append(this.generateMethods(component, generateBody));
//			if(!generateBody) {
//				componentCode.append("\n");
//			}
		}
		
		// Add the close part
		componentCode.append("}\n");
		
		// Add code to a file
		this.code.put(component.getName() + ".java", componentCode.toString());
	}
	
	/**
	 * Get the code for each UML component.
	 * @return The code for each UML component
	 */
	public Map<String, String> getCode() {
		return this.code;
	}
	
	/**
	 * Set a new diagram for the generator.
	 * @param diagram The new diagram
	 */
	public void setDiagram(UmlDiagram diagram) {
		this.diagram = diagram;
		this.code = new HashMap<String, String>();
	}
	
}
