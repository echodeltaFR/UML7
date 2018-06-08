package generator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import model.Modifier;
import model.PrimitiveType;
import model.UmlAttribute;
import model.UmlClass;
import model.UmlComponent;
import model.UmlDiagram;
import model.UmlEnum;
import model.UmlInterface;
import model.UmlMethod;
import model.UmlParams;
import model.UmlType;
import model.Visibility;

public class JavaGeneratorTest {

	private JavaGenerator generator;
	
	@Before
	public void setUp() {
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
		
		// Create parameters
		UmlComponent type1 = new UmlClass("type1");
		UmlComponent type2 = new UmlClass("type2");
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
		
		UmlMethod method1 = new UmlMethod("method1", paramsMethod1, PrimitiveType.VOID, Visibility.PUBLIC, null);
		UmlMethod method2 = new UmlMethod("method2", paramsMethod2, type1, null, null);
		UmlMethod method3 = new UmlMethod("method3", null, type2, null, modifierMethod3);
		
		// Create attribute and method component
		List <UmlAttribute> attributesInterface = new ArrayList<UmlAttribute>();
		attributesInterface.add(attribute1);
		attributesInterface.add(attribute2);
		attributesInterface.add(attribute3);
		
		List <UmlMethod> methodsInterface = new ArrayList<UmlMethod>();
		methodsInterface.add(method1);
		methodsInterface.add(method2);
		methodsInterface.add(method3);
		
		// Create components
		UmlComponent interfaceComponent = new UmlInterface("Interface", 
				methodsInterface, attributesInterface, 
				Visibility.PUBLIC, null);
		
//		umlInterface.setVisibility(Visibility.PUBLIC);
//		
//		UmlComponent classComponent = new UmlClass("ClassA");
//
//		UmlComponent abstractClassComponent = new UmlClass();
//		
//		UmlComponent enumComponent = new UmlEnum("Enum", Visibility.PUBLIC);
		
		// Create diagram
		List<UmlComponent> components = new ArrayList<UmlComponent>();
		components.add(interfaceComponent);
		
		UmlDiagram diagram = new UmlDiagram("Diagram1", components);
		
		// Create generator
		generator = new JavaGenerator();
		generator.setDiagram(diagram);
	}
	
	@Test
	public void testVisitUmlInterface() {
		// The results objective
		String results = "public interface Interface {\n\n"
				+ DiagramElementVisitor.TAB + "public static final int CONSTANTE;\n"
				+ DiagramElementVisitor.TAB + "public String attribut2;\n"
				+ DiagramElementVisitor.TAB + "private double attribut3;\n\n"
				+ DiagramElementVisitor.TAB + "public void method1(type1 param1, type2 param2);\n"
				+ DiagramElementVisitor.TAB + "public type1 method2(type1 param1);\n"
				+ DiagramElementVisitor.TAB + "public final type2 method3();\n\n"
				+ "}\n";
		
		System.out.print(results);
		generator.generateCode();
		String code = generator.getCode().get("Interface.java");
		
		System.out.println("\nLe résulat : \n");
		
		System.out.println(code);
		assertEquals("UmlInterface : wrong generation", results, code);
		
		// Test with extends relation
		// Add interface in diagram
		
		// Test with multiple extends relation
		
	}
	
	@Test
	public void testVisitClass() {
		// Test with no relation
		// The results objective
		String results = "public interface Interface {\n"
				+ "public static final int CONSTANTE = 3;"
				+ "String variable1;"
				+ "private double variable2;\n"
				+ "\tpublic void method1(type1 param1, type2 param2){\n"
				+ "}\n\n"
				+ "\ttype1 method2(type1 param1){\n"
				+ "}\n\n"
				+ "\tstatic type2 method3(){\n"
				+ "}\n\n"
				+ "}";
		// Test with extends relation
		
		
		// Test with implement relation
		
		// Test with implement and extend
	}
	
	
	@Test
	public void testVisitEnum() {
		// Test with no relation
		
		// Test with extends relation
		
		// Test with implement relation
		
		// Test with implement and extend
	}
	
//	public static void main(String ars[]) {
//		
//		System.out.println("Test : Visited diagram\n");
//		List<UmlComponent> list = new ArrayList<UmlComponent>();
//		UmlInterface umlInterface = new UmlInterface("Mon Interface");
//		umlInterface.addMethod(new UmlMethod());
//		list.add(new UmlEnum("MonEnum"));
//		list.add(new UmlInterface("MonInterface"));
//		
//		JavaGenerator generateur = new JavaGenerator();
//		
//		generateur.visitDiagram(new UmlDiagram("test", list));
//	}
	
}
