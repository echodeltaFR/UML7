package view;

import javax.swing.JLabel;

import model.Modifier;
import model.UmlMethod;
import model.UmlParams;

/**
 * Display method into the GUI.
 * @author Christian, Charly, echodeltaFR
 * @version 1.2
 */
public class MethodDisplay extends JLabel {

	/** Method to display. */
	private UmlMethod method;

	/** Constructor.
	 * @param method The method to display
	 */
	public MethodDisplay(UmlMethod method) {
		super();
		if (method == null) throw new IllegalArgumentException("Method can't be null");
		this.method = method;
		updateLabel();
	}

	/**
	 * Get the represented method.
	 * @return the method that is displayed
	 */
	public UmlMethod getMethod() {
		return this.method;
	}

	/**
     * Update the display of the method.
     * Call this method when you modify the method
     * and you want the display to be refreshed.
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
		str.append(method.getName()+"(");
		if (!method.getParams().isEmpty()) {
			for (UmlParams attr : method.getParams()) {
				str.append(
						attr.getName() + ":" + 
						attr.getType().getTypeName() + ",");
			}

			String tmp = str.substring(0, str.length()-1);
			str.setLength(0);
			str.append(tmp);
		}
		
		str.append(") : ");
		
		if (method.getReturnType() == null) {
			str.append("void");
		} else {
			str.append(method.getReturnType().getTypeName());
		}
		
		if (!method.getModifier().isEmpty()) {
			str.append(" {");
			for (Modifier m : method.getModifier()) {
				str.append(m.toString() + ",");
			}
			String tmp = str.substring(0,str.length()-1)+"}";
			str.setLength(0);
			str.append(tmp);
		}
		
		this.setText(str.toString());
	}
	
}
