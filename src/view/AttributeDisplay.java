package view;
import javax.swing.JLabel;

import model.Modifier;
import model.UmlAttribute;

/**
 * Display attributes into the GUI.
 * @author echodeltaFR
 * @version 1.2
 */
@SuppressWarnings("serial")
public class AttributeDisplay extends JLabel {

    /** Attribute to display. */
    private UmlAttribute attribute;

    /**
     * Constructor.
     * @param attribute Attribute to display
     */
    public AttributeDisplay(UmlAttribute attribute) {
        super();
        this.attribute = attribute;
        updateLabel();
    }

    /**
     * Gets the represented attribute
     * @return the attribute that is displayed
     */
    public UmlAttribute getAttribute() {
    	return this.attribute;
    }
    
    /**
     * Update the display of the attribute.
     * Call this method when you modify an attribute
     * and you want the display to refresh.
     */
    public void updateLabel() {
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

}
