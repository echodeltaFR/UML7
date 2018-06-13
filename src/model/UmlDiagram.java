package model;

import java.util.ArrayList;
import java.util.List;


/**
 * Class which allow to create a diagram with element.
 * @author fmeslet
 * @version 1.0
 */
public class UmlDiagram {

	/** Title of the UmlDiagram. */
	private String title;
	
	/** Elements of the diagram. */
	private List<UmlRefType> elements;
	
	/** Relations in the diagram. */
	private List<UmlRelationship> relations;
	
	/**
	 * Build an UML diagram with relations.
	 * @param title Title of the diagram
	 * @param elements UML elements in the diagram
	 * @params relations UML relation in the diagram
	 */
	public UmlDiagram(String title, List<UmlRefType> elements, List<UmlRelationship> relations) {
		this.title = title;
		
		if(elements != null) {
			this.elements = new ArrayList<>(elements);
		}else {
			this.elements = new ArrayList<>();
		}
		
		if(relations != null) {
			this.relations = new ArrayList<>(relations);
		} else {
			this.relations = new ArrayList<>();
		}
	}
	
	/**
	 * Build an UML diagram with no relation.
	 * @param title Title of diagram
	 * @param elements UML elements in the diagram
	 */
	public UmlDiagram(String title, List<UmlRefType> elements) {
		this.title = title;
		
		if(elements != null) {
			this.elements = new ArrayList<>(elements);
		}else {
			this.elements = new ArrayList<>();
		}
	}
	
	/**
	 * Build an UML diagram with only a title.
	 * @param title Title of the diagram
	 */
	public UmlDiagram(String title) {
		this.title = title;
		this.elements = new ArrayList<>(elements);
		this.relations = new ArrayList<>(relations);
	}
	
	/**
	 * Build an UML diagram.
	 */
	public UmlDiagram() {
		this.title = null;
		this.elements = new ArrayList<>();
		this.relations = new ArrayList<>();
		
	}
	
	/**
	 * Get the diagram title.
	 * @return Title of the diagram
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Set the diagram title.
	 * @param Title of the diagram
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the elements of the diagram.
	 * @return The diagram's elements
	 */
	public List<UmlRefType> getUmlElements() {
		return this.elements;
	}
	
	/**
	 * Add an Element in the diagram.
	 * @param element An element to add in the diagram
	 */
	public void addUmlElements(UmlRefType element) {
		this.elements.add(element);
	}
	
	/**
	 * Add a list of Element in the diagram.
	 * @param elements A list of diagram elements to add
	 */
	public void addAllUmlElements(List<UmlRefType> elements) {
		this.elements.addAll(elements);
	}
	
	/**
	 * Get the diagram element.
	 * @return The diagram elements 
	 */
	public List<UmlRelationship> getUmlRelations() {
		return this.relations;
	}
	
	/**
	 * Add a diagram element.
	 * @param relation A relation to add
	 */
	public void addUmlRelations(UmlRelationship relation) {
		this.relations.add(relation);
	}
	
	/**
	 * Add a list of diagram elements.
	 * @param relations A list of relations to add
	 */
	public void addAllUmlRelations(List<UmlRelationship> relations) {
		this.relations.addAll(relations);
	}
	
	//Mettre les remove
}
