package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import model.UmlMethod;

public class MethodEditorControler extends MouseAdapter{

	private UmlMethod modificationTarget;
	
	public MethodEditorControler(UmlMethod modificationTarget) {
		if (modificationTarget == null) {
			throw new IllegalArgumentException("Modification target can't be null");
		}
		this.modificationTarget = modificationTarget;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		String newName = JOptionPane.showInputDialog("What is the new method name?", modificationTarget.getName());
		if (newName != null) {
			modificationTarget.setName(newName);
		}
	}
	
}
