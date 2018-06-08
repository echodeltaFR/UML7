package model;

import java.util.ArrayList;
import java.util.List;

import generator.DiagramElementVisitor;

/**
 * Class which allow to create a diagram with element.
 * @author fmeslet
 * @version 1.0
 */
public class UmlDiagram {

	/** 
	 * Create a title.
	 */
	private String title;
	
	/**
	 * Element of the diagram.
	 */
	private List<UmlComponent> elements;
	
	/**
	 * Relation in the diagram.
	 */
	private List<UmlRelationship> relations;
	
	/**
	 * Build an uml diagram with relation.
	 * @param title title of diagram
	 * @param elements uml elements in the diagram
	 * @params relations uml relation in the diagram
	 */
	public UmlDiagram(String title, List<UmlComponent> elements, List<UmlRelationship> relations) {
		this.title = title;
		
		if(elements != null) {
			this.elements = new ArrayList<UmlComponent>(elements);
		}else {
			this.elements = new ArrayList<UmlComponent>();
		}
		
		if(relations != null) {
			this.relations = new ArrayList<UmlRelationship>(relations);
		} else {
			this.relations = new ArrayList<UmlRelationship>();
		}
	}
	
	/**
	 * Build an uml diagram with no relation.
	 * @param title title of diagram
	 * @param elements uml elements in the diagram
	 */
	public UmlDiagram(String title, List<UmlComponent> elements) {
		this.title = title;
		
		if(elements != null) {
			this.elements = new ArrayList<UmlComponent>(elements);
		}else {
			this.elements = new ArrayList<UmlComponent>();
		}
	}
	
	/**
	 * Build an uml diagram with only a title.
	 * @param title title of diagram
	 */
	public UmlDiagram(String title) {
		this.title = title;
		this.elements = new ArrayList<UmlComponent>(elements);
		this.relations = new ArrayList<UmlRelationship>(relations);
	}
	
	/**
	 * Build an uml diagram.
	 */
	public UmlDiagram() {
		this.title = null;
		this.elements = new ArrayList<UmlComponent>();
		this.relations = new ArrayList<UmlRelationship>();
		
	}
	
	/**
	 * Get the diagram title.
	 * @return diagram title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Set the diagram title.
	 * @param title diagram title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the Element of the diagram.
	 * @return the diagram elements
	 */
	public List<UmlComponent> getUmlElements() {
		return this.elements;
	}
	
	/**
	 * Add an Element in the diagram.
	 * @param element a diagram element
	 */
	public void addUmlElements(UmlComponent element) {
		this.elements.add(element);
	}
	
	/**
	 * Add a list of Element in the diagram.
	 * @param elements a list of diagram element
	 */
	public void addAllUmlElements(List<UmlComponent> elements) {
		this.elements.addAll(elements);
	}
	
	/**
	 * Get the diagram element.
	 * @return the diagram elements 
	 */
	public List<UmlRelationship> getUmlRelations() {
		return this.relations;
	}
	
	/**
	 * Add a diagram element.
	 * @params relation a relation
	 */
	public void addUmlRelations(UmlRelationship relation) {
		this.relations.add(relation);
	}
	
	/**
	 * Add a list of diagram element.
	 * @params relations a list of relation
	 */
	public void addAllUmlRelations(List<UmlRelationship> relations) {
		this.relations.addAll(relations);
	}
}
