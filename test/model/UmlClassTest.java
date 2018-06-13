package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.*;

import exception.ExceptionUml;
import exception.ExceptionMethode;

public class UmlClassTest {
	
	private UmlClass umlClass1;
	private UmlClass umlClass2;
	private UmlClass umlClass3;
	private UmlClass umlClass4;
	
	private UmlMethod umlMethod1;
	private UmlMethod umlMethod2;
	private UmlMethod umlMethod3;
	
	private UmlAttribute umlAttribute1;
	private UmlAttribute umlAttribute2;
	private UmlAttribute umlAttribute3;
	
	private Visibility visibility;
	private Visibility visibility2;
	
	private Modifier modifier1;
	private Modifier modifier2;
	
	private Set<Modifier> modifiers;
	private Set<Modifier> modifiers2;
	
	private List<UmlMethod> methods;
	private List<UmlMethod> methods2;
	
	private List<UmlAttribute> attributes;
	private List<UmlAttribute> attributes2;
	
	@Before
	public void setUp() {
		this.visibility = Visibility.PUBLIC;
		this.visibility2 = Visibility.PACKAGE;
		
		this.modifier1 = Modifier.FINAL;
		this.modifier2 = Modifier.ABSTRACT;
		
		this.modifiers = new HashSet<Modifier>();
		this.modifiers.add(modifier1);
		
		this.modifiers2 = new HashSet<Modifier>();
		this.modifiers2.add(modifier2);
		
		this.umlMethod1 = new UmlMethod("method1");
		this.umlMethod2 = new UmlMethod("method2");
		this.umlMethod3 = new UmlMethod("method3");
		
		this.umlAttribute1 = new UmlAttribute("attribute1", PrimitiveType.INT);
		this.umlAttribute2 = new UmlAttribute("attribute2", PrimitiveType.DOUBLE);
		this.umlAttribute3 = new UmlAttribute("attribute3", PrimitiveType.FLOAT);
		
		this.methods = new ArrayList<UmlMethod>();
		this.methods.add(umlMethod1);
		this.methods.add(umlMethod2);
		this.methods.add(umlMethod3);
		
		this.methods2 = new ArrayList<UmlMethod>();
		this.methods2.add(umlMethod1);
		this.methods2.add(umlMethod2);
		
		this.attributes = new ArrayList<UmlAttribute>();
		this.attributes.add(umlAttribute1);
		this.attributes.add(umlAttribute2);
		this.attributes.add(umlAttribute3);
		
		this.attributes2 = new ArrayList<UmlAttribute>();
		this.attributes2.add(umlAttribute1);
		this.attributes2.add(umlAttribute2);
	}
	
	@Test
	public void testInitialization1() {
		this.umlClass1 = new UmlClass("class1");
		assertNotNull(umlClass1);
		assertTrue(umlClass1.getName().equals("class1"));
	}
	
	@Test
	public void testInitialization2() throws ExceptionMethode {
		this.umlClass2 = new UmlClass("class2", methods);
		assertNotNull(umlClass2);
		assertTrue(umlClass2.getName().equals("class2"));
		assertTrue(umlClass2.getMethodsList().equals(methods));
	}
	
	@Test
	public void testInitialization3() throws ExceptionUml {
		this.umlClass3 = new UmlClass("class3", methods, attributes);
		assertNotNull(umlClass3);
		assertTrue(umlClass3.getName().equals("class3"));
		assertTrue(umlClass3.getMethodsList().equals(methods));
		assertTrue(umlClass3.getAttributesList().equals(attributes));
	}
	
	@Test
	public void testInitialization4() throws ExceptionUml {
		this.umlClass4 = new UmlClass("class4", methods, attributes, visibility, modifiers);
		assertNotNull(umlClass4);
		assertTrue(umlClass4.getName().equals("class4"));
		assertTrue(umlClass4.getMethodsList().equals(methods));
		assertTrue(umlClass4.getAttributesList().equals(attributes));
		assertTrue(umlClass4.getVisibility().equals(visibility));
		assertTrue(umlClass4.getModifiers().equals(modifiers));
	}
	
	@Test
	public void testSetName() {
		this.umlClass1 = new UmlClass("class1");
		this.umlClass1.setName("newName");
		assertTrue(umlClass1.getName().equals("newName"));
	}
	
	@Test
	public void testSetMethods() throws ExceptionMethode {
		this.umlClass2 = new UmlClass("class2", methods);
		this.umlClass2.setMethodsList(methods2);
		assertTrue(umlClass2.getMethodsList().equals(methods2));
	}
	
	@Test
	public void testSetAttributes() throws ExceptionUml {
		this.umlClass3 = new UmlClass("class3", methods, attributes);
		this.umlClass3.setAttributesList(attributes2);
		assertTrue(umlClass3.getAttributesList().equals(attributes2));
	}
	
	@Test
	public void testSetVisibilityModifiers() throws ExceptionUml {
		this.umlClass4 = new UmlClass("class4", methods, attributes, visibility, modifiers);
		this.umlClass4.setVisibility(visibility2);
		this.umlClass4.setModifiers(modifiers2);
		assertTrue(umlClass4.getVisibility().equals(visibility2));
		assertTrue(umlClass4.getModifiers().equals(modifiers2));
	}
	
	@Test
	public void testClearModifiers() throws ExceptionUml {
		this.umlClass4 = new UmlClass("class4", methods, attributes, visibility, modifiers);
		this.umlClass4.clearModifiers();
		assertTrue(umlClass4.getModifiers().isEmpty());
	}
	
	@Test
	public void testAddRemove() throws ExceptionUml {
		this.umlClass3 = new UmlClass("class3", methods, attributes);
		this.umlClass3.removeAttribute(umlAttribute1);
		assertTrue(!umlClass3.getAttributesList().contains(umlAttribute1));
		this.umlClass3.addAttribute(umlAttribute1);
		assertTrue(umlClass3.getAttributesList().contains(umlAttribute1));
		this.umlClass3.removeMethod(umlMethod1);
		assertTrue(!umlClass3.getMethodsList().contains(umlMethod1));
		this.umlClass3.addMethod(umlMethod1);
		assertTrue(umlClass3.getMethodsList().contains(umlMethod1));
	}
	
	@Test
	public void testGetTypeName() {
		this.umlClass1 = new UmlClass("class1");
		assertTrue(umlClass1.getTypeName().equals("class1"));
	}
}