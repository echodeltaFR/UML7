package model;

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
	 * Build an uml diagram.
	 * @param title
	 * @param elements
	 */
	public UmlDiagram(String title, List<UmlComponent> elements) {
		this.title = title;
		this.elements = elements;
	}
	
	/**
	 * Build an uml diagram.
	 * @param title diagram title
	 */
	public UmlDiagram(String title) {
		this.title = title;
	}

	/**
	 * Get the Element of the diagram.
	 * @return the diagram elements 
	 */
	public List<UmlComponent> getUmlElements() {
		return this.elements;
	}
}
