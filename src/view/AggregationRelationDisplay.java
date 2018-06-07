package view;

import java.awt.Graphics;
import java.awt.Polygon;

import model.UmlAggregationLink;

/**
 * Class that represents aggregation relationship
 * @author Charly Courilleau
 *
 */
public class AggregationRelationDisplay extends RelationDisplay {
	
	/**
	 * Constructor
	 * @param umlRelation the aggregation relationship
	 */
	public AggregationRelationDisplay(UmlAggregationLink umlRelation) {
		super(umlRelation);
	}
	
    @Override
    public void paintComponent(Graphics g) {
		assert g != null;
		assert this.getStart() != null;
		assert this.getEnd() != null;

		super.paintComponent(g);


		// Left extremity
        int xPoly[] = {this.getStart().getX(),
        				(int) (this.getStart().getX() + HEIGHT_TRIANGLE),
        				(int)(this.getStart().getX() + (2*HEIGHT_TRIANGLE)), 
        				(int) (this.getStart().getX() + HEIGHT_TRIANGLE),
        				this.getStart().getX()
        };
        int yPoly[] = {this.getStart().getY(),
        				(int) (this.getStart().getY() + (BASE_TRIANGLE/2)),		
        				this.getStart().getY(), 
        				(int) (this.getStart().getY() - (BASE_TRIANGLE/2)), 
        				this.getStart().getY()
        };
        
	    Polygon losange = new Polygon(xPoly, yPoly, xPoly.length);
	    g.drawPolygon(losange);
	    
		// Draw the line
	    if (this.getEnd().getX() < this.getStart().getX()) {
	    	g.drawLine(this.getStart().getX(), this.getStart().getY(), this.getEnd().getX(), this.getEnd().getY());
		    // Draw the arrow	    
		    g.drawLine(this.getEnd().getX(), this.getEnd().getY(), this.getEnd().getX()+10, this.getEnd().getY()+5);
		    g.drawLine(this.getEnd().getX(), this.getEnd().getY(), this.getEnd().getX()+10, this.getEnd().getY()-5);
	    } else {
	    	g.drawLine((int)(this.getStart().getX()+(HEIGHT_TRIANGLE*2)), this.getStart().getY(), this.getEnd().getX(), this.getEnd().getY());
		    // Draw the arrow	    
		    g.drawLine(this.getEnd().getX(), this.getEnd().getY(), this.getEnd().getX()-10, this.getEnd().getY()+5);
		    g.drawLine(this.getEnd().getX(), this.getEnd().getY(), this.getEnd().getX()-10, this.getEnd().getY()-5);

	    }

    }

}
