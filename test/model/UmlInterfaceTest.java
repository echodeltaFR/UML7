package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import exception.ExceptionAttribute;
import exception.ExceptionComposition;
import exception.ExceptionMethode;

public class UmlInterfaceTest {
	
	private UmlInterface umlInterface1;
	private UmlInterface umlInterface2;
	private UmlInterface umlInterface3;
	private UmlInterface umlInterface4;
	
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
	
	@Before public void setUp() {
		this.visibility = Visibility.PRIVATE;
		this.visibility2 = Visibility.PACKAGE;
		
		this.modifier1 = Modifier.FINAL;
		this.modifier2 = Modifier.ABSTRACT;
		
		this.modifiers = new HashSet<Modifier>();
		this.modifiers.add(modifier1);
		this.modifiers.add(modifier2);
		
		this.modifiers2 = new HashSet<Modifier>();
		this.modifiers2.add(modifier1);
		
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
		this.umlInterface1 = new UmlInterface("interface1");
		assertNotNull(umlInterface1);
		assertTrue(umlInterface1.getName().equals("interface1"));
	}
	
	@Test
	public void testInitialization2() throws ExceptionMethode {
		this.umlInterface2 = new UmlInterface("interface2", methods);
		assertNotNull(umlInterface2);
		assertTrue(umlInterface2.getName().equals("interface2"));
		assertTrue(umlInterface2.getMethodsList().equals(methods));
	}
	
	@Test
	public void testInitialization3() throws ExceptionAttribute, ExceptionMethode {
		this.umlInterface3 = new UmlInterface("interface3", methods, attributes);
		assertNotNull(umlInterface3);
		assertTrue(umlInterface3.getName().equals("interface3"));
		assertTrue(umlInterface3.getMethodsList().equals(methods));
		assertTrue(umlInterface3.getAttributesList().equals(attributes));
	}
	
	@Test
	public void testInitialization5() throws ExceptionComposition {
		this.umlInterface4 = new UmlInterface("interface4", methods, attributes, visibility, modifiers);
		assertNotNull(umlInterface4);
		assertTrue(umlInterface4.getName().equals("interface4"));
		assertTrue(umlInterface4.getMethodsList().equals(methods));
		assertTrue(umlInterface4.getAttributesList().equals(attributes));
		assertTrue(umlInterface4.getVisibility().equals(visibility));
		assertTrue(umlInterface4.getModifiers().equals(modifiers));
	}
	
	@Test
	public void testSetName() {
		this.umlInterface1 = new UmlInterface("interface1");
		this.umlInterface1.setName("newName");
		assertTrue(umlInterface1.getName().equals("newName"));
	}
	
	@Test
	public void testSetMethods() throws ExceptionMethode {
		this.umlInterface2 = new UmlInterface("interface3", methods);
		this.umlInterface2.setMethodsList(methods2);
		assertTrue(umlInterface2.getMethodsList().equals(methods2));
	}
	
	@Test
	public void testSetAttributes() throws ExceptionAttribute, ExceptionMethode {
		this.umlInterface3 = new UmlInterface("interface3", methods, attributes);
		this.umlInterface3.setAttributesList(attributes2);
		assertTrue(umlInterface3.getAttributesList().equals(attributes2));
	}
	
	@Test
	public void testSetVisibilityModifiers() throws ExceptionComposition {
		this.umlInterface4 = new UmlInterface("interface4", methods, attributes, visibility, modifiers);
		this.umlInterface4.setVisibility(visibility2);
		this.umlInterface4.setModifiers(modifiers2);
		assertTrue(umlInterface4.getVisibility().equals(visibility2));
		assertTrue(umlInterface4.getModifiers().equals(modifiers2));
	}
	
	@Test
	public void testClearModifiers() throws ExceptionComposition {
		this.umlInterface4 = new UmlInterface("interface5", methods, attributes, visibility, modifiers);
		this.umlInterface4.clearModifiers();
		assertTrue(umlInterface4.getModifiers().isEmpty());
	}
	
	@Test
	public void testAddRemove() throws ExceptionAttribute, ExceptionMethode {
		this.umlInterface3 = new UmlInterface("interface3",  methods, attributes);
		this.umlInterface3.removeAttribute(umlAttribute1);
		assertTrue(!umlInterface3.getAttributesList().contains(umlAttribute1));
		this.umlInterface3.addAttribute(umlAttribute1);
		assertTrue(umlInterface3.getAttributesList().contains(umlAttribute1));
		this.umlInterface3.removeMethod(umlMethod1);
		assertTrue(!umlInterface3.getMethodsList().contains(umlMethod1));
		this.umlInterface3.addMethod(umlMethod1);
	}
	
	@Test
	public void testGetTypeName() {
		this.umlInterface1 = new UmlInterface("interface1");
		assertTrue(umlInterface1.getTypeName().equals("interface1"));
	}
}

