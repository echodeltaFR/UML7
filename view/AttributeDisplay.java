package model;
import javax.swing.JLabel;

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

    public void updateLabel() {
        System.out.print(attribute.getName() + ": " + attribute.getType());
    }

}
