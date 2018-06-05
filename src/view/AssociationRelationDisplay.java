package view;

import java.awt.Graphics;

import model.UmlAssociationLink;

public class AssociationRelationDisplay extends RelationDisplay {

		/** Arrow or not **/
		private boolean unidirectional;
	
		public AssociationRelationDisplay(UmlAssociationLink umlRelation) {
			super(umlRelation);
			this.unidirectional = false;
		}
		
		public AssociationRelationDisplay(UmlAssociationLink umlRelation, boolean unidirectional) {
			super(umlRelation);
			this.unidirectional = unidirectional;
		}
		
	    @Override
	    public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
		    // Draw the line
		    g.drawLine(this.getElemA().getX(), 
		    		this.getElemA().getY(), 
		    		this.getElemB().getX(), 
		    		this.getElemB().getY());
		    
		    // Draw the arrow if unidirectional is enabled
		    if (this.unidirectional) {
			    g.drawLine(this.getElemB().getX(), 
			    		this.getElemB().getY(), 
			    		this.getElemB().getX()-10, 
			    		this.getElemB().getY()+5);
			    
			    g.drawLine(this.getElemB().getX(), 
			    		this.getElemB().getY(), 
			    		this.getElemB().getX()-10, 
			    		this.getElemB().getY()-5);
			    
		    }
	    }

}
