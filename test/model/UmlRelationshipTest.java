package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UmlRelationshipTest {

	private UmlRelationship umlRelation1;
	private UmlRelationship umlRelation2;
	private UmlRelationship umlRelation3;
	private UmlRelationship umlRelation4;

	private UmlClass classA;
	private UmlClass classB;
	private UmlClass classC;
	
	@Before 
	public void setUp() {
		this.classA = new UmlClass("ClassA");
		this.classB = new UmlClass("ClassB");
		this.classC = new UmlClass("ClassC");
		this.umlRelation1 = new UmlCompositionLink(classA, classB);
		this.umlRelation2 = new UmlAssociationLink(classA, classC);
		this.umlRelation3 = new UmlAggregationLink(classC, classB);
		this.umlRelation4 = new UmlExtendLink(classA, classA);
	}
	
	@Test
	public void testGetClassA()  {
		assertEquals(umlRelation1.getClassA(), classA);
		assertEquals(umlRelation2.getClassA(), classA);
		assertEquals(umlRelation3.getClassA(), classC);
		assertEquals(umlRelation4.getClassA(), classA);
	}
	
	@Test
	public void testGetClassB()  {
		assertEquals(umlRelation1.getClassB(), classB);
		assertEquals(umlRelation2.getClassB(), classC);
		assertEquals(umlRelation3.getClassB(), classB);
		assertEquals(umlRelation4.getClassB(), classA);
	}
	
	@Test
	public void testGetSetRoleA() {
		umlRelation1.setRoleA("personne");
		assertEquals("personne", umlRelation1.getRoleA());
		
		umlRelation2.setRoleA("entreprise");
		assertEquals("entreprise", umlRelation2.getRoleA());

		umlRelation3.setRoleA("ordinateur");
		assertEquals("ordinateur", umlRelation3.getRoleA());

		umlRelation4.setRoleA("voiture");
		assertEquals("voiture", umlRelation4.getRoleA());
	}
	
	@Test
	public void testGetSetRoleB() {
		umlRelation1.setRoleB("entreprise");
		assertEquals("entreprise", umlRelation1.getRoleB());
		
		umlRelation2.setRoleB("ordinateur");
		assertEquals("ordinateur", umlRelation2.getRoleB());

		umlRelation3.setRoleB("carteMere");
		assertEquals("carteMere", umlRelation3.getRoleB());

		umlRelation4.setRoleB("personne");
		assertEquals("personne", umlRelation4.getRoleB());

	}
	
	@Test
	public void testRelationName() {
		umlRelation1.setRelationName("appartient");
		assertEquals("appartient", umlRelation1.getRelationName());

		umlRelation2.setRelationName("possède");
		assertEquals("possède", umlRelation2.getRelationName());

		umlRelation3.setRelationName("travaille pour");
		assertEquals("travaille pour", umlRelation3.getRelationName());

		umlRelation4.setRelationName("contient");
		assertEquals("contient", umlRelation4.getRelationName());


	}

}
