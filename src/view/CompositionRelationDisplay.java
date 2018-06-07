package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import model.UmlCompositionLink;

/**
 * Class that represents composition relationship
 * @author Charly Courilleau
 *
 */
public class CompositionRelationDisplay extends RelationDisplay {

		/**
		 * Constructor
		 * @param umlRelation the composition relationship
		 */
		public CompositionRelationDisplay(UmlCompositionLink umlRelation) {
			super(umlRelation);
		}
		
	    @Override
	    public void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Extremité gauche (losange)
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
		    g.setColor(Color.black);
		    g.fillPolygon(losange);

			// Draw the line
		    g.drawLine(this.getStart().getX(), this.getStart().getY(), this.getEnd().getX(), this.getEnd().getY());

		    // Draw the arrow
		    g.drawLine(this.getEnd().getX(), this.getEnd().getY(), this.getEnd().getX()-10, this.getEnd().getY()+5);
		    g.drawLine(this.getEnd().getX(), this.getEnd().getY(), this.getEnd().getX()-10, this.getEnd().getY()-5);

	    }

}
