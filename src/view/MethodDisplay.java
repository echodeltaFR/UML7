package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import controller.MethodEditorController;
import model.Modifier;
import model.UmlMethod;
import model.UmlParams;
import model.Visibility;

/**
 * Display method into the GUI.
 * @author Christian, Charly, echodeltaFR
 * @version 1.2
 */
public class MethodDisplay extends JLabel implements Observer {

	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = 2430315020346922418L;

	/** Constructor.
	 * @param method The method to display
	 */
	public MethodDisplay(UmlMethod method) {
		super();
		if (method == null) throw new IllegalArgumentException("Method can't be null");
		this.setBackground(Uml7JFrame.objectBackgroundColor);
		method.addObserver(this);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MethodEditorController(method);
			}

		});
		updateLabel(method);

	}

	/**
     * Update the display of the method.
     * Call this method when you modify the method
     * and you want the display to be refreshed.
     */
	public void updateLabel(UmlMethod method) {
		StringBuilder str = new StringBuilder();

		if (method.getVisibility() == Visibility.PUBLIC) {
            str.append("+");
        } else if (method.getVisibility() == Visibility.PRIVATE) {
            str.append("-");
        } else if (method.getVisibility() == Visibility.PROTECTED) {
            str.append("#");
        } else if (method.getVisibility() == Visibility.PACKAGE) {
        	//DO NOTHING
        } else {
            str.append("Exception");
        }
		str.append(method.getName()+"(");
		if (!method.getParams().isEmpty()) {
			for (UmlParams attr : method.getParams()) {
				str.append(
						attr.getName() + ":" + 
						attr.getType().getTypeName() + " ; ");
			}
			
			// Remove the last ;
			String tmp = str.substring(0, str.length()-3);
			str.setLength(0);
			str.append(tmp);
		}
		
		str.append(") : ");
		
		if (method.getReturnType() == null) {
			str.append("void");
		} else {
			str.append(method.getReturnType().getTypeName());
		}
		
		if (!method.getModifiers().isEmpty()) {
			str.append(" { ");
			for (Modifier m : method.getModifiers()) {
				str.append(m.toString() + " ");
			}
			String tmp = str.substring(0,str.length()-1)+" }";
			str.setLength(0);
			str.append(tmp);
		}
		
		this.setText(str.toString());
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof UmlMethod) {
			this.updateLabel((UmlMethod)o);
		}
	}
	
}
