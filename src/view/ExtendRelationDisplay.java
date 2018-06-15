package view;

import java.awt.Graphics;
import java.awt.Point;

import model.UmlExtendLink;

/**
 * Class that represents extend relationship
 * @author Charly Courilleau
 *
 */
public class ExtendRelationDisplay extends RelationDisplay {
	
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = 2904404128088211416L;

	/**
	 * Constructor
	 * @param umlRelation the extend relationship
	 */
	public ExtendRelationDisplay(UmlExtendLink umlRelation, Point start, Point end) {
		super(umlRelation, start, end);
	}
	
    @Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		final int HEIGHT_TRIANGLE = 20;
		int xBWithoutArrow = (int)this.getEnd().getX() - HEIGHT_TRIANGLE;
	
		// Draw the vertical line
		g.drawLine(xBWithoutArrow, 
				(int)this.getEnd().getY() - 10, 
				xBWithoutArrow, 
				(int)this.getEnd().getY() + 10);
		
	    // Draw triangle's side
	    g.drawLine(xBWithoutArrow, 
	    		(int)this.getEnd().getY()-10, 
	    		(int)this.getEnd().getX(), 
	    		(int)this.getEnd().getY());
	    
	    g.drawLine(xBWithoutArrow, 
	    		(int)this.getEnd().getY()+10, 
	    		(int)this.getEnd().getX(), 
	    		(int)this.getEnd().getY());

		// Draw horizontal line from start point
	    g.drawLine((int)this.getStart().getX(), 
	    		(int)this.getStart().getY(), 
	    		xBWithoutArrow, 
	    		(int)this.getEnd().getY());
    }

}
