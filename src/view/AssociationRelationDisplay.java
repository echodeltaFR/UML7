package view;

import java.awt.Graphics;
import java.awt.Point;

import model.UmlAssociationLink;

/**
 * Class that represents association relationship
 * @author Charly Courilleau
 *
 */
public class AssociationRelationDisplay extends RelationDisplay {

	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = 2976428570302289024L;
	
		/** Boolean that characterizes an unidirectional relationship **/
		private boolean unidirectional;
	
		/**
		 * Constructor
		 * @param umlRelation the association relationship
		 * @param start the start point
		 * @param end the end point
		 */
		public AssociationRelationDisplay(UmlAssociationLink umlRelation, Point start, Point end) {
			super(umlRelation, start, end);
			this.unidirectional = false;
		}
		
		/**
		 * Constructor with option (unidirectonal or not)
		 * @param umlRelation the association relationship
		 * @param start the start point
		 * @param end the end point
		 * @param unidirectional boolean that permits to know if the relationship is unidirectional
		 */
		public AssociationRelationDisplay(UmlAssociationLink umlRelation, Point start, Point end, boolean unidirectional) {
			super(umlRelation, start, end);
			this.unidirectional = unidirectional;
		}
		
	    @Override
	    public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
		    // Draw the line
		    g.drawLine((int)this.getStart().getX(), 
		    		(int)this.getStart().getY(), 
		    		(int)this.getEnd().getX(), 
		    		(int)this.getEnd().getY());
		    
		    // Draw the arrow if unidirectional is enabled
		    if (this.unidirectional) {
			    g.drawLine((int)this.getEnd().getX(), 
			    		(int)this.getEnd().getY(), 
			    		(int)this.getEnd().getX()-10, 
			    		(int)this.getEnd().getY()+5);
			    
			    g.drawLine((int)this.getEnd().getX(), 
			    		(int)this.getEnd().getY(), 
			    		(int)this.getEnd().getX()-10, 
			    		(int)this.getEnd().getY()-5);
			    
		    }
	    }

}
