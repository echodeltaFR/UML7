package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import model.UmlCompositionLink;

/**
 * Class that represents composition relationship
 * @author Charly Courilleau
 *
 */
public class CompositionRelationDisplay extends RelationDisplay {

	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -4996019196669586384L;

		/**
		 * Constructor
		 * @param umlRelation the composition relationship
		 * @param start the start point
		 * @param end the end point
		 */
		public CompositionRelationDisplay(UmlCompositionLink umlRelation, Point start, Point end) {
			super(umlRelation, start, end);
		}
		
	    @Override
	    public void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Extremité gauche (losange)
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
		    g.setColor(Color.black);
		    g.fillPolygon(losange);

			// Draw the line
		    g.drawLine((int)this.getStart().getX(), (int)this.getStart().getY(), (int)this.getEnd().getX(), (int)this.getEnd().getY());

		    // Draw the arrow
		    g.drawLine((int)this.getEnd().getX(), (int)this.getEnd().getY(), (int)this.getEnd().getX()-10, (int)this.getEnd().getY()+5);
		    g.drawLine((int)this.getEnd().getX(), (int)this.getEnd().getY(), (int)this.getEnd().getX()-10, (int)this.getEnd().getY()-5);

	    }

}
