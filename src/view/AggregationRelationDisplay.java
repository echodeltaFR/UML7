package view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import model.UmlAggregationLink;

/**
 * Class that represents aggregation relationship
 * @author Charly Courilleau
 *
 */
public class AggregationRelationDisplay extends RelationDisplay {
	
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = 1215201257922820791L;

	/**
	 * Constructor
	 * @param umlRelation the aggregation relationship
	 */
	public AggregationRelationDisplay(UmlAggregationLink umlRelation, Point start, Point end) {
		super(umlRelation, start, end);
	}
	
    @Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);


		// Left extremity
        int[] xPoly = {(int)this.getStart().getX(),
        				(int) (this.getStart().getX() + HEIGHT_TRIANGLE),
        				(int)(this.getStart().getX() + (2*HEIGHT_TRIANGLE)), 
        				(int) (this.getStart().getX() + HEIGHT_TRIANGLE),
        				(int)this.getStart().getX()
        };
        int[] yPoly = {(int)this.getStart().getY(),
        				(int) (this.getStart().getY() + (BASE_TRIANGLE/2)),		
        				(int)this.getStart().getY(), 
        				(int) (this.getStart().getY() - (BASE_TRIANGLE/2)), 
        				(int)this.getStart().getY()
        };
        
	    Polygon losange = new Polygon(xPoly, yPoly, xPoly.length);
	    g.drawPolygon(losange);
	    
		// Draw the line
	    if (this.getEnd().getX() < this.getStart().getX()) {
	    	g.drawLine((int)this.getStart().getX(), (int)this.getStart().getY(), (int)this.getEnd().getX(), (int)this.getEnd().getY());
		    // Draw the arrow	    
		    g.drawLine((int)this.getEnd().getX(), (int)this.getEnd().getY(), (int)this.getEnd().getX()+10, (int)this.getEnd().getY()+5);
		    g.drawLine((int)this.getEnd().getX(), (int)this.getEnd().getY(), (int)this.getEnd().getX()+10, (int)this.getEnd().getY()-5);
	    } else {
	    	g.drawLine((int)(this.getStart().getX()+(HEIGHT_TRIANGLE*2)), (int)this.getStart().getY(), (int)this.getEnd().getX(), (int)this.getEnd().getY());
		    // Draw the arrow	    
		    g.drawLine((int)this.getEnd().getX(), (int)this.getEnd().getY(), (int)this.getEnd().getX()-10, (int)this.getEnd().getY()+5);
		    g.drawLine((int)this.getEnd().getX(), (int)this.getEnd().getY(), (int)this.getEnd().getX()-10, (int)this.getEnd().getY()-5);

	    }

    }

}
