package view;

import java.awt.Graphics;

import model.UmlExtendLink;

/**
 * Class that represents extend relationship
 * @author Charly Courilleau
 *
 */
public class ExtendRelationDisplay extends RelationDisplay {
	
	/**
	 * Constructor
	 * @param umlRelation the extend relationship
	 */
	public ExtendRelationDisplay(UmlExtendLink umlRelation) {
		super(umlRelation);
	}
	
    @Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		final int HEIGHT_TRIANGLE = 20;
		int xBWithoutArrow = this.getEnd().getX() - HEIGHT_TRIANGLE;
	
		// Draw the vertical line
		g.drawLine(xBWithoutArrow, 
				this.getEnd().getY() - 10, 
				xBWithoutArrow, 
				this.getEnd().getY() + 10);
		
	    // Draw triangle's side
	    g.drawLine(xBWithoutArrow, 
	    		this.getEnd().getY()-10, 
	    		this.getEnd().getX(), 
	    		this.getEnd().getY());
	    
	    g.drawLine(xBWithoutArrow, 
	    		this.getEnd().getY()+10, 
	    		this.getEnd().getX(), 
	    		this.getEnd().getY());

		// Draw horizontal line from start point
	    g.drawLine(this.getStart().getX(), 
	    		this.getStart().getY(), 
	    		this.getStart().getX(), 
	    		this.getStart().getY());
    }

}
