package view;

import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import model.UmlRelationShip;

/**
 * Abstract class that represents a relationship
 * @author Charly Courilleau 
 *
 */
public abstract class RelationDisplay extends JPanel {
	
	protected static final double HEIGHT_TRIANGLE = 5;
	protected static final double BASE_TRIANGLE = 20;
	
	/** Relationship **/
	private UmlRelationShip umlRelation;
	
	/** Start point **/
	private Point start;
	
	/** End point **/
	private Point end;
	
	
	/**
	 * Constructor
	 * @param umlRelation relationship to display
	 */
	public RelationDisplay(UmlRelationShip umlRelation) {
		super();
		assert umlRelation != null;
		this.umlRelation = umlRelation;
		this.start = null;
		this.end = null;
	}
	
	@Override
    public void paintComponent(Graphics g) {
		assert g != null;
		assert start != null;
		assert end != null;
		super.paintComponent(g);
	}
	
	/**
	 * Get start point
	 * @return the start point
	 */
	public Point getStart() {
		return start;
	}

	/** 
	 * Get end point
	 * @return the end point
	 */
	public Point getEnd() {
		return end;
	}

    
}
