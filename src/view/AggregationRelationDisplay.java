package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import model.UmlAggregationLink;

public class AggregationRelationDisplay extends RelationDisplay {

	public AggregationRelationDisplay(UmlAggregationLink umlRelation) {
		super(umlRelation);
	}
	
    @Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);


		// Extremité gauche (losange)
        int xPoly[] = {this.getElemA().getX(),
        				(int) (this.getElemA().getX() + HEIGHT_TRIANGLE),
        				(int)(this.getElemA().getX() + (2*HEIGHT_TRIANGLE)), 
        				(int) (this.getElemA().getX() + HEIGHT_TRIANGLE),
        				this.getElemA().getX()
        };
        int yPoly[] = {this.getElemA().getY(),
        				(int) (this.getElemA().getY() + (BASE_TRIANGLE/2)),		
        				this.getElemA().getY(), 
        				(int) (this.getElemA().getY() - (BASE_TRIANGLE/2)), 
        				this.getElemA().getY()
        };
        
	    Polygon losange = new Polygon(xPoly, yPoly, xPoly.length);
	    g.drawPolygon(losange);
	    
		// Draw the line
	    g.drawLine((int)(this.getElemA().getX()+(HEIGHT_TRIANGLE*2)), this.getElemA().getY(), this.getElemB().getX(), this.getElemB().getY());

	    // Draw the arrow	    
	    g.drawLine(this.getElemB().getX(), this.getElemB().getY(), this.getElemB().getX()-10, this.getElemB().getY()+5);
	    g.drawLine(this.getElemB().getX(), this.getElemB().getY(), this.getElemB().getX()-10, this.getElemB().getY()-5);

    }

}
