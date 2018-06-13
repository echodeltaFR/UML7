package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import exception.ExceptionComposition;
import exception.ExceptionInitialization;
import model.UmlAttributeTest;
import model.UmlMethod;
import model.Visibility;
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
		
		boolean done = (userChoice == 3); /* not canceled*/
		while (!done) {
			if (userChoice == 0 /* name */) {
				String newName = JOptionPane.showInputDialog("What is the new method name?", modificationTarget.getName());
				if (newName != null) {
					modificationTarget.setName(newName);
					done = true;
				} else {
					done = true;
				}
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
					done = true;
				} else {
					done = true;
				}
			} else if (userChoice == 2 /* visibility */) {
				Object[] possibilities = Visibility.values();
				Visibility v = (Visibility)JOptionPane.showInputDialog(
				                    null,
				                    "Choose a visibility",
				                    "Visibility choosing",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    possibilities,
				                    Visibility.PUBLIC);
				if (v != null) {
					try {
						modificationTarget.setVisibility(v);
						done = true;
					} catch (ExceptionComposition ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					done = true;
				}
			}
		}
	}
	
}
