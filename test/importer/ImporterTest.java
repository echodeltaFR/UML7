package importer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import exporter.DiagramSaver;
import model.Modifier;
import model.PrimitiveType;
import model.UmlAttribute;
import model.UmlClass;
import model.UmlDiagram;
import model.UmlMethod;
import model.UmlParams;
import model.UmlRefType;
import model.Visibility;

public class ImporterTest {

	private UmlDiagram diagramClass;
	
	private List<UmlRefType> classDiagramComponents;

	private UmlRefType classComponent;
	
	private DiagramSaver saver;
	private DiagramLoader loader;
	
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
		
		UmlMethod method1 = new UmlMethod("method1", paramsMethod1, PrimitiveType.VOID, Visibility.PUBLIC, null);
		UmlMethod method2 = new UmlMethod("method2", paramsMethod2, type1, null, null);
		UmlMethod method3 = new UmlMethod("method3", null, type2, null, modifierMethod3);
		
		// Create attribute and method component
		List <UmlAttribute> attributes = new ArrayList<UmlAttribute>();
		attributes.add(attribute1);
		attributes.add(attribute2);
		attributes.add(attribute3);
		
		List <UmlMethod> methods = new ArrayList<UmlMethod>();
		methods.add(method1);
		methods.add(method2);
		methods.add(method3);
		
		List <String> valuesEnum = new ArrayList<String>();
		valuesEnum.add("INT");
		valuesEnum.add("DOUBLE");
		valuesEnum.add("STRING");
		
		// Create components
		classComponent = new UmlClass("Class", 
				methods, attributes, 
				Visibility.PUBLIC, new HashMap<Modifier>());
		
		// Create diagrams
		diagramClass = new UmlDiagram("Diagram Class", classDiagramComponents);
		
		// Create Loader
		loader = new DiagramLoader();
		
		// Create Saver
		saver = new DiagramSaver(diagramClass);
	}
	
	@Test
	public void testLoader() throws ClassNotFoundException, IOException {
		saver.save();
		System.out.println("je passe");
		loader.load();

		assertEquals("testGenerationClass: wrong normal class generation", diagramClass, loader.getDiagram());
		
	}
	
}
