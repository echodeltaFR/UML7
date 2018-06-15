package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.UmlDiagram;
import model.UmlRefType;

/**
 * This class allow to display an UML Diagram and automatically keep up to date.<br>
 * While this class extends JScrollPane, it is discouraged to use inherited methods.
 */
public class DiagramDisplay extends JScrollPane implements Observer{
	
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -5448058609418336096L;
	
	/**
	 * Where the reference type displays are stored.
	 */
	private JPanel refTypeDisplayZone;
	
	/** 
	 * Create a view on the given diagram.
	 * @param diagram
	 * 		The diagram to display.
	 */
	public DiagramDisplay(UmlDiagram diagram){
		super();
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		diagram.addObserver(this);
		refTypeDisplayZone = new JPanel(new FlowLayout());
		this.setViewportView(refTypeDisplayZone);
		this.update(diagram);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof UmlDiagram) {
			this.update((UmlDiagram) o);
		}
	}

	private void update(UmlDiagram o) {
		this.refTypeDisplayZone.removeAll();
		for (UmlRefType refType : o.getUmlElements()) {
			this.refTypeDisplayZone.add(buildClassDisplayWrapper(refType, o));
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
