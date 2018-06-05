package view;

import java.awt.Graphics;

import model.UmlExtendsLink;

public class ExtendsRelationDisplay extends RelationDisplay {

	public ExtendsRelationDisplay(UmlExtendsLink umlRelation) {
		super(umlRelation);
	}
	
    @Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		final int HEIGHT_TRIANGLE = 20;
		int xBWithoutArrow = this.getElemB().getX() - HEIGHT_TRIANGLE;
	
		// Draw the vertical line
		g.drawLine(xBWithoutArrow, 
				this.getElemB().getY() - 10, 
				xBWithoutArrow, 
				this.getElemB().getY() + 10);
		
	    // Draw triangle's side
	    g.drawLine(xBWithoutArrow, 
	    		this.getElemB().getY()-10, 
	    		this.getElemB().getX(), 
	    		this.getElemB().getY());
	    
	    g.drawLine(xBWithoutArrow, 
	    		this.getElemB().getY()+10, 
	    		this.getElemB().getX(), 
	    		this.getElemB().getY());

		// Draw horizontal line from start point
	    g.drawLine(this.getElemA().getX(), 
	    		this.getElemA().getY(), 
	    		this.getElemA().getX(), 
	    		this.getElemA().getY());

	    
	    
		/** Right point
	    int xFinal = this.getxRelation()+200;
	    int yFinal = this.getyRelation();
	    
	    final int HEIGHT_TRIANGLE = 20;
	    xFinal -= HEIGHT_TRIANGLE;
	    
	    // Draw vertical line
	    g.drawLine(xFinal, yFinal-10, xFinal, yFinal+10);

	    // Draw triangle's side
	    g.drawLine(xFinal, yFinal-10, xFinal+HEIGHT_TRIANGLE, yFinal);
	    g.drawLine(xFinal, yFinal+10, xFinal+HEIGHT_TRIANGLE, yFinal);

		// Draw horizontal line from start point
	    g.drawLine(this.getxRelation(), this.getyRelation(), xFinal, yFinal);
	    **/

    }

}
