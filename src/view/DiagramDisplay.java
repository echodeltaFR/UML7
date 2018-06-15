package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.UmlDiagram;
import model.UmlRefType;

public class DiagramDisplay extends JScrollPane implements Observer{
	
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -5448058609418336096L;
	
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
	
	public void setDisplayedDiagram(UmlDiagram diagram) {
		diagram.addObserver(this);
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
			this.classGrid.add(buildClassDisplayWrapper(refType, o));
		}
		this.repaint();
		this.revalidate();
	}
	
	private JPanel buildClassDisplayWrapper(UmlRefType rt, UmlDiagram d) {
		JPanel wrapper = new JPanel(new BorderLayout());
		JPanel wrapperNorth = new JPanel(new BorderLayout());
		wrapper.add(wrapperNorth,BorderLayout.NORTH);
		JButton del = new JButton(" - ");
		del.setBorder(Uml7JFrame.deleteButtonBorder);
		
		del.addActionListener(e -> {
			d.removeUmlElement(rt);
		});
		
		wrapperNorth.add(del,BorderLayout.WEST);
		wrapper.add(new UMLObjectDisplay(rt),BorderLayout.CENTER);
		return wrapper;
	}

}
