package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import model.UmlAttributeTest;
import model.UmlMethod;
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
		String newName = JOptionPane.showInputDialog("What is the new method name?", modificationTarget.getName());
		if (newName != null) {
			modificationTarget.setName(newName);
		}
	}
	
}
