package generator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import exception.ExceptionUml;
import exception.ExceptionModifier;
import model.Modifier;
import model.PrimitiveType;
import model.UmlAttribute;
import model.UmlClass;
import model.UmlRefType;
import model.UmlDiagram;
import model.UmlEnum;
import model.UmlInterface;
import model.UmlMethod;
import model.UmlParams;
import model.UmlType;
import model.Visibility;

public class JavaGeneratorTest {

	private JavaGenerator generator;
	
	private UmlDiagram diagramInterface;
	private UmlDiagram diagramClass;
	private UmlDiagram diagramEnum;
	private UmlDiagram diagramClassEmpty;
	
	private List<UmlRefType> interfaceDiagramComponents;
	private List<UmlRefType> classDiagramComponents;
	private List<UmlRefType> emptyClassDiagramComponents;
	private List<UmlRefType> enumDiagramComponents;
	
	private UmlRefType interfaceComponent;
	private UmlRefType classComponent;
	private UmlRefType emptyClassComponent;
	private UmlRefType enumComponent;
	
	
	private String code;
	private String result;
	
	@Before
	public void setUp() throws ExceptionUml {
		// Create attributes with modifier and visiblity
		Set<Modifier> modifierAttribut1 = new HashSet<Modifier>();
		modifierAttribut1.add(Modifier.FINAL);
		modifierAttribut1.add(Modifier.STATIC);
		
		UmlAttribute attribute1 = new UmlAttribute("CONSTANTE",
				PrimitiveType.INT, 
				Visibility.PUBLIC,
				modifierAttribut1);
		UmlAttribute attribute2 = new UmlAttribute("attribut2",
				PrimitiveType.STRING, 
				Visibility.PUBLIC,
				null);
		UmlAttribute attribute3 = new UmlAttribute("attribut3",
				PrimitiveType.DOUBLE, 
				Visibility.PRIVATE,
				null);
		UmlAttribute attributeInterface = new UmlAttribute("attributInterface",
				PrimitiveType.DOUBLE, 
				Visibility.PUBLIC,
				modifierAttribut1);
		
		// Create parameters
		UmlRefType type1 = new UmlClass("type1");
		UmlRefType type2 = new UmlClass("type2");
		UmlParams param1 = new UmlParams(type1, "param1");
		UmlParams param2 = new UmlParams(type2, "param2");
		
		// Create methods parameters
		Set<UmlParams> paramsMethod1 = new HashSet<UmlParams>();
		paramsMethod1.add(param1);
		paramsMethod1.add(param2);
		Set<UmlParams> paramsMethod2 = new HashSet<UmlParams>();
		paramsMethod2.add(param1);
		
		Set<Modifier> modifierMethod3 = new HashSet<Modifier>();
		modifierMethod3.add(Modifier.FINAL);
		
		Set<Modifier> modifierAbstract = new HashSet<Modifier>();
		modifierAbstract.add(Modifier.ABSTRACT);
		
		UmlMethod method1 = new UmlMethod("method1", paramsMethod1, PrimitiveType.VOID, Visibility.PUBLIC, null);
		UmlMethod method2 = new UmlMethod("method2", paramsMethod2, type1, null, null);
		UmlMethod method3 = new UmlMethod("method3", null, type2, null, modifierMethod3);
		UmlMethod method4 = new UmlMethod("method4", null, PrimitiveType.VOID, Visibility.PUBLIC, modifierAbstract );
		
		// Create attribute and method component
		List <UmlAttribute> attributes = new ArrayList<UmlAttribute>();
		attributes.add(attribute1);
		attributes.add(attribute2);
		attributes.add(attribute3);
		
		List <UmlAttribute> attributesInterface = new ArrayList<UmlAttribute>();
		attributesInterface.add(attributeInterface);
		
		List <UmlMethod> methods = new ArrayList<UmlMethod>();
		methods.add(method1);
		methods.add(method2);
		methods.add(method3);
		
		List <UmlMethod> methodsInterface = new ArrayList<UmlMethod>();
		methodsInterface.add(method4);
		
		List <String> valuesEnum = new ArrayList<String>();
		valuesEnum.add("INT");
		valuesEnum.add("DOUBLE");
		valuesEnum.add("STRING");
		
		// Create components
		interfaceComponent = new UmlInterface("Interface", 
				methodsInterface, attributesInterface, 
				Visibility.PUBLIC, null);
		
		classComponent = new UmlClass("Class", 
				methods, attributes, 
				Visibility.PUBLIC, null);
		
		emptyClassComponent = new UmlClass("ClassEmpty", 
				new ArrayList<UmlMethod>(), new ArrayList<UmlAttribute>(), Visibility.PUBLIC, null);
		
		enumComponent = new UmlEnum("Enum", 
				valuesEnum, methods, attributes, 
				Visibility.PUBLIC);
		
		// Create diagrams
		interfaceDiagramComponents = new ArrayList<UmlRefType>();
		interfaceDiagramComponents.add(interfaceComponent);
		
		classDiagramComponents = new ArrayList<UmlRefType>();
		classDiagramComponents.add(classComponent);
		
		emptyClassDiagramComponents = new ArrayList<UmlRefType>();
		emptyClassDiagramComponents.add(emptyClassComponent);
		
		enumDiagramComponents = new ArrayList<UmlRefType>();
		enumDiagramComponents.add(enumComponent);
		
		diagramInterface = new UmlDiagram("Diagram Interface", interfaceDiagramComponents);
		diagramClass = new UmlDiagram("Diagram Class", classDiagramComponents);
		diagramClassEmpty = new UmlDiagram("Diagram Class Empty", emptyClassDiagramComponents);
		diagramEnum = new UmlDiagram("Diagram Enum", enumDiagramComponents);
		
		// Create generator
		generator = new JavaGenerator();
		
		// Result goal and code generate
		result = null;
		code = null;
	}
	
