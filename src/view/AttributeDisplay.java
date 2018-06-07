package view;
import javax.swing.JLabel;

import model.Modifier;
import model.UmlAttribute;
import model.Visibility;

/**
 * Diplay attributes into the GUI.
 * @author echodeltaFR
 * @version 1.1
 */
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
        if (attribute.getVisibility() == Visibility.PUBLIC) {
            str.append("+");
        } else if (attribute.getVisibility() == Visibility.PRIVATE) {
            str.append("-");
        } else if (attribute.getVisibility() == Visibility.PROTECTED) {
            str.append("#");
        } else {
            str.append("Exception");
        }
        if (!attribute.getModifier().isEmpty()) {
            for (Modifier m : attribute.getModifier()) {
                str.append(m.toString() + " ");
            }
        }
        str.append(attribute.getName() + ": " + attribute.getType());
        this.setText(str.toString());
    }

}
