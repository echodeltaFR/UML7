package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import model.UmlRefType;

/**
 * This class implements MouseAdapter to control the edition of an UmlClass when the mouse
 * is clicked.
 */
public class ClassEditorController extends MouseAdapter {

	/**
	 * The class to modify
	 */
	private UmlRefType modificationTarget;
	
	/**
	 * Create a new controller that will modify the given class.
	 * @param modificationTarget
	 * 		The class to control the modification for
	 */
	public ClassEditorController(UmlRefType modificationTarget) {
		if (modificationTarget == null) {
			throw new IllegalArgumentException("Modification target can't be null");
		}
		this.modificationTarget = modificationTarget;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		String newName = JOptionPane.showInputDialog("What is the new component name?", modificationTarget.getName());
		if (newName != null) {
			modificationTarget.setName(newName);
		}
	}
	
}
