package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class UmlInterfaceTest {
	private UmlInterface interface1;
	private UmlInterface interface2;
	private UmlInterface interface3;
	private UmlInterface interface4;
	private UmlMethod method1;
	private UmlMethod method2;
	private UmlMethod method3;
	private List<UmlMethod> Lmethod;
	private Visibility visibility;
	private Modifier modifiey1;
	private Modifier modifiey2;
	private Modifier modifiey3;
	private UmlAttribute attribute1;
	private UmlAttribute attribute2;
	private List<UmlAttribute> Lattribute;
	private Set<Modifier> modifier;
	@Before public void setUp() {
		 method1 = new UmlMethod("method1");
		 method2 = new UmlMethod("method2");
		 method3 = new UmlMethod("method3");
		 Lmethod = new ArrayList<UmlMethod>();
		 Lmethod.add(method1);
		 Lmethod.add(method2);
		 
		 attribute1 = new UmlAttribute("attribute1", null);
		 attribute2 = new UmlAttribute("attribute2", null, modifiey1);
		 
		 Lmethod = new ArrayList<UmlMethod>();
		 Lmethod.add(method1);
		 Lmethod.add(method2);
		 
		 visibility = Visibility.PUBLIC;
		 modifiey1 = Modifier.STATIC;
		 modifiey2 = Modifier.ABSTRACT;
		 modifiey3 = Modifier.TRANSIENT;
		 
		 
		 interface1 = new UmlInterface("interface");
		 interface2 = new UmlInterface("interface", Lmethod);
		 interface3 = new UmlInterface("interface", Lmethod, visibility);
		 interface4 = new UmlInterface("interface", Lmethod, null, null, null);
		 interface1.addMethod(method1);
		 interface1.addMethod(method2);
	}
	 
	@Test public void testgetNom() {
		assertEquals("Check the name", "interface", interface1.getName());
		assertEquals("Check the name", "interface", interface2.getName());
		assertEquals("Check the name", "interface", interface3.getName());
		assertEquals("Check the name", "interface", interface4.getName());
		assertEquals("Check the name", "interface", interface5.getName());
		
	}
	
	@Test public void testgetMethod() {
		assertEquals("Check the name", "interface", interface1.getMethodsList());
	}
	
}
