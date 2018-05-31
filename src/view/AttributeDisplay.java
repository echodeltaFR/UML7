package view;
import javax.swing.JLabel;

import model.Modifier;
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
     * Update the display of the attribute.
     * Call this method when you modify an attribute
     * and you want the display to refresh.
     */
    public void updateLabel() {
    	String str = attribute.getVisibility()+attribute.getName() + ": " + attribute.getType();
        if (attribute.getModifier().size()!=0) {
        	str+=" {";
        	for (Modifier m : attribute.getModifier()) {
        		str+=m.toString()+",";
        	}
        	str=str.substring(0,str.length()-1)+"}";
        }
    	this.setText(str);
    }

}
