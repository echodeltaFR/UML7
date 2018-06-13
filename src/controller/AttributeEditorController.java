package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

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
		
		int n = JOptionPane.showOptionDialog(null,
		"What do you want to edit?",
		"Edition choice",
		JOptionPane.YES_NO_CANCEL_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,
		options,
		options[2]);
		
		if (n == 0 /* name */) {
			String newName = JOptionPane.showInputDialog("What is the new method name?", modificationTarget.getName());
			if (newName != null) {
				modificationTarget.setName(newName);
			}
		} else if (n == 1 /* return type */) {
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
		} else if (n == 2 /* visibility */) {
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
				modificationTarget.setVisibility(v);
			}
		}
	}
	
}
