package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

import model.UmlRelationship;

/**
 * Abstract class that represents a relationship
 * @author Charly Courilleau 
 *
 */
public abstract class RelationDisplay extends JPanel {
	
	protected static final double HEIGHT_TRIANGLE = 10;
	protected static final double BASE_TRIANGLE = 12;
	
	/** Relationship **/
	private UmlRelationship umlRelation;
	
	/** Start point **/
	private Point start;
	
	/** End point **/
	private Point end;
	
	
	/**
	 * Constructor
	 * @param umlRelation relationship to display
	 * @param startPoint the start point
	 * @param endPoint the end point
	 */
	public RelationDisplay(UmlRelationship umlRelation, Point startPoint, Point endPoint) {
		super();
		assert umlRelation != null;
		this.umlRelation = umlRelation;
		this.start = new Point(0,0);
		this.end = new Point(0,0);
		this.setBackground(Color.WHITE);
		this.addComponentListener(new ComponentListener() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				start.setLocation(0, arg0.getComponent().getHeight()/2);
				end.setLocation(arg0.getComponent().getWidth(),  arg0.getComponent().getHeight()/2);

			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				start.setLocation(0, arg0.getComponent().getHeight()/2);
				end.setLocation(arg0.getComponent().getWidth(),  arg0.getComponent().getHeight()/2);
			}
			
		});
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
