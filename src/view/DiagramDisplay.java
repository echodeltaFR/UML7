package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.UmlDiagram;
import model.UmlRefType;

public class DiagramDisplay extends JScrollPane implements Observer{
	
	private JPanel classGrid;
	
	public DiagramDisplay(UmlDiagram diagram){
		super();
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		diagram.addObserver(this);
		classGrid = new JPanel(new FlowLayout());
		this.setViewportView(classGrid);
		this.update(diagram);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof UmlDiagram) {
			this.update((UmlDiagram) o);
		}
	}

	private void update(UmlDiagram o) {
		this.classGrid.removeAll();
		for (UmlRefType refType : o.getUmlElements()) {
			this.classGrid.add(new UMLObjectDisplay(refType));
		}
		this.revalidate();
	}

}
