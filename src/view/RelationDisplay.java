package view;

import java.awt.Graphics;
import javax.swing.JPanel;

import model.UmlRelationShip;

public abstract class RelationDisplay extends JPanel {
	
	protected static final double HEIGHT_TRIANGLE = 5;
	protected static final double BASE_TRIANGLE = 20;
	
	private UmlRelationShip umlRelation;
	private Point elemA;
	private Point elemB;
	
	public RelationDisplay(UmlRelationShip umlRelation) {
		super();
		this.umlRelation = umlRelation;
		this.elemA = null;
		this.elemB = null;
	}
	
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public Point getElemA() {
		return elemA;
	}

	public void setElemA(Point elemA) {
		this.elemA = elemA;
	}

	public Point getElemB() {
		return elemB;
	}

	public void setElemB(Point elemB) {
		this.elemB = elemB;
	}
    
}
