package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.*;

public class UmlEnumTest {
	
	private UmlEnum umlEnum1;
	private UmlEnum umlEnum2;
	private UmlEnum umlEnum3;
	private UmlEnum umlEnum4;
	private UmlEnum umlEnum5;
	
	private String value1;
	private String value2;
	private String value3;
	
	private List<String> values;
	private List<String> values2;
	
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
		this.value1 = "value1";
		this.value2 = "value2";
		this.value3 = "value3";
		
		this.values = new ArrayList<String>();
		this.values.add(value1);
		this.values.add(value2);
		this.values.add(value3);
		
		this.values2 = new ArrayList<String>();
		this.values2.add(value1);
		this.values2.add(value2);
		
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
		this.umlEnum1 = new UmlEnum("enum1");
		assertNotNull(umlEnum1);
		assertTrue(umlEnum1.getName().equals("enum1"));
	}
	
	@Test
	public void testInitialization2() {
		this.umlEnum2 = new UmlEnum("enum2", values);
		assertNotNull(umlEnum2);
		assertTrue(umlEnum2.getName().equals("enum2"));
		assertTrue(umlEnum2.getValuesList().equals(values));
	}
	
	@Test
	public void testInitialization3() {
		this.umlEnum3 = new UmlEnum("enum3", values, methods);
		assertNotNull(umlEnum3);
		assertTrue(umlEnum3.getName().equals("enum3"));
		assertTrue(umlEnum3.getValuesList().equals(values));
		assertTrue(umlEnum3.getMethodsList().equals(methods));
	}
	
	@Test
	public void testInitialization4() {
		this.umlEnum4 = new UmlEnum("enum4", values, methods, attributes);
		assertNotNull(umlEnum4);
		assertTrue(umlEnum4.getName().equals("enum4"));
		assertTrue(umlEnum4.getValuesList().equals(values));
		assertTrue(umlEnum4.getMethodsList().equals(methods));
		assertTrue(umlEnum4.getAttributesList().equals(attributes));
	}
	
	@Test
	public void testInitialization5() {
		this.umlEnum5 = new UmlEnum("enum5", values, methods, attributes, visibility, modifiers);
		assertNotNull(umlEnum5);
		assertTrue(umlEnum5.getName().equals("enum5"));
		assertTrue(umlEnum5.getValuesList().equals(values));
		assertTrue(umlEnum5.getMethodsList().equals(methods));
		assertTrue(umlEnum5.getAttributesList().equals(attributes));
		assertTrue(umlEnum5.getVisibility().equals(visibility));
		assertTrue(umlEnum5.getModifiers().equals(modifiers));
	}
	
	@Test
	public void testSetName() {
		this.umlEnum1 = new UmlEnum("enum1");
		this.umlEnum1.setName("newName");
		assertTrue(umlEnum1.getName().equals("newName"));
	}
	
	@Test
	public void testSetValues() {
		this.umlEnum2 = new UmlEnum("enum2", values);
		this.umlEnum2.setValuesList(values2);;
		assertTrue(umlEnum2.getValuesList().equals(values2));
	}
	
	@Test
	public void testSetMethods() {
		this.umlEnum3 = new UmlEnum("enum3", values, methods);
		this.umlEnum3.setMethodsList(methods2);
		assertTrue(umlEnum3.getMethodsList().equals(methods2));
	}
	
	@Test
	public void testSetAttributes() {
		this.umlEnum4 = new UmlEnum("enum4", values, methods, attributes);
		this.umlEnum4.setAttributesList(attributes2);
		assertTrue(umlEnum4.getAttributesList().equals(attributes2));
	}
	
	@Test
	public void testSetVisibilityModifiers() {
		this.umlEnum5 = new UmlEnum("enum5", values, methods, attributes, visibility, modifiers);
		this.umlEnum5.setVisibility(visibility2);
		this.umlEnum5.setModifiers(modifiers2);
		assertTrue(umlEnum5.getVisibility().equals(visibility2));
		assertTrue(umlEnum5.getModifiers().equals(modifiers2));
	}
	
	@Test
	public void testClearModifiers() {
		this.umlEnum5 = new UmlEnum("enum5", values, methods, attributes, visibility, modifiers);
		this.umlEnum5.clearModifiers();
		assertTrue(umlEnum5.getModifiers().isEmpty());
	}
	
	@Test
	public void testAddRemove() {
		this.umlEnum4 = new UmlEnum("enum4", values,  methods, attributes);
		this.umlEnum4.removeAttribute(umlAttribute1);
		assertTrue(!umlEnum4.getAttributesList().contains(umlAttribute1));
		this.umlEnum4.addAttribute(umlAttribute1);
		assertTrue(umlEnum4.getAttributesList().contains(umlAttribute1));
		this.umlEnum4.removeMethod(umlMethod1);
		assertTrue(!umlEnum4.getMethodsList().contains(umlMethod1));
		this.umlEnum4.addMethod(umlMethod1);
		assertTrue(umlEnum4.getMethodsList().contains(umlMethod1));
		this.umlEnum4.removeValue(value1);
		assertTrue(!umlEnum4.getValuesList().contains(value1));
		this.umlEnum4.addValue(value1);
		assertTrue(umlEnum4.getValuesList().contains(value1));
	}
	
	@Test
	public void testGetTypeName() {
		this.umlEnum1 = new UmlEnum("class1");
		assertTrue(umlEnum1.getTypeName().equals("class1"));
	}
}
