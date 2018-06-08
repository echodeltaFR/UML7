package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import model.UmlComponent;

public class ClassEditorController extends MouseAdapter {

	private UmlComponent modificationTarget;
	
	public ClassEditorController(UmlComponent modificationTarget) {
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
