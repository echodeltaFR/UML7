package view;

import java.awt.Graphics;

import model.UmlAssociationLink;

/**
 * Class that represents association relationship
 * @author Charly Courilleau
 *
 */
public class AssociationRelationDisplay extends RelationDisplay {

		/** Boolean that characterizes an unidirectional relationship **/
		private boolean unidirectional;
	
		/**
		 * Constructor
		 * @param umlRelation the association relationship
		 */
		public AssociationRelationDisplay(UmlAssociationLink umlRelation) {
			super(umlRelation);
			this.unidirectional = false;
		}
		
		/**
		 * Constructor with option (unidirectonal or not)
		 * @param umlRelation the association relationship
		 * @param unidirectional boolean that permits to know if the relationship is unidirectional
		 */
		public AssociationRelationDisplay(UmlAssociationLink umlRelation, boolean unidirectional) {
			super(umlRelation);
			this.unidirectional = unidirectional;
		}
		
	    @Override
	    public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
		    // Draw the line
		    g.drawLine(this.getStart().getX(), 
		    		this.getStart().getY(), 
		    		this.getEnd().getX(), 
		    		this.getEnd().getY());
		    
		    // Draw the arrow if unidirectional is enabled
		    if (this.unidirectional) {
			    g.drawLine(this.getEnd().getX(), 
			    		this.getEnd().getY(), 
			    		this.getEnd().getX()-10, 
			    		this.getEnd().getY()+5);
			    
			    g.drawLine(this.getEnd().getX(), 
			    		this.getEnd().getY(), 
			    		this.getEnd().getX()-10, 
			    		this.getEnd().getY()-5);
			    
		    }
	    }

}
