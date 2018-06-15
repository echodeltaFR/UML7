package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;


/**
 * Class which allow to create a diagram with element and relations.
 * @author fmeslet
 * @see UmlRefType
 * @see UmlRelationship
 * @version 1.0
 */
public class UmlDiagram extends Observable implements Serializable{

	/**
	 * generated serial ID
	 */
	private static final long serialVersionUID = -3323312232281185348L;

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
		this(title,elements,null);
	}
	
	/**
	 * Build an UML diagram with only a title.
	 * @param title Title of the diagram
	 */
	public UmlDiagram(String title) {
		this(title,null,null);
	}
	
	/**
	 * Build an UML diagram.
	 */
	public UmlDiagram() {
		this.title = "Diagram";
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
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Get the elements of the diagram.
	 * This returns an unmodifiable view of this object list.
	 * @return The diagram's elements
	 */
	public List<UmlRefType> getUmlElements() {
		return Collections.unmodifiableList(this.elements);
	}
	
	/**
	 * Add an Element in the diagram.
	 * @param element An element to add in the diagram
	 */
	public void addUmlElements(UmlRefType element) {
		if (this.elements.add(element)) {
			this.setChanged();
			this.notifyObservers();
		};
	}
	
	/**
	 * Add a list of Element in the diagram.
	 * @param elements A list of diagram elements to add
	 */
	public void addAllUmlElements(List<UmlRefType> elements) {
		if (this.elements.addAll(elements)) {
			this.setChanged();
			this.notifyObservers();
		};
	}
	
	/**
	 * Get the diagram element.
	 * This returns an unmodifiable view of this object list.
	 * @return The diagram elements 
	 */
	public List<UmlRelationship> getUmlRelations() {
		return Collections.unmodifiableList(this.relations);
	}
	
	/**
	 * Add a diagram element.
	 * @param relation A relation to add
	 */
	public void addUmlRelations(UmlRelationship relation) {
		if (this.relations.add(relation)) {
			this.setChanged();
			this.notifyObservers();
		};
	}
	
	/**
	 * Add a list of diagram elements.
	 * @param relations A list of relations to add
	 */
	public void addAllUmlRelations(List<UmlRelationship> relations) {
		if (this.relations.addAll(relations)) {
			this.setChanged();
			this.notifyObservers();
		};
	}
	
	/**
	 * Check if this object is equal to another.
	 * @return true if o is an UmlDiagram with the same relations and elements, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof UmlDiagram) {
			UmlDiagram u = (UmlDiagram) o;
			if (
					u.elements.equals(this.elements) &&
					u.relations.equals(this.relations)
					) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Remove an UML reference type from the diagram.
	 * @param reftype
	 * 		The type to remove
	 */
	public void removeUmlElement(UmlRefType reftype) {
		if (this.elements.remove(reftype)) {
			this.setChanged();
			this.notifyObservers();
		};
	}
}
