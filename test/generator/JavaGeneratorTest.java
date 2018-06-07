package generator;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.PrimitiveType;
import model.UmlAttribute;
import model.UmlComponent;
import model.UmlDiagram;
import model.UmlEnum;
import model.UmlInterface;
import model.UmlMethod;
import model.UmlType;
import model.Visibility;

public class JavaGeneratorTest {

	@Before
	public void setUp() {
		// Create Uml component
		UmlComponent umlInterface = new UmlInterface("Interface");
		
		UmlComponent umlClassA = new UmlClass("ClassA", );
		UmlComponent umlClassB = new UmlClass("ClassB", Modifier.ABSTRACT); //Classe astraite
		UmlComponent umlClassC = new UmlClass("ClassC", ); //Interface
		
		UmlComponent umlEnum = new UmlEnum("Enum", Visibility.PUBLIC);
		
		// Create attributes
		UmlAttribute attribute1 = new UmlAttribute("CONSTANTE", PrimitiveType.INT, );
		UmlAttribute attribute2 = new UmlAttribute("attribut1",PrimitiveType.INT,);
		
		// Créer le bon constructeur
		
		// Create methods
		UmlMethod method2 = new UmlMethod("method1", umlAttributeInterface1, );
		UmlMethod method1 = new UmlMethod("method2", umlAttributeInterface2);
		
		umlInterface.addMethod();
		
		JavaGenerator generateur = new JavaGenerator();
		
		generateur.visitDiagram(new UmlDiagram("test", list));
	}
	
	@Test
	public void testVisitUmlInterface() {
		// The results objective
		String results = "public interface Interface {\n"
				+ "public static final int CONSTANTE;\n"
				+ "String variable = \"tutu\";\n"
				+ "\tpublic void method1(type1 attribut1, type2 attribut2);\n"
				+ "\ttype1 method2(type1 attribut1)\n"
				+ "\tstatic void method3()\n"
				+ "}";
		
		System.out.print(results);
		AssertEquals("UmlInterface : wrong generation", results, );
		
		// Test with extends relation
		
		
		// Test with multiple extends relation
		
	}
	
	@Test
	public void testVisitClass() {
		// Test with no relation
		String results = "public class Class {\n"
				+ "public static final int CONSTANTE;\n"
				+ "String variable = \"tutu\";\n"
				+ "\tpublic void method1(type1 attribut1, type2 attribut2);\n"
				+ "\ttype1 method2(type1 attribut1)\n"
				+ "\tstatic void method3()\n"
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
	
}
