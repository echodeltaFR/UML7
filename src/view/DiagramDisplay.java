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

	/**
	 * Private method to update rebuild the view to show the given diagram.
	 * @param diagram
	 * 		The diagram to display.
	 */
	private void update(UmlDiagram diagram) {
		this.refTypeDisplayZone.removeAll();
		for (UmlRefType refType : diagram.getUmlElements()) {
			this.refTypeDisplayZone.add(buildClassDisplayWrapper(refType, diagram));
		}
		this.repaint();
		this.revalidate();
	}
	
	/**
	 * Build a wrapper JPanel for the given UmlRefType to allow deletion.<br>
	 * The function will create a UMLObjectDisplay to display the reference type
	 * and then wrap it in another JPanel that contains a deletion button.
	 * @param refType
	 * 		The reference type to display.
	 * @param d
	 * 		The diagram to call when deleting.
	 * @return
	 * 		The whole display of the refType with deletion option.
	 */
	private JPanel buildClassDisplayWrapper(UmlRefType refType, UmlDiagram d) {
		JPanel wrapper = new JPanel(new BorderLayout());
		JPanel wrapperNorth = new JPanel(new BorderLayout());
		wrapper.add(wrapperNorth,BorderLayout.NORTH);
		JButton del = new JButton(" - ");
		del.setBorder(Uml7JFrame.deleteButtonBorder);
		
		del.addActionListener(e -> {
			d.removeUmlElement(refType);
		});
		
		wrapperNorth.add(del,BorderLayout.WEST);
		wrapper.add(new UMLObjectDisplay(refType),BorderLayout.CENTER);
		return wrapper;
	}

}