	@Test
	public void testGenerationInterface() {
		// Test with no relation
		// The results objective
		result = "public interface Interface {\n\n"
				+ DiagramElementVisitor.TAB + "public static final int CONSTANTE;\n"
				+ DiagramElementVisitor.TAB + "public String attribut2;\n"
				+ DiagramElementVisitor.TAB + "private double attribut3;\n\n"
				+ DiagramElementVisitor.TAB + "public void method1(type2 param2, type1 param1);\n"
				+ DiagramElementVisitor.TAB + "public type1 method2(type1 param1);\n"
				+ DiagramElementVisitor.TAB + "public type2 method3();\n\n"
				+ "}\n";
		
		generator.setDiagram(diagramInterface);
		generator.generateCode();
		String code = generator.getCode().get("Interface.java");	
		
		assertEquals("testGenerationInterface : wrong generation", result, code);
		
		// Test with extends relation
		// Add interface in diagram
		
		// Test with multiple extends relation
		
	}
	
	@Test
	public void testGenerationNormalClass() {
		// The results objective
		result = "public class Class {\n\n"
				+ DiagramElementVisitor.TAB + "public static final int CONSTANTE;\n"
				+ DiagramElementVisitor.TAB + "public String attribut2;\n"
				+ DiagramElementVisitor.TAB + "private double attribut3;\n\n"
				+ DiagramElementVisitor.TAB + "public void method1(type2 param2, type1 param1) {\n"
				+ DiagramElementVisitor.TAB + "}\n\n"
				+ DiagramElementVisitor.TAB + "public type1 method2(type1 param1) {\n"
				+ DiagramElementVisitor.TAB + "}\n\n"
				+ DiagramElementVisitor.TAB + "public final type2 method3() {\n"
				+ DiagramElementVisitor.TAB + "}\n\n"
				+ "}\n";
		
		// Test with no relation
		generator.setDiagram(diagramClass);
		generator.generateCode();
		code = generator.getCode().get("Class.java");
		assertEquals("testGenerationClass: wrong normal class generation", result, code);
		
		// Test with extends relation
		
		// Test with implement relation
		
		// Test with implement and extend
	}
	
	@Test
	public void testGenerationAbstractClass() throws ExceptionModifier { 
		// The result objective
		result = "public abstract class ClassEmpty {\n\n" + "}\n";
		
		emptyClassComponent.addModifier(Modifier.ABSTRACT);
		generator.setDiagram(diagramClassEmpty);
		generator.generateCode();
		code = generator.getCode().get("ClassEmpty.java");

		assertEquals("testGenerationClass: wrong abstract class generation", result, code);
	}
	
	@Test
	public void testGenerationEnum() {
		// The results objective
		result = "public enum Enum {\n\n"
				+ DiagramElementVisitor.TAB + "INT;\n"
				+ DiagramElementVisitor.TAB + "DOUBLE;\n"
				+ DiagramElementVisitor.TAB + "STRING;\n\n"
				+ DiagramElementVisitor.TAB + "public static final int CONSTANTE;\n"
				+ DiagramElementVisitor.TAB + "public String attribut2;\n"
				+ DiagramElementVisitor.TAB + "private double attribut3;\n\n"
				+ DiagramElementVisitor.TAB + "public void method1(type1 param1, type2 param2) {\n"
				+ DiagramElementVisitor.TAB + "}\n\n"
				+ DiagramElementVisitor.TAB + "public type1 method2(type1 param1) {\n"
				+ DiagramElementVisitor.TAB + "}\n\n"
				+ DiagramElementVisitor.TAB + "public final type2 method3() {\n"
				+ DiagramElementVisitor.TAB + "}\n\n"
				+ "}\n";
		
		// Test with no relation
		generator.setDiagram(diagramEnum);
		generator.generateCode();
		code = generator.getCode().get("Enum.java");

		assertEquals("testGenerationClass: wrong enum generation", result, code);
		
		// Test with extends relation
		
		// Test with implement relation
		
		// Test with implement and extend
	}
	
}
