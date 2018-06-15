package view;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import controller.AttributeEditorController;
import model.Modifier;
import model.UmlAttribute;

/**
 * Display attributes into the GUI.
 * @author echodeltaFR
 * @version 1.2
 */
public class AttributeDisplay extends JLabel implements Observer{

    /**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -6461229184000932823L;

	/**
     * Constructor.
     * @param attribute Attribute to display
     */
    public AttributeDisplay(UmlAttribute attribute) {
        super();
        attribute.addObserver(this);
        this.setBackground(Uml7JFrame.objectBackgroundColor);
        
        this.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		new AttributeEditorController(attribute);
        	}
        });
        
        updateLabel(attribute);
    }
    
    /**
     * Update the display of the attribute.
     * Call this method when you modify an attribute
     * and you want the display to refresh.
     */
    public void updateLabel(UmlAttribute attribute) {
        StringBuilder str = new StringBuilder();
        switch (attribute.getVisibility()) {
        case PUBLIC:
        	str.append("+");
        	break;
        case PRIVATE:
        	str.append("-");
        	break;
        case PROTECTED:
        	str.append("#");
        	break;
        case PACKAGE:
        	//Nothing to append
        	break;
        default:
        	str.append("Exception");
        }
        if (!attribute.getModifiers().isEmpty()) {
            for (Modifier m : attribute.getModifiers()) {
                str.append(m.toString() + " ");
            }
        }
        str.append(attribute.getName() + ": " + attribute.getType());
        this.setText(str.toString());
    }

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof UmlAttribute) {
			this.updateLabel((UmlAttribute)o);
		}
	}

}
