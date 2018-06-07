package view;
import javax.swing.JLabel;
import model.UmlAttribute;

/**
 * Diplay attributes into the GUI.
 * @author echodeltaFR
 * @version 1.0
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
     * Get the represented attribute
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
        this.setText(attribute.getName() + ": " + attribute.getType());
    }

}
