package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import model.PrimitiveType;
import model.UmlAttribute;

public class AttributeEditorController extends MouseAdapter{

	private UmlAttribute modificationTarget;
	
	public AttributeEditorController(UmlAttribute modificationTarget) {
		if (modificationTarget == null) {
			throw new IllegalArgumentException("Modification target can't be null");
		}
		this.modificationTarget = modificationTarget;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		/*
		 * MODIFICATION CHOICE : 
		 * 0 - NAME
		 * 1 - TYPE
		 * 2 - VISIBILITY
		 * 3 - CANCEL
		 */
		Object[] options = {"Edit name",
                "Edit type",
                "Edit visibility",
                "Cancel"};
		
		int userChoice = JOptionPane.showOptionDialog(null,
		"What do you want to edit?",
		"Edition choice",
		JOptionPane.YES_NO_CANCEL_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,
		options,
		options[2]);
		
		if (userChoice == 0 /* name */) {
			UmlEntityControlUnit.askAndChangeName(modificationTarget);
		} else if (userChoice == 1 /* return type */) {
			Object[] possibilities = PrimitiveType.values();
			PrimitiveType pt = (PrimitiveType)JOptionPane.showInputDialog(
			                    null,
			                    "Choose a primitive type",
			                    "Type choosing",
			                    JOptionPane.PLAIN_MESSAGE,
			                    null,
			                    possibilities,
			                    PrimitiveType.INT);
			if (pt != null) {
				modificationTarget.setType(pt);
			}
		} else if (userChoice == 2 /* visibility */) {
			UmlEntityControlUnit.askAndChangeVisibility(modificationTarget);
		}
	}
	
}
